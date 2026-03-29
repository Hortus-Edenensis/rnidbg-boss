package com.zenmen.palmchat.ad.model;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public interface IGetGDTDownloadUrlListener {
    void onReceiveGDTDownloadUrl(GDTDownloadRespBean gDTDownloadRespBean);

    void onReceiverError(Exception exc);
}
