package com.wifi.ad.core.listener;

import com.wifi.ad.core.data.NestAdData;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/wifi/ad/core/listener/DislikeListener;", "", "onDislikeClicked", "", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", "reason", "", "core_release"}, k = 1, mv = {1, 1, 16})
public interface DislikeListener {
    void onDislikeClicked(NestAdData nestAdData, String reason);
}
