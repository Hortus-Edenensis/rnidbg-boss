package com.kwad.sdk.kgeo;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@KsJson
public class KGeoInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = 7513106797546359464L;
    public double latitude;
    public double longitude;
    public int range;
    public int rate;
}
