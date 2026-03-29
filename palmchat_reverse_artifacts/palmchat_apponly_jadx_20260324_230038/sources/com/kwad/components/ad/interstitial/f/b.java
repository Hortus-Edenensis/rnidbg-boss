package com.kwad.components.ad.interstitial.f;

import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b extends Presenter {
    public c mi;

    @Override // com.kwad.sdk.mvp.Presenter
    public void as() {
        super.as();
        this.mi = (c) PC();
    }

    public void dS() {
        List<Presenter> listPB = PB();
        if (listPB == null) {
            return;
        }
        for (Presenter presenter : listPB) {
            if (presenter instanceof b) {
                ((b) presenter).dS();
            }
        }
    }

    public void dT() {
        List<Presenter> listPB = PB();
        if (listPB == null) {
            return;
        }
        for (Presenter presenter : listPB) {
            if (presenter instanceof b) {
                ((b) presenter).dT();
            }
        }
    }
}
