package com.wifi.ad.core.utils;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.random.Random;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007J\u0006\u0010\t\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lcom/wifi/ad/core/utils/AdRandomUtil;", "", "()V", "getRandomAdProvider", "", "radio", "radioMap", "", "", "getRequestId", "core_release"}, k = 1, mv = {1, 1, 16})
public final class AdRandomUtil {
    public static final AdRandomUtil INSTANCE = new AdRandomUtil();

    private AdRandomUtil() {
    }

    public final String getRandomAdProvider(@NonNull Map<String, Integer> radioMap) {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = radioMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            sb.append(((String) entry.getKey()) + ':' + ((Number) entry.getValue()).intValue());
            sb.append(",");
            int iIntValue = ((Number) entry.getValue()).intValue();
            for (int i = 0; i < iIntValue; i++) {
                arrayList.add(entry.getKey());
            }
        }
        LogExtKt.logi$default("提供商比例：" + ((Object) sb), null, 1, null);
        if (arrayList.isEmpty()) {
            return null;
        }
        String str = (String) arrayList.get(RangesKt___RangesKt.random(RangesKt___RangesKt.until(0, arrayList.size()), Random.INSTANCE));
        LogExtKt.logi$default("随机到的广告: " + str, null, 1, null);
        return str;
    }

    public final String getRequestId() {
        String string;
        java.util.Random random = new java.util.Random();
        random.nextInt();
        int iNextInt = random.nextInt(999);
        if (iNextInt / 100 >= 1) {
            string = String.valueOf(iNextInt);
        } else if (iNextInt / 10 >= 1) {
            StringBuilder sb = new StringBuilder();
            sb.append('0');
            sb.append(iNextInt);
            string = sb.toString();
        } else {
            string = "00" + iNextInt;
        }
        return String.valueOf(System.currentTimeMillis()) + string;
    }

    public final String getRandomAdProvider(@NonNull String radio) {
        LogExtKt.logi$default("广告提供商的比例：" + radio, null, 1, null);
        ArrayList arrayList = new ArrayList();
        Iterator it = StringsKt__StringsKt.split$default((CharSequence) radio, new String[]{","}, false, 0, 6, (Object) null).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            if (str.length() == 0) {
                break;
            }
            List listSplit$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{":"}, false, 0, 6, (Object) null);
            if (listSplit$default.size() != 2) {
                break;
            }
            String str2 = (String) listSplit$default.get(0);
            String str3 = (String) listSplit$default.get(1);
            if (str2.length() == 0) {
                break;
            }
            if (str3.length() == 0) {
                break;
            }
            Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str3);
            int iIntValue = intOrNull != null ? intOrNull.intValue() : 0;
            for (int i = 0; i < iIntValue; i++) {
                arrayList.add(str2);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        String str4 = (String) arrayList.get(RangesKt___RangesKt.random(RangesKt___RangesKt.until(0, arrayList.size()), Random.INSTANCE));
        LogExtKt.logi$default("随机到的广告: " + str4, null, 1, null);
        return str4;
    }
}
