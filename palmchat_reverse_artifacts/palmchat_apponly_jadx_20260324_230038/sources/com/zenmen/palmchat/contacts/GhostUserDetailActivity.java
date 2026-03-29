package com.zenmen.palmchat.contacts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.ih;
import defpackage.me1;
import defpackage.rx4;
import defpackage.sy5;
import defpackage.wh4;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class GhostUserDetailActivity extends BaseActionBarActivity {
    public ih q;
    public ContactInfoItem r;
    public String s;
    public String t;
    public Toolbar u;
    public EffectiveShapeView v;
    public TextView w;
    public TextView x;
    public TextView y;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GhostUserDetailActivity ghostUserDetailActivity = GhostUserDetailActivity.this;
            ghostUserDetailActivity.D1(ghostUserDetailActivity.r.getUid(), true);
            GhostUserDetailActivity.this.y.setEnabled(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {
        public b() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            GhostUserDetailActivity.this.hideBaseProgressBar();
            LogUtil.d(BaseActionBarActivity.TAG, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f13339a;

        public c(boolean z) {
            this.f13339a = z;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            GhostUserDetailActivity.this.hideBaseProgressBar();
            if (!this.f13339a) {
                wh4.d(GhostUserDetailActivity.this.r.getUid(), GhostUserDetailActivity.this.r.getRequestType());
                rx4.b(GhostUserDetailActivity.this.getBaseContext(), jSONObject);
            } else {
                if (jSONObject.optInt("resultCode") == 0) {
                    sy5.e(AppContext.getContext(), R.string.sent, 0).g();
                    return;
                }
                String strOptString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
                Context baseContext = GhostUserDetailActivity.this.getBaseContext();
                if (TextUtils.isEmpty(strOptString)) {
                    strOptString = GhostUserDetailActivity.this.getString(R.string.send_failed);
                }
                sy5.f(baseContext, strOptString, 0).g();
            }
        }
    }

    public final void D1(String str, boolean z) {
        b bVar = new b();
        c cVar = new c(z);
        if (z) {
            HashMap map = new HashMap();
            map.put("fuids", str);
            map.put("sourceType", String.valueOf(3));
            map.put("type", "1");
            ih ihVar = new ih(cVar, bVar);
            this.q = ihVar;
            try {
                ihVar.u(map);
                showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
            } catch (DaoException e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void E1() {
        Toolbar toolbarInitToolbar = initToolbar(R.string.activity_title_user_detail);
        this.u = toolbarInitToolbar;
        setSupportActionBar(toolbarInitToolbar);
    }

    public final void F1() {
        EffectiveShapeView effectiveShapeView = (EffectiveShapeView) findViewById(R.id.portrait);
        this.v = effectiveShapeView;
        effectiveShapeView.changeShapeType(3);
        this.v.setDegreeForRoundRectangle(13, 13);
        this.v.setBorderWidth(me1.b(this, 1));
        this.v.setBorderColor(-1);
        gr2.j().e(R.drawable.default_portrait_for_ghost, this.v, bq6.s());
        this.w = (TextView) findViewById(R.id.first_name);
        if (TextUtils.isEmpty(this.s) || TextUtils.isEmpty(this.s.trim())) {
            this.s = this.t;
        }
        if (!TextUtils.isEmpty(this.s) && this.s.trim().length() > 0) {
            this.w.setText(this.s.trim().substring(0, 1));
        }
        this.x = (TextView) findViewById(R.id.nameMain);
        String mobile = !TextUtils.isEmpty(this.s) ? this.s : this.r.getMobile();
        if (TextUtils.isEmpty(this.r.getNickName())) {
            this.x.setText(mobile);
        } else {
            this.x.setText(mobile + "(" + this.r.getNickName() + ")");
        }
        TextView textView = (TextView) findViewById(R.id.action_textview);
        this.y = textView;
        textView.setOnClickListener(new a());
    }

    public final void G1() {
        Intent intent = getIntent();
        this.r = (ContactInfoItem) intent.getParcelableExtra("user_item_info");
        this.s = intent.getStringExtra("user_item_info_local_name");
        this.t = intent.getStringExtra("user_item_info_phone_number");
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_ghost_user_detail);
        G1();
        if (this.r == null) {
            return;
        }
        E1();
        F1();
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
