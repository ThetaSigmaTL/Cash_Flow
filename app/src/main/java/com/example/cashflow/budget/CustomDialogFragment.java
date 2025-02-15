package com.example.cashflow.budget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.cashflow.R;

public class CustomDialogFragment extends DialogFragment {
    Spinner spinner;
    View rootView;
    Context context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.dialog_fragment_main, container, false);
        spinner = rootView.findViewById(R.id.dialog_spinner_category);
        initspinner();
        Toast toast = Toast.makeText(getContext(),"Пока", Toast.LENGTH_SHORT);
        toast.show();
        return rootView ;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        String [] string = getResources().getStringArray(R.array.basic_categories);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        return builder
                .setPositiveButton("Ok",null)
                .setNegativeButton("Cancel",null)
                .setView(getActivity().getLayoutInflater().inflate(R.layout.dialog_fragment_main,null))
                .create();
    }

    private void initspinner(){
        String [] items = getResources().getStringArray(R.array.basic_categories);
        ArrayAdapter <String> arrayAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, items);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }
}
