package com.livessolutions.mybeerservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.livessolutions.mybeerservice.R;
import com.livessolutions.mybeerservice.utility.GetJSON;
import com.livessolutions.mybeerservice.utility.MyConstand;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Admins on 11/18/17.
 */

public class SecondFragment extends Fragment{
    // Explisit
    private String jsonString, dateString,rateString,
             usdString, anserString;

    private String jsonRateString;
    private double rateADouble;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
//        Read All JSON to Class
        readJSON();
//        Show Date
        showDate();
//        Show Rate
        showRate();
//      Exchange Controller
        exchangeController();


    }// Main Method

    private void exchangeController() {

        Button button = getView().findViewById(R.id.btnExchange);

        button.setOnClickListener(new View.OnClickListener() {
               //Ctrl Enter           //Alt Enter Red auto Gen Overide
            @Override
            public void onClick(View v) {

                EditText editText = getView().findViewById(R.id.editUSD);
                usdString = editText.getText().toString().trim();
                if (usdString.isEmpty()) {
//                    Have Space
                    Toast.makeText(getActivity(),"Please Fill Thai Bath ",
                            Toast.LENGTH_SHORT).show();


                } else {

//                      No Space

                    double usdAdouble = Double.parseDouble(usdString);
                    double answerAdouble = usdAdouble * rateADouble;

                    TextView textView = getView().findViewById(R.id.txtAnswer);
                    textView.setText(Double.toString(answerAdouble) + " THB");

                }



            }
        });
    }

    private void showRate() {
        TextView textView = getView().findViewById(R.id.txtShowRate);
        try {

            JSONArray jsonArray = new JSONArray(jsonRateString);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            rateADouble = jsonObject.getDouble("THB");
            Log.d("19novV1", "rateAdou == " + rateADouble);

            textView.setText(getText(R.string.rate) + " : " + Double.toString(rateADouble));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showDate() {
        TextView textView = getView().findViewById(R.id.txtShowDate);

        try {

            JSONArray jsonArray = new JSONArray("[" + jsonString + "]");
            JSONObject jsonObject = jsonArray.getJSONObject(0);

            dateString = jsonObject.getString("date");
            Log.d("19novV1", "Date == > " + dateString);

            textView.setText(getText(R.string.date) + " : " + dateString);
            jsonRateString = "[" + jsonObject.getString("rates") + "]";
            Log.d("19novV1", "jsonRate == > " + jsonRateString);


        } catch (Exception e) {
            e.printStackTrace();

        }




    }

    private void readJSON() {

        String tag = "19novV1";
        MyConstand myConstant = new MyConstand();



        try {

            GetJSON getJSON = new GetJSON(getActivity());
            getJSON.execute(myConstant.getUrlJSON());

            jsonString = getJSON.get();
            Log.d(tag, "JSON == > "+ jsonString);


        } catch (Exception e) {
            Log.d(tag, "e == > " + e.toString());

        }

        // (Exception e) shit Ctrl Enter
    }

    //    Create View
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second,container,false);
        return view;


    }

}   // Main Class
