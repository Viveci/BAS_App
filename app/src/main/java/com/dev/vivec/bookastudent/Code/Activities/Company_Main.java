package com.dev.vivec.bookastudent.Code.Activities;

/**
 * Created by user on 12/30/2015.
 */

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.vivec.bookastudent.Code.Fragments.Company_Home;
import com.dev.vivec.bookastudent.Code.Fragments.Company_Notifications;
import com.dev.vivec.bookastudent.Code.Fragments.Company_PostaJob;
import com.dev.vivec.bookastudent.Code.Fragments.Company_Ratings;
import com.dev.vivec.bookastudent.Code.Fragments.Company_Settings;
import com.dev.vivec.bookastudent.Code.Fragments.Contact;
import com.dev.vivec.bookastudent.Code.Fragments.Company_Jobs;
import com.dev.vivec.bookastudent.R;

/**
 * Created by Teperics Márton on 2015.12.30..
 */

public class Company_Main extends AppCompatActivity {

    //Defining Variables
    private int toolBarColor;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private MenuItem lastItem;

    private String name;
    private String email;
    private String CVR;

    android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_main);

        name = "Default";
        email = "default@default.com";

        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Fetching extras
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            if(extras.getInt("COLOR") != 0) {
                toolBarColor = extras.getInt("COLOR");
                toolbar.setBackgroundColor(toolBarColor);
            }
            if(extras.getString("EMAIL")!=null){
                email = extras.getString("EMAIL");
            }
            if(extras.getString("NAME")!=null){
                name = extras.getString("NAME");
            }
            if(extras.getString("CVR")!=null){
                CVR = extras.getString("CVR");
            }
        }

        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        //Inflating the header
        View header = navigationView.inflateHeaderView(R.layout.header_company);
        TextView textN = (TextView) header.findViewById(R.id.header_username);
        TextView textE = (TextView) header.findViewById(R.id.header_email);
        ImageView img = (ImageView) header.findViewById(R.id.header_img);
        if(!name.equals("Default")) {
            textN.setText(name);
            textE.setText(email);
            img.setImageResource(R.drawable.ic_account_circle_white_48dp);
        }




        //Default fragment
        fragmentTransaction.replace(R.id.frame, new Company_Home());
        fragmentTransaction.commit();

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                if(lastItem == null)
                    lastItem = menuItem;
                if(lastItem!=menuItem){
                    lastItem.setChecked(false);
                    lastItem = menuItem;
                }

                //Checking if the item is in checked state or not, if not make it in checked state
                if (!menuItem.isChecked()) menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Fragment transaction
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {

                    case R.id.detail_headerBar:
                        Toast.makeText(getApplicationContext(), "Profile selected", Toast.LENGTH_SHORT).show();
                        fragmentTransaction.replace(R.id.frame, new Company_Home());
                        fragmentTransaction.commit();
                        return true;


                    //Replacing the main content with HomeFragment Which is our Inbox View;
                    case R.id.CHome:
                        Toast.makeText(getApplicationContext(), "Home selected", Toast.LENGTH_SHORT).show();
                        fragmentTransaction.replace(R.id.frame, new Company_Home());
                        fragmentTransaction.commit();
                        return true;

                    case R.id.CPost:
                        Toast.makeText(getApplicationContext(), "Post a job", Toast.LENGTH_SHORT).show();
                        fragmentTransaction.replace(R.id.frame, new Company_PostaJob());
                        fragmentTransaction.commit();
                        return true;

                    case R.id.CJobs:
                        Toast.makeText(getApplicationContext(), "My posted jobs selected", Toast.LENGTH_SHORT).show();
                        fragmentTransaction.replace(R.id.frame, new Company_Jobs());
                        fragmentTransaction.commit();
                        return true;
                    case R.id.CRatings:
                        Toast.makeText(getApplicationContext(), "Ratings selected", Toast.LENGTH_SHORT).show();
                        fragmentTransaction.replace(R.id.frame, new Company_Ratings());
                        fragmentTransaction.commit();
                        return true;
                    case R.id.CNotifications:
                        Toast.makeText(getApplicationContext(), "Notification selected", Toast.LENGTH_SHORT).show();
                        fragmentTransaction.replace(R.id.frame, new Company_Notifications());
                        fragmentTransaction.commit();
                        return true;
                    case R.id.Csettings:
                        Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
                        fragmentTransaction.replace(R.id.frame, new Company_Settings());
                        fragmentTransaction.commit();
                        return true;
                    case R.id.contact:
                        Toast.makeText(getApplicationContext(), "contact", Toast.LENGTH_SHORT).show();
                        fragmentTransaction.replace(R.id.frame, new Contact());
                        fragmentTransaction.commit();
                        return true;
                    default:
                        Toast.makeText(getApplicationContext(), "Undefined", Toast.LENGTH_SHORT).show();
                        fragmentTransaction.replace(R.id.frame, new Contact());
                        fragmentTransaction.commit();
                        return true;

                }
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer, R.string.closeDrawer){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }



    public void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.move_destroy_left, R.anim.move_destroy_right);
    }
}

