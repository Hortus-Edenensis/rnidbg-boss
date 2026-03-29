package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import com.wifi.adsdk.entity.LxEventReplace;
import com.zm.fda.Z200O.ZZ00Z;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class ai {
    @WorkerThread
    public static String a(Context context, String str, aj.a aVar, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strAr = aj.ar(context, aj.a(str, aVar));
        String strDC = bd.dC(context);
        if (!TextUtils.isEmpty(strDC)) {
            strAr = strAr.replace("__MAC__", strDC).replace("__MAC2__", al.md5(strDC)).replace("__MAC3__", al.md5(strDC.replace(":", "")));
        }
        String strDA = bd.dA(context);
        if (!TextUtils.isEmpty(strDA)) {
            strAr = strAr.replace("__IMEI__", strDA).replace("__IMEI2__", al.md5(strDA)).replace("__IMEI3__", al.sha1(strDA));
        }
        String oaid = bd.getOaid();
        if (!TextUtils.isEmpty(oaid)) {
            strAr = strAr.replace(LxEventReplace.__OAID__, oaid).replace("__OAID2__", al.md5(oaid));
        }
        String strDB = bd.dB(context);
        if (!TextUtils.isEmpty(strDB)) {
            strAr = strAr.replace("__ANDROIDID2__", al.md5(strDB)).replace("__ANDROIDID3__", al.sha1(strDB)).replace("__ANDROIDID__", strDB);
        }
        return aj.d(context, strAr, z);
    }

    public static void f(AdTemplate adTemplate, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Context context = ServiceProvider.getContext();
        if (!TextUtils.isEmpty(bd.dC(context))) {
            if (str2.contains("__MAC__")) {
                arrayList.add("__MAC__");
            }
            if (str2.contains("__MAC2__")) {
                arrayList.add("__MAC2__");
            }
            if (str2.contains("__MAC3__")) {
                arrayList.add("__MAC3__");
            }
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.kwad.sdk.commercial.j.a.a(adTemplate, "MAC", str, str2, (String) it.next());
                }
                arrayList.clear();
            }
        }
        if (!TextUtils.isEmpty(bd.dA(context))) {
            if (str2.contains("__IMEI__")) {
                arrayList.add("__IMEI__");
            }
            if (str2.contains("__IMEI2__")) {
                arrayList.add("__IMEI2__");
            }
            if (str2.contains("__IMEI3__")) {
                arrayList.add("__IMEI3__");
            }
            if (!arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    com.kwad.sdk.commercial.j.a.a(adTemplate, "IMEI", str, str2, (String) it2.next());
                }
                arrayList.clear();
            }
        }
        if (!TextUtils.isEmpty(bd.getOaid())) {
            if (str2.contains(LxEventReplace.__OAID__)) {
                arrayList.add(LxEventReplace.__OAID__);
            }
            if (str2.contains("__OAID2__")) {
                arrayList.add("__OAID2__");
            }
            if (!arrayList.isEmpty()) {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    com.kwad.sdk.commercial.j.a.a(adTemplate, "OAID", str, str2, (String) it3.next());
                }
                arrayList.clear();
            }
        }
        if (TextUtils.isEmpty(bd.dB(context))) {
            return;
        }
        if (str2.contains("__ANDROIDID__")) {
            arrayList.add("__ANDROIDID__");
        }
        if (str2.contains("__ANDROIDID2__")) {
            arrayList.add("__ANDROIDID2__");
        }
        if (str2.contains("__ANDROIDID3__")) {
            arrayList.add("__ANDROIDID3__");
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            com.kwad.sdk.commercial.j.a.a(adTemplate, ZZ00Z.x, str, str2, (String) it4.next());
        }
        arrayList.clear();
    }
}
