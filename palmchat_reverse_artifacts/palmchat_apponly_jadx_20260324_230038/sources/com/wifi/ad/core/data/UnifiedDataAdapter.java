package com.wifi.ad.core.data;

import android.graphics.Bitmap;
import android.view.View;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\bJ\n\u0010\t\u001a\u0004\u0018\u00010\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rH&J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0007H&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0011"}, d2 = {"Lcom/wifi/ad/core/data/UnifiedDataAdapter;", "", "getAdIcon", "", "getAdLogo", "Landroid/graphics/Bitmap;", "getAdMode", "", "()Ljava/lang/Integer;", "getAdView", "Landroid/view/View;", "getDescription", "getImageList", "", "getInteractionType", "getRenderType", "getTitle", "core_release"}, k = 1, mv = {1, 1, 16})
public interface UnifiedDataAdapter {
    String getAdIcon();

    Bitmap getAdLogo();

    Integer getAdMode();

    View getAdView();

    String getDescription();

    List<String> getImageList();

    Integer getInteractionType();

    int getRenderType();

    String getTitle();
}
