package com.zenmen.palmchat.settings;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.openalliance.ad.constant.w;
import com.lantern.auth.server.WkParams;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.LinkMobileActivity;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.gs;
import defpackage.h00;
import defpackage.iq5;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.y63;
import defpackage.yy2;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ValidateMobileActivity extends BaseActionBarActivity {
    public h00 q;
    public gs r = new a().f(false);
    public String s;
    public String t;
    public String u;
    public EditText v;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends gs {

        /* JADX INFO: renamed from: com.zenmen.palmchat.settings.ValidateMobileActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1102a extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ JSONObject f15252a;

            public C1102a(JSONObject jSONObject) {
                this.f15252a = jSONObject;
                put("action", "validate_sms");
                put("status", "success");
                put("detail", jSONObject);
                put("phone_number", ValidateMobileActivity.this.s);
                put("type", 3);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {
            public b() {
                put("action", "validate_sms");
                put("status", "fail");
                put("phone_number", ValidateMobileActivity.this.s);
                put("type", 3);
            }
        }

        public a() {
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            ValidateMobileActivity.this.hideBaseProgressBar();
            LogUtil.i(gs.e, 3, new b(), exc);
            sy5.f(AppContext.getContext(), AppContext.getContext().getString(R.string.sent_request_failed), 0).g();
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            LogUtil.i(gs.e, 3, new C1102a(jSONObject), (Throwable) null);
            ValidateMobileActivity.this.F1(yy2Var.f22300a, yy2Var.f22300a ? yy2Var.d.optString(WkParams.SESSIONID) : null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.Listener<JSONObject> {
        public b() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            ValidateMobileActivity.this.hideBaseProgressBar();
            if (jSONObject.optInt("resultCode") != 0) {
                new sd3(ValidateMobileActivity.this).k(jSONObject.optString(MediationConstant.KEY_ERROR_MSG)).O(R.string.alert_dialog_ok).Q();
                return;
            }
            iq5.j(false, "1");
            Intent intent = new Intent(ValidateMobileActivity.this, (Class<?>) LinkMobileActivity.class);
            intent.putExtra("link_mobile_state", 1);
            intent.putExtra("phone", ValidateMobileActivity.this.s);
            intent.putExtra("ic", ValidateMobileActivity.this.t);
            ValidateMobileActivity.this.startActivity(intent);
            ValidateMobileActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.ErrorListener {
        public c() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            ValidateMobileActivity.this.hideBaseProgressBar();
        }
    }

    public final void D1() {
        Intent intent = getIntent();
        this.s = intent.getStringExtra("mobile_number");
        this.t = intent.getStringExtra(w.v);
        this.u = intent.getStringExtra("smsid");
    }

    public final void E1() {
        showBaseProgressBar(getString(R.string.progress_validating), false, false);
        this.v = (EditText) findViewById(R.id.sms_code_edit);
    }

    public final void F1(boolean z, String str) {
        if (!z) {
            hideBaseProgressBar();
            new sd3(this).j(R.string.valid_sms_code_failed).O(R.string.alert_dialog_ok).Q();
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put(WkParams.SESSIONID, str);
        map.put("newIC", this.t);
        map.put("newPhone", this.s);
        if (this.q == null) {
            this.q = new h00(new b(), new c());
        }
        try {
            this.q.n(map);
        } catch (DaoException e) {
            e.printStackTrace();
            hideBaseProgressBar();
        } catch (JSONException e2) {
            e2.printStackTrace();
            hideBaseProgressBar();
        }
    }

    public final void initActionBar() {
        initToolbar(R.string.sms_code_validate_activity_title);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_validate_mobile);
        D1();
        initActionBar();
        E1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        h00 h00Var = this.q;
        if (h00Var != null) {
            h00Var.onCancel();
        }
        super.onDestroy();
    }

    public void onNextStepClicked(View view) {
        String string = this.v.getText().toString();
        if (TextUtils.isEmpty(string)) {
            new sd3(this).T(R.string.update_install_dialog_title).j(R.string.input_right_sms_code).O(R.string.dialog_confirm).Q();
        } else {
            this.mBaseProgressDialog.show();
            y63.j().D(this.t, this.s, 3, string, this.u, this.r);
        }
    }
}
