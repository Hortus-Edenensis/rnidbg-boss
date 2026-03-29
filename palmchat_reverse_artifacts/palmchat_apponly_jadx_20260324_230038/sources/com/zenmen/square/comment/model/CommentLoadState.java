package com.zenmen.square.comment.model;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class CommentLoadState {
    public static final int REPLY_FIRST_PAGECOUNT = 3;
    public static final int REPLY_MORE_PAGECOUNT = 10;
    public long commentId;
    public List<Long> filterReplies;
    public boolean hasMore;
    public boolean isLoading;
    public int remainCount = 0;
    public int nextLoadCount = 3;
    public long nextLoadSeq = -1;
    public int nextLoadWeight = -1;
    public long queryTime = -1;
    public double score = -1.0d;
    public long version = 0;
}
