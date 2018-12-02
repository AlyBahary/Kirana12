package com.example.bahary.kirana12;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.bahary.kirana12.HomeFragments.CategoriesFragment;
import com.example.bahary.kirana12.HomeFragments.HomeFragment;
import com.example.bahary.kirana12.HomeFragments.SearchFragment;
import com.example.bahary.kirana12.HomeFragments.SupportFragment;
import com.example.bahary.kirana12.Models.CategoryModel;
import com.example.bahary.kirana12.NavItemsActivities.AboutUsActivity;
import com.example.bahary.kirana12.NavItemsActivities.AdressBook;
import com.example.bahary.kirana12.NavItemsActivities.MyAccountActivity;
import com.example.bahary.kirana12.NavItemsActivities.MyOrderActivity;
import com.example.bahary.kirana12.NavItemsActivities.NotificationActivity;
import com.example.bahary.kirana12.NavItemsActivities.ServiceAreaActivity;
import com.example.bahary.kirana12.NavItemsActivities.ShoppingCartActivity;
import com.example.bahary.kirana12.RecyclerView.CategroiesAdapter;

import java.util.ArrayList;

public class Home1Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public  AHBottomNavigation bottomNavigation;
    public AHBottomNavigationItem item2;
    public LinearLayout searchbarhome1;
    public ImageView homebar1item1, homebar1item2, homebar1item3, homebar1item4;
    public ImageView homebar2item1, homebar2item2;
    public ImageView homesection3button;
    RecyclerView CategryRV;
    CategroiesAdapter mCategroiesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);
        //********Declearaton****************
        searchbarhome1 = findViewById(R.id.searchbarhome);

        homesection3button = findViewById(R.id.homesection3button);

        //************************
/*
        searchbarhome1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomNavigation.setCurrentItem(2);
            }
        });
*/
/*\
        homesection3button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomNavigation.setCurrentItem(1);
            }
        });
*/
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        final HomeFragment homeFragment = new HomeFragment();
        homeFragment.setOnSearchBarHomeClicked(new HomeFragment.OnSearchBarHomeClicked() {
            @Override
            public void setOnSearchBarHomeClicked(int type) {
                setCurrentTab();
            }
        });
        homeFragment.setOnCateriesHomeClicked(new HomeFragment.OnCategroiesHomeClicked() {
            @Override
            public void setOnCateriesHomeClicked(int type) {
                setCurrentTabCatgries();
            }
        });
        final CategoriesFragment categoriesFragment = new CategoriesFragment();
        final SearchFragment searchFragment = new SearchFragment();
        final SupportFragment supportFragment = new SupportFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.FramContainer, homeFragment);
        fragmentTransaction.commit();
        //**************
        bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);
        // Create items
        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Home", R.drawable.ic_email_black_24dp, R.color.hint);
        item2 = new AHBottomNavigationItem("Categories", R.drawable.ic_apps_black_24dp, R.color.hint);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Search", R.drawable.ic_loupe, R.color.hint);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem("Support", R.drawable.ic_headset_mic_black_24dp, R.color.hint);

// Add items
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);
        bottomNavigation.addItem(item4);


// Set background color
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));

// Disable the translation inside the CoordinatorLayout
        bottomNavigation.setBehaviorTranslationEnabled(false);

// Change colors
        bottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));
        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));
// Force to tint the drawable (useful for font with icon for example)
        bottomNavigation.setForceTint(true);
// Set listeners
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                if (position == 0) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.FramContainer, homeFragment);
                    fragmentTransaction.commit();
                }
                if (position == 1) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.FramContainer, categoriesFragment);
                    fragmentTransaction.commit();

                }
                if (position == 2) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.FramContainer, searchFragment);
                    fragmentTransaction.commit();
                }
                if (position == 3) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.FramContainer, supportFragment);
                    fragmentTransaction.commit();

                }

                return true;
            }
        });
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.shop_By_Categorie) {
            // Handle the camera action
            bottomNavigation.setCurrentItem(1);

        } else if (id == R.id.Shopping_Cart) {
            Intent intent = new Intent(getApplicationContext(), ShoppingCartActivity.class);
            startActivity(intent);


        } else if (id == R.id.Account) {
            Intent intent = new Intent(getApplicationContext(), MyAccountActivity.class);
            startActivity(intent);

        } else if (id == R.id.Notification) {

            Intent intent = new Intent(getApplicationContext(), NotificationActivity.class);
            startActivity(intent);
        } else if (id == R.id.Order) {

            Intent intent = new Intent(getApplicationContext(), MyOrderActivity.class);
            startActivity(intent);
        } else if (id == R.id.Adress_Book) {
            Intent intent = new Intent(getApplicationContext(), AdressBook.class);
            startActivity(intent);

        } else if (id == R.id.Service_Area) {
            Intent intent = new Intent(getApplicationContext(), ServiceAreaActivity.class);
            startActivity(intent);
        } else if (id == R.id.share) {

        } else if (id == R.id.RateUs) {

        } else if (id == R.id.Support) {
            bottomNavigation.setCurrentItem(3);

        } else if (id == R.id.About) {
            Intent intent = new Intent(getApplicationContext(), AboutUsActivity.class);
            startActivity(intent);

        } else if (id == R.id.Out) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setCurrentTab() {
        Home1Activity.this.bottomNavigation.setCurrentItem(2);
    }

    public  void setCurrentTabCatgries() {Home1Activity.this.bottomNavigation.setCurrentItem(1);}


}
