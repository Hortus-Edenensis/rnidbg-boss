package com.zenmen.palmchat.contacts;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ContactRequestArgs;
import com.zenmen.palmchat.Vo.GreetConfig;
import com.zenmen.palmchat.Vo.PhoneContactItem;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.ClearEditText;
import defpackage.bo0;
import defpackage.ds0;
import defpackage.dt2;
import defpackage.f7;
import defpackage.hs0;
import defpackage.ih;
import defpackage.iq5;
import defpackage.k36;
import defpackage.rl0;
import defpackage.rn0;
import defpackage.rx4;
import defpackage.sn0;
import defpackage.sy5;
import defpackage.vn0;
import defpackage.wh4;
import java.util.List;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class NewContactRequestSendActivityV2 extends BaseActionBarActivity {
    public ih A;
    public f7 B;
    public String C;
    public ContactInfoItem E;
    public int G;
    public String H;
    public int J;
    public String P;
    public EditText r;
    public TextView s;
    public TextView t;
    public TextView u;
    public LinearLayout v;
    public ClearEditText w;
    public TextView x;
    public Response.ErrorListener y;
    public Response.Listener<JSONObject> z;
    public String q = "";
    public boolean F = false;
    public int I = 0;
    public int K = 0;
    public int L = 0;
    public boolean M = false;
    public boolean N = false;
    public boolean O = false;

    /* JADX INFO: compiled from: SearchBox */
    public static class NoUnderlineSpan extends UnderlineSpan {
        @Override // android.text.style.UnderlineSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(Color.parseColor("#009687"));
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13380a;

        public a(String str) {
            this.f13380a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewContactRequestSendActivityV2.this.x.setVisibility(8);
            NewContactRequestSendActivityV2.this.w.setText(this.f13380a);
            NewContactRequestSendActivityV2.this.w.setSelection(NewContactRequestSendActivityV2.this.w.getText().length());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", NewContactRequestSendActivityV2.this.G);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("tip_click", "1", null, jSONObject.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {
        public b() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            NewContactRequestSendActivityV2.this.M = false;
            NewContactRequestSendActivityV2.this.hideBaseProgressBar();
            if (NewContactRequestSendActivityV2.this.isFinishing()) {
                return;
            }
            NewContactRequestSendActivityV2.this.Y1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.Listener<JSONObject> {
        public c() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            NewContactRequestSendActivityV2.this.M = false;
            NewContactRequestSendActivityV2.this.hideBaseProgressBar();
            int iOptInt = jSONObject.optInt("resultCode");
            if (iOptInt == 0 || iOptInt == 1) {
                if (NewContactRequestSendActivityV2.this.F) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("accept_status", (Long) 2L);
                    contentValues.put("request_type", (Integer) 0);
                    String str = AccountUtils.p(AppContext.getContext()) + "_" + NewContactRequestSendActivityV2.this.C;
                    contentValues.put("rid", str);
                    AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues, "from_uid=?", new String[]{NewContactRequestSendActivityV2.this.C});
                    Intent intent = new Intent();
                    intent.putExtra("revertRid", str);
                    NewContactRequestSendActivityV2.this.setResult(-1, intent);
                } else {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("accept_status", (Long) 2L);
                    AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues2, "from_uid=?", new String[]{NewContactRequestSendActivityV2.this.C});
                }
                if (NewContactRequestSendActivityV2.this.K == 21) {
                    wh4.d(NewContactRequestSendActivityV2.this.E.getUid(), NewContactRequestSendActivityV2.this.L);
                }
                sn0 sn0Var = new sn0();
                sn0Var.d(NewContactRequestSendActivityV2.this.C);
                sn0Var.c(2L);
                ds0.a().b(sn0Var);
                NewContactRequestSendActivityV2.this.finish();
            } else if ((iOptInt == 1320 || iOptInt == 1321) && !NewContactRequestSendActivityV2.this.isFinishing()) {
                rx4.b(NewContactRequestSendActivityV2.this, jSONObject);
            }
            rn0.g(NewContactRequestSendActivityV2.this.C);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactRequestArgs f13383a;

        public d(ContactRequestArgs contactRequestArgs) {
            this.f13383a = contactRequestArgs;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            NewContactRequestSendActivityV2.this.M = false;
            int iOptInt = jSONObject.optInt("resultCode");
            if (iOptInt == 0) {
                NewContactRequestSendActivityV2.this.hideBaseProgressBar();
                iq5.j(false, new String[0]);
                wh4.h(NewContactRequestSendActivityV2.this.E);
                sn0 sn0Var = new sn0();
                sn0Var.d(NewContactRequestSendActivityV2.this.C);
                sn0Var.c(1L);
                ds0.a().b(sn0Var);
                NewContactRequestSendActivityV2.this.finish();
                return;
            }
            if (iOptInt == 1) {
                NewContactRequestSendActivityV2.this.X1(this.f13383a);
                return;
            }
            if (iOptInt == 1318) {
                NewContactRequestSendActivityV2.this.hideBaseProgressBar();
                if (NewContactRequestSendActivityV2.this.isFinishing()) {
                    return;
                }
                sy5.e(NewContactRequestSendActivityV2.this, R.string.send_refuse, 1).g();
                return;
            }
            if (iOptInt == 1320 || iOptInt == 1321) {
                NewContactRequestSendActivityV2.this.hideBaseProgressBar();
                if (NewContactRequestSendActivityV2.this.isFinishing()) {
                    return;
                }
                rx4.b(NewContactRequestSendActivityV2.this, jSONObject);
                return;
            }
            NewContactRequestSendActivityV2.this.hideBaseProgressBar();
            if (NewContactRequestSendActivityV2.this.isFinishing()) {
                return;
            }
            sy5.f(NewContactRequestSendActivityV2.this, rx4.a(jSONObject), 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Response.ErrorListener {
        public e() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            NewContactRequestSendActivityV2.this.M = false;
            NewContactRequestSendActivityV2.this.hideBaseProgressBar();
            if (NewContactRequestSendActivityV2.this.isFinishing()) {
                return;
            }
            sy5.e(NewContactRequestSendActivityV2.this, R.string.contact_apply_fail, 1).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnFocusChangeListener {
        public f() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            NewContactRequestSendActivityV2.this.w.setTextColor(Color.parseColor("#202020"));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewContactRequestSendActivityV2.this.R1();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", NewContactRequestSendActivityV2.this.G);
                int i = 1;
                jSONObject.put("greet_change", NewContactRequestSendActivityV2.this.N ? 1 : 0);
                if (!NewContactRequestSendActivityV2.this.O) {
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
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k36.f(NewContactRequestSendActivityV2.this.r);
            k36.f(NewContactRequestSendActivityV2.this.w);
            NewContactRequestSendActivityV2.this.finish();
            NewContactRequestSendActivityV2.this.S1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class k extends ClickableSpan implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View.OnClickListener f13390a;

        public k(View.OnClickListener onClickListener) {
            this.f13390a = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.view.View.OnClickListener
        public void onClick(View view) {
            this.f13390a.onClick(view);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(Color.parseColor("#04b4a2"));
            textPaint.setUnderlineText(false);
        }
    }

    public void R1() {
        ContactRequestArgs.Builder builderG = new ContactRequestArgs.Builder().e(ContactRequestArgs.c(this.E)).f(this.r.getText().toString().trim()).i(String.valueOf(this.I)).j(String.valueOf(this.J)).g(this.w.getText().toString().trim());
        if (this.I == 2) {
            builderG.c(ContactRequestArgs.a(this.P));
        }
        ContactRequestArgs contactRequestArgsA = builderG.a();
        f7 f7Var = new f7(new d(contactRequestArgsA), new e());
        this.B = f7Var;
        try {
            f7Var.n(contactRequestArgsA);
            this.M = true;
            if (isFinishing()) {
                return;
            }
            showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public final void S1() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.G);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("add_page_return", "1", null, jSONObject.toString());
        if (this.F || this.M) {
            return;
        }
        R1();
    }

    public final CharSequence T1(String str) {
        a aVar = new a(str);
        String string = getString(R.string.remark_recommend_by_phonebook_b, str);
        String string2 = getString(R.string.remark_recommend_by_phonebook_confirm);
        String str2 = string + " " + string2 + "\u200b";
        SpannableString spannableString = new SpannableString(str2);
        spannableString.setSpan(new k(aVar), (str2.length() - string2.length()) - 1, str2.length() - 1, 33);
        return spannableString;
    }

    public final void U1() {
        this.y = new b();
        this.z = new c();
    }

    public final void V1() {
        GreetConfig greetConfigF;
        List<GreetConfig.Word> listB;
        PhoneContactItem phoneContactItem;
        this.r = (EditText) findViewById(R.id.request_information);
        this.s = (TextView) findViewById(R.id.send_msg_notice_tv);
        this.v = (LinearLayout) findViewById(R.id.remark_layout);
        this.w = (ClearEditText) findViewById(R.id.remark_edit);
        this.x = (TextView) findViewById(R.id.phone_name);
        ContactInfoItem contactInfoItemL = bo0.r().l(AccountUtils.p(this));
        this.r.setText(getString(R.string.new_friend_request_message, contactInfoItemL != null ? contactInfoItemL.getNickName() : ""));
        if (this.I == 2) {
            this.r.setText(this.q);
        }
        int i2 = this.I;
        if (i2 == 14 || i2 == 34) {
            this.s.setText(R.string.nearby_send_greeting);
            this.r.setText("");
            ContactInfoItem contactInfoItemL2 = bo0.r().l(AccountUtils.p(this));
            ContactInfoItem contactInfoItemL3 = bo0.r().l(this.C);
            if (contactInfoItemL3 == null && (contactInfoItemL3 = this.E) == null) {
                contactInfoItemL3 = null;
            }
            if (contactInfoItemL2 != null && contactInfoItemL3 != null && contactInfoItemL2.getGender() == 0 && contactInfoItemL3.getGender() == 1 && (greetConfigF = rl0.h().f()) != null && (listB = greetConfigF.b()) != null) {
                this.r.setText(listB.get(new Random().nextInt(listB.size())).b);
            }
        } else if (i2 == 28) {
            this.s.setText(R.string.shake_send_greeting);
        }
        Selection.setSelection(this.r.getText(), this.r.getText().length());
        String remarkName = !TextUtils.isEmpty(this.E.getRemarkName()) ? this.E.getRemarkName() : null;
        if (TextUtils.isEmpty(remarkName)) {
            remarkName = this.E.getNickName();
        }
        this.w.setText(remarkName);
        this.w.setClearDrawable(R.drawable.ic_edittext_clear_gray, R.drawable.ic_edittext_clear_gray);
        this.w.setTextColor(Color.parseColor("#9b9b9b"));
        String strM = (TextUtils.isEmpty(this.H) || (phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(hs0.g().d(this.H))) == null) ? null : phoneContactItem.m();
        if (TextUtils.isEmpty(strM) || strM.equals(this.w.getText().toString())) {
            this.x.setVisibility(8);
        } else {
            this.x.setVisibility(0);
            this.x.setText(T1(strM));
            this.x.setMovementMethod(LinkMovementMethod.getInstance());
            this.x.setHighlightColor(getResources().getColor(android.R.color.transparent));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.G);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("tip_show", "1", null, jSONObject.toString());
        }
        this.w.setOnFocusChangeListener(new f());
        this.w.addTextChangedListener(new g());
        this.r.addTextChangedListener(new h());
        this.t.setOnClickListener(new i());
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("type", this.G);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("add_page_show", "1", null, jSONObject2.toString());
    }

    public final void W1(Intent intent) {
        int intExtra = intent.getIntExtra("new_contact_source_type", 0);
        this.I = intExtra;
        if (intExtra == 2) {
            this.q = intent.getStringExtra("groupchat_name");
        }
        this.K = intent.getIntExtra("extra_request_from", 0);
        this.L = intent.getIntExtra("extra_request_type", 0);
        this.J = intent.getIntExtra("subtype_key", 0);
        this.P = intent.getStringExtra("groupid");
    }

    public final void X1(ContactRequestArgs contactRequestArgs) {
        ih ihVar = new ih(this.z, this.y);
        this.A = ihVar;
        try {
            ihVar.v(!isFinishing());
            this.A.r(contactRequestArgs);
            this.M = true;
            if (isFinishing()) {
                return;
            }
            showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public final void Y1() {
        sy5.e(this, R.string.send_failed, 0).g();
    }

    public final void initActionBar() {
        initToolbar(-1);
        TextView textView = (TextView) getToolbar().findViewById(R.id.action_button);
        this.t = textView;
        textView.setText(R.string.send);
        TextView textView2 = (TextView) getToolbar().findViewById(R.id.title);
        this.u = textView2;
        int i2 = this.I;
        if (i2 == 14 || i2 == 28 || i2 == 34) {
            textView2.setText(R.string.nearby_greeting);
        } else {
            textView2.setText("");
        }
        if (getToolbar() != null) {
            getToolbar().setNavigationOnClickListener(new j());
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        S1();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        W1(intent);
        this.C = intent.getStringExtra("uid_key");
        this.E = (ContactInfoItem) intent.getParcelableExtra("user_item_info");
        this.F = intent.getBooleanExtra("new_contact_is_reverse", false);
        this.H = intent.getStringExtra("new_contact_local_phone_number");
        this.G = intent.getIntExtra("send_from_type", 0);
        setContentView(R.layout.layout_activity_new_friend_request_send_v2);
        initActionBar();
        V1();
        U1();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        k36.f(this.r);
        k36.f(this.w);
        finish();
        S1();
        return true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements TextWatcher {
        public g() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            NewContactRequestSendActivityV2.this.w.setTextColor(Color.parseColor("#202020"));
            dt2.d(NewContactRequestSendActivityV2.this.w, charSequence, 32);
            if (NewContactRequestSendActivityV2.this.O) {
                return;
            }
            NewContactRequestSendActivityV2.this.O = true;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements TextWatcher {
        public h() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            dt2.d(NewContactRequestSendActivityV2.this.r, charSequence, 60);
            if (NewContactRequestSendActivityV2.this.N) {
                return;
            }
            NewContactRequestSendActivityV2.this.N = true;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", NewContactRequestSendActivityV2.this.G);
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
}
