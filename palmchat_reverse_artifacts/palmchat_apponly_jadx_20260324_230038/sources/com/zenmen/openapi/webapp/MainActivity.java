package com.zenmen.openapi.webapp;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.bpea.entry.common.DataType;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.ads.ex;
import com.huawei.hms.ads.ld;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.wifi.adsdk.download.LxAdDLManager;
import com.zenmen.openapi.impl.OAAccountUtils;
import com.zenmen.openapi.offline.request.FetchPkgInfo;
import com.zenmen.openapi.webapp.floatview.AppFloatIcon;
import com.zenmen.openapi.webapp.floatview.AppFloatMenuBox;
import com.zenmen.openapi.webapp.widget.FloatMenu;
import com.zenmen.openapi.webapp.widget.MenuDialogView;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import defpackage.a46;
import defpackage.aa3;
import defpackage.an1;
import defpackage.b35;
import defpackage.b64;
import defpackage.bu3;
import defpackage.f84;
import defpackage.fa3;
import defpackage.fz4;
import defpackage.g84;
import defpackage.h84;
import defpackage.jn3;
import defpackage.jo6;
import defpackage.k86;
import defpackage.ka3;
import defpackage.ma3;
import defpackage.md2;
import defpackage.me1;
import defpackage.n54;
import defpackage.o54;
import defpackage.p75;
import defpackage.r75;
import defpackage.sm5;
import defpackage.sy5;
import defpackage.tj2;
import defpackage.tn1;
import defpackage.tn2;
import defpackage.vg;
import defpackage.vt2;
import defpackage.wc;
import defpackage.wn6;
import defpackage.x54;
import java.util.ArrayList;
import java.util.List;
import org.apache.cordova.CordovaWebViewClient;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class MainActivity extends FragmentActivity implements View.OnClickListener, md2, fa3 {
    public FragmentManager q;
    public FloatMenu r;
    public vg s;
    public tn1 v;
    public boolean t = false;
    public final BroadcastReceiver u = new a();
    public final fa3 w = new b();
    public boolean x = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getAction() == null || !"com.zenmen.openapi.ACTION_USER_LOGOUT".equals(intent.getAction())) {
                return;
            }
            MainActivity.this.K1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements fa3 {
        public b() {
        }

        @Override // defpackage.fa3
        @RequiresApi(api = 19)
        public void onEvent(int i, Object obj) {
            if (i == 1) {
                MainActivity.this.i2();
                return;
            }
            if (i == 2) {
                MainActivity.this.I1();
                return;
            }
            if (i == 3) {
                MainActivity.this.V1();
                return;
            }
            if (i == 4) {
                MainActivity.this.O1();
            } else if (i == 7) {
                MainActivity.this.H1();
            } else {
                if (i != 8) {
                    return;
                }
                MainActivity.this.j2();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ValueCallback<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12033a;

        public c(int i) {
            this.f12033a = i;
        }

        @Override // android.webkit.ValueCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            String string;
            ka3.b bVarE0 = MainActivity.this.L1().e0();
            if (TextUtils.isEmpty(str) || str.equalsIgnoreCase("NULL")) {
                MainActivity.this.l2(bVarE0, this.f12033a);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.put("shareType", this.f12033a);
                string = jSONObject.toString();
            } catch (JSONException e) {
                ma3.c(e);
                string = null;
            }
            if (!TextUtils.isEmpty(string)) {
                str = string;
            }
            MainActivity mainActivity = MainActivity.this;
            if (TextUtils.isEmpty(p75.h(bVarE0, str, mainActivity, mainActivity.N1()))) {
                return;
            }
            MainActivity.this.l2(bVarE0, this.f12033a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements n54.a<List<FetchPkgInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12035a;

        public e(String str) {
            this.f12035a = str;
        }

        @Override // defpackage.c5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(sm5<? super List<FetchPkgInfo>> sm5Var) {
            ArrayList arrayList = new ArrayList();
            FetchPkgInfo fetchPkgInfo = new FetchPkgInfo();
            fetchPkgInfo.setExtId(this.f12035a);
            String strD = b64.b().d(this.f12035a);
            if (TextUtils.isEmpty(strD)) {
                fetchPkgInfo.setVerCode(0);
            } else {
                fetchPkgInfo.setVerCode(Integer.valueOf(strD).intValue());
            }
            arrayList.add(fetchPkgInfo);
            sm5Var.onNext(arrayList);
            sm5Var.onCompleted();
        }
    }

    public final void H1() {
        moveTaskToBack(true);
        g2();
        f84.b(this.v, "float");
    }

    public final void I1() {
        J1();
        f84.b(this.v, "copy");
    }

    public final void J1() {
        ((ClipboardManager) getSystemService(DataType.CLIPBOARD)).setPrimaryClip(ClipData.newPlainText("fromSApp", L1().h0().loadedUrl));
        sy5.e(this, R.string.lx_open_api_clipboard_ok, 1).g();
    }

    public final void K1() {
        finishAndRemoveTask();
    }

    public final WebViewFragment L1() {
        return (WebViewFragment) this.q.findFragmentById(R.id.rl_webview_container);
    }

    public String M1() {
        return WebAppManager.TASK_WEBAPP0;
    }

    public wn6 N1() {
        return L1().k0();
    }

    public final void O1() {
        R1();
        f84.b(this.v, "feedback");
    }

    public final void P1() {
        moveTaskToBack(true);
        f84.b(this.v, OapsKey.KEY_GOBACK);
    }

    public final void Q1() {
        FloatMenu floatMenu = (FloatMenu) findViewById(R.id.rl_webapp_toolbar);
        this.r = floatMenu;
        floatMenu.setBlackStyle(true);
    }

    public final void R1() {
        Intent intent = new Intent(this, (Class<?>) CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", tj2.m());
        bundle.putBoolean("web_show_right_menu", false);
        bundle.putInt("BackgroundColor", -1);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public final void S1(Intent intent) {
        String string = intent.getExtras().getString("appId");
        tn1 tn1Var = new tn1();
        this.v = tn1Var;
        tn1Var.f18275a = string;
        WebViewFragment webViewFragment = new WebViewFragment();
        webViewFragment.setArguments(intent.getExtras());
        FragmentTransaction fragmentTransactionBeginTransaction = this.q.beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.rl_webview_container, webViewFragment, "homePage");
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        Z1(string);
    }

    public final void T1(Intent intent) {
        Bundle extras = intent.getExtras();
        String string = Uri.parse("zenxin://webapp").buildUpon().appendQueryParameter("url", extras.getString("url", "")).appendQueryParameter("appId", extras.getString("appId", "")).appendQueryParameter("scene", extras.getString("scene", "")).appendQueryParameter("windowStyle", extras.getString("windowStyle", "")).toString();
        K1();
        bu3.g().j(this, string);
    }

    public final void U1(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null || TextUtils.isEmpty(extras.getString("url"))) {
            sy5.e(this, R.string.lx_open_api_cannot_open, 1).g();
            return;
        }
        String string = extras.getString("appId");
        String string2 = extras.getString("fresh", ex.V);
        ka3.b bVarE0 = L1().e0();
        if (bVarE0 == null || !ex.V.equals(string2) || string == null || !string.equals(bVarE0.f21948a)) {
            if (h84.a()) {
                T1(intent);
                return;
            }
            c2(false);
            a46.B(getWindow(), false, Color.parseColor("#EFEFEF"));
            a2();
            S1(intent);
        }
    }

    public final void V1() {
        Y1();
        f84.b(this.v, com.alipay.sdk.m.x.d.w);
    }

    public void W1(Fragment fragment) {
        if (fragment != null) {
            an1.c().p(fragment);
        }
    }

    public final void X1() {
        registerReceiver(this.u, new IntentFilter("com.zenmen.openapi.ACTION_USER_LOGOUT"));
    }

    public final void Y1() {
        L1().y0();
    }

    public final void Z1(String str) {
        String strC = jo6.c("LX-31157", "A");
        if (WkAdxAdConfigMg.DSP_NAME_BAIDU.equalsIgnoreCase(strC) || WkAdxAdConfigMg.DSP_NAME_CSJ.equalsIgnoreCase(strC)) {
            n54.a(new e(str)).u(b35.c()).i(wc.a()).r(new d());
        }
    }

    public final void a2() {
        setTaskDescription(new ActivityManager.TaskDescription());
    }

    public final void b2(Bitmap bitmap) {
        ka3.b bVarE0 = L1().e0();
        if (bVarE0 == null || WebAppManager.APPID_WEBAPP_CENTER.equals(bVarE0.f21948a)) {
            return;
        }
        setTaskDescription(new ActivityManager.TaskDescription(bVarE0.b, bitmap, Color.parseColor("#00000000")));
    }

    public void c2(boolean z) {
        if (this.s == null) {
            vg vgVar = new vg((AppFloatIcon) findViewById(R.id.lx_webapp_float_menu_icon), (AppFloatMenuBox) findViewById(R.id.lx_webapp_float_menu_box));
            this.s = vgVar;
            vgVar.y(this);
        }
        if (z) {
            this.s.F(false);
        } else {
            this.s.t();
        }
    }

    public void d2(boolean z) {
        FloatMenu floatMenu = this.r;
        if (floatMenu == null) {
            return;
        }
        if (z) {
            floatMenu.setVisibility(0);
        } else {
            floatMenu.setVisibility(8);
        }
    }

    public void e2(boolean z) {
        if (z && !this.x) {
            setRequestedOrientation(0);
            this.x = true;
        } else {
            if (z || !this.x) {
                return;
            }
            setRequestedOrientation(1);
            this.x = false;
        }
    }

    public void f2(wn6 wn6Var) {
        if (this.r == null) {
            return;
        }
        boolean zF = wn6Var.f();
        boolean zEquals = wn6Var.a().equals("#000000");
        if (zF) {
            this.r.setVisibility(0);
            this.r.setBlackStyle(zEquals);
        } else {
            this.r.setVisibility(8);
            this.r.setBlackStyle(zEquals);
        }
        e2(wn6Var.e());
        c2(wn6Var.h());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.r.getLayoutParams();
        if (wn6Var.c().equals("fullscreen")) {
            layoutParams.topMargin = a46.b(this, 8.0f) + a46.n(this);
        } else {
            layoutParams.topMargin = a46.b(this, 8.0f);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        if (this.t && !r75.k() && AccountUtils.r(this)) {
            Intent intent = new Intent();
            intent.setClass(this, MainTabsActivity.class);
            k86.X(intent);
            startActivity(intent);
            this.t = false;
        }
        super.finish();
    }

    public final void g2() {
        ka3.b bVarE0 = L1().e0();
        if (bVarE0 == null) {
            WebAppManager.getInstance().setIdleAppInfo(null);
            sy5.e(this, R.string.lx_webapp_add_float_failed, 1).g();
            return;
        }
        fz4 fz4Var = new fz4();
        fz4Var.b("appId", bVarE0.f21948a);
        fz4Var.b("appIcon", bVarE0.c);
        fz4Var.b(WfConstant.EVENT_KEY_APP_NAME, bVarE0.b);
        fz4Var.b("linkUrl", p75.a("floatMenu", bVarE0.f21948a, L1().h0().loadedUrl, N1()));
        WebAppManager.getInstance().setIdleAppInfo(fz4Var);
    }

    public void h2() {
        getWindow().getDecorView().setSystemUiVisibility(1280);
        me1.k(getWindow(), 0);
    }

    public final void i2() {
        k2(0);
        f84.b(this.v, LogUtil.VALUE_SEND);
    }

    public final void j2() {
        k2(1);
        f84.b(this.v, "moment");
    }

    public final void k2(int i) {
        if (L1().e0() == null) {
            sy5.e(this, R.string.lx_open_api_cannot_share, 1).g();
        } else {
            L1().h0().evaluateJavascript("javascript:onShareAppMessage()", new c(i));
        }
    }

    public final void l2(ka3.b bVar, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("linkUrl", L1().h0().loadedUrl);
            jSONObject.put("subject", L1().h0().getTitle());
            jSONObject.put(LxAdDLManager.ITEM_DESC, L1().h0().loadedUrl);
            jSONObject.put(LxAdDLManager.ITEM_ICONURL, bVar.c);
            jSONObject.put("shareType", i);
            if (h84.b()) {
                jSONObject.put(LxAdDLManager.ITEM_ICONURL, aa3.a());
                jSONObject.put("authorIcon", bVar.c);
                jSONObject.put("authorName", bVar.b);
                p75.h(bVar, jSONObject.toString(), this, N1());
            } else {
                p75.g(bVar, jSONObject.toString(), this);
            }
        } catch (JSONException e2) {
            ma3.c(e2);
        }
    }

    public void m2() {
        jn3 jn3Var = new jn3(this, R.style.lx_pay_dialog_bottom_full);
        MenuDialogView menuDialogView = (MenuDialogView) getLayoutInflater().inflate(R.layout.dialog_webapp_menu_bottom, (ViewGroup) null);
        MenuDialogView.b bVar = new MenuDialogView.b();
        bVar.f12052a = L1().e0();
        menuDialogView.initView(bVar);
        jn3Var.c(menuDialogView, this.w);
        Window window = jn3Var.getWindow();
        window.setGravity(80);
        window.setWindowAnimations(R.style.lx_pay_botton_dialog_animation);
        window.setLayout(-1, -2);
        jn3Var.show();
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        if (this.t && !r75.k() && AccountUtils.r(this)) {
            Intent intent = new Intent();
            intent.setClass(this, MainTabsActivity.class);
            k86.X(intent);
            startActivity(intent);
            this.t = false;
        }
        return super.moveTaskToBack(z);
    }

    public void n2(Fragment fragment) {
        if (fragment != null) {
            an1.c().r(fragment);
        }
    }

    public final void o2() {
        try {
            unregisterReceiver(this.u);
        } catch (Exception e2) {
            ma3.c(e2);
        }
    }

    @Override // defpackage.e84
    public void onCallback(int i, String str, Object obj) {
        if (!isFinishing() && i == 1 && (obj instanceof Bitmap)) {
            b2((Bitmap) obj);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_webapp_btn_more) {
            m2();
            f84.b(this.v, ld.B);
        } else if (id == R.id.iv_webapp_btn_close) {
            f84.b(this.v, OapsKey.KEY_GOBACK);
            if (WebAppManager.TASK_MAIN.equals(M1())) {
                finish();
            } else {
                moveTaskToBack(true);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        vg vgVar = this.s;
        if (vgVar != null && vgVar.v()) {
            this.s.t();
            this.s.F(true);
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        getWindow().requestFeature(1);
        super.onCreate(bundle);
        this.t = getIntent().getBooleanExtra("back2MainTab", false);
        Bundle extras = getIntent().getExtras();
        if (extras == null || TextUtils.isEmpty(extras.getString("url"))) {
            sy5.e(this, R.string.lx_open_api_cannot_open, 1).g();
            finish();
            return;
        }
        a46.B(getWindow(), false, Color.parseColor("#EFEFEF"));
        setContentView(R.layout.activity_openapi_webapp);
        Q1();
        this.q = getSupportFragmentManager();
        CordovaWebViewClient.setJSSDKPath(com.zenmen.palmchat.webplatform.b.n().o(this));
        S1(getIntent());
        vt2.d(this, extras);
        X1();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        tn2 tn2Var;
        super.onDestroy();
        o2();
        if (this.v == null || (tn2Var = (tn2) g84.a(tn2.class)) == null || !tn2Var.isEnable()) {
            return;
        }
        tn2Var.a(this.v.f18275a);
    }

    @Override // defpackage.fa3
    public void onEvent(int i, Object obj) {
        if (i == 2) {
            O1();
        }
        if (i == 4) {
            H1();
        }
        if (i == 3) {
            P1();
        }
        if (i == 1) {
            i2();
        }
        if (i == 10) {
            f84.b(this.v, ld.B);
        }
        if (i == 5) {
            j2();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        U1(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (L1() != null) {
            L1().onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TextUtils.isEmpty(OAAccountUtils.getUid())) {
            sy5.e(this, R.string.lx_open_api_err_logout, 1).g();
            K1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements o54<List<FetchPkgInfo>> {
        public d() {
        }

        @Override // defpackage.o54
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<FetchPkgInfo> list) {
            x54.b().a(list);
        }

        @Override // defpackage.o54
        public void onError(Throwable th) {
        }

        @Override // defpackage.o54
        public void onCompleted() {
        }
    }
}
