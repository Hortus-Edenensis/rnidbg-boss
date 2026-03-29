package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.widget.MediaController;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import defpackage.fe;
import defpackage.mu2;
import defpackage.v92;
import defpackage.x15;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class a extends Drawable implements Animatable, MediaController.MediaPlayerControl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f20042a;
    public volatile boolean b;
    public long c;
    public final Rect d;
    public final Paint e;
    public final Bitmap f;
    public final GifInfoHandle g;
    public final ConcurrentLinkedQueue<fe> h;
    public ColorStateList i;
    public PorterDuffColorFilter j;
    public PorterDuff.Mode k;
    public final boolean l;
    public final mu2 m;
    public final e n;
    public final Rect o;
    public ScheduledFuture<?> p;
    public int q;
    public int r;

    /* JADX INFO: renamed from: pl.droidsonroids.gif.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1264a extends x15 {
        public C1264a(a aVar) {
            super(aVar);
        }

        @Override // defpackage.x15
        public void a() {
            if (a.this.g.v()) {
                a.this.start();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends x15 {
        public final /* synthetic */ int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i) {
            super(aVar);
            this.b = i;
        }

        @Override // defpackage.x15
        public void a() {
            a aVar = a.this;
            aVar.g.z(this.b, aVar.f);
            this.f21857a.m.sendEmptyMessageAtTime(-1, 0L);
        }
    }

    public a(@NonNull Resources resources, @DrawableRes @RawRes int i) throws Resources.NotFoundException, IOException {
        this(resources.openRawResourceFd(i));
        float fB = pl.droidsonroids.gif.b.b(resources, i);
        this.r = (int) (this.g.g() * fB);
        this.q = (int) (this.g.n() * fB);
    }

    public final void a() {
        ScheduledFuture<?> scheduledFuture = this.p;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.m.removeMessages(-1);
    }

    public int b() {
        return this.g.c();
    }

    public int c() {
        int iD = this.g.d();
        return (iD == 0 || iD < this.g.h()) ? iD : iD - 1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return d() > 1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return d() > 1;
    }

    public int d() {
        return this.g.l();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        boolean z;
        if (this.j == null || this.e.getColorFilter() != null) {
            z = false;
        } else {
            this.e.setColorFilter(this.j);
            z = true;
        }
        canvas.drawBitmap(this.f, this.o, this.d, this.e);
        if (z) {
            this.e.setColorFilter(null);
        }
    }

    public boolean e() {
        return this.g.p();
    }

    public void f() {
        this.f20042a.execute(new C1264a(this));
    }

    public final void g() {
        if (this.l && this.b) {
            long j = this.c;
            if (j != Long.MIN_VALUE) {
                long jMax = Math.max(0L, j - SystemClock.uptimeMillis());
                this.c = Long.MIN_VALUE;
                this.f20042a.remove(this.n);
                this.p = this.f20042a.schedule(this.n, jMax, TimeUnit.MILLISECONDS);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.e.getAlpha();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return 100;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.e.getColorFilter();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        return this.g.e();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        return this.g.f();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.r;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.q;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return (!this.g.o() || this.e.getAlpha() < 255) ? -2 : -1;
    }

    public void h(@IntRange(from = 0, to = WebSocketProtocol.PAYLOAD_SHORT_MAX) int i) {
        this.g.A(i);
    }

    public final void i() {
        this.b = false;
        this.m.removeMessages(-1);
        this.g.t();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        g();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return this.b;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        return super.isStateful() || ((colorStateList = this.i) != null && colorStateList.isStateful());
    }

    public void j(long j) {
        if (this.l) {
            this.c = 0L;
            this.m.sendEmptyMessageAtTime(-1, 0L);
        } else {
            a();
            this.p = this.f20042a.schedule(this.n, Math.max(j, 0L), TimeUnit.MILLISECONDS);
        }
    }

    public final PorterDuffColorFilter k(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.d.set(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.i;
        if (colorStateList == null || (mode = this.k) == null) {
            return false;
        }
        this.j = k(colorStateList, mode);
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        stop();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(@IntRange(from = 0, to = 2147483647L) int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Position is not positive");
        }
        this.f20042a.execute(new b(this, i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        this.e.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.e.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.e.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.e.setFilterBitmap(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.i = colorStateList;
        this.j = k(colorStateList, this.k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        this.k = mode;
        this.j = k(this.i, mode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (!this.l) {
            if (z) {
                if (z2) {
                    f();
                }
                if (visible) {
                    start();
                }
            } else if (visible) {
                stop();
            }
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable, android.widget.MediaController.MediaPlayerControl
    public void start() {
        synchronized (this) {
            if (this.b) {
                return;
            }
            this.b = true;
            j(this.g.w());
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        synchronized (this) {
            if (this.b) {
                this.b = false;
                a();
                this.g.y();
            }
        }
    }

    @NonNull
    public String toString() {
        return String.format(Locale.ENGLISH, "GIF: size: %dx%d, frames: %d, error: %d", Integer.valueOf(this.g.n()), Integer.valueOf(this.g.g()), Integer.valueOf(this.g.l()), Integer.valueOf(this.g.j()));
    }

    public a(@NonNull AssetManager assetManager, @NonNull String str) throws IOException {
        this(assetManager.openFd(str));
    }

    public a(@NonNull String str) throws IOException {
        this(new GifInfoHandle(str), null, null, true);
    }

    public a(@NonNull AssetFileDescriptor assetFileDescriptor) throws IOException {
        this(new GifInfoHandle(assetFileDescriptor), null, null, true);
    }

    public a(@Nullable ContentResolver contentResolver, @NonNull Uri uri) throws IOException {
        this(GifInfoHandle.r(contentResolver, uri), null, null, true);
    }

    public a(GifInfoHandle gifInfoHandle, a aVar, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z) {
        this.b = true;
        this.c = Long.MIN_VALUE;
        this.d = new Rect();
        this.e = new Paint(6);
        this.h = new ConcurrentLinkedQueue<>();
        e eVar = new e(this);
        this.n = eVar;
        this.l = z;
        this.f20042a = scheduledThreadPoolExecutor == null ? v92.a() : scheduledThreadPoolExecutor;
        this.g = gifInfoHandle;
        Bitmap bitmap = null;
        if (aVar != null) {
            synchronized (aVar.g) {
                if (!aVar.g.p() && aVar.g.g() >= gifInfoHandle.g() && aVar.g.n() >= gifInfoHandle.n()) {
                    aVar.i();
                    Bitmap bitmap2 = aVar.f;
                    bitmap2.eraseColor(0);
                    bitmap = bitmap2;
                }
            }
        }
        if (bitmap == null) {
            this.f = Bitmap.createBitmap(gifInfoHandle.n(), gifInfoHandle.g(), Bitmap.Config.ARGB_8888);
        } else {
            this.f = bitmap;
        }
        this.f.setHasAlpha(!gifInfoHandle.o());
        this.o = new Rect(0, 0, gifInfoHandle.n(), gifInfoHandle.g());
        this.m = new mu2(this);
        eVar.a();
        this.q = gifInfoHandle.n();
        this.r = gifInfoHandle.g();
    }
}
