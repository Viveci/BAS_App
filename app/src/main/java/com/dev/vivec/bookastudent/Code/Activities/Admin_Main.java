package com.dev.vivec.bookastudent.Code.Activities;



import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dev.vivec.bookastudent.Code.Fragments.ADatabase;
import com.dev.vivec.bookastudent.Code.Fragments.Admin_Home;
import com.dev.vivec.bookastudent.Code.Fragments.Admin_Notifications;
import com.dev.vivec.bookastudent.Code.Fragments.Admin_Settings;
import com.dev.vivec.bookastudent.Code.Fragments.Contact;
import com.dev.vivec.bookastudent.Code.Fragments.Home;
import com.dev.vivec.bookastudent.R;

/**
 * Created by Teperics Márton on 2015.12.30.
 */

public class Admin_Main extends AppCompatActivity {

    //Defining Variables
    private int toolBarColor;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Fetching extras
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            toolBarColor = extras.getInt("COLOR");
            toolbar.setBackgroundColor(toolBarColor);
        }

        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        //Default fragment
        fragmentTransaction.replace(R.id.frame, new Admin_Home());
        fragmentTransaction.commit();

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Fragment transaction
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {

                    //Replacing the main content with HomeFragment Which is our Inbox View;
                    case R.id.AHome:
                        Toast.makeText(getApplicationContext(), "Home selected", Toast.LENGTH_SHORT).show();
                        fragmentTransaction.replace(R.id.frame, new Admin_Home());
                        fragmentTransaction.commit();
                        return true;

                    case R.id.ADatabase:
                        Toast.makeText(getApplicationContext(), "My jobs selected", Toast.LENGTH_SHORT).show();
                        fragmentTransaction.replace(R.id.frame, new ADatabase());
                        fragmentTransaction.commit();
                        return true;
                    case R.id.ANotifications:
                        Toast.makeText(getApplicationContext(), "Find a job selected", Toast.LENGTH_SHORT).show();
                        fragmentTransaction.replace(R.id.frame, new Admin_Notifications());
                        fragmentTransaction.commit();
                        return true;

                    case R.id.Asettings:
                        Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
                        fragmentTransaction.replace(R.id.frame, new Admin_Settings());
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


