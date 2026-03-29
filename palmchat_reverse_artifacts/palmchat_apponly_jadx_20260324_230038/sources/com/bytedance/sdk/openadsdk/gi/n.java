package com.bytedance.sdk.openadsdk.gi;

import com.huawei.hms.framework.common.ContainerUtils;
import com.oplus.tblplayer.Constants;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n {

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        public Map<String, String> nr;
        public String u;
    }

    public static String nr(String str) {
        u uVarU = u(str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map<String, String> map = uVarU.nr;
        if (map != null) {
            if (map.containsKey("v")) {
                linkedHashMap.put("v", uVarU.nr.get("v"));
                uVarU.nr.remove("v");
            }
            for (Map.Entry<String, String> entry : uVarU.nr.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return u(uVarU.u, linkedHashMap);
    }

    public static u u(String str) {
        u uVar = new u();
        if (str == null) {
            return uVar;
        }
        String strTrim = str.trim();
        if (strTrim.equals("")) {
            return uVar;
        }
        String[] strArrSplit = strTrim.split("\\?");
        uVar.u = strArrSplit[0];
        if (strArrSplit.length == 1) {
            return uVar;
        }
        String[] strArrSplit2 = strArrSplit[1].split(ContainerUtils.FIELD_DELIMITER);
        uVar.nr = new HashMap();
        for (String str2 : strArrSplit2) {
            String[] strArrSplit3 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (strArrSplit3.length >= 2) {
                uVar.nr.put(strArrSplit3[0], strArrSplit3[1]);
            }
        }
        return uVar;
    }

    private static String u(String str, LinkedHashMap<String, String> linkedHashMap) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            return sb.toString();
        }
        sb.append(str);
        boolean z = str.contains(Constants.STRING_VALUE_UNSET) || str.contains(ContainerUtils.FIELD_DELIMITER);
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            for (String str2 : linkedHashMap.keySet()) {
                if (!z) {
                    sb.append(Constants.STRING_VALUE_UNSET);
                    z = true;
                } else {
                    sb.append(ContainerUtils.FIELD_DELIMITER);
                }
                sb.append(str2);
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(linkedHashMap.get(str2));
            }
        }
        return sb.toString();
    }
}
