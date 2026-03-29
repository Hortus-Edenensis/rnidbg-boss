package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class nr {
    public static boolean b(Context context) {
        File file = new File(context.getFilesDir(), "/pangle_p/com.byted.pangle");
        if (!file.exists()) {
            return false;
        }
        final StringBuilder sb = new StringBuilder("^version-(\\d+)$");
        File[] fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.api.plugin.nr.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                if (file2 == null) {
                    return false;
                }
                try {
                    Matcher matcher = Pattern.compile(sb.toString()).matcher(file2.getName());
                    String strGroup = matcher.find() ? matcher.group() : "";
                    return (TextUtils.isEmpty(strGroup) ? 0 : Integer.parseInt(strGroup.substring(8))) > 7232;
                } catch (Exception e) {
                    com.bytedance.sdk.openadsdk.api.iz.u(e);
                    return file2.getName().matches(sb.toString());
                }
            }
        });
        return (fileArrListFiles == null || fileArrListFiles.length == 0) ? false : true;
    }

    public static File fx(Context context) {
        return u(new File(context.getExternalCacheDir(), "pangle_com.byted.pangle"));
    }

    public static File nr(Context context) {
        return u(new File(context.getCacheDir(), "pangle_com.byted.pangle"));
    }

    private static File u(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static SharedPreferences nr(Context context, String str, int i) {
        return i == 0 ? com.bytedance.sdk.openadsdk.ats.b.u(context, u(str), i) : com.bytedance.sdk.openadsdk.ats.b.u(context, str, i);
    }

    public static File u(Context context) {
        return u(new File(context.getFilesDir(), "pangle_com.byted.pangle"));
    }

    public static File u(Context context, String str) {
        return u(new File(context.getExternalFilesDir(str), "pangle_com.byted.pangle"));
    }

    public static File u(Context context, String str, int i) {
        return i == 0 ? u(new File(context.getDir(str, i), "pangle_com.byted.pangle")) : context.getDir(str, i);
    }

    private static String u(String str) {
        return "pangle_com.byted.pangle_" + str;
    }
}
