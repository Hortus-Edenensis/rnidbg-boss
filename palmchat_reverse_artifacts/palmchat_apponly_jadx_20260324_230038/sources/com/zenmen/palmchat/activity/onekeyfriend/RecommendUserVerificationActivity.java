package com.zenmen.palmchat.activity.onekeyfriend;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bo0;
import defpackage.dt2;
import defpackage.ih;
import defpackage.k86;
import defpackage.r75;
import defpackage.sy5;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class RecommendUserVerificationActivity extends BaseActionBarActivity implements View.OnClickListener {
    public TextView q;
    public TextView r;
    public String[] s;
    public ih t;
    public EditText u;
    public BroadcastReceiver v = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !RecommendResultActivity.u.equals(intent.getAction())) {
                return;
            }
            RecommendUserVerificationActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.ErrorListener {
        public c() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            RecommendUserVerificationActivity.this.hideBaseProgressBar();
            RecommendUserVerificationActivity.this.G1();
            LogUtil.d(BaseActionBarActivity.TAG, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Response.Listener<JSONObject> {
        public d() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            RecommendUserVerificationActivity.this.hideBaseProgressBar();
            if (jSONObject.optInt("resultCode") == 0) {
                r75.p(AppContext.getContext(), k86.a("is_new_user"), 1);
                sy5.e(RecommendUserVerificationActivity.this, R.string.sent, 0).g();
                RecommendUserVerificationActivity.this.startActivity(new Intent(RecommendUserVerificationActivity.this, (Class<?>) RecommendResultActivity.class));
                return;
            }
            String strOptString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
            RecommendUserVerificationActivity recommendUserVerificationActivity = RecommendUserVerificationActivity.this;
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = RecommendUserVerificationActivity.this.getString(R.string.send_failed);
            }
            sy5.f(recommendUserVerificationActivity, strOptString, 0).g();
        }
    }

    public final void C1(String str) {
        c cVar = new c();
        d dVar = new d();
        StringBuilder sb = new StringBuilder();
        HashMap map = new HashMap();
        for (String str2 : this.s) {
            sb.append(str2);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        map.put("fuids", sb.toString());
        map.put("info", str);
        map.put("sourceType", String.valueOf(7));
        ih ihVar = new ih(dVar, cVar);
        this.t = ihVar;
        try {
            ihVar.s(map);
            showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void D1() {
        Toolbar toolbarInitToolbar = initToolbar(-1);
        TextView textView = (TextView) getToolbar().findViewById(R.id.action_button);
        this.q = textView;
        textView.setText(R.string.recommend_friend_send);
        this.q.setOnClickListener(this);
        TextView textView2 = (TextView) getToolbar().findViewById(R.id.title);
        this.r = textView2;
        textView2.setText(R.string.recommend_friend_verification);
        setSupportActionBar(toolbarInitToolbar);
    }

    public final void E1() {
        this.u = (EditText) findViewById(R.id.request_information);
        TextView textView = (TextView) findViewById(R.id.count);
        this.u.setText(getString(R.string.new_friend_request_message, bo0.r().l(AccountUtils.p(this)).getNickName()));
        Selection.setSelection(this.u.getText(), this.u.getText().length());
        textView.setText(((int) Math.floor(((double) (60 - dt2.b(this.u.getText().toString()))) * 0.5d)) + "");
        this.u.addTextChangedListener(new b(textView));
    }

    public final void F1() {
        Intent intent = getIntent();
        if (intent == null || intent.getExtras() == null) {
            return;
        }
        this.s = getIntent().getExtras().getStringArray("SELECT_USER");
    }

    public final void G1() {
        sy5.e(this, R.string.send_failed, 0).g();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        LogUtil.onClickEvent("93321", null, null);
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.action_button) {
            return;
        }
        C1(this.u.getText().toString());
        LogUtil.onClickEvent("9332", null, null);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_recommend_user_verification);
        D1();
        F1();
        E1();
        registerLocalReceiver(this.v, new IntentFilter(RecommendResultActivity.u));
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        hideBaseProgressBar();
        ih ihVar = this.t;
        if (ihVar != null) {
            ihVar.onCancel();
        }
        unregisterLocalReceiver(this.v);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        LogUtil.onClickEvent("9331", null, null);
        return true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f12290a;

        public b(TextView textView) {
            this.f12290a = textView;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int iD = dt2.d(RecommendUserVerificationActivity.this.u, charSequence, 60);
            if (iD <= 60) {
                this.f12290a.setText(((int) Math.floor(((double) (60 - iD)) * 0.5d)) + "");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
