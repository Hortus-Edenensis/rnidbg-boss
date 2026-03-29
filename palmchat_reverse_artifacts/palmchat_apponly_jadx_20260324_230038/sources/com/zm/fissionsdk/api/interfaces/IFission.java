package com.zm.fissionsdk.api.interfaces;

import android.os.Bundle;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface IFission extends IFissionBidding {
    public static final int INTERACTION_TYPE_DEEPLINK = 1;
    public static final int INTERACTION_TYPE_DOWNLOAD = 4;
    public static final int INTERACTION_TYPE_JUST_SHOW = 7;
    public static final int INTERACTION_TYPE_LANDING_PAGE = 3;
    public static final int INTERACTION_TYPE_MARKET = 5;
    public static final int INTERACTION_TYPE_MINI_PROGRAM = 2;
    public static final int INTERACTION_TYPE_UNKNOWN = -1;
    public static final int MATERIAL_TYPE_GROUP_IMAGE = 3;
    public static final int MATERIAL_TYPE_LARGE_IMAGE = 2;
    public static final int MATERIAL_TYPE_SMALL_IMAGE = 1;
    public static final int MATERIAL_TYPE_UN_KNOW = 0;
    public static final int MATERIAL_TYPE_VERTICAL_IMAGE = 6;
    public static final int MATERIAL_TYPE_VERTICAL_VIDEO = 7;
    public static final int MATERIAL_TYPE_VIDEO = 4;

    /* JADX INFO: compiled from: SearchBox */
    public interface AppDownloadListener {
        void onDownloadActive(long j, long j2);

        void onDownloadFail(int i, String str);

        void onDownloadFinish();

        void onDownloadPause(long j, long j2);

        void onDownloadStart();

        void onInstall();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface RewardListener {
        void onReward(boolean z, int i, Bundle bundle);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface VideoListener {
        void onVideoComplete();

        void onVideoContinuePlay();

        void onVideoError(int i, String str);

        void onVideoPause();

        void onVideoPlay();
    }

    void addExtraInfo(Map<String, Object> map);

    void destroy();

    int getAdLogo();

    int getECpm();

    String getSid();

    void pause();

    void resume();

    void setDownloadListener(AppDownloadListener appDownloadListener);

    void setRewardListener(RewardListener rewardListener);

    void setVideoListener(VideoListener videoListener);
}
