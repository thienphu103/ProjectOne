package vn.edu.poly.project_one;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.poly.project_one.Adapter.AdapterTabLayoutFrangment;
import vn.edu.poly.project_one.view.Find;
import vn.edu.poly.project_one.view.Gio_Hang;
import vn.edu.poly.project_one.view.Tai_Khoan;
import vn.edu.poly.project_one.view.ToDay;
import vn.edu.poly.project_one.view.ViSit;

public class TabLayOutActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    TabLayout tab_layout;
    ArrayList listFragment;
    ArrayList<String> listTitle;
    AdapterTabLayoutFrangment adapterTabLayoutFrangment;
    TextView tabOne,tabTwo,tabThree,tabFour,tabFive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_tablayout);
        initControl();
        initEvent();
        initDisplay();
        initOnClick();
        createTabIcons();

    }

    private void initOnClick() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @SuppressLint({"ResourceAsColor", "ResourceType"})
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
//                        tabOne = (TextView) LayoutInflater.from(TabLayOutActivity.this).inflate(R.layout.custom_tab_select, null);
                        tabOne.setText(getResources().getString(R.string.txt_today_tablayoutactivity));
                        tabOne.setTextColor(getResources().getColor(R.color.color_text_tablayout));
                        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_homnay_select, 0, 0);
                        tab_layout.getTabAt(0).setCustomView(tabOne);
                        tabTwo.setText(getResources().getString(R.string.txt_visit_tablayoutactivity));
                        tabTwo.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_thamquan, 0, 0);
                        tab_layout.getTabAt(1).setCustomView(tabTwo);
                        // icon Tham quan
                        tabThree.setText(getResources().getString(R.string.txt_find_tablayoutactivity));
                        tabThree.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_tinkiem, 0, 0);
                        tab_layout.getTabAt(2).setCustomView(tabThree);
                        // icon Tìm kiếm
                        tabFour.setText(getResources().getString(R.string.txt_giohang_tablayoutactivity));
                        tabFour.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_giaohang, 0, 0);
                        tab_layout.getTabAt(3).setCustomView(tabFour);
                        // icon giỏ hàng
                        tabFive.setText(getResources().getString(R.string.txt_taikhoan_tablayoutactivity));
                        tabFive.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabFive.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_taikhoan, 0, 0);
                        tab_layout.getTabAt(4).setCustomView(tabFive);
                        break;
                    case 1:
                        tabOne.setText(getResources().getString(R.string.txt_today_tablayoutactivity));
                        tabOne.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_today, 0, 0);
                        tab_layout.getTabAt(0).setCustomView(tabOne);
                        tabTwo.setText(getResources().getString(R.string.txt_visit_tablayoutactivity));
                        tabTwo.setTextColor(getResources().getColor(R.color.color_text_tablayout));
                        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_thamquan_select, 0, 0);
                        tab_layout.getTabAt(1).setCustomView(tabTwo);
                        // icon Tham quan
                        tabThree.setText(getResources().getString(R.string.txt_find_tablayoutactivity));
                        tabThree.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_tinkiem, 0, 0);
                        tab_layout.getTabAt(2).setCustomView(tabThree);
                        // icon Tìm kiếm
                        tabFour.setText(getResources().getString(R.string.txt_giohang_tablayoutactivity));
                        tabFour.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_giaohang, 0, 0);
                        tab_layout.getTabAt(3).setCustomView(tabFour);
                        // icon giỏ hàng
                        tabFive.setText(getResources().getString(R.string.txt_taikhoan_tablayoutactivity));
                        tabFive.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabFive.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_taikhoan, 0, 0);
                        tab_layout.getTabAt(4).setCustomView(tabFive);
                        break;
                    case 2:
                        tabOne.setText(getResources().getString(R.string.txt_today_tablayoutactivity));
                        tabOne.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_today, 0, 0);
                        tab_layout.getTabAt(0).setCustomView(tabOne);
                        tabTwo.setText(getResources().getString(R.string.txt_visit_tablayoutactivity));
                        tabTwo.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_thamquan, 0, 0);
                        tab_layout.getTabAt(1).setCustomView(tabTwo);
                        // icon Tham quan
                        tabThree.setText(getResources().getString(R.string.txt_find_tablayoutactivity));
                        tabThree.setTextColor(getResources().getColor(R.color.color_text_tablayout));
                        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_tiemkiem_select, 0, 0);
                        tab_layout.getTabAt(2).setCustomView(tabThree);
                        // icon Tìm kiếm
                        tabFour.setText(getResources().getString(R.string.txt_giohang_tablayoutactivity));
                        tabFour.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_giaohang, 0, 0);
                        tab_layout.getTabAt(3).setCustomView(tabFour);
                        // icon giỏ hàng
                        tabFive.setText(getResources().getString(R.string.txt_taikhoan_tablayoutactivity));
                        tabFive.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabFive.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_taikhoan, 0, 0);
                        tab_layout.getTabAt(4).setCustomView(tabFive);
                        break;
                    case 3:
                        tabOne.setText(getResources().getString(R.string.txt_today_tablayoutactivity));
                        tabOne.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_today, 0, 0);
                        tab_layout.getTabAt(0).setCustomView(tabOne);
                        tabTwo.setText(getResources().getString(R.string.txt_visit_tablayoutactivity));
                        tabTwo.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_thamquan, 0, 0);
                        tab_layout.getTabAt(1).setCustomView(tabTwo);
                        // icon Tham quan
                        tabThree.setText(getResources().getString(R.string.txt_find_tablayoutactivity));
                        tabThree.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_tinkiem, 0, 0);
                        tab_layout.getTabAt(2).setCustomView(tabThree);
                        // icon Tìm kiếm
                        tabFour.setText(getResources().getString(R.string.txt_giohang_tablayoutactivity));
                        tabFour.setTextColor(getResources().getColor(R.color.color_text_tablayout));
                        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_giohang_select, 0, 0);
                        tab_layout.getTabAt(3).setCustomView(tabFour);
                        // icon giỏ hàng
                        tabFive.setText(getResources().getString(R.string.txt_taikhoan_tablayoutactivity));
                        tabFive.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabFive.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_taikhoan, 0, 0);
                        tab_layout.getTabAt(4).setCustomView(tabFive);
                        break;
                    case 4:
                        tabOne.setText(getResources().getString(R.string.txt_today_tablayoutactivity));
                        tabOne.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_today, 0, 0);
                        tab_layout.getTabAt(0).setCustomView(tabOne);
                        tabTwo.setText(getResources().getString(R.string.txt_visit_tablayoutactivity));
                        tabTwo.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_thamquan, 0, 0);
                        tab_layout.getTabAt(1).setCustomView(tabTwo);
                        // icon Tham quan
                        tabThree.setText(getResources().getString(R.string.txt_find_tablayoutactivity));
                        tabThree.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_tinkiem, 0, 0);
                        tab_layout.getTabAt(2).setCustomView(tabThree);
                        // icon Tìm kiếm
                        tabFour.setText(getResources().getString(R.string.txt_giohang_tablayoutactivity));
                        tabFour.setTextColor(getResources().getColor(R.color.color_text_tablayoutactivity));
                        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_giaohang, 0, 0);
                        tab_layout.getTabAt(3).setCustomView(tabFour);
                        // icon giỏ hàng
                        tabFive.setText(getResources().getString(R.string.txt_taikhoan_tablayoutactivity));
                        tabFive.setTextColor(getResources().getColor(R.color.color_text_tablayout));
                        tabFive.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_taikhoan_select, 0, 0);
                        tab_layout.getTabAt(4).setCustomView(tabFive);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initControl() {
        tab_layout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.viewpager_content);
        tab_layout.setupWithViewPager(mViewPager);
    }
    private void initEvent() {
        listFragment = new ArrayList();
        listFragment.add(new ToDay());
        listFragment.add(new ViSit());
        listFragment.add(new Find());
        listFragment.add(new Gio_Hang());
        listFragment.add(new Tai_Khoan());

        listTitle = new ArrayList<>();

        listTitle.add(getResources().getString(R.string.txt_today_tablayoutactivity));
        listTitle.add(getResources().getString(R.string.txt_visit_tablayoutactivity));
        listTitle.add(getResources().getString(R.string.txt_find_tablayoutactivity));
        listTitle.add(getResources().getString(R.string.txt_giohang_tablayoutactivity));
        listTitle.add(getResources().getString(R.string.txt_taikhoan_tablayoutactivity));

        adapterTabLayoutFrangment = new AdapterTabLayoutFrangment(
                getSupportFragmentManager(), TabLayOutActivity.this, listTitle, listFragment
        );

        mViewPager.setAdapter(adapterTabLayoutFrangment);
    }

    private void initDisplay() {
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.color_statusbar_tablayotactivity));
    }
    private void createTabIcons() {
        tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText(getResources().getString(R.string.txt_today_tablayoutactivity));
        tabOne.setTextColor(getResources().getColor(R.color.color_text_tablayout));
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_homnay_select, 0, 0);
        tab_layout.getTabAt(0).setCustomView(tabOne);
        // icon Hôm nay
        tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText(getResources().getString(R.string.txt_visit_tablayoutactivity));
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_thamquan, 0, 0);
        tab_layout.getTabAt(1).setCustomView(tabTwo);
        // icon Tham quan

        tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText(getResources().getString(R.string.txt_find_tablayoutactivity));
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_tinkiem, 0, 0);
        tab_layout.getTabAt(2).setCustomView(tabThree);
        // icon Tìm kiếm

        tabFour = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabFour.setText(getResources().getString(R.string.txt_giohang_tablayoutactivity));
        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_giaohang, 0, 0);
        tab_layout.getTabAt(3).setCustomView(tabFour);
        // icon giỏ hàng

        tabFive = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabFive.setText(getResources().getString(R.string.txt_taikhoan_tablayoutactivity));
        tabFive.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_taikhoan, 0, 0);
        tab_layout.getTabAt(4).setCustomView(tabFive);
        // icon Tài khoản

    }
}
