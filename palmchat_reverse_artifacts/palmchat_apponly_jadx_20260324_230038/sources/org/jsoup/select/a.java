package org.jsoup.select;

import defpackage.jl5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.jsoup.nodes.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a extends org.jsoup.select.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<org.jsoup.select.b> f19836a;
    public int b;

    /* JADX INFO: renamed from: org.jsoup.select.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C1258a extends a {
        public C1258a(Collection<org.jsoup.select.b> collection) {
            super(collection);
        }

        @Override // org.jsoup.select.b
        public boolean a(f fVar, f fVar2) {
            for (int i = 0; i < this.b; i++) {
                if (!this.f19836a.get(i).a(fVar, fVar2)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return jl5.g(this.f19836a, " ");
        }

        public C1258a(org.jsoup.select.b... bVarArr) {
            this(Arrays.asList(bVarArr));
        }
    }

    public a() {
        this.b = 0;
        this.f19836a = new ArrayList<>();
    }

    public void b(org.jsoup.select.b bVar) {
        this.f19836a.set(this.b - 1, bVar);
    }

    public org.jsoup.select.b c() {
        int i = this.b;
        if (i > 0) {
            return this.f19836a.get(i - 1);
        }
        return null;
    }

    public void d() {
        this.b = this.f19836a.size();
    }

    public a(Collection<org.jsoup.select.b> collection) {
        this();
        this.f19836a.addAll(collection);
        d();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends a {
        public b(Collection<org.jsoup.select.b> collection) {
            if (this.b > 1) {
                this.f19836a.add(new C1258a(collection));
            } else {
                this.f19836a.addAll(collection);
            }
            d();
        }

        @Override // org.jsoup.select.b
        public boolean a(f fVar, f fVar2) {
            for (int i = 0; i < this.b; i++) {
                if (this.f19836a.get(i).a(fVar, fVar2)) {
                    return true;
                }
            }
            return false;
        }

        public void e(org.jsoup.select.b bVar) {
            this.f19836a.add(bVar);
            d();
        }

        public String toString() {
            return String.format(":or%s", this.f19836a);
        }

        public b(org.jsoup.select.b... bVarArr) {
            this(Arrays.asList(bVarArr));
        }

        public b() {
        }
    }
}
