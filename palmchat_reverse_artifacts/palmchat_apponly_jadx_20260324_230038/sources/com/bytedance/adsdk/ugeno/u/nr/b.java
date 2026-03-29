package com.bytedance.adsdk.ugeno.u.nr;

import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.iz.n;
import com.bytedance.adsdk.ugeno.u.pn;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b extends u {
    private List<Keyframe> n;

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.u.nr.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] u;

        static {
            int[] iArr = new int[pn.values().length];
            u = iArr;
            try {
                iArr[pn.TRANSLATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                u[pn.SCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public b(Context context, com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, Map<Float, String> map) {
        super(context, fxVar, str, map);
        this.n = new ArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.u.nr.u
    public TypeEvaluator iz() {
        return new FloatEvaluator();
    }

    @Override // com.bytedance.adsdk.ugeno.u.nr.u
    public void nr() {
        Keyframe keyframeOfFloat;
        Keyframe keyframeOfFloat2;
        int i = AnonymousClass1.u[this.b.ordinal()];
        if (i == 1) {
            keyframeOfFloat = Keyframe.ofFloat(0.0f, this.x.mv());
            keyframeOfFloat2 = Keyframe.ofFloat(0.0f, this.x.s());
        } else if (i != 2) {
            keyframeOfFloat = null;
            keyframeOfFloat2 = null;
        } else {
            keyframeOfFloat = Keyframe.ofFloat(0.0f, this.x.k());
            keyframeOfFloat2 = Keyframe.ofFloat(0.0f, this.x.my());
        }
        if (keyframeOfFloat != null) {
            this.pn.add(keyframeOfFloat);
        }
        if (keyframeOfFloat2 != null) {
            this.n.add(keyframeOfFloat2);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.u.nr.u
    public List<PropertyValuesHolder> pn() {
        String strNr = this.b.nr();
        b();
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(strNr + "X", (Keyframe[]) this.pn.toArray(new Keyframe[0]));
        this.iz.add(propertyValuesHolderOfKeyframe);
        PropertyValuesHolder propertyValuesHolderOfKeyframe2 = PropertyValuesHolder.ofKeyframe(strNr + "Y", (Keyframe[]) this.n.toArray(new Keyframe[0]));
        this.iz.add(propertyValuesHolderOfKeyframe2);
        TypeEvaluator typeEvaluatorIz = iz();
        if (typeEvaluatorIz != null) {
            propertyValuesHolderOfKeyframe.setEvaluator(typeEvaluatorIz);
            propertyValuesHolderOfKeyframe2.setEvaluator(typeEvaluatorIz);
        }
        return this.iz;
    }

    @Override // com.bytedance.adsdk.ugeno.u.nr.u
    public void u(float f, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() != 2) {
                return;
            }
            float fOptDouble = (float) jSONArray.optDouble(0);
            float fOptDouble2 = (float) jSONArray.optDouble(1);
            if (this.b == pn.TRANSLATE) {
                fOptDouble = n.u(this.u, fOptDouble);
                fOptDouble2 = n.u(this.u, fOptDouble2);
            }
            this.pn.add(Keyframe.ofFloat(f, fOptDouble));
            this.n.add(Keyframe.ofFloat(f, fOptDouble2));
        } catch (JSONException unused) {
        }
    }
}
