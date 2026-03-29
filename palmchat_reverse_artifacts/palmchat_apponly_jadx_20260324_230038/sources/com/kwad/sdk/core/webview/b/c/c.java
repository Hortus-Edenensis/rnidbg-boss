package com.kwad.sdk.core.webview.b.c;

import androidx.media3.common.MimeTypes;
import com.huawei.openalliance.ad.constant.bi;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c {
    private static final List<String> aSC;

    static {
        ArrayList arrayList = new ArrayList();
        aSC = arrayList;
        arrayList.add("application/x-javascript");
        arrayList.add("image/jpeg");
        arrayList.add("image/tiff");
        arrayList.add("text/css");
        arrayList.add("text/html");
        arrayList.add(bi.B);
        arrayList.add("image/png");
        arrayList.add("application/javascript");
        arrayList.add("video/mp4");
        arrayList.add("audio/mpeg");
        arrayList.add("application/json");
        arrayList.add(MimeTypes.IMAGE_WEBP);
        arrayList.add("image/apng");
        arrayList.add("image/svg+xml");
        arrayList.add("application/octet-stream");
    }

    public static boolean fw(String str) {
        return aSC.contains(str);
    }
}
