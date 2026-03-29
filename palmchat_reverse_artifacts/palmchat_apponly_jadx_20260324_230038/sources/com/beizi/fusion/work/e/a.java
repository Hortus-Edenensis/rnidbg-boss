package com.beizi.fusion.work.e;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.beizi.fusion.R;
import com.beizi.fusion.c.d;
import com.beizi.fusion.c.e;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.CoordinateBean;
import com.beizi.fusion.tool.aa;
import com.beizi.fusion.tool.aj;
import com.beizi.fusion.tool.al;
import com.beizi.fusion.tool.ap;
import com.beizi.fusion.tool.f;
import com.beizi.fusion.tool.o;
import com.beizi.fusion.widget.ScrollClickView;
import com.cdo.oaps.ad.OapsKey;
import com.wifi.adsdk.download.LxAdDLManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a extends com.beizi.fusion.work.a {
    protected ImageView A;
    protected ImageView B;
    protected TextView C;
    protected TextView D;
    protected TextView E;
    protected TextView F;
    protected TextView G;
    protected long H;
    protected float I;
    protected float J;
    protected boolean K = false;
    protected boolean L = false;
    protected boolean M = false;
    protected Context N;
    protected Activity O;
    protected al P;
    protected aj Q;
    protected CountDownTimer R;
    protected AdSpacesBean.RenderViewBean S;
    protected AdSpacesBean.BuyerBean.RenderAds T;
    protected List<AdSpacesBean.RenderViewBean> U;
    protected List<Pair<String, Integer>> V;
    protected View n;
    protected View o;
    protected View p;
    protected ViewGroup q;
    protected ViewGroup r;
    protected ViewGroup s;
    protected ViewGroup t;
    protected ViewGroup u;
    protected ViewGroup v;
    protected ViewGroup w;
    protected ViewGroup x;
    protected ImageView y;
    protected ImageView z;

    public a(Context context, long j, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, d dVar, int i) {
        this.N = context;
        this.H = j;
        this.e = buyerBean;
        this.d = dVar;
        this.k = i;
        this.f = forwardBean;
        this.I = ap.k(context);
        this.J = ap.l(context);
        az();
        r();
    }

    private void aR() {
        List<String> clickView = this.T.getClickView();
        ArrayList arrayList = new ArrayList();
        if (clickView != null && clickView.size() > 0) {
            if (clickView.contains(OapsKey.KEY_BG)) {
                arrayList.add(this.q);
                arrayList.add(this.s);
                arrayList.add(this.w);
            } else if (clickView.contains("ad")) {
                arrayList.add(this.s);
            } else {
                if (clickView.contains("image")) {
                    arrayList.add(this.t);
                }
                if (clickView.contains("title")) {
                    arrayList.add(this.D);
                }
                if (clickView.contains(LxAdDLManager.ITEM_DESC)) {
                    arrayList.add(this.E);
                }
                if (clickView.contains("icon")) {
                    arrayList.add(this.A);
                }
                if (clickView.contains(com.umeng.ccg.a.F)) {
                    arrayList.add(this.v);
                }
            }
        }
        a(arrayList);
    }

    private void aS() {
        ((FrameLayout) this.n).removeView(this.p);
    }

    private void c(int i, int i2) {
        a(this.t, this.T.getImageCoordinate(), i, i2);
        aJ();
    }

    private void g(int i, int i2) {
        a(this.v, this.T.getActionCoordinate(), i, i2);
        if (TextUtils.isEmpty(aN())) {
            return;
        }
        this.F.setText(aN());
    }

    private void i(int i, int i2) {
        b(this.w, this.T.getScrollCoordinate(), i, i2);
    }

    public void a(List<View> list) {
    }

    public void aC() {
        Log.d("BeiZis", "showUnifiedCustomAd Callback --> onADClicked()");
        d dVar = this.d;
        if (dVar != null && dVar.r() != 2) {
            this.d.d(f());
        }
        if (this.L) {
            return;
        }
        this.L = true;
        D();
        ad();
        if (this.k != 2) {
            aQ();
        }
    }

    public void aD() {
        Log.d("BeiZis", "showUnifiedCustomAd Callback --> onAdShow()");
        this.j = com.beizi.fusion.e.a.ADSHOW;
        d dVar = this.d;
        if (dVar != null && dVar.r() != 2) {
            this.d.b(f());
        }
        if (this.K) {
            return;
        }
        this.K = true;
        aO();
        B();
        C();
        ac();
    }

    public void aE() {
        try {
            if (Y()) {
                b();
            } else {
                P();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void aF() {
        if (this.T != null) {
            a((int) this.I, (int) this.J);
            this.z.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.e.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aG();
                }
            });
        }
        this.p = this.o;
        aH();
    }

    public String aK() {
        return "";
    }

    public String aL() {
        return "";
    }

    public String aM() {
        return "";
    }

    public String aN() {
        return "";
    }

    public void aO() {
        AdSpacesBean.BuyerBean.RenderAds renderAds;
        if (this.C == null || this.z == null || (renderAds = this.T) == null) {
            return;
        }
        if (renderAds.getAutoClose() == 0 && this.T.getMinTime() == 0) {
            this.C.setVisibility(8);
            this.z.setVisibility(0);
        } else {
            this.z.setVisibility(8);
            this.C.setVisibility(0);
            a(this.T.getAutoClose(), this.T.getMinTime(), this.T.getMaxTime());
        }
        this.u.setVisibility(0);
    }

    public void aQ() {
        Log.d("BeiZis", "UnifiedCustomAd onADClosed()");
        al alVar = this.P;
        if (alVar != null) {
            alVar.c();
        }
        aj ajVar = this.Q;
        if (ajVar != null) {
            ajVar.b();
        }
        aa();
        F();
        c(this.O);
    }

    public int ay() {
        return -1;
    }

    public void az() {
        if (ay() == -1) {
            return;
        }
        View viewInflate = LayoutInflater.from(this.N).inflate(ay(), (ViewGroup) null);
        this.o = viewInflate;
        this.q = (ViewGroup) viewInflate.findViewById(R.id.rl_bg_container);
        this.r = (ViewGroup) this.o.findViewById(R.id.rl_anim_container);
        this.s = (ViewGroup) this.o.findViewById(R.id.rl_container);
        this.t = (ViewGroup) this.o.findViewById(R.id.fl_img_container);
        this.y = (ImageView) this.o.findViewById(R.id.iv_imageview);
        this.u = (ViewGroup) this.o.findViewById(R.id.rl_close);
        this.C = (TextView) this.o.findViewById(R.id.tv_close);
        this.z = (ImageView) this.o.findViewById(R.id.iv_close);
        this.D = (TextView) this.o.findViewById(R.id.tv_title);
        this.E = (TextView) this.o.findViewById(R.id.tv_desc);
        this.A = (ImageView) this.o.findViewById(R.id.iv_icon);
        this.v = (ViewGroup) this.o.findViewById(R.id.rl_action);
        this.F = (TextView) this.o.findViewById(R.id.tv_action);
        this.w = (ViewGroup) this.o.findViewById(R.id.rl_slide_down_container);
        this.G = (TextView) this.o.findViewById(R.id.tv_slide_down_title);
        this.B = (ImageView) this.o.findViewById(R.id.iv_slide_down_arrow);
        this.x = (ViewGroup) this.o.findViewById(R.id.fl_event_container);
    }

    public void b(boolean z) {
    }

    @Override // com.beizi.fusion.work.a
    public void d() {
        if (this.d == null || ay() == -1) {
            return;
        }
        this.h = this.e.getAppId();
        this.i = this.e.getSpaceId();
        this.c = this.e.getBuyerSpaceUuId();
        List<AdSpacesBean.RenderViewBean> renderView = this.e.getRenderView();
        this.U = renderView;
        if (renderView != null && renderView.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean = this.U.get(0);
            this.S = renderViewBean;
            this.V = o.a(renderViewBean.getDpLinkUrlList());
        }
        com.beizi.fusion.events.b bVar = this.f4818a;
        if (bVar != null) {
            EventBean eventBeanA = bVar.a().a(this.c);
            this.b = eventBeanA;
            if (eventBeanA != null) {
                s();
                aA();
            }
        }
    }

    @Override // com.beizi.fusion.work.a
    public void e() {
    }

    @Override // com.beizi.fusion.work.a
    public String f() {
        return "";
    }

    @Override // com.beizi.fusion.work.a
    public com.beizi.fusion.e.a h() {
        return this.j;
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean j() {
        return this.e;
    }

    @Override // com.beizi.fusion.work.a
    public void k() {
        v();
        ab();
        this.T = this.e.getRenderAds();
        aB();
    }

    @Override // com.beizi.fusion.work.a
    public View o() {
        return this.p;
    }

    private void b(Activity activity) {
        if (activity == null || this.p == null) {
            return;
        }
        View decorView = activity.getWindow().getDecorView();
        this.n = decorView;
        if (decorView instanceof FrameLayout) {
            ap.a(this.p);
            ((FrameLayout) this.n).addView(this.p);
            b(this.r);
        }
    }

    private void e(int i, int i2) {
        a(this.E, this.T.getDescCoordinate(), i, i2);
        if (TextUtils.isEmpty(aL())) {
            return;
        }
        this.E.setText(aL());
    }

    private void f(int i, int i2) {
        a(this.A, this.T.getIconCoordinate(), i, i2);
        if (this.A.getVisibility() != 0 || TextUtils.isEmpty(aM())) {
            return;
        }
        f.a(this.N).a(aM(), new f.a() { // from class: com.beizi.fusion.work.e.a.2
            @Override // com.beizi.fusion.tool.f.a
            public void a() {
            }

            @Override // com.beizi.fusion.tool.f.a
            public void a(Bitmap bitmap) {
                a.this.A.setImageBitmap(bitmap);
            }
        });
    }

    private void h(int i, int i2) {
        a(this.u, this.T.getCloseCoordinate(), i, i2);
    }

    @Override // com.beizi.fusion.work.a
    public void a(Activity activity) {
        try {
            if (this.M) {
                return;
            }
            this.M = true;
            this.O = activity;
            b(activity);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void c(Activity activity) {
        if (activity != null) {
            if (this.n == null) {
                this.n = activity.getWindow().getDecorView();
            }
            if (this.n instanceof FrameLayout) {
                aS();
            }
        }
        l();
    }

    private void a(int i, int i2) {
        a(this.q, this.T.getBgCoordinate(), i, i2);
        int i3 = this.q.getLayoutParams().width;
        int i4 = this.q.getLayoutParams().height;
        b(i3, i4);
        i(i3, i4);
    }

    private void b(View view) {
        if (view != null) {
            view.setVisibility(8);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(500L);
            view.setVisibility(0);
            view.startAnimation(translateAnimation);
        }
    }

    private void a(final int i, final int i2, final int i3) {
        CountDownTimer countDownTimer = this.R;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(600 + (((long) i3) * 1000), 1000L) { // from class: com.beizi.fusion.work.e.a.3
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (i == 1) {
                    a.this.aQ();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                a aVar = a.this;
                TextView textView = aVar.C;
                if (textView == null || aVar.z == null) {
                    return;
                }
                int i4 = (int) (j / 1000.0f);
                if (i3 - i4 < i2) {
                    textView.setText(String.valueOf(i4));
                } else {
                    textView.setVisibility(8);
                    a.this.z.setVisibility(0);
                }
            }
        };
        this.R = countDownTimer2;
        countDownTimer2.start();
    }

    private void b() {
        d dVar = this.d;
        if (dVar == null) {
            return;
        }
        Log.d("BeiZis", f() + " NativeAdWorker:" + dVar.q().toString());
        Z();
        e eVar = this.g;
        if (eVar == e.SUCCESS) {
            aP();
            if (this.p != null) {
                this.d.a(f(), this.p);
                return;
            } else {
                this.d.a(10140);
                return;
            }
        }
        if (eVar == e.FAIL) {
            Log.d("BeiZis", "other worker shown," + f() + " remove");
        }
    }

    private void d(int i, int i2) {
        a(this.D, this.T.getTitleCoordinate(), i, i2);
        if (TextUtils.isEmpty(aK())) {
            return;
        }
        this.D.setText(aK());
    }

    public void aA() {
    }

    public void aB() {
    }

    public void aG() {
    }

    public void aH() {
    }

    public void aI() {
    }

    public void aJ() {
    }

    public void aP() {
    }

    @Override // com.beizi.fusion.work.a
    public void l() {
    }

    private void a(View view, String str, int i, int i2) {
        RelativeLayout.LayoutParams layoutParams;
        boolean z;
        if (view == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            view.setVisibility(8);
            return;
        }
        if (str.equals("-1:-1:-1:-1:-1:-1:-1:-1:-1")) {
            view.setVisibility(8);
            return;
        }
        CoordinateBean coordinate = CoordinateBean.getCoordinate(str);
        if (coordinate == null) {
            view.setVisibility(8);
            return;
        }
        int[] iArrA = a(coordinate, i, i2);
        int[] iArrA2 = a(coordinate, i, i2, iArrA);
        boolean z2 = view instanceof TextView;
        if (z2) {
            layoutParams = new RelativeLayout.LayoutParams(iArrA2[0], -2);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(iArrA2[0], iArrA2[1]);
        }
        layoutParams.setMargins(iArrA[0], iArrA[1], iArrA[2], iArrA[3]);
        if (!coordinate.getTop().equals("-1") || coordinate.getBottom().equals("-1")) {
            z = false;
        } else {
            layoutParams.addRule(12, -1);
            z = true;
        }
        if (coordinate.getLeft().equals("-1") && !coordinate.getRight().equals("-1")) {
            layoutParams.addRule(11, -1);
        }
        view.setLayoutParams(layoutParams);
        if (!coordinate.getFontOrCorner().equals("-1")) {
            if (z2) {
                ((TextView) view).setTextSize(Float.parseFloat(coordinate.getFontOrCorner()));
            } else if (view.getBackground() instanceof GradientDrawable) {
                GradientDrawable gradientDrawable = (GradientDrawable) view.getBackground();
                if (view != this.u && view != this.v) {
                    int iA = ap.a(this.N, Float.parseFloat(coordinate.getFontOrCorner()));
                    if (z) {
                        float f = iA;
                        gradientDrawable.setCornerRadii(new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f});
                    } else {
                        gradientDrawable.setCornerRadius(iA);
                    }
                } else {
                    gradientDrawable.setCornerRadius(iArrA2[1]);
                }
            }
        }
        if (coordinate.getColor().equals("-1")) {
            return;
        }
        if (z2) {
            ((TextView) view).setTextColor(Color.parseColor(coordinate.getColor()));
        } else if (view != this.x) {
            if (view.getBackground() instanceof GradientDrawable) {
                ((GradientDrawable) view.getBackground()).setColor(Color.parseColor(coordinate.getColor()));
            } else {
                view.setBackgroundColor(Color.parseColor(coordinate.getColor()));
            }
        }
    }

    private void b(int i, int i2) {
        String adCoordinate = this.T.getAdCoordinate();
        a(this.s, adCoordinate, i, i2);
        a(this.x, adCoordinate, i, i2);
        int i3 = this.s.getLayoutParams().width;
        int i4 = this.s.getLayoutParams().height;
        c(i3, i4);
        d(i3, i4);
        e(i3, i4);
        f(i3, i4);
        g(i3, i4);
        h(i3, i4);
        aI();
        aR();
    }

    private int b(String str, int i) {
        if (str.contains("%")) {
            return (i * ((int) Float.parseFloat(str.substring(0, str.indexOf("%"))))) / 100;
        }
        return ap.a(this.N, Float.parseFloat(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x027b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(View view, String str, int i, int i2) {
        int iA;
        int i3;
        char c;
        int i4;
        int i5;
        int i6;
        char c2;
        int i7;
        int iB;
        int iB2;
        if (view == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            view.setVisibility(8);
            return;
        }
        if (str.equals("-1:-1:-1:-1:-1:-1:-1:-1:-1")) {
            view.setVisibility(8);
            return;
        }
        CoordinateBean coordinate = CoordinateBean.getCoordinate(str);
        if (coordinate == null) {
            view.setVisibility(8);
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (!coordinate.getScale().equals("-1")) {
            this.G.setText(coordinate.getScale());
        }
        if (!coordinate.getFontOrCorner().equals("-1")) {
            this.G.setTextSize(Float.parseFloat(coordinate.getFontOrCorner()));
        }
        if (!coordinate.getColor().equals("-1")) {
            this.G.setTextColor(Color.parseColor(coordinate.getColor()));
        }
        if (coordinate.getWidth().equals("-1")) {
            iA = 0;
            i3 = 0;
        } else {
            iA = ap.a(this.N, Float.parseFloat(coordinate.getWidth()));
            i3 = (int) (((double) iA) / 0.8d);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(iA, i3);
            layoutParams2.gravity = 1;
            this.B.setLayoutParams(layoutParams2);
            this.B.setImageDrawable(this.N.getResources().getDrawable(R.drawable.beizi_slide_down_close_ad));
            ((AnimationDrawable) this.B.getDrawable()).start();
        }
        int i8 = this.s.getLayoutParams().width;
        int i9 = this.s.getLayoutParams().height;
        this.G.measure(View.MeasureSpec.makeMeasureSpec(1073741823, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(1073741823, Integer.MIN_VALUE));
        int measuredWidth = this.G.getMeasuredWidth();
        int measuredHeight = this.G.getMeasuredHeight();
        int iMax = Math.max(measuredWidth, iA);
        int i10 = measuredHeight + i3;
        int iA2 = ap.a(this.N, Float.parseFloat(coordinate.getHeight())) + i9;
        if (!coordinate.getHeight().equals("-1")) {
            layoutParams.addRule(12, -1);
            if (!coordinate.getLeft().equals("-1")) {
                if (coordinate.getLeft().contains("%")) {
                    iB = b(coordinate.getLeft(), i8) - (iMax / 2);
                } else {
                    iB = b(coordinate.getLeft(), i8);
                }
                if (iB <= 0) {
                }
                if (!coordinate.getRight().equals("-1")) {
                }
            } else {
                iB = 0;
                if (!coordinate.getRight().equals("-1")) {
                    if (coordinate.getRight().contains("%")) {
                        iB2 = b(coordinate.getRight(), i8) - (iMax / 2);
                    } else {
                        iB2 = b(coordinate.getRight(), i8);
                    }
                    if (iB2 <= 0) {
                    }
                    if (iB > 0) {
                        if (iB <= 0) {
                        }
                        layoutParams.setMargins(iB, 0, iB2, iA2);
                        i6 = 0;
                    }
                } else {
                    iB2 = 0;
                    if (iB > 0 && iB2 <= 0) {
                        layoutParams.addRule(14, -1);
                    } else if (iB <= 0) {
                        layoutParams.addRule(9, -1);
                    } else {
                        layoutParams.addRule(11, -1);
                    }
                    layoutParams.setMargins(iB, 0, iB2, iA2);
                    i6 = 0;
                }
            }
        } else {
            int[] iArr = {0, 0, 0, 0};
            if (!coordinate.getLeft().equals("-1")) {
                if (coordinate.getLeft().contains("%")) {
                    i7 = 0;
                    iArr[0] = b(coordinate.getLeft(), i) - (iMax / 2);
                } else {
                    i7 = 0;
                    iArr[0] = b(coordinate.getLeft(), i);
                }
                if (iArr[i7] <= 0) {
                    iArr[i7] = i7;
                }
            }
            if (!coordinate.getTop().equals("-1")) {
                if (coordinate.getTop().contains("%")) {
                    c2 = 1;
                    iArr[1] = b(coordinate.getTop(), i2) - (i10 / 2);
                } else {
                    c2 = 1;
                    iArr[1] = b(coordinate.getTop(), i2);
                }
                if (iArr[c2] <= 0) {
                    iArr[c2] = 0;
                }
            }
            if (!coordinate.getRight().equals("-1")) {
                if (coordinate.getRight().contains("%")) {
                    iArr[2] = b(coordinate.getRight(), i) - (iMax / 2);
                } else {
                    iArr[2] = b(coordinate.getRight(), i);
                }
                if (iArr[2] <= 0) {
                    iArr[2] = 0;
                }
            }
            if (!coordinate.getBottom().equals("-1")) {
                if (coordinate.getBottom().contains("%")) {
                    iArr[3] = b(coordinate.getBottom(), i2) - (i10 / 2);
                } else {
                    iArr[3] = b(coordinate.getBottom(), i2);
                }
                if (iArr[3] <= 0) {
                    c = 0;
                    iArr[3] = 0;
                }
                i4 = iArr[c];
                if (i4 > 0) {
                    if (i4 <= 0) {
                    }
                    i5 = iArr[1];
                    if (i5 > 0) {
                        if (i5 <= 0) {
                        }
                        i6 = 0;
                        layoutParams.setMargins(iArr[0], iArr[1], iArr[2], iArr[3]);
                    }
                }
            } else {
                c = 0;
                i4 = iArr[c];
                if (i4 > 0 && iArr[2] <= 0) {
                    layoutParams.addRule(14, -1);
                } else if (i4 <= 0) {
                    layoutParams.addRule(9, -1);
                } else {
                    layoutParams.addRule(11, -1);
                }
                i5 = iArr[1];
                if (i5 > 0 && iArr[3] <= 0) {
                    layoutParams.addRule(15, -1);
                } else if (i5 <= 0) {
                    layoutParams.addRule(10, -1);
                } else {
                    layoutParams.addRule(12, -1);
                }
                i6 = 0;
                layoutParams.setMargins(iArr[0], iArr[1], iArr[2], iArr[3]);
            }
        }
        view.setLayoutParams(layoutParams);
        view.setVisibility(i6);
        if (TextUtils.isEmpty(this.T.getScrollCoordinate()) || this.T.getScrollCoordinate().equals("-1:-1:-1:-1:-1:-1:-1:-1:-1")) {
            return;
        }
        a(this.q);
        a(this.x);
    }

    private int[] a(CoordinateBean coordinateBean, int i, int i2, int[] iArr) {
        int iB;
        int iB2;
        int[] iArr2 = new int[2];
        if (coordinateBean.getWidth().equals("-1")) {
            iB = (i - iArr[0]) - iArr[2];
        } else {
            iB = b(coordinateBean.getWidth(), i);
        }
        if (!coordinateBean.getScale().equals("-1") && !coordinateBean.getScale().equals("0")) {
            iB2 = (int) (iB / Float.parseFloat(coordinateBean.getScale()));
        } else if (coordinateBean.getHeight().equals("-1")) {
            iB2 = (i2 - iArr[1]) - iArr[3];
        } else {
            iB2 = b(coordinateBean.getHeight(), i2);
        }
        iArr2[0] = iB;
        iArr2[1] = iB2;
        return iArr2;
    }

    private int[] a(CoordinateBean coordinateBean, int i, int i2) {
        int[] iArr = new int[4];
        String left = coordinateBean.getLeft();
        int iB = (left.equals("0%") || left.equals("0") || left.equals("-1")) ? 0 : b(left, i);
        String top = coordinateBean.getTop();
        int iB2 = (top.equals("0%") || top.equals("0") || top.equals("-1")) ? 0 : b(top, i2);
        String right = coordinateBean.getRight();
        int iB3 = (right.equals("0%") || right.equals("0") || right.equals("-1")) ? 0 : b(right, i);
        String bottom = coordinateBean.getBottom();
        int iB4 = (bottom.equals("0%") || bottom.equals("0") || bottom.equals("-1")) ? 0 : b(bottom, i2);
        iArr[0] = iB;
        iArr[1] = iB2;
        iArr[2] = iB3;
        iArr[3] = iB4;
        return iArr;
    }

    public void a(View view) {
        a(view, "", 30, (aj.a) null);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void a(View view, final String str, int i, final aj.a aVar) {
        final int iA = ap.a(this.N, i);
        final boolean z = view == this.q;
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.e.a.4

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            float f4885a;
            float b;
            float c;
            float d;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                aj.a aVar2;
                aj.a aVar3;
                aj.a aVar4;
                aj.a aVar5;
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f4885a = motionEvent.getX();
                    this.b = motionEvent.getY();
                    this.c = motionEvent.getX();
                    this.d = motionEvent.getY();
                    if (z) {
                        a.this.q.onTouchEvent(motionEvent);
                    } else {
                        a.this.s.dispatchTouchEvent(motionEvent);
                    }
                } else if (action == 1) {
                    aa.b("SlideClickUtil", "mCurPosX = " + this.c + ",mCurPosY = " + this.d + ",mPosX = " + this.f4885a + ",mPosY = " + this.b);
                    float f = this.d;
                    float f2 = this.b;
                    float f3 = f - f2;
                    int i2 = iA;
                    if (f3 > i2) {
                        if (!TextUtils.isEmpty(a.this.T.getScrollCoordinate()) && !a.this.T.getScrollCoordinate().equals("-1:-1:-1:-1:-1:-1:-1:-1:-1")) {
                            a.this.b(z);
                        } else if (ScrollClickView.DIR_DOWN.equalsIgnoreCase(str) && (aVar5 = aVar) != null) {
                            aVar5.a_();
                        }
                    } else if (f2 - f <= i2) {
                        float f4 = this.f4885a;
                        float f5 = this.c;
                        if (f4 - f5 > i2) {
                            if ("left".equalsIgnoreCase(str) && (aVar3 = aVar) != null) {
                                aVar3.a_();
                            }
                        } else if (f5 - f4 > i2) {
                            if ("right".equalsIgnoreCase(str) && (aVar2 = aVar) != null) {
                                aVar2.a_();
                            }
                        } else if (z) {
                            a.this.q.onTouchEvent(motionEvent);
                        } else {
                            a.this.s.dispatchTouchEvent(motionEvent);
                        }
                    } else if ("up".equalsIgnoreCase(str) && (aVar4 = aVar) != null) {
                        aVar4.a_();
                    }
                } else if (action == 2) {
                    this.c = motionEvent.getX();
                    this.d = motionEvent.getY();
                }
                return true;
            }
        });
    }
}
