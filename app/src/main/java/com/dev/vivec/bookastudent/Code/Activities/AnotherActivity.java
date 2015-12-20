package com.dev.vivec.bookastudent.Code.Activities;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;

import com.dev.vivec.bookastudent.Code.Adapters.ViewPagerAdapter;
import com.dev.vivec.bookastudent.R;

/**
 * Created by Teperics Márton on 2015.11.16..
 */
public class AnotherActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_v2);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("Book a Student");

        /*Drawable d = getResources().getDrawable(R.drawable.face);
        resize(d);
        toolbar.setLogo(resize(d));
        */

        ViewPager VPager = (ViewPager) findViewById(R.id.view_pager);
        VPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        SlidingTabLayout mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.tabs);
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.bcg_norm));
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setViewPager(VPager);

    }

    private Drawable resize(Drawable image) {
        Bitmap b = ((BitmapDrawable)image).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, 60, 60, false);
        return new BitmapDrawable(getResources(), bitmapResized);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_log_reg, menu);
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

    public void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.move_destroy_left, R.anim.move_destroy_right);
    }
}
