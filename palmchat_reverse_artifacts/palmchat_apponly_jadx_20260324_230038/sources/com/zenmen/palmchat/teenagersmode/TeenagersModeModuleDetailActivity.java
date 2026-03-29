package com.zenmen.palmchat.teenagersmode;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.wifi.adsdk.download.LxAdDLManager;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.gr2;
import defpackage.je1;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class TeenagersModeModuleDetailActivity extends BaseActionBarActivity {
    public int q;
    public int r;
    public String s;
    public String t;
    public String u;
    public ImageView v;
    public TextView w;
    public TextView x;
    public je1 y;

    public final je1 A1() {
        if (this.y == null) {
            int i = this.r;
            if (i <= 0) {
                i = R.drawable.icon_loading_fail_bg;
            }
            this.y = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).z(i).A(i).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r();
        }
        return this.y;
    }

    public final void B1() {
        this.v = (ImageView) findViewById(R.id.img_icon);
        this.w = (TextView) findViewById(R.id.tv_title);
        this.x = (TextView) findViewById(R.id.tv_des);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("setting", this.q);
            LogUtil.onClickEvent("settiings_show", null, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public final void C1() {
        Intent intent = getIntent();
        this.q = intent.getIntExtra("type", 1);
        this.r = intent.getIntExtra("iconId", 0);
        this.s = intent.getStringExtra(LxAdDLManager.ITEM_ICONURL);
        this.t = intent.getStringExtra("title");
        this.u = intent.getStringExtra(LxAdDLManager.ITEM_DESC);
    }

    public final void D1() {
        if (TextUtils.isEmpty(this.s)) {
            this.v.setImageResource(this.r);
        } else {
            gr2.j().h(this.s, this.v, A1());
        }
        this.w.setText(this.t);
        this.x.setText(this.u);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_teenagers_mode_module_detail);
        C1();
        initToolbar(this.t);
        B1();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        D1();
    }
}
