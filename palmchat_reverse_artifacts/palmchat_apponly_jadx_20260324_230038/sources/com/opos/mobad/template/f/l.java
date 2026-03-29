package com.opos.mobad.template.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.a;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.CarouselViewPager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class l implements com.opos.mobad.template.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9535a;
    private com.opos.mobad.template.cmn.baseview.c b;
    private RelativeLayout c;
    private RelativeLayout d;
    private p e;
    private a.InterfaceC0778a f;
    private int g;
    private Context h;
    private com.opos.mobad.template.d.b i;
    private a j;
    private com.opos.mobad.d.a l;
    private boolean m;
    private boolean n;
    private com.opos.mobad.template.e.c.a o;
    private volatile boolean k = false;
    private boolean p = false;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f9554a;
        public final int b;

        public a(int i, int i2) {
            this.f9554a = i;
            this.b = i2;
        }
    }

    public l(Context context, int i, boolean z, a aVar, int i2, com.opos.mobad.d.a aVar2) {
        this.h = context.getApplicationContext();
        this.g = i;
        this.j = aVar;
        this.f9535a = i2;
        this.l = aVar2;
        this.m = z;
        f();
    }

    public static final com.opos.mobad.template.a b(Context context, int i, com.opos.mobad.d.a aVar) {
        return new l(context, i, false, new a(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT), 2, aVar, true);
    }

    private View d(com.opos.mobad.template.d.b bVar) {
        final CarouselViewPager carouselViewPager = new CarouselViewPager(this.h, 3);
        int iA = com.opos.cmn.an.h.f.a.a(this.h, this.j.f9554a);
        int iA2 = com.opos.cmn.an.h.f.a.a(this.h, this.j.b);
        if (bVar == null) {
            return carouselViewPager;
        }
        final ArrayList arrayList = new ArrayList();
        for (int i = 0; i < Math.min(bVar.c.size(), 3); i++) {
            com.opos.mobad.template.d.e eVar = bVar.c.get(i);
            if (eVar != null) {
                this.l.a(eVar.f9414a, eVar.b, iA, iA2, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.f.l.9
                    @Override // com.opos.mobad.d.a.InterfaceC0732a
                    public void a(int i2, final Bitmap bitmap) {
                        if (l.this.k) {
                            return;
                        }
                        if (bitmap == null || bitmap.isRecycled()) {
                            com.opos.cmn.an.f.a.a("imageInter", "null bitmap");
                            return;
                        }
                        if (i2 != 0 && i2 != 1) {
                            if (l.this.f != null) {
                                l.this.f.c(i2);
                            }
                        } else {
                            if (i2 == 1 && l.this.f != null) {
                                l.this.f.c(i2);
                            }
                            com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.f.l.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (l.this.k) {
                                        return;
                                    }
                                    arrayList.add(bitmap);
                                    AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                                    carouselViewPager.a(arrayList);
                                }
                            });
                        }
                    }
                });
            }
        }
        carouselViewPager.a(bVar.y);
        carouselViewPager.a(new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.l.10
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (l.this.f != null) {
                    l.this.f.h(view, iArr);
                }
            }
        });
        carouselViewPager.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.f.l.11
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i2, boolean z) {
                com.opos.cmn.an.f.a.a("imageInter", "onMockEventIntercepted->clickMockEvent:" + i2 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (l.this.f != null) {
                    l.this.f.a(view, i2, z);
                }
            }
        });
        return carouselViewPager;
    }

    private View f(com.opos.mobad.template.d.b bVar) {
        final ImageView imageView = new ImageView(this.h);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        List<com.opos.mobad.template.d.e> list = bVar.c;
        if (list != null) {
            this.l.a(list.get(0).f9414a, bVar.c.get(0).b, com.opos.cmn.an.h.f.a.a(this.h, this.j.f9554a), com.opos.cmn.an.h.f.a.a(this.h, this.j.b), new a.InterfaceC0732a() { // from class: com.opos.mobad.template.f.l.2
                @Override // com.opos.mobad.d.a.InterfaceC0732a
                public void a(int i, final Bitmap bitmap) {
                    if (l.this.k) {
                        return;
                    }
                    if (i != 0 && i != 1) {
                        if (l.this.f != null) {
                            l.this.f.c(i);
                        }
                    } else {
                        if (i == 1 && l.this.f != null) {
                            l.this.f.c(i);
                        }
                        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.f.l.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap2;
                                if (l.this.k || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                    return;
                                }
                                imageView.setImageBitmap(bitmap);
                            }
                        });
                    }
                }
            });
        }
        return imageView;
    }

    public static final com.opos.mobad.template.a g(Context context, int i, com.opos.mobad.d.a aVar) {
        return new l(context, i, true, new a(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, 169), 3, aVar);
    }

    public static final com.opos.mobad.template.a h(Context context, int i, com.opos.mobad.d.a aVar) {
        return new l(context, i, true, new a(MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE, 169), 0, aVar, true);
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.b;
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.g;
    }

    public l(Context context, int i, boolean z, a aVar, int i2, com.opos.mobad.d.a aVar2, boolean z2) {
        this.h = context.getApplicationContext();
        this.g = i;
        this.j = aVar;
        this.f9535a = i2;
        this.l = aVar2;
        this.m = z;
        this.n = z2;
        f();
    }

    public static final com.opos.mobad.template.a a(Context context, int i, com.opos.mobad.d.a aVar) {
        return new l(context, i, false, new a(MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE, 153), 1, aVar);
    }

    public static final com.opos.mobad.template.a c(Context context, int i, com.opos.mobad.d.a aVar) {
        return new l(context, i, false, new a(MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT), 3, aVar);
    }

    public static final com.opos.mobad.template.a d(Context context, int i, com.opos.mobad.d.a aVar) {
        return new l(context, i, false, new a(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT), 0, aVar, true);
    }

    private View e(com.opos.mobad.template.d.b bVar) {
        final com.opos.mobad.template.cmn.b bVarA = this.m ? com.opos.mobad.template.cmn.b.a(this.h) : com.opos.mobad.template.cmn.b.b(this.h);
        com.opos.mobad.template.d.e eVar = bVar.k;
        if (eVar != null) {
            this.l.a(eVar.f9414a, eVar.b, com.opos.cmn.an.h.f.a.a(this.h, bVarA.b), com.opos.cmn.an.h.f.a.a(this.h, bVarA.b), new a.InterfaceC0732a() { // from class: com.opos.mobad.template.f.l.12
                @Override // com.opos.mobad.d.a.InterfaceC0732a
                public void a(int i, final Bitmap bitmap) {
                    if (l.this.k) {
                        return;
                    }
                    if (i != 0 && i != 1) {
                        if (l.this.f != null) {
                            l.this.f.c(i);
                        }
                    } else {
                        if (i == 1 && l.this.f != null) {
                            l.this.f.c(i);
                        }
                        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.f.l.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap2;
                                if (l.this.k || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                    return;
                                }
                                bVarA.a(bitmap, 28);
                            }
                        });
                    }
                }
            });
        }
        return bVarA;
    }

    public static final com.opos.mobad.template.a f(Context context, int i, com.opos.mobad.d.a aVar) {
        return new l(context, i, true, new a(MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE, 169), 2, aVar, true);
    }

    private boolean g() {
        int i = this.g;
        return i == 48 || i == 7;
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        com.opos.mobad.template.e.c.a aVar;
        if (this.k || !g() || (aVar = this.o) == null) {
            return;
        }
        aVar.h();
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        this.e.a(bVar.b, bVar.f9413a, bVar.w, bVar.x, bVar.j);
        if (this.i != null) {
            return;
        }
        int iA = com.opos.cmn.an.h.f.a.a(this.h, 60.0f);
        com.opos.mobad.template.d.e eVar = bVar.k;
        if (eVar == null || TextUtils.isEmpty(eVar.f9414a)) {
            this.e.b();
        } else {
            com.opos.mobad.d.a aVar = this.l;
            com.opos.mobad.template.d.e eVar2 = bVar.k;
            aVar.a(eVar2.f9414a, eVar2.b, iA, iA, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.f.l.8
                @Override // com.opos.mobad.d.a.InterfaceC0732a
                public void a(int i, final Bitmap bitmap) {
                    if (l.this.k) {
                        return;
                    }
                    if (i != 0 && i != 1) {
                        if (l.this.f != null) {
                            l.this.f.c(i);
                        }
                    } else {
                        if (i == 1 && l.this.f != null) {
                            l.this.f.c(i);
                        }
                        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.f.l.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap2;
                                if (l.this.k || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                    return;
                                }
                                l.this.e.a(bitmap);
                            }
                        });
                    }
                }
            });
        }
        this.e.a();
    }

    public static final com.opos.mobad.template.a e(Context context, int i, com.opos.mobad.d.a aVar) {
        return new l(context, i, true, new a(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, 145), 1, aVar);
    }

    private void f() {
        com.opos.mobad.template.cmn.baseview.c cVar = new com.opos.mobad.template.cmn.baseview.c(this.h);
        this.b = cVar;
        cVar.setBackgroundColor(-1);
        com.opos.mobad.template.cmn.p.a(this.b, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.l.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (l.this.f != null) {
                    l.this.f.h(view, iArr);
                }
            }
        });
        com.opos.mobad.template.cmn.baseview.f fVar = new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.f.l.5
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i, boolean z) {
                com.opos.cmn.an.f.a.a("imageInter", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (l.this.f != null) {
                    l.this.f.a(view, i, z);
                }
            }
        };
        this.b.a(fVar);
        RelativeLayout relativeLayout = new RelativeLayout(this.h);
        this.c = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        this.b.addView(this.c, new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.h, this.j.b)));
        this.d = new RelativeLayout(this.h);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.h, this.m ? 232.0f : 92.0f));
        layoutParams.addRule(3, this.c.getId());
        if (this.n) {
            this.d.setBackgroundColor(this.h.getResources().getColor(R.color.opos_mobad_bottom_bg_color));
        }
        this.b.addView(this.d, layoutParams);
        p pVarA = this.m ? p.a(this.h, Boolean.valueOf(this.n)) : p.b(this.h, Boolean.valueOf(this.n));
        this.e = pVarA;
        pVarA.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.h, this.j.f9554a), -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(15);
        if (this.m) {
            this.e.setPadding(0, 0, 0, com.opos.cmn.an.h.f.a.a(this.h, 24.0f));
        } else {
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.h, 16.0f);
        }
        this.d.addView(this.e, layoutParams2);
        this.e.a(new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.l.6
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (l.this.f != null) {
                    l.this.f.g(view, iArr);
                }
            }
        });
        this.e.a(fVar);
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        com.opos.mobad.template.e.c.a aVar;
        if (this.k || !g() || (aVar = this.o) == null) {
            return;
        }
        aVar.i();
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        com.opos.mobad.template.e.c.a aVar;
        this.k = true;
        if (!g() || (aVar = this.o) == null) {
            return;
        }
        aVar.j();
    }

    private void c(com.opos.mobad.template.d.b bVar) {
        if (this.i != null) {
            return;
        }
        int i = this.f9535a;
        this.c.addView((i == 1 || i == 2) ? f(bVar) : i == 3 ? d(bVar) : e(bVar), new RelativeLayout.LayoutParams(-1, -1));
    }

    public void a(ViewGroup viewGroup, final a.InterfaceC0778a interfaceC0778a, final com.opos.mobad.template.e.c.a aVar) {
        if (viewGroup == null || interfaceC0778a == null) {
            return;
        }
        final com.opos.mobad.d.e.a aVar2 = new com.opos.mobad.d.e.a(viewGroup.getContext());
        aVar2.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.f.l.3
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (z) {
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.f.l.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
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
        aVar2.a(new a.c() { // from class: com.opos.mobad.template.f.l.4
            @Override // com.opos.mobad.d.e.a.c
            public void a(final boolean z, final boolean z2) {
                com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.f.l.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
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

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.f = interfaceC0778a;
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        if (!this.p) {
            com.opos.mobad.template.e.c.a aVarA = com.opos.mobad.template.e.a.i.a().a(this.h, e(), bVar.L);
            this.o = aVarA;
            if (aVarA == null) {
                return;
            }
            aVarA.a(new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.template.f.l.7
                @Override // com.opos.mobad.template.e.c.b
                public void a(int i, int[] iArr) {
                    if (l.this.f != null) {
                        l.this.f.a(i, iArr);
                    }
                }

                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (l.this.f != null) {
                        l.this.f.g(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(View view, int[] iArr) {
                    if (l.this.f != null) {
                        l.this.f.h(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.c
                public void a(int[] iArr) {
                    if (l.this.f != null) {
                        l.this.f.a(iArr);
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.h, 46.0f));
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.h, 12.0f);
            layoutParams.addRule(14);
            layoutParams.addRule(12, this.c.getId());
            if (this.o.e() && this.o.c() != null) {
                this.c.addView(this.o.c(), layoutParams);
            }
            this.p = true;
        }
        com.opos.mobad.template.e.c.a aVar = this.o;
        if (aVar != null) {
            aVar.a(com.opos.mobad.template.e.b.a.a(bVar));
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        a.InterfaceC0778a interfaceC0778a;
        List<com.opos.mobad.template.d.e> list;
        com.opos.mobad.template.d.e eVar;
        com.opos.mobad.template.d.b bVarA = fVar.a();
        if (bVarA == null) {
            com.opos.cmn.an.f.a.d("imageInter", "render with data null");
            a.InterfaceC0778a interfaceC0778a2 = this.f;
            if (interfaceC0778a2 != null) {
                interfaceC0778a2.a(1);
                return;
            }
            return;
        }
        if (this.f9535a == 0 && ((eVar = bVarA.k) == null || TextUtils.isEmpty(eVar.f9414a))) {
            com.opos.cmn.an.f.a.d("", "render with iconUrl null");
            a.InterfaceC0778a interfaceC0778a3 = this.f;
            if (interfaceC0778a3 != null) {
                interfaceC0778a3.a(1);
                return;
            }
            return;
        }
        if (this.f9535a != 0 && ((list = bVarA.c) == null || list.size() <= 0)) {
            com.opos.cmn.an.f.a.d("", "render with imgList null");
            a.InterfaceC0778a interfaceC0778a4 = this.f;
            if (interfaceC0778a4 != null) {
                interfaceC0778a4.a(1);
                return;
            }
            return;
        }
        c(bVarA);
        b(bVarA);
        if (g()) {
            a(bVarA);
        }
        if (this.i == null && (interfaceC0778a = this.f) != null) {
            interfaceC0778a.f();
            a(this.b, this.f, this.o);
        }
        this.i = bVarA;
    }
}
