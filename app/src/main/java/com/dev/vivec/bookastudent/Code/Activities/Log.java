package com.dev.vivec.bookastudent.Code.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dev.vivec.bookastudent.R;

/**
 * Created by Teperics Márton on 2015.11.08..
 */
public class Log extends AppCompatActivity {

    private Button log;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_log);
            log = (Button) findViewById(R.id.log_log);


            log.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Logging in...",
                            Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Log.this,NewMain.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.move_right, R.anim.move_left);
                }
            });

        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_log_reg, menu);
            return true;
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();

            if (id == R.id.action_settings) {
                return true;
            }

            switch (item.getItemId()) {
                case android.R.id.home:
                    Intent upIntent = new Intent(this, LogReg.class);
                    if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                        TaskStackBuilder
                                .from(this)
                                .addNextIntent(new Intent(this, LogReg.class))
                                .addNextIntent(upIntent).startActivities();
                        finish();
                    } else {
                        NavUtils.navigateUpTo(this, upIntent);
                        overridePendingTransition(R.anim.move_destroy_left, R.anim.move_destroy_right);
                    }
                    return true;
            }

            return super.onOptionsItemSelected(item);
        }

    public void onBackPressed(){
        super.onBackPressed();
        overridePendingTransition(R.anim.move_destroy_left, R.anim.move_destroy_right);
    }

}
