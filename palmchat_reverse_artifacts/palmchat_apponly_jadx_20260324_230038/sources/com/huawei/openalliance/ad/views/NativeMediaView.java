package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.fy;
import com.huawei.hms.ads.fz;
import com.huawei.openalliance.ad.inter.data.l;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class NativeMediaView extends AutoScaleSizeRelativeLayout {
    private static final String S = "NativeMediaView";
    protected l B;
    protected fy C;
    private fz D;
    boolean I;
    boolean V;

    public NativeMediaView(Context context) {
        super(context);
        this.V = false;
        this.I = false;
        this.C = new fy(this) { // from class: com.huawei.openalliance.ad.views.NativeMediaView.1
            @Override // com.huawei.hms.ads.fy
            public void Code() {
                NativeMediaView.this.Code();
            }

            @Override // com.huawei.hms.ads.fy
            public void Code(int i) {
                NativeMediaView.this.Code(i);
            }

            @Override // com.huawei.hms.ads.fy
            public void Code(long j, int i) {
                NativeMediaView.this.Code(0);
            }
        };
    }

    public void Code() {
    }

    public int getAutoPlayAreaPercentageThresshold() {
        return 100;
    }

    public int getHiddenAreaPercentageThreshhold() {
        return 10;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fy fyVar = this.C;
        if (fyVar != null) {
            fyVar.D();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fy fyVar = this.C;
        if (fyVar != null) {
            fyVar.L();
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        fy fyVar = this.C;
        if (fyVar != null) {
            fyVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNativeAd(com.huawei.openalliance.ad.inter.data.g gVar) {
        this.B = gVar instanceof l ? (l) gVar : null;
    }

    public void setViewShowAreaListener(fz fzVar) {
        this.D = fzVar;
    }

    public NativeMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.V = false;
        this.I = false;
        this.C = new fy(this) { // from class: com.huawei.openalliance.ad.views.NativeMediaView.1
            @Override // com.huawei.hms.ads.fy
            public void Code() {
                NativeMediaView.this.Code();
            }

            @Override // com.huawei.hms.ads.fy
            public void Code(int i) {
                NativeMediaView.this.Code(i);
            }

            @Override // com.huawei.hms.ads.fy
            public void Code(long j, int i) {
                NativeMediaView.this.Code(0);
            }
        };
    }

    void Code(int i) {
        String str = S;
        fh.V(str, "visiblePercentage is " + i);
        fz fzVar = this.D;
        if (fzVar != null) {
            fzVar.Code(i);
        }
        if (i >= getAutoPlayAreaPercentageThresshold()) {
            this.I = false;
            if (this.V) {
                return;
            }
            this.V = true;
            V();
            return;
        }
        this.V = false;
        int hiddenAreaPercentageThreshhold = getHiddenAreaPercentageThreshhold();
        fh.V(str, "HiddenAreaPercentageThreshhold is " + hiddenAreaPercentageThreshhold);
        if (i > 100 - hiddenAreaPercentageThreshhold) {
            if (this.I) {
                B();
            }
            this.I = false;
        } else {
            if (this.I) {
                return;
            }
            this.I = true;
            I();
        }
    }

    public NativeMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.V = false;
        this.I = false;
        this.C = new fy(this) { // from class: com.huawei.openalliance.ad.views.NativeMediaView.1
            @Override // com.huawei.hms.ads.fy
            public void Code() {
                NativeMediaView.this.Code();
            }

            @Override // com.huawei.hms.ads.fy
            public void Code(int i2) {
                NativeMediaView.this.Code(i2);
            }

            @Override // com.huawei.hms.ads.fy
            public void Code(long j, int i2) {
                NativeMediaView.this.Code(0);
            }
        };
    }

    public void B() {
    }

    public void I() {
    }

    public void V() {
    }
}
