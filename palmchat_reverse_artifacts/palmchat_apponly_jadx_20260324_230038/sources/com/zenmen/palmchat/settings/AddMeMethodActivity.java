package com.zenmen.palmchat.settings;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.eq3;
import defpackage.iq5;
import defpackage.jo6;
import defpackage.k86;
import defpackage.yg4;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AddMeMethodActivity extends BaseActionBarActivity {
    public static final String A = "AddMeMethodActivity";
    public CheckBox q;
    public CheckBox r;
    public CheckBox s;
    public CheckBox t;
    public CheckBox u;
    public eq3 v;
    public int w = 0;
    public Response.Listener<JSONObject> x = new a();
    public Response.ErrorListener y = new b();
    public CompoundButton.OnCheckedChangeListener z = new c();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<JSONObject> {
        public a() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.i(AddMeMethodActivity.A, "modify sucess");
            iq5.j(false, new String[0]);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements CompoundButton.OnCheckedChangeListener {
        public c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            String str;
            if (compoundButton == AddMeMethodActivity.this.q) {
                AddMeMethodActivity.this.P1(!z, 32);
                str = HiAnalyticsConstant.KeyAndValue.NUMBER_01;
            } else if (compoundButton == AddMeMethodActivity.this.r) {
                AddMeMethodActivity.this.P1(!z, 64);
                str = com.huawei.hms.ads.dynamic.a.t;
            } else if (compoundButton == AddMeMethodActivity.this.s) {
                AddMeMethodActivity.this.P1(!z, 128);
                str = "03";
            } else if (compoundButton == AddMeMethodActivity.this.t) {
                AddMeMethodActivity.this.P1(!z, 512);
                str = "04";
            } else if (compoundButton == AddMeMethodActivity.this.u) {
                AddMeMethodActivity.this.P1(!z, 131072);
                str = "05";
            } else {
                str = "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", str);
            } catch (Exception unused) {
            }
            LogUtil.uploadInfoImmediate("4461", z ? "5" : "6", null, jSONObject.toString());
            HashMap map = new HashMap();
            LogUtil.i(AddMeMethodActivity.A, "privacyConfig: " + AddMeMethodActivity.this.w);
            map.put("privacyConfig", Integer.valueOf(AddMeMethodActivity.this.w));
            if (AddMeMethodActivity.this.v == null) {
                AddMeMethodActivity.this.v = new eq3(AddMeMethodActivity.this.x, AddMeMethodActivity.this.y);
            }
            try {
                AddMeMethodActivity.this.v.n(map);
            } catch (DaoException e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final boolean M1(int i) {
        return yg4.a(this.w, i);
    }

    public final void N1() {
        this.w = AppContext.getContext().getTrayPreferences().b(k86.w(), 0);
    }

    public final void O1() {
        CheckBox checkBox = (CheckBox) findViewById(R.id.online_recommend_checkbox);
        this.q = checkBox;
        checkBox.setChecked(!M1(32));
        this.q.setOnCheckedChangeListener(this.z);
        if (jo6.l() || jo6.w()) {
            findViewById(R.id.newuser_recommend_layout).setVisibility(8);
            findViewById(R.id.accurate_recommend_layout).setVisibility(8);
            CheckBox checkBox2 = (CheckBox) findViewById(R.id.active_friends_recommend_checkbox);
            this.t = checkBox2;
            checkBox2.setChecked(!M1(512));
            this.t.setOnCheckedChangeListener(this.z);
        } else {
            findViewById(R.id.active_firends_recommend_layout).setVisibility(8);
            CheckBox checkBox3 = (CheckBox) findViewById(R.id.newuser_recommend_checkbox);
            this.r = checkBox3;
            checkBox3.setChecked(!M1(64));
            this.r.setOnCheckedChangeListener(this.z);
            CheckBox checkBox4 = (CheckBox) findViewById(R.id.accurate_recommend_checkbox);
            this.s = checkBox4;
            checkBox4.setChecked(!M1(128));
            this.s.setOnCheckedChangeListener(this.z);
        }
        CheckBox checkBox5 = (CheckBox) findViewById(R.id.ai_voice_checkbox);
        this.u = checkBox5;
        checkBox5.setChecked(!M1(131072));
        this.u.setOnCheckedChangeListener(this.z);
    }

    public final void P1(boolean z, int i) {
        this.w = yg4.b(this.w, z, i);
    }

    public final void initActionBar() {
        initToolbar(R.string.string_settings_find_me_by);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_addme_settings);
        N1();
        initActionBar();
        O1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        eq3 eq3Var = this.v;
        if (eq3Var != null) {
            eq3Var.onCancel();
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
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {
        public b() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
        }
    }
}
