package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class dn {
    protected Context Code;
    private dn I;
    private a V;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo);

        void V(com.huawei.openalliance.ad.inter.data.AppInfo appInfo);
    }

    public dn(Context context) {
        this.Code = context;
    }

    public Context Code() {
        return this.Code;
    }

    public abstract void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData, long j);

    public void V(com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
        a aVar = this.V;
        if (aVar != null) {
            aVar.V(appInfo);
        }
    }

    public void Code(a aVar) {
        this.V = aVar;
    }

    public void V(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData, long j) {
        dn dnVar = this.I;
        if (dnVar == null) {
            V(appInfo);
        } else {
            dnVar.Code(this.V);
            this.I.Code(appInfo, adContentData, j);
        }
    }

    public void Code(dn dnVar) {
        this.I = dnVar;
    }

    public void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
        a aVar = this.V;
        if (aVar != null) {
            aVar.Code(appInfo);
        }
    }
}
