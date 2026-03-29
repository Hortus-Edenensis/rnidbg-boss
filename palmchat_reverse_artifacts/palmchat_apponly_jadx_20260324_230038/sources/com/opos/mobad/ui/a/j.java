package com.opos.mobad.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.opos.mobad.d.a;
import com.opos.mobad.ui.a.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class j extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f10220a;
    private a b;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(ImageView imageView, Bitmap bitmap);
    }

    public j(Context context, d dVar, FrameLayout frameLayout) {
        super(context, dVar, frameLayout, false);
        this.f10220a = false;
        this.b = new a() { // from class: com.opos.mobad.ui.a.j.4
            @Override // com.opos.mobad.ui.a.j.a
            public void a(final ImageView imageView, final Bitmap bitmap) {
                if (imageView == null || bitmap == null) {
                    return;
                }
                com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.ui.a.j.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        ImageView imageView2 = imageView;
                        if (imageView2 == null || (bitmap2 = bitmap) == null) {
                            return;
                        }
                        imageView2.setImageBitmap(bitmap2);
                        com.opos.cmn.an.f.a.b("MediaCreative", "mIImgLoaderResult success");
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai() {
        Drawable drawable;
        BitmapDrawable bitmapDrawable;
        ImageView imageView = this.m;
        if (imageView == null || (drawable = imageView.getDrawable()) == null) {
            return;
        }
        if ((drawable instanceof BitmapDrawable) && (bitmapDrawable = (BitmapDrawable) drawable) != null && bitmapDrawable.getBitmap() != null && !bitmapDrawable.getBitmap().isRecycled()) {
            bitmapDrawable.getBitmap().recycle();
            com.opos.cmn.an.f.a.b("MediaCreative", "recycle bitmap");
        }
        this.m.setImageDrawable(null);
    }

    @Override // com.opos.mobad.ui.a.a
    public void a() {
        RelativeLayout relativeLayout = this.o;
        if (relativeLayout != null) {
            relativeLayout.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.opos.mobad.ui.a.j.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    if (k.a().a(j.this.B)) {
                        com.opos.cmn.an.f.a.b("MediaCreative", "onViewDetachedFromWindow release video");
                        k.a().c();
                    }
                    j.this.ai();
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                }
            });
        }
    }

    public void b() {
        com.opos.cmn.an.f.a.b("MediaCreative", "release video and ad");
        this.f10220a = true;
        W();
        S();
        T();
    }

    public void d(a.C0803a c0803a) {
        com.opos.cmn.an.f.a.b("MediaCreative", "playVideoWithoutCheckPlaying url:" + c0803a);
        if (c0803a != null) {
            this.d = c0803a;
            this.B = c0803a.c;
            a(this.m, 5);
            a(this.o, 4);
            X();
            k.a().b(this.c, c0803a.c, c0803a.d, this.o, this, false);
        }
    }

    @Override // com.opos.mobad.ui.a.e
    public void a(View view, int[] iArr) {
        c(view, iArr);
    }

    @Override // com.opos.mobad.ui.a.e
    public void b(View view, int[] iArr) {
        c(view, iArr);
    }

    public void c(View view, int[] iArr) {
        d dVar = this.v;
        if (dVar != null) {
            dVar.a(view, iArr, k.a().e(this.B), com.opos.mobad.cmn.func.b.a.VIDEO);
        }
    }

    @Override // com.opos.mobad.ui.a.a
    public void a(View view, int[] iArr, int i) {
        c(view, iArr);
    }

    public void b(a.C0803a c0803a) {
        ViewGroup.LayoutParams layoutParams;
        com.opos.cmn.an.f.a.b("MediaCreative", "renderInitCoverUI");
        if (this.m == null) {
            ImageView imageView = new ImageView(this.c);
            this.m = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        if (this.m.getParent() == null || this.m.getParent() == this.e) {
            if (this.m.getParent() == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            a(c0803a);
            X();
        }
        ((ViewGroup) this.m.getParent()).removeView(this.m);
        layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.e.addView(this.m, layoutParams);
        a(this.m, 5);
        a(c0803a);
        X();
    }

    public void c(final a.C0803a c0803a) {
        com.opos.cmn.an.f.a.b("MediaCreative", "playVideo :" + c0803a);
        if (c0803a != null) {
            this.d = c0803a;
            this.B = c0803a.c;
            com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.ui.a.j.2
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.f10220a) {
                        return;
                    }
                    j jVar = j.this;
                    jVar.a(jVar.m, 5);
                    j jVar2 = j.this;
                    jVar2.a(jVar2.o, 4);
                    k kVarA = k.a();
                    j jVar3 = j.this;
                    Context context = jVar3.c;
                    a.C0803a c0803a2 = c0803a;
                    kVarA.a(context, c0803a2.c, c0803a2.d, jVar3.o, jVar3, false);
                }
            });
        }
    }

    @Override // com.opos.mobad.ui.a.h
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.opos.mobad.downloader.f.a().b(str, null, com.opos.cmn.an.h.f.a.b(this.c), (com.opos.cmn.an.h.f.a.b(this.c) * 9) / 16, new a.InterfaceC0732a() { // from class: com.opos.mobad.ui.a.j.3
            @Override // com.opos.mobad.d.a.InterfaceC0732a
            public void a(int i, Bitmap bitmap) {
                com.opos.cmn.an.f.a.b("MediaCreative", "loadCoverImg code:" + i + " bitmap:" + bitmap);
                if (i != 0 || bitmap == null) {
                    return;
                }
                j.this.b.a(j.this.m, bitmap);
            }
        });
    }
}
