package com.baidu.location.e.a;

import android.os.Handler;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Integer, Object> f3511a = new ConcurrentHashMap();
    private Handler b;

    /* JADX INFO: renamed from: com.baidu.location.e.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0067a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f3512a = new a();
    }

    public static a a() {
        return C0067a.f3512a;
    }

    public void b() {
        this.b = new Handler();
    }
}
