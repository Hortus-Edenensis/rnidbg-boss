package com.zenmen.palmchat.database;

import android.text.TextUtils;
import com.zenmen.palmchat.Vo.MsgSession;
import com.zenmen.palmchat.Vo.NoChatVo;
import com.zenmen.palmchat.Vo.RichMsgExItemVo;
import com.zenmen.palmchat.Vo.RichMsgExVo;
import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.chat.g;
import defpackage.az2;
import defpackage.b05;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ThreadBizExtHelper {

    /* JADX INFO: compiled from: SearchBox */
    public static class BizExt {
        public static final int STATE_NOT_REPLYED = 2;
        public static final int STATE_REPLYED = 1;
        public int replyState;
        private BizExtRichMessage richMessage;
        public ThreadShowInfo threadShowInfo;

        public BizExtRichMessage getRichMessage() {
            return this.richMessage;
        }

        public void setRichMessage(BizExtRichMessage bizExtRichMessage) {
            this.richMessage = bizExtRichMessage;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class BizExtRichMessage {
        private int showType;

        public int getShowType() {
            return this.showType;
        }

        public void setShowType(int i) {
            this.showType = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class ThreadShowInfo {
        public String color;
        public String content;
    }

    public static NoChatVo a(String str) {
        RichMsgVo richMsgVo;
        NoChatVo noChatVo;
        if (TextUtils.isEmpty(str) || (richMsgVo = (RichMsgVo) az2.a(str, RichMsgVo.class)) == null || (noChatVo = richMsgVo.noChat) == null) {
            return null;
        }
        return noChatVo;
    }

    public static BizExtRichMessage b(String str, String str2, String str3) {
        RichMsgExVo richMsgExVoG;
        ArrayList<RichMsgExItemVo> arrayList;
        RichMsgExItemVo richMsgExItemVo;
        int i;
        if ("88888003".equals(str) || (richMsgExVoG = g.g(str2)) == null || (arrayList = richMsgExVoG.items) == null || arrayList.size() <= 0 || (richMsgExItemVo = richMsgExVoG.items.get(0)) == null || ((i = richMsgExItemVo.showType) != 8 && i != 9)) {
            return null;
        }
        BizExtRichMessage bizExtRichMessage = new BizExtRichMessage();
        bizExtRichMessage.setShowType(richMsgExItemVo.showType);
        return bizExtRichMessage;
    }

    public static ThreadShowInfo c(String str) {
        RichMsgVo richMsgVo;
        MsgSession msgSession;
        if (TextUtils.isEmpty(str) || (richMsgVo = (RichMsgVo) az2.a(str, RichMsgVo.class)) == null || (msgSession = richMsgVo.sessionTab) == null || msgSession.showBody == null) {
            return null;
        }
        ThreadShowInfo threadShowInfo = new ThreadShowInfo();
        MsgSession msgSession2 = richMsgVo.sessionTab;
        threadShowInfo.content = msgSession2.showBody;
        threadShowInfo.color = msgSession2.showColor;
        return threadShowInfo;
    }

    public static String d(int i, String str, int i2, String str2, String str3, String str4, int i3, String str5, boolean z) {
        ThreadShowInfo threadShowInfo;
        BizExtRichMessage bizExtRichMessageB;
        int i4;
        if (i2 == 28 && i == 0) {
            bizExtRichMessageB = b(str, str2, str3);
            threadShowInfo = null;
        } else if (i2 == 10000 || i2 == 1) {
            ThreadShowInfo threadShowInfoC = c(str4);
            NoChatVo noChatVoA = a(str4);
            if (noChatVoA != null && !TextUtils.isEmpty(noChatVoA.topText) && ((i4 = noChatVoA.style) == 0 || i4 == 1)) {
                threadShowInfoC = new ThreadShowInfo();
                threadShowInfoC.color = "#14CD64";
            }
            threadShowInfo = threadShowInfoC;
            bizExtRichMessageB = null;
        } else {
            bizExtRichMessageB = null;
            threadShowInfo = null;
        }
        BizExt bizExt = TextUtils.isEmpty(str5) ? null : (BizExt) az2.a(str5, BizExt.class);
        if (bizExt == null) {
            bizExt = new BizExt();
        }
        bizExt.richMessage = bizExtRichMessageB;
        bizExt.threadShowInfo = threadShowInfo;
        if (i2 != 10000) {
            if (i3 == 2) {
                b05.a("receiveType ==  MessageTables.Columns.TYPE_SEND");
                bizExt.replyState = 1;
            } else if (bizExt.replyState != 1 && z) {
                bizExt.replyState = 2;
            }
        }
        return az2.c(bizExt);
    }
}
