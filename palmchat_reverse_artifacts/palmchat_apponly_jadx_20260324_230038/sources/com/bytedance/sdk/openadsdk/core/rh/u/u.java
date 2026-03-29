package com.bytedance.sdk.openadsdk.core.rh.u;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.bytedance.sdk.component.a.nr.fx;
import com.bytedance.sdk.openadsdk.ats.b;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.gi.pn;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.rh.nr;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.oplus.tblplayer.monitor.sdk.SysPerformanceCollector;
import com.ss.android.download.api.constant.BaseConstants;
import com.umeng.analytics.pro.bt;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements nr {
    private static final FileFilter nr = new FileFilter() { // from class: com.bytedance.sdk.openadsdk.core.rh.u.u.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith(bt.w)) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (!Character.isDigit(name.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    };
    private static volatile u u;

    /* JADX WARN: Removed duplicated region for block: B:13:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int a() {
        int iNr = nr(dw.getContext());
        int iJk = jk();
        int i = 2;
        if (iNr != 0 && iNr != 1 && iJk != 0) {
            if (iNr != 2 || iJk <= 0) {
                i = iNr > 2 ? iJk > 1 ? 0 : 1 : -1000;
            }
        }
        u("ram_level", String.valueOf(iNr));
        u("cpu_level", String.valueOf(iJk));
        u("update_time", String.valueOf(System.currentTimeMillis()));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ram", iNr);
            jSONObject.put(bt.w, iJk);
            jSONObject.put("level", i);
        } catch (JSONException unused) {
        }
        s.u().pn(jSONObject);
        u(i);
        return i;
    }

    public static int b() {
        try {
            int iNr = nr("/sys/devices/system/cpu/possible");
            if (iNr == -1) {
                iNr = nr("/sys/devices/system/cpu/present");
            }
            return iNr == -1 ? new File("/sys/devices/system/cpu/").listFiles(nr).length : iNr;
        } catch (NullPointerException | SecurityException unused) {
            return -1;
        }
    }

    public static int fx() {
        int iIntValue = -1;
        for (int i = 0; i < b(); i++) {
            try {
                File file = new File(SysPerformanceCollector.SYS_CPU_INFO_ROOT_PATH + i + SysPerformanceCollector.SYS_CPU_MAX_FREQ_FILE);
                if (file.exists() && file.canRead()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        int i2 = 0;
                        while (Character.isDigit(bArr[i2]) && i2 < 128) {
                            i2++;
                        }
                        Integer numValueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i2)));
                        if (numValueOf.intValue() > iIntValue) {
                            iIntValue = numValueOf.intValue();
                        }
                    } catch (NumberFormatException unused) {
                    } catch (Throwable th) {
                        fileInputStream.close();
                        throw th;
                    }
                    fileInputStream.close();
                }
            } catch (IOException unused2) {
                return -1;
            }
        }
        if (iIntValue == -1) {
            FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
            try {
                int iU = u("cpu MHz", fileInputStream2) * 1000;
                if (iU > iIntValue) {
                    iIntValue = iU;
                }
                fileInputStream2.close();
            } catch (Throwable th2) {
                fileInputStream2.close();
                throw th2;
            }
        }
        return iIntValue;
    }

    private static int jk() {
        int iFx = fx() / 1000;
        if (iFx <= 1600) {
            return 0;
        }
        if (iFx <= 2000) {
            return 1;
        }
        return iFx <= 2500 ? 2 : 3;
    }

    private void n() {
        try {
            fx fxVarFx = pn.u().nr().fx();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("os", "android");
            jSONObject.put("device_model", Build.MODEL);
            fxVarFx.u(Uri.parse(jp.n("/api/ad/union/sdk/device_score")).buildUpon().appendQueryParameter("is_bidding", "1").appendQueryParameter(BaseConstants.EVENT_LABEL_EXTRA, com.bytedance.sdk.component.utils.u.nr(jSONObject.toString())).toString());
            com.bytedance.sdk.component.a.nr nrVarU = fxVarFx.u();
            if (nrVarU == null || !nrVarU.a()) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject(nrVarU.pn());
            if (jSONObject2.optInt("code") != 200) {
                u("bytebench_value", "-1.0");
                return;
            }
            double dOptDouble = jSONObject2.optDouble("score");
            u("bytebench_update_time", String.valueOf(System.currentTimeMillis()));
            u("bytebench_value", String.valueOf(dOptDouble));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("score", dOptDouble);
            s.u().iz(jSONObject3);
        } catch (Exception unused) {
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("score", -1);
                s.u().iz(jSONObject4);
            } catch (JSONException unused2) {
            }
        }
    }

    public static u u() {
        if (u == null) {
            synchronized (u.class) {
                if (u == null) {
                    u = new u();
                }
            }
        }
        return u;
    }

    public boolean iz() {
        String strU = u("update_time");
        return strU.isEmpty() || System.currentTimeMillis() - Long.parseLong(strU) >= 15552000000L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.nr
    public String nr() {
        return "DeviceRate";
    }

    public void pn() {
        if (dw.nr().gz() && iz()) {
            a();
        }
        if (dw.nr().qv() && x()) {
            n();
        }
    }

    public boolean x() {
        String strU = u("bytebench_update_time");
        return strU.isEmpty() || System.currentTimeMillis() - Long.parseLong(strU) >= 15552000000L;
    }

    private static int nr(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String line = bufferedReader.readLine();
                bufferedReader.close();
                int iFx = fx(line);
                fileInputStream.close();
                return iFx;
            } finally {
            }
        } catch (IOException unused) {
            return -1;
        }
    }

    @TargetApi(16)
    public static long u(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    private static int nr(Context context) {
        long jU = u(context) / 1048576;
        if (jU <= 2000) {
            return 0;
        }
        if (jU <= 3000) {
            return 1;
        }
        if (jU <= 4000) {
            return 2;
        }
        return jU <= 6000 ? 3 : 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0034, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int u(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int i = fileInputStream.read(bArr);
            int i2 = 0;
            while (i2 < i) {
                byte b = bArr[i2];
                if (b == 10 || i2 == 0) {
                    if (b == 10) {
                        i2++;
                    }
                    for (int i3 = i2; i3 < i; i3++) {
                        int i4 = i3 - i2;
                        if (bArr[i3] == str.charAt(i4)) {
                            if (i4 == str.length() - 1) {
                                return u(bArr, i3);
                            }
                        }
                    }
                }
                i2++;
            }
            return -1;
        } catch (IOException | NumberFormatException unused) {
            return -1;
        }
    }

    private static int u(byte[] bArr, int i) {
        byte b;
        while (i < bArr.length && (b = bArr[i]) != 10) {
            if (Character.isDigit(b)) {
                int i2 = i + 1;
                while (i2 < bArr.length && Character.isDigit(bArr[i2])) {
                    i2++;
                }
                return Integer.parseInt(new String(bArr, 0, i, i2 - i));
            }
            i++;
        }
        return -1;
    }

    private static int fx(String str) {
        if (str == null || !str.matches("0-[\\d]+$")) {
            return -1;
        }
        return Integer.valueOf(str.substring(2)).intValue() + 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.nr
    public String u(String str) {
        return b.u(nr()).get(str, "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.nr
    public void u(String str, String str2) {
        b.u(nr()).put(str, str2);
    }

    private void u(int i) {
        u("device_level", String.valueOf(i));
        com.bytedance.sdk.openadsdk.core.fx.b.u().n(i);
    }
}
