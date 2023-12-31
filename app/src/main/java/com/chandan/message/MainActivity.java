package com.chandan.message;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.widget.SearchView;

import com.chandan.message.database.DatabaseHelper;
import com.chandan.message.database.Messages;
import com.chandan.message.page_viewer.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.security.Permission;

public class MainActivity extends AppCompatActivity {
    private SearchView searchView;
    private static  final String[] PERMISSIONS = new String[]{"android.permission.RECEIVE_SMS","android.permission.READ_SMS","android.permission.SEND_SMS"};
    private static final int PERMISSION_REQ_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((androidx.appcompat.widget.Toolbar)findViewById(R.id.home_toolbar));
        getSupportActionBar().setTitle(0);
        ((ViewPager)findViewById(R.id.view_pager)).setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        ((TabLayout)findViewById(R.id.home_tab_layout)).setupWithViewPager((ViewPager)findViewById(R.id.view_pager));
        requestRuntimePermission();
    }

    private void requestRuntimePermission(){
        if(ActivityCompat.checkSelfPermission(this,PERMISSIONS[0]) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this,PERMISSIONS[1]) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this,PERMISSIONS[2]) == PackageManager.PERMISSION_GRANTED){

            ((ViewPager)findViewById(R.id.view_pager)).setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
            ((TabLayout)findViewById(R.id.home_tab_layout)).setupWithViewPager((ViewPager)findViewById(R.id.view_pager));

        }else if(ActivityCompat.shouldShowRequestPermissionRationale(this,PERMISSIONS[0]) &&
                ActivityCompat.shouldShowRequestPermissionRationale(this,PERMISSIONS[1]) &&
                ActivityCompat.shouldShowRequestPermissionRationale(this,PERMISSIONS[2])){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("This app required SMS Permission for particular feature to work as expected")
                    .setTitle("Permission Required")
                    .setCancelable(false)
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ActivityCompat.requestPermissions(MainActivity.this,PERMISSIONS,PERMISSION_REQ_CODE);
                            dialogInterface.dismiss();
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .show();
        }else{
            ActivityCompat.requestPermissions(this,PERMISSIONS,PERMISSION_REQ_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
       super.onRequestPermissionsResult(requestCode, permissions, grantResults);
       if(requestCode == PERMISSION_REQ_CODE){
           if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

           }else if(!ActivityCompat.shouldShowRequestPermissionRationale(this,PERMISSIONS[0]) &&
                   !ActivityCompat.shouldShowRequestPermissionRationale(this,PERMISSIONS[1]) &&
                   !ActivityCompat.shouldShowRequestPermissionRationale(this,PERMISSIONS[2])){
               AlertDialog.Builder builder = new AlertDialog.Builder(this);
               builder.setMessage("This app required some permission that you have denied" +
                       " please allow SMS permission from settings to proceed further")
                       .setTitle("Permission Required")
                       .setCancelable(false)
                       .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               dialogInterface.dismiss();
                           }
                       })
                       .setPositiveButton("Settings", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                               Uri uri = Uri.fromParts("package",getPackageName(),null);
                               intent.setData(uri);
                               startActivity(intent);
                           }
                       })
                       .show();
           }else{
               requestRuntimePermission();
           }
       }
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
