package com.baidu.location.c.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityTdscdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthNr;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import com.baidu.location.c.g;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.openalliance.ad.constant.x;
import defpackage.ch7;
import defpackage.ht6;
import defpackage.og7;
import defpackage.qr6;
import defpackage.tg7;
import defpackage.ts6;
import defpackage.ug7;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a implements com.baidu.location.c.b.a {
    public static int b;
    private static Class<?> w;
    private C0063a t;
    private b u;
    private c v;
    private Context x;
    private int e = 30;
    private int f = -1;
    private AtomicInteger g = new AtomicInteger(0);
    private float h = 0.2f;
    private boolean i = true;
    private boolean j = false;
    private TelephonyManager k = null;
    private TelephonyManager l = null;
    private TelephonyManager m = null;
    private SubscriptionManager n = null;
    private com.baidu.location.c.a o = new com.baidu.location.c.a();
    private com.baidu.location.c.a p = null;
    private List<com.baidu.location.c.a> q = null;
    private Executor r = null;
    private d s = null;
    private boolean y = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3472a = 0;
    private boolean z = false;
    private long A = 0;
    private long B = 0;
    private boolean C = false;
    private boolean D = true;
    private boolean E = false;
    private Handler F = null;
    private int G = -1;
    private int H = -1;
    private final Object I = new Object();
    private long J = 0;
    private List<com.baidu.location.c.a> K = null;
    private List<CellInfo> L = null;
    private AtomicInteger M = new AtomicInteger(1000);

    /* JADX INFO: renamed from: com.baidu.location.c.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0063a extends TelephonyManager.CellInfoCallback {
        private C0063a() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onCellInfo(List<CellInfo> list) {
            if (list == null) {
                return;
            }
            if (!com.baidu.location.c.b.a.d || g.i().a(list)) {
                a.this.j();
            }
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onError(int i, Throwable th) {
            if (th != null) {
                th.printStackTrace();
            }
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                g.i().a("cell onError = " + i);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends TelephonyManager.CellInfoCallback {
        private b() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onCellInfo(List<CellInfo> list) {
            boolean z = com.baidu.location.c.b.a.c;
            if (z && com.baidu.location.c.b.a.d) {
                g.i().a("onCellInfo");
            }
            if (list == null) {
                return;
            }
            boolean z2 = com.baidu.location.c.b.a.d;
            if (!z2 || g.i().a(list)) {
                if (z && z2) {
                    g.i().a("request sim1 cellInfo");
                }
                if (a.this.C) {
                    a.this.D = !r4.D;
                }
                if (!a.this.C || a.this.D) {
                    a.this.j();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends TelephonyManager.CellInfoCallback {
        private c() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onCellInfo(List<CellInfo> list) {
            if (list == null) {
                return;
            }
            boolean z = com.baidu.location.c.b.a.d;
            if (!z || g.i().a(list)) {
                if (com.baidu.location.c.b.a.c && z) {
                    g.i().a("request sim2 cellInfo");
                }
                if (a.this.C) {
                    a.this.D = !r3.D;
                }
                if (!a.this.C || a.this.D) {
                    a.this.j();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends PhoneStateListener {
        public d() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellInfoChanged(List<CellInfo> list) {
            if (list == null) {
                return;
            }
            a.this.F.post(new Runnable() { // from class: com.baidu.location.c.a.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                            g.i().a("cell received cellinfo change");
                        }
                        a.this.g();
                    } catch (Exception e) {
                        if (com.baidu.location.c.b.a.c) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            com.baidu.location.c.a aVar;
            int cdmaDbm;
            if (a.this.o != null) {
                if (a.this.o.i != 'g') {
                    if (a.this.o.i == 'c') {
                        aVar = a.this.o;
                        cdmaDbm = signalStrength.getCdmaDbm();
                    }
                    if (com.baidu.location.c.b.a.c || !com.baidu.location.c.b.a.d) {
                    }
                    g.i().a("cell strength===== cell singal strength changed : " + a.this.o.h);
                    return;
                }
                aVar = a.this.o;
                cdmaDbm = signalStrength.getGsmSignalStrength();
                aVar.h = cdmaDbm;
                if (com.baidu.location.c.b.a.c) {
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f3479a = new a();
    }

    private static int a(CellIdentityNr cellIdentityNr) {
        try {
            int iA = com.baidu.location.c.b.b.a(cellIdentityNr, "getHwTac");
            if (!com.baidu.location.c.b.a.c || !com.baidu.location.c.b.a.d) {
                return iA;
            }
            g.i().a(" get hw tac = " + iA);
            return iA;
        } catch (Throwable th) {
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                g.i().a(" get hw tac exception !" + th);
            }
            return -1;
        }
    }

    private static int b(String str) {
        if (str == null || !str.contains("mNrTac")) {
            return -1;
        }
        Matcher matcher = Pattern.compile("mNrTac=(.+?)\\}").matcher(str.replace(" ", ""));
        while (true) {
            int i = -1;
            while (matcher.find()) {
                if (matcher.groupCount() >= 1) {
                    String strGroup = matcher.group(1);
                    if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                        g.i().a(" pasrse mnrtac = " + strGroup);
                    }
                    try {
                        i = Integer.parseInt(strGroup);
                    } catch (Throwable th) {
                        if (com.baidu.location.c.b.a.c) {
                            th.printStackTrace();
                        }
                    }
                }
            }
            return i;
        }
    }

    private static int e(int i) {
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i;
    }

    private void h() {
        char c2;
        long j;
        com.baidu.location.c.e eVarI;
        String str;
        String strA = com.baidu.location.c.b.b.a(this.x);
        if (strA == null) {
            return;
        }
        File file = new File(strA + File.separator + "lcvif2.dat");
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(0L);
                long j2 = randomAccessFile.readLong();
                if (System.currentTimeMillis() - j2 > 60000) {
                    if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                        g.i().a("cellbuffer System.currentTimeMillis() - time > 1 *60 *1000" + j2);
                    }
                    randomAccessFile.close();
                    file.delete();
                    return;
                }
                randomAccessFile.readInt();
                for (int i = 0; i < 3; i++) {
                    long j3 = randomAccessFile.readLong();
                    int i2 = randomAccessFile.readInt();
                    int i3 = randomAccessFile.readInt();
                    int i4 = randomAccessFile.readInt();
                    long j4 = randomAccessFile.readLong();
                    int i5 = randomAccessFile.readInt();
                    boolean z = com.baidu.location.c.b.a.c;
                    if (z && com.baidu.location.c.b.a.d) {
                        g.i().a("cellbuffer cell info = " + j3 + " " + i2 + " " + i3 + " " + i4 + " " + j4 + " " + i5);
                    }
                    char c3 = i5 == 1 ? 'g' : (char) 0;
                    if (i5 == 2) {
                        j = 0;
                        c2 = 'c';
                    } else {
                        c2 = c3;
                        j = 0;
                    }
                    if (j3 != j) {
                        com.baidu.location.c.a aVar = new com.baidu.location.c.a(i4, j4, i2, i3, 0, c2, -1);
                        aVar.g = j3;
                        if (aVar.b()) {
                            this.E = true;
                            this.q.add(aVar);
                        }
                        if (z && com.baidu.location.c.b.a.d) {
                            eVarI = g.i();
                            str = "loc cell " + b(aVar);
                            eVarI.a(str);
                        }
                    } else if (z && com.baidu.location.c.b.a.d) {
                        eVarI = g.i();
                        str = "loc cell time1 == 0";
                        eVarI.a(str);
                    }
                }
                randomAccessFile.close();
            } catch (Exception e2) {
                if (com.baidu.location.c.b.a.c) {
                    e2.printStackTrace();
                }
                file.delete();
            }
        }
    }

    private void i() {
        List<com.baidu.location.c.a> list = this.q;
        if (list == null && this.p == null) {
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                g.i().a("cellbuffer mTrackList == null");
                return;
            }
            return;
        }
        if (list == null && this.p != null) {
            LinkedList linkedList = new LinkedList();
            this.q = linkedList;
            linkedList.add(this.p);
        }
        String strA = com.baidu.location.c.b.b.a(this.x);
        if (strA == null || this.q == null) {
            return;
        }
        File file = new File(strA + File.separator + "lcvif2.dat");
        int size = this.q.size();
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeLong(this.q.get(size - 1).g);
            randomAccessFile.writeInt(size);
            for (int i = 0; i < 3 - size; i++) {
                randomAccessFile.writeLong(0L);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeLong(-1L);
                randomAccessFile.writeInt(2);
            }
            for (int i2 = 0; i2 < size; i2++) {
                randomAccessFile.writeLong(this.q.get(i2).g);
                randomAccessFile.writeInt(this.q.get(i2).c);
                randomAccessFile.writeInt(this.q.get(i2).d);
                randomAccessFile.writeInt(this.q.get(i2).f3471a);
                randomAccessFile.writeLong(this.q.get(i2).b);
                if (this.q.get(i2).i == 'g') {
                    randomAccessFile.writeInt(1);
                } else if (this.q.get(i2).i == 'c') {
                    randomAccessFile.writeInt(2);
                } else {
                    randomAccessFile.writeInt(3);
                }
            }
            randomAccessFile.close();
        } catch (Exception e2) {
            if (com.baidu.location.c.b.a.c) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.F.post(new Runnable() { // from class: com.baidu.location.c.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.g();
                    synchronized (a.this.I) {
                        a.this.I.notifyAll();
                        if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                            g.i().a("update mCellInfo completed");
                        }
                    }
                } catch (Exception e2) {
                    if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                        g.i().a("handleCellInfo error = " + e2);
                    }
                }
            }
        });
    }

    public HashSet<String> c(com.baidu.location.c.a aVar) {
        StringBuilder sb;
        HashSet<String> hashSet = new HashSet<>();
        try {
            List<com.baidu.location.c.a> listA = a(this.k, this.o);
            if (listA != null && !listA.isEmpty()) {
                for (com.baidu.location.c.a aVar2 : listA) {
                    if (!aVar2.k) {
                        int i = aVar2.f3471a;
                        String string = "";
                        if (i != -1 && aVar2.b != -1) {
                            if (aVar.f3471a != i) {
                                sb = new StringBuilder();
                                sb.append(aVar2.f3471a);
                                sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                                sb.append(aVar2.b);
                            } else {
                                sb = new StringBuilder();
                                sb.append(aVar2.b);
                                sb.append("");
                            }
                            string = sb.toString();
                        }
                        hashSet.add(string);
                    }
                }
            } else if (com.baidu.location.c.b.a.c) {
                Log.d("getAllCellInfo", "=null");
            }
        } catch (Exception | NoSuchMethodError e2) {
            e2.printStackTrace();
        }
        return hashSet;
    }

    public com.baidu.location.c.a d(int i) {
        com.baidu.location.c.a aVar;
        if (this.k != null) {
            try {
                g();
                boolean z = com.baidu.location.c.b.a.c;
                if (z && com.baidu.location.c.b.a.d) {
                    g.i().a(" lastDiffTime = " + this.B + ", diffTime = " + i);
                }
                if (Build.VERSION.SDK_INT >= 29 && this.z) {
                    if (i < Integer.MAX_VALUE) {
                        long j = i;
                        if (j == this.B) {
                            if (System.currentTimeMillis() - this.A > j) {
                                if (z && com.baidu.location.c.b.a.d) {
                                    g.i().a(" over diff time");
                                }
                            }
                        } else if (z && com.baidu.location.c.b.a.d) {
                            g.i().a("diff time is changed");
                        }
                        e();
                    }
                    this.B = i;
                }
            } catch (Exception e2) {
                if (com.baidu.location.c.b.a.c) {
                    e2.printStackTrace();
                }
            }
        }
        com.baidu.location.c.a aVar2 = this.o;
        if (aVar2 != null && aVar2.e()) {
            this.p = null;
            this.p = new com.baidu.location.c.a(this.o);
        }
        com.baidu.location.c.a aVar3 = this.o;
        if (aVar3 != null && aVar3.d() && (aVar = this.p) != null) {
            com.baidu.location.c.a aVar4 = this.o;
            if (aVar4.i == 'g') {
                aVar4.d = aVar.d;
                aVar4.c = aVar.c;
            }
        }
        return this.o;
    }

    private int a(String str) {
        if (str == null || !str.contains("cl_s2")) {
            return -1;
        }
        try {
            Matcher matcher = Pattern.compile("cl_s2=[0-9]{1,}").matcher(str);
            if (!matcher.find()) {
                return -1;
            }
            String strGroup = matcher.group();
            return Integer.parseInt(strGroup.substring(strGroup.indexOf("cl_s2=") + 6, strGroup.length()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011c  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String d(com.baidu.location.c.a aVar) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = null;
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() >= 17) {
            try {
                List<com.baidu.location.c.a> listA = a(this.k, this.o);
                if (listA != null && !listA.isEmpty()) {
                    sb.append("&nc=");
                    HashSet hashSet = new HashSet();
                    long j = aVar != null ? aVar.g : 0L;
                    for (com.baidu.location.c.a aVar2 : listA) {
                        if (!aVar2.k) {
                            if (aVar2.f3471a != -1 && aVar2.b != -1) {
                                String str = aVar2.f3471a + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + aVar2.b;
                                if (!hashSet.contains(str)) {
                                    hashSet.add(str);
                                    sb.append(aVar2.c);
                                    sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                                    sb.append(aVar2.d);
                                    sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                                    sb.append(aVar2.f3471a);
                                    sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                                    sb.append(aVar2.b);
                                    sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                                    sb.append(aVar2.h);
                                    sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                                    sb.append(aVar2.g - j);
                                    sb.append(x.aQ);
                                }
                            }
                            if (Build.VERSION.SDK_INT > 28 && aVar2.l == 6 && aVar2.p != null && aVar2.b()) {
                                if (sb2 == null) {
                                    StringBuilder sb3 = new StringBuilder();
                                    try {
                                        sb3.append("&ncnr=");
                                        sb2 = sb3;
                                    } catch (Throwable th) {
                                        th = th;
                                        sb2 = sb3;
                                        if (com.baidu.location.c.b.a.c) {
                                            th.printStackTrace();
                                        }
                                        if (sb2 != null) {
                                        }
                                    }
                                }
                                sb2.append(f(aVar2));
                                sb2.append("_");
                                sb2.append(aVar2.p);
                                sb2.append(x.aQ);
                            }
                        }
                    }
                } else if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                    g.i().a("getAllCellInfo = null");
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        if (sb2 != null) {
            return sb.toString();
        }
        return sb.toString() + sb2.toString();
    }

    private String f(com.baidu.location.c.a aVar) {
        return String.format(Locale.CHINA, "%d|%d|%d|%d", Integer.valueOf(aVar.c), Integer.valueOf(aVar.d), Integer.valueOf(aVar.f3471a), Long.valueOf(aVar.b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g() {
        CellLocation cellLocation;
        com.baidu.location.c.a aVarA = a(this.o, this.k);
        if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d && aVarA != null) {
            g.i().a("new cell api = " + f(aVarA));
        }
        if (aVarA != null) {
            g(aVarA);
        }
        int i = this.f;
        boolean z = true;
        if (i >= 0 && Build.VERSION.SDK_INT > i) {
            z = false;
        }
        if (z && (aVarA == null || !aVarA.b())) {
            try {
                cellLocation = this.k.getCellLocation();
            } catch (Throwable unused) {
                cellLocation = null;
            }
            com.baidu.location.c.a aVarA2 = cellLocation != null ? a(cellLocation) : null;
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d && aVarA2 != null) {
                g.i().a(" old cell api = " + f(aVarA2));
            }
        }
    }

    public com.baidu.location.c.a b(com.baidu.location.c.a aVar, TelephonyManager telephonyManager) {
        CellLocation cellLocation;
        com.baidu.location.c.a aVarA = a(aVar, telephonyManager);
        if (Build.VERSION.SDK_INT <= 28 && (aVarA == null || !aVarA.b())) {
            try {
                cellLocation = telephonyManager.getCellLocation();
            } catch (Throwable unused) {
                cellLocation = null;
            }
            if (cellLocation != null) {
                aVarA = a(cellLocation);
            }
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d && aVarA != null) {
                g.i().a("main process: old cell api = " + f(aVarA));
            }
        }
        return aVarA;
    }

    public void c(int i) {
        this.M.set(i);
    }

    public static a a() {
        return e.f3479a;
    }

    private String e(com.baidu.location.c.a aVar) {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw2=");
        stringBuffer.append(aVar.i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl2=%d|%d|%d|%d&cl_s2=%d&clp2=%d&cl_t2=%d", Integer.valueOf(aVar.c), Integer.valueOf(aVar.d), Integer.valueOf(aVar.f3471a), Long.valueOf(aVar.b), Integer.valueOf(aVar.h), Integer.valueOf(aVar.l), Long.valueOf(aVar.g)));
        if (aVar.j != Integer.MAX_VALUE) {
            stringBuffer.append("&cl_cs2=");
            stringBuffer.append(aVar.j);
        }
        if (aVar.p != null) {
            stringBuffer.append("&clnrs2=");
            stringBuffer.append(aVar.p);
        }
        return stringBuffer.toString();
    }

    private void f() {
        if (this.t == null) {
            this.t = new C0063a();
        }
        Executor executor = this.r;
        if (executor != null) {
            this.k.requestCellInfoUpdate(executor, this.t);
        }
    }

    private void g(com.baidu.location.c.a aVar) {
        com.baidu.location.c.a aVar2;
        com.baidu.location.c.a aVar3 = this.o;
        if (aVar.b() && ((aVar2 = this.o) == null || !aVar2.a(aVar) || a(this.o, aVar))) {
            this.o = aVar;
        }
        if (aVar.b()) {
            if (aVar3 == null || !aVar3.a(aVar)) {
                if (!aVar.b()) {
                    List<com.baidu.location.c.a> list = this.q;
                    if (list != null) {
                        list.clear();
                        return;
                    }
                    return;
                }
                int size = this.q.size();
                com.baidu.location.c.a aVar4 = size == 0 ? null : this.q.get(size - 1);
                if (aVar4 != null) {
                    long j = aVar4.b;
                    com.baidu.location.c.a aVar5 = this.o;
                    if (j == aVar5.b && aVar4.f3471a == aVar5.f3471a) {
                        return;
                    }
                }
                this.q.add(this.o);
                if (this.q.size() > 3) {
                    this.q.remove(0);
                }
                if (this.j) {
                    i();
                }
                this.E = false;
            }
        }
    }

    public String b(com.baidu.location.c.a aVar) {
        int i;
        if (aVar == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(aVar.i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(aVar.c), Integer.valueOf(aVar.d), Integer.valueOf(aVar.f3471a), Long.valueOf(aVar.b), Integer.valueOf(aVar.h)));
        if (aVar.e < Integer.MAX_VALUE && (i = aVar.f) < Integer.MAX_VALUE) {
            stringBuffer.append(String.format(Locale.CHINA, "&cdmall=%.6f|%.6f", Double.valueOf(((double) i) / 14400.0d), Double.valueOf(((double) aVar.e) / 14400.0d)));
        }
        stringBuffer.append("&cl_t=");
        stringBuffer.append(aVar.g);
        stringBuffer.append("&cl_api=");
        stringBuffer.append(aVar.m);
        stringBuffer.append("&clp=");
        stringBuffer.append(aVar.l);
        if (aVar.p != null) {
            stringBuffer.append("&clnrs=");
            stringBuffer.append(aVar.p);
        }
        if (Build.VERSION.SDK_INT >= 28 && aVar.j != Integer.MAX_VALUE) {
            stringBuffer.append("&cl_cs=");
            stringBuffer.append(aVar.j);
        }
        try {
            List<com.baidu.location.c.a> list = this.q;
            if (list != null && list.size() > 0) {
                int size = this.q.size();
                stringBuffer.append("&clt=");
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.location.c.a aVar2 = this.q.get(i2);
                    if (aVar2 != null) {
                        int i3 = aVar2.c;
                        if (i3 != aVar.c) {
                            stringBuffer.append(i3);
                        }
                        stringBuffer.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                        int i4 = aVar2.d;
                        if (i4 != aVar.d) {
                            stringBuffer.append(i4);
                        }
                        stringBuffer.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                        int i5 = aVar2.f3471a;
                        if (i5 != aVar.f3471a) {
                            stringBuffer.append(i5);
                        }
                        stringBuffer.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                        long j = aVar2.b;
                        if (j != aVar.b) {
                            stringBuffer.append(j);
                        }
                        stringBuffer.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                        stringBuffer.append((System.currentTimeMillis() - aVar2.g) / 1000);
                        stringBuffer.append(x.aQ);
                    }
                }
            }
        } catch (Exception e2) {
            if (com.baidu.location.c.b.a.c) {
                e2.printStackTrace();
            }
        }
        if (this.f3472a > 100) {
            this.f3472a = 0;
        }
        int i6 = this.f3472a + (b << 8);
        boolean z = com.baidu.location.c.b.a.c;
        if (z && com.baidu.location.c.b.a.d) {
            g.i().a("sim state:" + this.f3472a + "," + i6);
        }
        stringBuffer.append("&cs=" + i6);
        String str = aVar.n;
        if (str != null) {
            stringBuffer.append(str);
        }
        if (z && com.baidu.location.c.b.a.d) {
            g.i().a("cell sb.toString() = " + stringBuffer.toString());
        }
        return stringBuffer.toString();
    }

    public boolean c() {
        return this.E;
    }

    public synchronized List<CellInfo> d() {
        return this.L;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x016c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.baidu.location.c.a a(CellInfo cellInfo, com.baidu.location.c.a aVar, TelephonyManager telephonyManager) {
        boolean z;
        int cellConnectionStatus;
        int iIntValue;
        com.baidu.location.c.e eVarI;
        StringBuilder sb;
        String str;
        String networkOperator;
        int i;
        com.baidu.location.c.e eVarI2;
        String str2;
        CellIdentityNr cellIdentityNr;
        int cellConnectionStatus2;
        int i2 = Build.VERSION.SDK_INT;
        int iIntValue2 = Integer.valueOf(i2).intValue();
        if (iIntValue2 < 17) {
            return null;
        }
        com.baidu.location.c.a aVar2 = new com.baidu.location.c.a();
        if (cellInfo instanceof CellInfoGsm) {
            CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
            CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                g.i().a("CellInfoGsm");
            }
            aVar2.c = e(cellIdentity.getMcc());
            aVar2.d = e(cellIdentity.getMnc());
            aVar2.f3471a = e(cellIdentity.getLac());
            aVar2.b = e(cellIdentity.getCid());
            aVar2.i = 'g';
            aVar2.h = cellInfoGsm.getCellSignalStrength().getAsuLevel();
            aVar2.l = 2;
            if (i2 >= 28) {
                cellConnectionStatus = cellInfo.getCellConnectionStatus();
                aVar2.j = cellConnectionStatus;
            }
            z = true;
        } else {
            if (cellInfo instanceof CellInfoCdma) {
                CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                boolean z2 = com.baidu.location.c.b.a.c;
                if (z2 && com.baidu.location.c.b.a.d) {
                    g.i().a("CellInfoCdma");
                    g.i().a("lat = " + cellIdentity2.getLatitude());
                    g.i().a("lon = " + cellIdentity2.getLongitude());
                }
                aVar2.e = cellIdentity2.getLatitude();
                aVar2.f = cellIdentity2.getLongitude();
                aVar2.d = e(cellIdentity2.getSystemId());
                aVar2.f3471a = e(cellIdentity2.getNetworkId());
                aVar2.b = e(cellIdentity2.getBasestationId());
                aVar2.i = 'c';
                aVar2.h = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                aVar2.l = 1;
                if (i2 >= 28) {
                    aVar2.j = cellInfo.getCellConnectionStatus();
                }
                if (aVar == null || (i = aVar.c) <= 0) {
                    try {
                        networkOperator = telephonyManager.getNetworkOperator();
                    } catch (Exception e2) {
                        if (com.baidu.location.c.b.a.c) {
                            e2.printStackTrace();
                        }
                    }
                    if (networkOperator == null || networkOperator.length() <= 0 || networkOperator.length() < 3) {
                        iIntValue = -1;
                        if (iIntValue > 0) {
                            aVar2.c = iIntValue;
                            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                                eVarI = g.i();
                                sb = new StringBuilder();
                                str = "cdma set old mcc = ";
                                sb.append(str);
                                sb.append(aVar2.c);
                                eVarI.a(sb.toString());
                            }
                        }
                    } else {
                        iIntValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                        if (iIntValue < 0) {
                        }
                        if (iIntValue > 0) {
                        }
                    }
                } else {
                    aVar2.c = i;
                    if (z2 && com.baidu.location.c.b.a.d) {
                        eVarI = g.i();
                        sb = new StringBuilder();
                        str = "cdma set old cellinfo mcc = ";
                        sb.append(str);
                        sb.append(aVar2.c);
                        eVarI.a(sb.toString());
                    }
                }
            } else if (cellInfo instanceof CellInfoLte) {
                CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                    g.i().a("CellInfoLte");
                }
                aVar2.c = e(cellIdentity3.getMcc());
                aVar2.d = e(cellIdentity3.getMnc());
                aVar2.f3471a = e(cellIdentity3.getTac());
                aVar2.b = e(cellIdentity3.getCi());
                aVar2.i = 'g';
                aVar2.h = cellInfoLte.getCellSignalStrength().getAsuLevel();
                aVar2.l = 3;
                if (i2 >= 28) {
                    cellConnectionStatus = cellInfo.getCellConnectionStatus();
                    aVar2.j = cellConnectionStatus;
                }
            } else {
                z = false;
            }
            z = true;
        }
        if (iIntValue2 >= 18 && !z) {
            try {
                if (cellInfo instanceof CellInfoWcdma) {
                    CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                    if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                        g.i().a("CellInfoWcdma");
                    }
                    aVar2.c = e(cellIdentity4.getMcc());
                    aVar2.d = e(cellIdentity4.getMnc());
                    aVar2.f3471a = e(cellIdentity4.getLac());
                    aVar2.b = e(cellIdentity4.getCid());
                    aVar2.i = 'g';
                    aVar2.h = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getAsuLevel();
                    aVar2.l = 4;
                    if (Build.VERSION.SDK_INT >= 28) {
                        cellConnectionStatus2 = cellInfo.getCellConnectionStatus();
                        aVar2.j = cellConnectionStatus2;
                    }
                } else if (Build.VERSION.SDK_INT >= 29) {
                    if (ts6.a(cellInfo)) {
                        CellIdentityTdscdma cellIdentity5 = ht6.a(cellInfo).getCellIdentity();
                        if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                            g.i().a("CellInfoTdscdma");
                        }
                        if (cellIdentity5.getMccString() != null) {
                            try {
                                aVar2.c = Integer.valueOf(cellIdentity5.getMccString()).intValue();
                            } catch (Throwable th) {
                                if (com.baidu.location.c.b.a.c) {
                                    th.printStackTrace();
                                }
                            }
                        }
                        if (cellIdentity5.getMncString() != null) {
                            try {
                                aVar2.d = Integer.valueOf(cellIdentity5.getMncString()).intValue();
                            } catch (Throwable th2) {
                                if (com.baidu.location.c.b.a.c) {
                                    th2.printStackTrace();
                                }
                            }
                        }
                        aVar2.f3471a = e(cellIdentity5.getLac());
                        aVar2.b = e(cellIdentity5.getCid());
                        aVar2.i = 'g';
                        aVar2.h = ht6.a(cellInfo).getCellSignalStrength().getAsuLevel();
                        aVar2.l = 5;
                        if (Build.VERSION.SDK_INT >= 28) {
                            cellConnectionStatus2 = cellInfo.getCellConnectionStatus();
                            aVar2.j = cellConnectionStatus2;
                        }
                    } else if (tg7.a(cellInfo)) {
                        try {
                            CellIdentityNr cellIdentityNrA = ch7.a(ug7.a(cellInfo).getCellIdentity());
                            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                                g.i().a(" get cell nr = " + cellIdentityNrA.toString());
                            }
                            cellIdentityNr = cellIdentityNrA;
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                            cellIdentityNr = null;
                        }
                        if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                            g.i().a("CellInfoNr");
                        }
                        if (cellIdentityNr != null) {
                            if (cellIdentityNr.getMccString() != null) {
                                try {
                                    aVar2.c = Integer.valueOf(cellIdentityNr.getMccString()).intValue();
                                } catch (Throwable th4) {
                                    if (com.baidu.location.c.b.a.c) {
                                        th4.printStackTrace();
                                    }
                                }
                            }
                            if (cellIdentityNr.getMncString() != null) {
                                try {
                                    aVar2.d = Integer.valueOf(cellIdentityNr.getMncString()).intValue();
                                } catch (Throwable th5) {
                                    if (com.baidu.location.c.b.a.c) {
                                        th5.printStackTrace();
                                    }
                                }
                            }
                            int iE = e(cellIdentityNr.getTac());
                            aVar2.f3471a = iE;
                            if (iE == -1) {
                                try {
                                    int iA = a(cellIdentityNr);
                                    if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                                        g.i().a(" get nrtac for huawei = " + iA);
                                    }
                                    aVar2.f3471a = e(iA);
                                } catch (Throwable th6) {
                                    if (com.baidu.location.c.b.a.c) {
                                        th6.printStackTrace();
                                    }
                                }
                            }
                            if (aVar2.f3471a == -1) {
                                try {
                                    int iB = b(cellIdentityNr.toString());
                                    if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                                        g.i().a(" get nrtac for samsung = " + iB);
                                    }
                                    aVar2.f3471a = e(iB);
                                } catch (Throwable th7) {
                                    if (com.baidu.location.c.b.a.c) {
                                        th7.printStackTrace();
                                    }
                                }
                            }
                            int tac = cellIdentityNr.getTac();
                            if (aVar2.f3471a == -1 && tac != Integer.MAX_VALUE) {
                                aVar2.f3471a = tac;
                            }
                            if (cellIdentityNr.getNci() != Long.MAX_VALUE) {
                                aVar2.b = cellIdentityNr.getNci();
                            }
                            aVar2.i = 'g';
                            aVar2.l = 6;
                            if (Build.VERSION.SDK_INT >= 28) {
                                aVar2.j = cellInfo.getCellConnectionStatus();
                            }
                            CellSignalStrengthNr cellSignalStrengthNrA = og7.a(ug7.a(cellInfo).getCellSignalStrength());
                            aVar2.h = cellSignalStrengthNrA.getAsuLevel();
                            if (aVar2.b()) {
                                aVar2.p = String.format(Locale.US, "%d|%d|%d|%d|%d|%d|%d|%d", Integer.valueOf(cellSignalStrengthNrA.getCsiRsrp()), Integer.valueOf(cellSignalStrengthNrA.getCsiRsrq()), Integer.valueOf(cellSignalStrengthNrA.getCsiSinr()), Integer.valueOf(cellSignalStrengthNrA.getDbm()), Integer.valueOf(cellSignalStrengthNrA.getLevel()), Integer.valueOf(cellSignalStrengthNrA.getSsRsrp()), Integer.valueOf(cellSignalStrengthNrA.getSsRsrq()), Integer.valueOf(cellSignalStrengthNrA.getSsSinr()));
                            }
                        }
                    }
                }
            } catch (Exception e3) {
                if (com.baidu.location.c.b.a.c) {
                    e3.printStackTrace();
                }
            }
        }
        if (cellInfo.isRegistered()) {
            aVar2.k = true;
        }
        try {
            if (iIntValue2 >= 30) {
                long jElapsedRealtime = SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis();
                boolean z3 = com.baidu.location.c.b.a.c;
                if (z3 && com.baidu.location.c.b.a.d) {
                    g.i().a("new cell delta1 time(ms) = " + SystemClock.elapsedRealtime());
                    g.i().a("new cell delta2 time(ms) = " + cellInfo.getTimestampMillis());
                    g.i().a("new cell delta3 time(ms) = " + jElapsedRealtime);
                }
                aVar2.g = System.currentTimeMillis() - jElapsedRealtime;
                if (z3) {
                    eVarI2 = g.i();
                    str2 = "new cell time apilevel up 30 (ms) = " + aVar2.g;
                    eVarI2.a(str2);
                }
            } else {
                long jElapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                boolean z4 = com.baidu.location.c.b.a.c;
                if (z4 && com.baidu.location.c.b.a.d) {
                    g.i().a("new cell delta1 time(ns) = " + SystemClock.elapsedRealtimeNanos());
                    g.i().a("new cell delta2 time(ns) = " + cellInfo.getTimeStamp());
                    g.i().a("new cell delta3 time(ms) = " + jElapsedRealtimeNanos);
                }
                aVar2.g = System.currentTimeMillis() - jElapsedRealtimeNanos;
                if (z4 && com.baidu.location.c.b.a.d) {
                    eVarI2 = g.i();
                    str2 = "new cell time(ms) = " + aVar2.g;
                    eVarI2.a(str2);
                }
            }
        } catch (Error e4) {
            if (com.baidu.location.c.b.a.c) {
                e4.printStackTrace();
            }
            aVar2.g = System.currentTimeMillis();
        }
        if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
            g.i().a("mcc = " + aVar2.c);
            g.i().a("mnc = " + aVar2.d);
            g.i().a("lac = " + aVar2.f3471a);
            g.i().a("cid = " + aVar2.b);
            g.i().a("cs = " + aVar2.j);
        }
        return aVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00b2 A[Catch: Exception -> 0x010b, TryCatch #0 {Exception -> 0x010b, blocks: (B:6:0x0010, B:8:0x0014, B:9:0x0022, B:11:0x0032, B:13:0x0035, B:16:0x003b, B:18:0x003e, B:19:0x0040, B:21:0x0046, B:23:0x004c, B:25:0x0051, B:27:0x0055, B:29:0x0059, B:30:0x008d, B:32:0x0094, B:34:0x0098, B:35:0x009e, B:39:0x00ae, B:41:0x00b2, B:42:0x00b9, B:44:0x00bd, B:46:0x00c1, B:48:0x00ca, B:50:0x00d0, B:52:0x00d4, B:53:0x00da, B:57:0x00ea, B:59:0x00ee, B:60:0x00f5, B:62:0x00f9, B:64:0x00fd, B:66:0x0106, B:54:0x00dd, B:56:0x00e1, B:65:0x0104, B:36:0x00a1, B:38:0x00a5, B:47:0x00c8, B:24:0x004f), top: B:95:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ee A[Catch: Exception -> 0x010b, TryCatch #0 {Exception -> 0x010b, blocks: (B:6:0x0010, B:8:0x0014, B:9:0x0022, B:11:0x0032, B:13:0x0035, B:16:0x003b, B:18:0x003e, B:19:0x0040, B:21:0x0046, B:23:0x004c, B:25:0x0051, B:27:0x0055, B:29:0x0059, B:30:0x008d, B:32:0x0094, B:34:0x0098, B:35:0x009e, B:39:0x00ae, B:41:0x00b2, B:42:0x00b9, B:44:0x00bd, B:46:0x00c1, B:48:0x00ca, B:50:0x00d0, B:52:0x00d4, B:53:0x00da, B:57:0x00ea, B:59:0x00ee, B:60:0x00f5, B:62:0x00f9, B:64:0x00fd, B:66:0x0106, B:54:0x00dd, B:56:0x00e1, B:65:0x0104, B:36:0x00a1, B:38:0x00a5, B:47:0x00c8, B:24:0x004f), top: B:95:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e() {
        TelephonyManager telephonyManagerCreateForSubscriptionId;
        TelephonyManager telephonyManager;
        Executor executor;
        TelephonyManager telephonyManagerCreateForSubscriptionId2;
        TelephonyManager telephonyManager2;
        Executor executor2;
        int i;
        this.A = System.currentTimeMillis();
        if (this.i) {
            boolean z = false;
            try {
                if (this.n == null) {
                    this.n = qr6.a(this.x.getSystemService("telephony_subscription_service"));
                }
                int[] subscriptionIds = this.n.getSubscriptionIds(0);
                int[] subscriptionIds2 = this.n.getSubscriptionIds(1);
                int i2 = -1;
                int i3 = (subscriptionIds == null || subscriptionIds.length <= 0) ? -1 : subscriptionIds[0];
                if (subscriptionIds2 != null && subscriptionIds2.length > 0) {
                    i2 = subscriptionIds2[0];
                }
                if (SubscriptionManager.isValidSubscriptionId(i3) && SubscriptionManager.isValidSubscriptionId(i2)) {
                    this.C = true;
                } else {
                    this.C = false;
                }
                if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                    g.i().a("getCellInfo: subId0 = " + i3 + ", subId1 = " + i2 + ", mLastSubId0 = " + this.G + ", mLastSubId1 = " + this.H);
                }
                if (SubscriptionManager.isValidSubscriptionId(i3)) {
                    if (this.l == null) {
                        telephonyManagerCreateForSubscriptionId2 = this.k.createForSubscriptionId(i3);
                    } else {
                        if (this.G != i3) {
                            this.l = null;
                            telephonyManagerCreateForSubscriptionId2 = this.k.createForSubscriptionId(i3);
                        }
                        if (this.u == null) {
                            this.u = new b();
                        }
                        telephonyManager2 = this.l;
                        if (telephonyManager2 != null && (executor2 = this.r) != null) {
                            telephonyManager2.requestCellInfoUpdate(executor2, this.u);
                            z = true;
                        }
                    }
                    this.l = telephonyManagerCreateForSubscriptionId2;
                    if (this.u == null) {
                    }
                    telephonyManager2 = this.l;
                    if (telephonyManager2 != null) {
                        telephonyManager2.requestCellInfoUpdate(executor2, this.u);
                        z = true;
                    }
                } else {
                    this.l = null;
                }
                if (SubscriptionManager.isValidSubscriptionId(i2)) {
                    if (this.m == null) {
                        telephonyManagerCreateForSubscriptionId = this.k.createForSubscriptionId(i2);
                    } else {
                        if (this.H != i2) {
                            this.m = null;
                            telephonyManagerCreateForSubscriptionId = this.k.createForSubscriptionId(i2);
                        }
                        if (this.v == null) {
                            this.v = new c();
                        }
                        telephonyManager = this.m;
                        if (telephonyManager != null && (executor = this.r) != null) {
                            telephonyManager.requestCellInfoUpdate(executor, this.v);
                            z = true;
                        }
                    }
                    this.m = telephonyManagerCreateForSubscriptionId;
                    if (this.v == null) {
                    }
                    telephonyManager = this.m;
                    if (telephonyManager != null) {
                        telephonyManager.requestCellInfoUpdate(executor, this.v);
                        z = true;
                    }
                } else {
                    this.m = null;
                }
                this.G = i3;
                this.H = i2;
            } catch (Exception e2) {
                if (com.baidu.location.c.b.a.c) {
                    e2.printStackTrace();
                }
            }
            if (!z) {
            }
        } else {
            f();
        }
        synchronized (this.I) {
            try {
                if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                    g.i().a("start waiting update to finish");
                }
                i = this.g.get();
            } catch (InterruptedException e3) {
                if (com.baidu.location.c.b.a.c) {
                    e3.printStackTrace();
                }
            }
            if (i != 0) {
                this.I.wait(i);
            }
        }
    }

    public void b() {
        TelephonyManager telephonyManager;
        if (this.y) {
            try {
                d dVar = this.s;
                if (dVar != null && (telephonyManager = this.k) != null) {
                    telephonyManager.listen(dVar, 0);
                }
                this.s = null;
                this.k = null;
                this.l = null;
                this.m = null;
                List<com.baidu.location.c.a> list = this.q;
                if (list != null) {
                    list.clear();
                    this.q = null;
                }
                if (this.j) {
                    i();
                }
            } catch (Exception e2) {
                if (com.baidu.location.c.b.a.c) {
                    e2.printStackTrace();
                }
            }
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                g.i().a("cell manager stop ...");
            }
            this.y = false;
        }
    }

    private com.baidu.location.c.a a(CellLocation cellLocation) {
        return a(cellLocation, false);
    }

    public void b(int i) {
        this.e = i;
    }

    private com.baidu.location.c.a a(CellLocation cellLocation, boolean z) {
        int iIntValue;
        if (cellLocation == null || this.k == null) {
            return null;
        }
        if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
            g.i().a("set cell info..");
        }
        com.baidu.location.c.a aVar = new com.baidu.location.c.a();
        aVar.m = 1;
        if (z) {
            aVar.q = true;
        }
        aVar.g = System.currentTimeMillis();
        try {
            String networkOperator = this.k.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                if (networkOperator.length() >= 3) {
                    iIntValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    aVar.c = iIntValue < 0 ? this.o.c : iIntValue;
                } else {
                    iIntValue = -1;
                }
                String strSubstring = networkOperator.substring(3);
                if (strSubstring != null) {
                    char[] charArray = strSubstring.toCharArray();
                    int i = 0;
                    while (i < charArray.length && Character.isDigit(charArray[i])) {
                        i++;
                    }
                    iIntValue = Integer.valueOf(strSubstring.substring(0, i)).intValue();
                }
                if (iIntValue < 0) {
                    iIntValue = this.o.d;
                }
                aVar.d = iIntValue;
            }
            this.f3472a = this.k.getSimState();
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                g.i().a("sim state:" + this.f3472a);
            }
        } catch (Exception e2) {
            if (com.baidu.location.c.b.a.c) {
                e2.printStackTrace();
            }
            b = 1;
        }
        if (cellLocation instanceof GsmCellLocation) {
            aVar.f3471a = ((GsmCellLocation) cellLocation).getLac();
            aVar.b = r10.getCid();
            aVar.i = 'g';
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                g.i().a("bslocation mNetworkType = 'g'");
            }
        } else if (cellLocation instanceof CdmaCellLocation) {
            aVar.i = 'c';
            boolean z2 = com.baidu.location.c.b.a.c;
            if (z2 && com.baidu.location.c.b.a.d) {
                g.i().a("bslocation mNetworkType = 'c'");
            }
            if (w == null) {
                try {
                    w = Class.forName("android.telephony.cdma.CdmaCellLocation");
                } catch (Exception unused) {
                    w = null;
                    return aVar;
                }
            }
            Class<?> cls = w;
            if (cls != null && cls.isInstance(cellLocation)) {
                try {
                    int systemId = ((CdmaCellLocation) cellLocation).getSystemId();
                    if (systemId < 0) {
                        systemId = this.o.d;
                    }
                    aVar.d = systemId;
                    aVar.b = ((CdmaCellLocation) cellLocation).getBaseStationId();
                    aVar.f3471a = ((CdmaCellLocation) cellLocation).getNetworkId();
                    int baseStationLatitude = ((CdmaCellLocation) cellLocation).getBaseStationLatitude();
                    if (z2 && com.baidu.location.c.b.a.d) {
                        g.i().a("bslocation lat " + (((double) baseStationLatitude) / 14400.0d));
                    }
                    if (baseStationLatitude < Integer.MAX_VALUE) {
                        aVar.e = baseStationLatitude;
                    }
                    int baseStationLongitude = ((CdmaCellLocation) cellLocation).getBaseStationLongitude();
                    if (z2 && com.baidu.location.c.b.a.d) {
                        g.i().a("bslocation lon" + (((double) baseStationLongitude) / 14400.0d));
                    }
                    if (baseStationLongitude < Integer.MAX_VALUE) {
                        aVar.f = baseStationLongitude;
                    }
                } catch (Exception e3) {
                    if (com.baidu.location.c.b.a.c) {
                        e3.printStackTrace();
                    }
                    b = 3;
                    return aVar;
                }
            }
        }
        g(aVar);
        return aVar;
    }

    public void b(boolean z) {
        this.j = z;
    }

    public com.baidu.location.c.a a(com.baidu.location.c.a aVar, TelephonyManager telephonyManager) {
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
            return null;
        }
        try {
            List<com.baidu.location.c.a> listA = a(telephonyManager, aVar);
            if (listA == null || listA.isEmpty()) {
                if (!com.baidu.location.c.b.a.c || !com.baidu.location.c.b.a.d) {
                    return null;
                }
                g.i().a("getAllCellInfo=null");
                return null;
            }
            com.baidu.location.c.a aVar2 = null;
            for (com.baidu.location.c.a aVar3 : listA) {
                if (aVar3.k) {
                    boolean z = aVar2 != null;
                    if (aVar3.b()) {
                        if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                            g.i().a(" cell res.isValid() = " + f(aVar3));
                        }
                        if (z && aVar2 != null) {
                            aVar2.n = e(aVar3);
                            aVar2.o = f(aVar3);
                        }
                    } else {
                        if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                            g.i().a("res.isValid()");
                        }
                        aVar3 = null;
                    }
                    if (aVar2 == null) {
                        aVar2 = aVar3;
                    }
                }
            }
            return aVar2;
        } catch (Throwable th) {
            if (!com.baidu.location.c.b.a.c) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public String a(com.baidu.location.c.a aVar) {
        String strD;
        int iIntValue;
        String str = "";
        try {
            strD = d(aVar);
            iIntValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
            if (strD != null && !"".equals(strD)) {
                if (!"&nc=".equals(strD)) {
                    return strD;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (iIntValue >= 17) {
            return strD;
        }
        str = strD;
        if (str == null || !"&nc=".equals(str)) {
            return str;
        }
        return null;
    }

    private synchronized List<com.baidu.location.c.a> a(TelephonyManager telephonyManager, com.baidu.location.c.a aVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.J > this.M.get()) {
            ArrayList arrayList = new ArrayList();
            try {
                this.f3472a = telephonyManager.getSimState();
                List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
                if (allCellInfo != null && !allCellInfo.isEmpty()) {
                    Iterator<CellInfo> it = allCellInfo.iterator();
                    while (it.hasNext()) {
                        com.baidu.location.c.a aVarA = a(it.next(), aVar, telephonyManager);
                        if (aVarA != null) {
                            arrayList.add(aVarA);
                        }
                    }
                }
                this.L = allCellInfo;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.J = jCurrentTimeMillis;
            this.K = arrayList;
        }
        return this.K;
    }

    public void a(int i) {
        this.g.set(i);
    }

    public void a(Context context) {
        d dVar;
        if (this.y) {
            return;
        }
        this.x = context;
        this.k = (TelephonyManager) context.getSystemService("phone");
        this.q = new LinkedList();
        if (Looper.myLooper() != null) {
            this.s = new d();
        }
        if (this.F == null) {
            this.F = new Handler(Looper.getMainLooper());
        }
        if (this.j) {
            h();
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= this.e) {
            if (this.r == null) {
                this.r = this.x.getMainExecutor();
            }
            this.z = com.baidu.location.c.b.b.a("android.telephony.TelephonyManager$CellInfoCallback");
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                g.i().a("isCellinfoCallbackExist = " + this.z);
            }
        }
        TelephonyManager telephonyManager = this.k;
        if (telephonyManager == null || (dVar = this.s) == null) {
            return;
        }
        if (i < this.e || !this.z) {
            try {
                telephonyManager.listen(dVar, 1280);
            } catch (Exception unused) {
            }
        }
        if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
            g.i().a("cell manager start...");
        }
        this.y = true;
    }

    public void a(boolean z) {
        this.i = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(com.baidu.location.c.a aVar, com.baidu.location.c.a aVar2) {
        boolean z;
        if (aVar == null && aVar2 == null) {
            return false;
        }
        if (aVar == null || aVar2 == null) {
            return true;
        }
        float fAbs = Math.abs(aVar.h - aVar2.h);
        int i = aVar.h;
        if (i == 0) {
            i = -1;
        }
        float f = fAbs / i;
        boolean z2 = com.baidu.location.c.b.a.c;
        if (z2 && com.baidu.location.c.b.a.d) {
            g.i().a("cl-cache, str, old:" + aVar.h + " new:" + aVar2.h);
            com.baidu.location.c.e eVarI = g.i();
            StringBuilder sb = new StringBuilder();
            sb.append("cl-cache, str, diffRate:");
            sb.append(f);
            eVarI.a(sb.toString());
        }
        String str = aVar.n;
        if (str == null || aVar2.n == null) {
            z = false;
        } else {
            if (Math.abs(Math.abs(r9 - a(aVar2.n)) / (a(str) != 0 ? r9 : -1)) > this.h) {
                z = true;
            }
        }
        if (z2 && com.baidu.location.c.b.a.d) {
            g.i().a("cl-cache, isStrengthChange2:" + z);
        }
        return f > this.h || z;
    }
}
