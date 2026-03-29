package com.bytedance.adsdk.lottie;

import android.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class sx {
    private boolean u = false;
    private final Set<Object> nr = new u();
    private final Map<String, com.bytedance.adsdk.lottie.pn.x> fx = new HashMap();
    private final Comparator<Pair<String, Float>> b = new Comparator<Pair<String, Float>>() { // from class: com.bytedance.adsdk.lottie.sx.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float fFloatValue = ((Float) pair.second).floatValue();
            float fFloatValue2 = ((Float) pair2.second).floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    };

    public void u(boolean z) {
        this.u = z;
    }

    public void u(String str, float f) {
        if (this.u) {
            com.bytedance.adsdk.lottie.pn.x xVar = this.fx.get(str);
            if (xVar == null) {
                xVar = new com.bytedance.adsdk.lottie.pn.x();
                this.fx.put(str, xVar);
            }
            xVar.u(f);
            if (str.equals("__container")) {
                Iterator<Object> it = this.nr.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }
}
