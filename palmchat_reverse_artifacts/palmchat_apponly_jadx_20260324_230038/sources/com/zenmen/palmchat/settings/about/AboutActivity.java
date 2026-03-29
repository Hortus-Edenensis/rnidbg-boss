package com.zenmen.palmchat.settings.about;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.settings.ExtraInfoActivity;
import com.zenmen.palmchat.update.AppInfo;
import com.zenmen.palmchat.update.UpdateManager;
import com.zenmen.palmchat.utils.SAppUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.utils.traceroutePing.NetDetectActivity;
import defpackage.ac1;
import defpackage.f65;
import defpackage.ir5;
import defpackage.l50;
import defpackage.nx3;
import defpackage.tj2;
import defpackage.vs0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AboutActivity extends BaseActionBarActivity {
    public static final String A = tj2.o();
    public static final String B = tj2.m();
    public TextView q;
    public View r;
    public View s;
    public ImageView t;
    public TextView u;
    public TextView v;
    public View w;
    public long x = 0;
    public int y = 0;
    public SharedPreferences z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(AboutActivity.this, CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", f65.i());
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putInt("BackgroundColor", -1);
            intent.putExtras(bundle);
            AboutActivity.this.startActivity(intent);
            LogUtil.uploadInfoImmediate("sharedlist_click", "1", null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(AboutActivity.this, CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", tj2.f());
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putInt("BackgroundColor", -1);
            intent.putExtras(bundle);
            AboutActivity.this.startActivity(intent);
            LogUtil.uploadInfoImmediate("complaint_click", null, null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            Intent intent = new Intent();
            intent.setClass(AboutActivity.this, NetDetectActivity.class);
            AboutActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            Intent intent = new Intent();
            intent.setClass(AboutActivity.this, CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", "https://beian.miit.gov.cn/#/home");
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putInt("BackgroundColor", -1);
            intent.putExtras(bundle);
            AboutActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            SAppUtil.K(AboutActivity.this.sInstance, "zenxin://activity?page=a0052&pkgId=ai-dating&urlExtra=%23%2Fnotice");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UpdateManager.G().Z();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(AboutActivity.this, CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", AboutActivity.A);
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putInt("BackgroundColor", -1);
            intent.putExtras(bundle);
            AboutActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (nx3.a("key_new_feedback")) {
                nx3.e("key_new_feedback");
            }
            Intent intent = new Intent();
            intent.setClass(AboutActivity.this, CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", AboutActivity.B);
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putInt("BackgroundColor", -1);
            intent.putExtras(bundle);
            AboutActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long jB = ir5.b();
            if (jB - AboutActivity.this.x > ViewConfiguration.getLongPressTimeout()) {
                AboutActivity.this.y = 1;
            } else {
                AboutActivity.this.y++;
                if (8 == AboutActivity.this.y) {
                    AboutActivity.this.G1();
                }
            }
            AboutActivity.this.x = jB;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(AboutActivity.this, CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", f65.b());
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putInt("BackgroundColor", -1);
            intent.putExtras(bundle);
            AboutActivity.this.startActivity(intent);
            LogUtil.uploadInfoImmediate("competence_click", "1", null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(AboutActivity.this, CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", f65.g());
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putInt("BackgroundColor", -1);
            intent.putExtras(bundle);
            AboutActivity.this.startActivity(intent);
            LogUtil.uploadInfoImmediate("expresslist_click", "1", null, null);
        }
    }

    public final void F1() {
        this.u = (TextView) findViewById(R.id.check_new_tv);
        this.v = (TextView) findViewById(R.id.version_name_tv);
        TextView textView = (TextView) findViewById(R.id.version);
        this.q = textView;
        textView.setText(getString(R.string.app_name) + AppInfo.getVersionName(this));
        findViewById(R.id.netdetect_layout).setOnClickListener(new c());
        findViewById(R.id.tv_about_beian).setOnClickListener(new d());
        findViewById(R.id.tv_suanfa_beian).setOnClickListener(new e());
        TextView textView2 = (TextView) findViewById(R.id.tv_about_copyright);
        String strB = vs0.a().b("copyrightLastYear");
        Object[] objArr = new Object[1];
        if (TextUtils.isEmpty(strB)) {
            strB = "2023";
        }
        objArr[0] = strB;
        textView2.setText(getString(R.string.about_copyright, objArr));
        View viewFindViewById = findViewById(R.id.check_new_version);
        this.r = viewFindViewById;
        viewFindViewById.setOnClickListener(new f());
        findViewById(R.id.settings_system_notify).setOnClickListener(new g());
        this.s = findViewById(R.id.sys_notification_about_feedback);
        this.w = findViewById(R.id.new3);
        findViewById(R.id.about_feedback).setOnClickListener(new h());
        ImageView imageView = (ImageView) findViewById(R.id.icon);
        this.t = imageView;
        imageView.setOnClickListener(new i());
        View viewFindViewById2 = findViewById(R.id.about_privacy);
        View viewFindViewById3 = findViewById(R.id.about_agreement);
        viewFindViewById2.setVisibility(8);
        viewFindViewById3.setVisibility(8);
        View viewFindViewById4 = findViewById(R.id.about_competence);
        if (f65.j(false)) {
            viewFindViewById4.setVisibility(0);
            LogUtil.uploadInfoImmediate("competence_show", null, null, null);
            viewFindViewById4.setOnClickListener(new j());
            ((TextView) findViewById(R.id.about_competence_label)).setText(f65.a());
        } else {
            viewFindViewById4.setVisibility(8);
        }
        View viewFindViewById5 = findViewById(R.id.about_expresslist);
        if (f65.l(false)) {
            viewFindViewById5.setVisibility(0);
            LogUtil.uploadInfoImmediate("expresslist_show", null, null, null);
            viewFindViewById5.setOnClickListener(new k());
            ((TextView) findViewById(R.id.about_expresslist_label)).setText(f65.f());
        } else {
            viewFindViewById5.setVisibility(8);
        }
        View viewFindViewById6 = findViewById(R.id.about_sharedlist);
        if (f65.m(false)) {
            viewFindViewById6.setVisibility(0);
            LogUtil.uploadInfoImmediate("sharedlist_show", null, null, null);
            viewFindViewById6.setOnClickListener(new a());
            ((TextView) findViewById(R.id.about_sharedlist_label)).setText(f65.h());
        } else {
            viewFindViewById6.setVisibility(8);
        }
        View viewFindViewById7 = findViewById(R.id.about_complaint);
        viewFindViewById7.setVisibility(0);
        viewFindViewById7.setOnClickListener(new b());
        LogUtil.uploadInfoImmediate("complaint_show", null, null, null);
        String strB2 = vs0.a().b("versionupdating_shield");
        if (strB2 == null || !strB2.contains(ac1.m)) {
            return;
        }
        this.r.setVisibility(8);
    }

    public final void G1() {
        startActivity(new Intent(this, (Class<?>) ExtraInfoActivity.class));
    }

    public final void H1() {
        if (nx3.a("key_new_feedback")) {
            this.s.setVisibility(0);
        } else {
            this.s.setVisibility(4);
        }
        if (this.z.getInt("update_versioncode", 0) <= AppInfo.getVersionCode(AppContext.getContext())) {
            this.u.setText(R.string.check_new_version);
            this.w.setVisibility(4);
            this.v.setVisibility(4);
        } else {
            this.u.setText("版本更新");
            this.w.setVisibility(0);
            this.v.setText(this.z.getString("update_versionname", ""));
            this.v.setVisibility(0);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 157;
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_app_settings_about);
        initToolbar(R.string.about);
        F1();
        this.z = PreferenceManager.getDefaultSharedPreferences(this);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onNewVersionChecked() {
        super.onNewVersionChecked();
        H1();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        H1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        super.bindMessagingService();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        super.unBindMessagingService();
    }
}
