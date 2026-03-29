package com.bytedance.sdk.component.iz.fx;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.component.iz.b.a;
import com.bytedance.sdk.component.iz.bq;
import com.bytedance.sdk.component.iz.h;
import com.bytedance.sdk.component.iz.jk;
import com.bytedance.sdk.component.iz.l;
import com.bytedance.sdk.component.iz.my;
import com.bytedance.sdk.component.iz.qq;
import com.bytedance.sdk.component.iz.s;
import com.bytedance.sdk.component.utils.k;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5141a;
    private String b;
    private final Handler bg;
    private boolean bq;
    private int c;
    private boolean d;
    private com.bytedance.sdk.component.iz.n dw;
    private String fx;
    private int gi;
    private ExecutorService h;
    private ImageView.ScaleType iz;
    private bq ja;
    private jk jk;
    private boolean k;
    private com.bytedance.sdk.component.iz.nr kj;
    private WeakReference<ImageView> l;
    private volatile boolean mv;
    private h my;
    private int n;
    private String nr;
    private int o;
    private qq pn;
    private iz q;
    private com.bytedance.sdk.component.iz.fx.u qq;
    private boolean rh;
    private boolean s;
    private Queue<a> sx;
    private int t;
    Future<?> u;
    private Bitmap.Config x;
    private int z;

    /* JADX INFO: compiled from: SearchBox */
    public class u implements qq {
        private qq nr;

        public u(qq qqVar) {
            this.nr = qqVar;
        }

        @Override // com.bytedance.sdk.component.iz.qq
        public void onFailed(final int i, final String str, final Throwable th) {
            if (fx.this.o == 5) {
                fx.this.bg.post(new Runnable() { // from class: com.bytedance.sdk.component.iz.fx.fx.u.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (u.this.nr != null) {
                            u.this.nr.onFailed(i, str, th);
                        }
                    }
                });
                return;
            }
            qq qqVar = this.nr;
            if (qqVar != null) {
                qqVar.onFailed(i, str, th);
            }
        }

        @Override // com.bytedance.sdk.component.iz.qq
        public void onSuccess(final my myVar) {
            Bitmap bitmapCoverterTo;
            final ImageView imageView = (ImageView) fx.this.l.get();
            if (imageView != null && fx.this.t != 3 && u(imageView) && (myVar.getResult() instanceof Bitmap)) {
                final Bitmap bitmap = (Bitmap) myVar.getResult();
                fx.this.bg.post(new Runnable() { // from class: com.bytedance.sdk.component.iz.fx.fx.u.1
                    @Override // java.lang.Runnable
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
            try {
                if (fx.this.jk != null && (myVar.getResult() instanceof Bitmap) && (bitmapCoverterTo = fx.this.jk.coverterTo((Bitmap) myVar.getResult())) != null) {
                    myVar.setResult(bitmapCoverterTo);
                }
            } catch (Throwable unused) {
            }
            if (fx.this.o == 5) {
                fx.this.bg.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.component.iz.fx.fx.u.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (u.this.nr != null) {
                            u.this.nr.onSuccess(myVar);
                        }
                    }
                });
                return;
            }
            qq qqVar = this.nr;
            if (qqVar != null) {
                qqVar.onSuccess(myVar);
            }
        }

        private boolean u(ImageView imageView) {
            Object tag;
            return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(fx.this.fx)) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l o() {
        iz izVar;
        try {
            izVar = this.q;
        } catch (Exception e) {
            k.nr("ImageRequest", e.getMessage());
        }
        if (izVar == null) {
            qq qqVar = this.pn;
            if (qqVar != null) {
                qqVar.onFailed(1005, "not init !", null);
            }
            return this;
        }
        ExecutorService executorServiceIz = this.h == null ? izVar.iz() : null;
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.iz.fx.fx.1
            @Override // java.lang.Runnable
            public void run() {
                a aVar;
                while (!fx.this.mv && (aVar = (a) fx.this.sx.poll()) != null) {
                    try {
                        if (fx.this.my != null) {
                            fx.this.my.onStepStart(aVar.u(), fx.this);
                        }
                        aVar.u(fx.this);
                        if (fx.this.my != null) {
                            fx.this.my.onStepEnd(aVar.u(), fx.this);
                        }
                    } catch (Throwable th) {
                        fx.this.u(2000, th.getMessage(), th);
                        if (fx.this.my != null) {
                            fx.this.my.onStepEnd("exception", fx.this);
                            return;
                        }
                        return;
                    }
                }
                if (fx.this.mv) {
                    fx.this.u(1003, "canceled", null);
                }
            }
        };
        if (this.rh) {
            runnable.run();
        } else {
            ExecutorService executorService = this.h;
            if (executorService != null) {
                this.u = executorService.submit(runnable);
            } else if (executorServiceIz != null) {
                this.u = executorServiceIz.submit(runnable);
            }
        }
        return this;
    }

    @Override // com.bytedance.sdk.component.iz.l
    public boolean cancelRequest() {
        this.mv = true;
        Future<?> future = this.u;
        if (future != null) {
            return future.cancel(true);
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.iz.l
    public Bitmap.Config getBitmapConfig() {
        return this.x;
    }

    @Override // com.bytedance.sdk.component.iz.l
    public int getHeight() {
        return this.f5141a;
    }

    @Override // com.bytedance.sdk.component.iz.l
    public String getMemoryCacheKey() {
        return this.fx;
    }

    @Override // com.bytedance.sdk.component.iz.l
    public String getRawCacheKey() {
        return this.b;
    }

    @Override // com.bytedance.sdk.component.iz.l
    public ImageView.ScaleType getScaleType() {
        return this.iz;
    }

    @Override // com.bytedance.sdk.component.iz.l
    public String getUrl() {
        return this.nr;
    }

    @Override // com.bytedance.sdk.component.iz.l
    public int getWidth() {
        return this.n;
    }

    public bq k() {
        return this.ja;
    }

    public iz l() {
        return this.q;
    }

    public com.bytedance.sdk.component.iz.nr mv() {
        return this.kj;
    }

    public String my() {
        return getRawCacheKey();
    }

    public boolean s() {
        return this.d;
    }

    public com.bytedance.sdk.component.iz.fx.u t() {
        return this.qq;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr implements s {
        private String b;
        private int bg;
        private boolean bq;
        private boolean c;
        private ExecutorService dw;
        private String fx;
        private Bitmap.Config iz;
        private com.bytedance.sdk.component.iz.nr k;
        private boolean l;
        private boolean mv;
        private iz my;
        private int n;
        private ImageView nr;
        private jk o;
        private ImageView.ScaleType pn;
        private bq q;
        private String s;
        private int sx;
        private h t;
        private qq u;
        private int x;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f5142a = 1;
        private int jk = 5;

        public nr(iz izVar) {
            this.my = izVar;
        }

        @Override // com.bytedance.sdk.component.iz.s
        public s cache(com.bytedance.sdk.component.iz.nr nrVar) {
            this.k = nrVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.iz.s
        public s cacheDir(String str) {
            this.s = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.iz.s
        public s config(Bitmap.Config config) {
            this.iz = config;
            return this;
        }

        @Override // com.bytedance.sdk.component.iz.s
        public s converter(jk jkVar) {
            this.o = jkVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.iz.s
        public s from(String str) {
            this.b = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.iz.s
        public s headers(boolean z) {
            this.l = z;
            return this;
        }

        @Override // com.bytedance.sdk.component.iz.s
        public s height(int i) {
            this.n = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.iz.s
        public s key(String str) {
            this.fx = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.iz.s
        public s loadSetp(bq bqVar) {
            this.q = bqVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.iz.s
        public s maxHeight(int i) {
            this.bg = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.iz.s
        public s maxWidth(int i) {
            this.sx = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.iz.s
        public s requestTime(boolean z) {
            this.mv = z;
            return this;
        }

        @Override // com.bytedance.sdk.component.iz.s
        public s runIn(ExecutorService executorService) {
            this.dw = executorService;
            return this;
        }

        @Override // com.bytedance.sdk.component.iz.s
        public s scaleType(ImageView.ScaleType scaleType) {
            this.pn = scaleType;
            return this;
        }

        @Override // com.bytedance.sdk.component.iz.s
        public s sync(boolean z) {
            this.c = z;
            return this;
        }

        @Override // com.bytedance.sdk.component.iz.s
        public l to(qq qqVar, int i) {
            this.jk = i;
            return to(qqVar);
        }

        @Override // com.bytedance.sdk.component.iz.s
        public s track(h hVar) {
            this.t = hVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.iz.s
        public s type(int i) {
            this.f5142a = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.iz.s
        public s width(int i) {
            this.x = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.iz.s
        public l to(qq qqVar) {
            this.u = qqVar;
            return new fx(this).o();
        }

        @Override // com.bytedance.sdk.component.iz.s
        public l to(ImageView imageView) {
            this.nr = imageView;
            return new fx(this).o();
        }
    }

    private fx(nr nrVar) {
        this.sx = new LinkedBlockingQueue();
        this.bg = new Handler(Looper.getMainLooper());
        this.bq = true;
        this.nr = nrVar.b;
        this.pn = new u(nrVar.u);
        this.l = new WeakReference<>(nrVar.nr);
        this.iz = nrVar.pn;
        this.x = nrVar.iz;
        this.n = nrVar.x;
        this.f5141a = nrVar.n;
        this.t = nrVar.f5142a;
        this.o = nrVar.jk;
        this.my = nrVar.t;
        this.kj = u(nrVar);
        if (!TextUtils.isEmpty(nrVar.fx)) {
            nr(nrVar.fx);
            u(nrVar.fx);
        }
        this.s = nrVar.l;
        this.k = nrVar.mv;
        this.q = nrVar.my;
        this.jk = nrVar.o;
        this.gi = nrVar.bg;
        this.z = nrVar.sx;
        this.h = nrVar.dw;
        this.d = nrVar.bq;
        this.rh = nrVar.c;
        this.ja = nrVar.q;
        this.sx.add(new com.bytedance.sdk.component.iz.b.fx());
    }

    public com.bytedance.sdk.component.iz.n a() {
        return this.dw;
    }

    public Bitmap.Config b() {
        return this.x;
    }

    public qq fx() {
        return this.pn;
    }

    public boolean iz() {
        return this.s;
    }

    public int jk() {
        return this.c;
    }

    public boolean n() {
        return this.bq;
    }

    public int nr() {
        return this.gi;
    }

    public int pn() {
        return this.t;
    }

    public boolean x() {
        return this.k;
    }

    private com.bytedance.sdk.component.iz.nr u(nr nrVar) {
        if (nrVar.k != null) {
            return nrVar.k;
        }
        if (!TextUtils.isEmpty(nrVar.s)) {
            return com.bytedance.sdk.component.iz.fx.u.u.u(new File(nrVar.s));
        }
        return com.bytedance.sdk.component.iz.fx.u.u.u();
    }

    public void nr(String str) {
        WeakReference<ImageView> weakReference = this.l;
        if (weakReference != null && weakReference.get() != null) {
            this.l.get().setTag(1094453505, str);
        }
        this.fx = str;
    }

    public int u() {
        return this.z;
    }

    public void u(String str) {
        this.b = str;
    }

    public void u(boolean z) {
        this.bq = z;
    }

    public void u(com.bytedance.sdk.component.iz.n nVar) {
        this.dw = nVar;
    }

    public void u(int i) {
        this.c = i;
    }

    public void u(com.bytedance.sdk.component.iz.fx.u uVar) {
        this.qq = uVar;
    }

    public boolean u(a aVar) {
        if (this.mv) {
            return false;
        }
        return this.sx.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, String str, Throwable th) {
        new com.bytedance.sdk.component.iz.b.n(i, str, th).u(this);
        this.sx.clear();
    }
}
