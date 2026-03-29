package com.umeng.ccg;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.cdo.oaps.ad.OapsKey;
import com.igexin.sdk.PushConsts;
import com.umeng.analytics.pro.ab;
import com.umeng.analytics.pro.ac;
import com.umeng.analytics.pro.ad;
import com.umeng.analytics.pro.ae;
import com.umeng.analytics.pro.af;
import com.umeng.analytics.pro.ag;
import com.umeng.analytics.pro.ah;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.ak;
import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.ao;
import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.ar;
import com.umeng.analytics.pro.as;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.av;
import com.umeng.analytics.pro.aw;
import com.umeng.analytics.pro.ax;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.n;
import com.umeng.ccg.c;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class d implements c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f11004a = "iucc";
    private static final String b = bd.b().b(bd.C);
    private static JSONObject c = null;
    private static final String[] d = {com.umeng.ccg.a.f, com.umeng.ccg.a.g, com.umeng.ccg.a.h};
    private static final String[] e = {com.umeng.ccg.a.f, com.umeng.ccg.a.g, com.umeng.ccg.a.h, com.umeng.ccg.a.i, com.umeng.ccg.a.n};
    private static ArrayList<ac> f = null;
    private static ArrayList<ac> g = null;
    private static ArrayList<ac> h = null;
    private static ArrayList<ac> i = null;
    private static ab j = null;
    private static f n = new f();
    private volatile String k = "";
    private volatile boolean l = false;
    private Map<String, c> m = new HashMap();

    /* JADX INFO: compiled from: SearchBox */
    public class a {
        private long b;
        private long c;

        public a(long j, long j2) {
            this.b = j;
            this.c = j2;
        }

        public long a() {
            return this.b;
        }

        public long b() {
            return this.c;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends BroadcastReceiver {
        public long a(ArrayList<ac> arrayList) {
            if (arrayList != null && arrayList.size() > 0) {
                for (int i = 0; i < arrayList.size(); i++) {
                    ac acVar = arrayList.get(i);
                    if (acVar instanceof af) {
                        return ((af) acVar).c();
                    }
                }
            }
            return 0L;
        }

        public boolean b(ArrayList<ac> arrayList) {
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).b()) {
                    return false;
                }
            }
            return true;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (action.equals("android.intent.action.SCREEN_ON") && d.j != null && (d.j instanceof ae)) {
                    if (b(d.i)) {
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 304, d.a(), null, 1000 * a(d.i));
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't send INVOKE_APPACT_WHEN_SCREEN_ON msg.");
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c {
        private JSONArray b;
        private String c;

        public c(JSONArray jSONArray, String str) {
            this.b = jSONArray;
            this.c = str;
        }

        public JSONArray a() {
            return this.b;
        }

        public String b() {
            return this.c;
        }
    }

    /* JADX INFO: renamed from: com.umeng.ccg.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0902d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11009a;
        public int b;
        public int c;

        public C0902d(String str, int i, int i2) {
            this.f11009a = str;
            this.b = i;
            this.c = i2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f11010a = new d();

        private e() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f extends BroadcastReceiver {
        public long a(ArrayList<ac> arrayList) {
            if (arrayList != null && arrayList.size() > 0) {
                for (int i = 0; i < arrayList.size(); i++) {
                    ac acVar = arrayList.get(i);
                    if (acVar instanceof af) {
                        return ((af) acVar).c();
                    }
                }
            }
            return 0L;
        }

        public boolean b(ArrayList<ac> arrayList) {
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).b()) {
                    return false;
                }
            }
            return true;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (action.equals("android.intent.action.SCREEN_ON")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_SCREEN_ON");
                    if (b(d.f)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_on event.");
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 301, d.a(), null, a(d.f) * 1000);
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_on event.");
                    }
                }
                if (action.equals("android.intent.action.SCREEN_OFF")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_SCREEN_OFF");
                    if (b(d.g)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_off event.");
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 302, d.a(), null, a(d.g) * 1000);
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_off event.");
                    }
                }
                if (action.equals(PushConsts.ACTION_BROADCAST_USER_PRESENT)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_USER_PRESENT");
                    if (!b(d.h)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_unlock event.");
                        return;
                    }
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_unlock event.");
                    com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 303, d.a(), null, a(d.h) * 1000);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, String str, BroadcastReceiver broadcastReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(str);
        context.registerReceiver(broadcastReceiver, intentFilter);
    }

    private boolean g() {
        SharedPreferences sharedPreferencesA = au.a(UMGlobalContext.getAppContext());
        if (sharedPreferencesA != null) {
            String string = sharedPreferencesA.getString(au.f, "");
            if (TextUtils.isEmpty(string)) {
                h();
                return false;
            }
            try {
                if (!as.a().keySet().equals(as.a(new JSONObject(string)).keySet())) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private void h() {
        try {
            SharedPreferences sharedPreferencesA = au.a(UMGlobalContext.getAppContext());
            if (sharedPreferencesA != null) {
                sharedPreferencesA.edit().putString(au.f, new JSONObject(as.a()).toString()).commit();
            }
        } catch (Throwable unused) {
        }
    }

    private boolean i() {
        try {
            SharedPreferences sharedPreferencesA = au.a(UMGlobalContext.getAppContext());
            if (sharedPreferencesA != null) {
                return !TextUtils.isEmpty(sharedPreferencesA.getString(au.g, ""));
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private JSONObject j() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ax.b(UMUtils.genUmc(), byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ax.a(byteArray, UMUtils.genSin());
            String str = new String(byteArray);
            byteArrayOutputStream.reset();
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private long b(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("ts")) {
            try {
                return jSONObject.optLong("ts");
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    private void c(Context context) {
        ImprintHandler.getImprintService(context).registImprintCallback(f11004a, new UMImprintChangeCallback() { // from class: com.umeng.ccg.d.1
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 107, d.a(), str2);
            }
        });
    }

    private Long d(Context context) {
        try {
            SharedPreferences sharedPreferencesA = au.a(context);
            if (sharedPreferencesA != null) {
                return Long.valueOf(sharedPreferencesA.getLong(au.d, 0L));
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private String e(Context context) {
        try {
            SharedPreferences sharedPreferencesA = au.a(context);
            return sharedPreferencesA != null ? sharedPreferencesA.getString(au.e, "") : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private void c(JSONObject jSONObject) {
        ab abVarA;
        if (jSONObject == null || !jSONObject.has(com.umeng.ccg.a.f11001a)) {
            return;
        }
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(com.umeng.ccg.a.f11001a);
            ab abVarA2 = jSONObjectOptJSONObject.has(com.umeng.ccg.a.b) ? a(com.umeng.ccg.a.b, jSONObjectOptJSONObject.optJSONObject(com.umeng.ccg.a.b)) : null;
            ab abVarA3 = jSONObjectOptJSONObject.has(com.umeng.ccg.a.c) ? a(com.umeng.ccg.a.c, jSONObjectOptJSONObject.optJSONObject(com.umeng.ccg.a.c)) : null;
            ab abVarA4 = jSONObjectOptJSONObject.has(com.umeng.ccg.a.d) ? a(com.umeng.ccg.a.d, jSONObjectOptJSONObject.optJSONObject(com.umeng.ccg.a.d)) : null;
            ab abVarA5 = jSONObjectOptJSONObject.has(com.umeng.ccg.a.e) ? a(com.umeng.ccg.a.e, jSONObjectOptJSONObject.optJSONObject(com.umeng.ccg.a.e)) : null;
            ab abVarA6 = jSONObjectOptJSONObject.has(com.umeng.ccg.a.f) ? a(com.umeng.ccg.a.f, jSONObjectOptJSONObject.optJSONObject(com.umeng.ccg.a.f)) : null;
            ab abVarA7 = jSONObjectOptJSONObject.has(com.umeng.ccg.a.g) ? a(com.umeng.ccg.a.g, jSONObjectOptJSONObject.optJSONObject(com.umeng.ccg.a.g)) : null;
            ab abVarA8 = jSONObjectOptJSONObject.has(com.umeng.ccg.a.h) ? a(com.umeng.ccg.a.h, jSONObjectOptJSONObject.optJSONObject(com.umeng.ccg.a.h)) : null;
            if (jSONObjectOptJSONObject.has(com.umeng.ccg.a.i)) {
                abVarA = a(com.umeng.ccg.a.i, jSONObjectOptJSONObject.optJSONObject(com.umeng.ccg.a.i));
                j = abVarA;
            } else {
                abVarA = null;
            }
            ab abVarA9 = jSONObjectOptJSONObject.has(com.umeng.ccg.a.n) ? a(com.umeng.ccg.a.n, jSONObjectOptJSONObject.optJSONObject(com.umeng.ccg.a.n)) : null;
            ArrayList arrayList = new ArrayList();
            if (abVarA2 != null) {
                arrayList.add(abVarA2);
            }
            if (abVarA3 != null) {
                arrayList.add(abVarA3);
            }
            if (abVarA4 != null) {
                arrayList.add(abVarA4);
            }
            if (abVarA5 != null) {
                arrayList.add(abVarA5);
            }
            if (abVarA6 != null) {
                arrayList.add(abVarA6);
            }
            if (abVarA7 != null) {
                arrayList.add(abVarA7);
            }
            if (abVarA8 != null) {
                arrayList.add(abVarA8);
            }
            if (abVarA != null) {
                arrayList.add(abVarA);
            }
            if (abVarA9 != null) {
                arrayList.add(abVarA9);
            }
            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 202, a(), arrayList);
        } catch (Throwable unused) {
        }
    }

    public static d a() {
        return e.f11010a;
    }

    public synchronized JSONObject b(Context context) {
        FileInputStream fileInputStreamOpenFileInput;
        JSONObject jSONObject = null;
        try {
            File filesDir = context.getFilesDir();
            String str = b;
            if (!new File(filesDir, str).exists()) {
                return null;
            }
            try {
                fileInputStreamOpenFileInput = context.openFileInput(str);
            } catch (Throwable unused) {
                fileInputStreamOpenFileInput = null;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(new String(ax.a(HelperUtils.readStreamToByteArray(fileInputStreamOpenFileInput), UMConfigure.sAppkey.getBytes())));
                try {
                    as.a(fileInputStreamOpenFileInput);
                } catch (Throwable unused2) {
                }
                jSONObject = jSONObject2;
            } catch (Throwable unused3) {
                as.a(fileInputStreamOpenFileInput);
            }
        } catch (Throwable unused4) {
        }
        return jSONObject;
    }

    public void a(Context context) {
        com.umeng.ccg.c.a(context, 105, a(), null);
    }

    private boolean a(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("code")) {
            return false;
        }
        try {
            if (200 == Integer.valueOf(jSONObject.optInt("code")).intValue() && jSONObject.has(com.umeng.ccg.a.f11001a)) {
                return jSONObject.has("ts");
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private synchronized void a(Context context, JSONObject jSONObject, String str) {
        long jB;
        byte[] bArrA;
        try {
            jB = b(jSONObject);
            bArrA = ax.a(jSONObject.toString().getBytes(), UMConfigure.sAppkey.getBytes());
        } catch (Throwable unused) {
        }
        if (bArrA != null && bArrA.length > 1) {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(context.getFilesDir(), b));
            try {
                fileOutputStream.write(bArrA);
                fileOutputStream.flush();
                as.a(fileOutputStream);
                a(context, str, jB);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "saveConfigFile success.");
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(com.umeng.ccg.a.f11001a);
                if (jSONObjectOptJSONObject != null) {
                    File file = new File(context.getFilesDir().getAbsolutePath() + File.separator + bx.n);
                    if (jSONObjectOptJSONObject.has(com.umeng.ccg.a.l)) {
                        if (!file.exists()) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "PI: cfg is on, flag not exist, create it.");
                            file.createNewFile();
                        }
                    } else if (file.exists()) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "PI: cfg is off, flag exist, delete it.");
                        file.delete();
                    }
                }
            } catch (Throwable th) {
                as.a(fileOutputStream);
                throw th;
            }
        }
    }

    private void b(String str) {
        String str2 = au.b + str;
        SharedPreferences sharedPreferencesA = au.a(UMGlobalContext.getAppContext());
        if (sharedPreferencesA != null) {
            sharedPreferencesA.edit().putLong(str2, System.currentTimeMillis()).commit();
        }
    }

    private void a(String str, ac acVar) {
        if (com.umeng.ccg.a.f.equalsIgnoreCase(str)) {
            if (f == null) {
                f = new ArrayList<>();
            }
            f.add(acVar);
        }
        if (com.umeng.ccg.a.g.equalsIgnoreCase(str)) {
            if (g == null) {
                g = new ArrayList<>();
            }
            g.add(acVar);
        }
        if (com.umeng.ccg.a.h.equalsIgnoreCase(str)) {
            if (h == null) {
                h = new ArrayList<>();
            }
            h.add(acVar);
        }
        if (com.umeng.ccg.a.i.equalsIgnoreCase(str)) {
            if (i == null) {
                i = new ArrayList<>();
            }
            i.add(acVar);
        }
    }

    private ab a(String str, JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        String str2;
        ab abVar;
        JSONArray jSONArrayOptJSONArray2;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(com.umeng.ccg.a.o) && (jSONArrayOptJSONArray = jSONObject.optJSONArray(com.umeng.ccg.a.o)) != null && jSONArrayOptJSONArray.length() > 0) {
                    JSONObject jSONObject2 = (JSONObject) jSONArrayOptJSONArray.get(0);
                    boolean zHas = jSONObject2.has(com.umeng.ccg.a.p);
                    boolean zHas2 = jSONObject2.has(com.umeng.ccg.a.s);
                    boolean zHas3 = jSONObject2.has(com.umeng.ccg.a.t);
                    if (!zHas || !zHas2 || !zHas3) {
                        return null;
                    }
                    try {
                        int iOptInt = jSONObject2.optInt(com.umeng.ccg.a.p);
                        long jOptLong = jSONObject2.optLong(com.umeng.ccg.a.s);
                        long jOptLong2 = jSONObject2.optLong(com.umeng.ccg.a.t);
                        String strOptString = jSONObject2.optString(com.umeng.ccg.a.u);
                        ArrayList arrayList = new ArrayList();
                        if (jSONObject2.has(com.umeng.ccg.a.q)) {
                            JSONArray jSONArrayOptJSONArray3 = jSONObject2.optJSONArray(com.umeng.ccg.a.q);
                            HashSet hashSet = new HashSet();
                            if (jSONArrayOptJSONArray3 != null) {
                                str2 = com.umeng.ccg.a.x;
                                int i2 = 0;
                                for (int length = jSONArrayOptJSONArray3.length(); i2 < length; length = length) {
                                    hashSet.add(Integer.valueOf(jSONArrayOptJSONArray3.getInt(i2)));
                                    i2++;
                                }
                            } else {
                                str2 = com.umeng.ccg.a.x;
                            }
                            if (hashSet.size() > 0) {
                                am amVar = new am(hashSet);
                                if (Arrays.asList(d).contains(str)) {
                                    a(str, amVar);
                                } else {
                                    arrayList.add(amVar);
                                    if (com.umeng.ccg.a.i.equalsIgnoreCase(str)) {
                                        a(str, amVar);
                                    }
                                }
                            }
                        } else {
                            str2 = com.umeng.ccg.a.x;
                        }
                        if (jSONObject2.has(com.umeng.ccg.a.r)) {
                            String strOptString2 = jSONObject2.optString(com.umeng.ccg.a.r);
                            if (!TextUtils.isEmpty(strOptString2)) {
                                ak akVar = new ak(strOptString2);
                                HashSet hashSet2 = new HashSet();
                                for (int i3 = 1; i3 <= 24; i3++) {
                                    if (akVar.a(i3)) {
                                        hashSet2.add(Integer.valueOf(i3));
                                    }
                                }
                                if (hashSet2.size() > 0) {
                                    ag agVar = new ag(hashSet2);
                                    if (Arrays.asList(d).contains(str)) {
                                        a(str, agVar);
                                    } else {
                                        arrayList.add(agVar);
                                    }
                                    if (com.umeng.ccg.a.i.equalsIgnoreCase(str)) {
                                        a(str, agVar);
                                    }
                                }
                            }
                        }
                        arrayList.add(new ai(iOptInt));
                        ah ahVar = new ah(str, jOptLong);
                        String[] strArr = d;
                        if (Arrays.asList(strArr).contains(str)) {
                            a(str, ahVar);
                        } else {
                            arrayList.add(ahVar);
                        }
                        if (com.umeng.ccg.a.i.equalsIgnoreCase(str)) {
                            a(str, ahVar);
                        }
                        af afVar = new af(jOptLong2);
                        if (Arrays.asList(strArr).contains(str)) {
                            a(str, afVar);
                            arrayList.add(afVar);
                        } else {
                            arrayList.add(afVar);
                        }
                        if (com.umeng.ccg.a.i.equalsIgnoreCase(str)) {
                            a(str, afVar);
                        }
                        if (com.umeng.ccg.a.e.equals(str)) {
                            abVar = new ad(str, arrayList);
                        } else if (com.umeng.ccg.a.i.equals(str)) {
                            abVar = new ae(str, arrayList);
                        } else {
                            abVar = new ab(str, arrayList);
                        }
                        try {
                            abVar.b(str, jSONObject2);
                            abVar.a(strOptString);
                            String str3 = "";
                            String str4 = str2;
                            if (jSONObject.has(str4) && (jSONArrayOptJSONArray2 = jSONObject.optJSONArray(str4)) != null) {
                                Map<String, c> map = this.m;
                                if (map != null && !map.containsKey(str)) {
                                    this.m.put(str, new c(new JSONArray(jSONArrayOptJSONArray2.toString()), strOptString));
                                }
                                int length2 = jSONArrayOptJSONArray2.length();
                                for (int i4 = 0; i4 < jSONArrayOptJSONArray2.length(); i4++) {
                                    str3 = str3 + jSONArrayOptJSONArray2.getString(i4);
                                    if (i4 < length2 - 1) {
                                        str3 = str3 + ",";
                                    }
                                }
                            }
                            abVar.b(str3);
                        } catch (Throwable unused) {
                        }
                        return abVar;
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
            } catch (Throwable unused3) {
            }
        }
        return null;
    }

    private void a(Context context, String str, long j2) {
        SharedPreferences sharedPreferencesA;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] strArrSplit = str.split("@");
            if (strArrSplit.length != 4 || (sharedPreferencesA = au.a(context)) == null) {
                return;
            }
            long j3 = Long.parseLong(strArrSplit[0]);
            String str2 = strArrSplit[1];
            SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
            editorEdit.putLong(au.c, j2);
            editorEdit.putLong(au.d, j3);
            editorEdit.putString(au.e, str2).commit();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "updateTsS1S2 : ts = " + j2 + "; s1 = " + j3 + "; s2 = " + str2);
        } catch (Throwable unused) {
        }
    }

    private void a(String str) {
        try {
            String[] strArrSplit = str.split("@");
            if (strArrSplit.length != 4) {
                return;
            }
            long j2 = Long.parseLong(strArrSplit[0]);
            String str2 = strArrSplit[1];
            if (!TextUtils.isEmpty(this.k)) {
                String[] strArrSplit2 = this.k.split("@");
                if (strArrSplit2.length == 2) {
                    long j3 = Long.parseLong(strArrSplit2[0]);
                    String str3 = strArrSplit2[1];
                    if (j3 == j2 && str3.equalsIgnoreCase(str2)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "重复的iucc S1 and S2, 忽略本次更新，不发起fetch。");
                        return;
                    }
                }
            }
            SharedPreferences sharedPreferencesA = au.a(UMGlobalContext.getAppContext());
            if (sharedPreferencesA != null) {
                if (sharedPreferencesA.getLong(au.c, 0L) != j2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "local config ts != iuccS1, send FETCH_NEW_CONFIG msg.");
                    this.k = String.valueOf(j2) + "@" + str2;
                    com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 101, a(), str);
                    return;
                }
                d(UMGlobalContext.getAppContext());
                if (e(UMGlobalContext.getAppContext()).equalsIgnoreCase(str2)) {
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "local S2 != iuccS2, send FETCH_NEW_CONFIG msg.");
                this.k = String.valueOf(j2) + "@" + str2;
                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 101, a(), str);
            }
        } catch (Throwable unused) {
        }
    }

    private void a(boolean z) {
        try {
            SharedPreferences sharedPreferencesA = au.a(UMGlobalContext.getAppContext());
            if (sharedPreferencesA != null) {
                SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
                if (z) {
                    editorEdit.putString(au.g, "1").commit();
                } else {
                    editorEdit.putString(au.g, "").commit();
                }
            }
        } catch (Throwable unused) {
        }
    }

    private JSONObject a(String str, int i2, int i3) {
        c cVar;
        JSONObject jSONObject = new JSONObject();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            jSONObject.put("id", "$$_umc_ev1");
            jSONObject.put("ts", jCurrentTimeMillis);
            jSONObject.put("tt", str);
            jSONObject.put(com.umeng.ccg.a.G, i2);
            jSONObject.put("result", i3);
            if (!this.m.containsKey(com.umeng.ccg.a.i) || (cVar = this.m.get(com.umeng.ccg.a.i)) == null) {
                return null;
            }
            JSONObject jSONObjectA = ao.a(UMGlobalContext.getAppContext(), cVar.a(), cVar.b());
            JSONObject jSONObjectA2 = ao.a(UMGlobalContext.getAppContext(), jSONObject);
            if (jSONObjectA == null || jSONObjectA2 == null) {
                return null;
            }
            return ao.a(jSONObjectA, jSONObjectA2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONObject a(String str, String str2, String str3, long j2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", "$$_umc_ev2");
            jSONObject.put("ts", j2);
            jSONObject.put("tt", str);
            jSONObject.put("flag", str2);
            jSONObject.put("ss", str3);
            if (z) {
                jSONObject.put("cd", 1);
            } else {
                jSONObject.put("cd", 0);
            }
            JSONObject jSONObjectA = ao.a(UMGlobalContext.getAppContext(), new JSONArray(), "");
            JSONObject jSONObjectA2 = ao.a(UMGlobalContext.getAppContext(), jSONObject);
            if (jSONObjectA == null || jSONObjectA2 == null) {
                return null;
            }
            return ao.a(jSONObjectA, jSONObjectA2);
        } catch (Throwable unused) {
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    private void a(Context context, String str, JSONObject jSONObject) {
        JSONObject jSONObjectA;
        Object objA;
        try {
            b(com.umeng.ccg.a.i);
            final String strOptString = jSONObject.has(com.umeng.ccg.a.F) ? jSONObject.optString(com.umeng.ccg.a.F) : "";
            if (TextUtils.isEmpty(strOptString)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> target is empty, ignore umc_cfg process");
                return;
            }
            final int iOptInt = jSONObject.has(com.umeng.ccg.a.G) ? jSONObject.optInt(com.umeng.ccg.a.G) : 0;
            if (iOptInt == 0) {
                JSONObject jSONObjectJ = j();
                if (jSONObjectJ == null || (objA = aw.a(jSONObjectJ.optString("c"), jSONObjectJ.optString("s"), new Class[]{String.class}, context, new Object[]{jSONObjectJ.optString("a")})) == null || Build.VERSION.SDK_INT < 23) {
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("ss", Base64.encodeToString(ax.a(DeviceConfig.getPackageName(context).getBytes(), UMUtils.genSin()), 0).trim());
                aw.a(jSONObjectJ.optString("m"), jSONObjectJ.optString("x"), new Class[]{String.class, String.class, String[].class, Bundle.class, Activity.class, aw.a(jSONObjectJ.optString("z")), Handler.class}, objA, new Object[]{strOptString, com.umeng.ccg.a.k, null, bundle, null, new AccountManagerCallback<Bundle>() { // from class: com.umeng.ccg.d.2
                    @Override // android.accounts.AccountManagerCallback
                    public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
                        int i2 = 1;
                        try {
                            accountManagerFuture.getResult();
                            i2 = 0;
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> umc_cfg p s!");
                        } catch (Throwable unused) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> umc_cfg p f!");
                        }
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 305, d.a(), d.this.new C0902d(strOptString, iOptInt, i2));
                    }
                }, null});
                return;
            }
            if (Build.VERSION.SDK_INT < 23 || (jSONObjectA = a(strOptString, iOptInt, 0)) == null) {
                return;
            }
            av.a(new aq(aq.b, jSONObjectA), 0L, TimeUnit.SECONDS);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:233:0x068b  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x068e  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x070c  */
    /* JADX WARN: Type inference failed for: r1v25, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29, types: [java.lang.Object, org.json.JSONObject] */
    @Override // com.umeng.ccg.c.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Object obj, int i2) {
        JSONObject jSONObjectB;
        Integer numValueOf;
        JSONObject jSONObject;
        boolean z;
        ArrayList arrayList;
        int size;
        ArrayList arrayList2;
        JSONObject jSONObjectD;
        c cVar;
        c cVar2;
        c cVar3;
        JSONObject jSONObjectA;
        JSONObject jSONObjectA2;
        try {
            if (i2 == 401) {
                if (this.l) {
                    Context appContext = UMGlobalContext.getAppContext();
                    int iIsAirplaneModeOn = DeviceConfig.isAirplaneModeOn(appContext);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    SharedPreferences sharedPreferencesA = au.a(appContext);
                    if (sharedPreferencesA != null) {
                        int i3 = sharedPreferencesA.getInt(au.i, 0);
                        long j2 = sharedPreferencesA.getLong(au.j, 0L);
                        if (i3 != iIsAirplaneModeOn) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> APMode value changed, current value: " + j2 + "; new value: " + iIsAirplaneModeOn);
                            SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
                            if (editorEdit != null) {
                                editorEdit.putInt(au.i, iIsAirplaneModeOn);
                                editorEdit.putLong(au.j, jCurrentTimeMillis);
                                editorEdit.commit();
                            }
                            if (i3 == 1 && iIsAirplaneModeOn == 0) {
                                com.umeng.ccg.c.a(appContext, 402, a(), new a(j2, jCurrentTimeMillis), 0L);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (i2 != 402) {
                switch (i2) {
                    case 101:
                        if (obj != null && (obj instanceof String)) {
                            String str = (String) obj;
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_NEW_CONFIG msg. source iucc is: " + str);
                            JSONObject jSONObjectA3 = ao.a(UMGlobalContext.getAppContext(), str);
                            if (jSONObjectA3 != null) {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "[imprint] send request. body: " + jSONObjectA3.toString());
                                av.a(new ar(ar.f10857a, jSONObjectA3, str), 0L, TimeUnit.SECONDS);
                            }
                            if (i()) {
                                c(UMGlobalContext.getAppContext());
                                String strImprintProperty = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), f11004a, "");
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "manual check iucc value: " + strImprintProperty);
                                a(strImprintProperty);
                            }
                            break;
                        }
                        break;
                    case 102:
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_RESPONSE msg.");
                        this.k = "";
                        if (obj != null && (obj instanceof JSONObject)) {
                            JSONObject jSONObject2 = (JSONObject) obj;
                            if (a(jSONObject2.optJSONObject(com.igexin.push.core.b.Y))) {
                                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 103, a(), jSONObject2);
                            } else {
                                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 104, a(), null);
                            }
                        } else {
                            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 104, a(), null);
                        }
                        break;
                    case 103:
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_SUCCESS msg.");
                        Context appContext2 = UMGlobalContext.getAppContext();
                        if (obj != null && (obj instanceof JSONObject)) {
                            JSONObject jSONObject3 = (JSONObject) obj;
                            JSONObject jSONObjectOptJSONObject = jSONObject3.optJSONObject(com.igexin.push.core.b.Y);
                            String strOptString = jSONObject3.optString("sourceIucc");
                            if (jSONObjectOptJSONObject != null) {
                                if (i()) {
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 成功拉取云配参数后，检测到should fetch标志，清除此标志。更新SDK类型集缓存值");
                                    h();
                                    a(false);
                                }
                                a(appContext2, jSONObjectOptJSONObject, strOptString);
                                CcgAgent.notifyConfigChanged(jSONObjectOptJSONObject);
                            }
                            break;
                        }
                        break;
                    case 104:
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_FAILED msg.");
                        break;
                    case 105:
                        for (String str2 : CcgAgent.getCollectItemList()) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "[forbid_sdk] 采集项: " + str2 + "; 值: " + CcgAgent.getForbidSdkArray(str2).toString());
                        }
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "[workEvent]: recv LOAD_CONFIG msg.");
                        Object jSONObject4 = 0;
                        try {
                            jSONObjectB = b(UMGlobalContext.getAppContext());
                        } catch (Throwable unused) {
                            jSONObjectB = null;
                        }
                        try {
                            if (jSONObjectB != null && a(jSONObjectB)) {
                                numValueOf = Integer.valueOf(jSONObject4.intValue() | 1);
                            } else {
                                numValueOf = Integer.valueOf(jSONObject4.intValue() | 0);
                            }
                            jSONObject4 = new JSONObject();
                            try {
                                jSONObject4.put("result", numValueOf);
                                if (jSONObjectB != null) {
                                    jSONObject4.put(com.igexin.push.core.b.Y, jSONObjectB);
                                }
                                break;
                            } catch (Throwable unused2) {
                            }
                            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 106, a(), jSONObject4);
                        } catch (Throwable unused3) {
                            JSONObject jSONObject5 = new JSONObject();
                            try {
                                jSONObject5.put("result", jSONObject4);
                                if (jSONObjectB != null) {
                                    jSONObject5.put(com.igexin.push.core.b.Y, jSONObjectB);
                                }
                                break;
                            } catch (Throwable unused4) {
                            }
                            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 106, a(), jSONObject5);
                            return;
                        }
                        break;
                    case 106:
                        if (obj != null && (obj instanceof JSONObject)) {
                            try {
                                jSONObject = (JSONObject) obj;
                            } catch (Throwable unused5) {
                            }
                            if (jSONObject.has("result")) {
                                if ((jSONObject.optInt("result") & 1) == 0 || !jSONObject.has(com.igexin.push.core.b.Y)) {
                                    z = false;
                                    if (!z) {
                                        CcgAgent.notifyConfigReady(null);
                                    }
                                } else {
                                    JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(com.igexin.push.core.b.Y);
                                    c = jSONObjectOptJSONObject2;
                                    if (jSONObjectOptJSONObject2 != null) {
                                        CcgAgent.notifyConfigReady(jSONObjectOptJSONObject2);
                                        try {
                                            JSONObject jSONObjectOptJSONObject3 = c.optJSONObject(com.umeng.ccg.a.f11001a);
                                            if (jSONObjectOptJSONObject3 != null && jSONObjectOptJSONObject3.has(com.umeng.ccg.a.m)) {
                                                n.a(UMGlobalContext.getAppContext()).b();
                                            }
                                            break;
                                        } catch (Throwable unused6) {
                                        }
                                        z = true;
                                    }
                                    if (!z) {
                                    }
                                }
                                if (!new File(UMGlobalContext.getAppContext().getFilesDir().getAbsolutePath() + File.separator + bx.n).exists()) {
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "PI: flag file exist, start process.");
                                    com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 310, a(), null, 0L);
                                }
                            }
                            if (g()) {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 检测到集成的SDK类型集合发生变化，发起云配参数拉取请求(设置本地should fetch标志).");
                                String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), f11004a, "");
                                a(true);
                                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 101, a(), strImprintProperty2);
                            } else {
                                c(UMGlobalContext.getAppContext());
                                String strImprintProperty3 = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), f11004a, "");
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "manual check iucc value: " + strImprintProperty3);
                                a(strImprintProperty3);
                            }
                            if (!new File(UMGlobalContext.getAppContext().getFilesDir().getAbsolutePath() + File.separator + bx.n).exists()) {
                            }
                            break;
                        }
                        break;
                    case 107:
                        if (obj != null) {
                            try {
                                if (obj instanceof String) {
                                    String str3 = (String) obj;
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[IMPRINT_IUCC_CHANGED] iucc : " + str3);
                                    a(str3);
                                }
                            } catch (Throwable th) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "[imprint] process error " + th.getMessage());
                                return;
                            }
                        }
                        break;
                    default:
                        switch (i2) {
                            case 201:
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "recv PARSE_CONFIG msg.");
                                if (obj != null && (obj instanceof JSONObject)) {
                                    c((JSONObject) obj);
                                    break;
                                }
                                break;
                            case 202:
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "recv COLLECTION_JUDGMENT msg.");
                                if (obj != null && (obj instanceof ArrayList) && (size = (arrayList = (ArrayList) obj).size()) > 0) {
                                    int i4 = 0;
                                    JSONObject jSONObject6 = null;
                                    while (i4 < size) {
                                        ab abVar = (ab) arrayList.get(i4);
                                        String strA = abVar.a();
                                        if (com.umeng.ccg.a.i.equalsIgnoreCase(strA)) {
                                            JSONObject jSONObject7 = new JSONObject();
                                            jSONObject7.put("scene", 202);
                                            jSONObject6 = jSONObject7;
                                        }
                                        JSONObject jSONObjectA4 = abVar.a(strA, jSONObject6);
                                        if (jSONObjectA4 != null) {
                                            long jOptLong = !Arrays.asList(d).contains(abVar.a()) ? jSONObjectA4.optLong("delay") * 1000 : j;
                                            if (com.umeng.ccg.a.i.equalsIgnoreCase(abVar.a()) && jSONObjectA4.optInt(com.umeng.ccg.a.C) == 0) {
                                                jOptLong = jSONObjectA4.optLong("delay") * 1000;
                                            }
                                            long j3 = jOptLong;
                                            int iOptInt = jSONObjectA4.optInt(com.umeng.ccg.a.B);
                                            jSONObjectA4.remove("delay");
                                            StringBuilder sb = new StringBuilder();
                                            arrayList2 = arrayList;
                                            sb.append("send START_COLLECT msg, delayTs = ");
                                            sb.append(j3);
                                            UMRTLog.i(UMRTLog.RTLOG_TAG, sb.toString());
                                            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), (com.umeng.ccg.a.i.equalsIgnoreCase(abVar.a()) && iOptInt == 2) ? 204 : 203, a(), jSONObjectA4, j3);
                                        } else {
                                            arrayList2 = arrayList;
                                        }
                                        i4++;
                                        arrayList = arrayList2;
                                        j = 0;
                                    }
                                    break;
                                }
                                break;
                            case 203:
                                if (obj != null && (obj instanceof JSONObject)) {
                                    JSONObject jSONObject8 = (JSONObject) obj;
                                    String strOptString2 = jSONObject8.optString("actionName");
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv START_COLLECT msg. name is : " + strOptString2);
                                    if (!com.umeng.ccg.b.a(strOptString2)) {
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "Local switch of [" + strOptString2 + "] is off, ignore this command.");
                                    } else {
                                        String string = jSONObject8.toString();
                                        if (Arrays.asList(e).contains(strOptString2)) {
                                            if (com.umeng.ccg.a.f.equalsIgnoreCase(strOptString2)) {
                                                UMRTLog.i(UMRTLog.RTLOG_TAG, "register Intent.ACTION_SCREEN_ON");
                                                a(UMGlobalContext.getAppContext(), "android.intent.action.SCREEN_ON", n);
                                            }
                                            if (com.umeng.ccg.a.g.equalsIgnoreCase(strOptString2)) {
                                                UMRTLog.i(UMRTLog.RTLOG_TAG, "register Intent.ACTION_SCREEN_OFF");
                                                a(UMGlobalContext.getAppContext(), "android.intent.action.SCREEN_OFF", n);
                                            }
                                            if (com.umeng.ccg.a.h.equalsIgnoreCase(strOptString2)) {
                                                UMRTLog.i(UMRTLog.RTLOG_TAG, "register Intent.ACTION_USER_PRESENT");
                                                a(UMGlobalContext.getAppContext(), PushConsts.ACTION_BROADCAST_USER_PRESENT, n);
                                            }
                                            if (com.umeng.ccg.a.i.equalsIgnoreCase(strOptString2)) {
                                                int actUpFlag = CcgAgent.getActUpFlag();
                                                UMRTLog.i(UMRTLog.RTLOG_TAG, "act up flag: " + actUpFlag);
                                                if (actUpFlag <= 0) {
                                                    if (jSONObject8.has(com.umeng.ccg.a.C)) {
                                                        int iOptInt2 = jSONObject8.optInt(com.umeng.ccg.a.C);
                                                        if (iOptInt2 == 0) {
                                                            a(UMGlobalContext.getAppContext(), strOptString2, jSONObject8);
                                                        } else if (iOptInt2 == 1) {
                                                            a(UMGlobalContext.getAppContext(), "android.intent.action.SCREEN_ON", new b());
                                                        }
                                                    }
                                                }
                                            }
                                            if (com.umeng.ccg.a.n.equalsIgnoreCase(strOptString2)) {
                                                b(strOptString2);
                                                this.l = true;
                                                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 401, a(), null, 0L);
                                            }
                                        } else {
                                            b(strOptString2);
                                            if (CcgAgent.hasRegistedActionInfo()) {
                                                boolean z2 = CcgAgent.getActionInfo("anti") != null;
                                                String strOptString3 = jSONObject8.optString(com.umeng.ccg.a.v);
                                                if (TextUtils.isEmpty(strOptString3)) {
                                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "忽略 本次采集项[" + strOptString2 + "]采集请求.");
                                                } else {
                                                    ActionInfo actionInfo = CcgAgent.getActionInfo(strOptString3);
                                                    if (actionInfo != null) {
                                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "调用[" + strOptString3 + "] onCommand接口方法, 参数: " + jSONObject8.toString());
                                                        actionInfo.onCommand(UMGlobalContext.getAppContext(), strOptString2, jSONObject8);
                                                    }
                                                }
                                                if (!z2) {
                                                    as.a(UMGlobalContext.getAppContext(), string);
                                                }
                                            } else {
                                                as.a(UMGlobalContext.getAppContext(), string);
                                            }
                                        }
                                    }
                                    break;
                                }
                                break;
                            case 204:
                                if (obj != null && (obj instanceof JSONObject)) {
                                    JSONObject jSONObject9 = (JSONObject) obj;
                                    String strOptString4 = jSONObject9.optString("actionName");
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv ACTUP_EVENT msg. name is : " + strOptString4);
                                    if (!com.umeng.ccg.b.a(strOptString4)) {
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "Local switch of [" + strOptString4 + "] is off, ignore this command.");
                                        break;
                                    } else if (com.umeng.ccg.a.i.equalsIgnoreCase(strOptString4)) {
                                        int actUpFlag2 = CcgAgent.getActUpFlag();
                                        int iOptInt3 = jSONObject9.has("index") ? jSONObject9.optInt("index") : 0;
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "act up flag: " + actUpFlag2);
                                        if ((actUpFlag2 <= 0 || iOptInt3 != 0) && jSONObject9.has(com.umeng.ccg.a.C)) {
                                            int iOptInt4 = jSONObject9.optInt(com.umeng.ccg.a.C);
                                            int iOptInt5 = jSONObject9.optInt(com.umeng.ccg.a.B);
                                            if (iOptInt4 == 0 && iOptInt5 == 2) {
                                                a(UMGlobalContext.getAppContext(), strOptString4, jSONObject9);
                                                ab abVar2 = j;
                                                if (abVar2 != null && (abVar2 instanceof ae) && (jSONObjectD = ((ae) abVar2).d(com.umeng.ccg.a.i)) != null) {
                                                    com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 204, a(), jSONObjectD, jSONObjectD.has("delay") ? jSONObjectD.optInt("delay") * 1000 : 0L);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                                break;
                            default:
                                switch (i2) {
                                    case 301:
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "recv REPORT_SCREEN_ON msg.");
                                        b(com.umeng.ccg.a.f);
                                        if (this.m.containsKey(com.umeng.ccg.a.f) && (cVar = this.m.get(com.umeng.ccg.a.f)) != null) {
                                            JSONObject jSONObjectA5 = ao.a(UMGlobalContext.getAppContext(), 1, cVar.a(), cVar.b(), this.l);
                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "screen_on event param: " + jSONObjectA5.toString());
                                            av.a(new aq(aq.f10856a, jSONObjectA5), 0L, TimeUnit.SECONDS);
                                            break;
                                        }
                                        break;
                                    case 302:
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "recv REPORT_SCREEN_OFF msg.");
                                        b(com.umeng.ccg.a.g);
                                        if (this.m.containsKey(com.umeng.ccg.a.g) && (cVar2 = this.m.get(com.umeng.ccg.a.g)) != null) {
                                            JSONObject jSONObjectA6 = ao.a(UMGlobalContext.getAppContext(), 3, cVar2.a(), cVar2.b(), this.l);
                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "screen_off event param: " + jSONObjectA6.toString());
                                            av.a(new aq(aq.f10856a, jSONObjectA6), 0L, TimeUnit.SECONDS);
                                            break;
                                        }
                                        break;
                                    case 303:
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "recv REPORT_SCREEN_UNLOCK msg.");
                                        b(com.umeng.ccg.a.h);
                                        if (this.m.containsKey(com.umeng.ccg.a.h) && (cVar3 = this.m.get(com.umeng.ccg.a.h)) != null) {
                                            JSONObject jSONObjectA7 = ao.a(UMGlobalContext.getAppContext(), 2, cVar3.a(), cVar3.b(), this.l);
                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "screen_unlock event param: " + jSONObjectA7.toString());
                                            av.a(new aq(aq.f10856a, jSONObjectA7), 0L, TimeUnit.SECONDS);
                                            break;
                                        }
                                        break;
                                    case 304:
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "recv INVOKE_APPACT_WHEN_SC_ON msg.");
                                        if (!com.umeng.ccg.b.a(com.umeng.ccg.a.i)) {
                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "Local switch of [umc_cfg] is off, ignore this command.");
                                        } else {
                                            JSONObject jSONObject10 = new JSONObject();
                                            jSONObject10.put("scene", 304);
                                            ab abVar3 = j;
                                            JSONObject jSONObjectA8 = abVar3.a(abVar3.a(), jSONObject10);
                                            if (jSONObjectA8 != null) {
                                                a(UMGlobalContext.getAppContext(), com.umeng.ccg.a.i, jSONObjectA8);
                                            } else {
                                                UMRTLog.i(UMRTLog.RTLOG_TAG, "appActAction.process return null !");
                                            }
                                        }
                                        break;
                                    case 305:
                                        C0902d c0902d = (C0902d) obj;
                                        JSONObject jSONObjectA9 = a(c0902d.f11009a, c0902d.b, c0902d.c);
                                        if (jSONObjectA9 != null) {
                                            av.a(new aq(aq.b, jSONObjectA9), 0L, TimeUnit.SECONDS);
                                        }
                                        break;
                                    default:
                                        switch (i2) {
                                            case 310:
                                                UMRTLog.i(UMRTLog.RTLOG_TAG, "PI: recv GET_PI_INFO msg.");
                                                n nVarA = n.a(UMGlobalContext.getAppContext());
                                                if (nVarA != null) {
                                                    ArrayList<n.b> arrayListF = nVarA.f();
                                                    for (int i5 = 0; i5 < arrayListF.size(); i5++) {
                                                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 312, a(), arrayListF.get(i5), 0L);
                                                    }
                                                }
                                                break;
                                            case 311:
                                                UMRTLog.i(UMRTLog.RTLOG_TAG, "PO: recv GET_PO_INFO msg.");
                                                n nVarA2 = n.a(UMGlobalContext.getAppContext());
                                                if (nVarA2 != null) {
                                                    ArrayList<n.c> arrayListG = nVarA2.g();
                                                    for (int i6 = 0; i6 < arrayListG.size(); i6++) {
                                                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 313, a(), arrayListG.get(i6), 3000L);
                                                    }
                                                }
                                                break;
                                            case 312:
                                                UMRTLog.i(UMRTLog.RTLOG_TAG, "PI: recv REPORT_PI_INFO msg.");
                                                if (obj != null && (obj instanceof n.b)) {
                                                    n.b bVar = (n.b) obj;
                                                    String strA2 = bVar.a();
                                                    if (!TextUtils.isEmpty(strA2)) {
                                                        JSONObject jSONObject11 = new JSONObject();
                                                        JSONArray jSONArray = new JSONArray();
                                                        JSONObject jSONObject12 = new JSONObject();
                                                        jSONObject12.put("id", "$$_pi");
                                                        jSONObject12.put("pkg", strA2);
                                                        jSONObject12.put("ts", bVar.b());
                                                        jSONArray.put(jSONObject12);
                                                        jSONObject11.put("ekv", jSONArray);
                                                        JSONObject jSONObjectA10 = ao.a(UMGlobalContext.getAppContext(), new JSONArray(), "");
                                                        if (jSONObjectA10 != null && (jSONObjectA = ao.a(jSONObjectA10, jSONObject11)) != null) {
                                                            av.a(new aq(aq.d, jSONObjectA), 0L, TimeUnit.SECONDS);
                                                            Thread.sleep(1000L);
                                                            break;
                                                        }
                                                    }
                                                }
                                                break;
                                            case 313:
                                                UMRTLog.i(UMRTLog.RTLOG_TAG, "PO: recv REPORT_PO_INFO msg.");
                                                if (obj != null && (obj instanceof n.c)) {
                                                    n.c cVar4 = (n.c) obj;
                                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>PO: po: " + cVar4.a() + "; ts: " + cVar4.d());
                                                    String strA3 = cVar4.a();
                                                    String strB = cVar4.b();
                                                    if (!TextUtils.isEmpty(strA3)) {
                                                        JSONObject jSONObject13 = new JSONObject();
                                                        JSONArray jSONArray2 = new JSONArray();
                                                        JSONObject jSONObject14 = new JSONObject();
                                                        jSONObject14.put("id", "$$_po");
                                                        jSONObject14.put("pkg", strA3);
                                                        jSONObject14.put("cls", strB);
                                                        jSONObject14.put("ts", cVar4.d());
                                                        jSONObject14.put("u", cVar4.e());
                                                        if (n.c()) {
                                                            jSONObject14.put("stat", "fg");
                                                        } else {
                                                            jSONObject14.put("stat", OapsKey.KEY_BG);
                                                        }
                                                        jSONArray2.put(jSONObject14);
                                                        jSONObject13.put("ekv", jSONArray2);
                                                        JSONObject jSONObjectA11 = ao.a(UMGlobalContext.getAppContext(), new JSONArray(), "");
                                                        if (jSONObjectA11 != null && (jSONObjectA2 = ao.a(jSONObjectA11, jSONObject13)) != null) {
                                                            av.a(new aq(aq.d, jSONObjectA2), 0L, TimeUnit.SECONDS);
                                                            Thread.sleep(1000L);
                                                            break;
                                                        }
                                                    }
                                                }
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                }
                return;
            }
            if (this.l && obj != null && (obj instanceof a)) {
                a aVar = (a) obj;
                long jA = aVar.a();
                long jB = aVar.b();
                if (jB <= jA) {
                    return;
                }
                long j4 = jB - jA;
                if (j4 >= 1000) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> APMode: 上报退出飞行模式事件：ts1 = " + jA + "; ts2 = " + jB + "; 停留: " + (j4 / 1000) + "秒");
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> APMode: 上报退出飞行模式事件：ts1 = " + jA + "; ts2 = " + jB + "; 停留: " + j4 + "毫秒");
                }
                JSONObject jSONObjectA12 = ao.a(UMGlobalContext.getAppContext(), 4, new JSONArray("[\"uapp\"]"), "uapp", this.l);
                jSONObjectA12.put("ts1", jA);
                jSONObjectA12.put("ts2", jB);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "APMode event param: " + jSONObjectA12);
                av.a(new aq(aq.f10856a, jSONObjectA12), 0L, TimeUnit.SECONDS);
            }
        } catch (Throwable unused7) {
        }
    }
}
