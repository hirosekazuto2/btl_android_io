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
import com.lequangvinh.baitaplon.Model.KhoanThu;
import com.lequangvinh.baitaplon.R;
import com.lequangvinh.baitaplon.SQLite.Database;

import java.util.List;

public class KhoanThuAdapter extends BaseAdapter {
    Context context;
    List<KhoanThu>khoanThuList;

    public KhoanThuAdapter(Context context,List<KhoanThu> KhoanThuList) {
        this.context=context;
        this.khoanThuList=khoanThuList;

    }

    @Override
    public int getCount() {
        return khoanThuList.size();

    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public class ViewHolder{
        TextView txtkhoanthu;
        ImageView khoanthusua,khoanthuxoa;
    }

    @Override
    public View getView(final int i, View view, ViewGroup parent) {
        final ViewHolder holder;
        if(view ==null){
            holder=new ViewHolder();
            LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item_khoan_thu,null);
            holder.txtkhoanthu=(TextView)view.findViewById(R.id.txtkhoanthu);
            holder.khoanthusua=(ImageView) view.findViewById(R.id.khoanthusua);
            holder.khoanthuxoa=(ImageView) view.findViewById(R.id.khoanthuxoa);
            view.setTag(holder);
        }
        else{
            holder=(ViewHolder) view.getTag();
        }
        final KhoanThu kt =khoanThuList.get(i);
        holder.txtkhoanthu.setText(kt.getKhoanthu());

        holder.khoanthusua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog=new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_sua);

                final EditText edtsua=(EditText) dialog.findViewById(R.id.edt_sua);
                Button btn_sua=(Button) dialog.findViewById(R.id.btn_sua);
                edtsua.setText(kt.getKhoanthu());
                btn_sua.setOnClickListener((v)->{
                    int b=kt.getIdthu();
                    String a = edtsua.getText().toString();
                    if(a.isEmpty()){
                        Toast.makeText(context, "vui long ko de trong khoan  thu", Toast.LENGTH_SHORT).show();
                    }else{
                        Database dataBase = new Database(context);
                        dataBase.SendData("UPDATE THU SET KHOAN THU='"+a+"'WHERE IDTHu="+b+" ");
                        Toast.makeText(context, "ban da thay doi thong tin thanh cong", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                        ((MainActivity)context).recreate();
            }
        });
                dialog.show();

        /*holder.khoanthusua.setOnClickListener((v)->{
            final Dialog dialog=new Dialog(context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialog_sua);

            final EditText edtsua=(EditText) dialog.findViewById(R.id.edt_sua);
            Button btn_sua=(Button) dialog.findViewById(R.id.btn_sua);
            edtsua.setText(kt.getKhoanthu());
            btn_sua.setOnClickListener((v)->{
                int b=kt.getIdthu();
                String a = edtsua.getText().toString();
                if(a.isEmpty()){
                    Toast.makeText(context, "vui long ko de trong khoan  thu", Toast.LENGTH_SHORT).show();
                }else{
                    DataBase dataBase = new DataBase(context);
                    dataBase.SendData("UPDATE THU SET KHOAN THU='"+a+"'WHERE IDTHu="+b+" ");
                    Toast.makeText(context, "ban da thay doi thong tin thanh cong", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    ((MainActivity)context).recreate();
                }
            });
            dialog.show();

        });*/
        /*holder.khoanthuxoa.setOnClickListener((v)->{
            final Dialog dialog1= new Dialog(context);
            dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog1.setContentView(R.layout.dialog_xoa);
            Button btn_chapnhanxoa=(Button) dialog1.findViewById(R.id.btn_chapnhanxoa);
            Button btn_huyboxoa=(Button) dialog1.findViewById(R.id.btn_huyboxoa);

            btn_huyboxoa.setOnClickListener((v)->{
                dialog1.dismiss();*/
        holder.khoanthuxoa.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final Dialog dialog1= new Dialog(context);
                dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog1.setContentView(R.layout.dialog_xoa);
                Button btn_chapnhanxoa=(Button) dialog1.findViewById(R.id.btn_chapnhanxoa);
                Button btn_huyboxoa=(Button) dialog1.findViewById(R.id.btn_huyboxoa);
            }
        });

            //});
            btn_chapnhanxoa.setOnClickListener((v) ->{
                Database database=new Database(context);
                int a=kt.getId();
                database.SendData("DELETE FROM THU WHERE IDTHU="+a+" ");
                dialog1.dismiss();
                Toast.makeText(context, "xoa thong tin thu thanh cong", Toast.LENGTH_SHORT).show();
                ((MainActivity)context).recreate();
            } );
            dialog1.show();
        });

    }

}
