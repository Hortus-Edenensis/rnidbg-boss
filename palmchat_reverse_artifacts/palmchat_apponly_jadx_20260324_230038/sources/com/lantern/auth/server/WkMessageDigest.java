package com.lantern.auth.server;

import com.lantern.auth.core.BLMessageDigest;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class WkMessageDigest extends BLMessageDigest {
    public static String sign(Map<String, String> map, String str) {
        Object[] array = map.keySet().toArray();
        Arrays.sort(array);
        StringBuffer stringBuffer = new StringBuffer();
        for (Object obj : array) {
            stringBuffer.append(map.get(obj));
        }
        stringBuffer.append(str);
        return BLMessageDigest.md5(stringBuffer.toString());
    }
}
