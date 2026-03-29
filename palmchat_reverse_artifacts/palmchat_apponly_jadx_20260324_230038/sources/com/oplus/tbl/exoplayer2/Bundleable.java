package com.oplus.tbl.exoplayer2;

import android.os.Bundle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public interface Bundleable {

    /* JADX INFO: compiled from: SearchBox */
    @Deprecated
    public interface Creator<T extends Bundleable> {
        T fromBundle(Bundle bundle);
    }

    Bundle toBundle();
}
