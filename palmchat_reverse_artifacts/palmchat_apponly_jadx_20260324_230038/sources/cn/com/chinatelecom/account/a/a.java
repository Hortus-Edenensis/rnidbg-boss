package cn.com.chinatelecom.account.a;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2020a = "a";

    public static String a(Context context, String str, String str2) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        InputStream inputStream2;
        StringBuilder sb;
        BufferedReader bufferedReader;
        String string = "";
        BufferedReader bufferedReader2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setRequestProperty("accept", "*/*");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.addRequestProperty(HttpHeaders.ACCEPT_CHARSET, "UTF-8");
                if (TextUtils.isEmpty(str2)) {
                    httpURLConnection.connect();
                } else {
                    DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(httpURLConnection.getOutputStream()));
                    dataOutputStream.write(str2.getBytes("UTF-8"));
                    dataOutputStream.flush();
                    dataOutputStream.close();
                }
            } catch (Throwable th) {
                th = th;
                inputStream = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (httpURLConnection.getResponseCode() == 200) {
            inputStream2 = httpURLConnection.getInputStream();
            try {
                sb = new StringBuilder();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream2));
            } catch (Throwable th2) {
                th = th2;
            }
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                    sb.append("\n");
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader2 = bufferedReader;
                    Throwable th4 = th;
                    inputStream = inputStream2;
                    th = th4;
                    try {
                        th.printStackTrace();
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (Throwable th5) {
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                throw th5;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        throw th5;
                    }
                }
                return string;
            }
            string = sb.toString();
            bufferedReader2 = bufferedReader;
        } else {
            inputStream2 = null;
        }
        if (bufferedReader2 != null) {
            bufferedReader2.close();
        }
        if (inputStream2 != null) {
            inputStream2.close();
        }
        return string;
    }
}
