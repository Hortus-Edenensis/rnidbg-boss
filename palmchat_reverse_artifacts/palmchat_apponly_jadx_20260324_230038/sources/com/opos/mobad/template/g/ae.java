package com.opos.mobad.template.g;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.a;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ae extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9665a;
    private int b;
    private RelativeLayout c;
    private View d;
    private int e;
    private View f;
    private ProgressBar g;
    private View h;
    private com.opos.mobad.d.d.a i;
    private String j;
    private boolean k;
    private com.opos.mobad.d.d.b l;
    private a.InterfaceC0778a m;
    private a n;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();

        void b();
    }

    private ae(Context context, int i, int i2, com.opos.mobad.d.d.a aVar) {
        super(context);
        this.j = "#4DFFFFFF";
        this.k = false;
        com.opos.mobad.d.d.b bVar = new com.opos.mobad.d.d.b() { // from class: com.opos.mobad.template.g.ae.3
            @Override // com.opos.mobad.d.d.b
            public void a(Map<String, String> map) {
                ae.this.f.setVisibility(4);
                ae.this.h.setVisibility(0);
                if (ae.this.m != null) {
                    ae.this.m.b(map);
                }
            }

            @Override // com.opos.mobad.d.d.b
            public void c() {
                com.opos.cmn.an.f.a.b("BlockVideoView", "onPrepare");
                if (ae.this.i == null) {
                    com.opos.cmn.an.f.a.b("BlockVideoView", "onPrepare mPlayer is null");
                } else if (ae.this.m != null) {
                    ae.this.m.d(0L, ae.this.i.c());
                }
            }

            @Override // com.opos.mobad.d.d.b
            public void d() {
                com.opos.cmn.an.f.a.b("BlockVideoView", "onStart");
                if (ae.this.i == null) {
                    com.opos.cmn.an.f.a.b("BlockVideoView", "onStart mPlayer is null");
                    return;
                }
                if (ae.this.n != null) {
                    ae.this.n.a();
                }
                ae.this.m.d(ae.this.i.d(), ae.this.i.c());
                ae.this.g.setProgress(0);
                ae.this.h.setVisibility(4);
                ae.this.k();
            }

            @Override // com.opos.mobad.d.d.b
            public void e() {
                com.opos.cmn.an.f.a.b("BlockVideoView", "onComplete");
                if (ae.this.i == null) {
                    com.opos.cmn.an.f.a.b("BlockVideoView", "onComplete mPlayer is null");
                    return;
                }
                ae.this.h.setVisibility(0);
                if (ae.this.m != null) {
                    ae.this.m.a(ae.this.i.d(), ae.this.i.c());
                }
                if (ae.this.n != null) {
                    ae.this.n.b();
                }
                if (ae.this.g != null) {
                    ae.this.g.setProgress(100);
                }
            }

            @Override // com.opos.mobad.d.d.b
            public void f() {
                com.opos.cmn.an.f.a.b("BlockVideoView", "onResume");
                if (ae.this.i == null) {
                    com.opos.cmn.an.f.a.b("BlockVideoView", "onResume mPlayer is null");
                    return;
                }
                ae.this.h.setVisibility(4);
                ae.this.k = false;
                ae.this.k();
                if (ae.this.m != null) {
                    ae.this.m.b(ae.this.i.d(), ae.this.i.c());
                }
            }

            @Override // com.opos.mobad.d.d.b
            public void g() {
                com.opos.cmn.an.f.a.b("BlockVideoView", "onPause");
                if (ae.this.i == null) {
                    com.opos.cmn.an.f.a.b("BlockVideoView", "onPause mPlayer is null");
                    return;
                }
                ae.this.h.setVisibility(0);
                if (ae.this.m == null || ae.this.i == null) {
                    return;
                }
                ae.this.m.c(ae.this.i.d(), ae.this.i.c());
            }

            @Override // com.opos.mobad.d.d.b
            public void h() {
                com.opos.cmn.an.f.a.b("BlockVideoView", "onBufferingStart");
                ae.this.l();
                ae.this.h.setVisibility(4);
            }

            @Override // com.opos.mobad.d.d.b
            public void i() {
                com.opos.cmn.an.f.a.b("BlockVideoView", "onBufferingEnd");
                ae.this.k();
            }

            @Override // com.opos.mobad.d.d.b
            public void j() {
            }
        };
        this.l = bVar;
        this.f9665a = i == 0 ? 256 : i;
        this.b = i2 == 0 ? 144 : i2;
        this.i = aVar;
        aVar.a(bVar);
        a(context);
    }

    private void j() {
        if (this.i == null) {
            com.opos.cmn.an.f.a.b("BlockVideoView", "mPlayer is null");
            return;
        }
        this.h.setVisibility(4);
        this.i.a(0L);
        this.i.e();
        a aVar = this.n;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.f.setVisibility(0);
    }

    public void f() {
        ProgressBar progressBar;
        if (this.i == null || (progressBar = this.g) == null) {
            return;
        }
        progressBar.setProgress(i());
        com.opos.cmn.an.f.a.b("BlockVideoView", "on progress" + this.g.getProgress());
    }

    public int g() {
        com.opos.mobad.d.d.a aVar = this.i;
        if (aVar == null) {
            return 0;
        }
        return (int) aVar.d();
    }

    public int h() {
        com.opos.mobad.d.d.a aVar = this.i;
        if (aVar == null) {
            return 0;
        }
        return (int) aVar.c();
    }

    public int i() {
        com.opos.mobad.d.d.a aVar = this.i;
        if (aVar == null || 0 == aVar.c()) {
            return 0;
        }
        return (int) Math.min(100L, Math.max(0L, (this.i.d() * 100) / this.i.c()));
    }

    public static ae a(Context context, int i, int i2, com.opos.mobad.d.d.a aVar) {
        return new ae(context, i, i2, aVar);
    }

    public void b() {
        com.opos.mobad.d.d.a aVar = this.i;
        if (aVar == null) {
            com.opos.cmn.an.f.a.b("BlockVideoView", "stop mPlayer is null");
            return;
        }
        try {
            int i = aVar.i();
            com.opos.mobad.d.d.a aVar2 = this.i;
            if (i == 3 || i == 1) {
                aVar2.g();
                this.h.setVisibility(4);
            } else if (i == 5) {
                j();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("BlockVideoView", "", (Throwable) e);
        }
    }

    public void c() {
        com.opos.mobad.d.d.a aVar = this.i;
        if (aVar != null) {
            aVar.f();
            this.i.h();
            this.i = null;
        }
    }

    public void d() {
        String str;
        com.opos.mobad.d.d.a aVar = this.i;
        if (aVar == null) {
            str = "mPlayer is null";
        } else {
            if (aVar.i() == 5) {
                return;
            }
            if (this.i.i() != 3 || !this.k) {
                this.i.g();
                return;
            }
            str = "resume but user pause";
        }
        com.opos.cmn.an.f.a.b("BlockVideoView", str);
    }

    public void e() {
        com.opos.mobad.d.d.a aVar = this.i;
        if (aVar != null) {
            aVar.f();
        }
    }

    public void a() {
        com.opos.mobad.d.d.a aVar = this.i;
        if (aVar == null) {
            com.opos.cmn.an.f.a.b("BlockVideoView", "stop mPlayer is null");
            return;
        }
        this.k = true;
        int i = aVar.i();
        com.opos.mobad.d.d.a aVar2 = this.i;
        if (i == 2) {
            aVar2.f();
        }
    }

    public void a(int i) {
        com.opos.mobad.d.d.a aVar = this.i;
        if (aVar == null) {
            return;
        }
        aVar.a(i == 1 ? 1.0f : 0.0f);
    }

    private void a(Context context) {
        setLayoutParams(new ViewGroup.LayoutParams(this.f9665a, this.b));
        this.e = View.generateViewId();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.c = relativeLayout;
        relativeLayout.setId(this.e);
        addView(this.c, new RelativeLayout.LayoutParams(this.f9665a, this.b));
        this.c.setBackgroundColor(-16777216);
        this.d = this.i.b();
        this.i.d(-16777216);
        this.d.setBackgroundColor(-16777216);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f9665a, this.b);
        layoutParams.addRule(13);
        this.c.addView(this.d, layoutParams);
        com.opos.mobad.template.cmn.baseview.d dVar = new com.opos.mobad.template.cmn.baseview.d(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(7, this.e);
        layoutParams2.addRule(5, this.e);
        layoutParams2.addRule(6, this.e);
        layoutParams2.addRule(8, this.e);
        this.c.addView(dVar, layoutParams2);
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.ae.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (ae.this.m != null) {
                    ae.this.m.f(view, iArr);
                }
            }
        };
        dVar.setOnTouchListener(pVar);
        dVar.setOnClickListener(pVar);
        dVar.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.ae.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i, boolean z) {
                com.opos.cmn.an.f.a.a("BlockVideoView", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (ae.this.m != null) {
                    ae.this.m.a(view, i, z);
                }
            }
        });
        this.f = new ProgressBar(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 20.0f), com.opos.cmn.an.h.f.a.a(context, 29.0f));
        layoutParams3.addRule(13);
        this.f.setVisibility(8);
        this.c.addView(this.f, layoutParams3);
        View view = new View(context);
        this.h = view;
        view.setBackground(context.getResources().getDrawable(R.drawable.opos_mobad_continue_bn));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 42.0f), com.opos.cmn.an.h.f.a.a(context, 42.0f));
        layoutParams4.addRule(13);
        this.h.setVisibility(0);
        this.c.addView(this.h, layoutParams4);
        ProgressBar progressBar = new ProgressBar(context);
        this.g = progressBar;
        progressBar.setId(View.generateViewId());
        com.opos.mobad.template.cmn.af.a(this.g, "mOnlyIndeterminate", new Boolean(false));
        this.g.setIndeterminate(false);
        this.g.setProgressDrawable(new ClipDrawable(new ColorDrawable(getResources().getColor(R.color.opos_mobad_video_progress_color)), 3, 1));
        this.g.setBackgroundColor(Color.parseColor(this.j));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(this.f9665a, com.opos.cmn.an.h.f.a.a(context, 2.0f));
        layoutParams5.addRule(12);
        this.g.setVisibility(0);
        this.c.addView(this.g, layoutParams5);
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        com.opos.cmn.an.f.a.b("BlockVideoView", "setListener " + interfaceC0778a);
        this.m = interfaceC0778a;
    }

    public void a(com.opos.mobad.template.d.c cVar) {
        com.opos.mobad.d.d.a aVar = this.i;
        if (aVar == null) {
            com.opos.cmn.an.f.a.b("BlockVideoView", "mPlayer is null");
        } else {
            aVar.a(cVar.N.f9414a, false);
            a(cVar.A);
        }
    }

    public void a(a aVar) {
        this.n = aVar;
    }
}
