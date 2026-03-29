package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class jx extends jv {
    public static final String Code = "4";
    private static final String[] F = {"com.huawei.openalliance.ad.views.ScanningRelativeLayout", "com.huawei.openalliance.ad.views.ParticleRelativeLayout"};
    private static final String S = "ShadeDetector";
    private View D;
    private double L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f6594a;
    private int b;
    private int c;
    private int d;
    private int e;
    private double f;
    private String g;

    public jx(Context context, AdContentData adContentData, View view) {
        super(context, adContentData);
        this.L = 0.0d;
        this.f6594a = 0.0d;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0.0d;
        this.D = view;
    }

    private int Code(Rect rect, int i) {
        int i2 = rect.right;
        int i3 = this.c;
        if (i2 <= i3) {
            return (this.c - this.b) - (Math.max(rect.left - this.b, 0) + Math.min(this.c - rect.right, i));
        }
        int i4 = rect.left;
        int i5 = this.b;
        if (i4 >= i5) {
            int iMin = Math.min(i4 - i5, i);
            int i6 = rect.right;
            int i7 = this.c;
            return (i7 - this.b) - (iMin + (i6 - i7 <= 0 ? i7 - i6 : 0));
        }
        if (i4 >= i5 || i2 <= i3) {
            return 0;
        }
        return i3 - i5;
    }

    private boolean I(View view) {
        if (view == null) {
            return false;
        }
        for (String str : F) {
            if (str.equals(view.getClass().getName())) {
                fh.Code(S, "shaded by animator view.");
                this.f = 0.0d;
                return true;
            }
        }
        return false;
    }

    private double V(View view) {
        if (view == null) {
            return this.f;
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup)) {
            return this.f;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        int iIndexOfChild = viewGroup.indexOfChild(view);
        while (true) {
            iIndexOfChild++;
            if (iIndexOfChild >= viewGroup.getChildCount()) {
                double d = this.f;
                return d < 0.5d ? V(viewGroup) : d;
            }
            View childAt = viewGroup.getChildAt(iIndexOfChild);
            if (childAt.getVisibility() == 0) {
                Rect rect = new Rect();
                childAt.getGlobalVisibleRect(rect);
                Code(rect);
                if (this.f >= 0.5d && !I(childAt)) {
                    this.g = childAt.getClass().getName();
                    return this.f;
                }
            }
        }
    }

    private void Code(Rect rect) {
        int iCode = this.c - this.b;
        int i = this.e;
        int i2 = this.d;
        int iMin = i - i2;
        int i3 = rect.bottom;
        int i4 = rect.top;
        if (i3 <= i) {
            iMin -= (i2 - i4 <= 0 ? i4 - i2 : 0) + Math.min(i - i3, iMin);
        } else if (i4 < i2) {
            if (i4 < i2 && i3 > i) {
            }
            this.f = ((double) (iCode * iMin)) / this.L;
        } else {
            int iMin2 = Math.min(i4 - i2, iMin);
            int i5 = rect.bottom;
            int i6 = this.e;
            iMin -= iMin2 + (i5 - i6 <= 0 ? i6 - i5 : 0);
        }
        iCode = Code(rect, iCode);
        this.f = ((double) (iCode * iMin)) / this.L;
    }

    private void Code(Rect rect, String str) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.V(com.huawei.openalliance.ad.beans.inner.a.D);
        analysisEventReport.Z(this.D.getClass().getSimpleName() + "_" + str);
        analysisEventReport.B(String.valueOf(this.D.getAlpha()));
        analysisEventReport.C(String.valueOf(rect.width()));
        analysisEventReport.S(String.valueOf(rect.height()));
        analysisEventReport.F(this.g);
        this.B.Code(this.I, analysisEventReport, this.Z);
    }

    @Override // com.huawei.hms.ads.jv
    public boolean Code() {
        View view = this.D;
        if (view == null || !jv.Code(view)) {
            return false;
        }
        this.L = this.D.getWidth() * this.D.getHeight();
        Rect rect = new Rect();
        this.D.getGlobalVisibleRect(rect);
        this.b = rect.left;
        this.c = rect.right;
        this.d = rect.top;
        this.e = rect.bottom;
        if (V(this.D) >= 0.5d) {
            Code(rect, "4");
            return true;
        }
        jv jvVar = this.C;
        if (jvVar != null) {
            return jvVar.Code();
        }
        return false;
    }
}
