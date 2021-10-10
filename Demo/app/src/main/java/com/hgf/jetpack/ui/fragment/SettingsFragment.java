package com.hgf.jetpack.ui.fragment;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.hgf.jetpack.R;
import com.hgf.jetpack.utils.ILog;

/**
 * @author :huangguofeng
 * date    :2020/7/3
 * package :com.hgf.jetpack.ui.fragment
 * desc    :程序设置fragment
 */
public class SettingsFragment extends PreferenceFragmentCompat {
    private static final String LOG_TAG = "SettingsFragment :";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String TAG;

    private SettingsFragment() {
        ILog.logInfo(LOG_TAG + "实例化 ： ");
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
    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
        fragment.setTAG(fragment.getClass().getSimpleName());
        ILog.logInfo(LOG_TAG + "TAG标记：" + fragment.getTAG());
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }

    public String getTAG() {
        return TAG;
    }

    public void setTAG(String TAG) {
        this.TAG = TAG;
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