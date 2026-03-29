package com.wifi.ad.core.helper;

import android.view.View;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.utils.WifiLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t¨\u0006\u000b"}, d2 = {"Lcom/wifi/ad/core/helper/AdDownHelper;", "", "()V", "saveClickViews", "", "creativeViews", "", "Landroid/view/View;", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", "setNativeDownClickDone", "core_release"}, k = 1, mv = {1, 1, 16})
public final class AdDownHelper {
    public static final AdDownHelper INSTANCE = new AdDownHelper();

    private AdDownHelper() {
    }

    public final void saveClickViews(List<View> creativeViews, NestAdData nestAdData) {
        Integer interactionType = nestAdData.getInteractionType();
        if (interactionType != null && interactionType.intValue() == 1) {
            WifiLog.d("downAd nestAdData " + nestAdData);
            ArrayList arrayList = new ArrayList();
            int size = creativeViews.size();
            for (int i = 0; i < size; i++) {
                View view = creativeViews.get(i);
                WifiLog.d("downAd tag " + view.getTag() + " adView " + view);
                if (!Intrinsics.areEqual(WifiNestConst.OtherConst.TAG_AD_BUTTON, r5)) {
                    arrayList.add(view);
                }
            }
            nestAdData.setNativeDownClickViews(arrayList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, android.view.View] */
    public final void setNativeDownClickDone(NestAdData nestAdData) {
        if (nestAdData.getNativeDownClickViews() == null || nestAdData.getNativeDownClickDone()) {
            return;
        }
        nestAdData.setNativeDownClickDone(true);
        List<View> nativeDownClickViews = nestAdData.getNativeDownClickViews();
        if (nativeDownClickViews == null) {
            Intrinsics.throwNpe();
        }
        int size = nativeDownClickViews.size();
        for (int i = 0; i < size; i++) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            List<View> nativeDownClickViews2 = nestAdData.getNativeDownClickViews();
            if (nativeDownClickViews2 == null) {
                Intrinsics.throwNpe();
            }
            objectRef.element = nativeDownClickViews2.get(i);
            WifiLog.d("downAd setNativeDownClickDone adView " + ((View) objectRef.element));
            ((View) objectRef.element).setOnClickListener(new View.OnClickListener() { // from class: com.wifi.ad.core.helper.AdDownHelper.setNativeDownClickDone.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WifiLog.d("downAd setNativeDownClickDone click " + ((View) objectRef.element));
                }
            });
        }
    }
}
