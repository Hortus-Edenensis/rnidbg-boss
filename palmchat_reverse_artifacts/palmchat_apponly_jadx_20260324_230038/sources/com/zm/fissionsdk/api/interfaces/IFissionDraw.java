package com.zm.fissionsdk.api.interfaces;

import android.content.Context;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface IFissionDraw extends IFission {

    /* JADX INFO: compiled from: SearchBox */
    public interface DrawInteractionListener extends IFissionInteractionListener {
    }

    View getDrawView(Context context);

    void setDrawInteractionListener(DrawInteractionListener drawInteractionListener);

    void setVideoMute(boolean z);
}
