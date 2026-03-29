package com.opos.mobad.c.e;

import com.opos.mobad.c.e.c;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class f<T extends c> implements d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<d<T>> f8599a;

    public f(List<d<T>> list) {
        this.f8599a = list;
    }

    @Override // com.opos.mobad.c.e.d
    public boolean a(T t) {
        List<d<T>> list = this.f8599a;
        if (list == null || list.size() <= 0) {
            return true;
        }
        Iterator<d<T>> it = this.f8599a.iterator();
        while (it.hasNext()) {
            if (it.next().a(t)) {
                return true;
            }
        }
        return false;
    }
}
