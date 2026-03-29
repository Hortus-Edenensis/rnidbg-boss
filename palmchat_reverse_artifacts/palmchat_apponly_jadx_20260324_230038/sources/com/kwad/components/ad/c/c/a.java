package com.kwad.components.ad.c.c;

import com.kwad.sdk.mvp.Presenter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a extends Presenter {
    public com.kwad.components.ad.c.b cD;

    @Override // com.kwad.sdk.mvp.Presenter
    public void as() {
        super.as();
        Object objPC = PC();
        if (objPC instanceof com.kwad.components.ad.c.b) {
            this.cD = (com.kwad.components.ad.c.b) objPC;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onCreate() {
        super.onCreate();
    }
}
