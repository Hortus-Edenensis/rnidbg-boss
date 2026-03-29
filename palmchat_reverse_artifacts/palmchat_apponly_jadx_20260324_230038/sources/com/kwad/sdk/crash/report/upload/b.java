package com.kwad.sdk.crash.report.upload;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.mapapi.http.HttpClient;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.w;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b {
    private static void a(@NonNull File file, @NonNull String str, String str2, @NonNull Map<String, String> map, @NonNull a aVar) throws Throwable {
        DataInputStream dataInputStream;
        OutputStream outputStream;
        byte[] bytes;
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploadLogFile " + Thread.currentThread());
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        String string = UUID.randomUUID().toString();
        String name = file.getName();
        String str3 = "https://" + com.kwad.sdk.core.network.idc.a.Jz().X("ulog", "ulog-sdk.gifshow.com") + "/rest/log/sdk/file/upload";
        int i = -1;
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str3).openConnection();
            try {
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setConnectTimeout(5000);
                httpURLConnection2.setReadTimeout(5000);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setRequestProperty("connection", HTTP.CONN_KEEP_ALIVE);
                httpURLConnection2.setRequestProperty("User-Agent", p.getUserAgent());
                httpURLConnection2.setRequestProperty("Charset", "UTF-8");
                httpURLConnection2.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + string);
                httpURLConnection2.setRequestProperty(HttpHeaders.CONTENT_MD5, Base64.encodeToString(com.kwad.sdk.utils.a.hd(file.getPath()), 2));
                httpURLConnection2.setRequestProperty("file-type", "." + w.getExtension(file.getName()));
                httpURLConnection2.setRequestProperty("origin-name", name);
                httpURLConnection2.setRequestProperty("Cookie", "did=" + str);
                httpURLConnection2.connect();
                outputStream = httpURLConnection2.getOutputStream();
                try {
                    for (String str4 : map.keySet()) {
                        outputStream.write(e(str4, map.get(str4), string));
                    }
                    bytes = ("\r\n--" + string + "--\r\n").getBytes();
                    StringBuilder sb = new StringBuilder();
                    sb.append(HttpClient.ENDFLAG);
                    sb.append(string);
                    sb.append(HttpClient.NEWLINE);
                    sb.append("Content-Disposition: form-data;name=\"file\";filename=\"" + name + "\"\r\n");
                    sb.append("Content-Type: application/octet-stream\r\n\r\n");
                    outputStream.write(sb.toString().getBytes());
                    dataInputStream = new DataInputStream(new FileInputStream(file));
                } catch (Exception e) {
                    e = e;
                    dataInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    dataInputStream = null;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i2 = dataInputStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        } else {
                            outputStream.write(bArr, 0, i2);
                        }
                    }
                    outputStream.write(HttpClient.NEWLINE.getBytes());
                    outputStream.write(bytes);
                    outputStream.flush();
                    int responseCode = httpURLConnection2.getResponseCode();
                    cVar.code = responseCode;
                    cVar.aIU = responseCode;
                    if (responseCode == 200) {
                        cVar.aIW = h.inputStream2String(httpURLConnection2.getInputStream());
                        try {
                            if (new JSONObject(cVar.aIW).optInt("result", -1) == 1) {
                                aVar.NQ();
                            } else {
                                e eVar = e.aVA;
                                aVar.NP();
                            }
                        } catch (JSONException unused) {
                            e eVar2 = e.aVA;
                            aVar.NP();
                        }
                        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "response.body= " + cVar.aIW);
                    } else {
                        e eVar3 = e.aVA;
                        e.aVG.AF();
                        aVar.NP();
                        com.kwad.sdk.core.network.idc.a aVarJz = com.kwad.sdk.core.network.idc.a.Jz();
                        int i3 = cVar.code;
                        if (i3 == 0) {
                            i3 = -1;
                        }
                        aVarJz.a(str3, i3, (Throwable) null);
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection2);
                } catch (Exception e2) {
                    e = e2;
                    httpURLConnection = httpURLConnection2;
                    try {
                        e eVar4 = e.aVA;
                        e.getCause();
                        aVar.NP();
                        com.kwad.sdk.core.network.idc.a aVarJz2 = com.kwad.sdk.core.network.idc.a.Jz();
                        int i4 = cVar.code;
                        if (i4 != 0) {
                            i = i4;
                        }
                        aVarJz2.a(str3, i, e);
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                        com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection);
                    } catch (Throwable th2) {
                        th = th2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection);
                        com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnection2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection);
                    com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                dataInputStream = null;
                outputStream = null;
            } catch (Throwable th4) {
                th = th4;
                dataInputStream = null;
                outputStream = null;
            }
        } catch (Exception e4) {
            e = e4;
            dataInputStream = null;
            outputStream = null;
        } catch (Throwable th5) {
            th = th5;
            dataInputStream = null;
            outputStream = null;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
        com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
    }

    private static byte[] e(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(HttpClient.ENDFLAG);
        sb.append(str3);
        sb.append(HttpClient.NEWLINE);
        sb.append("Content-Disposition: form-data; name=\"" + str + "\"");
        sb.append(HttpClient.NEWLINE);
        sb.append("Content-Length: " + str2.length());
        sb.append(HttpClient.NEWLINE);
        sb.append(HttpClient.NEWLINE);
        sb.append(str2);
        sb.append(HttpClient.NEWLINE);
        return sb.toString().getBytes();
    }

    private static Map<String, String> a(f fVar) {
        HashMap map = new HashMap();
        if (fVar == null) {
            return map;
        }
        if (!TextUtils.isEmpty(fVar.aVR)) {
            map.put("uploadToken", fVar.aVR);
        }
        if (!TextUtils.isEmpty(fVar.aVO)) {
            map.put(NotificationCompat.CATEGORY_SYSTEM, fVar.aVO);
        }
        if (!TextUtils.isEmpty(fVar.aVN)) {
            map.put("did", fVar.aVN);
        }
        if (!TextUtils.isEmpty(fVar.aVM)) {
            map.put("sid", fVar.aVM);
        }
        if (!TextUtils.isEmpty(fVar.aUi)) {
            map.put("appver", fVar.aUi);
        }
        if (!TextUtils.isEmpty(fVar.mTaskId)) {
            map.put(WfConstant.EVENT_KEY_TASK_ID, fVar.mTaskId);
        }
        if (!TextUtils.isEmpty(fVar.mToken)) {
            map.put("token", fVar.mToken);
        }
        if (!TextUtils.isEmpty(fVar.aVL)) {
            map.put(DeviceInfoUtil.UID_TAG, fVar.aVL);
        }
        if (!TextUtils.isEmpty(fVar.aVP)) {
            map.put(MediationConstant.KEY_EXTRA_INFO, fVar.aVP);
        }
        return map;
    }

    public static void a(File file, f fVar, a aVar) throws Throwable {
        a(file, fVar.aVN, fVar.mToken, a(fVar), aVar);
    }
}
