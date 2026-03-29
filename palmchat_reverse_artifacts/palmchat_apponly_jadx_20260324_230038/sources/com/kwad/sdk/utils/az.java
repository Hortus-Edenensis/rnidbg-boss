package com.kwad.sdk.utils;

import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.oplus.tblplayer.Constants;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class az {
    public static String appendUrl(@NonNull String str, Map<String, String> map) {
        String str2;
        if (map == null || map.size() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            str2 = ContainerUtils.FIELD_DELIMITER;
            if (!zHasNext) {
                break;
            }
            String next = it.next();
            if (map.get(next) != null) {
                sb.append(next);
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(map.get(next));
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
        }
        String strSubstring = sb.toString().substring(0, r6.length() - 1);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        if (!str.contains(Constants.STRING_VALUE_UNSET)) {
            str2 = Constants.STRING_VALUE_UNSET;
        }
        sb2.append(str2);
        return sb2.toString() + strSubstring;
    }
}
