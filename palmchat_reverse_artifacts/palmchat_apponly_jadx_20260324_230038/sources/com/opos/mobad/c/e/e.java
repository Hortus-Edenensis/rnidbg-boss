package com.opos.mobad.c.e;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class e implements c<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8598a = 0;

    @Override // com.opos.mobad.c.e.c
    public void a() {
        this.f8598a = 0;
    }

    public int b() {
        return this.f8598a;
    }

    @Override // com.opos.mobad.c.e.c
    public void a(Integer num) {
        this.f8598a += num.intValue();
    }
}
