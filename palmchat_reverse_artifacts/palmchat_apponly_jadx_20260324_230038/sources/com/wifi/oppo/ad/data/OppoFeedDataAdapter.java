package com.wifi.oppo.ad.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.heytap.msp.mobad.api.params.INativeAdFile;
import com.heytap.msp.mobad.api.params.INativeAdvanceData;
import com.wifi.ad.core.data.UnifiedDataAdapter;
import com.wifi.oppo.ad.BuildConfig;
import com.wifi.oppo.ad.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rJ\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012H\u0016J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u0014\u001a\u00020\fH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/wifi/oppo/ad/data/OppoFeedDataAdapter;", "Lcom/wifi/ad/core/data/UnifiedDataAdapter;", "ad", "Lcom/heytap/msp/mobad/api/params/INativeAdvanceData;", "context", "Landroid/content/Context;", "(Lcom/heytap/msp/mobad/api/params/INativeAdvanceData;Landroid/content/Context;)V", "getAdIcon", "", "getAdLogo", "Landroid/graphics/Bitmap;", "getAdMode", "", "()Ljava/lang/Integer;", "getAdView", "Landroid/view/View;", "getDescription", "getImageList", "", "getInteractionType", "getRenderType", "getTitle", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class OppoFeedDataAdapter implements UnifiedDataAdapter {
    private final INativeAdvanceData ad;
    private final Context context;

    public OppoFeedDataAdapter(INativeAdvanceData iNativeAdvanceData, Context context) {
        this.ad = iNativeAdvanceData;
        this.context = context;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public String getAdIcon() {
        INativeAdvanceData iNativeAdvanceData = this.ad;
        if ((iNativeAdvanceData != null ? iNativeAdvanceData.getIconFiles() : null) == null || this.ad.getIconFiles().size() <= 0 || this.ad.getIconFiles().get(0) == null) {
            return null;
        }
        INativeAdFile iNativeAdFile = this.ad.getIconFiles().get(0);
        Intrinsics.checkExpressionValueIsNotNull(iNativeAdFile, "ad.iconFiles[0]");
        return iNativeAdFile.getUrl();
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public Bitmap getAdLogo() {
        return null;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public Integer getAdMode() {
        INativeAdvanceData iNativeAdvanceData = this.ad;
        if (iNativeAdvanceData != null) {
            if (iNativeAdvanceData.getCreativeType() == 13 || this.ad.getCreativeType() == 16) {
                return 4;
            }
            if (this.ad.getImgFiles() != null) {
                return this.ad.getImgFiles().size() >= 3 ? 3 : 1;
            }
        }
        return 0;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public View getAdView() {
        return LayoutInflater.from(this.context).inflate(R.layout.layout_oppo_native_media_view, (ViewGroup) null, false);
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public String getDescription() {
        INativeAdvanceData iNativeAdvanceData = this.ad;
        if (iNativeAdvanceData != null) {
            return iNativeAdvanceData.getDesc();
        }
        return null;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public List<String> getImageList() {
        INativeAdvanceData iNativeAdvanceData = this.ad;
        if ((iNativeAdvanceData != null ? iNativeAdvanceData.getImgFiles() : null) == null || this.ad.getImgFiles().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<INativeAdFile> imgFiles = this.ad.getImgFiles();
        Intrinsics.checkExpressionValueIsNotNull(imgFiles, "ad.imgFiles");
        for (INativeAdFile imgFile : imgFiles) {
            Intrinsics.checkExpressionValueIsNotNull(imgFile, "imgFile");
            String url = imgFile.getUrl();
            Intrinsics.checkExpressionValueIsNotNull(url, "imgFile.url");
            arrayList.add(url);
        }
        return arrayList;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public Integer getInteractionType() {
        INativeAdvanceData iNativeAdvanceData = this.ad;
        return (iNativeAdvanceData != null ? iNativeAdvanceData.getComplianceInfo() : null) != null ? 1 : 0;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public int getRenderType() {
        return 0;
    }

    @Override // com.wifi.ad.core.data.UnifiedDataAdapter
    public String getTitle() {
        INativeAdvanceData iNativeAdvanceData = this.ad;
        if (iNativeAdvanceData != null) {
            return iNativeAdvanceData.getTitle();
        }
        return null;
    }
}
