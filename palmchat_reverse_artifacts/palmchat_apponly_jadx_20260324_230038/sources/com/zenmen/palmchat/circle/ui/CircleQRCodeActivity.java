package com.zenmen.palmchat.circle.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.openalliance.ad.constant.az;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.SendMessageActivity;
import com.zenmen.palmchat.circle.ui.view.CircleFixedRatioImageView;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.ir5;
import defpackage.j92;
import defpackage.oc0;
import defpackage.pu1;
import defpackage.se2;
import defpackage.sy5;
import defpackage.wm3;
import defpackage.xt;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleQRCodeActivity extends BaseActionBarActivity {
    public GroupInfoItem A;
    public int B = -1;
    public Response.Listener<JSONObject> C = new b();
    public Response.ErrorListener E = new c();
    public ConstraintLayout q;
    public EffectiveShapeView r;
    public TextView s;
    public TextView t;
    public CircleFixedRatioImageView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public String y;
    public JSONObject z;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends AsyncTask<Bitmap, Void, String> {
        public a() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(Bitmap... bitmapArr) {
            return xt.x(bitmapArr[0], System.currentTimeMillis() + "");
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            wm3.a(str);
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "5202", "1", "1", CircleQRCodeActivity.this.I1(true));
            CircleQRCodeActivity circleQRCodeActivity = CircleQRCodeActivity.this;
            sy5.f(circleQRCodeActivity, circleQRCodeActivity.getResources().getString(R.string.save_to_dir, pu1.m()), 1).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.Listener<JSONObject> {
        public b() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            CircleQRCodeActivity.this.hideBaseProgressBar();
            if (jSONObject != null) {
                try {
                    CircleQRCodeActivity.this.z = jSONObject;
                    JSONObject jSONObjectOptJSONObject = CircleQRCodeActivity.this.z.optJSONObject("data");
                    if (jSONObjectOptJSONObject != null) {
                        CircleQRCodeActivity.this.y = jSONObjectOptJSONObject.optString("roomQrCode");
                    }
                    CircleQRCodeActivity.this.updateViews();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.ErrorListener {
        public c() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            CircleQRCodeActivity.this.hideBaseProgressBar();
            sy5.e(CircleQRCodeActivity.this, R.string.send_failed, 0).g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N1(View view) {
        BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD, BaseActivityPermissionDispatcher.PermissionUsage.CIRCLE_SELECT_SAVE_IMAGE);
        HashMap map = new HashMap();
        GroupInfoItem groupInfoItem = this.A;
        if (groupInfoItem != null) {
            map.put("rid", groupInfoItem.getGroupId());
        }
        oc0.h("lx_group_code_save_click", map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O1(View view) {
        MessageVo threadBizType = MessageVo.buildNameCardMessage((String) null, (String) null, this.A, 0, ir5.b()).setThreadBizType(this, 1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(threadBizType);
        Intent intent = new Intent(this, (Class<?>) SendMessageActivity.class);
        intent.putExtra("message_vo_list", arrayList);
        intent.putExtra("extra_from", 2);
        intent.putExtra("extra_is_show_group", false);
        intent.addFlags(268435456);
        startActivity(intent);
        HashMap map = new HashMap();
        GroupInfoItem groupInfoItem = this.A;
        if (groupInfoItem != null) {
            map.put("rid", groupInfoItem.getGroupId());
        }
        oc0.h("lx_group_code_share_click", map);
    }

    public void H1(Bitmap bitmap) {
        if (bitmap != null) {
            new a().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, bitmap);
        }
    }

    public final String I1(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rid", this.A.getGroupId());
            if (z) {
                jSONObject.put("QrCode", this.y);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public final boolean J1() {
        Intent intent = getIntent();
        if (intent != null) {
            this.A = (GroupInfoItem) intent.getParcelableExtra("key_group_info");
            this.B = intent.getIntExtra("from_source", -1);
        }
        return this.A == null;
    }

    public final void K1() {
        updateViews();
        HashMap map = new HashMap();
        map.put("roomId", this.A.getGroupId());
        try {
            new j92(this.C, this.E, map).n();
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public final void L1() {
        this.v.setOnClickListener(new View.OnClickListener() { // from class: lb0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f18950a.N1(view);
            }
        });
        this.w.setOnClickListener(new View.OnClickListener() { // from class: mb0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19180a.O1(view);
            }
        });
    }

    public final void M1() {
        P1();
        this.q = (ConstraintLayout) findViewById(R.id.circle_qr_code_group);
        this.r = (EffectiveShapeView) findViewById(R.id.circle_qr_code_avatar);
        this.s = (TextView) findViewById(R.id.circle_qr_code_name);
        this.t = (TextView) findViewById(R.id.circle_qr_code_number);
        this.u = (CircleFixedRatioImageView) findViewById(R.id.circle_qr_code_qr_image);
        this.v = (TextView) findViewById(R.id.circle_qr_code_download);
        this.w = (TextView) findViewById(R.id.circle_qr_code_share);
        this.x = (TextView) findViewById(R.id.tv_invite);
    }

    public final void P1() {
        Toolbar toolbarInitToolbar = initToolbar(R.string.group_qr_code);
        setSupportActionBar(toolbarInitToolbar);
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText(R.string.group_qr_code);
        ((TextView) toolbarInitToolbar.findViewById(R.id.action_button)).setVisibility(8);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_qr_code);
        if (J1()) {
            finish();
            return;
        }
        M1();
        L1();
        K1();
        HashMap map = new HashMap();
        map.put(az.at, Integer.valueOf(this.B));
        GroupInfoItem groupInfoItem = this.A;
        if (groupInfoItem != null) {
            map.put("rid", groupInfoItem.getGroupId());
        }
        oc0.h("lx_group_edit_code_show", map);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        super.onPermissionGrant(permissionType, permissionUsage, z);
        if (permissionUsage == BaseActivityPermissionDispatcher.PermissionUsage.CIRCLE_SELECT_SAVE_IMAGE) {
            this.q.setDrawingCacheEnabled(true);
            Bitmap drawingCache = this.q.getDrawingCache();
            if (drawingCache != null) {
                H1(drawingCache);
            }
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void updateViews() {
        GroupInfoItem groupInfoItem = this.A;
        if (groupInfoItem != null) {
            this.s.setText(groupInfoItem.getNameForShow());
            if (!TextUtils.isEmpty(this.A.getIconURL())) {
                gr2.j().h(this.A.getGroupHeadImgUrl(), this.r, bq6.s());
            }
            this.t.setText("群号：" + this.A.getRnumber());
        }
        JSONObject jSONObject = this.z;
        if (jSONObject != null) {
            int iOptInt = jSONObject.optInt("resultCode", -1);
            if (iOptInt != 0) {
                if (iOptInt == 4022) {
                    new se2(this.u, "").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                    this.x.setVisibility(0);
                    this.x.setText(this.z.optString(MediationConstant.KEY_ERROR_MSG));
                    return;
                }
                return;
            }
            JSONObject jSONObjectOptJSONObject = this.z.optJSONObject("data");
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("roomQrCode");
                this.y = strOptString;
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                new se2(this.u, this.y).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            }
        }
    }
}
