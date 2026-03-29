package com.kwad.sdk.core.i;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {
    private static c aOQ;
    private static c aOR;

    public static c j(boolean z, boolean z2) {
        c cVar;
        com.kwad.sdk.core.d.c.d("KSUserAgentManager", "obtainUAGetter useKwaiUA: " + z + ", unionUAMark: " + z2);
        if (z) {
            if (aOQ == null) {
                aOQ = new b();
            }
            cVar = aOQ;
        } else {
            if (aOR == null) {
                aOR = new d();
            }
            cVar = aOR;
        }
        cVar.bx(z2);
        com.kwad.sdk.core.d.c.d("KSUserAgentManager", "obtainUAGetter result: " + cVar);
        return cVar;
    }
}
