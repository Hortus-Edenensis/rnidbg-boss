package com.tencent.turingfd.sdk.ams.ad;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import defpackage.ob3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class Lynx {
    public static Hydra a(Context context) {
        Hydra hydra = Hydra.b;
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            Object systemService = context.getSystemService("locale");
            return systemService != null ? new Hydra(new Leo(ob3.a(systemService).getSystemLocales())) : hydra;
        }
        Configuration configuration = Resources.getSystem().getConfiguration();
        return i >= 24 ? Hydra.a(configuration.getLocales().toLanguageTags()) : Hydra.a(configuration.locale.toLanguageTag());
    }
}
