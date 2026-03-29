package com.zm.adxsdk.protocol.api.interfaces;

import android.content.Context;
import android.view.View;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface IWfAdvert extends IWfBidding {
    public static final int DEAL_TYPE_GD = 1;
    public static final int DEAL_TYPE_PD = 3;
    public static final int DEAL_TYPE_PDB = 2;
    public static final int DEAL_TYPE_PREVIEW = 5;
    public static final int DEAL_TYPE_RTB = 4;
    public static final int INTERACTION_TYPE_DEEPLINK = 1;
    public static final int INTERACTION_TYPE_DOWNLOAD = 4;
    public static final int INTERACTION_TYPE_JUST_SHOW = 7;
    public static final int INTERACTION_TYPE_LANDING_PAGE = 3;
    public static final int INTERACTION_TYPE_MARKET = 5;
    public static final int INTERACTION_TYPE_MINI_PROGRAM = 2;
    public static final int INTERACTION_TYPE_QUICK_APP = 6;
    public static final int INTERACTION_TYPE_UNKNOWN = -1;
    public static final int MATERIAL_TYPE_GROUP_IMAGE = 3;
    public static final int MATERIAL_TYPE_LARGE_IMAGE = 2;
    public static final int MATERIAL_TYPE_SMALL_IMAGE = 1;
    public static final int MATERIAL_TYPE_UN_KNOW = 0;
    public static final int MATERIAL_TYPE_VERTICAL_IMAGE = 6;
    public static final int MATERIAL_TYPE_VERTICAL_VIDEO = 7;
    public static final int MATERIAL_TYPE_VIDEO = 4;

    void addExtraInfo(Map<String, Object> map);

    void deleteDownload();

    void destroy();

    int getAdLogo();

    int getAppSize();

    String getButtonText();

    int getClickType();

    double getCtr();

    int getDealType();

    String getDspId();

    String getDspName();

    int getECpm();

    Object getExtra(String str);

    int getInteractionInfo(int i);

    int getInteractionType();

    int getMaterialHeight();

    long getMaterialSize();

    String getMaterialUrl();

    int getMaterialWidth();

    int getMaxCpmDiff();

    int getMinECpm();

    List<String> getMovieEpisodes();

    String getPackageName();

    int getRealECpm();

    String getSid();

    String getSlotId();

    String getSmartRankPkg();

    int getSmartRankPriority();

    int getSmartRankSubType();

    int getSmartRankType();

    IWfAdvert getTwinsAdvert();

    View getTwinsView(Context context);

    void pause();

    void resume();

    void setDownloadListener(WfAppDownloadListener wfAppDownloadListener);

    void setRewardListener(Object obj);

    void setTwinsInteractionListener(Object obj);

    void setVideoListener(WfVideoListener wfVideoListener);

    void updateInteractionInfo(int i);
}
