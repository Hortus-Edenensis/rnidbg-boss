package com.amap.api.col.p0002sl;

import android.app.Application;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.AMapLocationQualityReport;
import com.amap.api.location.APSService;
import com.amap.api.location.UmidtokenInfo;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class d {
    private static boolean J = true;
    private static boolean L = false;
    private static AtomicBoolean N = new AtomicBoolean(false);
    public static volatile boolean g = false;
    private Context E;
    private g G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    lh f2685a;
    public c c;
    j l;
    Intent o;
    AMapLocationClientOption b = new AMapLocationClientOption();
    h d = null;
    private k F = null;
    private boolean H = false;
    private volatile boolean I = false;
    ArrayList<AMapLocationListener> e = new ArrayList<>();
    boolean f = false;
    public boolean h = true;
    public boolean i = true;
    public boolean j = true;
    public boolean k = true;
    Messenger m = null;
    Messenger n = null;
    int p = 0;
    private boolean K = true;
    b q = null;
    boolean r = false;
    AMapLocationClientOption.AMapLocationMode s = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
    Object t = new Object();
    mk u = null;
    boolean v = false;
    e w = null;
    private boolean M = false;
    private AMapLocationClientOption O = new AMapLocationClientOption();
    private i P = null;
    String x = null;
    private ServiceConnection Q = new ServiceConnection() { // from class: com.amap.api.col.2sl.d.2
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                d.this.m = new Messenger(iBinder);
                d.this.H = true;
                d.this.v = true;
            } catch (Throwable th) {
                me.a(th, "ALManager", "onServiceConnected");
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            d dVar = d.this;
            dVar.m = null;
            dVar.H = false;
        }
    };
    AMapLocationQualityReport y = null;
    boolean z = false;
    boolean A = false;
    private volatile boolean R = false;
    a B = null;
    String C = null;
    boolean D = false;

    /* JADX INFO: renamed from: com.amap.api.col.2sl.d$3, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2688a;

        static {
            int[] iArr = new int[AMapLocationClientOption.AMapLocationMode.values().length];
            f2688a = iArr;
            try {
                iArr[AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2688a[AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2688a[AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0 */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v8 */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            ?? r0 = 0;
            try {
                super.handleMessage(message);
                if (md.h) {
                    Log.e("AMapLocationClient", "SERVICE_NOT_AVAILABLE");
                }
                int i = message.what;
                if (i == 11) {
                    d.this.a(message.getData());
                    return;
                }
                if (i == 12) {
                    d.this.b(message);
                    return;
                }
                if (i == 16) {
                    d.this.c(message);
                    return;
                }
                if (i == 1011) {
                    d.this.a(14, (Bundle) null);
                    d.this.g();
                    return;
                }
                try {
                    switch (i) {
                        case 1002:
                            d.this.c((AMapLocationListener) message.obj);
                            break;
                        case 1003:
                            d.this.j();
                            d.this.a(13, (Bundle) null);
                            break;
                        case 1004:
                            d.this.l();
                            d.this.a(14, (Bundle) null);
                            break;
                        case 1005:
                            d.this.d((AMapLocationListener) message.obj);
                            break;
                        default:
                            switch (i) {
                                case 1014:
                                    d.this.a(message);
                                    break;
                                case 1015:
                                    d dVar = d.this;
                                    dVar.d.a(dVar.b);
                                    d.this.a(1025, (Object) null, 300000L);
                                    break;
                                case 1016:
                                    if (mm.m(d.this.E)) {
                                        mg.a();
                                        d.this.r();
                                    } else if (!d.this.d.b()) {
                                        d.this.n();
                                    } else {
                                        d.this.a(1016, (Object) null, 1000L);
                                    }
                                    break;
                                case 1017:
                                    d.this.d.a();
                                    d.this.a(1025);
                                    break;
                                case 1018:
                                    d dVar2 = d.this;
                                    AMapLocationClientOption aMapLocationClientOption = (AMapLocationClientOption) message.obj;
                                    dVar2.b = aMapLocationClientOption;
                                    if (aMapLocationClientOption != null) {
                                        dVar2.s();
                                    }
                                    break;
                                default:
                                    switch (i) {
                                        case 1023:
                                            d.this.d(message);
                                            break;
                                        case 1024:
                                            d.this.e(message);
                                            break;
                                        case 1025:
                                            if (d.this.d.f()) {
                                                d.this.d.a();
                                                d dVar3 = d.this;
                                                dVar3.d.a(dVar3.b);
                                            }
                                            d.this.a(1025, (Object) null, 300000L);
                                            break;
                                        case 1026:
                                            mg.b();
                                            d.this.G.a(d.this.b);
                                            break;
                                        case 1027:
                                            d.this.G.a();
                                            break;
                                        case 1028:
                                            d.this.g((AMapLocation) message.obj);
                                            break;
                                        case 1029:
                                            Bundle bundle = new Bundle();
                                            bundle.putString("objHash", Integer.toString(System.identityHashCode(this)));
                                            d.this.a(16, bundle);
                                            break;
                                        case 1030:
                                            Bundle bundle2 = new Bundle();
                                            bundle2.putString("objHash", Integer.toString(System.identityHashCode(this)));
                                            d.this.a(17, bundle2);
                                            break;
                                        case 1031:
                                            if (d.this.b.isSysNetworkLocEnable()) {
                                                d.this.F.a(d.this.b);
                                                d.this.a(1033, (Object) null, 300000L);
                                            }
                                            break;
                                        case 1032:
                                            d.this.F.a();
                                            d.this.a(1033);
                                            break;
                                        case 1033:
                                            if (d.this.F.b()) {
                                                d.this.F.a();
                                                d.this.F.a(d.this.b);
                                            }
                                            d.this.a(1033, (Object) null, 300000L);
                                            break;
                                        case 1034:
                                            Bundle data = message.getData();
                                            AMapLocation aMapLocation = (AMapLocation) data.getParcelable("mapLoc");
                                            lb lbVar = (lb) data.getParcelable("entity");
                                            data.getSerializable("ex");
                                            d.this.a(aMapLocation, lbVar);
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                } catch (Throwable th) {
                    r0 = message;
                    th = th;
                    if (r0 == 0) {
                        r0 = "handleMessage";
                    }
                    me.a(th, "AMapLocationManage$MHandlerr", r0);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        d f2690a;

        public b(String str, d dVar) {
            super(str);
            this.f2690a = dVar;
        }

        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            try {
                this.f2690a.l.a();
                mj.a(this.f2690a.E);
                this.f2690a.p();
                d dVar = this.f2690a;
                if (dVar != null && dVar.E != null) {
                    md.b(this.f2690a.E);
                    md.a(this.f2690a.E);
                }
                super.onLooperPrepared();
            } catch (Throwable unused) {
            }
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    public d(Context context, Intent intent, Looper looper) {
        this.o = null;
        this.E = context;
        this.o = intent;
        b(looper);
    }

    private void k() {
        AMapLocation aMapLocation = new AMapLocation("");
        aMapLocation.setErrorCode(12);
        aMapLocation.setLocationDetail("定位权限被禁用,请授予应用定位权限 #1201");
        if (this.y == null) {
            this.y = new AMapLocationQualityReport();
        }
        AMapLocationQualityReport aMapLocationQualityReport = new AMapLocationQualityReport();
        this.y = aMapLocationQualityReport;
        aMapLocationQualityReport.setGpsStatus(4);
        this.y.setGPSSatellites(0);
        this.y.setLocationMode(this.b.getLocationMode());
        this.y.setWifiAble(mm.g(this.E));
        this.y.setNetworkType(mm.h(this.E));
        this.y.setNetUseTime(0L);
        aMapLocation.setLocationQualityReport(this.y);
        mk.a((String) null, 2121);
        d(aMapLocation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            mg.c();
            a(1025);
            a(1033);
            h hVar = this.d;
            if (hVar != null) {
                hVar.a();
            }
            k kVar = this.F;
            if (kVar != null) {
                kVar.a();
            }
            g gVar = this.G;
            if (gVar != null) {
                gVar.a();
            }
            a(1016);
            a(1030, (Object) null, 0L);
            this.I = false;
            this.p = 0;
        } catch (Throwable th) {
            me.a(th, "ALManager", "stopLocation");
        }
    }

    private void m() {
        lh lhVarB = b(new lc(true));
        if (i()) {
            Bundle bundle = new Bundle();
            String str = (lhVarB == null || !(lhVarB.getLocationType() == 2 || lhVarB.getLocationType() == 4)) ? "0" : "1";
            bundle.putBundle("optBundle", me.a(this.b));
            bundle.putString("isCacheLoc", str);
            a(0, bundle);
            if (this.I) {
                a(13, (Bundle) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        try {
            if (J || !(this.v || this.R)) {
                J = false;
                this.R = true;
                m();
            } else {
                try {
                    if (this.v && !a() && !this.A) {
                        this.A = true;
                        p();
                    }
                } catch (Throwable th) {
                    this.A = true;
                    me.a(th, "ALManager", "doLBSLocation reStartService");
                }
                if (i()) {
                    this.A = false;
                    Bundle bundle = new Bundle();
                    bundle.putBundle("optBundle", me.a(this.b));
                    bundle.putString("d", UmidtokenInfo.getUmidtoken());
                    if (!this.d.b()) {
                        a(1, bundle);
                    }
                }
            }
        } catch (Throwable th2) {
            try {
                me.a(th2, "ALManager", "doLBSLocation");
                try {
                    if (this.b.isOnceLocation()) {
                        return;
                    }
                    o();
                } catch (Throwable unused) {
                }
            } finally {
                try {
                    if (!this.b.isOnceLocation()) {
                        o();
                    }
                } catch (Throwable unused2) {
                }
            }
        }
    }

    private void o() {
        if (this.b.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
            a(1016, (Object) null, this.b.getInterval() >= 1000 ? this.b.getInterval() : 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        try {
            if (this.n == null) {
                this.n = new Messenger(this.c);
            }
            a(q());
        } catch (Throwable unused) {
        }
    }

    private Intent q() {
        String apikey;
        if (this.o == null) {
            this.o = new Intent(this.E, (Class<?>) APSService.class);
        }
        try {
            apikey = !TextUtils.isEmpty(AMapLocationClientOption.getAPIKEY()) ? AMapLocationClientOption.getAPIKEY() : fr.f(this.E);
        } catch (Throwable th) {
            me.a(th, "ALManager", "startServiceImpl p2");
            apikey = "";
        }
        this.o.putExtra("a", apikey);
        this.o.putExtra(t.l, fr.c(this.E));
        this.o.putExtra("d", UmidtokenInfo.getUmidtoken());
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        try {
            StringBuilder sb = new StringBuilder();
            new lb().f("#2001");
            sb.append("模糊权限下不支持低功耗定位#2001");
            mk.a((String) null, 2153);
            lh lhVar = new lh("");
            lhVar.setErrorCode(20);
            lhVar.setLocationDetail(sb.toString());
            g(lhVar);
        } catch (Throwable th) {
            me.a(th, "ALManager", "apsLocation:callback");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.d.b(this.b);
        this.G.b(this.b);
        if (this.I && !this.b.getLocationMode().equals(this.s)) {
            l();
            j();
        }
        this.s = this.b.getLocationMode();
        if (this.u != null) {
            if (this.b.isOnceLocation()) {
                this.u.a(this.E, 0);
            } else {
                this.u.a(this.E, 1);
            }
            this.u.a(this.E, this.b);
        }
    }

    private boolean t() {
        int iB;
        if (mm.j(this.E)) {
            try {
                iB = mi.b(((Application) this.E.getApplicationContext()).getBaseContext(), "checkSelfPermission", "android.permission.FOREGROUND_SERVICE");
            } catch (Throwable unused) {
                iB = -1;
            }
            if (iB != 0) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            c cVar;
            c cVar2;
            try {
                super.handleMessage(message);
                d dVar = d.this;
                if (dVar.r) {
                    return;
                }
                int i = message.what;
                if (i == 1) {
                    Message messageObtainMessage = dVar.B.obtainMessage();
                    messageObtainMessage.what = 11;
                    messageObtainMessage.setData(message.getData());
                    d.this.B.sendMessage(messageObtainMessage);
                    return;
                }
                if (i != 2) {
                    if (i != 17) {
                        if (i == 18) {
                            Bundle data = message.getData();
                            if (d.this.F != null) {
                                d.this.F.a(data);
                                return;
                            }
                            return;
                        }
                        switch (i) {
                            case 5:
                                Bundle data2 = message.getData();
                                data2.putBundle("optBundle", me.a(d.this.b));
                                d.this.a(10, data2);
                                break;
                            case 6:
                                Bundle data3 = message.getData();
                                h hVar = d.this.d;
                                if (hVar != null) {
                                    hVar.a(data3);
                                }
                                break;
                            case 7:
                                d.this.K = message.getData().getBoolean("ngpsAble");
                                break;
                            case 8:
                                mk.a((String) null, 2141);
                                break;
                            case 9:
                                boolean unused = d.L = message.getData().getBoolean("installMockApp");
                                break;
                            case 10:
                                dVar.a((AMapLocation) message.obj);
                                break;
                            default:
                                switch (i) {
                                    case 13:
                                        lh lhVar = dVar.f2685a;
                                        if (lhVar == null) {
                                            AMapLocation aMapLocation = new AMapLocation("LBS");
                                            aMapLocation.setErrorCode(33);
                                            d.this.a(aMapLocation);
                                        } else {
                                            dVar.a(lhVar);
                                        }
                                        break;
                                    case 14:
                                        Bundle data4 = message.getData();
                                        data4.putBundle("optBundle", me.a(d.this.b));
                                        d.this.a(18, data4);
                                        break;
                                    case 15:
                                        break;
                                    default:
                                        switch (i) {
                                            case 100:
                                                mk.a((String) null, 2155);
                                                break;
                                            case 102:
                                                Bundle data5 = message.getData();
                                                data5.putBundle("optBundle", me.a(d.this.b));
                                                d.this.a(15, data5);
                                                break;
                                            case 103:
                                                Bundle data6 = message.getData();
                                                if (d.this.G != null) {
                                                    d.this.G.a(data6);
                                                }
                                                break;
                                        }
                                        Message messageObtain = Message.obtain();
                                        messageObtain.what = 1028;
                                        messageObtain.obj = message.obj;
                                        d.this.B.sendMessage(messageObtain);
                                        if (d.this.O != null && d.this.O.getCacheCallBack() && (cVar2 = d.this.c) != null) {
                                            cVar2.removeMessages(13);
                                            break;
                                        }
                                        break;
                                }
                                break;
                        }
                        return;
                    }
                    mk.a((String) null, 2131);
                    Message messageObtain2 = Message.obtain();
                    messageObtain2.what = 16;
                    messageObtain2.obj = message.obj;
                    d.this.B.sendMessage(messageObtain2);
                    return;
                }
                Message messageObtain3 = Message.obtain();
                messageObtain3.what = 12;
                messageObtain3.obj = message.obj;
                d.this.B.sendMessage(messageObtain3);
                if (d.this.O == null || !d.this.O.getCacheCallBack() || (cVar = d.this.c) == null) {
                    return;
                }
                cVar.removeMessages(13);
            } catch (Throwable th) {
                me.a(th, "AmapLocationManager$MainHandler", 0 == 0 ? "handleMessage" : null);
            }
        }

        public c() {
        }
    }

    private void h() {
        synchronized (this.t) {
            a aVar = this.B;
            if (aVar != null) {
                aVar.removeCallbacksAndMessages(null);
            }
            this.B = null;
        }
    }

    private boolean i() {
        boolean z = false;
        int i = 0;
        while (this.m == null) {
            try {
                Thread.sleep(100L);
                i++;
                if (i >= 50) {
                    break;
                }
            } catch (Throwable th) {
                me.a(th, "ALManager", "checkAPSManager");
            }
        }
        if (this.m == null) {
            Message messageObtain = Message.obtain();
            Bundle bundle = new Bundle();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setErrorCode(10);
            if (mm.k(this.E.getApplicationContext())) {
                aMapLocation.setLocationDetail("启动ApsServcie失败#1001");
            } else {
                aMapLocation.setLocationDetail("请检查配置文件是否配置服务，并且manifest中service标签是否配置在application标签内#1003");
            }
            bundle.putParcelable("loc", aMapLocation);
            messageObtain.setData(bundle);
            messageObtain.what = 1;
            this.c.sendMessage(messageObtain);
        } else {
            z = true;
        }
        if (!z) {
            if (mm.k(this.E.getApplicationContext())) {
                mk.a((String) null, AMapException.CODE_AMAP_NEARBY_KEY_NOT_BIND);
            } else {
                mk.a((String) null, 2103);
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j() {
        int i = Build.VERSION.SDK_INT;
        if ((i < 29 && i >= 23 && !mm.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") && !mm.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")) || ((i < 31 && i >= 29 && this.E.getApplicationInfo().targetSdkVersion >= 29 && !mm.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")) || ((i < 31 && i >= 29 && this.E.getApplicationInfo().targetSdkVersion < 29 && !mm.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") && !mm.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")) || (i >= 31 && !mm.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") && !mm.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O"))))) {
            k();
            return;
        }
        if (this.b == null) {
            this.b = new AMapLocationClientOption();
        }
        if (this.I) {
            return;
        }
        this.I = true;
        mg.c();
        long gpsFirstTimeout = 0;
        a(1029, (Object) null, 0L);
        int i2 = AnonymousClass3.f2688a[this.b.getLocationMode().ordinal()];
        if (i2 == 1) {
            a(1027, (Object) null, 0L);
            a(1017, (Object) null, 0L);
            a(1016, (Object) null, 0L);
            a(1031, (Object) null, 0L);
            return;
        }
        if (i2 == 2) {
            if (mm.m(this.E)) {
                a(1016);
                a(1017, (Object) null, 0L);
                a(1032, (Object) null, 0L);
                a(1026, (Object) null, 0L);
                return;
            }
            a(1016);
            a(1027, (Object) null, 0L);
            a(1032, (Object) null, 0L);
            a(1015, (Object) null, 0L);
            return;
        }
        if (i2 == 3) {
            if (mm.m(this.E)) {
                a(1016);
                a(1017, (Object) null, 0L);
                a(1032, (Object) null, 0L);
                a(1026, (Object) null, 0L);
                return;
            }
            a(1027, (Object) null, 0L);
            a(1015, (Object) null, 0L);
            if (this.b.isGpsFirst() && this.b.isOnceLocation()) {
                gpsFirstTimeout = this.b.getGpsFirstTimeout();
            }
            a(1016, (Object) null, gpsFirstTimeout);
            a(1031, (Object) null, gpsFirstTimeout);
        }
    }

    public final void f() {
        try {
            i iVar = this.P;
            if (iVar != null) {
                iVar.b();
                this.P = null;
            }
        } catch (Throwable th) {
            me.a(th, "ALManager", "stopAssistantLocation");
        }
    }

    public final void g() {
        a(12, (Bundle) null);
        this.h = true;
        this.j = true;
        this.i = true;
        this.k = true;
        this.H = false;
        this.v = false;
        l();
        mk mkVar = this.u;
        if (mkVar != null) {
            mkVar.b(this.E);
        }
        mj.a(this.E).a();
        mk.a(this.E);
        e eVar = this.w;
        if (eVar != null) {
            eVar.b().sendEmptyMessage(11);
        } else {
            ServiceConnection serviceConnection = this.Q;
            if (serviceConnection != null) {
                this.E.unbindService(serviceConnection);
            }
        }
        try {
            if (this.D) {
                this.E.stopService(q());
            }
        } catch (Throwable unused) {
        }
        this.D = false;
        ArrayList<AMapLocationListener> arrayList = this.e;
        if (arrayList != null) {
            arrayList.clear();
            this.e = null;
        }
        this.Q = null;
        h();
        b bVar = this.q;
        if (bVar != null) {
            try {
                mi.a(bVar, (Class<?>) HandlerThread.class, "quitSafely", new Object[0]);
            } catch (Throwable unused2) {
                this.q.quit();
            }
        }
        this.q = null;
        c cVar = this.c;
        if (cVar != null) {
            cVar.removeCallbacksAndMessages(null);
        }
        j jVar = this.l;
        if (jVar != null) {
            jVar.c();
            this.l = null;
        }
    }

    public final void c() {
        try {
            a(1004, (Object) null, 0L);
        } catch (Throwable th) {
            me.a(th, "ALManager", "stopLocation");
        }
    }

    public final void d() {
        try {
            i iVar = this.P;
            if (iVar != null) {
                iVar.b();
                this.P = null;
            }
            a(1011, (Object) null, 0L);
            this.r = true;
        } catch (Throwable th) {
            me.a(th, "ALManager", "onDestroy");
        }
    }

    public final AMapLocation e() {
        AMapLocation aMapLocationB = null;
        try {
            j jVar = this.l;
            if (jVar != null && (aMapLocationB = jVar.b()) != null) {
                aMapLocationB.setTrustedLevel(3);
            }
        } catch (Throwable th) {
            me.a(th, "ALManager", "getLastKnownLocation");
        }
        return aMapLocationB;
    }

    private void c(AMapLocation aMapLocation) {
        StringBuilder sb;
        if (aMapLocation != null) {
            try {
                String locationDetail = aMapLocation.getLocationDetail();
                if (TextUtils.isEmpty(locationDetail)) {
                    sb = new StringBuilder();
                } else {
                    sb = new StringBuilder(locationDetail);
                }
                boolean zC = mm.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF");
                boolean zC2 = mm.c(this.E, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF");
                boolean zC3 = mm.c(this.E, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==");
                boolean zC4 = mm.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=");
                boolean zC5 = mm.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O");
                boolean zC6 = mm.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=");
                sb.append(zC ? "#pm1" : "#pm0");
                String str = "1";
                sb.append(zC2 ? "1" : "0");
                sb.append(zC3 ? "1" : "0");
                sb.append(zC4 ? "1" : "0");
                sb.append(zC5 ? "1" : "0");
                if (!zC6) {
                    str = "0";
                }
                sb.append(str);
                aMapLocation.setLocationDetail(sb.toString());
            } catch (Throwable unused) {
                mg.b();
            }
        }
    }

    private void f(AMapLocation aMapLocation) {
        AMapLocation aMapLocationA;
        if (aMapLocation == null) {
            return;
        }
        try {
            lv lvVar = j.b;
            if (lvVar == null) {
                j jVar = this.l;
                aMapLocationA = jVar != null ? jVar.b() : null;
            } else {
                aMapLocationA = lvVar.a();
            }
            mk.a(aMapLocationA, aMapLocation);
        } catch (Throwable unused) {
        }
    }

    private synchronized void e(AMapLocation aMapLocation) {
        if (aMapLocation == null) {
            try {
                aMapLocation = new AMapLocation("");
                aMapLocation.setErrorCode(8);
                aMapLocation.setLocationDetail("coarse amapLocation is null#2005");
            } catch (Throwable th) {
                me.a(th, "ALManager", "handlerCoarseLocation part2");
                return;
            }
        }
        if (this.y == null) {
            this.y = new AMapLocationQualityReport();
        }
        this.y.setLocationMode(this.b.getLocationMode());
        if (this.G != null) {
            this.y.setGPSSatellites(aMapLocation.getSatellites());
            this.y.setGpsStatus(this.G.b());
        }
        this.y.setWifiAble(mm.g(this.E));
        this.y.setNetworkType(mm.h(this.E));
        this.y.setNetUseTime(0L);
        this.y.setInstallHighDangerMockApp(L);
        aMapLocation.setLocationQualityReport(this.y);
        try {
            if (this.I) {
                mk.a(this.E, aMapLocation);
                d(aMapLocation.m10clone());
                mj.a(this.E).a(aMapLocation);
                mj.a(this.E).b();
            }
        } catch (Throwable th2) {
            me.a(th2, "ALManager", "handlerCoarseLocation part");
        }
        if (this.r) {
            return;
        }
        if (this.G != null) {
            l();
        }
        a(14, (Bundle) null);
    }

    public final void b(AMapLocationListener aMapLocationListener) {
        try {
            a(1005, aMapLocationListener, 0L);
        } catch (Throwable th) {
            me.a(th, "ALManager", "unRegisterLocationListener");
        }
    }

    private void d(AMapLocation aMapLocation) {
        Message messageObtainMessage = this.c.obtainMessage();
        messageObtainMessage.what = 10;
        messageObtainMessage.obj = aMapLocation;
        this.c.sendMessage(messageObtainMessage);
    }

    public final void b() {
        c cVar;
        try {
            if (this.O.getCacheCallBack() && (cVar = this.c) != null) {
                cVar.sendEmptyMessageDelayed(13, this.O.getCacheCallBackTime());
            }
        } catch (Throwable unused) {
        }
        try {
            a(1003, (Object) null, 0L);
        } catch (Throwable th) {
            me.a(th, "ALManager", "startLocation");
        }
    }

    public final boolean a() {
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Object obj, long j) {
        synchronized (this.t) {
            if (this.B != null) {
                Message messageObtain = Message.obtain();
                messageObtain.what = i;
                if (obj instanceof Bundle) {
                    messageObtain.setData((Bundle) obj);
                } else {
                    messageObtain.obj = obj;
                }
                this.B.sendMessageDelayed(messageObtain, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AMapLocationListener aMapLocationListener) {
        if (!this.e.isEmpty() && this.e.contains(aMapLocationListener)) {
            this.e.remove(aMapLocationListener);
        }
        if (this.e.isEmpty()) {
            l();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0029 -> B:31:0x002e). Please report as a decompilation issue!!! */
    private void b(Looper looper) {
        try {
            if (looper == null) {
                if (Looper.myLooper() == null) {
                    this.c = new c(this.E.getMainLooper());
                } else {
                    this.c = new c();
                }
            } else {
                this.c = new c(looper);
            }
        } catch (Throwable th) {
            me.a(th, "ALManager", "init 1");
        }
        try {
            try {
                this.l = new j(this.E);
            } catch (Throwable th2) {
                me.a(th2, "ALManager", "init 2");
            }
            b bVar = new b("amapLocManagerThread", this);
            this.q = bVar;
            bVar.setPriority(5);
            this.q.start();
            this.B = a(this.q.getLooper());
        } catch (Throwable th3) {
            me.a(th3, "ALManager", "init 5");
        }
        try {
            this.d = new h(this.E, this.c);
            this.F = new k(this.E, this.c);
            this.G = new g(this.E, this.c);
        } catch (Throwable th4) {
            me.a(th4, "ALManager", "init 3");
        }
        if (this.u == null) {
            this.u = new mk();
        }
        a(this.E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Message message) {
        if (message == null) {
            return;
        }
        try {
            Bundle data = message.getData();
            if (data == null) {
                return;
            }
            int i = data.getInt("i", 0);
            Notification notification = (Notification) data.getParcelable("h");
            Intent intentQ = q();
            intentQ.putExtra("i", i);
            intentQ.putExtra("h", notification);
            intentQ.putExtra("g", 1);
            a(intentQ, true);
        } catch (Throwable th) {
            me.a(th, "ALManager", "doEnableBackgroundLocation");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        synchronized (this.t) {
            a aVar = this.B;
            if (aVar != null) {
                aVar.removeMessages(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener != null) {
            if (this.e == null) {
                this.e = new ArrayList<>();
            }
            if (this.e.contains(aMapLocationListener)) {
                return;
            }
            this.e.add(aMapLocationListener);
            return;
        }
        throw new IllegalArgumentException("listener参数不能为null");
    }

    private a a(Looper looper) {
        a aVar;
        synchronized (this.t) {
            aVar = new a(looper);
            this.B = aVar;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        try {
            AMapLocation aMapLocation = (AMapLocation) message.obj;
            aMapLocation.getLongitude();
            aMapLocation.getLatitude();
            mg.c();
            if (this.j && this.m != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", me.a(this.b));
                a(0, bundle);
                if (this.I) {
                    a(13, (Bundle) null);
                }
                this.j = false;
            }
            if (this.M) {
                a(1034);
                a(aMapLocation, (lb) null);
            }
            a(1033);
            a(1033, (Object) null, 300000L);
        } catch (Throwable th) {
            me.a(th, "ALManager", "resultNetworkLocationSuccess");
        }
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        try {
            this.O = aMapLocationClientOption.m11clone();
            a(1018, aMapLocationClientOption.m11clone(), 0L);
        } catch (Throwable th) {
            me.a(th, "ALManager", "setLocationOption");
        }
    }

    public final void a(AMapLocationListener aMapLocationListener) {
        try {
            a(1002, aMapLocationListener, 0L);
        } catch (Throwable th) {
            me.a(th, "ALManager", "setLocationListener");
        }
    }

    private static void b(AMapLocation aMapLocation) {
        if (aMapLocation == null) {
            return;
        }
        try {
            if (2 == aMapLocation.getLocationType() || 4 == aMapLocation.getLocationType()) {
                long time = aMapLocation.getTime();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis > time) {
                    aMapLocation.setTime(jCurrentTimeMillis);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void a(WebView webView) {
        if (this.P == null) {
            this.P = new i(this.E, webView);
        }
        this.P.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(AMapLocation aMapLocation) {
        try {
            if (this.i && this.m != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", me.a(this.b));
                a(0, bundle);
                if (this.I) {
                    a(13, (Bundle) null);
                }
                this.i = false;
            }
            e(aMapLocation);
        } catch (Throwable th) {
            me.a(th, "ALManager", "resultGpsLocationSuccess");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Message message) {
        if (message == null) {
            return;
        }
        try {
            Bundle data = message.getData();
            if (data == null) {
                return;
            }
            boolean z = data.getBoolean(hb.j, true);
            Intent intentQ = q();
            intentQ.putExtra(hb.j, z);
            intentQ.putExtra("g", 2);
            a(intentQ, false);
        } catch (Throwable th) {
            me.a(th, "ALManager", "doDisableBackgroundLocation");
        }
    }

    private static void a(final Context context) {
        if (N.compareAndSet(false, true)) {
            jc.a().b(new jd() { // from class: com.amap.api.col.2sl.d.1
                @Override // com.amap.api.col.p0002sl.jd
                public final void a() {
                    fv.l();
                    fv.a(context);
                    fv.f(context);
                }
            });
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:0|2|(12:124|3|103|4|(1:6)|120|10|(1:12)|16|17|119|18)|(5:20|(1:36)(2:22|(3:25|(2:27|(1:31))|36)(1:24))|105|88|94)(1:32)|37|(21:(1:40)(1:41)|117|42|(2:44|(1:46))|47|(3:115|56|57)(1:60)|113|61|(1:65)|101|69|(1:73)|107|74|(1:76)|77|(1:79)|(1:87)|105|88|94)(1:53)|54|(0)(0)|113|61|(2:63|65)|101|69|(2:71|73)|107|74|(0)|77|(0)|(2:85|87)|105|88|94|(2:(0)|(1:110))) */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e9, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ea, code lost:
    
        com.amap.api.col.p0002sl.me.a(r8, "ALManager", "fixLastLocation");
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0123, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0124, code lost:
    
        com.amap.api.col.p0002sl.me.a(r1, "ALManager", "apsLocation:callback");
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0107 A[Catch: all -> 0x0123, TryCatch #3 {all -> 0x0123, blocks: (B:74:0x0100, B:76:0x0107, B:77:0x011a, B:79:0x011f), top: B:107:0x0100, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x011f A[Catch: all -> 0x0123, TRY_LEAVE, TryCatch #3 {all -> 0x0123, blocks: (B:74:0x0100, B:76:0x0107, B:77:0x011a, B:79:0x011f), top: B:107:0x0100, outer: #7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private lh b(lc lcVar) {
        lh lhVar;
        Throwable th;
        boolean zM;
        boolean z;
        lh lhVarA;
        boolean z2;
        String strK;
        c cVar;
        j jVar;
        AMapLocation aMapLocationM10clone = null;
        this.f2685a = null;
        lb lbVar = new lb();
        try {
            lbVar.c(mm.b());
            try {
                String apikey = AMapLocationClientOption.getAPIKEY();
                if (!TextUtils.isEmpty(apikey)) {
                    fs.a(this.E, apikey);
                }
            } catch (Throwable th2) {
                me.a(th2, "ALManager", "apsLocation setAuthKey");
            }
            try {
                String umidtoken = UmidtokenInfo.getUmidtoken();
                if (!TextUtils.isEmpty(umidtoken)) {
                    fv.a(umidtoken);
                }
            } catch (Throwable th3) {
                me.a(th3, "ALManager", "apsLocation setUmidToken");
            }
            a(lcVar, lbVar);
            zM = md.m();
            z = false;
            try {
            } catch (Throwable th4) {
                me.a(th4, "ALManager", "apscach");
            }
        } catch (Throwable th5) {
            lhVar = null;
            th = th5;
            try {
                me.a(th, "ALManager", "apsLocation");
                return lhVar;
            } finally {
                try {
                    lcVar.e();
                } catch (Throwable unused) {
                }
            }
        }
        if (this.O.getCacheCallBack()) {
            lhVarA = a(lcVar, this.O.getCacheCallBack());
            if (lhVarA == null) {
                lhVarA = null;
            } else if (!md.a(lhVarA.getTime())) {
                if (this.O.getCacheCallBack()) {
                    int cacheTimeOut = this.O.getCacheTimeOut();
                    long jA = mm.a() - lhVarA.getTime();
                    if (jA > 0 && jA < cacheTimeOut) {
                        this.f2685a = lhVarA;
                        lhVarA.setLocationType(10);
                    }
                }
                lhVarA = null;
            }
            return lhVar;
        }
        lhVarA = a(lcVar, false);
        if (lhVarA == null) {
            try {
                lhVarA = lcVar.a(!zM, lbVar);
                if (lhVarA != null) {
                    if (lhVarA.getErrorCode() == 0) {
                        z = true;
                    }
                }
                lhVar = lhVarA;
                z2 = z;
                z = true;
            } catch (Throwable th6) {
                try {
                    me.a(th6, "ALManager", "apsLocation:doFirstNetLocate");
                    lhVar = lhVarA;
                    z = true;
                    z2 = false;
                } catch (Throwable th7) {
                    th = th7;
                    lhVar = lhVarA;
                    me.a(th, "ALManager", "apsLocation");
                    return lhVar;
                }
            }
            if (lhVar == null) {
                try {
                    strK = lhVar.k();
                    aMapLocationM10clone = lhVar.m10clone();
                } catch (Throwable th8) {
                    th = th8;
                    me.a(th, "ALManager", "apsLocation");
                }
            } else {
                strK = null;
            }
            if (this.b.isLocationCacheEnable() && (jVar = this.l) != null) {
                aMapLocationM10clone = jVar.a(aMapLocationM10clone, strK, this.b.getLastLocationLifeCycle());
            }
            if (this.O.getCacheCallBack() && (cVar = this.c) != null) {
                cVar.removeMessages(13);
            }
            Bundle bundle = new Bundle();
            if (aMapLocationM10clone != null) {
                bundle.putParcelable("loc", aMapLocationM10clone);
                bundle.putString("nb", lhVar.k());
                bundle.putParcelable("statics", lbVar);
            }
            a(bundle);
            if (z2) {
                a(lcVar, lhVar);
            }
            if (z && zM && !g) {
                g = true;
                a(lcVar);
            }
            return lhVar;
        }
        lhVar = lhVarA;
        z2 = false;
        if (lhVar == null) {
        }
        if (this.b.isLocationCacheEnable()) {
            aMapLocationM10clone = jVar.a(aMapLocationM10clone, strK, this.b.getLastLocationLifeCycle());
        }
        if (this.O.getCacheCallBack()) {
            cVar.removeMessages(13);
        }
        Bundle bundle2 = new Bundle();
        if (aMapLocationM10clone != null) {
        }
        a(bundle2);
        if (z2) {
        }
        if (z) {
            g = true;
            a(lcVar);
        }
        return lhVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = new Bundle();
            } catch (Throwable th) {
                boolean z = (th instanceof IllegalStateException) && th.getMessage().contains("sending message to a Handler on a dead thread");
                if ((th instanceof RemoteException) || z) {
                    this.m = null;
                    this.H = false;
                }
                me.a(th, "ALManager", "sendLocMessage");
                return;
            }
        }
        if (TextUtils.isEmpty(this.x)) {
            this.x = me.b(this.E);
        }
        bundle.putString("c", this.x);
        Message messageObtain = Message.obtain();
        messageObtain.what = i;
        messageObtain.setData(bundle);
        messageObtain.replyTo = this.n;
        Messenger messenger = this.m;
        if (messenger != null) {
            messenger.send(messageObtain);
        }
    }

    private void a(Intent intent) {
        try {
            this.E.bindService(intent, this.Q, 1);
        } catch (Throwable th) {
            me.a(th, "ALManager", "startServiceImpl");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AMapLocation aMapLocation) {
        try {
            if (aMapLocation.getErrorCode() != 0) {
                aMapLocation.setLocationType(0);
            }
            if (aMapLocation.getErrorCode() == 0) {
                double latitude = aMapLocation.getLatitude();
                double longitude = aMapLocation.getLongitude();
                if ((latitude == 0.0d && longitude == 0.0d) || latitude < -90.0d || latitude > 90.0d || longitude < -180.0d || longitude > 180.0d) {
                    mk.a("errorLatLng", aMapLocation.toStr());
                    aMapLocation.setLocationType(0);
                    aMapLocation.setErrorCode(8);
                    aMapLocation.setLocationDetail("LatLng is error#0802");
                }
            }
            if (GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider()) || !this.d.b() || "network".equalsIgnoreCase(aMapLocation.getProvider()) || !this.F.c()) {
                aMapLocation.setAltitude(mm.c(aMapLocation.getAltitude()));
                aMapLocation.setBearing(mm.a(aMapLocation.getBearing()));
                aMapLocation.setSpeed(mm.a(aMapLocation.getSpeed()));
                c(aMapLocation);
                b(aMapLocation);
                aMapLocation.getProvider();
                aMapLocation.getLongitude();
                aMapLocation.getLatitude();
                mg.c();
                Iterator<AMapLocationListener> it = this.e.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onLocationChanged(aMapLocation);
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(AMapLocation aMapLocation, lb lbVar) {
        try {
            mg.c();
            if (aMapLocation == null) {
                aMapLocation = new AMapLocation("");
                aMapLocation.setErrorCode(8);
                aMapLocation.setLocationDetail("amapLocation is null#0801");
            }
            if (this.y == null) {
                this.y = new AMapLocationQualityReport();
            }
            this.y.setLocationMode(this.b.getLocationMode());
            h hVar = this.d;
            if (hVar != null) {
                this.y.setGPSSatellites(hVar.e());
                this.y.setGpsStatus(this.d.d());
            }
            this.y.setWifiAble(mm.g(this.E));
            this.y.setNetworkType(mm.h(this.E));
            if (aMapLocation.getLocationType() == 1 || GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider())) {
                this.y.setNetUseTime(0L);
            }
            if (lbVar != null) {
                this.y.setNetUseTime(lbVar.a());
            }
            this.y.setInstallHighDangerMockApp(L);
            aMapLocation.setLocationQualityReport(this.y);
            try {
                if (this.I) {
                    a(aMapLocation, this.C);
                    if (lbVar != null) {
                        lbVar.d(mm.b());
                    }
                    mk.a(this.E, aMapLocation, lbVar);
                    mk.a(this.E, aMapLocation);
                    d(aMapLocation.m10clone());
                    mj.a(this.E).a(aMapLocation);
                    mj.a(this.E).b();
                }
            } catch (Throwable th) {
                me.a(th, "ALManager", "handlerLocation part2");
            }
            if (this.r) {
                return;
            }
            if (this.b.isOnceLocation()) {
                l();
                a(14, (Bundle) null);
            }
        } catch (Throwable th2) {
            me.a(th2, "ALManager", "handlerLocation part3");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        try {
            AMapLocation aMapLocation = (AMapLocation) message.obj;
            aMapLocation.getLongitude();
            aMapLocation.getLatitude();
            mg.c();
            if (this.h && this.m != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", me.a(this.b));
                a(0, bundle);
                if (this.I) {
                    a(13, (Bundle) null);
                }
                this.h = false;
            }
            a(aMapLocation, (lb) null);
            a(1025);
            a(1025, (Object) null, 300000L);
        } catch (Throwable th) {
            me.a(th, "ALManager", "resultGpsLocationSuccess");
        }
    }

    private void a(AMapLocation aMapLocation, String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("loc", aMapLocation);
        bundle.putString("lastLocNb", str);
        a(1014, bundle, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        try {
            Bundle data = message.getData();
            AMapLocation aMapLocation = (AMapLocation) data.getParcelable("loc");
            String string = data.getString("lastLocNb");
            f(aMapLocation);
            if (this.l.a(aMapLocation, string)) {
                this.l.d();
            }
        } catch (Throwable th) {
            me.a(th, "ALManager", "doSaveLastLocation");
        }
    }

    private void a(lc lcVar, lb lbVar) {
        try {
            lcVar.a(this.E);
            lcVar.a(this.b);
            lcVar.b(lbVar);
        } catch (Throwable th) {
            me.a(th, "ALManager", "initApsBase");
        }
    }

    private lh a(lc lcVar, boolean z) {
        if (!this.b.isLocationCacheEnable()) {
            return null;
        }
        try {
            return lcVar.b(z);
        } catch (Throwable th) {
            me.a(th, "ALManager", "doFirstCacheLoc");
            return null;
        }
    }

    private static void a(lc lcVar) {
        try {
            lcVar.d();
            lcVar.a(new AMapLocationClientOption().setNeedAddress(false));
            lcVar.a(true, new lb());
        } catch (Throwable th) {
            me.a(th, "ALManager", "apsLocation:doFirstNetLocate 2");
        }
    }

    private static void a(lc lcVar, lh lhVar) {
        if (lhVar != null) {
            try {
                if (lhVar.getErrorCode() == 0) {
                    lcVar.b(lhVar);
                }
            } catch (Throwable th) {
                me.a(th, "ALManager", "apsLocation:doFirstAddCache");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle) {
        lb lbVar;
        AMapLocation aMapLocationA;
        h hVar;
        AMapLocation aMapLocation = null;
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                aMapLocationA = (AMapLocation) bundle.getParcelable("loc");
                aMapLocationA.getLongitude();
                aMapLocationA.getLatitude();
                mg.c();
                aMapLocationA.setProvider("lbs");
                this.C = bundle.getString("nb");
                lbVar = (lb) bundle.getParcelable("statics");
                try {
                    if (aMapLocationA.getErrorCode() == 0 && (hVar = this.d) != null) {
                        hVar.c();
                        if (!TextUtils.isEmpty(aMapLocationA.getAdCode())) {
                            h.y = aMapLocationA;
                            k.y = aMapLocationA;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    me.a(th, "AmapLocationManager", "resultLbsLocationSuccess");
                }
            } catch (Throwable th2) {
                th = th2;
                lbVar = null;
                me.a(th, "AmapLocationManager", "resultLbsLocationSuccess");
            }
        } else {
            lbVar = null;
            aMapLocationA = null;
        }
        h hVar2 = this.d;
        if (hVar2 != null) {
            aMapLocationA = hVar2.a(aMapLocationA, this.C);
        }
        if (this.F != null && (!mm.a(aMapLocationA) || (this.b.isNeedAddress() && TextUtils.isEmpty(aMapLocationA.getAdCode())))) {
            aMapLocationA = this.F.a(aMapLocationA, this.C);
        }
        AMapLocation aMapLocation2 = aMapLocationA;
        th = null;
        aMapLocation = aMapLocation2;
        if (mm.a(aMapLocation)) {
            this.M = false;
            a(aMapLocation, lbVar);
            return;
        }
        this.M = true;
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("mapLoc", aMapLocation);
        bundle2.putParcelable("entity", lbVar);
        bundle2.putSerializable("ex", th);
        a(1034, bundle2, 10000L);
    }

    public final void a(int i, Notification notification) {
        if (i == 0 || notification == null) {
            return;
        }
        try {
            if (this.k && this.m != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", me.a(this.b));
                a(0, bundle);
                this.k = false;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("i", i);
            bundle2.putParcelable("h", notification);
            a(1023, bundle2, 0L);
        } catch (Throwable th) {
            me.a(th, "ALManager", "disableBackgroundLocation");
        }
    }

    public final void a(boolean z) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean(hb.j, z);
            a(1024, bundle, 0L);
        } catch (Throwable th) {
            me.a(th, "ALManager", "disableBackgroundLocation");
        }
    }

    private void a(Intent intent, boolean z) {
        Context context = this.E;
        if (context != null) {
            if (Build.VERSION.SDK_INT >= 26 && z) {
                if (!t()) {
                    Log.e("amapapi", "-------------调用后台定位服务，缺少权限：android.permission.FOREGROUND_SERVICE--------------");
                    return;
                } else {
                    try {
                        this.E.getClass().getMethod("startForegroundService", Intent.class).invoke(this.E, intent);
                    } catch (Throwable unused) {
                        this.E.startService(intent);
                    }
                }
            } else {
                context.startService(intent);
            }
            this.D = true;
        }
    }
}
