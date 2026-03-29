package com.xiaomi.push;

import android.app.NotificationChannel;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.download.api.constant.BaseConstants;
import defpackage.i04;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class bh implements Runnable {
    private bh() {
    }

    public static void a(Context context) {
        if (context == null || !"com.xiaomi.xmsf".equals(context.getPackageName())) {
            return;
        }
        a aVar = new a(context);
        if (aVar.m206a()) {
            new Thread(new bh()).start();
            aVar.m205a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x018c  */
    /* JADX WARN: Type inference failed for: r10v10, types: [com.xiaomi.push.bg] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v7, types: [com.xiaomi.push.bg] */
    /* JADX WARN: Type inference failed for: r10v8, types: [com.xiaomi.push.bg] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v4, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r11v5, types: [com.xiaomi.push.bf, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r15v3, types: [com.xiaomi.push.bg, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r19v3 */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r23v0, types: [com.xiaomi.push.bh] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        bd bdVar;
        bd bdVar2;
        String str;
        String str2;
        bd bdVar3;
        Iterator<Map.Entry<String, ?>> it;
        ?? r18;
        ?? r11;
        List<NotificationChannel> listM709a;
        String str3;
        ?? r19;
        ?? bfVar;
        ?? r10;
        String str4 = "mipush_";
        String str5 = "com.xiaomi.xmsf";
        final Context contextM660a = C1401r.m660a();
        if (contextM660a != null) {
            bd bdVar4 = new bd();
            bc bcVar = new bc(50L, 1000L);
            try {
                Map<String, ?> all = C1401r.m660a().getSharedPreferences("pref_registered_pkg_names", 0).getAll();
                if (all == null || all.isEmpty()) {
                    bdVar = bdVar4;
                } else {
                    bdVar4.a(all.keySet().contains("com.xiaomi.xmsf") ? r10.size() - 1 : r10.size());
                    bg bgVar = new bg();
                    bgVar.put("c", bdVar4.m203a());
                    Set<Map.Entry<String, ?>> setEntrySet = all.entrySet();
                    bf bfVar2 = new bf();
                    Iterator<Map.Entry<String, ?>> it2 = setEntrySet.iterator();
                    ?? r102 = bgVar;
                    ?? r112 = bfVar2;
                    while (it2.hasNext()) {
                        Map.Entry<String, ?> next = it2.next();
                        final String key = next.getKey();
                        String str6 = (String) next.getValue();
                        if (!TextUtils.isEmpty(key)) {
                            try {
                                if (str5.equals(key) || TextUtils.isEmpty(str6)) {
                                    str = str4;
                                    str2 = str5;
                                    bdVar3 = bdVar4;
                                    it = it2;
                                    r10 = r102;
                                    bfVar = r112;
                                } else {
                                    ?? bgVar2 = new bg();
                                    bgVar2.put("a", str6);
                                    bgVar2.put("s", (String) bcVar.a(new Callable<String>() { // from class: com.xiaomi.push.bh.1
                                        @Override // java.util.concurrent.Callable
                                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                                        public String call() {
                                            return String.valueOf(com.xiaomi.push.service.a.a(contextM660a, key));
                                        }
                                    }));
                                    if (Build.VERSION.SDK_INT < 26 || (listM709a = com.xiaomi.push.service.af.a(contextM660a, key).m709a()) == null || listM709a.isEmpty()) {
                                        str = str4;
                                        str2 = str5;
                                        bdVar3 = bdVar4;
                                        it = it2;
                                        r18 = r102;
                                        r11 = r112;
                                    } else {
                                        bf bfVar3 = new bf();
                                        str2 = str5;
                                        it = it2;
                                        r18 = r102;
                                        bdVar4.b(listM709a.size());
                                        Iterator<NotificationChannel> it3 = listM709a.iterator();
                                        while (it3.hasNext()) {
                                            final NotificationChannel notificationChannelA = i04.a(it3.next());
                                            String id = notificationChannelA.getId();
                                            bg bgVar3 = new bg();
                                            Iterator<NotificationChannel> it4 = it3;
                                            bdVar2 = bdVar4;
                                            if (id.startsWith(str4)) {
                                                r19 = r112;
                                                try {
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append(str4);
                                                    sb.append(key);
                                                    str3 = str4;
                                                    sb.append("_");
                                                    String strReplace = id.replace(sb.toString(), "");
                                                    bgVar3.put("t", 1);
                                                    bgVar3.put("c", strReplace);
                                                } catch (Exception e) {
                                                    e = e;
                                                    bdVar = bdVar2;
                                                    a(bdVar, bcVar, e);
                                                }
                                            } else {
                                                str3 = str4;
                                                r19 = r112;
                                                if (id.startsWith("mipush|")) {
                                                    String strReplace2 = id.replace("mipush|" + key + HiAnalyticsConstant.REPORT_VAL_SEPARATOR, "");
                                                    bgVar3.put("t", 2);
                                                    bgVar3.put("c", strReplace2);
                                                }
                                            }
                                            bgVar3.put("s", (String) bcVar.a(new Callable() { // from class: com.xiaomi.push.bh.2
                                                @Override // java.util.concurrent.Callable
                                                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                                                public String call() {
                                                    return String.valueOf(com.xiaomi.push.service.f.a(contextM660a, key, notificationChannelA));
                                                }
                                            }));
                                            bfVar3.put(bgVar3);
                                            r112 = r19;
                                            it3 = it4;
                                            bdVar4 = bdVar2;
                                            str4 = str3;
                                        }
                                        str = str4;
                                        bdVar3 = bdVar4;
                                        bgVar2.put("c", bfVar3);
                                        r11 = r112;
                                    }
                                    r11.put(bgVar2);
                                    ?? r103 = r18;
                                    r103.put("d", r11);
                                    r10 = r103;
                                    bfVar = r11;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                bdVar2 = bdVar4;
                            }
                        }
                        if (r10.a() > 30720) {
                            bdVar3.m204a();
                            bdVar = bdVar3;
                            try {
                                bdVar.c(r10.a());
                                a(contextM660a, r10, bdVar);
                                bg bgVar4 = new bg();
                                bgVar4.put("c", bdVar.m203a());
                                r10 = bgVar4;
                                bfVar = new bf();
                            } catch (Exception e3) {
                                e = e3;
                            }
                        } else {
                            bdVar = bdVar3;
                        }
                        bdVar4 = bdVar;
                        str5 = str2;
                        it2 = it;
                        str4 = str;
                        r102 = r10;
                        r112 = bfVar;
                    }
                    bdVar = bdVar4;
                    if (r112.length() > 0) {
                        bdVar.m204a();
                        bdVar.c(r102.a());
                        a(contextM660a, r102, bdVar);
                    }
                }
                e = null;
            } catch (Exception e4) {
                e = e4;
                bdVar = bdVar4;
            }
            a(bdVar, bcVar, e);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SharedPreferences f11440a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private final String f152a = "dc_job_result_time_26";

        public a(Context context) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            this.f11440a = sharedPreferences;
            long j = sharedPreferences.getLong("dc_job_result_time_26", 0L);
            if (j <= 0 || j - System.currentTimeMillis() > 259200000) {
                this.f11440a.edit().putLong("dc_job_result_time_26", a()).apply();
            }
        }

        private long a() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Random random = new Random(jCurrentTimeMillis);
            return (((jCurrentTimeMillis / 86400000) + 1) * 86400000) + ((long) (random.nextInt(3) * BaseConstants.Time.DAY)) + ((long) random.nextInt(46800000));
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m206a() {
            return System.currentTimeMillis() - this.f11440a.getLong("dc_job_result_time_26", 0L) > 0;
        }

        private a() {
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public void m205a() {
            long j = this.f11440a.getLong("dc_job_result_time_26", 0L);
            long jCurrentTimeMillis = System.currentTimeMillis() - j;
            if (jCurrentTimeMillis >= 0) {
                this.f11440a.edit().putLong("dc_job_result_time_26", j + (((jCurrentTimeMillis / 259200000) + 1) * 259200000)).apply();
            }
        }
    }

    private void a(bd bdVar, bc bcVar, Exception exc) {
        HashMap map = new HashMap();
        String strM766a = com.xiaomi.push.service.q.m766a(C1401r.m660a());
        if (!TextUtils.isEmpty(strM766a)) {
            map.put(Constant.MAP_KEY_UUID, strM766a);
        }
        map.put("appCount", Long.valueOf(bdVar.m203a()));
        map.put("channels", Long.valueOf(bdVar.b()));
        map.put("packCount", Long.valueOf(bdVar.c()));
        map.put("totalSize", Long.valueOf(bdVar.d()));
        map.put("isBatch", Integer.valueOf(bdVar.a()));
        map.put("maxCallTime", Long.valueOf(bcVar.a()));
        map.put("minCallTime", Long.valueOf(bcVar.b()));
        map.put("callAvg", Long.valueOf(bcVar.c()));
        map.put("duration", Long.valueOf(bcVar.d()));
        if (exc != null) {
            map.put("exception", exc.toString());
        }
        eh.a().a("app_switch_upload", map);
    }

    private void a(Context context, bg bgVar, bd bdVar) {
        gj gjVar = new gj();
        gjVar.d("category_app_channel_info");
        gjVar.c("app_channel_info");
        gjVar.b(bgVar.toString());
        gjVar.a(false);
        gjVar.a(1L);
        gjVar.a("xmsf_channel");
        gjVar.b(System.currentTimeMillis());
        gjVar.g("com.xiaomi.xmsf");
        gjVar.e("com.xiaomi.xmsf");
        gjVar.f(com.xiaomi.push.service.az.a());
        com.xiaomi.push.service.ba.a(context, gjVar);
    }
}
