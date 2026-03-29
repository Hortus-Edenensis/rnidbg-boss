package com.opos.exoplayer.core.text.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region;
import android.util.SparseArray;
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection;
import com.opos.exoplayer.core.text.Cue;
import com.opos.exoplayer.core.util.o;
import com.opos.exoplayer.core.util.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f8326a = {0, 7, 8, 15};
    private static final byte[] b = {0, 119, -120, -1};
    private static final byte[] c = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private final Paint d;
    private final Paint e;
    private final Canvas f;
    private final C0701b g;
    private final a h;
    private final h i;
    private Bitmap j;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8327a;
        public final int[] b;
        public final int[] c;
        public final int[] d;

        public a(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f8327a = i;
            this.b = iArr;
            this.c = iArr2;
            this.d = iArr3;
        }
    }

    /* JADX INFO: renamed from: com.opos.exoplayer.core.text.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0701b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8328a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        public C0701b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f8328a = i;
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
        public final int f8329a;
        public final boolean b;
        public final byte[] c;
        public final byte[] d;

        public c(int i, boolean z, byte[] bArr, byte[] bArr2) {
            this.f8329a = i;
            this.b = z;
            this.c = bArr;
            this.d = bArr2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8330a;
        public final int b;
        public final SparseArray<e> c;

        public d(int i, int i2, int i3, SparseArray<e> sparseArray) {
            this.f8330a = i2;
            this.b = i3;
            this.c = sparseArray;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8331a;
        public final int b;

        public e(int i, int i2) {
            this.f8331a = i;
            this.b = i2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8332a;
        public final boolean b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final SparseArray<g> j;

        public f(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, SparseArray<g> sparseArray) {
            this.f8332a = i;
            this.b = z;
            this.c = i2;
            this.d = i3;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = i8;
            this.i = i9;
            this.j = sparseArray;
        }

        public void a(f fVar) {
            if (fVar == null) {
                return;
            }
            SparseArray<g> sparseArray = fVar.j;
            for (int i = 0; i < sparseArray.size(); i++) {
                this.j.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8333a;
        public final int b;

        public g(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f8333a = i3;
            this.b = i4;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8334a;
        public final int b;
        public final SparseArray<f> c = new SparseArray<>();
        public final SparseArray<a> d = new SparseArray<>();
        public final SparseArray<c> e = new SparseArray<>();
        public final SparseArray<a> f = new SparseArray<>();
        public final SparseArray<c> g = new SparseArray<>();
        public C0701b h;
        public d i;

        public h(int i, int i2) {
            this.f8334a = i;
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

    public b(int i, int i2) {
        Paint paint = new Paint();
        this.d = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.e = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f = new Canvas();
        this.g = new C0701b(AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, 575, 0, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, 0, 575);
        this.h = new a(0, b(), c(), d());
        this.i = new h(i, i2);
    }

    private static int a(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0087 A[LOOP:0: B:3:0x0009->B:36:0x0087, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int b(o oVar, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        boolean z;
        int i3;
        int iC;
        int i4 = i;
        boolean z2 = false;
        while (true) {
            int iC2 = oVar.c(4);
            if (iC2 != 0) {
                z = z2;
            } else {
                if (oVar.e()) {
                    if (oVar.e()) {
                        int iC3 = oVar.c(2);
                        if (iC3 == 0) {
                            z = z2;
                            iC2 = 0;
                        } else if (iC3 == 1) {
                            z = z2;
                            iC2 = 0;
                            i3 = 2;
                        } else if (iC3 == 2) {
                            iC = oVar.c(4) + 9;
                        } else if (iC3 != 3) {
                            z = z2;
                            iC2 = 0;
                            i3 = 0;
                        } else {
                            iC = oVar.c(8) + 25;
                        }
                    } else {
                        iC = oVar.c(2) + 4;
                    }
                    z = z2;
                    i3 = iC;
                    iC2 = oVar.c(4);
                } else {
                    int iC4 = oVar.c(3);
                    if (iC4 != 0) {
                        z = z2;
                        i3 = iC4 + 2;
                        iC2 = 0;
                    } else {
                        iC2 = 0;
                        z = true;
                        i3 = 0;
                    }
                }
                if (i3 != 0 && paint != null) {
                    if (bArr != null) {
                        iC2 = bArr[iC2];
                    }
                    paint.setColor(iArr[iC2]);
                    canvas.drawRect(i4, i2, i4 + i3, i2 + 1, paint);
                }
                i4 += i3;
                if (!z) {
                    return i4;
                }
                z2 = z;
            }
            i3 = 1;
            if (i3 != 0) {
                if (bArr != null) {
                }
                paint.setColor(iArr[iC2]);
                canvas.drawRect(i4, i2, i4 + i3, i2 + 1, paint);
            }
            i4 += i3;
            if (!z) {
            }
        }
    }

    private static int c(o oVar, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        boolean z;
        int iC;
        int i3 = i;
        boolean z2 = false;
        while (true) {
            int iC2 = oVar.c(8);
            if (iC2 != 0) {
                z = z2;
                iC = 1;
            } else if (oVar.e()) {
                z = z2;
                iC = oVar.c(7);
                iC2 = oVar.c(8);
            } else {
                int iC3 = oVar.c(7);
                if (iC3 != 0) {
                    z = z2;
                    iC = iC3;
                    iC2 = 0;
                } else {
                    iC2 = 0;
                    z = true;
                    iC = 0;
                }
            }
            if (iC != 0 && paint != null) {
                if (bArr != null) {
                    iC2 = bArr[iC2];
                }
                paint.setColor(iArr[iC2]);
                canvas.drawRect(i3, i2, i3 + iC, i2 + 1, paint);
            }
            i3 += iC;
            if (z) {
                return i3;
            }
            z2 = z;
        }
    }

    private static int[] d() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i = 0; i < 256; i++) {
            if (i < 8) {
                iArr[i] = a(63, (i & 1) != 0 ? 255 : 0, (i & 2) != 0 ? 255 : 0, (i & 4) == 0 ? 0 : 255);
            } else {
                int i2 = i & 136;
                if (i2 == 0) {
                    iArr[i] = a(255, ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                } else if (i2 == 8) {
                    iArr[i] = a(127, ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                } else if (i2 == 128) {
                    iArr[i] = a(255, ((i & 1) != 0 ? 43 : 0) + 127 + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + 127 + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + 127 + ((i & 64) == 0 ? 0 : 85));
                } else if (i2 == 136) {
                    iArr[i] = a(255, ((i & 1) != 0 ? 43 : 0) + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + ((i & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007a A[LOOP:0: B:3:0x0009->B:33:0x007a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0079 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int a(o oVar, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        boolean z;
        int i3;
        int iC;
        int i4 = i;
        boolean z2 = false;
        while (true) {
            int iC2 = oVar.c(2);
            if (iC2 != 0) {
                z = z2;
            } else {
                if (oVar.e()) {
                    iC = oVar.c(3) + 3;
                } else if (oVar.e()) {
                    z = z2;
                    iC2 = 0;
                } else {
                    int iC3 = oVar.c(2);
                    if (iC3 == 0) {
                        iC2 = 0;
                        z = true;
                    } else if (iC3 == 1) {
                        z = z2;
                        iC2 = 0;
                        i3 = 2;
                        if (i3 != 0 && paint != null) {
                            if (bArr != null) {
                                iC2 = bArr[iC2];
                            }
                            paint.setColor(iArr[iC2]);
                            canvas.drawRect(i4, i2, i4 + i3, i2 + 1, paint);
                        }
                        i4 += i3;
                        if (!z) {
                            return i4;
                        }
                        z2 = z;
                    } else if (iC3 == 2) {
                        iC = oVar.c(4) + 12;
                    } else if (iC3 != 3) {
                        z = z2;
                        iC2 = 0;
                    } else {
                        iC = oVar.c(8) + 29;
                    }
                    i3 = 0;
                    if (i3 != 0) {
                        if (bArr != null) {
                        }
                        paint.setColor(iArr[iC2]);
                        canvas.drawRect(i4, i2, i4 + i3, i2 + 1, paint);
                    }
                    i4 += i3;
                    if (!z) {
                    }
                }
                z = z2;
                i3 = iC;
                iC2 = oVar.c(2);
                if (i3 != 0) {
                }
                i4 += i3;
                if (!z) {
                }
            }
            i3 = 1;
            if (i3 != 0) {
            }
            i4 += i3;
            if (!z) {
            }
        }
    }

    private static c b(o oVar) {
        byte[] bArr;
        int iC = oVar.c(16);
        oVar.b(4);
        int iC2 = oVar.c(2);
        boolean zE = oVar.e();
        oVar.b(1);
        byte[] bArr2 = null;
        if (iC2 != 1) {
            if (iC2 == 0) {
                int iC3 = oVar.c(16);
                int iC4 = oVar.c(16);
                if (iC3 > 0) {
                    bArr2 = new byte[iC3];
                    oVar.b(bArr2, 0, iC3);
                }
                if (iC4 > 0) {
                    bArr = new byte[iC4];
                    oVar.b(bArr, 0, iC4);
                }
            }
            return new c(iC, zE, bArr2, bArr);
        }
        oVar.b(oVar.c(8) * 16);
        bArr = bArr2;
        return new c(iC, zE, bArr2, bArr);
    }

    private static a c(o oVar, int i) {
        int iC;
        int i2;
        int iC2;
        int iC3;
        int iC4;
        int i3 = 8;
        int iC5 = oVar.c(8);
        oVar.b(8);
        int i4 = 2;
        int i5 = i - 2;
        int[] iArrB = b();
        int[] iArrC = c();
        int[] iArrD = d();
        while (i5 > 0) {
            int iC6 = oVar.c(i3);
            int iC7 = oVar.c(i3);
            int i6 = i5 - 2;
            int[] iArr = (iC7 & 128) != 0 ? iArrB : (iC7 & 64) != 0 ? iArrC : iArrD;
            if ((iC7 & 1) != 0) {
                iC3 = oVar.c(i3);
                iC4 = oVar.c(i3);
                iC = oVar.c(i3);
                iC2 = oVar.c(i3);
                i2 = i6 - 4;
            } else {
                int iC8 = oVar.c(6) << i4;
                int iC9 = oVar.c(4) << 4;
                iC = oVar.c(4) << 4;
                i2 = i6 - 2;
                iC2 = oVar.c(i4) << 6;
                iC3 = iC8;
                iC4 = iC9;
            }
            if (iC3 == 0) {
                iC4 = 0;
                iC = 0;
                iC2 = 255;
            }
            double d2 = iC3;
            double d3 = iC4 - 128;
            double d4 = iC - 128;
            iArr[iC6] = a((byte) (255 - (iC2 & 255)), y.a((int) (d2 + (1.402d * d3)), 0, 255), y.a((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 0, 255), y.a((int) (d2 + (d4 * 1.772d)), 0, 255));
            i5 = i2;
            iC5 = iC5;
            i3 = 8;
            i4 = 2;
        }
        return new a(iC5, iArrB, iArrC, iArrD);
    }

    private static C0701b a(o oVar) {
        int i;
        int iC;
        int i2;
        int i3;
        oVar.b(4);
        boolean zE = oVar.e();
        oVar.b(3);
        int iC2 = oVar.c(16);
        int iC3 = oVar.c(16);
        if (zE) {
            int iC4 = oVar.c(16);
            int iC5 = oVar.c(16);
            int iC6 = oVar.c(16);
            iC = oVar.c(16);
            i = iC5;
            i3 = iC6;
            i2 = iC4;
        } else {
            i = iC2;
            iC = iC3;
            i2 = 0;
            i3 = 0;
        }
        return new C0701b(iC2, iC3, i2, i, i3, iC);
    }

    private static f b(o oVar, int i) {
        int iC;
        int iC2;
        int iC3 = oVar.c(8);
        oVar.b(4);
        boolean zE = oVar.e();
        oVar.b(3);
        int i2 = 16;
        int iC4 = oVar.c(16);
        int iC5 = oVar.c(16);
        int iC6 = oVar.c(3);
        int iC7 = oVar.c(3);
        int i3 = 2;
        oVar.b(2);
        int iC8 = oVar.c(8);
        int iC9 = oVar.c(8);
        int iC10 = oVar.c(4);
        int iC11 = oVar.c(2);
        oVar.b(2);
        int i4 = i - 10;
        SparseArray sparseArray = new SparseArray();
        while (i4 > 0) {
            int iC12 = oVar.c(i2);
            int iC13 = oVar.c(i3);
            int iC14 = oVar.c(i3);
            int iC15 = oVar.c(12);
            int i5 = iC11;
            oVar.b(4);
            int iC16 = oVar.c(12);
            i4 -= 6;
            if (iC13 == 1 || iC13 == 2) {
                i4 -= 2;
                iC = oVar.c(8);
                iC2 = oVar.c(8);
            } else {
                iC = 0;
                iC2 = 0;
            }
            sparseArray.put(iC12, new g(iC13, iC14, iC15, iC16, iC, iC2));
            iC11 = i5;
            i3 = 2;
            i2 = 16;
        }
        return new f(iC3, zE, iC4, iC5, iC6, iC7, iC8, iC9, iC10, iC11, sparseArray);
    }

    private static int[] c() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < 16; i++) {
            if (i < 8) {
                iArr[i] = a(255, (i & 1) != 0 ? 255 : 0, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
            } else {
                iArr[i] = a(255, (i & 1) != 0 ? 127 : 0, (i & 2) != 0 ? 127 : 0, (i & 4) == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    private static d a(o oVar, int i) {
        int iC = oVar.c(8);
        int iC2 = oVar.c(4);
        int iC3 = oVar.c(2);
        oVar.b(2);
        int i2 = i - 2;
        SparseArray sparseArray = new SparseArray();
        while (i2 > 0) {
            int iC4 = oVar.c(8);
            oVar.b(8);
            i2 -= 6;
            sparseArray.put(iC4, new e(oVar.c(16), oVar.c(16)));
        }
        return new d(iC, iC2, iC3, sparseArray);
    }

    private static int[] b() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    public List<Cue> a(byte[] bArr, int i) {
        int i2;
        SparseArray<g> sparseArray;
        o oVar = new o(bArr, i);
        while (oVar.a() >= 48 && oVar.c(8) == 15) {
            a(oVar, this.i);
        }
        h hVar = this.i;
        if (hVar.i == null) {
            return Collections.emptyList();
        }
        C0701b c0701b = hVar.h;
        if (c0701b == null) {
            c0701b = this.g;
        }
        Bitmap bitmap = this.j;
        if (bitmap == null || c0701b.f8328a + 1 != bitmap.getWidth() || c0701b.b + 1 != this.j.getHeight()) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(c0701b.f8328a + 1, c0701b.b + 1, Bitmap.Config.ARGB_8888);
            this.j = bitmapCreateBitmap;
            this.f.setBitmap(bitmapCreateBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<e> sparseArray2 = this.i.i.c;
        for (int i3 = 0; i3 < sparseArray2.size(); i3++) {
            e eVarValueAt = sparseArray2.valueAt(i3);
            f fVar = this.i.c.get(sparseArray2.keyAt(i3));
            int i4 = eVarValueAt.f8331a + c0701b.c;
            int i5 = eVarValueAt.b + c0701b.e;
            float f2 = i4;
            float f3 = i5;
            this.f.clipRect(f2, f3, Math.min(fVar.c + i4, c0701b.d), Math.min(fVar.d + i5, c0701b.f), Region.Op.REPLACE);
            a aVar = this.i.d.get(fVar.f);
            if (aVar == null && (aVar = this.i.f.get(fVar.f)) == null) {
                aVar = this.h;
            }
            SparseArray<g> sparseArray3 = fVar.j;
            int i6 = 0;
            while (i6 < sparseArray3.size()) {
                int iKeyAt = sparseArray3.keyAt(i6);
                g gVarValueAt = sparseArray3.valueAt(i6);
                c cVar = this.i.e.get(iKeyAt);
                c cVar2 = cVar == null ? this.i.g.get(iKeyAt) : cVar;
                if (cVar2 != null) {
                    i2 = i6;
                    sparseArray = sparseArray3;
                    a(cVar2, aVar, fVar.e, gVarValueAt.f8333a + i4, i5 + gVarValueAt.b, cVar2.b ? null : this.d, this.f);
                } else {
                    i2 = i6;
                    sparseArray = sparseArray3;
                }
                i6 = i2 + 1;
                sparseArray3 = sparseArray;
            }
            if (fVar.b) {
                int i7 = fVar.e;
                this.e.setColor(i7 == 3 ? aVar.d[fVar.g] : i7 == 2 ? aVar.c[fVar.h] : aVar.b[fVar.i]);
                this.f.drawRect(f2, f3, fVar.c + i4, fVar.d + i5, this.e);
            }
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.j, i4, i5, fVar.c, fVar.d);
            float f4 = c0701b.f8328a;
            float f5 = c0701b.b;
            arrayList.add(new Cue(bitmapCreateBitmap2, f2 / f4, 0, f3 / f5, 0, fVar.c / f4, fVar.d / f5));
            this.f.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        return arrayList;
    }

    public void a() {
        this.i.a();
    }

    private static void a(c cVar, a aVar, int i, int i2, int i3, Paint paint, Canvas canvas) {
        int[] iArr = i == 3 ? aVar.d : i == 2 ? aVar.c : aVar.b;
        a(cVar.c, iArr, i, i2, i3, paint, canvas);
        a(cVar.d, iArr, i, i2, i3 + 1, paint, canvas);
    }

    private static void a(o oVar, h hVar) {
        SparseArray sparseArray;
        a aVar;
        int i;
        Object obj;
        c cVar;
        int iC = oVar.c(8);
        int iC2 = oVar.c(16);
        int iC3 = oVar.c(16);
        int iC4 = oVar.c() + iC3;
        if (iC3 * 8 > oVar.a()) {
            com.opos.cmn.an.f.a.c("DvbParser", "Data field length exceeds limit");
            oVar.b(oVar.a());
            return;
        }
        switch (iC) {
            case 16:
                if (iC2 == hVar.f8334a) {
                    d dVar = hVar.i;
                    d dVarA = a(oVar, iC3);
                    if (dVarA.b != 0) {
                        hVar.i = dVarA;
                        hVar.c.clear();
                        hVar.d.clear();
                        hVar.e.clear();
                    } else if (dVar != null && dVar.f8330a != dVarA.f8330a) {
                        hVar.i = dVarA;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.i;
                if (iC2 == hVar.f8334a && dVar2 != null) {
                    f fVarB = b(oVar, iC3);
                    if (dVar2.b == 0) {
                        fVarB.a(hVar.c.get(fVarB.f8332a));
                    }
                    hVar.c.put(fVarB.f8332a, fVarB);
                }
                break;
            case 18:
                if (iC2 == hVar.f8334a) {
                    a aVarC = c(oVar, iC3);
                    sparseArray = hVar.d;
                    aVar = aVarC;
                } else if (iC2 == hVar.b) {
                    a aVarC2 = c(oVar, iC3);
                    sparseArray = hVar.f;
                    aVar = aVarC2;
                }
                i = aVar.f8327a;
                obj = aVar;
                sparseArray.put(i, obj);
                break;
            case 19:
                if (iC2 == hVar.f8334a) {
                    c cVarB = b(oVar);
                    sparseArray = hVar.e;
                    cVar = cVarB;
                } else if (iC2 == hVar.b) {
                    c cVarB2 = b(oVar);
                    sparseArray = hVar.g;
                    cVar = cVarB2;
                }
                i = cVar.f8329a;
                obj = cVar;
                sparseArray.put(i, obj);
                break;
            case 20:
                if (iC2 == hVar.f8334a) {
                    hVar.h = a(oVar);
                }
                break;
        }
        oVar.d(iC4 - oVar.c());
    }

    private static void a(byte[] bArr, int[] iArr, int i, int i2, int i3, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        o oVar = new o(bArr);
        int iA = i2;
        int i4 = i3;
        byte[] bArrA = null;
        byte[] bArrA2 = null;
        while (oVar.a() != 0) {
            int iC = oVar.c(8);
            if (iC != 240) {
                switch (iC) {
                    case 16:
                        if (i != 3) {
                            if (i != 2) {
                                bArr2 = null;
                            } else if (bArrA2 == null) {
                                bArr3 = f8326a;
                                bArr2 = bArr3;
                            } else {
                                bArr2 = bArrA2;
                            }
                            iA = a(oVar, iArr, bArr2, iA, i4, paint, canvas);
                        } else if (bArrA != null) {
                            bArr2 = bArrA;
                            iA = a(oVar, iArr, bArr2, iA, i4, paint, canvas);
                        } else {
                            bArr3 = b;
                            bArr2 = bArr3;
                            iA = a(oVar, iArr, bArr2, iA, i4, paint, canvas);
                        }
                        break;
                    case 17:
                        iA = b(oVar, iArr, i == 3 ? c : null, iA, i4, paint, canvas);
                        break;
                    case 18:
                        iA = c(oVar, iArr, null, iA, i4, paint, canvas);
                        continue;
                    default:
                        switch (iC) {
                            case 32:
                                bArrA2 = a(4, 4, oVar);
                                break;
                            case 33:
                                bArrA = a(4, 8, oVar);
                                break;
                            case 34:
                                bArrA = a(16, 8, oVar);
                                break;
                            default:
                                continue;
                        }
                        break;
                }
                oVar.f();
            } else {
                i4 += 2;
                iA = i2;
            }
        }
    }

    private static byte[] a(int i, int i2, o oVar) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) oVar.c(i2);
        }
        return bArr;
    }
}
