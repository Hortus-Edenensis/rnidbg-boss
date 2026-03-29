package com.kwad.sdk.components;

import android.view.View;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface t {
    o a(String str, Object... objArr);

    void a(k kVar);

    void a(r rVar);

    void a(String str, String str2, s sVar);

    void b(com.kwad.sdk.core.webview.c.g gVar);

    void c(com.kwad.sdk.core.webview.c.a aVar);

    Object execute(String str);

    int getUniqId();

    View getView();

    void onDestroy();

    void setCustomEnv(Map<String, Object> map);
}
