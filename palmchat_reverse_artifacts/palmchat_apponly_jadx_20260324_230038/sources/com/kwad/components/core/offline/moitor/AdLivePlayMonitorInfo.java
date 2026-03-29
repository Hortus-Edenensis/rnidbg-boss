package com.kwad.components.core.offline.moitor;

import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class AdLivePlayMonitorInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    private static final long serialVersionUID = -3833408862294416903L;
    public String appId;
    public String authorId;
    public int scene;
    public Long userId;

    public AdLivePlayMonitorInfo setAppId(String str) {
        this.appId = str;
        return this;
    }

    public AdLivePlayMonitorInfo setAuthorId(String str) {
        this.authorId = str;
        return this;
    }

    public AdLivePlayMonitorInfo setScene(int i) {
        this.scene = i;
        return this;
    }

    public AdLivePlayMonitorInfo setUserId(Long l) {
        this.userId = l;
        return this;
    }
}
