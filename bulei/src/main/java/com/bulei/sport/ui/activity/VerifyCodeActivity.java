package com.bulei.sport.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;

import com.bulei.sport.R;
import com.bulei.sport.databinding.ActivityVerifyCodeBinding;
import com.bulei.sport.databinding.ActivityWelcomeBinding;
import com.bulei.sport.ui.callback.AfCallback;
import com.bulei.sport.ui.callback.EditTextTextWatcher;
import com.bulei.sport.ui.fragment.ForgetFragment;
import com.bulei.sport.ui.fragment.VerifyCodeFragment;
import com.bulei.sport.utils.InputUtils;
import com.example.myapplication.Main2Activity;
import com.lib.base.ui.BasicActivity;
import com.lib.base.utils.ActivityUtils;
import com.lib.utils.Logger;
import com.lib.utils.file.MmKvUtil;

import java.util.Objects;
@SuppressLint("SetTextI18n")
public class VerifyCodeActivity extends BasicActivity {
    int type;
    String phone;
    ActivityVerifyCodeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVerifyCodeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        parseBundle();
        initView();
        ActivityUtils.get().print();
    }


    private void initView() {
        binding.forgetVerifyBack.setOnClickListener(v -> {
            close();
            finish();
        });

        binding.forgetVerifyCodeTip.setText(binding.forgetVerifyCodeTip.getText()+phone);

        binding.forgetInputVerify.setOnKeyListener((v, keyCode, event) ->
                InputUtils.getUtils().onKey(binding.forgetInputVerify,event,keyCode));
        binding.forgetInputVerify.addTextChangedListener(new EditTextTextWatcher(4, state -> {
            if(state){
                binding.forgetSure.setClickable(true);
                binding.forgetSure.setBackgroundResource(R.drawable.login_button_yellow_light);
            }else{
                binding.forgetSure.setClickable(false);
                binding.forgetSure.setBackgroundResource(R.drawable.login_button_yellow);
            }
        }));


        binding.forgetSure.setOnClickListener( v -> {
            close();
            login(phone,binding.forgetInputVerify.getText().toString());
        });
        binding.forgetSure.setClickable(false);

        binding.forgetResend.setOnClickListener(v -> {
            binding.forgetResend.setClickable(false);
            close();
            handler.sendEmptyMessage(0);
        });
    }

    private void parseBundle(){
        Bundle bundle = getBundle();
        if(!bundle.getBoolean(BUNDLE_DEFAULT)){
            type = bundle.getInt("type");
            phone = bundle.getString("phone","");
            Logger.logInfo("type = "+type);
            Logger.logInfo("phone = "+phone);
        }
    }

    private void close(){
        binding.forgetInputVerify.clearFocus();
        InputUtils.getUtils().closeSoftInput(this,binding.forgetInputVerify);
    }

    private void login(String phone,String code){
        Logger.logInfo("网络请求验证码登录，手机号："+phone+" ，验证码："+code);
        MmKvUtil.put("loginResult",true);
        loginSuccess();
    }

    private void loginSuccess(){
        startActivity(new Intent(this, Main2Activity.class));
        ActivityUtils.get().removeAll();
    }

    int time = 60;
    @Override
    protected void handlerMsg(Message msg) {
        super.handlerMsg(msg);
        if(time == 0){
            binding.forgetResend.setText(getText(R.string.forget_resend));
            binding.forgetResend.setClickable(true);
            handler.removeMessages(0);
            time = 60;
        }else{
            binding.forgetResend.setText(time+getText(R.string.forget_resend_timer).toString());
            time--;
            handler.sendEmptyMessageDelayed(0,1000);
        }
    }
}