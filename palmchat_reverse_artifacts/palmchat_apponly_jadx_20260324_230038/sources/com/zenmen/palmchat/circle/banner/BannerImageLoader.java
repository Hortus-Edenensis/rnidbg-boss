package com.zenmen.palmchat.circle.banner;

import android.content.Context;
import com.zenmen.palmchat.circle.bean.CircleLoopBean;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.bq6;
import defpackage.gr2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class BannerImageLoader implements ImageLoaderInterface<EffectiveShapeView> {
    @Override // com.zenmen.palmchat.circle.banner.ImageLoaderInterface
    public EffectiveShapeView createImageView(Context context) {
        EffectiveShapeView effectiveShapeView = new EffectiveShapeView(context);
        effectiveShapeView.changeShapeType(3);
        return effectiveShapeView;
    }

    @Override // com.zenmen.palmchat.circle.banner.ImageLoaderInterface
    public void displayImage(Context context, Object obj, EffectiveShapeView effectiveShapeView) {
        if (obj instanceof CircleLoopBean.LoopData) {
            gr2.j().h(((CircleLoopBean.LoopData) obj).cover, effectiveShapeView, bq6.s());
        }
    }
}
