package com.heytap.msp.mobad.api.params;

import android.content.Context;
import android.view.View;
import com.heytap.msp.mobad.api.listener.IContentMediaListener;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface IContentData extends IContentBaseData {
    public static final int TYPE_TEXT = 5;
    public static final int TYPE_TEXT_BIG_IMG = 2;
    public static final int TYPE_TEXT_IMG = 1;
    public static final int TYPE_TEXT_MULTI_IMG = 3;
    public static final int TYPE_VIDEO = 4;

    void bindMediaVIew(MediaView mediaView, IContentMediaListener iContentMediaListener);

    void bindToView(Context context, ContentContainer contentContainer, List<View> list);

    int getCreativeType();

    String getDesc();

    List<String> getImgUrlList();

    long getPublishTime();

    List<String> getTagList();

    String getTitle();

    int getVideoDuration();

    void pause();

    void release();

    void resume();

    void setVolume(boolean z);
}
