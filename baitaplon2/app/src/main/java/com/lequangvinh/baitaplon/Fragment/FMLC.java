package com.lequangvinh.baitaplon.Fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.lequangvinh.baitaplon.Adapter.LoaiChiAdapter;
import com.lequangvinh.baitaplon.Model.LoaiChi;
import com.lequangvinh.baitaplon.R;
import com.lequangvinh.baitaplon.SQLite.Database;

import java.util.ArrayList;

public class FMLC extends Fragment {
    public FMLC(){

    }
    private View rootview;
    ListView lv_loaichi;
    ArrayList<LoaiChi>list;
    LoaiChiAdapter adapter;
    Database database;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState){
        rootview =inflater.inflate(R.layout.flagment_loai_chi,container,false);
        initView();
        return rootview;
    }
    private void initView(){
        lv_loaichi =rootview.findViewById(R.id.lv_loai_chi);
        list = new ArrayList<>();
        database=new Database(getActivity());
        adapter=new LoaiChiAdapter(getActivity(),R.id.list_item_loai_chi,list);
        Cursor dataloaichi=database.GetData("SELECT*fROM CHI");
        list.clear();
        while(dataloaichi.moveToNext()){
            String a=dataloaichi.getString(2);
            int b=dataloaichi.getInt(3);
            list.add(new LoaiChi(a,b));

        }
        adapter.notifyDataSetChanged();
        lv_loaichi.setAdapter(adapter);
    }

}
