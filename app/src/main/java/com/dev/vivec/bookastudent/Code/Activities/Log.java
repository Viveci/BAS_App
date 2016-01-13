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
import android.widget.EditText;
import android.widget.Toast;

import com.dev.vivec.bookastudent.R;

/**
 * Created by Teperics Márton on 2015.11.08..
 */
public class Log extends AppCompatActivity {

    private Button log;
    private EditText email;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_log);
            log = (Button) findViewById(R.id.log_log);
            email = (EditText) findViewById(R.id.log_input_email);


            log.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Logging in...",
                            Toast.LENGTH_SHORT).show();

                    Intent i = null;

                    if(email.getText().toString().equals("com")){
                        i = new Intent(Log.this,Company_Main.class);
                        i.putExtra("COLOR",getResources().getColor(R.color.bcg_blue_norm));
                    }

                    else if(email.getText().toString().equals("admin")){
                        i = new Intent(Log.this,Admin_Main.class);
                        i.putExtra("COLOR",getResources().getColor(R.color.admin));
                    }

                    else{
                        i = new Intent(Log.this,Student_Main.class);
                    }

                    startActivity(i);
                    overridePendingTransition(R.anim.move_right, R.anim.move_left);
                }
            });

        }

    public void onBackPressed(){
        super.onBackPressed();
        overridePendingTransition(R.anim.move_destroy_left, R.anim.move_destroy_right);
    }

}
