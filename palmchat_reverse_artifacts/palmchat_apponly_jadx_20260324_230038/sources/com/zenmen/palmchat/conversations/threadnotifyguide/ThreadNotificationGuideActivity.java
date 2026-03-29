package com.zenmen.palmchat.conversations.threadnotifyguide;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.me1;
import defpackage.s34;
import defpackage.y24;
import java.io.IOException;
import pl.droidsonroids.gif.GifImageView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ThreadNotificationGuideActivity extends BaseActionBarActivity {
    public View q;
    public View r;
    public View s;
    public View t;
    public View u;
    public View v;
    public int w = 0;
    public int x = -1;
    public boolean y = true;
    public boolean z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtil.uploadInfoImmediate("ntg32", null, null, y24.c(Integer.valueOf(ThreadNotificationGuideActivity.this.w), null));
            y24.k();
            ThreadNotificationGuideActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtil.uploadInfoImmediate("ntg31", null, null, y24.c(Integer.valueOf(ThreadNotificationGuideActivity.this.w), null));
            com.zenmen.palmchat.utils.a.E().y0(ThreadNotificationGuideActivity.this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtil.uploadInfoImmediate("ntg41", null, null, y24.c(Integer.valueOf(ThreadNotificationGuideActivity.this.w), null));
            ThreadNotificationGuideActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.zenmen.palmchat.utils.a.E().y0(ThreadNotificationGuideActivity.this);
        }
    }

    public final void B1(Window window, int i) {
        int i2 = Build.VERSION.SDK_INT;
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        if (i2 < 23) {
            window.setStatusBarColor(com.zenmen.palmchat.c.b().getResources().getColor(R.color.color_lollipop_status_bar));
            return;
        }
        window.setStatusBarColor(i);
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
    }

    public final void C1(int i) {
        if (!this.z) {
            findViewById(R.id.container).setPadding(0, me1.h(this), 0, 0);
        }
        this.q = findViewById(R.id.guide_layout);
        this.s = findViewById(R.id.new_guide_layout);
        this.r = findViewById(R.id.success_layout);
        this.t = findViewById(R.id.action_open);
        this.u = findViewById(R.id.action_ok);
        View viewFindViewById = findViewById(R.id.ignore);
        this.v = viewFindViewById;
        viewFindViewById.setOnClickListener(new a());
        this.t.setOnClickListener(new b());
        this.u.setOnClickListener(new c());
        findViewById(R.id.tv_go_open).setOnClickListener(new d());
        try {
            ((GifImageView) findViewById(R.id.gifview)).setImageDrawable(new pl.droidsonroids.gif.a(getAssets(), "gif_toggle.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        D1(i);
    }

    public final void D1(int i) {
        if (i != 0) {
            this.q.setVisibility(8);
            this.s.setVisibility(8);
            this.r.setVisibility(0);
            return;
        }
        if (this.z) {
            this.q.setVisibility(8);
            this.s.setVisibility(0);
            TextView textView = (TextView) findViewById(R.id.tv_title);
            TextView textView2 = (TextView) findViewById(R.id.tv_desc);
            ExtraInfo extraInfoD = y24.d();
            if (extraInfoD != null) {
                textView.setText(extraInfoD.homeDialogTitle);
                textView2.setText(extraInfoD.homeDialogContent);
            }
            setSupportActionBar(initToolbar("开启通知"));
        } else {
            this.q.setVisibility(0);
            this.s.setVisibility(8);
        }
        this.r.setVisibility(8);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        LogUtil.uploadInfoImmediate("ntg42", null, null, y24.c(Integer.valueOf(this.w), Boolean.valueOf(s34.c() != 0)));
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_thread_notification_guide);
        this.z = getIntent().getBooleanExtra("key_notify_style", false);
        this.w = y24.f() + 1;
        if (!this.z) {
            B1(getWindow(), getResources().getColor(R.color.white));
        }
        int iC = s34.c();
        this.x = iC;
        C1(iC);
        LogUtil.uploadInfoImmediate("ntg3", null, null, y24.c(Integer.valueOf(this.w), null));
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        int iC = s34.c();
        if (this.x != iC) {
            this.x = iC;
            if (iC != 0) {
                LogUtil.uploadInfoImmediate("ntg4", null, null, y24.c(Integer.valueOf(this.w), null));
                if (this.y) {
                    y24.k();
                    this.y = false;
                }
            } else {
                LogUtil.uploadInfoImmediate("ntg3", null, null, y24.c(Integer.valueOf(this.w), null));
            }
        }
        D1(iC);
    }
}
