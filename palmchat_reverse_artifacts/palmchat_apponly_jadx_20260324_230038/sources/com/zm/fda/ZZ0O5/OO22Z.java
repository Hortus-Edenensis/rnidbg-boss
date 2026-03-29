package com.zm.fda.ZZ0O5;

import android.content.Context;
import com.baidu.mapapi.http.HttpClient;
import com.zm.fda.busi.IPubParams;
import com.zm.fda.utils.EventLog;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class OO22Z {
    public static final String b = "";
    public static final String c = ".tmp";
    public static volatile Object d = new Object();
    public static volatile Object e = new Object();
    public static volatile Object f = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IPubParams f16702a;

    /* JADX INFO: renamed from: com.zm.fda.ZZ0O5.OO22Z$OO22Z, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C1173OO22Z implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f16703a;

        public C1173OO22Z(String str) {
            this.f16703a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(this.f16703a);
        }
    }

    public OO22Z(Context context, IPubParams iPubParams) {
        this.f16702a = iPubParams;
    }

    private void b() {
    }

    public static void c(String str, String str2) {
        EventLog.d(str, str2);
    }

    public void a() {
    }

    public static void a(String str, String str2, String str3) {
    }

    public static void b(String str, String str2) {
        EventLog.d(str, str2);
    }

    public static void a(String str, String str2) {
        EventLog.d(str, str2);
    }

    public static int a(String str, Map<String, String> map) {
        int responseCode = 0;
        if (map == null) {
            return 0;
        }
        String[] strArrSplit = str.split("/");
        String str2 = strArrSplit[strArrSplit.length - 1];
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("").openConnection();
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Connection", HTTP.CONN_KEEP_ALIVE);
                httpURLConnection.setRequestProperty("ENCTYPE", "multipart/form-data");
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
                httpURLConnection.setRequestProperty("files", str2);
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.writeBytes(HttpClient.ENDFLAG + "*****" + HttpClient.NEWLINE);
                StringBuffer stringBuffer = new StringBuffer();
                for (String str3 : map.keySet()) {
                    dataOutputStream.writeBytes(HttpClient.ENDFLAG + "*****" + HttpClient.NEWLINE);
                    stringBuffer.append("Content-Disposition: form-data; name=\"" + str3 + "\"" + HttpClient.NEWLINE);
                    stringBuffer.append(HttpClient.NEWLINE);
                    StringBuilder sb = new StringBuilder();
                    sb.append(map.get(str3));
                    sb.append(HttpClient.NEWLINE);
                    stringBuffer.append(sb.toString());
                }
                dataOutputStream.writeBytes(stringBuffer.toString());
                dataOutputStream.writeBytes(HttpClient.ENDFLAG + "*****" + HttpClient.NEWLINE);
                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"files\";filename=\"" + str2 + "\"" + HttpClient.NEWLINE);
                dataOutputStream.writeBytes(HttpClient.NEWLINE);
                int iMin = Math.min(fileInputStream.available(), 1048576);
                byte[] bArr = new byte[iMin];
                int i = fileInputStream.read(bArr, 0, iMin);
                while (i > 0) {
                    dataOutputStream.write(bArr, 0, iMin);
                    iMin = Math.min(fileInputStream.available(), 1048576);
                    i = fileInputStream.read(bArr, 0, iMin);
                }
                dataOutputStream.writeBytes(HttpClient.NEWLINE);
                dataOutputStream.writeBytes(HttpClient.ENDFLAG + "*****" + HttpClient.ENDFLAG + HttpClient.NEWLINE);
                responseCode = httpURLConnection.getResponseCode();
                httpURLConnection.getResponseMessage();
                fileInputStream.close();
                dataOutputStream.flush();
                dataOutputStream.close();
                if (responseCode == 200) {
                    file.delete();
                }
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (MalformedURLException e3) {
                e3.printStackTrace();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
        return responseCode;
    }

    private void a(String str) {
        if (this.f16702a != null) {
            HashMap map = new HashMap();
            map.put("deviceFlag", this.f16702a.getIMEI());
            a(str, map);
        }
    }
}
