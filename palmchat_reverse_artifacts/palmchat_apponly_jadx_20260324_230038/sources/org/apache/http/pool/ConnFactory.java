package org.apache.http.pool;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public interface ConnFactory<T, C> {
    C create(T t) throws IOException;
}
