package com.opos.mobad.template.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ah extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RelativeLayout f9972a;
    private View b;
    private int c;
    private View d;
    private com.opos.mobad.d.d.a e;
    private boolean f;
    private com.opos.mobad.d.d.b g;
    private b h;

    private ah(Context context, com.opos.mobad.d.d.a aVar) {
        super(context);
        this.f = false;
        com.opos.mobad.d.d.b bVar = new com.opos.mobad.d.d.b() { // from class: com.opos.mobad.template.h.ah.3
            @Override // com.opos.mobad.d.d.b
            public void a(Map<String, String> map) {
                if (ah.this.h != null) {
                    ah.this.h.b(map);
                }
            }

            @Override // com.opos.mobad.d.d.b
            public void c() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onPrepare");
                if (ah.this.h != null) {
                    ah.this.h.f();
                }
            }

            @Override // com.opos.mobad.d.d.b
            public void d() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onStart");
                if (ah.this.h != null) {
                    ah.this.h.d(0L, ah.this.e != null ? ah.this.e.c() : 0L);
                }
                ah.this.h();
            }

            @Override // com.opos.mobad.d.d.b
            public void e() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onComplete");
                if (ah.this.e == null || ah.this.h == null) {
                    return;
                }
                ah.this.h.a(ah.this.e.c(), ah.this.e.c());
            }

            @Override // com.opos.mobad.d.d.b
            public void f() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onResume");
                ah.this.h();
                if (ah.this.h == null || ah.this.e == null) {
                    return;
                }
                ah.this.h.b(ah.this.e.d(), ah.this.e.c());
            }

            @Override // com.opos.mobad.d.d.b
            public void g() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onPause");
                if (ah.this.h == null || ah.this.e == null) {
                    return;
                }
                ah.this.h.c(ah.this.e.d(), ah.this.e.c());
            }

            @Override // com.opos.mobad.d.d.b
            public void h() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onBufferingStart");
                ah.this.i();
            }

            @Override // com.opos.mobad.d.d.b
            public void i() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onBufferingEnd");
                ah.this.h();
            }

            @Override // com.opos.mobad.d.d.b
            public void j() {
                if (ah.this.h != null) {
                    ah.this.h.a();
                }
            }
        };
        this.g = bVar;
        this.e = aVar;
        aVar.a(bVar);
        a(context);
    }

    public static ah a(Context context, com.opos.mobad.d.d.a aVar) {
        return new ah(context, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.d.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.d.setVisibility(0);
    }

    public com.opos.mobad.d.d.a b() {
        return this.e;
    }

    public void c() {
        if (this.e == null) {
            com.opos.cmn.an.f.a.b("RewardVideoView", "stop mPlayer is null");
        } else {
            e();
        }
    }

    public void d() {
        com.opos.mobad.d.d.a aVar = this.e;
        if (aVar != null) {
            aVar.f();
            this.e.h();
            this.e = null;
        }
    }

    public void e() {
        com.opos.mobad.d.d.a aVar = this.e;
        if (aVar == null) {
            com.opos.cmn.an.f.a.b("RewardVideoView", "mPlayer is null");
        } else if (aVar.i() != 5) {
            this.e.g();
        }
    }

    public int f() {
        com.opos.mobad.d.d.a aVar = this.e;
        if (aVar == null) {
            return 0;
        }
        try {
            return (int) aVar.d();
        } catch (Exception unused) {
            return 0;
        }
    }

    public int g() {
        com.opos.mobad.d.d.a aVar = this.e;
        if (aVar == null) {
            return 0;
        }
        try {
            return (int) aVar.c();
        } catch (Exception unused) {
            return 0;
        }
    }

    public void a() {
        com.opos.mobad.d.d.a aVar = this.e;
        if (aVar == null) {
            com.opos.cmn.an.f.a.b("RewardVideoView", "stop mPlayer is null");
            return;
        }
        this.f = true;
        int i = aVar.i();
        com.opos.mobad.d.d.a aVar2 = this.e;
        if (i == 2) {
            aVar2.f();
        }
    }

    public void a(int i) {
        com.opos.mobad.d.d.a aVar = this.e;
        if (aVar == null) {
            return;
        }
        aVar.a(i == 1 ? 1.0f : 0.0f);
    }

    private void a(Context context) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.c = View.generateViewId();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.f9972a = relativeLayout;
        relativeLayout.setId(this.c);
        addView(this.f9972a, new RelativeLayout.LayoutParams(-1, -1));
        this.b = this.e.b();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.f9972a.addView(this.b, layoutParams);
        com.opos.mobad.template.cmn.baseview.d dVar = new com.opos.mobad.template.cmn.baseview.d(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(7, this.c);
        layoutParams2.addRule(5, this.c);
        layoutParams2.addRule(6, this.c);
        layoutParams2.addRule(8, this.c);
        this.f9972a.addView(dVar, layoutParams2);
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.ah.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (ah.this.h != null) {
                    ah.this.h.f(view, iArr);
                }
            }
        };
        dVar.setOnTouchListener(pVar);
        dVar.setOnClickListener(pVar);
        dVar.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.h.ah.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i, boolean z) {
                com.opos.cmn.an.f.a.a("RewardVideoView", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (ah.this.h != null) {
                    ah.this.h.a(view, i, z);
                }
            }
        });
        this.d = new ProgressBar(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 20.0f), com.opos.cmn.an.h.f.a.a(context, 29.0f));
        layoutParams3.addRule(13);
        this.d.setVisibility(0);
        this.f9972a.addView(this.d, layoutParams3);
    }

    public void a(com.opos.mobad.template.d.c cVar) {
        com.opos.mobad.d.d.a aVar = this.e;
        if (aVar == null) {
            com.opos.cmn.an.f.a.b("RewardVideoView", "mPlayer is null");
        } else {
            aVar.a(cVar.N.f9414a, false);
            a(cVar.A);
        }
    }

    public void a(b bVar) {
        com.opos.cmn.an.f.a.b("RewardVideoView", "setListener " + bVar);
        this.h = bVar;
    }
}
