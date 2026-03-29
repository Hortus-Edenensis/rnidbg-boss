package com.qq.gdt.action.f;

import com.qq.gdt.action.f.b.g;
import com.qq.gdt.action.f.d;
import com.qq.gdt.action.j.i;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class d<T extends d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f10515a;
    protected Map<String, String> b;
    protected final g.a c = new g.a();

    public T a(String str) {
        this.f10515a = str;
        return this;
    }

    public void a() {
        this.c.a("User-Agent", i.a("GDTActionSDK-[" + System.getProperty("http.agent") + "]"));
        Map<String, String> map = this.b;
        if (map == null || map.isEmpty()) {
            return;
        }
        for (String str : this.b.keySet()) {
            this.c.a(str, this.b.get(str));
        }
    }
}
