package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.helper.AdHelperFeed;
import com.wifi.ad.core.spstrategy.SPCacheManager;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class nv3 {
    /* JADX WARN: Removed duplicated region for block: B:31:0x0070 A[Catch: Exception -> 0x007f, TryCatch #0 {Exception -> 0x007f, blocks: (B:3:0x0002, B:7:0x0024, B:28:0x0064, B:29:0x0068, B:30:0x006c, B:31:0x0070, B:32:0x0074, B:33:0x0078, B:34:0x007c), top: B:38:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(iv3 iv3Var, Context context, ViewGroup viewGroup) {
        try {
            LogUtil.d("", "NativeType bindAdUIView model " + iv3Var + " adViewGroup " + viewGroup);
            if (iv3Var != null && viewGroup != null && context != null) {
                int iD = iv3Var.d();
                LogUtil.d("", "NativeType bindAdUIView scene " + iD);
                if (iD == 6) {
                    qv3.m(viewGroup, iv3Var, context);
                } else if (iD == 16) {
                    pv3.m(viewGroup, iv3Var, context);
                } else if (iD == 40) {
                    ov3.m(viewGroup, iv3Var, context);
                } else if (iD == 42) {
                    rv3.n(viewGroup, iv3Var, context);
                } else if (iD == 59) {
                    lv3.m(viewGroup, iv3Var, context);
                } else if (iD == 67) {
                    kv3.m(viewGroup, iv3Var, context);
                } else if (iD != 78 && iD != 83) {
                    if (iD == 56 || iD == 57) {
                        mv3.m(viewGroup, iv3Var, context);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void b(String str, ImageView imageView) {
        LogUtil.d("", "NativeType blurAdBg imgUrl " + str + " imageView " + imageView);
        if (imageView != null) {
            int i = R$drawable.nest_blur_def_bg;
            imageView.setImageResource(i);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            hc2.a(c.b()).load(k86.p(str)).placeholder(i).transform(new y5(70, 15)).into(imageView);
        }
    }

    public static int c(int i) {
        if (i == 57 || i == 56) {
            return 1002;
        }
        if (i == 42 || i == 78 || i == 83) {
            return 1003;
        }
        if (i == 67) {
            return 1004;
        }
        if (i == 86) {
            return 1001;
        }
        return (i != 40 && i == 59) ? 1006 : 1005;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00d2 A[Catch: Exception -> 0x0156, TryCatch #0 {Exception -> 0x0156, blocks: (B:5:0x001b, B:7:0x002f, B:9:0x0035, B:24:0x007a, B:16:0x0047, B:18:0x0053, B:20:0x005f, B:22:0x0065, B:25:0x0091, B:48:0x00e5, B:51:0x0105, B:53:0x010f, B:55:0x0144, B:57:0x0149, B:59:0x0153, B:41:0x00c3, B:42:0x00c8, B:43:0x00cd, B:44:0x00d2, B:45:0x00d7, B:46:0x00dc, B:47:0x00e1), top: B:62:0x001b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static View d(iv3 iv3Var, Context context) {
        FrameLayout frameLayout;
        LogUtil.d("", "NativeType getAdUIView model " + iv3Var);
        View viewN = null;
        if (iv3Var != null && context != null) {
            try {
                NestAdData nestAdDataA = iv3Var.a();
                int iD = iv3Var.d();
                if (nestAdDataA != null && nestAdDataA.getAdSPStrategy()) {
                    nestAdDataA = SPCacheManager.INSTANCE.changeCheckMaxAd(nestAdDataA);
                    if ((iD == 42 || iD == 78 || iD == 83 || iD == 57 || iD == 56) && nestAdDataA != null && ((nestAdDataA.getAdType() == SDKAlias.CSJ.getType() || nestAdDataA.getAdType() == SDKAlias.LXAD.getType()) && nestAdDataA.getHasReportExpose())) {
                        LogUtil.d("", "NativeType getAdUIView getHasReportExpose error not allow scene " + iD);
                        return null;
                    }
                    LogUtil.d("", "NativeType getAdUIView changedAd " + nestAdDataA);
                    iv3Var.f(nestAdDataA);
                }
                LogUtil.d("", "NativeType getAdUIView scene " + iD);
                if (iD == 6) {
                    viewN = qv3.n(iv3Var, context);
                } else if (iD == 16) {
                    viewN = pv3.n(iv3Var, context);
                } else if (iD == 40) {
                    viewN = ov3.n(iv3Var, context);
                } else if (iD == 42) {
                    viewN = rv3.o(iv3Var, context);
                } else if (iD == 59) {
                    viewN = lv3.n(iv3Var, context);
                } else if (iD == 67) {
                    viewN = kv3.n(iv3Var, context);
                } else if (iD != 78 && iD != 83) {
                    if (iD == 56 || iD == 57) {
                        viewN = mv3.p(iv3Var, context);
                    }
                }
                LogUtil.d("", "NativeType getAdUIView adView " + viewN + "adData:" + nestAdDataA);
                if (viewN != null && nestAdDataA != null) {
                    View viewFindViewWithTag = viewN.findViewWithTag("nest_native_ui_root_layout");
                    if (viewFindViewWithTag instanceof ViewGroup) {
                        ViewGroup viewGroupWrapDecorationIfGDT = AdHelperFeed.INSTANCE.wrapDecorationIfGDT((ViewGroup) viewFindViewWithTag, nestAdDataA);
                        LogUtil.d("", "NativeType getAdUIView adRootLayout " + viewFindViewWithTag + " adRootLayout.getParent() " + viewFindViewWithTag.getParent() + " adRootLayoutNew " + viewGroupWrapDecorationIfGDT);
                        if (viewGroupWrapDecorationIfGDT instanceof ViewGroup) {
                            iv3Var.g(viewGroupWrapDecorationIfGDT);
                        }
                        if (viewGroupWrapDecorationIfGDT != viewFindViewWithTag && (frameLayout = (FrameLayout) viewN.findViewById(R$id.ad_root_parent_layout)) != null) {
                            frameLayout.addView(viewGroupWrapDecorationIfGDT);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return viewN;
    }
}
