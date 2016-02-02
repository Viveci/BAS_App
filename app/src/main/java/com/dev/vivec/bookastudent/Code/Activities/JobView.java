package com.dev.vivec.bookastudent.Code.Activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.vivec.bookastudent.R;

/**
 * Created by user on 1/14/2016.
 */
public class JobView extends AppCompatActivity {

    private ImageView header;
    private TextView JobAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);

        header = (ImageView) findViewById(R.id.job_header_img);
        JobAbout = (TextView) findViewById(R.id.job_about_about);

        String htmls = "<p>Do you enjoy working in a creative environment?</p><p>Are you good with computer graphics?<p>"+
                        "<p>If the answer to these questions is YES, then this might be the job for you! </p>";
        JobAbout.setText(Html.fromHtml(htmls));


    }

    public void onBackPressed(){
        super.onBackPressed();
        overridePendingTransition(R.anim.move_destroy_left, R.anim.move_destroy_right);
    }

}
