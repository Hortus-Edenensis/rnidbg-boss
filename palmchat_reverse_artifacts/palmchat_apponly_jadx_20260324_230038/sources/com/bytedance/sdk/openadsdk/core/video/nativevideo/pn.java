package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.b.nr;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.component.utils.rh;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.widget.k;
import com.bytedance.sdk.openadsdk.core.widget.s;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends iz {
    private TextView ay;
    private TextView bc;
    private View cj;
    private final View.OnTouchListener dc;
    private final Rect df;
    private float dj;
    private final rh eh;
    private float ex;
    private int f;
    private int gc;
    private final Rect ge;
    private boolean hs;
    private float i;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private ImageView f5393jp;
    private boolean ju;
    private int jw;
    private boolean ki;
    private int kw;
    private boolean lf;
    private TextView m;
    private SeekBar mh;
    private int mk;
    private boolean nb;
    private TextView oa;
    private int ob;
    private int p;
    private final Rect qe;
    private boolean rg;
    private float rv;
    private ColorStateList sf;
    private View su;
    private ImageView tk;
    private ColorStateList tm;
    private ColorStateList tr;
    private float ua;
    private s uq;
    private ImageView v;
    private ImageView w;
    private TextView wi;
    private TextView xw;
    private View y;
    private TextView yd;
    private final Rect za;
    private final Rect zq;
    private int zx;

    public pn(Context context, View view, boolean z, EnumSet<nr.u> enumSet, bc bcVar, com.bykv.vk.openvk.component.video.api.b.fx fxVar, boolean z2) {
        super(context, view, z, enumSet, bcVar, fxVar, z2, null);
        this.eh = new rh(Looper.getMainLooper(), this);
        this.lf = false;
        this.nb = false;
        this.gc = 0;
        this.mk = 0;
        this.p = 0;
        this.kw = 0;
        this.f = 0;
        this.za = new Rect();
        this.ge = new Rect();
        this.ob = 0;
        this.zx = 0;
        this.jw = 0;
        this.uq = null;
        this.rg = false;
        this.dc = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.pn.7
            private float nr;

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                float x = motionEvent.getX();
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked != 0) {
                    if (actionMasked == 1) {
                        pn.this.rg = Math.abs(this.nr - motionEvent.getX()) < 10.0f;
                    } else if (actionMasked == 2) {
                        view2.getParent().requestDisallowInterceptTouchEvent(true);
                    } else if (actionMasked == 3) {
                        view2.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                } else {
                    this.nr = x;
                }
                return false;
            }
        };
        this.qe = new Rect();
        this.df = new Rect();
        this.zq = new Rect();
        this.z = dw.getContext().getApplicationContext();
        b(z2);
        this.u = view;
        this.dw = z;
        s sVar = new s(this);
        this.uq = sVar;
        sVar.u(this.dw);
        DisplayMetrics displayMetrics = this.z.getResources().getDisplayMetrics();
        this.zx = displayMetrics.widthPixels;
        this.jw = displayMetrics.heightPixels;
        this.qq = enumSet == null ? EnumSet.noneOf(nr.u.class) : enumSet;
        this.ja = fxVar;
        this.kj = bcVar;
        b(8);
        u(context, this.u, bcVar);
        b();
        my();
    }

    private void h() {
        DisplayMetrics displayMetrics = this.z.getResources().getDisplayMetrics();
        TextView textView = this.ay;
        if (textView != null) {
            this.ua = textView.getTextSize();
            this.ay.setTextSize(2, 14.0f);
            ColorStateList textColors = this.ay.getTextColors();
            this.sf = textColors;
            if (textColors != null) {
                this.ay.setTextColor(q.a(this.z, "tt_ssxinzi15"));
            }
            this.i = this.ay.getAlpha();
            this.ay.setAlpha(0.85f);
            this.ay.setShadowLayer(0.0f, y.fx(this.z, 0.5f), y.fx(this.z, 0.5f), q.a(this.z, "tt_video_shaoow_color_fullscreen"));
            ViewGroup.LayoutParams layoutParams = this.ay.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.qe.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                y.nr(this.ay, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.qe.top, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.qe.bottom);
            }
        }
        TextView textView2 = this.yd;
        if (textView2 != null) {
            this.dj = textView2.getTextSize();
            this.yd.setTextSize(2, 14.0f);
            ColorStateList textColors2 = this.yd.getTextColors();
            this.tr = textColors2;
            if (textColors2 != null) {
                this.yd.setTextColor(q.a(this.z, "tt_ssxinzi15"));
            }
            this.ex = this.yd.getAlpha();
            this.yd.setAlpha(0.85f);
            this.yd.setShadowLayer(0.0f, y.fx(this.z, 0.5f), y.fx(this.z, 0.5f), q.a(this.z, "tt_video_shaoow_color_fullscreen"));
            ViewGroup.LayoutParams layoutParams2 = this.yd.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                this.df.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                TextView textView3 = this.yd;
                int iApplyDimension = (int) TypedValue.applyDimension(1, 14.0f, displayMetrics);
                Rect rect = this.df;
                y.nr(textView3, iApplyDimension, rect.top, rect.right, rect.bottom);
            }
        }
        ImageView imageView = this.v;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                this.zq.set(marginLayoutParams3.leftMargin, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin, marginLayoutParams3.bottomMargin);
                ImageView imageView2 = this.v;
                Rect rect2 = this.zq;
                y.nr(imageView2, rect2.left, rect2.top, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.zq.bottom);
            }
        }
        ImageView imageView3 = this.v;
        if (imageView3 != null) {
            q.u(this.z, "tt_shrink_fullscreen", imageView3);
        }
        TextView textView4 = this.xw;
        if (textView4 != null) {
            ColorStateList textColors3 = textView4.getTextColors();
            this.tm = textColors3;
            if (textColors3 != null) {
                this.xw.setTextColor(q.a(this.z, "tt_ssxinzi15"));
            }
            this.rv = this.xw.getAlpha();
            this.xw.setAlpha(0.85f);
            ViewGroup.LayoutParams layoutParams4 = this.xw.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                this.ge.set(marginLayoutParams4.leftMargin, marginLayoutParams4.topMargin, marginLayoutParams4.rightMargin, marginLayoutParams4.bottomMargin);
                TextView textView5 = this.xw;
                int iApplyDimension2 = (int) TypedValue.applyDimension(1, 1.0f, displayMetrics);
                Rect rect3 = this.df;
                y.nr(textView5, iApplyDimension2, rect3.top, rect3.right, rect3.bottom);
            }
        }
        View view = this.y;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
            this.ob = layoutParams5.height;
            layoutParams5.height = (int) TypedValue.applyDimension(1, 49.0f, displayMetrics);
            this.y.setLayoutParams(layoutParams5);
            q.u(this.z, "tt_shadow_fullscreen_top", this.y);
        }
        nr(this.ju, true);
    }

    private boolean ja() {
        bc bcVar = this.kj;
        if (bcVar == null) {
            return false;
        }
        int iP = bcVar.p();
        return iP == 1 || iP == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ShapeDrawable nr(int i, String str) {
        Context context = dw.getContext();
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(Color.parseColor("#FFFFFFFF"));
        int iFx = y.fx(context, i);
        shapeDrawable.setIntrinsicWidth(iFx);
        shapeDrawable.setIntrinsicHeight(iFx);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(y.fx(context, 1.0f));
        paint.setColor(Color.parseColor(str));
        return shapeDrawable;
    }

    private void rh() {
        TextView textView = this.ay;
        if (textView != null) {
            textView.setTextSize(0, this.ua);
            ColorStateList colorStateList = this.sf;
            if (colorStateList != null) {
                this.ay.setTextColor(colorStateList);
            }
            this.ay.setAlpha(this.i);
            this.ay.setShadowLayer(y.fx(this.z, 1.0f), 0.0f, 0.0f, q.a(this.z, "tt_video_shadow_color"));
            TextView textView2 = this.ay;
            Rect rect = this.qe;
            y.nr(textView2, rect.left, rect.top, rect.right, rect.bottom);
        }
        TextView textView3 = this.yd;
        if (textView3 != null) {
            textView3.setTextSize(0, this.dj);
            ColorStateList colorStateList2 = this.tr;
            if (colorStateList2 != null) {
                this.yd.setTextColor(colorStateList2);
            }
            this.yd.setAlpha(this.ex);
            this.yd.setShadowLayer(y.fx(this.z, 1.0f), 0.0f, 0.0f, q.a(this.z, "tt_video_shadow_color"));
            TextView textView4 = this.yd;
            Rect rect2 = this.df;
            y.nr(textView4, rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
        ImageView imageView = this.v;
        if (imageView != null) {
            Rect rect3 = this.zq;
            y.nr(imageView, rect3.left, rect3.top, rect3.right, rect3.bottom);
        }
        ImageView imageView2 = this.v;
        if (imageView2 != null) {
            q.u(this.z, "tt_enlarge_video", imageView2);
        }
        TextView textView5 = this.xw;
        if (textView5 != null) {
            ColorStateList colorStateList3 = this.tm;
            if (colorStateList3 != null) {
                textView5.setTextColor(colorStateList3);
            }
            this.xw.setAlpha(this.rv);
            TextView textView6 = this.xw;
            Rect rect4 = this.df;
            y.nr(textView6, rect4.left, rect4.top, rect4.right, rect4.bottom);
        }
        View view = this.y;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.ob;
            this.y.setLayoutParams(layoutParams);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            gradientDrawable.setColors(new int[]{Color.parseColor("#FF1A1A1A"), Color.parseColor("#00000000")});
            this.y.setBackground(gradientDrawable);
        }
        nr(this.ju, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz
    public void a() {
        this.mh.setProgress(0);
        this.mh.setSecondaryProgress(0);
        this.k.setProgress(0);
        this.k.setSecondaryProgress(0);
        this.yd.setText(q.u(this.z, "tt_00_00"));
        this.ay.setText(q.u(this.z, "tt_00_00"));
        b(8);
        if (d()) {
            this.nr.setVisibility(8);
        }
        ImageView imageView = this.iz;
        if (imageView != null) {
            imageView.setImageDrawable(null);
            this.iz.setBackground(null);
        }
        b(8);
        y.u(this.su, 8);
        y.u(this.n, 8);
        y.u((View) this.f5391a, 8);
        y.u(this.jk, 8);
        y.u((View) this.t, 8);
        y.u((View) this.l, 8);
        y.u((View) this.mv, 8);
        k kVar = this.gi;
        if (kVar != null) {
            kVar.u(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz
    public void b() {
        super.b();
        this.uq.u(this.u);
        y.u((View) this.f5393jp, (this.dw || this.qq.contains(nr.u.hideCloseBtn)) ? 8 : 0);
        this.f5393jp.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.pn.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (pn.this.dw()) {
                    pn pnVar = pn.this;
                    pnVar.d.fx(pnVar, view);
                }
            }
        });
        y.u((View) this.m, (!this.dw || this.qq.contains(nr.u.alwayShowBackBtn)) ? 0 : 8);
        this.m.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.pn.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (pn.this.dw()) {
                    pn pnVar = pn.this;
                    pnVar.d.b(pnVar, view);
                }
            }
        });
        this.w.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.pn.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (pn.this.dw()) {
                    pn pnVar = pn.this;
                    pnVar.d.pn(pnVar, view);
                }
            }
        });
        this.tk.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.pn.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                pn.this.nr(false, true);
                pn.this.n();
                pn.this.x();
                pn.this.dw();
            }
        });
        this.v.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.pn.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (pn.this.dw()) {
                    pn pnVar = pn.this;
                    pnVar.d.nr(pnVar, view);
                }
            }
        });
        this.mh.setThumbOffset(0);
        this.mh.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.pn.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (pn.this.dw()) {
                    pn pnVar = pn.this;
                    pnVar.d.u(pnVar, i, z);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (!pn.this.lf && pn.this.z != null) {
                    seekBar.setThumb(pn.nr(22, "#1E000000"));
                }
                if (pn.this.dw()) {
                    seekBar.setThumbOffset(0);
                    pn pnVar = pn.this;
                    pnVar.d.nr(pnVar, seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (!pn.this.lf && pn.this.z != null) {
                    seekBar.setThumb(pn.nr(15, "#1E000000"));
                }
                if (pn.this.dw()) {
                    seekBar.setThumbOffset(0);
                    pn pnVar = pn.this;
                    pnVar.d.u(pnVar, seekBar.getProgress());
                }
            }
        });
        this.mh.setOnTouchListener(this.dc);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz
    public boolean fx(int i) {
        SeekBar seekBar = this.mh;
        return seekBar != null && i > seekBar.getSecondaryProgress();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz
    public void iz() {
        this.eh.removeMessages(1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz, com.bytedance.sdk.openadsdk.core.widget.k.nr
    public boolean jk() {
        return this.lf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz, com.bytedance.sdk.openadsdk.core.widget.s.u
    public boolean k() {
        k kVar = this.gi;
        return kVar != null && kVar.u();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz, com.bytedance.sdk.openadsdk.core.widget.k.nr
    public void l() {
        u(true, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz
    public boolean mv() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz
    public void n() {
        y.pn(this.b);
        y.pn(this.cj);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz
    public void pn() {
        this.eh.removeMessages(1);
        this.eh.sendMessageDelayed(this.eh.obtainMessage(1), 2000L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz, com.bytedance.sdk.openadsdk.core.widget.s.u
    public void s() {
        l();
        fx(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz
    public boolean t() {
        return this.dw;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz
    public void x() {
        bc bcVar;
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.kj)) {
            c();
            return;
        }
        y.iz(this.b);
        y.iz(this.pn);
        y.pn(this.cj);
        if (this.iz != null && (bcVar = this.kj) != null && !TextUtils.isEmpty(zx.nr(bcVar))) {
            y.iz(this.iz);
            com.bytedance.sdk.openadsdk.n.nr.u(zx.nr(this.kj)).to(this.iz);
            u(this.iz, zx.nr(this.kj));
        }
        if (this.fx.getVisibility() == 0) {
            y.u((View) this.fx, 8);
        }
    }

    private void iz(boolean z) {
        if (z) {
            h();
        } else {
            rh();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz
    public void fx(boolean z) {
        TextView textView = this.bc;
        if (textView != null) {
            y.u((View) textView, (!this.dw && z) ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz, com.bykv.vk.openvk.component.video.api.b.nr
    @SuppressLint({"ClickableViewAccessibility"})
    public /* bridge */ /* synthetic */ void u(bc bcVar, WeakReference weakReference, boolean z) {
        u(bcVar, (WeakReference<Context>) weakReference, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz
    public void u(Context context, View view, bc bcVar) {
        super.u(context, view, bcVar);
        this.m = (TextView) view.findViewById(2114387759);
        this.f5393jp = (ImageView) view.findViewById(2114387678);
        this.y = view.findViewById(2114387605);
        this.w = (ImageView) view.findViewById(2114387897);
        this.bc = (TextView) view.findViewById(2114387730);
        this.xw = (TextView) view.findViewById(2114387706);
        this.oa = (TextView) view.findViewById(2114387846);
        this.cj = view.findViewById(2114387823);
        this.tk = (ImageView) view.findViewById(2114387618);
        this.wi = (TextView) view.findViewById(2114387860);
        this.mh = (SeekBar) view.findViewById(2114387872);
        this.yd = (TextView) view.findViewById(2114387668);
        this.ay = (TextView) view.findViewById(2114387811);
        this.su = view.findViewById(2114387628);
        this.v = (ImageView) view.findViewById(2114387661);
        this.x = (TTViewStub) view.findViewById(2114387744);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz
    public void nr(boolean z) {
        int i = jk() ? this.jw : this.o;
        int dimensionPixelSize = jk() ? this.zx : this.sx;
        if (this.bq <= 0 || this.bg <= 0 || i <= 0) {
            return;
        }
        if (!t() && !jk() && !this.qq.contains(nr.u.fixedSize)) {
            dimensionPixelSize = this.z.getResources().getDimensionPixelSize(q.n(this.z, "tt_video_container_maxheight"));
        }
        int i2 = this.bg;
        int i3 = this.bq;
        int i4 = (int) (i3 * ((i * 1.0f) / i2));
        if (i4 > dimensionPixelSize) {
            i = (int) (i2 * ((dimensionPixelSize * 1.0f) / i3));
        } else {
            dimensionPixelSize = i4;
        }
        if (!z && !jk()) {
            i = this.o;
            dimensionPixelSize = this.sx;
        }
        this.nr.u(i, dimensionPixelSize);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz
    public void b(int i) {
        this.q = i;
        y.u(this.u, i);
        if (i != 0) {
            this.hs = false;
        } else if (this.ki) {
            this.hs = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz
    public void nr(int i) {
        View view = this.su;
        if (view != null && view.getVisibility() == 0) {
            y.u((View) this.k, 8);
            return;
        }
        y.u((View) this.k, 0);
        this.mh.setProgress(i);
        this.k.setProgress(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz
    public void u(String str) {
        TextView textView = this.bc;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.xw;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz
    public void u(long j, long j2) {
        this.yd.setText(com.bykv.vk.openvk.component.video.u.pn.u.u(j2));
        this.ay.setText(com.bykv.vk.openvk.component.video.u.pn.u.u(j));
        this.mh.setProgress(com.bykv.vk.openvk.component.video.u.pn.u.u(j, j2));
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz
    public void nr(ViewGroup viewGroup) {
        View view;
        com.bytedance.sdk.component.utils.k.nr("FullScreen", "Detail exitFullScreen.....");
        if (viewGroup == null || (view = this.u) == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        this.lf = false;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.u.getLayoutParams();
        marginLayoutParams.width = this.p;
        marginLayoutParams.height = this.kw;
        marginLayoutParams.leftMargin = this.mk;
        marginLayoutParams.topMargin = this.gc;
        this.u.setLayoutParams(marginLayoutParams);
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(3, this.f);
            viewGroup.setLayoutParams(layoutParams2);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            Rect rect = this.za;
            y.nr(viewGroup, rect.left, rect.top, rect.right, rect.bottom);
        }
        nr(true);
        q.u(this.z, "tt_enlarge_video", this.v);
        this.mh.setThumb(nr(15, "#1E000000"));
        this.mh.setThumbOffset(0);
        com.bykv.vk.openvk.component.video.u.pn.u.u(this.u, true);
        iz(this.lf);
        y.u(this.y, 8);
        if (this.qq.contains(nr.u.alwayShowBackBtn)) {
            y.u((View) this.m, 0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz, com.bykv.vk.openvk.component.video.api.b.nr
    public void u() {
        u(false, this.dw);
        kj();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz
    public void u(long j) {
        this.ay.setText(com.bykv.vk.openvk.component.video.u.pn.u.u(j));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz
    @SuppressLint({"ClickableViewAccessibility"})
    public void u(bc bcVar, WeakReference<Context> weakReference, boolean z) {
        bc bcVar2;
        if (bcVar == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(bcVar)) {
            u(dw.getContext(), this.u);
            sx();
            return;
        }
        u(this.u, dw.getContext());
        u(false, this.dw);
        y.u(this.n, 0);
        y.u((View) this.f5391a, 0);
        y.u(this.jk, 0);
        if (this.f5391a != null && (bcVar2 = this.kj) != null && !TextUtils.isEmpty(zx.nr(bcVar2))) {
            com.bytedance.sdk.openadsdk.n.nr.u(zx.nr(this.kj)).to(this.f5391a);
            u(this.f5391a, zx.nr(this.kj));
        }
        y.u((View) this.s, 0);
        y.u((View) this.t, 8);
        y.u((View) this.l, 8);
        y.u((View) this.mv, 8);
        y.u(this.s, q.u(this.z, "tt_video_dial_replay"));
        y.u(this.s, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.pn.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                nr nrVar = pn.this.d;
                if (nrVar != null) {
                    nrVar.u();
                }
            }
        }, "video_ad_button");
        y.u(this.s, (View.OnTouchListener) null, "video_ad_button");
        if (ja()) {
            y.u(this.jk, 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz
    public void u(ViewGroup viewGroup) {
        if (viewGroup != null && (this.u.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            this.lf = true;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.u.getLayoutParams();
            this.mk = marginLayoutParams.leftMargin;
            this.gc = marginLayoutParams.topMargin;
            this.p = marginLayoutParams.width;
            this.kw = marginLayoutParams.height;
            marginLayoutParams.width = -1;
            marginLayoutParams.height = -1;
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.leftMargin = 0;
            this.u.setLayoutParams(marginLayoutParams);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                int[] rules = layoutParams2.getRules();
                this.f = rules.length > 0 ? rules[3] : 0;
                layoutParams2.addRule(3, 0);
                viewGroup.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                this.za.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                y.nr(viewGroup, 0, 0, 0, 0);
            }
            nr(true);
            q.u(this.z, "tt_shrink_video", this.v);
            this.mh.setThumb(nr(18, "#00000000"));
            this.mh.setThumbOffset(0);
            com.bykv.vk.openvk.component.video.u.pn.u.u(this.u, false);
            iz(this.lf);
            y.u(this.y, 8);
            if (!this.dw) {
                y.u((View) this.f5393jp, 8);
                y.u((View) this.m, 8);
            } else if (this.qq.contains(nr.u.hideCloseBtn)) {
                y.u((View) this.f5393jp, 8);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz, com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        if (message.what != 1) {
            return;
        }
        l();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz
    public void u(boolean z, boolean z2, boolean z3) {
        y.u(this.su, 0);
        y.u((View) this.k, 0);
        if (this.lf) {
            y.u(this.y, 0);
            y.u((View) this.xw, 0);
        } else if (z3) {
            y.u(this.y, 8);
        }
        y.u((View) this.fx, (!z || this.b.getVisibility() == 0) ? 8 : 0);
        if (!this.dw && !this.lf) {
            if (!this.qq.contains(nr.u.hideCloseBtn) && !z3) {
                y.u((View) this.f5393jp, 0);
            }
            y.u((View) this.m, z3 ? 8 : 0);
        }
        y.u((View) this.yd, 0);
        y.u((View) this.ay, 0);
        if (ja()) {
            y.u((View) this.mh, 8);
        } else {
            y.u((View) this.mh, 0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz
    public void u(boolean z, boolean z2) {
        y.u(this.su, 8);
        y.u(this.y, 8);
        y.u((View) this.k, z ? 0 : 8);
        y.u((View) this.fx, 8);
        if (!this.dw && !this.lf) {
            y.u((View) this.f5393jp, 8);
            if (!this.qq.contains(nr.u.alwayShowBackBtn)) {
                y.u((View) this.m, 8);
            }
        } else if (this.qq.contains(nr.u.hideCloseBtn)) {
            y.u((View) this.f5393jp, 8);
        }
        if (z2) {
            y.u((View) this.f5393jp, 8);
            y.u((View) this.m, 8);
        }
        fx(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.iz, com.bytedance.sdk.openadsdk.core.widget.s.u
    public void u(View view, boolean z) {
        if (jk()) {
            String str = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
            bc bcVar = this.kj;
            if (bcVar != null && !TextUtils.isEmpty(bcVar.wf())) {
                u(this.kj.wf());
            }
            this.oa.setText(str);
        } else {
            u("");
            this.oa.setText("");
        }
        if (this.h) {
            return;
        }
        fx(this.dw && !this.lf);
        if (dw()) {
            this.d.u(this, view, true, this.b.getVisibility() != 0);
        }
    }
}
