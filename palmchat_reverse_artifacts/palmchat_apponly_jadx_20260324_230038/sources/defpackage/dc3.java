package defpackage;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.openalliance.ad.constant.bq;
import com.zenmen.openapi.webapp.WebAppManager;
import com.zenmen.openapi.webapp.floatview.MainFloatViewIdle;
import com.zenmen.openapi.webapp.floatview.MainFloatViewProc;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class dc3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MainFloatViewProc f17019a;
    public MainFloatViewIdle b;
    public fz4 c;
    public ViewGroup d;
    public Activity e;
    public ah f;
    public ViewGroup.LayoutParams g;
    public fa3 h = new c();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            dc3.this.i();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            dc3.this.g();
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements fa3 {
        public c() {
        }

        @Override // defpackage.fa3
        public void onEvent(int i, Object obj) {
            if (i != 1) {
                if (i == 2) {
                    dc3.this.f();
                }
            } else {
                Intent intentE = bu3.g().e(dc3.this.e, dc3.this.c.a("linkUrl"));
                if (intentE != null) {
                    dc3.this.e.startActivity(intentE);
                    f84.e(dc3.this.f, "click");
                }
                dc3.this.g();
            }
        }
    }

    public dc3(Activity activity) {
        this.e = activity;
    }

    public void f() {
        if (this.d != null) {
            MainFloatViewProc mainFloatViewProc = this.f17019a;
            if (mainFloatViewProc != null) {
                mainFloatViewProc.setVisibility(8);
            }
            MainFloatViewIdle mainFloatViewIdle = this.b;
            if (mainFloatViewIdle != null) {
                mainFloatViewIdle.setVisibility(8);
            }
        }
        WebAppManager.getInstance().setIdleAppInfo(null);
    }

    public final void g() {
        if (this.d == null) {
            this.d = (ViewGroup) this.e.findViewById(R.id.content);
        }
        MainFloatViewIdle mainFloatViewIdle = this.b;
        if (mainFloatViewIdle == null) {
            Point pointM = a46.m(this.e);
            this.b = new MainFloatViewIdle(this.e);
            this.g = new ViewGroup.LayoutParams(-2, -2);
            this.b.setTranslationX(pointM.x - a46.b(this.e, 48.0f));
            this.b.setTranslationY((pointM.y / 5) * 3);
            this.b.setOnClickListener(new a());
            this.d.addView(this.b, this.g);
        } else {
            mainFloatViewIdle.setVisibility(0);
        }
        MainFloatViewProc mainFloatViewProc = this.f17019a;
        if (mainFloatViewProc != null) {
            mainFloatViewProc.setVisibility(8);
        }
        this.b.setAppInfo(this.c);
    }

    public void h(fz4 fz4Var) {
        this.f = ah.c(fz4Var.a("appId"), "pop");
        this.c = fz4Var;
        g();
        f84.e(this.f, bq.b.V);
    }

    public final void i() {
        if (this.f17019a == null) {
            this.f17019a = new MainFloatViewProc(this.e);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.d.getWidth(), this.d.getHeight());
            this.f17019a.setEventCallback(this.h);
            this.f17019a.setOnTouchListener(new b());
            this.d.addView(this.f17019a, layoutParams);
        }
        MainFloatViewIdle mainFloatViewIdle = this.b;
        if (mainFloatViewIdle != null) {
            mainFloatViewIdle.setVisibility(8);
        }
        this.f17019a.setVisibility(0);
        this.f17019a.setAppInfo(this.c);
        this.f17019a.setPosition(this.b.getTranslationY());
    }
}
