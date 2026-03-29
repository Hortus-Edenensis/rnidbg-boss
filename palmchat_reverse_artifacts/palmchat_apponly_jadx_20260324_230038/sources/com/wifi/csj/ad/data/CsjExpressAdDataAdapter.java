package com.wifi.csj.ad.data;

import android.graphics.Bitmap;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.wifi.ad.core.data.UnifiedDataAdapter;
import com.wifi.csj.ad.BuildConfig;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u000f\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000bJ\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0010H\u0016J\u000f\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000bJ\b\u0010\u0012\u001a\u00020\nH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/wifi/csj/ad/data/CsjExpressAdDataAdapter;", "Lcom/wifi/ad/core/data/UnifiedDataAdapter;", "ad", "Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;", "(Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;)V", "getAdIcon", "", "getAdLogo", "Landroid/graphics/Bitmap;", "getAdMode", "", "()Ljava/lang/Integer;", "getAdView", "Landroid/view/View;", "getDescription", "getImageList", "", "getInteractionType", "getRenderType", "getTitle", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class CsjExpressAdDataAdapter implements UnifiedDataAdapter {
    private TTNativeExpressAd ad;

    public CsjExpressAdDataAdapter(TTNativeExpressAd tTNativeExpressAd) {
        this.ad = tTNativeExpressAd;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public String getAdIcon() {
        return null;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public Bitmap getAdLogo() {
        return null;
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
        if (imageMode != 4) {
            return imageMode != 5 ? 0 : 4;
        }
        return 3;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public View getAdView() {
        return this.ad.getExpressAdView();
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public String getDescription() {
        return null;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public List<String> getImageList() {
        return null;
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
        return 0;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public String getTitle() {
        return null;
    }
}
