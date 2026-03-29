package com.wifi.ks.ad.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.wifi.ad.core.data.UnifiedDataAdapter;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.ks.ad.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rJ\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012H\u0016J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u0014\u001a\u00020\fH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/wifi/ks/ad/data/KsNativeDataAdapter;", "Lcom/wifi/ad/core/data/UnifiedDataAdapter;", "ad", "Lcom/kwad/sdk/api/KsNativeAd;", "context", "Landroid/content/Context;", "(Lcom/kwad/sdk/api/KsNativeAd;Landroid/content/Context;)V", "getAdIcon", "", "getAdLogo", "Landroid/graphics/Bitmap;", "getAdMode", "", "()Ljava/lang/Integer;", "getAdView", "Landroid/view/View;", "getDescription", "getImageList", "", "getInteractionType", "getRenderType", "getTitle", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class KsNativeDataAdapter implements UnifiedDataAdapter {
    private final KsNativeAd ad;
    private final Context context;

    public KsNativeDataAdapter(KsNativeAd ksNativeAd, Context context) {
        this.ad = ksNativeAd;
        this.context = context;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public String getAdIcon() {
        return this.ad.getAppIconUrl();
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public Bitmap getAdLogo() {
        return null;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public Integer getAdMode() {
        int materialType = this.ad.getMaterialType();
        if (materialType == 1) {
            return 4;
        }
        if (materialType == 2) {
            return 1;
        }
        if (materialType != 3) {
            return materialType != 8 ? 0 : 4;
        }
        return 3;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public View getAdView() {
        return this.ad.getVideoView(this.context, new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).dataFlowAutoStart(true).build());
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public String getDescription() {
        return this.ad.getAdDescription();
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public List<String> getImageList() {
        String imageUrl;
        String imageUrl2;
        ArrayList arrayList = new ArrayList();
        int materialType = this.ad.getMaterialType();
        if (materialType == 1) {
            KsImage videoCoverImage = this.ad.getVideoCoverImage();
            if (videoCoverImage != null && (imageUrl = videoCoverImage.getImageUrl()) != null) {
                arrayList.add(imageUrl);
            }
        } else if (materialType != 8) {
            List<KsImage> imageList = this.ad.getImageList();
            if (imageList != null) {
                for (KsImage it : imageList) {
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    String imageUrl3 = it.getImageUrl();
                    Intrinsics.checkExpressionValueIsNotNull(imageUrl3, "it.imageUrl");
                    arrayList.add(imageUrl3);
                }
            }
        } else {
            KsImage videoCoverImage2 = this.ad.getVideoCoverImage();
            if (videoCoverImage2 != null && (imageUrl2 = videoCoverImage2.getImageUrl()) != null) {
                arrayList.add(imageUrl2);
            }
        }
        return arrayList;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public Integer getInteractionType() {
        int interactionType = this.ad.getInteractionType();
        if (interactionType != 1) {
            return interactionType != 2 ? 0 : 2;
        }
        return 1;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public int getRenderType() {
        int i;
        List<KsImage> imageList;
        KsImage ksImage;
        int materialType = this.ad.getMaterialType();
        if (materialType == 1) {
            KsImage it = this.ad.getVideoCoverImage();
            if (it == null) {
                return 0;
            }
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            i = it.getWidth() >= it.getHeight() ? 0 : 1;
            WifiLog.d("KS H5Ad ad pictureWidth = " + it.getWidth() + " :::: pictureHeight + " + it.getHeight());
        } else if (materialType != 8) {
            List<KsImage> imageList2 = this.ad.getImageList();
            if ((imageList2 == null || imageList2.isEmpty()) || (imageList = this.ad.getImageList()) == null || (ksImage = imageList.get(0)) == null) {
                return 0;
            }
            i = ksImage.getWidth() >= ksImage.getHeight() ? 0 : 1;
            WifiLog.d("KS H5Ad ad pictureWidth = " + ksImage.getWidth() + " :::: pictureHeight + " + ksImage.getHeight());
        } else {
            KsImage it2 = this.ad.getVideoCoverImage();
            if (it2 == null) {
                return 0;
            }
            Intrinsics.checkExpressionValueIsNotNull(it2, "it");
            i = it2.getWidth() >= it2.getHeight() ? 0 : 1;
            WifiLog.d("KS H5Ad ad pictureWidth = " + it2.getWidth() + " :::: pictureHeight + " + it2.getHeight());
        }
        return i;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public String getTitle() {
        return this.ad.getAppName();
    }
}
