package com.kwad.sdk.components;

import android.app.Activity;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface o {
    Object b(String str, String str2, m mVar);

    void bindActivity(Activity activity);

    View getView();

    boolean onBackPressed();

    void render();

    void setDownloadProgress(String str);
}
