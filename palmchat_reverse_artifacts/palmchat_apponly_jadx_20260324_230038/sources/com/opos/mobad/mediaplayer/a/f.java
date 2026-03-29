package com.opos.mobad.mediaplayer.a;

import android.content.Context;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f9003a = {"libffmpeg.so", "libffmpegJNI.so", "libPlatformJNI.so"};

    public static String a(Context context, String str) {
        return c(context, str) + "_temp";
    }

    public static String b(Context context, String str) {
        return c(context, str);
    }

    private static String c(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir().getAbsolutePath());
        String str2 = File.separator;
        sb.append(str2);
        sb.append(".mob_ad");
        sb.append(str2);
        sb.append(".tplay");
        sb.append(str2);
        sb.append(str);
        String string = sb.toString();
        com.opos.cmn.an.f.a.b("zipSoUtils", "getBasePath: " + string);
        return string;
    }

    private static boolean d(@NonNull File file) {
        for (int i = 1; i <= 3; i++) {
            if (file.delete()) {
                return true;
            }
            a(file, i);
            a(i);
        }
        return false;
    }

    private static void a(int i) {
        if (i < 3) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void b(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.opos.cmn.an.f.a.c("zipSoUtils", "Deleted invalid file: " + str);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("zipSoUtils", "Failed to delete invalid file", e);
        }
    }

    private static void c(@NonNull File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                a(file2);
            } else if (!d(file2)) {
                com.opos.cmn.an.f.a.c("zipSoUtils", "Failed to delete file: " + file2);
            }
        }
    }

    private static boolean d(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        for (String str2 : f9003a) {
            File file2 = new File(file, str2);
            file2.mkdirs();
            if (!file2.exists() || file2.length() == 0) {
                return false;
            }
            com.opos.cmn.an.f.a.a("zipSoUtils", "checkRequiredFiles " + str2);
        }
        return true;
    }

    public static void a(@NonNull File file) throws IOException {
        if (file.exists()) {
            c(file);
            if (d(file)) {
                return;
            }
            throw new IOException("Failed to delete directory: " + file);
        }
    }

    public static boolean b(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list == null) {
                return false;
            }
            for (String str : list) {
                if (!b(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    private static boolean c(String str) {
        File file = new File(str);
        String[] list = file.list();
        return file.isDirectory() && list != null && list.length > 0;
    }

    private static void a(File file, int i) {
        com.opos.cmn.an.f.a.c("zipSoUtils", "Retry delete [" + i + "/3] for: " + file.getAbsolutePath());
    }

    public static boolean a(String str) {
        return c(str) && d(str);
    }
}
