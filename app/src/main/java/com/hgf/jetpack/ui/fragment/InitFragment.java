package com.hgf.jetpack.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hgf.jetpack.R;
import com.hgf.jetpack.ui.base.BaseFragment;
import com.hgf.jetpack.utils.ILog;

/**
 * @author :huangguofeng
 * date    :2020/7/3
 * package :com.hgf.jetpack.ui.fragment
 * desc    :程序初始化的fragment
 */
public class InitFragment extends BaseFragment {
    private static final String LOG_TAG = "InitFragment :";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private InitFragment() {
        // Required empty public constructor
        ILog.logInfo(LOG_TAG + "实例化 ： " + this.getClass().getSimpleName());
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InitFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InitFragment newInstance(String param1, String param2) {
        InitFragment fragment = new InitFragment();
        fragment.setTAG(fragment.getClass().getSimpleName());
        ILog.logInfo(LOG_TAG + "TAG标记：" + fragment.getTAG());
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ILog.logInfo(LOG_TAG + "onCreate ： ");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ILog.logInfo(LOG_TAG + "onCreateView ： ");
        return inflater.inflate(R.layout.fragment_init, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ILog.logInfo(LOG_TAG + "onViewCreated ： ");
    }

    @Override
    public void onResume() {
        super.onResume();
        ILog.logInfo(LOG_TAG + "onResume ： ");
    }

    @Override
    public void onPause() {
        super.onPause();
        ILog.logInfo(LOG_TAG + "onPause ： ");
    }

    @Override
    public void onStart() {
        super.onStart();
        ILog.logInfo(LOG_TAG + "onStart ： ");
    }

    @Override
    public void onStop() {
        super.onStop();
        ILog.logInfo(LOG_TAG + "onStop ： ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ILog.logInfo(LOG_TAG + "onDestroyView ： ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ILog.logInfo(LOG_TAG + "onDestroy ： ");
    }
}