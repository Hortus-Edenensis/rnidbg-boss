package com.ss.android.socialbase.downloader.constants;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class pn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JSONObject f10603a = new JSONObject();
    public static long b = 512000;
    public static volatile String fx = "";
    public static long iz = 5242880;
    public static long n = 10485760;
    public static volatile String nr = "";
    public static long pn = 50;
    public static volatile String u = "";
    public static long x = 31457280;

    public static void u(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        u = str;
    }
}
