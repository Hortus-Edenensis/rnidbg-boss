package com.amap.api.col.p0002sl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.Path;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class bj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final a[] f2647a;
    protected final int b;
    protected final int c;
    protected final a[] d;
    private boolean e;
    private long f;
    private aw g;
    private Paint h = null;
    private Path i = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Bitmap f2648a = null;
        String b = "";
        boolean c = false;
        long d = 0;
        int e = -1;
        long f = 0;
        List<Object> g = null;

        public a() {
        }
    }

    public bj(int i, int i2, boolean z, long j, aw awVar) {
        this.b = i;
        this.c = i2;
        this.g = awVar;
        this.e = z;
        this.f = j * 1000000;
        if (i > 0) {
            this.f2647a = new a[i];
            this.d = new a[i2];
        } else {
            this.f2647a = null;
            this.d = null;
        }
    }

    private static long b() {
        return System.nanoTime();
    }

    private int c() {
        for (int i = 0; i < this.c; i++) {
            this.d[i] = null;
        }
        for (int i2 = 0; i2 < this.b; i2++) {
            a aVar = this.f2647a[i2];
            int i3 = 0;
            while (true) {
                if (i3 >= this.c) {
                    break;
                }
                a[] aVarArr = this.d;
                a aVar2 = aVarArr[i3];
                if (aVar2 == null) {
                    aVarArr[i3] = aVar;
                    break;
                }
                if (aVar2.d > aVar.d) {
                    aVarArr[i3] = aVar;
                    aVar = aVar2;
                }
                i3++;
            }
        }
        int i4 = -1;
        for (int i5 = 0; i5 < this.c; i5++) {
            a aVar3 = this.d[i5];
            if (aVar3 != null) {
                aVar3.c = false;
                if (i4 < 0) {
                    i4 = aVar3.e;
                }
            }
        }
        return i4;
    }

    private int d() {
        int i = -1;
        for (int i2 = 0; i2 < this.b; i2++) {
            a[] aVarArr = this.f2647a;
            a aVar = aVarArr[i2];
            if (aVar == null) {
                aVarArr[i2] = new a();
                this.f2647a[i2].e = i2;
                return i2;
            }
            if (!aVar.c && i < 0) {
                i = i2;
            }
        }
        return i;
    }

    public final int a(String str) {
        String str2;
        if (str != null && !str.equals("")) {
            for (int i = 0; i < this.b; i++) {
                a aVar = this.f2647a[i];
                if (aVar != null && (str2 = aVar.b) != null && str2.equals(str)) {
                    if (!this.f2647a[i].c) {
                        return -1;
                    }
                    if (this.e) {
                        long jB = b();
                        a aVar2 = this.f2647a[i];
                        if (jB - aVar2.f > this.f) {
                            aVar2.c = false;
                            return -1;
                        }
                    }
                    a aVar3 = this.f2647a[i];
                    if (aVar3.f2648a == null) {
                        return -1;
                    }
                    aVar3.d = b();
                    return i;
                }
            }
        }
        return -1;
    }

    public final Bitmap a(int i) {
        a aVar;
        if (i < 0 || i >= this.b || (aVar = this.f2647a[i]) == null) {
            return null;
        }
        return aVar.f2648a;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0091 A[Catch: all -> 0x0013, TRY_ENTER, TryCatch #1 {all -> 0x0013, blocks: (B:10:0x000e, B:17:0x001b, B:21:0x0021, B:23:0x0026, B:25:0x002a, B:27:0x0030, B:28:0x003f, B:30:0x0047, B:37:0x0063, B:44:0x0081, B:46:0x0089, B:51:0x0091, B:53:0x009f, B:43:0x007a, B:34:0x0056, B:40:0x006d), top: B:66:0x000e, inners: #0, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized int a(byte[] bArr, byte[] bArr2, boolean z, String str) {
        int iD;
        a aVar;
        Bitmap bitmap;
        int i = -1;
        if (bArr == null && bArr2 == null) {
            return -1;
        }
        try {
            iD = d();
            if (iD < 0) {
                try {
                    iD = c();
                } catch (Throwable th) {
                    th = th;
                    i = iD;
                    ct.a(th, "BitmapManager", "setBitmapData");
                    iD = i;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        if (iD < 0) {
            return -1;
        }
        a[] aVarArr = this.f2647a;
        if (aVarArr == null) {
            return -1;
        }
        a aVar2 = aVarArr[iD];
        if (aVar2 != null && (bitmap = aVar2.f2648a) != null && !bitmap.isRecycled()) {
            this.f2647a[iD].f2648a.recycle();
            this.f2647a[iD].f2648a = null;
        }
        List<Object> list = this.f2647a[iD].g;
        if (list != null) {
            list.clear();
            this.f2647a[iD].g = null;
        }
        if (z && bArr != null) {
            try {
                this.f2647a[iD].f2648a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            } catch (Throwable th3) {
                ct.a(th3, "BitmapManager", "setBitmapData");
            }
            aVar = this.f2647a[iD];
            if (aVar.f2648a != null) {
            }
            if (aVar != null) {
            }
        } else {
            if (bArr2 != null) {
                try {
                    this.f2647a[iD].f2648a = BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length);
                } catch (Throwable th4) {
                    ct.a(th4, "BitmapManager", "setBitmapData");
                }
            }
            aVar = this.f2647a[iD];
            if (aVar.f2648a != null && aVar.g == null) {
                return -1;
            }
            if (aVar != null) {
                aVar.c = true;
                aVar.b = str;
                aVar.d = b();
                if (this.e) {
                    this.f2647a[iD].f = b();
                }
            }
        }
        return iD;
    }

    public final void a() {
        for (int i = 0; i < this.b; i++) {
            a aVar = this.f2647a[i];
            if (aVar != null) {
                Bitmap bitmap = aVar.f2648a;
                if (bitmap != null && !bitmap.isRecycled()) {
                    this.f2647a[i].f2648a.recycle();
                }
                this.f2647a[i].f2648a = null;
            }
        }
    }
}
