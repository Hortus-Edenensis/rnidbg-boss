package com.wifi.ad.core.listener;

import com.wifi.ad.core.data.NestAdData;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u001e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\b\u0010\f\u001a\u00020\u0003H&¨\u0006\r"}, d2 = {"Lcom/wifi/ad/core/listener/DrawLoadListener;", "Lcom/wifi/ad/core/listener/BaseListener;", "onAdFailed", "", "errorCode", "", "message", "onAdLoaded", "providerType", "adList", "", "Lcom/wifi/ad/core/data/NestAdData;", "onStart", "core_release"}, k = 1, mv = {1, 1, 16})
public interface DrawLoadListener extends BaseListener {
    @Override // com.wifi.ad.core.listener.BaseListener
    void onAdFailed(String errorCode, String message);

    @Override // com.wifi.ad.core.listener.BaseListener
    void onAdLoaded(String providerType, List<NestAdData> adList);

    @Override // com.wifi.ad.core.listener.BaseListener
    void onStart();
}
