package com.example.androidbase.view;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import com.example.androidbase.R;

public class TagImageActivity extends AppCompatActivity {
    private SimpleTagImageView mSimpleTagImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tagi_mage);
        mSimpleTagImageView = (SimpleTagImageView) findViewById(R.id.stiv);
        mSimpleTagImageView.setTagTextSize(18);
        mSimpleTagImageView.setCornerDistance(30);
        mSimpleTagImageView.setTagTextColor(Color.YELLOW);
        mSimpleTagImageView.setTagTextStyle(SimpleTagImageView.TEXT_STYLE_NORMAL);
        mSimpleTagImageView.setTagText("TAG");
        mSimpleTagImageView.setTagBackgroundColor(Color.RED);
        mSimpleTagImageView.setTagWidth(18);
        mSimpleTagImageView.setTagOrientation(SimpleTagImageView.LEFT_TOP);
        mSimpleTagImageView.setTagRoundRadius(10);
        mSimpleTagImageView.setScaleType(AppCompatImageView.ScaleType.FIT_XY);
    }
}