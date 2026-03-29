package cn.fly.verify;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2442a;
    private Map<String, List<String>> b;
    private String c;

    public u(int i, Map<String, List<String>> map, String str) {
        this.f2442a = i;
        this.b = map;
        this.c = str;
    }

    public Map<String, List<String>> a() {
        Map<String, List<String>> map = this.b;
        return map == null ? new HashMap() : map;
    }

    public String b() {
        String str = this.c;
        return str == null ? "" : str;
    }

    public String toString() {
        return "HttpSuccessResponse{responseCode=" + this.f2442a + ", header=" + this.b + ", f208c='" + this.c + "'}";
    }
}
