package com.bytedance.adsdk.u.u;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.adsdk.u.u.u.a;
import com.bytedance.sdk.component.utils.k;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class fx<Decoder extends a<?, ?>> extends Drawable implements nr, a.u {
    private static final String u = "fx";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Runnable f5019a;
    private final DrawFilter b;
    private final Decoder fx;
    private final Set<Object> iz;
    private boolean jk;
    private boolean l;
    private final Handler n;
    private final Paint nr;
    private final Matrix pn;
    private final Set<WeakReference<Drawable.Callback>> t;
    private Bitmap x;

    public fx(com.bytedance.adsdk.u.u.fx.nr nrVar) {
        Paint paint = new Paint();
        this.nr = paint;
        this.b = new PaintFlagsDrawFilter(0, 3);
        this.pn = new Matrix();
        this.iz = new HashSet();
        this.n = new Handler(Looper.getMainLooper()) { // from class: com.bytedance.adsdk.u.u.fx.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    Iterator it = new ArrayList(fx.this.iz).iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                } else {
                    if (i != 2) {
                        return;
                    }
                    Iterator it2 = new ArrayList(fx.this.iz).iterator();
                    while (it2.hasNext()) {
                        it2.next();
                    }
                }
            }
        };
        this.f5019a = new Runnable() { // from class: com.bytedance.adsdk.u.u.fx.2
            @Override // java.lang.Runnable
            public void run() {
                fx.this.invalidateSelf();
            }
        };
        this.jk = true;
        this.t = new HashSet();
        this.l = false;
        paint.setAntiAlias(true);
        this.fx = (Decoder) nr(nrVar, this);
    }

    private void b() {
        this.fx.nr(this);
        if (this.jk) {
            this.fx.a();
        } else {
            this.fx.pn();
        }
    }

    private void fx() {
        this.fx.u(this);
        if (this.jk) {
            this.fx.n();
        } else {
            if (this.fx.jk()) {
                return;
            }
            this.fx.n();
        }
    }

    private void pn() {
        ArrayList arrayList = new ArrayList();
        Drawable.Callback callback = getCallback();
        boolean z = false;
        for (WeakReference weakReference : new HashSet(this.t)) {
            Drawable.Callback callback2 = (Drawable.Callback) weakReference.get();
            if (callback2 == null) {
                arrayList.add(weakReference);
            } else if (callback2 == callback) {
                z = true;
            } else {
                callback2.invalidateDrawable(this);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.t.remove((WeakReference) it.next());
        }
        if (z) {
            return;
        }
        this.t.add(new WeakReference<>(callback));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.x;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.setDrawFilter(this.b);
        canvas.drawBitmap(this.x, this.pn, this.nr);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.Callback getCallback() {
        return super.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.l) {
            return -1;
        }
        try {
            return this.fx.iz().height();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.l) {
            return -1;
        }
        try {
            return this.fx.iz().width();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        Iterator it = new HashSet(this.t).iterator();
        while (it.hasNext()) {
            Drawable.Callback callback = (Drawable.Callback) ((WeakReference) it.next()).get();
            if (callback != null && callback != getCallback()) {
                callback.invalidateDrawable(this);
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.fx.jk();
    }

    public abstract Decoder nr(com.bytedance.adsdk.u.u.fx.nr nrVar, a.u uVar);

    @Override // com.bytedance.adsdk.u.u.u.a.u
    public void nr(ByteBuffer byteBuffer) {
        if (isRunning()) {
            Bitmap bitmap = this.x;
            if (bitmap == null || bitmap.isRecycled()) {
                this.x = Bitmap.createBitmap(this.fx.iz().width() / this.fx.l(), this.fx.iz().height() / this.fx.l(), Bitmap.Config.ARGB_4444);
            }
            byteBuffer.rewind();
            if (byteBuffer.remaining() < this.x.getByteCount()) {
                k.nr(u, "onRender:Buffer not large enough for pixels");
            } else {
                this.x.copyPixelsFromBuffer(byteBuffer);
                this.n.post(this.f5019a);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.nr.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        boolean zNr = this.fx.nr(getBounds().width(), getBounds().height());
        this.pn.setScale(((getBounds().width() * 1.0f) * this.fx.l()) / this.fx.iz().width(), ((getBounds().height() * 1.0f) * this.fx.l()) / this.fx.iz().height());
        if (zNr) {
            this.x = Bitmap.createBitmap(this.fx.iz().width() / this.fx.l(), this.fx.iz().height() / this.fx.l(), Bitmap.Config.ARGB_4444);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.nr.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        pn();
        if (this.jk) {
            if (z) {
                if (!isRunning()) {
                    fx();
                }
            } else if (isRunning()) {
                b();
            }
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.fx.jk()) {
            this.fx.a();
        }
        this.fx.t();
        fx();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        b();
    }

    @Override // com.bytedance.adsdk.u.u.u.a.u
    public void u() {
        Message.obtain(this.n, 1).sendToTarget();
    }

    @Override // com.bytedance.adsdk.u.u.u.a.u
    public void nr() {
        Message.obtain(this.n, 2).sendToTarget();
    }
}
