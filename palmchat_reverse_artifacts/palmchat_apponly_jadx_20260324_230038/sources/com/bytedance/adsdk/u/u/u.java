package com.bytedance.adsdk.u.u;

import com.bytedance.adsdk.u.u.u.a;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u extends fx<com.bytedance.adsdk.u.u.u.nr> {
    public u(com.bytedance.adsdk.u.u.fx.nr nrVar) {
        super(nrVar);
    }

    @Override // com.bytedance.adsdk.u.u.fx
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.u.u.u.nr nr(com.bytedance.adsdk.u.u.fx.nr nrVar, a.u uVar) {
        return new com.bytedance.adsdk.u.u.u.nr(nrVar, uVar);
    }

    public static u u(final ByteBuffer byteBuffer) {
        return new u(new com.bytedance.adsdk.u.u.fx.u() { // from class: com.bytedance.adsdk.u.u.u.1
            @Override // com.bytedance.adsdk.u.u.fx.u
            public ByteBuffer u() {
                byteBuffer.position(0);
                return byteBuffer;
            }
        });
    }
}
