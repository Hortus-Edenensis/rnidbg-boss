package com.opos.mobad.template.e.c;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.cmn.ae;
import com.opos.mobad.template.cmn.baseview.f;
import com.opos.mobad.template.cmn.g;
import com.opos.mobad.template.cmn.w;
import com.opos.mobad.template.h;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class e extends a {
    private final View.OnTouchListener A;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private RelativeLayout i;
    private RelativeLayout j;
    private View k;
    private g l;
    private w m;
    private LinearLayout n;
    private b o;
    private TextView p;
    private TextView q;
    private Animator r;
    private AnimatorSet s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private boolean y;
    private double z;

    public e(Context context, com.opos.mobad.template.e.a aVar, boolean z) {
        super(context, aVar);
        this.u = false;
        this.z = com.opos.mobad.template.e.b.a.B;
        this.A = new View.OnTouchListener() { // from class: com.opos.mobad.template.e.c.e.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!e.this.t) {
                    return false;
                }
                float width = e.this.m.getWidth() / 2;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float fAbs = Math.abs(x - (e.this.m.getWidth() / 2));
                float fAbs2 = Math.abs(y - (e.this.m.getHeight() / 2));
                if ((fAbs * fAbs) + (fAbs2 * fAbs2) > width * width) {
                    return false;
                }
                if (motionEvent.getAction() == 0) {
                    e.this.w = (int) motionEvent.getX();
                    e.this.x = (int) motionEvent.getY();
                    e.this.v = false;
                    return true;
                }
                if (2 != motionEvent.getAction()) {
                    return true;
                }
                int y2 = (int) motionEvent.getY();
                int x2 = (int) motionEvent.getX();
                if ((Math.abs(e.this.w - x2) <= e.this.z && Math.abs(e.this.x - y2) <= e.this.z) || e.this.v) {
                    return true;
                }
                e.this.a(x2, y2);
                return true;
            }
        };
        this.y = z;
        k();
        a();
        b();
    }

    private void k() {
        int i;
        if (this.y) {
            this.c = MediaPlayer.MEDIA_PLAYER_OPTION_START_PLAY_BUFFER_THRES;
            this.d = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_GET_CACHE_TIMESTAMP;
            this.e = 228;
            this.f = 212;
            i = 80;
        } else {
            this.c = MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF;
            this.d = 240;
            this.e = 188;
            this.f = MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE;
            i = 71;
        }
        this.h = i;
        this.g = this.f / 2;
    }

    private void l() {
        this.s = new AnimatorSet();
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.k, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 1.08f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 1.08f, 1.0f));
        objectAnimatorOfPropertyValuesHolder.setDuration(1984L);
        objectAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
        objectAnimatorOfPropertyValuesHolder.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.m, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.976f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.976f, 1.0f));
        objectAnimatorOfPropertyValuesHolder2.setDuration(1984L);
        objectAnimatorOfPropertyValuesHolder2.setRepeatCount(-1);
        objectAnimatorOfPropertyValuesHolder2.setRepeatMode(1);
        this.s.playTogether(objectAnimatorOfPropertyValuesHolder, objectAnimatorOfPropertyValuesHolder2);
    }

    @Override // com.opos.mobad.template.e.c.a
    public View c() {
        return this.i;
    }

    @Override // com.opos.mobad.template.e.c.c
    public void g() {
        if (this.t && !this.u) {
            this.u = true;
            Animator animatorB = ae.b((View) this.i);
            this.r = animatorB;
            animatorB.addListener(new Animator.AnimatorListener() { // from class: com.opos.mobad.template.e.c.e.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.s.start();
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
            this.r.start();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void j() {
        if (this.t) {
            h.a(this.r);
            h.a(this.s);
            RelativeLayout relativeLayout = this.i;
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void b() {
        if (this.t) {
            RelativeLayout relativeLayout = new RelativeLayout(this.b);
            this.i = relativeLayout;
            relativeLayout.setVisibility(4);
            this.i.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            RelativeLayout relativeLayout2 = new RelativeLayout(this.b);
            this.j = relativeLayout2;
            relativeLayout2.setVisibility(4);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, this.c), com.opos.cmn.an.h.f.a.a(this.b, this.c));
            layoutParams.addRule(13);
            this.i.addView(this.j, layoutParams);
            View view = new View(this.b);
            this.k = view;
            view.setBackgroundResource(R.drawable.opos_mobad_four_arrows);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, this.d), com.opos.cmn.an.h.f.a.a(this.b, this.d));
            layoutParams2.addRule(13);
            this.j.addView(this.k, layoutParams2);
            w wVar = new w(this.b);
            this.m = wVar;
            wVar.a(com.opos.cmn.an.h.f.a.a(this.b, this.g));
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, this.f), com.opos.cmn.an.h.f.a.a(this.b, this.f));
            layoutParams3.addRule(13);
            this.m.setBackgroundColor(Color.argb(77, 0, 0, 0));
            this.j.addView(this.m, layoutParams3);
            this.m.setOnTouchListener(this.A);
            this.l = new g(this.b, new int[]{1308622847, 1308622847}, new float[]{1.0f, 1.0f}).a(com.opos.cmn.an.h.f.a.a(this.b, this.e)).b(com.opos.cmn.an.h.f.a.a(this.b, 1.0f)).a(Paint.Style.STROKE);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, this.e), com.opos.cmn.an.h.f.a.a(this.b, this.e));
            layoutParams4.addRule(13);
            this.j.addView(this.l, layoutParams4);
            LinearLayout linearLayout = new LinearLayout(this.b);
            this.n = linearLayout;
            linearLayout.setOrientation(1);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams5.addRule(13);
            layoutParams5.leftMargin = com.opos.cmn.an.h.f.a.a(this.b, this.h);
            layoutParams5.rightMargin = com.opos.cmn.an.h.f.a.a(this.b, this.h);
            this.j.addView(this.n, layoutParams5);
            TextView textView = new TextView(this.b);
            this.p = textView;
            textView.setTextSize(1, 16.0f);
            this.p.setText("任意方向滑动");
            this.p.setSingleLine();
            this.p.setLines(1);
            this.p.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams6.gravity = 17;
            this.p.setTextColor(-1);
            h.a(this.p);
            this.n.addView(this.p, layoutParams6);
            TextView textView2 = new TextView(this.b);
            this.q = textView2;
            textView2.setTextSize(1, 16.0f);
            this.q.setSingleLine();
            this.q.setLines(1);
            this.q.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams7.gravity = 17;
            this.q.setTextColor(-1);
            h.a(this.q);
            this.n.addView(this.q, layoutParams7);
            l();
            a(this.b);
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public boolean e() {
        return this.t;
    }

    @Override // com.opos.mobad.template.e.c.c
    public void h() {
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a() {
        this.t = h.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        int[] iArr = {this.w, this.x, i, i2};
        this.v = true;
        b bVar = this.o;
        if (bVar != null) {
            bVar.b(this.m, iArr);
        }
    }

    private void a(Context context) {
        final com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(context);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.e.c.e.3
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (z) {
                    if (e.this.j != null && e.this.j.getVisibility() != 0) {
                        e.this.j.setVisibility(0);
                    }
                    e.this.g();
                    aVar.a((a.InterfaceC0735a) null);
                }
            }
        });
        this.i.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(f fVar) {
        w wVar = this.m;
        if (wVar != null) {
            wVar.a(fVar);
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.b.a aVar) {
        TextView textView;
        if (this.t) {
            if (!TextUtils.isEmpty(aVar.b) && (textView = this.q) != null) {
                textView.setText(aVar.b);
            }
            if (aVar instanceof com.opos.mobad.template.e.b.f) {
                this.z = com.opos.cmn.an.h.f.a.a(this.b, ((com.opos.mobad.template.e.b.f) aVar).D);
            }
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(b bVar) {
        this.o = bVar;
    }

    @Override // com.opos.mobad.template.e.c.c
    public void i() {
    }
}
