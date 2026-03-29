package com.vivo.push.listener;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
interface IPushRequestListener<T, V> {
    void onFail(V v);

    void onSuccess(T t);
}
