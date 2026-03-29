package com.kwad.sdk.core.track;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.monitor.FraudVerifyCode;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {
    private static List<String> a(AdTemplate adTemplate, int i, @NonNull com.kwad.sdk.core.adlog.c.a aVar) {
        List<String> list;
        ArrayList arrayList = new ArrayList();
        AdInfo adInfoEr = e.er(adTemplate);
        List<AdInfo.AdTrackInfo> list2 = adInfoEr.adTrackInfoList;
        if (ap.L(list2)) {
            return arrayList;
        }
        List<String> listA = a(i, aVar, arrayList, adInfoEr, list2);
        if (listA != null) {
            return listA;
        }
        Iterator<AdInfo.AdTrackInfo> it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdInfo.AdTrackInfo next = it.next();
            if (next.type == i && (list = next.urls) != null) {
                arrayList.addAll(list);
                break;
            }
        }
        return arrayList;
    }

    public static void e(@NonNull com.kwad.sdk.core.adlog.c.a aVar) {
        AdTemplate adTemplate = aVar.adTemplate;
        AdInfo adInfoEr = e.er(adTemplate);
        int i = aVar.aAV;
        List<String> listA = a(adTemplate, i, aVar);
        if (ap.L(listA)) {
            return;
        }
        boolean zDy = com.kwad.sdk.core.response.b.a.dy(adInfoEr);
        boolean zDz = com.kwad.sdk.core.response.b.a.dz(adInfoEr);
        for (String str : listA) {
            com.kwad.sdk.commercial.j.a.o(adTemplate, i, str);
            if (adTemplate.isCheatingFlow()) {
                com.kwad.sdk.commercial.j.a.n(adTemplate, i, str);
                return;
            }
            if (bw.hR(str)) {
                com.kwad.sdk.commercial.j.a.a(adTemplate, i, str, "", FraudVerifyCode.RerwardFraudUnknown, "", 0);
                return;
            }
            HashMap map = null;
            String strA = ai.a(ServiceProvider.getContext(), str, i == 2 ? aVar.mJ : null, com.kwad.sdk.core.response.b.a.aC(e.er(adTemplate)));
            ai.f(adTemplate, str, strA);
            AdHttpProxy adHttpProxyCm = g.Cm();
            int i2 = adHttpProxyCm instanceof com.kwad.sdk.core.network.c.a ? 2 : 1;
            c.d("AdTrackUtil", "handleTrackUrl useKwaiUA: " + zDy);
            if (zDy) {
                com.kwad.sdk.core.i.c cVarJ = com.kwad.sdk.core.i.a.j(zDy, zDz);
                c.d("AdTrackUtil", "handleTrackUrl uaGetter: " + cVarJ);
                if (cVarJ != null) {
                    map = new HashMap();
                    map.put("User-Agent", cVarJ.LK());
                }
            }
            com.kwad.sdk.core.network.c cVarDoGetWithoutResponse = adHttpProxyCm.doGetWithoutResponse(strA, map, !zDy);
            if (ec(cVarDoGetWithoutResponse.code)) {
                c.d("AdTrackUtil", "trackUrl request success actionType: " + i);
                com.kwad.sdk.commercial.j.a.a(adTemplate, i, str, cVarDoGetWithoutResponse.code, i2);
            } else {
                com.kwad.sdk.commercial.j.a.a(adTemplate, i, str, strA, com.kwad.sdk.commercial.e.cM(cVarDoGetWithoutResponse.code), cVarDoGetWithoutResponse.aIW, i2);
            }
        }
    }

    private static boolean ec(int i) {
        return i >= 200 && i < 300;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
    
        r4.addAll(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static List<String> a(int i, com.kwad.sdk.core.adlog.c.a aVar, List<String> list, AdInfo adInfo, List<AdInfo.AdTrackInfo> list2) {
        int iOptInt;
        if (i != 402 || !com.kwad.sdk.core.response.b.a.bp(adInfo)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(aVar.PI)) {
                iOptInt = new JSONObject(aVar.PI).optInt("photoPlaySecond");
            } else {
                iOptInt = aVar.aCm;
            }
            JSONObject jSONObject = new JSONObject(adInfo.adBaseInfo.videoPlayedNSConfig);
            Iterator<AdInfo.AdTrackInfo> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AdInfo.AdTrackInfo next = it.next();
                if (next.type == jSONObject.optInt(String.valueOf(iOptInt)) && (r6 = next.urls) != null) {
                    break;
                }
            }
        } catch (Throwable unused) {
        }
        return list;
    }
}
