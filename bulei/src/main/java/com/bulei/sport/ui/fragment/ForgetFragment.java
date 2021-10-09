package com.bulei.sport.ui.fragment;

import android.os.Bundle;

import com.bulei.sport.R;
import com.lib.base.ui.BasicFragment;

/**
 * @author huangguofeng
 */
public class ForgetFragment extends BasicFragment {

    public ForgetFragment() {

    }

    /**
     * 创建fg实例
     *
     * @param bundle bundle类型的参数
     * @return A new instance of fragment ForgetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ForgetFragment create(Bundle bundle) {
        ForgetFragment fragment = new ForgetFragment();
        if(bundle == null){
            bundle = new Bundle();
        }
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_forget;
    }
}