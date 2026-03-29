package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wifi.ad.core.data.NestAdData;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class qv3 extends jv3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f20331a = -1;
    public static final Float[][] b;

    static {
        Float fValueOf = Float.valueOf(340.0f);
        b = new Float[][]{new Float[]{fValueOf, Float.valueOf(192.0f)}, new Float[]{fValueOf, Float.valueOf(228.0f)}, new Float[]{Float.valueOf(291.0f), Float.valueOf(516.0f)}};
    }

    public static void m(ViewGroup viewGroup, iv3 iv3Var, Context context) {
        LogUtil.d("", "NativeType NestNativeUiPM bindAdView start adViewGroup " + viewGroup);
        if (viewGroup != null && iv3Var != null && context != null) {
            NestAdData nestAdDataA = iv3Var.a();
            if (nestAdDataA == null) {
                return;
            }
            bv3 bv3VarB = iv3Var.b();
            if (!(bv3VarB instanceof gv3)) {
                return;
            }
            ((gv3) bv3VarB).e(viewGroup.findViewById(R$id.ad_down_yaoyiyao_layout));
            jv3.i(jv3.c(viewGroup, iv3Var, b, context), nestAdDataA);
        }
        LogUtil.d("", "NativeType NestNativeUiPM bindAdView end adViewGroup " + viewGroup);
    }

    public static View n(iv3 iv3Var, Context context) {
        if (iv3Var == null || context == null) {
            return null;
        }
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.nest_view_pm_ad_large, (ViewGroup) null, false);
        LogUtil.d("", "NativeType NestNativeUiPM createAdView adView " + viewInflate);
        return viewInflate;
    }
}
