package com.bytedance.pangle.x;

import android.os.RemoteException;
import com.bytedance.pangle.ZeusPluginInstallListener;
import com.bytedance.pangle.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends b.u {
    private final ZeusPluginInstallListener u;

    public nr(ZeusPluginInstallListener zeusPluginInstallListener) {
        this.u = zeusPluginInstallListener;
    }

    @Override // com.bytedance.pangle.b
    public void u(String str, int i, String str2) throws RemoteException {
        ZeusPluginInstallListener zeusPluginInstallListener = this.u;
        if (zeusPluginInstallListener != null) {
            zeusPluginInstallListener.onPluginInstall(str, i, str2);
        }
    }
}
