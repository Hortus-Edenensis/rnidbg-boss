package com.opos.mobad.activity.webview.a.a;

import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f8495a = new byte[0];
    private static volatile ExecutorService b;

    public static int a() {
        return 107;
    }

    public static String a(String str) {
        String strOptString = "";
        try {
            strOptString = new JSONObject(str).optString("clickTraceId", "");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("JSUtils", "getClickTraceId:", e);
        }
        com.opos.cmn.an.f.a.b("JSUtils", "getClickTraceId:", strOptString);
        return strOptString;
    }
}
