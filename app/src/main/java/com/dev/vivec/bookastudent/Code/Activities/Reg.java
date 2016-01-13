package com.dev.vivec.bookastudent.Code.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dev.vivec.bookastudent.R;

/**
 * Created by Teperics Márton on 2015.11.08..
 */
public class Reg extends AppCompatActivity {


    private RelativeLayout student;
    private TextView studentLabel;

    private RelativeLayout company;
    private TextView companytLabel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_v1);

        student = (RelativeLayout) findViewById(R.id.reg_student_color);
        company = (RelativeLayout) findViewById(R.id.reg_comp_color);

        studentLabel = (TextView) findViewById(R.id.reg_student_label);
        companytLabel = (TextView) findViewById(R.id.reg_comp_label);

        student.setOnTouchListener( new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        student.setBackgroundColor(getResources().getColor((R.color.bcg)));
                        studentLabel.setTextColor(getResources().getColor((R.color.bcg)));
                        break;
                    case MotionEvent.ACTION_UP:
                        //set color back to default
                        student.setBackgroundColor(Color.parseColor("#EEEEEE"));
                        studentLabel.setTextColor(Color.parseColor("#666666"));

                        Intent i = new Intent(Reg.this, Reg_Student.class);
                        startActivity(i);
                        overridePendingTransition(R.anim.move_right, R.anim.move_left);

                        break;

                    case MotionEvent.ACTION_CANCEL:
                        student.setBackgroundColor(Color.parseColor("#EEEEEE"));
                        studentLabel.setTextColor(Color.parseColor("#666666"));
                        break;
                }
                return true;
            }
        });

        company.setOnTouchListener( new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        company.setBackgroundColor(getResources().getColor((R.color.bcg_blue_norm)));
                        companytLabel.setTextColor(getResources().getColor((R.color.bcg_blue_norm)));

                        break;
                    case MotionEvent.ACTION_UP:
                        //set color back to default
                        company.setBackgroundColor(Color.parseColor("#EEEEEE"));
                        companytLabel.setTextColor(Color.parseColor("#666666"));

                        Intent i = new Intent(Reg.this, Reg_Company.class);
                        startActivity(i);
                        overridePendingTransition(R.anim.move_right, R.anim.move_left);
                        break;

                    case MotionEvent.ACTION_CANCEL:
                        company.setBackgroundColor(Color.parseColor("#EEEEEE"));
                        companytLabel.setTextColor(Color.parseColor("#666666"));
                        break;
                }
                return true;
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
