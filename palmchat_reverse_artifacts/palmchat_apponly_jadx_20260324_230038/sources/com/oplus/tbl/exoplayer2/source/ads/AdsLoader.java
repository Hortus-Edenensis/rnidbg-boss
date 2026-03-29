package com.oplus.tbl.exoplayer2.source.ads;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.Player;
import com.oplus.tbl.exoplayer2.source.ads.AdsMediaSource;
import com.oplus.tbl.exoplayer2.upstream.DataSpec;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface AdsLoader {

    /* JADX INFO: compiled from: SearchBox */
    public interface AdViewProvider {
        List<OverlayInfo> getAdOverlayInfos();

        @Deprecated
        View[] getAdOverlayViews();

        @Nullable
        ViewGroup getAdViewGroup();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface EventListener {
        void onAdClicked();

        void onAdLoadError(AdsMediaSource.AdLoadException adLoadException, DataSpec dataSpec);

        void onAdPlaybackState(AdPlaybackState adPlaybackState);

        void onAdTapped();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class OverlayInfo {
        public static final int PURPOSE_CLOSE_AD = 1;
        public static final int PURPOSE_CONTROLS = 0;
        public static final int PURPOSE_NOT_VISIBLE = 3;
        public static final int PURPOSE_OTHER = 2;
        public final int purpose;

        @Nullable
        public final String reasonDetail;
        public final View view;

        /* JADX INFO: compiled from: SearchBox */
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Purpose {
        }

        public OverlayInfo(View view, int i) {
            this(view, i, null);
        }

        public OverlayInfo(View view, int i, @Nullable String str) {
            this.view = view;
            this.purpose = i;
            this.reasonDetail = str;
        }
    }

    void handlePrepareComplete(AdsMediaSource adsMediaSource, int i, int i2);

    void handlePrepareError(AdsMediaSource adsMediaSource, int i, int i2, IOException iOException);

    void release();

    void setPlayer(@Nullable Player player);

    void setSupportedContentTypes(int... iArr);

    void start(AdsMediaSource adsMediaSource, DataSpec dataSpec, Object obj, AdViewProvider adViewProvider, EventListener eventListener);

    void stop(AdsMediaSource adsMediaSource, EventListener eventListener);
}
