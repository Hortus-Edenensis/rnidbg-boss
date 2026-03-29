package com.huawei.openalliance.ad.views.dialog;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.cn;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.bg;
import com.huawei.openalliance.ad.utils.d;
import com.huawei.openalliance.ad.utils.q;
import com.huawei.openalliance.ad.utils.z;
import com.huawei.openalliance.ad.views.PPSBaseDialogContentView;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class PPSBaseDialog extends RelativeLayout {
    protected int B;
    protected int C;
    protected View D;
    protected View F;
    protected int I;
    protected int[] L;
    protected RelativeLayout S;
    protected int V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int[] f6984a;
    protected float b;
    protected PPSBaseDialogContentView c;
    protected PPSBaseDialogContentView d;
    protected PPSBaseDialogContentView e;
    protected ImageView f;
    protected ImageView g;
    protected ImageView h;
    protected Context i;
    protected int j;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements View.OnClickListener {
        private WeakReference<View> Code;

        public a(View view) {
            this.Code = new WeakReference<>(view);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View view2 = this.Code.get();
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    public PPSBaseDialog(Context context) {
        super(context);
        this.b = 6.0f;
        this.j = -1;
        Code(context);
    }

    private void Code(Context context) {
        LayoutInflater.from(context).inflate(getLayoutId(), this);
        this.i = context.getApplicationContext();
        I();
        F();
        D();
        S();
    }

    private void D() {
        if (B() && bg.I()) {
            int[] iArr = this.L;
            int i = (this.V - iArr[0]) - this.f6984a[0];
            iArr[0] = i;
            fh.V("PPSAdvertiserInfoDialog", "rtl mAnchorViewLoc[x,y]= %d, %d", Integer.valueOf(i), Integer.valueOf(this.L[1]));
        }
    }

    private void F() {
        Code();
        if (Build.VERSION.SDK_INT >= 29) {
            this.S.setForceDarkAllowed(false);
        }
        RelativeLayout relativeLayout = this.S;
        relativeLayout.setOnClickListener(new a(relativeLayout));
    }

    private void L() {
        if (!B()) {
            V();
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.F.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            int[] iArr = this.L;
            layoutParams2.width = iArr[0];
            layoutParams2.height = iArr[1];
            this.F.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.D.getLayoutParams();
        if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
            int[] iArr2 = this.f6984a;
            layoutParams4.width = iArr2[0];
            layoutParams4.height = iArr2[1];
            this.D.setLayoutParams(layoutParams4);
        }
    }

    private void S() {
        if (!B()) {
            V();
            return;
        }
        RelativeLayout relativeLayout = this.S;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        PPSBaseDialogContentView pPSBaseDialogContentView = this.e;
        if (pPSBaseDialogContentView != null) {
            pPSBaseDialogContentView.Code(this.L, this.f6984a);
        }
        a();
        L();
        Z();
        b();
    }

    private RelativeLayout.LayoutParams V(boolean z) {
        int i;
        PPSBaseDialogContentView pPSBaseDialogContentView = this.e;
        if (pPSBaseDialogContentView == null) {
            return null;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pPSBaseDialogContentView.getLayoutParams();
        boolean zB = q.B(this.i);
        boolean z2 = q.C(this.i) && (1 == (i = this.B) || 9 == i);
        boolean z3 = q.S(this.i) && q.F(this.i);
        if (!z) {
            int iG = z.g(this.i);
            if (cn.Code(this.i).Code(this.i)) {
                iG = Math.max(iG, cn.Code(this.i).Code(this.S));
            }
            layoutParams.setMargins(0, iG, 0, 0);
        } else if (zB || z2 || z3) {
            layoutParams.setMargins(0, 0, 0, Math.max(z.V(this.i, 40.0f), bg.S(this.i)));
        }
        return layoutParams;
    }

    private void a() {
        if (!B()) {
            V();
            return;
        }
        boolean z = this.L[1] + (this.f6984a[1] / 2) <= this.I / 2;
        Code(z);
        RelativeLayout.LayoutParams layoutParamsV = V(z);
        PPSBaseDialogContentView pPSBaseDialogContentView = this.e;
        if (pPSBaseDialogContentView == null || layoutParamsV == null) {
            return;
        }
        pPSBaseDialogContentView.setLayoutParams(layoutParamsV);
    }

    private void b() {
        if (!B()) {
            V();
            return;
        }
        fh.V("PPSAdvertiserInfoDialog", "getRealOrientation orientation %s", Integer.valueOf(this.B));
        if (C()) {
            com.huawei.openalliance.ad.views.dialog.a.Code(this.i, this.B, this.h, this.e, this.V, 12);
        } else {
            com.huawei.openalliance.ad.views.dialog.a.Code(this.i, this.B, this.h, this.e, this.V);
        }
    }

    public boolean B() {
        int[] iArr = this.L;
        boolean z = iArr != null && iArr.length == 2;
        int[] iArr2 = this.f6984a;
        return z && (iArr2 != null && iArr2.length == 2);
    }

    public boolean C() {
        return this.j == 1;
    }

    public abstract void Code();

    public void I() {
        this.V = d.V(this.i);
        this.I = d.Code(this.i);
        this.B = bg.c(this.i);
        this.C = z.V(this.i, 22.0f);
    }

    public void Z() {
        ImageView imageView;
        float f;
        if (!B()) {
            V();
            return;
        }
        int iV = z.V(this.i, 36.0f);
        int i = this.C;
        int i2 = (this.V - i) - iV;
        int i3 = (this.L[0] + (this.f6984a[0] / 2)) - (iV / 2);
        if (i3 >= i) {
            i = i3;
        }
        if (i <= i2) {
            i2 = i;
        }
        if (bg.I()) {
            imageView = this.h;
            f = -i2;
        } else {
            imageView = this.h;
            f = i2;
        }
        imageView.setX(f);
    }

    public PPSBaseDialogContentView getBottomDialogView() {
        return this.d;
    }

    public abstract int getLayoutId();

    public PPSBaseDialogContentView getTopDialogView() {
        return this.c;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        V();
    }

    public void setAdContent(AdContentData adContentData) {
        this.e.setAdContentData(adContentData);
        S();
    }

    public void setScreenHeight(int i) {
        if (i > 0) {
            this.I = i;
        }
    }

    public void setScreenWidth(int i) {
        if (i > 0) {
            this.V = i;
        }
    }

    public PPSBaseDialog(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 6.0f;
        this.j = -1;
        Code(context);
    }

    private void Code(boolean z) {
        int i = z ? 8 : 0;
        int i2 = z ? 0 : 8;
        this.c.setVisibility(i);
        this.f.setVisibility(i);
        this.g.setVisibility(i2);
        this.d.setVisibility(i2);
        this.e = z ? this.d : this.c;
        this.h = z ? this.g : this.f;
    }

    public void V() {
        RelativeLayout relativeLayout = this.S;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    @Override // android.view.View
    public RelativeLayout getRootView() {
        return this.S;
    }

    public PPSBaseDialog(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 6.0f;
        this.j = -1;
        Code(context);
    }

    public PPSBaseDialog(Context context, int[] iArr, int[] iArr2) {
        super(context);
        this.b = 6.0f;
        this.j = -1;
        this.L = iArr == null ? null : Arrays.copyOf(iArr, iArr.length);
        this.f6984a = iArr2 != null ? Arrays.copyOf(iArr2, iArr2.length) : null;
        Code(context);
    }

    public PPSBaseDialog(Context context, int[] iArr, int[] iArr2, int i) {
        super(context);
        this.b = 6.0f;
        this.j = i;
        this.L = iArr == null ? null : Arrays.copyOf(iArr, iArr.length);
        this.f6984a = iArr2 != null ? Arrays.copyOf(iArr2, iArr2.length) : null;
        Code(context);
    }
}
