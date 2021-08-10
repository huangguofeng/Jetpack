package com.example.framework.mvp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.framework.R;
import com.lib.utils.Logger;

/**
 * @author huangguofeng
 * View角色
 */
public class MvpActivity extends AppCompatActivity implements IView {
    private Button clean;
    private EditText editText;
    private IPresenter presenter;
    private TestModel model;

    private Handler handler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        clean = (Button) findViewById(R.id.clean);
        editText = (EditText) findViewById(R.id.editText);

        presenter = new Presenter();
        model = new TestModel();

        setPresenter(presenter);
        model.setPresenter(presenter);

        presenter.setModel(model);
        presenter.setView(this);

        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.cleanClick();
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.textChange(s.toString());
            }
        });
    }


    @Override
    public void setPresenter(IPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void load() {
        Logger.logInfo("View准备load");
    }

    @Override
    public void show(String data) {
        Toast.makeText(this, data + "", Toast.LENGTH_SHORT).show();
    }
}