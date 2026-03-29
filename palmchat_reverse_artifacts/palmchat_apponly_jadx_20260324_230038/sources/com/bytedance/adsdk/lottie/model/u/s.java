package com.bytedance.adsdk.lottie.model.u;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
abstract class s<V, O> implements mv<V, O> {
    final List<com.bytedance.adsdk.lottie.iz.u<V>> u;

    public s(List<com.bytedance.adsdk.lottie.iz.u<V>> list) {
        this.u = list;
    }

    @Override // com.bytedance.adsdk.lottie.model.u.mv
    public List<com.bytedance.adsdk.lottie.iz.u<V>> fx() {
        return this.u;
    }

    @Override // com.bytedance.adsdk.lottie.model.u.mv
    public boolean nr() {
        return this.u.isEmpty() || (this.u.size() == 1 && this.u.get(0).pn());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.u.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.u.toArray()));
        }
        return sb.toString();
    }
}
