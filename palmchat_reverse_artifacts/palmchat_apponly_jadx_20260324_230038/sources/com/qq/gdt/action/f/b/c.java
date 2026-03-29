package com.qq.gdt.action.f.b;

import com.qq.gdt.action.j.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f10501a;
    private List<com.qq.gdt.action.f.b.a.c> b;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f10502a = new d();
        private final List<com.qq.gdt.action.f.b.a.c> b = new ArrayList();

        public a a(com.qq.gdt.action.f.b.a.c cVar) {
            if (cVar == null) {
                o.b("interceptor == null");
                return this;
            }
            this.b.add(cVar);
            return this;
        }

        public c a() {
            return new c(this);
        }
    }

    public c(a aVar) {
        this.b = new ArrayList();
        this.f10501a = aVar.f10502a;
        this.b = k.a(aVar.b);
    }

    public com.qq.gdt.action.f.b.a a(g gVar) {
        return new com.qq.gdt.action.f.b.a(new e(this.f10501a), gVar, this);
    }

    public List<com.qq.gdt.action.f.b.a.c> a() {
        return this.b;
    }
}
