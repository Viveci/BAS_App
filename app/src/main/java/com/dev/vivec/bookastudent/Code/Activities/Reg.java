package com.dev.vivec.bookastudent.Code.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.dev.vivec.bookastudent.R;

/**
 * Created by Teperics Márton on 2015.11.08..
 */
public class Reg extends AppCompatActivity {

    private Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_v1);
        reg = (Button)findViewById(R.id.reg_log);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Reg.this, NewMain.class);
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

        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed(){
        super.onBackPressed();
            overridePendingTransition(R.anim.move_destroy_left, R.anim.move_destroy_right);
    }

}
