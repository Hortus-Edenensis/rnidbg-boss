package com.kwad.components.ad.draw.presenter.b;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class a {
    private InterfaceC0475a eH;

    @Nullable
    private b eI;
    private boolean eJ = false;
    private AdTemplate mAdTemplate;

    /* JADX INFO: renamed from: com.kwad.components.ad.draw.presenter.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0475a {
        void aU();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        boolean aV();
    }

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @MainThread
    public final void a(InterfaceC0475a interfaceC0475a) {
        this.eH = interfaceC0475a;
    }

    public final void aT() {
        InterfaceC0475a interfaceC0475a;
        if (this.eJ) {
            return;
        }
        this.eJ = true;
        if (e.er(this.mAdTemplate).status == 1 || e.er(this.mAdTemplate).status == 2 || e.er(this.mAdTemplate).status == 3) {
            return;
        }
        b bVar = this.eI;
        if ((bVar == null || !bVar.aV()) && (interfaceC0475a = this.eH) != null) {
            interfaceC0475a.aU();
        }
    }

    @MainThread
    public final void a(b bVar) {
        this.eI = bVar;
    }
}
