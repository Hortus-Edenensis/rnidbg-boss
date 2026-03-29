package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.ii;
import com.huawei.hms.ads.lp;
import com.huawei.hms.ads.splash.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class PPSImageView extends PPSBaseView implements lp {
    private ImageView c;

    public PPSImageView(Context context) {
        super(context);
        Code(context);
        this.B = new ii(context, this);
    }

    private void Code(Context context) {
        View.inflate(context, R.layout.hiad_view_image_ad, this);
        this.c = (ImageView) findViewById(R.id.iv_ad_content);
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.lv
    public boolean C() {
        return true;
    }

    @Override // com.huawei.hms.ads.lp
    public void Code(Drawable drawable) {
        fh.V("PPSImageView", "onAdImageLoaded - set image to view");
        this.c.setImageDrawable(drawable);
        this.B.Code(this.F);
    }
}
