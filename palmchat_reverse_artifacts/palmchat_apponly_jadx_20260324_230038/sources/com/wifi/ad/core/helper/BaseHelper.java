package com.wifi.ad.core.helper;

import androidx.annotation.NonNull;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lcom/wifi/ad/core/helper/BaseHelper;", "", "()V", "filterType", "", "", "", "radioMap", "", "adProviderType", "core_release"}, k = 1, mv = {1, 1, 16})
public abstract class BaseHelper {
    public final Map<String, Integer> filterType(@NonNull Map<String, Integer> radioMap, String adProviderType) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(radioMap);
        linkedHashMap.put(adProviderType, 0);
        return linkedHashMap;
    }
}
