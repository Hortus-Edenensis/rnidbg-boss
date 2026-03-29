package com.zenmen.palmchat.settings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.settings.about.AboutActivity;
import com.zenmen.palmchat.settings.cert.MyCertActivity;
import com.zenmen.palmchat.settings.view.AppExitOptionDialog;
import com.zenmen.palmchat.teenagersmode.TeenagersModeActivity;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.test.TestActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.CommonInfoCellView;
import defpackage.ap3;
import defpackage.e00;
import defpackage.f65;
import defpackage.fn2;
import defpackage.hx3;
import defpackage.ir5;
import defpackage.l50;
import defpackage.nl0;
import defpackage.nx3;
import defpackage.q42;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.tj2;
import defpackage.ve;
import defpackage.vs0;
import defpackage.ym4;
import defpackage.zn6;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AppSettingsActivity extends BaseActionBarActivity {
    public View q;
    public View r;
    public View s;
    public View t;
    public View u;
    public View v;
    public TextView w;
    public SharedPreferences x;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            AppSettingsActivity.this.startActivity(new Intent(AppSettingsActivity.this, (Class<?>) PrivacySettingsActivity.class));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (nx3.a("key_new_common_setting")) {
                nx3.e("key_new_common_setting");
                AppSettingsActivity.this.t.setVisibility(8);
            }
            AppSettingsActivity.this.startActivity(new Intent(AppSettingsActivity.this, (Class<?>) GeneralSettingsActivity.class));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (nx3.a("key_new_account_setting")) {
                nx3.e("key_new_account_setting");
                AppSettingsActivity.this.u.setVisibility(8);
            }
            AppSettingsActivity.this.startActivity(new Intent(AppSettingsActivity.this, (Class<?>) AccountAndSafeSettingsActivity.class));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AppSettingsActivity.this.I1();
            LogUtil.uploadInfoImmediate("437", "1", null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zn6.c("widget_setting_page", "view");
            com.zenmen.palmchat.miniwidget.a.f().k(AppSettingsActivity.this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(AppSettingsActivity.this, CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", f65.b());
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putInt("BackgroundColor", -1);
            intent.putExtras(bundle);
            AppSettingsActivity.this.startActivity(intent);
            LogUtil.uploadInfoImmediate("competence_click", "1", null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ve.o(AppSettingsActivity.this, "zenxin://activity?page=a0052&pkgId=collect-msg", false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            ap3.a().B(AppSettingsActivity.this, nl0.q + "/vip/#/renewal");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(AppSettingsActivity.this, CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", f65.i());
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putInt("BackgroundColor", -1);
            intent.putExtras(bundle);
            AppSettingsActivity.this.startActivity(intent);
            LogUtil.uploadInfoImmediate("sharedlist_click", "1", null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(AppSettingsActivity.this, TeenagersModeActivity.class);
            AppSettingsActivity.this.startActivity(intent);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("status", TeenagersModeManager.a().d() ? 2 : 1);
                LogUtil.onClickEvent("click_youthmodelentrance", null, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements AppExitOptionDialog.a {

            /* JADX INFO: renamed from: com.zenmen.palmchat.settings.AppSettingsActivity$k$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C1101a extends HashMap<String, Object> {
                public C1101a() {
                    put("action", "send_message");
                    put("status", "fail");
                    put("detail", "AppSettingsReconnect");
                }
            }

            public a() {
            }

            @Override // com.zenmen.palmchat.settings.view.AppExitOptionDialog.a
            public void a(int i) {
                try {
                    fn2 messagingServiceInterface = AppSettingsActivity.this.getMessagingServiceInterface();
                    if (messagingServiceInterface != null && messagingServiceInterface.isConnected() && messagingServiceInterface.w()) {
                        messagingServiceInterface.E();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    LogUtil.i(BaseActionBarActivity.TAG, 3, new C1101a(), e);
                }
                if (i == R.id.tv_exit) {
                    AppContext.getContext().logout();
                    LogUtil.onClickEvent("4361", null, null);
                } else if (i == R.id.tv_close) {
                    AppContext.getContext().exitApp();
                }
            }
        }

        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new AppExitOptionDialog(AppSettingsActivity.this, new a()).show();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AppSettingsActivity.this.startActivity(new Intent(AppSettingsActivity.this, (Class<?>) MyCertActivity.class));
            e00.a("setup_authentication_click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(AppSettingsActivity.this, CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", ym4.e());
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putInt("BackgroundColor", -1);
            intent.putExtras(bundle);
            AppSettingsActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(AppSettingsActivity.this, CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", ym4.c());
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putInt("BackgroundColor", -1);
            intent.putExtras(bundle);
            AppSettingsActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(AppSettingsActivity.this, CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", tj2.c());
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putInt("BackgroundColor", -1);
            intent.putExtras(bundle);
            AppSettingsActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(AppSettingsActivity.this, CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", f65.d());
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putInt("BackgroundColor", -1);
            intent.putExtras(bundle);
            AppSettingsActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15140a;

        public q(String str) {
            this.f15140a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(AppSettingsActivity.this, CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", this.f15140a);
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putBoolean("hide_toolbar", true);
            bundle.putBoolean("hide_progressbar", true);
            bundle.putInt("BackgroundColor", -1);
            intent.putExtras(bundle);
            AppSettingsActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r extends MaterialDialog.e {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("action", "send_message");
                put("status", "fail");
                put("detail", "AppSettingsSwitchAccount");
            }
        }

        public r() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            if (!hx3.m(AppSettingsActivity.this)) {
                AppSettingsActivity appSettingsActivity = AppSettingsActivity.this;
                sy5.f(appSettingsActivity, appSettingsActivity.getString(R.string.net_operation_fail), 1).g();
                return;
            }
            LogUtil.uploadInfoImmediate("4371", "1", null, null);
            try {
                fn2 messagingServiceInterface = AppSettingsActivity.this.getMessagingServiceInterface();
                if (messagingServiceInterface != null && messagingServiceInterface.isConnected() && messagingServiceInterface.w()) {
                    messagingServiceInterface.E();
                }
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.i(BaseActionBarActivity.TAG, 3, new a(), e);
            }
            AppContext.getContext().logout(false, true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s implements View.OnClickListener {
        public s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            AppSettingsActivity.this.startActivity(new Intent(AppSettingsActivity.this, (Class<?>) ChargingSettingsActivity.class));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t implements View.OnClickListener {
        public t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(AppSettingsActivity.this, AboutActivity.class);
            AppSettingsActivity.this.startActivity(intent);
            LogUtil.uploadInfoImmediate("aboutlx_click", "1", null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u implements View.OnClickListener {
        public u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(AppSettingsActivity.this, VenusPrivacyActivity.class);
            AppSettingsActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class v implements View.OnClickListener {
        public v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(AppSettingsActivity.this, TestActivity.class);
            AppSettingsActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class w implements View.OnClickListener {
        public w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(AppSettingsActivity.this, MessageNotifySettingsActivity.class);
            AppSettingsActivity.this.startActivity(intent);
            if (com.zenmen.palmchat.utils.a.E().d0()) {
                if (AppSettingsActivity.this.v.getVisibility() == 0) {
                    AppSettingsActivity.this.G1();
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(TtmlNode.TEXT_EMPHASIS_MARK_DOT, AppSettingsActivity.this.v.getVisibility() == 0);
                    LogUtil.onNotifyClickEvent("4323", null, jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class y implements View.OnClickListener {
        public y() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (nx3.a("key_new_chat_setting")) {
                nx3.e("key_new_chat_setting");
                AppSettingsActivity.this.r.setVisibility(4);
            }
            AppSettingsActivity.this.startActivity(new Intent(AppSettingsActivity.this, (Class<?>) ChatSettingsActivity.class));
        }
    }

    public final void G1() {
        if (com.zenmen.palmchat.utils.a.E().d0()) {
            this.x.edit().putLong("notify_red_dot_time", ir5.b()).apply();
            K1();
        }
    }

    public final boolean H1() {
        if (com.zenmen.palmchat.utils.a.E().N() && !com.zenmen.palmchat.utils.a.E().X()) {
            if (ir5.b() - this.x.getLong("notify_red_dot_time", 0L) > 259200000) {
                return true;
            }
        }
        return false;
    }

    public final void I1() {
        new sd3(this).T(R.string.switch_account_title).j(R.string.switch_account_content).O(R.string.alert_dialog_ok).K(R.string.alert_dialog_cancel).f(new r()).e().show();
    }

    public final void J1() {
        String string = this.x.getString("system_preference_about_zx", "0");
        if (string.equals("0")) {
            if (nx3.a("key_new_feedback")) {
                this.q.setVisibility(0);
                return;
            } else {
                this.q.setVisibility(4);
                return;
            }
        }
        if (string.equals("1")) {
            this.q.setVisibility(4);
        } else {
            this.q.setVisibility(0);
        }
    }

    public final void K1() {
        if (com.zenmen.palmchat.utils.a.E().d0() && this.v.getVisibility() == 0 && !H1()) {
            this.v.setVisibility(4);
        }
    }

    public final void L1() {
        if (nx3.a("key_new_blacklist")) {
            this.s.setVisibility(0);
        } else {
            this.s.setVisibility(4);
        }
    }

    public final void M1() {
        String strOptString;
        boolean zOptBoolean;
        JSONObject config = vs0.a().getConfig("setting_securitycenter");
        String strOptString2 = "安全中心";
        if (config != null) {
            zOptBoolean = config.optBoolean("enable");
            strOptString2 = config.optString("name", "安全中心");
            strOptString = config.optString("url");
        } else {
            strOptString = "";
            zOptBoolean = false;
        }
        View viewFindViewById = findViewById(R.id.settings_safe_center);
        if (!zOptBoolean || TextUtils.isEmpty(strOptString)) {
            viewFindViewById.setVisibility(8);
            return;
        }
        viewFindViewById.setVisibility(0);
        ((TextView) findViewById(R.id.tv_safe_center)).setText(strOptString2);
        viewFindViewById.setOnClickListener(new q(strOptString));
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 151;
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_app_settings);
        initToolbar(R.string.settings_item_shezhi);
        this.x = PreferenceManager.getDefaultSharedPreferences(this);
        this.q = findViewById(R.id.red_dot_about);
        this.r = findViewById(R.id.red_dot_chat);
        this.s = findViewById(R.id.red_dot_privacy);
        this.t = findViewById(R.id.red_dot_common);
        this.u = findViewById(R.id.red_dot_account);
        this.w = (TextView) findViewById(R.id.teenagers_mode_status_tv);
        View viewFindViewById = findViewById(R.id.settings_teenagersMode);
        viewFindViewById.setVisibility(0);
        viewFindViewById.setOnClickListener(new j());
        findViewById(R.id.settings_exit).setOnClickListener(new k());
        View viewFindViewById2 = findViewById(R.id.charging_settings);
        if (q42.a()) {
            viewFindViewById2.setVisibility(0);
            viewFindViewById2.setOnClickListener(new s());
        } else {
            viewFindViewById2.setVisibility(8);
        }
        findViewById(R.id.settings_about).setOnClickListener(new t());
        LogUtil.uploadInfoImmediate("aboutlx_show", "1", null, null);
        ((CommonInfoCellView) findViewById(R.id.venusPrivacy)).setClickListener(new u());
        View viewFindViewById3 = findViewById(R.id.settings_test);
        viewFindViewById3.setOnClickListener(new v());
        if (!nl0.k() || nl0.h()) {
            viewFindViewById3.setVisibility(0);
        } else {
            viewFindViewById3.setVisibility(8);
        }
        findViewById(R.id.settings_message_notify).setOnClickListener(new w());
        this.v = findViewById(R.id.settings_message_notify_red_dot);
        if (com.zenmen.palmchat.utils.a.E().d0()) {
            if (H1()) {
                this.v.setVisibility(0);
                LogUtil.onNotifyEvent("4322", null, null, null);
            } else {
                this.v.setVisibility(4);
            }
        }
        findViewById(R.id.settings_no_disturb).setOnClickListener(new x());
        findViewById(R.id.settings_chat).setOnClickListener(new y());
        findViewById(R.id.settings_privacy).setOnClickListener(new a());
        findViewById(R.id.settings_common).setOnClickListener(new b());
        findViewById(R.id.settings_safe).setOnClickListener(new c());
        findViewById(R.id.switch_account).setOnClickListener(new d());
        View viewFindViewById4 = findViewById(R.id.settings_widget);
        if (com.zenmen.palmchat.miniwidget.a.f().h()) {
            viewFindViewById4.setOnClickListener(new e());
            viewFindViewById4.setVisibility(0);
        } else {
            viewFindViewById4.setVisibility(8);
        }
        View viewFindViewById5 = findViewById(R.id.settings_competence);
        if (f65.j(true)) {
            viewFindViewById5.setVisibility(0);
            LogUtil.uploadInfoImmediate("competence_show", null, null, null);
            viewFindViewById5.setOnClickListener(new f());
            ((TextView) findViewById(R.id.settings_competence_label)).setText(f65.a());
        } else {
            viewFindViewById5.setVisibility(8);
        }
        View viewFindViewById6 = findViewById(R.id.settings_expresslist);
        f65.l(true);
        viewFindViewById6.setVisibility(8);
        findViewById(R.id.setting_personal_info_connect).setOnClickListener(new g());
        findViewById(R.id.setting_personal_ai_pay).setOnClickListener(new h());
        View viewFindViewById7 = findViewById(R.id.settings_sharedlist);
        if (f65.m(true)) {
            viewFindViewById7.setVisibility(0);
            LogUtil.uploadInfoImmediate("sharedlist_show", null, null, null);
            viewFindViewById7.setOnClickListener(new i());
            ((TextView) findViewById(R.id.settings_sharedlist_label)).setText(f65.h());
        } else {
            viewFindViewById7.setVisibility(8);
        }
        findViewById(R.id.settings_my_cert).setOnClickListener(new l());
        View viewFindViewById8 = findViewById(R.id.settings_privacy_protocol);
        View viewFindViewById9 = findViewById(R.id.settings_agreement_protocol);
        View viewFindViewById10 = findViewById(R.id.settings_child_privacy_protocol);
        viewFindViewById8.setVisibility(0);
        viewFindViewById9.setVisibility(0);
        viewFindViewById10.setVisibility(0);
        viewFindViewById8.setOnClickListener(new m());
        viewFindViewById9.setOnClickListener(new n());
        viewFindViewById10.setOnClickListener(new o());
        View viewFindViewById11 = findViewById(R.id.settings_agreement_protocol_brief);
        if (f65.k()) {
            ((TextView) findViewById(R.id.protocol_brief_title)).setText(f65.c());
            viewFindViewById11.setVisibility(0);
            viewFindViewById11.setOnClickListener(new p());
        } else {
            viewFindViewById11.setVisibility(8);
        }
        M1();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (nx3.a("key_new_chat_setting")) {
            this.r.setVisibility(0);
        } else {
            this.r.setVisibility(4);
        }
        L1();
        J1();
        if (nx3.a("key_new_common_setting")) {
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(4);
        }
        if (nx3.a("key_new_account_setting")) {
            this.u.setVisibility(0);
        } else {
            this.u.setVisibility(4);
        }
        if (TeenagersModeManager.a().d()) {
            this.w.setText(R.string.teenagers_mode_on);
        } else {
            this.w.setText(R.string.teenagers_mode_off);
        }
        K1();
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

    /* JADX INFO: compiled from: SearchBox */
    public class x implements View.OnClickListener {
        public x() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}
