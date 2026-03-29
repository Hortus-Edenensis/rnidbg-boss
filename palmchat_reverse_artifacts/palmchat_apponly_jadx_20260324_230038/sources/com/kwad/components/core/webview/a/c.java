package com.kwad.components.core.webview.a;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@KsJson
public class c extends com.kwad.sdk.core.response.a.a {
    public String Om;
    public String afV;
    public String afW;
    public int afX;

    public final AdInfo.SmallAppJumpInfo bd(String str) {
        AdInfo.SmallAppJumpInfo smallAppJumpInfo = new AdInfo.SmallAppJumpInfo();
        smallAppJumpInfo.mediaSmallAppId = str;
        smallAppJumpInfo.originId = this.afV;
        smallAppJumpInfo.smallAppJumpUrl = this.afW;
        return smallAppJumpInfo;
    }
}
