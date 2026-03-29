package com.opos.mobad.template.c;

import android.content.Context;
import com.opos.mobad.template.a;
import com.opos.mobad.template.c.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c<T extends d> implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final List<T> f9339a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<T> f9340a = new ArrayList();

        public a a(T t) throws NullPointerException {
            if (t == null) {
                throw new NullPointerException("iCreator is null");
            }
            this.f9340a.add(t);
            return this;
        }
    }

    public c(a<T> aVar) {
        this.f9339a = ((a) aVar).f9340a;
    }

    @Override // com.opos.mobad.template.c.d
    public com.opos.mobad.template.a a(Context context, int i, com.opos.mobad.template.l.a aVar, a.InterfaceC0778a interfaceC0778a, com.opos.mobad.d.a aVar2) {
        List<T> list = this.f9339a;
        if (list == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            com.opos.mobad.template.a aVarA = it.next().a(context, i, aVar, interfaceC0778a, aVar2);
            if (aVarA != null) {
                return aVarA;
            }
        }
        return null;
    }
}
