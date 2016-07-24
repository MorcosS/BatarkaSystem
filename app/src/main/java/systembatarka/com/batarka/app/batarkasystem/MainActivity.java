package systembatarka.com.batarka.app.batarkasystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private TabLayout tabLayout;

    public static boolean onOpen;
    public  FloatingActionButton fab;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
/*
        if (id == R.id.nav_2015) {
            LoginActivity.counter = 0;
            Intent in = new Intent(MainActivity.this, year2015.class);
            startActivity(in);

        } else if (id == R.id.nav_2016) {
            LoginActivity.counter = 0;
            Intent mainIntent = new Intent(MainActivity.this, yearNew.class);
            startActivity(mainIntent);


        } else if (id == R.id.nav_message) {
            LoginActivity.counter = 0;
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://docs.google.com/document/d/1w1NfNxWW_ePslsr1wH9kTxSy2__zlN1-iDrX6epeaUg/edit?usp=docslist_api"));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        } else if (id == R.id.nav_sheet) {
            LoginActivity.counter = 0;
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://docs.google.com/spreadsheets/d/1yzekRD-XMQSHVxue93_iOronifsTpNVUdbu1N8NYUVA/edit?usp=docslist_api"));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);*/
        return true;
    }


    public static class PlaceholderFragment extends Fragment {
        View rootView;
        public static View rootView1;
        FloatingActionButton fab;
        private static final String ARG_SECTION_NUMBER = "section_number";
       public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }


        @Override
        public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                                 final Bundle savedInstanceState) {
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
                View rootView = inflater.inflate(R.layout.content_main, container, false);
                return rootView;
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 2) {
                rootView1 = inflater.inflate(R.layout.kashfy_layout,container,false);
                fab = (FloatingActionButton) rootView1.findViewById(R.id.fab);
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(rootView1.getContext(),Add_M5dumin.class);
                        startActivity(intent);
                    }
                });
                return rootView1;
            }
            return null;
        }


   /*     public static void Refresh() {
            RequestQueue queue = Volley.newRequestQueue(rootView1.getContext());
            String url = "https://spreadsheets.google.com/feeds/list/126KOdwxG_9J42s0-mPlZBSVJVCctvSoIOohwSG_cFDQ/default/public/values?alt=json";
            StringRequest s = new StringRequest(url,
                    new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {
                            String st = response.toString();
                            Gson gson = new Gson();
                            SpreadSheetData momentsData = gson.fromJson(st, SpreadSheetData.class);
                            momentsDataList = new ArrayList<OurMomentsData>();
                            for (int i = 0; i < momentsData.getFeed().getEntry().size(); i++) {
                                momentsDataList.add(new OurMomentsData(momentsData.getFeed().getEntry().get(i).getGsx$momentsname().get$t(), momentsData.getFeed().getEntry().get(i).getGsx$momentsdescribtion().get$t().toString()
                                        , momentsData.getFeed().getEntry().get(i).getGsx$momentsimage().get$t().toString(), momentsData.getFeed().getEntry().get(i).getGsx$momentsdate().get$t().toString()));
                            }
                            myAdapter = new MyAdapter(momentsDataList, (Activity) rootView1.getContext());
                            ls.setAdapter(myAdapter);
                            ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                    Intent intent = new Intent(rootView1.getContext(), MomentsDetailed.class);
                                    intent.putExtra("item", i);
                                  //  startActivity(intent);
                                }
                            });
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(rootView1.getContext(), "No Internet Connection!", Toast.LENGTH_LONG).show();
                        }
                    });

            queue.add(s);
        }*/

    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:

                    return "الغياب";
                case 1:
                    return "كشف الفصل";
            }
            return null;
        }
    }
}
