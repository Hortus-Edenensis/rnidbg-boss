package com.opos.cmn.func.dl.base.e;

import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f7987a;
    public File b;
    public com.opos.cmn.func.dl.base.a.b c;
    public List<c> d;
    public a e;

    public b(com.opos.cmn.func.dl.base.a.b bVar) {
        this.c = bVar;
        File file = bVar.i;
        this.f7987a = file;
        File file2 = bVar.j;
        this.b = file2;
        this.e = new d(file, file2);
    }
}
