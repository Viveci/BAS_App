package com.dev.vivec.bookastudent.Code.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.dev.vivec.bookastudent.R;

public class LogReg extends AppCompatActivity {

    private Button log;
    private Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_reg);
        log = (Button)findViewById(R.id.logreg_login);
        reg = (Button)findViewById(R.id.logreg_reg);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LogReg.this, Log.class);
                startActivity(i);
                overridePendingTransition(R.anim.move_right,R.anim.move_left);
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LogReg.this, Reg.class);
                startActivity(i);
                overridePendingTransition(R.anim.move_right,R.anim.move_left);
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
}
