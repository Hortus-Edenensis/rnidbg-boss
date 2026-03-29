package com.tencent.turingfd.sdk.ams.ad;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Taurus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10742a;
    public static final String b;

    static {
        StringBuilder sbA = Banana.a("mpdc_");
        sbA.append(Carambola.f10673a);
        sbA.append("_");
        sbA.append(1);
        f10742a = sbA.toString();
        StringBuilder sbA2 = Banana.a("mpdc_r_");
        sbA2.append(Carambola.f10673a);
        sbA2.append("_");
        sbA2.append(1);
        b = sbA2.toString();
    }

    public static String a(Context context) {
        long length;
        String strA;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2;
        String packageName = context.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 64);
            if (packageInfo == null) {
                return null;
            }
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null || TextUtils.isEmpty(applicationInfo.sourceDir)) {
                return null;
            }
            String str = applicationInfo.sourceDir;
            File file = new File(str);
            int i = applicationInfo.flags;
            long jLastModified = -1;
            try {
                length = file.length();
            } catch (Throwable unused) {
                length = -1;
            }
            try {
                jLastModified = file.lastModified() / 1000;
            } catch (Throwable unused2) {
            }
            String str2 = packageInfo.versionName;
            if (str2 == null) {
                str2 = "";
            }
            int i2 = packageInfo.versionCode;
            long j = packageInfo.firstInstallTime;
            long j2 = packageInfo.lastUpdateTime;
            System.currentTimeMillis();
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null || signatureArr.length <= 0) {
                strA = "";
            } else {
                try {
                    byteArrayInputStream2 = new ByteArrayInputStream(signatureArr[0].toByteArray());
                } catch (Throwable th) {
                    th = th;
                    byteArrayInputStream = null;
                }
                try {
                    strA = Norma.a(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream2)).getEncoded());
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayInputStream = byteArrayInputStream2;
                    try {
                        th.printStackTrace();
                        strA = "";
                        byteArrayInputStream2 = byteArrayInputStream;
                    } finally {
                        Auriga.a(byteArrayInputStream);
                    }
                }
            }
            if (TextUtils.isEmpty(strA)) {
                try {
                    ArrayList arrayList = (ArrayList) UrsaMinor.a(new File(str));
                    if (arrayList.size() > 0) {
                        String str3 = (String) arrayList.get(0);
                        strA = str3 == null ? "" : str3;
                    }
                } catch (Throwable unused3) {
                }
            }
            return length + ":" + strA + ":" + packageName + ":" + str2 + ":" + i2 + ":" + j + ":" + j2 + ":" + i + ":" + jLastModified;
        } catch (Throwable unused4) {
            return null;
        }
    }

    public static synchronized String a(Context context, String str) {
        byte[] bArrDigest;
        FileChannel channel;
        RandomAccessFile randomAccessFile;
        FileLock fileLockLock;
        String str2;
        RandomAccessFile randomAccessFile2;
        FileChannel channel2;
        String strA = a(context);
        if (strA == null) {
            return "";
        }
        byte[] bytes = strA.getBytes();
        FileLock fileLockLock2 = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            bArrDigest = messageDigest.digest();
        } catch (NoSuchAlgorithmException unused) {
            bArrDigest = null;
        }
        String strA2 = Damson.a(bArrDigest);
        File dir = context.getDir("turingfd", 0);
        File file = dir == null ? null : new File(dir, str);
        if (file == null) {
            str2 = null;
        } else if (!file.exists()) {
            str2 = "";
        } else if (!file.isFile()) {
            Cstrictfp.a(file);
            str2 = "";
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    channel = randomAccessFile.getChannel();
                    try {
                        fileLockLock = channel.lock();
                        try {
                            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(32);
                            while (true) {
                                int i = channel.read(byteBufferAllocate);
                                if (i <= 0) {
                                    break;
                                }
                                byteArrayOutputStream.write(byteBufferAllocate.array(), 0, i);
                            }
                            String string = byteArrayOutputStream.toString();
                            if (fileLockLock != null && fileLockLock.isValid()) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException unused2) {
                                }
                            }
                            Auriga.a(channel);
                            Auriga.a(randomAccessFile);
                            Auriga.a(byteArrayOutputStream);
                            str2 = string;
                        } catch (Throwable unused3) {
                            if (fileLockLock != null && fileLockLock.isValid()) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException unused4) {
                                }
                            }
                            Auriga.a(channel);
                            Auriga.a(randomAccessFile);
                            Auriga.a(byteArrayOutputStream);
                            str2 = null;
                        }
                    } catch (Throwable unused5) {
                        fileLockLock = null;
                    }
                } catch (Throwable unused6) {
                    channel = null;
                    fileLockLock = null;
                }
            } catch (Throwable unused7) {
                channel = null;
                randomAccessFile = null;
                fileLockLock = null;
            }
        }
        if (str2 == null) {
            return "";
        }
        if (TextUtils.equals(str2, strA2)) {
            return "";
        }
        File dir2 = context.getDir("turingfd", 0);
        File file2 = dir2 == null ? null : new File(dir2, str);
        if (file2 != null) {
            try {
                randomAccessFile2 = new RandomAccessFile(file2, "rw");
                try {
                    channel2 = randomAccessFile2.getChannel();
                    try {
                        fileLockLock2 = channel2.lock();
                        byte[] bytes2 = strA2.getBytes();
                        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(bytes2.length);
                        byteBufferAllocate2.put(bytes2);
                        byteBufferAllocate2.flip();
                        while (byteBufferAllocate2.hasRemaining()) {
                            channel2.write(byteBufferAllocate2);
                        }
                        channel2.truncate(bytes2.length);
                        if (fileLockLock2 != null && fileLockLock2.isValid()) {
                            try {
                                fileLockLock2.release();
                            } catch (IOException unused8) {
                            }
                        }
                        Auriga.a(channel2);
                        Auriga.a(randomAccessFile2);
                    } catch (Throwable unused9) {
                        if (fileLockLock2 != null && fileLockLock2.isValid()) {
                            try {
                                fileLockLock2.release();
                            } catch (IOException unused10) {
                            }
                        }
                        Auriga.a(channel2);
                        Auriga.a(randomAccessFile2);
                    }
                } catch (Throwable unused11) {
                    channel2 = null;
                }
            } catch (Throwable unused12) {
                randomAccessFile2 = null;
                channel2 = null;
            }
        }
        return strA;
    }
}
