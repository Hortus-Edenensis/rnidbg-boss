package com.zm.adxsdk.protocol.api.interfaces;

import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface IInteractionListener {
    void onClick(View view);

    void onShow();

    void onShowFailed(int i, String str);
}
