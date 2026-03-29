package com.getui.gtc.a;

import android.text.TextUtils;
import com.getui.gtc.base.util.ScheduleQueue;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f5656a = new AtomicBoolean(false);

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : str.contains(HiAnalyticsConstant.REPORT_VAL_SEPARATOR) ? str.replace(HiAnalyticsConstant.REPORT_VAL_SEPARATOR, "$") : str;
    }

    public static void a() {
        if (f5656a.getAndSet(true)) {
            return;
        }
        b[] bVarArr = {new d(), new e(), new f(), new g()};
        for (int i = 0; i < 4; i++) {
            ScheduleQueue.getInstance().addSchedule(bVarArr[i], 10000L);
        }
    }

    public static void a(int i) {
        if (i == 256) {
            c.a();
        }
    }
}
