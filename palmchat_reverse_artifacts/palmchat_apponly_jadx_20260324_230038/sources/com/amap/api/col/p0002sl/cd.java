package com.amap.api.col.p0002sl;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class cd extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    CopyOnWriteArrayList<Integer> f2669a;
    private ah b;
    private CopyOnWriteArrayList<at> c;
    private a d;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Comparator<Object> {
        private a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            at atVar = (at) obj;
            at atVar2 = (at) obj2;
            if (atVar == null || atVar2 == null) {
                return 0;
            }
            try {
                if (atVar.getZIndex() > atVar2.getZIndex()) {
                    return 1;
                }
                return atVar.getZIndex() < atVar2.getZIndex() ? -1 : 0;
            } catch (Exception e) {
                ct.a(e, "TileOverlayView", "compare");
                return 0;
            }
        }

        public /* synthetic */ a(cd cdVar, byte b) {
            this();
        }
    }

    public cd(Context context, ah ahVar) {
        super(context);
        this.c = new CopyOnWriteArrayList<>();
        this.d = new a(this, (byte) 0);
        this.f2669a = new CopyOnWriteArrayList<>();
        this.b = ahVar;
    }

    private void g() {
        Object[] array = this.c.toArray();
        Arrays.sort(array, this.d);
        this.c.clear();
        for (Object obj : array) {
            if (obj != null) {
                this.c.add((at) obj);
            }
        }
    }

    public final void a(Canvas canvas) {
        for (at atVar : this.c) {
            if (atVar.isVisible()) {
                atVar.a(canvas);
            }
        }
    }

    public final void b() {
        for (at atVar : this.c) {
            if (atVar != null) {
                atVar.remove();
            }
        }
        this.c.clear();
    }

    public final void c() {
        for (at atVar : this.c) {
            if (atVar != null) {
                atVar.isVisible();
            }
        }
    }

    public final void d() {
        for (at atVar : this.c) {
            if (atVar != null) {
                atVar.a();
            }
        }
    }

    public final void e() {
        for (at atVar : this.c) {
            if (atVar != null) {
                atVar.b();
            }
        }
    }

    public final void f() {
        for (at atVar : this.c) {
            if (atVar != null) {
                atVar.c();
            }
        }
    }

    public final boolean a() {
        return this.c.size() > 0;
    }

    public final boolean b(at atVar) {
        return this.c.remove(atVar);
    }

    public final void a(at atVar) {
        b(atVar);
        this.c.add(atVar);
        g();
    }
}
