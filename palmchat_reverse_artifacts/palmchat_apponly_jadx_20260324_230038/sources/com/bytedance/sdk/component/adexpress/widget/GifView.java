package com.bytedance.sdk.component.adexpress.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.Movie;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.b.pn;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.component.utils.q;
import defpackage.td;
import defpackage.ud;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@SuppressLint({"AppCompatCustomView"})
public class GifView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f5108a;
    private int b;
    private long fx;
    private boolean iz;
    private float jk;
    private boolean k;
    private int l;
    private volatile boolean mv;
    private float n;
    private Movie nr;
    private AnimatedImageDrawable pn;
    private boolean s;
    private int t;
    private int u;
    private boolean x;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(Drawable drawable);
    }

    public GifView(Context context) {
        super(context);
        this.iz = Build.VERSION.SDK_INT >= 28;
        this.x = false;
        this.s = true;
        this.k = true;
        u();
    }

    private void b() {
        if (this.nr == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.fx == 0) {
            this.fx = jUptimeMillis;
        }
        int iDuration = this.nr.duration();
        if (iDuration == 0) {
            iDuration = 1000;
        }
        if (this.k || Math.abs(iDuration - this.b) >= 60) {
            this.b = (int) ((jUptimeMillis - this.fx) % ((long) iDuration));
        } else {
            this.b = iDuration;
            this.mv = true;
        }
    }

    private void fx() {
        if (this.nr == null || this.iz || !this.s) {
            return;
        }
        postInvalidateOnAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageDecoder.Source nr(byte[] bArr) {
        FileOutputStream fileOutputStream;
        try {
            File fileU = u(getContext(), com.bytedance.sdk.component.adexpress.u.u.u.u().fx().l() ? "GIF_AD_CACHE/" : "/GIF_CACHE/", "TT_GIF_FILE");
            fileOutputStream = new FileOutputStream(fileU);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                if (Build.VERSION.SDK_INT >= 28) {
                    ImageDecoder.Source sourceCreateSource = ImageDecoder.createSource(fileU);
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused) {
                    }
                    return sourceCreateSource;
                }
            } catch (Throwable th) {
                th = th;
                try {
                    k.u("GifView", "GifView  getSourceByFile fail : ", th);
                    if (fileOutputStream != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
        try {
            fileOutputStream.close();
        } catch (Throwable unused3) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        setImageDrawable(drawable);
        if (Build.VERSION.SDK_INT >= 28 && td.a(drawable)) {
            AnimatedImageDrawable animatedImageDrawableA = ud.a(drawable);
            this.pn = animatedImageDrawableA;
            if (!this.mv) {
                animatedImageDrawableA.start();
            }
            if (!this.k) {
                animatedImageDrawableA.setRepeatCount(0);
            }
        }
        fx();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.nr == null || this.iz) {
            super.onDraw(canvas);
            return;
        }
        try {
            if (this.mv) {
                u(canvas);
                return;
            }
            b();
            u(canvas);
            fx();
        } catch (Throwable th) {
            k.u("GifView", "onDraw->Throwable->", th);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.nr != null && !this.iz) {
            this.n = (getWidth() - this.t) / 2.0f;
            this.f5108a = (getHeight() - this.l) / 2.0f;
        }
        this.s = getVisibility() == 0;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        Movie movie;
        int size;
        int size2;
        super.onMeasure(i, i2);
        if (this.iz || (movie = this.nr) == null) {
            return;
        }
        int iWidth = movie.width();
        int iHeight = this.nr.height();
        float fMax = 1.0f / Math.max((View.MeasureSpec.getMode(i) == 0 || iWidth <= (size2 = View.MeasureSpec.getSize(i))) ? 1.0f : iWidth / size2, (View.MeasureSpec.getMode(i2) == 0 || iHeight <= (size = View.MeasureSpec.getSize(i2))) ? 1.0f : iHeight / size);
        this.jk = fMax;
        int i3 = (int) (iWidth * fMax);
        this.t = i3;
        int i4 = (int) (iHeight * fMax);
        this.l = i4;
        setMeasuredDimension(i3, i4);
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        if (this.nr != null) {
            this.s = i == 1;
            fx();
        }
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.nr != null) {
            this.s = i == 0;
            fx();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.nr != null) {
            this.s = i == 0;
            fx();
        }
    }

    public void setRepeatConfig(boolean z) {
        AnimatedImageDrawable animatedImageDrawable;
        this.k = z;
        if (z) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT < 28 || (animatedImageDrawable = this.pn) == null) {
                return;
            }
            animatedImageDrawable.setRepeatCount(0);
        } catch (Exception e) {
            k.u("GifView", "setRepeatConfig error", e);
        }
    }

    public void u() {
        if (this.iz) {
            return;
        }
        setLayerType(1, null);
    }

    public void u(int i, boolean z) {
        this.mv = z;
        this.u = i;
        if (i == -1) {
            return;
        }
        if (!this.iz) {
            this.nr = u(i);
        } else {
            u(i, new u() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.1
                @Override // com.bytedance.sdk.component.adexpress.widget.GifView.u
                public void u(final Drawable drawable) {
                    GifView.this.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GifView.this.setDrawable(drawable);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageDecoder.Source nr(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            return ImageDecoder.createSource(q.u(getContext()), i);
        }
        return null;
    }

    public void u(byte[] bArr, boolean z) {
        this.mv = z;
        if (bArr == null) {
            return;
        }
        if (!this.iz) {
            this.nr = u(bArr);
        } else {
            u(bArr, new u() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.2
                @Override // com.bytedance.sdk.component.adexpress.widget.GifView.u
                public void u(final Drawable drawable) {
                    GifView.this.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GifView.this.setDrawable(drawable);
                        }
                    });
                }
            });
        }
    }

    public void nr() {
        if (this.nr == null || !this.mv) {
            return;
        }
        this.mv = false;
        if (!this.iz) {
            this.fx = SystemClock.uptimeMillis() - ((long) this.b);
            invalidate();
            return;
        }
        AnimatedImageDrawable animatedImageDrawable = this.pn;
        if (animatedImageDrawable == null || animatedImageDrawable.isRunning()) {
            return;
        }
        this.pn.start();
    }

    private Movie u(int i) {
        try {
            return Movie.decodeStream(q.u(getContext()).openRawResource(i));
        } catch (Throwable unused) {
            return null;
        }
    }

    private Movie u(byte[] bArr) {
        try {
            return Movie.decodeByteArray(bArr, 0, bArr.length);
        } catch (Throwable unused) {
            return null;
        }
    }

    private void u(final int i, final u uVar) {
        if (i == -1) {
            return;
        }
        pn.u(new a("createGifApi28WithByteArrayBySafely") { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.3
            @Override // java.lang.Runnable
            public void run() {
                u uVar2 = uVar;
                if (uVar2 != null) {
                    GifView gifView = GifView.this;
                    uVar2.u(gifView.u(gifView.nr(i)));
                }
            }
        }, 5);
    }

    private void u(final byte[] bArr, final u uVar) {
        if (bArr == null) {
            return;
        }
        pn.u(new a("createGifApi28WithByteArrayBySafely") { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.4
            @Override // java.lang.Runnable
            public void run() {
                u uVar2 = uVar;
                if (uVar2 != null) {
                    GifView gifView = GifView.this;
                    uVar2.u(gifView.u(gifView.nr(bArr)));
                }
            }
        }, 5);
    }

    public static File u(Context context, String str, String str2) {
        int iT = com.bytedance.sdk.component.adexpress.u.u.u.u().fx().t();
        boolean zL = com.bytedance.sdk.component.adexpress.u.u.u.u().fx().l();
        if (iT == 1) {
            k.nr("splashLoadAd", "视频存储使用内部存储");
            return n.nr(context, zL, str, str2);
        }
        k.nr("splashLoadAd", "视频存储使用外存储");
        return n.u(context, zL, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable u(ImageDecoder.Source source) {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                return null;
            }
            return ImageDecoder.decodeDrawable(source);
        } catch (Throwable unused) {
            return null;
        }
    }

    private void u(Canvas canvas) {
        Movie movie = this.nr;
        if (movie == null) {
            return;
        }
        movie.setTime(this.b);
        float f = this.jk;
        if (f == 0.0f) {
            canvas.scale(1.0f, 1.0f);
            this.nr.draw(canvas, 0.0f, 0.0f);
        } else {
            canvas.scale(f, f);
            Movie movie2 = this.nr;
            float f2 = this.n;
            float f3 = this.jk;
            movie2.draw(canvas, f2 / f3, this.f5108a / f3);
        }
        canvas.restore();
    }
}
