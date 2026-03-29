package com.wifi.feisuo.ad;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.wifi.ad.core.data.UnifiedDataAdapter;
import com.zm.fissionsdk.api.FissionVideoOption;
import com.zm.fissionsdk.api.interfaces.IFissionNative;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u000f\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000eJ\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013H\u0016J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u0015\u001a\u00020\rH\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/wifi/feisuo/ad/FeiSuoFeedDataAdapter;", "Lcom/wifi/ad/core/data/UnifiedDataAdapter;", "ad", "Lcom/zm/fissionsdk/api/interfaces/IFissionNative;", "context", "Landroid/content/Context;", "(Lcom/zm/fissionsdk/api/interfaces/IFissionNative;Landroid/content/Context;)V", "mContext", "getAdIcon", "", "getAdLogo", "Landroid/graphics/Bitmap;", "getAdMode", "", "()Ljava/lang/Integer;", "getAdView", "Landroid/view/View;", "getDescription", "getImageList", "", "getInteractionType", "getRenderType", "getTitle", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class FeiSuoFeedDataAdapter implements UnifiedDataAdapter {
    private IFissionNative ad;
    private Context mContext;

    public FeiSuoFeedDataAdapter(IFissionNative iFissionNative, Context context) {
        this.ad = iFissionNative;
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
        if (materialType == 2) {
            return 1;
        }
        if (materialType != 3) {
            return (materialType == 4 || materialType == 7) ? 4 : 0;
        }
        return 3;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public View getAdView() {
        return this.ad.getVideoView(this.mContext, new FissionVideoOption.Builder().setVideoMute(true).setAutoPlayPolicy(3).setShowEndCard(false).setVideoReplay(false).setTheme(1).setScaleType(1).build());
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public String getDescription() {
        return this.ad.getDesc();
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public List<String> getImageList() {
        return this.ad.getImageList();
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public Integer getInteractionType() {
        int interactionType = this.ad.getInteractionType();
        if (interactionType == 1) {
            return 3;
        }
        if (interactionType != 3) {
            return interactionType != 4 ? 0 : 1;
        }
        return 2;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public int getRenderType() {
        return this.ad.getMaterialWidth() >= this.ad.getMaterialHeight() ? 0 : 1;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public String getTitle() {
        return this.ad.getTitle();
    }
}
