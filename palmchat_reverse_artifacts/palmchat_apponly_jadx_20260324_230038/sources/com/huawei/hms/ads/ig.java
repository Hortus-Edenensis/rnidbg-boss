package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.ImageInfo;
import com.huawei.openalliance.ad.inter.data.VideoInfo;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.ac;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ig extends ic<lm> implements it<lm> {
    public ig(Context context, lm lmVar) {
        Code(lmVar);
        this.V = context;
    }

    private void V(final ImageInfo imageInfo) {
        String strA;
        String strL;
        if (imageInfo == null) {
            return;
        }
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(imageInfo.Z());
        sourceParam.Code(52428800L);
        sourceParam.V(imageInfo.I());
        sourceParam.V(imageInfo.S());
        sourceParam.I(true);
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            strA = adContentData.a();
            strL = this.Code.L();
        } else {
            strA = null;
            strL = null;
        }
        ac.Code(this.V, sourceParam, strA, strL, new com.huawei.openalliance.ad.utils.aq() { // from class: com.huawei.hms.ads.ig.2
            @Override // com.huawei.openalliance.ad.utils.aq
            public void Code() {
                fh.I("NativeVideoP", "cover image load fail");
            }

            @Override // com.huawei.openalliance.ad.utils.aq
            public void Code(String str, final Drawable drawable) {
                ImageInfo imageInfo2 = imageInfo;
                if (imageInfo2 == null || !TextUtils.equals(str, imageInfo2.Z())) {
                    return;
                }
                com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.ig.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ((lm) ig.this.I()).Code(imageInfo, drawable);
                    }
                });
            }
        });
    }

    @Override // com.huawei.hms.ads.it
    public void Code(ImageInfo imageInfo) {
        if (imageInfo == null) {
            return;
        }
        V(imageInfo);
    }

    @Override // com.huawei.hms.ads.ic
    public String S() {
        return "NativeVideoP";
    }

    @Override // com.huawei.hms.ads.it
    public void Code(final VideoInfo videoInfo) {
        if (videoInfo == null) {
            return;
        }
        final boolean zCode = videoInfo.Code();
        String strV = videoInfo.V();
        if (TextUtils.isEmpty(strV) || !strV.startsWith(com.huawei.openalliance.ad.constant.ce.CONTENT.toString())) {
            fh.V("NativeVideoP", "check if video cached.");
            com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.ig.1
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable;
                    try {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(com.huawei.openalliance.ad.constant.be.E, videoInfo.V());
                            com.huawei.openalliance.ad.ipc.g.V(ig.this.V).Code(com.huawei.openalliance.ad.constant.s.i, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.ig.1.1
                                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                                    String data = callResult.getData();
                                    if (TextUtils.isEmpty(data) || !data.startsWith(com.huawei.openalliance.ad.constant.ce.CONTENT.toString())) {
                                        return;
                                    }
                                    videoInfo.V(data);
                                }
                            }, String.class);
                            runnable = new Runnable() { // from class: com.huawei.hms.ads.ig.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    fh.Code("NativeVideoP", "video path: %s", videoInfo.V());
                                    lm lmVar = (lm) ig.this.I();
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    lmVar.Code(videoInfo, zCode);
                                }
                            };
                        } catch (JSONException unused) {
                            fh.Code("NativeVideoP", "check video cache jsonEx");
                            runnable = new Runnable() { // from class: com.huawei.hms.ads.ig.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    fh.Code("NativeVideoP", "video path: %s", videoInfo.V());
                                    lm lmVar = (lm) ig.this.I();
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    lmVar.Code(videoInfo, zCode);
                                }
                            };
                        }
                        com.huawei.openalliance.ad.utils.bj.Code(runnable);
                    } catch (Throwable th) {
                        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.ig.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                fh.Code("NativeVideoP", "video path: %s", videoInfo.V());
                                lm lmVar = (lm) ig.this.I();
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                lmVar.Code(videoInfo, zCode);
                            }
                        });
                        throw th;
                    }
                }
            });
        } else {
            fh.V("NativeVideoP", "video is cached.");
            ((lm) I()).Code(videoInfo, zCode);
        }
    }

    @Override // com.huawei.hms.ads.it
    public void Code(com.huawei.openalliance.ad.inter.data.l lVar) {
        this.Code = lVar != null ? lVar.q() : null;
    }

    @Override // com.huawei.hms.ads.it
    public void Code(boolean z) {
        jk.Code(this.V, this.Code, z);
    }
}
