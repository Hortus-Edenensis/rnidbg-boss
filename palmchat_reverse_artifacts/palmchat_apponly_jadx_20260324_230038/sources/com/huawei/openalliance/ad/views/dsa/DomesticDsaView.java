package com.huawei.openalliance.ad.views.dsa;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.ac;
import com.huawei.openalliance.ad.utils.bg;
import com.huawei.openalliance.ad.utils.q;
import com.huawei.openalliance.ad.utils.z;
import com.huawei.openalliance.ad.views.PPSBaseDialogContentView;
import com.huawei.openalliance.ad.views.PPSLabelView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class DomesticDsaView extends PPSBaseDialogContentView {
    private static final String g = "DomesticDsaView";
    private static final float h = 0.56f;
    private static final float i = 0.4f;
    private static final float j = 0.4f;
    protected Boolean f;
    private RelativeLayout k;
    private TextView l;
    private View m;
    private RelativeLayout n;
    private TextView o;
    private AdContentData p;
    private PPSLabelView.d q;
    private a r;

    public DomesticDsaView(Context context) {
        super(context);
    }

    private void B() {
        if (z.e(getContext())) {
            TextView textView = this.l;
            if (textView != null) {
                textView.setTextSize(1, 28.0f);
            }
            TextView textView2 = this.o;
            if (textView2 != null) {
                textView2.setTextSize(1, 28.0f);
            }
        }
    }

    private void Z() {
        this.n.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.dsa.DomesticDsaView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!z.Code(DomesticDsaView.this.getContext(), DomesticDsaView.this.p) || DomesticDsaView.this.r == null) {
                    return;
                }
                DomesticDsaView.this.r.Code();
            }
        });
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void setAdContentData(AdContentData adContentData) {
        if (adContentData == null) {
            return;
        }
        this.p = adContentData;
        Z();
        I();
        Code();
        B();
    }

    public void setDsaJumpListener(a aVar) {
        this.r = aVar;
    }

    public DomesticDsaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void I() {
        String str;
        if (this.m == null || this.k == null) {
            str = "partingLine or splashFeedbackClick view not init";
        } else {
            Boolean bool = this.f;
            if (bool != null && bool.booleanValue()) {
                this.m.setVisibility(0);
                this.k.setVisibility(0);
                this.k.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.dsa.DomesticDsaView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (DomesticDsaView.this.q != null) {
                            DomesticDsaView.this.q.Code(view);
                        }
                    }
                });
                if (z.Code(this.p.aQ(), this.p.aP())) {
                    return;
                }
                this.n.setVisibility(8);
                this.m.setVisibility(8);
                return;
            }
            str = "not need show splash feedback";
        }
        fh.V(g, str);
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void Code() {
        try {
            fh.V(g, "adapterView mFeedbackViewPaddingLeft = %s, mFeedbackViewPaddingRight= %s", Integer.valueOf(this.b), Integer.valueOf(this.c));
            if (V()) {
                this.I.setPadding(this.b, 0, this.c, 0);
                this.I.requestLayout();
                this.I.getViewTreeObserver().addOnGlobalLayoutListener(this.e);
            }
        } catch (Throwable th) {
            fh.I(g, "adapterView error, %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void V(Context context) {
        if (bg.I()) {
            Bitmap bitmapV = ac.V(getResources().getDrawable(R.drawable.hiad_feedback_right_arrow));
            ImageView imageView = (ImageView) findViewById(R.id.why_this_ad_right_arrow);
            if (imageView != null) {
                imageView.setImageBitmap(bitmapV);
            }
            ImageView imageView2 = (ImageView) findViewById(R.id.splash_feedback_right_arrow);
            if (imageView2 != null) {
                imageView2.setImageBitmap(bitmapV);
            }
        }
    }

    public DomesticDsaView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void Code(Context context) {
        try {
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.hiad_domestic_dsa_view, this);
            this.I = viewInflate.findViewById(R.id.dom_dsa_view_root);
            this.B = viewInflate.findViewById(R.id.dsa_scrollview);
            this.m = viewInflate.findViewById(R.id.splash_feedback_line);
            this.k = (RelativeLayout) viewInflate.findViewById(R.id.splash_feedback_btn);
            this.l = (TextView) viewInflate.findViewById(R.id.splash_feedback_tv);
            this.n = (RelativeLayout) viewInflate.findViewById(R.id.why_this_ad_btn);
            this.o = (TextView) viewInflate.findViewById(R.id.why_this_ad_tv);
        } catch (Throwable th) {
            fh.I(g, "initView error, %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void I(Context context) {
        if (q.B(context) || (q.S(context) && q.F(context))) {
            this.C = 0.4f;
        } else {
            this.C = h;
        }
    }

    public DomesticDsaView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    public void Code(boolean z, PPSLabelView.d dVar) {
        this.f = Boolean.valueOf(z);
        this.q = dVar;
    }
}
