package com.getui.gtc.dyc;

import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f5756a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final e f5757a = new e();
    }

    private e() {
        this.f5756a = c.a();
    }

    public static e a() {
        return a.f5757a;
    }

    public HashMap<String, h> c() {
        return this.f5756a.c();
    }

    public h a(String str) {
        return this.f5756a.a(str);
    }

    public boolean a(String str, h hVar) {
        if (hVar == null) {
            return false;
        }
        return this.f5756a.a(str, hVar);
    }
}
