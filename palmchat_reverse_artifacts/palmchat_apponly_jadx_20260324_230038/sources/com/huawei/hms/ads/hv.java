package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.media.Position;
import com.iab.omid.library.huawei.adsession.media.VastProperties;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class hv implements hn {
    private static boolean Code = hc.Code("com.iab.omid.library.huawei.adsession.media.VastProperties");
    private final hu B;
    private Float C;
    private final boolean I;
    private final boolean V;
    private final VastProperties Z;

    private hv(float f, boolean z, hu huVar, VastProperties vastProperties) {
        this.V = false;
        this.C = Float.valueOf(0.0f);
        this.C = Float.valueOf(f);
        this.I = z;
        this.B = huVar;
        this.Z = vastProperties;
    }

    public static hv Code(float f, boolean z, hu huVar) {
        Position positionCode;
        return new hv(f, z, huVar, (huVar == null || !Code() || (positionCode = hu.Code(huVar)) == null) ? null : VastProperties.createVastPropertiesForSkippableMedia(f, z, positionCode));
    }

    public hu B() {
        return this.B;
    }

    public VastProperties C() {
        return this.Z;
    }

    public Float I() {
        return this.C;
    }

    public boolean V() {
        return false;
    }

    public boolean Z() {
        return this.I;
    }

    private hv(boolean z, hu huVar, VastProperties vastProperties) {
        this.V = false;
        this.C = Float.valueOf(0.0f);
        this.I = z;
        this.B = huVar;
        this.Z = vastProperties;
    }

    public static hv Code(boolean z, hu huVar) {
        Position positionCode;
        return new hv(z, huVar, (huVar == null || !Code() || (positionCode = hu.Code(huVar)) == null) ? null : VastProperties.createVastPropertiesForNonSkippableMedia(z, positionCode));
    }

    public static boolean Code() {
        return Code;
    }
}
