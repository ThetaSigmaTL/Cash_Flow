package com.example.cashflow.budget.presentation;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.cashflow.R;

public class OperationCreateDialog extends DialogFragment implements DatePicker.DatePickerListener{

    Button dateView;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.operation_create_dialog, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dateView = view.findViewById(R.id.tv_date);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.tv_date:
                        DatePicker timePicker = new DatePicker();
                        timePicker.setListener(OperationCreateDialog.this);
                        timePicker.show(getActivity().getSupportFragmentManager(), "TimePicker");
                        break;
                }

            };

        };
        dateView.setOnClickListener(onClickListener);
    }

    public OperationCreateDialog (){

    }


    @Override
    public void onDateSelected(String date) {
        dateView.setText(date);
    }
}
