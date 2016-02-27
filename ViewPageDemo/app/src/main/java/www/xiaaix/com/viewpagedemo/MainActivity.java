package www.xiaaix.com.viewpagedemo;

import android.graphics.Color;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private List<View>viewList;
    private ViewPager pager;
    private PagerTabStrip tab;
    private List<String> titleList;
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewList=new ArrayList<View>();
        View view1=View.inflate(this, R.layout.view1, null);
        View view2=View.inflate(this, R.layout.view2, null);
        View view3=View.inflate(this, R.layout.view3, null);
        View view4=View.inflate(this, R.layout.view4, null);

        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);
        /*
        通过Fragment作为ViewPager的数据源
         */
        fragmentList=new ArrayList<Fragment>();
        fragmentList.add(new Fragment1());
        fragmentList.add(new Fragment2());
        fragmentList.add(new Fragment3());
        fragmentList.add(new Fragment4());

        //为ViewPager设置标题
        titleList =new ArrayList<String>();
        titleList.add("第一页");
        titleList.add("第二页");
        titleList.add("第三页");
        titleList.add("第四页");
        //为PagerTabStrip设置一些属性
        tab=(PagerTabStrip)findViewById(R.id.tab);
        tab.setBackgroundColor(Color.YELLOW);
        tab.setTextColor(Color.RED);
        tab.setDrawFullUnderline(false);
        tab.setTabIndicatorColor(Color.GREEN);
        //初始化pager
        pager=(ViewPager)findViewById(R.id.pager);

        //创建PageAdapter
        MyPageAdapter adapter=new MyPageAdapter(viewList,titleList);
        //ViewPager加载适配器
        //pager.setAdapter(adapter);
        MyFragmentPagerAdapter adapter2=new MyFragmentPagerAdapter(getSupportFragmentManager(),fragmentList,titleList);
        pager.setAdapter(adapter2);
        MyFragmentPagerAdapter2 adapter3=new MyFragmentPagerAdapter2(getSupportFragmentManager(),fragmentList,titleList);
        pager.setAdapter(adapter3);





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
