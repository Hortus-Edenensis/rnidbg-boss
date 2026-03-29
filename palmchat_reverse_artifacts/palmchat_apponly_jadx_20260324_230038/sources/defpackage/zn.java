package defpackage;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class zn {
    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes("UTF-8"));
            return vn.a(messageDigest.digest());
        } catch (UnsupportedEncodingException e) {
            v.c(e);
            return "";
        } catch (NoSuchAlgorithmException e2) {
            v.c(e2);
            return "";
        }
    }

    public static String b(Map<String, String> map, String str) {
        Object[] array = map.keySet().toArray();
        Arrays.sort(array);
        StringBuffer stringBuffer = new StringBuffer();
        for (Object obj : array) {
            stringBuffer.append(map.get(obj));
        }
        stringBuffer.append(str);
        return a(stringBuffer.toString());
    }
}
