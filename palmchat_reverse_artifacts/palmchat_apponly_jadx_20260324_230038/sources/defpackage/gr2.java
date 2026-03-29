package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class gr2 {
    public static final String b = "gr2";
    public static Handler c = new Handler(Looper.getMainLooper());
    public static volatile gr2 d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public jr2 f17776a = new gd5();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ImageViewTarget<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f17777a;
        public final /* synthetic */ String b;

        /* JADX INFO: renamed from: gr2$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC1200a implements Runnable {
            public RunnableC1200a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                aVar.f17777a.onLoadingStarted(aVar.b, ((ViewTarget) aVar).view);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                aVar.f17777a.onLoadingCancelled(aVar.b, ((ViewTarget) aVar).view);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ImageView imageView, e eVar, String str) {
            super(imageView);
            this.f17777a = eVar;
            this.b = str;
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(@NonNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
            super.onResourceReady(drawable, transition);
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
        public void onLoadCleared(@Nullable Drawable drawable) {
            super.onLoadCleared(drawable);
            if (this.f17777a != null) {
                gr2.c.post(new b());
            }
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(@Nullable Drawable drawable) {
            super.onLoadFailed(drawable);
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
        public void onLoadStarted(@Nullable Drawable drawable) {
            super.onLoadStarted(drawable);
            if (this.f17777a != null) {
                gr2.c.post(new RunnableC1200a());
            }
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget
        public void setResource(@Nullable Drawable drawable) {
            ((ImageView) this.view).setImageDrawable(drawable);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements RequestListener<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f17780a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ImageView c;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ GlideException f17781a;

            public a(GlideException glideException) {
                this.f17781a = glideException;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                bVar.f17780a.onLoadingFailed(bVar.b, bVar.c, new FailReason(gr2.this.n(this.f17781a), new Throwable()));
            }
        }

        /* JADX INFO: renamed from: gr2$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC1201b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Drawable f17782a;

            public RunnableC1201b(Drawable drawable) {
                this.f17782a = drawable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Drawable drawable = this.f17782a;
                Bitmap bitmap = drawable instanceof BitmapDrawable ? ((BitmapDrawable) drawable).getBitmap() : null;
                b bVar = b.this;
                bVar.f17780a.onLoadingComplete(bVar.b, bVar.c, bitmap);
            }
        }

        public b(e eVar, String str, ImageView imageView) {
            this.f17780a = eVar;
            this.b = str;
            this.c = imageView;
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            if (this.f17780a == null) {
                return false;
            }
            gr2.c.post(new RunnableC1201b(drawable));
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
            if (this.f17780a == null) {
                return false;
            }
            gr2.c.post(new a(glideException));
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements RequestListener<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f17786a;
        public final /* synthetic */ String b;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ GlideException f17787a;

            public a(GlideException glideException) {
                this.f17787a = glideException;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = d.this;
                dVar.f17786a.onLoadingFailed(dVar.b, null, new FailReason(gr2.this.n(this.f17787a), new Throwable()));
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Drawable f17788a;

            public b(Drawable drawable) {
                this.f17788a = drawable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Drawable drawable = this.f17788a;
                Bitmap bitmap = drawable instanceof BitmapDrawable ? ((BitmapDrawable) drawable).getBitmap() : null;
                d dVar = d.this;
                dVar.f17786a.onLoadingComplete(dVar.b, null, bitmap);
            }
        }

        public d(e eVar, String str) {
            this.f17786a = eVar;
            this.b = str;
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            if (this.f17786a == null) {
                return false;
            }
            gr2.c.post(new b(drawable));
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
            if (this.f17786a == null) {
                return false;
            }
            gr2.c.post(new a(glideException));
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e implements jr2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public jr2 f17789a;
        public boolean b = false;

        public e(jr2 jr2Var) {
            this.f17789a = jr2Var;
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
            if (this.b) {
                this.b = false;
                this.f17789a.onLoadingCancelled(str, view);
            }
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            this.b = false;
            this.f17789a.onLoadingComplete(str, view, bitmap);
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            if (this.b) {
                this.b = false;
                this.f17789a.onLoadingFailed(str, view, failReason);
            }
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
            this.b = true;
            this.f17789a.onLoadingStarted(str, view);
        }
    }

    public static gr2 j() {
        if (d == null) {
            synchronized (gr2.class) {
                if (d == null) {
                    d = new gr2();
                }
            }
        }
        return d;
    }

    public final boolean d(Context context) {
        return ((context instanceof Activity) && ((Activity) context).isDestroyed()) ? false : true;
    }

    public void e(int i, ImageView imageView, je1 je1Var) {
        if (d(imageView.getContext())) {
            f("drawable://" + i, hc2.a(imageView.getContext()).load(Integer.valueOf(i)), imageView, je1Var, null);
        }
    }

    public final void f(String str, kc2<Drawable> kc2Var, ImageView imageView, je1 je1Var, jr2 jr2Var) {
        Context context = imageView.getContext();
        e eVar = jr2Var != null ? new e(jr2Var) : null;
        kc2Var.apply(q(context, je1Var)).addListener(new b(eVar, str, imageView)).into(new a(imageView, eVar, str));
    }

    public void g(String str, ImageView imageView) {
        h(str, imageView, null);
    }

    public void h(String str, ImageView imageView, je1 je1Var) {
        i(str, imageView, je1Var, null);
    }

    public void i(String str, ImageView imageView, je1 je1Var, jr2 jr2Var) {
        if (d(imageView.getContext())) {
            f(str, hc2.a(imageView.getContext()).load(str), imageView, je1Var, jr2Var);
        }
    }

    public void k(String str, je1 je1Var, jr2 jr2Var) {
        m(str, null, je1Var, jr2Var);
    }

    public void l(String str, jr2 jr2Var) {
        m(str, null, null, jr2Var);
    }

    public void m(String str, or2 or2Var, je1 je1Var, jr2 jr2Var) {
        Application applicationB = com.zenmen.palmchat.c.b();
        e eVar = jr2Var != null ? new e(jr2Var) : null;
        RequestOptions requestOptionsCenterCrop = q(applicationB, je1Var).centerCrop();
        if (or2Var != null) {
            requestOptionsCenterCrop = requestOptionsCenterCrop.override(or2Var.b(), or2Var.a());
        }
        hc2.a(applicationB).load(str).apply(requestOptionsCenterCrop).addListener(new d(eVar, str)).into(new c(eVar, str));
    }

    public final FailReason.FailType n(GlideException glideException) {
        String message;
        FailReason.FailType failType = FailReason.FailType.UNKNOWN;
        return (glideException == null || (message = glideException.getMessage()) == null) ? failType : message.contains("LX_NET_404") ? FailReason.FailType.NET_404 : message.contains("LX_NET_403") ? FailReason.FailType.NET_403 : message.contains("FileNotFoundException") ? FailReason.FailType.IO_ERROR : failType;
    }

    public final RequestOptions q(Context context, je1 je1Var) {
        RequestOptions requestOptions = new RequestOptions();
        if (je1Var == null) {
            return requestOptions;
        }
        if (je1Var.a(context.getResources()) != 0) {
            requestOptions = requestOptions.error(je1Var.a(context.getResources()));
        }
        if (je1Var.b(context.getResources()) != 0) {
            requestOptions = requestOptions.placeholder(je1Var.b(context.getResources()));
        }
        RequestOptions requestOptionsDiskCacheStrategy = (je1Var.d() && je1Var.e()) ? requestOptions.skipMemoryCache(false).diskCacheStrategy(DiskCacheStrategy.DATA) : je1Var.d() ? requestOptions.skipMemoryCache(false).diskCacheStrategy(DiskCacheStrategy.NONE) : je1Var.e() ? requestOptions.skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.DATA) : requestOptions.skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE);
        return je1Var.c() == ImageScaleType.EXACTLY ? requestOptionsDiskCacheStrategy.downsample(DownsampleStrategy.CENTER_INSIDE) : requestOptionsDiskCacheStrategy;
    }

    public void o() {
    }

    public void p() {
    }

    public void c(ImageView imageView) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends CustomTarget<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f17783a;
        public final /* synthetic */ String b;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                cVar.f17783a.onLoadingStarted(cVar.b, null);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                cVar.f17783a.onLoadingCancelled(cVar.b, null);
            }
        }

        public c(e eVar, String str) {
            this.f17783a = eVar;
            this.b = str;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(@Nullable Drawable drawable) {
            if (this.f17783a != null) {
                gr2.c.post(new b());
            }
        }

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(@Nullable Drawable drawable) {
            super.onLoadFailed(drawable);
        }

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public void onLoadStarted(@Nullable Drawable drawable) {
            super.onLoadStarted(drawable);
            if (this.f17783a != null) {
                gr2.c.post(new a());
            }
        }

        @Override // com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(@NonNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
        }
    }
}
