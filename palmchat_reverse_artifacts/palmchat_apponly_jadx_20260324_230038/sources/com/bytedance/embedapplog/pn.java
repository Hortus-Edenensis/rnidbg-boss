package com.bytedance.embedapplog;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface pn {

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {
        public final long fx;
        public final boolean nr;

        @Nullable
        public final String u;

        public u(@Nullable String str, boolean z, long j) {
            this.u = str;
            this.nr = z;
            this.fx = j;
        }
    }

    @AnyThread
    void u(@NonNull u uVar);
}
