package com.opos.exoplayer.core.source;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.source.h;
import com.opos.exoplayer.core.w;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class b<T> implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<T, h> f8288a;
    private com.opos.exoplayer.core.g b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements h.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f8289a;
        final /* synthetic */ h b;

        public a(Object obj, h hVar) {
            this.f8289a = obj;
            this.b = hVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.opos.exoplayer.core.source.h.a
        public void a(h hVar, w wVar, @Nullable Object obj) {
            b.this.a(this.f8289a, this.b, wVar, obj);
        }
    }

    @Override // com.opos.exoplayer.core.source.h
    @CallSuper
    public void a() {
        Iterator<h> it = this.f8288a.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public abstract void a(@Nullable T t, h hVar, w wVar, @Nullable Object obj);

    @Override // com.opos.exoplayer.core.source.h
    @CallSuper
    public void b() {
        Iterator<h> it = this.f8288a.values().iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        this.f8288a.clear();
        this.b = null;
    }

    @Override // com.opos.exoplayer.core.source.h
    @CallSuper
    public void a(com.opos.exoplayer.core.g gVar, boolean z, h.a aVar) {
        this.b = gVar;
    }

    public void a(@Nullable T t, h hVar) {
        com.opos.exoplayer.core.util.a.a(!this.f8288a.containsKey(t));
        this.f8288a.put(t, hVar);
        hVar.a(this.b, false, new a(t, hVar));
    }
}
