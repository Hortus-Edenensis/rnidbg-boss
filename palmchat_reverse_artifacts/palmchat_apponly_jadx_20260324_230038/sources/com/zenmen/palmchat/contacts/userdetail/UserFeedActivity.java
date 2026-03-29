package com.zenmen.palmchat.contacts.userdetail;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.square.ui.widget.NestDynamicLifeTabHeaderView;
import com.zenmen.square.ui.widget.SquarePersonalHelper;
import defpackage.me1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class UserFeedActivity extends BaseActionBarActivity {
    public NestDynamicLifeTabHeaderView q;
    public SquarePersonalHelper r;
    public ContactInfoItem s;
    public long v;
    public int t = 0;
    public int u = 0;
    public int w = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UserFeedActivity.super.onBackPressed();
        }
    }

    public static void C1(Activity activity, ContactInfoItem contactInfoItem) {
        if (contactInfoItem != null) {
            Intent intent = new Intent(activity, (Class<?>) UserFeedActivity.class);
            intent.putExtra("extra_user", contactInfoItem);
            intent.putExtra("extra_tab", 0);
            activity.startActivity(intent);
        }
    }

    public final void B1() {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.toolbar_layout);
        findViewById(R.id.back).setOnClickListener(new a());
        ((TextView) findViewById(R.id.title_txt)).setText("选择要曝光的动态");
        viewGroup.setVisibility(0);
        ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.top_view);
        viewGroup2.setPadding(0, me1.h(this), 0, 0);
        ViewGroup.LayoutParams layoutParams = viewGroup2.getLayoutParams();
        layoutParams.height = me1.h(this);
        viewGroup2.setLayoutParams(layoutParams);
    }

    public final void initActionBar() {
        Toolbar toolbarInitToolbar = initToolbar(this.s.getNameForShow());
        setSupportActionBar(toolbarInitToolbar);
        toolbarInitToolbar.setBackgroundColor(Color.parseColor("#fafafa"));
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_user_feed);
        if (getIntent() != null) {
            this.s = (ContactInfoItem) getIntent().getParcelableExtra("extra_user");
            this.t = getIntent().getIntExtra("extra_tab", this.t);
            this.u = getIntent().getIntExtra("EXTRA_From", 0);
            this.v = getIntent().getLongExtra(SquarePersonalHelper.EXTRA_FEED_ID, -1L);
            this.w = getIntent().getIntExtra("EXTRA_From_Param", 0);
        }
        if (this.s == null) {
            finish();
            return;
        }
        initActionBar();
        this.q = (NestDynamicLifeTabHeaderView) findViewById(R.id.tab_layout);
        SquarePersonalHelper squarePersonalHelper = (SquarePersonalHelper) findViewById(R.id.dynamic_life);
        this.r = squarePersonalHelper;
        squarePersonalHelper.bind(this.q, this.u, this.v, this.w);
        boolean z = !this.s.getIsStranger();
        this.r.load(this, this.s, z, this.t);
        this.q.setVisibility(z ? 0 : 8);
        if (this.u == 2) {
            this.mToolbar.setVisibility(8);
            this.q.setVisibility(8);
            B1();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        SquarePersonalHelper squarePersonalHelper = this.r;
        if (squarePersonalHelper != null) {
            squarePersonalHelper.onDestory();
        }
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
