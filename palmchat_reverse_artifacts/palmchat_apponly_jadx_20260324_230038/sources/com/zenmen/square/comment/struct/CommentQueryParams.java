package com.zenmen.square.comment.struct;

import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class CommentQueryParams implements Serializable {
    public static final int STATUS_DELETED = -1;
    public String cmtId;
    public boolean isDelete;
    public String replyId;

    public CommentQueryParams(String str, String str2, boolean z) {
        this.cmtId = str;
        this.replyId = str2;
        this.isDelete = z;
    }
}
