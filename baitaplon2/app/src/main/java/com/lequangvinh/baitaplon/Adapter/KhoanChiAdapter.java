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
import com.lequangvinh.baitaplon.Model.KhoanChi;
import com.lequangvinh.baitaplon.R;
import com.lequangvinh.baitaplon.SQLite.Database;

import java.util.List;

public class KhoanChiAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<KhoanChi> khoanChiList;
    public KhoanChiAdapter(Context context, int layout, List<KhoanChi> khoanChiList) {
        this.context=context;
        this.layout=layout;
        this.khoanChiList=khoanChiList;
    }
    @Override
    public int getCount() {
        return khoanChiList.size();
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
    TextView txtkhoanchi;
    ImageView khoanchisua,khoanchixoa;
    }


    @Override
    public View getView(int i , View view, ViewGroup parent){
        ViewHolder holder;
        if(view==null){
            holder=new ViewHolder();
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view= inflater.inflate(layout,null);
            holder.txtkhoanchi=(TextView) view.findViewById(R.id.txtkhoanchi);
            holder.khoanchisua=(ImageView) view.findViewById(R.id.khoanchisua);
            holder.khoanchixoa=(ImageView) view.findViewById(R.id.khoanchixoa);
            view.setTag(holder);
        }
        else{
            holder=(ViewHolder)  view.getTag();

        }
        final KhoanChi kc=khoanChiList.get();
        holder.txtkhoanchi.setText(kc.getKhoanchi());

        holder.khoanchisua.setOnClickListener((v)->{
            final Dialog dialog=new Dialog(context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialog_sua);
            final EditText edtsua=(EditText) dialog.findViewById(R.id.edt_sua);
            Button btnsua=(Button) dialog.findViewById(R.id.btn_sua);
            edtsua.setText(kc.getKhoanchi());
            btnsua.setOnClickListener((v)->{
                String a=edtsua.getText().toString();
                int b=kc.getIdchi();
                if(a.isEmpty()){
                    Toast.makeText(context,"Vui long khong de trong khoan chi",Toast.LENGTH_LONG).show();
                }
                else{
                    Database dataBase= new Database(context);
                    dataBase.SendData("UPDATE CHI SET KHOAN CHI='"+a+"'WHERE IDCHI="+b+" ");
                    Toast.makeText(context, "cap nhat khoan chi thanh cong", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    ((MainActivity)context).recreate();
                }
            });
            dialog.show();
        });
        holder.khoanchixoa.setOnClickListener((v)->{
            final  Dialog dialog =new Dialog((context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialog_xoa);

            Button btnhuy=(Button)dialog.findViewById(R.id.btn_huyboxoa);
            Button btnchapnhan=(Button) dialog.findViewById(R.id.btnchapnhanxoa);
            btnhuy.setOnClickListener((v)->{
                dialog.dismiss();
            });
            btnchapnhan.setOnClickListener((v)->{
                int a =kc.getIdchi();
                Database database=new Database(context);
                database.SendData("DELETE FROM CHI WHERE IDCHI="+a+" ");
                Toast.makeText(context, "xoa thonmg tin chi thanh cong", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                ((MainActivity)context).recreate();
            });
            dialog.show();
        });
            return view;
    }
}
