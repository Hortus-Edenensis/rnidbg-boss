package com.zenmen.openapi.impl;

import android.os.RemoteException;
import com.zenmen.openapi.b;
import defpackage.ac1;
import defpackage.eh;
import defpackage.hx3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class DeviceManagerImpl extends b.a {
    @Override // com.zenmen.openapi.b
    public String getAndroidId() throws RemoteException {
        return ac1.p;
    }

    @Override // com.zenmen.openapi.b
    public String getChanId() throws RemoteException {
        return ac1.m;
    }

    @Override // com.zenmen.openapi.b
    public String getDeviceId() throws RemoteException {
        return ac1.h;
    }

    @Override // com.zenmen.openapi.b
    public String getImei() throws RemoteException {
        return ac1.i;
    }

    @Override // com.zenmen.openapi.b
    public String getLanguage() throws RemoteException {
        return eh.a();
    }

    @Override // com.zenmen.openapi.b
    public String getMac() throws RemoteException {
        return ac1.k;
    }

    @Override // com.zenmen.openapi.b
    public String getNetModel() throws RemoteException {
        return hx3.h();
    }

    @Override // com.zenmen.openapi.b
    public String getVersionCode() throws RemoteException {
        return ac1.f;
    }

    @Override // com.zenmen.openapi.b
    public String getVersionName() throws RemoteException {
        return ac1.g;
    }
}
