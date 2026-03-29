package com.tencent.turingfd.sdk.ams.ad;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Bagasse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10659a;
    public final URL b;
    public final String c = "GET";
    public final Map<String, String> d;
    public final int e;
    public final int f;
    public final boolean g;

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.Bagasse$do, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class Cdo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10660a;
        public final URL b;
        public final HashMap<String, String> c;
        public int d;
        public int e;
        public boolean f;

        public Cdo(String str) throws MalformedURLException {
            HashMap<String, String> map = new HashMap<>();
            this.c = map;
            this.d = 10000;
            this.e = 10000;
            this.f = true;
            this.f10660a = str;
            this.b = new URL(str);
            map.put("Content-Type", "application/json; charset=utf-8");
        }
    }

    public Bagasse(Cdo cdo) {
        this.f10659a = cdo.f10660a;
        this.b = cdo.b;
        this.d = cdo.c;
        this.e = cdo.d;
        this.f = cdo.e;
        this.g = cdo.f;
    }
}
