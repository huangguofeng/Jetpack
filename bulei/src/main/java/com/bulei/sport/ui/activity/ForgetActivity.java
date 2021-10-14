package com.bulei.sport.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bulei.sport.R;
import com.bulei.sport.databinding.ActivityForgetBinding;
import com.bulei.sport.ui.MainPath;
import com.lib.base.ui.BasicActivity;
import com.lib.common.ui.EditTextTextWatcher;
import com.lib.common.utils.InputUtils;
import com.lib.utils.Logger;
import com.lib.utils.check.CheckUtils;

/**
 * @author huangguofeng
 */
@SuppressLint("SetTextI18n")
@Route(path = MainPath.MAIN_FORGET)
public class ForgetActivity extends BasicActivity {
    int type;
    String phone;
    ActivityForgetBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ARouter.getInstance().inject(this);
        parseBundle();
        initView();
    }


    private void initView() {
        binding.forgetBg.setOnClickListener(v -> {
            close();
            finish();
        });
        binding.forgetInputPhone.setText(phone);
        binding.forgetInputPhone.setOnKeyListener((v, keyCode, event) ->
                InputUtils.getUtils().onKey(binding.forgetInputPhone, event, keyCode));
        binding.forgetInputPhone.addTextChangedListener(new EditTextTextWatcher(11, state -> {
            if (state) {
                binding.forgetNext.setClickable(true);
                binding.forgetNext.setBackgroundResource(R.drawable.login_button_yellow_light);
            } else {
                binding.forgetNext.setClickable(false);
                binding.forgetNext.setBackgroundResource(R.drawable.login_button_yellow);
            }
        }));

        binding.forgetNext.setOnClickListener(v -> {
            close();
            goVerifyActivity();
        });
        binding.forgetNext.setClickable(false);

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
        binding.forgetInputPhone.clearFocus();
        InputUtils.getUtils().closeSoftInput(this, binding.forgetInputPhone);
    }

    private void goVerifyActivity() {
        if (!CheckUtils.checkPhoneNumber(binding.forgetInputPhone.getText().toString())) {
            Toast.makeText(this, "手机号格式错误，请检查", Toast.LENGTH_SHORT).show();
            return;
        }
        ARouter.getInstance().build(MainPath.MAIN_VERIFY).withInt("type", type).withString("phone",
                binding.forgetInputPhone.getText().toString()).navigation();
    }

}