package com.myfirst.fragmentstotalapplecounts;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TotalApplesFragment extends Fragment {

    private EditText mEtTotal;
    private TextView mTvTotal;
    private Button mBtnNext;
    private ClickListener clickListener;
    private int totalApplesRemaining;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        clickListener = (ClickListener) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            totalApplesRemaining = getArguments().getInt("remaining");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_total_apples, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mEtTotal = view.findViewById(R.id.etTotal);
        mTvTotal = view.findViewById(R.id.tvTotal);
        mBtnNext = view.findViewById(R.id.next);
        mTvTotal.setText(totalApplesRemaining + "");
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                int total = Integer.parseInt(mEtTotal.getText().toString());
                bundle.putInt("apples",total);
                clickListener.onClick(bundle);
            }
        });
    }
}