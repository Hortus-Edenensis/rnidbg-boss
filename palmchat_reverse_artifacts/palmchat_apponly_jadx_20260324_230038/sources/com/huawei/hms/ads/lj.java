package com.huawei.hms.ads;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.SdkListener;
import com.sina.weibo.sdk.openapi.WBAPIFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class lj implements la {
    private static final int B = 110;
    private static final String C = "#%s# %s";
    private static final String Code = "WeiBoShare";
    private static final Integer F = 100;
    private static final int I = 32768;
    private static final String L = "";
    private static final String S = "com.sina.weibo.sdk.auth.AuthInfo";
    private static final int V = 5242880;
    private static final int Z = 30;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6600a = "";
    private Boolean D = Boolean.TRUE;

    private static String Code(le leVar) {
        return String.format(C, lh.Code(leVar.V(), 30), lh.Code(leVar.I(), 110));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(Activity activity, le leVar, IWBAPI iwbapi) {
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        Code(leVar, weiboMultiMessage);
        Code(BitmapFactory.decodeStream(new ByteArrayInputStream(lh.Code(activity, leVar, 5242880))), weiboMultiMessage);
        Code(leVar, BitmapFactory.decodeStream(new ByteArrayInputStream(lh.Code(activity, leVar, 32768))), weiboMultiMessage);
        iwbapi.shareMessage(activity, weiboMultiMessage, true);
    }

    @Override // com.huawei.hms.ads.la
    public void Code(Activity activity, le leVar, lg lgVar) {
        fh.V(Code, "start WeiBo share");
        IWBAPI iwbapiCreateWBAPI = WBAPIFactory.createWBAPI(activity);
        iwbapiCreateWBAPI.setLoggerEnable(true);
        AuthInfo authInfo = new AuthInfo(activity, lgVar.Code(), "", "");
        if (!this.D.booleanValue()) {
            V(activity, leVar, iwbapiCreateWBAPI);
        } else {
            Code(activity, leVar, iwbapiCreateWBAPI, authInfo);
            this.D = Boolean.FALSE;
        }
    }

    private static void Code(final Activity activity, final le leVar, final IWBAPI iwbapi, AuthInfo authInfo) {
        iwbapi.registerApp(activity, authInfo, new SdkListener() { // from class: com.huawei.hms.ads.lj.1
            public void onInitSuccess() {
                lj.V(activity, leVar, iwbapi);
            }

            public void onInitFailure(Exception exc) {
            }
        });
    }

    private static void Code(Bitmap bitmap, WeiboMultiMessage weiboMultiMessage) {
        ImageObject imageObject = new ImageObject();
        imageObject.setImageData(bitmap);
        weiboMultiMessage.imageObject = imageObject;
    }

    private static void Code(le leVar, Bitmap bitmap, WeiboMultiMessage weiboMultiMessage) {
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.actionUrl = leVar.Z();
        webpageObject.identify = UUID.randomUUID().toString();
        webpageObject.defaultText = "分享网页";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, F.intValue(), byteArrayOutputStream);
            webpageObject.thumbData = byteArrayOutputStream.toByteArray();
        } finally {
            try {
            } catch (Throwable th) {
            }
        }
        com.huawei.openalliance.ad.utils.bb.Code(byteArrayOutputStream);
        weiboMultiMessage.mediaObject = webpageObject;
    }

    private static void Code(le leVar, WeiboMultiMessage weiboMultiMessage) {
        TextObject textObject = new TextObject();
        textObject.text = Code(leVar);
        weiboMultiMessage.textObject = textObject;
    }

    @Override // com.huawei.hms.ads.la
    public boolean Code() {
        return lh.Code(S);
    }
}
