package com.zm.fda.Z200O;

import com.zm.fda.utils.EventLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZZ00Z {
    public static List<Integer> A = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f16678a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final String f = "fda_crash";
    public static final String g = "file_fob_event";
    public static final String h = "file_fob_crash";
    public static final String i = "last_report_app_open_time";
    public static final String j = "key_oaid";
    public static final String k = "key_oaid_new";
    public static final String l = "suid";
    public static final String m = "sdk_inited";
    public static final String n = "sdk_last_params";
    public static final String o = "sdk_last_params_new";
    public static final String p = "sdk_func_open";
    public static final String q = "fda_aes_key";
    public static final String r = "fda_aes_iv";
    public static final String s = "crash_md5";
    public static final String t = "crash_appid";
    public static final String u = "crash_aes_key";
    public static final String v = "crash_aes_iv";
    public static final String w = "00000000-0000-0000-0000-000000000000";
    public static final String x = "ANDROID";
    public static final long y = 512000;
    public static final int z = 20;

    /* JADX INFO: compiled from: SearchBox */
    public static class O022Z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f16679a = 0;
        public static final int b = 1;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class OO22Z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f16680a = "app_open";
        public static final String b = "db_error";
        public static final String c = "sdk_init";
        public static final String d = "oaid_obtain";
    }

    /* JADX INFO: renamed from: com.zm.fda.Z200O.ZZ00Z$ZZ00Z, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C1170ZZ00Z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f16681a = "005011";
        public static final String b = "https://app.aishuttler.com/sdk/trace";
        public static final String c = "https://test-app.aishuttler.com/sdk/trace";
        public static final String d = "https://app.aishuttler.com/sdk/crash";
        public static final String e = "https://test-app.aishuttler.com/sdk/crash";

        public static String a() {
            return EventLog.isDebugEnable() ? e : d;
        }

        public static String b() {
            return EventLog.isDebugEnable() ? c : b;
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        A = arrayList;
        arrayList.add(1);
        A.add(2);
        A.add(3);
    }
}
