package com.example.androidbase.textureview;

import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidbase.R;

/**
 * @author huangguofeng
 */
public class TextureViewActivity extends AppCompatActivity implements TextureView.SurfaceTextureListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnBufferingUpdateListener {
    private TextureView textureView;
    private MediaPlayer mediaPlayer;
    private SurfaceTexture surfaceTexture;
    private Surface surface;
    private final static String TAG = "MainActivity";
    private int mVideomode = 0;
    private int mVideoWidth;
    private int mVideoHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texture);
        textureView = findViewById(R.id.texture);
        textureView.setSurfaceTextureListener(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (textureView.isAvailable()) {
            playVideo();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    private void playVideo() {
        if (mediaPlayer == null) {
            surfaceTexture = textureView.getSurfaceTexture();
            surface = new Surface(surfaceTexture);
            initMediaPlayer();
        }
    }

    private void initMediaPlayer() {
        mediaPlayer = MediaPlayer.create(this, R.raw.video);
        mediaPlayer.setSurface(surface);
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setOnErrorListener(this);
        mediaPlayer.setOnBufferingUpdateListener(this);
        mediaPlayer.setOnVideoSizeChangedListener(this);
        mediaPlayer.setLooping(true);
    }

    @Override
    public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surface, int width, int height) {
        playVideo();
    }

    @Override
    public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surface, int width, int height) {
        updateTextureViewSizeCenter();
    }

    @Override
    public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surface) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surface) {

    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        if (mp != null) {
            mediaPlayer.setVolume(1f, 1f);
            mediaPlayer.start();
        }
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
        mVideoWidth = mp.getVideoWidth();
        mVideoHeight = mp.getVideoHeight();
        updateTextureViewSizeCenter();
    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {

    }

    private void updateTextureViewSizeCenter() {
        float sx = (float) textureView.getWidth() / (float) mVideoWidth;
        float sy = (float) textureView.getHeight() / (float) mVideoHeight;
        Matrix matrix = new Matrix();
        matrix.preTranslate((textureView.getWidth() - mVideoWidth) / 2, (textureView.getHeight() - mVideoHeight) / 2);
        matrix.preScale(mVideoWidth / (float) textureView.getWidth(), mVideoHeight / (float) textureView.getHeight());
        if (sx >= sy) {
            matrix.postScale(sy, sy, textureView.getWidth() / 2, textureView.getHeight() / 2);
        } else {
            matrix.postScale(sx, sx, textureView.getWidth() / 2, textureView.getHeight() / 2);
        }
        textureView.setTransform(matrix);
        textureView.postInvalidate();
        //放大三倍
        matrix.setScale(1 + 0 / 100f, 1 + 0 / 100f);
        textureView.setTransform(matrix);
    }
}