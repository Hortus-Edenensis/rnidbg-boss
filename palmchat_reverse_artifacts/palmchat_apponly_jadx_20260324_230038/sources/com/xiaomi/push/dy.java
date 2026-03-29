package com.xiaomi.push;

import android.util.Pair;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Vector;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class dy {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Vector<Pair<String, Long>> f354a = new Vector<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, Long> f11529a = new ConcurrentHashMap<>();

    public static String a() {
        StringBuilder sb = new StringBuilder();
        synchronized (f354a) {
            for (int i = 0; i < f354a.size(); i++) {
                Pair<String, Long> pairElementAt = f354a.elementAt(i);
                sb.append((String) pairElementAt.first);
                sb.append(":");
                sb.append(pairElementAt.second);
                if (i < f354a.size() - 1) {
                    sb.append(com.huawei.openalliance.ad.constant.x.aQ);
                }
            }
            f354a.clear();
        }
        return sb.toString();
    }
}
