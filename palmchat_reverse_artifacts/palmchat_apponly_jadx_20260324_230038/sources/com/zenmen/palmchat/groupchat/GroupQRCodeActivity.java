package com.zenmen.palmchat.groupchat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.f;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.QRCodeScan.ScannerActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.videocall.c;
import defpackage.hc2;
import defpackage.is0;
import defpackage.pu1;
import defpackage.se2;
import defpackage.sy5;
import defpackage.wm3;
import defpackage.xt;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class GroupQRCodeActivity extends BaseActionBarActivity {
    public Toolbar q;
    public ImageView r;
    public TextView s;
    public TextView t;
    public LinearLayout u;
    public String v;
    public String w;
    public GroupInfoItem x;
    public JSONObject y;
    public String[] z = {AppContext.getContext().getResources().getString(R.string.save_to_phone), AppContext.getContext().getResources().getString(R.string.menu_scan_qrcode)};
    public int[] A = null;
    public is0.f B = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements is0.f {
        public a() {
        }

        @Override // is0.f
        public void onItemClicked(int i) {
            if (i != 0) {
                if (i == 1 && !c.f()) {
                    GroupQRCodeActivity.this.startActivity(new Intent(AppContext.getContext(), (Class<?>) ScannerActivity.class));
                    return;
                }
                return;
            }
            GroupQRCodeActivity.this.u.setDrawingCacheEnabled(true);
            Bitmap drawingCache = GroupQRCodeActivity.this.u.getDrawingCache();
            if (drawingCache != null) {
                GroupQRCodeActivity.this.C1(drawingCache);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends AsyncTask<Bitmap, Void, String> {
        public b() {
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
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "5202", "1", "1", GroupQRCodeActivity.this.D1(true));
            GroupQRCodeActivity groupQRCodeActivity = GroupQRCodeActivity.this;
            sy5.f(groupQRCodeActivity, groupQRCodeActivity.getResources().getString(R.string.save_to_dir, pu1.m()), 1).g();
        }
    }

    public void C1(Bitmap bitmap) {
        if (bitmap != null) {
            new b().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, bitmap);
        }
    }

    public final String D1(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rid", this.v);
            if (z) {
                jSONObject.put("QrCode", this.w);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public final void E1() {
        Toolbar toolbarInitToolbar = initToolbar(R.string.group_qrcode_card);
        this.q = toolbarInitToolbar;
        setSupportActionBar(toolbarInitToolbar);
    }

    public final void F1() {
        this.r = (ImageView) findViewById(R.id.qrcode_image);
        this.s = (TextView) findViewById(R.id.period_of_validity);
        this.t = (TextView) findViewById(R.id.exceeds);
        this.u = (LinearLayout) findViewById(R.id.qrcode_combine);
        this.t.setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.nickname_textview);
        ImageView imageView = (ImageView) findViewById(R.id.portrait);
        GroupInfoItem groupInfoItem = this.x;
        if (groupInfoItem != null) {
            if (TextUtils.isEmpty(groupInfoItem.getGroupName())) {
                textView.setText(this.x.getGroupLocalName());
            } else {
                textView.setText(this.x.getGroupName());
            }
            if (!TextUtils.isEmpty(this.x.getIconURL())) {
                hc2.b(this).load(this.x.getGroupHeadImgUrl()).placeholder(R.drawable.default_portrait).error(R.drawable.default_portrait).transform(new RoundedCornersTransformation(13, 0)).into(imageView);
            }
        }
        JSONObject jSONObject = this.y;
        if (jSONObject != null) {
            int iOptInt = jSONObject.optInt("resultCode", -1);
            if (iOptInt != 0) {
                if (iOptInt == 4022) {
                    new se2(this.r, "").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                    this.t.setVisibility(0);
                    this.t.setText(this.y.optString(MediationConstant.KEY_ERROR_MSG));
                    return;
                }
                return;
            }
            JSONObject jSONObjectOptJSONObject = this.y.optJSONObject("data");
            if (jSONObjectOptJSONObject != null) {
                this.w = jSONObjectOptJSONObject.optString("roomQrCode");
                String strOptString = jSONObjectOptJSONObject.optString("days");
                String strOptString2 = jSONObjectOptJSONObject.optString("dueMonth");
                String strOptString3 = jSONObjectOptJSONObject.optString("dueDay");
                if (!TextUtils.isEmpty(this.w)) {
                    new se2(this.r, this.w).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                }
                this.s.setText(getString(R.string.qrcode_group_valid, strOptString, strOptString2, strOptString3));
            }
        }
    }

    public final void G1() {
        Intent intent = getIntent();
        if (intent != null) {
            GroupInfoItem groupInfoItem = (GroupInfoItem) intent.getParcelableExtra(f.K);
            this.x = groupInfoItem;
            if (groupInfoItem != null) {
                this.v = groupInfoItem.getGroupId();
            }
            String stringExtra = intent.getStringExtra("extra_qr_data");
            if (stringExtra != null) {
                try {
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    this.y = jSONObject;
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                    if (jSONObjectOptJSONObject != null) {
                        this.w = jSONObjectOptJSONObject.optString("roomQrCode");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_group_qrcode);
        G1();
        E1();
        F1();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_user_info_detail, menu);
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 82 || keyEvent.getAction() != 0 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        showPopupMenu(this, this.q, this.z, this.A, this.B, null);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId == R.id.menu_more) {
            showPopupMenu(this, this.q, this.z, this.A, this.B, null);
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
