package com.techsoldev.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

public class AiChooseSymbolActivity extends AppCompatActivity implements View.OnTouchListener {


    private ImageView BackBtn , CrossImg , CrossRadioImg , CircleImg , CircleRadioImg;
    private Button ContinueBtn;

    int PICK_SIDE ;
    private String playerName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_ai_choose_symbol);

        playerName = getIntent().getStringExtra("p1");


        BackBtn= (ImageView) findViewById(R.id.ai_pick_side_back_btn);
        CrossImg= (ImageView) findViewById(R.id.ai_pick_side_cross_img);
        CircleImg= (ImageView) findViewById(R.id.ai_pick_side_circle_img);
        CrossRadioImg= (ImageView) findViewById(R.id.ai_pick_side_cross_radio);
        CircleRadioImg= (ImageView) findViewById(R.id.ai_pick_side_circle_radio);

        ContinueBtn = (Button) findViewById(R.id.ai_pick_side_continue_btn);

        // CrossRadioImg.setOnTouchListener(this);
        CrossRadioImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PICK_SIDE = 0;
                CrossRadioImg.setImageResource(R.drawable.radio_button_checked);
                CircleRadioImg.setImageResource(R.drawable.radio_button_unchecked);
                CircleImg.setAlpha(0.3f);
                CrossImg.setAlpha(1.0f);
            }
        });

        CircleRadioImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                PICK_SIDE= 1;
                CircleRadioImg.setImageResource(R.drawable.radio_button_checked);
                CrossRadioImg.setImageResource(R.drawable.radio_button_unchecked);
                CrossImg.setAlpha(0.3f);
                CircleImg.setAlpha(1.0f);

            }
        });

        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                onBackPressed();

            }
        });

        ContinueBtn.setOnTouchListener(this);
        ContinueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(    AiChooseSymbolActivity.this,AiGameActivity.class);
                intent.putExtra("p1",playerName);
                intent.putExtra("ps",PICK_SIDE);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v == ContinueBtn) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                v.setAlpha(0.5f);
            } else {
                v.setAlpha(1f);
            }
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}