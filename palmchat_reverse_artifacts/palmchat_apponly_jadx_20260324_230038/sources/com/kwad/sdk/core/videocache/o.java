package com.kwad.sdk.core.videocache;

import android.content.Context;
import com.kwad.sdk.utils.be;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class o {
    public static File bZ(Context context) {
        return new File(be.dQ(context), "video-cache");
    }
}
