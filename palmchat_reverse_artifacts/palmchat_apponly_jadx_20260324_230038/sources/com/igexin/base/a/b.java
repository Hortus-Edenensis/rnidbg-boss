package com.igexin.base.a;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mapapi.http.HttpClient;
import com.igexin.base.api.SharedPreferencesManager;
import com.igexin.base.util.IOUtils;
import com.igexin.base.util.StringUtil;
import com.igexin.push.g.e;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
final class b implements Runnable {
    private static b b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final List<c> f7017a = new ArrayList();

    private b() {
        Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(this, 5L, 5L, TimeUnit.SECONDS);
    }

    public static synchronized b a() {
        if (b == null) {
            b = new b();
        }
        return b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (c cVar : this.f7017a) {
            if (cVar.isEnabled()) {
                if (cVar.f7018a.size() >= cVar.b || SystemClock.elapsedRealtime() - cVar.d >= cVar.c) {
                    a(cVar);
                    cVar.d = SystemClock.elapsedRealtime();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x022b A[Catch: all -> 0x0245, TRY_ENTER, TryCatch #5 {all -> 0x0245, blocks: (B:3:0x000b, B:5:0x001c, B:7:0x0026, B:10:0x002d, B:13:0x0034, B:16:0x003b, B:17:0x0042, B:19:0x0048, B:20:0x0057, B:22:0x005d, B:114:0x022b, B:116:0x0231, B:120:0x0239, B:122:0x023f, B:123:0x0242), top: B:134:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01f0  */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r21v10 */
    /* JADX WARN: Type inference failed for: r21v14, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r21v15 */
    /* JADX WARN: Type inference failed for: r21v16 */
    /* JADX WARN: Type inference failed for: r21v17 */
    /* JADX WARN: Type inference failed for: r21v18 */
    /* JADX WARN: Type inference failed for: r21v19 */
    /* JADX WARN: Type inference failed for: r21v2 */
    /* JADX WARN: Type inference failed for: r21v20 */
    /* JADX WARN: Type inference failed for: r21v21 */
    /* JADX WARN: Type inference failed for: r21v3 */
    /* JADX WARN: Type inference failed for: r21v4 */
    /* JADX WARN: Type inference failed for: r21v5 */
    /* JADX WARN: Type inference failed for: r21v6 */
    /* JADX WARN: Type inference failed for: r21v7, types: [int] */
    /* JADX WARN: Type inference failed for: r21v8 */
    /* JADX WARN: Type inference failed for: r21v9 */
    /* JADX WARN: Type inference failed for: r27v0, types: [com.igexin.base.a.c] */
    /* JADX WARN: Type inference failed for: r27v1 */
    /* JADX WARN: Type inference failed for: r27v10 */
    /* JADX WARN: Type inference failed for: r27v11 */
    /* JADX WARN: Type inference failed for: r27v12 */
    /* JADX WARN: Type inference failed for: r27v13 */
    /* JADX WARN: Type inference failed for: r27v14 */
    /* JADX WARN: Type inference failed for: r27v15 */
    /* JADX WARN: Type inference failed for: r27v2 */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r27v4 */
    /* JADX WARN: Type inference failed for: r27v5 */
    /* JADX WARN: Type inference failed for: r27v6 */
    /* JADX WARN: Type inference failed for: r27v7 */
    /* JADX WARN: Type inference failed for: r27v8 */
    /* JADX WARN: Type inference failed for: r27v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [int] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(c cVar) {
        ?? size;
        FileLock fileLock;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        byte[] bArrA;
        boolean z;
        ?? r21;
        OutputStream outputStream;
        OutputStream fileOutputStream;
        ?? r27;
        ?? r212;
        ?? r9;
        String strBytesToHexString;
        FileLock fileLock2;
        Object obj;
        ?? r272;
        Object obj2;
        ?? r213;
        String string = "";
        String str = null;
        try {
            File file = new File(cVar.a(cVar.f));
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if ((!parentFile.exists() && !parentFile.mkdirs()) || !file.createNewFile()) {
                    return false;
                }
            }
            if (!file.isFile()) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            List<String> list = cVar.f7018a;
            while (true) {
                size = list.size();
                if (size <= 0) {
                    break;
                }
                sb.append(list.remove(0));
                sb.append(HttpClient.NEWLINE);
            }
            if (sb.length() <= 0) {
                return true;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                FileLock fileLockLock = randomAccessFile.getChannel().lock();
                if (fileLockLock != null) {
                    try {
                        if (fileLockLock.isValid()) {
                            String string2 = sb.toString();
                            String str2 = cVar.e;
                            String md5 = StringUtil.getMD5(file.getAbsolutePath());
                            try {
                                try {
                                    jSONObject = new JSONObject(SharedPreferencesManager.get("gbase").getParam("logkey3", "").toString());
                                    try {
                                        string = jSONObject.getString(md5);
                                    } catch (JSONException unused) {
                                    }
                                } catch (JSONException unused2) {
                                    jSONObject = null;
                                }
                                String str3 = string;
                                jSONObject2 = jSONObject;
                                if (TextUtils.isEmpty(str3)) {
                                    KeyGenerator keyGenerator = KeyGenerator.getInstance(EncryptUtils.AES_ENCRYPT_ALGORITHM);
                                    keyGenerator.init(128);
                                    byte[] encoded = keyGenerator.generateKey().getEncoded();
                                    if (file.length() > 0) {
                                        file.delete();
                                    }
                                    bArrA = encoded;
                                    z = true;
                                } else {
                                    bArrA = com.igexin.base.util.a.a.a(StringUtil.hexStringToBytes(str3), (TextUtils.isEmpty(str2) ? com.igexin.push.core.b.am : str2).getBytes());
                                    z = false;
                                }
                            } catch (Throwable th) {
                                th = th;
                                fileLock = fileLockLock;
                                if (fileLock != null && fileLock.isValid()) {
                                    fileLock.release();
                                }
                                throw th;
                            }
                            try {
                                try {
                                    SecretKeySpec secretKeySpec = new SecretKeySpec(bArrA, EncryptUtils.AES_ENCRYPT_ALGORITHM);
                                    byte[] bArr = new byte[16];
                                    r21 = (randomAccessFile.length() > 0L ? 1 : (randomAccessFile.length() == 0L ? 0 : -1));
                                    try {
                                        try {
                                            if (r21 == 0) {
                                                try {
                                                    strBytesToHexString = StringUtil.bytesToHexString(secretKeySpec.getEncoded());
                                                    cVar = com.igexin.push.core.b.am;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    r21 = fileLockLock;
                                                    cVar = com.igexin.push.core.b.am;
                                                }
                                                try {
                                                    fileLock2 = fileLockLock;
                                                    RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance(EncryptUtils.RSA_ENCRYPT_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(e.f7358a, 0)));
                                                    Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding");
                                                    cipher.init(1, rSAPublicKey);
                                                    randomAccessFile.write(cipher.doFinal(strBytesToHexString.getBytes("UTF-8")));
                                                    new SecureRandom().nextBytes(bArr);
                                                    randomAccessFile.write(bArr);
                                                    str = "logkey3";
                                                    obj = "gbase";
                                                    r272 = cVar;
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    r21 = fileLockLock;
                                                    str = "logkey3";
                                                    size = "gbase";
                                                    try {
                                                        th.printStackTrace();
                                                        fileOutputStream = new FileOutputStream(file, true);
                                                        size = size;
                                                        r21 = r21;
                                                        cVar = cVar;
                                                    } catch (IOException e) {
                                                        e = e;
                                                        outputStream = null;
                                                        e.printStackTrace();
                                                        r9 = size;
                                                        r212 = r21;
                                                        r27 = cVar;
                                                        IOUtils.close(outputStream);
                                                        r213 = r212;
                                                        if (z) {
                                                        }
                                                        if (r213 != 0) {
                                                        }
                                                    } catch (Throwable th4) {
                                                        th = th4;
                                                        outputStream = null;
                                                        IOUtils.close(outputStream);
                                                        throw th;
                                                    }
                                                }
                                            } else {
                                                fileLock2 = fileLockLock;
                                                r272 = com.igexin.push.core.b.am;
                                                if (randomAccessFile.length() < 144) {
                                                    throw new IllegalArgumentException("Invalid file length (need 2 blocks for iv and data)");
                                                }
                                                if (randomAccessFile.length() % 16 != 0) {
                                                    str = "logkey3";
                                                    obj2 = "gbase";
                                                    long length = (int) (randomAccessFile.length() % 16);
                                                    if (length < 16 && length > 0) {
                                                        randomAccessFile.setLength(randomAccessFile.length() - length);
                                                    }
                                                    randomAccessFile.seek(randomAccessFile.length() - 16);
                                                } else {
                                                    str = "logkey3";
                                                    obj2 = "gbase";
                                                    randomAccessFile.seek(randomAccessFile.length() - 16);
                                                }
                                                randomAccessFile.read(bArr);
                                                obj = obj2;
                                            }
                                            Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
                                            cipher2.init(1, secretKeySpec, new IvParameterSpec(bArr));
                                            fileOutputStream = new CipherOutputStream(new FileOutputStream(randomAccessFile.getFD()), cipher2);
                                            size = obj;
                                            r21 = fileLock2;
                                            cVar = r272;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            th.printStackTrace();
                                            fileOutputStream = new FileOutputStream(file, true);
                                            size = size;
                                            r21 = r21;
                                            cVar = cVar;
                                            outputStream = fileOutputStream;
                                            try {
                                                outputStream.write(string2.getBytes("UTF-8"));
                                                r9 = size;
                                                r212 = r21;
                                                r27 = cVar;
                                            } catch (IOException e2) {
                                                e = e2;
                                                e.printStackTrace();
                                                r9 = size;
                                                r212 = r21;
                                                r27 = cVar;
                                            }
                                            IOUtils.close(outputStream);
                                            r213 = r212;
                                            if (z) {
                                            }
                                            return r213 != 0 ? true : true;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    str = "logkey3";
                                    size = "gbase";
                                    r21 = fileLockLock;
                                    cVar = com.igexin.push.core.b.am;
                                }
                                outputStream = fileOutputStream;
                                try {
                                    outputStream.write(string2.getBytes("UTF-8"));
                                    r9 = size;
                                    r212 = r21;
                                    r27 = cVar;
                                    IOUtils.close(outputStream);
                                    r213 = r212;
                                    if (z) {
                                        if (jSONObject2 == null) {
                                            jSONObject2 = new JSONObject();
                                        }
                                        boolean zIsEmpty = TextUtils.isEmpty(str2);
                                        ?? r12 = str2;
                                        if (zIsEmpty) {
                                            r12 = r27;
                                        }
                                        jSONObject2.put(md5, StringUtil.bytesToHexString(com.igexin.base.util.a.a.a(bArrA, r12.getBytes())));
                                        SharedPreferencesManager.get(r9).saveParam(str, jSONObject2.toString());
                                        r213 = r212;
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    IOUtils.close(outputStream);
                                    throw th;
                                }
                            } catch (Throwable th9) {
                                th = th9;
                                fileLock = fileLockLock;
                                if (fileLock != null) {
                                    fileLock.release();
                                }
                                throw th;
                            }
                        } else {
                            r213 = fileLockLock;
                        }
                    } catch (Throwable th10) {
                        th = th10;
                    }
                }
                if (r213 != 0 && r213.isValid()) {
                    r213.release();
                    return true;
                }
            } catch (Throwable th11) {
                th = th11;
                fileLock = null;
            }
        } catch (Throwable unused3) {
            return false;
        }
    }
}
