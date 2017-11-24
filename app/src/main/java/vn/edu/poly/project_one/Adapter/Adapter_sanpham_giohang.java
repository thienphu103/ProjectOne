package vn.edu.poly.project_one.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.SanPham;

/**
 * Created by TN on 24-Nov-17.
 */

public class Adapter_sanpham_giohang extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<SanPham> sanPhamArrayList;

    public Adapter_sanpham_giohang(Context context, ArrayList<SanPham> sanPhamArrayList) {
        this.context = context;
        this.sanPhamArrayList = sanPhamArrayList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return sanPhamArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return sanPhamArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class ViewHolder {
        TextView txt_sanpham_giohang, txt_giasanpham_giohang,
                txt_size_sanpham_giohang, txt_soluong_sanpham_giohang;
        ImageButton btn_xoasanpham_giohang;
        Button btn_muasau_giohang;
        ImageView image_sanpham_giohang;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = inflater.inflate(R.layout.custom_gridview_giohang, null);
            holder = new ViewHolder();
            holder.txt_sanpham_giohang = (TextView) view.findViewById(R.id.txt_sanpham_giohang);
            holder.txt_giasanpham_giohang = (TextView) view.findViewById(R.id.txt_giasanpham_giohang);
            holder.txt_size_sanpham_giohang = (TextView) view.findViewById(R.id.txt_size_sanpham_giohang);
            holder.txt_soluong_sanpham_giohang = (TextView) view.findViewById(R.id.txt_soluong_sanpham_giohang);

            holder.btn_xoasanpham_giohang = (ImageButton) view.findViewById(R.id.btn_xoasanpham_giohang);
            holder.btn_muasau_giohang = (Button) view.findViewById(R.id.btn_muasau_giohang);
            holder.image_sanpham_giohang = (ImageView) view.findViewById(R.id.image_sanpham_giohang);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        SanPham sp = sanPhamArrayList.get(i);
        holder.txt_sanpham_giohang.setText(sp.getTen_sp());
        holder.txt_giasanpham_giohang.setText(sp.getGia_sp());
        holder.txt_size_sanpham_giohang.setText("size | " + sp.getSize_sp());
        holder.txt_soluong_sanpham_giohang.setText("số lượng | ×" + sp.getSoluong_sp());
        holder.image_sanpham_giohang.setImageDrawable(view.getResources().getDrawable(sp.getImg_sp()));
        return view;
    }
}
