package com.zenmen.palmchat.paidservices.superexpose.msgtab.model;

import androidx.annotation.Keep;
import com.qq.e.comm.constants.ErrorCode;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class SuperExposeMsgTagCItemModel {
    public static final int TYPE_POLISH = 21;
    public String avatar;
    public String nickname;
    public String tagName;
    public int type;
    public String uid;

    public int getChatBizType(int i) {
        int i2 = this.type;
        if (i2 == 1) {
            return ErrorCode.METHOD_CALL_ERROR;
        }
        if (i2 == 2) {
            return 5028;
        }
        if (i2 == 3) {
            if (i == 1) {
                return 5057;
            }
            if (i == 2) {
                return 5056;
            }
            if (i == 3) {
                return ErrorCode.NO_AD_FILL_FOR_MULTI;
            }
        } else if (i2 == 21) {
            return ErrorCode.BIDDING_C2S_TIMEOUT;
        }
        return ErrorCode.METHOD_CALL_ERROR;
    }
}
