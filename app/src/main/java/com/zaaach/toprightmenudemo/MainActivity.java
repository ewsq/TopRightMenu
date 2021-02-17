package com.zaaach.toprightmenudemo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.zaaach.toprightmenu.MenuItem;
import com.zaaach.toprightmenu.TopRightMenu;
import com.zaaach.toprightmenudemo.adapter.MyPagerAdapter;
import com.zaaach.toprightmenudemo.ui.FirstFragment;
import com.zaaach.toprightmenudemo.ui.SimpleCardFragment;
import com.zaaach.toprightmenudemo.utils.ViewFindUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnTabSelectListener {
    private Context mContext = this;
    private MyPagerAdapter mAdapter;
    private TopRightMenu mTopRightMenu;
    private ImageView moreBtn;
    private CheckBox iconCB, dimCB, animCB;

    private boolean showIcon = true;
    private boolean dimBg = true;
    private boolean needAnim = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moreBtn = (ImageView) findViewById(R.id.more);
        moreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTopRightMenu = new TopRightMenu(MainActivity.this);
                List<MenuItem> menuItems = new ArrayList<>();
                menuItems.add(new MenuItem(R.mipmap.multichat, "发起群聊"));
                menuItems.add(new MenuItem(R.mipmap.addmember, "加好友"));
                menuItems.add(new MenuItem(R.mipmap.qr_scan, "扫一扫"));
                mTopRightMenu
                        .setHeight(680)     //默认高度480
                        .setWidth(370)      //默认宽度wrap_content
                        .showIcon(showIcon)     //显示菜单图标，默认为true
                        .dimBackground(dimBg)           //背景变暗，默认为true
                        .needAnimationStyle(needAnim)   //显示动画，默认为true
                        .setAnimationStyle(R.style.TRM_ANIM_STYLE)  //默认为R.style.TRM_ANIM_STYLE
                        .addMenuList(menuItems)
                        .addMenuItem(new MenuItem(R.mipmap.facetoface, "面对面快传"))
                        .addMenuItem(new MenuItem(R.mipmap.pay, "付款"))
                        .setOnMenuItemClickListener(new TopRightMenu.OnMenuItemClickListener() {
                            @Override
                            public void onMenuItemClick(int position) {
                                Toast.makeText(MainActivity.this, "点击菜单:" + position, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .showAsDropDown(moreBtn, -230, 0);
                       //.showAsDropDown(moreBtn);
            }
        });


        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mAdapter.getFragments().add(FirstFragment.getInstance("主页"));
        /*for (String title : mAdapter.getTitles()) {
            mAdapter.getFragments().add(SimpleCardFragment.getInstance(title));
        }*/
        View decorView = getWindow().getDecorView();
        ViewPager vp = ViewFindUtils.find(decorView, R.id.vp);
        vp.setAdapter(mAdapter);

        /** tab固定宽度 */
        SlidingTabLayout tabLayout_4 = ViewFindUtils.find(decorView, R.id.tl_4);
        tabLayout_4.setViewPager(vp);
        vp.setCurrentItem(0);

    }

    @Override
    public void onTabSelect(int position) {
        Toast.makeText(mContext, "onTabSelect&position--->" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabReselect(int position) {
        Toast.makeText(mContext, "onTabReselect&position--->" + position, Toast.LENGTH_SHORT).show();
    }

}
