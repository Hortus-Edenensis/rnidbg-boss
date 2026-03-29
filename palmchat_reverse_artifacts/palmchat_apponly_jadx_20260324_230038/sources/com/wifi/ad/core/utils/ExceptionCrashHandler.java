package com.wifi.ad.core.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.openalliance.ad.constant.az;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ExceptionCrashHandler implements Thread.UncaughtExceptionHandler {
    private static final String CRASH_FILE_NAME = "crash_file_name";
    private static final String TAG = "ExceptionCrashHandler";
    private static volatile ExceptionCrashHandler mInstance;
    private Context mContext;
    private Thread.UncaughtExceptionHandler mDefaultUncaughtExceptionHandler;

    private ExceptionCrashHandler() {
    }

    private String botainExceptionInfo(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        return stringWriter.toString();
    }

    private void cacheCrashFile(String str) {
        this.mContext.getSharedPreferences("crash", 0).edit().putString(CRASH_FILE_NAME, str).commit();
    }

    private boolean deleteDir(File file) {
        if (!file.isDirectory()) {
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        for (int i = 0; i < fileArrListFiles.length; i++) {
            if (fileArrListFiles[i].isFile()) {
                fileArrListFiles[i].delete();
            }
        }
        return true;
    }

    private String getAssignTime(String str) {
        return new SimpleDateFormat(str).format(Long.valueOf(System.currentTimeMillis()));
    }

    public static ExceptionCrashHandler getInstance() {
        if (mInstance == null) {
            synchronized (ExceptionCrashHandler.class) {
                if (mInstance == null) {
                    mInstance = new ExceptionCrashHandler();
                }
            }
        }
        return mInstance;
    }

    private String getMoBileInfo() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (Field field : Build.class.getDeclaredFields()) {
                field.setAccessible(true);
                stringBuffer.append(field.getName() + ContainerUtils.KEY_VALUE_DELIMITER + field.get(null).toString());
                stringBuffer.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    private HashMap<String, String> obtainSimpleInfo(Context context) {
        HashMap<String, String> map = new HashMap<>();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
            map.put("versionName", packageInfo.versionName);
            map.put(az.aW, packageInfo.versionCode + "");
            map.put("MODEL", Build.MODEL);
            map.put("SDK_INT", Build.VERSION.SDK_INT + "");
            map.put("PRODUCT", Build.PRODUCT);
            map.put("MOBILDE_INFO", getMoBileInfo());
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return map;
    }

    private String saveInfoToSd(Throwable th) {
        HashMap<String, String> mapObtainSimpleInfo = obtainSimpleInfo(this.mContext);
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : mapObtainSimpleInfo.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            stringBuffer.append(key);
            stringBuffer.append(" = ");
            stringBuffer.append(value);
            stringBuffer.append("\n");
        }
        stringBuffer.append(botainExceptionInfo(th));
        String str = null;
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        String str2 = File.separator;
        sb.append(str2);
        sb.append("aaaaaaaa_crash");
        sb.append(str2);
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            str = file.toString() + str2 + getAssignTime("yyyy_MM_dd_HH_mm") + ".txt";
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            fileOutputStream.write(stringBuffer.toString().getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public File getCrashFile(Context context) {
        String string = context.getSharedPreferences("crash", 0).getString(CRASH_FILE_NAME, null);
        if (string != null) {
            return new File(string);
        }
        return null;
    }

    public void init(Context context) {
        this.mContext = context;
        Thread.currentThread().setUncaughtExceptionHandler(this);
        Thread.currentThread();
        this.mDefaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        cacheCrashFile(saveInfoToSd(th));
        this.mDefaultUncaughtExceptionHandler.uncaughtException(thread, th);
    }
}
