package cn.fly.verify;

import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class av {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private fk f2077a;

    public av(int i, String str, String str2) {
        this.f2077a = new fk(i, str, str2);
    }

    public <T> T a(HashMap<String, String> map, HashMap<String, Object> map2, String str, boolean z) throws Throwable {
        return (T) a(true, map, map2, str, z);
    }

    public <T> T a(boolean z, HashMap<String, String> map, HashMap<String, Object> map2, String str, boolean z2) throws Throwable {
        return (T) this.f2077a.a(z, map, map2, str, z2);
    }

    public static HashMap<String, String> a() throws Throwable {
        return fk.a();
    }
}
