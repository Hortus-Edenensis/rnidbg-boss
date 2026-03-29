package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection;
import defpackage.pr0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class si1 {
    public static final byte[] h = {0, 7, 8, 15};
    public static final byte[] i = {0, 119, -120, -1};
    public static final byte[] j = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f20749a;
    public final Paint b;
    public final Canvas c;
    public final b d;
    public final a e;
    public final h f;
    public Bitmap g;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20750a;
        public final int[] b;
        public final int[] c;
        public final int[] d;

        public a(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f20750a = i;
            this.b = iArr;
            this.c = iArr2;
            this.d = iArr3;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20751a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        public b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f20751a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20752a;
        public final boolean b;
        public final byte[] c;
        public final byte[] d;

        public c(int i, boolean z, byte[] bArr, byte[] bArr2) {
            this.f20752a = i;
            this.b = z;
            this.c = bArr;
            this.d = bArr2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20753a;
        public final int b;
        public final int c;
        public final SparseArray<e> d;

        public d(int i, int i2, int i3, SparseArray<e> sparseArray) {
            this.f20753a = i;
            this.b = i2;
            this.c = i3;
            this.d = sparseArray;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20754a;
        public final int b;

        public e(int i, int i2) {
            this.f20754a = i;
            this.b = i2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20755a;
        public final boolean b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final int j;
        public final SparseArray<g> k;

        public f(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, SparseArray<g> sparseArray) {
            this.f20755a = i;
            this.b = z;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = i5;
            this.g = i6;
            this.h = i7;
            this.i = i8;
            this.j = i9;
            this.k = sparseArray;
        }

        public void a(f fVar) {
            SparseArray<g> sparseArray = fVar.k;
            for (int i = 0; i < sparseArray.size(); i++) {
                this.k.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20756a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        public g(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f20756a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20757a;
        public final int b;
        public final SparseArray<f> c = new SparseArray<>();
        public final SparseArray<a> d = new SparseArray<>();
        public final SparseArray<c> e = new SparseArray<>();
        public final SparseArray<a> f = new SparseArray<>();
        public final SparseArray<c> g = new SparseArray<>();

        @Nullable
        public b h;

        @Nullable
        public d i;

        public h(int i, int i2) {
            this.f20757a = i;
            this.b = i2;
        }

        public void a() {
            this.c.clear();
            this.d.clear();
            this.e.clear();
            this.f.clear();
            this.g.clear();
            this.h = null;
            this.i = null;
        }
    }

    public si1(int i2, int i3) {
        Paint paint = new Paint();
        this.f20749a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.c = new Canvas();
        this.d = new b(AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, 575, 0, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, 0, 575);
        this.e = new a(0, c(), d(), e());
        this.f = new h(i2, i3);
    }

    public static byte[] a(int i2, int i3, fc4 fc4Var) {
        byte[] bArr = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) fc4Var.h(i3);
        }
        return bArr;
    }

    public static int[] c() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    public static int[] d() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i2 = 1; i2 < 16; i2++) {
            if (i2 < 8) {
                iArr[i2] = f(255, (i2 & 1) != 0 ? 255 : 0, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) != 0 ? 255 : 0);
            } else {
                iArr[i2] = f(255, (i2 & 1) != 0 ? 127 : 0, (i2 & 2) != 0 ? 127 : 0, (i2 & 4) == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    public static int[] e() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            if (i2 < 8) {
                iArr[i2] = f(63, (i2 & 1) != 0 ? 255 : 0, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) == 0 ? 0 : 255);
            } else {
                int i3 = i2 & 136;
                if (i3 == 0) {
                    iArr[i2] = f(255, ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? 170 : 0), ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0), ((i2 & 4) == 0 ? 0 : 85) + ((i2 & 64) == 0 ? 0 : 170));
                } else if (i3 == 8) {
                    iArr[i2] = f(127, ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? 170 : 0), ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0), ((i2 & 4) == 0 ? 0 : 85) + ((i2 & 64) == 0 ? 0 : 170));
                } else if (i3 == 128) {
                    iArr[i2] = f(255, ((i2 & 1) != 0 ? 43 : 0) + 127 + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + 127 + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 4) == 0 ? 0 : 43) + 127 + ((i2 & 64) == 0 ? 0 : 85));
                } else if (i3 == 136) {
                    iArr[i2] = f(255, ((i2 & 1) != 0 ? 43 : 0) + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 4) == 0 ? 0 : 43) + ((i2 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    public static int f(int i2, int i3, int i4, int i5) {
        return (i2 << 24) | (i3 << 16) | (i4 << 8) | i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0063 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0083 A[LOOP:0: B:3:0x0009->B:33:0x0083, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0082 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int g(fc4 fc4Var, int[] iArr, @Nullable byte[] bArr, int i2, int i3, @Nullable Paint paint, Canvas canvas) {
        boolean z;
        int i4;
        int iH;
        int iH2;
        int i5 = i2;
        boolean z2 = false;
        while (true) {
            int iH3 = fc4Var.h(2);
            if (iH3 != 0) {
                z = z2;
            } else {
                if (fc4Var.g()) {
                    iH = fc4Var.h(3) + 3;
                    iH2 = fc4Var.h(2);
                } else if (fc4Var.g()) {
                    z = z2;
                    iH3 = 0;
                } else {
                    int iH4 = fc4Var.h(2);
                    if (iH4 == 0) {
                        iH3 = 0;
                        z = true;
                    } else if (iH4 == 1) {
                        z = z2;
                        iH3 = 0;
                        i4 = 2;
                        if (i4 != 0 && paint != null) {
                            if (bArr != null) {
                                iH3 = bArr[iH3];
                            }
                            paint.setColor(iArr[iH3]);
                            canvas.drawRect(i5, i3, i5 + i4, i3 + 1, paint);
                        }
                        i5 += i4;
                        if (!z) {
                            return i5;
                        }
                        z2 = z;
                    } else if (iH4 == 2) {
                        iH = fc4Var.h(4) + 12;
                        iH2 = fc4Var.h(2);
                    } else if (iH4 != 3) {
                        z = z2;
                        iH3 = 0;
                    } else {
                        iH = fc4Var.h(8) + 29;
                        iH2 = fc4Var.h(2);
                    }
                    i4 = 0;
                    if (i4 != 0) {
                        if (bArr != null) {
                        }
                        paint.setColor(iArr[iH3]);
                        canvas.drawRect(i5, i3, i5 + i4, i3 + 1, paint);
                    }
                    i5 += i4;
                    if (!z) {
                    }
                }
                z = z2;
                i4 = iH;
                iH3 = iH2;
                if (i4 != 0) {
                }
                i5 += i4;
                if (!z) {
                }
            }
            i4 = 1;
            if (i4 != 0) {
            }
            i5 += i4;
            if (!z) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0090 A[LOOP:0: B:3:0x0009->B:36:0x0090, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int h(fc4 fc4Var, int[] iArr, @Nullable byte[] bArr, int i2, int i3, @Nullable Paint paint, Canvas canvas) {
        boolean z;
        int i4;
        int iH;
        int iH2;
        int i5 = i2;
        boolean z2 = false;
        while (true) {
            int iH3 = fc4Var.h(4);
            if (iH3 != 0) {
                z = z2;
            } else {
                if (fc4Var.g()) {
                    if (fc4Var.g()) {
                        int iH4 = fc4Var.h(2);
                        if (iH4 == 0) {
                            z = z2;
                            iH3 = 0;
                        } else if (iH4 == 1) {
                            z = z2;
                            iH3 = 0;
                            i4 = 2;
                        } else if (iH4 == 2) {
                            iH = fc4Var.h(4) + 9;
                            iH2 = fc4Var.h(4);
                        } else if (iH4 != 3) {
                            z = z2;
                            iH3 = 0;
                            i4 = 0;
                        } else {
                            iH = fc4Var.h(8) + 25;
                            iH2 = fc4Var.h(4);
                        }
                    } else {
                        iH = fc4Var.h(2) + 4;
                        iH2 = fc4Var.h(4);
                    }
                    z = z2;
                    i4 = iH;
                    iH3 = iH2;
                } else {
                    int iH5 = fc4Var.h(3);
                    if (iH5 != 0) {
                        z = z2;
                        i4 = iH5 + 2;
                        iH3 = 0;
                    } else {
                        iH3 = 0;
                        z = true;
                        i4 = 0;
                    }
                }
                if (i4 != 0 && paint != null) {
                    if (bArr != null) {
                        iH3 = bArr[iH3];
                    }
                    paint.setColor(iArr[iH3]);
                    canvas.drawRect(i5, i3, i5 + i4, i3 + 1, paint);
                }
                i5 += i4;
                if (!z) {
                    return i5;
                }
                z2 = z;
            }
            i4 = 1;
            if (i4 != 0) {
                if (bArr != null) {
                }
                paint.setColor(iArr[iH3]);
                canvas.drawRect(i5, i3, i5 + i4, i3 + 1, paint);
            }
            i5 += i4;
            if (!z) {
            }
        }
    }

    public static int i(fc4 fc4Var, int[] iArr, @Nullable byte[] bArr, int i2, int i3, @Nullable Paint paint, Canvas canvas) {
        boolean z;
        int iH;
        int i4 = i2;
        boolean z2 = false;
        while (true) {
            int iH2 = fc4Var.h(8);
            if (iH2 != 0) {
                z = z2;
                iH = 1;
            } else if (fc4Var.g()) {
                z = z2;
                iH = fc4Var.h(7);
                iH2 = fc4Var.h(8);
            } else {
                int iH3 = fc4Var.h(7);
                if (iH3 != 0) {
                    z = z2;
                    iH = iH3;
                    iH2 = 0;
                } else {
                    iH2 = 0;
                    z = true;
                    iH = 0;
                }
            }
            if (iH != 0 && paint != null) {
                if (bArr != null) {
                    iH2 = bArr[iH2];
                }
                paint.setColor(iArr[iH2]);
                canvas.drawRect(i4, i3, i4 + iH, i3 + 1, paint);
            }
            i4 += iH;
            if (z) {
                return i4;
            }
            z2 = z;
        }
    }

    public static void j(byte[] bArr, int[] iArr, int i2, int i3, int i4, @Nullable Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        fc4 fc4Var = new fc4(bArr);
        int iG = i3;
        int i5 = i4;
        byte[] bArrA = null;
        byte[] bArrA2 = null;
        byte[] bArrA3 = null;
        while (fc4Var.b() != 0) {
            int iH = fc4Var.h(8);
            if (iH != 240) {
                switch (iH) {
                    case 16:
                        if (i2 == 3) {
                            bArr3 = bArrA == null ? i : bArrA;
                        } else if (i2 != 2) {
                            bArr2 = null;
                            iG = g(fc4Var, iArr, bArr2, iG, i5, paint, canvas);
                            fc4Var.c();
                        } else {
                            bArr3 = bArrA3 == null ? h : bArrA3;
                        }
                        bArr2 = bArr3;
                        iG = g(fc4Var, iArr, bArr2, iG, i5, paint, canvas);
                        fc4Var.c();
                        break;
                    case 17:
                        iG = h(fc4Var, iArr, i2 == 3 ? bArrA2 == null ? j : bArrA2 : null, iG, i5, paint, canvas);
                        fc4Var.c();
                        break;
                    case 18:
                        iG = i(fc4Var, iArr, null, iG, i5, paint, canvas);
                        break;
                    default:
                        switch (iH) {
                            case 32:
                                bArrA3 = a(4, 4, fc4Var);
                                break;
                            case 33:
                                bArrA = a(4, 8, fc4Var);
                                break;
                            case 34:
                                bArrA2 = a(16, 8, fc4Var);
                                break;
                        }
                        break;
                }
            } else {
                i5 += 2;
                iG = i3;
            }
        }
    }

    public static void k(c cVar, a aVar, int i2, int i3, int i4, @Nullable Paint paint, Canvas canvas) {
        int[] iArr = i2 == 3 ? aVar.d : i2 == 2 ? aVar.c : aVar.b;
        j(cVar.c, iArr, i2, i3, i4, paint, canvas);
        j(cVar.d, iArr, i2, i3, i4 + 1, paint, canvas);
    }

    public static a l(fc4 fc4Var, int i2) {
        int iH;
        int i3;
        int iH2;
        int iH3;
        int iH4;
        int i4 = 8;
        int iH5 = fc4Var.h(8);
        fc4Var.r(8);
        int i5 = 2;
        int i6 = i2 - 2;
        int[] iArrC = c();
        int[] iArrD = d();
        int[] iArrE = e();
        while (i6 > 0) {
            int iH6 = fc4Var.h(i4);
            int iH7 = fc4Var.h(i4);
            int i7 = i6 - 2;
            int[] iArr = (iH7 & 128) != 0 ? iArrC : (iH7 & 64) != 0 ? iArrD : iArrE;
            if ((iH7 & 1) != 0) {
                iH3 = fc4Var.h(i4);
                iH4 = fc4Var.h(i4);
                iH = fc4Var.h(i4);
                iH2 = fc4Var.h(i4);
                i3 = i7 - 4;
            } else {
                int iH8 = fc4Var.h(6) << i5;
                int iH9 = fc4Var.h(4) << 4;
                iH = fc4Var.h(4) << 4;
                i3 = i7 - 2;
                iH2 = fc4Var.h(i5) << 6;
                iH3 = iH8;
                iH4 = iH9;
            }
            if (iH3 == 0) {
                iH4 = 0;
                iH = 0;
                iH2 = 255;
            }
            double d2 = iH3;
            double d3 = iH4 - 128;
            double d4 = iH - 128;
            iArr[iH6] = f((byte) (255 - (iH2 & 255)), g86.q((int) (d2 + (1.402d * d3)), 0, 255), g86.q((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 0, 255), g86.q((int) (d2 + (d4 * 1.772d)), 0, 255));
            i6 = i3;
            iH5 = iH5;
            i4 = 8;
            i5 = 2;
        }
        return new a(iH5, iArrC, iArrD, iArrE);
    }

    public static b m(fc4 fc4Var) {
        int i2;
        int iH;
        int i3;
        int i4;
        fc4Var.r(4);
        boolean zG = fc4Var.g();
        fc4Var.r(3);
        int iH2 = fc4Var.h(16);
        int iH3 = fc4Var.h(16);
        if (zG) {
            int iH4 = fc4Var.h(16);
            int iH5 = fc4Var.h(16);
            int iH6 = fc4Var.h(16);
            iH = fc4Var.h(16);
            i2 = iH5;
            i4 = iH6;
            i3 = iH4;
        } else {
            i2 = iH2;
            iH = iH3;
            i3 = 0;
            i4 = 0;
        }
        return new b(iH2, iH3, i3, i2, i4, iH);
    }

    public static c n(fc4 fc4Var) {
        byte[] bArr;
        int iH = fc4Var.h(16);
        fc4Var.r(4);
        int iH2 = fc4Var.h(2);
        boolean zG = fc4Var.g();
        fc4Var.r(1);
        byte[] bArr2 = g86.f;
        if (iH2 != 1) {
            if (iH2 == 0) {
                int iH3 = fc4Var.h(16);
                int iH4 = fc4Var.h(16);
                if (iH3 > 0) {
                    bArr2 = new byte[iH3];
                    fc4Var.k(bArr2, 0, iH3);
                }
                if (iH4 > 0) {
                    bArr = new byte[iH4];
                    fc4Var.k(bArr, 0, iH4);
                }
            }
            return new c(iH, zG, bArr2, bArr);
        }
        fc4Var.r(fc4Var.h(8) * 16);
        bArr = bArr2;
        return new c(iH, zG, bArr2, bArr);
    }

    public static d o(fc4 fc4Var, int i2) {
        int iH = fc4Var.h(8);
        int iH2 = fc4Var.h(4);
        int iH3 = fc4Var.h(2);
        fc4Var.r(2);
        int i3 = i2 - 2;
        SparseArray sparseArray = new SparseArray();
        while (i3 > 0) {
            int iH4 = fc4Var.h(8);
            fc4Var.r(8);
            i3 -= 6;
            sparseArray.put(iH4, new e(fc4Var.h(16), fc4Var.h(16)));
        }
        return new d(iH, iH2, iH3, sparseArray);
    }

    public static f p(fc4 fc4Var, int i2) {
        int iH;
        int iH2;
        int iH3 = fc4Var.h(8);
        fc4Var.r(4);
        boolean zG = fc4Var.g();
        fc4Var.r(3);
        int i3 = 16;
        int iH4 = fc4Var.h(16);
        int iH5 = fc4Var.h(16);
        int iH6 = fc4Var.h(3);
        int iH7 = fc4Var.h(3);
        int i4 = 2;
        fc4Var.r(2);
        int iH8 = fc4Var.h(8);
        int iH9 = fc4Var.h(8);
        int iH10 = fc4Var.h(4);
        int iH11 = fc4Var.h(2);
        fc4Var.r(2);
        int i5 = i2 - 10;
        SparseArray sparseArray = new SparseArray();
        while (i5 > 0) {
            int iH12 = fc4Var.h(i3);
            int iH13 = fc4Var.h(i4);
            int iH14 = fc4Var.h(i4);
            int iH15 = fc4Var.h(12);
            int i6 = iH11;
            fc4Var.r(4);
            int iH16 = fc4Var.h(12);
            i5 -= 6;
            if (iH13 == 1 || iH13 == 2) {
                i5 -= 2;
                iH = fc4Var.h(8);
                iH2 = fc4Var.h(8);
            } else {
                iH = 0;
                iH2 = 0;
            }
            sparseArray.put(iH12, new g(iH13, iH14, iH15, iH16, iH, iH2));
            iH11 = i6;
            i4 = 2;
            i3 = 16;
        }
        return new f(iH3, zG, iH4, iH5, iH6, iH7, iH8, iH9, iH10, iH11, sparseArray);
    }

    public static void q(fc4 fc4Var, h hVar) {
        f fVar;
        int iH = fc4Var.h(8);
        int iH2 = fc4Var.h(16);
        int iH3 = fc4Var.h(16);
        int iD = fc4Var.d() + iH3;
        if (iH3 * 8 > fc4Var.b()) {
            y53.i("DvbParser", "Data field length exceeds limit");
            fc4Var.r(fc4Var.b());
            return;
        }
        switch (iH) {
            case 16:
                if (iH2 == hVar.f20757a) {
                    d dVar = hVar.i;
                    d dVarO = o(fc4Var, iH3);
                    if (dVarO.c != 0) {
                        hVar.i = dVarO;
                        hVar.c.clear();
                        hVar.d.clear();
                        hVar.e.clear();
                    } else if (dVar != null && dVar.b != dVarO.b) {
                        hVar.i = dVarO;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.i;
                if (iH2 == hVar.f20757a && dVar2 != null) {
                    f fVarP = p(fc4Var, iH3);
                    if (dVar2.c == 0 && (fVar = hVar.c.get(fVarP.f20755a)) != null) {
                        fVarP.a(fVar);
                    }
                    hVar.c.put(fVarP.f20755a, fVarP);
                }
                break;
            case 18:
                if (iH2 == hVar.f20757a) {
                    a aVarL = l(fc4Var, iH3);
                    hVar.d.put(aVarL.f20750a, aVarL);
                } else if (iH2 == hVar.b) {
                    a aVarL2 = l(fc4Var, iH3);
                    hVar.f.put(aVarL2.f20750a, aVarL2);
                }
                break;
            case 19:
                if (iH2 == hVar.f20757a) {
                    c cVarN = n(fc4Var);
                    hVar.e.put(cVarN.f20752a, cVarN);
                } else if (iH2 == hVar.b) {
                    c cVarN2 = n(fc4Var);
                    hVar.g.put(cVarN2.f20752a, cVarN2);
                }
                break;
            case 20:
                if (iH2 == hVar.f20757a) {
                    hVar.h = m(fc4Var);
                }
                break;
        }
        fc4Var.s(iD - fc4Var.d());
    }

    public List<pr0> b(byte[] bArr, int i2) {
        int i3;
        SparseArray<g> sparseArray;
        fc4 fc4Var = new fc4(bArr, i2);
        while (fc4Var.b() >= 48 && fc4Var.h(8) == 15) {
            q(fc4Var, this.f);
        }
        h hVar = this.f;
        d dVar = hVar.i;
        if (dVar == null) {
            return Collections.emptyList();
        }
        b bVar = hVar.h;
        if (bVar == null) {
            bVar = this.d;
        }
        Bitmap bitmap = this.g;
        if (bitmap == null || bVar.f20751a + 1 != bitmap.getWidth() || bVar.b + 1 != this.g.getHeight()) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bVar.f20751a + 1, bVar.b + 1, Bitmap.Config.ARGB_8888);
            this.g = bitmapCreateBitmap;
            this.c.setBitmap(bitmapCreateBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<e> sparseArray2 = dVar.d;
        for (int i4 = 0; i4 < sparseArray2.size(); i4++) {
            this.c.save();
            e eVarValueAt = sparseArray2.valueAt(i4);
            f fVar = this.f.c.get(sparseArray2.keyAt(i4));
            int i5 = eVarValueAt.f20754a + bVar.c;
            int i6 = eVarValueAt.b + bVar.e;
            this.c.clipRect(i5, i6, Math.min(fVar.c + i5, bVar.d), Math.min(fVar.d + i6, bVar.f));
            a aVar = this.f.d.get(fVar.g);
            if (aVar == null && (aVar = this.f.f.get(fVar.g)) == null) {
                aVar = this.e;
            }
            SparseArray<g> sparseArray3 = fVar.k;
            int i7 = 0;
            while (i7 < sparseArray3.size()) {
                int iKeyAt = sparseArray3.keyAt(i7);
                g gVarValueAt = sparseArray3.valueAt(i7);
                c cVar = this.f.e.get(iKeyAt);
                c cVar2 = cVar == null ? this.f.g.get(iKeyAt) : cVar;
                if (cVar2 != null) {
                    i3 = i7;
                    sparseArray = sparseArray3;
                    k(cVar2, aVar, fVar.f, gVarValueAt.c + i5, i6 + gVarValueAt.d, cVar2.b ? null : this.f20749a, this.c);
                } else {
                    i3 = i7;
                    sparseArray = sparseArray3;
                }
                i7 = i3 + 1;
                sparseArray3 = sparseArray;
            }
            if (fVar.b) {
                int i8 = fVar.f;
                this.b.setColor(i8 == 3 ? aVar.d[fVar.h] : i8 == 2 ? aVar.c[fVar.i] : aVar.b[fVar.j]);
                this.c.drawRect(i5, i6, fVar.c + i5, fVar.d + i6, this.b);
            }
            arrayList.add(new pr0.b().f(Bitmap.createBitmap(this.g, i5, i6, fVar.c, fVar.d)).k(i5 / bVar.f20751a).l(0).h(i6 / bVar.b, 0).i(0).n(fVar.c / bVar.f20751a).g(fVar.d / bVar.b).a());
            this.c.drawColor(0, PorterDuff.Mode.CLEAR);
            this.c.restore();
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void r() {
        this.f.a();
    }
}
