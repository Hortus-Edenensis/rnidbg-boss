package com.bytedance.embedapplog;

import android.content.Context;
import android.net.Uri;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.qiniu.android.collect.ReportItem;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class rh {
    public static JSONObject u(Context context, JSONObject jSONObject, boolean z) {
        byte[] bytes;
        JSONObject jSONObjectU;
        byte[] bytes2 = new byte[0];
        try {
            bytes2 = jSONObject.toString().getBytes("UTF-8");
            String strClientPackedBase64 = TTEncryptUtils.clientPackedBase64(bytes2, bytes2.length);
            if (bg.nr()) {
                bg.u("__kite", "请求体整体进行sword加密：加密内容：".concat(String.valueOf(jSONObject)));
                bg.fx("__kite", "请求体整体进行sword加密：加密结果：".concat(String.valueOf(strClientPackedBase64)));
            }
            bytes = strClientPackedBase64.getBytes("UTF-8");
        } catch (Exception e) {
            bg.b("__kite", "error: " + e.getMessage());
            bytes = bytes2;
        }
        if (bytes == null) {
            bg.fx("__kite", "data is null ");
            return new JSONObject();
        }
        try {
            jSONObjectU = u(context, Uri.parse("https://toblog.ctobsnssdk.com/service/2/device_sdk/kite/").buildUpon().appendQueryParameter(ReportItem.RequestKeyRequestId, UUID.randomUUID().toString()).build().toString(), bytes, z);
        } catch (Exception e2) {
            bg.nr("__kiteerror " + e2.getMessage());
            jSONObjectU = null;
        }
        return jSONObjectU == null ? new JSONObject() : jSONObjectU;
    }

    public static JSONObject u(Context context, String str, byte[] bArr, boolean z) {
        String strU;
        try {
            if (gb.pn()) {
                try {
                    strU = rv.u(context, str, bArr, null, false, false);
                } catch (RuntimeException e) {
                    bg.b("__kite", "error " + e.getMessage());
                    strU = rv.u(context, str, bArr, "application/json; charset=utf-8", true, true);
                }
            } else {
                try {
                    strU = rv.u(context, str, bArr, "application/json; charset=utf-8", false, true);
                } catch (Exception e2) {
                    bg.b("__kite", "error " + e2.getMessage());
                    strU = "";
                }
            }
        } catch (Exception e3) {
            bg.b("__kite", "network error " + e3.getMessage());
            strU = "";
        }
        try {
            return new JSONObject(strU);
        } catch (Exception e4) {
            bg.b("__kite", "error: " + e4.getMessage());
            return new JSONObject();
        }
    }
}
