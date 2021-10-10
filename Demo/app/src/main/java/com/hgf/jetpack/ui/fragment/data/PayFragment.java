package com.hgf.jetpack.ui.fragment.data;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hgf.jetpack.R;
import com.hgf.jetpack.ui.base.BaseFragment;
import com.hgf.jetpack.ui.fragment.data.dummy.DummyContent;
import com.hgf.jetpack.utils.ILog;

/**
 * @author :huangguofeng
 * date    :2020/7/3
 * package :com.hgf.jetpack.ui.fragment.data
 * desc    :支付带列表的fragment
 */
public class PayFragment extends BaseFragment {
    private static final String LOG_TAG = "PayFragment :";
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    private PayFragment() {
        ILog.logInfo(LOG_TAG + "实例化 ： ");
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static PayFragment newInstance(int columnCount) {
        PayFragment fragment = new PayFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pay_list, container, false);
        ILog.logInfo(LOG_TAG + "实例化 ： ");
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new PayItemRecyclerViewAdapter(DummyContent.ITEMS));
        }
        return view;
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