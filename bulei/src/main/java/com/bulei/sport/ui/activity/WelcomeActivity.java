package com.bulei.sport.ui.activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bulei.sport.R;
import com.bulei.sport.databinding.ActivityWelcomeBinding;
import com.bulei.sport.ui.MainPath;
import com.bulei.sport.viewmodel.LoginViewModel;
import com.bumptech.glide.Glide;
import com.lib.base.ui.BaseViewModelActivity;
import com.lib.base.utils.ActivityUtils;
import com.lib.common.utils.InputUtils;
import com.lib.utils.Logger;
import com.lib.utils.check.CheckUtils;

import jp.wasabeef.glide.transformations.BlurTransformation;

@SuppressLint("ResourceAsColor")
public class WelcomeActivity extends BaseViewModelActivity<LoginViewModel> implements View.OnFocusChangeListener {
    ActivityWelcomeBinding binding;
    int passwordLength, phoneNumberLength, verifyCodeLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ARouter.getInstance().inject(this);
        getViewModel().loginResult.observe(this, aBoolean -> {
            Logger.logInfo("观察到登录结果变化了：是否登录：" + aBoolean);
            if (aBoolean) {
                loginSuccess();
            }
        });

        binding.loginInputPhone.setOnFocusChangeListener(this);
        binding.loginInputPassword.setOnFocusChangeListener(this);
        binding.loginInputVerifyCode.setOnFocusChangeListener(this);

        binding.loginInputPhone.setOnKeyListener((v, keyCode, event) ->
                InputUtils.getUtils().onKey(binding.loginInputPhone, event, keyCode));
        binding.loginInputPassword.setOnKeyListener((v, keyCode, event) ->
                InputUtils.getUtils().onKey(binding.loginInputPassword, event, keyCode));
        binding.loginInputVerifyCode.setOnKeyListener((v, keyCode, event) ->
                InputUtils.getUtils().onKey(binding.loginInputVerifyCode, event, keyCode));

