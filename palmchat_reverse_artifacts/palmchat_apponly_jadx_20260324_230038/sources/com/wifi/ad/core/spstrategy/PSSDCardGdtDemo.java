package com.wifi.ad.core.spstrategy;

import android.os.Environment;
import android.text.TextUtils;
import com.wifi.ad.core.utils.WifiLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class PSSDCardGdtDemo {
    public static String getSdCardDemo(String str) {
        try {
            String str2 = getsdfile("gdtadtest.txt");
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            JSONObject jSONObject = new JSONObject(str2);
            WifiLog.d("SPAD getSdCardDemo gdtOb " + jSONObject + " adcode:" + str);
            return jSONObject.optString(str);
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getsdfile(String str) {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), str);
            StringBuffer stringBuffer = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    return stringBuffer.toString();
                }
                stringBuffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
