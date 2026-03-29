package com.zenmen.palmchat.peoplenearby;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bo0;
import defpackage.cq3;
import defpackage.ds0;
import defpackage.fn0;
import defpackage.hx3;
import defpackage.iq5;
import defpackage.k86;
import defpackage.lu3;
import defpackage.oj0;
import defpackage.qm5;
import defpackage.r92;
import defpackage.sd3;
import defpackage.st2;
import defpackage.sy5;
import defpackage.vt2;
import defpackage.yy2;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CompleteGenderActivity extends BaseActionBarActivity {
    public r92 q;
    public ContactInfoItem r;
    public String s;
    public TextView t;
    public ImageView u;
    public ImageView v;
    public View w;
    public View x;
    public cq3 z;
    public int y = -1;
    public int A = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CompleteGenderActivity.this.u.setVisibility(0);
            CompleteGenderActivity.this.v.setVisibility(8);
            CompleteGenderActivity.this.y = 0;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CompleteGenderActivity.this.u.setVisibility(8);
            CompleteGenderActivity.this.v.setVisibility(0);
            CompleteGenderActivity.this.y = 1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtil.uploadInfoImmediate(CompleteGenderActivity.this.s, "310a4", null, null, null);
            CompleteGenderActivity completeGenderActivity = CompleteGenderActivity.this;
            completeGenderActivity.I1(completeGenderActivity.y);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CompleteGenderActivity.this.r = bo0.r().l(CompleteGenderActivity.this.s);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Response.Listener<JSONObject> {
        public e() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            try {
                if (jSONObject.getInt("resultCode") == 0) {
                    iq5.j(false, new String[0]);
                    Intent intent = new Intent();
                    Intent intent2 = CompleteGenderActivity.this.getIntent();
                    if (intent2 != null) {
                        if ("value_intent_from_secretary".equals(intent2.getStringExtra("intent_key_from"))) {
                            intent.putExtra("intent_key_from", "value_intent_from_secretary");
                        }
                        intent.putExtra("fromType", intent2.getIntExtra("fromType", 0));
                    }
                    if (CompleteGenderActivity.this.r == null || !TextUtils.isEmpty(CompleteGenderActivity.this.r.getSignature())) {
                        intent.setClass(CompleteGenderActivity.this, PeopleNearbyActivity.class);
                        CompleteGenderActivity.this.startActivity(intent);
                        CompleteGenderActivity.this.finish();
                    } else {
                        intent.setClass(CompleteGenderActivity.this, CompleteSignatureActivity.class);
                        intent.putExtra("fromGender", true);
                        CompleteGenderActivity.this.startActivity(intent);
                    }
                } else {
                    sy5.f(CompleteGenderActivity.this, yy2.a(jSONObject), 0).g();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            CompleteGenderActivity.this.hideBaseProgressBar();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Response.ErrorListener {
        public f() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            CompleteGenderActivity.this.hideBaseProgressBar();
            sy5.e(AppContext.getContext(), R.string.network_exception_toast, 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends MaterialDialog.e {
        public g() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            materialDialog.dismiss();
            CompleteGenderActivity.this.finish();
            lu3.a();
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            materialDialog.dismiss();
            LogUtil.uploadInfoImmediate(CompleteGenderActivity.this.s, "310a3", null, null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CompleteGenderActivity.this.finish();
        }
    }

    public final void I1(int i) {
        if (i != 1 && i != 0) {
            i = 0;
        }
        if (!hx3.m(AppContext.getContext())) {
            sy5.e(this, R.string.update_network_error, 0).g();
            return;
        }
        HashMap map = new HashMap();
        map.put("sex", i + "");
        this.z = new cq3(new e(), new f());
        try {
            showBaseProgressBar(R.string.progress_sending, false);
            this.z.n(map);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public final void J1() {
        this.u = (ImageView) findViewById(R.id.iv_check_male);
        this.v = (ImageView) findViewById(R.id.iv_check_female);
        this.w = findViewById(R.id.male_area);
        this.x = findViewById(R.id.female_area);
        this.t = (TextView) findViewById(R.id.action_button);
        ((TextView) findViewById(R.id.nearby_gender_title)).setText(st2.b());
        this.w.setOnClickListener(new a());
        this.x.setOnClickListener(new b());
        this.t.setOnClickListener(new c());
    }

    public final void K1() {
        LogUtil.uploadInfoImmediate(this.s, "310a1", null, null, null);
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.NEARBY;
        if (!sPUtil.a(scene, k86.a("nearby_complete_gender_back"), true)) {
            finish();
            lu3.a();
        } else {
            LogUtil.uploadInfoImmediate(this.s, "310a2", null, null, null);
            sPUtil.t(scene, k86.a("nearby_complete_gender_back"), Boolean.FALSE);
            new sd3(this).b(true).k(st2.a()).M(getResources().getColor(R.color.material_dialog_positive_color)).O(R.string.nearby_complete_gender_back_confirm).K(R.string.exit).I(getResources().getColor(R.color.material_dialog_button_text_color)).f(new g()).e().show();
        }
    }

    public final void L1() {
        this.r = bo0.r().l(this.s);
        r92 r92Var = new r92();
        this.q = r92Var;
        r92Var.n();
        ContactInfoItem contactInfoItem = this.r;
        if (contactInfoItem != null) {
            this.y = contactInfoItem.getGender();
        }
        if (this.y == 1) {
            this.u.setVisibility(8);
            this.v.setVisibility(0);
        } else {
            this.y = 0;
            this.u.setVisibility(0);
            this.v.setVisibility(8);
        }
    }

    public final void M1() {
        LogUtil.uploadInfoImmediate(this.s, "310a", null, null, String.valueOf(this.A));
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        K1();
    }

    @qm5
    public void onCompleteProfileEvent(oj0 oj0Var) {
        runOnUiThread(new h());
    }

    @qm5
    public void onContactChanged(fn0 fn0Var) {
        runOnUiThread(new d());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_complete_gender);
        setSupportActionBar(initToolbar(R.string.nearby_complete_profile));
        this.s = AccountUtils.p(AppContext.getContext());
        J1();
        if (getIntent() != null) {
            this.A = getIntent().getIntExtra("fromType", 0);
            vt2.d(this, getIntent().getExtras());
        }
        M1();
        bo0.r().i().j(this);
        ds0.a().c(this);
        L1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        cq3 cq3Var = this.z;
        if (cq3Var != null) {
            cq3Var.onCancel();
        }
        bo0.r().i().l(this);
        ds0.a().d(this);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        K1();
        return true;
    }
}
