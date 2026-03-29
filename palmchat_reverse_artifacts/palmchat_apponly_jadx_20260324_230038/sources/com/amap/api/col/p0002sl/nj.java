package com.amap.api.col.p0002sl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.zip.CRC32;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@SuppressLint({"NewApi"})
public final class nj {
    protected static String J;
    protected static String L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3035a = "1";
    protected short b = 0;
    protected String c = null;
    protected String d = null;
    protected String e = null;
    protected String f = null;
    protected String g = null;
    public String h = null;
    public String i = null;
    protected String j = null;
    protected String k = null;
    protected String l = null;
    protected String m = null;
    protected String n = null;
    protected String o = null;
    protected String p = null;
    protected String q = null;
    protected String r = null;
    protected String s = null;
    protected String t = null;
    protected String u = null;
    protected String v = null;
    protected String w = null;
    protected String x = null;
    protected String y = null;
    protected int z = 0;
    protected String A = null;
    protected String B = null;
    protected ArrayList<nd> C = new ArrayList<>();
    protected String D = null;
    protected String E = null;
    protected ArrayList<ScanResult> F = new ArrayList<>();
    protected String G = null;
    protected String H = null;
    protected byte[] I = null;
    private byte[] O = null;
    private int P = 0;
    protected String K = null;
    protected String M = null;
    protected String N = null;

    private static int a(String str, byte[] bArr, int i) {
        try {
        } catch (Throwable th) {
            nl.a(th, "Req", "copyContentWithByteLen");
            bArr[i] = 0;
        }
        if (TextUtils.isEmpty(str)) {
            bArr[i] = 0;
            return i + 1;
        }
        byte[] bytes = str.getBytes("GBK");
        int length = bytes.length;
        if (length > 127) {
            length = 127;
        }
        bArr[i] = (byte) length;
        int i2 = i + 1;
        System.arraycopy(bytes, 0, bArr, i2, length);
        return i2 + length;
    }

    private String b(String str) {
        if (!this.A.contains(str + ">")) {
            return "0";
        }
        return this.A.substring(this.A.indexOf(str + ">") + str.length() + 1, this.A.indexOf("</".concat(String.valueOf(str))));
    }

    private String a(String str, int i) {
        String[] strArrSplit = this.B.split("\\*")[i].split(",");
        if ("lac".equals(str)) {
            return strArrSplit[0];
        }
        if ("cellid".equals(str)) {
            return strArrSplit[1];
        }
        if ("signal".equals(str)) {
            return strArrSplit[2];
        }
        return null;
    }

