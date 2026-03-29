package com.getui.gtc.a;

import android.annotation.TargetApi;
import android.os.Build;
import android.text.TextUtils;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.util.CommonUtil;
import com.getui.gtc.e.c;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.openalliance.ad.constant.x;
import com.zenmen.palmchat.ad.view.AdView;
import defpackage.ey6;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5681a;
    private boolean b = false;
    private long c = 86400000;
    private String[] d = {x.ad, "com.bbk.launcher2", "net.oneplus.launcher", "com.android.deskclock", "com.heytap.market", "com.oppo.market"};
    private String[] e = {"com.tencent.mm", "com.tencent.mobileqq", "com.eg.android.AlipayGphone", "com.jingdong.app.mall", "com.ss.android.article.news", "com.taobao.taobao", "com.tmall.wireless", "com.sankuai.meituan", "com.xunmeng.pinduoduo", AdView.DOUYIN};

    private String a() {
        try {
            StringBuilder sb = new StringBuilder();
            for (String str : this.d) {
                try {
                    sb.append(str + "#,");
                } catch (Throwable unused) {
                    com.getui.gtc.i.c.a.b(str + " not found");
                }
            }
            if (sb.toString().endsWith(",")) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.b(th);
            return "";
        }
    }

    @TargetApi(26)
    private String b() {
        File parentFile;
        if (Build.VERSION.SDK_INT < 26) {
            com.getui.gtc.i.c.a.a("type304 get hot info failed, api<26");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            File externalCacheDir = GtcProvider.context().getExternalCacheDir();
            File parentFile2 = (externalCacheDir == null || (parentFile = externalCacheDir.getParentFile()) == null) ? null : parentFile.getParentFile();
            if (parentFile2 == null) {
                return "";
            }
            for (String str : this.e) {
                try {
                    BasicFileAttributes attributes = Files.readAttributes(new File(parentFile2, str).toPath(), (Class<BasicFileAttributes>) ey6.a(), new LinkOption[0]);
                    sb.append(str + "#0#" + attributes.creationTime().toMillis() + "#" + attributes.lastAccessTime().toMillis());
                    sb.append(",");
                } catch (Throwable th) {
                    com.getui.gtc.i.c.a.b(th);
                }
            }
            if (sb.toString().endsWith(",")) {
                sb.deleteCharAt(sb.length() - 1);
            }
        } catch (Throwable th2) {
            com.getui.gtc.i.c.a.b(th2);
        }
        return sb.toString();
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, String> mapA = com.getui.gtc.f.c.a(com.heytap.mcssdk.constant.a.g, (com.getui.gtc.f.e) null);
            if (mapA != null && mapA.size() > 0) {
                try {
                    String str = mapA.get("sdk.gtc.type304.enable");
                    if (str != null) {
                        this.b = Boolean.parseBoolean(str);
                    }
                } catch (Exception e) {
                    com.getui.gtc.i.c.a.b(e);
                }
                try {
                    String str2 = mapA.get("sdk.gtc.type304.interval");
                    if (str2 != null) {
                        this.c = Long.parseLong(str2) * 1000;
                    }
                } catch (Exception e2) {
                    com.getui.gtc.i.c.a.b(e2);
                }
                try {
                    String str3 = mapA.get("sdk.gtc.type304.sys_al");
                    if (!TextUtils.isEmpty(str3) && !"none".equalsIgnoreCase(str3)) {
                        String[] strArrSplit = str3.split(",");
                        if (strArrSplit.length > 0) {
                            this.d = strArrSplit;
                            com.getui.gtc.i.c.a.a("type304 dyc sysApp:" + Arrays.toString(strArrSplit));
                        }
                    }
                } catch (Exception e3) {
                    com.getui.gtc.i.c.a.b(e3);
                }
                try {
                    String str4 = mapA.get("sdk.gtc.type304.hot_al");
                    if (!TextUtils.isEmpty(str4) && !"none".equalsIgnoreCase(str4)) {
                        String[] strArrSplit2 = str4.split(",");
                        if (strArrSplit2.length > 0) {
                            this.e = strArrSplit2;
                            com.getui.gtc.i.c.a.a("type304 dyc hotApp:" + Arrays.toString(strArrSplit2));
                        }
                    }
                } catch (Exception e4) {
                    com.getui.gtc.i.c.a.b(e4);
                }
            }
            if (!this.b) {
                com.getui.gtc.i.c.a.b("type 304 is not enabled");
                return;
            }
            if (CommonUtil.isAppDebugEnable()) {
                com.getui.gtc.i.c.a.b("type 304 is debug, disallow");
                return;
            }
            if (System.currentTimeMillis() - c.a.f5766a.f5765a.l < this.c) {
                return;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
            String str5 = a.a(simpleDateFormat.format(new Date())) + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + a.a(com.getui.gtc.c.b.d) + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + a.a(com.getui.gtc.c.b.f5704a) + "|android|" + GtcProvider.context().getPackageName() + "|GTC-3.2.16.0|" + a() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + b();
            this.f5681a = str5;
            try {
                com.getui.gtc.h.a.a(str5, 304);
                com.getui.gtc.e.d dVar = c.a.f5766a.f5765a;
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (dVar.a(16, jCurrentTimeMillis)) {
                    dVar.l = jCurrentTimeMillis;
                }
            } catch (Exception e5) {
                com.getui.gtc.i.c.a.c("type 304 report error: " + e5.toString());
            }
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.a("type 304", th);
        }
    }
}
