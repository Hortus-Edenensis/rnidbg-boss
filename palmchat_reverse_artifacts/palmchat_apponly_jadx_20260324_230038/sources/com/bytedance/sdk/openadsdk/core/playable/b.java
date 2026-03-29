package com.bytedance.sdk.openadsdk.core.playable;

import com.bytedance.sdk.component.utils.n;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends com.bytedance.sdk.openadsdk.core.t.nr {
    public b(int i, int i2) {
        super(i, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.t.nr, com.bytedance.sdk.openadsdk.core.t.u
    public void u(List<File> list) {
        int size = list.size();
        if (u(0L, size)) {
            return;
        }
        for (File file : list) {
            n.fx(file);
            size--;
            if (u(file, 0L, size)) {
                return;
            }
        }
    }
}
