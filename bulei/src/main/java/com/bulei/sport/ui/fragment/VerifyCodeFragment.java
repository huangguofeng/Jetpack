package com.bulei.sport.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bulei.sport.R;
import com.bulei.sport.databinding.FragmentVerifyCodeBinding;
import com.bulei.sport.ui.callback.AfCallback;
import com.bulei.sport.ui.callback.EditTextTextWatcher;
import com.bulei.sport.utils.InputUtils;
import com.lib.base.ui.BasicFragment;
import com.lib.utils.Logger;

import java.util.Objects;

/**
 * @author huangguofeng
 */
@SuppressLint("SetTextI18n")
public class VerifyCodeFragment extends BasicFragment {
    FragmentVerifyCodeBinding binding;
    int type;
    String phone;
    AfCallback callback;

    public VerifyCodeFragment() {

    }

    /**
     * 创建fg实例
     *
     * @param bundle bundle类型的参数
     * @return A new instance of fragment ForgetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VerifyCodeFragment create(Bundle bundle) {
        VerifyCodeFragment fragment = new VerifyCodeFragment();
        if(bundle == null){
            bundle = new Bundle();
        }
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getBundle().getInt("type");
        phone = getBundle().getString("phone");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentVerifyCodeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.forgetVerifyBack.setOnClickListener(v -> {
            close();
            callback.back(type);
        });

        binding.forgetVerifyCodeTip.setText(binding.forgetVerifyCodeTip.getText()+phone);
        binding.forgetSure.setClickable(false);
        binding.forgetSure.setOnClickListener(v -> {
            close();
            Logger.logInfo("手机号："+phone+" , 验证码："+binding.forgetInputVerify.getText().toString());
        });

        binding.forgetResend.setOnClickListener(v -> {
            binding.forgetResend.setClickable(false);
            close();
            Logger.logInfo("手机号："+phone+" , 验证码："+binding.forgetInputVerify.getText().toString());
        });

        binding.forgetInputVerify.setOnKeyListener((v, keyCode, event) ->
                InputUtils.getUtils().onKey(binding.forgetInputVerify,event,keyCode));
        binding.forgetInputVerify.addTextChangedListener(new EditTextTextWatcher(4,state -> {
            if(state){
                binding.forgetSure.setClickable(true);
                binding.forgetSure.setBackgroundResource(R.drawable.login_button_yellow_light);
            }else{
                binding.forgetSure.setClickable(false);
                binding.forgetSure.setBackgroundResource(R.drawable.login_button_yellow);
            }
        }));
    }
    private void close(){
        binding.forgetInputVerify.clearFocus();
        InputUtils.getUtils().closeSoftInput(Objects.requireNonNull(getActivity()),binding.forgetInputVerify);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_verify_code;
    }

    public void setCallback(AfCallback callback) {
        this.callback = callback;
    }
}