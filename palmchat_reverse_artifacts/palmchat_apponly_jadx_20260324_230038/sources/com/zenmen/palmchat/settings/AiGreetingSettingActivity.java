package com.zenmen.palmchat.settings;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.eq3;
import defpackage.iq5;
import defpackage.k86;
import defpackage.yg4;
import defpackage.zn6;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AiGreetingSettingActivity extends BaseActionBarActivity {
    public static final String x = "AiGreetingSettingActivity";
    public CheckBox q;
    public CheckBox r;
    public eq3 s;
    public int t = 0;
    public Response.Listener<JSONObject> u = new a();
    public Response.ErrorListener v = new b();
    public CompoundButton.OnCheckedChangeListener w = new c();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<JSONObject> {
        public a() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.i(AiGreetingSettingActivity.x, "modify sucess");
            iq5.j(false, new String[0]);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements CompoundButton.OnCheckedChangeListener {
        public c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            String str = "chat";
            if (compoundButton == AiGreetingSettingActivity.this.q) {
                AiGreetingSettingActivity.this.M1(!z, 4194304);
            } else if (compoundButton == AiGreetingSettingActivity.this.r) {
                AiGreetingSettingActivity.this.M1(!z, 8388608);
                str = "quick";
            }
            HashMap map = new HashMap();
            map.put("button", str);
            map.put("result", z ? "open" : "close");
            zn6.i("AiChat_entrance_panel_setpage_click", map);
            HashMap map2 = new HashMap();
            LogUtil.i(AiGreetingSettingActivity.x, "privacyConfig: " + AiGreetingSettingActivity.this.t);
            map2.put("privacyConfig", Integer.valueOf(AiGreetingSettingActivity.this.t));
            if (AiGreetingSettingActivity.this.s == null) {
                AiGreetingSettingActivity.this.s = new eq3(AiGreetingSettingActivity.this.u, AiGreetingSettingActivity.this.v);
            }
            try {
                AiGreetingSettingActivity.this.s.n(map2);
            } catch (DaoException e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final boolean J1(int i) {
        return yg4.a(this.t, i);
    }

    public final void K1() {
        this.t = AppContext.getContext().getTrayPreferences().b(k86.w(), 0);
    }

    public final void L1() {
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox1);
        this.q = checkBox;
        checkBox.setChecked(!J1(4194304));
        this.q.setOnCheckedChangeListener(this.w);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox2);
        this.r = checkBox2;
        checkBox2.setChecked(!J1(8388608));
        this.r.setOnCheckedChangeListener(this.w);
    }

    public final void M1(boolean z, int i) {
        this.t = yg4.b(this.t, z, i);
    }

    public final void initActionBar() {
        initToolbar("AI帮聊设置");
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_aigreeting_settings);
        K1();
        initActionBar();
        L1();
        zn6.b("AiChat_entrance_panel_setpage_show");
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        eq3 eq3Var = this.s;
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
