package com.example.bahary.kirana12;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bahary.kirana12.Models.CountryModel.CountryExampleModel;
import com.example.bahary.kirana12.Models.UserStatusModel;
import com.example.bahary.kirana12.Utils.Connectors;
import com.example.bahary.kirana12.Utils.Constants;
import com.google.gson.Gson;
import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistrationActivity extends AppCompatActivity {

    EditText f_name, l_name, email, pass, mobile, location, postal, newsletter;
    RadioButton Gender_M, Gender_F;
    DatePicker BD;
    String F_name, L_name, Email, Pass, Mobile, Location, Postal, Sex = "";
    int error_num = 0;
    Button signup_button;
    ArrayList<String> Country, States;
    ArrayList<String> CountryID, StatesID;
    ArrayAdapter<String> CountryAdapter, SataeAdapter;
    String countryID = "", StateID = "";

    Spinner CountrySpinner, StateSpinner;

    //birthdate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getCountries();
        //View view = getLayoutInflater().inflate( R.layout.action_bar,null);
        TextView bar_title = findViewById(R.id.toolbar_title);
        TextView sign_in = findViewById(R.id.sign_in);
        ImageView bar_image = findViewById(R.id.toolbarback);
        CountrySpinner = findViewById(R.id.CountrySpinner);
        StateSpinner = findViewById(R.id.StateSpinner);
        bar_title.setText("Sign up");
        bar_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Country = new ArrayList<>();
        Country.add("Select Country");
        States = new ArrayList<>();
        States.add("Select State");
        CountryID = new ArrayList<>();
        CountryID.add("case");
        StatesID = new ArrayList<>();
        StatesID.add("case");
        CountryAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Country);
        SataeAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, States);
        CountrySpinner.setAdapter(CountryAdapter);
        StateSpinner.setAdapter(SataeAdapter);
        SataeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        CountryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        CountrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                } else {
                    getStates(CountryID.get(position));
                    countryID = CountryID.get(position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        StateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                } else {
                    StateID = StatesID.get(position);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        signup_button = findViewById(R.id.sign_up_button);
        signup_button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongViewCast")
            @Override
            public void onClick(View view) {
                f_name = findViewById(R.id.input_first_name_Registration);
                F_name = f_name.getText().toString();
                l_name = findViewById(R.id.input_last_name_Registration);
                L_name = l_name.getText().toString();
                email = findViewById(R.id.input_Email_Registration);
                Email = email.getText().toString();
                pass = findViewById(R.id.input_pass);
                Pass = pass.getText().toString();
                mobile = findViewById(R.id.input_number_Registration);
                Mobile = mobile.getText().toString();
                location = findViewById(R.id.input_Address_Registration);
                Location = location.getText().toString();
                postal = findViewById(R.id.input_postal_Registration);
                Postal = postal.getText().toString();
                BD = findViewById(R.id.Birthday);
                Gender_M = findViewById(R.id.MR);
                Gender_F = findViewById(R.id.MS);
                if (Gender_M.isChecked()) {
                    Sex = "M";
                } else {
                    Sex = "F";
                }
                if (F_name.equals("") || F_name.equals(null)) {
                    error_num = 1;
                    View parentLayout = findViewById(android.R.id.content);
                    Snackbar.make(parentLayout, "Please Enter first name", Snackbar.LENGTH_LONG)
                            .setActionTextColor(getResources().getColor(android.R.color.holo_red_light))
                            .show();
                } else if (L_name.equals("") || L_name.equals(null)) {
                    View parentLayout = findViewById(android.R.id.content);
                    Snackbar.make(parentLayout, "Please Enter Last name", Snackbar.LENGTH_LONG)
                            .setActionTextColor(getResources().getColor(android.R.color.holo_red_light))
                            .show();
                    error_num = 2;
                } else if (Email.equals("") || Email.equals(null) || !isEmailValid(Email)) {
                    View parentLayout = findViewById(android.R.id.content);
                    Snackbar.make(parentLayout, "Please Enter Valid Email", Snackbar.LENGTH_LONG)
                            .setActionTextColor(getResources().getColor(android.R.color.holo_red_light))
                            .show();
                    error_num = 3;
                } else if (Pass.equals("") || Pass.equals(null)) {
                    error_num = 4;
                    View parentLayout = findViewById(android.R.id.content);
                    Snackbar.make(parentLayout, "Please recheck password", Snackbar.LENGTH_LONG)
                            .setActionTextColor(getResources().getColor(android.R.color.holo_red_light))
                            .show();
                } else if (Mobile.equals("") || Mobile.equals(null)) {
                    error_num = 5;
                    View parentLayout = findViewById(android.R.id.content);
                    Snackbar.make(parentLayout, "Please Enter Mobile number", Snackbar.LENGTH_LONG)
                            .setActionTextColor(getResources().getColor(android.R.color.holo_red_light))
                            .show();
                } else if (Location.equals("") || Location.equals(null)) {
                    View parentLayout = findViewById(android.R.id.content);
                    Snackbar.make(parentLayout, "Please Enter your Address", Snackbar.LENGTH_LONG)
                            .setActionTextColor(getResources().getColor(android.R.color.holo_red_light))
                            .show();
                    error_num = 6;
                } else if (Postal.equals("") || Postal.equals(null)) {
                    View parentLayout = findViewById(android.R.id.content);
                    Snackbar.make(parentLayout, "Please Enter postal code", Snackbar.LENGTH_LONG)
                            .setActionTextColor(getResources().getColor(android.R.color.holo_red_light))
                            .show();
                    error_num = 7;
                } else if (Sex.equals("") || Sex.equals(null)) {
                    View parentLayout = findViewById(android.R.id.content);
                    Snackbar.make(parentLayout, "Please Select your gender", Snackbar.LENGTH_LONG)
                            .setActionTextColor(getResources().getColor(android.R.color.holo_red_light))
                            .show();
                    error_num = 8;
                } else if (StateID.equals("")) {
                    View parentLayout = findViewById(android.R.id.content);
                    Snackbar.make(parentLayout, "Please Select youy state", Snackbar.LENGTH_LONG)
                            .setActionTextColor(getResources().getColor(android.R.color.holo_red_light))
                            .show();
                } else if (countryID.equals("")) {
                    View parentLayout = findViewById(android.R.id.content);
                    Snackbar.make(parentLayout, "Please Select your Country", Snackbar.LENGTH_LONG)
                            .setActionTextColor(getResources().getColor(android.R.color.holo_red_light))
                            .show();
                } else {
                    registrationConnector(F_name, L_name, Pass, Sex
                            , BD.getDayOfMonth() + "/" + BD.getMonth() + "/" + BD.getYear()
                            , Email, Mobile, Postal, Location, "true", StateID+"", ""+countryID, "Kotok");

                }

            }
        });


    }

    public void registrationConnector(
            String F_name
            , String L_name
            , String password
            , String gender
            , String birth_date
            , String email
            , String mobile
            , String postal
            , String address
            , String newsletter
            , String statID
            , String CountryID
            , String City) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Connectors.setNewUser.BaseURL)
                .addConverterFactory(GsonConverterFactory
                        .create(new Gson())).build();
        Connectors.setNewUser setNewUser = retrofit.create(Connectors.setNewUser.class);
        setNewUser.Registration(F_name, L_name, password, gender, birth_date, email, mobile, postal
                , address, newsletter, statID, CountryID, City).enqueue(new Callback<UserStatusModel>() {
            @Override
            public void onResponse(Call<UserStatusModel> call, Response<UserStatusModel> response) {
                UserStatusModel model = response.body();
                Hawk.put(Constants.muserFirstName,model.getUser().getFirstName());
                Hawk.put(Constants.muserLastName,model.getUser().getLastName());
                Hawk.put(Constants.muserAddress,model.getUser().getAddress());
                Hawk.put(Constants.muserDateOfBirth,model.getUser().getDateOfBirth());
                Hawk.put(Constants.muserEmail,model.getUser().getEmail());
                Hawk.put(Constants.muserGender,model.getUser().getGender());
                Hawk.put(Constants.muserMobile,model.getUser().getMobile());
                Hawk.put(Constants.musernewsletter,model.getUser().getNewsletter());
                Hawk.put(Constants.muserAdressID,model.getUser().getAddressId());
                Log.i("REGResponse", model.getStatus() + "");

            }

            @Override
            public void onFailure(Call<UserStatusModel> call, Throwable t) {


            }
        });
    }

    public void getCountries() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Connectors.setNewUser.BaseURL)
                .addConverterFactory(GsonConverterFactory
                        .create(new Gson())).build();
        Connectors.getLoginDataService setNewUser = retrofit.create(Connectors.getLoginDataService.class);
        setNewUser.Countries().enqueue(new Callback<CountryExampleModel>() {
            @Override
            public void onResponse(Call<CountryExampleModel> call, Response<CountryExampleModel> response) {
                Log.d("TTTT", "onResponse: "+response.toString()+"---");
                Log.d("TTTT", "onResponse: "+response.body().getCountries().get(0).getName());
                CountryExampleModel countryExampleModel = response.body();
                for (int i = 0; i < countryExampleModel.getCountries().size(); i++) {
                    Country.add(countryExampleModel.getCountries().get(i).getName());
                    CountryID.add(countryExampleModel.getCountries().get(i).getId() + "");
                }
                CountryAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<CountryExampleModel> call, Throwable t) {
                View parentLayout = findViewById(android.R.id.content);
                Snackbar.make(parentLayout, "Please Check your internet Connection", Snackbar.LENGTH_LONG)
                        .setAction("CLOSE", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            }
                        })
                        .setActionTextColor(getResources().getColor(android.R.color.holo_red_light))
                        .show();

            }
        });


    }

    public void getStates(String country_id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Connectors.setNewUser.BaseURL)
                .addConverterFactory(GsonConverterFactory
                        .create(new Gson())).build();
        Connectors.getLoginDataService setNewUser = retrofit.create(Connectors.getLoginDataService.class);
        setNewUser.States(country_id).enqueue(new Callback<CountryExampleModel>() {
            @Override
            public void onResponse(Call<CountryExampleModel> call, Response<CountryExampleModel> response) {
                CountryExampleModel countryExampleModel = response.body();
                for (int i = 0; i < countryExampleModel.getCountries().size(); i++) {
                    States.add(countryExampleModel.getCountries().get(i).getName());
                    StatesID.add(countryExampleModel.getCountries().get(i).getId() + "");
                }
                SataeAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<CountryExampleModel> call, Throwable t) {
                View parentLayout = findViewById(android.R.id.content);
                Snackbar.make(parentLayout, "Please Check your internet Connection", Snackbar.LENGTH_LONG)
                        .setActionTextColor(getResources().getColor(android.R.color.holo_red_light))
                        .show();


            }
        });
    }

    public boolean isEmailValid(String email) {
        String regExpn =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches())
            return true;
        else
            return false;
    }
}
