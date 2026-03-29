package com.zm.adxsdk.tools.defective.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.zm.adxsdk.protocol.api.WfConfig;
import com.zm.adxsdk.tools.f;
import com.zm.adxsdk.tools.g;
import com.zm.adxsdk.tools.q;
import com.zm.adxsdk.tools.r;
import com.zm.fission.fataar.R$color;
import com.zm.fission.fataar.R$id;
import com.zm.fission.fataar.R$layout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SlotDetailActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f16602a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public LinearLayout i;
    public Button j;
    public String k;
    public String l;
    public String m;
    public String n;
    public StringBuilder o;
    public boolean p;

    public final boolean a(String str, String str2) {
        String str3 = this.k;
        return !TextUtils.isEmpty(str3) && str3.contains("_") && f.f16603a.equals(str) && f.b.equals(str2);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.wf_shell_df_layout_activity_slot_detail);
        this.k = getIntent().getStringExtra("slot_id");
        this.l = getIntent().getStringExtra("slot_type");
        this.m = getIntent().getStringExtra("request_result");
        this.n = getIntent().getStringExtra("error_msg");
        Log.d("SlotDetailActivity", "get slotId:" + this.k + "slot_type:" + this.l);
        this.f16602a = (TextView) findViewById(R$id.wf_sdk_df_item_slot_id);
        this.b = (TextView) findViewById(R$id.wf_sdk_df_item_app_id);
        this.c = (TextView) findViewById(R$id.wf_sdk_df_item_token_id);
        this.d = (TextView) findViewById(R$id.wf_sdk_df_detail_slot_type);
        this.e = (TextView) findViewById(R$id.wf_sdk_df_detail_slot_request_log);
        this.j = (Button) findViewById(R$id.wf_sdk_df_detail_request_ad);
        this.f = (TextView) findViewById(R$id.wf_sdk_df_request_status);
        this.g = (TextView) findViewById(R$id.wf_sdk_df_request_status_tv);
        this.h = (TextView) findViewById(R$id.wf_sdk_df_request_error_msg);
        this.i = (LinearLayout) findViewById(R$id.wf_sdk_df_request_error_layout);
        findViewById(R$id.wf_df_slot_detail_back_image).setOnClickListener(new q(this));
        if (!TextUtils.isEmpty(this.m)) {
            this.g.setVisibility(0);
            this.f.setVisibility(0);
            this.f.setText(this.m);
        }
        if (!TextUtils.isEmpty(this.n)) {
            this.i.setVisibility(0);
            this.h.setText(this.n);
        }
        WfConfig wfConfig = g.a().f16604a;
        String appId = wfConfig != null ? wfConfig.getAppId() : "";
        WfConfig wfConfig2 = g.a().f16604a;
        String token = wfConfig2 != null ? wfConfig2.getToken() : "";
        String str = this.k;
        if (!TextUtils.isEmpty(str) && str.contains("_") && !a(appId, token)) {
            this.f16602a.setTextColor(getResources().getColor(R$color.wf_shell_df_error_warn));
            appId = this.k + "（测试）";
        }
        this.f16602a.setText(this.k);
        if (TextUtils.isEmpty(this.l)) {
            this.l = "未知";
        }
        this.d.setText(this.l);
        if (TextUtils.isEmpty(appId)) {
            this.b.setTextColor(getResources().getColor(R$color.wf_shell_df_error_warn));
            String str2 = f.f16603a;
            Log.e("FISSION_CHECK", "AppId初始化接口未传入，请检查处理！！！");
            appId = "未传入";
        }
        if (f.f16603a.equals(appId) && !a(appId, token)) {
            this.b.setTextColor(getResources().getColor(R$color.wf_shell_df_error_warn));
            appId = appId + "（测试）";
        }
        this.b.setText(appId);
        if (TextUtils.isEmpty(token)) {
            this.c.setTextColor(getResources().getColor(R$color.wf_shell_df_error_warn));
            Log.e("FISSION_CHECK", "Token初始化接口未传入，请检查处理！！！");
            token = "未传入";
        }
        if (f.b.equals(token) && !a(appId, token)) {
            this.c.setTextColor(getResources().getColor(R$color.wf_shell_df_error_warn));
            token = token + "（测试）";
        }
        this.c.setText(token);
        this.j.setOnClickListener(new r(this));
    }

    public final void a(String str) {
        if (this.o == null) {
            this.o = new StringBuilder();
        }
        this.o.append(str);
        this.o.append("\n");
        this.e.setText(this.o.toString());
    }
}
