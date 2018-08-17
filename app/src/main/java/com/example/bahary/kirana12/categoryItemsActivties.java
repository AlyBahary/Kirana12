package com.example.bahary.kirana12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bahary.kirana12.Models.HomeItemsModel;
import com.example.bahary.kirana12.RecyclerView.FirstImagesAdapter;

import java.util.ArrayList;

public class categoryItemsActivties extends AppCompatActivity {
    RecyclerView mitemCategryItemRV;
    FirstImagesAdapter mfirstImagesAdapterm;
    ArrayList<HomeItemsModel> mCategryItemsModels;
    TextView bar_title ;
    ImageView toolbarback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_items_activties);
        bar_title=findViewById(R.id.toolbar_title);
        bar_title.setText("Category1");
        toolbarback=findViewById(R.id.toolbarback);
        toolbarback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

       mitemCategryItemRV=findViewById(R.id.CategoryRV);
        mCategryItemsModels=new ArrayList<>();
        mCategryItemsModels.add(new HomeItemsModel("10% Off","Lemon","1","1 unit","100$","150$"));
        mCategryItemsModels.add(new HomeItemsModel("10% Off","Lemon","2","1 unit","100$","150$"));
        mCategryItemsModels.add(new HomeItemsModel("10% Off","Lemon","3","1 unit","100$","150$"));
        mCategryItemsModels.add(new HomeItemsModel("10% Off","Lemon","4","1 unit","100$","150$"));
        mCategryItemsModels.add(new HomeItemsModel("10% Off","Lemon","5","1 unit","100$","150$"));
        mCategryItemsModels.add(new HomeItemsModel("10% Off","Lemon","6","1 unit","100$","150$"));
        mfirstImagesAdapterm=new FirstImagesAdapter(getApplicationContext(), mCategryItemsModels, 1, new FirstImagesAdapter.OnItemClick() {
            @Override
            public void setOnItemClick(int position) {

            }
        });
        mitemCategryItemRV.setAdapter(mfirstImagesAdapterm);
        mitemCategryItemRV.setLayoutManager(new GridLayoutManager(categoryItemsActivties.this, 2));
//
    }
}
