package com.tide.host.a;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class t {
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(String str, String str2, HashMap map, j jVar) {
        int responseCode;
        HttpURLConnection httpURLConnectionA = null;
        try {
            httpURLConnectionA = f.a(new URL(str));
            httpURLConnectionA.setRequestMethod("POST");
            for (Map.Entry entry : map.entrySet()) {
                httpURLConnectionA.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            httpURLConnectionA.setDoOutput(true);
            httpURLConnectionA.setUseCaches(false);
            httpURLConnectionA.setConnectTimeout(15000);
            httpURLConnectionA.setReadTimeout(15000);
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnectionA.getOutputStream());
            try {
                dataOutputStream.write(str2.getBytes());
                dataOutputStream.flush();
                dataOutputStream.close();
                responseCode = httpURLConnectionA.getResponseCode();
            } finally {
            }
        } catch (Throwable th) {
            try {
                jVar.a(-1, "POST request failed: " + th.getMessage());
            } finally {
                if (httpURLConnectionA != null) {
                    httpURLConnectionA.disconnect();
                }
            }
        }
        if (responseCode == 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnectionA.getInputStream()));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    } else {
                        sb.append(line);
                    }
                    jVar.a(-1, "POST request failed: " + th.getMessage());
                    if (httpURLConnectionA == null) {
                        return;
                    }
                }
                jVar.a(sb.toString());
                bufferedReader.close();
            } finally {
            }
        } else {
            jVar.a(responseCode, "POST request failed");
        }
    }
}
