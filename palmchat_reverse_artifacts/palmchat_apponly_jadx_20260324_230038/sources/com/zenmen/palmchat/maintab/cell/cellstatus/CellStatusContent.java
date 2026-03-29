package com.zenmen.palmchat.maintab.cell.cellstatus;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class CellStatusContent {
    public String appId;
    public String iconUrl;
    public String label;
    public boolean redDot;
    public int unread;
    public String url;

    public int computeUnreadStatus(boolean z) {
        if (z) {
            return -2;
        }
        int i = this.unread;
        return i > 0 ? i : this.redDot ? -1 : 0;
    }
}
