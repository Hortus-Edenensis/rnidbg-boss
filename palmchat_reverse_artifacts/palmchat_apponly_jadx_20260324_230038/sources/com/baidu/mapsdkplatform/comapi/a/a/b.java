package com.baidu.mapsdkplatform.comapi.a.a;

import android.content.Context;
import android.os.Build;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comapi.util.e;
import com.baidu.mapsdkplatform.comapi.util.f;
import com.baidu.mapsdkplatform.comjni.util.JNIHandler;
import com.efs.sdk.base.Constants;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.zip.GZIPOutputStream;
import org.apache.http.HttpHeaders;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f3939a = "";
    private static String b = "";
    private static String c = "";
    private Context d;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            File[] fileArrListFiles;
            if (e.b().a() == null) {
                return;
            }
            File file = new File(b.f3939a);
            if (!file.exists() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) {
                return;
            }
            try {
                Arrays.sort(fileArrListFiles, new c());
            } catch (Exception unused) {
            }
            int length = fileArrListFiles.length;
            if (length > 10) {
                length = 10;
            }
            for (int i = 0; i < length; i++) {
                File file2 = fileArrListFiles[i];
                if (!file2.isDirectory() && file2.exists() && file2.isFile() && file2.getName().contains(b.b)) {
                    if (file2.getName().endsWith(".txt")) {
                        b.this.b(file2);
                    } else if (file2.getName().endsWith(".zip") && file2.exists()) {
                        b.this.b(file2);
                    }
                }
            }
            if (fileArrListFiles.length > 10) {
                b.this.a(fileArrListFiles);
            }
        }
    }

    /* JADX INFO: renamed from: com.baidu.mapsdkplatform.comapi.a.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0081b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f3941a = new b();
    }

    public static b c() {
        return C0081b.f3941a;
    }

    private void d() {
        File filesDir;
        Context context = this.d;
        if (context == null || (filesDir = context.getFilesDir()) == null) {
            return;
        }
        String path = filesDir.getPath();
        if (path.isEmpty()) {
            return;
        }
        String str = path + File.separator + "crash";
        File file = new File(str);
        if (file.exists()) {
            f3939a = str;
        } else if (file.mkdir()) {
            f3939a = str;
        } else {
            f3939a = path;
        }
    }

    private HttpURLConnection e() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://api.map.baidu.com/lbs_sdkcc/report").openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Connection", "keep-alive");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=bd_map_sdk_cc");
            httpURLConnection.setRequestProperty(HttpHeaders.CACHE_CONTROL, "no-cache");
            httpURLConnection.setRequestProperty("Content-Encoding", Constants.CP_GZIP);
            httpURLConnection.setConnectTimeout(10000);
            return httpURLConnection;
        } catch (Exception unused) {
            return null;
        }
    }

    private void f() {
        String str;
        String str2 = f3939a;
        if (str2 == null || str2.isEmpty() || (str = b) == null || str.isEmpty()) {
            return;
        }
        String str3 = f3939a + File.separator + b;
        com.baidu.mapsdkplatform.comapi.a.a.a.a().a(str3);
        JNIHandler.registerNativeHandler(str3);
    }

    private void g() {
        if (NetworkUtil.isNetworkAvailable(this.d)) {
            new Thread(new a()).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x012c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[Catch: all -> 0x000f, SYNTHETIC, TRY_ENTER, TRY_LEAVE, TryCatch #14 {, blocks: (B:7:0x000b, B:43:0x00f2, B:48:0x00fb, B:49:0x0101, B:63:0x0119, B:68:0x0122, B:72:0x012c, B:73:0x012f, B:77:0x0136, B:82:0x013f, B:86:0x0149), top: B:111:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean b(File file) {
        HttpURLConnection httpURLConnectionE;
        OutputStream outputStream;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        DataInputStream dataInputStream;
        byte[] bArr;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        bufferedReader = null;
        bufferedReader2 = null;
        InputStream inputStream2 = null;
        bufferedReader = null;
        bufferedReader2 = null;
        BufferedReader bufferedReader3 = null;
        try {
            httpURLConnectionE = e();
        } catch (Exception unused) {
            httpURLConnectionE = null;
            outputStream = null;
        } catch (Throwable th) {
            th = th;
            httpURLConnectionE = null;
            outputStream = null;
        }
        if (httpURLConnectionE == null) {
            if (httpURLConnectionE != null) {
                try {
                    httpURLConnectionE.disconnect();
                } catch (Exception unused2) {
                }
            }
            return false;
        }
        try {
            httpURLConnectionE.connect();
            outputStream = httpURLConnectionE.getOutputStream();
            try {
                outputStream.write(a(a(file).toString().getBytes()));
                outputStream.write(a(("--bd_map_sdk_cc" + HttpClient.NEWLINE + "Content-Disposition: form-data; name=\"file\"; filename=\"c.txt\"\r\n" + HttpClient.NEWLINE).getBytes()));
                byteArrayOutputStream = new ByteArrayOutputStream((int) file.length());
                dataInputStream = new DataInputStream(new FileInputStream(file));
                bArr = new byte[1024];
            } catch (Exception unused3) {
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
        } catch (Exception unused4) {
            outputStream = null;
            inputStream = outputStream;
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
            inputStream = outputStream;
            if (outputStream != null) {
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                    bufferedReader2.close();
                } catch (Exception unused5) {
                }
            }
            if (httpURLConnectionE != null) {
            }
        }
        while (true) {
            int i = dataInputStream.read(bArr);
            if (i == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, i);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception unused6) {
                }
            }
            if (inputStream != null && bufferedReader3 != null) {
                try {
                    inputStream.close();
                    bufferedReader3.close();
                } catch (Exception unused7) {
                }
            }
            if (httpURLConnectionE != null) {
                try {
                    httpURLConnectionE.disconnect();
                } catch (Exception unused8) {
                }
            }
            return false;
        }
        outputStream.write(a(byteArrayOutputStream.toByteArray()));
        dataInputStream.close();
        byteArrayOutputStream.close();
        outputStream.write(a("\r\n--bd_map_sdk_cc--\r\n".getBytes()));
        outputStream.flush();
        if (httpURLConnectionE.getResponseCode() == 200) {
            inputStream = httpURLConnectionE.getInputStream();
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                try {
                    try {
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            int i2 = bufferedReader.read();
                            if (i2 == -1) {
                                break;
                            }
                            stringBuffer.append((char) i2);
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(stringBuffer.toString());
                            if (jSONObject.has("status") && jSONObject.getInt("status") == 0 && file.exists()) {
                                file.delete();
                            }
                        } catch (Exception unused9) {
                        }
                        inputStream2 = inputStream;
                    } catch (Exception unused10) {
                        bufferedReader3 = bufferedReader;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader2 = bufferedReader;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception unused11) {
                        }
                    }
                    if (inputStream != null && bufferedReader2 != null) {
                        inputStream.close();
                        bufferedReader2.close();
                    }
                    if (httpURLConnectionE != null) {
                        throw th;
                    }
                    try {
                        httpURLConnectionE.disconnect();
                        throw th;
                    } catch (Exception unused12) {
                        throw th;
                    }
                }
            } catch (Exception unused13) {
            } catch (Throwable th5) {
                th = th5;
            }
        } else {
            bufferedReader = null;
        }
        try {
            outputStream.close();
        } catch (Exception unused14) {
        }
        if (inputStream2 != null && bufferedReader != null) {
            try {
                inputStream2.close();
                bufferedReader.close();
            } catch (Exception unused15) {
            }
        }
        try {
            httpURLConnectionE.disconnect();
        } catch (Exception unused16) {
        }
        return true;
    }

    public void a(Context context) {
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr.length > 0) {
            c = strArr[0];
        }
        this.d = context;
        String strG = f.g();
        if (strG.isEmpty()) {
            return;
        }
        if (strG.contains("_")) {
            strG = strG.replaceAll("_", "");
        }
        b = strG + "_" + f.n() + "_";
        d();
        f();
        g();
    }

    public void a(String str, String str2) {
        JNIHandler.addLog(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File[] fileArr) {
        int length = fileArr.length;
        for (int i = 0; i < length - 10; i++) {
            int i2 = i + 10;
            File file = fileArr[i2];
            if (file != null && file.exists()) {
                fileArr[i2].delete();
            }
        }
    }

    private StringBuilder a(File file) {
        String[] strArrSplit = file.getName().substring(0, file.getName().length() - 4).split("_");
        StringBuilder sb = new StringBuilder();
        sb.append("--bd_map_sdk_cc");
        sb.append(HttpClient.NEWLINE);
        sb.append("Content-Disposition: form-data; name=\"phoneinfo\"\r\n");
        sb.append(HttpClient.NEWLINE);
        sb.append(URLDecoder.decode(SyncSysInfo.getPhoneInfo() + "&abi=" + c));
        sb.append(HttpClient.NEWLINE);
        sb.append("--bd_map_sdk_cc");
        sb.append(HttpClient.NEWLINE);
        String str = strArrSplit[0];
        if (str != null && !str.isEmpty()) {
            sb.append("Content-Disposition: form-data; name=\"packname\"\r\n");
            sb.append(HttpClient.NEWLINE);
            sb.append(strArrSplit[0]);
            sb.append(HttpClient.NEWLINE);
            sb.append("--bd_map_sdk_cc");
            sb.append(HttpClient.NEWLINE);
        }
        String str2 = strArrSplit[1];
        if (str2 != null && !str2.isEmpty()) {
            sb.append("Content-Disposition: form-data; name=\"version\"\r\n");
            sb.append(HttpClient.NEWLINE);
            sb.append(strArrSplit[1]);
            sb.append(HttpClient.NEWLINE);
            sb.append("--bd_map_sdk_cc");
            sb.append(HttpClient.NEWLINE);
        }
        String str3 = strArrSplit[2];
        if (str3 != null && !str3.isEmpty()) {
            sb.append("Content-Disposition: form-data; name=\"timestamp\"\r\n");
            sb.append(HttpClient.NEWLINE);
            sb.append(strArrSplit[2]);
            sb.append(HttpClient.NEWLINE);
            sb.append("--bd_map_sdk_cc");
            sb.append(HttpClient.NEWLINE);
        }
        sb.append("Content-Disposition: form-data; name=\"os\"\r\n");
        sb.append(HttpClient.NEWLINE);
        sb.append("android");
        sb.append(HttpClient.NEWLINE);
        sb.append("--bd_map_sdk_cc");
        sb.append(HttpClient.NEWLINE);
        return sb;
    }

    private byte[] a(byte[] bArr) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        a(byteArrayInputStream, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        byteArrayInputStream.close();
        return byteArray;
    }

    private void a(InputStream inputStream, OutputStream outputStream) throws Exception {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr, 0, 1024);
            if (i != -1) {
                gZIPOutputStream.write(bArr, 0, i);
            } else {
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                try {
                    outputStream.close();
                    inputStream.close();
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }
}
