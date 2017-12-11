package vn.edu.poly.project_one.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by ASUS on 12/11/2017.
 */

public class AdapterTabLayoutFrangment_Manage extends FragmentPagerAdapter {
    Context context;
    ArrayList<String> list_title_tab;
    ArrayList<Fragment> list_fragment;
    private int page_count = 5;

    public AdapterTabLayoutFrangment_Manage(FragmentManager fm, Context context, ArrayList<String> list_title_tab, ArrayList<Fragment> list_fragment) {
        super(fm);
        this.context = context;
        this.list_title_tab = list_title_tab;
        this.list_fragment = list_fragment;
    }

    public AdapterTabLayoutFrangment_Manage(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return list_fragment.get(position);
    }

    @Override
    public int getCount() {
        return list_title_tab.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return  list_title_tab.get(position);
    }
}
