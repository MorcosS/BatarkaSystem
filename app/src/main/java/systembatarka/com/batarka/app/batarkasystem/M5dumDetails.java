package systembatarka.com.batarka.app.batarkasystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import systembatarka.com.batarka.app.batarkasystem.Adapters.TafaselM5dumAdapter;
import systembatarka.com.batarka.app.batarkasystem.Data.M5dumDataShow;

public class M5dumDetails extends AppCompatActivity {
    String m5dumName, m5dumPhoto, m5dumAddress, m5dumFloorNo,m5dumFlatNo,m5dumMobile,m5dumPhone,m5dumFatherMob
            ,m5dumMotherMob,m5dumPoints,dob;
    ArrayList<M5dumDataShow> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m5dumdetails);
        Intent intent = getIntent();
        m5dumName = intent.getStringExtra("Name");
        m5dumPhoto = intent.getStringExtra("Photo");
        m5dumAddress = intent.getStringExtra("Address");
        m5dumFloorNo= intent.getStringExtra("FloorNo");
        m5dumFlatNo = intent.getStringExtra("FlatNo");
        m5dumMobile = intent.getStringExtra("Mobile");
        m5dumPhone = intent.getStringExtra("Phone");
        m5dumFatherMob = intent.getStringExtra("FatherMob");
        m5dumMotherMob = intent.getStringExtra("MotherMob");
        m5dumPoints = intent.getStringExtra("Points");
        dob = intent.getStringExtra("DOB");
        arrayList = new ArrayList<M5dumDataShow>();
        addInList();
        TafaselM5dumAdapter tafaselM5dumAdapter = new TafaselM5dumAdapter(arrayList,this);
        ListView ls = (ListView) findViewById(R.id.listView4);
        ls.setAdapter(tafaselM5dumAdapter);
    }

    public void addInList(){
        arrayList.add(new M5dumDataShow(m5dumAddress+"\n"+"الدور: "+m5dumFloorNo+"\n"+"الشقة: "+m5dumFlatNo,"Address","ic_navigation_black_24dp","ic_edit_location_black_24dp"));
        arrayList.add(new M5dumDataShow(m5dumPhone,"Phone","ic_call_black_24dp","ic_call_black_24dp"));
        arrayList.add(new M5dumDataShow(m5dumMobile,"Mobile","ic_call_black_24dp","ic_message_black_24dp"));
        arrayList.add(new M5dumDataShow(m5dumFatherMob,"Father Mobile","ic_call_black_24dp","ic_message_black_24dp"));
        arrayList.add(new M5dumDataShow(m5dumMotherMob,"Mother Mobile","ic_call_black_24dp","ic_message_black_24dp"));
        arrayList.add(new M5dumDataShow(dob,"Date Of Birth","ic_insert_invitation_black_24dp","ic_edit_location_black_24dp"));
        arrayList.add(new M5dumDataShow(m5dumPoints,"Points","ic_add_circle_outline_black_24dp","ic_remove_circle_outline_black_24dp"));
    }

}
