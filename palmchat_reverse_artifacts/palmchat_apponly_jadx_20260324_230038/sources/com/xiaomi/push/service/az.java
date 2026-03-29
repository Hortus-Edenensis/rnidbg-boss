package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C1401r;
import com.xiaomi.push.gi;
import com.xiaomi.push.gj;
import com.xiaomi.push.gp;
import com.xiaomi.push.he;
import com.xiaomi.push.hp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class az {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f11742a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static SimpleDateFormat f964a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static AtomicLong f965a = new AtomicLong(0);

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f964a = simpleDateFormat;
        f11742a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static synchronized String a() {
        String str;
        str = f964a.format(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.equals(f11742a, str)) {
            f965a.set(0L);
            f11742a = str;
        }
        return str + "-" + f965a.incrementAndGet();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<he> a(List<gj> list, String str, String str2, int i) {
        int length;
        if (list == null) {
            com.xiaomi.channel.commonutils.logger.b.d("requests can not be null in TinyDataHelper.transToThriftObj().");
            return null;
        }
        if (list.size() == 0) {
            com.xiaomi.channel.commonutils.logger.b.d("requests.length is 0 in TinyDataHelper.transToThriftObj().");
            return null;
        }
        ArrayList<he> arrayList = new ArrayList<>();
        gi giVar = new gi();
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            gj gjVar = list.get(i3);
            if (gjVar != null) {
                if (gjVar.m488a() == null || !gjVar.m488a().containsKey("item_size")) {
                    length = 0;
                } else {
                    String str3 = gjVar.m488a().get("item_size");
                    if (!TextUtils.isEmpty(str3)) {
                        try {
                            length = Integer.parseInt(str3);
                        } catch (Exception unused) {
                            length = 0;
                        }
                        if (gjVar.m488a().size() != 1) {
                            gjVar.a((Map<String, String>) null);
                        } else {
                            gjVar.m488a().remove("item_size");
                        }
                    } else {
                        length = 0;
                        if (gjVar.m488a().size() != 1) {
                        }
                    }
                }
                if (length <= 0) {
                    length = hp.a(gjVar).length;
                }
                if (length > i) {
                    com.xiaomi.channel.commonutils.logger.b.d("TinyData is too big, ignore upload request item:" + gjVar.d());
                } else {
                    if (i2 + length > i) {
                        arrayList.add(a(str, str2, giVar));
                        giVar = new gi();
                        i2 = 0;
                    }
                    giVar.a(gjVar);
                    i2 += length;
                }
            }
        }
        if (giVar.a() != 0) {
            arrayList.add(a(str, str2, giVar));
        }
        return arrayList;
    }

    private static he a(String str, String str2, gi giVar) {
        return new he("-1", false).d(str).b(str2).a(com.xiaomi.push.w.a(hp.a(giVar))).c(gp.UploadTinyData.f535a);
    }

    public static boolean a(gj gjVar, boolean z) {
        if (gjVar == null) {
            com.xiaomi.channel.commonutils.logger.b.m74a("item is null, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (!z && TextUtils.isEmpty(gjVar.f507a)) {
            com.xiaomi.channel.commonutils.logger.b.m74a("item.channel is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (TextUtils.isEmpty(gjVar.f514d)) {
            com.xiaomi.channel.commonutils.logger.b.m74a("item.category is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (TextUtils.isEmpty(gjVar.f513c)) {
            com.xiaomi.channel.commonutils.logger.b.m74a("item.name is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (!com.xiaomi.push.bb.m201a(gjVar.f514d)) {
            com.xiaomi.channel.commonutils.logger.b.m74a("item.category can only contain ascii char, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (!com.xiaomi.push.bb.m201a(gjVar.f513c)) {
            com.xiaomi.channel.commonutils.logger.b.m74a("item.name can only contain ascii char, verfiy ClientUploadDataItem failed.");
            return true;
        }
        String str = gjVar.f512b;
        if (str == null || str.length() <= 30720) {
            return false;
        }
        com.xiaomi.channel.commonutils.logger.b.m74a("item.data is too large(" + gjVar.f512b.length() + "), max size for data is 30720 , verfiy ClientUploadDataItem failed.");
        return true;
    }

    public static void a(Context context, String str, String str2, long j, String str3) {
        gj gjVar = new gj();
        gjVar.d(str);
        gjVar.c(str2);
        gjVar.a(j);
        gjVar.b(str3);
        gjVar.a("push_sdk_channel");
        gjVar.g(context.getPackageName());
        gjVar.e(context.getPackageName());
        gjVar.a(true);
        gjVar.b(System.currentTimeMillis());
        gjVar.f(a());
        ba.a(context, gjVar);
    }

    public static boolean a(String str) {
        return !C1401r.m664b() || Constants.HYBRID_PACKAGE_NAME.equals(str);
    }
}
