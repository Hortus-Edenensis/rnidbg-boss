package com.kwad.sdk.commercial.model;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@KsJson
public class WebCloseStatus extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = -998295657148922925L;
    public int closeType;
    public boolean interactSuccess;
}
