package com.heytap.msp.mobad.api.listener;

import com.heytap.msp.mobad.api.params.INativeAdvanceData;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface INativeAdvanceLoadListener {
    void onAdFailed(int i, String str);

    void onAdSuccess(List<INativeAdvanceData> list);
}
