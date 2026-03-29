package com.zenmen.palmchat.privinfo;

import android.content.Context;
import android.content.pm.PackageInfo;
import defpackage.wm4;
import defpackage.wy3;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public enum PrivInfoManager {
    INSTANCE;

    private boolean isInit = false;
    private Context mContext;
    private wm4 mImpl;

    PrivInfoManager() {
    }

    public String getAndroidID() {
        return !this.isInit ? "none" : this.mImpl.h();
    }

    public synchronized String getBssid() {
        if (!this.isInit) {
            return "";
        }
        return this.mImpl.i();
    }

    public synchronized String getDefaultNetworkOperator() {
        if (!this.isInit) {
            return "";
        }
        return this.mImpl.j();
    }

    public synchronized String getIMEI() {
        if (!this.isInit) {
            return "";
        }
        return this.mImpl.k();
    }

    public synchronized String getIMSI() {
        if (!this.isInit) {
            return "";
        }
        return this.mImpl.l();
    }

    public ArrayList<String> getInstalledApplications() {
        return this.mImpl.m(this.mContext);
    }

    public String getMac() {
        return !this.isInit ? "" : this.mImpl.n();
    }

    public synchronized String getNetworkOperator() {
        if (!this.isInit) {
            return "";
        }
        return this.mImpl.o();
    }

    public synchronized String getNetworkOperatorName() {
        if (!this.isInit) {
            return "";
        }
        return this.mImpl.p();
    }

    public synchronized String getNetworkType() {
        if (!this.isInit) {
            return "";
        }
        return this.mImpl.q();
    }

    public synchronized String getProcessName(Context context) {
        return this.isInit ? this.mImpl.r(context) : wy3.a(context);
    }

    public synchronized String getRealNetworkType() {
        if (!this.isInit) {
            return "";
        }
        return this.mImpl.s();
    }

    public PackageInfo getSelfPackageInfo() {
        if (this.isInit) {
            return this.mImpl.t();
        }
        return null;
    }

    public synchronized String getSimNum() {
        if (!this.isInit) {
            return "";
        }
        return this.mImpl.u();
    }

    public int getSimState() {
        if (this.isInit) {
            return this.mImpl.v();
        }
        return 0;
    }

    public synchronized String getSsid() {
        if (!this.isInit) {
            return "";
        }
        return this.mImpl.w();
    }

    public void init(Context context) {
        synchronized (this) {
            if (this.isInit) {
                return;
            }
            Context applicationContext = context.getApplicationContext();
            this.mContext = applicationContext;
            this.mImpl = new wm4(applicationContext);
            this.isInit = true;
        }
    }

    public boolean isWifiEnabled() {
        return this.mImpl.B();
    }

    public void onNetStateChange() {
        this.mImpl.C();
    }

    public void unInit() {
        synchronized (this) {
            wm4 wm4Var = this.mImpl;
            if (wm4Var != null) {
                wm4Var.H();
            }
            this.isInit = false;
        }
    }
}
