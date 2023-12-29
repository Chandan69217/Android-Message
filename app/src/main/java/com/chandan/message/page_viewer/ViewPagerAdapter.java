package com.chandan.message.page_viewer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;

import com.chandan.message.tab.MesasgeFragment;
import com.chandan.message.tab.NoticesFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        this.fragmentManager = fm;
        fragmentTransaction = fm.beginTransaction();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        if(position==0){
           fragment = new MesasgeFragment();
        }else{
            fragment = new NoticesFragment();
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return "Messages";
        }else {
            return "Notices";
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
