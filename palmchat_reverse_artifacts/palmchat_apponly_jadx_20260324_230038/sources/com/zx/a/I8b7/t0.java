package com.zx.a.I8b7;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<j0> f16862a = new ArrayList();

    public void a(int i, String str, String str2, Throwable th) {
        for (j0 j0Var : this.f16862a) {
            try {
                if (j0Var.a(i, null)) {
                    j0Var.a(i, null, str2, th);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public void a(j0 j0Var) {
        this.f16862a.add(j0Var);
    }
}
