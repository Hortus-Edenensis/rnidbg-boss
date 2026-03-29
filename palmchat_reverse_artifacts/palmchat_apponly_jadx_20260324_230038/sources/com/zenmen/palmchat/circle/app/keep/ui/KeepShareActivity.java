package com.zenmen.palmchat.circle.app.keep.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.app.keep.model.KeepShareData;
import com.zenmen.palmchat.circle.app.keep.model.KeepTrainData;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.ka3;
import defpackage.oc0;
import defpackage.p75;
import defpackage.ry5;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class KeepShareActivity extends FrameworkBaseActivity implements View.OnClickListener {
    public TextView A;
    public TextView B;
    public KeepShareData q;
    public ImageView r;
    public TextView s;
    public EffectiveShapeView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public ImageView z;

    public static void G1(Context context, KeepShareData keepShareData) {
        Intent intent = new Intent(context, (Class<?>) KeepShareActivity.class);
        intent.putExtra("data", keepShareData);
        context.startActivity(intent);
    }

    public final void A1() {
        HashMap<String, Object> mapB1 = B1();
        if (mapB1 == null) {
            return;
        }
        mapB1.put("report_type", "click");
        oc0.h("pagekeepcheck_close", mapB1);
    }

    public final HashMap<String, Object> B1() {
        KeepShareData keepShareData = this.q;
        if (keepShareData == null || keepShareData.trainData == null) {
            return null;
        }
        HashMap<String, Object> map = new HashMap<>();
        if (!TextUtils.isEmpty(this.q.trainData.actId)) {
            map.put("actid", this.q.trainData.actId);
        }
        if (!TextUtils.isEmpty(this.q.trainData.lessonId)) {
            map.put("lessonid", this.q.trainData.lessonId);
        }
        if (!TextUtils.isEmpty(this.q.trainData.planId)) {
            map.put("planid", this.q.trainData.planId);
        }
        return map;
    }

    public final void C1() {
        KeepTrainData keepTrainData;
        this.r = (ImageView) findViewById(R.id.image_close);
        this.s = (TextView) findViewById(R.id.text_share);
        this.t = (EffectiveShapeView) findViewById(R.id.image_head);
        this.u = (TextView) findViewById(R.id.text_name);
        this.v = (TextView) findViewById(R.id.text_date);
        this.w = (TextView) findViewById(R.id.text_time);
        this.x = (TextView) findViewById(R.id.text_count);
        this.y = (TextView) findViewById(R.id.text_action);
        this.z = (ImageView) findViewById(R.id.image_background);
        this.A = (TextView) findViewById(R.id.text_repeat);
        this.B = (TextView) findViewById(R.id.text_unit);
        this.r.setOnClickListener(this);
        this.s.setOnClickListener(this);
        KeepShareData keepShareData = this.q;
        if (keepShareData == null || (keepTrainData = keepShareData.trainData) == null) {
            return;
        }
        gr2.j().h(keepTrainData.headUrl, this.t, bq6.s());
        gr2.j().h(keepTrainData.background, this.z, bq6.s());
        this.u.setText(keepTrainData.userName);
        this.v.setText(keepTrainData.date);
        this.w.setText(keepTrainData.time);
        this.y.setText(keepTrainData.shareName);
        this.x.setText(String.valueOf(keepTrainData.count));
        this.A.setText(keepTrainData.repeat);
        this.B.setText(keepTrainData.unit);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void D1() {
        String string;
        String strOptString;
        String strOptString2;
        String strOptString3;
        if (this.q == null) {
            ry5.a("数据错误，无法分享");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.q.shareMessage);
            jSONObject.put("shareType", 0);
            string = jSONObject.toString();
        } catch (JSONException unused) {
            string = null;
            strOptString = null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(this.q.appInfo);
            strOptString = jSONObject2.optString("appid");
            try {
                strOptString2 = jSONObject2.optString(WfConstant.EVENT_KEY_APP_NAME);
                try {
                    strOptString3 = jSONObject2.optString("appIcon");
                } catch (JSONException unused2) {
                    strOptString3 = null;
                }
            } catch (JSONException unused3) {
                strOptString2 = null;
            }
        } catch (JSONException unused4) {
            strOptString = null;
            strOptString2 = strOptString;
            strOptString3 = null;
            ka3.b bVar = new ka3.b(strOptString, strOptString2, strOptString3, null);
            if (TextUtils.isEmpty(string)) {
            }
            TextUtils.isEmpty(p75.h(bVar, string, this, null));
            finish();
        }
        ka3.b bVar2 = new ka3.b(strOptString, strOptString2, strOptString3, null);
        if (TextUtils.isEmpty(string)) {
            string = this.q.shareMessage;
        }
        TextUtils.isEmpty(p75.h(bVar2, string, this, null));
        finish();
    }

    public final void E1() {
        HashMap<String, Object> mapB1 = B1();
        if (mapB1 == null) {
            return;
        }
        mapB1.put("report_type", "click");
        oc0.h("pagekeepcheck_share", mapB1);
    }

    public final void F1() {
        HashMap<String, Object> mapB1 = B1();
        if (mapB1 == null) {
            return;
        }
        mapB1.put("report_type", "view");
        oc0.h("pagekeepcheck", mapB1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.image_close) {
            finish();
            A1();
        } else if (id == R.id.text_share) {
            D1();
            E1();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_keep_share);
        this.q = (KeepShareData) getIntent().getParcelableExtra("data");
        C1();
        F1();
    }
}
