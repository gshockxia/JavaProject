package www.xiaaix.com.viewpagedemo;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Monster on 2016/2/14.
 */
public class MyPageAdapter extends PagerAdapter{

    private List<View>viewList;
    private List<String>titleList;

    public MyPageAdapter(List<View>viewList,List<String>titleList)
    {
        this.viewList=viewList;
        this.titleList=titleList;
    }
    /*
    返回的是页卡的数量
     */
    @Override
    public int getCount() {
        return viewList.size();
    }

    /*
    View是否来自对象
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    /*
    实例化一个页卡
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    /*
     *设置Viewpager页卡的标题
     */

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    /*
        销毁一个页卡
         */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }
}
