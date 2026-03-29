package com.efs.sdk.base.core.cache;

import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface IFileFilter {
    boolean filter(File file);

    void finish();

    void finish(boolean z, boolean z2);

    boolean hasTask();
}
