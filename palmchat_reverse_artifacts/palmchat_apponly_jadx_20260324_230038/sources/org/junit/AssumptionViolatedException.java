package org.junit;

import defpackage.od3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class AssumptionViolatedException extends org.junit.internal.AssumptionViolatedException {
    private static final long serialVersionUID = 1;

    public <T> AssumptionViolatedException(T t, od3<T> od3Var) {
        super((Object) t, (od3<?>) od3Var);
    }

    public <T> AssumptionViolatedException(String str, T t, od3<T> od3Var) {
        super(str, t, od3Var);
    }

    public AssumptionViolatedException(String str) {
        super(str);
    }

    public AssumptionViolatedException(String str, Throwable th) {
        super(str, th);
    }
}
