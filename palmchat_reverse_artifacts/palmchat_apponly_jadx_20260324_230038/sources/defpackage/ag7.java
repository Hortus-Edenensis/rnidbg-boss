package defpackage;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.framework.common.ContainerUtils;
import com.lantern.auth.server.WkParams;
import com.tencent.matrix.trace.config.SharePluginInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ag7 {
    public static String a(String str, String str2, long j, int i, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, cw6 cw6Var) {
        String str12;
        HashMap map = new HashMap();
        map.put("specificId", str);
        map.put("reportReason", str2);
        map.put("ts", String.valueOf(j));
        map.put("businessVersion", o17.f(o17.a()));
        map.put("protocolVersion", "3");
        map.put("errorCode", String.valueOf(i));
        map.put(SharePluginInfo.ISSUE_SUB_TYPE, str3);
        map.put("brand", cc7.b());
        map.put(WkParams.MODEL, Build.MODEL);
        map.put("osVersion", cc7.c());
        map.put("romVersion", cc7.a());
        map.put("androidVersion", Build.VERSION.RELEASE);
        map.put(WkParams.IMEI, str4.replace("%23", "#"));
        map.put("openId", str5.replace("%23", "#"));
        map.put("tracePkg", str6);
        map.put("program", str7);
        if (!TextUtils.isEmpty(str8)) {
            map.put("fileName", str8);
        }
        if (!TextUtils.isEmpty(str9)) {
            map.put(MediationConstant.KEY_ERROR_MSG, str9);
        }
        String str13 = str10 + File.separator + str8;
        String strB = b(map);
        cw6Var.a("NearX-HLog", "签名生成空格替换前参数: " + strB + "url: " + str13);
        String strReplaceAll = strB.replaceAll(" ", "_");
        byte[] bytes = strReplaceAll.getBytes();
        byte[] bArrB = ae7.b(ae7.c(str13));
        if (bArrB == null) {
            Log.e("SecurityUtils", "log zip file is null");
            str12 = str11;
        } else {
            byte[] bArr = new byte[bytes.length + bArrB.length];
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
            System.arraycopy(bArrB, 0, bArr, bytes.length, bArrB.length);
            str12 = str11;
            bytes = bArr;
        }
        String strD = d(bytes, str12);
        cw6Var.a("NearX-HLog", "签名生成空格替换后参数: " + strReplaceAll + "url: " + str13 + "\n sign: " + strD);
        return strD;
    }

    public static String b(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        for (String str : arrayList) {
            sb.append(str);
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(map.get(str));
            sb.append(ContainerUtils.FIELD_DELIMITER);
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public static String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            if ((bArr[i] & UByte.MAX_VALUE) < 16) {
                sb.append("0");
            }
            sb.append(Long.toString(bArr[i] & UByte.MAX_VALUE, 16));
        }
        return sb.toString();
    }

    public static String d(byte[] bArr, String str) {
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(str.getBytes("UTF-8"), mac.getAlgorithm()));
            return c(mac.doFinal(bArr));
        } catch (Exception e) {
            throw new RuntimeException("HMAC-SHA1 encode error", e);
        }
    }
}
