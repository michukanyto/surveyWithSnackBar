package com.lasalle.midterm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import model.Client;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonReturn;
    TextView textViewTotalBusMetro;
    TextView textViewTotalPrivateTaxi;
    TextView textViewPercentageBusMetro;
    TextView textViewPercentagePrivateTaxi;
    ArrayList<Client> clients;
    int totalBusMetro;
    int totalPrivateTaxi;
    float percentageBusMetro;
    float percentagePrivateTaxi;
    float finalPercentageBusMetro;
    float finalPercentagePrivateTaxi;
    Client client;
    int transportType;
    int kmBusMetro;
    int kmPrivateTaxi;
    float totalClients;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        client = new Client();
        clients = (ArrayList<Client>) getIntent().getExtras().getSerializable(StartActivity.KEY);
        initialize();
    }

    private void initialize() {
        buttonReturn = (Button) findViewById(R.id.buttonReturn);
        buttonReturn.setOnClickListener(this);
        textViewTotalBusMetro = (TextView) findViewById(R.id.textViewTotalBusMetro);
        textViewTotalPrivateTaxi = (TextView) findViewById(R.id.textViewTotalPrivateTaxi);
        textViewPercentageBusMetro = (TextView) findViewById(R.id.textViewPercentageBusMetro);
        textViewPercentagePrivateTaxi = (TextView) findViewById(R.id.textViewPercentagePrixivateTa);
        transportType = 0;
        kmBusMetro = 0;
        kmPrivateTaxi = 0;
        totalClients = 0;
        totalBusMetro = 0;
        totalPrivateTaxi = 0;
        percentageBusMetro = 0;
        percentagePrivateTaxi = 0;
        finalPercentageBusMetro = 0;
        finalPercentagePrivateTaxi = 0;
        prepareData();
        fillUpData();
    }

    private void prepareData() {
        for(int i = 0; i < clients.size(); i++){
            transportType = clients.get(i).getTrans_type();
            if (transportType == 1 || transportType == 2) {
                totalBusMetro++;
                kmBusMetro += clients.get(i).getNb_km();
                Log.i("km bus metro : ", String.valueOf(kmBusMetro));
            }else if(transportType == 3 || transportType == 4){
                totalPrivateTaxi ++;
                kmPrivateTaxi += clients.get(i).getCl_number();
            }
            Log.i("i : ",String.valueOf(i));
        }

        totalClients = totalBusMetro + totalPrivateTaxi;
        Log.i("total b/M passenger : ", String.valueOf(totalBusMetro));
        Log.i("total p/t passenger : ", String.valueOf(totalPrivateTaxi));
        Log.i("total passenger : ", String.valueOf(totalClients));
        if(kmBusMetro == 0){
            kmBusMetro = 1;
        }else if(kmPrivateTaxi == 0){
            kmPrivateTaxi = 1;
        }
        percentageBusMetro = (float) totalBusMetro /(float) kmBusMetro;
        percentagePrivateTaxi = (float) totalPrivateTaxi /(float) kmPrivateTaxi;
        finalPercentageBusMetro = (totalBusMetro / totalClients) * 100;
        finalPercentagePrivateTaxi = (totalPrivateTaxi / totalClients) * 100;
    }


    private void fillUpData() {
        textViewTotalBusMetro.setText(String.valueOf(percentageBusMetro));
        textViewTotalPrivateTaxi.setText(String.valueOf(percentagePrivateTaxi));
        textViewPercentageBusMetro.setText(finalPercentageBusMetro + " %");
        textViewPercentagePrivateTaxi.setText(finalPercentagePrivateTaxi + " %");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonReturn:
                finish();
                break;
            default:
                break;

        }

    }
}
