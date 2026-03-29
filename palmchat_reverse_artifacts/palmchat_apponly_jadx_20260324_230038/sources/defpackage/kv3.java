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
public class kv3 extends jv3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Float[][] f18836a;

    static {
        Float fValueOf = Float.valueOf(-1.0f);
        Float[] fArr = {fValueOf, Float.valueOf(172.0f)};
        Float fValueOf2 = Float.valueOf(207.0f);
        f18836a = new Float[][]{fArr, new Float[]{fValueOf, fValueOf2}, new Float[]{Float.valueOf(116.0f), fValueOf2}};
    }

    public static void m(ViewGroup viewGroup, iv3 iv3Var, Context context) {
        LogUtil.d("", "NativeType NestNativeUiChat bindAdView start adViewGroup " + viewGroup);
        if (viewGroup != null && iv3Var != null && context != null) {
            NestAdData nestAdDataA = iv3Var.a();
            if (nestAdDataA == null || !(iv3Var.b() instanceof cv3)) {
                return;
            } else {
                jv3.i(jv3.c(viewGroup, iv3Var, f18836a, context), nestAdDataA);
            }
        }
        LogUtil.d("", "NativeType NestNativeUiChat bindAdView end adViewGroup " + viewGroup);
    }

    public static View n(iv3 iv3Var, Context context) {
        if (iv3Var == null || context == null) {
            return null;
        }
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.nest_view_public_chat_content_large, (ViewGroup) null, false);
        LogUtil.d("", "NativeType NestNativeUiChat createAdView adView " + viewInflate);
        return viewInflate;
    }
}
