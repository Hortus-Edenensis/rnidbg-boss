package com.zenmen.palmchat.circle.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleMyGroupActivity extends BaseActionBarActivity {
    public String[] q = {"我创建的", "我管理的", "我加入的"};
    public List<CircleGroupFragment> r = new ArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends FragmentStatePagerAdapter {
        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return CircleMyGroupActivity.this.q.length;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return (Fragment) CircleMyGroupActivity.this.r.get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return CircleMyGroupActivity.this.q[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E1(View view) {
        Intent intent = new Intent(this, (Class<?>) CircleSearchActivity.class);
        intent.putExtra("intentFrom", 1);
        startActivity(intent);
    }

    public final void D1() {
        Toolbar toolbarInitToolbar = initToolbar("群聊");
        this.r.add(CircleGroupFragment.l0(1));
        this.r.add(CircleGroupFragment.l0(2));
        this.r.add(CircleGroupFragment.l0(3));
        setSupportActionBar(toolbarInitToolbar);
        findViewById(R.id.lin_search).setOnClickListener(new View.OnClickListener() { // from class: sa0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20691a.E1(view);
            }
        });
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new a(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager, false);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_my_group);
        D1();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
