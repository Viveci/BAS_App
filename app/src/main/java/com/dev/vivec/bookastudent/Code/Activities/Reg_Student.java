package com.dev.vivec.bookastudent.Code.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dev.vivec.bookastudent.R;

/**
 * Created by user on 1/13/2016.
 */
public class Reg_Student extends AppCompatActivity {

    private Button next;

    private EditText email;
    private EditText pass;
    private EditText name;
    private EditText cpr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_student);

        email = (EditText) findViewById(R.id.reg_student_fill_email);
        pass = (EditText) findViewById(R.id.reg_student_fill_password);
        name = (EditText) findViewById(R.id.reg_student_fill_name);
        cpr = (EditText) findViewById(R.id.reg_student_fill_cpr);

        next = (Button) findViewById(R.id.reg_student_fill_button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Reg_Student.this,Student_Main.class);
                i.putExtra("EMAIL",email.getText().toString());
                i.putExtra("PASS", pass.getText().toString());
                i.putExtra("NAME", name.getText().toString());
                i.putExtra("CPR",cpr.getText().toString());
                startActivity(i);
                overridePendingTransition(R.anim.move_right, R.anim.move_left);
            }
        });

    }

    public void onResume(){
        super.onResume();
    }

    public void onPause(){
        super.onPause();
    }

    public void onBackPressed(){
        super.onBackPressed();
        overridePendingTransition(R.anim.move_destroy_left, R.anim.move_destroy_right);
    }

}
