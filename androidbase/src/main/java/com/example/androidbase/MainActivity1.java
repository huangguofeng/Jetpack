package com.example.androidbase;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.lib.utils.Logger;

/**
 * @author huangguofeng
 */
public class MainActivity1 extends AppCompatActivity {
    Button button;
    MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.logInfo("onCreate : " + this.getClass().getSimpleName());
        setContentView(R.layout.activity_main1);
        button = findViewById(R.id.bt);
        myView = findViewById(R.id.myView);

        button.setText(getRadiusGradientSpan(
                "这个世界\n" + "没有看上去那么简单", 0xFFFF0000, 0xFF00FF00));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity1.this, MainActivity.class));
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Logger.logInfo("onStart : " + this.getClass().getSimpleName());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Logger.logInfo("onRestart : " + this.getClass().getSimpleName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.logInfo("onResume : " + this.getClass().getSimpleName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.logInfo("onPause : " + this.getClass().getSimpleName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.logInfo("onStop : " + this.getClass().getSimpleName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.logInfo("onDestroy : " + this.getClass().getSimpleName());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Logger.logInfo("onNewIntent : " + this.getClass().getSimpleName());
    }

    public static SpannableStringBuilder getRadiusGradientSpan(String string, int startColor, int endColor) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        LinearGradientFontSpan span = new LinearGradientFontSpan(startColor, endColor);
        spannableStringBuilder.setSpan(span, 0, spannableStringBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableStringBuilder;

    }
}