package com.techsoldev.tictactoegame;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


public class OfflineGameMenuActivity extends AppCompatActivity implements View.OnTouchListener {
    public int SCREEN_SIZE;
    public int SET_TRANSLATE;


    private Button WithAFriendBtn , WithAi;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline_game_menu);


        WithAFriendBtn = (Button) findViewById(R.id.btn_choice2_offline_menu);
        WithAi = (Button) findViewById(R.id.btn_choice1_offline_menu);

        SCREEN_SIZE =getScreenResolution(this);

        if(SCREEN_SIZE >1500)
        {
            SET_TRANSLATE = -560;
        }
        else if(SCREEN_SIZE <=1500)
        {
            SET_TRANSLATE = -300;
        }

        WithAFriendBtn.setOnTouchListener(this);
        WithAFriendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OfflineGameMenuActivity.this,OfflineGetPlayersNamesActivity.class);
               startActivity(intent);
            }
        });

        WithAi.setOnTouchListener(this);
        WithAi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OfflineGameMenuActivity.this,AIGetPlayerNameActivity.class);
                startActivity(intent);
            }
        });




    }



    private int getScreenResolution(Context context)
    {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        //  Toast.makeText(SplashActivity.this , "Screen height is : "+ height , Toast.LENGTH_SHORT).show();

        return height ;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }




    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v == WithAFriendBtn) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                v.setAlpha(0.5f);
            } else {
                v.setAlpha(1f);
            }
        }
        else  if (v == WithAi) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                v.setAlpha(0.5f);
            } else {
                v.setAlpha(1f);
            }
        }
        return false;
    }
}
