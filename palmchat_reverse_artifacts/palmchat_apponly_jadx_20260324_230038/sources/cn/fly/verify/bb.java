package cn.fly.verify;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public enum bb {
    JP("jp", "Japan"),
    US(com.igexin.push.g.o.f7373a, "United States of America"),
    DEFAULT(null, null);

    private String d;
    private String e;

    bb(String str, String str2) {
        this.d = str;
        this.e = str2;
    }

    public static bb a(String str) {
        if (str == null) {
            return DEFAULT;
        }
        for (bb bbVar : values()) {
            if (str.equalsIgnoreCase(bbVar.d)) {
                return bbVar;
            }
        }
        return DEFAULT;
    }

    public String a() {
        return this.d;
    }
}
