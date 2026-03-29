package com.zenmen.square.comment.model;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class CommentChangeInfo {
    public int count;
    public STATE status;

    /* JADX INFO: compiled from: SearchBox */
    public enum STATE {
        REFRESH,
        ADD,
        DELETE,
        REPLY_LOADMOREFINISH,
        COMMENT_LOADMOREFINISH
    }

    public CommentChangeInfo(STATE state, int i) {
        STATE state2 = STATE.REFRESH;
        this.status = state;
        this.count = i;
    }
}
