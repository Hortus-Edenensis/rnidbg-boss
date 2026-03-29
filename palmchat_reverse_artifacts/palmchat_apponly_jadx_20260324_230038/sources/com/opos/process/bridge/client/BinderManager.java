package com.opos.process.bridge.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.opos.process.bridge.client.BaseServiceClient;
import com.opos.process.bridge.provider.BridgeExecuteException;
import com.opos.process.bridge.provider.ProcessBridgeLog;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class BinderManager {
    private static final String TAG = "BinderManager";
    private static final BinderManager ourInstance = new BinderManager();
    private final Map<String, IBinderInfo> cachedIBinders = new ConcurrentHashMap();

    /* JADX INFO: compiled from: SearchBox */
    public static class IBinderInfo {
        ServiceConnection connection;
        IBinder iBinder;
        List<BaseServiceClient.ServiceListener> listeners = new CopyOnWriteArrayList();

        public IBinderInfo(IBinder iBinder, ServiceConnection serviceConnection) {
            this.iBinder = iBinder;
            this.connection = serviceConnection;
        }

        public boolean hasListener() {
            return this.listeners.size() > 0;
        }

        public void notifyListenerServiceConnected(ComponentName componentName) {
            for (BaseServiceClient.ServiceListener serviceListener : this.listeners) {
                if (serviceListener != null) {
                    serviceListener.onServiceConnected(componentName);
                }
            }
        }

        public void notifyListenerServiceDisconnected(ComponentName componentName) {
            for (BaseServiceClient.ServiceListener serviceListener : this.listeners) {
                if (serviceListener != null) {
                    serviceListener.onServiceDisconnected(componentName);
                }
            }
        }

        public void registerListener(BaseServiceClient.ServiceListener serviceListener) {
            this.listeners.add(serviceListener);
        }

        public void unregisterListener(BaseServiceClient.ServiceListener serviceListener) {
            this.listeners.remove(serviceListener);
        }
    }

    private BinderManager() {
    }

    public static BinderManager getInstance() {
        return ourInstance;
    }

    public synchronized void freeBinder(Context context, Intent intent, BaseServiceClient.ServiceListener serviceListener) {
        ProcessBridgeLog.d(TAG, "freeBinder");
        String str = intent.getPackage() + "/" + intent.getAction();
        ProcessBridgeLog.v(TAG, "key:" + str);
        IBinderInfo iBinderInfo = this.cachedIBinders.get(str);
        if (iBinderInfo != null) {
            iBinderInfo.unregisterListener(serviceListener);
            if (!iBinderInfo.hasListener()) {
                if (this.cachedIBinders.containsValue(iBinderInfo)) {
                    this.cachedIBinders.remove(str);
                }
                context.unbindService(iBinderInfo.connection);
            }
        }
    }

    public void getBinderAsync(Context context, Intent intent, final BaseServiceClient.ServiceListener serviceListener) {
        ProcessBridgeLog.d(TAG, "getBinderAsync");
        final String str = intent.getPackage() + "/" + intent.getAction();
        ProcessBridgeLog.v(TAG, "key:" + str);
        if (!this.cachedIBinders.containsKey(str) || this.cachedIBinders.get(str) == null) {
            context.bindService(intent, new ServiceConnection() { // from class: com.opos.process.bridge.client.BinderManager.1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(final ComponentName componentName, IBinder iBinder) {
                    ProcessBridgeLog.v(BinderManager.TAG, "onServiceConnected");
                    try {
                        iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.opos.process.bridge.client.BinderManager.1.1
                            @Override // android.os.IBinder.DeathRecipient
                            public void binderDied() {
                                ProcessBridgeLog.v(BinderManager.TAG, "binderDied");
                                IBinderInfo iBinderInfo = (IBinderInfo) BinderManager.this.cachedIBinders.remove(str);
                                if (iBinderInfo != null) {
                                    iBinderInfo.notifyListenerServiceDisconnected(componentName);
                                }
                            }
                        }, 0);
                    } catch (RemoteException unused) {
                    }
                    IBinderInfo iBinderInfo = new IBinderInfo(iBinder, this);
                    iBinderInfo.registerListener(serviceListener);
                    if (BinderManager.this.cachedIBinders.put(str, iBinderInfo) != null) {
                        iBinderInfo.notifyListenerServiceConnected(componentName);
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    ProcessBridgeLog.v(BinderManager.TAG, "onServiceDisconnected");
                    IBinderInfo iBinderInfo = (IBinderInfo) BinderManager.this.cachedIBinders.remove(str);
                    if (iBinderInfo != null) {
                        iBinderInfo.notifyListenerServiceDisconnected(componentName);
                    }
                }
            }, 1);
        }
    }

    public synchronized IBinder getBinderSync(Context context, Intent intent, int i, final BaseServiceClient.ServiceListener serviceListener) throws BridgeExecuteException {
        IBinderInfo iBinderInfo;
        ProcessBridgeLog.d(TAG, "getBinderSync");
        final String str = intent.getPackage() + "/" + intent.getAction();
        ProcessBridgeLog.v(TAG, "key:" + str);
        iBinderInfo = this.cachedIBinders.get(str);
        if (iBinderInfo == null || iBinderInfo.iBinder == null) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            ProcessBridgeLog.v(TAG, "bindService");
            if (!context.bindService(intent, new ServiceConnection() { // from class: com.opos.process.bridge.client.BinderManager.2
                @Override // android.content.ServiceConnection
                public void onNullBinding(ComponentName componentName) {
                    ProcessBridgeLog.v(BinderManager.TAG, "onNullBinding:" + componentName);
                    countDownLatch.countDown();
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(final ComponentName componentName, IBinder iBinder) {
                    ProcessBridgeLog.v(BinderManager.TAG, "onServiceConnected");
                    try {
                        iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.opos.process.bridge.client.BinderManager.2.1
                            @Override // android.os.IBinder.DeathRecipient
                            public void binderDied() {
                                ProcessBridgeLog.v(BinderManager.TAG, "binderDied");
                                IBinderInfo iBinderInfo2 = (IBinderInfo) BinderManager.this.cachedIBinders.remove(str);
                                if (iBinderInfo2 != null) {
                                    iBinderInfo2.notifyListenerServiceDisconnected(componentName);
                                }
                            }
                        }, 0);
                    } catch (RemoteException unused) {
                    }
                    IBinderInfo iBinderInfo2 = new IBinderInfo(iBinder, this);
                    iBinderInfo2.registerListener(serviceListener);
                    if (BinderManager.this.cachedIBinders.put(str, iBinderInfo2) != null) {
                        iBinderInfo2.notifyListenerServiceConnected(componentName);
                    }
                    countDownLatch.countDown();
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    ProcessBridgeLog.v(BinderManager.TAG, "onServiceDisconnected");
                    IBinderInfo iBinderInfo2 = (IBinderInfo) BinderManager.this.cachedIBinders.remove(str);
                    if (iBinderInfo2 != null) {
                        iBinderInfo2.notifyListenerServiceDisconnected(componentName);
                    }
                }
            }, 1)) {
                ProcessBridgeLog.e(TAG, "bindService failed");
                throw new BridgeExecuteException("bindService failed", 101005);
            }
            try {
                ProcessBridgeLog.v(TAG, "wait to connect");
                boolean zAwait = countDownLatch.await(i, TimeUnit.MILLISECONDS);
                ProcessBridgeLog.v(TAG, "get iBinder from saved map");
                iBinderInfo = this.cachedIBinders.get(str);
                if (iBinderInfo == null && !zAwait) {
                    ProcessBridgeLog.e(TAG, "service refused");
                    throw new BridgeExecuteException("service refused", 101004);
                }
            } catch (InterruptedException e) {
                ProcessBridgeLog.e(TAG, "wait time out");
                throw new BridgeExecuteException(e, 101005);
            }
        } else {
            iBinderInfo.listeners.add(serviceListener);
        }
        return iBinderInfo != null ? iBinderInfo.iBinder : null;
    }
}
