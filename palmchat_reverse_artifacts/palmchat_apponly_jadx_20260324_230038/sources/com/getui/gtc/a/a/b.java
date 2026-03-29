package com.getui.gtc.a.a;

import android.annotation.TargetApi;
import android.net.Network;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f5658a;
    private HttpURLConnection b;
    private boolean c = false;
    private SecretKeySpec d;

    public b(f fVar) {
        this.f5658a = fVar;
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        this.d = new SecretKeySpec(bArr, "AES/CFB/NoPadding");
    }

    private void a() {
        HttpURLConnection httpURLConnection = this.b;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
                this.b = null;
            } catch (Throwable th) {
                com.getui.gtc.i.c.a.c(th);
            }
        }
    }

    @TargetApi(21)
    private byte[] b(Map<String, List<String>> map) {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(this.f5658a.f5661a);
            Network network = this.f5658a.c;
            this.b = network == null ? (HttpURLConnection) url.openConnection() : (HttpURLConnection) network.openConnection(url);
            this.b.setConnectTimeout(this.f5658a.h);
            this.b.setReadTimeout(this.f5658a.i);
            this.b.setDoInput(this.f5658a.k);
            this.b.setRequestMethod("GET");
            this.b.setUseCaches(this.f5658a.l);
            this.b.setInstanceFollowRedirects(this.f5658a.m);
            for (String str : this.f5658a.n.keySet()) {
                this.b.setRequestProperty(str, this.f5658a.n.get(str));
            }
            if (this.f5658a.d && (httpURLConnection = this.b) != null) {
                try {
                    httpURLConnection.addRequestProperty("GT_C_T", "1");
                    httpURLConnection.addRequestProperty("GT_C_K", com.igexin.push.a.j);
                    byte[] bArr = new byte[16];
                    new SecureRandom().nextBytes(bArr);
                    PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(EncryptUtils.RSA_ENCRYPT_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(com.igexin.push.a.k, 0)));
                    Cipher cipher = Cipher.getInstance("RSA/NONE/OAEPWithSHA1AndMGF1Padding");
                    cipher.init(1, publicKeyGeneratePublic);
                    byte[] bArrDoFinal = cipher.doFinal(this.d.getEncoded());
                    byte[] bArr2 = new byte[bArrDoFinal.length + 16];
                    System.arraycopy(bArr, 0, bArr2, 0, 16);
                    System.arraycopy(bArrDoFinal, 0, bArr2, 16, bArrDoFinal.length);
                    httpURLConnection.addRequestProperty("GT_C_V", Base64.encodeToString(bArr2, 2));
                    String strValueOf = String.valueOf(System.currentTimeMillis());
                    httpURLConnection.addRequestProperty("GT_T", strValueOf);
                    byte[] bytes = strValueOf.getBytes();
                    byte[] bArr3 = new byte[bytes.length + 0];
                    System.arraycopy(bytes, 0, bArr3, 0, bytes.length);
                    System.arraycopy(new byte[0], 0, bArr3, bytes.length, 0);
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    messageDigest.update(bArr3);
                    httpURLConnection.addRequestProperty("GT_C_S", Base64.encodeToString(messageDigest.digest(), 2));
                } catch (Throwable th) {
                    com.getui.gtc.i.c.a.c(th);
                }
            }
            inputStream = this.b.getInputStream();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    if (this.b.getResponseCode() == 200) {
                        if (this.b.getHeaderFields() != null) {
                            map.putAll(this.b.getHeaderFields());
                        }
                        byte[] bArr4 = new byte[1024];
                        while (true) {
                            int i = inputStream.read(bArr4);
                            if (i == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr4, 0, i);
                        }
                        if (byteArrayOutputStream.toByteArray() != null) {
                            byte[] bArrA = a(this.b, byteArrayOutputStream.toByteArray());
                            try {
                                inputStream.close();
                            } catch (Throwable th2) {
                                com.getui.gtc.i.c.a.c(th2);
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable th3) {
                                com.getui.gtc.i.c.a.c(th3);
                            }
                            a();
                            return bArrA;
                        }
                    } else {
                        f fVar = this.f5658a;
                        if (fVar != null) {
                            fVar.a(this.b.getResponseCode());
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th4) {
                            com.getui.gtc.i.c.a.c(th4);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th5) {
                        th = th5;
                        com.getui.gtc.i.c.a.c(th);
                    }
                } catch (Throwable th6) {
                    th = th6;
                    try {
                        f fVar2 = this.f5658a;
                        if (fVar2 != null) {
                            fVar2.a();
                        }
                        com.getui.gtc.i.c.a.c(th);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th7) {
                                com.getui.gtc.i.c.a.c(th7);
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable th8) {
                                th = th8;
                                com.getui.gtc.i.c.a.c(th);
                            }
                        }
                    } catch (Throwable th9) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th10) {
                                com.getui.gtc.i.c.a.c(th10);
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable th11) {
                                com.getui.gtc.i.c.a.c(th11);
                            }
                        }
                        a();
                        throw th9;
                    }
                }
            } catch (Throwable th12) {
                th = th12;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th13) {
            th = th13;
            inputStream = null;
            byteArrayOutputStream = null;
        }
        a();
        return null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Process.setThreadPriority(10);
            if (this.c) {
                return;
            }
            this.c = false;
            f fVar = this.f5658a;
            if (fVar == null || TextUtils.isEmpty(fVar.f5661a)) {
                return;
            }
            HashMap map = new HashMap();
            byte[] bArrB = this.f5658a.b == null ? b(map) : a(map);
            if (bArrB != null) {
                this.f5658a.a(map, bArrB);
            }
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c(th);
        }
    }

    private byte[] a(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            f fVar = this.f5658a;
            if (!fVar.d) {
                return fVar.g ? p.b(c.a(bArr)) : bArr;
            }
            String headerField = httpURLConnection.getHeaderField("GT_ERR");
            if (headerField != null && "0".equals(headerField)) {
                String headerField2 = httpURLConnection.getHeaderField("GT_T");
                if (headerField2 == null) {
                    throw new SecurityException("sdk config response error, GT_T header not found");
                }
                byte[] bytes = headerField2.getBytes();
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bytes);
                IvParameterSpec ivParameterSpec = new IvParameterSpec(messageDigest.digest());
                String headerField3 = httpURLConnection.getHeaderField("GT_C_S");
                if (headerField3 == null) {
                    throw new SecurityException("sdk config response error, GT_C_S header not found");
                }
                byte[] bArrDecode = Base64.decode(headerField3, 2);
                Cipher cipher = Cipher.getInstance("AES/CFB/NoPadding");
                cipher.init(2, this.d, ivParameterSpec);
                byte[] bArrDoFinal = cipher.doFinal(bArr);
                byte[] bArr2 = new byte[bArrDoFinal.length + bytes.length];
                System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
                System.arraycopy(bArrDoFinal, 0, bArr2, bytes.length, bArrDoFinal.length);
                MessageDigest messageDigest2 = MessageDigest.getInstance("SHA1");
                messageDigest2.update(bArr2);
                if (Arrays.equals(messageDigest2.digest(), bArrDecode)) {
                    return bArrDoFinal;
                }
                throw new SecurityException("sdk config response error, response body sign check failed");
            }
            if (headerField != null) {
                throw new SecurityException("sdk config response error, error code is ".concat(headerField));
            }
            throw new SecurityException("sdk config response error, GT_ERR header not found");
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c(th);
            return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:16|(2:144|17)|(11:19|(1:21)|22|124|23|24|122|25|(4:26|(1:28)(1:146)|92|93)|29|(9:31|128|32|136|36|112|40|44|45))(3:51|(1:53)|54)|120|55|(2:132|60)|(2:140|65)|92|93) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0129, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x012a, code lost:
    
        com.getui.gtc.i.c.a.c(r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0162 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x016c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0158 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x014c A[Catch: all -> 0x0178, TryCatch #11 {all -> 0x0178, blocks: (B:73:0x0148, B:75:0x014c, B:76:0x014f), top: B:134:0x0148 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte[] a(Map<String, List<String>> map) {
        InputStream inputStream;
        DataOutputStream dataOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        f fVar;
        byte[] bArrA;
        InputStream inputStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        DataOutputStream dataOutputStream2;
        byte[] bArr;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f5658a.f5661a).openConnection();
            this.b = httpURLConnection;
            httpURLConnection.setConnectTimeout(this.f5658a.h);
            this.b.setReadTimeout(this.f5658a.i);
            this.b.setDoInput(this.f5658a.k);
            this.b.setDoOutput(this.f5658a.j);
            this.b.setRequestMethod("POST");
            this.b.setUseCaches(this.f5658a.l);
            this.b.setInstanceFollowRedirects(this.f5658a.m);
            for (String str : this.f5658a.n.keySet()) {
                this.b.setRequestProperty(str, this.f5658a.n.get(str));
            }
            f fVar2 = this.f5658a;
            bArrA = fVar2.b;
            if (fVar2.d) {
                bArrA = a(bArrA);
            } else if (fVar2.f) {
                bArrA = p.a(bArrA);
            }
        } catch (Throwable th) {
            th = th;
            inputStream = null;
            dataOutputStream = null;
            byteArrayOutputStream = null;
        }
        try {
            if (bArrA == null) {
                a();
                return null;
            }
            this.b.connect();
            DataOutputStream dataOutputStream3 = new DataOutputStream(this.b.getOutputStream());
            try {
                dataOutputStream3.write(bArrA, 0, bArrA.length);
                dataOutputStream3.flush();
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                dataOutputStream = dataOutputStream3;
                inputStream = null;
            }
            if (this.b.getResponseCode() == 200) {
                if (this.b.getHeaderFields() != null) {
                    map.putAll(this.b.getHeaderFields());
                }
                inputStream2 = this.b.getInputStream();
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        bArr = new byte[1024];
                    } catch (Throwable th3) {
                        dataOutputStream2 = dataOutputStream3;
                        inputStream = inputStream2;
                        th = th3;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        dataOutputStream = dataOutputStream2;
                        fVar = this.f5658a;
                        if (fVar != null) {
                        }
                        com.getui.gtc.i.c.a.d(th.toString());
                        if (dataOutputStream != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                    }
                } catch (Throwable th4) {
                    byteArrayOutputStream = null;
                    dataOutputStream2 = dataOutputStream3;
                    inputStream = inputStream2;
                    th = th4;
                }
                while (true) {
                    int i = inputStream2.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    byteArrayOutputStream2.write(bArr, 0, i);
                    a();
                    return null;
                }
                if (byteArrayOutputStream2.toByteArray() != null) {
                    byte[] bArrA2 = a(this.b, byteArrayOutputStream2.toByteArray());
                    try {
                        dataOutputStream3.close();
                    } catch (Throwable th5) {
                        com.getui.gtc.i.c.a.c(th5);
                    }
                    try {
                        inputStream2.close();
                    } catch (Throwable th6) {
                        com.getui.gtc.i.c.a.c(th6);
                    }
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Throwable th7) {
                        com.getui.gtc.i.c.a.c(th7);
                    }
                    a();
                    return bArrA2;
                }
            } else {
                f fVar3 = this.f5658a;
                if (fVar3 != null) {
                    fVar3.a(this.b.getResponseCode());
                }
                inputStream2 = null;
                byteArrayOutputStream2 = null;
            }
            dataOutputStream3.close();
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (Throwable th8) {
                    com.getui.gtc.i.c.a.c(th8);
                }
            }
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (Throwable th9) {
                    th = th9;
                    com.getui.gtc.i.c.a.c(th);
                }
            }
            a();
            return null;
            fVar = this.f5658a;
            if (fVar != null) {
                fVar.a();
            }
            com.getui.gtc.i.c.a.d(th.toString());
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th10) {
                    com.getui.gtc.i.c.a.c(th10);
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th11) {
                    com.getui.gtc.i.c.a.c(th11);
                }
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th12) {
                    th = th12;
                    com.getui.gtc.i.c.a.c(th);
                }
            }
            a();
            return null;
        } catch (Throwable th13) {
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th14) {
                    com.getui.gtc.i.c.a.c(th14);
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th15) {
                    com.getui.gtc.i.c.a.c(th15);
                }
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th16) {
                    com.getui.gtc.i.c.a.c(th16);
                }
            }
            a();
            throw th13;
        }
    }

    private byte[] a(byte[] bArr) {
        try {
            byte[] bArrA = g.a(bArr);
            byte[] bArr2 = new byte[0];
            if (bArrA == null) {
                bArrA = bArr2;
            }
            String strValueOf = String.valueOf(System.currentTimeMillis());
            byte[] bArr3 = new byte[16];
            new SecureRandom().nextBytes(bArr3);
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(EncryptUtils.RSA_ENCRYPT_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(com.igexin.push.a.k, 0)));
            Cipher cipher = Cipher.getInstance("RSA/NONE/OAEPWithSHA1AndMGF1Padding");
            cipher.init(1, publicKeyGeneratePublic);
            byte[] bArrDoFinal = cipher.doFinal(this.d.getEncoded());
            byte[] bArr4 = new byte[bArrDoFinal.length + 16];
            System.arraycopy(bArr3, 0, bArr4, 0, 16);
            System.arraycopy(bArrDoFinal, 0, bArr4, 16, bArrDoFinal.length);
            String strEncodeToString = Base64.encodeToString(bArr4, 2);
            byte[] bytes = strValueOf.getBytes();
            byte[] bArr5 = new byte[bytes.length + bArrA.length];
            System.arraycopy(bytes, 0, bArr5, 0, bytes.length);
            System.arraycopy(bArrA, 0, bArr5, bytes.length, bArrA.length);
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(bArr5);
            String strEncodeToString2 = Base64.encodeToString(messageDigest.digest(), 2);
            MessageDigest messageDigest2 = MessageDigest.getInstance("MD5");
            messageDigest2.update(strEncodeToString2.getBytes());
            IvParameterSpec ivParameterSpec = new IvParameterSpec(messageDigest2.digest());
            Cipher cipher2 = Cipher.getInstance("AES/CFB/NoPadding");
            cipher2.init(1, this.d, ivParameterSpec);
            byte[] bArrDoFinal2 = cipher2.doFinal(bArrA);
            this.b.addRequestProperty("GT_T", strValueOf);
            this.b.addRequestProperty("GT_C_T", "1");
            this.b.addRequestProperty("GT_C_K", com.igexin.push.a.j);
            this.b.addRequestProperty("GT_C_V", strEncodeToString);
            this.b.addRequestProperty("GT_C_S", strEncodeToString2);
            return bArrDoFinal2;
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c(th);
            return null;
        }
    }
}
