package com.zenmen.palmchat.ad.model;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class GDTDownloadRespBean {
    GDTDataBean data;
    int ret;

    /* JADX INFO: compiled from: SearchBox */
    public static class GDTDataBean {
        String clickid;
        String dstlink;

        public String getClickid() {
            return this.clickid;
        }

        public String getDstlink() {
            return this.dstlink;
        }
    }

    public GDTDataBean getData() {
        return this.data;
    }
}
