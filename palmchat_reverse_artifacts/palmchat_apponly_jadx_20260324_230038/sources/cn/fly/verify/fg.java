package cn.fly.verify;

import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public abstract class fg {
    public abstract InputStream a() throws Throwable;

    public abstract long b() throws Throwable;

    public InputStream c() throws Throwable {
        return new ff(a());
    }
}
