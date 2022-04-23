package com.lequangvinh.baitaplon.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.lequangvinh.baitaplon.Fragment.FMKT;

public class PagerAdapter1 extends FragmentStatePagerAdapter {

    public PagerAdapter1( FragmentManager fm) {
        super(fm);
    }


    @Override
    public int getCount() {
        return 2;
    }


    @Nullable
    @Override
    public Fragment getItem(int i) {
        if(i==0){
            return new FMKT();

        }
        else if(i==1){
            return new FMKT();
        }
        else
        return null;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "khoan thu";
            case 1:
                return "loai thu";
        }
        return null;
    }
}
