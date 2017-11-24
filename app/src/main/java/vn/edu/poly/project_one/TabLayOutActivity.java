package vn.edu.poly.project_one;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_tablayout);
        initControl();
        initEvent();
        initDisplay();
        createTabIcons();

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
        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText(getResources().getString(R.string.txt_today_tablayoutactivity));
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.today, 0, 0);
        tab_layout.getTabAt(0).setCustomView(tabOne);
        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText(getResources().getString(R.string.txt_visit_tablayoutactivity));
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.today, 0, 0);
        tab_layout.getTabAt(1).setCustomView(tabTwo);
        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText(getResources().getString(R.string.txt_find_tablayoutactivity));
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.today, 0, 0);
        tab_layout.getTabAt(2).setCustomView(tabThree);
        TextView tabFour = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabFour.setText(getResources().getString(R.string.txt_giohang_tablayoutactivity));
        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.today, 0, 0);
        tab_layout.getTabAt(3).setCustomView(tabFour);
        TextView tabFive = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabFive.setText(getResources().getString(R.string.txt_taikhoan_tablayoutactivity));
        tabFive.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.today, 0, 0);
        tab_layout.getTabAt(4).setCustomView(tabFive);
    }
}
