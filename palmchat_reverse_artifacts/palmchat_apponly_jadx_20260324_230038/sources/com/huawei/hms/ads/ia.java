package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.media.Position;
import com.iab.omid.library.huawei.adsession.media.VastProperties;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ia implements hn {
    private static boolean Code = hc.Code("com.iab.omid.library.huawei.adsession.media.VastProperties");
    private final hz B;
    private Float C;
    private final boolean I;
    private final boolean V;
    private final VastProperties Z;

    private ia(float f, boolean z, hz hzVar, VastProperties vastProperties) {
        this.V = false;
        this.C = Float.valueOf(0.0f);
        this.C = Float.valueOf(f);
        this.I = z;
        this.B = hzVar;
        this.Z = vastProperties;
    }

    public static ia Code(float f, boolean z, hz hzVar) {
        Position positionCode;
        return new ia(f, z, hzVar, (hzVar == null || !Code() || (positionCode = hz.Code(hzVar)) == null) ? null : VastProperties.createVastPropertiesForSkippableMedia(f, z, positionCode));
    }

    public VastProperties V() {
        return this.Z;
    }

    private ia(boolean z, hz hzVar, VastProperties vastProperties) {
        this.V = false;
        this.C = Float.valueOf(0.0f);
        this.I = z;
        this.B = hzVar;
        this.Z = vastProperties;
    }

    public static ia Code(boolean z, hz hzVar) {
        Position positionCode;
        VastProperties vastPropertiesCreateVastPropertiesForNonSkippableMedia = null;
        if (!Code) {
            return null;
        }
        if (hzVar != null && hz.Code() && (positionCode = hz.Code(hzVar)) != null) {
            vastPropertiesCreateVastPropertiesForNonSkippableMedia = VastProperties.createVastPropertiesForNonSkippableMedia(z, positionCode);
        }
        return new ia(z, hzVar, vastPropertiesCreateVastPropertiesForNonSkippableMedia);
    }

    public static boolean Code() {
        return Code;
    }
}
