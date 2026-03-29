package com.qiniu.android.dns;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IResolver {
    public static final int DNS_DEFAULT_TIMEOUT = 10;

    Record[] resolve(Domain domain, NetworkInfo networkInfo) throws IOException;
}