        binding.loginInputPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Logger.logInfo(" " + start + " " + before + " " + count + " , " + phoneNumberLength + " " +
                        passwordLength + " " + verifyCodeLength);
                if (start == 10) {
                    if (getViewModel().loginState == 0) {
                        binding.loginGetVerifyCode.setClickable(true);
                        binding.loginGetVerifyCode.setBackgroundResource(R.drawable.login_button_yellow_light);
                    }
                    if (getViewModel().loginState == 1) {
                        if (passwordLength >= 6 && passwordLength <= 16) {
                            binding.loginLogin.setClickable(true);
                            binding.loginLogin.setBackgroundResource(R.drawable.login_button_yellow_light);
                        }
                    }
                    if (getViewModel().loginState == 2) {
                        if (passwordLength >= 6 && passwordLength <= 16 && verifyCodeLength == 4) {
                            binding.loginRegister.setClickable(true);
                            binding.loginRegister.setBackgroundResource(R.drawable.login_button_yellow_light);
                        }
                    }
                }
                if (count == 10) {
                    if (getViewModel().loginState == 0) {
                        binding.loginGetVerifyCode.setClickable(false);
                        binding.loginGetVerifyCode.setBackgroundResource(R.drawable.login_button_yellow);
                    }
                    if (getViewModel().loginState == 1) {
                        if (passwordLength >= 6 && passwordLength <= 16) {
                            binding.loginLogin.setClickable(false);
                            binding.loginLogin.setBackgroundResource(R.drawable.login_button_yellow);
                        }
                    }
                    if (getViewModel().loginState == 2) {
                        if (passwordLength >= 6 && passwordLength <= 16 && verifyCodeLength == 4) {
                            binding.loginRegister.setClickable(false);
                            binding.loginRegister.setBackgroundResource(R.drawable.login_button_yellow);
                        }
                    }

                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                phoneNumberLength = binding.loginInputPhone.getText().length();
//                Logger.logInfo("手机号长度："+phoneNumberLength);
            }
        });

        binding.loginInputPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Logger.logInfo(" " + start + " " + before + " " + count + " , " + phoneNumberLength + " " +
                        passwordLength + " " + verifyCodeLength);
                if (start == 5) {
                    if (getViewModel().loginState == 1) {
                        if (phoneNumberLength == 11) {
                            binding.loginLogin.setClickable(true);
                            binding.loginLogin.setBackgroundResource(R.drawable.login_button_yellow_light);
                        }
                    }
                    if (getViewModel().loginState == 2) {
                        if (phoneNumberLength == 11 && verifyCodeLength == 4) {
                            binding.loginRegister.setClickable(true);
                            binding.loginRegister.setBackgroundResource(R.drawable.login_button_yellow_light);
                        }
                    }
                }
                if (count == 5) {
                    if (getViewModel().loginState == 1) {
                        if (phoneNumberLength == 11) {
                            binding.loginLogin.setClickable(false);
                            binding.loginLogin.setBackgroundResource(R.drawable.login_button_yellow);
                        }
                    }
                    if (getViewModel().loginState == 2) {
                        if (phoneNumberLength == 11 && verifyCodeLength == 4) {
                            binding.loginRegister.setClickable(false);
                            binding.loginRegister.setBackgroundResource(R.drawable.login_button_yellow);
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                passwordLength = binding.loginInputPassword.getText().length();
//                Logger.logInfo("密码长度："+passwordLength);
            }
        });

        binding.loginInputVerifyCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Logger.logInfo(" " + start + " " + before + " " + count + " , " + phoneNumberLength + " " +
                        passwordLength + " " + verifyCodeLength);
                if (start == 3) {
                    if (getViewModel().loginState == 2) {
                        if (phoneNumberLength == 11 && passwordLength >= 6 && passwordLength <= 16) {
                            binding.loginRegister.setClickable(true);
                            binding.loginRegister.setBackgroundResource(R.drawable.login_button_yellow_light);
                        }
                    }
                }
                if (count == 3) {
                    if (getViewModel().loginState == 2) {
                        if (phoneNumberLength == 11 && passwordLength >= 6 && passwordLength <= 16) {
                            binding.loginRegister.setClickable(false);
                            binding.loginRegister.setBackgroundResource(R.drawable.login_button_yellow);
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                verifyCodeLength = binding.loginInputVerifyCode.getText().length();
//                Logger.logInfo("验证码长度："+verifyCodeLength);
            }
        });
        binding.loginOther1.setOnClickListener(v -> {
            if (getViewModel().loginState == 1) {
                getViewModel().loginState = 0;
            } else {
                getViewModel().loginState = 1;
            }
            changeState();
        });
        binding.loginOther2.setOnClickListener(v -> {
            if (getViewModel().loginState == 0) {
                getViewModel().loginState = 2;
                changeState();
            } else if (getViewModel().loginState == 1) {
                cleanFocus();
                forgetPassword(2);
            } else {
                getViewModel().loginState = 0;
                changeState();
            }
        });
        binding.getRoot().setOnClickListener(v -> {
            cleanFocus();
        });
        binding.loginLl.setOnClickListener(v -> {
            cleanFocus();
        });
        binding.loginGetVerifyCode.setOnClickListener(v -> {
            cleanFocus();
            if (CheckUtils.checkPhoneNumber(binding.loginInputPhone.getText().toString())) {
                forgetPassword(1);
            } else {
                Toast.makeText(this, "手机号格式错误，请检查", Toast.LENGTH_SHORT).show();
            }

        });
        binding.loginLogin.setOnClickListener(v -> {
            cleanFocus();
            // 网络请求去登录
            if (CheckUtils.checkPhoneNumber(binding.loginInputPhone.getText().toString())) {
                getViewModel().login(binding.loginInputPhone.getText().toString(),
                        binding.loginInputPassword.getText().toString());
            } else {
                Toast.makeText(this, "手机号格式错误，请检查", Toast.LENGTH_SHORT).show();
            }

        });
        binding.loginRegister.setOnClickListener(v -> {
            if (getViewModel().loginState == 1) {
                getViewModel().loginState = 2;
                changeState();
            } else {
                // 网络请求注册账号
                cleanFocus();
                if (CheckUtils.checkPhoneNumber(binding.loginInputPhone.getText().toString())) {
                    getViewModel().register(binding.loginInputPhone.getText().toString(),
                            binding.loginInputPassword.getText().toString(),
                            binding.loginInputVerifyCode.getText().toString());
                } else {
                    Toast.makeText(this, "手机号格式错误，请检查", Toast.LENGTH_SHORT).show();
                }

            }
        });
        binding.loginCheckboxPassword.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                binding.loginInputPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            } else {
                binding.loginInputPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
            binding.loginInputPassword.setSelection(binding.loginInputPassword.getText().length());
        });
        binding.loginGetVerifyCodeTv.setOnClickListener(v -> {
            binding.loginGetVerifyCodeTv.setClickable(false);
            binding.loginGetVerifyCodeTv.setTextColor(Color.GRAY);

            Message message = Message.obtain();
            message.what = 1;
            message.obj = 60;
            handler.sendMessage(message);
        });
        handler.sendEmptyMessageDelayed(0, 2000);
    }

    @Override
    protected LoginViewModel initViewModel() {
        return createViewModel(LoginViewModel.class);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void handlerMsg(Message msg) {
        Logger.logInfo("消息的what：" + msg.what);
        if (msg.what == 0) {
            //TODO:如果已经登陆成功这里跳转Main，而不必切换视图显示了
            if (getViewModel().isLogin()) {
                loginSuccess();
                return;
            }
            changeDefault();
            changeState();
            changeBg(false);
        }
        if (msg.what == 1) {
            int number = Integer.parseInt(msg.obj.toString());
            Logger.logInfo("消息的obj：" + number);
            if (number > 0) {
                if (number == 60) {
                    binding.loginGetVerifyCodeTv.setText(
                            getString(R.string.login_resend_verify_code) + "(" + number + ")");
                } else {
                    String s = binding.loginGetVerifyCodeTv.getText().toString();
                    binding.loginGetVerifyCodeTv.setText(s.replace((number + 1) + "", "" + number));
                }
            }

            if (number == 0) {
                binding.loginGetVerifyCodeTv.setClickable(true);
                binding.loginGetVerifyCodeTv.setTextColor(Color.WHITE);
                binding.loginGetVerifyCodeTv.setText(R.string.login_button_get_verify);
                handler.removeMessages(1);
            } else {
                number--;
                Message message = Message.obtain();
                message.what = msg.what;
                message.obj = number;
                handler.sendMessageDelayed(message, 1000);
            }

        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        Logger.logInfo("焦点变化：" + hasFocus);
        getViewModel().isEditFocus.setValue(hasFocus);
        if (hasFocus) {
            changeBg(true);
        }
    }

    private void cleanFocus() {
//        Logger.logInfo("清除焦点");
        binding.loginInputPhone.clearFocus();
        binding.loginInputVerifyCode.clearFocus();
        binding.loginInputPassword.clearFocus();
        InputMethodManager manager =
                (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        if (manager.isActive()) {
            if (getViewModel().loginState >= 0) {
                manager.hideSoftInputFromWindow(binding.loginInputPhone.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
            if (getViewModel().loginState >= 1) {
                manager.hideSoftInputFromWindow(binding.loginInputPassword.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
            if (getViewModel().loginState >= 2) {
                manager.hideSoftInputFromWindow(binding.loginInputVerifyCode.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
        changeBg(false);
    }

    private void changeState() {
        Logger.logInfo(getViewModel().loginState + "  ");
        switch (getViewModel().loginState) {
            case 1:
                binding.loginTitle.setVisibility(View.VISIBLE);
                binding.loginTitleTip.setVisibility(View.GONE);
                binding.loginInputPhone.setVisibility(View.VISIBLE);
                binding.loginInputVerifyCodeFm.setVisibility(View.GONE);
//                binding.loginInputVerifyCode.setVisibility(View.GONE);
                binding.loginInputPasswordFm.setVisibility(View.VISIBLE);
//                binding.loginInputPassword.setVisibility(View.VISIBLE);
                binding.loginGetVerifyCode.setVisibility(View.GONE);
                binding.loginLogin.setVisibility(View.VISIBLE);
                binding.loginRegister.setVisibility(View.VISIBLE);
                binding.loginRegister.setClickable(true);

                binding.loginTitle.setText(R.string.login_title_password);
                binding.loginOther1.setText(R.string.login_button_verify);
                binding.loginOther2.setText(R.string.login_button_forget_password);
                binding.loginRegister.setTextColor(Color.WHITE);
                binding.loginRegister.setBackgroundResource(R.drawable.login_button_white);
                if (phoneNumberLength == 11 && passwordLength >= 6 && passwordLength <= 16) {
                    binding.loginLogin.setClickable(true);
                    binding.loginLogin.setBackgroundResource(R.drawable.login_button_yellow_light);
                } else {
                    binding.loginLogin.setClickable(false);
                    binding.loginLogin.setBackgroundResource(R.drawable.login_button_yellow);
                }
                break;
            case 2:
                binding.loginTitle.setVisibility(View.VISIBLE);
                binding.loginTitleTip.setVisibility(View.GONE);
                binding.loginInputPhone.setVisibility(View.VISIBLE);
                binding.loginInputVerifyCodeFm.setVisibility(View.VISIBLE);
//                binding.loginInputVerifyCode.setVisibility(View.VISIBLE);
                binding.loginInputPasswordFm.setVisibility(View.VISIBLE);
//                binding.loginInputPassword.setVisibility(View.VISIBLE);
                binding.loginGetVerifyCode.setVisibility(View.GONE);
                binding.loginLogin.setVisibility(View.GONE);
                binding.loginRegister.setVisibility(View.VISIBLE);
                binding.loginRegister.setClickable(false);

                binding.loginTitle.setText(R.string.login_title_register);
                binding.loginOther1.setText(R.string.login_title_password);
                binding.loginOther2.setText(R.string.login_button_verify);
                binding.loginRegister.setTextColor(R.color.login_button);
                binding.loginRegister.setBackgroundResource(R.drawable.login_button_yellow);
                if (phoneNumberLength == 11 && passwordLength >= 6 && passwordLength <= 16
                        && verifyCodeLength == 4) {
                    binding.loginRegister.setClickable(true);
                    binding.loginRegister.setBackgroundResource(R.drawable.login_button_yellow_light);
                } else {
                    binding.loginRegister.setClickable(false);
                    binding.loginRegister.setBackgroundResource(R.drawable.login_button_yellow);
                }
                break;
            default:
                binding.loginTitle.setVisibility(View.VISIBLE);
                binding.loginTitleTip.setVisibility(View.VISIBLE);
                binding.loginInputPhone.setVisibility(View.VISIBLE);
                binding.loginInputVerifyCodeFm.setVisibility(View.GONE);
//                binding.loginInputVerifyCode.setVisibility(View.GONE);
                binding.loginInputPasswordFm.setVisibility(View.GONE);
//                binding.loginInputPassword.setVisibility(View.GONE);
                binding.loginGetVerifyCode.setVisibility(View.VISIBLE);
                binding.loginLogin.setVisibility(View.GONE);
                binding.loginRegister.setVisibility(View.GONE);
                binding.loginGetVerifyCode.setClickable(false);
                binding.loginLogin.setClickable(false);
                binding.loginRegister.setClickable(false);

                binding.loginTitle.setText(R.string.login_title_verify);
                binding.loginOther1.setText(R.string.login_title_password);
                binding.loginOther2.setText(R.string.login_title_register);
                if (phoneNumberLength == 11) {
                    binding.loginGetVerifyCode.setClickable(true);
                    binding.loginGetVerifyCode.setBackgroundResource(R.drawable.login_button_yellow_light);
                } else {
                    binding.loginGetVerifyCode.setClickable(false);
                    binding.loginGetVerifyCode.setBackgroundResource(R.drawable.login_button_yellow);
                }
        }
    }

    private void changeDefault() {
        binding.welcomeBg.setVisibility(View.GONE);
        binding.loginLl.setVisibility(View.VISIBLE);
        Glide.with(this).asGif().load(R.mipmap.login_bg).centerCrop()
                .into(binding.loginBg);
        Glide.with(this).asGif().load(R.mipmap.login_bg).centerCrop()
                .transform(new BlurTransformation()).into(binding.loginBgFocus);
    }

    private void changeBg(boolean focus) {
        binding.loginBgFocus.setVisibility(focus ? View.VISIBLE : View.GONE);
        binding.loginBg.setVisibility(focus ? View.GONE : View.VISIBLE);
    }

    /**
     * 跳转到忘记密码或者验证码输入界面
     *
     * @param type 1：验证码输入，2：忘记密码
     */
    private void forgetPassword(int type) {
        Logger.logDebug("获取验证码=1,忘记密码=2, 本次type = " + type);
        if (type == 1) {
            ARouter.getInstance().build(MainPath.MAIN_VERIFY).withInt("type", type).withString("phone",
                    binding.loginInputPhone.getText().toString()).navigation();
        } else {
            ARouter.getInstance().build(MainPath.MAIN_FORGET).withInt("type", type).withString("phone",
                    binding.loginInputPhone.getText().toString()).navigation();
        }
    }

    private void loginSuccess() {
        ARouter.getInstance().build(MainPath.MAIN_HOME).navigation();
        ActivityUtils.get().removeAll();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (back()) {
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    private boolean back() {
        if (getViewModel().loginState != 0) {
            getViewModel().loginState = 0;
            changeState();
            return true;
        }
        return false;
    }
}