package com.vivo.push.b;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class t extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<String> f11210a;
    private ArrayList<String> b;

    public t(int i) {
        super(i);
        this.f11210a = null;
        this.b = null;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("content", this.f11210a);
        dVar.a("error_msg", this.b);
    }

    public final ArrayList<String> d() {
        return this.f11210a;
    }

    public final List<String> e() {
        return this.b;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnSetTagsCommand";
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f11210a = dVar.c("content");
        this.b = dVar.c("error_msg");
    }
}
