package com.kwad.components.offline.api.core.adInnerEc;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Keep
public interface IHostLoginStatusListener {
    void onLoginFailure(String str);

    void onLoginSuccess();

    void onLogout();
}
