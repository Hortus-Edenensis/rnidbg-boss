package com.bytedance.adsdk.u.u.nr;

import java.nio.ByteOrder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr extends b {
    @Override // com.bytedance.adsdk.u.u.nr.b
    public void fx(int i) {
        super.fx(i);
        this.u.order(ByteOrder.BIG_ENDIAN);
    }

    public void nr(int i) {
        u((byte) ((i >> 24) & 255));
        u((byte) ((i >> 16) & 255));
        u((byte) ((i >> 8) & 255));
        u((byte) (i & 255));
    }

    public void u(int i) {
        u((byte) (i & 255));
        u((byte) ((i >> 8) & 255));
        u((byte) ((i >> 16) & 255));
        u((byte) ((i >> 24) & 255));
    }
}
