package com.oplus.tblplayer.remote;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.oplus.tblplayer.IRemoteLinker;
import com.oplus.tblplayer.config.Globals;
import com.oplus.tblplayer.utils.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class TBLRemotePlayerService extends Service {
    private static final String TAG = "TBLRemoteService";
    private Context mAppContext;
    private IBinder mBinder;

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        LogUtil.d(TAG, "onBind");
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Context applicationContext = getApplicationContext();
        this.mAppContext = applicationContext;
        Globals.maybeInitialize(applicationContext, null);
        this.mBinder = new IRemoteLinker.Stub() { // from class: com.oplus.tblplayer.remote.TBLRemotePlayerService.1
            @Override // com.oplus.tblplayer.IRemoteLinker
            public IBinder create() throws RemoteException {
                return new RemotePlayerStub(TBLRemotePlayerService.this.mAppContext);
            }
        };
    }

    @Override // android.app.Service
    public void onDestroy() {
        LogUtil.d(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        LogUtil.d(TAG, "onUnbind");
        return super.onUnbind(intent);
    }
}
