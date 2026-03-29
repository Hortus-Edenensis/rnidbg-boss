package defpackage;

import android.view.View;
import com.google.common.collect.ImmutableList;
import com.oplus.tbl.exoplayer2.source.ads.AdsLoader;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class u7 {
    public static List a(AdsLoader.AdViewProvider adViewProvider) {
        ImmutableList.a aVar = new ImmutableList.a();
        for (View view : adViewProvider.getAdOverlayViews()) {
            aVar.a(new AdsLoader.OverlayInfo(view, 0));
        }
        return aVar.e();
    }

    @Deprecated
    public static View[] b(AdsLoader.AdViewProvider adViewProvider) {
        return new View[0];
    }
}
