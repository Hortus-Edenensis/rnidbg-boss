package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class b extends RelativeLayout {

    @NonNull
    protected final c aPx;
    private Runnable adJ;

    public b(Context context, @NonNull c cVar) {
        super(context);
        this.aPx = cVar;
    }

    public abstract void onPlayStateChanged(int i);

    public abstract void reset();

    public abstract void uY();

    public final void ve() {
        vf();
        if (this.adJ == null) {
            this.adJ = new Runnable() { // from class: com.kwad.sdk.core.video.videoview.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.uY();
                    if (b.this.adJ != null) {
                        b bVar = b.this;
                        bVar.postDelayed(bVar.adJ, 1000L);
                    }
                }
            };
        }
        post(this.adJ);
    }

    public final void vf() {
        Runnable runnable = this.adJ;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.adJ = null;
        }
    }

    public void p(int i, int i2) {
    }
}
