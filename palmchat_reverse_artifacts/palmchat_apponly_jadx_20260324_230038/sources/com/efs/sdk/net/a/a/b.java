package com.efs.sdk.net.a.a;

import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.net.NetManager;
import com.efs.sdk.net.a.a.f;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Map<String, Long> f5630a = new HashMap();

    public static long a(f.b bVar) {
        try {
            if (bVar.d() != null) {
                return r2.length;
            }
            return 0L;
        } catch (IOException | OutOfMemoryError e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static InputStream a(String str, String str2, String str3, InputStream inputStream) {
        Log.i("NetTrace-Interceptor", "save interpret response stream");
        com.efs.sdk.net.a.c cVarA = com.efs.sdk.net.a.a.a().a(str);
        cVarA.j = str2;
        if (str2 != null) {
            if (str2.contains("text") || str2.contains(BodyData.TYPE_JSON)) {
                ByteArrayOutputStream byteArrayOutputStreamA = a(inputStream, cVarA, str3);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStreamA.toByteArray());
                try {
                    byteArrayOutputStreamA.close();
                } catch (IOException e) {
                    Log.e("NetTrace-Interceptor", "save interpret response stream, e is ".concat(String.valueOf(e)));
                }
                return byteArrayInputStream;
            }
        }
        cVarA.m = 0L;
        return inputStream;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:0|2|(4:32|3|(1:5)(1:36)|30)|6|(1:8)(1:9)|10|(3:11|(1:13)(1:37)|30)|14|34|15|(1:25)|26|30) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static ByteArrayOutputStream a(InputStream inputStream, com.efs.sdk.net.a.c cVar, String str) {
        BufferedReader bufferedReader;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int i = inputStream.read(bArr);
                if (i < 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            } catch (IOException e) {
                Log.e("NetTrace-Interceptor", "parse and save body, e is ".concat(String.valueOf(e)));
            }
            return byteArrayOutputStream;
        }
        byteArrayOutputStream.flush();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        if (Constants.CP_GZIP.equals(str)) {
            bufferedReader = new BufferedReader(new InputStreamReader(new GZIPInputStream(byteArrayInputStream)));
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream));
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            sb.append(line + '\n');
            return byteArrayOutputStream;
        }
        String string = sb.toString();
        if (NetManager.getNetConfigManager().getNetResponseBodyCollectState() && string.getBytes().length < 10240 && (cVar.j.contains("application/json") || cVar.j.contains("application/x-www-form-urlencoded") || cVar.j.contains(HTTP.PLAIN_TEXT_TYPE))) {
            cVar.k = string;
        }
        cVar.m = string.getBytes().length;
        return byteArrayOutputStream;
    }
}
