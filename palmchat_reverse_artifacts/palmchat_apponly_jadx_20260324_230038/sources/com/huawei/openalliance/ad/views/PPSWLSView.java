package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.cn;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.ft;
import com.huawei.hms.ads.splash.ChoicesView;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.bg;
import com.huawei.openalliance.ad.utils.q;
import com.huawei.openalliance.ad.utils.z;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class PPSWLSView extends RelativeLayout {
    private ChoicesView B;
    private ft C;
    private Integer D;
    private Integer F;
    private TextView I;
    private View.OnClickListener L;
    private WeakReference<PPSLinkedView> S;
    private PPSSplashLabelView V;

    public PPSWLSView(Context context) {
        super(context, null);
        Code(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PPSLinkedView getPpsLinkedView() {
        WeakReference<PPSLinkedView> weakReference = this.S;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int[] getChoiceViewLoc() {
        return bg.Z(this.B);
    }

    public int[] getChoiceViewSize() {
        return bg.B(this.B);
    }

    public void setAdMediator(ft ftVar) {
        this.C = ftVar;
    }

    public void setChoiceViewOnClickListener(View.OnClickListener onClickListener) {
        this.L = onClickListener;
    }

    public void setPpsLinkedView(PPSLinkedView pPSLinkedView) {
        this.S = new WeakReference<>(pPSLinkedView);
    }

    public PPSWLSView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
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

    private void I(String str) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.I.getLayoutParams();
        int i = R.id.hiad_ad_label_wls;
        layoutParams.addRule(6, i);
        layoutParams.addRule(8, i);
        if (!this.V.Code()) {
            layoutParams.addRule(15);
        }
        layoutParams.addRule("tr".equals(str) ? 16 : 17, i);
        this.I.setLayoutParams(layoutParams);
    }

    private void V(final AdContentData adContentData, String str) {
        Code(str);
        String strV = bc.V(adContentData.ad());
        String strV2 = bc.V(adContentData.ae());
        if (!TextUtils.isEmpty(strV)) {
            if (TextUtils.isEmpty(strV2)) {
                this.B.I();
            } else {
                this.B.setAdChoiceIcon(strV2);
            }
        }
        this.B.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSWLSView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (fh.Code()) {
                    fh.Code("PPSWLSView", "choiceView onclick");
                }
                if (PPSWLSView.this.L != null) {
                    PPSWLSView.this.L.onClick(view);
                    return;
                }
                if (z.Code(PPSWLSView.this.getContext(), adContentData)) {
                    if (PPSWLSView.this.C != null) {
                        PPSWLSView.this.C.B();
                    }
                    if (PPSWLSView.this.getPpsLinkedView() != null) {
                        PPSWLSView.this.getPpsLinkedView().Code((Integer) 10, true);
                    }
                }
            }
        });
    }

    public PPSWLSView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Code(context);
    }

    private void Code(Context context) {
        View.inflate(context, R.layout.hiad_wls_view, this);
        ChoicesView choicesView = (ChoicesView) findViewById(R.id.splash_why_this_ad);
        this.B = choicesView;
        choicesView.setVisibility(8);
        PPSSplashLabelView pPSSplashLabelView = (PPSSplashLabelView) findViewById(R.id.hiad_ad_label_wls);
        this.V = pPSSplashLabelView;
        pPSSplashLabelView.setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.hiad_ad_source_wls);
        this.I = textView;
        textView.setVisibility(8);
    }

    private void V(String str) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.V.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.addRule("tr".equals(str) ? 16 : 17, R.id.splash_why_this_ad);
        this.V.setLayoutParams(layoutParams);
    }

    public PPSWLSView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Code(context);
    }

    private void Code(AdContentData adContentData) {
        MetaData metaDataS = adContentData.S();
        if (metaDataS != null) {
            String strV = bc.V(metaDataS.L());
            if (TextUtils.isEmpty(strV)) {
                this.I.setVisibility(8);
                return;
            }
            this.I.setText(strV);
            this.I.setVisibility(0);
            I(adContentData.s());
        }
    }

    private void Code(AdContentData adContentData, String str) {
        V(str);
        this.V.Code((AdSource) null, !bc.Code(adContentData.r()) ? adContentData.r() : getResources().getString(R.string.hiad_ad_label_new), false);
        this.V.setVisibility(0);
        this.V.setDataAndRefreshUi(adContentData);
    }

    public void Code(AdContentData adContentData, boolean z, int i, int i2, boolean z2) {
        fh.V("PPSWLSView", "positionAndSet. ");
        String strS = adContentData.s() == null ? "ll" : adContentData.s();
        this.B.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Resources resources = getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.hiad_splash_wls_side_margin);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.hiad_splash_wls_vertical_margin);
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if ("tr".equals(strS)) {
                Code(i, i2, z2, dimensionPixelSize, dimensionPixelSize2, layoutParams2);
            } else {
                Code(z, i, i2, z2, dimensionPixelSize, dimensionPixelSize2, layoutParams2);
            }
            setLayoutParams(layoutParams2);
        }
        V(adContentData, strS);
        Code(adContentData, strS);
        Code(adContentData);
    }

    public void Code(Integer num, Integer num2) {
        this.F = num;
        this.D = num2;
    }

    private void Code(String str) {
        Resources resources = getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.B.getLayoutParams();
        if ("tr".equals(str)) {
            layoutParams.addRule(10);
            layoutParams.addRule(21);
            layoutParams.setMarginStart(resources.getDimensionPixelSize(R.dimen.hiad_8_dp));
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(20);
            layoutParams.setMarginEnd(resources.getDimensionPixelSize(R.dimen.hiad_8_dp));
        }
        this.B.setLayoutParams(layoutParams);
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
}
