package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class gb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f11595a = false;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f11596a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private ge f494a;

        public a(Context context, ge geVar) {
            this.f494a = geVar;
            this.f11596a = context;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            gb.c(this.f11596a, this.f494a);
        }
    }

    public static void a(Context context, ge geVar) {
        ae.a(context).a(new a(context, geVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(Context context, ge geVar) throws Throwable {
        RandomAccessFile randomAccessFile;
        File file;
        if (f11595a) {
            com.xiaomi.channel.commonutils.logger.b.m74a("TinyData extractTinyData is running");
            return;
        }
        f11595a = true;
        File file2 = new File(context.getFilesDir(), "tiny_data.data");
        if (!file2.exists()) {
            com.xiaomi.channel.commonutils.logger.b.m74a("TinyData no ready file to get data.");
            return;
        }
        a(context);
        byte[] bArrA = com.xiaomi.push.service.ba.a(context);
        FileLock fileLockLock = null;
        try {
            try {
                File file3 = new File(context.getFilesDir(), "tiny_data.lock");
                w.m789a(file3);
                randomAccessFile = new RandomAccessFile(file3, "rw");
                try {
                    fileLockLock = randomAccessFile.getChannel().lock();
                    file2.renameTo(new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data"));
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException e) {
                            e = e;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException e3) {
                            e = e3;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                        }
                    }
                    w.a(randomAccessFile);
                    file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                    if (file.exists()) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (fileLockLock != null && fileLockLock.isValid()) {
                    try {
                        fileLockLock.release();
                    } catch (IOException e4) {
                        com.xiaomi.channel.commonutils.logger.b.a(e4);
                    }
                }
                w.a(randomAccessFile);
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            randomAccessFile = null;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
            if (fileLockLock != null) {
                fileLockLock.release();
            }
            w.a(randomAccessFile);
            throw th;
        }
        w.a(randomAccessFile);
        file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
        if (file.exists()) {
            com.xiaomi.channel.commonutils.logger.b.m74a("TinyData no ready file to get data.");
            return;
        }
        a(context, geVar, file, bArrA);
        ga.a(false);
        b(context);
        f11595a = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a0, code lost:
    
        com.xiaomi.channel.commonutils.logger.b.d("TinyData read from cache file failed cause lengthBuffer < 1 || too big. length:" + r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(Context context, ge geVar, File file, byte[] bArr) throws Throwable {
        ArrayList arrayList = new ArrayList();
        byte[] bArr2 = new byte[4];
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                bufferedInputStream = null;
                loop0: while (true) {
                    int i = 0;
                    int length = 0;
                    while (true) {
                        try {
                            int i2 = bufferedInputStream2.read(bArr2);
                            if (i2 == -1) {
                                break loop0;
                            }
                            if (i2 != 4) {
                                com.xiaomi.channel.commonutils.logger.b.d("TinyData read from cache file failed cause lengthBuffer error. size:" + i2);
                                break loop0;
                            }
                            int iA = y.a(bArr2);
                            if (iA < 1 || iA > 30720) {
                                break loop0;
                            }
                            byte[] bArr3 = new byte[iA];
                            int i3 = bufferedInputStream2.read(bArr3);
                            if (i3 != iA) {
                                com.xiaomi.channel.commonutils.logger.b.d("TinyData read from cache file failed cause buffer size not equal length. size:" + i3 + "__length:" + iA);
                                break loop0;
                            }
                            byte[] bArrA = h.a(bArr, bArr3);
                            if (bArrA == null || bArrA.length == 0) {
                                com.xiaomi.channel.commonutils.logger.b.d("TinyData read from cache file failed cause decrypt fail");
                            } else {
                                gj gjVar = new gj();
                                hp.a(gjVar, bArrA);
                                gjVar.a("item_size", String.valueOf(bArrA.length));
                                arrayList.add(gjVar);
                                i++;
                                length += bArrA.length;
                                if (i >= 8 || length >= 30720) {
                                    break;
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            bufferedInputStream = bufferedInputStream2;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            w.a((Closeable) bufferedInputStream);
                        } catch (Throwable th) {
                            th = th;
                            bufferedInputStream = bufferedInputStream2;
                            w.a((Closeable) bufferedInputStream);
                            throw th;
                        }
                    }
                    gc.a(context, geVar, arrayList);
                    arrayList.clear();
                }
                gc.a(context, geVar, arrayList);
                if (file != null && file.exists() && !file.delete()) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("TinyData delete reading temp file failed");
                }
                w.a((Closeable) bufferedInputStream2);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private static void b(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_extra", 4).edit();
        editorEdit.putLong("last_tiny_data_upload_timestamp", System.currentTimeMillis() / 1000);
        editorEdit.commit();
    }

    private static void a(Context context) {
        File file = new File(context.getFilesDir() + "/tdReadTemp");
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }
}
