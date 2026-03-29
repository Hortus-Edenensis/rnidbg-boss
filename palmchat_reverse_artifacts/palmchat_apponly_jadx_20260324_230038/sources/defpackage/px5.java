package defpackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.collection.LruCache;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.FileDescriptor;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class px5 extends Drawable {
    public static a s;
    public static final Object t = new Object();
    public static final AtomicInteger u = new AtomicInteger(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20129a;
    public final WeakReference<ImageView> b;
    public final BitmapRegionDecoder c;
    public final BlockingQueue<e> d;
    public final HashMap<String, Integer> e;
    public final int f;
    public final b g;
    public final int h;
    public final int i;
    public final int j;
    public final Bitmap k;
    public final Paint l;
    public Matrix m;
    public final float[] n;
    public float[] o;
    public final Rect p;
    public final Rect q;
    public final Rect r;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends LruCache<String, Bitmap> {
        @TargetApi(19)
        public static int a(Bitmap bitmap) {
            return bitmap.getAllocationByteCount();
        }

        @Override // androidx.collection.LruCache
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, Bitmap bitmap) {
            return a(bitmap);
        }

        public a(int i) {
            super(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends g13 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<px5> f20130a;
        public final BitmapRegionDecoder b;
        public final BlockingQueue<e> c;
        public boolean d;

        public void quit() {
            this.d = true;
            interrupt();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Bitmap bitmapDecodeRegion;
            px5 px5Var;
            while (this.f20130a.get() != null) {
                try {
                    e eVarTake = this.c.take();
                    synchronized (px5.t) {
                        if (px5.s.get(eVarTake.c()) == null) {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                            options.inPreferQualityOverSpeed = false;
                            options.inSampleSize = 1 << eVarTake.e;
                            synchronized (this.b) {
                                bitmapDecodeRegion = null;
                                try {
                                    bitmapDecodeRegion = this.b.decodeRegion(eVarTake.b, options);
                                    if (bitmapDecodeRegion == null && (px5Var = this.f20130a.get()) != null) {
                                        LogUtil.e("TileBitmapDrawable", "decode start rect=" + eVarTake.b + "level = " + eVarTake.e + " count = " + px5Var.i(eVarTake) + "queue size =" + this.c.size() + "bitmap=" + bitmapDecodeRegion);
                                        px5Var.k(eVarTake);
                                    }
                                } catch (OutOfMemoryError unused) {
                                }
                            }
                            if (bitmapDecodeRegion == null) {
                                continue;
                            } else {
                                synchronized (px5.t) {
                                    px5.s.put(eVarTake.c(), bitmapDecodeRegion);
                                }
                            }
                        }
                    }
                } catch (InterruptedException unused2) {
                    if (this.d) {
                        return;
                    }
                }
            }
        }

        public b(px5 px5Var, BitmapRegionDecoder bitmapRegionDecoder, BlockingQueue<e> blockingQueue) {
            this.f20130a = new WeakReference<>(px5Var);
            this.b = bitmapRegionDecoder;
            this.c = blockingQueue;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c extends AsyncTask<Object, Void, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f20131a;
        public final d b;
        public Bitmap c;

        @Override // android.os.AsyncTask
        public Object doInBackground(Object... objArr) {
            try {
                Object obj = objArr[0];
                BitmapRegionDecoder bitmapRegionDecoderNewInstance = obj instanceof String ? BitmapRegionDecoder.newInstance((String) obj, false) : obj instanceof FileDescriptor ? BitmapRegionDecoder.newInstance((FileDescriptor) obj, false) : BitmapRegionDecoder.newInstance((InputStream) obj, false);
                Bitmap bitmapDecodeRegion = this.c;
                if (bitmapDecodeRegion == null) {
                    ((WindowManager) this.f20131a.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
                    float fMin = Math.min(r1.widthPixels / bitmapRegionDecoderNewInstance.getWidth(), r1.heightPixels / bitmapRegionDecoderNewInstance.getHeight());
                    int iMax = Math.max(1, zd3.a(bitmapRegionDecoderNewInstance.getWidth() / (bitmapRegionDecoderNewInstance.getWidth() * fMin)));
                    Rect rect = new Rect(0, 0, bitmapRegionDecoderNewInstance.getWidth(), bitmapRegionDecoderNewInstance.getHeight());
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    options.inPreferQualityOverSpeed = false;
                    options.inSampleSize = 1 << (iMax - 1);
                    try {
                        Bitmap bitmapDecodeRegion2 = bitmapRegionDecoderNewInstance.decodeRegion(rect, options);
                        bitmapDecodeRegion = Bitmap.createScaledBitmap(bitmapDecodeRegion2, Math.round(bitmapRegionDecoderNewInstance.getWidth() * fMin), Math.round(bitmapRegionDecoderNewInstance.getHeight() * fMin), true);
                        if (!bitmapDecodeRegion2.equals(bitmapDecodeRegion)) {
                            bitmapDecodeRegion2.recycle();
                        }
                    } catch (OutOfMemoryError unused) {
                        options.inSampleSize <<= 1;
                        bitmapDecodeRegion = bitmapRegionDecoderNewInstance.decodeRegion(rect, options);
                    }
                }
                try {
                    return new px5(this.f20131a, bitmapRegionDecoderNewInstance, bitmapDecodeRegion);
                } catch (Exception e) {
                    return e;
                }
            } catch (Exception e2) {
                return e2;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Object obj) {
            d dVar;
            if (obj instanceof px5) {
                this.f20131a.setImageDrawable((px5) obj);
                d dVar2 = this.b;
                if (dVar2 != null) {
                    dVar2.b();
                    return;
                }
                return;
            }
            if ((obj instanceof Exception) && (dVar = this.b) != null) {
                dVar.onError((Exception) obj);
                return;
            }
            d dVar3 = this.b;
            if (dVar3 != null) {
                dVar3.onError(new Exception("Did not receive an exception or TileBitmapDrawable from doInBackground"));
            }
        }

        public c(Bitmap bitmap, ImageView imageView, Drawable drawable, d dVar) {
            this.c = bitmap;
            this.f20131a = imageView;
            this.b = dVar;
            if (dVar != null) {
                dVar.a();
            }
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a();

        void b();

        void onError(Exception exc);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20132a;
        public final Rect b;
        public final int c;
        public final int d;
        public final int e;

        public String c() {
            return "#" + this.f20132a + "#" + this.c + "#" + this.d + "#" + this.e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof e) {
                return c().equals(((e) obj).c());
            }
            return false;
        }

        public int hashCode() {
            return c().hashCode();
        }

        public e(int i, Rect rect, int i2, int i3, int i4) {
            this.f20132a = i;
            Rect rect2 = new Rect();
            this.b = rect2;
            rect2.set(rect);
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    public static void e(Bitmap bitmap, ImageView imageView, String str, Drawable drawable, d dVar) {
        new c(bitmap, imageView, drawable, dVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, str);
    }

    public static void g() {
        a aVar = s;
        if (aVar != null) {
            aVar.evictAll();
        }
    }

    @TargetApi(17)
    public static void h(Context context, DisplayMetrics displayMetrics) {
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i;
        int i2;
        Bitmap bitmap;
        ImageView imageView = this.b.get();
        if (imageView == null) {
            return;
        }
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        Matrix imageMatrix = imageView.getImageMatrix();
        this.m = imageMatrix;
        imageMatrix.getValues(this.n);
        float[] fArr = this.n;
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = fArr[0];
        float[] fArr2 = this.o;
        if (f != fArr2[2] || f2 != fArr2[5] || f3 != fArr2[0]) {
            this.d.clear();
        }
        float[] fArr3 = this.n;
        this.o = Arrays.copyOf(fArr3, fArr3.length);
        float f4 = width;
        float f5 = height;
        float fMin = Math.min(f4 / this.h, f5 / this.i);
        int i3 = this.h;
        int iB = zd3.b(zd3.c(1.0f / f3), 0, Math.max(1, zd3.a(i3 / (i3 * fMin))) - 1);
        int i4 = (1 << iB) * this.j;
        float f6 = i4;
        int iCeil = (int) Math.ceil(this.h / f6);
        int iCeil2 = (int) Math.ceil(this.i / f6);
        float f7 = -f;
        float f8 = -f2;
        this.q.set(Math.max(0, (int) (f7 / f3)), Math.max(0, (int) (f8 / f3)), Math.min(this.h, Math.round((f7 + f4) / f3)), Math.min(this.i, Math.round((f8 + f5) / f3)));
        boolean z = false;
        for (int i5 = 0; i5 < iCeil; i5++) {
            int i6 = 0;
            while (i6 < iCeil2) {
                int i7 = i5 * i4;
                int i8 = i6 * i4;
                int i9 = (i5 + 1) * i4;
                int i10 = this.h;
                int i11 = i9 <= i10 ? i9 : i10;
                int i12 = i6 + 1;
                int i13 = i12 * i4;
                int i14 = this.i;
                if (i13 <= i14) {
                    i14 = i13;
                }
                this.p.set(i7, i8, i11, i14);
                if (Rect.intersects(this.q, this.p)) {
                    int i15 = i14;
                    int i16 = i11;
                    i = iCeil2;
                    i2 = iCeil;
                    e eVar = new e(this.f20129a, this.p, i5, i6, iB);
                    synchronized (t) {
                        bitmap = s.get(eVar.c());
                    }
                    if (bitmap != null) {
                        canvas.drawBitmap(bitmap, (Rect) null, this.p, this.l);
                    } else {
                        synchronized (this.d) {
                            if (j(eVar)) {
                                if (!this.d.contains(eVar)) {
                                    this.d.add(eVar);
                                }
                                z = true;
                            }
                        }
                        this.r.set(Math.round((i7 * this.k.getWidth()) / this.h), Math.round((i8 * this.k.getHeight()) / this.i), Math.round((i16 * this.k.getWidth()) / this.h), Math.round((i15 * this.k.getHeight()) / this.i));
                        canvas.drawBitmap(this.k, this.r, this.p, this.l);
                    }
                } else {
                    i = iCeil2;
                    i2 = iCeil;
                }
                iCeil2 = i;
                i6 = i12;
                iCeil = i2;
            }
        }
        if (z) {
            invalidateSelf();
        }
    }

    public final int f(DisplayMetrics displayMetrics) {
        int i = displayMetrics.densityDpi;
        if (i < 240) {
            return 128;
        }
        if (i >= 320 && i >= 480) {
            return i < 640 ? 384 : 512;
        }
        return 256;
    }

    public void finalize() throws Throwable {
        this.g.quit();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.l.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap = this.k;
        return (bitmap == null || bitmap.hasAlpha() || this.l.getAlpha() < 255) ? -3 : -1;
    }

    public final int i(e eVar) {
        Integer num = this.e.get(eVar.c());
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final boolean j(e eVar) {
        boolean z;
        Integer value;
        Iterator<Map.Entry<String, Integer>> it = this.e.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            Map.Entry<String, Integer> next = it.next();
            if (eVar.c().equals(next.getKey()) && (value = next.getValue()) != null && value.intValue() > 2) {
                z = false;
                break;
            }
        }
        if (!z) {
            LogUtil.e("TileBitmapDrawable", "needLoadTile = false " + eVar.c());
        }
        return z;
    }

    public final void k(e eVar) {
        int i = i(eVar);
        LogUtil.e("TileBitmapDrawable", "updateLoadFailCount tile=" + eVar.c() + " failcount = " + i);
        this.e.put(eVar.c(), Integer.valueOf(i + 1));
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.l.getAlpha()) {
            this.l.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.l.setColorFilter(colorFilter);
        invalidateSelf();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public px5(ImageView imageView, BitmapRegionDecoder bitmapRegionDecoder, Bitmap bitmap) {
        Object[] objArr;
        this.f20129a = u.getAndIncrement();
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.d = linkedBlockingQueue;
        this.e = new HashMap<>();
        this.f = 2;
        this.l = new Paint(2);
        this.n = new float[9];
        this.o = new float[9];
        this.p = new Rect();
        this.q = new Rect();
        this.r = new Rect();
        this.b = new WeakReference<>(imageView);
        synchronized (bitmapRegionDecoder) {
            this.c = bitmapRegionDecoder;
            this.h = bitmapRegionDecoder.getWidth();
            this.i = bitmapRegionDecoder.getHeight();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        h(imageView.getContext(), displayMetrics);
        int iF = f(displayMetrics);
        this.j = iF;
        this.k = bitmap;
        synchronized (t) {
            objArr = 0;
            if (s == null) {
                s = new a(((int) Math.ceil((displayMetrics.widthPixels * 2) / iF)) * 4 * ((int) Math.ceil((displayMetrics.heightPixels * 2) / iF)) * iF * iF);
            }
        }
        b bVar = new b(bitmapRegionDecoder, linkedBlockingQueue);
        this.g = bVar;
        bVar.start();
    }
}
