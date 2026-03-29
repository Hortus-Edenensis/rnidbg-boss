package com.wifi.gdt.ad.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.wifi.ad.core.data.UnifiedDataAdapter;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.gdt.ad.BuildConfig;
import com.wifi.gdt.ad.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rJ\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012H\u0016J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u0014\u001a\u00020\fH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/wifi/gdt/ad/data/GdtNativeDataAdapter;", "Lcom/wifi/ad/core/data/UnifiedDataAdapter;", "context", "Landroid/content/Context;", "ad", "Lcom/qq/e/ads/nativ/NativeUnifiedADData;", "(Landroid/content/Context;Lcom/qq/e/ads/nativ/NativeUnifiedADData;)V", "getAdIcon", "", "getAdLogo", "Landroid/graphics/Bitmap;", "getAdMode", "", "()Ljava/lang/Integer;", "getAdView", "Landroid/view/View;", "getDescription", "getImageList", "", "getInteractionType", "getRenderType", "getTitle", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class GdtNativeDataAdapter implements UnifiedDataAdapter {
    private final NativeUnifiedADData ad;
    private final Context context;

    public GdtNativeDataAdapter(Context context, NativeUnifiedADData nativeUnifiedADData) {
        this.context = context;
        this.ad = nativeUnifiedADData;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public String getAdIcon() {
        return this.ad.getIconUrl();
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public Bitmap getAdLogo() {
        return null;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public Integer getAdMode() {
        int adPatternType = this.ad.getAdPatternType();
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
        return LayoutInflater.from(this.context).inflate(R.layout.layout_native_media_view, (ViewGroup) null, false);
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public String getDescription() {
        return this.ad.getDesc();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<String> getImageList() {
        ArrayList arrayList = new ArrayList();
        int adPatternType = this.ad.getAdPatternType();
        boolean z = true;
        if (adPatternType == 1 || adPatternType == 2) {
            String imgUrl = this.ad.getImgUrl();
            if (imgUrl != null && imgUrl.length() != 0) {
                z = false;
            }
            if (!z) {
                String imgUrl2 = this.ad.getImgUrl();
                Intrinsics.checkExpressionValueIsNotNull(imgUrl2, "ad.imgUrl");
                arrayList.add(imgUrl2);
            }
        } else if (adPatternType == 3) {
            List<String> imgList = this.ad.getImgList();
            if (imgList != null) {
                for (String it : imgList) {
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    arrayList.add(it);
                }
            }
        } else if (adPatternType == 4) {
        }
        return arrayList;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public Integer getInteractionType() {
        return this.ad.isAppAd() ? 1 : 2;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public int getRenderType() {
        int i = this.ad.getPictureWidth() > this.ad.getPictureHeight() ? 0 : 1;
        WifiLog.d("GDT H5Ad ad pictureWidth = " + this.ad.getPictureWidth() + " :::: pictureHeight + " + this.ad.getPictureHeight());
        return i;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public String getTitle() {
        return this.ad.getTitle();
    }
}
