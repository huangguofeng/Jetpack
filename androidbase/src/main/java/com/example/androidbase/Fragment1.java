package com.example.androidbase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.lib.utils.Logger;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment1() {
        // Required empty public constructor
        Logger.logDebug("Fragment1 : " + getActivity());
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.logInfo("onCreate : " + this.getClass().getSimpleName());
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Logger.logDebug("onCreate : " + getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Logger.logInfo("onCreateView : " + this.getClass().getSimpleName());
        Logger.logDebug("onCreateView : " + getActivity());
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        view.findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireActivity(), MainActivity2.class);
                startActivityForResult(intent, 100);
            }
        });
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Logger.logInfo("onAttach : " + this.getClass().getSimpleName());
        Logger.logDebug("onAttach : " + getActivity());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Logger.logInfo("onActivityCreated : " + this.getClass().getSimpleName());
        Logger.logDebug("onActivityCreated : " + getActivity());
    }

    @Override
    public void onStart() {
        super.onStart();
        Logger.logInfo("onStart : " + this.getClass().getSimpleName());
        Logger.logDebug("onStart : " + getActivity());
    }

    @Override
    public void onResume() {
        super.onResume();
        Logger.logInfo("onResume : " + this.getClass().getSimpleName());
        Logger.logDebug("onResume : " + getActivity());
    }

    @Override
    public void onPause() {
        super.onPause();
        Logger.logInfo("onPause : " + this.getClass().getSimpleName());
    }

    @Override
    public void onStop() {
        super.onStop();
        Logger.logInfo("onStop : " + this.getClass().getSimpleName());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Logger.logInfo("onDestroyView : " + this.getClass().getSimpleName());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.logInfo("onDestroy : " + this.getClass().getSimpleName());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Logger.logInfo("onDetach : " + this.getClass().getSimpleName());
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Logger.logInfo("onActivityResult : " + this.getClass().getSimpleName() + "  " + requestCode + " " + resultCode);
    }

    public void send1() {
        Logger.logInfo("send1 : " + this.getClass().getSimpleName());
        fragmentCallback.send();
    }

    public interface FragmentCallback {
        void send();
    }

    FragmentCallback fragmentCallback;

    public void setFragmentCallback(FragmentCallback fragmentCallback) {
        this.fragmentCallback = fragmentCallback;
    }
}