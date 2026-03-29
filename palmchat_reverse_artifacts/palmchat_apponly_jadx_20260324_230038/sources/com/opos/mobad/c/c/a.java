package com.opos.mobad.c.c;

import android.util.LruCache;
import com.opos.mobad.c.d;
import com.opos.mobad.c.e.b;
import com.opos.mobad.c.e.e;
import com.opos.mobad.c.e.f;
import com.opos.mobad.c.e.g;
import com.opos.mobad.c.e.h;
import com.opos.mobad.c.e.i;
import java.util.LinkedList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f8592a;
    private h c = new h(15);
    private LruCache<String, b<Integer>> b = new LruCache<>(50);

    public a(d dVar) {
        this.f8592a = dVar;
    }

    private b<Integer> b(final String str) {
        b<Integer> bVar = this.b.get(str);
        if (bVar != null) {
            return bVar;
        }
        e eVar = new e();
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(new i(90000));
        linkedList2.add(this.c);
        linkedList.add(new g(new f(linkedList2)));
        final i iVar = new i(90000);
        linkedList.add(iVar);
        com.opos.mobad.c.e.a aVar = new com.opos.mobad.c.e.a(eVar, new f(linkedList), new b<e>() { // from class: com.opos.mobad.c.c.a.1
            @Override // com.opos.mobad.c.e.b
            public void a(e eVar2) {
                iVar.a(eVar2);
                a.this.a(str, eVar2.b());
            }
        });
        this.b.put(str, aVar);
        return aVar;
    }

    public void a(String str) {
        b(str).a(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        this.f8592a.d().a(str, i);
    }
}
