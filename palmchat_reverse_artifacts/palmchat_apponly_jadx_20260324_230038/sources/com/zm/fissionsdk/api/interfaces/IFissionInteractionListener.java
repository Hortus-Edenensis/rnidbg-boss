package com.zm.fissionsdk.api.interfaces;

import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface IFissionInteractionListener {
    void onClick(View view);

    void onShow();

    void onShowFailed(int i, String str);
}
