package com.bytedance.adsdk.u.u.fx;

import com.bytedance.adsdk.u.u.nr.fx;
import com.bytedance.adsdk.u.u.nr.iz;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class u implements nr {
    @Override // com.bytedance.adsdk.u.u.fx.nr
    public iz nr() throws IOException {
        return new fx(u());
    }

    public abstract ByteBuffer u();
}
