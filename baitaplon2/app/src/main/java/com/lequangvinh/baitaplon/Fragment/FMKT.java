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

import com.lequangvinh.baitaplon.Adapter.KhoanThuAdapter;
import com.lequangvinh.baitaplon.Model.KhoanThu;
import com.lequangvinh.baitaplon.R;
import com.lequangvinh.baitaplon.SQLite.Database;

import java.util.ArrayList;

public class FMKT extends Fragment {
    public FMKT(){

    }
    ListView lv_khoanthu;
    ArrayList<KhoanThu> list;
    Database database;
    KhoanThuAdapter adapter;
    private View rootview;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState){
        rootview =inflater.inflate(R.layout.flagment_khoan_thu,container,false);
        initView();
        return  rootview;
    }
    public void initView(){
        lv_khoanthu=rootview.findViewById(R.id.lv_khoanthu);
        list=new ArrayList<>();
        database=new Database(getActivity());
        adapter=new KhoanThuAdapter(getActivity(),list);
        getData();
        lv_khoanthu.setAdapter(adapter);


    }
    public void getData(){
        Cursor.datakhoanthu=database.GetData("SELECT*FROM THU");
        list.clear();
        while(datakhoanthu.moveToNext()){
            String a=datakhoanthu.getString(1);
            int b=datakhoanthu.getInt(3);
            list.add(new KhoanThu(a,b));

        }
        adapter.notifyDataSetChanged();
    }

}
