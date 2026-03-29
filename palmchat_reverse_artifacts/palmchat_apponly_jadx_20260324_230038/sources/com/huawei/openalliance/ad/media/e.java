package com.huawei.openalliance.ad.media;

import android.content.Context;
import com.huawei.hms.ads.eh;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.media.listener.h;
import com.huawei.openalliance.ad.utils.ao;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class e {
    private static final String Code = "VideoPlayTimeProcessor";
    private long B;
    private long C;
    private boolean D;
    private boolean F;
    private int L;
    private long S;
    private long Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f6954a;
    private final Set<h> V = new CopyOnWriteArraySet();
    private final String I = x.dE + hashCode();

    public e(Context context) {
        this.f6954a = context;
    }

    private void I(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.B = jCurrentTimeMillis;
        this.S = jCurrentTimeMillis;
        this.L = i;
        this.C = this.Z;
    }

    public void Code() {
        if (fh.Code()) {
            fh.Code(Code, "notifyVideoTimeWithVideoStart: videoStartTime %s ", Long.valueOf(this.Z));
        }
        if (this.Z == 0) {
            this.Z = System.currentTimeMillis();
        } else {
            ao.Code(this.I);
        }
        if (this.B != 0) {
            this.B = 0L;
        }
        this.D = false;
    }

    public void V() {
        this.V.clear();
    }

    public void Code(int i) {
        if (fh.Code()) {
            fh.Code(Code, "notifyVideoTimeWithVideoStop");
        }
        Code(i);
        ao.Code(this.I);
        this.Z = 0L;
    }

    public void V(int i) {
        I(i);
        ao.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (fh.Code()) {
                    fh.Code(e.Code, "notifyVideoTimeWithVideoPause: videoStartTime %s , videoPauseTime %s", Long.valueOf(e.this.C), Long.valueOf(e.this.S));
                }
                if (e.this.F) {
                    return;
                }
                if (e.this.C == 0) {
                    e eVar = e.this;
                    eVar.V(eVar.Z);
                    return;
                }
                long j = e.this.S - e.this.C;
                e eVar2 = e.this;
                if (j > eVar2.L || j < 0) {
                    j = e.this.L;
                }
                eVar2.V(j);
                e.this.F = true;
            }
        }, this.I, eh.Code(this.f6954a).ao());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(long j) {
        fh.V(Code, "notifyVideoTime: videoTime: %s ", Long.valueOf(j));
        Iterator<h> it = this.V.iterator();
        while (it.hasNext()) {
            it.next().Code(j);
        }
    }

    public void Code(long j) {
        if (this.F || this.D) {
            this.F = false;
            this.D = true;
            return;
        }
        long j2 = this.Z;
        if (j2 != 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.Z;
            if (fh.Code()) {
                fh.Code(Code, "notifyVideoTimeWithVideoEnd: videoTime %s  ,playTime %s", Long.valueOf(jCurrentTimeMillis), Long.valueOf(j));
            }
            if (jCurrentTimeMillis <= j && jCurrentTimeMillis >= 0) {
                j = jCurrentTimeMillis;
            }
            V(j);
            this.Z = 0L;
        } else {
            V(j2);
        }
        if (this.B != 0) {
            this.B = 0L;
        }
        this.D = true;
    }

    public void V(h hVar) {
        if (hVar == null) {
            return;
        }
        this.V.remove(hVar);
    }

    public void Code(h hVar) {
        if (hVar == null) {
            return;
        }
        this.V.add(hVar);
    }
}
