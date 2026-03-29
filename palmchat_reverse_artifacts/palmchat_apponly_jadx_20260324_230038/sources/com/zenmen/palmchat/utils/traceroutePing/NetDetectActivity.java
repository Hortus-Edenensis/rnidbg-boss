package com.zenmen.palmchat.utils.traceroutePing;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.amap.api.services.district.DistrictSearchQuery;
import com.lantern.auth.conf.WkSDKConfig;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.d;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.utils.traceroutePing.ReportVo;
import com.zenmen.palmchat.utils.traceroutePing.a;
import defpackage.ac1;
import defpackage.az2;
import defpackage.go2;
import defpackage.hx3;
import defpackage.it0;
import defpackage.l50;
import defpackage.nl0;
import defpackage.ry5;
import defpackage.sw4;
import defpackage.tg4;
import defpackage.v4;
import defpackage.zn6;
import defpackage.zw4;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class NetDetectActivity extends BaseActionBarActivity {
    public TextView q;
    public boolean r = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends go2<LXBaseNetBean<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReportVo f15762a;

        public a(ReportVo reportVo) {
            this.f15762a = reportVo;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject = new JSONObject(az2.c(this.f15762a));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            sw4 sw4VarC = sw4.c(1, nl0.z + "/bizpub.network.testing.upload.result", jSONObject);
            sw4VarC.h = false;
            return sw4VarC;
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<String> lXBaseNetBean, Exception exc) {
            NetDetectActivity.this.hideBaseProgressBar();
            boolean z2 = z && lXBaseNetBean.isSuccess();
            if (!z2) {
                ry5.a("上报失败，请稍后重试");
            }
            NetDetectActivity.this.q.setText(z2 ? "检测完成并上报成功" : "检测并上报");
            NetDetectActivity.this.q.setEnabled(!z2);
            NetDetectActivity.this.r = false;
            HashMap map = new HashMap();
            map.put("success", String.valueOf(z2));
            map.put("info", az2.c(this.f15762a));
            zn6.i("client_net_detect_result", map);
            HashMap map2 = new HashMap();
            map2.put("success", String.valueOf(z2));
            map2.put("info", az2.c(this.f15762a));
            LogUtil.uploadInfoImmediate("client_net_detect_result", map2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements a.e {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f15764a;

            public a(int i) {
                this.f15764a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetDetectActivity.this.q.setText("检测中 " + this.f15764a + "%");
            }
        }

        /* JADX INFO: renamed from: com.zenmen.palmchat.utils.traceroutePing.NetDetectActivity$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC1124b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ List f15765a;
            public final /* synthetic */ List b;
            public final /* synthetic */ String c;

            public RunnableC1124b(List list, List list2, String str) {
                this.f15765a = list;
                this.b = list2;
                this.c = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetDetectActivity.this.F1(this.f15765a, this.b, this.c);
            }
        }

        public b() {
        }

        @Override // com.zenmen.palmchat.utils.traceroutePing.a.e
        public void a(List<ReportVo.PingResult> list, List<ReportVo.DownloadResResult> list2, String str) {
            NetDetectActivity.this.runOnUiThread(new RunnableC1124b(list, list2, str));
        }

        @Override // com.zenmen.palmchat.utils.traceroutePing.a.e
        public boolean b() {
            return !NetDetectActivity.this.r;
        }

        @Override // com.zenmen.palmchat.utils.traceroutePing.a.e
        public void onProgress(int i) {
            NetDetectActivity.this.runOnUiThread(new a(i));
        }
    }

    public final void E1() {
        this.q = (TextView) findViewById(R.id.btnTv);
    }

    public final void F1(List<ReportVo.PingResult> list, List<ReportVo.DownloadResResult> list2, String str) {
        if (isFinishing() || !this.r) {
            return;
        }
        showBaseProgressBar("上传中", false);
        ReportVo reportVo = new ReportVo();
        reportVo.platformND = "android";
        reportVo.modelND = ac1.b;
        reportVo.versionNameND = ac1.g;
        reportVo.uidND = v4.e(this);
        reportVo.clientIpInfo = str;
        reportVo.localDnsInfo = it0.k().r();
        reportVo.pingResults = list;
        reportVo.downloadResResults = list2;
        reportVo.f15766net = hx3.c();
        reportVo.car = WkSDKConfig.getCurrentCarNetType();
        reportVo.osVerND = ac1.e;
        reportVo.locationPermissionGranted = tg4.b(this, BaseActivityPermissionDispatcher.PermissionType.LOCATION.permissionList);
        LocationEx locationExI = d.g().i(2147483647L);
        if (locationExI != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("longitude", locationExI.getLongitude());
                jSONObject.put("latitude", locationExI.getLatitude());
                jSONObject.put("cityCode", locationExI.getCityCode());
                jSONObject.put(DistrictSearchQuery.KEYWORDS_CITY, locationExI.getCity());
                jSONObject.put(DistrictSearchQuery.KEYWORDS_PROVINCE, locationExI.getProvince());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            reportVo.address = jSONObject.toString();
        }
        zw4.e(new a(reportVo));
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_app_settings_net_detect);
        initToolbar("网络状态上报");
        E1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.r = false;
    }

    public void onDetect(View view) {
        if (l50.a()) {
            return;
        }
        if (!hx3.m(this)) {
            ry5.a("网络已断开，请检查网络");
            return;
        }
        this.r = true;
        this.q.setEnabled(false);
        com.zenmen.palmchat.utils.traceroutePing.a.j(new b());
    }
}
