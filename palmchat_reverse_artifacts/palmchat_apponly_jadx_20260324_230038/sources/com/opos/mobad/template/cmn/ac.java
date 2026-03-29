package com.opos.mobad.template.cmn;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.oplus.tblplayer.monitor.ErrorCode;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ac implements SensorEventListener {
    private int b;
    private a.InterfaceC0778a c;
    private Context d;
    private RelativeLayout e;
    private ImageView f;
    private TextView g;
    private k h;
    private x i;
    private Animator j;
    private Animator k;
    private SensorManager l;
    private int m;
    private boolean n;
    private boolean o;
    private float v;
    private float w;
    private float x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9354a = 4;
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;
    private int t = 1000;
    private int u = ErrorCode.REASON_DS_SCHEME;
    private long y = 0;
    private boolean z = false;

    public ac(Context context, int i, boolean z) {
        this.d = context;
        this.o = z;
        g();
        this.m = i;
        h();
        this.k = ae.e(this.f);
    }

    private void g() {
        Sensor defaultSensor;
        try {
            defaultSensor = ((SensorManager) this.d.getSystemService("sensor")).getDefaultSensor(1);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("ShakeView", "shake check", th);
            defaultSensor = null;
        }
        this.n = defaultSensor != null;
    }

    private void h() {
        if (this.n) {
            RelativeLayout relativeLayout = new RelativeLayout(this.d);
            this.e = relativeLayout;
            relativeLayout.setVisibility(4);
            this.e.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.e.setClipChildren(false);
            x xVar = new x(this.d);
            this.i = xVar;
            xVar.setVisibility(4);
            this.i.a(com.opos.cmn.an.h.f.a.a(this.d, 44.0f));
            this.i.setOrientation(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.d, 44.0f));
            layoutParams.addRule(13);
            this.i.setPadding(com.opos.cmn.an.h.f.a.a(this.d, 15.0f), 0, com.opos.cmn.an.h.f.a.a(this.d, 16.0f), 0);
            this.i.setBackgroundColor(Color.argb(138, 66, 70, 76));
            this.e.addView(this.i, layoutParams);
            this.f = new ImageView(this.d);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.d, 27.0f), com.opos.cmn.an.h.f.a.a(this.d, 27.0f));
            layoutParams2.gravity = 16;
            this.f.setImageResource(R.drawable.opos_mobad_icon_hand);
            this.f.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.i.addView(this.f, layoutParams2);
            TextView textView = new TextView(this.d);
            this.g = textView;
            textView.setTextSize(1, 18.0f);
            this.g.setText("摇一摇");
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(this.d, 9.0f);
            layoutParams3.gravity = 16;
            this.g.setTextColor(-1);
            com.opos.mobad.template.h.a(this.g);
            this.i.addView(this.g, layoutParams3);
            a(this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        x xVar = this.i;
        if (xVar == null || xVar.getWidth() <= 0) {
            return;
        }
        int width = this.i.getWidth();
        this.h = new k(this.d, this.o, width);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, com.opos.cmn.an.h.f.a.a(this.d, 44.0f));
        layoutParams.addRule(13);
        this.e.addView(this.h, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        x xVar = this.i;
        if (xVar == null || xVar.getWidth() <= 0) {
            return;
        }
        int width = this.i.getWidth() - com.opos.cmn.an.h.f.a.a(this.d, 1.0f);
        int height = this.i.getHeight() - com.opos.cmn.an.h.f.a.a(this.d, 1.0f);
        this.h = new k(this.d, this.o, width, height, this.b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.d, 1.0f) / 2;
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.d, 1.0f) / 2;
        this.e.addView(this.h, layoutParams);
    }

    private void k() {
        if (this.n) {
            SensorManager sensorManager = this.l;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
                this.l = null;
            }
            this.x = 0.0f;
            this.w = 0.0f;
            this.v = 0.0f;
            this.y = 0L;
        }
    }

    private void l() {
        if (this.n && this.l == null) {
            SensorManager sensorManager = (SensorManager) this.d.getSystemService("sensor");
            this.l = sensorManager;
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            if (defaultSensor == null) {
                return;
            }
            this.l.registerListener(this, defaultSensor, 1);
        }
    }

    public View b() {
        return this.e;
    }

    public void c() {
        if (this.n && !this.s) {
            this.s = true;
            Animator animatorB = ae.b((View) this.e);
            this.j = animatorB;
            animatorB.addListener(new Animator.AnimatorListener() { // from class: com.opos.mobad.template.cmn.ac.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ac.this.k.start();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            this.j.start();
        }
    }

    public void d() {
        k();
        k kVar = this.h;
        if (kVar != null) {
            kVar.a();
        }
    }

    public void e() {
        com.opos.cmn.an.f.a.b("ShakeView", "isEnd:" + this.p + " mIsViewVisible:" + this.r);
        if (this.p || !this.r) {
            return;
        }
        l();
        k kVar = this.h;
        if (kVar != null) {
            kVar.b();
        }
    }

    public void f() {
        if (this.n) {
            Animator animator = this.j;
            if (animator != null) {
                animator.end();
            }
            Animator animator2 = this.k;
            if (animator2 != null) {
                animator2.end();
            }
            k();
            RelativeLayout relativeLayout = this.e;
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        a(sensorEvent);
    }

    public void a(int i, int i2, String str) {
        if (i > 0) {
            this.t = i;
        }
        if (i2 > 0) {
            this.u = i2;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.g.setText("摇一摇" + str);
    }

    private void a(Context context) {
        com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(context);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.cmn.ac.3
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                ac.this.r = z;
                if (!z) {
                    ac.this.d();
                    return;
                }
                if (ac.this.i != null && ac.this.i.getVisibility() != 0) {
                    ac.this.i.setVisibility(0);
                    if (ac.this.q) {
                        ac.this.j();
                    } else {
                        ac.this.i();
                    }
                }
                ac.this.c();
                ac.this.e();
            }
        });
        this.e.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void b(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        this.v = fArr[0];
        this.w = fArr[1];
        this.x = fArr[2];
        this.y = SystemClock.elapsedRealtime();
    }

    private void a(SensorEvent sensorEvent) {
        float[] fArr;
        if (this.z || this.p || !this.r || sensorEvent == null || (fArr = sensorEvent.values) == null || fArr.length < 3) {
            return;
        }
        if (this.y <= 0) {
            b(sensorEvent);
            return;
        }
        double dSqrt = Math.sqrt(Math.pow(fArr[0] - this.v, 2.0d) + Math.pow(sensorEvent.values[1] - this.w, 2.0d) + Math.pow(sensorEvent.values[2] - this.x, 2.0d));
        float f = this.v;
        float f2 = this.w;
        float f3 = this.x;
        if (dSqrt * 1000.0d < this.u) {
            if (SystemClock.elapsedRealtime() - this.y >= this.t) {
                b(sensorEvent);
                return;
            }
            return;
        }
        this.z = true;
        a.InterfaceC0778a interfaceC0778a = this.c;
        if (interfaceC0778a != null) {
            if (this.m == 1) {
                float[] fArr2 = sensorEvent.values;
                interfaceC0778a.b(new int[]{(int) ((fArr2[0] - f) * 100.0f), (int) ((fArr2[1] - f2) * 100.0f), (int) ((fArr2[2] - f3) * 100.0f)});
            } else {
                float[] fArr3 = sensorEvent.values;
                interfaceC0778a.a(new int[]{(int) ((fArr3[0] - f) * 100.0f), (int) ((fArr3[1] - f2) * 100.0f), (int) ((fArr3[2] - f3) * 100.0f)});
            }
            com.opos.cmn.an.f.a.b("ShakeView", "xacc2:" + sensorEvent.values[0] + ",yacc2:" + sensorEvent.values[1] + ",zacc2:" + sensorEvent.values[2] + ",xacc1:" + f + ",yacc1:" + f2 + ",zacc1:" + f3);
        }
        d();
        k kVar = this.h;
        if (kVar != null) {
            kVar.c();
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.opos.mobad.template.cmn.ac.2
            @Override // java.lang.Runnable
            public void run() {
                ac.this.z = false;
                ac.this.e();
            }
        }, com.igexin.push.config.c.j);
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.c = interfaceC0778a;
    }

    public boolean a() {
        return this.n;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
