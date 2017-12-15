package vn.edu.poly.project_one.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.SanPham;

/**
 * Created by TN on 24-Nov-17.
 */

public class Adapter_sanpham_giohang extends RecyclerView.Adapter<Adapter_sanpham_giohang.ViewHolder> {
    Context context;
    LayoutInflater inflater;
    ArrayList<SanPham> sanPhamArrayList;
    private View.OnClickListener click;
    View v;

    public Adapter_sanpham_giohang(Context context, ArrayList<SanPham> sanPhamArrayList, View.OnClickListener click) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.sanPhamArrayList = sanPhamArrayList;
        this.click = click;
    }

    @Override
    public Adapter_sanpham_giohang.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_gridview_giohang, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(Adapter_sanpham_giohang.ViewHolder holder, final int position) {
        holder.txt_sanpham_giohang.setText(sanPhamArrayList.get(position).getTen_sp());
        holder.txt_giasanpham_giohang.setText(sanPhamArrayList.get(position).getGia_sp());
        holder.txt_size_sanpham_giohang.setText("size | " + sanPhamArrayList.get(position).getSize_sp());
        holder.txt_soluong_sanpham_giohang.setText("số lượng | ×" + sanPhamArrayList.get(position).getSoluong_sp());
        holder.btn_xoasanpham_giohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setTag(new Integer(position));
                click.onClick(v);
            }
        });
//        holder.image_sanpham_giohang.setImageDrawable(v.getResources().getDrawable(sanPhamArrayList.get(position).getImg_sp()));

        String url="";
        if((sanPhamArrayList.get(position).getImg_sp()!=null)) {//null
            url="http://namtnps06077.hol.es/"+sanPhamArrayList.get(position).getImg_sp();
        }else{
            url= String.valueOf(R.drawable.ic_priority_high_black_24dp);//null
        }
        Picasso.with(context)
                .load(url)
                .error(R.drawable.ic_priority_high_black_24dp)//load url error
                .placeholder(R.drawable.ic_priority_high_black_24dp)//load url error
                .resize(76, 76)
                .into(holder.image_sanpham_giohang);

    }

    @Override
    public int getItemCount() {
        return sanPhamArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_sanpham_giohang, txt_giasanpham_giohang,
                txt_size_sanpham_giohang, txt_soluong_sanpham_giohang;
        ImageButton btn_xoasanpham_giohang;
        Button btn_muasau_giohang;
        ImageView image_sanpham_giohang;
        public ViewHolder(View itemView) {
            super(itemView);
            txt_sanpham_giohang = (TextView) itemView.findViewById(R.id.txt_sanpham_giohang);
            txt_giasanpham_giohang = (TextView) itemView.findViewById(R.id.txt_giasanpham_giohang);
            txt_size_sanpham_giohang = (TextView) itemView.findViewById(R.id.txt_size_sanpham_giohang);
            txt_soluong_sanpham_giohang = (TextView) itemView.findViewById(R.id.txt_soluong_sanpham_giohang);
            btn_xoasanpham_giohang = (ImageButton) itemView.findViewById(R.id.btn_xoasanpham_giohang);
            btn_muasau_giohang = (Button) itemView.findViewById(R.id.btn_muasau_giohang);
            image_sanpham_giohang = (ImageView) itemView.findViewById(R.id.image_sanpham_giohang);
        }
    }

//    private class ViewHolder {
//        TextView txt_sanpham_giohang, txt_giasanpham_giohang,
//                txt_size_sanpham_giohang, txt_soluong_sanpham_giohang;
//        ImageButton btn_xoasanpham_giohang;
//        Button btn_muasau_giohang;
//        ImageView image_sanpham_giohang;
//    }

//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        ViewHolder holder = null;
//        if (view == null) {
//            view = inflater.inflate(R.layout.custom_gridview_giohang, null);
//            holder = new ViewHolder();
//            holder.txt_sanpham_giohang = (TextView) view.findViewById(R.id.txt_sanpham_giohang);
//            holder.txt_giasanpham_giohang = (TextView) view.findViewById(R.id.txt_giasanpham_giohang);
//            holder.txt_size_sanpham_giohang = (TextView) view.findViewById(R.id.txt_size_sanpham_giohang);
//            holder.txt_soluong_sanpham_giohang = (TextView) view.findViewById(R.id.txt_soluong_sanpham_giohang);
//
//            holder.btn_xoasanpham_giohang = (ImageButton) view.findViewById(R.id.btn_xoasanpham_giohang);
//            holder.btn_muasau_giohang = (Button) view.findViewById(R.id.btn_muasau_giohang);
//            holder.image_sanpham_giohang = (ImageView) view.findViewById(R.id.image_sanpham_giohang);
//
//            view.setTag(holder);
//        } else {
//            holder = (ViewHolder) view.getTag();
//        }
//
//        SanPham sp = sanPhamArrayList.get(i);
//        holder.txt_sanpham_giohang.setText(sp.getTen_sp());
//        holder.txt_giasanpham_giohang.setText(sp.getGia_sp());
//        holder.txt_size_sanpham_giohang.setText("size | " + sp.getSize_sp());
//        holder.txt_soluong_sanpham_giohang.setText("số lượng | ×" + sp.getSoluong_sp());
//        holder.image_sanpham_giohang.setImageDrawable(view.getResources().getDrawable(sp.getImg_sp()));
//        return view;
//    }
}
