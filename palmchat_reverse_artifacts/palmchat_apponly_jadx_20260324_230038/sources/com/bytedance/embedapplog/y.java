package com.bytedance.embedapplog;

import android.os.Bundle;
import com.oplus.tbl.exoplayer2.audio.DefaultAudioSink;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class y extends wq {
    private static final long[] nr = {60000};
    private boolean b;
    private long fx;

    public y(xg xgVar) {
        super(xgVar);
        this.b = true;
    }

    @Override // com.bytedance.embedapplog.wq
    public String b() {
        return "s";
    }

    @Override // com.bytedance.embedapplog.wq
    public boolean fx() {
        Bundle bundleU;
        long jCurrentTimeMillis = System.currentTimeMillis();
        bc bcVarX = this.u.x();
        if (bcVarX != null && (bundleU = bcVarX.u(jCurrentTimeMillis, DefaultAudioSink.MIN_AUDIO_UNDERRUN_OFFSET_US)) != null) {
            u.u("play_session", bundleU, 1);
            u.nr();
        }
        zx zxVarFx = this.u.fx();
        yd ydVarPn = this.u.pn();
        if (ydVarPn.l() != 0) {
            JSONObject jSONObjectFx = gb.fx(ydVarPn.u());
            if (jSONObjectFx != null) {
                u(zxVarFx.u(jSONObjectFx));
                this.fx = System.currentTimeMillis();
                return true;
            }
            ti.nr((Throwable) null);
        }
        return false;
    }

    @Override // com.bytedance.embedapplog.wq
    public long[] nr() {
        return nr;
    }

    public void u(boolean z) {
        this.b = z;
    }

    @Override // com.bytedance.embedapplog.wq
    public long u() {
        long jKj = this.u.b().kj();
        if (jKj > 60000 || jKj <= 0) {
            jKj = 60000;
        }
        nr[0] = jKj;
        return this.fx + jKj;
    }

    private void u(ArrayList<ua> arrayList) {
        int iU;
        zx zxVarFx = this.u.fx();
        ArrayList<ua> arrayList2 = new ArrayList<>();
        ArrayList<ua> arrayList3 = new ArrayList<>();
        mh mhVarB = this.u.b();
        ArrayList arrayList4 = new ArrayList();
        if (!arrayList.isEmpty()) {
            arrayList4.addAll(arrayList);
        }
        ArrayList<ua> arrayListU = zxVarFx.u();
        if (!arrayListU.isEmpty()) {
            arrayList4.addAll(arrayListU);
        }
        if (arrayList4.size() > 0) {
            Iterator it = arrayList4.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ua uaVar = (ua) it.next();
                byte[] bArr = uaVar.l;
                if (bArr != null && bArr.length > 0) {
                    if (this.b) {
                        xg xgVar = this.u;
                        iU = rv.u(ge.u(xgVar, xgVar.nr(), this.u.pn().u()), uaVar.l, mhVarB);
                    } else {
                        iU = 200;
                    }
                    if (rv.u(iU)) {
                        if (arrayList.contains(uaVar)) {
                            uaVar.s = iU;
                            arrayList3.add(uaVar);
                        }
                    } else if (iU == 200) {
                        arrayList2.add(uaVar);
                    } else {
                        uaVar.s = iU;
                        arrayList3.add(uaVar);
                    }
                } else {
                    arrayList2.add(uaVar);
                }
            }
            if (arrayList2.size() > 0 || arrayList3.size() > 0) {
                zxVarFx.u(arrayList2, arrayList3, arrayList);
            }
            ti.b(b() + " " + arrayList2.size() + " " + arrayList4.size(), null);
        }
    }
}
