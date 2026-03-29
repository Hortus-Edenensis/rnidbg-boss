package com.zenmen.openapi.impl;

import android.os.RemoteException;
import com.zenmen.openapi.a;
import com.zenmen.palmchat.c;
import defpackage.v4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AccountManagerImpl extends a.AbstractBinderC0938a {
    @Override // com.zenmen.openapi.a
    public String getProfile() throws RemoteException {
        return v4.d();
    }

    @Override // com.zenmen.openapi.a
    public String getSid() throws RemoteException {
        return v4.c(c.b());
    }

    @Override // com.zenmen.openapi.a
    public String getToken() throws RemoteException {
        return v4.d();
    }

    @Override // com.zenmen.openapi.a
    public String getUid() throws RemoteException {
        return v4.e(c.b());
    }
}
