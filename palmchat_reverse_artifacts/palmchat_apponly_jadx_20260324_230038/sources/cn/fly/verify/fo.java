package cn.fly.verify;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class fo extends fg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StringBuilder f2357a = new StringBuilder();

    public fo a(String str) {
        this.f2357a.append(str);
        return this;
    }

    @Override // cn.fly.verify.fg
    public long b() throws Throwable {
        return this.f2357a.toString().getBytes("utf-8").length;
    }

    public String toString() {
        return this.f2357a.toString();
    }

    @Override // cn.fly.verify.fg
    public InputStream a() throws Throwable {
        return new ByteArrayInputStream(this.f2357a.toString().getBytes("utf-8"));
    }
}
