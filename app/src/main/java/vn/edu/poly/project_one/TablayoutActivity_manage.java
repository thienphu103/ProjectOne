package vn.edu.poly.project_one;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import vn.edu.poly.project_one.Adapter.AdapterTabLayoutFrangment;
import vn.edu.poly.project_one.Adapter.AdapterTabLayoutFrangment_Manage;
import vn.edu.poly.project_one.View_manage.CuaHang;
import vn.edu.poly.project_one.View_manage.DonHang;
import vn.edu.poly.project_one.View_manage.KhoHang;
import vn.edu.poly.project_one.View_manage.ThongKe;
import vn.edu.poly.project_one.view.Find;
import vn.edu.poly.project_one.view.Gio_Hang;
import vn.edu.poly.project_one.view.Tai_Khoan;
import vn.edu.poly.project_one.view.ToDay;
import vn.edu.poly.project_one.view.ViSit;

public class TablayoutActivity_manage extends AppCompatActivity {
    public ViewPager mViewPager_manage;
    public TabLayout tab_layout_manage;
    ArrayList listFragment;
    ArrayList<String> listTitle;
    AdapterTabLayoutFrangment_Manage adapterTabLayoutFrangment_manage;
    public TextView tabOne, tabTwo, tabThree, tabFour, tabFive;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout_manage);
        initControl();
        initEvent();
        initDisplay();
        initOnClick();
        createTabIcons();

    }

    private void createTabIcons() {
        tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText(getResources().getString(R.string.txt_cuahang_manage));
        tabOne.setTextColor(getResources().getColor(R.color.color_text_tablayout));
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_cuahang_select, 0, 0);
        tab_layout_manage.getTabAt(0).setCustomView(tabOne);
        // icon Cửa Hàng
        tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText(getResources().getString(R.string.txt_khohang_manage));
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_khohang, 0, 0);
        tab_layout_manage.getTabAt(1).setCustomView(tabTwo);
        // icon Kho Hàng

        tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText(getResources().getString(R.string.txt_donhang_manage));
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_donhang, 0, 0);
        tab_layout_manage.getTabAt(2).setCustomView(tabThree);
        // icon Đơn Hàng

        tabFour = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabFour.setText(getResources().getString(R.string.txt_thongke_manage));
        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_thongke, 0, 0);
        tab_layout_manage.getTabAt(3).setCustomView(tabFour);
        // icon Thống Kê

        tabFive = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabFive.setText(getResources().getString(R.string.txt_taikhoan_tablayoutactivity));
        tabFive.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_taikhoan, 0, 0);
        tab_layout_manage.getTabAt(4).setCustomView(tabFive);
        // icon Tài khoản
    }

    private void initOnClick() {
        mViewPager_manage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @SuppressLint({"ResourceAsColor", "ResourceType"})
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
//                        tabOne = (TextView) LayoutInflater.from(TabLayOutActivity.this).inflate(R.layout.custom_tab_select, null);
                        tabOne.setText(getResources().getString(R.string.txt_cuahang_manage));
                        tabOne.setTextColor(getResources().getColor(R.color.color_text_tablayout));
                        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_cuahang_select, 0, 0);
                        tab_layout_manage.getTabAt(0).setCustomView(tabOne);
                        tabTwo.setText(getResources().getString(R.string.txt_khohang_manage));
                        tabTwo.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_khohang, 0, 0);
                        tab_layout_manage.getTabAt(1).setCustomView(tabTwo);
                        // icon Kho hàng
                        tabThree.setText(getResources().getString(R.string.txt_donhang_manage));
                        tabThree.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_donhang, 0, 0);
                        tab_layout_manage.getTabAt(2).setCustomView(tabThree);
                        // icon Đơn hàng
                        tabFour.setText(getResources().getString(R.string.txt_thongke_manage));
                        tabFour.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_thongke, 0, 0);
                        tab_layout_manage.getTabAt(3).setCustomView(tabFour);
                        // icon Thống kê
                        tabFive.setText(getResources().getString(R.string.txt_taikhoan_tablayoutactivity));
                        tabFive.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabFive.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_taikhoan, 0, 0);
                        tab_layout_manage.getTabAt(4).setCustomView(tabFive);
                        break;
                    case 1:
                        tabOne.setText(getResources().getString(R.string.txt_cuahang_manage));
                        tabOne.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_cuahang, 0, 0);
                        tab_layout_manage.getTabAt(0).setCustomView(tabOne);
                        tabTwo.setText(getResources().getString(R.string.txt_khohang_manage));
                        tabTwo.setTextColor(getResources().getColor(R.color.color_text_tablayout));
                        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_khohang_select, 0, 0);
                        tab_layout_manage.getTabAt(1).setCustomView(tabTwo);
                        // icon Kho hàng
                        tabThree.setText(getResources().getString(R.string.txt_donhang_manage));
                        tabThree.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_donhang, 0, 0);
                        tab_layout_manage.getTabAt(2).setCustomView(tabThree);
                        // icon Đơn hàng
                        tabFour.setText(getResources().getString(R.string.txt_thongke_manage));
                        tabFour.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_thongke, 0, 0);
                        tab_layout_manage.getTabAt(3).setCustomView(tabFour);
                        // icon Thống kê
                        tabFive.setText(getResources().getString(R.string.txt_taikhoan_tablayoutactivity));
                        tabFive.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabFive.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_taikhoan, 0, 0);
                        tab_layout_manage.getTabAt(4).setCustomView(tabFive);
                        break;
                    case 2:
                        tabOne.setText(getResources().getString(R.string.txt_cuahang_manage));
                        tabOne.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_cuahang, 0, 0);
                        tab_layout_manage.getTabAt(0).setCustomView(tabOne);
                        tabTwo.setText(getResources().getString(R.string.txt_khohang_manage));
                        tabTwo.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_khohang, 0, 0);
                        tab_layout_manage.getTabAt(1).setCustomView(tabTwo);
                        // icon Kho hàng
                        tabThree.setText(getResources().getString(R.string.txt_donhang_manage));
                        tabThree.setTextColor(getResources().getColor(R.color.color_text_tablayout));
                        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_donhang_select, 0, 0);
                        tab_layout_manage.getTabAt(2).setCustomView(tabThree);
                        // icon Đơn hàng
                        tabFour.setText(getResources().getString(R.string.txt_thongke_manage));
                        tabFour.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_thongke, 0, 0);
                        tab_layout_manage.getTabAt(3).setCustomView(tabFour);
                        // icon Thống kê
                        tabFive.setText(getResources().getString(R.string.txt_taikhoan_tablayoutactivity));
                        tabFive.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabFive.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_taikhoan, 0, 0);
                        tab_layout_manage.getTabAt(4).setCustomView(tabFive);
                        break;
                    case 3:
                        tabOne.setText(getResources().getString(R.string.txt_cuahang_manage));
                        tabOne.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_cuahang, 0, 0);
                        tab_layout_manage.getTabAt(0).setCustomView(tabOne);
                        tabTwo.setText(getResources().getString(R.string.txt_khohang_manage));
                        tabTwo.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_khohang, 0, 0);
                        tab_layout_manage.getTabAt(1).setCustomView(tabTwo);
                        // icon Kho hàng
                        tabThree.setText(getResources().getString(R.string.txt_donhang_manage));
                        tabThree.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_donhang, 0, 0);
                        tab_layout_manage.getTabAt(2).setCustomView(tabThree);
                        // icon Đơn hàng
                        tabFour.setText(getResources().getString(R.string.txt_thongke_manage));
                        tabFour.setTextColor(getResources().getColor(R.color.color_text_tablayout));
                        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_thongke_select, 0, 0);
                        tab_layout_manage.getTabAt(3).setCustomView(tabFour);
                        // icon Thống kê
                        tabFive.setText(getResources().getString(R.string.txt_taikhoan_tablayoutactivity));
                        tabFive.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabFive.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_taikhoan, 0, 0);
                        tab_layout_manage.getTabAt(4).setCustomView(tabFive);
                        break;
                    case 4:
                        tabOne.setText(getResources().getString(R.string.txt_cuahang_manage));
                        tabOne.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_cuahang, 0, 0);
                        tab_layout_manage.getTabAt(0).setCustomView(tabOne);
                        tabTwo.setText(getResources().getString(R.string.txt_khohang_manage));
                        tabTwo.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_khohang, 0, 0);
                        tab_layout_manage.getTabAt(1).setCustomView(tabTwo);
                        // icon Kho Hàng
                        tabThree.setText(getResources().getString(R.string.txt_donhang_manage));
                        tabThree.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_donhang, 0, 0);
                        tab_layout_manage.getTabAt(2).setCustomView(tabThree);
                        // icon Đơn Hàng
                        tabFour.setText(getResources().getString(R.string.txt_thongke_manage));
                        tabFour.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_thongke, 0, 0);
                        tab_layout_manage.getTabAt(3).setCustomView(tabFour);
                        // icon Thống kê
                        tabFive.setText(getResources().getString(R.string.txt_taikhoan_tablayoutactivity));
                        tabFive.setTextColor(getResources().getColor(R.color.color_text_tablayout));
                        tabFive.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_taikhoan_select, 0, 0);
                        tab_layout_manage.getTabAt(4).setCustomView(tabFive);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initDisplay() {
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.color_statusbar_tablayotactivity));
    }

    private void initEvent() {
        listFragment = new ArrayList();
        listFragment.add(new CuaHang());
        listFragment.add(new KhoHang());
        listFragment.add(new DonHang());
        listFragment.add(new ThongKe());
        listFragment.add(new Tai_Khoan());

        listTitle = new ArrayList<>();

        listTitle.add(getResources().getString(R.string.txt_cuahang_manage));
        listTitle.add(getResources().getString(R.string.txt_khohang_manage));
        listTitle.add(getResources().getString(R.string.txt_donhang_manage));
        listTitle.add(getResources().getString(R.string.txt_thongke_manage));
        listTitle.add(getResources().getString(R.string.txt_taikhoan_tablayoutactivity));

        adapterTabLayoutFrangment_manage = new AdapterTabLayoutFrangment_Manage(
                getSupportFragmentManager(), TablayoutActivity_manage.this, listTitle, listFragment
        );

        mViewPager_manage.setAdapter(adapterTabLayoutFrangment_manage);
    }

    private void initControl() {
        tab_layout_manage = (TabLayout) findViewById(R.id.tabs_manage);
        mViewPager_manage = (ViewPager) findViewById(R.id.viewpager_content_manage);
        tab_layout_manage.setupWithViewPager(mViewPager_manage);
    }
}
