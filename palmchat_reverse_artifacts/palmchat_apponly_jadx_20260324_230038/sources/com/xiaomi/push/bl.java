package com.xiaomi.push;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class bl {
    public static String a() {
        return Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL;
    }

    @TargetApi(9)
    public static byte[] a(String str) {
        byte[] bArrCopyOf = Arrays.copyOf(ay.m185a(str), 16);
        bArrCopyOf[0] = 68;
        bArrCopyOf[15] = 84;
        return bArrCopyOf;
    }

    public static String a(Context context) {
        String strA = bm.a(context).a("sp_client_report_status", "sp_client_report_key", "");
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        String strA2 = bb.a(20);
        bm.a(context).m212a("sp_client_report_status", "sp_client_report_key", strA2);
        return strA2;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m208a(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode >= 108;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.xmsf.push.XMSF_UPLOAD_ACTIVE");
        intent.putExtra("pkgname", context.getPackageName());
        intent.putExtra(com.huawei.openalliance.ad.constant.x.cw, "category_client_report_data");
        intent.putExtra("name", "quality_support");
        intent.putExtra("data", str);
        context.sendBroadcast(intent, "com.xiaomi.xmsf.permission.USE_XMSF_UPLOAD");
    }

    public static void a(Context context, List<String> list) {
        if (list == null || list.size() <= 0 || !m208a(context)) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                a(context, str);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x012f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, String str, String str2) throws Throwable {
        File file;
        RandomAccessFile randomAccessFile;
        Exception e;
        if (context == null || str == null || str2 == null) {
            return;
        }
        File file2 = new File(context.getFilesDir(), str2);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        File file3 = new File(context.getFilesDir(), str);
        if (!file3.exists()) {
            file3.mkdirs();
            return;
        }
        File[] fileArrListFiles = file3.listFiles(new FilenameFilter() { // from class: com.xiaomi.push.bl.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file4, String str3) {
                return (TextUtils.isEmpty(str3) || str3.toLowerCase().endsWith(".lock")) ? false : true;
            }
        });
        if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        FileLock fileLockLock = null;
        RandomAccessFile randomAccessFile2 = null;
        File file4 = null;
        for (File file5 : fileArrListFiles) {
            if (file5 != null) {
                try {
                } catch (Exception e2) {
                    file = file4;
                    randomAccessFile = randomAccessFile2;
                    e = e2;
                } catch (Throwable th) {
                    th = th;
                }
                if (!TextUtils.isEmpty(file5.getAbsolutePath())) {
                    file = new File(file5.getAbsolutePath() + ".lock");
                    try {
                        w.m789a(file);
                        randomAccessFile = new RandomAccessFile(file, "rw");
                        try {
                            try {
                                fileLockLock = randomAccessFile.getChannel().lock();
                                File file6 = new File(file2.getAbsolutePath() + File.separator + file5.getName() + jCurrentTimeMillis);
                                try {
                                    w.b(file5, file6);
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    file5.delete();
                                    file6.delete();
                                }
                                file5.delete();
                                if (fileLockLock != null && fileLockLock.isValid()) {
                                    try {
                                        fileLockLock.release();
                                    } catch (IOException e4) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e4);
                                    }
                                }
                                w.a(randomAccessFile);
                            } catch (Exception e5) {
                                e = e5;
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                                if (fileLockLock != null && fileLockLock.isValid()) {
                                    try {
                                        fileLockLock.release();
                                    } catch (IOException e6) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e6);
                                    }
                                }
                                w.a(randomAccessFile);
                                if (file != null) {
                                }
                                randomAccessFile2 = randomAccessFile;
                                file4 = file;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            randomAccessFile2 = randomAccessFile;
                            file4 = file;
                            if (fileLockLock != null && fileLockLock.isValid()) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException e7) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e7);
                                }
                            }
                            w.a(randomAccessFile2);
                            if (file4 != null) {
                                file4.delete();
                                throw th;
                            }
                            throw th;
                        }
                    } catch (Exception e8) {
                        randomAccessFile = randomAccessFile2;
                        e = e8;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    file.delete();
                    randomAccessFile2 = randomAccessFile;
                    file4 = file;
                } else {
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException e9) {
                            com.xiaomi.channel.commonutils.logger.b.a(e9);
                        }
                    }
                    w.a(randomAccessFile2);
                    if (file4 == null) {
                        file4.delete();
                    }
                }
            } else {
                if (fileLockLock != null) {
                    fileLockLock.release();
                }
                w.a(randomAccessFile2);
                if (file4 == null) {
                }
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m209a(Context context, String str) {
        File file = new File(str);
        long maxFileLength = com.xiaomi.clientreport.manager.a.a(context).m83a().getMaxFileLength();
        if (file.exists()) {
            try {
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
            return file.length() <= maxFileLength;
        }
        w.m789a(file);
        return true;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static File[] m210a(Context context, String str) {
        return new File(context.getFilesDir(), str).listFiles(new FilenameFilter() { // from class: com.xiaomi.push.bl.2
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str2) {
                return (TextUtils.isEmpty(str2) || str2.toLowerCase().endsWith(".lock")) ? false : true;
            }
        });
    }
}
