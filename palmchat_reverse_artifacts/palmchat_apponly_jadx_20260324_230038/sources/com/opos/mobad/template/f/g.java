package com.opos.mobad.template.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.palette.graphics.Palette;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.a;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.baseview.BaseImageView;
import com.opos.mobad.template.f.r;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class g implements com.opos.mobad.template.a {
    private Context b;
    private int c;
    private int d;
    private com.opos.mobad.d.a e;
    private a.InterfaceC0778a f;
    private RelativeLayout g;
    private b h;
    private c i;
    private View j;
    private ObjectAnimator k;
    private com.opos.mobad.template.d.b l;
    private int m;
    private FrameLayout n;
    private ImageView o;
    private ImageView p;
    private boolean q;
    private com.opos.mobad.template.e.c.a r;
    private boolean s = false;
    private com.opos.mobad.template.cmn.p t = new AnonymousClass5();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.opos.mobad.template.cmn.baseview.f f9495a = new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.f.g.12
        @Override // com.opos.mobad.template.cmn.baseview.f
        public void a(View view, int i, boolean z) {
            com.opos.cmn.an.f.a.a("ImageFullScreenInters", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
            if (g.this.f != null) {
                g.this.f.a(view, i, z);
            }
        }
    };

    /* JADX INFO: renamed from: com.opos.mobad.template.f.g$5, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass5 extends com.opos.mobad.template.cmn.p {
        public AnonymousClass5() {
        }

        @Override // com.opos.mobad.template.cmn.p
        public void b(final View view, final int[] iArr) {
            g.this.a(new r.a() { // from class: com.opos.mobad.template.f.g.5.1
                @Override // com.opos.mobad.template.f.r.a
                public void a() {
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.f.g.5.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (g.this.f != null) {
                                a.InterfaceC0778a interfaceC0778a = g.this.f;
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                interfaceC0778a.e(view, iArr);
                            }
                        }
                    });
                }
            });
        }
    }

    public g(Context context, int i, int i2, com.opos.mobad.d.a aVar) {
        if (context != null) {
            this.b = context.getApplicationContext();
        }
        this.d = i;
        this.q = i == 0;
        this.c = i2;
        this.e = aVar;
        f();
    }

    private void h() {
        ImageView imageViewJ = j();
        this.p = imageViewJ;
        this.g.addView(imageViewJ);
        BaseImageView baseImageView = new BaseImageView(this.b);
        baseImageView.setImageResource(R.drawable.opos_mobad_drawable_block_close_with_bg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMarginEnd(com.opos.cmn.an.h.f.a.a(this.b, 25.0f));
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 32.0f);
        layoutParams.addRule(21);
        baseImageView.setId(View.generateViewId());
        baseImageView.setOnClickListener(this.t);
        baseImageView.setOnTouchListener(this.t);
        this.g.addView(baseImageView, layoutParams);
        b bVar = new b(this.b, this.e);
        this.h = bVar;
        this.g.addView(bVar);
    }

    private void i() {
        FrameLayout frameLayout = new FrameLayout(this.b);
        this.n = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ImageView imageViewJ = j();
        this.o = imageViewJ;
        this.n.addView(imageViewJ);
        View view = new View(this.b);
        this.j = view;
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.n.addView(this.j);
    }

    private ImageView j() {
        BaseImageView baseImageView = new BaseImageView(this.b);
        baseImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        baseImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.g.11
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (g.this.f != null) {
                    g.this.f.h(view, iArr);
                }
            }
        };
        baseImageView.setOnClickListener(pVar);
        baseImageView.setOnTouchListener(pVar);
        baseImageView.a(this.f9495a);
        return baseImageView;
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.c;
    }

    private RelativeLayout a(int i) {
        RelativeLayout relativeLayout = new RelativeLayout(this.b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setBackgroundColor(ColorUtils.setAlphaComponent(-1, i));
        relativeLayout.setOutlineProvider(new ViewOutlineProvider() { // from class: com.opos.mobad.template.f.g.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), g.this.m);
            }
        });
        relativeLayout.setClipToOutline(true);
        return relativeLayout;
    }

    public static final com.opos.mobad.template.a b(Context context, int i, com.opos.mobad.d.a aVar) {
        return new g(context, 1, i, aVar);
    }

    private void g() {
        i();
        this.g.addView(this.n);
        this.i = new c(this.b, this.e);
        RelativeLayout relativeLayoutA = a(25);
        relativeLayoutA.addView(this.i);
        this.g.addView(relativeLayoutA);
        this.i.a(this.m);
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.g;
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        this.b = null;
        this.l = null;
        RelativeLayout relativeLayout = this.g;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        ObjectAnimator objectAnimator = this.k;
        if (objectAnimator != null) {
            objectAnimator.end();
        }
        com.opos.mobad.template.e.c.a aVar = this.r;
        if (aVar != null) {
            aVar.j();
        }
    }

    public void f() {
        Context context = this.b;
        if (context == null) {
            return;
        }
        this.m = com.opos.cmn.an.h.f.a.a(context, 16.0f);
        this.g = new RelativeLayout(this.b);
        this.g.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.g.setVisibility(4);
        if (this.d == 1) {
            g();
        } else {
            h();
        }
    }

    public static final com.opos.mobad.template.a a(Context context, int i, com.opos.mobad.d.a aVar) {
        return new g(context, 0, i, aVar);
    }

    private void c(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.d.e eVar;
        if (this.e == null || bVar == null || (eVar = bVar.k) == null || TextUtils.isEmpty(eVar.f9414a)) {
            a((Bitmap) null);
            return;
        }
        com.opos.mobad.d.a aVar = this.e;
        com.opos.mobad.template.d.e eVar2 = bVar.k;
        aVar.a(eVar2.f9414a, eVar2.b, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.f.g.3
            @Override // com.opos.mobad.d.a.InterfaceC0732a
            public void a(int i, final Bitmap bitmap) {
                if (g.this.b == null) {
                    return;
                }
                if (i == 0 || i == 1) {
                    if (i == 1 && g.this.f != null) {
                        g.this.f.c(i);
                    }
                    com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.f.g.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2 = bitmap;
                            if (bitmap2 == null || bitmap2.isRecycled()) {
                                return;
                            }
                            g.this.a(bitmap);
                        }
                    });
                    return;
                }
                g.this.a((Bitmap) null);
                if (g.this.f != null) {
                    g.this.f.c(i);
                }
            }
        });
    }

    @Override // com.opos.mobad.template.a
    public void b() {
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        RelativeLayout.LayoutParams layoutParams;
        ViewGroup viewGroup;
        if (!this.s) {
            com.opos.mobad.template.e.c.a aVarA = com.opos.mobad.template.e.a.i.a().a(this.b, e(), bVar.L);
            this.r = aVarA;
            if (aVarA == null) {
                return;
            }
            aVarA.a(new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.template.f.g.9
                @Override // com.opos.mobad.template.e.c.b
                public void a(int i, int[] iArr) {
                    if (g.this.f != null) {
                        g.this.f.a(i, iArr);
                    }
                }

                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (g.this.f != null) {
                        g.this.f.g(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(View view, int[] iArr) {
                    if (g.this.f != null) {
                        g.this.f.h(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.c
                public void a(int[] iArr) {
                    if (g.this.f != null) {
                        g.this.f.a(iArr);
                    }
                }
            });
            if (this.q) {
                layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.b, 46.0f));
                layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.b, 244.0f);
                layoutParams.addRule(14);
                layoutParams.addRule(12);
                if (this.r.e() && this.r.c() != null) {
                    viewGroup = this.g;
                    viewGroup.addView(this.r.c(), layoutParams);
                }
                this.s = true;
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.b, 46.0f));
                layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.b, 12.0f);
                layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.b, 3.5f);
                layoutParams.addRule(12);
                layoutParams.addRule(20);
                this.i.setClipChildren(false);
                if (this.r.e() && this.r.c() != null) {
                    viewGroup = this.i;
                    viewGroup.addView(this.r.c(), layoutParams);
                }
                this.s = true;
            }
        }
        com.opos.mobad.template.e.c.a aVar = this.r;
        if (aVar != null) {
            aVar.a(com.opos.mobad.template.e.b.a.a(bVar));
        }
    }

    @Override // com.opos.mobad.template.a
    public void a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Bitmap bitmap) {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.f.g.4
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.d == 1) {
                    if (g.this.i != null) {
                        g.this.i.b(bitmap);
                    }
                } else if (g.this.h != null) {
                    g.this.h.a(bitmap);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, Palette palette, com.opos.mobad.template.d.b bVar) {
        if (this.i == null || this.j == null || palette == null) {
            return;
        }
        com.opos.mobad.template.cmn.s.a(palette);
        this.j.setBackgroundColor(ColorUtils.setAlphaComponent(-16777216, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID));
        this.i.a(this.f).a(this.t).a(palette).a(bitmap).a(bVar.f9413a).a(bVar).a(bVar.b, bVar.u).b(bVar.j);
        c(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Bitmap bitmap, final com.opos.mobad.template.d.b bVar) {
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() { // from class: com.opos.mobad.template.f.g.2
            @Override // androidx.palette.graphics.Palette.PaletteAsyncListener
            public void onGenerated(Palette palette) {
                if (g.this.d == 1) {
                    g.this.a(bitmap, palette, bVar);
                } else {
                    g.this.a(palette, bVar);
                }
            }
        });
    }

    public void a(ViewGroup viewGroup, final a.InterfaceC0778a interfaceC0778a, final com.opos.mobad.template.e.c.a aVar) {
        if (viewGroup == null || interfaceC0778a == null) {
            return;
        }
        final com.opos.mobad.d.e.a aVar2 = new com.opos.mobad.d.e.a(viewGroup.getContext());
        aVar2.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.f.g.7
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (z) {
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.f.g.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                            if (interfaceC0778a != null) {
                                interfaceC0778a.a(com.opos.mobad.template.h.a(aVar));
                            }
                            com.opos.mobad.template.e.c.a aVar3 = aVar;
                            if (aVar3 == null || aVar3.c() == null) {
                                return;
                            }
                            aVar.c().setVisibility(0);
                        }
                    });
                    aVar2.a((a.InterfaceC0735a) null);
                }
            }
        });
        aVar2.a(new a.c() { // from class: com.opos.mobad.template.f.g.8
            @Override // com.opos.mobad.d.e.a.c
            public void a(final boolean z, final boolean z2) {
                com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.f.g.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                        if (interfaceC0778a != null) {
                            Map<String, String> mapA = com.opos.mobad.template.h.a(aVar);
                            mapA.put("isVisibleRect", String.valueOf(z));
                            mapA.put("isAttached", String.valueOf(z2));
                            interfaceC0778a.a(mapA);
                        }
                    }
                });
                aVar2.a((a.c) null, (View) null);
            }
        }, c());
        viewGroup.addView(aVar2, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Palette palette, com.opos.mobad.template.d.b bVar) {
        b bVar2 = this.h;
        if (bVar2 == null || bVar == null) {
            return;
        }
        if (bVar2.a() == null) {
            this.h.a(this.f);
        }
        this.h.a(palette).a(bVar.f9413a).a(bVar).a(bVar.b, bVar.u).b(bVar.j);
        c(bVar);
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.f = interfaceC0778a;
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        a(bVar, this.d == 1 ? this.o : this.p);
        b(bVar);
    }

    private void a(final com.opos.mobad.template.d.b bVar, final ImageView imageView) {
        List<com.opos.mobad.template.d.e> list = bVar.c;
        if (list != null) {
            this.e.a(list.get(0).f9414a, bVar.c.get(0).b, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.f.g.10
                @Override // com.opos.mobad.d.a.InterfaceC0732a
                public void a(int i, final Bitmap bitmap) {
                    if (g.this.b == null) {
                        return;
                    }
                    if (i != 0 && i != 1) {
                        if (g.this.f != null) {
                            g.this.f.c(i);
                        }
                    } else {
                        if (i == 1 && g.this.f != null) {
                            g.this.f.c(i);
                        }
                        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.f.g.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap2 = bitmap;
                                if (bitmap2 == null || bitmap2.isRecycled()) {
                                    return;
                                }
                                if (g.this.d == 1) {
                                    AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                                    imageView.setImageBitmap(com.opos.mobad.template.cmn.f.a(g.this.b, bitmap, 75, 0.25f, 60.0f));
                                } else {
                                    imageView.setImageBitmap(bitmap);
                                }
                                AnonymousClass10 anonymousClass102 = AnonymousClass10.this;
                                g.this.a(bitmap, bVar);
                            }
                        });
                    }
                }
            });
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        a.InterfaceC0778a interfaceC0778a;
        com.opos.mobad.template.d.b bVarA = fVar.a();
        if (bVarA == null) {
            com.opos.cmn.an.f.a.d("ImageFullScreenInterstitial", "render with data null");
            a.InterfaceC0778a interfaceC0778a2 = this.f;
            if (interfaceC0778a2 != null) {
                interfaceC0778a2.a(1);
                return;
            }
            return;
        }
        List<com.opos.mobad.template.d.e> list = bVarA.c;
        if (list == null || list.size() <= 0) {
            com.opos.cmn.an.f.a.d("", "render with imgList null");
            a.InterfaceC0778a interfaceC0778a3 = this.f;
            if (interfaceC0778a3 != null) {
                interfaceC0778a3.a(1);
                return;
            }
            return;
        }
        RelativeLayout relativeLayout = this.g;
        if (relativeLayout != null && relativeLayout.getVisibility() != 0) {
            this.g.setVisibility(0);
        }
        a(bVarA);
        if (this.l == null && (interfaceC0778a = this.f) != null) {
            interfaceC0778a.f();
            a(this.g, this.f, this.r);
        }
        this.l = bVarA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ObjectAnimatorBinding"})
    public void a(final r.a aVar) {
        this.k = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        this.k.setInterpolator(PathInterpolatorCompat.create(0.1f, 0.0f, 0.9f, 1.0f));
        this.k.setDuration(150L);
        this.k.start();
        this.k.addListener(new AnimatorListenerAdapter() { // from class: com.opos.mobad.template.f.g.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                g.this.k.removeListener(this);
                if (aVar != null) {
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.f.g.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.a();
                        }
                    });
                }
            }
        });
    }
}
