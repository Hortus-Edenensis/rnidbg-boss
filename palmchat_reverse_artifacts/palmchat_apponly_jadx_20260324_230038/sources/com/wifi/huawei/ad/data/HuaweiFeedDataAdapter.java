package com.wifi.huawei.ad.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.ads.Image;
import com.huawei.hms.ads.VideoOperator;
import com.huawei.hms.ads.nativead.NativeAd;
import com.wifi.ad.core.data.UnifiedDataAdapter;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.huawei.ad.BuildConfig;
import com.wifi.huawei.ad.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rJ\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012H\u0016J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u0014\u001a\u00020\fH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/wifi/huawei/ad/data/HuaweiFeedDataAdapter;", "Lcom/wifi/ad/core/data/UnifiedDataAdapter;", "ad", "Lcom/huawei/hms/ads/nativead/NativeAd;", "context", "Landroid/content/Context;", "(Lcom/huawei/hms/ads/nativead/NativeAd;Landroid/content/Context;)V", "getAdIcon", "", "getAdLogo", "Landroid/graphics/Bitmap;", "getAdMode", "", "()Ljava/lang/Integer;", "getAdView", "Landroid/view/View;", "getDescription", "getImageList", "", "getInteractionType", "getRenderType", "getTitle", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class HuaweiFeedDataAdapter implements UnifiedDataAdapter {
    private final NativeAd ad;
    private final Context context;

    public HuaweiFeedDataAdapter(NativeAd nativeAd, Context context) {
        this.ad = nativeAd;
        this.context = context;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public String getAdIcon() {
        NativeAd nativeAd = this.ad;
        if ((nativeAd != null ? nativeAd.getIcon() : null) == null) {
            return null;
        }
        Image icon = this.ad.getIcon();
        Intrinsics.checkExpressionValueIsNotNull(icon, "ad.icon");
        if (icon.getUri() == null) {
            return null;
        }
        Image icon2 = this.ad.getIcon();
        Intrinsics.checkExpressionValueIsNotNull(icon2, "ad.icon");
        Uri uri = icon2.getUri();
        if (uri == null) {
            Intrinsics.throwNpe();
        }
        return uri.toString();
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public Bitmap getAdLogo() {
        return null;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public Integer getAdMode() {
        NativeAd nativeAd = this.ad;
        if (nativeAd == null) {
            return 0;
        }
        int creativeType = nativeAd.getCreativeType();
        if (creativeType == 2 || creativeType == 102 || creativeType == 7 || creativeType == 107) {
            return 1;
        }
        if (creativeType == 8 || creativeType == 108) {
            return 3;
        }
        if (creativeType != 3 && creativeType != 6 && creativeType != 103 && creativeType != 106) {
            return 1;
        }
        VideoOperator videoOperator = this.ad.getVideoOperator();
        if (videoOperator == null || !videoOperator.hasVideo()) {
            return 1;
        }
        WifiLog.d("HWAD HuaweiFeedDataAdapter getAdMode videoOperator VIDEO");
        return 4;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public View getAdView() {
        return LayoutInflater.from(this.context).inflate(R.layout.layout_huawei_native_media_view, (ViewGroup) null, false);
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public String getDescription() {
        NativeAd nativeAd = this.ad;
        if (nativeAd != null) {
            return nativeAd.getDescription();
        }
        return null;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public List<String> getImageList() {
        NativeAd nativeAd = this.ad;
        if ((nativeAd != null ? nativeAd.getImages() : null) == null || this.ad.getImages().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            List<Image> images = this.ad.getImages();
            Intrinsics.checkExpressionValueIsNotNull(images, "ad.images");
            for (Image imgFile : images) {
                Intrinsics.checkExpressionValueIsNotNull(imgFile, "imgFile");
                String string = imgFile.getUri().toString();
                Intrinsics.checkExpressionValueIsNotNull(string, "imgFile.uri.toString()");
                arrayList.add(string);
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public Integer getInteractionType() {
        int creativeType;
        NativeAd nativeAd = this.ad;
        return (nativeAd == null || !((creativeType = nativeAd.getCreativeType()) == 103 || creativeType == 106)) ? 0 : 1;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public int getRenderType() {
        return 0;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public String getTitle() {
        NativeAd nativeAd = this.ad;
        if (nativeAd != null) {
            return nativeAd.getTitle();
        }
        return null;
    }
}
