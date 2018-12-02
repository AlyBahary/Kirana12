package com.example.bahary.kirana12.NavItemsActivities;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bahary.kirana12.Dialoge.OrderConfirmationDialoge;
import com.example.bahary.kirana12.Models.ORDERMODEL;
import com.example.bahary.kirana12.Models.ProductsModel;
import com.example.bahary.kirana12.R;
import com.example.bahary.kirana12.RecyclerView.FirstImagesAdapter;
import com.example.bahary.kirana12.RecyclerView.OrderListAdapter;
import com.example.bahary.kirana12.Utils.Constants;
import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.Collection;

public class ShoppingCartActivity extends AppCompatActivity {

    RecyclerView OrderRecyclerView;
    OrderListAdapter orderListAdapter;
    ArrayList<ORDERMODEL> orderListmodels;
    Button CheckOut;
    float SubTotal=0,Total=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        TextView bar_title = findViewById(R.id.toolbar_title);
        ImageView bar_image = findViewById(R.id.toolbarback);
        bar_title.setText("Shopping Cart");
        bar_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        CheckOut=findViewById(R.id.CheckOut);
        CheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubTotal=0;
                Total=0;
                if(orderListmodels.size()>0){
                    for(int i=0;i<orderListmodels.size();i++){
                        SubTotal= SubTotal+Float.parseFloat(orderListmodels.get(i).getTotalPrice());

                    }
                    Total=SubTotal+70;
                    OrderConfirmationDialoge cdd = new OrderConfirmationDialoge(ShoppingCartActivity.this
                            ,""+SubTotal,""+Total,orderListmodels);
                    cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    cdd.show();
                }

            }
        });
        orderListmodels = new ArrayList<>();
        OrderRecyclerView = findViewById(R.id.OrderRV);
        if (Hawk.contains(Constants.ORDER_LIST)) {
            orderListmodels.addAll((Collection<? extends ORDERMODEL>) Hawk.get(Constants.ORDER_LIST));
            orderListAdapter = new OrderListAdapter(orderListmodels, this, new OrderListAdapter.OnItemClick() {
                @Override
                public void setOnItemClick(int position) {
                    orderListmodels.remove(position);
                    Hawk.put(Constants.ORDER_LIST, orderListmodels);
                    orderListAdapter.notifyDataSetChanged();
                }
            });
            OrderRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
            OrderRecyclerView.setAdapter(orderListAdapter);
            orderListAdapter.notifyDataSetChanged();
        }
    }
}
