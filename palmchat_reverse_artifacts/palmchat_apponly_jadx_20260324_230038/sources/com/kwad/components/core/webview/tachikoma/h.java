package com.kwad.components.core.webview.tachikoma;

import android.text.TextUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class h {
    private final Map<String, HashMap<Integer, String>> aja = new ConcurrentHashMap();
    private Map<String, Integer> ajb = new ConcurrentSkipListMap();
    private int ajc = 0;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        private static final h ajd = new h();
    }

    private static int bm(String str) {
        return ((((str.length() * 2) + 12) + 16) + 16) / 1024;
    }

    private void bz(int i) {
        try {
            if (this.ajc + i > com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aGd)) {
                ArrayList arrayList = new ArrayList();
                Iterator<Map.Entry<String, Integer>> it = this.ajb.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, Integer> next = it.next();
                    arrayList.add(next.getKey());
                    this.ajc -= next.getValue().intValue();
                    it.remove();
                    if (this.ajc <= com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aGd) - i) {
                        break;
                    }
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    this.aja.remove((String) it2.next());
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    private void r(String str, String str2) {
        int iBm = bm(str2);
        this.ajc += iBm;
        this.ajb.put(str, Integer.valueOf(iBm));
    }

    public static h wt() {
        return a.ajd;
    }

    public final void b(String str, int i, String str2) {
        if (TextUtils.isEmpty(str2) || com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aGd) == 0) {
            return;
        }
        if (this.aja.containsKey(str)) {
            HashMap<Integer, String> map = this.aja.get(str);
            if (map != null && map.containsKey(Integer.valueOf(i))) {
                return;
            } else {
                this.aja.remove(str);
            }
        }
        bz(bm(str2));
        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(Integer.valueOf(i), str2);
        this.aja.put(str, map2);
        r(str, str2);
    }

    public final String o(String str, int i) {
        HashMap<Integer, String> map;
        return (com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aGd) != 0 && this.aja.containsKey(str) && (map = this.aja.get(str)) != null && map.containsKey(Integer.valueOf(i))) ? map.get(Integer.valueOf(i)) : "";
    }
}
