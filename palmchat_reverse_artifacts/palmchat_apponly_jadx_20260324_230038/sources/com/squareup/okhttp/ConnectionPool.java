package com.squareup.okhttp;

import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ConnectionPool {
    private static final long DEFAULT_KEEP_ALIVE_DURATION_MS = 300000;
    private static final int MAX_CONNECTIONS_TO_CLEANUP = 2;
    private static final ConnectionPool systemDefault;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;
    private final LinkedList<Connection> connections = new LinkedList<>();
    private final ExecutorService executorService = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.daemonThreadFactory("OkHttp ConnectionPool"));
    private final Callable<Void> connectionsCleanupCallable = new Callable<Void>() { // from class: com.squareup.okhttp.ConnectionPool.1
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            ArrayList arrayList = new ArrayList(2);
            synchronized (ConnectionPool.this) {
                ListIterator listIterator = ConnectionPool.this.connections.listIterator(ConnectionPool.this.connections.size());
                int i = 0;
                while (listIterator.hasPrevious()) {
                    Connection connection = (Connection) listIterator.previous();
                    if (!connection.isAlive() || connection.isExpired(ConnectionPool.this.keepAliveDurationNs)) {
                        listIterator.remove();
                        arrayList.add(connection);
                        if (arrayList.size() == 2) {
                            break;
                        }
                    } else if (connection.isIdle()) {
                        i++;
                    }
                }
                ListIterator listIterator2 = ConnectionPool.this.connections.listIterator(ConnectionPool.this.connections.size());
                while (listIterator2.hasPrevious() && i > ConnectionPool.this.maxIdleConnections) {
                    Connection connection2 = (Connection) listIterator2.previous();
                    if (connection2.isIdle()) {
                        arrayList.add(connection2);
                        listIterator2.remove();
                        i--;
                    }
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Util.closeQuietly((Connection) it.next());
            }
            return null;
        }
    };

    static {
        String property = System.getProperty("http.keepAlive");
        String property2 = System.getProperty("http.keepAliveDuration");
        String property3 = System.getProperty("http.maxConnections");
        long j = property2 != null ? Long.parseLong(property2) : 300000L;
        if (property != null && !Boolean.parseBoolean(property)) {
            systemDefault = new ConnectionPool(0, j);
        } else if (property3 != null) {
            systemDefault = new ConnectionPool(Integer.parseInt(property3), j);
        } else {
            systemDefault = new ConnectionPool(5, j);
        }
    }

    public ConnectionPool(int i, long j) {
        this.maxIdleConnections = i;
        this.keepAliveDurationNs = j * 1000 * 1000;
    }

    public static ConnectionPool getDefault() {
        return systemDefault;
    }

    private void waitForCleanupCallableToRun() {
        try {
            this.executorService.submit(new Runnable() { // from class: com.squareup.okhttp.ConnectionPool.2
                @Override // java.lang.Runnable
                public void run() {
                }
            }).get();
        } catch (Exception unused) {
            throw new AssertionError();
        }
    }

    public void evictAll() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.connections);
            this.connections.clear();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Util.closeQuietly((Connection) it.next());
        }
    }

    public synchronized Connection get(Address address) {
        Connection connectionPrevious;
        LinkedList<Connection> linkedList = this.connections;
        ListIterator<Connection> listIterator = linkedList.listIterator(linkedList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                connectionPrevious = null;
                break;
            }
            connectionPrevious = listIterator.previous();
            if (connectionPrevious.getRoute().getAddress().equals(address) && connectionPrevious.isAlive() && System.nanoTime() - connectionPrevious.getIdleStartTimeNs() < this.keepAliveDurationNs) {
                listIterator.remove();
                if (connectionPrevious.isSpdy()) {
                    break;
                }
                try {
                    Platform.get().tagSocket(connectionPrevious.getSocket());
                    break;
                } catch (SocketException e) {
                    Util.closeQuietly(connectionPrevious);
                    Platform.get().logW("Unable to tagSocket(): " + e);
                }
            }
        }
        if (connectionPrevious != null && connectionPrevious.isSpdy()) {
            this.connections.addFirst(connectionPrevious);
        }
        this.executorService.submit(this.connectionsCleanupCallable);
        return connectionPrevious;
    }

    public synchronized int getConnectionCount() {
        return this.connections.size();
    }

    public List<Connection> getConnections() {
        ArrayList arrayList;
        waitForCleanupCallableToRun();
        synchronized (this) {
            arrayList = new ArrayList(this.connections);
        }
        return arrayList;
    }

    public synchronized int getHttpConnectionCount() {
        int i;
        Iterator<Connection> it = this.connections.iterator();
        i = 0;
        while (it.hasNext()) {
            if (!it.next().isSpdy()) {
                i++;
            }
        }
        return i;
    }

    public synchronized int getSpdyConnectionCount() {
        int i;
        Iterator<Connection> it = this.connections.iterator();
        i = 0;
        while (it.hasNext()) {
            if (it.next().isSpdy()) {
                i++;
            }
        }
        return i;
    }

    public void maybeShare(Connection connection) {
        this.executorService.submit(this.connectionsCleanupCallable);
        if (connection.isSpdy() && connection.isAlive()) {
            synchronized (this) {
                this.connections.addFirst(connection);
            }
        }
    }

    public void recycle(Connection connection) {
        if (connection.isSpdy()) {
            return;
        }
        if (!connection.isAlive()) {
            Util.closeQuietly(connection);
            return;
        }
        try {
            Platform.get().untagSocket(connection.getSocket());
            synchronized (this) {
                this.connections.addFirst(connection);
                connection.resetIdleStartTime();
            }
            this.executorService.submit(this.connectionsCleanupCallable);
        } catch (SocketException e) {
            Platform.get().logW("Unable to untagSocket(): " + e);
            Util.closeQuietly(connection);
        }
    }
}
