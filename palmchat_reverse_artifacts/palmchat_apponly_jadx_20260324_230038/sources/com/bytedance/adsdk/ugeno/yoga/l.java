package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class l extends YogaNodeJNIBase {
    public void finalize() throws Throwable {
        try {
            mv();
        } finally {
            super.finalize();
        }
    }

    public void mv() {
        long j = this.u;
        if (j != 0) {
            this.u = 0L;
            YogaNative.jni_YGNodeFinalizeJNI(j);
        }
    }
}
