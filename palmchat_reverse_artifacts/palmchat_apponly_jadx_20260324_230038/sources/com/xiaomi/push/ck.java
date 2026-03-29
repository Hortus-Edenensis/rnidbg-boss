package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ck {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final List<String> f207a = Arrays.asList(PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY, "002", "003", "004", "005");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Boolean f11473a = null;

    public static void a(String str, String str2) {
    }

    public static boolean a(Context context) {
        if (f11473a == null) {
            try {
                if (!j.m651a(context)) {
                    f11473a = Boolean.FALSE;
                }
                String strM766a = com.xiaomi.push.service.q.m766a(context);
                if (TextUtils.isEmpty(strM766a) || strM766a.length() < 3) {
                    f11473a = Boolean.FALSE;
                } else {
                    f11473a = Boolean.valueOf(f207a.contains(strM766a.substring(strM766a.length() - 3)));
                }
                a("Sampling statistical connection quality: " + f11473a);
            } catch (Throwable th) {
                f11473a = Boolean.FALSE;
                com.xiaomi.channel.commonutils.logger.b.c("Push-ConnectionQualityStatsHelper", "Determine sampling switch error: " + th);
            }
        }
        return f11473a.booleanValue();
    }

    public static void a(String str) {
        a("Push-ConnectionQualityStatsHelper", str);
    }
}
