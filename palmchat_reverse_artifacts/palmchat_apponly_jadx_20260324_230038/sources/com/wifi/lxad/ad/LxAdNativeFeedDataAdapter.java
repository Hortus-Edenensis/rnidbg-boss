package com.wifi.lxad.ad;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.wifi.ad.core.data.UnifiedDataAdapter;
import com.wifi.adsdk.entity.SingleImage;
import com.wifi.adsdk.nativefeed.LxNativeFeedAd;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u000f\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000eJ\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013H\u0016J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u0015\u001a\u00020\rH\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/wifi/lxad/ad/LxAdNativeFeedDataAdapter;", "Lcom/wifi/ad/core/data/UnifiedDataAdapter;", "ad", "Lcom/wifi/adsdk/nativefeed/LxNativeFeedAd;", "context", "Landroid/content/Context;", "(Lcom/wifi/adsdk/nativefeed/LxNativeFeedAd;Landroid/content/Context;)V", "mContext", "getAdIcon", "", "getAdLogo", "Landroid/graphics/Bitmap;", "getAdMode", "", "()Ljava/lang/Integer;", "getAdView", "Landroid/view/View;", "getDescription", "getImageList", "", "getInteractionType", "getRenderType", "getTitle", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class LxAdNativeFeedDataAdapter implements UnifiedDataAdapter {
    private LxNativeFeedAd ad;
    private Context mContext;

    public LxAdNativeFeedDataAdapter(LxNativeFeedAd lxNativeFeedAd, Context context) {
        this.ad = lxNativeFeedAd;
        this.mContext = context;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public String getAdIcon() {
        return this.ad.getAppIcon();
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public Bitmap getAdLogo() {
        return null;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public Integer getAdMode() {
        int materialType = this.ad.getMaterialType();
        int i = 1;
        if (materialType != 1) {
            return materialType != 3 ? 0 : 4;
        }
        if (this.ad.getImageList() != null && this.ad.getImageList().size() >= 3) {
            i = 3;
        }
        return Integer.valueOf(i);
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public View getAdView() {
        return this.ad.getVideoView(this.mContext);
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public String getDescription() {
        return this.ad.getDescription();
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public List<String> getImageList() {
        ArrayList arrayList = new ArrayList();
        if (this.ad.getMaterialType() == 3) {
            if (!TextUtils.isEmpty(this.ad.getVideoImgUrl())) {
                String videoImgUrl = this.ad.getVideoImgUrl();
                Intrinsics.checkExpressionValueIsNotNull(videoImgUrl, "ad.videoImgUrl");
                arrayList.add(videoImgUrl);
            }
        } else if (this.ad.getImageList() != null) {
            List<SingleImage> imageList = this.ad.getImageList();
            if (imageList == null) {
                Intrinsics.throwNpe();
            }
            int size = imageList.size();
            for (int i = 0; i < size; i++) {
                SingleImage singleImage = this.ad.getImageList().get(i);
                Intrinsics.checkExpressionValueIsNotNull(singleImage, "ad.imageList[i]");
                String url = singleImage.getUrl();
                Intrinsics.checkExpressionValueIsNotNull(url, "ad.imageList[i].url");
                arrayList.add(url);
            }
        } else if (this.ad.getSingleImage() != null) {
            SingleImage singleImage2 = this.ad.getSingleImage();
            Intrinsics.checkExpressionValueIsNotNull(singleImage2, "ad.singleImage");
            String url2 = singleImage2.getUrl();
            Intrinsics.checkExpressionValueIsNotNull(url2, "ad.singleImage.url");
            arrayList.add(url2);
        }
        return arrayList;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public Integer getInteractionType() {
        return this.ad.isDownloadAd() ? 1 : 0;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public int getRenderType() {
        return this.ad.getMaterialType() == 3 ? this.ad.getVideoWidth() >= this.ad.getVideoHeight() ? 0 : 1 : this.ad.getMaterialWidth() >= this.ad.getMaterialHeight() ? 0 : 1;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public String getTitle() {
        return this.ad.getTitle();
    }
}
