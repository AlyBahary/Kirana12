package com.example.bahary.kirana12.HomeFragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.bahary.kirana12.ItemDescriptionActivity;
import com.example.bahary.kirana12.MainCategoryActivity;
import com.example.bahary.kirana12.Models.HomeItemsModel;
import com.example.bahary.kirana12.R;
import com.example.bahary.kirana12.RecyclerView.FirstImagesAdapter;
import com.example.bahary.kirana12.Utils.Constants;
import com.example.bahary.kirana12.categoryItemsActivties;

import java.util.ArrayList;

import cn.iwgang.countdownview.CountdownView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    RecyclerView mitemHomeItemRV,mitemHomeItemRV1,mitemHomeItemRV2,mitemHomeItemRV3,mitemHomeItemRV4;
    FirstImagesAdapter mfirstImagesAdapterm,mfirstImagesAdapterm1,mfirstImagesAdapterm2,mfirstImagesAdapterm3,mfirstImagesAdapterm4;
    ArrayList<HomeItemsModel> mhomeItemsModels;
    ImageView categry1,categry2,categry3,categry4,categry5,categry6,categry7,categry8;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        CountdownView mCvCountdownView = (CountdownView)view.findViewById(R.id.cv_countdownViewTest1);
        mCvCountdownView.start(9000); // Millisecond
        mCvCountdownView.setOnCountdownEndListener(new CountdownView.OnCountdownEndListener() {
            @Override
            public void onEnd(CountdownView cv) {
                Toast.makeText(getContext(), "End", Toast.LENGTH_SHORT).show();
            }
        });

        mitemHomeItemRV=view.findViewById(R.id.home_items);
        mitemHomeItemRV1=view.findViewById(R.id.home_items1);
        mitemHomeItemRV2=view.findViewById(R.id.home_items2);
        mitemHomeItemRV3=view.findViewById(R.id.home_items3);
        mitemHomeItemRV4=view.findViewById(R.id.home_items4);
        categry1=view.findViewById(R.id.categry1);
        categry2=view.findViewById(R.id.categry2);
        categry3=view.findViewById(R.id.categry3);
        categry4=view.findViewById(R.id.categry4);
        categry5=view.findViewById(R.id.categry5);
        categry6=view.findViewById(R.id.categry6);
        categry7=view.findViewById(R.id.categry7);
        categry8=view.findViewById(R.id.categry8);
        //mitemomeItemRV1=view.findViewById(R.id.home_items1);
        //////////
        //////////
        categry1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),MainCategoryActivity.class);
                intent.putExtra(Constants.CategorieNumb,"1");
                startActivity(intent);
            }
        });
        categry2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),MainCategoryActivity.class);
                intent.putExtra(Constants.CategorieNumb,"2");
                startActivity(intent);
            }
        });
        categry3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),MainCategoryActivity.class);
                intent.putExtra(Constants.CategorieNumb,"3");
                startActivity(intent);
            }
        });
        categry4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),MainCategoryActivity.class);
                intent.putExtra(Constants.CategorieNumb,"4");
                startActivity(intent);
            }
        });
        categry5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),MainCategoryActivity.class);
                intent.putExtra(Constants.CategorieNumb,"5");
                startActivity(intent);
            }
        });
        categry6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),MainCategoryActivity.class);
                intent.putExtra(Constants.CategorieNumb,"6");
                startActivity(intent);
            }
        });
        categry7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),MainCategoryActivity.class);
                intent.putExtra(Constants.CategorieNumb,"7");
                startActivity(intent);
            }
        });
        categry8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),MainCategoryActivity.class);
                intent.putExtra(Constants.CategorieNumb,"8");
                startActivity(intent);
            }
        });
        ////////
        mhomeItemsModels=new ArrayList<>();
        mhomeItemsModels.add(new HomeItemsModel("110% Off","Lemon","1","1 unit","100$","150$"));
        mhomeItemsModels.add(new HomeItemsModel("110% Off","Lemon","2","1 unit","100$","150$"));
        mhomeItemsModels.add(new HomeItemsModel("110% Off","Lemon","3","1 unit","100$","150$"));
        mhomeItemsModels.add(new HomeItemsModel("110% Off","Lemon","4","1 unit","100$","150$"));
        mhomeItemsModels.add(new HomeItemsModel("110% Off","Lemon","5","1 unit","100$","150$"));
        mhomeItemsModels.add(new HomeItemsModel("110% Off","Lemon","6","1 unit","100$","150$"));
        mfirstImagesAdapterm=new FirstImagesAdapter(getContext(), mhomeItemsModels, 0, new FirstImagesAdapter.OnItemClick() {
            @Override
            public void setOnItemClick(int position) {
                Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getContext(), ItemDescriptionActivity.class);
                startActivity(i);
            }
        });
        mitemHomeItemRV.setAdapter(mfirstImagesAdapterm);
        mitemHomeItemRV.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.HORIZONTAL,false));
/////////////////////////////
        mfirstImagesAdapterm1=new FirstImagesAdapter(getContext(), mhomeItemsModels, 0, new FirstImagesAdapter.OnItemClick() {
            @Override
            public void setOnItemClick(int position) {
                Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getContext(), ItemDescriptionActivity.class);
                startActivity(i);
            }
        });
        mitemHomeItemRV1.setAdapter(mfirstImagesAdapterm1);
        mitemHomeItemRV1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.HORIZONTAL,false));
/////////////////////////////
        mfirstImagesAdapterm2=new FirstImagesAdapter(getContext(), mhomeItemsModels, 0, new FirstImagesAdapter.OnItemClick() {
            @Override
            public void setOnItemClick(int position) {

            }
        });
        mitemHomeItemRV2.setAdapter(mfirstImagesAdapterm2);
        mitemHomeItemRV2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.HORIZONTAL,false));
/////////////////////////////
        mfirstImagesAdapterm3=new FirstImagesAdapter(getContext(), mhomeItemsModels, 0, new FirstImagesAdapter.OnItemClick() {
            @Override
            public void setOnItemClick(int position) {

            }
        });
        mitemHomeItemRV3.setAdapter(mfirstImagesAdapterm3);
        mitemHomeItemRV3.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.HORIZONTAL,false));
/////////////////////////////
        mfirstImagesAdapterm4=new FirstImagesAdapter(getContext(), mhomeItemsModels, 0, new FirstImagesAdapter.OnItemClick() {
            @Override
            public void setOnItemClick(int position) {

            }
        });
        mitemHomeItemRV4.setAdapter(mfirstImagesAdapterm4);
        mitemHomeItemRV4.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.HORIZONTAL,false));
        return view;
    }

}
