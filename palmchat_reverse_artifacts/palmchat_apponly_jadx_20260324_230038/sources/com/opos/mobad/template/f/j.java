package com.opos.mobad.template.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.opos.mobad.d.a;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class j implements com.opos.mobad.template.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a.InterfaceC0778a f9521a;
    private com.opos.mobad.d.a b;
    private int c;
    private Context d;
    private int e;
    private RelativeLayout f;
    private d g;
    private com.opos.mobad.template.d.b h;
    private boolean i;
    private com.opos.mobad.template.e.c.a k;
    private volatile boolean j = false;
    private boolean l = false;

    private j(Context context, int i, int i2, com.opos.mobad.d.a aVar) {
        if (context == null) {
            return;
        }
        this.c = i;
        this.d = context.getApplicationContext();
        this.e = i2;
        this.b = aVar;
        this.i = i2 == 1;
        f();
    }

    private void f() {
        this.f = new RelativeLayout(this.d);
        this.g = this.e == 1 ? new k(this.d) : new i(this.d);
        this.f.addView(this.g.a());
        this.g.a(new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.j.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (j.this.f9521a != null) {
                    j.this.f9521a.h(view, iArr);
                }
            }
        });
        this.g.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.f.j.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i, boolean z) {
                com.opos.cmn.an.f.a.a("ImageHalfScreenInterstitial", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (j.this.f9521a != null) {
                    j.this.f9521a.a(view, i, z);
                }
            }
        });
    }

    private boolean g() {
        return this.c == 2007;
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.f;
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        this.j = true;
        this.d = null;
        this.h = null;
        RelativeLayout relativeLayout = this.f;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        com.opos.mobad.template.e.c.a aVar = this.k;
        if (aVar != null) {
            aVar.j();
        }
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.c;
    }

    public static final com.opos.mobad.template.a a(Context context, int i, com.opos.mobad.d.a aVar) {
        return new j(context, i, 1, aVar);
    }

    public static final com.opos.mobad.template.a b(Context context, int i, com.opos.mobad.d.a aVar) {
        return new j(context, i, 0, aVar);
    }

    private void c(com.opos.mobad.template.d.b bVar) {
        List<com.opos.mobad.template.d.e> list = bVar.c;
        if (list != null) {
            this.b.a(list.get(0).f9414a, bVar.c.get(0).b, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.f.j.6
                @Override // com.opos.mobad.d.a.InterfaceC0732a
                public void a(int i, final Bitmap bitmap) {
                    if (j.this.d == null) {
                        return;
                    }
                    if (i != 0 && i != 1) {
                        if (j.this.f9521a != null) {
                            j.this.f9521a.c(i);
                        }
                    } else {
                        if (i == 1 && j.this.f9521a != null) {
                            j.this.f9521a.c(i);
                        }
                        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.f.j.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap2 = bitmap;
                                if (bitmap2 == null || bitmap2.isRecycled() || j.this.g == null) {
                                    return;
                                }
                                j.this.g.a(bitmap);
                            }
                        });
                    }
                }
            });
        }
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        com.opos.mobad.template.e.c.a aVar;
        if (this.j || (aVar = this.k) == null) {
            return;
        }
        aVar.i();
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        com.opos.mobad.template.e.c.a aVar;
        if (this.j || (aVar = this.k) == null) {
            return;
        }
        aVar.h();
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        if (!this.l) {
            com.opos.mobad.template.e.c.a aVarA = com.opos.mobad.template.e.a.i.a().a(this.d, e(), bVar.L);
            this.k = aVarA;
            if (aVarA == null) {
                return;
            }
            aVarA.a(new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.template.f.j.3
                @Override // com.opos.mobad.template.e.c.b
                public void a(int i, int[] iArr) {
                    if (j.this.f9521a != null) {
                        j.this.f9521a.a(i, iArr);
                    }
                }

                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (j.this.f9521a != null) {
                        j.this.f9521a.g(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(View view, int[] iArr) {
                    if (j.this.f9521a != null) {
                        j.this.f9521a.h(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.c
                public void a(int[] iArr) {
                    if (j.this.f9521a != null) {
                        j.this.f9521a.a(iArr);
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.d, 46.0f));
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.d, 78.0f);
            if (this.k.e() && this.k.c() != null) {
                layoutParams.addRule(14);
                layoutParams.addRule(12);
                this.f.addView(this.k.c(), layoutParams);
            }
            this.l = true;
        }
        com.opos.mobad.template.e.c.a aVar = this.k;
        if (aVar != null) {
            aVar.a(com.opos.mobad.template.e.b.a.a(bVar));
        }
    }

    public void a(ViewGroup viewGroup, final a.InterfaceC0778a interfaceC0778a, final com.opos.mobad.template.e.c.a aVar) {
        if (viewGroup == null || interfaceC0778a == null) {
            return;
        }
        final com.opos.mobad.d.e.a aVar2 = new com.opos.mobad.d.e.a(viewGroup.getContext());
        aVar2.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.f.j.4
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (z) {
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.f.j.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
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
        aVar2.a(new a.c() { // from class: com.opos.mobad.template.f.j.5
            @Override // com.opos.mobad.d.e.a.c
            public void a(final boolean z, final boolean z2) {
                com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.f.j.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
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
        this.f9521a = interfaceC0778a;
    }

    public void a(final com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.d.e eVar;
        if (this.b == null || bVar == null || (eVar = bVar.k) == null || TextUtils.isEmpty(eVar.f9414a)) {
            a(bVar, null);
            return;
        }
        com.opos.mobad.d.a aVar = this.b;
        com.opos.mobad.template.d.e eVar2 = bVar.k;
        aVar.a(eVar2.f9414a, eVar2.b, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.f.j.7
            @Override // com.opos.mobad.d.a.InterfaceC0732a
            public void a(int i, final Bitmap bitmap) {
                if (j.this.d == null) {
                    return;
                }
                if (i == 0 || i == 1) {
                    if (i == 1 && j.this.f9521a != null) {
                        j.this.f9521a.c(i);
                    }
                    com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.f.j.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2 = bitmap;
                            if (bitmap2 == null || bitmap2.isRecycled()) {
                                return;
                            }
                            AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                            j.this.a(bVar, bitmap);
                        }
                    });
                    return;
                }
                com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.f.j.7.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                        j.this.a(bVar, null);
                    }
                });
                if (j.this.f9521a != null) {
                    j.this.f9521a.c(i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.opos.mobad.template.d.b bVar, Bitmap bitmap) {
        d dVar = this.g;
        if (dVar != null) {
            dVar.a(bVar, bitmap);
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        a.InterfaceC0778a interfaceC0778a;
        d dVar;
        com.opos.mobad.template.d.b bVarA = fVar.a();
        if (bVarA == null) {
            com.opos.cmn.an.f.a.d("ImageHalfScreenInterstitial", "render with data null");
            a.InterfaceC0778a interfaceC0778a2 = this.f9521a;
            if (interfaceC0778a2 != null) {
                interfaceC0778a2.a(1);
                return;
            }
            return;
        }
        List<com.opos.mobad.template.d.e> list = bVarA.c;
        if (list == null || list.size() <= 0) {
            com.opos.cmn.an.f.a.d("ImageHalfScreenInterstitial", "render with imgList null");
            a.InterfaceC0778a interfaceC0778a3 = this.f9521a;
            if (interfaceC0778a3 != null) {
                interfaceC0778a3.a(1);
                return;
            }
            return;
        }
        c(bVarA);
        a(bVarA);
        if (g()) {
            b(bVarA);
        }
        a.InterfaceC0778a interfaceC0778a4 = this.f9521a;
        if (interfaceC0778a4 != null && (dVar = this.g) != null) {
            dVar.a(interfaceC0778a4);
        }
        if (this.h == null && (interfaceC0778a = this.f9521a) != null) {
            interfaceC0778a.f();
            a(this.f, this.f9521a, this.k);
        }
        this.h = bVarA;
    }
}
