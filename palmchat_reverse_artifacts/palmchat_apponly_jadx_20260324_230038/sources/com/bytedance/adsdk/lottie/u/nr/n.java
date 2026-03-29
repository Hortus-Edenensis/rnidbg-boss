package com.bytedance.adsdk.lottie.u.nr;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class n {
    private final List<com.bytedance.adsdk.lottie.model.nr.n> fx;
    private final List<u<Integer, Integer>> nr;
    private final List<u<com.bytedance.adsdk.lottie.model.nr.s, Path>> u;

    public n(List<com.bytedance.adsdk.lottie.model.nr.n> list) {
        this.fx = list;
        this.u = new ArrayList(list.size());
        this.nr = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.u.add(list.get(i).nr().u());
            this.nr.add(list.get(i).fx().u());
        }
    }

    public List<u<Integer, Integer>> fx() {
        return this.nr;
    }

    public List<u<com.bytedance.adsdk.lottie.model.nr.s, Path>> nr() {
        return this.u;
    }

    public List<com.bytedance.adsdk.lottie.model.nr.n> u() {
        return this.fx;
    }
}
