package com.zenmen.palmchat.contacts;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ContactRequestArgs;
import com.zenmen.palmchat.Vo.PhoneContactItem;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bo0;
import defpackage.dt2;
import defpackage.f7;
import defpackage.hs0;
import defpackage.ih;
import defpackage.iq5;
import defpackage.rn0;
import defpackage.rx4;
import defpackage.sy5;
import defpackage.vn0;
import defpackage.wh4;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class RecommendRequestSendActivity extends BaseActionBarActivity {
    public static final String M = "RecommendRequestSendActivity";
    public String A;
    public String H;
    public String L;
    public EditText q;
    public EditText r;
    public LinearLayout s;
    public ih t;
    public f7 u;
    public String v;
    public ContactInfoItem w;
    public int z;
    public int x = 0;
    public int y = 0;
    public boolean B = false;
    public boolean C = false;
    public boolean E = false;
    public long F = 0;
    public int G = -1;
    public int I = 0;
    public int J = 0;
    public boolean K = false;

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.Listener<JSONObject> {
        public c() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            RecommendRequestSendActivity.this.G = jSONObject.optInt("resultCode");
            if (RecommendRequestSendActivity.this.G == 0 || RecommendRequestSendActivity.this.G == 1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("accept_status", (Long) 2L);
                AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues, "from_uid=?", new String[]{RecommendRequestSendActivity.this.v});
                if (RecommendRequestSendActivity.this.I == 21) {
                    wh4.d(RecommendRequestSendActivity.this.w.getUid(), RecommendRequestSendActivity.this.J);
                }
                RecommendRequestSendActivity.this.F = 2L;
            }
            rn0.g(RecommendRequestSendActivity.this.v);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnFocusChangeListener {
        public f() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            RecommendRequestSendActivity.this.r.setTextColor(Color.parseColor("#4A4A4A"));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 1;
            if (!RecommendRequestSendActivity.this.E) {
                RecommendRequestSendActivity.this.U1();
            } else if (RecommendRequestSendActivity.this.G == 0 || RecommendRequestSendActivity.this.G == 1) {
                sy5.e(AppContext.getContext(), R.string.sent, 0).g();
                if (RecommendRequestSendActivity.this.F != 0) {
                    Intent intent = new Intent();
                    intent.putExtra("uid_key", RecommendRequestSendActivity.this.v);
                    intent.putExtra("accept_status", RecommendRequestSendActivity.this.F);
                    RecommendRequestSendActivity.this.setResult(-1, intent);
                }
                RecommendRequestSendActivity.this.finish();
            } else {
                RecommendRequestSendActivity.this.U1();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", RecommendRequestSendActivity.this.z);
                jSONObject.put("greet_change", RecommendRequestSendActivity.this.B ? 1 : 0);
                if (!RecommendRequestSendActivity.this.C) {
                    i = 0;
                }
                jSONObject.put("remark_change", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("add_page_send", "1", null, jSONObject.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactRequestArgs f13424a;

        public h(ContactRequestArgs contactRequestArgs) {
            this.f13424a = contactRequestArgs;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            if (iOptInt == 0) {
                RecommendRequestSendActivity.this.hideBaseProgressBar();
                iq5.j(false, new String[0]);
                wh4.h(RecommendRequestSendActivity.this.w);
                Intent intent = new Intent();
                intent.putExtra("uid_key", RecommendRequestSendActivity.this.v);
                intent.putExtra("accept_status", 1L);
                RecommendRequestSendActivity.this.setResult(-1, intent);
                RecommendRequestSendActivity.this.finish();
                return;
            }
            if (iOptInt == 1) {
                RecommendRequestSendActivity.this.V1(this.f13424a);
                return;
            }
            if (iOptInt == 1318) {
                RecommendRequestSendActivity.this.hideBaseProgressBar();
                sy5.e(RecommendRequestSendActivity.this, R.string.send_refuse, 1).g();
            } else if (iOptInt == 1320 || iOptInt == 1321) {
                RecommendRequestSendActivity.this.hideBaseProgressBar();
                rx4.b(RecommendRequestSendActivity.this, jSONObject);
            } else {
                RecommendRequestSendActivity.this.hideBaseProgressBar();
                sy5.f(RecommendRequestSendActivity.this, rx4.a(jSONObject), 0).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Response.ErrorListener {
        public i() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            RecommendRequestSendActivity.this.hideBaseProgressBar();
            sy5.e(RecommendRequestSendActivity.this, R.string.contact_apply_fail, 1).g();
            LogUtil.d(RecommendRequestSendActivity.M, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements Response.ErrorListener {
        public j() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            RecommendRequestSendActivity.this.hideBaseProgressBar();
            sy5.e(RecommendRequestSendActivity.this, R.string.contact_apply_fail, 1).g();
            LogUtil.d(RecommendRequestSendActivity.M, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Response.Listener<JSONObject> {
        public k() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            RecommendRequestSendActivity.this.hideBaseProgressBar();
            int iOptInt = jSONObject.optInt("resultCode");
            if (iOptInt == 0 || iOptInt == 1) {
                Intent intent = new Intent();
                if (RecommendRequestSendActivity.this.K) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("accept_status", (Long) 2L);
                    contentValues.put("request_type", (Integer) 0);
                    String str = AccountUtils.p(AppContext.getContext()) + "_" + RecommendRequestSendActivity.this.v;
                    contentValues.put("rid", str);
                    AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues, "from_uid=?", new String[]{RecommendRequestSendActivity.this.v});
                    intent.putExtra("revertRid", str);
                } else {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("accept_status", (Long) 2L);
                    AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues2, "from_uid=?", new String[]{RecommendRequestSendActivity.this.v});
                }
                if (RecommendRequestSendActivity.this.I == 21) {
                    wh4.d(RecommendRequestSendActivity.this.w.getUid(), RecommendRequestSendActivity.this.J);
                }
                intent.putExtra("uid_key", RecommendRequestSendActivity.this.v);
                intent.putExtra("accept_status", 2L);
                RecommendRequestSendActivity.this.setResult(-1, intent);
                RecommendRequestSendActivity.this.finish();
            } else if (iOptInt == 1320 || iOptInt == 1321) {
                rx4.b(RecommendRequestSendActivity.this, jSONObject);
            }
            rn0.g(RecommendRequestSendActivity.this.v);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactRequestArgs f13428a;

        public l(ContactRequestArgs contactRequestArgs) {
            this.f13428a = contactRequestArgs;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            RecommendRequestSendActivity.this.G = jSONObject.optInt("resultCode");
            if (RecommendRequestSendActivity.this.G == 0) {
                iq5.j(false, new String[0]);
                wh4.h(RecommendRequestSendActivity.this.w);
                RecommendRequestSendActivity.this.F = 1L;
            } else if (RecommendRequestSendActivity.this.G == 1) {
                RecommendRequestSendActivity.this.X1(this.f13428a);
            }
        }
    }

    public void U1() {
        ContactRequestArgs contactRequestArgsA = new ContactRequestArgs.Builder().e(ContactRequestArgs.c(this.w)).f(this.q.getText().toString().trim()).i(String.valueOf(this.x)).j(String.valueOf(this.y)).g(this.r.getText().toString().trim()).a();
        f7 f7Var = new f7(new h(contactRequestArgsA), new i());
        this.u = f7Var;
        try {
            f7Var.n(contactRequestArgsA);
            showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public final void V1(ContactRequestArgs contactRequestArgs) {
        ih ihVar = new ih(new k(), new j());
        this.t = ihVar;
        try {
            ihVar.r(contactRequestArgs);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public void W1() {
        ContactRequestArgs contactRequestArgsA = new ContactRequestArgs.Builder().e(ContactRequestArgs.c(this.w)).f(this.q.getText().toString().trim()).i(String.valueOf(this.x)).j(String.valueOf(this.y)).g(this.r.getText().toString().trim()).a();
        f7 f7Var = new f7(new l(contactRequestArgsA), new a());
        this.u = f7Var;
        try {
            f7Var.n(contactRequestArgsA);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public final void X1(ContactRequestArgs contactRequestArgs) {
        ih ihVar = new ih(new c(), new b());
        this.t = ihVar;
        try {
            ihVar.v(false);
            this.t.r(contactRequestArgs);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public final void Y1() {
        String remarkName;
        PhoneContactItem phoneContactItem;
        EditText editText = (EditText) findViewById(R.id.request_information);
        this.q = editText;
        if (this.x == 2) {
            editText.setText(this.H);
        } else {
            ContactInfoItem contactInfoItemL = bo0.r().l(AccountUtils.p(this));
            this.q.setText(getString(R.string.new_friend_request_message, contactInfoItemL != null ? contactInfoItemL.getNickName() : ""));
        }
        Selection.setSelection(this.q.getText(), this.q.getText().length());
        this.q.addTextChangedListener(new d());
        this.r = (EditText) findViewById(R.id.remark_edit);
        if (TextUtils.isEmpty(this.w.getRemarkName())) {
            ContactInfoItem contactInfoItemL2 = bo0.r().l(this.v);
            remarkName = (contactInfoItemL2 == null || TextUtils.isEmpty(contactInfoItemL2.getRemarkName())) ? null : contactInfoItemL2.getRemarkName();
        } else {
            remarkName = this.w.getRemarkName();
        }
        if (TextUtils.isEmpty(remarkName)) {
            String identifyCode = this.w.getIdentifyCode();
            if (TextUtils.isEmpty(identifyCode) && !TextUtils.isEmpty(this.L)) {
                identifyCode = hs0.g().d(this.L);
            }
            if (!TextUtils.isEmpty(identifyCode) && (phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(identifyCode)) != null && (TextUtils.isEmpty(this.w.getNickName()) || !this.w.getNickName().equals(phoneContactItem.m()))) {
                remarkName = phoneContactItem.m();
            }
        }
        if (TextUtils.isEmpty(remarkName)) {
            remarkName = TextUtils.isEmpty(this.A) ? this.w.getNickName() : this.A;
        }
        this.r.setText(remarkName);
        this.r.setTextColor(getResources().getColor(R.color.divider_gray));
        this.r.addTextChangedListener(new e());
        this.r.setOnFocusChangeListener(new f());
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.action_btn);
        this.s = linearLayout;
        linearLayout.setOnClickListener(new g());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.z);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("add_page_show", "1", null, jSONObject.toString());
    }

    public final void Z1(Intent intent) {
        this.v = intent.getStringExtra("uid_key");
        this.w = (ContactInfoItem) intent.getParcelableExtra("user_item_info_key");
        this.x = intent.getIntExtra("source_type_key", 0);
        this.y = intent.getIntExtra("subtype_key", 0);
        this.z = intent.getIntExtra("send_from_type", 0);
        this.A = intent.getStringExtra("real_name");
        if (this.x == 2) {
            this.H = intent.getStringExtra("groupchat_name");
        }
        this.I = intent.getIntExtra("extra_request_from", 0);
        this.J = intent.getIntExtra("extra_request_type", 0);
        this.K = intent.getBooleanExtra("is_reverse", false);
        this.L = intent.getStringExtra("new_contact_local_phone_number");
        this.E = intent.getBooleanExtra("auto_send", false);
    }

    public final void a2() {
        finish();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.z);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("add_page_return", "1", null, jSONObject.toString());
    }

    public final void initActionBar() {
        setSupportActionBar(initToolbar(R.string.recommend_request_send_title));
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Z1(getIntent());
        setContentView(R.layout.layout_activity_recommend_request_send);
        initActionBar();
        Y1();
        if (this.E) {
            W1();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ih ihVar = this.t;
        if (ihVar != null) {
            ihVar.onCancel();
        }
        f7 f7Var = this.u;
        if (f7Var != null) {
            f7Var.onCancel();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyUp(i2, keyEvent);
        }
        a2();
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        a2();
        return true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.ErrorListener {
        public a() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {
        public b() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements TextWatcher {
        public d() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            dt2.d(RecommendRequestSendActivity.this.q, charSequence, 60);
            if (RecommendRequestSendActivity.this.B) {
                return;
            }
            RecommendRequestSendActivity.this.B = true;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", RecommendRequestSendActivity.this.z);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("add_page_change", "1", null, jSONObject.toString());
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements TextWatcher {
        public e() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            dt2.d(RecommendRequestSendActivity.this.r, charSequence, 32);
            if (RecommendRequestSendActivity.this.C) {
                return;
            }
            RecommendRequestSendActivity.this.C = true;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
