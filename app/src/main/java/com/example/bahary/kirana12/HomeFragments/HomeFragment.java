package com.example.bahary.kirana12.HomeFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.bahary.kirana12.Models.HomeItemsModel;
import com.example.bahary.kirana12.R;
import com.example.bahary.kirana12.RecyclerView.FirstImagesAdapter;

import java.util.ArrayList;

import cn.iwgang.countdownview.CountdownView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    RecyclerView mitemHomeItemRV,mitemHomeItemRV1,mitemHomeItemRV2,mitemHomeItemRV3,mitemHomeItemRV4;
    FirstImagesAdapter mfirstImagesAdapterm,mfirstImagesAdapterm1,mfirstImagesAdapterm2,mfirstImagesAdapterm3,mfirstImagesAdapterm4;
    ArrayList<HomeItemsModel> mhomeItemsModels;
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
        //mitemHomeItemRV1=view.findViewById(R.id.home_items1);
        mhomeItemsModels=new ArrayList<>();
        mhomeItemsModels.add(new HomeItemsModel("10%","Lemon","1","1 unit","100$","150$"));
        mhomeItemsModels.add(new HomeItemsModel("10%","Lemon","2","1 unit","100$","150$"));
        mhomeItemsModels.add(new HomeItemsModel("10%","Lemon","3","1 unit","100$","150$"));
        mhomeItemsModels.add(new HomeItemsModel("10%","Lemon","4","1 unit","100$","150$"));
        mhomeItemsModels.add(new HomeItemsModel("10%","Lemon","5","1 unit","100$","150$"));
        mhomeItemsModels.add(new HomeItemsModel("10%","Lemon","6","1 unit","100$","150$"));
        mfirstImagesAdapterm=new FirstImagesAdapter(getContext(),mhomeItemsModels);
        mitemHomeItemRV.setAdapter(mfirstImagesAdapterm);
        mitemHomeItemRV.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.HORIZONTAL,false));
/////////////////////////////
        mfirstImagesAdapterm1=new FirstImagesAdapter(getContext(),mhomeItemsModels);
        mitemHomeItemRV1.setAdapter(mfirstImagesAdapterm1);
        mitemHomeItemRV1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.HORIZONTAL,false));
/////////////////////////////
        mfirstImagesAdapterm2=new FirstImagesAdapter(getContext(),mhomeItemsModels);
        mitemHomeItemRV2.setAdapter(mfirstImagesAdapterm2);
        mitemHomeItemRV2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.HORIZONTAL,false));
/////////////////////////////
        mfirstImagesAdapterm3=new FirstImagesAdapter(getContext(),mhomeItemsModels);
        mitemHomeItemRV3.setAdapter(mfirstImagesAdapterm3);
        mitemHomeItemRV3.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.HORIZONTAL,false));
/////////////////////////////
        mfirstImagesAdapterm4=new FirstImagesAdapter(getContext(),mhomeItemsModels);
        mitemHomeItemRV4.setAdapter(mfirstImagesAdapterm4);
        mitemHomeItemRV4.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.HORIZONTAL,false));
        return view;
    }

}
