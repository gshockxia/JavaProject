package www.xiaaix.com.viewpagedemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

/**
 * Created by Monster on 2016/2/20 0020.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter{
    private List<Fragment>fragmentList;
    private List<String> titleList;
    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment>fragmentList,List<String> titleList) {
        super(fm);
        this.fragmentList=fragmentList;
        this.titleList=titleList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
