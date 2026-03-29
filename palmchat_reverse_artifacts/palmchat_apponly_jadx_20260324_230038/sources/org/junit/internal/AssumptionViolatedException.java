package org.junit.internal;

import defpackage.f55;
import defpackage.hl5;
import defpackage.od3;
import defpackage.ya1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class AssumptionViolatedException extends RuntimeException implements f55 {
    private static final long serialVersionUID = 2;
    private final String fAssumption;
    private final od3<?> fMatcher;
    private final Object fValue;
    private final boolean fValueMatcher;

    @Deprecated
    public AssumptionViolatedException(String str, boolean z, Object obj, od3<?> od3Var) {
        this.fAssumption = str;
        this.fValue = obj;
        this.fValueMatcher = z;
        if (obj instanceof Throwable) {
            initCause((Throwable) obj);
        }
    }

    @Override // defpackage.f55
    public void describeTo(ya1 ya1Var) {
        String str = this.fAssumption;
        if (str != null) {
            ya1Var.a(str);
        }
        if (this.fValueMatcher) {
            if (this.fAssumption != null) {
                ya1Var.a(": ");
            }
            ya1Var.a("got: ");
            ya1Var.b(this.fValue);
        }
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return hl5.k(this);
    }

    @Deprecated
    public AssumptionViolatedException(Object obj, od3<?> od3Var) {
        this(null, true, obj, od3Var);
    }

    @Deprecated
    public AssumptionViolatedException(String str, Object obj, od3<?> od3Var) {
        this(str, true, obj, od3Var);
    }

    @Deprecated
    public AssumptionViolatedException(String str) {
        this(str, false, null, null);
    }

    @Deprecated
    public AssumptionViolatedException(String str, Throwable th) {
        this(str, false, null, null);
        initCause(th);
    }
}
