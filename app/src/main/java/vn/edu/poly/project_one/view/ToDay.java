package vn.edu.poly.project_one.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import vn.edu.poly.project_one.Adapter.Adapter_cardview_today;
import vn.edu.poly.project_one.Adapter.Adapter_khaitruong_today;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.today_khaitruong_setter_getter;

/**
 * Created by ASUS on 11/18/2017.
 */

public class ToDay extends Fragment {
    View view_today;
    ArrayList<today_khaitruong_setter_getter> arrayList;
    ListView listView;
    Adapter_khaitruong_today adapter;
    private RecyclerView mRecyclerView_today;
    private RecyclerView.Adapter mAdapter_today;
    private RecyclerView.LayoutManager mLayoutManager_today;
    private ArrayList<String> strings;
    ImageView imageView;
    private int index_handle_back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view_today = inflater.inflate(R.layout.fragment_today, container, false);
        initControl();
        initEvent();
        initOnClick();
        return view_today;
    }

    private void initOnClick() {
    }

    private void initEvent() {
        arrayList = new ArrayList<>();
        arrayList.add(new today_khaitruong_setter_getter(R.drawable.bayab,
                getResources().getString(R.string.txt_beyeu_tablayoutactivity),
                getResources().getString(R.string.txt_cuahangbabay_today),
                getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new today_khaitruong_setter_getter(R.drawable.bayab,
                getResources().getString(R.string.txt_beyeu_tablayoutactivity),
                getResources().getString(R.string.txt_cuahangbabay_today),
                getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new today_khaitruong_setter_getter(R.drawable.bayab,
                getResources().getString(R.string.txt_beyeu_tablayoutactivity),
                getResources().getString(R.string.txt_cuahangbabay_today),
                getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new today_khaitruong_setter_getter(R.drawable.bayab,
                getResources().getString(R.string.txt_beyeu_tablayoutactivity),
                getResources().getString(R.string.txt_cuahangbabay_today),
                getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new today_khaitruong_setter_getter(R.drawable.bayab,
                getResources().getString(R.string.txt_beyeu_tablayoutactivity),
                getResources().getString(R.string.txt_cuahangbabay_today),
                getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new today_khaitruong_setter_getter(R.drawable.bayab,
                getResources().getString(R.string.txt_beyeu_tablayoutactivity),
                getResources().getString(R.string.txt_cuahangbabay_today),
                getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new today_khaitruong_setter_getter(R.drawable.bayab,
                getResources().getString(R.string.txt_beyeu_tablayoutactivity),
                getResources().getString(R.string.txt_cuahangbabay_today),
                getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new today_khaitruong_setter_getter(R.drawable.bayab,
                getResources().getString(R.string.txt_beyeu_tablayoutactivity),
                getResources().getString(R.string.txt_cuahangbabay_today),
                getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new today_khaitruong_setter_getter(R.drawable.bayab,
                getResources().getString(R.string.txt_beyeu_tablayoutactivity),
                getResources().getString(R.string.txt_cuahangbabay_today),
                getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new today_khaitruong_setter_getter(R.drawable.bayab,
                getResources().getString(R.string.txt_beyeu_tablayoutactivity),
                getResources().getString(R.string.txt_cuahangbabay_today),
                getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new today_khaitruong_setter_getter(R.drawable.bayab,
                getResources().getString(R.string.txt_beyeu_tablayoutactivity),
                getResources().getString(R.string.txt_cuahangbabay_today),
                getResources().getString(R.string.btn_vao_tablayoutactivity)));
        arrayList.add(new today_khaitruong_setter_getter(R.drawable.bayab,
                getResources().getString(R.string.txt_beyeu_tablayoutactivity),
                getResources().getString(R.string.txt_cuahangbabay_today),
                getResources().getString(R.string.btn_vao_tablayoutactivity)));

        adapter = new Adapter_khaitruong_today(getActivity(),arrayList);
        listView.setAdapter(adapter);
        setListViewHeightBasedOnChildren(listView);

        strings = new ArrayList<>();
        for(int i = 0 ; i < 8 ;i++){
            strings.add(getResources().getString(R.string.txt_giaynam));
        }
        mRecyclerView_today.setHasFixedSize(true);
        mLayoutManager_today = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView_today.setLayoutManager(mLayoutManager_today);
        mAdapter_today = new Adapter_cardview_today(strings);
        mRecyclerView_today.setAdapter(mAdapter_today);
    }

    private void initControl() {
        index_handle_back=0;
        listView = (ListView) view_today.findViewById(R.id.lst_today_khaitruong);
        mRecyclerView_today = (RecyclerView) view_today.findViewById(R.id.my_recycler_view_today);
        view_today.setFocusableInTouchMode(true);
        view_today.requestFocus();
        view_today.setOnKeyListener( new View.OnKeyListener()
        {
            @Override
            public boolean onKey( View v, int keyCode, KeyEvent event )
            {
                index_handle_back++;
                if( keyCode == KeyEvent.KEYCODE_BACK &&index_handle_back>1)
                {
                    showQuestionDialog();
                    return true;
                }

                return false;
            }
        } );
    }
    public void showQuestionDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("App");
        builder.setMessage("Bạn có muốn thoát app không");
//        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                getActivity().finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                index_handle_back=0;
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }


    public static void setListViewHeightBasedOnChildren(ListView listView) {
        Adapter_khaitruong_today listAdapter = (Adapter_khaitruong_today) listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = listView.getPaddingTop() + listView.getPaddingBottom();

        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            if (listItem instanceof ViewGroup) {
                listItem.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            }

            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }



}

