package com.kwad.components.ad.reward.presenter.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c extends f {
    @Override // com.kwad.components.ad.reward.presenter.f.f, com.kwad.components.core.webview.tachikoma.j
    public String getTKReaderScene() {
        return "tk_image_video";
    }

    @Override // com.kwad.components.ad.reward.presenter.f.f, com.kwad.components.core.webview.tachikoma.j
    public String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dL(this.tq.mAdTemplate);
    }
}
