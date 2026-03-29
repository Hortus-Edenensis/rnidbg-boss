package com.opos.acs.st.utils;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.nt.crypt.EncryptUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class e {
    public static String a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strExecuteEncryptStringV3 = EncryptUtils.executeEncryptStringV3(str, 0);
        f.a("LocalEncryptUtils", "encrypt value " + str + " to " + strExecuteEncryptStringV3);
        if (TextUtils.isEmpty(strExecuteEncryptStringV3)) {
            g.a(context).a(ErrorContants.errorContantseMap(context, "5", ErrorContants.LOCAL_EN_ERROR, "", "-1", 0L, 0L, str));
            return str;
        }
        return "@en_v1_" + strExecuteEncryptStringV3;
    }

    public static String b(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.startsWith("@en_v1_")) {
            try {
                String strSubstring = str.substring(7);
                String strExecuteDecryptStringV3 = EncryptUtils.executeDecryptStringV3(strSubstring, 0);
                if (TextUtils.isEmpty(strExecuteDecryptStringV3)) {
                    g.a(context).a(ErrorContants.errorContantseMap(context, "5", ErrorContants.LOCAL_DE_ERROR, "", "-1", 0L, 0L, strSubstring));
                } else {
                    strSubstring = strExecuteDecryptStringV3;
                }
                f.a("LocalEncryptUtils", "decrypt value " + str + " to " + strSubstring);
                return strSubstring;
            } catch (Exception e) {
                f.c("LocalEncryptUtils", "decryptValue", e);
            }
        }
        return str;
    }
}
