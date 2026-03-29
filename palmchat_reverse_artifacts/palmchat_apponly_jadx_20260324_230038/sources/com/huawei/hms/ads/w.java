package com.huawei.hms.ads;

import android.content.Context;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class w {
    private Context I;
    private com.huawei.openalliance.ad.inter.data.l V;

    public w(Context context, com.huawei.openalliance.ad.inter.data.l lVar) {
        this.V = lVar;
        this.I = context;
    }

    public void Code() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar != null) {
            jk.Code(this.I, lVar.q());
        }
    }

    public void V(List<String> list) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar != null) {
            jk.Code(this.I, lVar.q(), 0, 0, list);
        }
    }

    public void Code(long j, int i) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar != null) {
            jk.Code(this.I, lVar.q(), j, i);
        }
    }

    public void Code(ji jiVar) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar != null) {
            jk.Code(this.I, lVar.q(), jiVar);
        }
    }

    public void Code(String str) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            fh.V("NativeEventProcessor", " native ad is empty");
        } else {
            jk.Code(this.I, lVar.q(), 0, 0, (String) null, str);
        }
    }

    public void Code(String str, String str2) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar != null) {
            jk.Code(this.I, lVar.q(), 0, 0, str, str2);
        }
    }

    public void Code(List<String> list) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar != null) {
            jk.Code(this.I, lVar.q(), 0, 0, list);
        }
    }
}
