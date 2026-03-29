package com.bytedance.sdk.component.panglearmor.u;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.bytedance.sdk.component.panglearmor.SoftDecTool;
import com.bytedance.sdk.component.panglearmor.u.nr.iz;
import com.bytedance.sdk.openadsdk.api.plugin.nr;
import com.cdo.oaps.ad.OapsWrapper;
import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static u u;
    private long nr = 0;

    private boolean fx() {
        SharedPreferences sharedPreferences = SoftDecTool.getSharedPreferences(SoftDecTool.SP_NAME);
        if (sharedPreferences == null) {
            return false;
        }
        this.nr = (System.currentTimeMillis() / 1000) - SoftDecTool.fr();
        int i = sharedPreferences.getInt("hit_times", 0);
        if (i < 2 && this.nr >= 172800) {
            sharedPreferences.edit().putInt("hit_times", 2).apply();
            return nr();
        }
        if (i != 0 || this.nr < 21600) {
            return false;
        }
        sharedPreferences.edit().putInt("hit_times", 1).apply();
        return nr();
    }

    private boolean nr() {
        return new SecureRandom().nextInt(10) == 1;
    }

    public static u u() {
        if (u == null) {
            synchronized (u.class) {
                if (u == null) {
                    u uVar = new u();
                    u = uVar;
                    uVar.nr = 0L;
                }
            }
        }
        return u;
    }

    private String nr(Context context) {
        if (context == null) {
            return null;
        }
        String packageCodePath = context.getPackageCodePath();
        if (TextUtils.isEmpty(packageCodePath)) {
            return null;
        }
        File file = new File(packageCodePath);
        if (file.exists() && file.canRead()) {
            return packageCodePath;
        }
        return null;
    }

    public synchronized JSONObject u(Context context, String str) {
        String strNr;
        JSONObject jSONObject = new JSONObject();
        try {
            strNr = nr(context);
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(strNr) && fx()) {
            File file = new File(strNr);
            if (file.exists()) {
                jSONObject = u(file, context, str);
            }
            return jSONObject;
        }
        return null;
    }

    private JSONObject u(File file, Context context, String str) {
        JSONObject jSONObjectU = iz.u(file);
        File fileU = nr.u(context);
        if (fileU != null) {
            iz.u(jSONObjectU, "files", u(!TextUtils.isEmpty(str) ? nr.u(context).getParent() : nr.u(context).getPath()), false);
            File parentFile = fileU.getParentFile();
            if (parentFile != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(!TextUtils.isEmpty(str) ? parentFile.getParent() : parentFile.getPath());
                sb.append("/shared_prefs");
                List<String> listU = u(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(!TextUtils.isEmpty(str) ? parentFile.getParent() : parentFile.getPath());
                sb2.append("/databases");
                List<String> listU2 = u(sb2.toString());
                iz.u(jSONObjectU, "prefs", listU, false);
                iz.u(jSONObjectU, "databases", listU2, false);
            }
        }
        try {
            JSONObject jSONObjectU2 = u(context);
            if (jSONObjectU2 != null && jSONObjectU2.length() > 0) {
                jSONObjectU.put("manifest", jSONObjectU2);
            }
            jSONObjectU.put("rt", this.nr);
            jSONObjectU.put(OapsWrapper.KEY_PATH, str);
        } catch (JSONException unused) {
        }
        return jSONObjectU;
    }

    private List<String> u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isFile() && file2.exists()) {
                    arrayList.add(file2.getName());
                }
            }
        }
        return arrayList;
    }

    private JSONObject u(Context context) {
        if (context == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String packageName = context.getPackageName();
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 4239);
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null) {
                jSONObject.put("application_name", applicationInfo.name);
                jSONObject.put("label", packageManager.getApplicationLabel(applicationInfo));
            }
            if (packageInfo != null) {
                ActivityInfo[] activityInfoArr = packageInfo.activities;
                String[] strArr = packageInfo.requestedPermissions;
                ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                ProviderInfo[] providerInfoArr = packageInfo.providers;
                if (activityInfoArr != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        jSONArray.put(activityInfo.name);
                    }
                    jSONObject.put("activities", jSONArray);
                }
                if (strArr != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (String str : strArr) {
                        jSONArray2.put(str);
                    }
                    jSONObject.put("permissions", jSONArray2);
                }
                if (activityInfoArr2 != null) {
                    JSONArray jSONArray3 = new JSONArray();
                    for (ActivityInfo activityInfo2 : activityInfoArr2) {
                        jSONArray3.put(activityInfo2.name);
                    }
                    jSONObject.put("receivers", jSONArray3);
                }
                if (serviceInfoArr != null) {
                    JSONArray jSONArray4 = new JSONArray();
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        jSONArray4.put(serviceInfo.name);
                    }
                    jSONObject.put("services", jSONArray4);
                }
                if (providerInfoArr != null) {
                    JSONArray jSONArray5 = new JSONArray();
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        jSONArray5.put(providerInfo.name);
                    }
                    jSONObject.put("providers", jSONArray5);
                }
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}
