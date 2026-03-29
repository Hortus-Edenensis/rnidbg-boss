package com.vivo.push.listener;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IPushQueryActionListener extends IPushRequestListener<String, Integer> {
    @Override // com.vivo.push.listener.IPushRequestListener
    /* synthetic */ void onFail(Integer num);

    @Override // com.vivo.push.listener.IPushRequestListener
    /* synthetic */ void onSuccess(String str);
}
