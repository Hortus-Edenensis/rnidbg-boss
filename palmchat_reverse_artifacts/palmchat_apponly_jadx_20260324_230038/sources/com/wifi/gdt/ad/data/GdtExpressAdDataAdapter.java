package com.wifi.gdt.ad.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.pi.AdData;
import com.wifi.ad.core.data.UnifiedDataAdapter;
import com.wifi.gdt.ad.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rJ\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012H\u0016J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u0014\u001a\u00020\fH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/wifi/gdt/ad/data/GdtExpressAdDataAdapter;", "Lcom/wifi/ad/core/data/UnifiedDataAdapter;", "context", "Landroid/content/Context;", "ad", "Lcom/qq/e/ads/nativ/NativeExpressADView;", "(Landroid/content/Context;Lcom/qq/e/ads/nativ/NativeExpressADView;)V", "getAdIcon", "", "getAdLogo", "Landroid/graphics/Bitmap;", "getAdMode", "", "()Ljava/lang/Integer;", "getAdView", "Landroid/view/View;", "getDescription", "getImageList", "", "getInteractionType", "getRenderType", "getTitle", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class GdtExpressAdDataAdapter implements UnifiedDataAdapter {
    private final NativeExpressADView ad;
    private final Context context;

    public GdtExpressAdDataAdapter(Context context, NativeExpressADView nativeExpressADView) {
        this.context = context;
        this.ad = nativeExpressADView;
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
        AdData boundData = this.ad.getBoundData();
        Intrinsics.checkExpressionValueIsNotNull(boundData, "ad.boundData");
        int adPatternType = boundData.getAdPatternType();
        if (adPatternType != 1) {
            if (adPatternType == 2) {
                return 4;
            }
            if (adPatternType == 3) {
                return 1;
            }
            if (adPatternType != 4) {
                return 0;
            }
        }
        return 1;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public View getAdView() {
        return this.ad;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public String getDescription() {
        AdData boundData = this.ad.getBoundData();
        Intrinsics.checkExpressionValueIsNotNull(boundData, "ad.boundData");
        return boundData.getDesc();
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public List<String> getImageList() {
        return null;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public Integer getInteractionType() {
        return null;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public int getRenderType() {
        return 0;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public String getTitle() {
        AdData boundData = this.ad.getBoundData();
        Intrinsics.checkExpressionValueIsNotNull(boundData, "ad.boundData");
        return boundData.getTitle();
    }
}
