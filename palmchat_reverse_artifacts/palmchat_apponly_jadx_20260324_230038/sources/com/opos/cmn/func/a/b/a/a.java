package com.opos.cmn.func.a.b.a;

import com.opos.cmn.envdev.api.EnvDevConfig;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {
    public static boolean a() {
        try {
            return EnvDevConfig.isTaphttpTestEnv();
        } catch (Throwable unused) {
            return false;
        }
    }
}
