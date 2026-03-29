package com.oplus.tblplayer.cache.service;

import android.os.IBinder;
import android.os.IInterface;
import com.oplus.tblplayer.cache.ICacheListener;
import com.oplus.tblplayer.misc.MediaUrl;
import com.oplus.tblplayer.remote.BaseBinderStub;
import com.oplus.tblplayer.utils.ArgsUtil;
import com.oplus.tblplayer.utils.LogUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class RemoteCacheListener extends BaseBinderStub implements IInterface, ICacheListener {
    public static final String DESCRIPTOR = "RemoteCacheListener";
    public static final int M_ON_CACHE_CANCEL = 3;
    public static final int M_ON_CACHE_ERROR = 4;
    public static final int M_ON_CACHE_FINISH = 2;
    public static final int M_ON_CACHE_START = 1;
    private static final String TAG = "RemoteCacheListener";
    private List<ICacheListener> mListener;

    public RemoteCacheListener() {
        attachInterface(this, DESCRIPTOR);
    }

    public Object execTransact(int i, Object... objArr) throws IOException {
        if (i == 1) {
            onCacheStart((MediaUrl) ArgsUtil.safeGet(objArr, 0));
            return null;
        }
        if (i == 2) {
            onCacheFinish((MediaUrl) ArgsUtil.safeGet(objArr, 0), ((Long) ArgsUtil.safeGet(objArr, 1)).longValue(), ((Long) ArgsUtil.safeGet(objArr, 2)).longValue(), ((Long) ArgsUtil.safeGet(objArr, 3)).longValue(), ((Long) ArgsUtil.safeGet(objArr, 4)).longValue());
            return null;
        }
        if (i == 3) {
            onCacheCancel((MediaUrl) ArgsUtil.safeGet(objArr, 0));
            return null;
        }
        if (i == 4) {
            onCacheError((MediaUrl) ArgsUtil.safeGet(objArr, 0), ((Integer) ArgsUtil.safeGet(objArr, 1)).intValue(), (String) ArgsUtil.safeGet(objArr, 2));
            return null;
        }
        LogUtil.d(TAG, "call get unknown method index:%d" + i);
        return super.onTransactInternal(i, objArr);
    }

    public String getDescriptor() {
        return DESCRIPTOR;
    }

    public boolean isEmpty() {
        List<ICacheListener> list = this.mListener;
        return list != null && list.isEmpty();
    }

    @Override // com.oplus.tblplayer.cache.ICacheListener
    public void onCacheCancel(MediaUrl mediaUrl) {
        List<ICacheListener> list = this.mListener;
        if (list != null) {
            Iterator<ICacheListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onCacheCancel(mediaUrl);
            }
        }
    }

    @Override // com.oplus.tblplayer.cache.ICacheListener
    public void onCacheError(MediaUrl mediaUrl, int i, String str) {
        List<ICacheListener> list = this.mListener;
        if (list != null) {
            Iterator<ICacheListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onCacheError(mediaUrl, i, str);
            }
        }
    }

    @Override // com.oplus.tblplayer.cache.ICacheListener
    public void onCacheFinish(MediaUrl mediaUrl, long j, long j2, long j3, long j4) {
        List<ICacheListener> list = this.mListener;
        if (list != null) {
            Iterator<ICacheListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onCacheFinish(mediaUrl, j, j2, j3, j4);
            }
        }
    }

    @Override // com.oplus.tblplayer.cache.ICacheListener
    public void onCacheStart(MediaUrl mediaUrl) {
        List<ICacheListener> list = this.mListener;
        if (list != null) {
            Iterator<ICacheListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onCacheStart(mediaUrl);
            }
        }
    }

    @Override // com.oplus.tblplayer.remote.BaseBinderStub
    public Object onTransactInternal(int i, Object... objArr) throws IOException {
        return execTransact(i, objArr);
    }

    public boolean registerCacheListener(ICacheListener iCacheListener) {
        if (this.mListener == null) {
            this.mListener = new ArrayList();
        }
        if (this.mListener.contains(iCacheListener)) {
            return false;
        }
        return this.mListener.add(iCacheListener);
    }

    public boolean unregisterCacheListener(ICacheListener iCacheListener) {
        if (isEmpty()) {
            return false;
        }
        return this.mListener.remove(iCacheListener);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
