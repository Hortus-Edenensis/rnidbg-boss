package com.zenmen.palmchat.maintab;

import androidx.annotation.Keep;
import com.zenmen.palmchat.maintab.config.TabItem;
import defpackage.ds0;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class CellUpdateEvent implements ds0.a {
    public static final int TYPE_CONFIG_UPDATE = 0;
    public static final int TYPE_DEEPLINK = 5;
    public static final int TYPE_MANYKNOWN = 3;
    public static final int TYPE_MINE_DAYN_UPDATE = 7;
    public static final int TYPE_MINE_NERBY_MYFRIENDS_UPDATE = 8;
    public static final int TYPE_MOMENTS = 4;
    public static final int TYPE_NEWFRIENDS = 2;
    public static final int TYPE_RECENT_CONFIG_UPDATE = 6;
    public static final int TYPE_SMALLVIDEO_UPDATE = 1;
    public List<TabItem> data;
    public int type;

    private CellUpdateEvent(int i, List<TabItem> list) {
        this.type = i;
        this.data = list;
    }

    public static CellUpdateEvent produceEvent(int i, List<TabItem> list) {
        return new CellUpdateEvent(i, list);
    }
}
