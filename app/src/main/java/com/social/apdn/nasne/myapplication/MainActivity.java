package com.social.apdn.nasne.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import static com.social.apdn.nasne.myapplication.R.color.white;

public class MainActivity extends AppCompatActivity {

    public CardView cardView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(getColor(white));

        cardView = findViewById(R.id.wallpaperChatRecentCard);

    }

    float x , y , dx , dy;
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if (event.getAction()== MotionEvent.ACTION_DOWN)
        {
            x = event.getX();
            y = event.getY();
        }

        if (event.getAction()== MotionEvent.ACTION_MOVE)
        {
            dx = event.getX() - x;
            dy = event.getY() - y;

            cardView.setX(cardView.getX() + dx);
            cardView.setY(cardView.getY() + dy);

            x = event.getX();
            y = event.getY();
        }
        return super.onTouchEvent(event);
    }
}