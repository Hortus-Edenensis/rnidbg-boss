package com.huawei.hms.ads;

import android.graphics.Bitmap;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class dv {
    private static final int B = 1;
    private static final int C = 2;
    private static final int D = 33;
    private static final int F = 44;
    private static final int I = 4096;
    private static final int L = 249;
    private static final int S = 3;
    private static final int Z = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f6535a = 62914560;
    private static final String b = "dv";
    public int Code;
    private int[] E;
    private int G;
    private Bitmap J;
    private int[] K;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int T;
    private int U;
    public int V;
    private int W;
    private final int c;
    private InputStream d;
    private boolean j;
    private boolean k;
    private boolean l;
    private short[] m;
    private byte[] n;
    private byte[] p;
    private byte[] q;
    private int r;
    private int v;
    private int w;
    private int x;
    private int y;
    private final Object e = new Object();
    private final Object f = new Object();
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;
    private byte[] o = new byte[512];
    private int s = 100;
    private int t = 0;
    private int u = 0;
    private int[] z = null;
    private int[] A = null;
    private int H = 0;
    private int M = 0;
    private int X = 0;
    private int[] Y = null;

    public dv(InputStream inputStream, int i) {
        this.d = inputStream;
        this.c = i;
        Z();
    }

    private void B() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            stringBuffer.append((char) C());
        }
        if (!stringBuffer.toString().startsWith("GIF")) {
            this.u = 1;
            return;
        }
        S();
        if (!this.j || D()) {
            return;
        }
        int[] iArrCode = Code(this.v);
        this.z = iArrCode;
        this.y = iArrCode[this.x];
    }

    private int C() {
        try {
            return this.d.read();
        } catch (Exception unused) {
            this.u = 1;
            return 0;
        }
    }

    private Bitmap Code(int[] iArr, int i, int i2, Bitmap bitmap) {
        if (bitmap == null) {
            Bitmap.Config config = com.huawei.openalliance.ad.utils.z.V() > f6535a ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            if (fh.Code()) {
                fh.Code(b, "create image with config %s", config);
            }
            bitmap = Bitmap.createBitmap(i, i2, config);
        }
        bitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
        return bitmap;
    }

    private boolean D() {
        return this.u != 0;
    }

    private int F() {
        return C() | (C() << 8);
    }

    private dx L() {
        dx dxVar = null;
        try {
            int iA = a();
            if (D()) {
                return null;
            }
            b();
            d();
            if (D()) {
                return null;
            }
            e();
            if (D()) {
                return null;
            }
            Bitmap bitmap = this.J;
            if (bitmap != null) {
                int i = this.M + 1;
                this.M = i;
                dxVar = new dx(i, bitmap, this.s);
            }
            if (this.i) {
                this.E[this.G] = iA;
            }
            g();
        } catch (Exception | StackOverflowError unused) {
            this.u = 1;
            fh.I(b, "read image error");
        } catch (OutOfMemoryError unused2) {
            this.u = 1;
            fh.I(b, "run out of memory");
            f();
        }
        return dxVar;
    }

    private void S() {
        this.Code = F();
        this.V = F();
        this.j = (C() & 128) != 0;
        this.v = (int) Math.pow(2.0d, (r0 & 7) + 1);
        this.x = C();
        C();
    }

    private void Z() {
        if (this.d == null) {
            Code(true);
            return;
        }
        B();
        if (D()) {
            Code(true);
            V();
        }
    }

    private int a() {
        int[] iArr;
        this.N = F();
        this.O = F();
        this.P = F();
        this.Q = F();
        int iC = C();
        int i = 0;
        this.k = (iC & 128) != 0;
        this.l = (iC & 64) != 0;
        int iPow = (int) Math.pow(2.0d, (iC & 7) + 1);
        this.w = iPow;
        if (this.k) {
            int[] iArrCode = Code(iPow);
            this.A = iArrCode;
            this.E = iArrCode;
        } else {
            this.E = this.z;
            if (this.x == this.G) {
                this.y = 0;
            }
        }
        if (this.i && (iArr = this.E) != null && iArr.length > 0) {
            int length = iArr.length;
            int i2 = this.G;
            if (length > i2) {
                int i3 = iArr[i2];
                iArr[i2] = 0;
                i = i3;
            }
        }
        if (this.E == null) {
            this.u = 1;
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v18, types: [short] */
    /* JADX WARN: Type inference failed for: r2v20 */
    private void b() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        short s;
        int i6 = this.P * this.Q;
        V(i6);
        int iC = C();
        int i7 = 1 << iC;
        int i8 = i7 + 1;
        int i9 = i7 + 2;
        int i10 = iC + 1;
        int i11 = (1 << i10) - 1;
        for (int i12 = 0; i12 < i7; i12++) {
            this.m[i12] = 0;
            this.n[i12] = (byte) i12;
        }
        int i13 = i10;
        int i14 = i9;
        int i15 = i11;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int iH = 0;
        int i20 = 0;
        int i21 = -1;
        int i22 = 0;
        int i23 = 0;
        while (i16 < i6) {
            if (i17 != 0) {
                i = i10;
                i2 = i7;
                i3 = i8;
                i4 = i9;
                i5 = i21;
            } else if (i18 >= i13) {
                int i24 = i19 & i15;
                i19 >>= i13;
                i18 -= i13;
                if (i24 > i14 || i24 == i8) {
                    break;
                }
                if (i24 == i7) {
                    i13 = i10;
                    i14 = i9;
                    i15 = i11;
                    i21 = -1;
                } else {
                    i = i10;
                    int i25 = i21;
                    if (i25 == -1) {
                        this.p[i17] = this.n[i24];
                        i21 = i24;
                        i17++;
                        i10 = i;
                        i22 = i21;
                    } else {
                        if (i24 == i14) {
                            i3 = i8;
                            this.p[i17] = (byte) i22;
                            s = i25;
                            i17++;
                        } else {
                            i3 = i8;
                            s = i24;
                        }
                        while (s > i7) {
                            this.p[i17] = this.n[s];
                            s = this.m[s];
                            i17++;
                            i7 = i7;
                        }
                        i2 = i7;
                        byte[] bArr = this.n;
                        int i26 = bArr[s] & UByte.MAX_VALUE;
                        if (i14 >= 4096) {
                            break;
                        }
                        int i27 = i17 + 1;
                        i4 = i9;
                        byte b2 = (byte) i26;
                        this.p[i17] = b2;
                        this.m[i14] = (short) i25;
                        bArr[i14] = b2;
                        i14++;
                        if ((i14 & i15) == 0 && i14 < 4096) {
                            i13++;
                            i15 += i14;
                        }
                        i22 = i26;
                        i5 = i24;
                        i17 = i27;
                    }
                }
            } else {
                if (iH == 0) {
                    iH = h();
                    if (iH <= 0) {
                        break;
                    } else {
                        i20 = 0;
                    }
                }
                i19 += (this.o[i20] & UByte.MAX_VALUE) << i18;
                i18 += 8;
                i20++;
                iH--;
            }
            i17--;
            this.q[i23] = this.p[i17];
            i16++;
            i21 = i5;
            i23++;
            i10 = i;
            i7 = i2;
            i8 = i3;
            i9 = i4;
        }
        for (int i28 = i23; i28 < i6; i28++) {
            this.q[i28] = 0;
        }
    }

    private void c() {
        C();
        int iC = C();
        int i = (iC & 28) >> 2;
        this.t = i;
        if (i == 0) {
            this.t = 1;
        }
        this.i = (iC & 1) != 0;
        int iF = F() * 10;
        this.s = iF;
        int i2 = this.c;
        if (i2 > iF) {
            this.s = i2;
        }
        this.G = C();
        C();
    }

    private void d() {
        do {
            h();
            if (this.X <= 0) {
                return;
            }
        } while (!D());
    }

    private void e() {
        int i;
        try {
            i();
            int i2 = 0;
            int i3 = 0;
            int i4 = 8;
            int i5 = 1;
            while (true) {
                int i6 = this.Q;
                if (i2 >= i6) {
                    this.J = Code(this.Y, this.Code, this.V, this.J);
                    return;
                }
                if (this.l) {
                    if (i3 >= i6) {
                        i5++;
                        if (i5 == 2) {
                            i3 = 4;
                        } else if (i5 == 3) {
                            i3 = 2;
                            i4 = 4;
                        } else if (i5 == 4) {
                            i3 = 1;
                            i4 = 2;
                        }
                    }
                    i = i3 + i4;
                } else {
                    i = i3;
                    i3 = i2;
                }
                int i7 = i3 + this.O;
                if (i7 < this.V) {
                    int i8 = this.Code;
                    int i9 = i7 * i8;
                    int i10 = this.N + i9;
                    int i11 = this.P;
                    int i12 = i10 + i11;
                    if (i9 + i8 < i12) {
                        i12 = i9 + i8;
                    }
                    int i13 = i11 * i2;
                    while (i10 < i12) {
                        int i14 = i13 + 1;
                        int i15 = this.E[this.q[i13] & UByte.MAX_VALUE];
                        if (i15 != 0) {
                            this.Y[i10] = i15;
                        }
                        i10++;
                        i13 = i14;
                    }
                }
                i2++;
                i3 = i;
            }
        } catch (Exception | StackOverflowError unused) {
            this.u = 1;
            fh.I(b, "set pixel error");
        }
    }

    private void f() {
        this.u = 3;
    }

    private void g() {
        this.H = this.t;
        this.R = this.N;
        this.T = this.O;
        this.U = this.P;
        this.W = this.Q;
        this.r = this.y;
        this.K = this.Y;
        this.i = false;
        this.t = 0;
        this.A = null;
        this.s = this.c;
    }

    private int h() {
        String str;
        String str2;
        int iC = C();
        this.X = iC;
        int i = 0;
        if (iC > 0) {
            while (true) {
                try {
                    int i2 = this.X;
                    if (i >= i2) {
                        break;
                    }
                    int i3 = this.d.read(this.o, i, i2 - i);
                    if (i3 == -1) {
                        break;
                    }
                    i += i3;
                } catch (IOException unused) {
                    str = b;
                    str2 = "read block IOException";
                    fh.I(str, str2);
                } catch (Exception unused2) {
                    str = b;
                    str2 = "read block fail";
                    fh.I(str, str2);
                }
            }
            if (i < this.X) {
                this.u = 1;
            }
        }
        return i;
    }

    private void i() {
        if (this.Y == null) {
            this.Y = new int[this.Code * this.V];
        }
        int i = this.H;
        if (i > 0) {
            if (3 == i) {
                this.K = null;
            }
            int[] iArr = this.K;
            if (iArr != null) {
                this.Y = iArr;
                if (2 == i) {
                    int i2 = !this.i ? this.r : 0;
                    for (int i3 = 0; i3 < this.W; i3++) {
                        int i4 = ((this.T + i3) * this.Code) + this.R;
                        int i5 = this.U + i4;
                        while (i4 < i5) {
                            this.Y[i4] = i2;
                            i4++;
                        }
                    }
                }
            }
        }
    }

    private boolean j() {
        boolean z;
        synchronized (this.f) {
            z = this.h;
        }
        return z;
    }

    public boolean I() {
        boolean z;
        synchronized (this.e) {
            z = this.g;
        }
        return z;
    }

    public void V() {
        synchronized (this.e) {
            if (!this.g) {
                this.g = true;
                com.huawei.openalliance.ad.utils.bb.Code((Closeable) this.d);
            }
        }
    }

    private void V(int i) {
        byte[] bArr = this.q;
        if (bArr == null || bArr.length < i) {
            this.q = new byte[i];
        }
        if (this.m == null) {
            this.m = new short[4096];
        }
        if (this.n == null) {
            this.n = new byte[4096];
        }
        if (this.p == null) {
            this.p = new byte[4097];
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0050, code lost:
    
        if (j() == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0052, code lost:
    
        V();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0055, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public dx Code() {
        if (I()) {
            Code(true);
            return null;
        }
        while (true) {
            if (j()) {
                break;
            }
            if (D()) {
                Code(true);
                break;
            }
            int iC = C();
            if (iC != 0) {
                if (iC != 33) {
                    if (iC == 44) {
                        dx dxVarL = L();
                        if (dxVarL != null) {
                            return dxVarL;
                        }
                    } else if (iC != 59) {
                        this.u = 1;
                    } else {
                        Code(true);
                    }
                } else if (249 == C()) {
                    c();
                } else {
                    d();
                }
            }
        }
    }

    private void Code(boolean z) {
        synchronized (this.f) {
            this.h = z;
        }
    }

    private int[] Code(int i) {
        int i2;
        int[] iArr = new int[256];
        int i3 = i * 3;
        byte[] bArr = new byte[i3];
        try {
            i2 = this.d.read(bArr);
        } catch (Exception unused) {
            fh.I(b, "read color table fail");
            i2 = 0;
        }
        if (i2 < i3) {
            this.u = 1;
        } else {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i4 + 1;
                int i7 = i6 + 1;
                iArr[i5] = ((bArr[i4] & UByte.MAX_VALUE) << 16) | (-16777216) | ((bArr[i6] & UByte.MAX_VALUE) << 8) | (bArr[i7] & UByte.MAX_VALUE);
                i4 = i7 + 1;
            }
        }
        return iArr;
    }
}
