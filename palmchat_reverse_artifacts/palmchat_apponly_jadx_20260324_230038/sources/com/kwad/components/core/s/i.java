package com.kwad.components.core.s;

import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class i implements View.OnClickListener {
    private j acD;

    public i() {
        this(false);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.acD.a(view, this);
    }

    private i(boolean z) {
        this.acD = new j(false);
    }
}
