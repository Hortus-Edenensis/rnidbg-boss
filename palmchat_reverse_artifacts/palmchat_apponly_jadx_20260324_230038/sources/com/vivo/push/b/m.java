package com.vivo.push.b;

import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class m extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<String> f11204a;

    public m() {
        super(8);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("tags_list", this.f11204a);
    }

    public final ArrayList<String> d() {
        return this.f11204a;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnListTagCommand";
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f11204a = dVar.c("tags_list");
    }
}
