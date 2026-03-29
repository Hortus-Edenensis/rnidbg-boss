package com.bytedance.adsdk.ugeno.u.nr;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.bytedance.adsdk.ugeno.u.pn;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class u {
    protected pn b;
    protected Map<Float, String> fx;
    protected String nr;
    protected Context u;
    protected com.bytedance.adsdk.ugeno.nr.fx x;
    protected List<PropertyValuesHolder> iz = new ArrayList();
    protected List<Keyframe> pn = new ArrayList();

    public u(Context context, com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, Map<Float, String> map) {
        this.u = context;
        this.nr = str;
        this.fx = map;
        this.b = pn.u(this.nr);
        this.x = fxVar;
    }

    public void b() {
        Map<Float, String> map = this.fx;
        if (map == null || map.size() <= 0) {
            return;
        }
        if (!u()) {
            nr();
        }
        for (Map.Entry<Float, String> entry : this.fx.entrySet()) {
            if (entry != null) {
                u(entry.getKey().floatValue() / 100.0f, entry.getValue());
            }
        }
        fx();
    }

    public void fx() {
        Map<Float, String> map = this.fx;
        if (map == null || map.size() <= 0) {
            return;
        }
        Map<Float, String> map2 = this.fx;
        if (map2 instanceof TreeMap) {
            float fFloatValue = ((Float) ((TreeMap) map2).lastKey()).floatValue();
            if (fFloatValue != 100.0f) {
                u(100.0f, this.fx.get(Float.valueOf(fFloatValue)));
            }
        }
    }

    public String getType() {
        return this.b.fx();
    }

    public abstract TypeEvaluator iz();

    public abstract void nr();

    public List<PropertyValuesHolder> pn() {
        String strNr = this.b.nr();
        b();
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(strNr, (Keyframe[]) this.pn.toArray(new Keyframe[0]));
        TypeEvaluator typeEvaluatorIz = iz();
        if (typeEvaluatorIz != null) {
            propertyValuesHolderOfKeyframe.setEvaluator(typeEvaluatorIz);
        }
        this.iz.add(propertyValuesHolderOfKeyframe);
        return this.iz;
    }

    public abstract void u(float f, String str);

    public boolean u() {
        Map<Float, String> map = this.fx;
        if (map == null || map.size() <= 0) {
            return false;
        }
        return this.fx.containsKey(Float.valueOf(0.0f));
    }
}
