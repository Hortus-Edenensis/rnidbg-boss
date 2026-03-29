package com.tencent.turingfd.sdk.ams.ad;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Cascara {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, Cif> f10675a = new HashMap<>();
    public static final Object b;

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.Cascara$do, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class Cdo implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Cif f10676a;

        public Cdo(Cif cif) {
            this.f10676a = cif;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context;
            FileChannel channel;
            RandomAccessFile randomAccessFile;
            System.currentTimeMillis();
            String string = this.f10676a.toString();
            synchronized (Ccase.class) {
                context = Ccase.f10751a;
            }
            File file = new File(context.getDir("turingfd", 0), Foxnut.f);
            int length = string.length();
            synchronized (Cascara.b) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                FileLock fileLockLock = null;
                try {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        channel = randomAccessFile.getChannel();
                        try {
                            fileLockLock = channel.lock();
                            if (randomAccessFile.length() != 0) {
                                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(1024);
                                while (true) {
                                    int i = channel.read(byteBufferAllocate);
                                    if (i <= 0) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(byteBufferAllocate.array(), 0, i);
                                    byteBufferAllocate.clear();
                                }
                                string = byteArrayOutputStream + "," + string;
                                if (string.length() > (length + 1) * 50) {
                                    string = string.substring(string.indexOf(",") + 1);
                                }
                            }
                            channel.position(0L);
                            ByteBuffer byteBufferWrap = ByteBuffer.wrap(string.getBytes());
                            while (byteBufferWrap.hasRemaining()) {
                                channel.write(byteBufferWrap);
                            }
                            channel.truncate(byteBufferWrap.position());
                            if (fileLockLock != null && fileLockLock.isValid()) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException unused) {
                                }
                            }
                            Auriga.a(channel);
                        } catch (Throwable unused2) {
                            if (fileLockLock != null && fileLockLock.isValid()) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException unused3) {
                                }
                            }
                            Auriga.a(channel);
                        }
                    } catch (Throwable unused4) {
                        channel = null;
                    }
                } catch (Throwable unused5) {
                    channel = null;
                    randomAccessFile = null;
                }
                Auriga.a(randomAccessFile);
            }
        }
    }

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.Cascara$if, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class Cif {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f10677a;
        public final String b;

        public Cif(long j, String str) {
            this.f10677a = j;
            this.b = str;
        }

        public String toString() {
            return this.f10677a + ":" + this.b;
        }
    }

    static {
        new AtomicBoolean(false);
        b = new Object();
        new AtomicReference();
    }

    public static void a(long j, String str) {
        int i;
        long j2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Cif cif = new Cif(j, str);
        byte[] bytes = str.getBytes();
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bytes);
        int length = bytes.length;
        long j3 = (((long) length) * (-4132994306676758123L)) ^ 0;
        int i2 = length >> 3;
        int i3 = 0;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = i3 + (i4 << 3);
            long j4 = ((((long) byteBufferWrap.get(i5 + 0)) & 255) + ((((long) byteBufferWrap.get(i5 + 1)) & 255) << 8) + ((((long) byteBufferWrap.get(i5 + 2)) & 255) << 16) + ((((long) byteBufferWrap.get(i5 + 3)) & 255) << 24) + ((((long) byteBufferWrap.get(i5 + 4)) & 255) << 32) + ((((long) byteBufferWrap.get(i5 + 5)) & 255) << 40) + ((((long) byteBufferWrap.get(i5 + 6)) & 255) << 48) + ((((long) byteBufferWrap.get(i5 + 7)) & 255) << 56)) * (-4132994306676758123L);
            j3 = (j3 ^ ((j4 ^ (j4 >>> 47)) * (-4132994306676758123L))) * (-4132994306676758123L);
            i4++;
            i3 = 0;
        }
        int i6 = length & 7;
        switch (i6) {
            case 1:
                i = 0;
                long j5 = ((long) byteBufferWrap.get((i + length) - i6)) ^ j3;
                j2 = -4132994306676758123L;
                j3 = j5 * (-4132994306676758123L);
                break;
            case 2:
                i = 0;
                j3 ^= ((long) byteBufferWrap.get(((i + length) - i6) + 1)) << 8;
                long j52 = ((long) byteBufferWrap.get((i + length) - i6)) ^ j3;
                j2 = -4132994306676758123L;
                j3 = j52 * (-4132994306676758123L);
                break;
            case 3:
                i = 0;
                j3 ^= ((long) byteBufferWrap.get(((i + length) - i6) + 2)) << 16;
                j3 ^= ((long) byteBufferWrap.get(((i + length) - i6) + 1)) << 8;
                long j522 = ((long) byteBufferWrap.get((i + length) - i6)) ^ j3;
                j2 = -4132994306676758123L;
                j3 = j522 * (-4132994306676758123L);
                break;
            case 4:
                i = 0;
                j3 ^= ((long) byteBufferWrap.get(((i + length) - i6) + 3)) << 24;
                j3 ^= ((long) byteBufferWrap.get(((i + length) - i6) + 2)) << 16;
                j3 ^= ((long) byteBufferWrap.get(((i + length) - i6) + 1)) << 8;
                long j5222 = ((long) byteBufferWrap.get((i + length) - i6)) ^ j3;
                j2 = -4132994306676758123L;
                j3 = j5222 * (-4132994306676758123L);
                break;
            case 5:
                i = 0;
                j3 ^= ((long) byteBufferWrap.get(((i + length) - i6) + 4)) << 32;
                j3 ^= ((long) byteBufferWrap.get(((i + length) - i6) + 3)) << 24;
                j3 ^= ((long) byteBufferWrap.get(((i + length) - i6) + 2)) << 16;
                j3 ^= ((long) byteBufferWrap.get(((i + length) - i6) + 1)) << 8;
                long j52222 = ((long) byteBufferWrap.get((i + length) - i6)) ^ j3;
                j2 = -4132994306676758123L;
                j3 = j52222 * (-4132994306676758123L);
                break;
            case 7:
                j3 ^= ((long) byteBufferWrap.get(((length + 0) - i6) + 6)) << 48;
            case 6:
                i = 0;
                j3 ^= ((long) byteBufferWrap.get(((0 + length) - i6) + 5)) << 40;
                j3 ^= ((long) byteBufferWrap.get(((i + length) - i6) + 4)) << 32;
                j3 ^= ((long) byteBufferWrap.get(((i + length) - i6) + 3)) << 24;
                j3 ^= ((long) byteBufferWrap.get(((i + length) - i6) + 2)) << 16;
                j3 ^= ((long) byteBufferWrap.get(((i + length) - i6) + 1)) << 8;
                long j522222 = ((long) byteBufferWrap.get((i + length) - i6)) ^ j3;
                j2 = -4132994306676758123L;
                j3 = j522222 * (-4132994306676758123L);
                break;
            default:
                j2 = -4132994306676758123L;
                break;
        }
        long j6 = ((j3 >>> 47) ^ j3) * j2;
        String strValueOf = String.valueOf(j6 ^ (j6 >>> 47));
        HashMap<String, Cif> map = f10675a;
        synchronized (map) {
            map.put(strValueOf, cif);
        }
        Cpackage.f10766a.submit(new Cdo(cif));
    }
}
