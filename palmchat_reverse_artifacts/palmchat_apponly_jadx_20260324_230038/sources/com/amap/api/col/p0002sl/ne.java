package com.amap.api.col.p0002sl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.HandlerThread;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.alipay.sdk.m.x.d;
import com.ss.android.ttvecamera.TECameraResult;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@SuppressLint({"NewApi"})
public final class ne {
    TelephonyManager c;
    CellLocation e;
    private Context l;
    private nc p;
    private Object q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f3029a = 0;
    ArrayList<nd> b = new ArrayList<>();
    private String m = null;
    private ArrayList<nd> n = new ArrayList<>();
    private int o = TECameraResult.TER_CLOSE_CALLED;
    long d = 0;
    private int r = 0;
    private long s = 0;
    boolean f = false;
    PhoneStateListener g = null;
    String h = null;
    boolean i = false;
    StringBuilder j = null;
    HandlerThread k = null;
    private boolean t = false;
    private Object u = new Object();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HandlerThread {
        public a(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            try {
                super.onLooperPrepared();
                synchronized (ne.this.u) {
                    if (!ne.this.t) {
                        ne.this.k();
                    }
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                try {
                    super.run();
                } catch (Throwable unused) {
                    ne.this.c.listen(ne.this.g, 0);
                    ne.this.g = null;
                    quit();
                }
            } catch (Throwable unused2) {
            }
        }
    }

    public ne(Context context) {
        this.c = null;
        this.p = null;
        this.l = context;
        this.c = (TelephonyManager) np.a(context, "phone");
        j();
        this.p = new nc();
    }

    private void j() {
        TelephonyManager telephonyManager = this.c;
        if (telephonyManager == null) {
            return;
        }
        try {
            this.f3029a = c(telephonyManager.getCellLocation());
        } catch (SecurityException e) {
            this.h = e.getMessage();
        } catch (Throwable th) {
            this.h = null;
            nl.a(th, "CgiManager", "CgiManager");
            this.f3029a = 0;
        }
        try {
            int iU = u();
            this.r = iU;
            this.q = iU != 1 ? iU != 2 ? np.a(this.l, "phone2") : np.a(this.l, "phone2") : np.a(this.l, "phone_msim");
        } catch (Throwable unused) {
        }
        if (this.k == null) {
            a aVar = new a("listenerPhoneStateThread");
            this.k = aVar;
            aVar.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        int iB;
        this.g = new PhoneStateListener() { // from class: com.amap.api.col.2sl.ne.1
            @Override // android.telephony.PhoneStateListener
            public final void onCellLocationChanged(CellLocation cellLocation) {
                try {
                    if (ne.this.a(cellLocation)) {
                        ne neVar = ne.this;
                        neVar.e = cellLocation;
                        neVar.f = true;
                        neVar.s = np.b();
                    }
                } catch (Throwable unused) {
                }
            }

            @Override // android.telephony.PhoneStateListener
            public final void onServiceStateChanged(ServiceState serviceState) {
                try {
                    int state = serviceState.getState();
                    if (state == 0) {
                        ne.this.f();
                    } else {
                        if (state != 1) {
                            return;
                        }
                        ne.this.h();
                    }
                } catch (Throwable unused) {
                }
            }

            @Override // android.telephony.PhoneStateListener
            public final void onSignalStrengthChanged(int i) {
                try {
                    int i2 = ne.this.f3029a;
                    ne.this.b((i2 == 1 || i2 == 2) ? np.a(i) : TECameraResult.TER_CLOSE_CALLED);
                } catch (Throwable unused) {
                }
            }

            @Override // android.telephony.PhoneStateListener
            public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
                if (signalStrength == null) {
                    return;
                }
                try {
                    int i = ne.this.f3029a;
                    ne.this.b(i != 1 ? i != 2 ? TECameraResult.TER_CLOSE_CALLED : signalStrength.getCdmaDbm() : np.a(signalStrength.getGsmSignalStrength()));
                } catch (Throwable unused) {
                }
            }
        };
        try {
            iB = nn.b("android.telephony.PhoneStateListener", np.c() < 7 ? "LISTEN_SIGNAL_STRENGTH" : "LISTEN_SIGNAL_STRENGTHS");
        } catch (Throwable unused) {
            iB = 0;
        }
        if (iB == 0) {
            try {
                this.c.listen(this.g, 16);
            } catch (Throwable unused2) {
            }
        } else {
            try {
                this.c.listen(this.g, iB | 16);
            } catch (Throwable unused3) {
            }
        }
    }

    private CellLocation l() {
        TelephonyManager telephonyManager = this.c;
        if (telephonyManager != null) {
            try {
                CellLocation cellLocation = telephonyManager.getCellLocation();
                this.h = null;
                if (b(cellLocation)) {
                    this.e = cellLocation;
                    return cellLocation;
                }
            } catch (SecurityException e) {
                this.h = e.getMessage();
            } catch (Throwable th) {
                this.h = null;
                nl.a(th, "CgiManager", "getCellLocation");
            }
        }
        return null;
    }

    private boolean m() {
        return !this.i && np.b() - this.d >= 10000;
    }

    private void n() {
        h();
    }

    private void o() {
        int iD = d();
        if (iD == 1) {
            if (this.b.isEmpty()) {
                this.f3029a = 0;
            }
        } else if (iD == 2 && this.b.isEmpty()) {
            this.f3029a = 0;
        }
    }

    private void p() {
        if (!this.i && this.c != null) {
            CellLocation cellLocationQ = q();
            if (!b(cellLocationQ)) {
                cellLocationQ = r();
            }
            if (b(cellLocationQ)) {
                this.e = cellLocationQ;
                this.s = np.b();
            } else if (np.b() - this.s > 60000) {
                this.e = null;
                this.b.clear();
                this.n.clear();
            }
        }
        this.f = true;
        if (b(this.e)) {
            String[] strArrA = np.a(this.c);
            int iC = c(this.e);
            if (iC == 1) {
                a(this.e, strArrA);
            } else if (iC == 2) {
                b(this.e, strArrA);
            }
        }
        try {
            if (np.c() >= 18) {
                t();
            }
        } catch (Throwable unused) {
        }
        TelephonyManager telephonyManager = this.c;
        if (telephonyManager != null) {
            String networkOperator = telephonyManager.getNetworkOperator();
            this.m = networkOperator;
            if (TextUtils.isEmpty(networkOperator)) {
                return;
            }
            this.f3029a |= 8;
        }
    }

    @SuppressLint({"NewApi"})
    private CellLocation q() {
        TelephonyManager telephonyManager = this.c;
        CellLocation cellLocationA = null;
        if (telephonyManager == null) {
            return null;
        }
        CellLocation cellLocationL = l();
        if (b(cellLocationL)) {
            return cellLocationL;
        }
        if (np.c() >= 18) {
            try {
                cellLocationA = a(telephonyManager.getAllCellInfo());
            } catch (SecurityException e) {
                this.h = e.getMessage();
            }
        }
        if (cellLocationA != null) {
            return cellLocationA;
        }
        CellLocation cellLocationA2 = a(telephonyManager, "getCellLocationExt", 1);
        return cellLocationA2 != null ? cellLocationA2 : a(telephonyManager, "getCellLocationGemini", 1);
    }

    private CellLocation r() {
        Object obj = this.q;
        CellLocation cellLocationA = null;
        if (obj == null) {
            return null;
        }
        try {
            Class<?> clsS = s();
            if (clsS.isInstance(obj)) {
                Object objCast = clsS.cast(obj);
                CellLocation cellLocationA2 = a(objCast, "getCellLocation", new Object[0]);
                if (cellLocationA2 != null) {
                    return cellLocationA2;
                }
                CellLocation cellLocationA3 = a(objCast, "getCellLocation", 1);
                if (cellLocationA3 != null) {
                    return cellLocationA3;
                }
                CellLocation cellLocationA4 = a(objCast, "getCellLocationGemini", 1);
                if (cellLocationA4 != null) {
                    return cellLocationA4;
                }
                cellLocationA = a(objCast, "getAllCellInfo", 1);
                if (cellLocationA != null) {
                    return cellLocationA;
                }
            }
        } catch (Throwable th) {
            nl.a(th, "CgiManager", "getSim2Cgi");
        }
        return cellLocationA;
    }

    private Class<?> s() {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        int i = this.r;
        try {
            return systemClassLoader.loadClass(i != 0 ? i != 1 ? i != 2 ? null : "android.telephony.TelephonyManager2" : "android.telephony.MSimTelephonyManager" : "android.telephony.TelephonyManager");
        } catch (Throwable th) {
            nl.a(th, "CgiManager", "getSim2TmClass");
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    private void t() {
        SecurityException e;
        List<CellInfo> allCellInfo;
        int size;
        nd ndVarA;
        long jMin;
        TelephonyManager telephonyManager = this.c;
        if (telephonyManager == null) {
            return;
        }
        ArrayList<nd> arrayList = this.n;
        nc ncVar = this.p;
        try {
            allCellInfo = telephonyManager.getAllCellInfo();
            try {
                this.h = null;
            } catch (SecurityException e2) {
                e = e2;
                this.h = e.getMessage();
            }
        } catch (SecurityException e3) {
            e = e3;
            allCellInfo = null;
        }
        if (allCellInfo != null && (size = allCellInfo.size()) != 0) {
            if (arrayList != null) {
                arrayList.clear();
            }
            for (int i = 0; i < size; i++) {
                CellInfo cellInfo = allCellInfo.get(i);
                if (cellInfo != null) {
                    try {
                        boolean zIsRegistered = cellInfo.isRegistered();
                        if (cellInfo instanceof CellInfoCdma) {
                            CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                            if (a(cellInfoCdma.getCellIdentity())) {
                                ndVarA = a(cellInfoCdma, zIsRegistered);
                                jMin = Math.min(WebSocketProtocol.PAYLOAD_SHORT_MAX, ncVar.a(ndVarA));
                                ndVarA.l = (short) jMin;
                                arrayList.add(ndVarA);
                            }
                        } else if (cellInfo instanceof CellInfoGsm) {
                            CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                            if (a(cellInfoGsm.getCellIdentity())) {
                                ndVarA = a(cellInfoGsm, zIsRegistered);
                                jMin = Math.min(WebSocketProtocol.PAYLOAD_SHORT_MAX, ncVar.a(ndVarA));
                                ndVarA.l = (short) jMin;
                                arrayList.add(ndVarA);
                            }
                        } else if (cellInfo instanceof CellInfoWcdma) {
                            CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                            if (a(cellInfoWcdma.getCellIdentity())) {
                                ndVarA = a(cellInfoWcdma, zIsRegistered);
                                jMin = Math.min(WebSocketProtocol.PAYLOAD_SHORT_MAX, ncVar.a(ndVarA));
                                ndVarA.l = (short) jMin;
                                arrayList.add(ndVarA);
                            }
                        } else if (cellInfo instanceof CellInfoLte) {
                            CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                            if (a(cellInfoLte.getCellIdentity())) {
                                ndVarA = a(cellInfoLte, zIsRegistered);
                                jMin = Math.min(WebSocketProtocol.PAYLOAD_SHORT_MAX, ncVar.a(ndVarA));
                                ndVarA.l = (short) jMin;
                                arrayList.add(ndVarA);
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.f3029a |= 4;
        ncVar.a(arrayList);
    }

    private int u() {
        try {
            Class.forName("android.telephony.MSimTelephonyManager");
            this.r = 1;
        } catch (Throwable unused) {
        }
        if (this.r == 0) {
            try {
                Class.forName("android.telephony.TelephonyManager2");
                this.r = 2;
            } catch (Throwable unused2) {
            }
        }
        return this.r;
    }

    public final ArrayList<nd> b() {
        return this.n;
    }

    public final int c() {
        return this.f3029a;
    }

    public final int d() {
        return this.f3029a & 3;
    }

    public final TelephonyManager e() {
        return this.c;
    }

    public final void f() {
        try {
            this.i = np.a(this.l);
            if (m() || this.b.isEmpty()) {
                p();
                this.d = np.b();
            }
            if (this.i) {
                n();
            } else {
                o();
            }
        } catch (SecurityException e) {
            this.h = e.getMessage();
        } catch (Throwable th) {
            nl.a(th, "CgiManager", d.w);
        }
    }

    public final void g() {
        PhoneStateListener phoneStateListener;
        this.p.a();
        this.s = 0L;
        synchronized (this.u) {
            this.t = true;
        }
        TelephonyManager telephonyManager = this.c;
        if (telephonyManager != null && (phoneStateListener = this.g) != null) {
            try {
                telephonyManager.listen(phoneStateListener, 0);
            } catch (Throwable th) {
                nl.a(th, "CgiManager", "destroy");
            }
        }
        this.g = null;
        HandlerThread handlerThread = this.k;
        if (handlerThread != null) {
            handlerThread.quit();
            this.k = null;
        }
        this.o = TECameraResult.TER_CLOSE_CALLED;
        this.c = null;
        this.q = null;
    }

    public final void h() {
        this.h = null;
        this.e = null;
        this.f3029a = 0;
        this.b.clear();
        this.n.clear();
    }

    public final String i() {
        return this.m;
    }

    private CellLocation a(Object obj, String str, Object... objArr) {
        CellLocation cellLocation;
        if (obj == null) {
            return null;
        }
        try {
            Object objA = nn.a(obj, str, objArr);
            cellLocation = objA != null ? (CellLocation) objA : null;
        } catch (Throwable unused) {
        }
        if (b(cellLocation)) {
            return cellLocation;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        ArrayList<nd> arrayList;
        if (i == -113) {
            this.o = TECameraResult.TER_CLOSE_CALLED;
            return;
        }
        this.o = i;
        int i2 = this.f3029a;
        if ((i2 != 1 && i2 != 2) || (arrayList = this.b) == null || arrayList.isEmpty()) {
            return;
        }
        try {
            this.b.get(0).j = this.o;
        } catch (Throwable unused) {
        }
    }

    private int c(CellLocation cellLocation) {
        if (this.i || cellLocation == null) {
            return 0;
        }
        if (cellLocation instanceof GsmCellLocation) {
            return 1;
        }
        try {
            Class.forName("android.telephony.cdma.CdmaCellLocation");
            return 2;
        } catch (Throwable th) {
            nl.a(th, "Utils", "getCellLocT");
            return 0;
        }
    }

    private static boolean d(int i) {
        return (i == -1 || i == 0 || i == 65535 || i >= 268435455) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00af A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [com.amap.api.col.2sl.nd] */
    /* JADX WARN: Type inference failed for: r11v6 */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private CellLocation a(List<CellInfo> list) {
        GsmCellLocation gsmCellLocation;
        CellLocation cellLocation;
        CellLocation cellLocation2 = null;
        gsmCellLocation = null;
        gsmCellLocation = null;
        cellLocation2 = null;
        GsmCellLocation gsmCellLocation2 = null;
        cellLocation2 = null;
        cellLocation2 = null;
        if (list != null && !list.isEmpty()) {
            int i = 0;
            nd ndVarA = list;
            while (true) {
                if (i >= ndVarA.size()) {
                    ndVarA = 0;
                    if (ndVarA == 0) {
                        gsmCellLocation = null;
                        break;
                    }
                    try {
                        if (ndVarA.k == 2) {
                            CdmaCellLocation cdmaCellLocation = new CdmaCellLocation();
                            try {
                                cdmaCellLocation.setCellLocationData(ndVarA.i, ndVarA.e, ndVarA.f, ndVarA.g, ndVarA.h);
                                cellLocation = cdmaCellLocation;
                            } catch (Throwable unused) {
                                cellLocation = cdmaCellLocation;
                            }
                        } else {
                            gsmCellLocation = new GsmCellLocation();
                            try {
                                gsmCellLocation.setLacAndCid(ndVarA.c, ndVarA.d);
                            } catch (Throwable unused2) {
                                cellLocation = null;
                                gsmCellLocation2 = gsmCellLocation;
                                CellLocation cellLocation3 = cellLocation;
                                gsmCellLocation = gsmCellLocation2;
                                cellLocation2 = cellLocation3;
                            }
                        }
                    } catch (Throwable unused3) {
                        cellLocation = gsmCellLocation2;
                    }
                    CellLocation cellLocation32 = cellLocation;
                    gsmCellLocation = gsmCellLocation2;
                    cellLocation2 = cellLocation32;
                } else {
                    CellInfo cellInfo = (CellInfo) ndVarA.get(i);
                    if (cellInfo != null) {
                        try {
                            boolean zIsRegistered = cellInfo.isRegistered();
                            if (cellInfo instanceof CellInfoCdma) {
                                CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                                if (a(cellInfoCdma.getCellIdentity())) {
                                    ndVarA = a(cellInfoCdma, zIsRegistered);
                                    if (ndVarA == 0) {
                                    }
                                }
                            } else if (cellInfo instanceof CellInfoGsm) {
                                CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                                if (a(cellInfoGsm.getCellIdentity())) {
                                    ndVarA = a(cellInfoGsm, zIsRegistered);
                                    if (ndVarA == 0) {
                                    }
                                }
                            } else if (cellInfo instanceof CellInfoWcdma) {
                                CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                                if (a(cellInfoWcdma.getCellIdentity())) {
                                    ndVarA = a(cellInfoWcdma, zIsRegistered);
                                    if (ndVarA == 0) {
                                    }
                                }
                            } else {
                                if (cellInfo instanceof CellInfoLte) {
                                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                                    if (a(cellInfoLte.getCellIdentity())) {
                                        ndVarA = a(cellInfoLte, zIsRegistered);
                                    }
                                }
                                if (ndVarA == 0) {
                                }
                            }
                        } catch (Throwable unused4) {
                            continue;
                        }
                    } else {
                        continue;
                    }
                    i++;
                    ndVarA = ndVarA;
                }
            }
            if (cellLocation2 == null) {
                return gsmCellLocation;
            }
        }
        return cellLocation2;
    }

    private void b(CellLocation cellLocation, String[] strArr) {
        boolean z;
        GsmCellLocation gsmCellLocation;
        if (cellLocation == null) {
            return;
        }
        this.b.clear();
        if (np.c() < 5) {
            return;
        }
        try {
            boolean z2 = true;
            if (this.q != null) {
                try {
                    Field declaredField = cellLocation.getClass().getDeclaredField("mGsmCellLoc");
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    gsmCellLocation = (GsmCellLocation) declaredField.get(cellLocation);
                } catch (Throwable unused) {
                }
                if (gsmCellLocation == null || !b(gsmCellLocation)) {
                    z = false;
                } else {
                    a(gsmCellLocation, strArr);
                    z = true;
                }
                if (z) {
                    return;
                }
            }
            if (b(cellLocation)) {
                this.f3029a = 2;
                nd ndVar = new nd(2, true);
                ndVar.f3028a = Integer.parseInt(strArr[0]);
                ndVar.b = Integer.parseInt(strArr[1]);
                ndVar.g = nn.b(cellLocation, "getSystemId", new Object[0]);
                ndVar.h = nn.b(cellLocation, "getNetworkId", new Object[0]);
                ndVar.i = nn.b(cellLocation, "getBaseStationId", new Object[0]);
                ndVar.j = this.o;
                ndVar.e = nn.b(cellLocation, "getBaseStationLatitude", new Object[0]);
                int iB = nn.b(cellLocation, "getBaseStationLongitude", new Object[0]);
                ndVar.f = iB;
                int i = ndVar.e;
                if (i != iB || i <= 0) {
                    z2 = false;
                }
                if (i < 0 || iB < 0 || i == Integer.MAX_VALUE || iB == Integer.MAX_VALUE || z2) {
                    ndVar.e = 0;
                    ndVar.f = 0;
                }
                if (this.b.contains(ndVar)) {
                    return;
                }
                this.b.add(ndVar);
            }
        } catch (Throwable th) {
            nl.a(th, "CgiManager", "hdlCdmaLocChange");
        }
    }

    private nd c(CellLocation cellLocation, String[] strArr) {
        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
        nd ndVar = new nd(1, true);
        ndVar.f3028a = np.d(strArr[0]);
        ndVar.b = np.d(strArr[1]);
        ndVar.c = gsmCellLocation.getLac();
        ndVar.d = gsmCellLocation.getCid();
        ndVar.j = this.o;
        return ndVar;
    }

    private static nd a(int i, boolean z, int i2, int i3, int i4, int i5, int i6) {
        nd ndVar = new nd(i, z);
        ndVar.f3028a = i2;
        ndVar.b = i3;
        ndVar.c = i4;
        ndVar.d = i5;
        ndVar.j = i6;
        return ndVar;
    }

    private boolean b(CellLocation cellLocation) {
        boolean zA = a(cellLocation);
        if (!zA) {
            this.f3029a = 0;
        }
        return zA;
    }

    @SuppressLint({"NewApi"})
    private nd a(CellInfoCdma cellInfoCdma, boolean z) {
        int i;
        int i2;
        int i3;
        CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
        String[] strArrA = np.a(this.c);
        try {
            i = Integer.parseInt(strArrA[0]);
        } catch (Throwable unused) {
            i = 0;
        }
        try {
            i3 = Integer.parseInt(strArrA[1]);
            i2 = i;
        } catch (Throwable unused2) {
            i2 = i;
            i3 = 0;
        }
        nd ndVarA = a(2, z, i2, i3, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
        ndVarA.g = cellIdentity.getSystemId();
        ndVarA.h = cellIdentity.getNetworkId();
        ndVarA.i = cellIdentity.getBasestationId();
        ndVarA.e = cellIdentity.getLatitude();
        ndVarA.f = cellIdentity.getLongitude();
        return ndVarA;
    }

    private static boolean c(int i) {
        return (i == -1 || i == 0 || i > 65535) ? false : true;
    }

    @SuppressLint({"NewApi"})
    private static nd a(CellInfoGsm cellInfoGsm, boolean z) {
        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        return a(1, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoGsm.getCellSignalStrength().getDbm());
    }

    @SuppressLint({"NewApi"})
    private static nd a(CellInfoLte cellInfoLte, boolean z) {
        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
        nd ndVarA = a(3, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getTac(), cellIdentity.getCi(), cellInfoLte.getCellSignalStrength().getDbm());
        ndVarA.o = cellIdentity.getPci();
        return ndVarA;
    }

    @SuppressLint({"NewApi"})
    private static nd a(CellInfoWcdma cellInfoWcdma, boolean z) {
        CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        nd ndVarA = a(4, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoWcdma.getCellSignalStrength().getDbm());
        ndVarA.o = cellIdentity.getPsc();
        return ndVarA;
    }

    private static nd a(NeighboringCellInfo neighboringCellInfo, String[] strArr) {
        try {
            nd ndVar = new nd(1, false);
            ndVar.f3028a = Integer.parseInt(strArr[0]);
            ndVar.b = Integer.parseInt(strArr[1]);
            ndVar.c = nn.b(neighboringCellInfo, "getLac", new Object[0]);
            ndVar.d = neighboringCellInfo.getCid();
            ndVar.j = np.a(neighboringCellInfo.getRssi());
            return ndVar;
        } catch (Throwable th) {
            nl.a(th, "CgiManager", "getGsm");
            return null;
        }
    }

    public final ArrayList<nd> a() {
        return this.b;
    }

    private void a(CellLocation cellLocation, String[] strArr) {
        nd ndVarA;
        if (cellLocation == null || this.c == null) {
            return;
        }
        this.b.clear();
        if (b(cellLocation)) {
            this.f3029a = 1;
            this.b.add(c(cellLocation, strArr));
            List<NeighboringCellInfo> list = Build.VERSION.SDK_INT <= 28 ? (List) nn.a(this.c, "getNeighboringCellInfo", new Object[0]) : null;
            if (list == null || list.isEmpty()) {
                return;
            }
            for (NeighboringCellInfo neighboringCellInfo : list) {
                if (neighboringCellInfo != null && a(neighboringCellInfo.getLac(), neighboringCellInfo.getCid()) && (ndVarA = a(neighboringCellInfo, strArr)) != null && !this.b.contains(ndVarA)) {
                    this.b.add(ndVarA);
                }
            }
        }
    }

    public static boolean a(int i) {
        return i > 0 && i <= 15;
    }

    private static boolean a(int i, int i2) {
        return (i == -1 || i == 0 || i > 65535 || i2 == -1 || i2 == 0 || i2 == 65535 || i2 >= 268435455) ? false : true;
    }

    @SuppressLint({"NewApi"})
    private static boolean a(CellIdentityCdma cellIdentityCdma) {
        return cellIdentityCdma != null && cellIdentityCdma.getSystemId() > 0 && cellIdentityCdma.getNetworkId() >= 0 && cellIdentityCdma.getBasestationId() >= 0;
    }

    @SuppressLint({"NewApi"})
    private static boolean a(CellIdentityGsm cellIdentityGsm) {
        return cellIdentityGsm != null && c(cellIdentityGsm.getLac()) && d(cellIdentityGsm.getCid());
    }

    @SuppressLint({"NewApi"})
    private static boolean a(CellIdentityLte cellIdentityLte) {
        return cellIdentityLte != null && c(cellIdentityLte.getTac()) && d(cellIdentityLte.getCi());
    }

    @SuppressLint({"NewApi"})
    private static boolean a(CellIdentityWcdma cellIdentityWcdma) {
        return cellIdentityWcdma != null && c(cellIdentityWcdma.getLac()) && d(cellIdentityWcdma.getCid());
    }

    public final boolean a(CellLocation cellLocation) {
        String str;
        boolean z = false;
        if (cellLocation == null) {
            return false;
        }
        int iC = c(cellLocation);
        if (iC == 1) {
            try {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                return a(gsmCellLocation.getLac(), gsmCellLocation.getCid());
            } catch (Throwable th) {
                th = th;
                str = "cgiUseful Cgi.I_GSM_T";
            }
        } else {
            if (iC != 2) {
                return true;
            }
            try {
                if (nn.b(cellLocation, "getSystemId", new Object[0]) > 0 && nn.b(cellLocation, "getNetworkId", new Object[0]) >= 0) {
                    if (nn.b(cellLocation, "getBaseStationId", new Object[0]) >= 0) {
                        z = true;
                    }
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
                str = "cgiUseful Cgi.I_CDMA_T";
            }
        }
        nl.a(th, "CgiManager", str);
        return true;
    }
}
