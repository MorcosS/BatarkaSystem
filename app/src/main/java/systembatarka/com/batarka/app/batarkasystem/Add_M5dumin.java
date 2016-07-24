package systembatarka.com.batarka.app.batarkasystem;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.ByteArrayOutputStream;

/**
 * A login screen that offers login via email/password.
 */
public class Add_M5dumin extends AppCompatActivity {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;


    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */

    // UI references.
    private EditText m5dumName;
    private EditText m5dumAddress;
    private View mProgressView;
    private View mLoginFormView;
    private ImageButton m5dumPhoto;
    private String myClass;
    private long m5dumIDs;
    StorageReference storageRef;
    public static Firebase myFirebaseRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_add__m5dumin);
         myFirebaseRef = new Firebase("https://batarkasystem.firebaseio.com/");
        // Set up the login form.
        FirebaseStorage storage = FirebaseStorage.getInstance();
        storageRef = storage.getReferenceFromUrl("gs://batarkasystem.appspot.com");
        SharedPreferences sharedPref =  getApplicationContext().getSharedPreferences("SharedPreference", Activity.MODE_PRIVATE);
        myClass=sharedPref.getString("Class","");
        Log.v("myClass",myClass);
        Query queryRef = myFirebaseRef.child("Classes").child(myClass).child("m5dumIDs");
        queryRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                m5dumIDs = Long.parseLong(snapshot.getValue().toString());
            }
            @Override public void onCancelled(FirebaseError error) {

            }
        });
        m5dumName= (EditText) findViewById(R.id.m5dum_name);

        m5dumAddress = (EditText) findViewById(R.id.m5dum_address);

        m5dumPhoto = (ImageButton) findViewById(R.id.imageButton);
        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                generateQRAndSend();
            }
                       });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    public boolean generateQRAndSend(){
        QRCodeWriter writer = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = writer.encode((m5dumIDs+1)+"", BarcodeFormat.QR_CODE, 512, 512);
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    bmp.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                }
            }
            m5dumPhoto.setImageBitmap(bmp);
            StorageReference imagesRef = storageRef.child("أسرة البطاركة ١٧٣٣"+"/"+myClass+"/"+m5dumName.getText().toString()+".jpg");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] data = baos.toByteArray();
            UploadTask uploadTask = imagesRef.putBytes(data);
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Handle unsuccessful uploads
                    Log.v("justwow",exception.toString());
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                    Uri downloadUrl = taskSnapshot.getDownloadUrl();
                    Log.v("justwow",myClass+"   "+downloadUrl.toString());
                }
            });

        } catch (WriterException e) { //eek//
        }
        return true;
    }


}

