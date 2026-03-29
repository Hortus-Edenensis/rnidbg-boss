package com.zenmen.palmchat.contacts;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
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
import defpackage.hs0;
import defpackage.ih;
import defpackage.io0;
import defpackage.jo6;
import defpackage.n42;
import defpackage.p05;
import defpackage.rl0;
import defpackage.rx4;
import defpackage.sy5;
import defpackage.vn0;
import defpackage.wh4;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class NewContactRequestSendActivity extends BaseActionBarActivity {
    public static final String O = "NewContactRequestSendActivity";
    public ih A;
    public String B;
    public ContactInfoItem C;
    public String F;
    public String J;
    public int L;
    public EditText r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public LinearLayout w;
    public ClearEditText x;
    public Response.ErrorListener y;
    public Response.Listener<JSONObject> z;
    public String q = "";
    public int E = -1;
    public boolean G = false;
    public boolean H = false;
    public ContactRequestsVO I = null;
    public int K = 0;
    public int M = 0;
    public int N = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class NoUnderlineSpan extends UnderlineSpan {
        @Override // android.text.style.UnderlineSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(Color.parseColor("#1dc1fc"));
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.ErrorListener {

        /* JADX INFO: renamed from: com.zenmen.palmchat.contacts.NewContactRequestSendActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1019a extends HashMap<String, Object> {
            public C1019a() {
                put("action", "NewContactRequestSendActivity");
                put("status", "fail");
            }
        }

        public a() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            NewContactRequestSendActivity.this.hideBaseProgressBar();
            NewContactRequestSendActivity.this.Q1();
            LogUtil.i(NewContactRequestSendActivity.O, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new C1019a(), volleyError);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.Listener<JSONObject> {
        public b() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            NewContactRequestSendActivity.this.hideBaseProgressBar();
            if (iOptInt != 0 && iOptInt != 1) {
                if (iOptInt == 1320 || iOptInt == 1321) {
                    rx4.b(NewContactRequestSendActivity.this, jSONObject);
                    return;
                }
                return;
            }
            if (NewContactRequestSendActivity.this.H) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("accept_status", (Long) 2L);
                contentValues.put("request_type", (Integer) 0);
                String str = AccountUtils.p(AppContext.getContext()) + "_" + NewContactRequestSendActivity.this.B;
                contentValues.put("rid", str);
                AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues, "from_uid=?", new String[]{NewContactRequestSendActivity.this.B});
                Intent intent = new Intent();
                intent.putExtra("revertRid", str);
                NewContactRequestSendActivity.this.setResult(-1, intent);
            } else {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("accept_status", (Long) 2L);
                AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues2, "from_uid=?", new String[]{NewContactRequestSendActivity.this.B});
            }
            if (NewContactRequestSendActivity.this.M == 21) {
                wh4.d(NewContactRequestSendActivity.this.C.getUid(), NewContactRequestSendActivity.this.N);
            }
            if (p05.c() && NewContactRequestSendActivity.this.G) {
                ds0.a().b(new n42());
            }
            NewContactRequestSendActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewContactRequestSendActivity.this.P1();
        }
    }

    public final void M1() {
        this.y = new a();
        this.z = new b();
    }

    public final void N1() {
        GreetConfig greetConfigF;
        List<GreetConfig.Word> listB;
        PhoneContactItem phoneContactItem;
        this.r = (EditText) findViewById(R.id.request_information);
        this.s = (TextView) findViewById(R.id.send_msg_notice_tv);
        this.v = (TextView) findViewById(R.id.notification);
        this.w = (LinearLayout) findViewById(R.id.remark_layout);
        this.x = (ClearEditText) findViewById(R.id.remark_edit);
        TextView textView = (TextView) findViewById(R.id.count);
        ContactInfoItem contactInfoItemL = bo0.r().l(AccountUtils.p(this));
        String nickName = contactInfoItemL != null ? contactInfoItemL.getNickName() : "";
        if (jo6.i() && io0.t(this.K)) {
            this.w.setVisibility(0);
            this.x.addTextChangedListener(new c());
            String remarkName = !TextUtils.isEmpty(this.C.getRemarkName()) ? this.C.getRemarkName() : (TextUtils.isEmpty(this.J) || (phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(hs0.g().d(this.J))) == null || this.C.getNickName().equals(phoneContactItem.m())) ? null : phoneContactItem.m();
            if (TextUtils.isEmpty(remarkName)) {
                remarkName = this.C.getNickName();
            }
            this.x.setText(remarkName);
        }
        this.r.setText(getString(R.string.new_friend_request_message, nickName));
        if (this.K == 2) {
            this.r.setText(this.q);
        }
        int i = this.K;
        if (i == 14 || i == 34) {
            this.s.setText(R.string.nearby_send_greeting);
            textView.setText("");
            this.r.setText("");
            ContactInfoItem contactInfoItemL2 = bo0.r().l(AccountUtils.p(this));
            ContactInfoItem contactInfoItemL3 = bo0.r().l(this.B);
            ContactInfoItem contactInfoItem = (contactInfoItemL3 == null && (contactInfoItemL3 = this.C) == null) ? null : contactInfoItemL3;
            if (contactInfoItemL2 != null && contactInfoItem != null && contactInfoItemL2.getGender() == 0 && contactInfoItem.getGender() == 1 && (greetConfigF = rl0.h().f()) != null && (listB = greetConfigF.b()) != null) {
                int iNextInt = new Random().nextInt(listB.size());
                this.E = iNextInt;
                this.r.setText(listB.get(iNextInt).b);
            }
        } else if (i == 28) {
            this.s.setText(R.string.shake_send_greeting);
        }
        Selection.setSelection(this.r.getText(), this.r.getText().length());
        int i2 = this.K;
        if (i2 != 14 && i2 != 34) {
            textView.setText(((int) Math.floor(((double) (60 - dt2.b(this.r.getText().toString()))) * 0.5d)) + "");
        }
        this.r.addTextChangedListener(new d(textView));
        this.t.setOnClickListener(new e());
    }

    public final void O1(Intent intent) {
        int intExtra = intent.getIntExtra("new_contact_source_type", 0);
        this.K = intExtra;
        if (intExtra == 2) {
            this.q = intent.getStringExtra("groupchat_name");
        }
        this.M = intent.getIntExtra("extra_request_from", 0);
        this.N = intent.getIntExtra("extra_request_type", 0);
        this.L = intent.getIntExtra("subtype_key", 0);
        this.F = intent.getStringExtra("groupid");
        this.G = intent.getBooleanExtra("from_user_detail", false);
    }

    public final void P1() {
        ContactRequestArgs.Builder builderG = new ContactRequestArgs.Builder().h(this.H).b(this.I).e(ContactRequestArgs.c(this.C)).f(this.r.getText().toString()).i(String.valueOf(this.K)).j(String.valueOf(this.L)).g(this.x.getText().toString());
        if (this.K == 2) {
            builderG.c(ContactRequestArgs.a(this.F));
        }
        ih ihVar = new ih(this.z, this.y);
        this.A = ihVar;
        try {
            ihVar.r(builderG.a());
            showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public final void Q1() {
        sy5.e(this, R.string.send_failed, 0).g();
    }

    public final void initActionBar() {
        initToolbar(-1);
        TextView textView = (TextView) getToolbar().findViewById(R.id.action_button);
        this.t = textView;
        textView.setText(R.string.send);
        TextView textView2 = (TextView) getToolbar().findViewById(R.id.title);
        this.u = textView2;
        int i = this.K;
        if (i == 14 || i == 28 || i == 34) {
            textView2.setText(R.string.nearby_greeting);
        } else {
            textView2.setText(R.string.app_name);
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        O1(intent);
        this.B = intent.getStringExtra("uid_key");
        this.C = (ContactInfoItem) intent.getParcelableExtra("user_item_info");
        this.H = intent.getBooleanExtra("new_contact_is_reverse", false);
        this.I = (ContactRequestsVO) intent.getParcelableExtra("new_contact_contactrequst_info");
        this.J = intent.getStringExtra("new_contact_local_phone_number");
        setContentView(R.layout.layout_activity_new_friend_request_send);
        initActionBar();
        N1();
        M1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ih ihVar = this.A;
        if (ihVar != null) {
            ihVar.onCancel();
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

    /* JADX INFO: compiled from: SearchBox */
    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            dt2.d(NewContactRequestSendActivity.this.x, charSequence, 32);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f13378a;

        public d(TextView textView) {
            this.f13378a = textView;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int iD = dt2.d(NewContactRequestSendActivity.this.r, charSequence, 60);
            if (iD > 60 || NewContactRequestSendActivity.this.K == 14 || NewContactRequestSendActivity.this.K == 34) {
                return;
            }
            this.f13378a.setText(((int) Math.floor(((double) (60 - iD)) * 0.5d)) + "");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
