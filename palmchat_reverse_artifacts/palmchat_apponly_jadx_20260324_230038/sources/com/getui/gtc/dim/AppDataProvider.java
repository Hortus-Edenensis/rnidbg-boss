package com.getui.gtc.dim;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface AppDataProvider {
    Object getAppData(String str);

    void onDataFailed(String str, Throwable th);
}
