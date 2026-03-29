package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ke {
    private static final String Code = "BtnUriActionFactory";

    public static kr Code(Context context, AdContentData adContentData, Map<String, String> map, List<Integer> list) {
        if (context == null || adContentData == null || map == null) {
            return new km();
        }
        List<kr> listV = V(context, adContentData, map, list);
        if (listV == null || listV.size() <= 0) {
            return new km();
        }
        kr krVar = null;
        for (kr krVar2 : listV) {
            if (krVar != null) {
                krVar.Code(krVar2);
            }
            krVar = krVar2;
        }
        return listV.get(0);
    }

    private static List<kr> V(Context context, AdContentData adContentData, Map<String, String> map, List<Integer> list) {
        kr kmVar;
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Integer num : list) {
            int iIntValue = num.intValue();
            if (iIntValue == 0) {
                kmVar = new km();
            } else if (iIntValue != 14) {
                fh.I(Code, "unsupport action:" + num);
                kmVar = null;
            } else {
                kmVar = new kg(context, adContentData, true, map);
            }
            if (kmVar != null) {
                arrayList.add(kmVar);
            }
        }
        return arrayList;
    }
}
