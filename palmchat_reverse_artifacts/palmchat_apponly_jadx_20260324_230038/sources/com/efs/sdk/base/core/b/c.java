package com.efs.sdk.base.core.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.efs.sdk.base.core.config.GlobalInfoManager;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.d.f;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class c extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Long> f5545a = new HashMap<String, Long>() { // from class: com.efs.sdk.base.core.b.c.1
        {
            put("flow_5min", 300000L);
            put("flow_hour", 3600000L);
            put("flow_day", 86400000L);
        }
    };
    private static final Map<String, Long> b = new HashMap<String, Long>() { // from class: com.efs.sdk.base.core.b.c.2
        {
            put("flow_5min", 1048576L);
            put("flow_hour", 1048576L);
            put("flow_day", Long.valueOf(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE));
        }
    };
    private Map<String, AtomicInteger> c;
    private volatile SharedPreferences d;
    private volatile SharedPreferences.Editor e;
    private Context f;
    private String g;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f5546a = new c(0);
    }

    public /* synthetic */ c(byte b2) {
        this();
    }

    public static c a() {
        return a.f5546a;
    }

    private void b() {
        try {
            c();
        } catch (Throwable th) {
            Log.e("efs.flow", "init sharedpreferences error", th);
        }
    }

    private void c() {
        if (this.d == null) {
            synchronized (c.class) {
                if (this.d == null) {
                    this.d = SharedPreferencesUtils.getSharedPreferences(this.f, this.g.toLowerCase() + "_flow");
                }
            }
        }
        if (this.e == null) {
            synchronized (c.class) {
                if (this.e == null) {
                    this.e = this.d.edit();
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        int i = message.what;
        if (i == 0) {
            b();
            if (this.d == null) {
                Log.w("efs.flow", "sharedpreferences is null, cann't get last flow stat");
                return;
            }
            if (this.e == null) {
                Log.w("efs.flow", "sharedpreferences editor is null, cann't refresh flow stat");
                return;
            }
            String strValueOf = String.valueOf(message.obj);
            long j = message.arg1;
            String netStatus = GlobalInfoManager.getInstance().getNetStatus();
            for (String str : f5545a.keySet()) {
                String strConcat = "curr_time_".concat(String.valueOf(str));
                if (!this.d.contains(strConcat)) {
                    this.e.putLong(strConcat, System.currentTimeMillis());
                }
                for (String str2 : a(str, strValueOf, netStatus)) {
                    this.e.putLong(str2, this.d.getLong(str2, 0L) + j);
                }
            }
            this.e.apply();
            return;
        }
        if (i != 1) {
            Log.w("efs.flow", "flow stat listener not support action '" + message.what + "'");
            return;
        }
        String strValueOf2 = String.valueOf(message.obj);
        long j2 = message.arg1;
        b();
        if (this.d == null) {
            Log.w("efs.flow", "sharedpreferences is null, cann't get last refresh timestamp");
            return;
        }
        if (this.e == null) {
            Log.w("efs.flow", "sharedpreferences editor is null, cann't refresh timestamp");
            return;
        }
        String strConcat2 = "curr_time_".concat(strValueOf2);
        if (Math.abs(System.currentTimeMillis() - this.d.getLong(strConcat2, System.currentTimeMillis())) >= j2) {
            for (String str3 : this.d.getAll().keySet()) {
                if (str3.startsWith(strValueOf2)) {
                    this.e.putLong(str3, 0L);
                }
            }
            this.e.putLong(strConcat2, System.currentTimeMillis());
            this.e.apply();
            this.c.clear();
        }
    }

    private c() {
        super(com.efs.sdk.base.core.util.concurrent.a.f5599a.getLooper());
        this.c = new ConcurrentHashMap(5);
        this.f = ControllerCenter.getGlobalEnvStruct().mAppContext;
        this.g = ControllerCenter.getGlobalEnvStruct().getAppid();
        b();
        File fileC = com.efs.sdk.base.core.util.a.c(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (fileC.exists()) {
            FileUtil.delete(fileC);
        }
    }

    public final boolean a(@NonNull String str, long j) {
        String netStatus = GlobalInfoManager.getInstance().getNetStatus();
        boolean zA = true;
        for (Map.Entry<String, Long> entry : f5545a.entrySet()) {
            zA = a(entry.getKey(), entry.getValue().longValue(), str, netStatus, j);
            if (!zA) {
                break;
            }
        }
        return zA;
    }

    private boolean a(@NonNull String str, long j, @NonNull String str2, @NonNull String str3, long j2) {
        b();
        if (this.d == null) {
            Log.w("efs.flow", "sharedpreferences is null, cann't get last flow stat");
            return false;
        }
        List<String> listA = a(str, str2, str3);
        Map<String, String> mapC = com.efs.sdk.base.core.config.remote.b.a().c();
        for (String str4 : listA) {
            if (Math.abs(System.currentTimeMillis() - this.d.getLong("curr_time_".concat(String.valueOf(str)), System.currentTimeMillis())) > j) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                messageObtain.obj = str;
                messageObtain.arg1 = Long.valueOf(j).intValue();
                sendMessage(messageObtain);
            }
            long jA = a(mapC, str, str4);
            long j3 = this.d.getLong(str4, 0L);
            if (j3 + j2 > jA) {
                Log.i("efs.flow", "flow limit, key: " + str4 + ", max: " + jA + ", now: " + j3 + ", size: " + j2);
                a(str4);
                return false;
            }
        }
        return true;
    }

    private void a(String str) {
        if (!this.c.containsKey(str) || this.c.get(str) == null || this.c.get(str).get() <= 10) {
            f.a.f5585a.a(com.efs.sdk.base.core.config.remote.b.a().d.mConfigVersion, str);
            if (str.equals("flow_day")) {
                f.a.f5585a.a(com.efs.sdk.base.core.config.remote.b.a().d.mConfigVersion);
            }
            if (!this.c.containsKey(str)) {
                this.c.put(str, new AtomicInteger());
            }
            this.c.get(str).incrementAndGet();
        }
    }

    private static long a(Map<String, String> map, @NonNull String str, @NonNull String str2) {
        long jLongValue = b.get(str).longValue();
        if (map == null || !map.containsKey(str2) || TextUtils.isEmpty(map.get(str2))) {
            return jLongValue;
        }
        try {
            return Long.parseLong(map.get(str2));
        } catch (Throwable th) {
            Log.w("efs.flow", "get max flow error", th);
            return jLongValue;
        }
    }

    private static List<String> a(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str + "_" + str2);
        }
        if (!TextUtils.isEmpty(str3) && !"unknown".equalsIgnoreCase(str3)) {
            arrayList.add(str + "_" + str3);
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            arrayList.add(str + "_" + str2 + "_" + str3);
        }
        return arrayList;
    }
}
