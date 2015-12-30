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

import com.dev.vivec.bookastudent.R;

/**
 * Created by Teperics Márton on 2015.11.08..
 */
public class Reg extends AppCompatActivity {

    private Button reg;
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_v1);
        reg = (Button)findViewById(R.id.reg_log);
        email = (EditText) findViewById(R.id.reg_input_email);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Reg.this, Student_Main.class);

                if(email.getText().toString().equals("comp")){
                    i.putExtra("COLOR",getResources().getColor(R.color.bcg_blue_norm));
                }

                if(email.getText().toString().equals("admin")){
                    i.putExtra("COLOR",getResources().getColor(R.color.admin));
                }

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
