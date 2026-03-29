package com.tide.protocol.context.base;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import com.tide.protocol.context.ITideService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ProxyBaseService extends Service implements TideHostServiceDelegator {
    protected ITideService mTideService;

    @Override // com.tide.protocol.context.base.TideHostServiceDelegator
    public void callSuperOnConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.tide.protocol.context.base.TideHostServiceDelegator
    public void callSuperOnCreate() {
        super.onCreate();
    }

    @Override // com.tide.protocol.context.base.TideHostServiceDelegator
    public void callSuperOnDestroy() {
        super.onDestroy();
    }

    @Override // com.tide.protocol.context.base.TideHostServiceDelegator
    public void callSuperOnLowMemory() {
        super.onLowMemory();
    }

    @Override // com.tide.protocol.context.base.TideHostServiceDelegator
    public void callSuperOnRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Override // com.tide.protocol.context.base.TideHostServiceDelegator
    public void callSuperOnStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    @Override // com.tide.protocol.context.base.TideHostServiceDelegator
    public int callSuperOnStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    @Override // com.tide.protocol.context.base.TideHostServiceDelegator
    public void callSuperOnTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
    }

    @Override // com.tide.protocol.context.base.TideHostServiceDelegator
    public void callSuperOnTrimMemory(int i) {
        super.onTrimMemory(i);
    }

    @Override // com.tide.protocol.context.base.TideHostServiceDelegator
    public boolean callSuperOnUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        ITideService iTideService = this.mTideService;
        if (iTideService != null) {
            return iTideService.onBind(intent);
        }
        return null;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        ITideService iTideService = this.mTideService;
        if (iTideService != null) {
            iTideService.onConfigurationChanged(configuration);
        } else {
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        ITideService iTideService = this.mTideService;
        if (iTideService != null) {
            iTideService.onCreate();
        } else {
            super.onCreate();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        ITideService iTideService = this.mTideService;
        if (iTideService != null) {
            iTideService.onDestroy();
        } else {
            super.onDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        ITideService iTideService = this.mTideService;
        if (iTideService != null) {
            iTideService.onLowMemory();
        } else {
            super.onLowMemory();
        }
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        ITideService iTideService = this.mTideService;
        if (iTideService != null) {
            iTideService.onRebind(intent);
        } else {
            super.onRebind(intent);
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        ITideService iTideService = this.mTideService;
        if (iTideService != null) {
            iTideService.onStart(intent, i);
        } else {
            super.onStart(intent, i);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        ITideService iTideService = this.mTideService;
        return iTideService != null ? iTideService.onStartCommand(intent, i, i2) : super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        ITideService iTideService = this.mTideService;
        if (iTideService != null) {
            iTideService.onTaskRemoved(intent);
        } else {
            super.onTaskRemoved(intent);
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        ITideService iTideService = this.mTideService;
        if (iTideService != null) {
            iTideService.onTrimMemory(i);
        } else {
            super.onTrimMemory(i);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        ITideService iTideService = this.mTideService;
        return iTideService != null ? iTideService.onUnbind(intent) : super.onUnbind(intent);
    }
}
