package com.bytedance.adsdk.ugeno.yoga.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.b;
import com.bytedance.adsdk.ugeno.fx.x;
import com.bytedance.adsdk.ugeno.iz.fx;
import com.bytedance.adsdk.ugeno.iz.n;
import com.bytedance.adsdk.ugeno.nr.u;
import com.bytedance.adsdk.ugeno.u;
import com.bytedance.adsdk.ugeno.widget.image.RoundImageView;
import com.bytedance.adsdk.ugeno.yoga.iz;
import com.bytedance.adsdk.ugeno.yoga.jk;
import com.bytedance.adsdk.ugeno.yoga.mv;
import com.bytedance.adsdk.ugeno.yoga.pn;
import com.bytedance.adsdk.ugeno.yoga.s;
import com.bytedance.adsdk.ugeno.yoga.widget.YogaLayout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u extends com.bytedance.adsdk.ugeno.nr.u<YogaLayout> {
    private com.bytedance.adsdk.ugeno.yoga.u gb;
    private jk gl;
    private s hs;
    private pn ki;
    private iz te;
    private com.bytedance.adsdk.ugeno.yoga.u ti;

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.yoga.widget.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0179u extends u.C0171u {
        private boolean bc;
        public int bf;
        public float d;
        public float gi;
        public int h;
        public int ja;

        /* JADX INFO: renamed from: jp, reason: collision with root package name */
        private boolean f5057jp;
        public float m;
        private boolean oa;
        public int pb;
        public float rh;
        private boolean w;
        public int wq;
        public int xg;
        private boolean xw;
        private boolean y;
        public int z;

        public C0179u(com.bytedance.adsdk.ugeno.nr.u uVar) {
            super(uVar);
            this.z = 1;
            this.gi = 0.0f;
            this.d = 1.0f;
            this.h = com.bytedance.adsdk.ugeno.yoga.u.AUTO.u();
            this.rh = -1.0f;
            this.ja = mv.RELATIVE.u();
        }

        private void b() {
            com.bytedance.adsdk.ugeno.nr.u uVar = this.kj;
            if (uVar instanceof u) {
                if (((u) uVar).eh() == pn.ROW && this.kj.wq() == -2 && this.u == -1.0f && !this.kj.w()) {
                    this.u = -2.0f;
                    this.d = 1.0f;
                    this.gi = 1.0f;
                    this.f5057jp = true;
                    this.rh = -1.0f;
                }
                if (((u) this.kj).eh() == pn.COLUMN && this.kj.pb() == -2 && this.nr == -1.0f && !this.kj.w()) {
                    this.nr = -2.0f;
                    this.d = 1.0f;
                    this.gi = 1.0f;
                    this.f5057jp = true;
                    this.rh = -1.0f;
                }
            }
        }

        public boolean fx() {
            float f = this.u;
            if (f == -1.0f && this.nr == -1.0f) {
                return false;
            }
            return f == -2.0f || this.nr == -2.0f;
        }

        @Override // com.bytedance.adsdk.ugeno.nr.u.C0171u
        /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
        public YogaLayout.u u() {
            b();
            YogaLayout.u uVar = new YogaLayout.u((int) this.u, (int) this.nr);
            uVar.l((int) (this.bq ? this.iz : this.pn));
            uVar.s((int) (this.dw ? this.x : this.pn));
            uVar.t((int) (this.c ? this.n : this.pn));
            uVar.mv((int) (this.q ? this.f5036a : this.pn));
            uVar.u(this.z);
            uVar.pn(this.h);
            uVar.nr(this.gi);
            uVar.fx(this.d);
            uVar.my(this.fx);
            uVar.o(this.b);
            if (this.f5057jp) {
                uVar.b(this.rh);
            }
            uVar.iz(this.ja);
            if (this.y) {
                uVar.x(this.bf);
            }
            if (this.bc) {
                uVar.a(this.wq);
            }
            if (this.xw) {
                uVar.n(this.pb);
            }
            if (this.oa) {
                uVar.jk(this.xg);
            }
            if (this.w && fx()) {
                float f = this.m;
                if (f > 0.0f) {
                    uVar.k(f);
                    uVar.fx(0.0f);
                    uVar.nr(0.0f);
                }
            }
            return uVar;
        }

        @Override // com.bytedance.adsdk.ugeno.nr.u.C0171u
        public String toString() {
            return "LayoutParams{mOrder=" + this.z + ", mFlexGrow=" + this.gi + ", mFlexShrink=" + this.d + ", mAlignSelf=" + this.h + ", mFlexBasis=" + this.rh + ", mPosition=" + this.ja + ", mTop=" + this.bf + ", mBottom=" + this.wq + ", mLeft=" + this.pb + ", mRight=" + this.xg + '}';
        }

        @Override // com.bytedance.adsdk.ugeno.nr.u.C0171u
        public void u(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            super.u(context, str, str2);
            str.hashCode();
            switch (str) {
                case "flexBasis":
                    this.f5057jp = true;
                    float fU = fx.u(str2, -1.0f);
                    this.rh = fU;
                    this.rh = n.u(context, fU);
                    break;
                case "bottom":
                    this.bc = true;
                    this.wq = (int) n.u(context, fx.u(str2, 0));
                    break;
                case "top":
                    this.y = true;
                    this.bf = (int) n.u(context, fx.u(str2, 0));
                    break;
                case "left":
                    this.xw = true;
                    this.pb = (int) n.u(context, fx.u(str2, 0));
                    break;
                case "order":
                    this.z = fx.u(str2, 1);
                    break;
                case "ratio":
                    this.w = true;
                    this.m = fx.u(str2, 0.0f);
                    break;
                case "right":
                    this.oa = true;
                    this.xg = (int) n.u(context, fx.u(str2, 0));
                    break;
                case "position":
                    this.ja = mv.u(str2).u();
                    break;
                case "flexShrink":
                    this.d = fx.u(str2, 1.0f);
                    break;
                case "flexGrow":
                    this.gi = fx.u(str2, 0.0f);
                    break;
                case "alignSelf":
                    this.h = com.bytedance.adsdk.ugeno.yoga.u.u(str2).u();
                    break;
            }
        }
    }

    public u(Context context) {
        super(context);
        this.ki = pn.ROW;
        this.hs = s.NO_WRAP;
        this.te = iz.FLEX_START;
        com.bytedance.adsdk.ugeno.yoga.u uVar = com.bytedance.adsdk.ugeno.yoga.u.STRETCH;
        this.ti = uVar;
        this.gb = uVar;
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    /* JADX INFO: renamed from: ay, reason: merged with bridge method [inline-methods] */
    public YogaLayout u() {
        YogaLayout yogaLayout = new YogaLayout(this.nr);
        yogaLayout.u(this);
        this.gl = yogaLayout.getYogaNode();
        return yogaLayout;
    }

    public pn eh() {
        return this.ki;
    }

    @Override // com.bytedance.adsdk.ugeno.nr.u
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public C0179u n() {
        return new C0179u(this);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void z() {
        ImageView.ScaleType scaleType;
        if (this.xw) {
            x xVar = this.dj;
            if (xVar != null) {
                xVar.u();
            }
            b.u().nr().u(this.f5034a, this.f5035jp, new u.InterfaceC0173u() { // from class: com.bytedance.adsdk.ugeno.yoga.widget.u.1
                @Override // com.bytedance.adsdk.ugeno.u.InterfaceC0173u
                public void u(Bitmap bitmap) {
                    if (bitmap == null) {
                        if (((com.bytedance.adsdk.ugeno.nr.fx) u.this).dj != null) {
                            x xVar2 = ((com.bytedance.adsdk.ugeno.nr.fx) u.this).dj;
                            u uVar = u.this;
                            xVar2.nr(uVar, ((com.bytedance.adsdk.ugeno.nr.fx) uVar).f5035jp);
                            return;
                        }
                        return;
                    }
                    if (((com.bytedance.adsdk.ugeno.nr.fx) u.this).dj != null) {
                        x xVar3 = ((com.bytedance.adsdk.ugeno.nr.fx) u.this).dj;
                        u uVar2 = u.this;
                        xVar3.u(uVar2, ((com.bytedance.adsdk.ugeno.nr.fx) uVar2).f5035jp);
                    }
                    final Bitmap bitmapU = n.u(((com.bytedance.adsdk.ugeno.nr.fx) u.this).nr, bitmap, (int) ((com.bytedance.adsdk.ugeno.nr.fx) u.this).bc);
                    if (bitmapU != null) {
                        n.u(new Runnable() { // from class: com.bytedance.adsdk.ugeno.yoga.widget.u.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                u.this.u(new BitmapDrawable(bitmapU));
                            }
                        });
                    }
                }
            });
            return;
        }
        x xVar2 = this.dj;
        if (xVar2 != null) {
            xVar2.u();
        }
        RoundImageView roundImageView = new RoundImageView(this.nr);
        b.u().nr().u(this.f5034a, this.f5035jp, roundImageView, this.pn.getWidth(), this.pn.getHeight(), new u.InterfaceC0173u() { // from class: com.bytedance.adsdk.ugeno.yoga.widget.u.2
            @Override // com.bytedance.adsdk.ugeno.u.InterfaceC0173u
            public void u(Bitmap bitmap) {
                if (bitmap == null) {
                    if (((com.bytedance.adsdk.ugeno.nr.fx) u.this).dj != null) {
                        x xVar3 = ((com.bytedance.adsdk.ugeno.nr.fx) u.this).dj;
                        u uVar = u.this;
                        xVar3.nr(uVar, ((com.bytedance.adsdk.ugeno.nr.fx) uVar).f5035jp);
                        return;
                    }
                    return;
                }
                if (((com.bytedance.adsdk.ugeno.nr.fx) u.this).dj != null) {
                    x xVar4 = ((com.bytedance.adsdk.ugeno.nr.fx) u.this).dj;
                    u uVar2 = u.this;
                    xVar4.u(uVar2, ((com.bytedance.adsdk.ugeno.nr.fx) uVar2).f5035jp);
                }
            }
        });
        if (!this.oa || (scaleType = this.y) == ImageView.ScaleType.FIT_XY) {
            roundImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            roundImageView.setScaleType(scaleType);
        }
        roundImageView.setCornerRadius(this.w);
        YogaLayout.u uVar = new YogaLayout.u(-1, -1);
        uVar.iz(mv.ABSOLUTE.u());
        T t = this.pn;
        if (t instanceof YogaLayout) {
            ((YogaLayout) t).addView(roundImageView, 0, uVar);
            u(roundImageView);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void l() {
        if (this.ja) {
            this.gl.nr(com.bytedance.adsdk.ugeno.yoga.b.ALL, this.z);
        }
        if (this.bf) {
            this.gl.nr(com.bytedance.adsdk.ugeno.yoga.b.LEFT, this.gi);
        }
        if (this.wq) {
            this.gl.nr(com.bytedance.adsdk.ugeno.yoga.b.RIGHT, this.d);
        }
        if (this.pb) {
            this.gl.nr(com.bytedance.adsdk.ugeno.yoga.b.TOP, this.h);
        }
        if (this.xg) {
            this.gl.nr(com.bytedance.adsdk.ugeno.yoga.b.BOTTOM, this.rh);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.nr.u, com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
        this.gl.u(this.ki);
        this.gl.u(this.hs);
        this.gl.u(this.te);
        this.gl.u(this.ti);
        this.gl.fx(this.gb);
        this.gl.u(true);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void u(Drawable drawable) {
        ImageView.ScaleType scaleType;
        RoundImageView roundImageView = new RoundImageView(this.nr);
        roundImageView.setImageDrawable(drawable);
        if (this.oa && (scaleType = this.y) != ImageView.ScaleType.FIT_XY) {
            roundImageView.setScaleType(scaleType);
        } else {
            roundImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        roundImageView.setCornerRadius(this.w);
        YogaLayout.u uVar = new YogaLayout.u(-1, -1);
        uVar.iz(mv.ABSOLUTE.u());
        T t = this.pn;
        if (t instanceof YogaLayout) {
            ((YogaLayout) t).addView(roundImageView, 0, uVar);
            u(roundImageView);
        }
    }

    private void u(final RoundImageView roundImageView) {
        this.pn.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.adsdk.ugeno.yoga.widget.u.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                jk jkVarU;
                if (((com.bytedance.adsdk.ugeno.nr.fx) u.this).pn == null || (jkVarU = ((YogaLayout) ((com.bytedance.adsdk.ugeno.nr.fx) u.this).pn).u(roundImageView)) == null) {
                    return;
                }
                int width = ((com.bytedance.adsdk.ugeno.nr.fx) u.this).pn.getWidth();
                jkVarU.b(width);
                int height = ((com.bytedance.adsdk.ugeno.nr.fx) u.this).pn.getHeight();
                jkVarU.iz(height);
                roundImageView.setCornerRadius(((com.bytedance.adsdk.ugeno.nr.fx) u.this).w);
                ((com.bytedance.adsdk.ugeno.nr.fx) u.this).pn.requestLayout();
                if (width > 0 || height > 0) {
                    ((com.bytedance.adsdk.ugeno.nr.fx) u.this).pn.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.nr.u
    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar) {
        super.u(fxVar);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.u
    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar, ViewGroup.LayoutParams layoutParams) {
        if (fxVar == null) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.nr.u) this).u.add(fxVar);
        View viewA = fxVar.a();
        if (viewA != null) {
            ((YogaLayout) this.pn).addView(viewA, layoutParams);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void u(String str, String str2) {
        super.u(str, str2);
        str.hashCode();
        switch (str) {
            case "alignItems":
                this.ti = com.bytedance.adsdk.ugeno.yoga.u.u(str2);
                break;
            case "flexDirection":
                this.ki = pn.u(str2);
                break;
            case "alignContent":
                this.gb = com.bytedance.adsdk.ugeno.yoga.u.u(str2);
                break;
            case "flexWrap":
                this.hs = s.u(str2);
                break;
            case "justifyContent":
                this.te = iz.u(str2);
                break;
        }
    }
}
