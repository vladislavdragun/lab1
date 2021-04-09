package ua.cn.stu.savingscalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class SecondScreenFragment extends Fragment {

    public static int getSelectedCurrency() {
        return selectedCurrency;
    }

    private static int selectedCurrency;
    private final List<String> currencyList = new ArrayList<String>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_secondscreen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        currencyList.add("USD");
        currencyList.add("EUR");
        Spinner currencySpinner = view.findViewById(R.id.currencySpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, new ArrayList<>(currencyList));
        currencySpinner.setAdapter(adapter);
       Button thirdScreenButton = view.findViewById(R.id.thirdScreenButton);
        thirdScreenButton.setOnClickListener(v->
                {
                    selectedCurrency = currencySpinner.getSelectedItemPosition();

                    getFragmentManager().beginTransaction()
                            .addToBackStack(null)
                           .replace(R.id.fragmentContainer, new ThirdScreenFragment()).commit();
                }
        );


    }

}
