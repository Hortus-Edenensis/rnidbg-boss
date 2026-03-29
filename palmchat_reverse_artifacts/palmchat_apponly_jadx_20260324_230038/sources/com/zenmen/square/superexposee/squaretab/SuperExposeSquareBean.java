package com.zenmen.square.superexposee.squaretab;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public class SuperExposeSquareBean {
    public String avatar;
    public String nickname;
    public String squareButtonText;
    public String squareText;
    public String tagName;
    public int type;
    public String uid;

    @Deprecated
    public int getChatBizType() {
        int i = this.type;
        return (i != 1 && i == 2) ? 5029 : 5026;
    }
}
