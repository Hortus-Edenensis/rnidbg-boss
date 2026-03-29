package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.io;
import com.huawei.hms.ads.jb;
import com.huawei.hms.ads.mb;
import com.huawei.hms.ads.mg;
import com.huawei.openalliance.ad.utils.bj;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class SloganView extends RelativeLayout implements mb {
    private int B;
    private int C;
    private float D;
    private View F;
    private jb I;
    private int S;

    public SloganView(Context context, int i, int i2) {
        super(context);
        this.C = 0;
        this.S = 1;
        this.B = i;
        V(i2);
    }

    public void V() {
        setVisibility(8);
    }

    public int getOrientation() {
        return this.S;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        fh.Code("SloganView", "onSizeChanged w: %d h: %d oldw: %d oldh: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        Code(i, i2);
    }

    public void setSloganShowListener(mg mgVar) {
        this.I.Code(mgVar);
    }

    public void setWideSloganResId(int i) {
        this.C = i;
    }

    public SloganView(Context context, int i, int i2, int i3) {
        super(context);
        this.C = 0;
        this.S = i;
        this.B = i2;
        V(i3);
    }

    private void V(int i) {
        this.I = new io(getContext(), this);
    }

    public void Code() {
        if (this.F == null) {
            this.I.Code(this.B, true);
        }
        setVisibility(0);
    }

    @Override // com.huawei.hms.ads.mb
    public void Code(final int i) {
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.SloganView.1
            @Override // java.lang.Runnable
            public void run() {
                ImageView imageView;
                if (SloganView.this.F instanceof ImageView) {
                    imageView = (ImageView) SloganView.this.F;
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    SloganView.this.removeAllViews();
                    imageView = new ImageView(SloganView.this.getContext());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    SloganView.this.F = imageView;
                    SloganView.this.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
                }
                imageView.setImageResource(i);
            }
        });
    }

    private void Code(int i, int i2) {
        int i3;
        String str;
        if (i <= 0 || i2 <= 0) {
            return;
        }
        float f = (i * 1.0f) / i2;
        float fAbs = Math.abs(this.D - f);
        fh.Code("SloganView", "ratio: %s diff: %s", Float.valueOf(f), Float.valueOf(fAbs));
        if (fAbs > 0.01f) {
            this.D = f;
            if (f <= 0.9f || (i3 = this.C) <= 0) {
                i3 = this.B;
                str = "pick defaultSloganResId";
            } else {
                str = "pick wideSloganResId";
            }
            fh.Code("SloganView", str);
            this.I.Code(i3, false);
        }
    }
}
