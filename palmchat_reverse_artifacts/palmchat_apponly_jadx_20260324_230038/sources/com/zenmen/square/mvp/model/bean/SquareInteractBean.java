package com.zenmen.square.mvp.model.bean;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareInteractBean extends SquareBean {
    public static final int TYPE_COMMENT_COMMENT = 3;
    public static final int TYPE_COMMENT_PRAISE = 1;
    public static final int TYPE_FEED_COMMENT = 4;
    public static final int TYPE_FEED_PRAISE = 2;
    public int aggregationNoticeType;
    public long counts;
    public long id;
    public boolean ifAggregation;
    public SquareInteractDetail singleInteract;
    public List<SquareInteractDetail> singleNoticeList;
    public long version;
}
