package com.getui.gtc.a;

import android.text.TextUtils;
import com.getui.gtc.e.c;
import com.getui.gtc.i.d.b;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5679a;
    private boolean b = true;
    private long c = 10000;

    @Override // java.lang.Runnable
    public final void run() {
        Map<String, String> mapA = com.getui.gtc.f.c.a(com.heytap.mcssdk.constant.a.g, (com.getui.gtc.f.e) null);
        if (mapA != null && mapA.size() > 0) {
            try {
                if (mapA.containsKey("sdk.gtc.type301.enable")) {
                    this.b = Boolean.parseBoolean(mapA.get("sdk.gtc.type301.enable"));
                }
            } catch (Exception e) {
                com.getui.gtc.i.c.a.b(e);
            }
            try {
                if (mapA.containsKey("sdk.gtc.type301.interval")) {
                    this.c = Long.parseLong(mapA.get("sdk.gtc.type301.interval")) * 1000;
                }
            } catch (Exception e2) {
                com.getui.gtc.i.c.a.b(e2);
            }
        }
        if (!this.b) {
            com.getui.gtc.i.c.a.b("type 301 is not enabled");
            return;
        }
        String str = c.a.f5766a.f5765a.f5767a;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] strArrSplit = str.split("\n");
                if (System.currentTimeMillis() - new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).parse(strArrSplit[0].split("\\|")[0]).getTime() > com.igexin.push.f.b.d.b || strArrSplit.length > 300) {
                    c.a.f5766a.f5765a.d("");
                    com.getui.gtc.i.c.a.a("type 301 clean stored samples");
                }
            } catch (Exception e3) {
                com.getui.gtc.i.c.a.b("type 301 clean samples error: " + e3.toString());
            }
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        StringBuilder sb = new StringBuilder();
        sb.append(a.a(simpleDateFormat.format(new Date())));
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append(a.a(com.getui.gtc.c.b.d));
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append(a.a(com.getui.gtc.c.b.f5704a));
        sb.append("|android|");
        com.getui.gtc.i.d.b unused = b.C0345b.f5803a;
        Calendar calendar = Calendar.getInstance();
        double d = ((double) (calendar.get(15) + calendar.get(16))) / 3600000.0d;
        NumberFormat numberInstance = NumberFormat.getNumberInstance();
        numberInstance.setMaximumFractionDigits(2);
        sb.append(a.a(numberInstance.format(d)));
        String string = sb.toString();
        com.getui.gtc.e.d dVar = c.a.f5766a.f5765a;
        if (!TextUtils.isEmpty(string)) {
            if (!TextUtils.isEmpty(dVar.f5767a)) {
                string = dVar.f5767a + "\n" + string;
            }
            if (dVar.a(7, string)) {
                dVar.f5767a = string;
            }
        }
        this.f5679a = c.a.f5766a.f5765a.f5767a;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - c.a.f5766a.f5765a.c < this.c) {
                return;
            }
            com.getui.gtc.h.a.a(this.f5679a, 301);
            com.getui.gtc.e.d dVar2 = c.a.f5766a.f5765a;
            if (dVar2.a(6, jCurrentTimeMillis)) {
                dVar2.c = jCurrentTimeMillis;
            }
            c.a.f5766a.f5765a.d("");
        } catch (Exception e4) {
            com.getui.gtc.i.c.a.c("type 301 report error: " + e4.toString());
        }
    }
}
