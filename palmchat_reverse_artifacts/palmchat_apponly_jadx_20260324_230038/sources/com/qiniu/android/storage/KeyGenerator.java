package com.qiniu.android.storage;

import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface KeyGenerator {
    @Deprecated
    String gen(String str, File file);

    String gen(String str, String str2);
}
