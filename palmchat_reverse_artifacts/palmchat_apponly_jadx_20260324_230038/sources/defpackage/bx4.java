package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class bx4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f1846a;

    public static boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            z = str.length() != 16;
            try {
                Long.parseLong(str);
            } catch (Exception e) {
                e.printStackTrace();
                z = true;
            }
        }
        if (z) {
            HashMap map = new HashMap();
            map.put("errorUid", str);
            LogUtil.log4ClientError("RequestTokenNotMatchChecker_" + str2, map, null, true);
        }
        return z;
    }

    public static String b(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArrCipherWithType = z ? EncryptUtils.cipherWithType(Base64.decode(str.getBytes(), 2), 5, nl0.k()) : EncryptUtils.cipherWithType(com.squareup.okhttp.internal.Base64.decode(str.getBytes()), 5, nl0.k());
            if (bArrCipherWithType != null) {
                return new String(bArrCipherWithType, StandardCharsets.UTF_8);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean c(String str, String str2, boolean z) {
        if (d(str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        String strB = b(str, z);
        if (TextUtils.isEmpty(strB) || strB.startsWith(str2)) {
            return true;
        }
        HashMap map = new HashMap();
        map.put("requestUid", str2);
        map.put("token", str);
        LogUtil.log4ClientError("RequestTokenNotMatchChecker_checkFail", map, null, true);
        return false;
    }

    public static boolean d(String str) {
        boolean z = !TextUtils.isEmpty(f1846a) && !TextUtils.isEmpty(str) && f1846a.length() >= 10 && str.length() >= 10 && str.startsWith(f1846a);
        if (!TextUtils.isEmpty(str) && str.length() >= 10) {
            f1846a = str.substring(0, 10);
        }
        return z;
    }

    public static void e(String str) {
        String strB;
        String strGenerateMessageToken;
        String strGenerateMessageToken2;
        String strB2;
        if (str != null) {
            Uri uri = Uri.parse(str);
            String queryParameter = uri.getQueryParameter(DeviceInfoUtil.UID_TAG);
            String queryParameter2 = uri.getQueryParameter("token");
            String strB3 = b(queryParameter2, false);
            if (TextUtils.isEmpty(strB3) || strB3.startsWith(queryParameter)) {
                strB = null;
                strGenerateMessageToken = null;
                strGenerateMessageToken2 = null;
            } else {
                strGenerateMessageToken = EncryptUtils.generateMessageToken();
                strB = b(strGenerateMessageToken, false);
                if (!TextUtils.isEmpty(strB) && !strB.startsWith(queryParameter)) {
                    strGenerateMessageToken2 = EncryptUtils.generateMessageToken(true);
                    strB2 = b(strGenerateMessageToken, true);
                    HashMap map = new HashMap();
                    map.put("url", str);
                    map.put("requestUid", queryParameter);
                    map.put("token", queryParameter2);
                    map.put("token2", strB3);
                    map.put("testToken", strGenerateMessageToken);
                    map.put("testOriToken", strB);
                    map.put("testToken2", strGenerateMessageToken2);
                    map.put("testOriToken2", strB2);
                    LogUtil.log4ClientError("RequestTokenNotMatchChecker_httpAuth2", map, null, true);
                }
                strGenerateMessageToken2 = null;
            }
            strB2 = strGenerateMessageToken2;
            HashMap map2 = new HashMap();
            map2.put("url", str);
            map2.put("requestUid", queryParameter);
            map2.put("token", queryParameter2);
            map2.put("token2", strB3);
            map2.put("testToken", strGenerateMessageToken);
            map2.put("testOriToken", strB);
            map2.put("testToken2", strGenerateMessageToken2);
            map2.put("testOriToken2", strB2);
            LogUtil.log4ClientError("RequestTokenNotMatchChecker_httpAuth2", map2, null, true);
        }
    }
}
