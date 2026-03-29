package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ks {
    private static final String Code = "ks";

    public static kr Code(Context context, AdContentData adContentData, Map<String, String> map) {
        if (context == null || adContentData == null || map == null) {
            return new km();
        }
        List<kr> listCode = Code(context, adContentData, map, adContentData.q());
        if (com.huawei.openalliance.ad.utils.ag.Code(listCode)) {
            return new km();
        }
        kr krVar = null;
        for (kr krVar2 : listCode) {
            if (krVar != null) {
                krVar.Code(krVar2);
            }
            krVar = krVar2;
        }
        return listCode.get(0);
    }

    private static List<kr> Code(Context context, AdContentData adContentData, Map<String, String> map, List<Integer> list) {
        if (com.huawei.openalliance.ad.utils.ag.Code(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size() + 1);
        Code(context, adContentData, arrayList);
        kr kmVar = null;
        for (Integer num : list) {
            switch (num.intValue()) {
                case 0:
                    kmVar = new km();
                    break;
                case 1:
                    kmVar = new kl(context, adContentData, false, map);
                    break;
                case 2:
                    kmVar = new kk(context, adContentData, map);
                    break;
                case 3:
                    kmVar = new kb(context, adContentData);
                    break;
                case 4:
                    kmVar = new kl(context, adContentData, true, map);
                    break;
                case 5:
                    kmVar = new ko(context, adContentData);
                    break;
                case 6:
                    kmVar = new kd(context, adContentData);
                    break;
                case 7:
                    kmVar = new kc(context, adContentData);
                    break;
                case 8:
                    kmVar = new kn(context, adContentData);
                    break;
                case 9:
                    kmVar = new kq(context, adContentData);
                    break;
                case 10:
                default:
                    fh.I(Code, "unsupport action:" + num);
                    kmVar = null;
                    break;
                case 11:
                    kmVar = new ki(context, adContentData);
                    break;
                case 12:
                    kmVar = new kf(context, adContentData);
                    break;
                case 13:
                    if (kt.Code(context)) {
                        kmVar = new kp(context, adContentData);
                    }
                    break;
                case 14:
                    kmVar = new kg(context, adContentData, true, map);
                    break;
            }
            if (kmVar != null) {
                kmVar.I(num.intValue());
                arrayList.add(kmVar);
            }
        }
        return arrayList;
    }

    private static void Code(Context context, AdContentData adContentData, List<kr> list) {
        String str = Code;
        fh.V(str, "start add agent action");
        if (adContentData == null || adContentData.S() == null || !com.huawei.openalliance.ad.utils.g.Code(context, adContentData.S().p())) {
            return;
        }
        list.add(new ka(context, adContentData));
        fh.Code(str, "in decouple add agent action success");
    }
}
