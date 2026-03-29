package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import com.wifi.adsdk.utils.BLHexDump;
import com.wifi.adsdk.utils.WkSecretKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ja5 {
    public static String a(File file) throws Throwable {
        MessageDigest messageDigest;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            byte[] bArr = new byte[2014];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i <= 0) {
                    break;
                }
                messageDigest.update(bArr, 0, i);
            }
            String hexString = BLHexDump.toHexString(messageDigest.digest());
            try {
                fileInputStream.close();
            } catch (IOException e2) {
                ma3.c(e2);
            }
            return hexString;
        } catch (Exception e3) {
            e = e3;
            fileInputStream2 = fileInputStream;
            ma3.c(e);
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e4) {
                    ma3.c(e4);
                }
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e5) {
                    ma3.c(e5);
                }
            }
            throw th;
        }
    }

    public static String b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes("UTF-8"));
            return BLHexDump.toHexString(messageDigest.digest());
        } catch (UnsupportedEncodingException e) {
            ma3.c(e);
            return "";
        } catch (NoSuchAlgorithmException e2) {
            ma3.c(e2);
            return "";
        }
    }

    public static Map<String, String> c(String str, Map<String, String> map, String str2, String str3) {
        String string = new JSONObject(map).toString();
        map.clear();
        try {
            map.put("appId", str2);
            if (!TextUtils.isEmpty(str)) {
                map.put("pid", str);
            }
            map.put("ed", WkSecretKey.encryptAES(Uri.encode(string.trim(), "UTF-8"), str3.substring(0, 16), str3.substring(16, 32)));
            map.put("et", "a");
            map.put("st", "m");
            map.put("ts", System.currentTimeMillis() + "");
            map.put("sign", d(map, str3));
        } catch (Exception e) {
            ma3.c(e);
        }
        return map;
    }

    public static String d(Map<String, String> map, String str) {
        Object[] array = map.keySet().toArray();
        Arrays.sort(array);
        StringBuffer stringBuffer = new StringBuffer();
        for (Object obj : array) {
            stringBuffer.append(map.get(obj));
        }
        stringBuffer.append(str);
        return b(stringBuffer.toString());
    }
}
