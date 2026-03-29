package com.zenmen.palmchat.webplatform;

import android.R;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Picture;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.qq.gdt.action.ActionUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.ttvecamera.TECameraSettings;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.publish.PublishActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.webplatform.a;
import com.zenmen.palmchat.webplatform.miniPrograms.Package;
import defpackage.aj6;
import defpackage.ap3;
import defpackage.ds0;
import defpackage.ei0;
import defpackage.gr2;
import defpackage.hq3;
import defpackage.je1;
import defpackage.k86;
import defpackage.m5;
import defpackage.me1;
import defpackage.n5;
import defpackage.pp3;
import defpackage.qm5;
import defpackage.r75;
import defpackage.sy5;
import defpackage.uj6;
import defpackage.v4;
import defpackage.vi6;
import defpackage.yi1;
import defpackage.yy2;
import defpackage.zs1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.cordova.CordovaWebViewClient;
import org.apache.cordova.jssdk.RedPacketPullNewPlugin;
import org.apache.cordovaNew.CordovaActivity;
import org.apache.cordovaNew.CordovaPlugin;
import org.apache.cordovaNew.CordovaWebView;
import org.apache.cordovaNew.CordovaWebViewImpl;
import org.apache.cordovaNew.LOG;
import org.apache.cordovaNew.engine.SystemWebView;
import org.apache.cordovaNew.engine.SystemWebViewClient;
import org.apache.cordovaNew.engine.SystemWebViewEngine;
import org.apache.webplatform.jssdk.WebPlatformPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class WebModuleActivity extends CordovaActivity implements zs1.a {
    public static String F = "WebModuleActivity";
    public static String G = "MINIPROGRAMS";
    public static String H;
    public View B;
    public int C;
    public FrameLayout.LayoutParams E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f15883a;
    public boolean b;
    public Package c;
    public int d;
    public int e;
    public String i;
    public String k;
    public int l;
    public boolean m;
    public boolean n;
    public ViewGroup o;
    public View p;
    public View q;
    public View r;
    public ImageView s;
    public ImageView t;
    public PopupWindow u;
    public View v;
    public View w;
    public String x;
    public long y;
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;
    public boolean j = false;
    public boolean z = false;
    public BroadcastReceiver A = new g();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f15884a;
        public final /* synthetic */ long b;

        public a(long j, long j2) {
            this.f15884a = j;
            this.b = j2;
            put("action", "downMinAppORnot");
            put("startJudge_time", Long.valueOf(j));
            put("endJudge_time", Long.valueOf(j2));
            put("needDownload", Boolean.TRUE);
            put("appId", WebModuleActivity.this.c.pkgId);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {
        public b() {
            put("action", "downMinAppORnot");
            put("needDownload", Boolean.FALSE);
            put("appId", WebModuleActivity.this.c.pkgId);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements a.InterfaceC1135a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f15886a;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f15887a;

            public a(long j) {
                this.f15887a = j;
                put("action", "downMinAppORnot");
                put("startJudge_time", Long.valueOf(c.this.f15886a));
                put("endJudge_time", Long.valueOf(j));
                put("needDownload", Boolean.TRUE);
                put("appId", WebModuleActivity.this.c.pkgId);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {
            public b() {
                put("action", "downMinAppORnot");
                put("needDownload", Boolean.FALSE);
                put("appId", WebModuleActivity.this.c.pkgId);
            }
        }

        /* JADX INFO: renamed from: com.zenmen.palmchat.webplatform.WebModuleActivity$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC1133c implements Runnable {
            public RunnableC1133c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                WebModuleActivity.this.P();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class d extends HashMap<String, Object> {
            public d() {
                put("action", "downMinAppORnot");
                put("needDownload", Boolean.FALSE);
                put("appId", WebModuleActivity.this.c.pkgId);
            }
        }

        public c(long j) {
            this.f15886a = j;
        }

        @Override // com.zenmen.palmchat.webplatform.a.InterfaceC1135a
        public void a(JSONObject jSONObject, yy2 yy2Var) {
            JSONObject jSONObjectOptJSONObject;
            JSONArray jSONArrayOptJSONArray;
            if (jSONObject != null && jSONObject.optInt("resultCode", -1) == 0 && (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("pkgs")) != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                    String strOptString = jSONObjectOptJSONObject2.optString("appId");
                    if (WebModuleActivity.this.c.pkgId.equals(strOptString)) {
                        int iOptInt = jSONObjectOptJSONObject2.optInt("version", 0);
                        if (iOptInt <= WebModuleActivity.this.c.version) {
                            LogUtil.i(WebModuleActivity.F, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new b(), (Throwable) null);
                            WebModuleActivity webModuleActivity = WebModuleActivity.this;
                            webModuleActivity.Z(webModuleActivity.c.pkgId);
                            return;
                        }
                        Package r8 = new Package();
                        r8.pkgId = strOptString;
                        r8.version = iOptInt;
                        r8.icon = jSONObjectOptJSONObject2.optString("icon");
                        r8.md5 = jSONObjectOptJSONObject2.optString("md5");
                        r8.name = jSONObjectOptJSONObject2.optString("name");
                        r8.description = jSONObjectOptJSONObject2.optString("description");
                        LogUtil.i(WebModuleActivity.F, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new a(System.currentTimeMillis()), (Throwable) null);
                        WebModuleActivity.this.I(r8, true);
                        return;
                    }
                }
            }
            WebModuleActivity.this.runOnUiThread(new RunnableC1133c());
        }

        @Override // com.zenmen.palmchat.webplatform.a.InterfaceC1135a
        public void onFail(Exception exc) {
            LogUtil.i(WebModuleActivity.F, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new d(), (Throwable) null);
            WebModuleActivity webModuleActivity = WebModuleActivity.this;
            webModuleActivity.Z(webModuleActivity.c.pkgId);
            exc.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f15891a;
        public final /* synthetic */ Package b;
        public final /* synthetic */ boolean c;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f15892a;

            public a(long j) {
                this.f15892a = j;
                put("action", "downMinApp");
                put("startDownload_time", Long.valueOf(d.this.f15891a));
                put("endDownload_time", Long.valueOf(j));
                put(ActionUtils.IS_SUCCESS, Boolean.TRUE);
                put("appId", d.this.b.pkgId);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f15893a;

            public b(long j) {
                this.f15893a = j;
                put("action", "downMinApp");
                put("startDownload_time", Long.valueOf(d.this.f15891a));
                put("endDownload_time", Long.valueOf(j));
                put(ActionUtils.IS_SUCCESS, Boolean.FALSE);
                put("appId", d.this.b.pkgId);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                WebModuleActivity.this.P();
            }
        }

        public d(long j, Package r4, boolean z) {
            this.f15891a = j;
            this.b = r4;
            this.c = z;
        }

        @Override // com.zenmen.palmchat.webplatform.a.c
        public void onFail(Exception exc) {
            LogUtil.i(WebModuleActivity.F, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new b(System.currentTimeMillis()), (Throwable) null);
            exc.printStackTrace();
            WebModuleActivity.this.runOnUiThread(new c());
        }

        @Override // com.zenmen.palmchat.webplatform.a.c
        public void onSuccess(String str, int i) {
            LogUtil.i(WebModuleActivity.F, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new a(System.currentTimeMillis()), (Throwable) null);
            if (this.c) {
                com.zenmen.palmchat.webplatform.b.j(WebModuleActivity.this.c.pkgId, WebModuleActivity.this.c.version);
            }
            WebModuleActivity.this.Z(str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f15895a;
        public final /* synthetic */ String b;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f15896a;
            public final /* synthetic */ String b;

            public a(long j, String str) {
                this.f15896a = j;
                this.b = str;
                put("action", "downMinApp");
                put("startDownload_time", Long.valueOf(e.this.f15895a));
                put("endDownload_time", Long.valueOf(j));
                put(ActionUtils.IS_SUCCESS, Boolean.TRUE);
                put("appId", str);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f15897a;

            public b(long j) {
                this.f15897a = j;
                put("action", "downMinApp");
                put("status", "fail");
                put("startDownload_time", Long.valueOf(e.this.f15895a));
                put("endDownload_time", Long.valueOf(j));
                put(ActionUtils.IS_SUCCESS, Boolean.FALSE);
                put("appId", e.this.b);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                WebModuleActivity.this.P();
            }
        }

        public e(long j, String str) {
            this.f15895a = j;
            this.b = str;
        }

        @Override // com.zenmen.palmchat.webplatform.a.c
        public void onFail(Exception exc) {
            LogUtil.i(WebModuleActivity.F, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new b(System.currentTimeMillis()), (Throwable) null);
            exc.printStackTrace();
            WebModuleActivity.this.runOnUiThread(new c());
        }

        @Override // com.zenmen.palmchat.webplatform.a.c
        public void onSuccess(String str, int i) {
            LogUtil.i(WebModuleActivity.F, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new a(System.currentTimeMillis(), str), (Throwable) null);
            WebModuleActivity.this.Z(str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements a.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15899a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15900a;
            public final /* synthetic */ int b;
            public final /* synthetic */ String c;

            /* JADX INFO: renamed from: com.zenmen.palmchat.webplatform.WebModuleActivity$f$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C1134a extends HashMap<String, Object> {
                public C1134a() {
                    put("appid", WebModuleActivity.H);
                }
            }

            public a(String str, int i, String str2) {
                this.f15900a = str;
                this.b = i;
                this.c = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                int iOptInt;
                String str;
                WebModuleActivity.this.f15883a = com.zenmen.palmchat.webplatform.b.m(this.f15900a, this.b);
                if (TextUtils.isEmpty(WebModuleActivity.this.f15883a)) {
                    WebModuleActivity.this.P();
                    return;
                }
                if (!TextUtils.isEmpty(this.c)) {
                    try {
                        JSONObject jSONObject = new JSONObject(this.c);
                        iOptInt = jSONObject.optInt(TECameraSettings.SCENE_MODE_LANDSCAPE, 0);
                        try {
                            WebModuleActivity.this.h = jSONObject.optInt(RedPacketPullNewPlugin.ACTION_SCREENSHOT, 0) != 0;
                            WebModuleActivity.this.j = jSONObject.optBoolean("webgl", false);
                            WebModuleActivity.this.k = jSONObject.optString("background");
                        } catch (JSONException e) {
                            e = e;
                            e.printStackTrace();
                        }
                    } catch (JSONException e2) {
                        e = e2;
                        iOptInt = 0;
                    }
                    if (iOptInt > 0) {
                        WebModuleActivity.this.setRequestedOrientation(6);
                    }
                }
                com.zenmen.palmchat.webplatform.b.n().f(this.f15900a);
                com.zenmen.palmchat.webplatform.b.n().y(this.f15900a, v4.e(WebModuleActivity.this));
                WebModuleActivity.this.X(false);
                WebModuleActivity webModuleActivity = WebModuleActivity.this;
                if (TextUtils.isEmpty(webModuleActivity.i)) {
                    str = WebModuleActivity.this.f15883a;
                } else {
                    str = WebModuleActivity.this.f15883a + WebModuleActivity.this.i;
                }
                webModuleActivity.loadUrl(str);
                f fVar = f.this;
                WebModuleActivity.H = fVar.f15899a;
                WebModuleActivity webModuleActivity2 = WebModuleActivity.this;
                webModuleActivity2.updateCurrentPageInfo(webModuleActivity2, new C1134a());
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("appid", f.this.f15899a);
                    jSONObject2.put("from", WebModuleActivity.this.e);
                    LogUtil.uploadInfoImmediate("62", null, null, jSONObject2.toString());
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                WebModuleActivity.this.P();
            }
        }

        public f(String str) {
            this.f15899a = str;
        }

        @Override // com.zenmen.palmchat.webplatform.a.e
        public void a(String str, int i, String str2) {
            WebModuleActivity.this.runOnUiThread(new a(str, i, str2));
        }

        @Override // com.zenmen.palmchat.webplatform.a.e
        public void onFail(Exception exc) {
            exc.printStackTrace();
            WebModuleActivity.this.runOnUiThread(new b());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends BroadcastReceiver {
        public g() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.intent.action.PACKAGE_ADDED") || action.equals("android.intent.action.PACKAGE_REPLACED")) {
                String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                if (ApkDownloadManager.d().b(schemeSpecificPart)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("gameid", schemeSpecificPart);
                        LogUtil.uploadInfoImmediate("yx2", null, null, jSONObject.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements ViewTreeObserver.OnGlobalLayoutListener {
        public h() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            WebModuleActivity.this.Q();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends HashMap<String, Object> {
        public i() {
            put("appid", WebModuleActivity.H);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements View.OnLongClickListener {
        public k() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WebModuleActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((CordovaActivity) WebModuleActivity.this).appView != null) {
                if (WebModuleActivity.this.h) {
                    ((CordovaActivity) WebModuleActivity.this).appView.loadUrl("javascript:share();");
                    return;
                }
                Bitmap bitmapD = WebModuleActivity.this.D();
                if (bitmapD == null) {
                    sy5.f(WebModuleActivity.this, "截屏失败", 1).g();
                    return;
                }
                WebModuleActivity webModuleActivity = WebModuleActivity.this;
                webModuleActivity.x = webModuleActivity.T(bitmapD);
                if (WebModuleActivity.this.E()) {
                    WebModuleActivity.this.u.showAtLocation(view, 80, 0, WebModuleActivity.this.L());
                } else {
                    WebModuleActivity.this.u.showAtLocation(view, 80, 0, 0);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WebModuleActivity.this.u.dismiss();
            WebModuleActivity webModuleActivity = WebModuleActivity.this;
            pp3.a(webModuleActivity, webModuleActivity.c, null, null, WebModuleActivity.this.x);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WebModuleActivity.this.u.dismiss();
            if (TextUtils.isEmpty(WebModuleActivity.this.x)) {
                return;
            }
            WebModuleActivity.this.V();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WebModuleActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements View.OnClickListener {
        public q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WebModuleActivity.this.c != null) {
                WebModuleActivity.this.W(false);
                WebModuleActivity.this.X(true);
                WebModuleActivity.this.F();
            }
        }
    }

    public final void A() {
        View viewInflate = View.inflate(this, R$layout.layout_webview_error, null);
        this.q = viewInflate;
        viewInflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        View viewFindViewById = this.q.findViewById(R$id.toolbar);
        viewFindViewById.setPadding(0, me1.h(this), 0, 0);
        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
        layoutParams.height = me1.h(this) + me1.b(this, 48);
        viewFindViewById.setLayoutParams(layoutParams);
        this.q.findViewById(R$id.back).setOnClickListener(new p());
        this.q.findViewById(R$id.error_action).setOnClickListener(new q());
        this.q.setVisibility(8);
        this.o.addView(this.q);
    }

    public final void B() {
        View viewInflate = View.inflate(this, R$layout.layout_webview_loading, null);
        this.p = viewInflate;
        viewInflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        ImageView imageView = (ImageView) this.p.findViewById(R$id.iv_loading);
        TextView textView = (TextView) this.p.findViewById(R$id.tv_loading);
        Package r2 = this.c;
        if (r2 != null) {
            textView.setText(r2.name);
            je1.a aVarU = new je1.a().s(true).t(true).u(true);
            int i2 = R$drawable.media_pick_grid_item_background;
            gr2.j().h(k86.p(this.c.icon), imageView, aVarU.B(i2).A(i2).q(Bitmap.Config.RGB_565).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r());
        }
        this.o.addView(this.p);
    }

    public final void C() {
        this.r = View.inflate(this, R$layout.layout_webview_menu, null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(me1.b(this, 85), me1.b(this, 32));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.rightMargin = me1.b(this, 10);
        layoutParams.topMargin = me1.b(this, 10);
        this.r.setLayoutParams(layoutParams);
        this.o.addView(this.r);
        this.t = (ImageView) this.r.findViewById(R$id.mini_program_exit);
        this.s = (ImageView) this.r.findViewById(R$id.mini_program_more);
        this.t.setOnClickListener(new l());
        this.s.setOnClickListener(new m());
        if (this.g) {
            this.r.setVisibility(8);
        }
    }

    public final Bitmap D() {
        Picture pictureCapturePicture = ((SystemWebView) this.appView.getView()).capturePicture();
        int width = pictureCapturePicture.getWidth();
        int height = pictureCapturePicture.getHeight();
        if (width <= 0 || height <= 0) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        pictureCapturePicture.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    public boolean E() {
        return (ViewConfiguration.get(this).hasPermanentMenuKey() || KeyCharacterMap.deviceHasKey(4)) ? false : true;
    }

    public final void F() {
        boolean z;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Cursor cursorQuery = getContentResolver().query(hq3.f18029a, null, "web_id=?", new String[]{this.c.pkgId}, null);
        ContentValues contentValues = null;
        boolean z2 = false;
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("web_id"));
                int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("version"));
                if (com.zenmen.palmchat.webplatform.b.m(string, i2) == null) {
                    break;
                }
                if (contentValues == null) {
                    contentValues = new ContentValues();
                    contentValues.put("web_id", string);
                    contentValues.put("web_name", cursorQuery.getString(cursorQuery.getColumnIndex("web_name")));
                    contentValues.put("version", Integer.valueOf(i2));
                    contentValues.put("package_info", cursorQuery.getString(cursorQuery.getColumnIndex("package_info")));
                    contentValues.put("icon", cursorQuery.getString(cursorQuery.getColumnIndex("icon")));
                    contentValues.put("description", cursorQuery.getString(cursorQuery.getColumnIndex("description")));
                    contentValues.put(BaseConstants.EVENT_LABEL_EXTRA, cursorQuery.getString(cursorQuery.getColumnIndex(BaseConstants.EVENT_LABEL_EXTRA)));
                    Package r9 = this.c;
                    if (r9.version <= 0) {
                        r9.version = contentValues.getAsInteger("version").intValue();
                    }
                }
                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(DeviceInfoUtil.UID_TAG));
                if (string2 == null || !string2.equals(v4.e(this))) {
                    z2 = true;
                } else {
                    int i3 = this.d;
                    if (i3 == 1) {
                        G(jCurrentTimeMillis);
                    } else if (i3 == 3) {
                        Z(this.c.pkgId);
                    }
                    z2 = true;
                    z = true;
                    cursorQuery.close();
                }
            }
            z = false;
            cursorQuery.close();
        } else {
            z = false;
        }
        if (!z2) {
            LogUtil.i(F, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new a(jCurrentTimeMillis, System.currentTimeMillis()), (Throwable) null);
            Package r0 = this.c;
            if (r0.version > 0) {
                I(r0, false);
                return;
            } else {
                J(r0.pkgId);
                return;
            }
        }
        if (z) {
            return;
        }
        contentValues.put(DeviceInfoUtil.UID_TAG, v4.e(this));
        contentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        getContentResolver().insert(hq3.f18029a, contentValues);
        int i4 = this.d;
        if (i4 == 1) {
            G(jCurrentTimeMillis);
        } else if (i4 == 3) {
            Z(this.c.pkgId);
        }
    }

    public final void G(long j2) {
        if (com.zenmen.palmchat.webplatform.b.n().s(this.c.pkgId)) {
            LogUtil.i(F, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new b(), (Throwable) null);
            Z(this.c.pkgId);
            return;
        }
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", this.c.pkgId);
            jSONObject.put("version", this.c.version);
            jSONArray.put(jSONObject);
            com.zenmen.palmchat.webplatform.a.f(jSONArray, new c(j2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final int H() {
        Rect rect = new Rect();
        this.B.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public final void I(Package r8, boolean z) {
        com.zenmen.palmchat.webplatform.a.b(r8, new d(System.currentTimeMillis(), r8, z));
    }

    public final void J(String str) {
        com.zenmen.palmchat.webplatform.a.c(str, new e(System.currentTimeMillis(), str));
    }

    public Package K() {
        return this.c;
    }

    public int L() {
        boolean zHasPermanentMenuKey = ViewConfiguration.get(this).hasPermanentMenuKey();
        int identifier = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier <= 0 || zHasPermanentMenuKey) {
            return 0;
        }
        return getResources().getDimensionPixelSize(identifier);
    }

    public final void M() {
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.layout_pop_more, (ViewGroup) null);
        this.v = viewInflate.findViewById(R$id.share_to_friend);
        this.w = viewInflate.findViewById(R$id.share_to_moment);
        View viewFindViewById = viewInflate.findViewById(R$id.menu_sep);
        LogUtil.i(F, "isMomentEnable = " + N());
        if (N()) {
            this.w.setVisibility(0);
            viewFindViewById.setVisibility(0);
            this.u = new PopupWindow(viewInflate, -1, k86.e(this, 120.0f));
        } else {
            this.w.setVisibility(8);
            viewFindViewById.setVisibility(8);
            this.u = new PopupWindow(viewInflate, -1, k86.e(this, 63.0f));
        }
        this.u.setOutsideTouchable(true);
        this.u.setAnimationStyle(R$style.MyPopupWindow_anim_style);
        this.v.setOnClickListener(new n());
        this.w.setOnClickListener(new o());
    }

    public final boolean N() {
        return yi1.b();
    }

    public final void O() {
        if (getIntent().getExtras() != null) {
            this.f15883a = getIntent().getExtras().getString("web_url", null);
            this.c = (Package) getIntent().getExtras().getSerializable("extra_package");
            this.d = getIntent().getExtras().getInt("extra_type", 0);
            this.b = getIntent().getExtras().getBoolean("web_show_share", false);
            this.e = getIntent().getExtras().getInt("extra_from", -1);
            this.f = getIntent().getExtras().getBoolean("extra_landscape", false);
            this.g = getIntent().getExtras().getBoolean("extra_hide_menu", false);
            this.i = getIntent().getExtras().getString("extra_url_extension");
            this.l = getIntent().getExtras().getInt("extra_status_bar_color", 0);
            this.m = getIntent().getExtras().getBoolean("extra_use_light_status_bar", false);
            this.n = getIntent().getExtras().getBoolean(BaseActionBarActivity.EXTRA_KEY_NEED_BACK2MAINTAB, false);
            H = getIntent().getStringExtra("app_id");
            int i2 = this.d;
            if ((i2 == 1 || i2 == 3) && this.c != null) {
                F();
            } else {
                if (i2 != 2 || this.c == null) {
                    return;
                }
                G(System.currentTimeMillis());
            }
        }
    }

    public final void P() {
        if (this.d != 3 || this.c == null) {
            setResult(1000);
            finish();
        } else {
            X(false);
            W(true);
        }
    }

    public final void Q() {
        int iH = H();
        if (iH != this.C) {
            this.E.height = iH;
            this.B.requestLayout();
            this.C = iH;
        }
    }

    public void R() {
        View childAt = ((FrameLayout) findViewById(R.id.content)).getChildAt(0);
        this.B = childAt;
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new h());
        this.E = (FrameLayout.LayoutParams) this.B.getLayoutParams();
    }

    public final void S() {
        SystemWebView systemWebView = (SystemWebView) this.appView.getView();
        systemWebView.removeJavascriptInterface("accessibility");
        systemWebView.removeJavascriptInterface("accessibilityTraversal");
        systemWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        systemWebView.getSettings().setSavePassword(false);
    }

    public final String T(Bitmap bitmap) {
        File file = new File(getExternalCacheDir(), System.currentTimeMillis() + ".jpg");
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
                if (bitmap != null) {
                }
                return file.getAbsolutePath();
            }
            bitmap.recycle();
            return file.getAbsolutePath();
        } catch (Throwable th) {
            if (bitmap != null) {
                bitmap.recycle();
            }
            throw th;
        }
    }

    public void U(String str) {
        this.x = str;
        if (E()) {
            this.u.showAtLocation(this.s, 80, 0, L());
        } else {
            this.u.showAtLocation(this.s, 80, 0, 0);
        }
    }

    public final void V() {
        Intent intent = new Intent();
        intent.putExtra("key_from", 5);
        intent.putExtra("key_publish_type", 2);
        ArrayList arrayList = new ArrayList();
        MediaItem mediaItem = new MediaItem();
        mediaItem.fileFullPath = this.x;
        arrayList.add(mediaItem);
        intent.putExtra("key_publish_pictures", arrayList);
        intent.putExtra("key_extra_info", this.c.pkgId);
        intent.setClass(this, PublishActivity.class);
        startActivity(intent);
    }

    public final void W(boolean z) {
        LogUtil.i(F, "showErrorView isShow = " + z);
        if (z) {
            this.q.setVisibility(0);
            CordovaWebView cordovaWebView = this.appView;
            if (cordovaWebView != null) {
                cordovaWebView.getView().setVisibility(8);
                return;
            }
            return;
        }
        this.q.setVisibility(8);
        CordovaWebView cordovaWebView2 = this.appView;
        if (cordovaWebView2 != null) {
            cordovaWebView2.getView().setVisibility(0);
        }
    }

    public final void X(boolean z) {
        LogUtil.i(F, "showLoadingView isShow = " + z);
        if (z) {
            this.p.setVisibility(0);
            CordovaWebView cordovaWebView = this.appView;
            if (cordovaWebView != null) {
                cordovaWebView.getView().setVisibility(8);
                return;
            }
            return;
        }
        this.p.setVisibility(8);
        CordovaWebView cordovaWebView2 = this.appView;
        if (cordovaWebView2 != null) {
            cordovaWebView2.getView().setVisibility(0);
        }
    }

    public final void Y() {
        if (this.z) {
            return;
        }
        this.z = true;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            try {
                if (TextUtils.isEmpty(extras.getString("source_page_tag")) && !TextUtils.isEmpty(H)) {
                    extras.putString("source_page_tag", H);
                }
                if (TextUtils.isEmpty(extras.getString("source_tab_tag")) && "wseem".equals(extras.getString("source_page_tag"))) {
                    extras.putString("source_tab_tag", "tab_msg");
                }
                ap3.g(this, extras);
            } catch (Exception unused) {
            }
        }
    }

    public final void Z(String str) {
        com.zenmen.palmchat.webplatform.a.g(str, new f(str));
    }

    @Override // org.apache.cordovaNew.CordovaActivity
    public void createViews() {
        LogUtil.d(F, "createViews()");
        z();
        this.r.bringToFront();
        SystemWebView systemWebView = (SystemWebView) this.appView.getView();
        if (!this.j && !TextUtils.isEmpty(this.k)) {
            systemWebView.setLayerType(1, null);
            try {
                systemWebView.setBackgroundColor(Color.parseColor(this.k));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        S();
        systemWebView.getSettings().setUserAgentString(ei0.a(systemWebView, "lx-inner-webapp"));
        systemWebView.setWebViewClient(new j((SystemWebViewEngine) this.appView.getEngine()));
        systemWebView.setLongClickable(true);
        systemWebView.setHapticFeedbackEnabled(false);
        systemWebView.setOnLongClickListener(new k());
    }

    @Override // android.app.Activity
    public void finish() {
        if (!r75.k()) {
            if (!this.n) {
                FrameworkBaseActivity.g.b(this);
            } else if (!TextUtils.isEmpty(v4.e(this))) {
                startActivity(n5.b(this, null));
            }
        }
        super.finish();
    }

    @Override // zs1.a
    public String formatStackForLog() {
        return null;
    }

    @Override // zs1.a
    public int getPageId() {
        return 301;
    }

    @Override // org.apache.cordovaNew.CordovaActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        O();
        m5.c(this, bundle);
        super.onCreate(bundle);
        LogUtil.d(F, "onCreate()");
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.o = relativeLayout;
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 0.0f));
        this.o.setBackgroundColor(-1);
        getWindow().setBackgroundDrawableResource(R$color.white);
        Package r4 = this.c;
        if (r4 != null && "task".equals(r4.pkgId)) {
            vi6.c().d(this);
        }
        setContentView(this.o);
        if (this.l != 0) {
            me1.m(getWindow(), this.l, true, this.m);
        }
        B();
        A();
        C();
        int i2 = this.d;
        if ((i2 == 1 || i2 == 2 || i2 == 3) && this.c != null) {
            X(true);
        } else {
            X(false);
        }
        if (this.u == null) {
            M();
        }
        if (this.f) {
            setRequestedOrientation(6);
        }
        ds0.a().c(this);
        if (!TextUtils.isEmpty(this.f15883a) && this.c == null) {
            if (!TextUtils.isEmpty(H)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("appid", H);
                    LogUtil.uploadInfoImmediate("62", null, null, jSONObject.toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(this.i)) {
                str = this.f15883a;
            } else {
                str = this.f15883a + this.i;
            }
            super.loadUrl(str);
        }
        updateCurrentPageInfo(this, new i());
        R();
    }

    @Override // org.apache.cordovaNew.CordovaActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Package r0 = this.c;
        if (r0 != null && !TextUtils.isEmpty(r0.pkgId)) {
            com.zenmen.palmchat.webplatform.b.n().g(new String[]{this.c.pkgId});
        }
        ds0.a().d(this);
        Package r02 = this.c;
        if (r02 != null && "task".equals(r02.pkgId)) {
            vi6.c().a(this);
        }
        if (!TextUtils.isEmpty(H)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appid", H);
                LogUtil.uploadInfoImmediate("622", null, null, jSONObject.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        H = null;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        CordovaPlugin plugin;
        CordovaWebView cordovaWebView = this.appView;
        if (cordovaWebView == null || i2 != 4 || (plugin = cordovaWebView.getPluginManager().getPlugin("webPlatform")) == null || !((WebPlatformPlugin) plugin).overrideBackButton()) {
            return super.onKeyUp(i2, keyEvent);
        }
        ((CordovaWebViewImpl) this.appView).callJavascriptEventCallback("backbutton");
        return true;
    }

    @Override // org.apache.cordovaNew.CordovaActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // org.apache.cordovaNew.CordovaActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @qm5
    public void receivedWebModuleEvent(aj6 aj6Var) {
        CordovaWebView cordovaWebView = this.appView;
        if (cordovaWebView == null || !(cordovaWebView instanceof CordovaWebViewImpl)) {
            return;
        }
        ((CordovaWebViewImpl) cordovaWebView).callJavascriptEventCallback(aj6Var.b(), aj6Var.a());
    }

    @Override // zs1.a
    public void updateCurrentPageInfo(Activity activity, HashMap map) {
        zs1.d(this, map);
    }

    public final void z() {
        LogUtil.i(F, "addAppView");
        this.appView.getView().setId(R$id.web_module_view);
        this.appView.getView().setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        ViewParent parent = this.appView.getView().getParent();
        if (parent != null && parent != this.o) {
            LOG.d(F, "removing appView from existing parent");
            ((ViewGroup) parent).removeView(this.appView.getView());
        }
        this.appView.getView().setDrawingCacheEnabled(true);
        this.appView.getView().setLayerType(2, null);
        this.o.addView(this.appView.getView());
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j extends SystemWebViewClient {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("action", "loadMinApp");
                put("startLoad_time", Long.valueOf(WebModuleActivity.this.y));
                put("endLoad_time", Long.valueOf(System.currentTimeMillis()));
                put(ActionUtils.IS_SUCCESS, Boolean.TRUE);
                put("appId", WebModuleActivity.this.c != null ? WebModuleActivity.this.c.pkgId : WebModuleActivity.H);
            }
        }

        public j(SystemWebViewEngine systemWebViewEngine) {
            super(systemWebViewEngine);
        }

        @Override // org.apache.cordovaNew.engine.SystemWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            LogUtil.i(WebModuleActivity.F, "onPageFinished");
            LogUtil.i(WebModuleActivity.F, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new a(), (Throwable) null);
            super.onPageFinished(webView, str);
            WebModuleActivity.this.Y();
        }

        @Override // org.apache.cordovaNew.engine.SystemWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            WebModuleActivity.this.y = System.currentTimeMillis();
            LogUtil.i(WebModuleActivity.F, "onPageStarted");
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // org.apache.cordovaNew.engine.SystemWebViewClient, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            LogUtil.i(WebModuleActivity.F, "shouldInterceptRequest" + str);
            if (str.contains(CordovaWebViewClient.ZX_LOCAL_RES)) {
                String str2 = com.zenmen.palmchat.webplatform.b.n().p(WebModuleActivity.this) + File.separator + str.substring(str.indexOf(CordovaWebViewClient.ZX_LOCAL_RES) + 14);
                try {
                    LogUtil.i(WebModuleActivity.F, "shouldInterceptRequest, filePath = " + str2);
                    return new WebResourceResponse("application/javascript", "UTF-8", new FileInputStream(str2));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    LogUtil.log4ClientError("shouldInterceptRequest_webplatform", null, e, true);
                }
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // android.webkit.WebViewClient
        @Nullable
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            LogUtil.i(WebModuleActivity.F, "shouldInterceptRequest2 " + webResourceRequest.getUrl());
            try {
                WebResourceResponse webResourceResponseB = new uj6().b(webView, webResourceRequest);
                if (webResourceResponseB != null) {
                    LogUtil.i(WebModuleActivity.F, "shouldInterceptRequest2 " + webResourceRequest.getUrl() + "result=" + webResourceResponseB);
                    return webResourceResponseB;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }
}
