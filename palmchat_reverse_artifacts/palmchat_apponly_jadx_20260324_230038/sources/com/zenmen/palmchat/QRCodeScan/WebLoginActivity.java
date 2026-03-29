package com.zenmen.palmchat.QRCodeScan;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.dao.DaoException;
import defpackage.yi6;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class WebLoginActivity extends BaseActionBarActivity {
    public yi6 q;
    public String r;
    public boolean s = false;
    public TextView t;
    public TextView u;
    public TextView v;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WebLoginActivity.this.F1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WebLoginActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.Listener<JSONObject> {
        public c() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            WebLoginActivity.this.hideBaseProgressBar();
            if (jSONObject.optInt("resultCode") == 0) {
                WebLoginActivity.this.finish();
            } else {
                WebLoginActivity.this.E1();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Response.ErrorListener {
        public d() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            WebLoginActivity.this.hideBaseProgressBar();
            WebLoginActivity.this.E1();
        }
    }

    public final void C1() {
        Intent intent = getIntent();
        this.r = intent.getStringExtra("web_login_uuid");
        this.s = "web_login_success".equals(intent.getStringExtra("web_login_result"));
    }

    public final void D1() {
        TextView textView = (TextView) findViewById(R.id.login_textview);
        this.u = textView;
        textView.setOnClickListener(new a());
        TextView textView2 = (TextView) findViewById(R.id.exit_tv);
        this.t = textView2;
        textView2.setOnClickListener(new b());
        this.v = (TextView) findViewById(R.id.web_notification_tv);
        if (this.s) {
            return;
        }
        E1();
    }

    public final void E1() {
        this.u.setEnabled(false);
        this.v.setText(R.string.web_login_fail);
        this.v.setTextColor(Color.parseColor("#f95645"));
    }

    public final void F1() {
        HashMap map = new HashMap();
        map.put(Constant.MAP_KEY_UUID, this.r);
        if (this.q == null) {
            this.q = new yi6(new c(), new d());
        }
        try {
            this.q.n(map);
            showBaseProgressBar(getString(R.string.progress_sending), false, false);
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_web_login);
        C1();
        D1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        yi6 yi6Var = this.q;
        if (yi6Var != null) {
            yi6Var.onCancel();
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
}
