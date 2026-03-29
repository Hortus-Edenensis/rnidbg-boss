package defpackage;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface w9 {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        v9 getAllocation();

        @Nullable
        a next();
    }

    void a(v9 v9Var);

    v9 allocate();

    void b(a aVar);

    int getIndividualAllocationLength();

    void trim();
}
