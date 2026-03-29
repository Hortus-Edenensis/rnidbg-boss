package com.kwad.sdk.components;

import com.kwad.sdk.components.DevelopMangerComponents;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class g {
    public static boolean ds(String str) {
        DevelopMangerComponents.DevelopValue developValueDr = d.dr(str);
        return developValueDr != null && ((Boolean) developValueDr.getValue()).booleanValue();
    }

    public static boolean encryptDisable() {
        return ds("KEY_HOST_ENCRYPT_DISABLE");
    }
}
