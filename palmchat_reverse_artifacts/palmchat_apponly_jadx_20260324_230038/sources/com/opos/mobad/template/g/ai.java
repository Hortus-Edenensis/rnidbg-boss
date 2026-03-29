package com.opos.mobad.template.g;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.graphics.ColorUtils;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ai extends ag {
    private com.opos.mobad.d.d.a e;
    private View f;
    private ProgressBar g;
    private View h;
    private Handler i;
    private int j;
    private boolean l;
    private a m;
    private View n;
    private RelativeLayout o;
    private Runnable p;

    /* JADX INFO: renamed from: com.opos.mobad.template.g.ai$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9696a;

        static {
            int[] iArr = new int[com.opos.mobad.template.cmn.t.values().length];
            f9696a = iArr;
            try {
                iArr[com.opos.mobad.template.cmn.t.PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9696a[com.opos.mobad.template.cmn.t.RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9696a[com.opos.mobad.template.cmn.t.START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9696a[com.opos.mobad.template.cmn.t.COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9696a[com.opos.mobad.template.cmn.t.BUFFERINGSTART.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9696a[com.opos.mobad.template.cmn.t.BUFFERINGEND.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(long j, long j2);
    }

    public ai(Context context, int i, com.opos.mobad.d.a aVar, com.opos.mobad.d.d.a aVar2) {
        super(context, i, aVar, -1);
        this.p = new Runnable() { // from class: com.opos.mobad.template.g.ai.1
            @Override // java.lang.Runnable
            public void run() {
                if (ai.this.l) {
                    return;
                }
                if (ai.this.m != null) {
                    ai.this.m.a(ai.this.e.d(), ai.this.e.c());
                }
                ai.this.g.setProgress(ai.this.e());
                ai.this.i.postDelayed(this, 500L);
            }
        };
        this.i = new Handler(Looper.getMainLooper());
        this.e = aVar2;
        a(this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e() {
        if (0 == this.e.c()) {
            return 0;
        }
        return (int) Math.min(100L, Math.max(0L, (this.e.d() * 100) / this.e.c()));
    }

    @Override // com.opos.mobad.template.g.ag
    public void a(ViewGroup viewGroup) {
        if (viewGroup == null || this.e == null) {
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.b);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(-16777216);
        this.e.d(-16777216);
        e(relativeLayout);
        d(relativeLayout);
        c(relativeLayout);
        b(relativeLayout);
        a(relativeLayout);
        viewGroup.addView(relativeLayout);
    }

    @Override // com.opos.mobad.template.g.ag
    public ag b(com.opos.mobad.template.cmn.p pVar) {
        ViewGroup viewGroup = this.c;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(pVar);
            this.c.setOnTouchListener(pVar);
        }
        return super.b(pVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.i.removeCallbacks(this.p);
        this.l = true;
        super.onDetachedFromWindow();
    }

    private void a(RelativeLayout relativeLayout) {
        this.n = new ProgressBar(this.b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 20.0f), com.opos.cmn.an.h.f.a.a(this.b, 29.0f));
        layoutParams.addRule(13);
        this.n.setVisibility(0);
        relativeLayout.addView(this.n, layoutParams);
    }

    private void c(RelativeLayout relativeLayout) {
        View view = new View(this.b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.b, 17.0f));
        layoutParams.addRule(12);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{ColorUtils.setAlphaComponent(-16777216, 120), ColorUtils.setAlphaComponent(-16777216, 80), ColorUtils.setAlphaComponent(-16777216, 40), ColorUtils.setAlphaComponent(-16777216, 0)});
        gradientDrawable.setShape(0);
        view.setBackground(gradientDrawable);
        if (relativeLayout != null) {
            relativeLayout.addView(view, layoutParams);
        }
    }

    private void d(RelativeLayout relativeLayout) {
        View view = new View(this.b);
        this.h = view;
        view.setBackground(this.b.getResources().getDrawable(R.drawable.opos_mobad_continue_bn));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 48.0f), com.opos.cmn.an.h.f.a.a(this.b, 48.0f));
        layoutParams.addRule(13);
        this.h.setVisibility(4);
        if (relativeLayout != null) {
            relativeLayout.addView(this.h, layoutParams);
        }
    }

    private void f() {
        this.g.setProgress(0);
        this.g.setVisibility(0);
        this.h.setVisibility(4);
        this.o.setVisibility(0);
        this.n.setVisibility(8);
    }

    private void b(RelativeLayout relativeLayout) {
        ProgressBar progressBar = new ProgressBar(this.b);
        this.g = progressBar;
        progressBar.setId(View.generateViewId());
        com.opos.mobad.template.cmn.af.a(this.g, "mOnlyIndeterminate", new Boolean(false));
        this.g.setIndeterminate(false);
        this.g.setProgressDrawable(new ClipDrawable(new ColorDrawable(-1), 3, 1));
        this.g.setBackgroundColor(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.b, 2.0f));
        layoutParams.addRule(12);
        this.g.setVisibility(0);
        if (relativeLayout != null) {
            relativeLayout.addView(this.g, layoutParams);
        }
    }

    private void e(RelativeLayout relativeLayout) {
        com.opos.mobad.d.d.a aVar = this.e;
        if (aVar == null) {
            return;
        }
        this.f = aVar.b();
        int iGenerateViewId = View.generateViewId();
        this.j = iGenerateViewId;
        this.f.setId(iGenerateViewId);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.b);
        this.o = relativeLayout2;
        relativeLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View view = this.f;
        if (view != null) {
            this.o.addView(view, new ViewGroup.LayoutParams(-1, -1));
        }
        if (relativeLayout != null) {
            relativeLayout.addView(this.o);
        }
        this.o.setVisibility(4);
    }

    @Override // com.opos.mobad.template.g.ag
    public void a(com.opos.mobad.template.cmn.t tVar) {
        View view;
        switch (AnonymousClass2.f9696a[tVar.ordinal()]) {
            case 1:
                this.i.removeCallbacks(this.p);
                this.g.setVisibility(0);
                view = this.h;
                view.setVisibility(0);
                return;
            case 2:
                this.i.post(this.p);
                this.g.setVisibility(0);
                break;
            case 3:
                this.i.removeCallbacks(this.p);
                this.i.postDelayed(this.p, 500L);
                a.InterfaceC0778a interfaceC0778a = ((ag) this).f9671a;
                if (interfaceC0778a != null) {
                    interfaceC0778a.d(this.e.d(), this.e.c());
                }
                f();
                return;
            case 4:
                this.i.removeCallbacks(this.p);
                this.g.setVisibility(8);
                break;
            case 5:
                view = this.n;
                view.setVisibility(0);
                return;
            case 6:
                this.n.setVisibility(8);
                return;
            default:
                return;
        }
        this.h.setVisibility(4);
    }

    @Override // com.opos.mobad.template.g.ag
    public void a(a aVar) {
        this.m = aVar;
    }
}
