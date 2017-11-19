package com.livessolutions.mybeerservice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.livessolutions.mybeerservice.fragment.MainFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                                //Ctl ??? Click


//        Add Fragment To Activity
        if (savedInstanceState == null) {
//              Status True
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentFragmentMain, new MainFragment()).commit();
        } //if

//          Drawer Controller
        drawerController();



    }   // Main Method
    //Crl Alt M
    private void drawerController() {
        TextView mainTextView = findViewById(R.id.txtMain);
        TextView secondTextView = findViewById(R.id.txtSecond);
        TextView exiTextView = findViewById(R.id.txtExit);

        mainTextView.setOnClickListener(this);
        secondTextView.setOnClickListener(this);
        exiTextView.setOnClickListener(this);


}   // Main Class

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.txtMain:

                break;
            case R.id.txtSecond:

                break;

            case R.id.txtExit:

                break;

        }

    }

    }
