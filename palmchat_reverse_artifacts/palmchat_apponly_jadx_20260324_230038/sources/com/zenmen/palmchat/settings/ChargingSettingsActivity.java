package com.zenmen.palmchat.settings;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.e00;
import defpackage.eq3;
import defpackage.il5;
import defpackage.iq5;
import defpackage.k86;
import defpackage.tj2;
import defpackage.vs0;
import defpackage.yg4;
import defpackage.zn6;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ChargingSettingsActivity extends BaseActionBarActivity {
    public static final String A = "ChargingSettingsActivity";
    public eq3 q;
    public CheckBox s;
    public CheckBox t;
    public LinearLayout u;
    public CheckBox v;
    public TextView w;
    public int r = 0;
    public Response.Listener<JSONObject> x = new b();
    public Response.ErrorListener y = new c();
    public CompoundButton.OnCheckedChangeListener z = new d();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends e {
        public final /* synthetic */ URLSpan b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Activity activity, URLSpan uRLSpan) {
            super(activity);
            this.b = uRLSpan;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Activity activityA = a();
            if (activityA == null || this.b.getURL() == null) {
                return;
            }
            ChargingSettingsActivity.O1(activityA, tj2.w());
            e00.a("authentication_authorization_document_click");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            LogUtil.i(ChargingSettingsActivity.A, "updateDrawState");
            textPaint.setColor(Color.parseColor("#14CD64"));
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.Listener<JSONObject> {
        public b() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.i(ChargingSettingsActivity.A, "modify sucess");
            iq5.j(false, new String[0]);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements CompoundButton.OnCheckedChangeListener {
        public d() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            try {
                LogUtil.i(ChargingSettingsActivity.A, "----privacyConfig: " + ChargingSettingsActivity.this.r + z);
                int i = 1;
                if (compoundButton == ChargingSettingsActivity.this.s) {
                    ChargingSettingsActivity.this.N1(z, 4096);
                    JSONObject jSONObject = new JSONObject();
                    if (!z) {
                        i = 0;
                    }
                    zn6.g("1v1settings_Text", jSONObject.put("change", i));
                } else if (compoundButton == ChargingSettingsActivity.this.t) {
                    ChargingSettingsActivity.this.N1(z, 8192);
                    JSONObject jSONObject2 = new JSONObject();
                    if (!z) {
                        i = 0;
                    }
                    zn6.g("1v1settings_yuelao", jSONObject2.put("change", i));
                } else if (compoundButton == ChargingSettingsActivity.this.v) {
                    ChargingSettingsActivity.this.N1(z, 16384);
                    JSONObject jSONObject3 = new JSONObject();
                    if (!z) {
                        i = 0;
                    }
                    zn6.g("1v1settings_video", jSONObject3.put("change", i));
                }
                HashMap map = new HashMap();
                LogUtil.i(ChargingSettingsActivity.A, "privacyConfig: " + ChargingSettingsActivity.this.r + z);
                map.put("privacyConfig", Integer.valueOf(ChargingSettingsActivity.this.r));
                if (ChargingSettingsActivity.this.q == null) {
                    ChargingSettingsActivity.this.q = new eq3(ChargingSettingsActivity.this.x, ChargingSettingsActivity.this.y);
                }
                ChargingSettingsActivity.this.q.n(map);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class e extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<Activity> f15167a;

        public e(Activity activity) {
            this.f15167a = new WeakReference<>(activity);
        }

        public Activity a() {
            return this.f15167a.get();
        }
    }

    public static void O1(Activity activity, String str) {
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

    public final boolean L1(int i) {
        return yg4.a(this.r, i);
    }

    public final void M1(String str, String str2) {
        if (il5.l(str) || il5.l(str2)) {
            return;
        }
        Spanned spannedFromHtml = Html.fromHtml(k86.Q(str2.replaceAll(str, "<a href='agreement'>" + str + "</a>")));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannedFromHtml);
        try {
            for (URLSpan uRLSpan : (URLSpan[]) spannableStringBuilder.getSpans(0, spannedFromHtml.length(), URLSpan.class)) {
                spannableStringBuilder.setSpan(new a(this, uRLSpan), spannableStringBuilder.getSpanStart(uRLSpan), spannableStringBuilder.getSpanEnd(uRLSpan), spannableStringBuilder.getSpanFlags(uRLSpan));
                spannableStringBuilder.removeSpan(uRLSpan);
            }
            this.w.setText(spannableStringBuilder);
            this.w.setMovementMethod(LinkMovementMethod.getInstance());
            this.w.setHighlightColor(getResources().getColor(R.color.transparent));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void N1(boolean z, int i) {
        this.r = yg4.b(this.r, z, i);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String string;
        super.onCreate(bundle);
        setContentView(com.zenmen.palmchat.R.layout.activity_charging_settings);
        initToolbar(com.zenmen.palmchat.R.string.settings_message_charging);
        this.r = AppContext.getContext().getTrayPreferences().b(k86.w(), 0);
        this.s = (CheckBox) findViewById(com.zenmen.palmchat.R.id.chat_charging_checkbox);
        this.t = (CheckBox) findViewById(com.zenmen.palmchat.R.id.ylqx_checkbox);
        this.u = (LinearLayout) findViewById(com.zenmen.palmchat.R.id.video_charging_container);
        this.v = (CheckBox) findViewById(com.zenmen.palmchat.R.id.video_charging_checkbox);
        this.s.setChecked(L1(4096));
        this.s.setOnCheckedChangeListener(this.z);
        this.t.setChecked(L1(8192));
        this.t.setOnCheckedChangeListener(this.z);
        this.v.setChecked(L1(16384));
        this.v.setOnCheckedChangeListener(this.z);
        this.w = (TextView) findViewById(com.zenmen.palmchat.R.id.chat_charging_tips_content);
        String string2 = getString(com.zenmen.palmchat.R.string.chat_charging_tips_highlight_content);
        JSONObject config = vs0.a().getConfig("1v1settings");
        if (config != null) {
            config.optBoolean("1v1videoEnable", true);
            string = config.optString("chatDesc");
        } else {
            string = "";
        }
        this.u.setVisibility(8);
        if (il5.l(string)) {
            string = getString(com.zenmen.palmchat.R.string.chat_charging_tips_content);
        }
        M1(string2, string);
        zn6.b("pagediscover_1v1settings");
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        eq3 eq3Var = this.q;
        if (eq3Var != null) {
            eq3Var.onCancel();
        }
        super.onDestroy();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.ErrorListener {
        public c() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
        }
    }
}
