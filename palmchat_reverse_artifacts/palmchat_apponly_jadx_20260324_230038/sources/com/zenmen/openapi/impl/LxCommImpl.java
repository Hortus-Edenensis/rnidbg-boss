package com.zenmen.openapi.impl;

import android.os.RemoteException;
import com.zenmen.openapi.c;
import com.zenmen.openapi.config.LxApiProxy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LxCommImpl extends c.a {
    @Override // com.zenmen.openapi.c
    public String getConfig(String str) throws RemoteException {
        return LxApiProxy.getInstance().getConfigString(str);
    }
}
