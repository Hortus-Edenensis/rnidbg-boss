package com.google.android.exoplayer2;

import android.os.Bundle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface f {

    /* JADX INFO: compiled from: SearchBox */
    public interface a<T extends f> {
        T fromBundle(Bundle bundle);
    }

    Bundle toBundle();
}
