package com.lantern.auth.http;

import android.content.Context;
import com.lantern.auth.server.WkServer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class HttpSign extends WkServer {
    public HttpSign(Context context) {
        super(context);
        this.mAppId = "self";
        this.mAESKey = "z$6fpnwYoG1BE&B6";
        this.mAESIV = "xvFCSwYoK48s3&C7";
        this.mMD5Key = "KAVY@Jjz%XTiUv#EiEuZdQcTLr1qWJQS";
    }
}
