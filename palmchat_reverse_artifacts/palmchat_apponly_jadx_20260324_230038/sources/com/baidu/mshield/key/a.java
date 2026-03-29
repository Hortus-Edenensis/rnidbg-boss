package com.baidu.mshield.key;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.b.f.b;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.utility.d;
import java.security.PublicKey;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {
    public static boolean a(Context context) {
        PackageInfo packageInfo;
        Signature[] signatureArr;
        Signature signature;
        try {
            JSONObject jSONObject = new JSONObject();
            String packageName = context.getPackageName();
            jSONObject.put("pkg", packageName);
            try {
                packageInfo = context.getPackageManager().getPackageInfo(packageName, 64);
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
                packageInfo = null;
            }
            if (packageInfo != null) {
                PublicKey publicKeyA = b.a(packageInfo.applicationInfo.sourceDir);
                if (publicKeyA == null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0 && (signature = signatureArr[0]) != null) {
                    try {
                        publicKeyA = b.a(signature);
                    } catch (Throwable th2) {
                        com.baidu.mshield.utility.a.a(th2);
                    }
                }
                if (publicKeyA != null) {
                    byte[] encoded = publicKeyA.getEncoded();
                    if (encoded != null) {
                        com.baidu.mshield.utility.a.a(context, encoded);
                        jSONObject.put("sign", e.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", "")));
                    }
                } else {
                    jSONObject.put("sign", "");
                }
                jSONObject.put("app", packageName);
            } else {
                jSONObject.put("sign", "");
                jSONObject.put("app", "");
            }
            String strA = d.a(context, com.baidu.mshield.utility.a.f(context) + "p/1/auh", jSONObject.toString(), false, true);
            com.baidu.mshield.b.c.a.b("auh res:" + strA);
            JSONObject jSONObject2 = new JSONObject(strA);
            if (jSONObject2.length() <= 0 || jSONObject2.optInt("code") != 200) {
                return false;
            }
            String strOptString = jSONObject2.optString("ak");
            String strOptString2 = jSONObject2.optString("sk");
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
                return false;
            }
            com.baidu.mshield.utility.a.a(strOptString, strOptString2);
            com.baidu.mshield.sharedpreferences.a.a(context).d(strOptString, strOptString2);
            return true;
        } catch (Throwable th3) {
            com.baidu.mshield.utility.a.a(th3);
            return false;
        }
    }
}
