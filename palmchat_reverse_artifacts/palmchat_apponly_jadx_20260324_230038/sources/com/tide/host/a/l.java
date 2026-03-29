package com.tide.host.a;

import android.text.TextUtils;
import com.tide.protocol.util.TdLogUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class l {
    public static i a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            TdLogUtils.log("l", "File URL or Save File Path is empty, returning false.");
            return new i(-1, false);
        }
        String str3 = str2 + ".tmp";
        HttpURLConnection httpURLConnectionA = null;
        try {
            httpURLConnectionA = f.a(new URL(str));
            httpURLConnectionA.setRequestMethod("GET");
            httpURLConnectionA.setDoInput(true);
            httpURLConnectionA.setUseCaches(false);
            httpURLConnectionA.setConnectTimeout(10000);
            httpURLConnectionA.setReadTimeout(15000);
            httpURLConnectionA.connect();
            int responseCode = httpURLConnectionA.getResponseCode();
            if (responseCode != 200) {
                String str4 = "Failed to download APK. HTTP response code: " + responseCode;
                TdLogUtils.error("l", str4);
                i iVar = new i(str4);
                try {
                    httpURLConnectionA.disconnect();
                    new File(str3).delete();
                } catch (Throwable unused) {
                }
                return iVar;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnectionA.getInputStream());
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(str3);
                try {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = bufferedInputStream.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, i);
                        }
                        if (new File(str3).renameTo(new File(str2))) {
                            TdLogUtils.log("l", "APK downloaded and renamed successfully.");
                            i iVar2 = new i(responseCode, true);
                            bufferedOutputStream.close();
                            fileOutputStream.close();
                            bufferedInputStream.close();
                            try {
                                httpURLConnectionA.disconnect();
                                new File(str3).delete();
                            } catch (Throwable unused2) {
                            }
                            return iVar2;
                        }
                        TdLogUtils.error("l", "Failed to rename the temporary download file.");
                        i iVar3 = new i("Failed to rename the temporary download file.");
                        bufferedOutputStream.close();
                        fileOutputStream.close();
                        bufferedInputStream.close();
                        try {
                            httpURLConnectionA.disconnect();
                            new File(str3).delete();
                        } catch (Throwable unused3) {
                        }
                        return iVar3;
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                String str5 = "Failed to download APK: " + th.getMessage();
                TdLogUtils.error("l", str5);
                i iVar4 = new i(str5);
                if (httpURLConnectionA != null) {
                    try {
                        httpURLConnectionA.disconnect();
                    } catch (Throwable unused4) {
                        return iVar4;
                    }
                }
                return iVar4;
            } finally {
                if (httpURLConnectionA != null) {
                    try {
                        httpURLConnectionA.disconnect();
                    } catch (Throwable unused5) {
                    }
                }
                new File(str3).delete();
            }
        }
    }
}
