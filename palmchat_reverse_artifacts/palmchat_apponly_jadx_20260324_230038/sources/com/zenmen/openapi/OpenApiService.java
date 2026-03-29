package com.zenmen.openapi;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.zenmen.openapi.e;
import com.zenmen.openapi.impl.AccountManagerImpl;
import com.zenmen.openapi.impl.DeviceManagerImpl;
import com.zenmen.openapi.impl.LxCommImpl;
import com.zenmen.openapi.impl.MDAManagerImpl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class OpenApiService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f12012a = new b();

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.zenmen.openapi.a f12013a;
        public com.zenmen.openapi.b b;
        public d c;
        public c d;

        public b() {
            this.f12013a = new AccountManagerImpl();
            this.b = new DeviceManagerImpl();
            this.c = new MDAManagerImpl();
            this.d = new LxCommImpl();
        }

        @Override // com.zenmen.openapi.e
        public d H() throws RemoteException {
            return this.c;
        }

        @Override // com.zenmen.openapi.e
        public com.zenmen.openapi.b m() throws RemoteException {
            return this.b;
        }

        @Override // com.zenmen.openapi.e
        public c v() throws RemoteException {
            return this.d;
        }

        @Override // com.zenmen.openapi.e
        public com.zenmen.openapi.a z() throws RemoteException {
            return this.f12013a;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f12012a;
    }
}
