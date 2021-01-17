package com.example.carads.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.carads.Adapter.ViewPagerAdapter;
import com.example.carads.Fragment.FragmentNotification;
import com.example.carads.Fragment.FragmentProfile;
import com.example.carads.Fragment.FragmentServices;
import com.example.carads.R;
import com.example.carads.Utils.CustomViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity  implements  BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener{

    private CustomViewPager viewPager;
    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
    LinearLayout nav_drawer_lay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer);

        init();
    }


    private void init(){
        nav_drawer_lay =  findViewById(R.id.nav_drawer_lay);
        nav_drawer_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        viewPager =  findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        bottomNavigationView = findViewById(R.id.btn_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        drawerLayout = findViewById(R.id.n_drawer);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.btn_nav1:{
                switchToFragment(1);
                break;
            }



            //nav menu
            case R.id.nav_menu_sc1:{
//                startActivity(new Intent(getApplicationContext(),Login.class));
                Toast.makeText(this, "لاحقا", Toast.LENGTH_SHORT).show();
//                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
//            case R.id.nav_menu_sc2:{
////                startActivity(new Intent(getApplicationContext(),Register.class));
//                Toast.makeText(this, "لاحـقا", Toast.LENGTH_SHORT).show();
//                drawerLayout.closeDrawer(GravityCompat.START);
//                break;
//            }
//            case R.id.nav_menu_favorite:{
//                startActivity(new Intent(getApplicationContext(),FavoriteAds.class));
//                drawerLayout.closeDrawer(GravityCompat.START);
//                break;
//            }
//            case R.id.nav_menu_login:{
//                startActivity(new Intent(getApplicationContext(),Login.class));
//                drawerLayout.closeDrawer(GravityCompat.START);
//                break;
//            }

        }
        return true;
    }

    public void switchToFragment(int f_no) {
//        FragmentManager manager = getSupportFragmentManager();
        switch (f_no) {
            case 1: {
                viewPager.setCurrentItem(0);
                SetNavigationItemSelected(R.id.btn_nav1);
                break;
            }
            case 2: {
                viewPager.setCurrentItem(1);
                SetNavigationItemSelected(R.id.btn_nav2);
                break;
            }
            case 3: {
                viewPager.setCurrentItem(2);
                SetNavigationItemSelected(R.id.btn_nav3);
                break;
            }

        }
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        FragmentNotification fragmentNotification= new FragmentNotification();
        FragmentServices fragmentServices = new FragmentServices();
        FragmentProfile fragmentProfile = new FragmentProfile();

        adapter.addFragment(fragmentNotification,"الاشعارات");
        adapter.addFragment(fragmentServices,"الخدمات");
        adapter.addFragment(fragmentProfile,"الملف الشخصي");
        viewPager.setAdapter(adapter);
    }

    private void SetNavigationItemSelected(int id){
        bottomNavigationView.getMenu().findItem(id).setChecked(true);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            if (viewPager.getCurrentItem()==0){
                super.onBackPressed();
            }else{
                switchToFragment(1);
//                viewPager.setCurrentItem(0);
            }
        }
    }





}