package com.zenmen.palmchat.peoplenearby;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bo0;
import defpackage.cq3;
import defpackage.ds0;
import defpackage.dt2;
import defpackage.fn0;
import defpackage.hx3;
import defpackage.iq5;
import defpackage.lu3;
import defpackage.oj0;
import defpackage.qm5;
import defpackage.r92;
import defpackage.st2;
import defpackage.sy5;
import defpackage.yy2;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CompleteSignatureActivity extends BaseActionBarActivity {
    public r92 q;
    public ContactInfoItem r;
    public String s;
    public EditText t;
    public TextView u;
    public TextView v;
    public cq3 x;
    public long w = 0;
    public int y = 0;
    public boolean z = false;
    public int A = -1;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements TextView.OnEditorActionListener {
        public a() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            return keyEvent != null && keyEvent.getKeyCode() == 66;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String string = CompleteSignatureActivity.this.t.getText().toString();
            if (TextUtils.isEmpty(string)) {
                LogUtil.uploadInfoImmediate(CompleteSignatureActivity.this.s, "310b2", null, null, null);
            } else {
                LogUtil.uploadInfoImmediate(CompleteSignatureActivity.this.s, "310b1", null, null, null);
            }
            if (!hx3.m(AppContext.getContext())) {
                sy5.e(CompleteSignatureActivity.this, R.string.update_network_error, 0).g();
                return;
            }
            if (!TextUtils.isEmpty(string)) {
                CompleteSignatureActivity.this.K1(string);
            } else if (System.currentTimeMillis() - CompleteSignatureActivity.this.w > 3000) {
                sy5.e(CompleteSignatureActivity.this, R.string.nearby_complete_signature_toast, 0).g();
                CompleteSignatureActivity.this.w = System.currentTimeMillis();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CompleteSignatureActivity.this.r = bo0.r().l(CompleteSignatureActivity.this.s);
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
                int i = jSONObject.getInt("resultCode");
                if (i == 0) {
                    iq5.j(false, new String[0]);
                    Intent intent = new Intent();
                    Intent intent2 = CompleteSignatureActivity.this.getIntent();
                    if (intent2 != null) {
                        if ("value_intent_from_secretary".equals(intent2.getStringExtra("intent_key_from"))) {
                            intent.putExtra("intent_key_from", "value_intent_from_secretary");
                        }
                        intent.putExtra("fromType", intent2.getIntExtra("fromType", 0));
                    }
                    intent.setClass(CompleteSignatureActivity.this, PeopleNearbyActivity.class);
                    CompleteSignatureActivity.this.startActivity(intent);
                    CompleteSignatureActivity.this.finish();
                    ds0.a().b(new oj0());
                } else if (i == 1130) {
                    CompleteSignatureActivity.this.showRequestFailDialog(yy2.a(jSONObject), CompleteSignatureActivity.this.getString(R.string.send_failed));
                } else {
                    sy5.e(AppContext.getContext(), R.string.send_failed, 0).g();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            CompleteSignatureActivity.this.hideBaseProgressBar();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Response.ErrorListener {
        public f() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            CompleteSignatureActivity.this.hideBaseProgressBar();
            sy5.e(AppContext.getContext(), R.string.send_failed, 0).g();
        }
    }

    public final void J1(boolean z) {
        if (z) {
            this.u.setBackgroundResource(R.drawable.selector_btn_green);
        } else {
            this.u.setBackgroundResource(R.drawable.shape_btn_mend_disnable);
        }
    }

    public final void K1(String str) {
        HashMap map = new HashMap();
        map.put(com.umeng.ccg.a.A, str);
        if (this.A != -1) {
            map.put("sex", this.A + "");
        }
        this.x = new cq3(new e(), new f());
        try {
            showBaseProgressBar(R.string.progress_sending, false);
            this.x.n(map);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public final boolean L1() {
        return !TextUtils.isEmpty(this.t.getText().toString());
    }

    public final void M1(IBinder iBinder) {
        if (iBinder != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(iBinder, 2);
        }
    }

    public final void N1() {
        TextView textView = (TextView) findViewById(R.id.nearby_signature_title);
        this.v = (TextView) findViewById(R.id.count);
        this.u = (TextView) findViewById(R.id.action_button);
        TextView textView2 = (TextView) findViewById(R.id.action_tips);
        this.t = (EditText) findViewById(R.id.completed_pro_signature);
        textView.setText(st2.i());
        this.t.setHint(st2.g());
        this.u.setText(st2.f());
        textView2.setText(st2.h());
        this.t.setOnEditorActionListener(new a());
        this.t.addTextChangedListener(new b());
        this.u.setOnClickListener(new c());
    }

    public final boolean O1(View view, MotionEvent motionEvent) {
        if (!(view instanceof EditText)) {
            return false;
        }
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return motionEvent.getX() <= ((float) i) || motionEvent.getX() >= ((float) (view.getWidth() + i)) || motionEvent.getY() <= ((float) i2) || motionEvent.getY() >= ((float) (view.getHeight() + i2));
    }

    public final void P1() {
        LogUtil.uploadInfoImmediate(this.s, "310b3", null, null, null);
        finish();
        lu3.a();
    }

    public final void Q1() {
        this.r = bo0.r().l(this.s);
        r92 r92Var = new r92();
        this.q = r92Var;
        r92Var.n();
        ContactInfoItem contactInfoItem = this.r;
        String signature = contactInfoItem != null ? contactInfoItem.getSignature() : null;
        if (TextUtils.isEmpty(signature)) {
            J1(false);
            return;
        }
        this.t.setText(signature);
        Selection.setSelection(this.t.getText(), this.t.getText().length());
        J1(true);
    }

    public final void R1() {
        LogUtil.uploadInfoImmediate(this.s, "310b", null, null, String.valueOf(this.y));
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            View currentFocus = getCurrentFocus();
            if (O1(currentFocus, motionEvent)) {
                M1(currentFocus.getWindowToken());
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        P1();
    }

    @qm5
    public void onContactChanged(fn0 fn0Var) {
        runOnUiThread(new d());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_complete_signature);
        setSupportActionBar(initToolbar(R.string.nearby_complete_profile));
        this.s = AccountUtils.p(AppContext.getContext());
        N1();
        if (getIntent() != null) {
            this.y = getIntent().getIntExtra("fromType", 0);
            this.z = getIntent().getBooleanExtra("fromGender", false);
            this.A = getIntent().getIntExtra("gender", -1);
            if (this.z) {
                this.y = 12;
            }
        }
        R1();
        bo0.r().i().j(this);
        Q1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        cq3 cq3Var = this.x;
        if (cq3Var != null) {
            cq3Var.onCancel();
        }
        bo0.r().i().l(this);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        P1();
        return true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (CompleteSignatureActivity.this.L1()) {
                CompleteSignatureActivity.this.J1(true);
            } else {
                CompleteSignatureActivity.this.J1(false);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            CompleteSignatureActivity.this.v.setVisibility(0);
            int iD = dt2.d(CompleteSignatureActivity.this.t, charSequence, 60);
            if (iD <= 60) {
                CompleteSignatureActivity.this.v.setText(((int) Math.floor(((double) (60 - iD)) * 0.5d)) + "");
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
