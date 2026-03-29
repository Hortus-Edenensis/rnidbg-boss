package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, Boolean> f11026a = new HashMap();
    private static Object b = new Object();

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f11027a = new b();

        private a() {
        }
    }

    public static b b() {
        return a.f11027a;
    }

    public void a() {
        synchronized (b) {
            f11026a.clear();
        }
    }

    private b() {
    }

    public static boolean a(String str) {
        if (!d.a(str)) {
            return false;
        }
        synchronized (b) {
            if (!f11026a.containsKey(str)) {
                return true;
            }
            return f11026a.get(str).booleanValue();
        }
    }

    @Override // com.umeng.commonsdk.config.f
    public void a(String str, Boolean bool) {
        if (d.a(str)) {
            synchronized (b) {
                Map<String, Boolean> map = f11026a;
                if (map != null) {
                    map.put(str, bool);
                }
            }
        }
    }
}
