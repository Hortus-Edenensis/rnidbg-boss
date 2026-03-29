package com.zenmen.palmchat.settings;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.ss.android.ttvecamera.BuildConfig;
import com.wifi.ad.core.interactive.WkInteractiveManager;
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
public class AddMeMethod2Activity extends BaseActionBarActivity {
    public static final String y = "AddMeMethod2Activity";
    public CheckBox q;
    public CheckBox r;
    public CheckBox s;
    public eq3 t;
    public int u = 0;
    public Response.Listener<JSONObject> v = new a();
    public Response.ErrorListener w = new b();
    public CompoundButton.OnCheckedChangeListener x = new c();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<JSONObject> {
        public a() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.i(AddMeMethod2Activity.y, "modify sucess");
            iq5.j(false, new String[0]);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements CompoundButton.OnCheckedChangeListener {
        public c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            int i = 1;
            if (compoundButton == AddMeMethod2Activity.this.q) {
                AddMeMethod2Activity.this.N1(!z, 524288);
            } else if (compoundButton == AddMeMethod2Activity.this.r) {
                AddMeMethod2Activity.this.N1(!z, 1048576);
                i = 2;
            } else if (compoundButton == AddMeMethod2Activity.this.s) {
                AddMeMethod2Activity.this.N1(!z, 2097152);
                i = 3;
            }
            HashMap map = new HashMap();
            map.put("option", String.valueOf(i));
            map.put("action", z ? BuildConfig.USE_CLOUD_CONFIG : WkInteractiveManager.TimingTypeOff);
            zn6.i("setting_findmyway", map);
            HashMap map2 = new HashMap();
            LogUtil.i(AddMeMethod2Activity.y, "privacyConfig: " + AddMeMethod2Activity.this.u);
            map2.put("privacyConfig", Integer.valueOf(AddMeMethod2Activity.this.u));
            if (AddMeMethod2Activity.this.t == null) {
                AddMeMethod2Activity.this.t = new eq3(AddMeMethod2Activity.this.v, AddMeMethod2Activity.this.w);
            }
            try {
                AddMeMethod2Activity.this.t.n(map2);
            } catch (DaoException e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final boolean K1(int i) {
        return yg4.a(this.u, i);
    }

    public final void L1() {
        this.u = AppContext.getContext().getTrayPreferences().b(k86.w(), 0);
    }

    public final void M1() {
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox_city);
        this.q = checkBox;
        checkBox.setChecked(!K1(524288));
        this.q.setOnCheckedChangeListener(this.x);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox_receive_sys_match);
        this.r = checkBox2;
        checkBox2.setChecked(!K1(1048576));
        this.r.setOnCheckedChangeListener(this.x);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkbox_recommend_sys_match);
        this.s = checkBox3;
        checkBox3.setChecked(!K1(2097152));
        this.s.setOnCheckedChangeListener(this.x);
    }

    public final void N1(boolean z, int i) {
        this.u = yg4.b(this.u, z, i);
    }

    public final void initActionBar() {
        initToolbar("添加/推荐我的方式");
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_addme_settings2);
        L1();
        initActionBar();
        M1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        eq3 eq3Var = this.t;
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
