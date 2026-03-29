package com.zm.fda;

import android.content.Context;
import android.text.TextUtils;
import com.zm.fda.FobDeviceIdClient;
import com.zm.fda.O52OZ.ZZ050;
import com.zm.fda.oaid.Z0225;
import com.zm.fda.utils.EventLog;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FobDeviceIdClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16618a = "FobDeviceIdClient";

    public static /* synthetic */ void a(Context context, String str, String str2, boolean z) {
        HashMap map = new HashMap();
        if (z) {
            a(context, str2, str);
            map.put("oaid", str2);
            map.put("result", 1);
            Z0225.oaid = str2;
            com.zm.fda.oaid.Z2500.Z25O0.b(f16618a, "oaid:" + str2);
        }
        com.zm.fda.oaid.Z2500.Z25O0.b(f16618a, "get oaid:" + str2 + " and send fda track");
        ZZ00Z.a(map);
    }

    public static boolean checkoutOAID(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.equals(str, "00000000-0000-0000-0000-000000000000")) ? false : true;
    }

    public static String getOaid() {
        return Z0225.oaid;
    }

    public static void initOaidGetter(final Context context, boolean z) {
        final String strB = null;
        try {
            String strA = ZZ050.a(context, com.zm.fda.Z200O.ZZ00Z.g, com.zm.fda.Z200O.ZZ00Z.k, "");
            if (TextUtils.isEmpty(strA)) {
                strB = ZZ050.a(context, com.zm.fda.Z200O.ZZ00Z.g, com.zm.fda.Z200O.ZZ00Z.j, "");
                ZZ050.a(context, com.zm.fda.Z200O.ZZ00Z.g, com.zm.fda.Z200O.ZZ00Z.j);
                a(context, strB, "");
            } else {
                strB = com.zm.fda.OOZ20.ZZ00Z.b(strA);
            }
            EventLog.d(f16618a, "initOaidGetter getSpOaid:" + strB);
            Z0225.oaid = strB;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (context != null && z) {
            Z0225.getInstance().register(context, new Z0225.ZZ00Z() { // from class: p02
                @Override // com.zm.fda.oaid.Z0225.ZZ00Z
                public final void a(String str, boolean z2) {
                    FobDeviceIdClient.a(context, strB, str, z2);
                }
            });
            return;
        }
        HashMap map = new HashMap();
        map.put("oaid", "");
        map.put("result", 0);
        map.put("code", 101);
        ZZ00Z.a(map);
        com.zm.fda.oaid.Z2500.Z25O0.a(f16618a, "oaidGetEnable = false, 不开启");
    }

    public static void a(Context context, String str, String str2) {
        if (TextUtils.equals(str, str2)) {
            return;
        }
        String strB = com.zm.fda.OOZ20.ZZ00Z.b(str.getBytes(StandardCharsets.UTF_8));
        EventLog.d(f16618a, "updateSp encryptOaid:" + strB);
        ZZ050.b(context, com.zm.fda.Z200O.ZZ00Z.g, com.zm.fda.Z200O.ZZ00Z.k, strB);
    }
}
