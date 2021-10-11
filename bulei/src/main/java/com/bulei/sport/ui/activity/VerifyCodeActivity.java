package com.bulei.sport.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Message;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bulei.sport.R;
import com.bulei.sport.databinding.ActivityVerifyCodeBinding;
import com.bulei.sport.ui.MainPath;
import com.lib.base.ui.BasicActivity;
import com.lib.base.utils.ActivityUtils;
import com.lib.common.ui.EditTextTextWatcher;
import com.lib.common.utils.InputUtils;
import com.lib.utils.Logger;
import com.lib.utils.file.MmKvUtil;

@SuppressLint("SetTextI18n")
@Route(path = MainPath.MAIN_VERIFY)
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

        binding.forgetVerifyCodeTip.setText(binding.forgetVerifyCodeTip.getText() + phone);

        binding.forgetInputVerify.setOnKeyListener((v, keyCode, event) ->
                InputUtils.getUtils().onKey(binding.forgetInputVerify, event, keyCode));
        binding.forgetInputVerify.addTextChangedListener(new EditTextTextWatcher(4, state -> {
            if (state) {
                binding.forgetSure.setClickable(true);
                binding.forgetSure.setBackgroundResource(R.drawable.login_button_yellow_light);
            } else {
                binding.forgetSure.setClickable(false);
                binding.forgetSure.setBackgroundResource(R.drawable.login_button_yellow);
            }
        }));


        binding.forgetSure.setOnClickListener(v -> {
            close();
            login(phone, binding.forgetInputVerify.getText().toString());
        });
        binding.forgetSure.setClickable(false);

        binding.forgetResend.setOnClickListener(v -> {
            binding.forgetResend.setClickable(false);
            close();
            handler.sendEmptyMessage(0);
        });
    }

    private void parseBundle() {
        Bundle bundle = getBundle();
        if (!bundle.getBoolean(BUNDLE_DEFAULT)) {
            type = bundle.getInt("type");
            phone = bundle.getString("phone", "");
            Logger.logInfo("type = " + type);
            Logger.logInfo("phone = " + phone);
        }
    }

    private void close() {
        binding.forgetInputVerify.clearFocus();
        InputUtils.getUtils().closeSoftInput(this, binding.forgetInputVerify);
    }

    private void login(String phone, String code) {
        Logger.logInfo("网络请求验证码登录，手机号：" + phone + " ，验证码：" + code);
        MmKvUtil.put("loginResult", true);
        loginSuccess();
    }

    private void loginSuccess() {
        ARouter.getInstance().build(MainPath.MAIN_HOME).navigation();
        ActivityUtils.get().removeAll();
    }

    int time = 60;

    @Override
    protected void handlerMsg(Message msg) {
        super.handlerMsg(msg);
        if (time == 0) {
            binding.forgetResend.setText(getText(R.string.forget_resend));
            binding.forgetResend.setClickable(true);
            handler.removeMessages(0);
            time = 60;
        } else {
            binding.forgetResend.setText(time + getText(R.string.forget_resend_timer).toString());
            time--;
            handler.sendEmptyMessageDelayed(0, 1000);
        }
    }
}