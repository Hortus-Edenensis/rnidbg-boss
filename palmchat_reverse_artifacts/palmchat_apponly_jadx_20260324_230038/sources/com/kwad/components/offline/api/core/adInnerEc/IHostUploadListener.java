package com.kwad.components.offline.api.core.adInnerEc;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Keep
public interface IHostUploadListener {
    void onFailed(int i, String str);

    void onProgress(float f);

    void onSuccess(String str);
}
