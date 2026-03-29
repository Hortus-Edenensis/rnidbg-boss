package com.getui.gtc.a.a;

import android.net.Network;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5661a;
    public byte[] b;
    public Network c;
    public boolean d;
    public e e;
    public boolean f;
    public boolean g;
    public int h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public HashMap<String, String> n;

    public f() {
        this.c = null;
        this.h = 30000;
        this.i = 60000;
        this.j = true;
        this.k = true;
        this.l = false;
        this.m = true;
        this.n = new HashMap<>();
    }

    public void a() {
    }

    public f(String str) {
        this.c = null;
        this.h = 30000;
        this.i = 60000;
        this.j = true;
        this.k = true;
        this.l = false;
        this.m = true;
        HashMap<String, String> map = new HashMap<>();
        this.n = map;
        this.f5661a = str;
        map.put("Content-Type", "application/x-www-form-urlencoded");
    }

    public void a(int i) {
    }

    public void a(Map<String, List<String>> map, byte[] bArr) {
    }
}
