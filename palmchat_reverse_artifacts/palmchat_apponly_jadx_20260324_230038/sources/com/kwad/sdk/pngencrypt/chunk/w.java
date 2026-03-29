package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class w {
    private final e bbA;
    private final boolean bbB;

    public w(e eVar) {
        this.bbA = eVar;
        if (eVar instanceof f) {
            this.bbB = false;
        } else {
            this.bbB = true;
        }
    }

    private List<? extends t> gS(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.bbA.an("tEXt", str));
        arrayList.addAll(this.bbA.an("zTXt", str));
        arrayList.addAll(this.bbA.an("iTXt", str));
        return arrayList;
    }

    public final String gT(String str) {
        List<? extends t> listGS = gS(str);
        if (listGS.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<? extends t> it = listGS.iterator();
        while (it.hasNext()) {
            sb.append(it.next().QC());
            sb.append("\n");
        }
        return sb.toString().trim();
    }
}
