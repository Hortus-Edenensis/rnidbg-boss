package com.tide.host.a;

import android.text.TextUtils;
import com.tide.protocol.host.model.PluginInfo;
import com.tide.protocol.util.TdLogUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class q0 {
    public static PluginInfo a(String str) {
        TdLogUtils.log("TdStringUtils", "stringToPluginInfo is:" + str);
        if (TextUtils.isEmpty(str)) {
            TdLogUtils.log("TdStringUtils", "stringToPluginInfo is empty");
            return null;
        }
        PluginInfo pluginInfo = new PluginInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            pluginInfo.setPluginName(jSONObject.optString("pgn"));
            pluginInfo.setPackageName(jSONObject.optString("pan"));
            pluginInfo.setPluginPath(jSONObject.optString("pgp"));
            pluginInfo.setPluginVCode(jSONObject.optInt("vc"));
            pluginInfo.setPluginVName(jSONObject.optString("vn"));
            pluginInfo.setHostVCode(jSONObject.optInt("hvc"));
            pluginInfo.setFrameVCode(jSONObject.optInt("fvc"));
            pluginInfo.setMd5(jSONObject.optString("md5"));
            pluginInfo.setPluginFrom(jSONObject.optString("from"));
            pluginInfo.setLoadTime(System.currentTimeMillis());
        } catch (Throwable th) {
            TdLogUtils.error("TdStringUtils", "stringToPluginInfo " + th.getMessage());
        }
        return pluginInfo;
    }

    public static String a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            int i = 0;
            while (i < 1024) {
                int i2 = inputStream.read(bArr, 0, Math.min(1024, 1024 - i));
                if (i2 == -1) {
                    break;
                }
                i += i2;
                byteArrayOutputStream.write(bArr, 0, i2);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            String str = new String(byteArray, 0, Math.min(byteArray.length, 1024), StandardCharsets.UTF_8);
            try {
                byteArrayOutputStream.close();
                return str;
            } catch (IOException e) {
                e.printStackTrace();
                return str;
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return "";
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
