package com.mitid.feedrecipeapp_2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {

    //Initialize variables
    TabLayout tabLayout;
    ViewPager viewPager;
    HomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //Assign Variable
        tabLayout=findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        //Initialize adapter
        adapter=new HomeAdapter(getSupportFragmentManager());
        //Add fragments
        adapter.AddFragment(new Veg(),"Veg");
        adapter.AddFragment(new nonVeg(), "Non-Veg");
        adapter.AddFragment(new Vegan(), "Vegan");
        adapter.AddFragment(new All()," All");

        //set adapter

        viewPager.setAdapter(adapter);

        //connect tablayout with view pager
        tabLayout.setupWithViewPager(viewPager);
    }

    private class HomeAdapter extends FragmentPagerAdapter {
        //Initialise arraylist
        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        ArrayList<String> stringArrayList = new ArrayList<>();

        //Create constructor
        public void AddFragment(Fragment fragment, String s){
            //Add fragment

            fragmentArrayList.add(fragment);
            //Add string
            stringArrayList.add(s);
        }



        public HomeAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            //Return fragment position
            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            //Return fragment list size
            return fragmentArrayList.size();

        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            //Return tab title
            return stringArrayList.get(position);

        }
    }
}