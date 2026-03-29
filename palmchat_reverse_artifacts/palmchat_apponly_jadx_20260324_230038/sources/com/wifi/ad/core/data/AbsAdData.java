package com.wifi.ad.core.data;

import android.graphics.Bitmap;
import android.view.View;
import com.wifi.ad.core.config.EventParams;
import com.wifi.adsdk.utils.LxAdConst;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020,2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0003\u001a\u0004\u0018\u00010\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0007R.\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001f2\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001e\u0010#\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b$\u0010\u000f\"\u0004\b%\u0010\u0011R\u001e\u0010&\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\"\u0010)\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0007¨\u0006."}, d2 = {"Lcom/wifi/ad/core/data/AbsAdData;", "", "()V", "<set-?>", "", "adIcon", "getAdIcon", "()Ljava/lang/String;", "Landroid/graphics/Bitmap;", "adLogo", "getAdLogo", "()Landroid/graphics/Bitmap;", LxAdConst.EventKeyParams.KEY_PARAM_ADMODE, "", "getAdMode", "()Ljava/lang/Integer;", "setAdMode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "adView", "Landroid/view/View;", "getAdView", "()Landroid/view/View;", "setAdView", "(Landroid/view/View;)V", "Lcom/wifi/ad/core/data/UnifiedDataAdapter;", "dataAdapter", "getDataAdapter", "()Lcom/wifi/ad/core/data/UnifiedDataAdapter;", "description", "getDescription", "", "imageList", "getImageList", "()Ljava/util/List;", "interactionType", "getInteractionType", "setInteractionType", EventParams.KEY_RENDERTYPE, "getRenderType", "()I", "title", "getTitle", "setData", "", "setDataAdapter", "core_release"}, k = 1, mv = {1, 1, 16})
public abstract class AbsAdData {
    private String adIcon;
    private Bitmap adLogo;
    private Integer adMode;
    private View adView;
    private UnifiedDataAdapter dataAdapter;
    private String description;
    private List<String> imageList;
    private Integer interactionType = 0;
    private int renderType;
    private String title;

    private final void setData() {
        UnifiedDataAdapter unifiedDataAdapter = this.dataAdapter;
        if (unifiedDataAdapter != null) {
            this.adLogo = unifiedDataAdapter.getAdLogo();
            this.title = unifiedDataAdapter.getTitle();
            this.description = unifiedDataAdapter.getDescription();
            this.adIcon = unifiedDataAdapter.getAdIcon();
            this.imageList = unifiedDataAdapter.getImageList();
            this.interactionType = unifiedDataAdapter.getInteractionType();
            this.adMode = unifiedDataAdapter.getAdMode();
            this.adView = unifiedDataAdapter.getAdView();
            this.renderType = unifiedDataAdapter.getRenderType();
        }
    }

    public final String getAdIcon() {
        return this.adIcon;
    }

    public final Bitmap getAdLogo() {
        return this.adLogo;
    }

    public final Integer getAdMode() {
        return this.adMode;
    }

    public final View getAdView() {
        return this.adView;
    }

    public final UnifiedDataAdapter getDataAdapter() {
        return this.dataAdapter;
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<String> getImageList() {
        return this.imageList;
    }

    public final Integer getInteractionType() {
        return this.interactionType;
    }

    public final int getRenderType() {
        return this.renderType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setAdMode(Integer num) {
        this.adMode = num;
    }

    public final void setAdView(View view) {
        this.adView = view;
    }

    public final void setDataAdapter(UnifiedDataAdapter dataAdapter) {
        this.dataAdapter = dataAdapter;
        setData();
    }

    public final void setInteractionType(Integer num) {
        this.interactionType = num;
    }
}
