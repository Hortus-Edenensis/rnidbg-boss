package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.utils.z;
import com.huawei.openalliance.ad.views.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c extends a {
    public c(Context context) {
        super(context);
        this.V.Code(context.getResources().getDrawable(R.drawable.hiad_app_down_btn_normal_hm));
        a.C0459a c0459a = this.V;
        Resources resources = context.getResources();
        int i = R.color.hiad_down_btn_white;
        c0459a.Code(resources.getColor(i));
        LayerDrawable layerDrawable = (LayerDrawable) Code(context, R.drawable.hiad_app_down_btn_processing_hm);
        Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(android.R.id.progress);
        if (drawableFindDrawableByLayerId instanceof ClipDrawable) {
            h hVar = new h(drawableFindDrawableByLayerId, 17, 1);
            layerDrawable.mutate();
            layerDrawable.setDrawableByLayerId(android.R.id.progress, hVar);
            this.I.Code(layerDrawable);
        } else {
            fh.I("ExtandAppDownloadButtonStyleHm", "not clipDrawable");
            this.I.Code(Code(context, R.drawable.hiad_app_down_btn_processing));
        }
        this.I.Code(context.getResources().getColor(R.color.hiad_emui_black));
        LayerDrawable layerDrawable2 = (LayerDrawable) Code(context, R.drawable.hiad_app_down_btn_installing_hm);
        if (layerDrawable2.findDrawableByLayerId(android.R.id.progress) instanceof ClipDrawable) {
            f fVar = new f(z.V(context, 18.0f));
            layerDrawable2.mutate();
            layerDrawable2.setDrawableByLayerId(android.R.id.progress, fVar);
            this.Z.Code(layerDrawable2);
            fVar.Code();
        } else {
            fh.I("ExtandAppDownloadButtonStyleHm", "not clipDrawable");
            this.Z.Code(Code(context, R.drawable.hiad_app_down_btn_installing));
        }
        this.Z.Code(context.getResources().getColor(i));
    }
}
