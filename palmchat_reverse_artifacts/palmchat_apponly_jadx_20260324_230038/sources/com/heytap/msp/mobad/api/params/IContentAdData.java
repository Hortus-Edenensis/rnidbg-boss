package com.heytap.msp.mobad.api.params;

import android.content.Context;
import android.view.View;
import com.heytap.msp.mobad.api.listener.IContentInteractListener;
import com.heytap.msp.mobad.api.listener.IContentMediaListener;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface IContentAdData extends IContentBaseData {
    public static final int TYPE_BIG_IMG = 1;
    public static final int TYPE_MULTI_IMG = 3;
    public static final int TYPE_SMALL_IMG = 2;
    public static final int TYPE_VIDEO = 4;

    void bindMediaView(MediaView mediaView, IContentMediaListener iContentMediaListener);

    void bindToView(Context context, ContentContainer contentContainer, List<View> list);

    String getClickBnText();

    int getCreativeType();

    String getDesc();

    List<INativeAdFile> getImgFiles();

    INativeAdFile getLogoFile();

    String getTitle();

    boolean isAdValid();

    void release();

    void setInteractListener(IContentInteractListener iContentInteractListener);
}
