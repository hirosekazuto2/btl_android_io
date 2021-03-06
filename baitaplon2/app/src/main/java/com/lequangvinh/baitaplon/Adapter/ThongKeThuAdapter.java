package com.lequangvinh.baitaplon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lequangvinh.baitaplon.Model.ThongKeThu;
import com.lequangvinh.baitaplon.Model.ThongKechi;
import com.lequangvinh.baitaplon.R;

import java.util.List;

public class ThongKeThuAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<ThongKeThu>thongKeThuList;
    public ThongKeThuAdapter(Context context,int layout,List<ThongKeThu>thongKeThuList){
        this.context=context;
        this.layout=layout;
        this.thongKeThuList=thongKeThuList;
    }
    @Override
    public int getCount() {
        return thongKeThuList.size();
    }

    @Override
    public Object getItem(int positon) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class ViewHolder{
        TextView txt_ngaythang,txt_khoanthu,txt_loaithu;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHolder holder;
        if(view==null){
            holder=new ViewHolder();
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view =inflater.inflate(layout,null);

            holder.txt_ngaythang=(TextView) view.findViewById(R.id.txt_ngaythang);
            holder.txt_khoanthu=(TextView) view.findViewById(R.id.txt_khoanthu);
            holder.txt_loaithu=(TextView) view.findViewById(R.id.txt_loaithu);
            view.setTag(holder);
        }
        else{
            holder =(ViewHolder)  view.getTag(i);
        }
        ThongKeThu tkc=thongKeThuList.get(i);
        holder.txt_ngaythang.setText(tkc.getNgaythang());
        holder.txt_khoanthu.setText(tkc.getKhoanthu());
        holder.txt_loaithu.setText(tkc.getLoaithu());
        return view;
    }
}
