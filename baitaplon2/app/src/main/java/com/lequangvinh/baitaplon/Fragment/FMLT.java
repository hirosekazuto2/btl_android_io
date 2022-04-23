package com.lequangvinh.baitaplon.Fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lequangvinh.baitaplon.Adapter.LoaiChiAdapter;
import com.lequangvinh.baitaplon.Adapter.LoaiThuAdapter;
import com.lequangvinh.baitaplon.Model.Loaithu;
import com.lequangvinh.baitaplon.R;
import com.lequangvinh.baitaplon.SQLite.Database;

import java.util.ArrayList;

public class FMLT {
    public FMLT(){

    }
    private View rootview;
    ListView lv_loaithu;
    ArrayList<LoaiThu> list;
    LoaiChiAdapter adapter;
    Database database;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState){
        rootview =inflater.inflate(R.layout.flagment_loai_thu,container,false);
        initView();
        return rootview;
    }
    private void initView(){
        lv_loaichi =rootview.findViewById(R.id.lv_loai_thu);
        list = new ArrayList<>();
        database=new Database(getActivity());
        adapter=new LoaiThuAdapter(getActivity(),R.id.list_item_loai_thu,list);
        Cursor dataloaichi=database.GetData("SELECT*fROM THU");
        list.clear();
        while(dataloaichi.moveToNext()){
            String a=dataloaithu.getString(2);
            int b=dataloaithu.getInt(3);
            list.add(new Loaithu(a,b));

        }
        adapter.notifyDataSetChanged();
        lv_loaithu.setAdapter(adapter);
    }



}
