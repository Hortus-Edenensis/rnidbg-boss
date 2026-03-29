package com.oplus.tblplayer.cache.service;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.oplus.tblplayer.cache.ICacheListener;
import com.oplus.tblplayer.cache.ICacheManager;
import com.oplus.tblplayer.cache.impl.DefaultCacheManagerImpl;
import com.oplus.tblplayer.misc.MediaUrl;
import com.oplus.tblplayer.remote.BaseBinderStub;
import com.oplus.tblplayer.utils.ArgsUtil;
import com.oplus.tblplayer.utils.LogUtil;
import com.oplus.tblplayer.utils.ParcelUtils;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class CacheManagerStub extends BaseBinderStub implements IInterface, ICacheManager {
    private static final String TAG = "CacheManagerStub";
    private ICacheManager mCacheManager;
    private boolean mHasListener;
    private ICacheListener mListenerDispatcher = new ICacheListener() { // from class: com.oplus.tblplayer.cache.service.CacheManagerStub.1
        @Override // com.oplus.tblplayer.cache.ICacheListener
        public void onCacheCancel(MediaUrl mediaUrl) {
            if (CacheManagerStub.this.checkListenerState()) {
                CacheManagerStub.this.invokeRemoteMethod(3, mediaUrl);
            }
        }

        @Override // com.oplus.tblplayer.cache.ICacheListener
        public void onCacheError(MediaUrl mediaUrl, int i, String str) {
            if (CacheManagerStub.this.checkListenerState()) {
                CacheManagerStub.this.invokeRemoteMethod(4, mediaUrl, Integer.valueOf(i), str);
            }
        }

        @Override // com.oplus.tblplayer.cache.ICacheListener
        public void onCacheFinish(MediaUrl mediaUrl, long j, long j2, long j3, long j4) {
            if (CacheManagerStub.this.checkListenerState()) {
                CacheManagerStub.this.invokeRemoteMethod(2, mediaUrl, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
            }
        }

        @Override // com.oplus.tblplayer.cache.ICacheListener
        public void onCacheStart(MediaUrl mediaUrl) {
            if (CacheManagerStub.this.checkListenerState()) {
                CacheManagerStub.this.invokeRemoteMethod(1, mediaUrl);
            }
        }
    };
    private IBinder mRemoteListener;

    public CacheManagerStub(Context context) {
        attachInterface(this, "RemoteCacheManagerService");
        DefaultCacheManagerImpl defaultCacheManagerImpl = new DefaultCacheManagerImpl(context);
        this.mCacheManager = defaultCacheManagerImpl;
        defaultCacheManagerImpl.registerCacheListener(this.mListenerDispatcher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkListenerState() {
        return this.mRemoteListener != null && this.mHasListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeRemoteMethod(int i, Object... objArr) {
        try {
            ParcelUtils.invokeRemoteMethod(this.mRemoteListener, RemoteCacheListener.DESCRIPTOR, i, objArr);
        } catch (RemoteException unused) {
            LogUtil.e(TAG, "invokeRemoteMethod error.");
        }
    }

    private void registerRemoteCacheListener(IBinder iBinder) {
        this.mRemoteListener = iBinder;
    }

    private void setHasListener(boolean z) {
        this.mHasListener = z;
    }

    public String getDescriptor() {
        return "RemoteCacheManagerService";
    }

    @Override // com.oplus.tblplayer.remote.BaseBinderStub
    public Object onTransactInternal(int i, Object... objArr) throws IOException {
        if (i == 1) {
            if (objArr == null || objArr.length < 1) {
                LogUtil.d(TAG, "binder call startCache ignore due to illegalArgument");
                return null;
            }
            Long l = (Long) ArgsUtil.safeGet(objArr, 1);
            Long l2 = (Long) ArgsUtil.safeGet(objArr, 2);
            Integer num = (Integer) ArgsUtil.safeGet(objArr, 3);
            if (l == null || l.longValue() < 0) {
                l = 0L;
            }
            if (l2 == null) {
                l2 = 1048576L;
            }
            startCache((MediaUrl) ArgsUtil.safeGet(objArr, 0), l.longValue(), l2.longValue(), num.intValue());
            return null;
        }
        if (i == 2) {
            stopCache((MediaUrl) ArgsUtil.safeGet(objArr, 0));
            return null;
        }
        if (i == 3) {
            stopAllCache();
            return null;
        }
        if (i == 4) {
            registerRemoteCacheListener((IBinder) ArgsUtil.safeGet(objArr, 0));
            setHasListener(((Boolean) ArgsUtil.safeGet(objArr, 1)).booleanValue());
            return null;
        }
        if (i == 5) {
            setHasListener(((Boolean) ArgsUtil.safeGet(objArr, 0)).booleanValue());
            return null;
        }
        LogUtil.d(TAG, "binder call get unknown method index:" + i);
        return super.onTransactInternal(i, objArr);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void registerCacheListener(ICacheListener iCacheListener) {
        this.mRemoteListener = (IBinder) iCacheListener;
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void startCache(MediaUrl mediaUrl, long j, long j2) {
        startCache(mediaUrl, j, j2, -1000);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void stopAllCache() {
        this.mCacheManager.stopAllCache();
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void stopCache(MediaUrl mediaUrl) {
        this.mCacheManager.stopCache(mediaUrl);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void unregisterCacheListener(ICacheListener iCacheListener) {
        this.mRemoteListener = null;
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void startCache(MediaUrl mediaUrl, long j, long j2, int i) {
        this.mCacheManager.startCache(mediaUrl, j, j2, i);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
