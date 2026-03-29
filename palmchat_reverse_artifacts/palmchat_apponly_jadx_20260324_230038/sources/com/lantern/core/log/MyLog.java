package com.lantern.core.log;

import android.content.Context;
import android.os.Environment;
import com.baidu.mapapi.http.HttpClient;
import com.lantern.core.business.IPubParams;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class MyLog {
    private static final String ENDSWITH = ".tmp";
    private static final String EVENT_LOG = "eventLog.txt";
    private static final String SAVE_LOG = "saveLog.txt";
    private static final String SEND_LOG = "sendLog.txt";
    private static final String SERVER_URL = "http://wifi3a.51y5.net/qiyun-api/upload";
    private Context mContext;
    private IPubParams mPubParams;
    private static Boolean SWITCH = Boolean.FALSE;
    private static String PATH_SDCARD_DIR = Environment.getExternalStorageDirectory().getPath() + File.separator + "wifilog";
    private static SimpleDateFormat logfile = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
    private static SimpleDateFormat myLogSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static ExecutorService fixedThreadPool = Executors.newCachedThreadPool();
    public static volatile Object evLock = new Object();
    public static volatile Object svLock = new Object();
    public static volatile Object sdLock = new Object();

    /* JADX INFO: compiled from: SearchBox */
    public static class MyFilter implements FilenameFilter {
        private String type;

        public MyFilter(String str) {
            this.type = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(this.type);
        }
    }

    public MyLog(Context context, IPubParams iPubParams) {
        this.mContext = context;
        this.mPubParams = iPubParams;
        fixedThreadPool = Executors.newCachedThreadPool();
    }

    public static void event(final String str, final String str2) {
        if (SWITCH.booleanValue()) {
            fixedThreadPool.execute(new Runnable() { // from class: com.lantern.core.log.MyLog.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (MyLog.evLock) {
                        MyLog.writeFile(MyLog.EVENT_LOG, str, str2);
                    }
                }
            });
        }
    }

    public static int post(String str, Map<String, String> map) {
        String[] strArrSplit = str.split("/");
        String str2 = strArrSplit[strArrSplit.length - 1];
        File file = new File(str);
        int responseCode = 0;
        if (file.exists() && file.isFile()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(SERVER_URL).openConnection();
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
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        return responseCode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean renameFile(String str) {
        Date date = new Date();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(logfile.format(date));
        stringBuffer.append("_");
        stringBuffer.append(this.mPubParams.getIMEI());
        stringBuffer.append("_");
        stringBuffer.append(str);
        stringBuffer.append(".tmp");
        File file = new File(PATH_SDCARD_DIR, stringBuffer.toString());
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(PATH_SDCARD_DIR, str);
        if (file2.exists()) {
            return file2.renameTo(file);
        }
        return false;
    }

    public static void save(final String str, final String str2) {
        if (SWITCH.booleanValue()) {
            fixedThreadPool.execute(new Runnable() { // from class: com.lantern.core.log.MyLog.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (MyLog.svLock) {
                        MyLog.writeFile(MyLog.SAVE_LOG, str, str2);
                    }
                }
            });
        }
    }

    public static void send(final String str, final String str2) {
        if (SWITCH.booleanValue()) {
            fixedThreadPool.execute(new Runnable() { // from class: com.lantern.core.log.MyLog.3
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (MyLog.sdLock) {
                        MyLog.writeFile(MyLog.SEND_LOG, str, str2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadTmpFile(String str) {
        HashMap map = new HashMap();
        map.put("deviceFlag", this.mPubParams.getIMEI());
        post(str, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadTmpFiles() {
        String[] list = new File(PATH_SDCARD_DIR).list(new MyFilter(".tmp"));
        if (list == null) {
            return;
        }
        for (final String str : list) {
            fixedThreadPool.execute(new Runnable() { // from class: com.lantern.core.log.MyLog.5
                @Override // java.lang.Runnable
                public void run() {
                    MyLog.this.uploadTmpFile(MyLog.PATH_SDCARD_DIR + File.separator + str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeFile(String str, String str2, String str3) {
        String str4 = myLogSdf.format(new Date()) + "    " + str2 + "    " + str3;
        File file = new File(PATH_SDCARD_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            FileWriter fileWriter = new FileWriter(new File(file, str), true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(str4);
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void upload() {
        fixedThreadPool.execute(new Runnable() { // from class: com.lantern.core.log.MyLog.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (MyLog.evLock) {
                    MyLog.this.renameFile(MyLog.EVENT_LOG);
                }
                synchronized (MyLog.svLock) {
                    MyLog.this.renameFile(MyLog.SAVE_LOG);
                }
                synchronized (MyLog.sdLock) {
                    MyLog.this.renameFile(MyLog.SEND_LOG);
                }
                MyLog.this.uploadTmpFiles();
            }
        });
    }
}
