package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class SqlDownloadCacheService extends Service {
    private static final String u = "SqlDownloadCacheService";

    public static void u(Context context, ServiceConnection serviceConnection) {
        if (context != null) {
            try {
                Intent intent = new Intent(context, (Class<?>) SqlDownloadCacheService.class);
                if (serviceConnection != null) {
                    context.bindService(intent, serviceConnection, 1);
                }
                context.startService(intent);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        jk jkVarKj = fx.kj();
        bq bqVarIz = jkVarKj instanceof com.ss.android.socialbase.downloader.impls.b ? ((com.ss.android.socialbase.downloader.impls.b) jkVarKj).iz() : jkVarKj instanceof bq ? (bq) jkVarKj : null;
        return bqVarIz instanceof IBinder ? (IBinder) bqVarIz : new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        fx.u(getApplicationContext());
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int iOnStartCommand = super.onStartCommand(intent, i, i2);
        if (fx.jk()) {
            return 2;
        }
        return iOnStartCommand;
    }
}
