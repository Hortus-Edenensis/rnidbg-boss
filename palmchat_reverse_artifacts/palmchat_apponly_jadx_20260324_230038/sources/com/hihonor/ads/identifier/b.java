package com.hihonor.ads.identifier;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b implements ServiceConnection {
    public static final ThreadPoolExecutor c = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6432a = false;
    public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        Log.d("OaidSerivceConnection", "onServiceConnected");
        c.execute(new Runnable() { // from class: com.hihonor.ads.identifier.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f6433a.a(iBinder);
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.d("OaidSerivceConnection", "onServiceDisconnected " + System.currentTimeMillis());
    }

    public IBinder a() {
        if (this.f6432a) {
            throw new IllegalStateException();
        }
        this.f6432a = true;
        return this.b.take();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(IBinder iBinder) {
        try {
            Log.d("OaidSerivceConnection", "onServiceConnected " + System.currentTimeMillis());
            this.b.offer(iBinder);
        } catch (Throwable th) {
            Log.e("OaidSerivceConnection", "onServiceConnected  " + th.getMessage());
        }
    }
}
