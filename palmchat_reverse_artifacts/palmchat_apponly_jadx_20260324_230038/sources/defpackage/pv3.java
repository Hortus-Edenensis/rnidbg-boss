package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class pv3 extends jv3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Float[][] f20112a;

    static {
        Float fValueOf = Float.valueOf(76.0f);
        f20112a = new Float[][]{new Float[]{Float.valueOf(135.0f), fValueOf}, new Float[]{Float.valueOf(116.0f), fValueOf}, new Float[]{Float.valueOf(42.0f), fValueOf}};
    }

    public static void m(ViewGroup viewGroup, iv3 iv3Var, Context context) {
        LogUtil.d("", "NativeType NestNativeUiNearBy bindAdView start adViewGroup " + viewGroup);
        if (viewGroup != null && iv3Var != null && context != null) {
            if (iv3Var.a() == null) {
                return;
            }
            iv3Var.b();
        } else {
            LogUtil.d("", "NativeType NestNativeUiNearBy bindAdView end adViewGroup " + viewGroup);
        }
    }

    public static View n(iv3 iv3Var, Context context) {
        if (iv3Var == null || context == null) {
            return null;
        }
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.nest_view_nearby_old_content_large, (ViewGroup) null, false);
        LogUtil.d("", "NativeType NestNativeUiNearBy createAdView adView " + viewInflate);
        return viewInflate;
    }
}
