package com.ss.android.socialbase.appdownloader.iz;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Process;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.oplus.tblplayer.Constants;
import com.oplus.tblplayer.monitor.sdk.SysPerformanceCollector;
import com.tide.protocol.util.TdFileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class iz {
    private static Boolean u;

    private static int b() {
        String str = null;
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, u("726f2e736563757265"));
            if (objInvoke != null) {
                str = (String) objInvoke;
            }
        } catch (Exception unused) {
        }
        return (str == null || !"0".equals(str)) ? 1 : 0;
    }

    public static boolean fx(Context context) {
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return intentRegisterReceiver != null && intentRegisterReceiver.getIntExtra("plugged", -1) == 2;
    }

    private static boolean iz() {
        try {
            HashSet<String> hashSet = new HashSet();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(SysPerformanceCollector.APP_CPU_INFO_ROOT_PATH + Process.myPid() + "/maps"));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if (line.endsWith(Constants.LIBRARY_SUFFIX) || line.endsWith(TdFileUtils.PLUGIN_FILE_TAIL)) {
                    hashSet.add(line.substring(line.lastIndexOf(" ") + 1));
                }
            }
            bufferedReader.close();
            for (String str : hashSet) {
                if (str.contains(u("636f6d2e73617572696b2e737562737472617465")) || str.contains(u("58706f7365644272696467652e6a6172")) || str.contains(u("6c696273616e64686f6f6b2e656478702e736f"))) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean nr() {
        if (b() == 0) {
            return true;
        }
        return pn();
    }

    private static boolean pn() {
        String[] strArr = {u("2f7362696e2f7375"), u("2f73797374656d2f62696e2f7375"), u("2f73797374656d2f7862696e2f7375"), u("2f646174612f6c6f63616c2f7862696e2f7375"), u("2f646174612f6c6f63616c2f62696e2f7375"), u("2f73797374656d2f73642f7862696e2f7375"), u("2f73797374656d2f62696e2f6661696c736166652f7375"), u("2f646174612f6c6f63616c2f7375")};
        for (int i = 0; i < 8; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean u() {
        Boolean bool = u;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    @WorkerThread
    public static synchronized void u(@NonNull Context context) {
        if (u == null) {
            u = Boolean.valueOf((nr() || nr(context) || fx(context) || !b(context) || fx() || pn(context)) ? false : true);
        }
    }

    public static boolean nr(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    @WorkerThread
    public static boolean fx() {
        try {
            InetAddress.getByName(u("3132372e302e302e31"));
            new Socket(u("3132372e302e302e31"), Integer.parseInt(u("3237303432")));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean b(Context context) {
        int simState;
        try {
            simState = ((TelephonyManager) context.getSystemService("phone")).getSimState();
        } catch (Throwable unused) {
        }
        return (simState == 1 || simState == 0) ? false : true;
    }

    private static String u(@NonNull String str) {
        return com.ss.android.socialbase.downloader.jk.iz.u(str);
    }

    @WorkerThread
    public static boolean pn(Context context) {
        return iz() || iz(context);
    }

    private static boolean iz(Context context) {
        List listAsList = Arrays.asList(u("64652e726f62762e616e64726f69642e78706f736564"), u("636f6d2e746f706a6f686e77752e6d616769736b"), u("696f2e76612e6578706f736564"), u("636f6d2e77696e642e636f74746572"), u("6f72672e6d656f776361742e656478706f7365642e6d616e61676572"), u("6d652e7765697368752e657870"), u("636f6d2e73617572696b2e737562737472617465"));
        PackageManager packageManager = context.getPackageManager();
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            if (packageManager.getPackageInfo((String) it.next(), 0) != null) {
                return true;
            }
        }
        return false;
    }
}
