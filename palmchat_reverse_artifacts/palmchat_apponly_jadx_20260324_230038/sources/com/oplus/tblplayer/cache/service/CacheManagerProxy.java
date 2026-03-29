package com.oplus.tblplayer.cache.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Pair;
import com.oplus.tblplayer.cache.ICacheListener;
import com.oplus.tblplayer.cache.ICacheManager;
import com.oplus.tblplayer.misc.MediaUrl;
import com.oplus.tblplayer.utils.LogUtil;
import com.oplus.tblplayer.utils.ParcelUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class CacheManagerProxy implements ServiceConnection, IBinder.DeathRecipient, ICacheManager {
    private static final String TAG = "CacheManagerProxy";
    private IBinder mBinder;
    private Context mContext;
    private Intent mIntent;
    private List<Pair<Integer, Object[]>> mPendingOps;
    private boolean mEnablePendingOps = true;
    private boolean mAutoReBind = true;
    private RemoteCacheListener mRemoteListener = new RemoteCacheListener();

    public CacheManagerProxy(Context context, Intent intent) {
        this.mContext = context.getApplicationContext();
        this.mIntent = intent;
        startBind();
    }

    private void addPendingOps(int i, Object[] objArr) {
        if (this.mPendingOps == null) {
            this.mPendingOps = new CopyOnWriteArrayList();
        }
        this.mPendingOps.add(new Pair<>(Integer.valueOf(i), objArr));
    }

    private boolean checkBinderState() {
        return this.mBinder != null;
    }

    private void executePendingOps() {
        boolean z;
        List<Pair<Integer, Object[]>> list = this.mPendingOps;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<Pair<Integer, Object[]>> it = this.mPendingOps.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Pair<Integer, Object[]> next = it.next();
            if (next == null) {
                LogUtil.d(TAG, "executePendingOps pending op is null.", new Exception());
                break;
            }
            try {
                invokeMethod(((Integer) next.first).intValue(), (Object[]) next.second);
                this.mPendingOps.remove(next);
            } catch (RemoteException e) {
                onBinderDied();
                LogUtil.e(TAG, "executePendingOps error. method:" + next.first + ", param:" + next.second + ", error:" + e.getMessage());
                z = true;
            }
        }
        z = false;
        if (z) {
            this.mPendingOps.clear();
        }
    }

    private Object invokeMethod(int i, Object[] objArr) throws RemoteException {
        return ParcelUtils.invokeRemoteMethod(this.mBinder, "RemoteCacheManagerService", i, objArr);
    }

    private void invokeMethodAndRetryIfNeeded(int i, Object[] objArr) throws RemoteException {
        if (checkBinderState()) {
            invokeMethod(i, objArr);
            return;
        }
        if (this.mEnablePendingOps) {
            addPendingOps(i, objArr);
        }
        if (this.mAutoReBind) {
            startBind();
        }
    }

    private void onBindFailed() {
        this.mBinder = null;
    }

    private void onBinderDied() {
        this.mBinder = null;
    }

    private void onBound(IBinder iBinder) {
        String interfaceDescriptor;
        try {
            interfaceDescriptor = iBinder.getInterfaceDescriptor();
        } catch (RemoteException e) {
            binderDied();
            LogUtil.e(TAG, "getInterfaceDescriptor error:" + e.getMessage());
            interfaceDescriptor = null;
        }
        if ("RemoteCacheManagerService".equals(interfaceDescriptor)) {
            try {
                iBinder.linkToDeath(this, 0);
            } catch (RemoteException e2) {
                onBinderDied();
                LogUtil.e(TAG, "linkToDeath error: " + e2.getMessage());
            }
            this.mBinder = iBinder;
            try {
                Object[] objArr = new Object[2];
                RemoteCacheListener remoteCacheListener = this.mRemoteListener;
                objArr[0] = remoteCacheListener;
                objArr[1] = Boolean.valueOf(remoteCacheListener.isEmpty() ? false : true);
                invokeMethod(4, objArr);
            } catch (RemoteException e3) {
                onBinderDied();
                LogUtil.e(TAG, "add listener error: " + e3.getMessage());
            }
            executePendingOps();
        }
    }

    private void startBind() {
        String str = TAG;
        LogUtil.d(str, "[CACHE] startBind");
        if (checkBinderState()) {
            LogUtil.d(str, "startBind ignore due to binder alive");
            return;
        }
        boolean zBindService = false;
        try {
            zBindService = this.mContext.bindService(this.mIntent, this, 1);
            LogUtil.d(str, "[CACHE] bindService RET : " + zBindService);
        } catch (Exception e) {
            LogUtil.e(TAG, "bindService failed: " + e.getMessage());
            this.mContext.unbindService(this);
            onBindFailed();
        }
        if (zBindService) {
            return;
        }
        try {
            this.mContext.unbindService(this);
        } catch (Exception unused) {
        }
        onBindFailed();
        LogUtil.e(TAG, "bindService return false");
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        onBinderDied();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        onBound(iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        onBinderDied();
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void registerCacheListener(ICacheListener iCacheListener) {
        if (!checkBinderState()) {
            this.mRemoteListener.registerCacheListener(iCacheListener);
            return;
        }
        try {
            if (this.mRemoteListener.registerCacheListener(iCacheListener)) {
                invokeMethodAndRetryIfNeeded(5, new Object[]{Boolean.TRUE});
            }
        } catch (RemoteException e) {
            LogUtil.e(TAG, "registerCacheListener error. error:" + e.getMessage());
        }
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void startCache(MediaUrl mediaUrl, long j, long j2) {
        startCache(mediaUrl, j, j2, -1000);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void stopAllCache() {
        try {
            invokeMethodAndRetryIfNeeded(3, null);
        } catch (RemoteException e) {
            LogUtil.e(TAG, "stopAllCache error. error: " + e.getMessage());
        }
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void stopCache(MediaUrl mediaUrl) {
        try {
            invokeMethodAndRetryIfNeeded(2, new Object[]{mediaUrl});
        } catch (RemoteException e) {
            LogUtil.e(TAG, "stopCache error. url: " + mediaUrl + " error: " + e.getMessage());
        }
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void unregisterCacheListener(ICacheListener iCacheListener) {
        if (!checkBinderState()) {
            this.mRemoteListener.unregisterCacheListener(iCacheListener);
            return;
        }
        try {
            if (this.mRemoteListener.unregisterCacheListener(iCacheListener)) {
                boolean z = true;
                Object[] objArr = new Object[1];
                if (this.mRemoteListener.isEmpty()) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                invokeMethodAndRetryIfNeeded(5, objArr);
            }
        } catch (RemoteException e) {
            LogUtil.e(TAG, "unregisterCacheListener error. error:" + e.getMessage());
        }
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void startCache(MediaUrl mediaUrl, long j, long j2, int i) {
        try {
            invokeMethodAndRetryIfNeeded(1, new Object[]{mediaUrl, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)});
        } catch (RemoteException e) {
            LogUtil.e(TAG, "startCache error. url: " + mediaUrl + " error:%s" + e.getMessage());
        }
    }
}
