package com.beizi.fusion.c;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.ad.model.BeiZiLocation;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.model.AdPlusConfig;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.model.ResponseInfo;
import com.beizi.fusion.tool.ae;
import com.beizi.fusion.tool.ao;
import com.beizi.fusion.tool.x;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f4620a;

    public static void a(Context context, String str) {
        try {
            b(context.getApplicationContext(), str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void b(final Context context, String str) {
        if (f4620a) {
            return;
        }
        try {
            a(context);
            com.beizi.ad.b.a(context, str, new com.beizi.ad.c() { // from class: com.beizi.fusion.c.l.1
                @Override // com.beizi.ad.c
                public boolean a() {
                    return BeiZis.getCustomController() != null ? BeiZis.getCustomController().isCanUseLocation() : super.a();
                }

                @Override // com.beizi.ad.c
                public BeiZiLocation b() {
                    return BeiZis.getCustomController() != null ? BeiZis.getCustomController().getLocation() : super.b();
                }

                @Override // com.beizi.ad.c
                public boolean c() {
                    return BeiZis.getCustomController() != null ? !ae.a() && BeiZis.getCustomController().isCanUseOaid() : super.c();
                }

                @Override // com.beizi.ad.c
                public String d() {
                    try {
                        if (RequestInfo.getInstance(context).getDevInfo() != null) {
                            String oaid = RequestInfo.getInstance(context).getDevInfo().getOaid();
                            if (!TextUtils.isEmpty(oaid)) {
                                return oaid;
                            }
                            String customOaid = RequestInfo.getInstance(context).getCustomOaid();
                            if (!TextUtils.isEmpty(customOaid)) {
                                return customOaid;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return super.d();
                }
            });
            com.beizi.ad.b.b(x.a().a(context.getApplicationContext()));
            f4620a = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(Context context) {
        String strA;
        try {
            AdPlusConfig adPlusConfig = ResponseInfo.getInstance(context).getAdPlusConfig();
            if (adPlusConfig != null) {
                List<String> h5RedirectBlackList = adPlusConfig.getH5RedirectBlackList();
                if (h5RedirectBlackList == null || h5RedirectBlackList.size() <= 0) {
                    h5RedirectBlackList = new ArrayList<>();
                    h5RedirectBlackList.add("market://");
                }
                com.beizi.ad.b.a(h5RedirectBlackList);
            }
            if (adPlusConfig != null && !TextUtils.isEmpty(adPlusConfig.getAdUrl()) && adPlusConfig.getAdUrl().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                strA = adPlusConfig.getAdUrl();
            } else {
                strA = com.beizi.fusion.tool.d.a(BeiZis.getTransferProtocol() ? "aHR0cHM6Ly9hcGktaHRwLmJlaXppLmJpei9tYi9zZGswL2pzb24=" : "aHR0cDovL2FwaS5odHAuYWQtc2NvcGUuY29tLmNuOjQ1NjAwL21iL3NkazAvanNvbg==");
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
            }
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            com.beizi.ad.b.a(strA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            a(context, str);
            return com.beizi.ad.b.c(str2);
        }
        com.beizi.ad.internal.c.a().a(context);
        return new com.beizi.ad.v2.e.b().a(ao.a(), false);
    }
}
