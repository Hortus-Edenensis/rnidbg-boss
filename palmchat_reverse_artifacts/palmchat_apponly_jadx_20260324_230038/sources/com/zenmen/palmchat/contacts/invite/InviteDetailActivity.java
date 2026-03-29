package com.zenmen.palmchat.contacts.invite;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ds0;
import defpackage.me1;
import defpackage.of5;
import defpackage.pf5;
import defpackage.qm5;
import defpackage.sy5;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class InviteDetailActivity extends BaseActionBarActivity {
    public String q;
    public String r;
    public String s;
    public Toolbar t;
    public TextView u;
    public TextView v;
    public pf5 w;
    public boolean x = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tphone", InviteDetailActivity.this.s);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.onImmediateClickEvent("newinvite_2", null, jSONObject.toString());
            InviteDetailActivity.this.G1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.Listener<JSONObject> {
        public b() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            JSONObject jSONObject2;
            InviteDetailActivity.this.hideBaseProgressBar();
            if (InviteDetailActivity.this.isFinishing()) {
                return;
            }
            try {
                if (jSONObject.getInt("resultCode") == 0 && (jSONObject2 = jSONObject.getJSONObject("data")) != null) {
                    String string = jSONObject2.getString("msg");
                    if (!TextUtils.isEmpty(string)) {
                        ds0.a().b(new of5(InviteDetailActivity.this.s, 1));
                        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + InviteDetailActivity.this.r));
                        intent.putExtra("sms_body", string);
                        InviteDetailActivity.this.startActivityForResult(intent, 101);
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            sy5.e(InviteDetailActivity.this, R.string.default_response_error, 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.ErrorListener {
        public c() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            InviteDetailActivity.this.hideBaseProgressBar();
            sy5.e(InviteDetailActivity.this, R.string.default_response_error, 0).g();
        }
    }

    public final void D1() {
        Toolbar toolbarInitToolbar = initToolbar("");
        this.t = toolbarInitToolbar;
        toolbarInitToolbar.setNavigationIcon(R.drawable.arrow_back_round);
        this.t.setBackgroundResource(R.color.color_trans);
        this.t.setPadding(me1.b(this, 10), 0, 0, 0);
        setSupportActionBar(this.t);
    }

    public final void E1() {
        this.u = (TextView) findViewById(R.id.nameMain);
        this.v = (TextView) findViewById(R.id.action_textview);
        this.u.setText(this.q);
        this.v.setOnClickListener(new a());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fphone", this.s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.onImmediateClickEvent("invite_4", null, jSONObject.toString());
    }

    public final void F1() {
        Intent intent = getIntent();
        this.q = intent.getStringExtra("phone_contact_local_name");
        this.r = intent.getStringExtra("phone_contact_local_phone");
        this.s = intent.getStringExtra("phone_contact_md5_phone");
    }

    public final void G1() {
        pf5 pf5Var = new pf5(new b(), new c());
        this.w = pf5Var;
        try {
            pf5Var.n(this.r.replaceAll("-", "").replaceAll(" ", ""));
            showBaseProgressBar(R.string.progress_sending, false);
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_invite_detail);
        F1();
        ds0.a().c(this);
        if (TextUtils.isEmpty(this.r) || TextUtils.isEmpty(this.s)) {
            finish();
        } else {
            D1();
            E1();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ds0.a().d(this);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.x = true;
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.x = false;
    }

    @qm5
    public void onSmsEvent(of5 of5Var) {
        String str;
        if (this.x && of5Var != null && of5Var.b() == 2 && (str = this.s) != null && str.equals(of5Var.a())) {
            finish();
        }
    }
}
