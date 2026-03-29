package com.beizi.ad.lance.a;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class h {
    public static final File a(Context context) {
        File fileB = b(context);
        if (fileB == null) {
            return null;
        }
        File file = new File(fileB.getPath() + "/Beizi/download/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static void b(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(268435456);
                context.startActivity(launchIntentForPackage);
            }
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(context, "启动失败:" + str, 1).show();
        }
    }

    public static File c(Context context) {
        return context.getCacheDir();
    }

    public static File d(Context context) {
        File file = new File(context.getCacheDir().getPath() + "/beizi/material/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static void e(Context context) {
        File[] fileArrListFiles;
        try {
            File fileD = d(context);
            if (!fileD.exists() || (fileArrListFiles = fileD.listFiles()) == null) {
                return;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date(System.currentTimeMillis() - 1296000000);
            for (File file : fileArrListFiles) {
                if (file.isFile()) {
                    try {
                        if (simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(file.lastModified()))).before(date)) {
                            file.delete();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static File f(Context context) {
        File file = new File(context.getCacheDir().getPath() + "/beizi/ad/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static void g(Context context) {
        File[] fileArrListFiles;
        File[] fileArrListFiles2;
        if (context == null) {
            return;
        }
        try {
            File fileF = f(context);
            if (fileF.exists() && fileF.isDirectory() && (fileArrListFiles = fileF.listFiles()) != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(System.currentTimeMillis() - 86400000);
                for (File file : fileArrListFiles) {
                    if (file.isDirectory() && (fileArrListFiles2 = file.listFiles()) != null) {
                        try {
                            for (File file2 : fileArrListFiles2) {
                                if (file2.isFile() && simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(file2.lastModified()))).before(date)) {
                                    file2.delete();
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static File b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            File externalFilesDir = ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) ? context.getExternalFilesDir(null) : null;
            return externalFilesDir == null ? context.getFilesDir() : externalFilesDir;
        } catch (Exception unused) {
            return context.getFilesDir();
        }
    }

    public static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return context.getPackageManager().getApplicationInfo(str, 0) != null;
    }

    public static void a(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static void b(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            File fileF = f(context);
            if (fileF.exists() && fileF.isDirectory()) {
                File file = new File(fileF.getPath() + "/" + str + "/", str2);
                if (file.exists()) {
                    file.delete();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean a(Context context, String str, String str2, String str3) {
        FileWriter fileWriter;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(f(context).getPath() + "/" + str + "/");
            if (!file.exists()) {
                file.mkdirs();
            }
            fileWriter = new FileWriter(new File(file, str2), false);
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter);
                try {
                    bufferedWriter2.write(str3);
                    try {
                        bufferedWriter2.close();
                        fileWriter.close();
                        return true;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return true;
                    }
                } catch (Throwable th2) {
                    bufferedWriter = bufferedWriter2;
                    th = th2;
                    try {
                        th.printStackTrace();
                        if (bufferedWriter != null) {
                            try {
                            } catch (Throwable th3) {
                                return false;
                            }
                        }
                        return false;
                    } finally {
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (Throwable th32) {
                                th32.printStackTrace();
                            }
                        }
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            fileWriter = null;
        }
    }

    public static String a(Context context, String str, String str2) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            File file = new File(f(context).getPath() + "/" + str + "/", str2);
            if (!file.exists()) {
                return null;
            }
            fileReader = new FileReader(file);
            try {
                if (!fileReader.ready()) {
                    try {
                        fileReader.close();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    return null;
                }
                bufferedReader = new BufferedReader(fileReader);
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    }
                    String string = sb.toString();
                    try {
                        bufferedReader.close();
                        fileReader.close();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    return string;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } catch (Throwable th5) {
            th = th5;
            fileReader = null;
            bufferedReader = null;
        }
        try {
            th.printStackTrace();
            return null;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
            }
            if (fileReader != null) {
                fileReader.close();
            }
        }
    }
}
