package com.huawei.openalliance.ad.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.ld;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.ImageInfo;
import com.huawei.openalliance.ad.inter.data.l;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.bg;
import com.huawei.openalliance.ad.utils.t;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c {
    public static void Code(Context context, l lVar, AdContentData adContentData) {
        ImageInfo imageInfo;
        fh.Code("NativeActivityStarter", "startComplianceActivity");
        if (Code(lVar)) {
            return;
        }
        try {
            Intent intent = new Intent(context, (Class<?>) PPSShareActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("title", lVar.Code());
            intent.putExtra("description", lVar.V());
            if (lVar.B() != null && !lVar.B().isEmpty() && (imageInfo = lVar.B().get(0)) != null) {
                intent.putExtra(ld.f, ad.V(imageInfo));
                intent.putExtra(ld.f6599a, imageInfo.Z());
            }
            intent.putExtra("cshareUrl", lVar.aC());
            intent.putExtra("contentId", lVar.d());
            intent.putExtra("slotId", lVar.r());
            intent.putExtra("templateId", lVar.av());
            intent.putExtra(ld.g, ad.V(adContentData));
            bg.Code(context, intent);
        } catch (Throwable th) {
            fh.I("NativeActivityStarter", "start Activity error: %s", th.getClass().getSimpleName());
        }
    }

    private static boolean Code(l lVar) {
        String str;
        if (t.Code()) {
            str = "repeat click too fast";
        } else {
            if (lVar != null) {
                return false;
            }
            str = "nativeAd is null";
        }
        fh.Code("NativeActivityStarter", str);
        return true;
    }
}
