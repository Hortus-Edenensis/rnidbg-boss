package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.metadata.Om;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class gr {
    private static final String Code = "AdSessionAgentFactory";

    public static hm Code(Context context, AdContentData adContentData, gl glVar, boolean z) {
        hg hgVarCode;
        if (adContentData == null || context == null) {
            return new gu();
        }
        if (z && (glVar == null || glVar.getOpenMeasureView() == null)) {
            fh.V(Code, "MeasureView is null");
            return new gu();
        }
        if (!gq.Code()) {
            return new gu();
        }
        fh.Code(Code, "AdSessionAgent is avalible");
        gq gqVar = new gq();
        List<Om> listAj = adContentData.aj();
        if (listAj == null) {
            fh.V(Code, "Oms is null");
            return gqVar;
        }
        if (adContentData.t() != null || (adContentData.u() != null && "video/mp4".equals(adContentData.u().Code()))) {
            fh.V(Code, "Video adsession");
            hj hjVar = hj.VIDEO;
            ho hoVar = ho.VIEWABLE;
            hp hpVar = hp.NATIVE;
            hgVarCode = hg.Code(hjVar, hoVar, hpVar, hpVar, false);
        } else {
            hgVarCode = hg.Code(hj.NATIVE_DISPLAY, ho.VIEWABLE, hp.NATIVE, hp.NONE, false);
        }
        if (hgVarCode == null) {
            return gqVar;
        }
        fh.V(Code, "init adSessionAgent");
        gqVar.Code(context, listAj, hgVarCode);
        if (z) {
            gqVar.Code(glVar.getOpenMeasureView());
        }
        return gqVar;
    }
}
