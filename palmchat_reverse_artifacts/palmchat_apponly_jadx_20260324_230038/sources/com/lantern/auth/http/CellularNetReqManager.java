package com.lantern.auth.http;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import com.lantern.auth.app.WkSDKManager;
import com.lantern.auth.core.BLLog;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class CellularNetReqManager {
    private static CellularNetReqManager mInstance;
    private ConnectivityManager mConnectivityManager = (ConnectivityManager) WkSDKManager.getContext().getSystemService("connectivity");

    private CellularNetReqManager() {
    }

    public static synchronized CellularNetReqManager getInstance() {
        if (mInstance == null) {
            mInstance = new CellularNetReqManager();
        }
        return mInstance;
    }

    public CellularNetwork requestCelluarNetwork() throws IOException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final CellularNetwork cellularNetwork = new CellularNetwork();
        this.mConnectivityManager.requestNetwork((NetworkRequest) null, new ConnectivityManager.NetworkCallback() { // from class: com.lantern.auth.http.CellularNetReqManager.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                BLLog.d("current thread " + Thread.currentThread().getName(), new Object[0]);
                CellularNetwork cellularNetwork2 = cellularNetwork;
                cellularNetwork2.mNetwork = network;
                cellularNetwork2.mNetworkCallback = this;
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await(3000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            BLLog.e(e);
        }
        return cellularNetwork;
    }

    public void unRegisterCallback(ConnectivityManager.NetworkCallback networkCallback) {
        this.mConnectivityManager.unregisterNetworkCallback(networkCallback);
    }
}
