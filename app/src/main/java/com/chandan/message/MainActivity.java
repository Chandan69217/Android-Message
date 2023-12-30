package com.chandan.message;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.SearchView;

import com.chandan.message.database.DatabaseHelper;
import com.chandan.message.database.Messages;
import com.chandan.message.page_viewer.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((androidx.appcompat.widget.Toolbar)findViewById(R.id.home_toolbar));
        getSupportActionBar().setTitle(0);
        ((ViewPager)findViewById(R.id.view_pager)).setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        ((TabLayout)findViewById(R.id.home_tab_layout)).setupWithViewPager((ViewPager)findViewById(R.id.view_pager));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option,menu);
        searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.app_bar_search));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        if(!searchView.isIconified()){
            searchView.setIconified(true);
        }else{
            super.onBackPressed();
        }
    }
}
