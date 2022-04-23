package com.lequangvinh.baitaplon.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lequangvinh.baitaplon.MainActivity;
import com.lequangvinh.baitaplon.Model.LoaiChi;
import com.lequangvinh.baitaplon.Model.Loaithu;
import com.lequangvinh.baitaplon.R;
import com.lequangvinh.baitaplon.SQLite.Database;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class LoaiThuAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Loaithu>LoaithuList;
    public LoaiThuAdapter(Context context,int layout, List<Loaithu> LoaiThuList) {
        this.context=context;
        this.layout=layout;
        this.LoaithuList=LoaiThuList;
    }

    @Override
    public int getCount() {
        return LoaithuList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class ViewHolder{
        TextView txtloaithu;
        ImageView loaithusua;

    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {

        ViewHolder holder=new ViewHolder();
        if(view ==null){
            holder=new ViewHolder();
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder.txtloaithu=(TextView) view.findViewById(R.id.txtloaithu);
            holder.loaithusua=(ImageView) view.findViewById(R.id.loaithusua);
            view.setTag(holder);
        }
        else {
            holder=(ViewHolder) view.getTag();

        }
        final Loaithu lt= LoaithuList.get(i);
        holder.txtloaithu.setText(lt.getLoaithu());

        holder.loaithusua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog=new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_sua);

                final EditText edtsua=(EditText) dialog.findViewById(R.id.edt_sua);
                Button btnsua=(Button) dialog.findViewById(R.id.btn_sua);
                edtsua.setText(lt.getLoaithu());
                btnsua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String a=edtsua.getText().toString();
                        int b=lt.getIdthu();
                        if(a.isEmpty()){
                            Toast.makeText(context, "vui long ko de trong khoan thu", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Database database=new Database(context);
                            database.SendData("UPDATE CHI SET LOAITHU='" + a + "'WHERE IDCHI= " + b + " ");
                            dialog.dismiss();
                            Toast.makeText(context, "cap nhat loai thu thanh cong", Toast.LENGTH_SHORT).show();
                            ((MainActivity)context).recreate();;
                        }
                    }
                });
                dialog.show();
            }
        });
        return view;
    }
}
