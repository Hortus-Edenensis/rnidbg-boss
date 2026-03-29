package com.zenmen.square.fragment.online;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.giftkit.a;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import defpackage.ap3;
import defpackage.az2;
import defpackage.bj5;
import defpackage.go2;
import defpackage.hc2;
import defpackage.hx3;
import defpackage.l50;
import defpackage.nl0;
import defpackage.of2;
import defpackage.ry5;
import defpackage.sw4;
import defpackage.z64;
import defpackage.zw4;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class OnLineDialogActivity extends FrameworkBaseActivity {
    public TextView A;
    public View B;
    public TextView C;
    public TextView E;
    public ImageView F;
    public View G;
    public View H;
    public TextView I;
    public ImageView J;
    public TextView K;
    public View L;
    public OnLineDetailData q;
    public View r;
    public ImageView s;
    public ImageView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public View x;
    public View y;
    public TextView z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            OnLineDialogActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            z64.I(OnLineDialogActivity.this.q, OnLineDialogActivity.this);
            OnLineDialogActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a() || OnLineDialogActivity.this.q == null || OnLineDialogActivity.this.q.userInfo == null) {
                return;
            }
            z64.j();
            ap3.l(OnLineDialogActivity.this, OnLineDialogActivity.this.q.userInfo.uid + "", "", 5058);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            OnLineDialogActivity.this.J1();
            z64.u();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends go2<LXBaseNetBean<JSONObject>> {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(500L);
                    OnLineDialogActivity onLineDialogActivity = OnLineDialogActivity.this;
                    onLineDialogActivity.I1(onLineDialogActivity);
                } catch (Exception unused) {
                }
            }
        }

        public e() {
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("unlockTargetUid", OnLineDialogActivity.this.q.userInfo.uid + "");
            map.put("scheduleOrderId", OnLineDialogActivity.this.q.scheduleInfo.scheduleOrderId);
            map.put("pandaValueLx62476", WkAdxAdConfigMg.DSP_NAME_CSJ);
            map.put("taichiGroupLx66032", bj5.b().a().T("LX-66344", "A"));
            return sw4.b(1, nl0.z + "/map.schedule.unlock.v2", map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<JSONObject> lXBaseNetBean, Exception exc) {
            LogUtil.d(FrameworkBaseActivity.TAG, "startOtherChat info onResult=" + az2.c(lXBaseNetBean));
            if (lXBaseNetBean != null) {
                int i = lXBaseNetBean.resultCode;
                if (i == 0) {
                    bj5.b().a().h0(OnLineDialogActivity.this.q);
                    OnLineDialogActivity.this.G.setVisibility(0);
                    OnLineDialogActivity.this.H.setVisibility(8);
                    ap3.l(OnLineDialogActivity.this, OnLineDialogActivity.this.q.userInfo.uid + "", "", 5058);
                    return;
                }
                if (i == -1004) {
                    ry5.a(!TextUtils.isEmpty(lXBaseNetBean.errorMsg) ? lXBaseNetBean.errorMsg : "您的连信豆不足，请先充值后再解锁");
                    new Thread(new a()).start();
                } else if (i == -1009 || i == -1008) {
                    ry5.a(!TextUtils.isEmpty(lXBaseNetBean.errorMsg) ? lXBaseNetBean.errorMsg : "该行程动态已消失，看看其他人的行程吧");
                } else {
                    ry5.a(lXBaseNetBean.errorMsg);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements a.InterfaceC1055a {
        public f() {
        }

        @Override // com.zenmen.palmchat.giftkit.a.InterfaceC1055a
        public void a(boolean z) {
            LogUtil.d("", "showStartCharge startCharge result success " + z);
            if (z) {
                OnLineDialogActivity.this.J1();
            } else {
                ry5.a("充值失败，请稍后再试");
            }
        }
    }

    public final void F1() {
        OnLineDetailData onLineDetailData = this.q;
        if (onLineDetailData != null) {
            OnLineDetailUserInfo onLineDetailUserInfo = onLineDetailData.userInfo;
            if (onLineDetailUserInfo != null) {
                if (!TextUtils.isEmpty(onLineDetailUserInfo.avatar)) {
                    hc2.b(this).load(this.q.userInfo.avatar).error(R$drawable.default_portrait).into(this.s);
                }
                if (this.q.userInfo.gender == 0) {
                    this.t.setImageResource(R$drawable.online_detail_man_bg);
                }
                if (!TextUtils.isEmpty(this.q.userInfo.nickname)) {
                    this.u.setText(this.q.userInfo.nickname);
                }
                StringBuilder sb = new StringBuilder();
                if (this.q.isMine) {
                    this.L.setVisibility(8);
                    if (!TextUtils.isEmpty(this.q.userInfo.cityName)) {
                        sb.append(this.q.userInfo.cityName);
                    }
                } else {
                    this.L.setVisibility(0);
                    if (!TextUtils.isEmpty(this.q.userInfo.cityName)) {
                        sb.append(this.q.userInfo.cityName);
                    }
                    sb.append(" · " + this.q.userInfo.distanceKm + "km");
                }
                if (TextUtils.isEmpty(sb)) {
                    this.v.setVisibility(8);
                } else {
                    this.v.setVisibility(0);
                    this.v.setText(sb);
                }
                if (TextUtils.isEmpty(this.q.userInfo.onlineDesc)) {
                    this.w.setVisibility(8);
                } else {
                    this.w.setVisibility(0);
                    if ("当前在线".equals(this.q.userInfo.onlineDesc)) {
                        this.w.setTextColor(Color.parseColor("#14CD64"));
                    }
                    this.v.append(" · ");
                    this.w.setText(this.q.userInfo.onlineDesc);
                }
            }
            int i = this.q.type;
            String str = "";
            if (i == 2) {
                this.x.setVisibility(0);
                this.y.setVisibility(8);
                if (this.q.isMine) {
                    z64.o(3, this.q.activeInfo.itemId + "", this.q.activeInfo.content);
                } else {
                    z64.o(1, this.q.activeInfo.itemId + "", this.q.activeInfo.content);
                }
                if (this.q.activeInfo != null) {
                    this.B.setVisibility(0);
                    this.G.setVisibility(8);
                    this.H.setVisibility(8);
                    if (!TextUtils.isEmpty(this.q.activeInfo.url)) {
                        hc2.b(this).load(this.q.activeInfo.url).error(R$drawable.online_status_msg_bg).into(this.J);
                    }
                    if (!TextUtils.isEmpty(this.q.activeInfo.content)) {
                        this.K.setText(this.q.activeInfo.content);
                    }
                    if (!TextUtils.isEmpty(this.q.activeInfo.itemUrl)) {
                        hc2.b(this).load(this.q.activeInfo.itemUrl).into(this.F);
                    }
                    if (!TextUtils.isEmpty(this.q.activeInfo.itemText)) {
                        this.E.setText(this.q.activeInfo.itemText);
                    }
                    this.C.setText("(" + this.q.activeInfo.price + "连信豆)");
                    return;
                }
                return;
            }
            if (i == 1) {
                this.x.setVisibility(8);
                this.y.setVisibility(0);
                if (this.q.scheduleInfo != null) {
                    this.B.setVisibility(8);
                    this.G.setVisibility(0);
                    this.H.setVisibility(0);
                    String strU = bj5.b().a().U(this.q.scheduleInfo.tag);
                    z64.o(2, this.q.scheduleInfo.scheduleOrderId, strU);
                    if (!TextUtils.isEmpty(strU)) {
                        this.z.setText(strU);
                    }
                    if (!TextUtils.isEmpty(this.q.scheduleInfo.address)) {
                        this.A.setText(this.q.scheduleInfo.address);
                    }
                    if (this.q.userInfo != null) {
                        str = this.q.userInfo.uid + "";
                    }
                    if (bj5.b().a().e(str, this.q.scheduleInfo.scheduleOrderId)) {
                        this.G.setVisibility(0);
                        this.H.setVisibility(8);
                        return;
                    }
                    this.G.setVisibility(8);
                    this.H.setVisibility(0);
                    this.I.setText("(" + bj5.b().a().s() + ")");
                }
            }
        }
    }

    public final void G1() {
        this.r = findViewById(R$id.public_dialog_close);
        this.s = (ImageView) findViewById(R$id.portrait_icon);
        this.t = (ImageView) findViewById(R$id.online_gender);
        this.u = (TextView) findViewById(R$id.online_nick);
        this.v = (TextView) findViewById(R$id.online_city_layout);
        this.w = (TextView) findViewById(R$id.online_time_layout);
        this.x = findViewById(R$id.online_status_layout);
        this.K = (TextView) findViewById(R$id.online_status_desc);
        this.J = (ImageView) findViewById(R$id.online_status_icon);
        this.y = findViewById(R$id.online_trip_layout);
        this.z = (TextView) findViewById(R$id.online_trip_tag);
        this.A = (TextView) findViewById(R$id.online_trip_address);
        this.B = findViewById(R$id.online_gift_layout);
        this.E = (TextView) findViewById(R$id.online_gift_btn_desc);
        this.C = (TextView) findViewById(R$id.online_gift_price);
        this.F = (ImageView) findViewById(R$id.online_gift_img_icon);
        this.G = findViewById(R$id.online_saihi_layout);
        this.H = findViewById(R$id.online_trip_unlock_layout);
        this.I = (TextView) findViewById(R$id.online_unlock_price);
        this.L = findViewById(R$id.online_other_layout);
        this.r.setOnClickListener(new a());
        this.B.setOnClickListener(new b());
        this.G.setOnClickListener(new c());
        this.H.setOnClickListener(new d());
    }

    public final void H1() {
        setContentView(R$layout.layout_online_detail_dialog);
        G1();
        F1();
    }

    public final void I1(Context context) {
        if (hx3.m(context)) {
            com.zenmen.palmchat.giftkit.a.a().b(context, of2.f(200302, 2003, "", 0, "", 0), 20L, new f());
        }
    }

    public final void J1() {
        OnLineDetailData onLineDetailData = this.q;
        if (onLineDetailData == null || onLineDetailData.scheduleInfo == null || onLineDetailData.userInfo == null) {
            return;
        }
        zw4.e(new e());
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            return;
        }
        String stringExtra = getIntent().getStringExtra("key_activity_detail_data");
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
            return;
        }
        OnLineDetailData onLineDetailData = (OnLineDetailData) az2.a(stringExtra, OnLineDetailData.class);
        this.q = onLineDetailData;
        if (onLineDetailData == null) {
            finish();
        } else {
            H1();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
