package com.opos.mobad.service.g;

import com.opos.cmn.i.o;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9243a;
    private StringBuilder b = new StringBuilder();

    public b(String str) {
        this.f9243a = str;
    }

    public b a() {
        this.b.append(this.f9243a);
        return this;
    }

    public String toString() {
        return this.b.toString();
    }

    public b a(float f) {
        if (this.b.length() > 0) {
            this.b.append(this.f9243a);
        }
        this.b.append(f);
        return this;
    }

    public b a(int i) {
        if (this.b.length() > 0) {
            this.b.append(this.f9243a);
        }
        this.b.append(i);
        return this;
    }

    public b a(b bVar) {
        if (this.b.length() > 0) {
            this.b.append(this.f9243a);
        }
        this.b.append((CharSequence) bVar.b);
        return this;
    }

    public b a(String str) {
        if (this.b.length() > 0) {
            this.b.append(this.f9243a);
        }
        this.b.append(o.a(str));
        return this;
    }
}
