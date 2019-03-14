package com.lasalle.midterm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        prepareData();
        fillUpData();
    }

    private void prepareData() {
        transportType = 0;
        kmBusMetro = 0;
        kmPrivateTaxi = 0;
        totalClients = 0;
        for(int i = 0; i < clients.size();i++){
            transportType = clients.get(i).getTrans_type();
            switch (transportType){
                case 1:
                    totalBusMetro += clients.get(i).getCl_number();
                    kmBusMetro += clients.get(i).getNb_km();
                    break;
                case 2:
                    totalBusMetro += clients.get(i).getCl_number();
                    kmBusMetro += clients.get(i).getNb_km();
                    break;
                case 3:
                    totalPrivateTaxi += clients.get(i).getCl_number();
                    kmPrivateTaxi += clients.get(i).getNb_km();
                    break;
                case 4:
                    totalPrivateTaxi += clients.get(i).getCl_number();
                    kmPrivateTaxi += clients.get(i).getNb_km();
                    break;
                default:
                    break;
            }
        }

        percentageBusMetro = totalBusMetro /kmBusMetro;
        percentagePrivateTaxi = totalPrivateTaxi /kmPrivateTaxi;
        totalClients = totalBusMetro + totalPrivateTaxi;


    }

    private void fillUpData() {
        textViewTotalBusMetro.setText(String.valueOf(percentageBusMetro));
        textViewTotalPrivateTaxi.setText(String.valueOf(percentagePrivateTaxi));
        textViewPercentageBusMetro.setText(String.valueOf((totalBusMetro / totalClients) * 100));
        textViewPercentagePrivateTaxi.setText(String.valueOf((totalPrivateTaxi / totalClients) * 100));



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
