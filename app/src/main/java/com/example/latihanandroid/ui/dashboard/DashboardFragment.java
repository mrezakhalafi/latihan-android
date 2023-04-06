package com.example.latihanandroid.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.latihanandroid.R;
import com.example.latihanandroid.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    Button num1,num2,num3,num4,num5,num6,num7,num8,num9,num0,numdot,plus,min,multiply,divided,result,clear;
    TextView textPreview;
    String totalResult = "";
    int totalResultInt = 0;
    String mOperation;

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        num0 = root.findViewById(R.id.num0);
        num1 = root.findViewById(R.id.num1);
        num2 = root.findViewById(R.id.num2);
        num3 = root.findViewById(R.id.num3);
        num4 = root.findViewById(R.id.num4);
        num5 = root.findViewById(R.id.num5);
        num6 = root.findViewById(R.id.num6);
        num7 = root.findViewById(R.id.num7);
        num8 = root.findViewById(R.id.num8);
        num9 = root.findViewById(R.id.num9);
        num0 = root.findViewById(R.id.num0);
        numdot = root.findViewById(R.id.numdot);
        plus = root.findViewById(R.id.plus);
        min = root.findViewById(R.id.min);
        multiply = root.findViewById(R.id.multiply);
        divided = root.findViewById(R.id.divided);
        result = root.findViewById(R.id.result);
        clear = root.findViewById(R.id.clear);
        textPreview = root.findViewById(R.id.preview);

        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addNumber("1");

            }
        });

        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addNumber("2");

            }
        });

        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addNumber("3");

            }
        });

        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addNumber("4");

            }
        });

        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addNumber("5");

            }
        });

        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addNumber("6");

            }
        });

        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addNumber("7");

            }
        });

        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addNumber("8");

            }
        });

        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addNumber("9");

            }
        });

        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addNumber("0");

            }
        });

        numdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addNumber(".");

            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setOperation("+");

            }
        });

        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setOperation("-");

            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setOperation("x");

            }
        });

        divided.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setOperation("/");

            }
        });

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOperation.length() > 0 && totalResult.length() > 0) {
                    int number = Integer.parseInt(totalResult);
                    if (mOperation.equals("+")) {
                        totalResultInt += number;
                    } else if (mOperation.equals("-")) {
                        totalResultInt -= number;
                    } else if (mOperation.equals("x")) {
                        totalResultInt *= number;
                    } else if (mOperation.equals("/")) {
                        totalResultInt /= number;
                    }
                    totalResult = "";
                    mOperation = "";
                    textPreview.setText(String.valueOf(totalResultInt));
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalResult = "";
                mOperation = "";
                totalResultInt = 0;
                textPreview.setText("0");
            }
        });

        return root;
    }

    private void addNumber(String number) {
        totalResult += number;
        textPreview.setText(totalResult);
    }

    private void setOperation(String operation) {
        if (totalResult.length() > 0) {
            mOperation = operation;
            totalResultInt = Integer.parseInt(totalResult);
            totalResult = "";
            textPreview.setText(operation);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}