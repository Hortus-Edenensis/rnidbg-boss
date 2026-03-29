package com.wifi.csj.ad.data;

import android.graphics.Bitmap;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.wifi.ad.core.data.UnifiedDataAdapter;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.csj.ad.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u000f\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000bJ\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0010H\u0016J\u000f\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000bJ\b\u0010\u0012\u001a\u00020\nH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/wifi/csj/ad/data/CsjFeedDataAdapter;", "Lcom/wifi/ad/core/data/UnifiedDataAdapter;", "ad", "Lcom/bytedance/sdk/openadsdk/TTFeedAd;", "(Lcom/bytedance/sdk/openadsdk/TTFeedAd;)V", "getAdIcon", "", "getAdLogo", "Landroid/graphics/Bitmap;", "getAdMode", "", "()Ljava/lang/Integer;", "getAdView", "Landroid/view/View;", "getDescription", "getImageList", "", "getInteractionType", "getRenderType", "getTitle", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class CsjFeedDataAdapter implements UnifiedDataAdapter {
    private TTFeedAd ad;

    public CsjFeedDataAdapter(TTFeedAd tTFeedAd) {
        this.ad = tTFeedAd;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public String getAdIcon() {
        TTImage icon = this.ad.getIcon();
        if (icon != null) {
            return icon.getImageUrl();
        }
        return null;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public Bitmap getAdLogo() {
        return this.ad.getAdLogo();
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public Integer getAdMode() {
        int imageMode = this.ad.getImageMode();
        if (imageMode == 2) {
            return 2;
        }
        if (imageMode == 3) {
            return 1;
        }
        if (imageMode == 4) {
            return 3;
        }
        if (imageMode != 5) {
            return imageMode != 15 ? 0 : 5;
        }
        return 4;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public View getAdView() {
        return this.ad.getAdView();
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public String getDescription() {
        return this.ad.getDescription();
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public List<String> getImageList() {
        String imageUrl;
        ArrayList arrayList = new ArrayList();
        int imageMode = this.ad.getImageMode();
        if (imageMode == 5 || imageMode == 15) {
            TTImage videoCoverImage = this.ad.getVideoCoverImage();
            if (videoCoverImage != null && (imageUrl = videoCoverImage.getImageUrl()) != null) {
                arrayList.add(imageUrl);
            }
        } else {
            List<TTImage> imageList = this.ad.getImageList();
            if (imageList != null) {
                for (TTImage it : imageList) {
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    String imageUrl2 = it.getImageUrl();
                    Intrinsics.checkExpressionValueIsNotNull(imageUrl2, "it.imageUrl");
                    arrayList.add(imageUrl2);
                }
            }
        }
        return arrayList;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public Integer getInteractionType() {
        int interactionType = this.ad.getInteractionType();
        if (interactionType == 2) {
            return 2;
        }
        if (interactionType == 3) {
            return 3;
        }
        if (interactionType != 4) {
            return interactionType != 5 ? 0 : 4;
        }
        return 1;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public int getRenderType() {
        int i;
        List<TTImage> imageList;
        TTImage tTImage;
        int imageMode = this.ad.getImageMode();
        if (imageMode == 5 || imageMode == 15) {
            TTImage videoCoverImage = this.ad.getVideoCoverImage();
            if (videoCoverImage == null) {
                return 0;
            }
            i = videoCoverImage.getWidth() >= videoCoverImage.getHeight() ? 0 : 1;
            WifiLog.d("CSJ H5Ad ad pictureWidth = " + videoCoverImage.getWidth() + " :::: pictureHeight + " + videoCoverImage.getHeight());
        } else {
            List<TTImage> imageList2 = this.ad.getImageList();
            if ((imageList2 == null || imageList2.isEmpty()) || (imageList = this.ad.getImageList()) == null || (tTImage = imageList.get(0)) == null) {
                return 0;
            }
            i = tTImage.getWidth() >= tTImage.getHeight() ? 0 : 1;
            WifiLog.d("KS H5Ad ad pictureWidth = " + tTImage.getWidth() + " :::: pictureHeight + " + tTImage.getHeight());
        }
        return i;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public String getTitle() {
        return this.ad.getTitle();
    }
}
