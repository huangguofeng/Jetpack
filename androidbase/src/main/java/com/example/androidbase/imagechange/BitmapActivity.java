package com.example.androidbase.imagechange;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidbase.R;
import com.lib.utils.Logger;
import com.lib.utils.file.FileUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BitmapActivity extends AppCompatActivity {
    ImageView imageView1;
    ImageView imageView2;
    Button button1;
    Button button2;
    Button button3;
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);
        imageView1 = findViewById(R.id.image1);
        imageView2 = findViewById(R.id.image2);
        button1 = findViewById(R.id.ys1);
        button2 = findViewById(R.id.ys2);
        button3 = findViewById(R.id.ys3);
        button4 = findViewById(R.id.ys4);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = getBitmap(R.mipmap.baobao);
                imageView1.setImageBitmap(bitmap);
                imageView2.setImageBitmap(compressImage(bitmap));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = getBitmap(R.mipmap.baobao);
                imageView1.setImageBitmap(bitmap);
                imageView2.setImageBitmap(compressOptions(R.mipmap.baobao));
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = getBitmap(R.mipmap.baobao1);
                imageView1.setImageBitmap(bitmap);
                imageView2.setImageBitmap(compressMatrix(bitmap));
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = getBitmap(R.mipmap.baobao1);
                imageView1.setImageBitmap(bitmap);
                imageView2.setImageBitmap(compressOptionsRGB(R.mipmap.baobao1));
            }
        });
        compressSize(getBitmap(R.mipmap.dnf));
    }


    @Override
    protected void onStart() {
        super.onStart();
        imageView1.post(new Runnable() {
            @Override
            public void run() {
                int width = imageView1.getMeasuredWidth();
                int height = imageView1.getMeasuredHeight();
                Logger.logInfo("imageView1 宽度为" + width + " 高度为" + height);
            }
        });
        imageView2.post(new Runnable() {
            @Override
            public void run() {
                int width = imageView2.getMeasuredWidth();
                int height = imageView2.getMeasuredHeight();
                Logger.logInfo("imageView2 宽度为" + width + " 高度为" + height);
            }
        });
    }

    private Bitmap getBitmap(int id) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), id);
        Logger.logInfo("压缩前图片的大小" + (bitmap.getByteCount() / 1024 / 1024)
                + "M宽度为" + bitmap.getWidth() + "高度为" + bitmap.getHeight()
                + "单位像素占用字节数：" + bitmap.getByteCount() / bitmap.getWidth() / bitmap.getHeight());
        return bitmap;
    }

    // 质量压缩
    public Bitmap compressImage(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            //压缩格式选取JPEG就行了，quality：压缩精度尽量不要低于50，否则影响清晰度
            bitmap.compress(Bitmap.CompressFormat.JPEG, 10, baos);
            byte[] bytes = baos.toByteArray();
            ByteArrayInputStream isBm = new ByteArrayInputStream(bytes);
            Bitmap bitmap1 = BitmapFactory.decodeStream(isBm);
            Logger.logInfo("压缩后图片的大小" + (bitmap1.getByteCount() / 1024 / 1024)
                    + "M宽度为" + bitmap1.getWidth() + "高度为" + bitmap1.getHeight()
                    + "bytes.length=  " + (bytes.length / 1024) + "KB "
                    + "单位像素占用字节数：" + bitmap1.getByteCount() / bitmap1.getWidth() / bitmap1.getHeight());
            return bitmap1;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            Logger.logError(e.getMessage());
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    // 采样率压缩
    public Bitmap compressOptions(int id) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 4;
        Bitmap bitmap1;
        bitmap1 = BitmapFactory.decodeResource(getResources(), id, options);
        Logger.logInfo("压缩后图片的大小" + (bitmap1.getByteCount() / 1024 / 1024)
                + "M宽度为" + bitmap1.getWidth() + "高度为" + bitmap1.getHeight()
                + "单位像素占用字节数：" + bitmap1.getByteCount() / bitmap1.getWidth() / bitmap1.getHeight());
        return bitmap1;
    }

    // 缩放压缩
    public Bitmap compressMatrix(Bitmap bit) {
        Matrix matrix = new Matrix();
        matrix.setScale(0.2f, 0.2f);
        Bitmap bm = Bitmap.createBitmap(bit, 0, 0, bit.getWidth(),
                bit.getHeight(), matrix, true);
        Logger.logInfo("压缩后图片的大小" + (bm.getByteCount() / 1024 / 1024)
                + "M宽度为" + bm.getWidth() + "高度为" + bm.getHeight()
                + "单位像素占用字节数：" + bm.getByteCount() / bm.getWidth() / bm.getHeight());
        return bm;
    }

    // RGB565压缩
    public Bitmap compressOptionsRGB(int id) {
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap bm = BitmapFactory.decodeResource(getResources(), id, options2);
        Logger.logInfo("压缩后图片的大小" + (bm.getByteCount() / 1024 / 1024)
                + "M宽度为" + bm.getWidth() + "高度为" + bm.getHeight()
                + "单位像素占用字节数：" + bm.getByteCount() / bm.getWidth() / bm.getHeight());
        return bm;
    }

    // 创建指定大小图片进行压缩
    public Bitmap compressSize(Bitmap bitmap) {
        Bitmap bm = Bitmap.createScaledBitmap(bitmap, 1000, 1000, true);
        Logger.logInfo("压缩后图片的大小" + (bm.getByteCount() / 1024 / 1024)
                + "M宽度为" + bm.getWidth() + "高度为" + bm.getHeight()
                + "单位像素占用字节数：" + bm.getByteCount() / bm.getWidth() / bm.getHeight());
        return bm;
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(), drawable.getOpacity() != PixelFormat.OPAQUE ?
                        Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public static Drawable bitmapToDrawable(Resources resources, Bitmap bm) {
        Drawable drawable = new BitmapDrawable(resources, bm);
        return drawable;
    }

    public void save() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.baobao);
        File file = new File(FileUtils.getFilesDir(this), "test.jpg");
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //释放bitmap的资源，这是个不可逆转的操作
        bitmap.recycle();
    }

}