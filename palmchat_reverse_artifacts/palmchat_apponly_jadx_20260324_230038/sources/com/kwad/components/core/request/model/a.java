package com.kwad.components.core.request.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.j;
import com.kwad.sdk.commercial.d.d;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {

    @NonNull
    public final ImpInfo SS;

    @NonNull
    public final com.kwad.components.core.request.c aaP;

    @Nullable
    public j aaQ;

    @Nullable
    public List<String> aaR;
    public boolean aaS;
    public boolean aaT;

    @Nullable
    public c aaU;
    private String aaV;

    /* JADX INFO: renamed from: com.kwad.components.core.request.model.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0560a {
        public ImpInfo SS;
        public com.kwad.components.core.request.c aaP;
        public boolean aaS;
        public boolean aaT;
        public j aaW;

        public final C0560a a(@NonNull com.kwad.components.core.request.c cVar) {
            this.aaP = cVar;
            return this;
        }

        public final C0560a aP(boolean z) {
            this.aaS = true;
            return this;
        }

        public final C0560a aQ(boolean z) {
            this.aaT = z;
            return this;
        }

        public final C0560a e(ImpInfo impInfo) {
            this.SS = impInfo;
            return this;
        }

        public final a tR() {
            if (com.kwad.components.ad.f.a.oy.booleanValue() && (this.SS == null || this.aaP == null)) {
                throw new IllegalStateException("AdRequestParams build Illegal");
            }
            return new a(this, (byte) 0);
        }

        public final C0560a a(j jVar) {
            this.aaW = jVar;
            return this;
        }
    }

    public /* synthetic */ a(C0560a c0560a, byte b) {
        this(c0560a);
    }

    public static void a(@NonNull a aVar, AdResultData adResultData, boolean z) {
        d.a(aVar.SS.adScene, aVar.tQ(), adResultData.getAdSource());
        if (adResultData.isAdResultDataEmpty()) {
            aVar.aaP.a(e.aJc.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? e.aJc.msg : adResultData.testErrorMsg, z);
        } else {
            aVar.aaP.a(adResultData, z);
        }
    }

    public final void aQ(String str) {
        this.aaV = str;
    }

    public final int getAdNum() {
        SceneImpl sceneImpl = this.SS.adScene;
        if (sceneImpl != null) {
            return sceneImpl.getAdNum();
        }
        return 1;
    }

    public final int getAdStyle() {
        SceneImpl sceneImpl = this.SS.adScene;
        if (sceneImpl != null) {
            return sceneImpl.adStyle;
        }
        return 0;
    }

    public final long getPosId() {
        SceneImpl sceneImpl = this.SS.adScene;
        if (sceneImpl != null) {
            return sceneImpl.getPosId();
        }
        return -1L;
    }

    @Nullable
    public final j tP() {
        return this.aaQ;
    }

    public final String tQ() {
        return !TextUtils.isEmpty(this.aaV) ? this.aaV : "network_only";
    }

    private a(C0560a c0560a) {
        this.SS = c0560a.SS;
        this.aaP = c0560a.aaP;
        this.aaS = c0560a.aaS;
        this.aaT = c0560a.aaT;
        this.aaQ = c0560a.aaW;
    }

    public static void a(@NonNull a aVar, int i, String str, boolean z) {
        aVar.aaP.a(i, str, z);
        d.a(aVar.getAdStyle(), i, str, aVar.tQ());
    }
}
