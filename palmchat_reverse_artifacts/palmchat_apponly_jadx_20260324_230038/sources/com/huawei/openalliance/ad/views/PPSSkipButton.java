package com.huawei.openalliance.ad.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.cn;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.ft;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.bf;
import com.huawei.openalliance.ad.utils.bg;
import com.huawei.openalliance.ad.utils.q;
import com.huawei.openalliance.ad.utils.z;
import java.util.IllegalFormatException;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class PPSSkipButton extends FrameLayout {
    private static int B = 4;
    private static int C = 16;
    private static final String Code = "PPSSkipButton";
    private static int D = 24;
    private static int F = 24;
    private static int I = 16;
    private static int S = 16;
    private static int V = 16;
    private Context b;
    private String c;
    private String d;
    private int e;
    private int f;
    private int g;
    private final String h;
    private ft i;
    private boolean j;
    private Resources k;
    private TextView l;
    private boolean m;
    private int n;
    private float o;
    private int p;
    private boolean q;
    private boolean r;
    private boolean s;

    public PPSSkipButton(Context context, String str, int i, int i2, int i3, String str2, boolean z, int i4, float f, int i5, boolean z2) {
        super(context);
        this.g = 0;
        this.m = false;
        this.q = false;
        this.r = true;
        this.s = false;
        this.b = context;
        this.k = context.getResources();
        V();
        this.e = i;
        this.f = i2;
        this.g = i3;
        this.h = str2 == null ? "tr" : str2;
        this.c = context.getString(R.string.hiad_default_skip_text);
        this.d = Code(str);
        this.j = z;
        this.n = i4;
        this.o = f;
        this.p = i5;
        this.q = z2;
        this.r = cn.V(context);
        I();
        this.s = false;
        Z();
    }

    private int Code(boolean z) {
        int i = z ? F : I;
        if (5 == this.f) {
            return z ? D : S;
        }
        return i;
    }

    @SuppressLint({"NewApi"})
    private void I() {
        View.inflate(getContext(), R.layout.hiad_view_skip_button, this);
        TextView textView = (TextView) findViewById(R.id.hiad_skip_text);
        this.l = textView;
        textView.setText(this.c);
        if (this.o > 0.0f) {
            if (z.e(this.b)) {
                this.l.setTextSize(1, 24.0f);
                if (this.p > 0) {
                    this.l.setHeight(z.V(this.b, 48.0f));
                }
            } else {
                this.l.setTextSize(2, this.o);
                int i = this.p;
                if (i > 0) {
                    this.l.setHeight(z.Z(this.b, i));
                }
            }
        }
        this.l.setPadding(getSkipAdPaddingPx(), 0, getSkipAdPaddingPx(), 0);
        setPaddingRelative(getSkipAdLeftPaddingPx(), getSkipAdTopPaddingPx(), getSkipAdRightPaddingPx(), getSkipAdBottomPaddingPx());
        setClickable(true);
        setLayoutParams(getSkipAdLayoutParams());
    }

    private void Z() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSSkipButton.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (motionEvent.getAction() == 0) {
                    if (fh.Code()) {
                        fh.Code(PPSSkipButton.Code, "touch down skipAdButton x=%f, y=%f", Float.valueOf(rawX), Float.valueOf(rawY));
                    }
                    if (!PPSSkipButton.this.s && PPSSkipButton.this.i != null) {
                        PPSSkipButton.this.s = true;
                        PPSSkipButton.this.i.Code((int) rawX, (int) rawY);
                    }
                }
                return true;
            }
        });
    }

    private int getHorizontalSideGapDpSize() {
        int i = V;
        if (5 == this.f) {
            i = C;
        }
        return !this.r ? B : i;
    }

    private int getHorizontalSideMarginDp() {
        int horizontalSideGapDpSize = getHorizontalSideGapDpSize();
        int i = this.g;
        if (horizontalSideGapDpSize < i) {
            return 0;
        }
        return horizontalSideGapDpSize - i;
    }

    private int getHorizontalSidePaddingDp() {
        return Math.min(getHorizontalSideGapDpSize(), this.g);
    }

    private int getSkipAdBottomMarginPx() {
        if (!"lr".equals(this.h)) {
            return 0;
        }
        int iCode = this.j ? 0 : bf.Code(this.b);
        if (this.e == 0 && 5 != this.f && !q.S(this.b) && !q.B(this.b)) {
            iCode = 0;
        }
        if (!this.j && fh.Code()) {
            fh.Code(Code, "navigation bar h: %d", Integer.valueOf(iCode));
        }
        return bf.Code(this.b, getVerticalSideBottomMarginDp()) + iCode;
    }

    private int getSkipAdBottomPaddingPx() {
        Context context;
        int verticalSidePaddingDp;
        if ("lr".equals(this.h)) {
            context = this.b;
            verticalSidePaddingDp = getVerticalSidePaddingDp();
        } else {
            context = this.b;
            verticalSidePaddingDp = this.g;
        }
        return bf.Code(context, verticalSidePaddingDp);
    }

    private RelativeLayout.LayoutParams getSkipAdLayoutParams() {
        int iV;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule("lr".equals(this.h) ? 12 : 10);
        layoutParams.addRule(21);
        int skipAdLeftMarginPx = getSkipAdLeftMarginPx();
        int skipAdTopMarginPx = getSkipAdTopMarginPx();
        int skipAdRightMarginPx = getSkipAdRightMarginPx();
        int skipAdBottomMarginPx = getSkipAdBottomMarginPx();
        if (1 != this.e) {
            if (!this.q) {
                skipAdRightMarginPx += this.n;
            }
            skipAdRightMarginPx = this.r ? skipAdRightMarginPx + bg.I(this.b) : bg.I(this.b);
            if ("tr".equals(this.h)) {
                iV = z.V(this.b, 12.0f);
                skipAdTopMarginPx += iV;
            }
        } else if ("tr".equals(this.h)) {
            iV = this.n;
            skipAdTopMarginPx += iV;
        }
        layoutParams.setMargins(skipAdLeftMarginPx, skipAdTopMarginPx, skipAdRightMarginPx, skipAdBottomMarginPx);
        layoutParams.setMarginEnd(skipAdRightMarginPx);
        return layoutParams;
    }

    private int getSkipAdLeftMarginPx() {
        return 0;
    }

    private int getSkipAdLeftPaddingPx() {
        return this.k.getDimensionPixelOffset(R.dimen.hiad_margin_m);
    }

    private int getSkipAdPaddingPx() {
        return this.k.getDimensionPixelOffset(R.dimen.hiad_margin_l);
    }

    private int getSkipAdRightMarginPx() {
        return bf.Code(this.b, getHorizontalSideMarginDp());
    }

    private int getSkipAdRightPaddingPx() {
        return bf.Code(this.b, getHorizontalSidePaddingDp());
    }

    private int getSkipAdTopMarginPx() {
        if ("lr".equals(this.h)) {
            return 0;
        }
        return bf.Code(this.b, getVerticalSideMarginDp());
    }

    private int getSkipAdTopPaddingPx() {
        Context context;
        int topPaddingDp;
        if ("lr".equals(this.h)) {
            context = this.b;
            topPaddingDp = this.g;
        } else {
            context = this.b;
            topPaddingDp = getTopPaddingDp();
        }
        return bf.Code(context, topPaddingDp);
    }

    private int getTopPaddingDp() {
        return Math.min(5 == this.f ? S : I, this.g);
    }

    private int getVerticalSideBottomMarginDp() {
        int iCode = Code(true);
        int i = this.g;
        if (iCode < i) {
            return 0;
        }
        return iCode - i;
    }

    private int getVerticalSideMarginDp() {
        int iCode = Code(false);
        int i = this.g;
        if (iCode < i) {
            return 0;
        }
        return iCode - i;
    }

    private int getVerticalSidePaddingDp() {
        return Math.min(Code(false), this.g);
    }

    public void setAdMediator(ft ftVar) {
        this.i = ftVar;
    }

    public void setLinkedOnTouchListener(View.OnTouchListener onTouchListener) {
        setOnTouchListener(onTouchListener);
    }

    public void setShowLeftTime(boolean z) {
        this.m = z;
    }

    private void V() {
        Context context;
        Resources resources = this.k;
        if (resources == null || (context = this.b) == null) {
            return;
        }
        V = z.I(context, resources.getDimension(R.dimen.hiad_splash_skip_phone_margin));
        I = z.I(this.b, this.k.getDimension(R.dimen.hiad_splash_skip_phone_margin_top));
        B = z.I(this.b, this.k.getDimension(R.dimen.hiad_splash_skip_third_margin));
        C = z.I(this.b, this.k.getDimension(R.dimen.hiad_splash_skip_tablet_margin));
        S = z.I(this.b, this.k.getDimension(R.dimen.hiad_splash_skip_tablet_margin_top));
        F = z.I(this.b, this.k.getDimension(R.dimen.hiad_splash_skip_phone_margin_bottom));
        D = z.I(this.b, this.k.getDimension(R.dimen.hiad_splash_skip_tablet_margin_bottom));
    }

    private String Code(String str) {
        String strV = bc.V(str);
        return bc.Code(strV) ? this.b.getString(R.string.hiad_default_skip_text_time) : strV;
    }

    public void Code(int i) {
        if (this.m && !TextUtils.isEmpty(this.d)) {
            try {
                String str = String.format(Locale.getDefault(), this.d, Integer.valueOf(i));
                fh.Code(Code, "updateLeftTime : %s", str);
                this.l.setText(str);
                return;
            } catch (IllegalFormatException unused) {
                fh.Z(Code, "updateLeftTime IllegalFormatException");
            }
        }
        this.l.setText(this.c);
    }
}
