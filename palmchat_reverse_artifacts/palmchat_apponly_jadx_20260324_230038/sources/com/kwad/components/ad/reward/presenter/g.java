package com.kwad.components.ad.reward.presenter;

import androidx.annotation.Nullable;
import com.kwad.components.core.j.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class g extends b implements a.InterfaceC0546a {
    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        boolean zJl = com.kwad.sdk.core.local.a.Jl();
        com.kwad.sdk.core.d.c.d("RewardInnerAdLoadPresenter", "onBind localCheckResult: " + zJl);
        SceneImpl sceneImpl = this.mAdTemplate.mAdScene;
        if (sceneImpl == null || !zJl) {
            return;
        }
        com.kwad.components.core.j.a.a(sceneImpl, this);
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0546a
    public final void e(@Nullable List<com.kwad.components.core.j.c> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        com.kwad.sdk.core.d.c.d("RewardInnerAdLoadPresenter", "onInnerAdLoad: " + list.size());
        AdTemplate adTemplate = list.get(0).getAdTemplate();
        boolean zCK = com.kwad.sdk.core.response.b.b.cK(adTemplate);
        List<a.InterfaceC0546a> listGS = this.tq.gS();
        if (zCK) {
            com.kwad.sdk.core.local.a.e(com.kwad.sdk.core.response.b.b.cH(adTemplate), com.kwad.sdk.core.response.b.b.cI(adTemplate));
            if (listGS != null) {
                Iterator<a.InterfaceC0546a> it = listGS.iterator();
                while (it.hasNext()) {
                    it.next().e(list);
                }
            }
        }
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0546a
    public final void onError(int i, String str) {
        List<a.InterfaceC0546a> listGS = this.tq.gS();
        if (listGS != null) {
            Iterator<a.InterfaceC0546a> it = listGS.iterator();
            while (it.hasNext()) {
                it.next().onError(i, str);
            }
        }
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0546a
    public final void onRequestResult(int i) {
        List<a.InterfaceC0546a> listGS = this.tq.gS();
        if (listGS != null) {
            Iterator<a.InterfaceC0546a> it = listGS.iterator();
            while (it.hasNext()) {
                it.next().onRequestResult(i);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
