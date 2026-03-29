package com.huawei.openalliance.ad.utils;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class m {
    private static final int Code = 0;

    public static Map<Integer, String> Code(Context context, Map<String, String> map) {
        HashMap map2 = new HashMap();
        if (!al.Code(map)) {
            Code(context, "title", map, map2);
            Code(context, "content", map, map2);
            Code(context, com.huawei.openalliance.ad.constant.x.cw, map, map2);
            Code(context, com.huawei.openalliance.ad.constant.x.cx, map, map2);
        }
        return map2;
    }

    private static void Code(Context context, String str, Map<String, String> map, Map<Integer, String> map2) {
        List list = (List) ad.V(map.get(str), List.class, new Class[0]);
        if (ag.Code(list)) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int identifier = context.getResources().getIdentifier((String) it.next(), "id", context.getPackageName());
            if (identifier != 0) {
                map2.put(Integer.valueOf(identifier), str);
            }
        }
    }
}
