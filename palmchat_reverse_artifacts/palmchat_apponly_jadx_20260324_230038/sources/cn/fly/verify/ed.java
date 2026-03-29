package cn.fly.verify;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ed {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ed f2223a;
    private HashMap<String, Object> b;

    private ed() {
        HashMap<String, Object> mapC = c();
        this.b = mapC;
        if (mapC == null) {
            this.b = new HashMap<>();
        }
        ArrayList<bd> arrayListB = bu.b();
        if (arrayListB == null || arrayListB.isEmpty()) {
            return;
        }
        for (bd bdVar : arrayListB) {
            if (!this.b.containsKey(bdVar.a())) {
                this.b.put(bdVar.a(), 0);
            }
        }
    }

    public static ed a() {
        if (f2223a == null) {
            synchronized (ed.class) {
                if (f2223a == null) {
                    f2223a = new ed();
                }
            }
        }
        return f2223a;
    }

    private HashMap<String, Object> c() {
        try {
            return bv.a().h();
        } catch (Throwable unused) {
            return null;
        }
    }

    public HashMap<String, Object> b() {
        return this.b;
    }

    public static String a(String str) {
        return eg.a(str, 99);
    }
}
