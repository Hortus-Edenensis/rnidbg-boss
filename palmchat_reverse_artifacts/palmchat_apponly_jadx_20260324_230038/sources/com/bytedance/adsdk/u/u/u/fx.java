package com.bytedance.adsdk.u.u.u;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.umeng.analytics.pro.dn;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class fx extends n<com.bytedance.adsdk.u.u.nr.u, com.bytedance.adsdk.u.u.nr.nr> {
    static final /* synthetic */ boolean iz = true;
    private static final byte[] k = {-119, 80, 78, 71, dn.k, 10, 26, 10};
    private static final byte[] my = {0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};
    private static final ThreadLocal<CRC32> o = new ThreadLocal<>();
    List<pn> b;
    byte[] fx;
    public final byte nr;
    List<pn> pn;
    public final byte u;

    public fx(com.bytedance.adsdk.u.u.nr.u uVar, iz izVar) {
        super(uVar);
        this.b = new ArrayList();
        this.pn = new ArrayList();
        this.u = izVar.s;
        this.nr = izVar.mv;
        int i = izVar.t * 1000;
        short s = izVar.l;
        int i2 = i / (s == 0 ? (short) 100 : s);
        this.l = i2;
        if (i2 < 10) {
            this.l = 100;
        }
        this.n = izVar.fx;
        this.f5022a = izVar.n;
        this.jk = izVar.f5021a;
        this.t = izVar.jk;
    }

    private CRC32 u() {
        ThreadLocal<CRC32> threadLocal = o;
        CRC32 crc32 = threadLocal.get();
        if (crc32 != null) {
            return crc32;
        }
        CRC32 crc322 = new CRC32();
        threadLocal.set(crc322);
        return crc322;
    }

    private int u(com.bytedance.adsdk.u.u.nr.nr nrVar) throws IOException {
        int i;
        Iterator<pn> it = this.pn.iterator();
        int i2 = 33;
        while (it.hasNext()) {
            i2 += it.next().b + 12;
        }
        for (pn pnVar : this.b) {
            if (pnVar instanceof jk) {
                i = pnVar.b + 12;
            } else if (pnVar instanceof x) {
                i = pnVar.b + 8;
            }
            i2 += i;
        }
        int length = i2 + my.length;
        nrVar.fx(length);
        nrVar.u(k);
        nrVar.nr(13);
        int iU = nrVar.u();
        nrVar.u(l.u);
        nrVar.nr(this.n);
        nrVar.nr(this.f5022a);
        nrVar.u(this.fx);
        CRC32 crc32U = u();
        crc32U.reset();
        crc32U.update(nrVar.nr(), iU, 17);
        nrVar.nr((int) crc32U.getValue());
        for (pn pnVar2 : this.pn) {
            if (!(pnVar2 instanceof t)) {
                ((com.bytedance.adsdk.u.u.nr.u) this.x).d_();
                ((com.bytedance.adsdk.u.u.nr.u) this.x).u(pnVar2.x);
                ((com.bytedance.adsdk.u.u.nr.u) this.x).u(nrVar.nr(), nrVar.u(), pnVar2.b + 12);
                nrVar.b(pnVar2.b + 12);
            }
        }
        for (pn pnVar3 : this.b) {
            if (pnVar3 instanceof jk) {
                ((com.bytedance.adsdk.u.u.nr.u) this.x).d_();
                ((com.bytedance.adsdk.u.u.nr.u) this.x).u(pnVar3.x);
                ((com.bytedance.adsdk.u.u.nr.u) this.x).u(nrVar.nr(), nrVar.u(), pnVar3.b + 12);
                nrVar.b(pnVar3.b + 12);
            } else if (pnVar3 instanceof x) {
                nrVar.nr(pnVar3.b - 4);
                int iU2 = nrVar.u();
                nrVar.u(jk.u);
                ((com.bytedance.adsdk.u.u.nr.u) this.x).d_();
                ((com.bytedance.adsdk.u.u.nr.u) this.x).u(pnVar3.x + 4 + 4 + 4);
                ((com.bytedance.adsdk.u.u.nr.u) this.x).u(nrVar.nr(), nrVar.u(), pnVar3.b - 4);
                nrVar.b(pnVar3.b - 4);
                crc32U.reset();
                crc32U.update(nrVar.nr(), iU2, pnVar3.b);
                nrVar.nr((int) crc32U.getValue());
            }
        }
        nrVar.u(my);
        return length;
    }

    @Override // com.bytedance.adsdk.u.u.u.n
    public Bitmap u(Canvas canvas, Paint paint, int i, Bitmap bitmap, com.bytedance.adsdk.u.u.nr.nr nrVar) {
        Bitmap bitmapDecodeByteArray;
        try {
            int iU = u(nrVar);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = i;
            options.inMutable = true;
            options.inBitmap = bitmap;
            byte[] bArrNr = nrVar.nr();
            try {
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrNr, 0, iU, options);
            } catch (IllegalArgumentException unused) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = i;
                options2.inMutable = true;
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrNr, 0, iU, options2);
            }
            if (!iz && bitmapDecodeByteArray == null) {
                throw new AssertionError();
            }
            Rect rect = this.mv;
            rect.left = 0;
            rect.top = 0;
            rect.right = bitmapDecodeByteArray.getWidth();
            this.mv.bottom = bitmapDecodeByteArray.getHeight();
            Rect rect2 = this.s;
            int i2 = this.jk;
            float f = i;
            rect2.left = (int) (i2 / f);
            rect2.top = (int) (this.t / f);
            rect2.right = (int) ((i2 / f) + bitmapDecodeByteArray.getWidth());
            this.s.bottom = (int) ((this.t / f) + bitmapDecodeByteArray.getHeight());
            canvas.drawBitmap(bitmapDecodeByteArray, this.mv, this.s, paint);
            return bitmapDecodeByteArray;
        } catch (IOException unused2) {
            return null;
        }
    }
}
