package com.tencent.turingfd.sdk.ams.ad;

import android.os.Build;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Perseus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, Cdo> f10734a;
    public static Phoenix b;
    public static String c;

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.Perseus$do, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class Cdo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Aquila f10735a;
        public int b = 0;

        public Cdo(Aquila aquila) {
            this.f10735a = aquila;
        }
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f10734a = concurrentHashMap;
        concurrentHashMap.put("C892BA2", new Cdo(new Solar()));
        f10734a.put("43780D5", new Cdo(new Solar()));
        f10734a.put("7CD3AF2", new Cdo(new Solar()));
        f10734a.put("22792AF", new Cdo(new Scorpius()));
        c = "";
        try {
            c = Norma.a(Build.MANUFACTURER.toLowerCase().getBytes()).substring(0, 7);
        } catch (Throwable unused) {
        }
    }
}
