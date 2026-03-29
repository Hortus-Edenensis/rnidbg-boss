package com.beizi.fusion.tool;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.mapapi.http.HttpClient;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.model.ResponseInfo;
import com.huawei.openalliance.ad.constant.az;
import com.lantern.auth.server.WkParams;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.http.HttpHost;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class n implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static n f4741a = new n();
    private Thread.UncaughtExceptionHandler b;
    private Context c;

    private n() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        printWriter.close();
        String string = stringWriter.toString();
        a(string);
        b(string);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            a(th);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            Process.killProcess(Process.myPid());
        }
    }

    public static n a() {
        return f4741a;
    }

    public void a(Context context) {
        this.b = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.c = context.getApplicationContext();
    }

    private void a(String str) {
        String strA;
        String strA2;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("appId", com.beizi.fusion.c.b.a().b());
            jSONObject.put("packageName", this.c.getPackageName());
            jSONObject.put("versionName", ap.d(this.c));
            jSONObject.put(az.aW, String.valueOf(ap.e(this.c)));
            jSONObject.put("sdkVersion", "5.2.2.0");
            jSONObject2.put("osVersion", Build.VERSION.RELEASE + "_" + Build.VERSION.SDK_INT);
            jSONObject2.put("vendor", Build.MANUFACTURER);
            jSONObject2.put(WkParams.MODEL, Build.MODEL);
            jSONObject.put("device", jSONObject2);
            jSONObject.put("crashMessage", str);
            if (!TextUtils.isEmpty(ResponseInfo.getInstance(this.c).getCrashUrl()) && ResponseInfo.getInstance(this.c).getCrashUrl().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                strA = ResponseInfo.getInstance(this.c).getCrashUrl();
            } else {
                strA = d.a(BeiZis.getTransferProtocol() ? "aHR0cHM6Ly9hcGktaHRwLmJlaXppLmJpei9tYi9zZGsvY3Jhc2gvdjE=" : "aHR0cDovL2FwaS5odHAuYWQtc2NvcGUuY29tLmNuOjQ1NjAwL21iL3Nkay9jcmFzaC92MQ==");
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
            }
            if (TextUtils.isEmpty(strA) || (strA2 = v.a(strA, jSONObject.toString().getBytes())) == null) {
                return;
            }
            aa.a("lance", "post:" + strA2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b(String str) {
        try {
            Context context = this.c;
            if (context == null) {
                return;
            }
            File fileA = g.a(context);
            aa.a("BeiZis", "CrashHandler storagePath == " + fileA);
            if (fileA != null) {
                String str2 = fileA.getPath() + "/Beizi/log/";
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str3 = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS").format(new Date(System.currentTimeMillis()));
                File file2 = new File(str2 + "crash_" + str3 + ".trace");
                file2.createNewFile();
                FileWriter fileWriter = new FileWriter(file2, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(str3);
                bufferedWriter.write(HttpClient.NEWLINE);
                bufferedWriter.write("------------------crash----------------------");
                bufferedWriter.write(HttpClient.NEWLINE);
                bufferedWriter.write(str);
                bufferedWriter.write(HttpClient.NEWLINE);
                bufferedWriter.write("-------------------end-----------------------");
                bufferedWriter.newLine();
                bufferedWriter.close();
                fileWriter.close();
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        aa.a("lance", "writeLog ok");
    }

    private boolean a(final Throwable th) {
        if (th == null) {
            return false;
        }
        new Thread(new Runnable() { // from class: com.beizi.fusion.tool.n.1
            @Override // java.lang.Runnable
            public void run() {
                Looper.prepare();
                n.this.b(th);
                Looper.loop();
            }
        }).start();
        try {
            Thread.sleep(1000L);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return true;
        }
    }
}
