package com.qq.gdt.action.f.b.a;

import com.qq.gdt.action.f.b.a.c;
import com.qq.gdt.action.f.b.i;
import com.qq.gdt.action.j.o;
import com.qq.gdt.action.j.v;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10500a;

    public f(int i) {
        this.f10500a = i;
    }

    @Override // com.qq.gdt.action.f.b.a.c
    public i a(c.a aVar) throws IOException {
        com.qq.gdt.action.f.b.g gVarA = aVar.a();
        i iVarA = aVar.a(gVarA);
        int i = 0;
        while (!iVarA.b() && i < this.f10500a) {
            iVarA.e().close();
            i++;
            o.a(v.a("Retry for %s, retry number = %d", gVarA.a(), Integer.valueOf(i)), new Object[0]);
            iVarA = aVar.a(gVarA);
        }
        return iVarA;
    }
}
