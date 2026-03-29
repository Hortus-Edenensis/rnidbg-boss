package com.amap.api.col.p0002sl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.autonavi.amap.mapcore2d.Inner_3dMap_location;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationOption;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.igexin.push.core.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class mz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f3022a;
    private nf e;
    private ne f;
    private nh h;
    private ConnectivityManager i;
    private nj j;
    private Inner_3dMap_locationOption l;
    private a g = null;
    boolean b = false;
    private StringBuilder k = new StringBuilder();
    String c = null;
    private mx m = null;
    long d = 0;
    private final String n = "\"status\":\"0\"";
    private final String o = "</body></html>";

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (context == null || intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                    if (mz.this.e != null) {
                        mz.this.e.c();
                    }
                } else {
                    if (!action.equals("android.net.wifi.WIFI_STATE_CHANGED") || mz.this.e == null) {
                        return;
                    }
                    mz.this.e.d();
                }
            } catch (Throwable th) {
                nl.a(th, "MapNetLocation", "onReceive");
            }
        }

        public /* synthetic */ a(mz mzVar, byte b) {
            this();
        }
    }

    public mz(Context context) {
        this.f3022a = null;
        this.e = null;
        this.f = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.l = null;
        try {
            Context applicationContext = context.getApplicationContext();
            this.f3022a = applicationContext;
            np.b(applicationContext);
            a(this.f3022a);
            this.l = new Inner_3dMap_locationOption();
            if (this.e == null) {
                nf nfVar = new nf(this.f3022a, (WifiManager) np.a(this.f3022a, "wifi"));
                this.e = nfVar;
                nfVar.a(this.b);
            }
            if (this.f == null) {
                this.f = new ne(this.f3022a);
            }
            if (this.h == null) {
                this.h = nh.a(this.f3022a);
            }
            if (this.i == null) {
                this.i = (ConnectivityManager) np.a(this.f3022a, "connectivity");
            }
            this.j = new nj();
            c();
        } catch (Throwable th) {
            nl.a(th, "MapNetLocation", "<init>");
        }
    }

    private static mx a(mx mxVar) {
        return mt.a().a(mxVar);
    }

    private void c() {
        try {
            byte b = 0;
            if (this.g == null) {
                this.g = new a(this, b);
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
            this.f3022a.registerReceiver(this.g, intentFilter);
            this.e.b(false);
            this.f.f();
        } catch (Throwable th) {
            nl.a(th, "MapNetLocation", "initBroadcastListener");
        }
    }

    private mx d() throws Exception {
        byte[] bArr;
        String str;
        StringBuilder sb;
        String str2;
        mx mxVar = new mx("");
        nf nfVar = this.e;
        if (nfVar != null && nfVar.g()) {
            mxVar.setErrorCode(15);
            return mxVar;
        }
        try {
            if (this.j == null) {
                this.j = new nj();
            }
            this.j.a(this.f3022a, this.l.isNeedAddress(), this.l.isOffset(), this.f, this.e, this.i, this.c);
            na naVar = new na();
            try {
                try {
                    ie ieVarA = this.h.a(this.h.a(this.f3022a, this.j.a(), nl.a()));
                    if (ieVarA != null) {
                        bArr = ieVarA.f2902a;
                        str = ieVarA.c;
                    } else {
                        bArr = null;
                        str = "";
                    }
                    if (bArr == null || bArr.length == 0) {
                        mxVar.setErrorCode(4);
                        this.k.append("please check the network");
                        if (!TextUtils.isEmpty(str)) {
                            this.k.append(" #csid:".concat(String.valueOf(str)));
                        }
                        mxVar.setLocationDetail(this.k.toString());
                        return mxVar;
                    }
                    String str3 = new String(bArr, "UTF-8");
                    if (str3.contains("\"status\":\"0\"")) {
                        return naVar.a(str3, this.f3022a, ieVarA);
                    }
                    if (str3.contains("</body></html>")) {
                        mxVar.setErrorCode(5);
                        nf nfVar2 = this.e;
                        if (nfVar2 == null || !nfVar2.a(this.i)) {
                            sb = this.k;
                            str2 = "request may be intercepted";
                        } else {
                            sb = this.k;
                            str2 = "make sure you are logged in to the network";
                        }
                        sb.append(str2);
                        if (!TextUtils.isEmpty(str)) {
                            this.k.append(" #csid:".concat(String.valueOf(str)));
                        }
                        mxVar.setLocationDetail(this.k.toString());
                        return mxVar;
                    }
                    byte[] bArrA = ng.a(bArr);
                    if (bArrA == null) {
                        mxVar.setErrorCode(5);
                        this.k.append("decrypt response data error");
                        if (!TextUtils.isEmpty(str)) {
                            this.k.append(" #csid:".concat(String.valueOf(str)));
                        }
                        mxVar.setLocationDetail(this.k.toString());
                        return mxVar;
                    }
                    mx mxVarA = naVar.a(bArrA);
                    this.c = mxVarA.a();
                    if (mxVarA.getErrorCode() != 0) {
                        if (!TextUtils.isEmpty(str)) {
                            mxVarA.setLocationDetail(mxVarA.getLocationDetail() + " #csid:" + str);
                        }
                        return mxVarA;
                    }
                    if (!nb.a(mxVarA)) {
                        String strB = mxVarA.b();
                        mxVarA.setErrorCode(6);
                        StringBuilder sb2 = this.k;
                        StringBuilder sb3 = new StringBuilder("location faile retype:");
                        sb3.append(mxVarA.d());
                        sb3.append(" rdesc:");
                        if (strB == null) {
                            strB = b.m;
                        }
                        sb3.append(strB);
                        sb2.append(sb3.toString());
                        if (!TextUtils.isEmpty(str)) {
                            this.k.append(" #csid:".concat(String.valueOf(str)));
                        }
                        mxVarA.setLocationDetail(this.k.toString());
                        return mxVarA;
                    }
                    mxVarA.e();
                    if (mxVarA.getErrorCode() == 0 && mxVarA.getLocationType() == 0) {
                        if ("-5".equals(mxVarA.d()) || "1".equals(mxVarA.d()) || "2".equals(mxVarA.d()) || BaseWrapper.ENTER_ID_AD_SDK.equals(mxVarA.d()) || "24".equals(mxVarA.d()) || "-1".equals(mxVarA.d())) {
                            mxVarA.setLocationType(5);
                        } else {
                            mxVarA.setLocationType(6);
                        }
                        this.k.append(mxVarA.d());
                        if (!TextUtils.isEmpty(str)) {
                            this.k.append(" #csid:".concat(String.valueOf(str)));
                        }
                        mxVarA.setLocationDetail(this.k.toString());
                    }
                    return mxVarA;
                } catch (Throwable th) {
                    nl.a(th, "MapNetLocation", "getApsLoc req");
                    mxVar.setErrorCode(4);
                    this.k.append("please check the network");
                    mxVar.setLocationDetail(this.k.toString());
                    return mxVar;
                }
            } catch (Throwable th2) {
                nl.a(th2, "MapNetLocation", "getApsLoc buildV4Dot2");
                mxVar.setErrorCode(3);
                this.k.append("buildV4Dot2 error " + th2.getMessage());
                mxVar.setLocationDetail(this.k.toString());
                return mxVar;
            }
        } catch (Throwable th3) {
            nl.a(th3, "MapNetLocation", "getApsLoc");
            this.k.append("get parames error:" + th3.getMessage());
            mxVar.setErrorCode(3);
            mxVar.setLocationDetail(this.k.toString());
            return mxVar;
        }
    }

    public final void b() {
        a aVar;
        this.b = false;
        this.c = null;
        try {
            Context context = this.f3022a;
            if (context != null && (aVar = this.g) != null) {
                context.unregisterReceiver(aVar);
            }
            ne neVar = this.f;
            if (neVar != null) {
                neVar.g();
            }
            nf nfVar = this.e;
            if (nfVar != null) {
                nfVar.h();
            }
            this.g = null;
        } catch (Throwable unused) {
            this.g = null;
        }
    }

    public final Inner_3dMap_location a() {
        if (this.k.length() > 0) {
            StringBuilder sb = this.k;
            sb.delete(0, sb.length());
        }
        if (a(this.d) && nb.a(this.m)) {
            return this.m;
        }
        this.d = np.b();
        if (this.f3022a == null) {
            this.k.append("context is null");
            Inner_3dMap_location inner_3dMap_location = new Inner_3dMap_location("");
            inner_3dMap_location.setErrorCode(1);
            inner_3dMap_location.setLocationDetail(this.k.toString());
            return inner_3dMap_location;
        }
        try {
            this.f.f();
        } catch (Throwable th) {
            nl.a(th, "MapNetLocation", "getLocation getCgiListParam");
        }
        try {
            this.e.b(true);
        } catch (Throwable th2) {
            nl.a(th2, "MapNetLocation", "getLocation getScanResultsParam");
        }
        try {
            mx mxVarD = d();
            this.m = mxVarD;
            this.m = a(mxVarD);
        } catch (Throwable th3) {
            nl.a(th3, "MapNetLocation", "getLocation getScanResultsParam");
        }
        return this.m;
    }

    private void a(Context context) {
        try {
            if (context.checkCallingOrSelfPermission(ge.c("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) == 0) {
                this.b = true;
            }
        } catch (Throwable unused) {
        }
    }

    public final void a(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        this.l = inner_3dMap_locationOption;
        if (inner_3dMap_locationOption == null) {
            this.l = new Inner_3dMap_locationOption();
        }
        try {
            nf nfVar = this.e;
            this.l.isWifiActiveScan();
            nfVar.c(this.l.isWifiScan());
        } catch (Throwable unused) {
        }
        try {
            this.h.a(this.l.getHttpTimeOut(), this.l.getLocationProtocol().equals(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationProtocol.HTTPS));
        } catch (Throwable unused2) {
        }
    }

    private boolean a(long j) {
        if (np.b() - j < 800) {
            if ((nb.a(this.m) ? np.a() - this.m.getTime() : 0L) <= 10000) {
                return true;
            }
        }
        return false;
    }
}
