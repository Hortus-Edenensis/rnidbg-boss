package com.zenmen.palmchat.paidservices.superexpose.msgtab;

import androidx.annotation.Keep;
import com.qq.e.comm.constants.ErrorCode;
import com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class SuperExposeNumItem implements BaseRecyclerViewAdapter.c {
    public String age;
    public String avatar;
    public String distanceKm;
    public FooterStatus footerStatus = FooterStatus.LOADING;
    public boolean isFooter;
    public String nickname;
    public int position;
    public List<String> tagList;
    public int type;
    public String uid;

    /* JADX INFO: compiled from: SearchBox */
    public enum FooterStatus {
        LOADING,
        ERROR,
        LOADED_ALL,
        LOADED
    }

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
        }
        return ErrorCode.METHOD_CALL_ERROR;
    }

    public long getId() {
        return 0L;
    }

    public String toString() {
        return "nickname:" + this.nickname + " age:" + this.age + " distanceKm:" + this.distanceKm + " uid:" + this.uid + " avatar:" + this.avatar;
    }
}
