package com.kwad.sdk.commercial;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.bp;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class e {
    private static String a(@NonNull AdMatrixInfo.MatrixTemplate matrixTemplate) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(matrixTemplate.templateId);
        stringBuffer.append("#");
        stringBuffer.append(matrixTemplate.templateVersionCode);
        return stringBuffer.toString();
    }

    public static BusinessType bh(AdTemplate adTemplate) {
        return adTemplate == null ? BusinessType.OTHER : cL(com.kwad.sdk.core.response.b.e.el(adTemplate));
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0038  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AdMatrixInfo.MatrixTemplate bi(AdTemplate adTemplate) {
        String str;
        AdMatrixInfo.MatrixTemplate matrixTemplateK = null;
        if (adTemplate.mAdScene == null) {
            return null;
        }
        AdMatrixInfo.AdDataV2 adDataV2 = com.kwad.sdk.core.response.b.b.ct(adTemplate).adDataV2;
        int iEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (iEl == 2) {
            str = adDataV2.neoTKInfo.templateId;
        } else if (iEl == 3) {
            str = adDataV2.fullScreenInfo.templateId;
        } else if (iEl == 4) {
            str = adDataV2.splashPlayCardTKInfo.templateId;
        } else if (iEl == 6) {
            str = adDataV2.drawTKCardInfo.templateId;
        } else if (iEl == 13) {
            str = adDataV2.interstitialCardInfo.templateId;
        } else if (iEl == 23) {
            int iEJ = com.kwad.sdk.core.response.b.e.eJ(adTemplate);
            str = iEJ == 1 ? adDataV2.fullScreenInfo.templateId : iEJ == 2 ? adDataV2.interstitialCardInfo.templateId : "";
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<AdMatrixInfo.MatrixTemplate> it = com.kwad.sdk.core.response.b.b.cu(adTemplate).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdMatrixInfo.MatrixTemplate next = it.next();
            if (bp.isEquals(str, next.templateId)) {
                matrixTemplateK = next;
                break;
            }
        }
        if (matrixTemplateK == null) {
            matrixTemplateK = com.kwad.sdk.core.response.b.b.k(adTemplate, str);
        }
        if (matrixTemplateK != null) {
            matrixTemplateK.publishType = ((h) ServiceProvider.get(h.class)).cu(a(matrixTemplateK));
        }
        return matrixTemplateK;
    }

    public static BusinessType cL(int i) {
        return i == 3 ? BusinessType.AD_FULLSCREEN : i == 2 ? BusinessType.AD_REWARD : i == 4 ? BusinessType.AD_SPLASH : (i == 13 || i == 23) ? BusinessType.AD_INTERSTITIAL : i == 1 ? BusinessType.AD_FEED : i == 10000 ? BusinessType.AD_NATIVE : BusinessType.OTHER;
    }

    public static int cM(int i) {
        if (i == -1) {
            return 100010;
        }
        if (i == -2) {
            return 100011;
        }
        return i;
    }
}
