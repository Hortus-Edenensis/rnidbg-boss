package com.kwad.components.core.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.aq;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class f extends FrameLayout {
    private boolean ang;
    protected g kQ;
    protected boolean li;

    @NonNull
    protected Context mContext;

    public f(@NonNull Context context) {
        super(context);
        this.mContext = context;
        this.li = aq.SM();
    }

    private void xH() {
        boolean zSM = aq.SM();
        if (!this.ang || zSM == this.li) {
            return;
        }
        this.li = zSM;
        g gVar = this.kQ;
        if (gVar != null) {
            gVar.k(!zSM);
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        xH();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.ang = i == 0;
        xH();
    }

    public final void setOrientationChangeListener(g gVar) {
        this.kQ = gVar;
    }
}
