package androidx.work.impl.constraints;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public interface ConstraintListener<T> {
    void onConstraintChanged(@Nullable T t);
}
