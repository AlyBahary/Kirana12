package com.example.bahary.kirana12;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bahary.kirana12.HomeFragments.HomeFragment;
import com.example.bahary.kirana12.Models.ExampleMainFactorModel;
import com.example.bahary.kirana12.Models.ExampleProductsModel;
import com.example.bahary.kirana12.Models.HomeItemsModel;
import com.example.bahary.kirana12.Models.Manufacturer;
import com.example.bahary.kirana12.Models.ProductsModel;
import com.example.bahary.kirana12.RecyclerView.FirstImagesAdapter;
import com.example.bahary.kirana12.Utils.Connectors;
import com.example.bahary.kirana12.Utils.Constants;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class categoryItemsActivties extends AppCompatActivity {
    RecyclerView mitemCategryItemRV;
    FirstImagesAdapter mfirstImagesAdapterm;
    ArrayList<ProductsModel> mCategryItemsModels;
    TextView bar_title;
    ImageView toolbarback;
    String id, type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_items_activties);
        bar_title = findViewById(R.id.toolbar_title);
        bar_title.setText("Category1");
        toolbarback = findViewById(R.id.toolbarback);
        toolbarback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Bundle extras = getIntent().getExtras();
        id = extras.getString(Constants.Item_ID_Bundle);
        type = extras.getString(Constants.Item_Type_Bundle);

        mitemCategryItemRV = findViewById(R.id.CategoryRV);
        mCategryItemsModels = new ArrayList<>();
        getProductItems(id+"" ,type+"");
        mfirstImagesAdapterm = new FirstImagesAdapter(this,getApplicationContext(), mCategryItemsModels, 1, new FirstImagesAdapter.OnItemClick() {
            @Override
            public void setOnItemClick(int position) {
                Intent intent=new Intent(getApplicationContext(),ItemDescriptionActivity.class);
                intent.putExtra("Item_Desctibtion_ID_Bundle",mCategryItemsModels.get(position).getId());
                startActivity(intent);

            }
        });
        mitemCategryItemRV.setAdapter(mfirstImagesAdapterm);
        mitemCategryItemRV.setLayoutManager(new GridLayoutManager(categoryItemsActivties.this, 2));
//
    }

    private void getProductItems(String id, String type) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Connectors.getProductsServices.BaseURL)
                .addConverterFactory(GsonConverterFactory
                        .create(new Gson())).build();
        Connectors.getProductsServices getProductsServices = retrofit.create(Connectors.getProductsServices.class);
        if (type.equals("MANUFACT")) {
            getProductsServices.getProductsByManufac(id + "").enqueue(new Callback<ExampleProductsModel>() {
                @Override
                public void onResponse(Call<ExampleProductsModel> call, Response<ExampleProductsModel> response) {
                    ExampleProductsModel exampleProductsModel = response.body();
                    ArrayList<ProductsModel> productsModels = new ArrayList<>();
                    if (exampleProductsModel != null) {
                        productsModels = exampleProductsModel.getProducts();
                    }
                    Log.d("Response_products", "onResponse: " + productsModels.size() + productsModels.get(0).getImage());

                    categoryItemsActivties.this.mCategryItemsModels.addAll(productsModels);
                    mfirstImagesAdapterm.notifyDataSetChanged();


                }

                @Override
                public void onFailure(@NonNull Call<ExampleProductsModel> call, Throwable t) {

                }
            });
        }
        else if(type.equals("SUBCAT")){
            getProductsServices.getProductsBySubCat(id+"").enqueue(new Callback<ExampleProductsModel>() {
                @Override
                public void onResponse(@NonNull Call<ExampleProductsModel> call, @NonNull Response<ExampleProductsModel> response) {
                    ExampleProductsModel exampleProductsModel = response.body();
                    ArrayList<ProductsModel> productsModels = new ArrayList<>();
                    if (exampleProductsModel != null) {
                        productsModels = exampleProductsModel.getProducts();
                    }
                    Log.d("Response_products", "onResponse: " + productsModels.size() + productsModels.get(0).getImage());

                    categoryItemsActivties.this.mCategryItemsModels.addAll(productsModels);
                    mfirstImagesAdapterm.notifyDataSetChanged();


                }

                @Override
                public void onFailure(Call<ExampleProductsModel> call, Throwable t) {

                }
            });
        }

        }
    }



