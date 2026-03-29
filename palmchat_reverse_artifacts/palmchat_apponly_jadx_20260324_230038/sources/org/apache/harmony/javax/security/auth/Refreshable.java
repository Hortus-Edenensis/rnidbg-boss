package org.apache.harmony.javax.security.auth;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public interface Refreshable {
    boolean isCurrent();

    void refresh() throws RefreshFailedException;
}
