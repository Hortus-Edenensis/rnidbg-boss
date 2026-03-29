package com.bytedance.adsdk.lottie.model.nr;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a implements fx {
    private final boolean fx;
    private final u nr;
    private final String u;

    /* JADX INFO: compiled from: SearchBox */
    public enum u {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static u u(int i) {
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? MERGE : EXCLUDE_INTERSECTIONS : INTERSECT : SUBTRACT : ADD : MERGE;
        }
    }

    public a(String str, u uVar, boolean z) {
        this.u = str;
        this.nr = uVar;
        this.fx = z;
    }

    public boolean fx() {
        return this.fx;
    }

    public u nr() {
        return this.nr;
    }

    public String toString() {
        return "MergePaths{mode=" + this.nr + '}';
    }

    public String u() {
        return this.u;
    }

    @Override // com.bytedance.adsdk.lottie.model.nr.fx
    public com.bytedance.adsdk.lottie.u.u.fx u(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.iz izVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar) {
        return new com.bytedance.adsdk.lottie.u.u.l(this);
    }
}
