package com.lasalle.midterm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

import model.Client;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY = "ok";
    Button buttonSave;
    Button buttonNew;
    Button buttonEnd;
    Button buttonGo;
    Button buttonLoad;
    EditText editTextClientNumber;
    EditText editTextKm;
    EditText editTextPassword;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Intent myIntent;
    ArrayList<Client> clients;
    ArrayList<Client> clientsDefault;
    int transportType;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initialize();
    }

    private void initialize() {

        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonNew = (Button) findViewById(R.id.buttonNew);
        buttonEnd = (Button) findViewById(R.id.buttonEnd);
        buttonGo = (Button) findViewById(R.id.buttonGo);
        buttonLoad = (Button) findViewById(R.id.buttonLoad);
        buttonSave.setOnClickListener(this);
        buttonNew.setOnClickListener(this);
        buttonEnd.setOnClickListener(this);
        buttonGo.setOnClickListener(this);
        buttonLoad.setOnClickListener(this);
        editTextClientNumber = (EditText) findViewById(R.id.editTextClientNumber);
        editTextKm = (EditText) findViewById(R.id.editTextKm);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupButtonTransport);
        clients = new ArrayList<Client>();
        clientsDefault = new ArrayList<Client>();
        myIntent = new Intent(this, ResultActivity.class);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonSave:
                findTransportType();
                clients.add(new Client(Integer.parseInt(editTextClientNumber.getText().toString()),
                                       transportType,
                                       Integer.parseInt(editTextKm.getText().toString())));

                Snackbar mysnackbar = Snackbar
                        .make(coordinatorLayout,editTextClientNumber.getText().toString() + transportType + editTextKm.getText().toString(), Snackbar.LENGTH_LONG);

                mysnackbar.show();
                break;
            case R.id.buttonNew:
                editTextClientNumber.setText(null);
                editTextKm.setText(null);
                editTextPassword.setText(null);
                radioGroup.clearCheck();
                break;
            case R.id.buttonEnd:
                finish();
                break;
            case R.id.buttonGo:
                myIntent.putExtra(KEY,(ArrayList<Client>) clients);
                startActivity(myIntent);
                break;
            case R.id.buttonLoad:
                fillUpClientsDefault();
                myIntent.putExtra(KEY,(ArrayList<Client>) clientsDefault);
                startActivity(myIntent);
                break;
        }

    }

    private void fillUpClientsDefault() {
        clientsDefault.add(new Client(100,1,10));
        clientsDefault.add(new Client(101,2,12));
        clientsDefault.add(new Client(102,1,14));
        clientsDefault.add(new Client(103,3,20));
        clientsDefault.add(new Client(104,1,11));
        clientsDefault.add(new Client(105,4,25));
        clientsDefault.add(new Client(106,4,20));
        clientsDefault.add(new Client(107,1,8));
    }

    private void findTransportType() {
        int idRadioButton = radioGroup.getCheckedRadioButtonId();
        switch (idRadioButton){
            case R.id.radioButtonBus:
                transportType = 1;
                break;
            case R.id.radioButtonMetro:
                transportType = 2;
                break;
            case R.id.radioButtonPrivateTransport:
                transportType = 3;
                break;
            case R.id.radioButtonTaxi:
                transportType = 4;
                break;

        }
    }
}
