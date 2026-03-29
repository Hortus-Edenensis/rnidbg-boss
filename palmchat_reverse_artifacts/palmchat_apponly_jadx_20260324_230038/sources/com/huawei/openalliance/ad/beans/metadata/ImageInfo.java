package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.constant.bh;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@DataKeep
public class ImageInfo implements Serializable {
    private static final long serialVersionUID = 5884357961234973073L;
    private int checkSha256Flag;
    private String origUrl;
    private String sha256;

    @com.huawei.openalliance.ad.annotations.a
    private String url;
    private int width = 0;
    private int height = 0;
    private String imageType = bh.Code;
    private int fileSize = 0;

    public int B() {
        return this.height;
    }

    public int C() {
        return this.fileSize;
    }

    public String Code() {
        return this.sha256;
    }

    public String F() {
        return this.origUrl;
    }

    public String I() {
        return this.url;
    }

    public int S() {
        return this.checkSha256Flag;
    }

    public String V() {
        return this.imageType;
    }

    public int Z() {
        return this.width;
    }
}
