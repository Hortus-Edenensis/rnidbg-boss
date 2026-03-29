package com.hihonor.push.sdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class a1 {
    public boolean b;
    public Object c;
    public Exception d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f6439a = new Object();
    public List<j0<Object>> e = new ArrayList();

    public final void a() {
        synchronized (this.f6439a) {
            Iterator<j0<Object>> it = this.e.iterator();
            while (it.hasNext()) {
                try {
                    it.next().a(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.e = null;
        }
    }

    public final Exception b() {
        Exception exc;
        synchronized (this.f6439a) {
            exc = this.d;
        }
        return exc;
    }

    public final Object c() {
        Object obj;
        synchronized (this.f6439a) {
            if (this.d != null) {
                throw new RuntimeException(this.d);
            }
            obj = this.c;
        }
        return obj;
    }

    public final boolean d() {
        synchronized (this.f6439a) {
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean e() {
        boolean z;
        synchronized (this.f6439a) {
            if (this.b) {
                d();
                z = this.d == null;
            }
        }
        return z;
    }

    public final a1 a(j0 j0Var) {
        synchronized (this.f6439a) {
            if (!this.b) {
                this.e.add(j0Var);
            } else {
                j0Var.a(this);
            }
        }
        return this;
    }
}
