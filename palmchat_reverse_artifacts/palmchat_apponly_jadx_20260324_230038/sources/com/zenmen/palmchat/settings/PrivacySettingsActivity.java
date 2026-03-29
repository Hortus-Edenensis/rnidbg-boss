package com.zenmen.palmchat.settings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.ZXCheckBox;
import defpackage.bo0;
import defpackage.eq3;
import defpackage.iq5;
import defpackage.k86;
import defpackage.kq3;
import defpackage.nh4;
import defpackage.nl0;
import defpackage.nx3;
import defpackage.q42;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.t66;
import defpackage.tj6;
import defpackage.uv3;
import defpackage.v4;
import defpackage.vt1;
import defpackage.yg4;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class PrivacySettingsActivity extends BaseActionBarActivity {
    public ZXCheckBox A;
    public ZXCheckBox B;
    public View C;
    public View E;
    public View F;
    public eq3 G;
    public vt1 H;
    public ContactInfoItem J;
    public CheckBox K;
    public CheckBox q;
    public CheckBox r;
    public CheckBox s;
    public CheckBox t;
    public CheckBox u;
    public ZXCheckBox v;
    public View w;
    public View x;
    public View y;
    public ZXCheckBox z;
    public int I = 0;
    public Response.Listener<JSONObject> L = new j();
    public Response.ErrorListener M = new k();
    public CompoundButton.OnCheckedChangeListener N = new l();
    public CompoundButton.OnCheckedChangeListener O = new m();
    public CompoundButton.OnCheckedChangeListener P = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ZXCheckBox.a {
        public a() {
        }

        @Override // com.zenmen.palmchat.widget.ZXCheckBox.a
        public void b(CompoundButton compoundButton, boolean z, boolean z2) {
            if (z2) {
                if (!z) {
                    PrivacySettingsActivity.this.e2(compoundButton);
                    return;
                }
                if (compoundButton == PrivacySettingsActivity.this.A) {
                    nh4.e().l(z);
                } else if (compoundButton == PrivacySettingsActivity.this.B) {
                    nh4.e().n(z);
                } else if (compoundButton == PrivacySettingsActivity.this.z) {
                    nh4.e().m(z);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends n {
        public final /* synthetic */ URLSpan b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Activity activity, URLSpan uRLSpan) {
            super(activity);
            this.b = uRLSpan;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Activity activityA = a();
            if (activityA == null || this.b.getURL() == null) {
                return;
            }
            LogUtil.i(BaseActionBarActivity.TAG, "URL-click:" + this.b.getURL());
            PrivacySettingsActivity.g2(activityA, "https://storage.lianxinapp.com/mdc/res/v5/1/9ugxnorjls-13-4-db6a0dc23931467b88e38cc93593af79-s2gt2f");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            LogUtil.i(BaseActionBarActivity.TAG, "updateDrawState");
            textPaint.setColor(PrivacySettingsActivity.this.getResources().getColor(R.color.Ga));
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompoundButton f15233a;

        public c(CompoundButton compoundButton) {
            this.f15233a = compoundButton;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            if (this.f15233a == PrivacySettingsActivity.this.A) {
                nh4.e().l(false);
            } else if (this.f15233a == PrivacySettingsActivity.this.B) {
                nh4.e().n(false);
            } else if (this.f15233a == PrivacySettingsActivity.this.z) {
                nh4.e().m(false);
            }
            super.onNegative(materialDialog);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            ((ZXCheckBox) this.f15233a).setChecked(true, false);
            super.onPositive(materialDialog);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompoundButton f15234a;
        public final /* synthetic */ boolean b;

        public d(CompoundButton compoundButton, boolean z) {
            this.f15234a = compoundButton;
            this.b = z;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            PrivacySettingsActivity.this.c2(!this.b, 1);
            HashMap map = new HashMap();
            map.put("privacyConfig", Integer.valueOf(PrivacySettingsActivity.this.I));
            if (PrivacySettingsActivity.this.G == null) {
                PrivacySettingsActivity.this.G = new eq3(PrivacySettingsActivity.this.L, PrivacySettingsActivity.this.M);
            }
            try {
                PrivacySettingsActivity.this.G.n(map);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            this.f15234a.setChecked(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(PrivacySettingsActivity.this, AddMeMethod2Activity.class);
            PrivacySettingsActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtil.uploadInfoImmediate("446", "1", null, null);
            Intent intent = new Intent();
            intent.setClass(PrivacySettingsActivity.this, AddMeMethodActivity.class);
            PrivacySettingsActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (nx3.a("key_new_blacklist")) {
                nx3.e("key_new_blacklist");
                PrivacySettingsActivity.this.h2();
            }
            Intent intent = new Intent();
            intent.setClass(PrivacySettingsActivity.this, BlackListActivity.class);
            PrivacySettingsActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(PrivacySettingsActivity.this, PermissionManagerActivity.class);
            PrivacySettingsActivity.this.startActivity(intent);
            LogUtil.uploadInfoImmediate("authoritym_click", "1", null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PrivacySettingsActivity.this.startActivity(tj6.a(PrivacySettingsActivity.this, nl0.q + "/dpinfo/", true, false));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements Response.Listener<JSONObject> {
        public j() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            iq5.j(false, new String[0]);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements CompoundButton.OnCheckedChangeListener {
        public l() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton != PrivacySettingsActivity.this.q) {
                if (compoundButton == PrivacySettingsActivity.this.r) {
                    LogUtil.uploadInfoImmediate("442", z ? "5" : "6", null, null);
                    PrivacySettingsActivity.this.c2(!z, 2);
                } else if (compoundButton == PrivacySettingsActivity.this.s) {
                    PrivacySettingsActivity.this.c2(!z, 4);
                } else if (compoundButton == PrivacySettingsActivity.this.t) {
                    PrivacySettingsActivity.this.c2(!z, 8);
                } else if (compoundButton == PrivacySettingsActivity.this.u) {
                    PrivacySettingsActivity.this.c2(!z, 2048);
                    LogUtil.uploadInfoImmediate("4511", z ? "5" : "6", null, null);
                } else if (compoundButton == PrivacySettingsActivity.this.K) {
                    uv3.E(z, 2);
                    LogUtil.d("", "mPopAdCheckbox onCheckedChanged checked:" + z);
                }
            } else {
                if (!z && q42.a() && PrivacySettingsActivity.this.J != null && PrivacySettingsActivity.this.J.getGender() == 1) {
                    PrivacySettingsActivity privacySettingsActivity = PrivacySettingsActivity.this;
                    privacySettingsActivity.d2(privacySettingsActivity.q, z);
                    return;
                }
                PrivacySettingsActivity.this.c2(!z, 1);
            }
            HashMap map = new HashMap();
            map.put("privacyConfig", Integer.valueOf(PrivacySettingsActivity.this.I));
            if (PrivacySettingsActivity.this.G == null) {
                PrivacySettingsActivity.this.G = new eq3(PrivacySettingsActivity.this.L, PrivacySettingsActivity.this.M);
            }
            try {
                PrivacySettingsActivity.this.G.n(map);
            } catch (DaoException e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m extends ZXCheckBox.a {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Response.Listener<JSONObject> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f15243a;

            public a(int i) {
                this.f15243a = i;
            }

            @Override // com.android.volley.Response.Listener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponse(JSONObject jSONObject) {
                boolean z = false;
                if (jSONObject != null) {
                    try {
                        if (jSONObject.optInt("resultCode", -1) == 0) {
                            kq3.a().e(this.f15243a);
                            iq5.j(false, new String[0]);
                            z = true;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (z) {
                    return;
                }
                PrivacySettingsActivity.this.i2();
                PrivacySettingsActivity.this.f2();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Response.ErrorListener {
            public b() {
            }

            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                PrivacySettingsActivity.this.i2();
                PrivacySettingsActivity.this.f2();
            }
        }

        public m() {
        }

        @Override // com.zenmen.palmchat.widget.ZXCheckBox.a
        public void b(CompoundButton compoundButton, boolean z, boolean z2) {
            if (z2) {
                HashMap map = new HashMap();
                map.put("public_", Integer.valueOf(z ? 1 : 0));
                map.put("random", Long.toString(Calendar.getInstance().getTimeInMillis()));
                String strE = v4.e(com.zenmen.palmchat.c.b());
                if (!TextUtils.isEmpty(strE)) {
                    try {
                        map.put(DeviceInfoUtil.UID_TAG, Long.valueOf(Long.parseLong(strE)));
                    } catch (Exception unused) {
                    }
                }
                if (PrivacySettingsActivity.this.H == null) {
                    PrivacySettingsActivity.this.H = new vt1();
                }
                try {
                    PrivacySettingsActivity.this.H.n(map, new a(z ? 1 : 0), new b());
                } catch (DaoException e) {
                    e.printStackTrace();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("time", System.currentTimeMillis());
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                LogUtil.uploadInfoImmediate("447", z ? "5" : "6", null, jSONObject.toString());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class n extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<Activity> f15245a;

        public n(Activity activity) {
            this.f15245a = new WeakReference<>(activity);
        }

        public Activity a() {
            return this.f15245a.get();
        }
    }

    public static void g2(Activity activity, String str) {
        LogUtil.onEvent("903", null, null, null);
        Intent intent = new Intent();
        intent.setClass(activity, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", str);
        bundle.putBoolean("web_show_right_menu", false);
        bundle.putInt("BackgroundColor", -1);
        intent.putExtra("needCheckAccount", false);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public final CharSequence Y1(CompoundButton compoundButton) {
        if (compoundButton == this.A) {
            return getString(R.string.string_settings_privacy_personalized_ad_dialog_msg);
        }
        if (compoundButton == this.B) {
            return getString(R.string.string_settings_privacy_personalized_smallvideo_dialog_msg);
        }
        if (compoundButton != this.z) {
            return null;
        }
        Spanned spannedFromHtml = Html.fromHtml("关闭个性化内容推荐后，你将不再收到基于你个人特征推荐的内容<br/><br/><a href='agreement'>了解《个性化内容推荐的基本原理》</a>");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannedFromHtml);
        try {
            for (URLSpan uRLSpan : (URLSpan[]) spannableStringBuilder.getSpans(0, spannedFromHtml.length(), URLSpan.class)) {
                spannableStringBuilder.setSpan(new b(this, uRLSpan), spannableStringBuilder.getSpanStart(uRLSpan), spannableStringBuilder.getSpanEnd(uRLSpan), spannableStringBuilder.getSpanFlags(uRLSpan));
                spannableStringBuilder.removeSpan(uRLSpan);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return spannableStringBuilder;
    }

    public final boolean Z1(int i2) {
        return yg4.a(this.I, i2);
    }

    public final void a2() {
        this.J = bo0.r().l(AccountUtils.p(AppContext.getContext()));
        this.I = AppContext.getContext().getTrayPreferences().b(k86.w(), 0);
    }

    public final void b2() {
        findViewById(R.id.search_by_phone_layout).setVisibility(com.zenmen.palmchat.activity.search.c.h() ? 0 : 8);
        this.x = findViewById(R.id.red_dot_clear);
        CheckBox checkBox = (CheckBox) findViewById(R.id.frind_confirmation_checkbox);
        this.q = checkBox;
        checkBox.setChecked(!Z1(1));
        this.q.setOnCheckedChangeListener(this.N);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.find_mobile_contacts_checkbox);
        this.r = checkBox2;
        checkBox2.setChecked(!Z1(2));
        this.r.setOnCheckedChangeListener(this.N);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.friend_search_zxid);
        this.s = checkBox3;
        checkBox3.setChecked(!Z1(4));
        this.s.setOnCheckedChangeListener(this.N);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.find_may_know_checkbox);
        this.u = checkBox4;
        checkBox4.setChecked(!Z1(2048));
        this.u.setOnCheckedChangeListener(this.N);
        View viewFindViewById = findViewById(R.id.find_may_know);
        this.F = viewFindViewById;
        viewFindViewById.setVisibility(0);
        CheckBox checkBox5 = (CheckBox) findViewById(R.id.friend_search_phone);
        this.t = checkBox5;
        checkBox5.setChecked(!Z1(8));
        this.t.setOnCheckedChangeListener(this.N);
        this.w = findViewById(R.id.setting_blacklist);
        this.C = findViewById(R.id.setting_find_me_by);
        View viewFindViewById2 = findViewById(R.id.setting_find_me_by2);
        if (t66.h().f("LX-66259", false)) {
            viewFindViewById2.setVisibility(0);
            this.C.setVisibility(8);
            viewFindViewById2.setOnClickListener(new e());
        } else {
            viewFindViewById2.setVisibility(8);
            this.C.setVisibility(0);
            this.C.setOnClickListener(new f());
        }
        this.w.setVisibility(0);
        this.w.setOnClickListener(new g());
        this.E = findViewById(R.id.privacy_settings_moments);
        this.v = (ZXCheckBox) findViewById(R.id.privacy_settings_moments_stranger);
        this.E.setVisibility(0);
        this.v.setOnCheckedChangeListener(this.O);
        i2();
        this.y = findViewById(R.id.privacy_settings_personalized);
        if (nh4.e().i(true)) {
            ZXCheckBox zXCheckBox = (ZXCheckBox) findViewById(R.id.privacy_settings_personalized_content);
            this.z = zXCheckBox;
            zXCheckBox.setChecked(nh4.e().h());
            this.z.setOnCheckedChangeListener(this.P);
            ZXCheckBox zXCheckBox2 = (ZXCheckBox) findViewById(R.id.privacy_settings_personalized_ad);
            this.A = zXCheckBox2;
            zXCheckBox2.setChecked(nh4.e().g());
            this.A.setOnCheckedChangeListener(this.P);
            ZXCheckBox zXCheckBox3 = (ZXCheckBox) findViewById(R.id.privacy_settings_personalized_smallvideo);
            this.B = zXCheckBox3;
            zXCheckBox3.setChecked(nh4.e().k());
            this.B.setOnCheckedChangeListener(this.P);
        } else {
            this.y.setVisibility(8);
        }
        View viewFindViewById3 = findViewById(R.id.setting_permission_manager);
        viewFindViewById3.setVisibility(0);
        viewFindViewById3.setOnClickListener(new h());
        LogUtil.uploadInfoImmediate("authoritym_show", "1", null, null);
        findViewById(R.id.setting_self_info_export).setOnClickListener(new i());
        this.K = (CheckBox) findViewById(R.id.privacy_settings_ad_pop);
        boolean zP = uv3.p();
        LogUtil.d("", "mPopAdCheckbox init res:" + zP);
        this.K.setChecked(zP);
        this.K.setOnCheckedChangeListener(this.N);
        uv3.E(zP, 1);
    }

    public final void c2(boolean z, int i2) {
        this.I = yg4.b(this.I, z, i2);
    }

    public final void d2(CompoundButton compoundButton, boolean z) {
        new sd3(this).T(R.string.feed_privacy_stranger_title).k(getString(R.string.string_1v1_add_friend_dialog_content)).O(R.string.string_1v1_add_friend_dialog_cancel).K(R.string.string_1v1_add_friend_dialog_confirm).f(new d(compoundButton, z)).e().show();
    }

    public final void e2(CompoundButton compoundButton) {
        new sd3(this).T(R.string.feed_privacy_stranger_title).k(Y1(compoundButton)).K(R.string.alert_dialog_ok).J(R.color.manychats_materialdialog_negative_color).O(R.string.alert_dialog_cancel).N(R.color.Ga).h(false).f(new c(compoundButton)).e().show();
    }

    public final void f2() {
        sy5.b();
        sy5.f(this, getString(R.string.default_response_error), 0).g();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 155;
    }

    public final void h2() {
        if (nx3.a("key_new_blacklist")) {
            this.x.setVisibility(0);
        } else {
            this.x.setVisibility(8);
        }
    }

    public final void i2() {
        this.v.setChecked(kq3.a().d(), false);
    }

    public final void initActionBar() {
        initToolbar(R.string.settings_message_privacy);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_privacy_settings);
        a2();
        initActionBar();
        b2();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        eq3 eq3Var = this.G;
        if (eq3Var != null) {
            eq3Var.onCancel();
        }
        vt1 vt1Var = this.H;
        if (vt1Var != null) {
            vt1Var.onCancel();
        }
        super.onDestroy();
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
        h2();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Response.ErrorListener {
        public k() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
        }
    }
}