    private void b() {
        if (TextUtils.isEmpty(this.f3035a)) {
            this.f3035a = "";
        }
        if (TextUtils.isEmpty(this.c)) {
            this.c = "";
        }
        if (TextUtils.isEmpty(this.d)) {
            this.d = "";
        }
        if (TextUtils.isEmpty(this.e)) {
            this.e = "";
        }
        if (TextUtils.isEmpty(this.f)) {
            this.f = "";
        }
        if (TextUtils.isEmpty(this.g)) {
            this.g = "";
        }
        if (TextUtils.isEmpty(this.h)) {
            this.h = "";
        }
        if (TextUtils.isEmpty(this.i)) {
            this.i = "";
        }
        if (TextUtils.isEmpty(this.j) || (!"0".equals(this.j) && !"2".equals(this.j))) {
            this.j = "0";
        }
        if (TextUtils.isEmpty(this.k) || (!"0".equals(this.k) && !"1".equals(this.k))) {
            this.k = "0";
        }
        if (TextUtils.isEmpty(this.l)) {
            this.l = "";
        }
        if (TextUtils.isEmpty(this.m)) {
            this.m = "";
        }
        if (TextUtils.isEmpty(this.n)) {
            this.n = "";
        }
        if (TextUtils.isEmpty(this.o)) {
            this.o = "";
        }
        if (TextUtils.isEmpty(this.p)) {
            this.p = "";
        }
        if (TextUtils.isEmpty(this.q)) {
            this.q = "";
        }
        if (TextUtils.isEmpty(this.r)) {
            this.r = "";
        }
        if (TextUtils.isEmpty(this.s)) {
            this.s = "";
        }
        if (TextUtils.isEmpty(this.t)) {
            this.t = "";
        }
        if (TextUtils.isEmpty(this.u)) {
            this.u = "";
        }
        if (TextUtils.isEmpty(this.v)) {
            this.v = "";
        }
        if (TextUtils.isEmpty(this.w)) {
            this.w = "";
        }
        if (TextUtils.isEmpty(this.x)) {
            this.x = "";
        }
        if (TextUtils.isEmpty(this.y) || (!"1".equals(this.y) && !"2".equals(this.y))) {
            this.y = "0";
        }
        if (!ne.a(this.z)) {
            this.z = 0;
        }
        if (TextUtils.isEmpty(this.A)) {
            this.A = "";
        }
        if (TextUtils.isEmpty(this.B)) {
            this.B = "";
        }
        if (TextUtils.isEmpty(this.E)) {
            this.E = "";
        }
        if (TextUtils.isEmpty(this.G)) {
            this.G = "";
        }
        if (TextUtils.isEmpty(this.H)) {
            this.H = "";
        }
        if (TextUtils.isEmpty(J)) {
            J = "";
        }
        if (this.I == null) {
            this.I = new byte[0];
        }
        if (TextUtils.isEmpty(this.N)) {
            this.N = "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Context context, boolean z, boolean z2, ne neVar, nf nfVar, ConnectivityManager connectivityManager, String str) {
        String str2;
        String str3;
        int i;
        String str4;
        NetworkInfo activeNetworkInfo;
        String strB;
        String str5;
        String str6;
        String str7;
        String str8;
        ArrayList<ScanResult> arrayList;
        String str9;
        String string;
        ArrayList<ScanResult> arrayList2;
        int length;
        String strF = fr.f(context);
        int iF = np.f();
        this.K = str;
        if (z2) {
            str2 = "api_serverSDK_130905";
            str3 = "S128DF1572465B890OE3F7A13167KLEI";
        } else {
            str2 = "UC_nlp_20131029";
            str3 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
        }
        String str10 = str3;
        String str11 = str2;
        StringBuilder sb = new StringBuilder();
        int iC = neVar.c();
        int iD = neVar.d();
        TelephonyManager telephonyManagerE = neVar.e();
        ArrayList<nd> arrayListA = neVar.a();
        ArrayList<nd> arrayListB = neVar.b();
        ArrayList<ScanResult> arrayListA2 = nfVar.a();
        String str12 = iD == 2 ? "1" : "0";
        if (telephonyManagerE == null) {
            i = iF;
            str4 = "1";
        } else if (TextUtils.isEmpty(nl.d)) {
            try {
                nl.d = fv.k();
                str4 = "1";
            } catch (Throwable th) {
                str4 = "1";
                nl.a(th, "Aps", "getApsReq part4");
            }
            i = iF;
            if (TextUtils.isEmpty(nl.d) && Build.VERSION.SDK_INT < 29) {
                nl.d = "888888888888888";
            }
            if (TextUtils.isEmpty(nl.e)) {
                try {
                    nl.e = telephonyManagerE.getSubscriberId();
                } catch (SecurityException unused) {
                } catch (Throwable th2) {
                    nl.a(th2, "Aps", "getApsReq part2");
                }
            }
            if (TextUtils.isEmpty(nl.e) && Build.VERSION.SDK_INT < 29) {
                nl.e = "888888888888888";
            }
        } else {
            str4 = "1";
            i = iF;
            if (TextUtils.isEmpty(nl.d)) {
                nl.d = "888888888888888";
            }
            if (TextUtils.isEmpty(nl.e)) {
            }
            if (TextUtils.isEmpty(nl.e)) {
                nl.e = "888888888888888";
            }
        }
        try {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th3) {
            nl.a(th3, "Aps", "getApsReq part");
            activeNetworkInfo = null;
        }
        boolean zA = nfVar.a(connectivityManager);
        if (np.a(activeNetworkInfo) != -1) {
            strB = np.b(telephonyManagerE);
            str5 = zA ? "2" : str4;
        } else {
            strB = "";
            str5 = strB;
        }
        String str13 = str5;
        String str14 = strB;
        if (arrayListA.isEmpty()) {
            str6 = strF;
            str7 = str11;
            str8 = str10;
            arrayList = arrayListA2;
            str9 = "0";
            string = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            str6 = strF;
            str9 = "0";
            str8 = str10;
            str7 = str11;
            if (iD == 1) {
                nd ndVar = arrayListA.get(0);
                arrayList = arrayListA2;
                sb2.delete(0, sb2.length());
                sb2.append("<mcc>");
                sb2.append(ndVar.f3028a);
                sb2.append("</mcc>");
                sb2.append("<mnc>");
                sb2.append(ndVar.b);
                sb2.append("</mnc>");
                sb2.append("<lac>");
                sb2.append(ndVar.c);
                sb2.append("</lac>");
                sb2.append("<cellid>");
                sb2.append(ndVar.d);
                sb2.append("</cellid>");
                sb2.append("<signal>");
                sb2.append(ndVar.j);
                sb2.append("</signal>");
                string = sb2.toString();
                for (int i2 = 1; i2 < arrayListA.size(); i2++) {
                    nd ndVar2 = arrayListA.get(i2);
                    sb.append(ndVar2.c);
                    sb.append(",");
                    sb.append(ndVar2.d);
                    sb.append(",");
                    sb.append(ndVar2.j);
                    if (i2 < arrayListA.size() - 1) {
                        sb.append("*");
                    }
                }
            } else if (iD != 2) {
                arrayList = arrayListA2;
                string = "";
            } else {
                nd ndVar3 = arrayListA.get(0);
                sb2.delete(0, sb2.length());
                sb2.append("<mcc>");
                sb2.append(ndVar3.f3028a);
                sb2.append("</mcc>");
                sb2.append("<sid>");
                sb2.append(ndVar3.g);
                sb2.append("</sid>");
                sb2.append("<nid>");
                sb2.append(ndVar3.h);
                sb2.append("</nid>");
                sb2.append("<bid>");
                sb2.append(ndVar3.i);
                sb2.append("</bid>");
                if (ndVar3.f > 0 && ndVar3.e > 0) {
                    sb2.append("<lon>");
                    sb2.append(ndVar3.f);
                    sb2.append("</lon>");
                    sb2.append("<lat>");
                    sb2.append(ndVar3.e);
                    sb2.append("</lat>");
                }
                sb2.append("<signal>");
                sb2.append(ndVar3.j);
                sb2.append("</signal>");
                string = sb2.toString();
                arrayList = arrayListA2;
            }
            sb2.delete(0, sb2.length());
        }
        if ((iC & 4) != 4 || arrayListB.isEmpty()) {
            this.C.clear();
        } else {
            this.C.clear();
            this.C.addAll(arrayListB);
        }
        StringBuilder sb3 = new StringBuilder();
        if (nfVar.e()) {
            if (zA) {
                WifiInfo wifiInfoF = nfVar.f();
                if (nf.a(wifiInfoF)) {
                    sb3.append(wifiInfoF.getBSSID());
                    sb3.append(",");
                    int rssi = wifiInfoF.getRssi();
                    if (rssi < -128 || rssi > 127) {
                        rssi = 0;
                    }
                    sb3.append(rssi);
                    sb3.append(",");
                    String ssid = wifiInfoF.getSSID();
                    try {
                        length = wifiInfoF.getSSID().getBytes("UTF-8").length;
                    } catch (Exception unused2) {
                        length = 32;
                    }
                    if (length >= 32) {
                        ssid = "unkwn";
                    }
                    sb3.append(ssid.replace("*", "."));
                }
            }
            if (arrayList != null && (arrayList2 = this.F) != null) {
                arrayList2.clear();
                this.F.addAll(arrayList);
            }
        } else {
            nfVar.b();
            ArrayList<ScanResult> arrayList3 = this.F;
            if (arrayList3 != null) {
                arrayList3.clear();
            }
        }
        this.b = (short) 0;
        if (!z) {
            this.b = (short) (2 | 0);
        }
        this.c = str7;
        this.d = str8;
        this.f = np.d();
        this.g = "android" + np.e();
        this.h = np.b(context);
        this.i = str12;
        String str15 = str9;
        this.j = str15;
        this.k = str15;
        this.l = str15;
        this.m = str15;
        this.n = str15;
        this.o = str6;
        this.p = nl.d;
        this.q = nl.e;
        this.s = String.valueOf(i);
        this.t = np.d(context);
        this.v = "4.7.0";
        this.w = null;
        this.u = "";
        this.x = str14;
        this.y = str13;
        this.z = iC;
        this.A = string;
        this.B = sb.toString();
        this.D = neVar.i();
        this.G = nf.i();
        this.E = sb3.toString();
        try {
            if (TextUtils.isEmpty(J)) {
                J = fv.f(context);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (TextUtils.isEmpty(L)) {
                L = fv.a(context);
            }
        } catch (Throwable unused4) {
        }
        try {
            if (TextUtils.isEmpty(this.N)) {
                this.N = fv.f();
            }
        } catch (Throwable unused5) {
        }
        sb.delete(0, sb.length());
        sb3.delete(0, sb3.length());
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0328 A[PHI: r0
      0x0328: PHI (r0v109 int) = (r0v108 int), (r0v117 int) binds: [B:66:0x023d, B:91:0x0305] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x048b A[Catch: all -> 0x049d, TryCatch #8 {all -> 0x049d, blocks: (B:166:0x047d, B:170:0x048b, B:171:0x048f), top: B:221:0x047d }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x048f A[Catch: all -> 0x049d, TRY_LEAVE, TryCatch #8 {all -> 0x049d, blocks: (B:166:0x047d, B:170:0x048b, B:171:0x048f), top: B:221:0x047d }] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x04b0 A[Catch: all -> 0x04d1, TryCatch #1 {all -> 0x04d1, blocks: (B:176:0x04a8, B:178:0x04b0, B:179:0x04ba), top: B:208:0x04a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x04ec  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x04fb  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x04c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0182 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x020d A[PHI: r0
      0x020d: PHI (r0v48 int) = (r0v47 int), (r0v47 int), (r0v127 int) binds: [B:51:0x01f1, B:53:0x01f6, B:205:0x020d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0307  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] a() {
        int length;
        int i;
        int i2;
        int length2;
        int length3;
        int i3;
        String str;
        int i4;
        int length4;
        int i5;
        int iMin;
        byte b;
        int length5;
        int i6;
        int length6;
        int i7;
        int length7;
        byte[] bArrA;
        int i8;
        int length8;
        byte[] bArr;
        byte[] bArr2;
        int length9;
        boolean zIsEmpty;
        byte[] bytes;
        int length10;
        int length11;
        int i9;
        b();
        byte[] bArr3 = new byte[2];
        byte[] bArr4 = new byte[4];
        byte[] bArr5 = this.I;
        int length12 = bArr5 != null ? 4096 + bArr5.length + 1 : 4096;
        byte[] bArr6 = this.O;
        if (bArr6 == null || length12 > this.P) {
            bArr6 = new byte[length12];
            this.O = bArr6;
            this.P = length12;
        }
        byte[] bArr7 = bArr6;
        byte b2 = 0;
        bArr7[0] = np.e(this.f3035a);
        byte[] bArrA2 = np.a(this.b, (byte[]) null);
        System.arraycopy(bArrA2, 0, bArr7, 1, bArrA2.length);
        int iA = a(this.q, bArr7, a(this.p, bArr7, a(this.h, bArr7, a(this.u, bArr7, a(this.g, bArr7, a(this.f, bArr7, a(this.e, bArr7, a(this.o, bArr7, a(this.d, bArr7, a(this.c, bArr7, bArrA2.length + 1))))))))));
        try {
        } catch (Throwable th) {
            nl.a(th, "Req", "buildV4Dot219");
            bArr7[iA] = 0;
        }
        if (TextUtils.isEmpty(this.t)) {
            bArr7[iA] = 0;
            length = iA + 1;
            int iA2 = a(this.x, bArr7, a(L, bArr7, a(J, bArr7, a(this.w, bArr7, a(this.v, bArr7, length)))));
            bArr7[iA2] = Byte.parseByte(this.y);
            int i10 = iA2 + 1;
            bArr7[i10] = Byte.parseByte(this.j);
            int i11 = i10 + 1;
            int i12 = this.z;
            i = i12 & 3;
            bArr7[i11] = (byte) i12;
            i2 = i11 + 1;
            if (i != 1 || i == 2) {
                byte[] bArrB = np.b(b("mcc"));
                System.arraycopy(bArrB, 0, bArr7, i2, bArrB.length);
                int length13 = i2 + bArrB.length;
                if (i != 1) {
                    byte[] bArrB2 = np.b(b("mnc"));
                    System.arraycopy(bArrB2, 0, bArr7, length13, bArrB2.length);
                    int length14 = length13 + bArrB2.length;
                    byte[] bArrB3 = np.b(b("lac"));
                    System.arraycopy(bArrB3, 0, bArr7, length14, bArrB3.length);
                    length2 = length14 + bArrB3.length;
                    byte[] bArrC = np.c(b("cellid"));
                    System.arraycopy(bArrC, 0, bArr7, length2, bArrC.length);
                    length3 = bArrC.length;
                } else {
                    if (i == 2) {
                        byte[] bArrB4 = np.b(b("sid"));
                        System.arraycopy(bArrB4, 0, bArr7, length13, bArrB4.length);
                        int length15 = length13 + bArrB4.length;
                        byte[] bArrB5 = np.b(b("nid"));
                        System.arraycopy(bArrB5, 0, bArr7, length15, bArrB5.length);
                        int length16 = length15 + bArrB5.length;
                        byte[] bArrB6 = np.b(b(MapBundleKey.MapObjKey.OBJ_BID));
                        System.arraycopy(bArrB6, 0, bArr7, length16, bArrB6.length);
                        int length17 = length16 + bArrB6.length;
                        byte[] bArrC2 = np.c(b("lon"));
                        System.arraycopy(bArrC2, 0, bArr7, length17, bArrC2.length);
                        length2 = length17 + bArrC2.length;
                        byte[] bArrC3 = np.c(b(f.C));
                        System.arraycopy(bArrC3, 0, bArr7, length2, bArrC3.length);
                        length3 = bArrC3.length;
                    }
                    i3 = Integer.parseInt(b("signal"));
                    if (i3 > 127 || i3 < -128) {
                        i3 = 0;
                    }
                    bArr7[length13] = (byte) i3;
                    int i13 = length13 + 1;
                    byte[] bArrA3 = np.a(0, bArr3);
                    System.arraycopy(bArrA3, 0, bArr7, i13, bArrA3.length);
                    i2 = i13 + 2;
                    if (i != 1) {
                        if (TextUtils.isEmpty(this.B)) {
                            bArr7[i2] = 0;
                            i2++;
                        } else {
                            int length18 = this.B.split("\\*").length;
                            bArr7[i2] = (byte) length18;
                            i2++;
                            for (int i14 = 0; i14 < length18; i14++) {
                                byte[] bArrB7 = np.b(a("lac", i14));
                                System.arraycopy(bArrB7, 0, bArr7, i2, bArrB7.length);
                                int length19 = i2 + bArrB7.length;
                                byte[] bArrC4 = np.c(a("cellid", i14));
                                System.arraycopy(bArrC4, 0, bArr7, length19, bArrC4.length);
                                int length20 = length19 + bArrC4.length;
                                int i15 = Integer.parseInt(a("signal", i14));
                                if (i15 > 127 || i15 < -128) {
                                    i15 = 0;
                                }
                                bArr7[length20] = (byte) i15;
                                i2 = length20 + 1;
                            }
                        }
                    } else if (i == 2) {
                        bArr7[i2] = 0;
                        i2++;
                    }
                }
                length13 = length2 + length3;
                i3 = Integer.parseInt(b("signal"));
                if (i3 > 127) {
                    i3 = 0;
                    bArr7[length13] = (byte) i3;
                    int i132 = length13 + 1;
                    byte[] bArrA32 = np.a(0, bArr3);
                    System.arraycopy(bArrA32, 0, bArr7, i132, bArrA32.length);
                    i2 = i132 + 2;
                    if (i != 1) {
                    }
                }
            }
            str = this.D;
            if (str == null && (this.z & 8) == 8) {
                try {
                    byte[] bytes2 = str.getBytes("GBK");
                    int iMin2 = Math.min(bytes2.length, 60);
                    bArr7[i2] = (byte) iMin2;
                    i2++;
                    System.arraycopy(bytes2, 0, bArr7, i2, iMin2);
                    i4 = i2 + iMin2;
                } catch (Exception unused) {
                    bArr7[i2] = 0;
                    i4 = i2 + 1;
                }
            } else {
                bArr7[i2] = 0;
                i4 = i2 + 1;
            }
            ArrayList<nd> arrayList = this.C;
            int size = arrayList.size();
            if ((this.z & 4) == 4 || size <= 0) {
                bArr7[i4] = 0;
                length4 = i4 + 1;
            } else {
                if (!arrayList.get(0).p) {
                    size--;
                }
                bArr7[i4] = (byte) size;
                length4 = i4 + 1;
                for (int i16 = 0; i16 < size; i16++) {
                    nd ndVar = arrayList.get(i16);
                    if (ndVar.p) {
                        int i17 = ndVar.k;
                        if (i17 == 1 || i17 == 3 || i17 == 4) {
                            byte b3 = (byte) i17;
                            if (ndVar.n) {
                                b3 = (byte) (b3 | 8);
                            }
                            bArr7[length4] = b3;
                            int i18 = length4 + 1;
                            byte[] bArrA4 = np.a(ndVar.f3028a, bArr3);
                            System.arraycopy(bArrA4, 0, bArr7, i18, bArrA4.length);
                            int length21 = i18 + bArrA4.length;
                            byte[] bArrA5 = np.a(ndVar.b, bArr3);
                            System.arraycopy(bArrA5, 0, bArr7, length21, bArrA5.length);
                            int length22 = length21 + bArrA5.length;
                            byte[] bArrA6 = np.a(ndVar.c, bArr3);
                            System.arraycopy(bArrA6, 0, bArr7, length22, bArrA6.length);
                            length10 = length22 + bArrA6.length;
                            byte[] bArrB8 = np.b(ndVar.d, bArr4);
                            System.arraycopy(bArrB8, 0, bArr7, length10, bArrB8.length);
                            length11 = bArrB8.length;
                        } else {
                            if (i17 == 2) {
                                byte b4 = (byte) i17;
                                if (ndVar.n) {
                                    b4 = (byte) (b4 | 8);
                                }
                                bArr7[length4] = b4;
                                int i19 = length4 + 1;
                                byte[] bArrA7 = np.a(ndVar.f3028a, bArr3);
                                System.arraycopy(bArrA7, 0, bArr7, i19, bArrA7.length);
                                int length23 = i19 + bArrA7.length;
                                byte[] bArrA8 = np.a(ndVar.g, bArr3);
                                System.arraycopy(bArrA8, 0, bArr7, length23, bArrA8.length);
                                int length24 = length23 + bArrA8.length;
                                byte[] bArrA9 = np.a(ndVar.h, bArr3);
                                System.arraycopy(bArrA9, 0, bArr7, length24, bArrA9.length);
                                int length25 = length24 + bArrA9.length;
                                byte[] bArrA10 = np.a(ndVar.i, bArr3);
                                System.arraycopy(bArrA10, 0, bArr7, length25, bArrA10.length);
                                int length26 = length25 + bArrA10.length;
                                byte[] bArrB9 = np.b(ndVar.f, bArr4);
                                System.arraycopy(bArrB9, 0, bArr7, length26, bArrB9.length);
                                length10 = length26 + bArrB9.length;
                                byte[] bArrB10 = np.b(ndVar.e, bArr4);
                                System.arraycopy(bArrB10, 0, bArr7, length10, bArrB10.length);
                                length11 = bArrB10.length;
                            }
                            i9 = ndVar.j;
                            if (i9 <= 127 || i9 < -128) {
                                i9 = 99;
                            }
                            bArr7[length4] = (byte) i9;
                            int i20 = length4 + 1;
                            byte[] bArrA11 = np.a(ndVar.l, bArr3);
                            System.arraycopy(bArrA11, 0, bArr7, i20, bArrA11.length);
                            length4 = i20 + bArrA11.length;
                            if (Double.valueOf("5.1").doubleValue() < 5.0d) {
                                int i21 = ndVar.k;
                                if (i21 == 3 || i21 == 4) {
                                    int i22 = ndVar.o;
                                    if (i22 > 32767) {
                                        i22 = 32767;
                                    }
                                    byte[] bArrA12 = np.a(i22 >= 0 ? i22 : 32767, bArr3);
                                    System.arraycopy(bArrA12, 0, bArr7, length4, bArrA12.length);
                                    length4 += bArrA12.length;
                                }
                            }
                        }
                        length4 = length10 + length11;
                        i9 = ndVar.j;
                        if (i9 <= 127) {
                            i9 = 99;
                            bArr7[length4] = (byte) i9;
                            int i202 = length4 + 1;
                            byte[] bArrA112 = np.a(ndVar.l, bArr3);
                            System.arraycopy(bArrA112, 0, bArr7, i202, bArrA112.length);
                            length4 = i202 + bArrA112.length;
                            if (Double.valueOf("5.1").doubleValue() < 5.0d) {
                            }
                        }
                    }
                }
            }
            if (this.E.length() != 0) {
                bArr7[length4] = 0;
                i5 = length4 + 1;
            } else {
                bArr7[length4] = 1;
                int length27 = length4 + 1;
                try {
                    String[] strArrSplit = this.E.split(",");
                    byte[] bArrA13 = a(strArrSplit[0]);
                    System.arraycopy(bArrA13, 0, bArr7, length27, bArrA13.length);
                    length27 += bArrA13.length;
                    try {
                        byte[] bytes3 = strArrSplit[2].getBytes("GBK");
                        int length28 = bytes3.length;
                        if (length28 > 127) {
                            length28 = 127;
                        }
                        bArr7[length27] = (byte) length28;
                        length27++;
                        System.arraycopy(bytes3, 0, bArr7, length27, length28);
                        length27 += length28;
                    } catch (Throwable th2) {
                        nl.a(th2, "Req", "buildV4Dot214");
                        bArr7[length27] = 0;
                        length27++;
                    }
                    int i23 = Integer.parseInt(strArrSplit[1]);
                    if (i23 > 127 || i23 < -128) {
                        i23 = 0;
                    }
                    bArr7[length27] = Byte.parseByte(String.valueOf(i23));
                } catch (Throwable th3) {
                    nl.a(th3, "Req", "buildV4Dot216");
                    byte[] bArrA14 = a("00:00:00:00:00:00");
                    System.arraycopy(bArrA14, 0, bArr7, length27, bArrA14.length);
                    int length29 = length27 + bArrA14.length;
                    bArr7[length29] = 0;
                    length27 = length29 + 1;
                    bArr7[length27] = Byte.parseByte("0");
                }
                i5 = length27 + 1;
            }
            ArrayList<ScanResult> arrayList2 = this.F;
            iMin = Math.min(arrayList2.size(), 25);
            if (iMin != 0) {
                bArr7[i5] = 0;
                length5 = i5 + 1;
                b = 0;
            } else {
                bArr7[i5] = (byte) iMin;
                int length30 = i5 + 1;
                boolean z = np.c() >= 17;
                long jB = z ? np.b() / 1000 : 0L;
                int i24 = 0;
                while (i24 < iMin) {
                    ScanResult scanResult = arrayList2.get(i24);
                    byte[] bArrA15 = a(scanResult.BSSID);
                    System.arraycopy(bArrA15, b2, bArr7, length30, bArrA15.length);
                    int length31 = length30 + bArrA15.length;
                    try {
                        byte[] bytes4 = scanResult.SSID.getBytes("GBK");
                        bArr7[length31] = (byte) bytes4.length;
                        length31++;
                        System.arraycopy(bytes4, b2, bArr7, length31, bytes4.length);
                        length6 = length31 + bytes4.length;
                        i6 = 1;
                    } catch (Exception unused2) {
                        bArr7[length31] = b2;
                        i6 = 1;
                        length6 = length31 + 1;
                    }
                    int i25 = scanResult.level;
                    if (i25 > 127 || i25 < -128) {
                        i25 = 0;
                    }
                    bArr7[length6] = Byte.parseByte(String.valueOf(i25));
                    int i26 = length6 + i6;
                    long j = jB;
                    if (!z || (i7 = (int) (j - ((scanResult.timestamp / 1000000) + 1))) < 0) {
                        i7 = 0;
                    }
                    if (i7 > 65535) {
                        i7 = 65535;
                    }
                    byte[] bArrA16 = np.a(i7, bArr3);
                    System.arraycopy(bArrA16, 0, bArr7, i26, bArrA16.length);
                    int length32 = i26 + bArrA16.length;
                    byte[] bArrA17 = np.a(scanResult.frequency, bArr3);
                    System.arraycopy(bArrA17, 0, bArr7, length32, bArrA17.length);
                    length30 = length32 + bArrA17.length;
                    i24++;
                    jB = j;
                    b2 = 0;
                }
                b = 0;
                byte[] bArrA18 = np.a(Integer.parseInt(this.G), bArr3);
                System.arraycopy(bArrA18, 0, bArr7, length30, bArrA18.length);
                length5 = length30 + bArrA18.length;
            }
            bArr7[length5] = b;
            int i27 = length5 + 1;
            try {
                bytes = this.H.getBytes("GBK");
                if (bytes.length > 127) {
                    bytes = null;
                }
            } catch (Throwable unused3) {
                bArr7[i27] = 0;
            }
            if (bytes != null) {
                bArr7[i27] = 0;
                length7 = i27 + 1;
                bArrA = new byte[]{0, 0};
                try {
                    zIsEmpty = TextUtils.isEmpty(this.K);
                    if (!zIsEmpty) {
                        bArrA = np.a(this.K.length(), bArr3);
                    }
                    System.arraycopy(bArrA, 0, bArr7, length7, 2);
                    length8 = length7 + 2;
                    if (!zIsEmpty) {
                        try {
                            byte[] bytes5 = this.K.getBytes("GBK");
                            System.arraycopy(bytes5, 0, bArr7, length8, bytes5.length);
                            length8 += bytes5.length;
                        } catch (Throwable unused4) {
                        }
                    }
                    i8 = 2;
                } catch (Throwable unused5) {
                    i8 = 2;
                    length8 = length7 + 2;
                }
                try {
                    System.arraycopy(np.a(0, bArr3), 0, bArr7, length8, i8);
                } catch (Throwable unused6) {
                }
                int i28 = length8 + i8;
                byte[] bArr8 = new byte[i8];
                // fill-array-data instruction
                bArr8[0] = 0;
                bArr8[1] = 0;
                try {
                    System.arraycopy(bArr8, 0, bArr7, i28, i8);
                } catch (Throwable unused7) {
                }
                int i29 = i28 + i8;
                bArr = this.I;
                if (bArr == null) {
                    length9 = bArr.length;
                    bArr2 = null;
                } else {
                    bArr2 = null;
                    length9 = 0;
                }
                byte[] bArrA19 = np.a(length9, bArr2);
                System.arraycopy(bArrA19, 0, bArr7, i29, bArrA19.length);
                int length33 = i29 + bArrA19.length;
                if (length9 > 0) {
                    byte[] bArr9 = this.I;
                    System.arraycopy(bArr9, 0, bArr7, length33, bArr9.length);
                    length33 += this.I.length;
                }
                if (Double.valueOf("5.1").doubleValue() >= 5.0d) {
                    bArr7[length33] = 0;
                    length33 = a(this.N, bArr7, length33 + 1);
                }
                byte[] bArr10 = new byte[length33];
                System.arraycopy(bArr7, 0, bArr10, 0, length33);
                CRC32 crc32 = new CRC32();
                crc32.update(bArr10);
                byte[] bArrA20 = np.a(crc32.getValue());
                byte[] bArr11 = new byte[length33 + 8];
                System.arraycopy(bArr10, 0, bArr11, 0, length33);
                System.arraycopy(bArrA20, 0, bArr11, length33, 8);
                return bArr11;
            }
            bArr7[i27] = (byte) bytes.length;
            int i30 = i27 + 1;
            System.arraycopy(bytes, 0, bArr7, i30, bytes.length);
            length7 = i30 + bytes.length;
            bArrA = new byte[]{0, 0};
            zIsEmpty = TextUtils.isEmpty(this.K);
            if (!zIsEmpty) {
            }
            System.arraycopy(bArrA, 0, bArr7, length7, 2);
            length8 = length7 + 2;
            if (!zIsEmpty) {
            }
            i8 = 2;
            System.arraycopy(np.a(0, bArr3), 0, bArr7, length8, i8);
            int i282 = length8 + i8;
            byte[] bArr82 = new byte[i8];
            // fill-array-data instruction
            bArr82[0] = 0;
            bArr82[1] = 0;
            System.arraycopy(bArr82, 0, bArr7, i282, i8);
            int i292 = i282 + i8;
            bArr = this.I;
            if (bArr == null) {
            }
            byte[] bArrA192 = np.a(length9, bArr2);
            System.arraycopy(bArrA192, 0, bArr7, i292, bArrA192.length);
            int length332 = i292 + bArrA192.length;
            if (length9 > 0) {
            }
            if (Double.valueOf("5.1").doubleValue() >= 5.0d) {
            }
            byte[] bArr102 = new byte[length332];
            System.arraycopy(bArr7, 0, bArr102, 0, length332);
            CRC32 crc322 = new CRC32();
            crc322.update(bArr102);
            byte[] bArrA202 = np.a(crc322.getValue());
            byte[] bArr112 = new byte[length332 + 8];
            System.arraycopy(bArr102, 0, bArr112, 0, length332);
            System.arraycopy(bArrA202, 0, bArr112, length332, 8);
            return bArr112;
        }
        byte[] bArrA21 = a(this.t);
        bArr7[iA] = (byte) bArrA21.length;
        int i31 = iA + 1;
        System.arraycopy(bArrA21, 0, bArr7, i31, bArrA21.length);
        length = i31 + bArrA21.length;
        int iA22 = a(this.x, bArr7, a(L, bArr7, a(J, bArr7, a(this.w, bArr7, a(this.v, bArr7, length)))));
        bArr7[iA22] = Byte.parseByte(this.y);
        int i102 = iA22 + 1;
        bArr7[i102] = Byte.parseByte(this.j);
        int i112 = i102 + 1;
        int i122 = this.z;
        i = i122 & 3;
        bArr7[i112] = (byte) i122;
        i2 = i112 + 1;
        if (i != 1) {
            byte[] bArrB11 = np.b(b("mcc"));
            System.arraycopy(bArrB11, 0, bArr7, i2, bArrB11.length);
            int length132 = i2 + bArrB11.length;
            if (i != 1) {
            }
            length132 = length2 + length3;
            i3 = Integer.parseInt(b("signal"));
            if (i3 > 127) {
            }
        }
        str = this.D;
        if (str == null) {
            bArr7[i2] = 0;
            i4 = i2 + 1;
        }
        ArrayList<nd> arrayList3 = this.C;
        int size2 = arrayList3.size();
        if ((this.z & 4) == 4) {
            bArr7[i4] = 0;
            length4 = i4 + 1;
        }
        if (this.E.length() != 0) {
        }
        ArrayList<ScanResult> arrayList22 = this.F;
        iMin = Math.min(arrayList22.size(), 25);
        if (iMin != 0) {
        }
        bArr7[length5] = b;
        int i272 = length5 + 1;
        bytes = this.H.getBytes("GBK");
        if (bytes.length > 127) {
        }
        if (bytes != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000f A[Catch: all -> 0x003e, TryCatch #0 {all -> 0x003e, blocks: (B:4:0x000c, B:10:0x001c, B:12:0x001f, B:14:0x0028, B:15:0x0030, B:6:0x000f, B:8:0x0014), top: B:20:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte[] a(String str) {
        String[] strArrSplit = str.split(":");
        byte[] bArr = new byte[6];
        if (strArrSplit != null) {
            try {
                if (strArrSplit.length != 6) {
                    strArrSplit = new String[6];
                    for (int i = 0; i < 6; i++) {
                        strArrSplit[i] = "0";
                    }
                }
            } catch (Throwable th) {
                nl.a(th, "Req", "getMacBa ".concat(str));
                return a("00:00:00:00:00:00");
            }
        }
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            if (strArrSplit[i2].length() > 2) {
                strArrSplit[i2] = strArrSplit[i2].substring(0, 2);
            }
            bArr[i2] = (byte) Integer.parseInt(strArrSplit[i2], 16);
        }
        return bArr;
    }
}
