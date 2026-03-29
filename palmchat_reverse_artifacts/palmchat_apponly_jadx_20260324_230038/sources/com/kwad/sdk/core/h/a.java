package com.kwad.sdk.core.h;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.h;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {
    private static C0613a aOJ;
    private static boolean aOK;
    private static final AtomicBoolean mHasInit = new AtomicBoolean(false);
    private static boolean aOL = true;

    /* JADX INFO: renamed from: com.kwad.sdk.core.h.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    @KsJson
    public static class C0613a extends com.kwad.sdk.core.response.a.a {
        public List<String> aOM;
        public int aON;
        public List<String> aOO;
        public List<String> aOP;
    }

    public static void LD() {
        h.execute(new bg() { // from class: com.kwad.sdk.core.h.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (a.mHasInit.getAndSet(true)) {
                    return;
                }
                try {
                    C0613a unused = a.aOJ = new C0613a();
                    boolean unused2 = a.aOK = ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).DE();
                    String strDF = ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).DF();
                    if (a.aOK && !TextUtils.isEmpty(strDF)) {
                        a.aOJ.parseJson(new JSONObject(strDF));
                        a.LE();
                        return;
                    }
                    boolean unused3 = a.aOL = a.aOK;
                } catch (Throwable unused4) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void LE() {
        aOL = true;
        if (aOJ == null) {
            return;
        }
        ea(LF());
        ag.l("ksadsdk_tk_switch", "tk_config", aOL);
    }

    private static int LF() {
        int i = !aOJ.aOO.isEmpty() ? 1 : 0;
        C0613a c0613a = aOJ;
        int i2 = c0613a.aON != 0 ? 2 : 0;
        return ((i ^ i2) ^ (!c0613a.aOM.isEmpty() ? 4 : 0)) ^ (aOJ.aOP.isEmpty() ? 0 : 8);
    }

    public static boolean LG() {
        return mHasInit.get() ? aOL : ag.m("ksadsdk_tk_switch", "tk_config", true);
    }

    private static void ea(int i) {
        for (int i2 = 0; i2 < Integer.toBinaryString(i).length(); i2++) {
            if (((1 << i2) & i) != 0) {
                aOL = false;
                eb(i2);
                if (aOL) {
                    return;
                }
            }
        }
    }

    private static void eb(int i) {
        if (i == 0) {
            if (aOJ.aOO.contains(br.TN())) {
                return;
            }
            aOL = true;
        } else if (i == 1) {
            if (aOJ.aON < br.TX()) {
                aOL = true;
            }
        } else if (i == 2) {
            if (aOJ.aOM.contains(BuildConfig.VERSION_NAME)) {
                return;
            }
            aOL = true;
        } else if (i == 3 && !aOJ.aOP.contains(br.TM())) {
            aOL = true;
        }
    }
}
