package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.gj;
import com.xiaomi.push.hp;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f11744a = new Object();

    public static void a(final Context context, final gj gjVar) {
        if (az.a(gjVar.e())) {
            com.xiaomi.push.ae.a(context).a(new Runnable() { // from class: com.xiaomi.push.service.ba.1
                @Override // java.lang.Runnable
                public void run() {
                    RandomAccessFile randomAccessFile;
                    synchronized (ba.f11744a) {
                        FileLock fileLockLock = null;
                        try {
                            try {
                                File file = new File(context.getFilesDir(), "tiny_data.lock");
                                com.xiaomi.push.w.m789a(file);
                                randomAccessFile = new RandomAccessFile(file, "rw");
                                try {
                                    try {
                                        fileLockLock = randomAccessFile.getChannel().lock();
                                        ba.c(context, gjVar);
                                        if (fileLockLock != null && fileLockLock.isValid()) {
                                            try {
                                                fileLockLock.release();
                                            } catch (IOException e) {
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
                                                com.xiaomi.channel.commonutils.logger.b.a(e3);
                                            }
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
                                    com.xiaomi.push.w.a(randomAccessFile);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            randomAccessFile = null;
                        } catch (Throwable th3) {
                            th = th3;
                            randomAccessFile = null;
                            if (fileLockLock != null) {
                                fileLockLock.release();
                            }
                            com.xiaomi.push.w.a(randomAccessFile);
                            throw th;
                        }
                        com.xiaomi.push.w.a(randomAccessFile);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.Closeable] */
    public static void c(Context context, gj gjVar) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        ?? A = a(context);
        try {
            try {
                byte[] bArrB = com.xiaomi.push.h.b(A, hp.a(gjVar));
                if (bArrB == null || bArrB.length < 1) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("TinyData write to cache file failed case encryption fail item:" + gjVar.d() + "  ts:" + System.currentTimeMillis());
                } else {
                    if (bArrB.length <= 30720) {
                        BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(new File(context.getFilesDir(), "tiny_data.data"), true));
                        try {
                            bufferedOutputStream3.write(com.xiaomi.push.y.a(bArrB.length));
                            bufferedOutputStream3.write(bArrB);
                            bufferedOutputStream3.flush();
                            com.xiaomi.push.w.a((Closeable) null);
                            com.xiaomi.push.w.a(bufferedOutputStream3);
                            return;
                        } catch (IOException e) {
                            bufferedOutputStream2 = bufferedOutputStream3;
                            e = e;
                            com.xiaomi.channel.commonutils.logger.b.a("TinyData write to cache file failed cause io exception item:" + gjVar.d(), e);
                            A = bufferedOutputStream2;
                            com.xiaomi.push.w.a((Closeable) null);
                            com.xiaomi.push.w.a((Closeable) A);
                            return;
                        } catch (Exception e2) {
                            bufferedOutputStream = bufferedOutputStream3;
                            e = e2;
                            com.xiaomi.channel.commonutils.logger.b.a("TinyData write to cache file  failed item:" + gjVar.d(), e);
                            A = bufferedOutputStream;
                            com.xiaomi.push.w.a((Closeable) null);
                            com.xiaomi.push.w.a((Closeable) A);
                            return;
                        } catch (Throwable th) {
                            A = bufferedOutputStream3;
                            th = th;
                            com.xiaomi.push.w.a((Closeable) null);
                            com.xiaomi.push.w.a((Closeable) A);
                            throw th;
                        }
                    }
                    com.xiaomi.channel.commonutils.logger.b.m74a("TinyData write to cache file failed case too much data content item:" + gjVar.d() + "  ts:" + System.currentTimeMillis());
                }
                com.xiaomi.push.w.a((Closeable) null);
                com.xiaomi.push.w.a((Closeable) null);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedOutputStream2 = null;
        } catch (Exception e4) {
            e = e4;
            bufferedOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            A = 0;
        }
    }

    public static byte[] a(Context context) {
        String strA = com.xiaomi.push.o.a(context).a("mipush", "td_key", "");
        if (TextUtils.isEmpty(strA)) {
            strA = com.xiaomi.push.bb.a(20);
            com.xiaomi.push.o.a(context).m659a("mipush", "td_key", strA);
        }
        return a(strA);
    }

    private static byte[] a(String str) {
        byte[] bArrCopyOf = Arrays.copyOf(com.xiaomi.push.ay.m185a(str), 16);
        bArrCopyOf[0] = 68;
        bArrCopyOf[15] = 84;
        return bArrCopyOf;
    }
}
