package com.kwad.components.ad.reward;

import com.kwad.sdk.core.response.model.AdTemplate;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class i {
    private Map<String, List<AdTemplate>> te;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        private static final i tf = new i(0);
    }

    public /* synthetic */ i(byte b) {
        this();
    }

    public static i ht() {
        return a.tf;
    }

    public final void H(String str) {
        this.te.remove(str);
    }

    private i() {
        this.te = new ConcurrentHashMap();
    }
}
