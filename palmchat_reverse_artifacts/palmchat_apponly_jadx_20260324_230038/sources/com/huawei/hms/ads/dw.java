package com.huawei.hms.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Gravity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class dw extends Drawable implements Animatable, Drawable.Callback {
    private static final int B = 2;
    private static final int C = 119;
    private static final String Code = "GifDrawable";
    private static final int D = 2;
    private static final int F = 5;
    private static final int I = 640;
    private static final int L = 4;
    private static final String S = "render_frame";
    private static final int V = 0;
    private static final int Z = 960;
    private Paint f;
    private String i;
    private int l;
    private int m;
    private dv o;
    private Context p;
    private dx r;
    private boolean s;
    private com.huawei.openalliance.ad.utils.w t;
    private dy v;
    private a w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6536a = S + hashCode();
    private Canvas b = new Canvas();
    private Rect c = new Rect();
    private Rect d = new Rect();
    private Rect e = new Rect();
    private boolean g = false;
    private int h = 0;
    private Queue<dx> j = new ConcurrentLinkedQueue();
    private Queue<Bitmap> k = new ConcurrentLinkedQueue();
    private boolean n = false;
    private long q = 0;
    private final WeakHashMap<Drawable.Callback, Void> u = new WeakHashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void Code(Bitmap bitmap);
    }

    public dw(Context context, String str) {
        this.p = context.getApplicationContext();
        this.i = str;
        com.huawei.openalliance.ad.utils.w wVar = new com.huawei.openalliance.ad.utils.w("gif-thread");
        this.t = wVar;
        wVar.Code();
        setCallback(this);
    }

    private InputStream B(String str) {
        String strE;
        StringBuilder sb;
        try {
            return this.p.getResources().openRawResource(Integer.parseInt(str.substring(com.huawei.openalliance.ad.constant.ce.RES.toString().length())));
        } catch (Resources.NotFoundException e) {
            e = e;
            strE = e();
            sb = new StringBuilder();
            sb.append("loadFile ");
            sb.append(e.getClass().getSimpleName());
            fh.I(strE, sb.toString());
            return null;
        } catch (NumberFormatException e2) {
            e = e2;
            strE = e();
            sb = new StringBuilder();
            sb.append("loadFile ");
            sb.append(e.getClass().getSimpleName());
            fh.I(strE, sb.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap Code(Bitmap bitmap, boolean z) {
        int i;
        if (fh.Code()) {
            fh.Code(e(), "image pool size: %d", Integer.valueOf(this.k.size()));
        }
        Bitmap bitmapPoll = this.k.poll();
        if (bitmapPoll == null) {
            fh.V(e(), "cache bitmap null");
            if (!z) {
                return bitmap.copy(bitmap.getConfig(), true);
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width < height) {
                i = 640;
                if (width <= 640) {
                    i = width;
                }
                int i2 = (int) (((i * height) * 1.0f) / width);
                fh.V(e(), "reduce image size to w: %d, h: %d src w: %d, h: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(width), Integer.valueOf(height));
                bitmapPoll = Bitmap.createBitmap(i, i2, Bitmap.Config.RGB_565);
            } else {
                i = Z;
                if (width <= Z) {
                }
                int i22 = (int) (((i * height) * 1.0f) / width);
                fh.V(e(), "reduce image size to w: %d, h: %d src w: %d, h: %d", Integer.valueOf(i), Integer.valueOf(i22), Integer.valueOf(width), Integer.valueOf(height));
                bitmapPoll = Bitmap.createBitmap(i, i22, Bitmap.Config.RGB_565);
            }
        }
        Code(bitmap, bitmapPoll);
        return bitmapPoll;
    }

    public static /* synthetic */ int D(dw dwVar) {
        int i = dwVar.l;
        dwVar.l = i + 1;
        return i;
    }

    private Paint Z() {
        if (this.f == null) {
            this.f = new Paint(2);
        }
        return this.f;
    }

    private void b() {
        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.dw.6
            @Override // java.lang.Runnable
            public void run() {
                if (dw.this.v != null) {
                    dw.this.v.Code();
                }
            }
        });
    }

    private void c() {
        this.k.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        fh.V(e(), "on play end");
        c();
        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.dw.8
            @Override // java.lang.Runnable
            public void run() {
                if (dw.this.v != null) {
                    dw.this.v.I();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e() {
        return "GifDrawable_" + hashCode();
    }

    public int I() {
        int size = (this.k.size() + this.j.size()) * getIntrinsicWidth() * getIntrinsicHeight() * 4;
        if (size > 0) {
            return size;
        }
        return 1;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        dx dxVar = this.r;
        if (dxVar == null || dxVar.V == null) {
            return;
        }
        if (fh.Code()) {
            fh.Code(e(), "draw frame: %d", Integer.valueOf(this.r.Code));
        }
        if (this.s) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.c);
            this.s = false;
        }
        canvas.drawBitmap(this.r.V, (Rect) null, this.c, Z());
    }

    public void finalize() throws Throwable {
        super.finalize();
        this.t.V();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        dx dxVar = this.r;
        return dxVar != null ? dxVar.V.getHeight() : super.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        dx dxVar = this.r;
        return dxVar != null ? dxVar.V.getWidth() : super.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        for (Drawable.Callback callback : this.u.keySet()) {
            if (callback != null) {
                callback.invalidateDrawable(drawable);
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.s = true;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        for (Drawable.Callback callback : this.u.keySet()) {
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Z().setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Z().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        fh.V(e(), "setVisible " + z);
        if (!z) {
            stop();
        } else if (!this.g) {
            start();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        fh.V(e(), "start");
        this.g = true;
        Code();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        fh.V(e(), "stop");
        this.g = false;
        V();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        for (Drawable.Callback callback : this.u.keySet()) {
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        fh.V(e(), "replay " + com.huawei.openalliance.ad.utils.bl.Code(this.i));
        Code(this.i);
    }

    private InputStream C(String str) {
        try {
            return this.p.getAssets().open(str.substring(com.huawei.openalliance.ad.constant.ce.ASSET.toString().length()));
        } catch (IOException e) {
            fh.I(e(), "loadFile " + e.getClass().getSimpleName());
            return null;
        }
    }

    private void D() {
        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.dw.3
            @Override // java.lang.Runnable
            public void run() {
                if (dw.this.v != null) {
                    dw.this.v.V();
                }
                dw.this.V();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean F() {
        return this.n;
    }

    private InputStream I(String str) {
        try {
            return this.p.getContentResolver().openInputStream(Uri.parse(str));
        } catch (FileNotFoundException e) {
            fh.I(e(), "oPIs " + e.getClass().getSimpleName());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        final dv dvVar;
        if (F() || (dvVar = this.o) == null || dvVar.I()) {
            return;
        }
        this.t.Code(new Runnable() { // from class: com.huawei.hms.ads.dw.4
            @Override // java.lang.Runnable
            public void run() {
                fh.V(dw.this.e(), "fetch next");
                long jCurrentTimeMillis = System.currentTimeMillis();
                dx dxVarCode = dvVar.Code();
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                fh.Code(dw.this.e(), "frame fetch - decoding duration: %d gif: %s", Long.valueOf(jCurrentTimeMillis2), dxVarCode);
                dw dwVar = dw.this;
                if (dxVarCode == null) {
                    dx dxVar = (dx) dwVar.j.poll();
                    if (dxVar != null) {
                        dw.this.Code(dxVar);
                        return;
                    }
                    long jCurrentTimeMillis3 = System.currentTimeMillis() - dw.this.q;
                    if (jCurrentTimeMillis3 < dw.this.m) {
                        try {
                            Thread.sleep(((long) dw.this.m) - jCurrentTimeMillis3);
                        } catch (InterruptedException unused) {
                            fh.Code(dw.this.e(), "InterruptedException");
                        }
                    }
                    dw.this.a();
                    return;
                }
                boolean zCode = dwVar.Code(dxVarCode, jCurrentTimeMillis2);
                fh.Code(dw.this.e(), "need reduce size: %s", Boolean.valueOf(zCode));
                dx dxVarCode2 = dxVarCode.Code();
                dxVarCode2.V = dw.this.Code(dxVarCode.V, zCode);
                if (!dw.this.j.offer(dxVarCode2)) {
                    fh.I(dw.this.e(), "fail to add frame to cache");
                }
                int i = dxVarCode2.I;
                if (jCurrentTimeMillis2 <= i) {
                    fh.V(dw.this.e(), "send to render directly");
                } else {
                    int i2 = (int) ((jCurrentTimeMillis2 * 1.0d) / ((double) i));
                    if (i2 > 5) {
                        i2 = 5;
                    }
                    fh.Code(dw.this.e(), "preferred cached frame num: %d", Integer.valueOf(i2));
                    if (dw.this.j.size() < i2) {
                        dw.this.L();
                        return;
                    }
                }
                dw dwVar2 = dw.this;
                dwVar2.Code((dx) dwVar2.j.poll());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        dv dvVar = this.o;
        if (dvVar != null) {
            dvVar.V();
            this.o = null;
        }
    }

    private InputStream Z(String str) {
        try {
            return new FileInputStream(new File(str));
        } catch (FileNotFoundException e) {
            fh.I(e(), "loadFile " + e.getClass().getSimpleName());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.dw.5
            @Override // java.lang.Runnable
            public void run() {
                dw.D(dw.this);
                if (dw.this.h == 0 || dw.this.l < dw.this.h) {
                    dw.this.B();
                } else {
                    dw.this.V();
                    dw.this.d();
                }
            }
        });
    }

    private void C() {
        Code(false);
        this.l = 0;
        this.j.clear();
    }

    public void Code() {
        if (TextUtils.isEmpty(this.i)) {
            return;
        }
        fh.V(e(), "play " + com.huawei.openalliance.ad.utils.bl.Code(this.i));
        V();
        C();
        Code(this.i);
    }

    public void V() {
        fh.V(e(), "stop play " + com.huawei.openalliance.ad.utils.bl.Code(this.i));
        com.huawei.openalliance.ad.utils.bj.Code(this.f6536a);
        Code(true);
        this.j.clear();
        this.t.Code(new Runnable() { // from class: com.huawei.hms.ads.dw.1
            @Override // java.lang.Runnable
            public void run() {
                dw.this.S();
            }
        });
    }

    private void I(dx dxVar) {
        if (dxVar == null || this.k.size() >= 2) {
            fh.V(e(), "drop frame");
        } else {
            if (this.k.contains(dxVar.V) || this.k.offer(dxVar.V)) {
                return;
            }
            fh.I(e(), "fail to release frame to pool");
        }
    }

    private void V(dx dxVar) {
        a aVar;
        I(this.r);
        this.r = dxVar;
        if (dxVar != null && (aVar = this.w) != null) {
            aVar.Code(dxVar.V);
        }
        this.m = dxVar.I;
        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.dw.7
            @Override // java.lang.Runnable
            public void run() {
                if (dw.this.F()) {
                    dw.this.r = null;
                } else {
                    dw.this.invalidateSelf();
                    dw.this.L();
                }
            }
        }, this.f6536a, 0L);
        this.q = System.currentTimeMillis();
    }

    public void Code(int i) {
        this.h = i;
    }

    private void Code(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap2 != null) {
            this.b.setBitmap(bitmap2);
            this.b.drawColor(0, PorterDuff.Mode.CLEAR);
            this.d.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            this.e.set(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
            this.b.drawBitmap(bitmap, this.d, this.e, (Paint) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(String str) {
        S();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        InputStream inputStreamC = str.startsWith(com.huawei.openalliance.ad.constant.ce.ASSET.toString()) ? C(str) : str.startsWith(com.huawei.openalliance.ad.constant.ce.RES.toString()) ? B(str) : str.startsWith(com.huawei.openalliance.ad.constant.ce.CONTENT.toString()) ? I(str) : Z(str);
        if (inputStreamC != null) {
            try {
                this.o = new dv(inputStreamC, 100);
                L();
            } catch (Exception unused) {
                fh.I(e(), "exception in creating gif decoder");
                D();
            }
        }
    }

    public void Code(Drawable.Callback callback) {
        this.u.put(callback, null);
        setCallback(this);
    }

    public void Code(a aVar) {
        this.w = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(dx dxVar) {
        if (dxVar == null) {
            fh.V(e(), "invalid frame.");
            return;
        }
        fh.V(e(), "onFrameDecoded index: %d isstop: %s", Integer.valueOf(dxVar.Code), Boolean.valueOf(F()));
        if (F()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.q;
        if (fh.Code()) {
            fh.Code(e(), "onFrameDecoded decodeInterval: %d currentFrameDuration: %d", Long.valueOf(jCurrentTimeMillis), Integer.valueOf(this.m));
        }
        if (dxVar.Code == 1) {
            b();
        } else {
            int i = this.m;
            if (jCurrentTimeMillis < i) {
                try {
                    Thread.sleep(((long) i) - jCurrentTimeMillis);
                } catch (InterruptedException unused) {
                    fh.Code(e(), "sleep InterruptedException");
                }
            }
        }
        V(dxVar);
    }

    public void Code(dy dyVar) {
        this.v = dyVar;
    }

    private void Code(final String str) {
        this.t.Code(new Runnable() { // from class: com.huawei.hms.ads.dw.2
            @Override // java.lang.Runnable
            public void run() {
                dw.this.V(str);
            }
        });
    }

    private synchronized void Code(boolean z) {
        this.n = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Code(dx dxVar, long j) {
        int iCeil;
        long width = ((long) dxVar.V.getWidth()) * ((long) dxVar.V.getHeight()) * ((long) (dxVar.V.getConfig() == Bitmap.Config.RGB_565 ? 2 : 4));
        int i = dxVar.I;
        if (j > i) {
            iCeil = (int) Math.ceil((j * 1.0d) / ((double) i));
            if (iCeil > 5) {
                iCeil = 5;
            }
        } else {
            iCeil = 1;
        }
        long jMax = width * ((long) Math.max(iCeil, this.j.size()));
        long jV = com.huawei.openalliance.ad.utils.z.V();
        if (fh.Code()) {
            fh.Code(e(), "max frame mem: %d unused memory: %d", Long.valueOf(jMax), Long.valueOf(jV));
        }
        return jMax >= jV;
    }
}
