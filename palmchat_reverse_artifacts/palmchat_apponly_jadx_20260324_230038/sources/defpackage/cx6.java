package defpackage;

import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class cx6 extends b27 {
    public static String b(Map<String, String> map, String str) {
        Object[] array = map.keySet().toArray();
        Arrays.sort(array);
        StringBuffer stringBuffer = new StringBuffer();
        for (Object obj : array) {
            stringBuffer.append(map.get(obj));
        }
        stringBuffer.append(str);
        return b27.a(stringBuffer.toString());
    }
}
