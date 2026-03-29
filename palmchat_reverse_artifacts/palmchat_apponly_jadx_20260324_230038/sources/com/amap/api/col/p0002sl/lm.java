package com.amap.api.col.p0002sl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.alipay.sdk.m.x.d;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.kuaishou.weapon.p0.g;
import com.ss.android.ttvecamera.TECameraResult;
import defpackage.ch7;
import defpackage.og7;
import defpackage.tg7;
import defpackage.ug7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@SuppressLint({"NewApi"})
public final class lm {
    TelephonyManager b;
    SignalStrength d;
    private Context h;
    private lk m;

    @SuppressLint({"NewApi"})
    private TelephonyManager.CellInfoCallback q;
    private ld x;
    private boolean i = false;
    private boolean j = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<ll> f2971a = new ArrayList<>();
    private String k = null;
    private ArrayList<ll> l = new ArrayList<>();
    private long n = 0;
    PhoneStateListener c = null;
    private boolean o = false;
    private Object p = new Object();
    private boolean r = false;
    boolean e = false;
    StringBuilder f = null;
    private String s = null;
    private String t = null;
    String g = null;
    private volatile boolean u = true;
    private volatile boolean v = true;
    private volatile boolean w = false;

    /* JADX INFO: compiled from: SearchBox */
    @SuppressLint({"NewApi"})
    public class a extends TelephonyManager.CellInfoCallback {
        public a() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public final void onCellInfo(List<CellInfo> list) {
            try {
                mg.a();
                StringBuilder sb = new StringBuilder("noLocReqCgiEnable:");
                sb.append(lm.this.v);
                sb.append(" isStartLocation:");
                sb.append(lm.this.u);
                mg.a();
                if ((lm.this.v || lm.this.u) && mm.b() - lm.this.n >= 500) {
                    lm.d(lm.this);
                    lm.this.a(lm.this.v());
                    lm.this.a(list);
                    lm.this.n = mm.b();
                }
            } catch (SecurityException e) {
                lm.this.g = e.getMessage();
            } catch (Throwable th) {
                me.a(th, "Cgi", "cellInfo");
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends PhoneStateListener {
        public b() {
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellInfoChanged(List<CellInfo> list) {
            try {
                mg.a();
                StringBuilder sb = new StringBuilder("noLocReqCgiEnable:");
                sb.append(lm.this.v);
                sb.append(" isStartLocation:");
                sb.append(lm.this.u);
                mg.a();
                if (lm.this.v || lm.this.u) {
                    if (lm.this.x != null) {
                        lm.this.x.c();
                    }
                    if (mm.b() - lm.this.n < 500) {
                        return;
                    }
                    lm.this.a(lm.this.v());
                    lm.this.a(list);
                    lm.this.n = mm.b();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellLocationChanged(CellLocation cellLocation) {
            mg.a();
            StringBuilder sb = new StringBuilder("noLocReqCgiEnable:");
            sb.append(lm.this.v);
            sb.append(" isStartLocation:");
            sb.append(lm.this.u);
            mg.a();
            if ((lm.this.v || lm.this.u) && mm.b() - lm.this.n >= 500) {
                try {
                    lm.this.a(cellLocation);
                    lm.this.a(lm.this.w());
                    lm.this.n = mm.b();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onDataConnectionStateChanged(int i) {
            super.onDataConnectionStateChanged(i);
            mg.a();
        }

        @Override // android.telephony.PhoneStateListener
        public final void onServiceStateChanged(ServiceState serviceState) {
            try {
                mg.a();
                StringBuilder sb = new StringBuilder("noLocReqCgiEnable:");
                sb.append(lm.this.v);
                sb.append(" isStartLocation:");
                sb.append(lm.this.u);
                mg.a();
                if (lm.this.v || lm.this.u) {
                    int state = serviceState.getState();
                    if (state == 0) {
                        lm.this.a(false, false);
                    } else {
                        if (state != 1) {
                            return;
                        }
                        lm.this.j();
                    }
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthChanged(int i) {
            super.onSignalStrengthChanged(i);
            mg.a();
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
            mg.a();
            StringBuilder sb = new StringBuilder("noLocReqCgiEnable:");
            sb.append(lm.this.v);
            sb.append(" isStartLocation:");
            sb.append(lm.this.u);
            mg.a();
            if (signalStrength == null) {
                return;
            }
            lm lmVar = lm.this;
            lmVar.d = signalStrength;
            if (lmVar.v || lm.this.u) {
                try {
                    if (lm.this.x != null) {
                        lm.this.x.c();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public lm(Context context, Handler handler) {
        this.b = null;
        this.m = null;
        mg.a();
        this.h = context;
        if (this.b == null) {
            this.b = (TelephonyManager) mm.a(context, "phone");
        }
        o();
        lk lkVar = new lk(context, "cellAge", handler);
        this.m = lkVar;
        lkVar.a();
    }

    public static boolean a(int i) {
        return i > 0 && i <= 15;
    }

    private static int b(int i) {
        return (i * 2) + TECameraResult.TER_CLOSE_CALLED;
    }

    public static /* synthetic */ boolean d(lm lmVar) {
        lmVar.r = true;
        return true;
    }

    private void o() {
        if (this.b == null) {
            return;
        }
        p();
    }

    private void p() {
        try {
            if (this.c == null) {
                this.c = new b();
            }
            int i = Build.VERSION.SDK_INT;
            String str = "hasFineLocPerm";
            int i2 = MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME;
            if (i < 31) {
                mg.b();
            } else if (this.h.checkSelfPermission(g.g) == 0) {
                this.t = "hasFineLocPerm";
                mg.b();
            } else {
                this.t = "hasNoFineLocPerm";
                mg.b();
                i2 = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
            }
            if (i >= 31) {
                boolean z = this.h.checkSelfPermission(g.c) == 0;
                boolean z2 = this.h.checkSelfPermission(g.g) == 0;
                if (z && z2) {
                    i2 |= 1024;
                }
                mg.b();
                this.s = z ? "hasReadPhoneStatePerm" : "hasNoReadPhoneStatePerm";
                if (!z2) {
                    str = "hasNoFineLocPerm";
                }
                this.t = str;
                mg.b();
            } else {
                mg.b();
                i2 |= 1024;
            }
            PhoneStateListener phoneStateListener = this.c;
            if (phoneStateListener != null) {
                this.b.listen(phoneStateListener, i2);
                this.w = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int q() {
        ll llVarE = e();
        if (llVarE != null) {
            return llVarE.l;
        }
        return 0;
    }

    private CellLocation r() {
        TelephonyManager telephonyManager = this.b;
        if (telephonyManager != null) {
            try {
                CellLocation cellLocation = telephonyManager.getCellLocation();
                mg.a();
                this.g = null;
                return cellLocation;
            } catch (SecurityException e) {
                this.g = e.getMessage();
            } catch (Throwable th) {
                this.g = null;
                me.a(th, "CgiManager", "getCellLocation");
            }
        }
        return null;
    }

    private List<CellInfo> s() {
        TelephonyManager telephonyManager = this.b;
        if (telephonyManager == null) {
            return null;
        }
        List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
        mg.a();
        return allCellInfo;
    }

    private boolean t() {
        return !this.e && mm.b() - this.n >= 45000;
    }

    private void u() {
        PhoneStateListener phoneStateListener;
        TelephonyManager telephonyManager = this.b;
        if (telephonyManager != null && (phoneStateListener = this.c) != null) {
            try {
                telephonyManager.listen(phoneStateListener, 0);
                this.w = false;
            } catch (Throwable th) {
                me.a(th, "CgiManager", "destroy");
            }
        }
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellLocation v() {
        if (this.b == null) {
            return null;
        }
        return r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public List<CellInfo> w() {
        List<CellInfo> listS;
        try {
            if (mm.c() < 18 || this.b == null) {
                return null;
            }
            try {
                listS = s();
                try {
                    this.g = null;
                } catch (SecurityException e) {
                    e = e;
                    this.g = e.getMessage();
                }
            } catch (SecurityException e2) {
                e = e2;
                listS = null;
            }
            return listS;
        } catch (Throwable th) {
            me.a(th, "Cgi", "getNewCells");
            return null;
        }
    }

    public final int h() {
        return q() & 3;
    }

    public final TelephonyManager i() {
        return this.b;
    }

    public final synchronized void j() {
        this.g = null;
        this.f2971a.clear();
        this.l.clear();
        this.i = false;
        this.j = false;
    }

    public final String k() {
        return this.g;
    }

    public final String l() {
        return this.k;
    }

    public final synchronized String m() {
        if (this.e) {
            j();
        }
        StringBuilder sb = this.f;
        if (sb == null) {
            this.f = new StringBuilder();
        } else {
            sb.delete(0, sb.length());
        }
        if (h() == 1) {
            for (int i = 1; i < this.f2971a.size(); i++) {
                StringBuilder sb2 = this.f;
                sb2.append("#");
                sb2.append(this.f2971a.get(i).b);
                StringBuilder sb3 = this.f;
                sb3.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                sb3.append(this.f2971a.get(i).c);
                StringBuilder sb4 = this.f;
                sb4.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                sb4.append(this.f2971a.get(i).d);
            }
        }
        for (int i2 = 1; i2 < this.l.size(); i2++) {
            ll llVar = this.l.get(i2);
            int i3 = llVar.l;
            if (i3 == 1 || i3 == 3 || i3 == 4 || i3 == 5) {
                StringBuilder sb5 = this.f;
                sb5.append("#");
                sb5.append(llVar.l);
                StringBuilder sb6 = this.f;
                sb6.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                sb6.append(llVar.f2970a);
                StringBuilder sb7 = this.f;
                sb7.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                sb7.append(llVar.b);
                StringBuilder sb8 = this.f;
                sb8.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                sb8.append(llVar.c);
                StringBuilder sb9 = this.f;
                sb9.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                sb9.append(llVar.a());
            } else if (i3 == 2) {
                StringBuilder sb10 = this.f;
                sb10.append("#");
                sb10.append(llVar.l);
                StringBuilder sb11 = this.f;
                sb11.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                sb11.append(llVar.f2970a);
                StringBuilder sb12 = this.f;
                sb12.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                sb12.append(llVar.h);
                StringBuilder sb13 = this.f;
                sb13.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                sb13.append(llVar.i);
                StringBuilder sb14 = this.f;
                sb14.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                sb14.append(llVar.j);
            }
        }
        if (this.f.length() > 0) {
            this.f.deleteCharAt(0);
        }
        return this.f.toString();
    }

    public final boolean n() {
        try {
            TelephonyManager telephonyManager = this.b;
            if (telephonyManager != null) {
                if (!TextUtils.isEmpty(telephonyManager.getSimOperator())) {
                    return true;
                }
                if (!TextUtils.isEmpty(this.b.getSimCountryIso())) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            int iA = mm.a(mm.c(this.h));
            return iA == 0 || iA == 4 || iA == 2 || iA == 5 || iA == 3;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public final synchronized ArrayList<ll> c() {
        ArrayList<ll> arrayList;
        arrayList = new ArrayList<>();
        ArrayList<ll> arrayList2 = this.f2971a;
        if (arrayList2 != null) {
            Iterator<ll> it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().clone());
            }
        }
        return arrayList;
    }

    public final synchronized ArrayList<ll> d() {
        ArrayList<ll> arrayList;
        arrayList = new ArrayList<>();
        ArrayList<ll> arrayList2 = this.l;
        if (arrayList2 != null) {
            Iterator<ll> it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().clone());
            }
        }
        return arrayList;
    }

    public final synchronized ll e() {
        if (this.e) {
            return null;
        }
        ArrayList<ll> arrayList = this.f2971a;
        if (arrayList.size() <= 0) {
            return null;
        }
        return arrayList.get(0).clone();
    }

    public final synchronized ll f() {
        if (this.e) {
            return null;
        }
        ArrayList<ll> arrayList = this.l;
        if (arrayList.size() <= 0) {
            return null;
        }
        for (ll llVar : arrayList) {
            if (llVar.n) {
                return llVar.clone();
            }
        }
        return arrayList.get(0).clone();
    }

    public final int g() {
        return q() | (this.i ? 4 : 0) | (this.j ? 8 : 0);
    }

    public final void b() {
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                String str = this.h.checkSelfPermission(g.g) == 0 ? "hasFineLocPerm" : "hasNoFineLocPerm";
                String str2 = this.h.checkSelfPermission(g.c) == 0 ? "hasReadPhoneStatePerm" : "hasNoReadPhoneStatePerm";
                boolean z = true;
                boolean z2 = (TextUtils.isEmpty(this.t) || this.t.equals(str)) ? false : true;
                if (TextUtils.isEmpty(this.s) || this.s.equals(str2)) {
                    z = z2;
                }
                if (z) {
                    mg.b();
                    p();
                }
            }
        } catch (Throwable unused) {
            mg.b();
        }
    }

    public final List<kk> a() {
        ArrayList arrayList = new ArrayList();
        List<CellInfo> listS = s();
        if (listS != null) {
            for (CellInfo cellInfo : listS) {
                if (cellInfo instanceof CellInfoCdma) {
                    CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                    CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
                    kl klVar = new kl(cellInfo.isRegistered(), true);
                    klVar.m = cellIdentity.getLatitude();
                    klVar.n = cellIdentity.getLongitude();
                    klVar.j = cellIdentity.getSystemId();
                    klVar.k = cellIdentity.getNetworkId();
                    klVar.l = cellIdentity.getBasestationId();
                    klVar.d = cellInfoCdma.getCellSignalStrength().getAsuLevel();
                    klVar.c = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                    arrayList.add(klVar);
                } else if (cellInfo instanceof CellInfoGsm) {
                    CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                    CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                    km kmVar = new km(cellInfo.isRegistered(), true);
                    kmVar.f2944a = String.valueOf(cellIdentity2.getMcc());
                    kmVar.b = String.valueOf(cellIdentity2.getMnc());
                    kmVar.j = cellIdentity2.getLac();
                    kmVar.k = cellIdentity2.getCid();
                    kmVar.c = cellInfoGsm.getCellSignalStrength().getDbm();
                    kmVar.d = cellInfoGsm.getCellSignalStrength().getAsuLevel();
                    if (Build.VERSION.SDK_INT >= 24) {
                        kmVar.m = cellIdentity2.getArfcn();
                        kmVar.n = cellIdentity2.getBsic();
                    }
                    arrayList.add(kmVar);
                } else if (cellInfo instanceof CellInfoLte) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                    kn knVar = new kn(cellInfo.isRegistered());
                    knVar.f2944a = String.valueOf(cellIdentity3.getMcc());
                    knVar.b = String.valueOf(cellIdentity3.getMnc());
                    knVar.l = cellIdentity3.getPci();
                    knVar.d = cellInfoLte.getCellSignalStrength().getAsuLevel();
                    knVar.k = cellIdentity3.getCi();
                    knVar.j = cellIdentity3.getTac();
                    knVar.n = cellInfoLte.getCellSignalStrength().getTimingAdvance();
                    knVar.c = cellInfoLte.getCellSignalStrength().getDbm();
                    if (Build.VERSION.SDK_INT >= 24) {
                        knVar.m = cellIdentity3.getEarfcn();
                    }
                    arrayList.add(knVar);
                } else {
                    int i = Build.VERSION.SDK_INT;
                    if (cellInfo instanceof CellInfoWcdma) {
                        CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                        CellIdentityWcdma cellIdentity4 = cellInfoWcdma.getCellIdentity();
                        ko koVar = new ko(cellInfo.isRegistered(), true);
                        koVar.f2944a = String.valueOf(cellIdentity4.getMcc());
                        koVar.b = String.valueOf(cellIdentity4.getMnc());
                        koVar.j = cellIdentity4.getLac();
                        koVar.k = cellIdentity4.getCid();
                        koVar.l = cellIdentity4.getPsc();
                        koVar.d = cellInfoWcdma.getCellSignalStrength().getAsuLevel();
                        koVar.c = cellInfoWcdma.getCellSignalStrength().getDbm();
                        if (i >= 24) {
                            koVar.m = cellIdentity4.getUarfcn();
                        }
                        arrayList.add(koVar);
                    }
                }
            }
        }
        return arrayList;
    }

    public final void c(boolean z) {
        this.v = z;
    }

    public final void b(boolean z) {
        this.u = z;
        if (this.v) {
            return;
        }
        if (z && !this.w) {
            p();
        } else {
            if (z || !this.w) {
                return;
            }
            u();
        }
    }

    @SuppressLint({"NewApi"})
    private void b(boolean z, boolean z2) {
        if (!this.e && this.b != null && Build.VERSION.SDK_INT >= 29 && this.h.getApplicationInfo().targetSdkVersion >= 29) {
            if (this.q == null) {
                this.q = new a();
            }
            try {
                this.b.requestCellInfoUpdate(jc.a().b(), this.q);
            } catch (Throwable th) {
                me.a(th, "Cgi", "refreshCgi");
            }
            if (z2 || z) {
                for (int i = 0; !this.r && i < 20; i++) {
                    try {
                        Thread.sleep(5L);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        this.j = false;
        TelephonyManager telephonyManager = this.b;
        if (telephonyManager != null) {
            String networkOperator = telephonyManager.getNetworkOperator();
            this.k = networkOperator;
            if (!TextUtils.isEmpty(networkOperator)) {
                this.j = true;
            }
        }
        this.n = mm.b();
    }

    public final void a(boolean z, boolean z2) {
        try {
            this.e = mm.a(this.h);
            if (t()) {
                b(z, z2);
                a(v());
                a(w());
            }
            if (this.e) {
                j();
            }
        } catch (SecurityException e) {
            this.g = e.getMessage();
        } catch (Throwable th) {
            me.a(th, "CgiManager", d.w);
        }
    }

    public final void a(boolean z) {
        this.m.a(z);
        this.n = 0L;
        synchronized (this.p) {
            this.o = true;
        }
        u();
        this.d = null;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(CellLocation cellLocation) {
        String[] strArrA = mm.a(this.b);
        this.f2971a.clear();
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            ll llVar = new ll(1, true);
            llVar.f2970a = mm.e(strArrA[0]);
            llVar.b = mm.e(strArrA[1]);
            llVar.c = gsmCellLocation.getLac();
            llVar.d = gsmCellLocation.getCid();
            SignalStrength signalStrength = this.d;
            if (signalStrength != null) {
                int gsmSignalStrength = signalStrength.getGsmSignalStrength();
                llVar.s = gsmSignalStrength == 99 ? Integer.MAX_VALUE : b(gsmSignalStrength);
            }
            llVar.r = false;
            this.m.a(llVar);
            this.f2971a.add(llVar);
            return;
        }
        if (cellLocation instanceof CdmaCellLocation) {
            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
            ll llVar2 = new ll(2, true);
            llVar2.f2970a = Integer.parseInt(strArrA[0]);
            llVar2.b = Integer.parseInt(strArrA[1]);
            llVar2.f = cdmaCellLocation.getBaseStationLatitude();
            llVar2.g = cdmaCellLocation.getBaseStationLongitude();
            llVar2.h = cdmaCellLocation.getSystemId();
            llVar2.i = cdmaCellLocation.getNetworkId();
            llVar2.j = cdmaCellLocation.getBaseStationId();
            SignalStrength signalStrength2 = this.d;
            if (signalStrength2 != null) {
                llVar2.s = signalStrength2.getCdmaDbm();
            }
            llVar2.r = false;
            this.m.a(llVar2);
            this.f2971a.add(llVar2);
        }
    }

    public final synchronized void a(List<CellInfo> list) {
        ll llVarA;
        ArrayList<ll> arrayList = this.l;
        if (arrayList != null) {
            arrayList.clear();
        }
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                CellInfo cellInfo = list.get(i);
                if (cellInfo != null) {
                    boolean zIsRegistered = cellInfo.isRegistered();
                    if (cellInfo instanceof CellInfoCdma) {
                        llVarA = a((CellInfoCdma) cellInfo, zIsRegistered);
                    } else if (cellInfo instanceof CellInfoGsm) {
                        llVarA = a((CellInfoGsm) cellInfo, zIsRegistered);
                    } else if (cellInfo instanceof CellInfoWcdma) {
                        llVarA = a((CellInfoWcdma) cellInfo, zIsRegistered);
                    } else if (cellInfo instanceof CellInfoLte) {
                        llVarA = a((CellInfoLte) cellInfo, zIsRegistered);
                    } else {
                        llVarA = (Build.VERSION.SDK_INT < 29 || !tg7.a(cellInfo)) ? null : a(ug7.a(cellInfo), zIsRegistered);
                    }
                    if (llVarA != null) {
                        this.m.a(llVarA);
                        llVarA.m = (short) Math.min(WebSocketProtocol.PAYLOAD_SHORT_MAX, this.m.e(llVarA));
                        llVarA.r = true;
                        this.l.add(llVarA);
                    }
                }
            }
            this.i = false;
            ArrayList<ll> arrayList2 = this.l;
            if (arrayList2 != null && arrayList2.size() > 0) {
                this.i = true;
            }
        }
    }

    @SuppressLint({"NewApi"})
    private static ll a(CellInfoGsm cellInfoGsm, boolean z) {
        if (cellInfoGsm == null || cellInfoGsm.getCellIdentity() == null) {
            return null;
        }
        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        ll llVarA = a(1, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoGsm.getCellSignalStrength().getDbm());
        llVarA.o = cellInfoGsm.getCellIdentity().getBsic();
        llVarA.p = cellInfoGsm.getCellIdentity().getArfcn();
        llVarA.q = cellInfoGsm.getCellSignalStrength().getTimingAdvance();
        llVarA.s = cellInfoGsm.getCellSignalStrength().getDbm();
        return llVarA;
    }

    private static ll a(CellInfoWcdma cellInfoWcdma, boolean z) {
        if (cellInfoWcdma == null || cellInfoWcdma.getCellIdentity() == null) {
            return null;
        }
        CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        ll llVarA = a(4, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoWcdma.getCellSignalStrength().getDbm());
        llVarA.o = cellIdentity.getPsc();
        llVarA.p = cellInfoWcdma.getCellIdentity().getUarfcn();
        llVarA.s = cellInfoWcdma.getCellSignalStrength().getDbm();
        return llVarA;
    }

    private static ll a(CellInfoLte cellInfoLte, boolean z) {
        if (cellInfoLte == null || cellInfoLte.getCellIdentity() == null) {
            return null;
        }
        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
        ll llVarA = a(3, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getTac(), cellIdentity.getCi(), cellInfoLte.getCellSignalStrength().getDbm());
        llVarA.o = cellIdentity.getPci();
        if (Build.VERSION.SDK_INT >= 24) {
            llVarA.p = cellIdentity.getEarfcn();
        }
        llVarA.q = cellInfoLte.getCellSignalStrength().getTimingAdvance();
        llVarA.s = cellInfoLte.getCellSignalStrength().getDbm();
        return llVarA;
    }

    private static ll a(CellInfoNr cellInfoNr, boolean z) {
        int i;
        int i2;
        int i3;
        if (cellInfoNr == null || cellInfoNr.getCellIdentity() == null) {
            return null;
        }
        CellIdentityNr cellIdentityNrA = ch7.a(cellInfoNr.getCellIdentity());
        int tac = cellIdentityNrA.getTac();
        if (tac == Integer.MAX_VALUE && "HUAWEI".equals(Build.MANUFACTURER)) {
            try {
                tac = mi.b(cellIdentityNrA, "getHwTac", new Object[0]);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        long nci = cellIdentityNrA.getNci();
        try {
            i = Integer.parseInt(cellIdentityNrA.getMccString());
            try {
                i2 = i;
                i3 = Integer.parseInt(cellIdentityNrA.getMncString());
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                i2 = i;
                i3 = 0;
            }
        } catch (Throwable th3) {
            th = th3;
            i = 0;
        }
        ll llVarA = a(5, z, i2, i3, cellIdentityNrA.getTac(), 0, og7.a(cellInfoNr.getCellSignalStrength()).getSsRsrp());
        llVarA.e = nci;
        if (tac > 16777215) {
            llVarA.c = 65535;
        } else if (tac > 65535) {
            llVarA.c = 65535;
            llVarA.q = tac;
        } else {
            llVarA.c = tac;
        }
        llVarA.o = cellIdentityNrA.getPci();
        llVarA.p = cellIdentityNrA.getNrarfcn();
        llVarA.s = cellInfoNr.getCellSignalStrength().getDbm();
        return llVarA;
    }

    private ll a(CellInfoCdma cellInfoCdma, boolean z) {
        int i;
        int i2;
        int i3;
        if (cellInfoCdma != null && cellInfoCdma.getCellIdentity() != null) {
            CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
            if (cellIdentity.getSystemId() > 0 && cellIdentity.getNetworkId() >= 0 && cellIdentity.getBasestationId() >= 0) {
                CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                String[] strArrA = mm.a(this.b);
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
                ll llVarA = a(2, z, i2, i3, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                llVarA.h = cellIdentity2.getSystemId();
                llVarA.i = cellIdentity2.getNetworkId();
                llVarA.j = cellIdentity2.getBasestationId();
                llVarA.f = cellIdentity2.getLatitude();
                llVarA.g = cellIdentity2.getLongitude();
                llVarA.s = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                return llVarA;
            }
        }
        return null;
    }

    private static ll a(int i, boolean z, int i2, int i3, int i4, int i5, int i6) {
        ll llVar = new ll(i, z);
        llVar.f2970a = i2;
        llVar.b = i3;
        llVar.c = i4;
        llVar.d = i5;
        llVar.k = i6;
        return llVar;
    }

    public final void a(ld ldVar) {
        this.x = ldVar;
    }
}
