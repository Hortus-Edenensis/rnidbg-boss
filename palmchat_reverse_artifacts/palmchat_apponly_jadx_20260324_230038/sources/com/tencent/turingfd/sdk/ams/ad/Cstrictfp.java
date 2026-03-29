package com.tencent.turingfd.sdk.ams.ad;

import com.kuaishou.weapon.p0.t;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.strictfp, reason: invalid class name */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Cstrictfp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, Cdo> f10772a = new HashMap<>();

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.strictfp$do, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class Cdo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReentrantReadWriteLock f10773a = new ReentrantReadWriteLock();
        public final AtomicInteger b = new AtomicInteger(0);
    }

    public static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    public static boolean a(String str, byte[] bArr, boolean z) {
        Cdo cdo;
        FileChannel fileChannel;
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        FileLock fileLock2 = null;
        fileLockLock = null;
        FileLock fileLockLock = null;
        FileChannel fileChannel2 = null;
        if (z) {
            HashMap<String, Cdo> map = f10772a;
            synchronized (map) {
                cdo = map.get(str);
                if (cdo == null) {
                    cdo = new Cdo();
                    map.put(str, cdo);
                }
                cdo.b.incrementAndGet();
            }
            cdo.f10773a.writeLock().lock();
        } else {
            cdo = null;
        }
        try {
            randomAccessFile = new RandomAccessFile(str, "rw");
            try {
                FileChannel channel = randomAccessFile.getChannel();
                if (z) {
                    try {
                        fileLockLock = channel.lock();
                    } catch (Throwable unused) {
                        fileLock = fileLockLock;
                        fileChannel2 = channel;
                        FileChannel fileChannel3 = fileChannel2;
                        fileLock2 = fileLock;
                        fileChannel = fileChannel3;
                        if (fileLock2 != null && fileLock2.isValid()) {
                            try {
                                fileLock2.release();
                            } catch (IOException unused2) {
                            }
                        }
                        Auriga.a(fileChannel);
                        Auriga.a(randomAccessFile);
                        if (cdo == null) {
                            return false;
                        }
                        HashMap<String, Cdo> map2 = f10772a;
                        synchronized (map2) {
                            cdo.f10773a.writeLock().unlock();
                            if (cdo.b.decrementAndGet() == 0) {
                                map2.remove(str);
                            }
                        }
                        return false;
                    }
                }
                randomAccessFile.seek(0L);
                randomAccessFile.write(bArr);
                randomAccessFile.setLength(bArr.length);
                if (fileLockLock != null && fileLockLock.isValid()) {
                    try {
                        fileLockLock.release();
                    } catch (IOException unused3) {
                    }
                }
                Auriga.a(channel);
                Auriga.a(randomAccessFile);
                if (cdo == null) {
                    return true;
                }
                HashMap<String, Cdo> map3 = f10772a;
                synchronized (map3) {
                    cdo.f10773a.writeLock().unlock();
                    if (cdo.b.decrementAndGet() == 0) {
                        map3.remove(str);
                    }
                }
                return true;
            } catch (Throwable unused4) {
                fileLock = null;
            }
        } catch (Throwable unused5) {
            fileChannel = null;
            randomAccessFile = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(String str, boolean z) {
        Cdo cdo;
        FileLock fileLockLock;
        RandomAccessFile randomAccessFile;
        FileChannel channel;
        if (z) {
            HashMap<String, Cdo> map = f10772a;
            synchronized (map) {
                cdo = map.get(str);
                if (cdo == null) {
                    cdo = new Cdo();
                    map.put(str, cdo);
                }
                cdo.b.incrementAndGet();
            }
            cdo.f10773a.readLock().lock();
        } else {
            cdo = null;
        }
        try {
            randomAccessFile = new RandomAccessFile(str, t.k);
            try {
                channel = randomAccessFile.getChannel();
                if (z) {
                    try {
                        fileLockLock = channel.lock(0L, Long.MAX_VALUE, true);
                    } catch (Throwable unused) {
                        fileLockLock = null;
                        if (fileLockLock != null) {
                            try {
                                fileLockLock.release();
                            } catch (IOException unused2) {
                            }
                        }
                        Auriga.a(channel);
                        Auriga.a(randomAccessFile);
                        if (cdo != null) {
                        }
                        return null;
                    }
                } else {
                    fileLockLock = null;
                }
                try {
                    long length = randomAccessFile.length();
                    int i = (int) length;
                    if (i == length) {
                        byte[] bArr = new byte[i];
                        randomAccessFile.readFully(bArr);
                        if (fileLockLock != null && fileLockLock.isValid()) {
                            try {
                                fileLockLock.release();
                            } catch (IOException unused3) {
                            }
                        }
                        Auriga.a(channel);
                        Auriga.a(randomAccessFile);
                        if (cdo != null) {
                            HashMap<String, Cdo> map2 = f10772a;
                            synchronized (map2) {
                                cdo.f10773a.readLock().unlock();
                                if (cdo.b.decrementAndGet() == 0) {
                                    map2.remove(str);
                                }
                            }
                        }
                        return bArr;
                    }
                    throw new IOException("");
                } catch (Throwable unused4) {
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        fileLockLock.release();
                    }
                    Auriga.a(channel);
                    Auriga.a(randomAccessFile);
                    if (cdo != null) {
                        HashMap<String, Cdo> map3 = f10772a;
                        synchronized (map3) {
                            cdo.f10773a.readLock().unlock();
                            if (cdo.b.decrementAndGet() == 0) {
                                map3.remove(str);
                            }
                        }
                    }
                    return null;
                }
            } catch (Throwable unused5) {
                fileLockLock = null;
                channel = null;
            }
        } catch (Throwable unused6) {
            fileLockLock = null;
            randomAccessFile = null;
            channel = null;
        }
    }

    public static byte[] a(String str, int i) {
        FileInputStream fileInputStream;
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable unused) {
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[i];
            int i2 = 0;
            do {
                int i3 = fileInputStream.read(bArr, i2, i - i2);
                if (i3 == -1) {
                    break;
                }
                i2 += i3;
            } while (i2 < i);
            if (i2 == 0) {
                Auriga.a(fileInputStream);
                return null;
            }
            if (i2 < i) {
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, 0, bArr2, 0, i2);
                bArr = bArr2;
            }
            Auriga.a(fileInputStream);
            return bArr;
        } catch (Throwable unused2) {
            Auriga.a(fileInputStream);
            return null;
        }
    }

    public static byte[] a(String str) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(fileInputStream.available());
                try {
                    Auriga.a(fileInputStream, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (byteArray == null) {
                        byteArray = "".getBytes();
                    }
                    return byteArray;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        throw th;
                    } finally {
                        Auriga.a(fileInputStream);
                        Auriga.a(byteArrayOutputStream);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    public static boolean a(File file) {
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            try {
                return file.delete();
            } catch (Throwable unused) {
                return false;
            }
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                a(file2);
            }
        }
        try {
            return file.delete();
        } catch (Throwable unused2) {
            return false;
        }
    }
}
