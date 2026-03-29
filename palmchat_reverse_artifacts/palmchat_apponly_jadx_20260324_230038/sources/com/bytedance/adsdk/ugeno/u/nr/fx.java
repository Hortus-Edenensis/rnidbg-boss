package com.bytedance.adsdk.ugeno.u.nr;

import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.Keyframe;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.bytedance.adsdk.ugeno.u.pn;
import java.util.TreeMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class fx extends u {
    public fx(Context context, com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, TreeMap<Float, String> treeMap) {
        super(context, fxVar, str, treeMap);
    }

    @Override // com.bytedance.adsdk.ugeno.u.nr.u
    public TypeEvaluator iz() {
        return this.b == pn.BACKGROUND_COLOR ? new ArgbEvaluator() : new IntEvaluator();
    }

    @Override // com.bytedance.adsdk.ugeno.u.nr.u
    public void nr() {
        if (this.b == pn.BACKGROUND_COLOR) {
            this.pn.add(Keyframe.ofInt(0.0f, this.x.jp()));
        }
    }

    @Override // com.bytedance.adsdk.ugeno.u.nr.u
    public void u(float f, String str) {
        this.pn.add(this.b == pn.BACKGROUND_COLOR ? Keyframe.ofInt(f, com.bytedance.adsdk.ugeno.iz.u.u(str)) : Keyframe.ofInt(f, com.bytedance.adsdk.ugeno.iz.fx.u(str, 0)));
    }
}
