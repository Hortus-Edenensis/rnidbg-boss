package com.kwad.components.ad.reward.n;

import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.IdRes;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class s extends d {
    protected ViewGroup vZ;

    public final void a(ViewGroup viewGroup, @IdRes int i, @IdRes int i2) {
        if (this.vZ != null) {
            return;
        }
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(i);
        if (viewStub != null) {
            this.vZ = (ViewGroup) viewStub.inflate();
        } else {
            this.vZ = (ViewGroup) viewGroup.findViewById(i2);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public ViewGroup hQ() {
        return this.vZ;
    }
}
