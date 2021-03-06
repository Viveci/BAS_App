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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.vivec.bookastudent.Code.Fragments.Contact;
import com.dev.vivec.bookastudent.Code.Fragments.FindJobs;
import com.dev.vivec.bookastudent.Code.Fragments.Home;
import com.dev.vivec.bookastudent.Code.Fragments.MyJobs;
import com.dev.vivec.bookastudent.Code.Fragments.Notifications;
import com.dev.vivec.bookastudent.Code.Fragments.Ratings;
import com.dev.vivec.bookastudent.Code.Fragments.Settings;
import com.dev.vivec.bookastudent.R;


/**
 * Created by Teperics Márton on 2015.12.02..
 */
public class Student_Main extends AppCompatActivity {

        //Defining Variables
        private int toolBarColor;
        private Toolbar toolbar;
        private NavigationView navigationView;
        private DrawerLayout drawerLayout;
        private MenuItem lastItem;
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        private String name;
        private String email;
        private String CPR;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_newmain);

            // Initializing Toolbar and setting it as the actionbar
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            name = "Default";
            email = "default@default.com";

            //Fetching extras
            Bundle extras = getIntent().getExtras();
            if(extras != null){
                if(extras.getInt("COLOR") != 0) {
                    toolBarColor = extras.getInt("COLOR");
                    toolbar.setBackgroundColor(toolBarColor);
                }
                if(!extras.getString("EMAIL").isEmpty()){
                    email = extras.getString("EMAIL");
                }
                if(!extras.getString("NAME").isEmpty()){
                    name = extras.getString("NAME");
                }
                if(!extras.getString("CPR").isEmpty()){
                    CPR = extras.getString("CPR");
                }
            }

            //Initializing NavigationView
            navigationView = (NavigationView) findViewById(R.id.navigation_view);

            //Inflating the header
            View header = navigationView.inflateHeaderView(R.layout.header);
            TextView textN = (TextView) header.findViewById(R.id.header_username);
            TextView textE = (TextView) header.findViewById(R.id.header_email);
            ImageView img = (ImageView) header.findViewById(R.id.header_img);
            if(!name.equals("Default")) {
                textN.setText(name);
                textE.setText(email);
                img.setImageResource(R.drawable.ic_account_circle_white_48dp);
            }

            //Default fragment
            fragmentTransaction.replace(R.id.frame, new Home());
            fragmentTransaction.commit();

            //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

                // This method will trigger on item Click of navigation menu
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {

                    // replacing the single click behavior from the menu xml
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
                            fragmentTransaction.replace(R.id.frame, new Home());
                            fragmentTransaction.commit();
                            return true;


                        //Replacing the main content with HomeFragment Which is our Inbox View;
                        case R.id.Home:
                            Toast.makeText(getApplicationContext(), "Home selected", Toast.LENGTH_SHORT).show();

                            //DAfuq here
                            Home h = new Home();
                            Bundle bundle = new Bundle();
                            bundle.putString("NAME", name);
                            h.setArguments(bundle);

                            fragmentTransaction.replace(R.id.frame, h);
                            fragmentTransaction.commit();
                            return true;

                        case R.id.MyJobs:
                            Toast.makeText(getApplicationContext(), "My jobs selected", Toast.LENGTH_SHORT).show();
                            fragmentTransaction.replace(R.id.frame, new MyJobs());
                            fragmentTransaction.commit();
                            return true;
                        case R.id.FindJobs:
                            Toast.makeText(getApplicationContext(), "Find a job selected", Toast.LENGTH_SHORT).show();
                            fragmentTransaction.replace(R.id.frame, new FindJobs());
                            fragmentTransaction.commit();
                            return true;
                        case R.id.Rating:
                            Toast.makeText(getApplicationContext(), "Ratings selected", Toast.LENGTH_SHORT).show();
                            fragmentTransaction.replace(R.id.frame, new Ratings());
                            fragmentTransaction.commit();
                            return true;
                        case R.id.Notifications:
                            Toast.makeText(getApplicationContext(), "Notification selected", Toast.LENGTH_SHORT).show();
                            fragmentTransaction.replace(R.id.frame, new Notifications());
                            fragmentTransaction.commit();
                            return true;
                        case R.id.settings:
                            Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
                            fragmentTransaction.replace(R.id.frame, new Settings());
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
        }

        public void onBackPressed(){
            super.onBackPressed();
            overridePendingTransition(R.anim.move_destroy_left, R.anim.move_destroy_right);
        }



}
