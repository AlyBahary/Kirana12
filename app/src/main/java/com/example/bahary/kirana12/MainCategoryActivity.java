package com.example.bahary.kirana12;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bahary.kirana12.Utils.Constants;

import java.util.ArrayList;

public class MainCategoryActivity extends AppCompatActivity {
    ListView listView;
    TextView mainCatgName;

    Button button1, button2, button3, button4, button5, button6, button7, button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_category);
        //******
        button1 = findViewById(R.id.mainCatgButton1);
        button2 = findViewById(R.id.mainCatgButton2);
        button3 = findViewById(R.id.mainCatgButton3);
        button4 = findViewById(R.id.mainCatgButton4);
        button5 = findViewById(R.id.mainCatgButton5);
        button6 = findViewById(R.id.mainCatgButton6);
        button7 = findViewById(R.id.mainCatgButton7);
        button8 = findViewById(R.id.mainCatgButton8);
        /////
        listView = (ListView) findViewById(R.id.mainCatglist);
        /////
        mainCatgName=findViewById(R.id.mainCatgName);
        mainCatgName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //******
        final String falg;
        falg = getIntent().getStringExtra(Constants.CategorieNumb);
        changeState(falg);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeState("1");

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeState("2");

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeState("3");

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeState("4");

            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeState("5");

            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeState("6");

            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeState("7");

            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeState("8");

            }
        });

        TextView bar_title = findViewById(R.id.toolbar_title);
        ImageView bar_image = findViewById(R.id.toolbarback);
        bar_title.setText("Shop By category");
        bar_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //*******
    }

    public void changeState(String falg) {
        ArrayList<String> values = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.maincateglistitem, R.id.mainCatgListName, values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) listView.getItemAtPosition(position);

                Intent i=new Intent(MainCategoryActivity.this,categoryItemsActivties.class);
                startActivity(i);

            }

        });

        if (falg.equals("1")) {
            adapter.clear();
            adapter.add("TExt1");
            adapter.add("TExt2");
            adapter.add("TExt3");
            adapter.add("TExt4");
            adapter.add("TExt5");
            adapter.notifyDataSetChanged();
        } else if (falg.equals("2")) {
            adapter.clear();
            adapter.add("TExt2");
            adapter.add("TExt2");
            adapter.notifyDataSetChanged();
        } else if (falg.equals("3")) {
            adapter.clear();
            adapter.add("TExt3");
            adapter.add("TExt3");
            adapter.notifyDataSetChanged();
        } else if (falg.equals("4")) {
            adapter.clear();
            adapter.add("TExt4");
            adapter.add("TExt4");
            adapter.notifyDataSetChanged();
        } else if (falg.equals("5")) {
            adapter.clear();
            adapter.add("TExt5");
            adapter.add("TExt5");
            adapter.notifyDataSetChanged();
        } else if (falg.equals("6")) {
            adapter.clear();
            adapter.add("TExt6");
            adapter.add("TExt6");
            adapter.notifyDataSetChanged();
        } else if (falg.equals("7")) {
            adapter.clear();
            adapter.add("TExt7");
            adapter.add("TExt7");
            adapter.notifyDataSetChanged();
        } else if (falg.equals("8")) {
            adapter.clear();
            adapter.add("TExt8");
            adapter.add("TExt8");
            adapter.notifyDataSetChanged();
        }


    }

}


