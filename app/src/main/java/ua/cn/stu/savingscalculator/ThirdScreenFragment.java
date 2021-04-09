package ua.cn.stu.savingscalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ThirdScreenFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_thirdscreen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        TextView Sy = view.findViewById(R.id.Sy);
        TextView Sc = view.findViewById(R.id.Sc);
        TextView W = view.findViewById(R.id.W);
        TextView Sh = view.findViewById(R.id.Sh);
        TextView Sl = view.findViewById(R.id.Sl);
        TextView H = view.findViewById(R.id.H);
        TextView r = view.findViewById(R.id.R);

        Calculations calculations = new Calculations();

        Sy.setText(String.valueOf(calculations.getSy((int)FirstScreenFragment.getProfitPerMonth())));
        Sc.setText(String.valueOf(calculations.getSc()));
        W.setText(String.valueOf(Math.round(calculations.getW(SecondScreenFragment.getSelectedCurrency()))));
        Sh.setText(String.valueOf((Math.round(calculations.getSh(SecondScreenFragment.getSelectedCurrency())))));
        Sl.setText(String.valueOf(calculations.getSl()));
        H.setText(String.valueOf(Math.round(calculations.getH(SecondScreenFragment.getSelectedCurrency()))));
        r.setText(String.valueOf(Math.round(calculations.getR(SecondScreenFragment.getSelectedCurrency()))));
        Button OKButton = view.findViewById(R.id.OKButton);
        OKButton.setOnClickListener(v->
                {
                    getFragmentManager().beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragmentContainer, new MenuFragment()).commit();
                }
        );
    }
}
