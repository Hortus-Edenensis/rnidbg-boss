package com.qq.gdt.action.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.qq.gdt.action.j.o;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadPoolExecutor f10458a = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());
    boolean b = false;
    private final LinkedBlockingQueue<IBinder> c = new LinkedBlockingQueue<>(1);

    public IBinder a() throws InterruptedException {
        if (this.b) {
            throw new IllegalStateException();
        }
        this.b = true;
        return this.c.take();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        o.a("onServiceConnected", new Object[0]);
        f10458a.execute(new Runnable() { // from class: com.qq.gdt.action.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    o.a("onServiceConnected " + System.currentTimeMillis(), new Object[0]);
                    b.this.c.offer(iBinder);
                } catch (Throwable th) {
                    o.a("onServiceConnected  " + th.getClass().getSimpleName(), new Object[0]);
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        o.a("onServiceDisconnected " + System.currentTimeMillis(), new Object[0]);
    }
}
