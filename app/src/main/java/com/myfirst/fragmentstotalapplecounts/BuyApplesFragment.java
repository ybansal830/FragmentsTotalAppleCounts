package com.myfirst.fragmentstotalapplecounts;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class BuyApplesFragment extends Fragment {

    private EditText mEtBuy;
    private ClickListener clickListener;
    private int totalApples;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        clickListener = (ClickListener) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        totalApples = getArguments().getInt("apples");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buy_apples, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEtBuy = view.findViewById(R.id.etBuy);
    }

    @Override
    public void onPause() {
        super.onPause();
        int buy = Integer.parseInt(mEtBuy.getText().toString());
        if(buy <= totalApples){
            int remaining = totalApples - buy;
            Bundle bundle = new Bundle();
            bundle.putInt("remaining",remaining);
            clickListener.onBack(bundle);
        }
        else{
           int remaining  = totalApples;
           Bundle bundle = new Bundle();
           bundle.putInt("remaining",remaining);
           clickListener.onBack(bundle);
        }
    }
}