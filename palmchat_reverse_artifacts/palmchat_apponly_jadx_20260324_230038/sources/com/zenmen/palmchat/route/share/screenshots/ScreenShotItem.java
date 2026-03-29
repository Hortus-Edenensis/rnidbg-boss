package com.zenmen.palmchat.route.share.screenshots;

import androidx.annotation.Keep;
import defpackage.pu1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class ScreenShotItem {
    public long during;
    public long fileSize;
    public String path;
    public String thumbPath;
    public int type;

    public ScreenShotItem(int i, String str, String str2, long j, long j2) {
        this.type = i;
        this.path = str;
        this.thumbPath = str2;
        this.fileSize = j;
        this.during = j2;
    }

    public String getCoverPath() {
        return this.type == 0 ? this.path : this.thumbPath;
    }

    public boolean isCorrect() {
        return this.type == 0 ? pu1.b(this.path) : pu1.b(this.path) && pu1.b(this.thumbPath) && this.during < 301000 && this.fileSize < 209715200;
    }
}
