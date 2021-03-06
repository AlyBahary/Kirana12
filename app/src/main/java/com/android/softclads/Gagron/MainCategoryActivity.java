package com.android.softclads.Gagron;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.softclads.Gagron.Models.CategoryModel;
import com.android.softclads.Gagron.Models.ExampleCatgModel;
import com.android.softclads.Gagron.Models.ExampleSubCatgModel;
import com.android.softclads.Gagron.RecyclerView.CategroiesAdapter;
import com.android.softclads.Gagron.Utils.Connectors;
import com.android.softclads.Gagron.Utils.Constants;
import com.google.gson.Gson;
import com.orhanobut.hawk.Hawk;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainCategoryActivity extends AppCompatActivity {
    RecyclerView listView;
    TextView mainCatgName;
    RecyclerView CategryRV;

    CategroiesAdapter mCategroiesAdapter, mSubCatrgriesAdapter;
    ArrayList<CategoryModel> categoryModels, SubSubcatgryModel;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_category);
        pd = new ProgressDialog(this);
        pd.setMessage("Loading..");
        pd.show();
        //******

        categoryModels = new ArrayList<>();
        SubSubcatgryModel = new ArrayList<>();
        mainCatgName = findViewById(R.id.mainCatgName);
        mainCatgName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        categoryModels = Hawk.get("mMainCategriesResponse");
        CategryRV = findViewById(R.id.Main_Categories_Activity_RV);
        mCategroiesAdapter = new CategroiesAdapter(categoryModels, getApplicationContext(), "2", new CategroiesAdapter.OnItemClick() {
            @Override
            public void setOnItemClick(int position) {
                getSubCatgries(categoryModels.get(position).getId() + "");
            }
        });
        CategryRV.setAdapter(mCategroiesAdapter);
        CategryRV.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        /////
        listView = findViewById(R.id.mainCatglist);
        mSubCatrgriesAdapter = new CategroiesAdapter(SubSubcatgryModel, getApplicationContext(), "3", new CategroiesAdapter.OnItemClick() {
            @Override
            public void setOnItemClick(int position) {
                Intent i = new Intent(getApplicationContext(), SubCatrgriesActivity.class);
                i.putExtra(Constants.SubCategorieNumb, SubSubcatgryModel.get(position).getId());
                Hawk.put(Constants.Name_name,SubSubcatgryModel.get(position).getName());

                startActivity(i);


            }
        });
        listView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        listView.setAdapter(mSubCatrgriesAdapter);
        /////

        //******
        final String falg;
        falg = getIntent().getStringExtra(Constants.CategorieNumb);
        getSubCatgries(falg + "");
        mainCatgName.setText("Sub Categries");
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
        ArrayList<CategoryModel> values = new ArrayList<>();

    }

    public void getSubCatgries(final String Catgry) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Connectors.getSubCategroiesServices.BaseURL)
                .addConverterFactory(GsonConverterFactory
                        .create(new Gson())).build();
        Connectors.getSubCategroiesServices getSubCategroiesServices = retrofit.create(Connectors.getSubCategroiesServices.class);
        getSubCategroiesServices.getSubCatries(Catgry + "").enqueue(new Callback<ExampleSubCatgModel>() {
            @Override
            public void onResponse(Call<ExampleSubCatgModel> call, Response<ExampleSubCatgModel> response) {
                pd.dismiss();
                ExampleSubCatgModel exampleCatgModel = response.body();
                ArrayList<CategoryModel> categoryModels = (ArrayList<CategoryModel>) exampleCatgModel.getSubcategories();
                Log.i("SUBCATGSize", categoryModels.get(0).getImage() + "");
                SubSubcatgryModel.clear();
                SubSubcatgryModel.addAll(categoryModels);
                mSubCatrgriesAdapter.notifyDataSetChanged();


            }

            @Override
            public void onFailure(Call<ExampleSubCatgModel> call, Throwable t) {
                pd.dismiss();
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


}


