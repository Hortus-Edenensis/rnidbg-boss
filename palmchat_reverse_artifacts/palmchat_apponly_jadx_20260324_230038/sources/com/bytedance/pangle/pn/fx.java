package com.bytedance.pangle.pn;

import android.app.Application;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.a;
import com.bytedance.sdk.openadsdk.api.iz;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.oplus.tblplayer.Constants;
import com.tide.protocol.util.TdFileUtils;
import java.io.File;
import java.io.FileFilter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private static File fx;
    private static File nr;
    private static File u;

    public static String a(String str, int i) {
        return u(str, "version-".concat(String.valueOf(i)), "secondary-dexes");
    }

    public static String b() {
        Application appApplication = Zeus.getAppApplication();
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return null;
            }
            File externalFilesDir = appApplication.getExternalFilesDir(".pangle" + a.nr);
            if (externalFilesDir != null) {
                return u(externalFilesDir);
            }
            return null;
        } catch (Exception e) {
            iz.u(e);
            return null;
        }
    }

    public static String fx() {
        Application appApplication = Zeus.getAppApplication();
        if (fx == null) {
            fx = new File(appApplication.getFilesDir(), ".pangle" + a.u);
        }
        return u(fx);
    }

    public static String iz(String str, int i) {
        return new File(u(str, "version-".concat(String.valueOf(i)), "apk")).getPath();
    }

    public static boolean jk(@NonNull String str, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(u());
        String str2 = File.separator;
        sb.append(str2);
        sb.append(str);
        sb.append(str2);
        sb.append("version-");
        sb.append(i);
        return new File(sb.toString()).exists();
    }

    public static String l(String str, int i) {
        return new File(u(str, "version-".concat(String.valueOf(i)), com.igexin.push.core.b.Y), "config.json").getPath();
    }

    public static String n(String str, int i) {
        return com.bytedance.pangle.util.a.s() ? u(str, "version-".concat(String.valueOf(i)), "apk", "temp", TdFileUtils.FILE_OAT, com.bytedance.pangle.iz.nr.u()) : u(str, "version-".concat(String.valueOf(i)), "dalvik-cache");
    }

    public static String nr() {
        Application appApplication = Zeus.getAppApplication();
        if (nr == null) {
            File downloadDir = GlobalParam.getInstance().getDownloadDir();
            if (downloadDir == null) {
                downloadDir = new File(appApplication.getFilesDir(), ".pangle" + a.nr);
            }
            nr = downloadDir;
        }
        return u(nr);
    }

    private static void pn() {
        if (u == null) {
            File file = new File(Zeus.getAppApplication().getFilesDir(), MediationConstant.ADN_PANGLE + a.fx);
            u = file;
            u(file);
        }
    }

    public static File[] t(String str, int i) {
        String strU = u(str, "version-".concat(String.valueOf(i)), "dex");
        if (TextUtils.isEmpty(strU)) {
            return null;
        }
        return new File(strU).listFiles(new FileFilter() { // from class: com.bytedance.pangle.pn.fx.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file.isFile() && file.getName().endsWith(".dex");
            }
        });
    }

    public static String u(File file) {
        if (file == null) {
            return null;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public static String x(String str, int i) {
        return new File(u(str, "version-".concat(String.valueOf(i)), "apk", "temp")).getPath();
    }

    public static String pn(String str, int i) {
        return new File(u(str, "version-".concat(String.valueOf(i)), "apk", "temp"), "base-1.apk").getPath();
    }

    private static String u(String... strArr) {
        pn();
        File file = u;
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    file = new File(file, str);
                }
            }
        }
        return u(file);
    }

    public static String fx(String str, int i) {
        if (com.bytedance.pangle.util.a.s()) {
            return u(str, "version-".concat(String.valueOf(i)), "apk", TdFileUtils.FILE_OAT, com.bytedance.pangle.iz.nr.u());
        }
        return u(str, "version-".concat(String.valueOf(i)), "dalvik-cache");
    }

    public static String b(String str, int i) {
        return u(str, "version-".concat(String.valueOf(i)), Constants.LIBRARY_PREFIX);
    }

    public static String nr(String str, int i) {
        return new File(u(str, "version-".concat(String.valueOf(i)), "apk"), "base-1.apk").getPath();
    }

    public static String u() {
        pn();
        return u.getPath();
    }

    public static String u(String str, int i) {
        pn();
        File file = u;
        String[] strArr = {str, "version-".concat(String.valueOf(i))};
        for (int i2 = 0; i2 < 2; i2++) {
            String str2 = strArr[i2];
            if (!TextUtils.isEmpty(str2)) {
                file = new File(file, str2);
            }
        }
        if (file != null) {
            return file.getPath();
        }
        return null;
    }

    public static String u(String str) {
        return u(str);
    }

    public static String u(String str, int i, String str2) {
        return new File(u(str, "version-".concat(String.valueOf(i)), "dex"), str2).getPath();
    }
}
