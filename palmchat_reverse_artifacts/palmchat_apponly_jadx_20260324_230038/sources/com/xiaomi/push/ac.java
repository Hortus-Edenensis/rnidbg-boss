package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ac {
    public static boolean a(Context context, String str, long j) throws Throwable {
        RandomAccessFile randomAccessFile;
        FileLock fileLockLock = null;
        try {
            File file = new File(context.getFilesDir(), "/.vdevdir/");
            if (!v.m788a(file)) {
                w.a((Closeable) null);
                return true;
            }
            File file2 = new File(file, "lcfp.lock");
            w.m789a(file2);
            randomAccessFile = new RandomAccessFile(file2, "rw");
            try {
                try {
                    fileLockLock = randomAccessFile.getChannel().lock();
                    boolean zB = b(context, str, j);
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException unused) {
                        }
                    }
                    w.a(randomAccessFile);
                    return zB;
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                    if (fileLockLock != null) {
                        try {
                            fileLockLock.release();
                        } catch (IOException unused2) {
                        }
                    }
                    w.a(randomAccessFile);
                    return true;
                }
            } catch (Throwable th) {
                th = th;
                if (fileLockLock != null && fileLockLock.isValid()) {
                    try {
                        fileLockLock.release();
                    } catch (IOException unused3) {
                    }
                }
                w.a(randomAccessFile);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
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
        e.printStackTrace();
        if (fileLockLock != null && fileLockLock.isValid()) {
            fileLockLock.release();
        }
        w.a(randomAccessFile);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00d9 A[Catch: all -> 0x00ed, IOException -> 0x00f0, LOOP:0: B:42:0x00d3->B:44:0x00d9, LOOP_END, TRY_LEAVE, TryCatch #7 {IOException -> 0x00f0, all -> 0x00ed, blocks: (B:41:0x00cf, B:42:0x00d3, B:44:0x00d9), top: B:71:0x00cf }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean b(Context context, String str, long j) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2;
        Iterator it;
        File file = new File(context.getFilesDir(), "/.vdevdir/");
        if (!v.m788a(file)) {
            return true;
        }
        File file2 = new File(file, "lcfp");
        ArrayList arrayList = new ArrayList();
        String str2 = str + ":" + context.getPackageName() + "," + System.currentTimeMillis();
        if (file2.exists()) {
            try {
                bufferedReader2 = new BufferedReader(new FileReader(file2));
                while (true) {
                    try {
                        try {
                            String line = bufferedReader2.readLine();
                            if (line == null) {
                                break;
                            }
                            String[] strArrSplit = line.split(":");
                            if (strArrSplit.length == 2) {
                                if (TextUtils.equals(strArrSplit[0], String.valueOf(str))) {
                                    String[] strArrSplit2 = strArrSplit[1].split(",");
                                    if (strArrSplit2.length == 2) {
                                        long j2 = Long.parseLong(strArrSplit2[1]);
                                        if (!TextUtils.equals(strArrSplit2[0], context.getPackageName()) && Math.abs(r3 - j2) < 1000 * j * 0.9f) {
                                            w.a(bufferedReader2);
                                            return false;
                                        }
                                    }
                                } else {
                                    arrayList.add(line);
                                }
                            }
                        } catch (Exception unused) {
                            arrayList.clear();
                            w.a(bufferedReader2);
                            arrayList.add(str2);
                            bufferedWriter2 = new BufferedWriter(new FileWriter(file2));
                            it = arrayList.iterator();
                            while (it.hasNext()) {
                            }
                            w.a(bufferedWriter2);
                            return true;
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        w.a(bufferedReader);
                        throw th;
                    }
                }
            } catch (Exception unused2) {
                bufferedReader2 = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                w.a(bufferedReader);
                throw th;
            }
        } else if (!w.m789a(file2)) {
            return true;
        }
        arrayList.add(str2);
        try {
            bufferedWriter2 = new BufferedWriter(new FileWriter(file2));
        } catch (IOException e) {
            e = e;
            bufferedWriter = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter = null;
        }
        try {
            it = arrayList.iterator();
            while (it.hasNext()) {
                bufferedWriter2.write((String) it.next());
                bufferedWriter2.newLine();
                bufferedWriter2.flush();
            }
            w.a(bufferedWriter2);
        } catch (IOException e2) {
            e = e2;
            bufferedWriter = bufferedWriter2;
            try {
                com.xiaomi.channel.commonutils.logger.b.d(e.toString());
                w.a(bufferedWriter);
            } catch (Throwable th4) {
                th = th4;
                w.a(bufferedWriter);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedWriter = bufferedWriter2;
            w.a(bufferedWriter);
            throw th;
        }
        return true;
    }
}
