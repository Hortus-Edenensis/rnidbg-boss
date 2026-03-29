package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class mj2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19237a;
    public String b;
    public int g = -1;
    public int d = 0;
    public boolean e = false;
    public boolean f = false;
    public Map<String, Object> c = new HashMap();

    public mj2(String str) {
        this.f19237a = str;
    }

    public String a() {
        return this.b;
    }

    public int b() {
        return this.g;
    }

    public void c(String str) {
        this.b = str;
    }

    public void d(int i) {
        this.g = i;
    }

    public void e(String str, String str2) {
        Map<String, Object> map = this.c;
        if (map != null) {
            map.put(str, str2);
        }
    }

    public String toString() {
        return "HttpResponse{responseBody='" + this.b + "', responseCode=" + this.g + '}';
    }
}
