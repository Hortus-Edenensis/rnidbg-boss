package com.squareup.okhttp;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.net.ssl.SSLHandshakeException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class RouteDatabase {
    private final Set<Route> failedRoutes = new LinkedHashSet();

    public synchronized void connected(Route route) {
        this.failedRoutes.remove(route);
    }

    public synchronized void failed(Route route, IOException iOException) {
        this.failedRoutes.add(route);
        if (!(iOException instanceof SSLHandshakeException)) {
            this.failedRoutes.add(route.flipTlsMode());
        }
    }

    public synchronized int failedRoutesCount() {
        return this.failedRoutes.size();
    }

    public synchronized boolean shouldPostpone(Route route) {
        return this.failedRoutes.contains(route);
    }
}
