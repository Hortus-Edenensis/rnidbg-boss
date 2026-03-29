package com.amap.api.col.p0002sl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.CRC32;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@SuppressLint({"NewApi"})
public final class mc {
    protected static String I;
    protected static String K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2996a = "1";
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
    protected ArrayList<ll> A = new ArrayList<>();
    protected ArrayList<ll> B = new ArrayList<>();
    protected String C = null;
    protected String D = null;
    protected ArrayList<kr> E = new ArrayList<>();
    protected String F = null;
    protected String G = null;
    protected byte[] H = null;
    private byte[] Q = null;
    private int R = 0;
    protected String J = null;
    protected String L = null;
    protected String M = null;
    protected String N = null;
    protected int O = 0;
    private List<ln> S = null;
    private List<ll> T = Collections.synchronizedList(new ArrayList());
    final int P = 3;

    private void b() {
        String[] strArr = {this.f2996a, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.D, this.F, this.G, I, this.M, this.N};
        for (int i = 0; i < 27; i++) {
            if (TextUtils.isEmpty(strArr[i])) {
                strArr[i] = "";
            }
        }
        if (TextUtils.isEmpty(this.j)) {
            this.j = "0";
        } else if (!"0".equals(this.j) && !"2".equals(this.j)) {
            this.j = "0";
        }
        if (TextUtils.isEmpty(this.k)) {
            this.k = "0";
        } else if (!"0".equals(this.k) && !"1".equals(this.k)) {
            this.k = "0";
        }
        if (TextUtils.isEmpty(this.y)) {
            this.y = "0";
        } else if (!"1".equals(this.y) && !"2".equals(this.y)) {
            this.y = "0";
        }
        if (!lm.a(this.z)) {
            this.z = 0;
        }
        if (this.H == null) {
            this.H = new byte[0];
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:13|18|19|(20:25|(1:27)(1:28)|29|(7:31|(1:33)(1:34)|35|(1:37)(1:38)|39|(1:41)(1:42)|43)(12:(11:46|(1:48)(1:49)|50|(1:52)(1:53)|54|(1:56)(1:57)|58|(1:60)(1:61)|62|(1:64)(1:65)|66)|67|(1:69)(1:70)|(1:72)|75|(1:77)(1:78)|79|(1:81)|82|(1:84)|85|(2:87|(1:89)(3:90|(11:92|(1:94)(1:95)|96|(1:98)(1:99)|100|(1:102)(1:103)|104|(1:106)|110|(8:112|(1:114)(1:115)|116|(1:118)|119|(1:121)|122|397)(2:123|396)|124)|395))(14:125|(1:127)|128|(1:134)(3:367|132|133)|135|(1:199)(4:138|(7:140|(3:157|(1:159)|160)(1:(3:147|(1:149)|150)(2:151|(3:153|(1:155)|156)))|161|(1:163)|167|(2:186|(1:386)(5:188|(1:190)|(1:193)|194|(3:196|185|385)(1:387)))(2:174|(1:384)(6:178|(1:180)|(1:183)|184|185|385))|197)|382|198)|200|(1:228)(14:205|365|206|207|373|208|(1:210)|211|212|215|(1:217)|221|(2:223|224)|225)|229|(1:231)(7:232|(1:234)(1:235)|(1:237)|238|(10:240|371|241|242|244|(1:247)|251|(1:255)|(2:257|393)(1:394)|258)|392|259)|260|362|261|(28:263|273|274|369|275|(1:277)|278|279|(3:363|281|282)|283|285|380|286|287|376|288|289|(1:291)(1:292)|293|(1:295)|296|(5:298|(1:300)(1:301)|302|(5:378|304|(6:307|(3:325|(1:327)|328)(2:313|(3:315|(1:317)|318)(4:319|(3:321|(1:323)|324)|330|331))|329|330|331|305)|388|332)|334)|335|(4:337|(1:339)(1:340)|341|(3:343|(6:346|(1:348)|349|(2:351|390)(1:391)|352|344)|389))|353|(1:355)|356|357)(3:264|(1:266)|(29:268|272|273|274|369|275|(0)|278|279|(0)|283|285|380|286|287|376|288|289|(0)(0)|293|(0)|296|(0)|335|(0)|353|(0)|356|357)(28:269|270|274|369|275|(0)|278|279|(0)|283|285|380|286|287|376|288|289|(0)(0)|293|(0)|296|(0)|335|(0)|353|(0)|356|357))))|44|67|(0)(0)|(9:72|75|(0)(0)|79|(0)|82|(0)|85|(0)(0))(0)|128|(2:130|134)(0)|135|(1:199)(0)|200|(2:202|228)(0)|229|(0)(0)|260|362|261|(0)(0))(1:23)|24|128|(0)(0)|135|(0)(0)|200|(0)(0)|229|(0)(0)|260|362|261|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x06e0, code lost:
    
        r13[r8] = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x034d A[PHI: r0
      0x034d: PHI (r0v51 int) = (r0v50 int), (r0v50 int), (r0v162 int) binds: [B:129:0x0331, B:131:0x0336, B:361:0x034d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0364 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x053a  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x05f3  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x060a  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0610  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x06bf A[Catch: all -> 0x06e0, TryCatch #0 {all -> 0x06e0, blocks: (B:261:0x06bb, B:263:0x06bf, B:264:0x06c2, B:268:0x06ce, B:269:0x06d2), top: B:362:0x06bb }] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x06c2 A[Catch: all -> 0x06e0, TryCatch #0 {all -> 0x06e0, blocks: (B:261:0x06bb, B:263:0x06bf, B:264:0x06c2, B:268:0x06ce, B:269:0x06d2), top: B:362:0x06bb }] */
    /* JADX WARN: Removed duplicated region for block: B:277:0x06f3 A[Catch: all -> 0x0714, TryCatch #4 {all -> 0x0714, blocks: (B:275:0x06eb, B:277:0x06f3, B:278:0x06fd), top: B:369:0x06eb }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x072c  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x072e  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x073d  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0757  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x084f  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x08f9  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0705 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0216 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0256  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] a() {
        int length;
        int i;
        int length2;
        int length3;
        int length4;
        int i2;
        byte[] bArr;
        long jB;
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        long jB2;
        String str;
        int i3;
        byte[] bArr5;
        byte[] bArr6;
        byte b;
        int length5;
        int i4;
        byte b2;
        int length6;
        int iMin;
        byte b3;
        int length7;
        int i5;
        int length8;
        int i6;
        int length9;
        byte[] bArrA;
        int i7;
        int length10;
        int length11;
        int length12;
        int length13;
        boolean zIsEmpty;
        String str2;
        int i8;
        byte[] bArr7;
        int length14;
        int length15;
        b();
        int i9 = 2;
        byte[] bArr8 = new byte[2];
        byte[] bArr9 = new byte[4];
        byte[] bArr10 = this.H;
        int i10 = 1;
        int length16 = bArr10 != null ? 4096 + bArr10.length + 1 : 4096;
        byte[] bArr11 = this.Q;
        if (bArr11 == null || length16 > this.R) {
            bArr11 = new byte[length16];
            this.Q = bArr11;
            this.R = length16;
        }
        byte[] bArr12 = bArr11;
        int i11 = 0;
        bArr12[0] = mm.g(this.f2996a);
        byte[] bArr13 = null;
        byte[] bArrA2 = mm.a(this.b, (byte[]) null);
        System.arraycopy(bArrA2, 0, bArr12, 1, bArrA2.length);
        int iA = a(this.q, bArr12, a(this.p, bArr12, a(this.h, bArr12, a(this.u, bArr12, a(this.g, bArr12, a(this.f, bArr12, a(this.e, bArr12, a(this.o, bArr12, a(this.d, bArr12, a(this.c, bArr12, bArrA2.length + 1))))))))));
        try {
        } catch (Throwable th) {
            me.a(th, "Req", "buildV4Dot219");
            bArr12[iA] = 0;
        }
        if (TextUtils.isEmpty(this.t)) {
            bArr12[iA] = 0;
            length = iA + 1;
            int iA2 = a(this.x, bArr12, a(K, bArr12, a(I, bArr12, a(this.w, bArr12, a(this.v, bArr12, length)))));
            bArr12[iA2] = Byte.parseByte(this.y);
            int i12 = iA2 + 1;
            bArr12[i12] = Byte.parseByte(this.j);
            int i13 = i12 + 1;
            int i14 = this.z;
            i = i14 & 3;
            bArr12[i13] = (byte) i14;
            length2 = i13 + 1;
            if (i != 1 || i == 2) {
                byte[] bArrA3 = mm.a(this.A.size() <= 0 ? this.A.get(0).f2970a : 0, (byte[]) null);
                System.arraycopy(bArrA3, 0, bArr12, length2, bArrA3.length);
                int length17 = length2 + bArrA3.length;
                if (i != 1) {
                    byte[] bArrA4 = mm.a(this.A.size() > 0 ? this.A.get(0).b : 0, (byte[]) null);
                    System.arraycopy(bArrA4, 0, bArr12, length17, bArrA4.length);
                    int length18 = length17 + bArrA4.length;
                    byte[] bArrA5 = mm.a(this.A.size() > 0 ? this.A.get(0).c : 0, (byte[]) null);
                    System.arraycopy(bArrA5, 0, bArr12, length18, bArrA5.length);
                    length3 = length18 + bArrA5.length;
                    byte[] bArrB = mm.b(this.A.size() > 0 ? this.A.get(0).d : 0, (byte[]) null);
                    System.arraycopy(bArrB, 0, bArr12, length3, bArrB.length);
                    length4 = bArrB.length;
                } else {
                    if (i == 2) {
                        byte[] bArrA6 = mm.a(this.A.size() > 0 ? this.A.get(0).h : 0, (byte[]) null);
                        System.arraycopy(bArrA6, 0, bArr12, length17, bArrA6.length);
                        int length19 = length17 + bArrA6.length;
                        byte[] bArrA7 = mm.a(this.A.size() > 0 ? this.A.get(0).i : 0, (byte[]) null);
                        System.arraycopy(bArrA7, 0, bArr12, length19, bArrA7.length);
                        int length20 = length19 + bArrA7.length;
                        byte[] bArrA8 = mm.a(this.A.size() > 0 ? this.A.get(0).j : 0, (byte[]) null);
                        System.arraycopy(bArrA8, 0, bArr12, length20, bArrA8.length);
                        int length21 = length20 + bArrA8.length;
                        byte[] bArrB2 = mm.b(this.A.size() > 0 ? this.A.get(0).g : 0, (byte[]) null);
                        System.arraycopy(bArrB2, 0, bArr12, length21, bArrB2.length);
                        length3 = length21 + bArrB2.length;
                        byte[] bArrB3 = mm.b(this.A.size() > 0 ? this.A.get(0).f : 0, (byte[]) null);
                        System.arraycopy(bArrB3, 0, bArr12, length3, bArrB3.length);
                        length4 = bArrB3.length;
                    }
                    i2 = this.A.size() > 0 ? this.A.get(0).k : 0;
                    if (i2 > 127 || i2 < -128) {
                        i2 = 0;
                    }
                    bArr12[length17] = (byte) i2;
                    int i15 = length17 + 1;
                    if (this.A.size() <= 0) {
                        bArr = bArr9;
                        jB = (mm.b() - this.A.get(0).t) / 1000;
                    } else {
                        bArr = bArr9;
                        jB = 0;
                    }
                    if (jB > WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                        jB = 65535;
                    }
                    if (jB < 0) {
                        jB = 0;
                    }
                    byte[] bArrA9 = mm.a((int) jB, bArr8);
                    System.arraycopy(bArrA9, 0, bArr12, i15, bArrA9.length);
                    length2 = i15 + 2;
                    if (i == 1) {
                        bArr2 = bArr12;
                        if (i == 2) {
                            bArr2[length2] = 0;
                            length2++;
                        }
                        str = this.C;
                        if (str == null && (this.z & 8) == 8) {
                            try {
                                byte[] bytes = str.getBytes("GBK");
                                int iMin2 = Math.min(bytes.length, 60);
                                bArr2[length2] = (byte) iMin2;
                                length2++;
                                System.arraycopy(bytes, 0, bArr2, length2, iMin2);
                                i3 = length2 + iMin2;
                            } catch (Exception unused) {
                                bArr2[length2] = 0;
                                i3 = length2 + 1;
                            }
                        } else {
                            bArr2[length2] = 0;
                            i3 = length2 + 1;
                        }
                        ArrayList<ll> arrayList = this.B;
                        int size = arrayList.size();
                        int i16 = 5;
                        int i17 = 3;
                        if ((this.z & 4) == 4 || size <= 0) {
                            bArr5 = bArr2;
                            bArr6 = bArr;
                            bArr5[i3] = 0;
                            b = 1;
                            length5 = i3 + 1;
                        } else {
                            arrayList.get(0);
                            bArr2[i3] = (byte) size;
                            int i18 = 1;
                            length5 = i3 + 1;
                            int i19 = 0;
                            while (i19 < size) {
                                ll llVar = arrayList.get(i19);
                                int i20 = llVar.l;
                                if (i20 == i18 || i20 == i17 || i20 == 4) {
                                    bArr7 = bArr;
                                    byte b4 = (byte) i20;
                                    if (llVar.n) {
                                        b4 = (byte) (b4 | 8);
                                    }
                                    bArr2[length5] = b4;
                                    int i21 = length5 + 1;
                                    byte[] bArrA10 = mm.a(llVar.f2970a, bArr8);
                                    System.arraycopy(bArrA10, i11, bArr2, i21, bArrA10.length);
                                    int length22 = i21 + bArrA10.length;
                                    byte[] bArrA11 = mm.a(llVar.b, bArr8);
                                    System.arraycopy(bArrA11, i11, bArr2, length22, bArrA11.length);
                                    int length23 = length22 + bArrA11.length;
                                    byte[] bArrA12 = mm.a(llVar.c, bArr8);
                                    System.arraycopy(bArrA12, i11, bArr2, length23, bArrA12.length);
                                    int length24 = length23 + bArrA12.length;
                                    byte[] bArrB4 = mm.b(llVar.d, bArr7);
                                    System.arraycopy(bArrB4, i11, bArr2, length24, bArrB4.length);
                                    length5 = length24 + bArrB4.length;
                                } else if (i20 == i9) {
                                    byte b5 = (byte) i20;
                                    if (llVar.n) {
                                        b5 = (byte) (b5 | 8);
                                    }
                                    bArr2[length5] = b5;
                                    int i22 = length5 + 1;
                                    byte[] bArrA13 = mm.a(llVar.f2970a, bArr8);
                                    System.arraycopy(bArrA13, i11, bArr2, i22, bArrA13.length);
                                    int length25 = i22 + bArrA13.length;
                                    byte[] bArrA14 = mm.a(llVar.h, bArr8);
                                    System.arraycopy(bArrA14, i11, bArr2, length25, bArrA14.length);
                                    int length26 = length25 + bArrA14.length;
                                    byte[] bArrA15 = mm.a(llVar.i, bArr8);
                                    System.arraycopy(bArrA15, i11, bArr2, length26, bArrA15.length);
                                    int length27 = length26 + bArrA15.length;
                                    byte[] bArrA16 = mm.a(llVar.j, bArr8);
                                    System.arraycopy(bArrA16, i11, bArr2, length27, bArrA16.length);
                                    int length28 = length27 + bArrA16.length;
                                    bArr7 = bArr;
                                    byte[] bArrB5 = mm.b(llVar.g, bArr7);
                                    System.arraycopy(bArrB5, i11, bArr2, length28, bArrB5.length);
                                    int length29 = length28 + bArrB5.length;
                                    byte[] bArrB6 = mm.b(llVar.f, bArr7);
                                    System.arraycopy(bArrB6, i11, bArr2, length29, bArrB6.length);
                                    length5 = length29 + bArrB6.length;
                                } else {
                                    bArr7 = bArr;
                                    if (i20 == i16) {
                                        byte b6 = (byte) i20;
                                        if (llVar.n) {
                                            b6 = (byte) (b6 | 8);
                                        }
                                        bArr2[length5] = b6;
                                        int i23 = length5 + 1;
                                        byte[] bArrA17 = mm.a(llVar.f2970a, bArr8);
                                        System.arraycopy(bArrA17, i11, bArr2, i23, bArrA17.length);
                                        int length30 = i23 + bArrA17.length;
                                        byte[] bArrA18 = mm.a(llVar.b, bArr8);
                                        System.arraycopy(bArrA18, i11, bArr2, length30, bArrA18.length);
                                        int length31 = length30 + bArrA18.length;
                                        byte[] bArrA19 = mm.a(llVar.c, bArr8);
                                        System.arraycopy(bArrA19, i11, bArr2, length31, bArrA19.length);
                                        int length32 = length31 + bArrA19.length;
                                        System.arraycopy(mm.a(llVar.e), i11, bArr2, length32, 8);
                                        length5 = length32 + 8;
                                    }
                                }
                                int i24 = llVar.k;
                                if (i24 > 127 || i24 < -128) {
                                    i24 = 99;
                                }
                                bArr2[length5] = (byte) i24;
                                int i25 = length5 + 1;
                                byte[] bArr14 = bArr2;
                                byte[] bArrA20 = mm.a((short) ((mm.b() - llVar.t) / 1000), bArr8);
                                System.arraycopy(bArrA20, 0, bArr14, i25, bArrA20.length);
                                length5 = i25 + bArrA20.length;
                                int i26 = llVar.l;
                                if (i26 == 3 || i26 == 4 || i26 == 5) {
                                    if (Double.valueOf(me.f2999a).doubleValue() >= 5.0d) {
                                        int i27 = llVar.o;
                                        if (i27 > 32767) {
                                            i27 = 32767;
                                        }
                                        byte[] bArrA21 = mm.a(i27 >= 0 ? i27 : 32767, bArr8);
                                        System.arraycopy(bArrA21, 0, bArr14, length5, bArrA21.length);
                                        length5 += bArrA21.length;
                                        if (Double.valueOf(me.f2999a).doubleValue() >= 5.3d) {
                                            byte[] bArrB7 = mm.b(llVar.p, bArr7);
                                            System.arraycopy(bArrB7, 0, bArr14, length5, bArrB7.length);
                                            length14 = length5 + bArrB7.length;
                                            byte[] bArrB8 = mm.b(llVar.q, bArr7);
                                            System.arraycopy(bArrB8, 0, bArr14, length14, bArrB8.length);
                                            length15 = bArrB8.length;
                                            length5 = length14 + length15;
                                        }
                                    }
                                } else if (i26 == 1 && Double.valueOf(me.f2999a).doubleValue() >= 5.3d) {
                                    int i28 = llVar.o;
                                    if (i28 > 32767) {
                                        i28 = 32767;
                                    }
                                    byte[] bArrA22 = mm.a(i28 >= 0 ? i28 : 32767, bArr8);
                                    System.arraycopy(bArrA22, 0, bArr14, length5, bArrA22.length);
                                    int length33 = length5 + bArrA22.length;
                                    byte[] bArrB9 = mm.b(llVar.p, bArr7);
                                    System.arraycopy(bArrB9, 0, bArr14, length33, bArrB9.length);
                                    length14 = length33 + bArrB9.length;
                                    byte[] bArrB10 = mm.b(llVar.q, bArr7);
                                    System.arraycopy(bArrB10, 0, bArr14, length14, bArrB10.length);
                                    length15 = bArrB10.length;
                                    length5 = length14 + length15;
                                }
                                i19++;
                                bArr = bArr7;
                                bArr2 = bArr14;
                                i9 = 2;
                                i11 = 0;
                                i18 = 1;
                                i16 = 5;
                                i17 = 3;
                            }
                            bArr5 = bArr2;
                            bArr6 = bArr;
                            b = 1;
                        }
                        if (!TextUtils.isEmpty(this.D) || this.D.length() == 0) {
                            i4 = 1;
                            b2 = 0;
                            bArr5[length5] = 0;
                            length6 = length5 + 1;
                        } else {
                            bArr5[length5] = b;
                            length6 = length5 + 1;
                            try {
                                String[] strArrSplit = this.D.split(",");
                                byte[] bArrA23 = a(strArrSplit[0]);
                                System.arraycopy(bArrA23, 0, bArr5, length6, bArrA23.length);
                                length6 += bArrA23.length;
                                try {
                                    byte[] bytes2 = strArrSplit[2].getBytes("GBK");
                                    int length34 = bytes2.length;
                                    if (length34 > 127) {
                                        length34 = 127;
                                    }
                                    bArr5[length6] = (byte) length34;
                                    length6++;
                                    System.arraycopy(bytes2, 0, bArr5, length6, length34);
                                    i8 = length6 + length34;
                                } catch (Throwable th2) {
                                    me.a(th2, "Req", "buildV4Dot214");
                                    bArr5[length6] = 0;
                                    i8 = length6 + 1;
                                }
                                int i29 = Integer.parseInt(strArrSplit[1]);
                                if (i29 > 127 || i29 < -128) {
                                    i29 = 0;
                                }
                                bArr5[i8] = Byte.parseByte(String.valueOf(i29));
                                length6 = i8 + 1;
                                if (Double.valueOf(me.f2999a).doubleValue() >= 5.2d) {
                                    byte[] bArrA24 = mm.a(this.O, bArr8);
                                    System.arraycopy(bArrA24, 0, bArr5, length6, bArrA24.length);
                                    length6 += bArrA24.length;
                                }
                                i4 = 1;
                                b2 = 0;
                            } catch (Throwable th3) {
                                me.a(th3, "Req", "buildV4Dot216");
                                byte[] bArrA25 = a("00:00:00:00:00:00");
                                b2 = 0;
                                System.arraycopy(bArrA25, 0, bArr5, length6, bArrA25.length);
                                int length35 = length6 + bArrA25.length;
                                bArr5[length35] = 0;
                                i4 = 1;
                                int i30 = length35 + 1;
                                bArr5[i30] = Byte.parseByte("0");
                                length6 = i30 + 1;
                            }
                        }
                        ArrayList<kr> arrayList2 = this.E;
                        iMin = Math.min(arrayList2.size(), 25);
                        if (iMin != 0) {
                            bArr5[length6] = b2;
                            length7 = length6 + i4;
                            b3 = 0;
                        } else {
                            bArr5[length6] = (byte) iMin;
                            int length36 = length6 + i4;
                            boolean z = mm.c() >= 17;
                            long jB3 = z ? mm.b() / 1000 : 0L;
                            for (int i31 = 0; i31 < iMin; i31++) {
                                kr krVar = arrayList2.get(i31);
                                byte[] bArrA26 = a(kr.a(krVar.f2946a));
                                System.arraycopy(bArrA26, 0, bArr5, length36, bArrA26.length);
                                int length37 = length36 + bArrA26.length;
                                try {
                                    byte[] bytes3 = krVar.b.getBytes("GBK");
                                    bArr5[length37] = (byte) bytes3.length;
                                    length37++;
                                    System.arraycopy(bytes3, 0, bArr5, length37, bytes3.length);
                                    length8 = length37 + bytes3.length;
                                    i5 = 1;
                                } catch (Exception unused2) {
                                    bArr5[length37] = 0;
                                    i5 = 1;
                                    length8 = length37 + 1;
                                }
                                int i32 = krVar.c;
                                if (i32 > 127 || i32 < -128) {
                                    i32 = 0;
                                }
                                bArr5[length8] = Byte.parseByte(String.valueOf(i32));
                                int i33 = length8 + i5;
                                if (!z || (i6 = (int) (jB3 - (krVar.f / 1000))) < 0) {
                                    i6 = 0;
                                }
                                if (i6 > 65535) {
                                    i6 = 65535;
                                }
                                byte[] bArrA27 = mm.a(i6, bArr8);
                                System.arraycopy(bArrA27, 0, bArr5, i33, bArrA27.length);
                                int length38 = i33 + bArrA27.length;
                                byte[] bArrA28 = mm.a(krVar.d, bArr8);
                                System.arraycopy(bArrA28, 0, bArr5, length38, bArrA28.length);
                                length36 = length38 + bArrA28.length;
                            }
                            b3 = 0;
                            byte[] bArrA29 = mm.a(Integer.parseInt(this.F), bArr8);
                            System.arraycopy(bArrA29, 0, bArr5, length36, bArrA29.length);
                            length7 = length36 + bArrA29.length;
                        }
                        bArr5[length7] = b3;
                        int i34 = 1;
                        int i35 = length7 + 1;
                        str2 = this.G;
                        if (str2 == null) {
                            byte[] bytes4 = str2.getBytes("GBK");
                            if (bytes4.length > 127) {
                                bytes4 = null;
                            }
                            if (bytes4 == null) {
                                bArr5[i35] = 0;
                                i34 = 1;
                                length9 = i35 + i34;
                                bArrA = new byte[]{0, 0};
                                zIsEmpty = TextUtils.isEmpty(this.J);
                                if (!zIsEmpty) {
                                }
                                System.arraycopy(bArrA, 0, bArr5, length9, 2);
                                length10 = length9 + 2;
                                if (!zIsEmpty) {
                                }
                                i7 = 2;
                                System.arraycopy(mm.a(0, bArr8), 0, bArr5, length10, i7);
                                int i36 = length10 + i7;
                                byte[] bArr15 = new byte[i7];
                                // fill-array-data instruction
                                bArr15[0] = 0;
                                bArr15[1] = 0;
                                System.arraycopy(bArr15, 0, bArr5, i36, i7);
                                int i37 = i36 + i7;
                                byte[] bArr16 = this.H;
                                if (bArr16 != null) {
                                }
                                byte[] bArrA30 = mm.a(length11, (byte[]) null);
                                System.arraycopy(bArrA30, 0, bArr5, i37, bArrA30.length);
                                int length39 = i37 + bArrA30.length;
                                if (length11 > 0) {
                                }
                                if (Double.valueOf(me.f2999a).doubleValue() >= 5.0d) {
                                }
                                if (Double.valueOf(me.f2999a).doubleValue() >= 5.2d) {
                                }
                                if (Double.valueOf(me.f2999a).doubleValue() >= 5.3d) {
                                }
                                byte[] bArr17 = new byte[length39];
                                System.arraycopy(bArr5, 0, bArr17, 0, length39);
                                CRC32 crc32 = new CRC32();
                                crc32.update(bArr17);
                                byte[] bArrA31 = mm.a(crc32.getValue());
                                byte[] bArr18 = new byte[length39 + 8];
                                System.arraycopy(bArr17, 0, bArr18, 0, length39);
                                System.arraycopy(bArrA31, 0, bArr18, length39, 8);
                                return bArr18;
                            }
                            bArr5[i35] = (byte) bytes4.length;
                            int i38 = i35 + 1;
                            System.arraycopy(bytes4, 0, bArr5, i38, bytes4.length);
                            length9 = i38 + bytes4.length;
                            bArrA = new byte[]{0, 0};
                            zIsEmpty = TextUtils.isEmpty(this.J);
                            if (!zIsEmpty) {
                            }
                            System.arraycopy(bArrA, 0, bArr5, length9, 2);
                            length10 = length9 + 2;
                            if (!zIsEmpty) {
                            }
                            i7 = 2;
                            System.arraycopy(mm.a(0, bArr8), 0, bArr5, length10, i7);
                            int i362 = length10 + i7;
                            byte[] bArr152 = new byte[i7];
                            // fill-array-data instruction
                            bArr152[0] = 0;
                            bArr152[1] = 0;
                            System.arraycopy(bArr152, 0, bArr5, i362, i7);
                            int i372 = i362 + i7;
                            byte[] bArr162 = this.H;
                            if (bArr162 != null) {
                            }
                            byte[] bArrA302 = mm.a(length11, (byte[]) null);
                            System.arraycopy(bArrA302, 0, bArr5, i372, bArrA302.length);
                            int length392 = i372 + bArrA302.length;
                            if (length11 > 0) {
                            }
                            if (Double.valueOf(me.f2999a).doubleValue() >= 5.0d) {
                            }
                            if (Double.valueOf(me.f2999a).doubleValue() >= 5.2d) {
                            }
                            if (Double.valueOf(me.f2999a).doubleValue() >= 5.3d) {
                            }
                            byte[] bArr172 = new byte[length392];
                            System.arraycopy(bArr5, 0, bArr172, 0, length392);
                            CRC32 crc322 = new CRC32();
                            crc322.update(bArr172);
                            byte[] bArrA312 = mm.a(crc322.getValue());
                            byte[] bArr182 = new byte[length392 + 8];
                            System.arraycopy(bArr172, 0, bArr182, 0, length392);
                            System.arraycopy(bArrA312, 0, bArr182, length392, 8);
                            return bArr182;
                        }
                        bArr5[i35] = b3;
                        length9 = i35 + i34;
                        bArrA = new byte[]{0, 0};
                        try {
                            zIsEmpty = TextUtils.isEmpty(this.J);
                            if (!zIsEmpty) {
                                bArrA = mm.a(this.J.length(), bArr8);
                            }
                            System.arraycopy(bArrA, 0, bArr5, length9, 2);
                            length10 = length9 + 2;
                            if (!zIsEmpty) {
                                try {
                                    byte[] bytes5 = this.J.getBytes("GBK");
                                    System.arraycopy(bytes5, 0, bArr5, length10, bytes5.length);
                                    length10 += bytes5.length;
                                } catch (Throwable unused3) {
                                }
                            }
                            i7 = 2;
                        } catch (Throwable unused4) {
                            i7 = 2;
                            length10 = length9 + 2;
                        }
                        try {
                            System.arraycopy(mm.a(0, bArr8), 0, bArr5, length10, i7);
                        } catch (Throwable unused5) {
                        }
                        int i3622 = length10 + i7;
                        byte[] bArr1522 = new byte[i7];
                        // fill-array-data instruction
                        bArr1522[0] = 0;
                        bArr1522[1] = 0;
                        try {
                            System.arraycopy(bArr1522, 0, bArr5, i3622, i7);
                        } catch (Throwable unused6) {
                        }
                        int i3722 = i3622 + i7;
                        byte[] bArr1622 = this.H;
                        length11 = bArr1622 != null ? bArr1622.length : 0;
                        byte[] bArrA3022 = mm.a(length11, (byte[]) null);
                        System.arraycopy(bArrA3022, 0, bArr5, i3722, bArrA3022.length);
                        int length3922 = i3722 + bArrA3022.length;
                        if (length11 > 0) {
                            byte[] bArr19 = this.H;
                            System.arraycopy(bArr19, 0, bArr5, length3922, bArr19.length);
                            length3922 += this.H.length;
                        }
                        if (Double.valueOf(me.f2999a).doubleValue() >= 5.0d) {
                            List<ll> list = this.T;
                            int size2 = list != null ? list.size() : 0;
                            bArr5[length3922] = (byte) size2;
                            int i39 = length3922 + 1;
                            byte[] bArr20 = new byte[i39];
                            System.arraycopy(bArr5, 0, bArr20, 0, i39);
                            if (size2 > 0) {
                                try {
                                    int length40 = i39;
                                    for (ll llVar2 : this.T) {
                                        int i40 = llVar2.l;
                                        if (i40 == 1 || i40 == 3 || i40 == 4) {
                                            byte b7 = (byte) i40;
                                            if (llVar2.n) {
                                                b7 = (byte) (b7 | 8);
                                            }
                                            bArr5[length40] = b7;
                                            int i41 = length40 + 1;
                                            byte[] bArrA32 = mm.a(llVar2.c, bArr8);
                                            System.arraycopy(bArrA32, 0, bArr5, i41, bArrA32.length);
                                            length12 = i41 + bArrA32.length;
                                            byte[] bArrB11 = mm.b(llVar2.d, bArr6);
                                            System.arraycopy(bArrB11, 0, bArr5, length12, bArrB11.length);
                                            length13 = bArrB11.length;
                                        } else if (i40 == 2) {
                                            byte b8 = (byte) i40;
                                            if (llVar2.n) {
                                                b8 = (byte) (b8 | 8);
                                            }
                                            bArr5[length40] = b8;
                                            int i42 = length40 + 1;
                                            byte[] bArrA33 = mm.a(llVar2.h, bArr8);
                                            System.arraycopy(bArrA33, 0, bArr5, i42, bArrA33.length);
                                            int length41 = i42 + bArrA33.length;
                                            byte[] bArrA34 = mm.a(llVar2.i, bArr8);
                                            System.arraycopy(bArrA34, 0, bArr5, length41, bArrA34.length);
                                            length12 = length41 + bArrA34.length;
                                            byte[] bArrA35 = mm.a(llVar2.j, bArr8);
                                            System.arraycopy(bArrA35, 0, bArr5, length12, bArrA35.length);
                                            length13 = bArrA35.length;
                                        } else {
                                            if (i40 == 5) {
                                                byte b9 = (byte) i40;
                                                if (llVar2.n) {
                                                    b9 = (byte) (b9 | 8);
                                                }
                                                bArr5[length40] = b9;
                                                int i43 = length40 + 1;
                                                byte[] bArrA36 = mm.a(llVar2.c, bArr8);
                                                System.arraycopy(bArrA36, 0, bArr5, i43, bArrA36.length);
                                                int length42 = i43 + bArrA36.length;
                                                System.arraycopy(mm.a(llVar2.e), 0, bArr5, length42, 8);
                                                length40 = length42 + 8;
                                            }
                                            byte[] bArrA37 = mm.a((short) ((mm.b() - llVar2.t) / 1000), bArr8);
                                            System.arraycopy(bArrA37, 0, bArr5, length40, bArrA37.length);
                                            length40 += bArrA37.length;
                                        }
                                        length40 = length12 + length13;
                                        byte[] bArrA372 = mm.a((short) ((mm.b() - llVar2.t) / 1000), bArr8);
                                        System.arraycopy(bArrA372, 0, bArr5, length40, bArrA372.length);
                                        length40 += bArrA372.length;
                                    }
                                    i39 = length40;
                                } catch (Throwable unused7) {
                                    System.arraycopy(bArr20, 0, bArr5, 0, i39);
                                    bArr5[i39 - 1] = 0;
                                }
                            }
                            length3922 = a(this.M, bArr5, i39);
                        }
                        if (Double.valueOf(me.f2999a).doubleValue() >= 5.2d) {
                            List<ln> list2 = this.S;
                            int size3 = list2 == null ? 0 : list2.size();
                            bArr5[length3922] = (byte) size3;
                            length3922++;
                            if (size3 > 0) {
                                for (ln lnVar : this.S) {
                                    int iCurrentTimeMillis = ((int) (System.currentTimeMillis() - lnVar.d)) / 1000;
                                    if (iCurrentTimeMillis > 65535) {
                                        iCurrentTimeMillis = 65535;
                                    }
                                    System.arraycopy(mm.a(iCurrentTimeMillis, bArr8), 0, bArr5, length3922, 2);
                                    int i44 = length3922 + 2;
                                    System.arraycopy(mm.b((int) Math.round(lnVar.c * 1.0E7d), bArr6), 0, bArr5, i44, 4);
                                    int i45 = i44 + 4;
                                    System.arraycopy(mm.b((int) Math.round(lnVar.b * 1.0E7d), bArr6), 0, bArr5, i45, 4);
                                    int i46 = i45 + 4;
                                    float f = lnVar.e;
                                    if (f > 65535.0f) {
                                        f = 65535.0f;
                                    }
                                    System.arraycopy(mm.a((int) f, bArr8), 0, bArr5, i46, 2);
                                    int i47 = i46 + 2;
                                    System.arraycopy(mm.a((short) ((lnVar.h | (lnVar.f2974a << 13) | (lnVar.g << 6)) & 65535), bArr8), 0, bArr5, i47, 2);
                                    length3922 = i47 + 2;
                                }
                            }
                        }
                        if (Double.valueOf(me.f2999a).doubleValue() >= 5.3d) {
                            length3922 = a(this.N, bArr5, length3922);
                        }
                        byte[] bArr1722 = new byte[length3922];
                        System.arraycopy(bArr5, 0, bArr1722, 0, length3922);
                        CRC32 crc3222 = new CRC32();
                        crc3222.update(bArr1722);
                        byte[] bArrA3122 = mm.a(crc3222.getValue());
                        byte[] bArr1822 = new byte[length3922 + 8];
                        System.arraycopy(bArr1722, 0, bArr1822, 0, length3922);
                        System.arraycopy(bArrA3122, 0, bArr1822, length3922, 8);
                        return bArr1822;
                    }
                    if (this.A.size() == 0) {
                        bArr12[length2] = 0;
                        length2++;
                    } else {
                        int size4 = this.A.size();
                        bArr12[length2] = (byte) size4;
                        length2++;
                        int i48 = 0;
                        while (i48 < size4) {
                            byte[] bArrA38 = mm.a(this.A.size() > 0 ? this.A.get(i48).c : 0, bArr13);
                            System.arraycopy(bArrA38, 0, bArr12, length2, bArrA38.length);
                            int length43 = length2 + bArrA38.length;
                            byte[] bArrB12 = mm.b(this.A.size() > 0 ? this.A.get(i48).d : 0, bArr13);
                            System.arraycopy(bArrB12, 0, bArr12, length43, bArrB12.length);
                            int length44 = length43 + bArrB12.length;
                            int i49 = this.A.size() > 0 ? this.A.get(i48).k : 0;
                            if (i49 > 127 || i49 < -128) {
                                i49 = 0;
                            }
                            bArr12[length44] = (byte) i49;
                            length2 = length44 + i10;
                            if (Double.valueOf(me.f2999a).doubleValue() >= 5.2d) {
                                if (this.A.size() > 0) {
                                    bArr4 = bArr12;
                                    jB2 = (mm.b() - this.A.get(0).t) / 1000;
                                } else {
                                    bArr4 = bArr12;
                                    jB2 = 0;
                                }
                                if (jB2 > WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                                    jB2 = 65535;
                                }
                                if (jB2 < 0) {
                                    jB2 = 0;
                                }
                                byte[] bArrA39 = mm.a((int) jB2, bArr8);
                                bArr3 = bArr4;
                                System.arraycopy(bArrA39, 0, bArr3, length2, bArrA39.length);
                                length2 += bArrA39.length;
                            } else {
                                bArr3 = bArr12;
                            }
                            i48++;
                            bArr12 = bArr3;
                            i10 = 1;
                            bArr13 = null;
                        }
                    }
                }
                length17 = length3 + length4;
                if (this.A.size() > 0) {
                }
                if (i2 > 127) {
                    i2 = 0;
                    bArr12[length17] = (byte) i2;
                    int i152 = length17 + 1;
                    if (this.A.size() <= 0) {
                    }
                    if (jB > WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                    }
                    if (jB < 0) {
                    }
                    byte[] bArrA92 = mm.a((int) jB, bArr8);
                    System.arraycopy(bArrA92, 0, bArr12, i152, bArrA92.length);
                    length2 = i152 + 2;
                    if (i == 1) {
                    }
                }
                str = this.C;
                if (str == null) {
                    bArr2[length2] = 0;
                    i3 = length2 + 1;
                }
                ArrayList<ll> arrayList3 = this.B;
                int size5 = arrayList3.size();
                int i162 = 5;
                int i172 = 3;
                if ((this.z & 4) == 4) {
                    bArr5 = bArr2;
                    bArr6 = bArr;
                    bArr5[i3] = 0;
                    b = 1;
                    length5 = i3 + 1;
                }
                if (TextUtils.isEmpty(this.D)) {
                    i4 = 1;
                    b2 = 0;
                    bArr5[length5] = 0;
                    length6 = length5 + 1;
                }
                ArrayList<kr> arrayList22 = this.E;
                iMin = Math.min(arrayList22.size(), 25);
                if (iMin != 0) {
                }
                bArr5[length7] = b3;
                int i342 = 1;
                int i352 = length7 + 1;
                str2 = this.G;
                if (str2 == null) {
                }
            } else {
                bArr = bArr9;
            }
            bArr2 = bArr12;
            str = this.C;
            if (str == null) {
            }
            ArrayList<ll> arrayList32 = this.B;
            int size52 = arrayList32.size();
            int i1622 = 5;
            int i1722 = 3;
            if ((this.z & 4) == 4) {
            }
            if (TextUtils.isEmpty(this.D)) {
            }
            ArrayList<kr> arrayList222 = this.E;
            iMin = Math.min(arrayList222.size(), 25);
            if (iMin != 0) {
            }
            bArr5[length7] = b3;
            int i3422 = 1;
            int i3522 = length7 + 1;
            str2 = this.G;
            if (str2 == null) {
            }
        } else {
            byte[] bArrA40 = a(this.t);
            bArr12[iA] = (byte) bArrA40.length;
            int i50 = iA + 1;
            System.arraycopy(bArrA40, 0, bArr12, i50, bArrA40.length);
            length = i50 + bArrA40.length;
            int iA22 = a(this.x, bArr12, a(K, bArr12, a(I, bArr12, a(this.w, bArr12, a(this.v, bArr12, length)))));
            bArr12[iA22] = Byte.parseByte(this.y);
            int i122 = iA22 + 1;
            bArr12[i122] = Byte.parseByte(this.j);
            int i132 = i122 + 1;
            int i142 = this.z;
            i = i142 & 3;
            bArr12[i132] = (byte) i142;
            length2 = i132 + 1;
            if (i != 1) {
                byte[] bArrA310 = mm.a(this.A.size() <= 0 ? this.A.get(0).f2970a : 0, (byte[]) null);
                System.arraycopy(bArrA310, 0, bArr12, length2, bArrA310.length);
                int length172 = length2 + bArrA310.length;
                if (i != 1) {
                }
                length172 = length3 + length4;
                if (this.A.size() > 0) {
                }
                if (i2 > 127) {
                }
            }
            str = this.C;
            if (str == null) {
            }
            ArrayList<ll> arrayList322 = this.B;
            int size522 = arrayList322.size();
            int i16222 = 5;
            int i17222 = 3;
            if ((this.z & 4) == 4) {
            }
            if (TextUtils.isEmpty(this.D)) {
            }
            ArrayList<kr> arrayList2222 = this.E;
            iMin = Math.min(arrayList2222.size(), 25);
            if (iMin != 0) {
            }
            bArr5[length7] = b3;
            int i34222 = 1;
            int i35222 = length7 + 1;
            str2 = this.G;
            if (str2 == null) {
            }
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
                me.a(th, "Req", "getMacBa ".concat(str));
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

    public final void a(Context context, boolean z, boolean z2, lm lmVar, ls lsVar, ConnectivityManager connectivityManager, String str, lo loVar) {
        String str2;
        String str3;
        String str4;
        NetworkInfo activeNetworkInfo;
        String strA;
        String str5;
        ArrayList<kr> arrayList;
        int length;
        String strF = fr.f(context);
        int iD = mm.d();
        this.J = str;
        this.S = null;
        if (z2) {
            str2 = "api_serverSDK_130905";
            str3 = "S128DF1572465B890OE3F7A13167KLEI";
        } else {
            str2 = "UC_nlp_20131029";
            str3 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
        }
        String str6 = str3;
        String str7 = str2;
        StringBuilder sb = new StringBuilder();
        int iG = lmVar.g();
        int iH = lmVar.h();
        TelephonyManager telephonyManagerI = lmVar.i();
        ArrayList<ll> arrayListC = lmVar.c();
        ArrayList<ll> arrayListD = lmVar.d();
        ArrayList<kr> arrayListE = lsVar.e();
        String str8 = iH == 2 ? "1" : "0";
        if (telephonyManagerI != null) {
            if (TextUtils.isEmpty(me.g)) {
                try {
                    me.g = fv.k();
                } catch (Throwable th) {
                    me.a(th, "Aps", "getApsReq part4");
                }
            }
            str4 = "1";
            if (TextUtils.isEmpty(me.g) && Build.VERSION.SDK_INT < 29) {
                me.g = "888888888888888";
            }
            if (TextUtils.isEmpty(me.h)) {
                try {
                    me.h = fv.n();
                } catch (SecurityException unused) {
                } catch (Throwable th2) {
                    me.a(th2, "Aps", "getApsReq part2");
                }
            }
            if (TextUtils.isEmpty(me.h) && Build.VERSION.SDK_INT < 29) {
                me.h = "888888888888888";
            }
        } else {
            str4 = "1";
        }
        try {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th3) {
            me.a(th3, "Aps", "getApsReq part");
            activeNetworkInfo = null;
        }
        boolean zA = lsVar.a(connectivityManager);
        if (mm.a(activeNetworkInfo) != -1) {
            strA = mm.a(connectivityManager);
            str5 = zA ? "2" : str4;
        } else {
            strA = "";
            str5 = strA;
        }
        if ((iG & 4) == 4 && !arrayListD.isEmpty()) {
            this.B.clear();
            this.B.addAll(arrayListD);
        } else {
            this.B.clear();
        }
        this.A.clear();
        this.A.addAll(arrayListC);
        StringBuilder sb2 = new StringBuilder();
        if (lsVar.l()) {
            if (zA) {
                lr lrVarN = lsVar.n();
                if (ls.a(lrVarN)) {
                    sb2.append(lrVarN.a());
                    sb2.append(",");
                    int iC = lrVarN.c();
                    if (iC < -128 || iC > 127) {
                        iC = 0;
                    }
                    sb2.append(iC);
                    sb2.append(",");
                    String strB = lrVarN.b();
                    try {
                        length = strB.getBytes("UTF-8").length;
                    } catch (Exception unused2) {
                        length = 32;
                    }
                    if (length >= 32) {
                        strB = "unkwn";
                    }
                    sb2.append(strB.replace("*", "."));
                }
            }
            if (arrayListE != null && (arrayList = this.E) != null) {
                arrayList.clear();
                this.E.addAll(arrayListE);
            }
        } else {
            lsVar.g();
            ArrayList<kr> arrayList2 = this.E;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
        }
        this.b = (short) 0;
        if (!z) {
            this.b = (short) (2 | 0);
        }
        this.c = str7;
        this.d = str6;
        this.f = Build.MODEL;
        this.g = "android" + Build.VERSION.RELEASE;
        this.h = mm.b(context);
        this.i = str8;
        this.j = "0";
        this.k = "0";
        this.l = "0";
        this.m = "0";
        this.n = "0";
        this.o = strF;
        this.p = me.g;
        this.q = me.h;
        this.s = String.valueOf(iD);
        this.t = mm.i(context);
        this.v = "6.4.5";
        this.w = null;
        this.u = "";
        this.x = strA;
        this.y = str5;
        this.z = iG;
        this.C = lmVar.l();
        this.F = ls.q();
        this.D = sb2.toString();
        this.O = (int) ((mm.b() - lsVar.r()) / 1000);
        try {
            if (TextUtils.isEmpty(I)) {
                I = fv.f(context);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (TextUtils.isEmpty(K)) {
                K = fv.a(context);
            }
        } catch (Throwable unused4) {
        }
        try {
            if (TextUtils.isEmpty(this.M)) {
                this.M = fv.f();
            }
        } catch (Throwable unused5) {
        }
        try {
            if (TextUtils.isEmpty(this.N)) {
                this.N = fv.e(context);
            }
        } catch (Throwable unused6) {
        }
        try {
            this.S = loVar.a(this.B, this.E);
            a(this.A, this.B);
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
        sb.delete(0, sb.length());
        sb2.delete(0, sb2.length());
    }

    private void a(ArrayList<ll> arrayList, ArrayList<ll> arrayList2) {
        if (arrayList2 != null && arrayList2.size() > 0) {
            for (ll llVar : arrayList2) {
                if (llVar.r && llVar.n) {
                    a(llVar, this.T);
                    return;
                }
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        a(arrayList.get(0), this.T);
    }

    private static void a(ll llVar, List<ll> list) {
        if (llVar == null || list == null) {
            return;
        }
        int size = list.size();
        if (size == 0) {
            list.add(llVar);
            return;
        }
        int i = -1;
        long jMin = Long.MAX_VALUE;
        int i2 = 0;
        int i3 = -1;
        while (true) {
            if (i2 >= size) {
                i = i3;
                break;
            }
            ll llVar2 = list.get(i2);
            if (llVar.c() != null && llVar.c().equals(llVar2.c())) {
                int i4 = llVar.s;
                if (i4 != llVar2.s) {
                    llVar2.t = llVar.t;
                    llVar2.s = i4;
                }
            } else {
                jMin = Math.min(jMin, llVar2.t);
                if (jMin == llVar2.t) {
                    i3 = i2;
                }
                i2++;
            }
        }
        if (i >= 0) {
            if (size < 3) {
                list.add(llVar);
            } else {
                if (llVar.t <= jMin || i >= size) {
                    return;
                }
                list.remove(i);
                list.add(llVar);
            }
        }
    }

    private static int a(String str, byte[] bArr, int i) {
        try {
        } catch (Throwable th) {
            me.a(th, "Req", "copyContentWithByteLen");
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
}
