package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wifi.ad.core.data.NestAdData;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ov3 extends jv3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Float[][] f19883a;

    static {
        Float fValueOf = Float.valueOf(-1.0f);
        f19883a = new Float[][]{new Float[]{fValueOf, Float.valueOf(180.0f)}, new Float[]{fValueOf, Float.valueOf(210.0f)}, new Float[]{Float.valueOf(125.0f), Float.valueOf(223.0f)}};
    }

    public static void m(ViewGroup viewGroup, iv3 iv3Var, Context context) {
        NestAdData nestAdDataA;
        LogUtil.d("", "NativeType NestNativeUiMine bindAdView adViewGroup " + viewGroup);
        if (viewGroup == null || iv3Var == null || context == null || (nestAdDataA = iv3Var.a()) == null || !(iv3Var.b() instanceof fv3)) {
            return;
        }
        jv3.i(jv3.c(viewGroup, iv3Var, f19883a, context), nestAdDataA);
        LogUtil.d("", "NativeType NestNativeUiMine bindAdView end adViewGroup " + viewGroup);
    }

    public static View n(iv3 iv3Var, Context context) {
        if (iv3Var == null || context == null) {
            return null;
        }
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.nest_view_wkmine_bannerview_content_large, (ViewGroup) null, false);
        LogUtil.d("", "NativeType NestNativeUiMine createAdView adView " + viewInflate);
        return viewInflate;
    }
}
