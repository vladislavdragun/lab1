package ua.cn.stu.savingscalculator;

import android.os.Bundle;
import android.text.NoCopySpan;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public  class Calculations {


    private List<Currency> currencyList = Arrays.asList(
            new Currency("USD", 23.6862,28.2605),
            new Currency("EUR", 26.4220,34.6375));

    public List<Currency> getCurrencylist()
    {
        return  currencyList;
    }

    public int getSy(int profitPerMonth)  //Гіпотетичний повний річний дохід у гривні (SY) без обміну валюти:
    {
        return profitPerMonth*12;
    }

   public double getSc() //Кількість гривень (Sc), витрачених на обмін валюти:
   {
       return getSy((int)FirstScreenFragment.getProfitPerMonth()) *FirstScreenFragment.getMonthPercentage();
   }

   public double getCi(int i, double Cstart, double Cend) // Інтерпольований курс
   {
        return  Cstart+ (i*((Cend-Cstart)/12));
   }

    public double getW (int currency) // Кількість валюти (W), придбаної за рік:
    {

            Currency currency1 = getCurrencylist().get(currency);
        double sum=0;
        for(int i=1;i<=12;i++)
        {
            sum+= (FirstScreenFragment.getProfitPerMonth()*FirstScreenFragment.getMonthPercentage())/getCi(i,currency1.getcStart(),currency1.getcEnd());
        }
        return  sum;

    }

    public double getSh(int currency)  // Гривнева вартість придбаної валюти (SH) на кінець року:
    {
        Currency currency1 = getCurrencylist().get(currency);
        return  getW(currency)*currency1.getcEnd();
    }

    public double getSl() // ) Гривневий залишок (SL):
    {
        return  getSy((int)FirstScreenFragment.getProfitPerMonth())-getSc();
    }

    public double getH(int currency)
    {

        return getSh(currency) +getSl();
    }

    public double getR(int currency)
    {
        return  getH(currency)-getSy((int)FirstScreenFragment.getProfitPerMonth());
    }

}

