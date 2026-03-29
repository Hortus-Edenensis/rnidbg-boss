package com.getui.gtc.dim.b;

import android.text.TextUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    private static final List<String> b = Arrays.asList("dim-2-1-21-5", "dim-2-1-21-3", "dim-2-1-21-2", "dim-2-1-21-1");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, h> f5719a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f5720a = new c(0);
    }

    private c() {
        this.f5719a = new ConcurrentHashMap();
    }

    public static c a() {
        return a.f5720a;
    }

    public /* synthetic */ c(byte b2) {
        this();
    }

    public final h a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        h hVar = this.f5719a.get(str);
        if (hVar != null) {
            Object obj = hVar.f5729a;
            if (obj instanceof List) {
                List list = (List) obj;
                return new h(list.isEmpty() ? Collections.emptyList() : new ArrayList(list), hVar.b);
            }
        }
        return hVar;
    }

    public final void a(String str, Object obj, long j) {
        if (f.h(str)) {
            com.getui.gtc.dim.e.b.a(str + " skip dim ram cache = " + obj);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        h hVar = new h(obj, j);
        com.getui.gtc.dim.e.b.a(str + " update dim ram cache = " + obj);
        this.f5719a.put(str, hVar);
    }
}
