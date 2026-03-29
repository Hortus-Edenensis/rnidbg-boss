package com.qq.gdt.action.f.b;

import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f10497a;
    private final e b;
    private c c;

    public a(e eVar, g gVar, c cVar) {
        this.b = eVar;
        this.f10497a = gVar;
        this.c = cVar;
    }

    private i b() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.c.a());
        arrayList.add(new com.qq.gdt.action.f.b.a.b());
        return new com.qq.gdt.action.f.b.a.d(this.b, arrayList, 0, this.f10497a, this).a(this.f10497a);
    }

    public i a() throws IOException {
        try {
            return b();
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    public void a(final b bVar) {
        try {
            this.b.a().execute(new Runnable() { // from class: com.qq.gdt.action.f.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        i iVarA = a.this.a();
                        b bVar2 = bVar;
                        if (bVar2 != null) {
                            bVar2.a(iVarA);
                        }
                    } catch (Throwable th) {
                        b bVar3 = bVar;
                        if (bVar3 != null) {
                            bVar3.a(th);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            if (bVar != null) {
                bVar.a(th);
            }
        }
    }
}
