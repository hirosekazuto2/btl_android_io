package com.lequangvinh.baitaplon.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.lequangvinh.baitaplon.Fragment.FMLC;

public class PagerAdapter2 extends FragmentStatePagerAdapter  {
    public PagerAdapter2( FragmentManager fm) {
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
            return  new FMLC();
        }
        else if(i==1){
            return new FMLC();
        }
        else
        return null;
    }
    @Nullable
    @Override
    public CharSequence getpageTitle(int position){
        switch (position){
            case 0:
                return "khoan chi";
            case 1:
                return "loai chi";
        }
        return null;
    }
}
