package com.example.bahary.kirana12.HomeFragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.bahary.kirana12.MainCategoryActivity;
import com.example.bahary.kirana12.R;
import com.example.bahary.kirana12.Utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriesFragment extends Fragment {
    LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4,linearLayout5,linearLayout6,linearLayout7,linearLayout8;


    public CategoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_categories, container, false);
        linearLayout1=view.findViewById(R.id.fragCatg1);
        linearLayout2=view.findViewById(R.id.fragCatg2);
        linearLayout3=view.findViewById(R.id.fragCatg3);
        linearLayout4=view.findViewById(R.id.fragCatg4);
        linearLayout5=view.findViewById(R.id.fragCatg5);
        linearLayout6=view.findViewById(R.id.fragCatg6);
        linearLayout7=view.findViewById(R.id.fragCatg7);
        linearLayout8=view.findViewById(R.id.fragCatg8);

          linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), MainCategoryActivity.class);
                intent.putExtra(Constants.CategorieNumb,"1");
                startActivity(intent);
            }
        });
          linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), MainCategoryActivity.class);
                intent.putExtra(Constants.CategorieNumb,"2");
                startActivity(intent);

            }
        });
          linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), MainCategoryActivity.class);
                intent.putExtra(Constants.CategorieNumb,"3");
                startActivity(intent);
            }
        });
          linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), MainCategoryActivity.class);
                intent.putExtra(Constants.CategorieNumb,"4");
                startActivity(intent);
            }
        });
          linearLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), MainCategoryActivity.class);
                intent.putExtra(Constants.CategorieNumb,"5");
                startActivity(intent);
            }
        });
          linearLayout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), MainCategoryActivity.class);
                intent.putExtra(Constants.CategorieNumb,"6");
                startActivity(intent);
            }
        });
          linearLayout7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), MainCategoryActivity.class);
                intent.putExtra(Constants.CategorieNumb,"7");
                startActivity(intent);
            }
        });
          linearLayout8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), MainCategoryActivity.class);
                intent.putExtra(Constants.CategorieNumb,"8");
                startActivity(intent);
            }
        });
        return view;
    }

}
