package com.bytedance.sdk.openadsdk.core.ja.nr;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.dw;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private static Map<String, Integer> fx = new HashMap();
    private static String nr;
    private static String u;

    static {
        if (b.u()) {
            nr = Build.SUPPORTED_ABIS[0];
        } else {
            nr = Build.CPU_ABI;
        }
        fx.put("arm64-v8a", 64);
        fx.put("armeabi-v7a", 32);
        fx.put("armeabi", 32);
        fx.put("x86_64", 64);
        fx.put("x86", 32);
        fx.put("mips64", 64);
        fx.put("mips", 32);
        u = nr();
    }

    private static JSONObject fx() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("primaryCpuAbi", "0");
            jSONObject.put("processMode", "0");
            jSONObject.put("supportedABI0", "0");
            jSONObject.put("matchCpuAbi", "0");
            jSONObject.put("defaultABI0", "0");
            jSONObject.put("defaultABI", "0");
            jSONObject.put("autoError", "0");
            jSONObject.put("manualError", "0");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private static String nr() {
        JSONObject jSONObjectFx = fx();
        String strU = u(jSONObjectFx);
        return strU == null ? nr(jSONObjectFx) : strU;
    }

    private static Map<String, List<ZipEntry>> u(ZipFile zipFile) {
        String[] strArrSplit;
        HashMap map = new HashMap();
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        Pattern patternCompile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            if (!zipEntryNextElement.isDirectory() && patternCompile.matcher(zipEntryNextElement.getName()).matches() && (strArrSplit = zipEntryNextElement.getName().split(File.separator)) != null && strArrSplit.length >= 2) {
                String str = strArrSplit[strArrSplit.length - 2];
                if (fx.containsKey(str)) {
                    if (map.get(str) == null) {
                        map.put(str, new LinkedList());
                    }
                    ((List) map.get(str)).add(zipEntryNextElement);
                }
            }
        }
        zipFile.getName();
        return map;
    }

    private static String nr(JSONObject jSONObject) {
        HashSet hashSet;
        String[] strArr;
        try {
            Context context = dw.getContext();
            ZipFile zipFile = new ZipFile(new File(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir));
            hashSet = new HashSet(u(zipFile).keySet());
            try {
                zipFile.close();
            } catch (IOException unused) {
            }
            strArr = b.u() ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        } catch (Throwable th) {
            k.u("NativeLibHelper", "NativeLibHelper inferHostAbiManual failed!", th);
            u(jSONObject, "manualError", "1");
        }
        if (hashSet.isEmpty()) {
            u(jSONObject, "supportedABI0", strArr[0]);
            return strArr[0];
        }
        for (String str : strArr) {
            if (hashSet.contains(str)) {
                u(jSONObject, "matchCpuAbi", str);
                return str;
            }
        }
        if (b.u()) {
            String[] strArr2 = Build.SUPPORTED_ABIS;
            u(jSONObject, "defaultABI0", strArr2[0]);
            return strArr2[0];
        }
        String str2 = Build.CPU_ABI;
        u(jSONObject, "defaultABI", str2);
        return str2;
    }

    public static String u() {
        String str = u;
        if (str != null) {
            return str;
        }
        String strNr = nr();
        u = strNr;
        return strNr;
    }

    private static String u(JSONObject jSONObject) {
        int i;
        if (!b.u()) {
            return null;
        }
        try {
            String str = (String) u.u(dw.getContext().getApplicationInfo(), "primaryCpuAbi");
            u(jSONObject, "primaryCpuAbi", str);
            if (str == null) {
                return null;
            }
            if (b.nr()) {
                try {
                    i = Process.is64Bit() ? 64 : 32;
                } catch (Exception unused) {
                    i = 0;
                }
            } else {
                i = 0;
            }
            u(jSONObject, "processMode", String.valueOf(i));
            if (i != 0) {
                if (fx.get(str).intValue() != i) {
                    return null;
                }
            }
            return str;
        } catch (Exception e) {
            k.u("NativeLibHelper", "NativeLibHelper inferHostAbiAuto failed!", e);
            u(jSONObject, "autoError", "1");
            return null;
        }
    }

    private static void u(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException unused) {
        }
    }
}
