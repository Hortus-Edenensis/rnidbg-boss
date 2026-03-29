package com.bytedance.sdk.component.iz.nr;

import com.bytedance.sdk.component.iz.iz;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements com.bytedance.sdk.component.iz.pn<b> {
    private Map<String, String> u(HttpURLConnection httpURLConnection) {
        HashMap map = new HashMap();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        for (String str : headerFields.keySet()) {
            List<String> list = headerFields.get(str);
            if (list != null && list.size() > 0) {
                map.put(str, list.get(0));
            }
        }
        return map;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:0|2|(3:46|3|4)|(2:52|5)|(7:47|6|(1:8)(1:54)|38|39|40|41)|9|49|10|(2:12|13)|14|40|41|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        r9 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
    
        r9 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.io.ByteArrayOutputStream, java.io.Closeable] */
    @Override // com.bytedance.sdk.component.iz.pn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b<byte[]> call(iz izVar) throws Throwable {
        Closeable closeable;
        InputStream inputStream;
        byte[] byteArray;
        ?? byteArrayOutputStream;
        String message;
        ?? r5;
        HttpURLConnection httpURLConnection;
        byte[] bArr;
        InputStream inputStream2 = null;
        Map<String, String> mapU = null;
        int i = 0;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(izVar.u()).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.connect();
                inputStream = httpURLConnection.getInputStream();
            } catch (Throwable th) {
                th = th;
            }
        } catch (MalformedURLException e) {
            e = e;
            inputStream = null;
            byteArray = null;
        } catch (IOException e2) {
            e = e2;
            inputStream = null;
            byteArray = null;
        } catch (Throwable th2) {
            th = th2;
            closeable = null;
            com.bytedance.sdk.component.iz.fx.fx.nr.u(inputStream2);
            com.bytedance.sdk.component.iz.fx.fx.nr.u(closeable);
            throw th;
        }
        try {
            bArr = new byte[1024];
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (MalformedURLException e3) {
            e = e3;
            byteArray = null;
            byteArrayOutputStream = byteArray;
        } catch (IOException e4) {
            e = e4;
            byteArray = null;
            byteArrayOutputStream = byteArray;
            e.getMessage();
            message = e.getMessage();
            r5 = byteArrayOutputStream;
            com.bytedance.sdk.component.iz.fx.fx.nr.u(inputStream);
            com.bytedance.sdk.component.iz.fx.fx.nr.u(r5);
            return new b<>(i, byteArray, message, mapU);
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            inputStream2 = inputStream;
            com.bytedance.sdk.component.iz.fx.fx.nr.u(inputStream2);
            com.bytedance.sdk.component.iz.fx.fx.nr.u(closeable);
            throw th;
        }
        while (true) {
            try {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            } catch (MalformedURLException e5) {
                e = e5;
                byteArray = null;
            } catch (IOException e6) {
                e = e6;
                byteArray = null;
            }
            e.getMessage();
            message = e.getMessage();
            r5 = byteArrayOutputStream;
            com.bytedance.sdk.component.iz.fx.fx.nr.u(inputStream);
            com.bytedance.sdk.component.iz.fx.fx.nr.u(r5);
            return new b<>(i, byteArray, message, mapU);
        }
        i = 200;
        byteArray = byteArrayOutputStream.toByteArray();
        mapU = izVar.nr() ? u(httpURLConnection) : null;
        com.bytedance.sdk.component.iz.fx.fx.nr.u(inputStream);
        com.bytedance.sdk.component.iz.fx.fx.nr.u(byteArrayOutputStream);
        message = "success";
        return new b<>(i, byteArray, message, mapU);
    }
}
