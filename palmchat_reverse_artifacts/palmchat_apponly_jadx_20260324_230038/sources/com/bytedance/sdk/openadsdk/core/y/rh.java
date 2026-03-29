package com.bytedance.sdk.openadsdk.core.y;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class rh {
    /* JADX INFO: Access modifiers changed from: private */
    public static void fx(com.bytedance.sdk.openadsdk.core.kj.bc bcVar, Double d) {
        if (bcVar == null || bcVar.sj() == null) {
            return;
        }
        bcVar.pm().fx(1);
        try {
            Object obj = bcVar.sj().get("sdk_bidding_type");
            if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                String strReplace = (String) bcVar.sj().get("nurl");
                if (TextUtils.isEmpty(strReplace)) {
                    return;
                }
                if (d != null) {
                    strReplace = strReplace.replace("${AUCTION_BID_TO_WIN}", String.valueOf(d));
                }
                com.bytedance.sdk.openadsdk.core.dw.u().u(u(bcVar, strReplace, "${AUCTION_EXT}"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void u(final com.bytedance.sdk.openadsdk.core.kj.bc bcVar, final Double d) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("win") { // from class: com.bytedance.sdk.openadsdk.core.y.rh.1
                @Override // java.lang.Runnable
                public void run() {
                    rh.fx(bcVar, d);
                }
            });
        } else {
            fx(bcVar, d);
        }
    }

    public static void u(final com.bytedance.sdk.openadsdk.core.kj.bc bcVar, final Double d, final String str, final String str2) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("loss") { // from class: com.bytedance.sdk.openadsdk.core.y.rh.2
                @Override // java.lang.Runnable
                public void run() {
                    rh.fx(bcVar, d, str, str2);
                }
            });
        } else {
            fx(bcVar, d, str, str2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034 A[PHI: r0
      0x0034: PHI (r0v3 java.lang.String) = (r0v2 java.lang.String), (r0v5 java.lang.String) binds: [B:8:0x001b, B:13:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String u(com.bytedance.sdk.openadsdk.core.kj.bc bcVar, String str, String str2) throws Exception {
        String strOptString;
        int iIntValue;
        if (bcVar == null || str == null || !str.contains(str2)) {
            return str;
        }
        Pair<Integer, JSONObject> pairU = com.bytedance.sdk.openadsdk.core.fx.iz.u().u(bcVar.ap(), false);
        strOptString = "";
        if (pairU == null) {
            iIntValue = 3;
        } else {
            Object obj = pairU.second;
            strOptString = obj != null ? ((JSONObject) obj).optString("message") : "";
            Object obj2 = pairU.first;
            if (obj2 != null) {
                iIntValue = ((Integer) obj2).intValue();
            }
        }
        if (iIntValue != 3) {
            try {
                if (TextUtils.isEmpty(new URL(str).getQuery())) {
                    str = str + "?abort_aes=1";
                } else {
                    str = str + "&abort_aes=1";
                }
            } catch (Exception unused) {
            }
        }
        return str.replace(str2, URLEncoder.encode(strOptString, "UTF-8"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fx(com.bytedance.sdk.openadsdk.core.kj.bc bcVar, Double d, String str, String str2) {
        if (bcVar == null || bcVar.sj() == null) {
            return;
        }
        try {
            bcVar.pm().fx(2);
            Object obj = bcVar.sj().get("sdk_bidding_type");
            if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                String strReplace = (String) bcVar.sj().get("lurl");
                if (TextUtils.isEmpty(strReplace)) {
                    return;
                }
                if (d != null) {
                    strReplace = strReplace.replace("${AUCTION_PRICE}", String.valueOf(d));
                }
                if (str != null) {
                    strReplace = strReplace.replace("${AUCTION_LOSS}", str);
                }
                if (str2 != null) {
                    strReplace = strReplace.replace("${AUCTION_WINNER}", str2);
                }
                com.bytedance.sdk.openadsdk.core.dw.u().u(u(bcVar, strReplace, "${AUCTION_EXT}"));
            }
        } catch (Throwable unused) {
        }
    }
}
