package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.he;
import com.iab.omid.library.huawei.adsession.AdEvents;
import com.iab.omid.library.huawei.adsession.AdSession;
import com.iab.omid.library.huawei.adsession.media.InteractionType;
import com.iab.omid.library.huawei.adsession.media.MediaEvents;
import com.iab.omid.library.huawei.adsession.media.PlayerState;
import com.iab.omid.library.huawei.adsession.media.VastProperties;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ha extends gz implements gx {
    public static final int Code = 200;
    private static boolean I = false;
    private static final String V = "VideoEventAgent";
    private he C;
    private final List<MediaEvents> Z = new ArrayList();
    private final List<AdEvents> B = new ArrayList();
    private boolean S = false;
    private int F = 0;
    private float D = 0.0f;
    private boolean L = false;

    static {
        I = hc.Code("com.iab.omid.library.huawei.adsession.media.MediaEvents") && hc.Code(hc.e);
    }

    public static boolean C() {
        return I;
    }

    private String D() {
        return V + hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        if (fh.Code()) {
            fh.Code(D(), "volumeChangeInner %s", Boolean.valueOf(this.S));
        }
        V(this.S ? 0.0f : 1.0f);
    }

    @Override // com.huawei.hms.ads.gz
    public void B() {
        if (this.B.isEmpty()) {
            fh.I(D(), "impressionOccurred, mAdEventList isEmpty");
            return;
        }
        try {
            Iterator<AdEvents> it = this.B.iterator();
            while (it.hasNext()) {
                it.next().impressionOccurred();
            }
        } catch (IllegalStateException unused) {
            fh.V(D(), "impressionOccurred, fail");
        }
    }

    @Override // com.huawei.hms.ads.gz
    public void Code() {
        if (this.Z.isEmpty()) {
            fh.I(D(), "firstQuartile, mVideoEventsList isEmpty");
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    fh.V(D(), com.huawei.openalliance.ad.constant.dc.V);
                    mediaEvents.firstQuartile();
                }
            }
        } catch (IllegalStateException unused) {
            fh.V(D(), "firstQuartile, fail");
        }
    }

    public he S() {
        return this.C;
    }

    @Override // com.huawei.hms.ads.gz
    public void Z() {
        if (this.Z.isEmpty()) {
            fh.I(D(), "thirdQuartile, mVideoEventsList isEmpty");
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    fh.V(D(), "thirdQuartile ");
                    mediaEvents.thirdQuartile();
                }
            }
        } catch (IllegalStateException unused) {
            fh.V(D(), "thirdQuartile, fail");
        }
    }

    @Override // com.huawei.hms.ads.gz, com.huawei.hms.ads.hw
    public void a() {
        this.D = 0.0f;
        this.F = 0;
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (fh.Code()) {
                        fh.Code(D(), "complete ");
                    }
                    mediaEvents.complete();
                }
            }
        } catch (IllegalStateException unused) {
            fh.V(D(), "complete, fail");
        }
    }

    @Override // com.huawei.hms.ads.gz, com.huawei.hms.ads.hw
    public void b() {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (fh.Code()) {
                        fh.Code(D(), "bufferStart ");
                    }
                    mediaEvents.bufferStart();
                }
            }
        } catch (IllegalStateException unused) {
            fh.V(D(), "bufferStart, fail");
        }
    }

    @Override // com.huawei.hms.ads.gz, com.huawei.hms.ads.hw
    public void c() {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (fh.Code()) {
                        fh.Code(D(), "bufferFinish ");
                    }
                    mediaEvents.bufferFinish();
                }
            }
        } catch (IllegalStateException unused) {
            fh.V(D(), "bufferFinish, fail");
        }
    }

    @Override // com.huawei.hms.ads.gz, com.huawei.hms.ads.hw
    public void d() {
        if (!this.L) {
            this.F = 0;
        }
        if (this.Z.isEmpty()) {
            fh.I(D(), "skipped, mVideoEventsList isEmpty");
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (fh.Code()) {
                        fh.Code(D(), "skipped ");
                    }
                    mediaEvents.skipped();
                }
            }
        } catch (IllegalStateException unused) {
            fh.V(D(), "skipped, fail");
        }
    }

    @Override // com.huawei.hms.ads.gz, com.huawei.hms.ads.hw
    public void e() {
        if (this.Z.isEmpty() || 1 != this.F) {
            return;
        }
        try {
            this.F = 2;
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (fh.Code()) {
                        fh.Code(D(), "pause ");
                    }
                    mediaEvents.pause();
                }
            }
        } catch (IllegalStateException unused) {
            fh.V(D(), "pause, fail");
        }
    }

    @Override // com.huawei.hms.ads.gz, com.huawei.hms.ads.hw
    public void f() {
        this.F = 1;
        if (this.Z.isEmpty()) {
            fh.I(D(), "resume, mVideoEventsList isEmpty");
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (fh.Code()) {
                        fh.Code(D(), "resume ");
                    }
                    mediaEvents.resume();
                }
            }
        } catch (IllegalStateException unused) {
            fh.V(D(), "resume, fail");
        }
    }

    @Override // com.huawei.hms.ads.hw
    public void Code(float f) {
        int iCode = hd.Code(this.D, f);
        if (fh.Code()) {
            fh.Code(D(), "onProgress %s", Integer.valueOf(iCode));
        }
        if (iCode == 25) {
            this.D = iCode;
            Code();
        } else if (iCode == 50) {
            this.D = iCode;
            I();
        } else {
            if (iCode != 75) {
                return;
            }
            this.D = iCode;
            Z();
        }
    }

    @Override // com.huawei.hms.ads.gz
    public void I() {
        if (this.Z.isEmpty()) {
            fh.I(D(), "midpoint, mVideoEventsList isEmpty");
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    fh.V(D(), "midpoint ");
                    mediaEvents.midpoint();
                }
            }
        } catch (IllegalStateException unused) {
            fh.V(D(), "midpoint, fail");
        }
    }

    @Override // com.huawei.hms.ads.gx
    public void V() {
        if (fh.Code()) {
            fh.Code(D(), "release ");
        }
        this.F = 0;
        he heVar = this.C;
        if (heVar != null) {
            heVar.V();
        }
        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.ha.2
            @Override // java.lang.Runnable
            public void run() {
                ha.this.Z.clear();
                ha.this.B.clear();
            }
        }, 200L);
    }

    @Override // com.huawei.hms.ads.gz
    public void Code(float f, float f2) {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (fh.Code()) {
                        fh.Code(D(), "start，duration %s", Float.valueOf(f));
                    }
                    mediaEvents.start(f, f2);
                }
            }
        } catch (IllegalStateException unused) {
            fh.V(D(), "start, fail");
        }
    }

    @Override // com.huawei.hms.ads.gz, com.huawei.hms.ads.hw
    public void V(float f) {
        he heVar;
        fh.V(D(), "volumeChange %s", Float.valueOf(f));
        this.S = Math.abs(f - 0.0f) < 1.0E-8f;
        if (this.Z.isEmpty() || this.F != 1) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null && (heVar = this.C) != null) {
                    if (f == -1.0f) {
                        mediaEvents.volumeChange(heVar.Code(this.S));
                    } else {
                        mediaEvents.volumeChange(f);
                    }
                }
            }
        } catch (IllegalStateException unused) {
            fh.V(D(), "volumeChange, fail");
        }
    }

    @Override // com.huawei.hms.ads.hw
    public void Code(float f, boolean z) {
        this.F = 1;
        this.S = z;
        Code(f, z ? 0.0f : 1.0f);
    }

    @Override // com.huawei.hms.ads.hw
    public void V(boolean z) {
        this.L = z;
    }

    @Override // com.huawei.hms.ads.gx
    public void Code(hm hmVar) {
        String strD;
        String str;
        if (I) {
            if ((hmVar instanceof gq) && C()) {
                gq gqVar = (gq) hmVar;
                Context contextI = gqVar.I();
                if (contextI != null) {
                    fh.V(D(), "Set VolumeChange observer");
                    he heVar = new he(contextI);
                    this.C = heVar;
                    heVar.Code(new he.b() { // from class: com.huawei.hms.ads.ha.1
                        @Override // com.huawei.hms.ads.he.b
                        public void Code() {
                            ha.this.F();
                        }
                    });
                }
                List<AdSession> listV = gqVar.V();
                if (!listV.isEmpty()) {
                    for (AdSession adSession : listV) {
                        if (adSession != null) {
                            if (fh.Code()) {
                                fh.Code(D(), "setAdSessionAgent, add mVideoEventsList ");
                            }
                            this.Z.add(MediaEvents.createMediaEvents(adSession));
                            this.B.add(AdEvents.createAdEvents(adSession));
                        }
                    }
                    return;
                }
                strD = D();
                str = "adSessionList is empty";
            } else {
                strD = D();
                str = "adsessionAgent is null";
            }
            fh.V(strD, str);
        }
    }

    @Override // com.huawei.hms.ads.gz, com.huawei.hms.ads.hw
    public void Code(hx hxVar) {
        InteractionType interactionTypeCode;
        if (!hx.Code() || (interactionTypeCode = hx.Code(hxVar)) == null) {
            return;
        }
        Code(interactionTypeCode);
    }

    @Override // com.huawei.hms.ads.hw
    public void Code(hy hyVar) {
        PlayerState playerStateCode;
        if (!hy.Code() || (playerStateCode = hy.Code(hyVar)) == null) {
            return;
        }
        if (fh.Code()) {
            fh.Code(D(), "playerStateChange %s", hyVar.toString());
        }
        Code(playerStateCode);
    }

    @Override // com.huawei.hms.ads.gz, com.huawei.hms.ads.hw
    public void Code(ia iaVar) {
        VastProperties vastPropertiesV;
        if (iaVar == null || !ia.Code() || (vastPropertiesV = iaVar.V()) == null) {
            return;
        }
        Code(vastPropertiesV);
    }

    @Override // com.huawei.hms.ads.gz
    public void Code(InteractionType interactionType) {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (fh.Code()) {
                        fh.Code(D(), "adUserInteraction ");
                    }
                    mediaEvents.adUserInteraction(interactionType);
                }
            }
        } catch (IllegalStateException unused) {
            fh.V(D(), "adUserInteraction, fail");
        }
    }

    @Override // com.huawei.hms.ads.gz
    public void Code(PlayerState playerState) {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    mediaEvents.playerStateChange(PlayerState.COLLAPSED);
                }
            }
        } catch (IllegalStateException unused) {
            fh.V(D(), "playerStateChange, fail");
        }
    }

    @Override // com.huawei.hms.ads.gz
    public void Code(VastProperties vastProperties) {
        if (this.B.isEmpty()) {
            return;
        }
        try {
            for (AdEvents adEvents : this.B) {
                if (adEvents != null) {
                    if (fh.Code()) {
                        fh.Code(D(), "loaded ");
                    }
                    adEvents.loaded(vastProperties);
                }
            }
        } catch (IllegalStateException unused) {
            fh.V(D(), "loaded, fail");
        }
    }
}
