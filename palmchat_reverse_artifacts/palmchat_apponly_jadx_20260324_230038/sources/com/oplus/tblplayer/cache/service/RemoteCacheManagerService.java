package com.oplus.tblplayer.cache.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.oplus.tblplayer.config.Globals;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class RemoteCacheManagerService extends Service {
    protected static final String DESCRIPTOR = "RemoteCacheManagerService";
    protected static final int M_ADD_LISTENER = 4;
    protected static final int M_LISTENER_FLAG = 5;
    protected static final int M_START_CACHE = 1;
    protected static final int M_STOP_ALL = 3;
    protected static final int M_STOP_CACHE = 2;
    private Context mAppContext;
    private IBinder mBinder;

    public IBinder createService() {
        return new CacheManagerStub(this.mAppContext);
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Context applicationContext = getApplicationContext();
        this.mAppContext = applicationContext;
        Globals.maybeInitialize(applicationContext, null);
        this.mBinder = createService();
    }
}
