package com.bytedance.adsdk.lottie.u.u;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr {
    private final List<dw> u = new ArrayList();

    public void u(dw dwVar) {
        this.u.add(dwVar);
    }

    public void u(Path path) {
        for (int size = this.u.size() - 1; size >= 0; size--) {
            com.bytedance.adsdk.lottie.pn.a.u(path, this.u.get(size));
        }
    }
}
