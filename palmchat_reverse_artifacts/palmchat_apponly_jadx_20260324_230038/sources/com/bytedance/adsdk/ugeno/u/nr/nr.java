package com.bytedance.adsdk.ugeno.u.nr;

import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.bytedance.adsdk.ugeno.iz.n;
import com.bytedance.adsdk.ugeno.u.pn;
import java.util.TreeMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr extends u {

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.u.nr.nr$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] u;

        static {
            int[] iArr = new int[pn.values().length];
            u = iArr;
            try {
                iArr[pn.TRANSLATE_X.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                u[pn.TRANSLATE_Y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                u[pn.SCALE_X.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                u[pn.SCALE_Y.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                u[pn.ROTATE_X.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                u[pn.ROTATE_Y.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                u[pn.ROTATE_Z.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                u[pn.ALPHA.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                u[pn.BORDER_RADIUS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public nr(Context context, com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, TreeMap<Float, String> treeMap) {
        super(context, fxVar, str, treeMap);
    }

    @Override // com.bytedance.adsdk.ugeno.u.nr.u
    public TypeEvaluator iz() {
        return new FloatEvaluator();
    }

    @Override // com.bytedance.adsdk.ugeno.u.nr.u
    public void nr() {
        float fMv;
        switch (AnonymousClass1.u[this.b.ordinal()]) {
            case 1:
                fMv = this.x.mv();
                break;
            case 2:
                fMv = this.x.s();
                break;
            case 3:
                fMv = this.x.k();
                break;
            case 4:
                fMv = this.x.my();
                break;
            case 5:
                fMv = this.x.o();
                if (this.x.a() != null) {
                    this.x.a().setCameraDistance(10000.0f);
                }
                break;
            case 6:
                fMv = this.x.sx();
                if (this.x.a() != null) {
                    this.x.a().setCameraDistance(10000.0f);
                }
                break;
            case 7:
                fMv = this.x.bg();
                break;
            case 8:
                fMv = this.x.bq();
                break;
            case 9:
                fMv = this.x.dw();
                break;
            default:
                fMv = 0.0f;
                break;
        }
        this.pn.add(Keyframe.ofFloat(0.0f, fMv));
    }

    @Override // com.bytedance.adsdk.ugeno.u.nr.u
    public void u(float f, String str) {
        this.pn.add(Keyframe.ofFloat(f, (this.nr.startsWith(pn.TRANSLATE.u()) || this.b == pn.BORDER_RADIUS) ? n.u(this.u, com.bytedance.adsdk.ugeno.iz.fx.u(str, 0.0f)) : com.bytedance.adsdk.ugeno.iz.fx.u(str, 0.0f)));
    }
}
