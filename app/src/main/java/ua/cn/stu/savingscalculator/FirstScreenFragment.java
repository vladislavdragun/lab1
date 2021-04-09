package ua.cn.stu.savingscalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class    FirstScreenFragment extends Fragment {

    private  static long  profitPerMonth;
    private static double monthPercentage;

    public static long  getProfitPerMonth() {
        return profitPerMonth;
    }

    public static double getMonthPercentage() {
        return monthPercentage;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_firstscreen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        //profitPerMonth = Integer.parseInt(view.findViewById(R.id.profitPerMonth).toString());
        EditText textView1 = view.findViewById(R.id.profitPerMonth);
        EditText textView2 = view.findViewById(R.id.monthPercentage);


        Button secondScreenButton = view.findViewById(R.id.secondScreenButton);

        secondScreenButton.setOnClickListener(v ->
        {
            if(textView1.getText().toString().isEmpty())
            {
                Toast.makeText(getActivity(),"Введіть дохід за місяць",Toast.LENGTH_SHORT).show();
            }
            else if (textView2.getText().toString().isEmpty())
            {
                Toast.makeText(getActivity(),"Введіть відсоток доходу",Toast.LENGTH_SHORT).show();
            }
            else if(Long.parseLong(textView1.getText().toString())>Integer.MAX_VALUE)
            {
                Toast.makeText(getActivity(),"Значення не може перевищувати "+String.valueOf(Integer.MAX_VALUE),Toast.LENGTH_SHORT).show();
            }
            else if(Double.parseDouble(textView2.getText().toString())>1)
            {
                Toast.makeText(getActivity(),"Відсоток доходу не може бути > 1",Toast.LENGTH_SHORT).show();
            }
            else
            {
                profitPerMonth =Integer.parseInt(textView1.getText().toString());

                monthPercentage = Double.parseDouble(textView2.getText().toString());
//zxc
                getFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragmentContainer, new SecondScreenFragment()).commit();
            }
        });

    }


}
