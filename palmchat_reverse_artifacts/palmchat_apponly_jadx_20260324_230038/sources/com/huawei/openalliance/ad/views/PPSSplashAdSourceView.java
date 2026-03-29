package com.huawei.openalliance.ad.views;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.cn;
import com.huawei.hms.ads.db;
import com.huawei.hms.ads.dm;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.ft;
import com.huawei.hms.ads.gc;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.constant.be;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.SafeIntent;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.bg;
import com.huawei.openalliance.ad.utils.q;
import com.huawei.openalliance.ad.utils.z;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.huawei.openalliance.ad.views.dialog.PPSTransparencyDialog;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class PPSSplashAdSourceView extends RelativeLayout {
    private ft B;
    private Integer C;
    private boolean D;
    private WeakReference<gc> F;
    private TextView I;
    private boolean L;
    private Integer S;
    private PPSSplashLabelView V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f6975a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements PPSLabelView.a {
        private ft B;
        private WeakReference<PPSSplashAdSourceView> Code;
        private boolean I;
        private AdContentData V;
        private Integer Z;

        public a(PPSSplashAdSourceView pPSSplashAdSourceView, AdContentData adContentData, boolean z, Integer num, ft ftVar) {
            this.Code = new WeakReference<>(pPSSplashAdSourceView);
            this.V = adContentData;
            this.I = z;
            this.Z = num;
            this.B = ftVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.huawei.openalliance.ad.views.PPSLabelView.a
        public void Code(gc gcVar, int[] iArr, int[] iArr2) {
            if (gcVar != 0) {
                boolean z = gcVar instanceof PPSSplashView;
                if (z || (gcVar instanceof PPSLinkedView)) {
                    if (!z.Code(iArr, 2) || !z.Code(iArr2, 2)) {
                        fh.I("PPSSplashAdSourceView", "anchor is invalid.");
                        return;
                    }
                    if (fh.Code()) {
                        fh.Code("PPSSplashAdSourceView", "addTransparencyDialog, loc: %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                        fh.Code("PPSSplashAdSourceView", "addTransparencyDialog, size: %s, %s", Integer.valueOf(iArr2[0]), Integer.valueOf(iArr2[1]));
                    }
                    RelativeLayout relativeLayout = (RelativeLayout) gcVar;
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    PPSTransparencyDialog pPSTransparencyDialog = new PPSTransparencyDialog(relativeLayout.getContext(), iArr, iArr2, 1);
                    PPSSplashAdSourceView pPSSplashAdSourceView = this.Code.get();
                    if (pPSSplashAdSourceView != null) {
                        pPSSplashAdSourceView.setTransparencyDialogCallback(new d(pPSTransparencyDialog));
                    }
                    if (z) {
                        pPSTransparencyDialog.Code(this.I, new c(this.Z, this.B), new b(this.B));
                        relativeLayout.addView(pPSTransparencyDialog, layoutParams);
                        pPSTransparencyDialog.setScreenHeight(relativeLayout.getMeasuredHeight());
                        pPSTransparencyDialog.setScreenWidth(relativeLayout.getMeasuredWidth());
                    } else if ((gcVar instanceof PPSLinkedView) && !Code((PPSLinkedView) gcVar, this.I, this.Z, layoutParams, pPSTransparencyDialog)) {
                        return;
                    }
                    pPSTransparencyDialog.setAdContent(this.V);
                }
            }
        }

        private boolean Code(PPSLinkedView pPSLinkedView, boolean z, Integer num, RelativeLayout.LayoutParams layoutParams, PPSTransparencyDialog pPSTransparencyDialog) {
            SplashLinkedVideoView splashLinkedVideoViewI = pPSLinkedView.i();
            if (splashLinkedVideoViewI == null) {
                fh.I("PPSSplashAdSourceView", "linked splash container is null");
                return false;
            }
            pPSTransparencyDialog.Code(z, new c(num, this.B), new b(this.B));
            splashLinkedVideoViewI.addView(pPSTransparencyDialog, layoutParams);
            pPSTransparencyDialog.setScreenHeight(splashLinkedVideoViewI.getMeasuredHeight());
            pPSTransparencyDialog.setScreenWidth(splashLinkedVideoViewI.getMeasuredWidth());
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements com.huawei.openalliance.ad.views.dsa.a {
        private ft Code;

        public b(ft ftVar) {
            this.Code = ftVar;
        }

        @Override // com.huawei.openalliance.ad.views.dsa.a
        public void Code() {
            ft ftVar = this.Code;
            if (ftVar != null) {
                ftVar.B();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements PPSLabelView.d {
        private Integer Code;
        private ft V;

        public c(Integer num, ft ftVar) {
            this.Code = num;
            this.V = ftVar;
        }

        private int Code(Context context, int i) {
            Integer numB = z.b(context);
            if (z.I()) {
                return i;
            }
            if (numB != null && numB.intValue() >= 30454100) {
                return i;
            }
            fh.V("PPSSplashAdSourceView", "HMS version is low, interactMode is %s", Integer.valueOf(i));
            if (i == 4) {
                i = 1;
            }
            if (i == 3) {
                return 2;
            }
            return i;
        }

        @Override // com.huawei.openalliance.ad.views.PPSLabelView.d
        public void Code(View view) {
            dm.Code(view.getContext()).Code();
            db.Code(view.getContext());
            SafeIntent safeIntent = new SafeIntent(x.an);
            safeIntent.setPackage(z.Z(view.getContext()));
            safeIntent.putExtra(be.aj, Code(view.getContext(), this.Code.intValue()));
            if (!(view.getContext() instanceof Activity)) {
                safeIntent.addFlags(268435456);
            }
            bg.Code(view.getContext(), safeIntent);
            ft ftVar = this.V;
            if (ftVar != null) {
                ftVar.C();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d {
        PPSTransparencyDialog Code;

        public d(PPSTransparencyDialog pPSTransparencyDialog) {
            this.Code = pPSTransparencyDialog;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Code() {
            PPSTransparencyDialog pPSTransparencyDialog = this.Code;
            if (pPSTransparencyDialog != null) {
                pPSTransparencyDialog.S();
            }
        }
    }

    public PPSSplashAdSourceView(Context context) {
        super(context, null);
        this.D = false;
        this.L = false;
    }

    private void V(AdContentData adContentData) {
        TextView textView;
        int i;
        MetaData metaDataS = adContentData.S();
        if (metaDataS == null || this.I == null) {
            return;
        }
        String strV = bc.V(metaDataS.L());
        if (TextUtils.isEmpty(strV)) {
            textView = this.I;
            i = 8;
        } else {
            this.I.setText(strV);
            textView = this.I;
            i = 0;
        }
        textView.setVisibility(i);
    }

    public void Code() {
        d dVar = this.f6975a;
        if (dVar != null) {
            dVar.Code();
        }
    }

    public int getRootLayoutId() {
        this.L = Code(getContext(), this.C, this.S);
        return V() ? R.layout.hiad_splash_ad_source_with_click : R.layout.hiad_splash_ad_source;
    }

    public void setAdMediator(ft ftVar) {
        this.B = ftVar;
    }

    public void setTransparencyDialogCallback(d dVar) {
        this.f6975a = dVar;
    }

    public PPSSplashAdSourceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = false;
        this.L = false;
    }

    private void Code(int i, int i2, boolean z, int i3, int i4, RelativeLayout.LayoutParams layoutParams) {
        int I;
        layoutParams.addRule(10);
        layoutParams.addRule(21);
        layoutParams.rightMargin = i3;
        layoutParams.setMarginEnd(i3);
        layoutParams.topMargin = i4;
        if (i2 != 0) {
            layoutParams.topMargin = i4 + i;
            return;
        }
        if (!z) {
            layoutParams.setMarginEnd(layoutParams.rightMargin + i);
            layoutParams.rightMargin += i;
        }
        if (cn.V(getContext())) {
            layoutParams.setMarginEnd(layoutParams.rightMargin + bg.I(getContext()));
            I = layoutParams.rightMargin + bg.I(getContext());
        } else {
            layoutParams.setMarginEnd(bg.I(getContext()));
            I = bg.I(getContext());
        }
        layoutParams.rightMargin = I;
        layoutParams.topMargin += z.V(getContext(), 12.0f);
    }

    private boolean V() {
        fh.V("PPSSplashAdSourceView", "isSplashClickable: %s, isShowTransparency: %s", Boolean.valueOf(this.L), Boolean.valueOf(this.D));
        return this.L || this.D;
    }

    public PPSSplashAdSourceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.D = false;
        this.L = false;
    }

    private void Code(Context context) {
        View.inflate(context, getRootLayoutId(), this);
        PPSSplashLabelView pPSSplashLabelView = (PPSSplashLabelView) findViewById(R.id.hiad_ad_label);
        this.V = pPSSplashLabelView;
        pPSSplashLabelView.setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.hiad_ad_source);
        this.I = textView;
        textView.setVisibility(8);
    }

    public PPSSplashAdSourceView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.D = false;
        this.L = false;
    }

    public void Code(gc gcVar, Integer num, Integer num2, boolean z) {
        fh.V("PPSSplashAdSourceView", "setAdLabelConfig %s %s %s", num, num2, Boolean.valueOf(z));
        this.F = new WeakReference<>(gcVar);
        this.C = num;
        this.S = num2;
        this.D = z;
    }

    private void Code(AdContentData adContentData) {
        String strR = !bc.Code(adContentData.r()) ? adContentData.r() : getResources().getString(R.string.hiad_ad_label_new);
        MetaData metaDataS = adContentData.S();
        AdSource adSourceCode = (metaDataS == null || metaDataS.l() == null) ? null : AdSource.Code(metaDataS.l());
        PPSSplashLabelView pPSSplashLabelView = this.V;
        a aVar = new a(this, adContentData, this.L, this.C, this.B);
        WeakReference<gc> weakReference = this.F;
        pPSSplashLabelView.Code(aVar, weakReference != null ? weakReference.get() : null, adContentData, this.D);
        this.V.Code(adSourceCode, strR, this.L);
        this.V.setVisibility(0);
        this.V.setDataAndRefreshUi(adContentData);
    }

    public void Code(AdContentData adContentData, boolean z, int i, int i2, boolean z2) {
        Code(getContext());
        String strS = adContentData.s() == null ? "ll" : adContentData.s();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Resources resources = getResources();
        int i3 = R.dimen.hiad_splash_label_side_margin;
        int dimensionPixelSize = resources.getDimensionPixelSize(i3);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(i3);
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if ("tr".equals(strS)) {
                Code(i, i2, z2, dimensionPixelSize, dimensionPixelSize2, layoutParams2);
            } else {
                Code(z, i, i2, z2, dimensionPixelSize, dimensionPixelSize2, layoutParams2);
            }
            setLayoutParams(layoutParams2);
        }
        Code(adContentData);
        V(adContentData);
    }

    private void Code(boolean z, int i, int i2, boolean z2, int i3, int i4, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.addRule(12);
        layoutParams.addRule(20);
        layoutParams.leftMargin = i3;
        layoutParams.setMarginStart(i3);
        layoutParams.bottomMargin = i4;
        if (i2 != 0) {
            if (z) {
                return;
            }
            layoutParams.bottomMargin = i4 + bg.I(getContext());
            return;
        }
        if (cn.V(getContext()) && z2) {
            layoutParams.setMarginStart(layoutParams.leftMargin + i);
            layoutParams.leftMargin += i;
        } else if (!cn.V(getContext()) || (cn.V(getContext()) && TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1)) {
            layoutParams.setMarginStart(bg.I(getContext()));
            layoutParams.leftMargin = bg.I(getContext());
        }
        if (z) {
            return;
        }
        if (q.B(getContext()) || q.S(getContext())) {
            layoutParams.bottomMargin += bg.I(getContext());
        }
    }

    public static boolean Code(Context context, Integer num, Integer num2) {
        if (!cn.Code(context).V() || num == null || num2 == null) {
            return false;
        }
        return ((num.intValue() == 1 || num.intValue() == 4) && (num2.intValue() == 2 || num2.intValue() == 3)) || ((num.intValue() == 2 || num.intValue() == 3) && (num2.intValue() == 1 || num2.intValue() == 3));
    }
}
