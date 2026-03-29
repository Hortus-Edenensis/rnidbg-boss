package com.wifi.ad.core.monitor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IWkConfigCallBack<T> {
    void dataError(String str);

    void dataSuccess(T t, int i, String str);
}
