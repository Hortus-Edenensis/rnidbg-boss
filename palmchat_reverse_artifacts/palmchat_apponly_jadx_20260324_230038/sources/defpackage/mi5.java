package defpackage;

import android.text.TextUtils;
import com.umeng.analytics.pro.bd;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.GuideInfoForChatCard;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.square.mvp.model.bean.MediaForChatCard;
import com.zenmen.square.mvp.model.bean.SquareFeedForChatCard;
import defpackage.kn2;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class mi5 extends u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Set<String> f19229a;

    public static MessageVo n(ChatItem chatItem, String str) {
        MessageVo messageVoG = u0.g(chatItem);
        messageVoG.mimeType = 33;
        RichMsgVo richMsgVo = new RichMsgVo();
        richMsgVo.squareFeed = (SquareFeedForChatCard) az2.a(str, SquareFeedForChatCard.class);
        messageVoG.extention = az2.c(richMsgVo);
        messageVoG.text = "对方发送了一张动态卡片信息，请升级app后查看";
        return messageVoG;
    }

    public static void o(SquareFeedForChatCard squareFeedForChatCard, String str) {
        if (squareFeedForChatCard == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("report_type", "click");
            jSONObject.put("feedid", squareFeedForChatCard.id);
            jSONObject.put(bd.h, squareFeedForChatCard.exid);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d(str, null, jSONObject.toString());
    }

    public static boolean p(String str, String str2, boolean z) {
        SquareFeedForChatCard squareFeedForChatCard;
        String strP = AccountUtils.p(AppContext.getContext());
        if ((str2 != null && str2.equals(strP)) || TextUtils.isEmpty(str) || (squareFeedForChatCard = (SquareFeedForChatCard) az2.a(str, SquareFeedForChatCard.class)) == null || squareFeedForChatCard.id <= 0 || squareFeedForChatCard.exid == null) {
            return false;
        }
        if (f19229a == null) {
            f19229a = q();
        }
        String str3 = squareFeedForChatCard.id + strP;
        boolean z2 = !f19229a.contains(str3);
        if (z2 && z) {
            f19229a.add(str3);
            SPUtil.f14322a.t(SPUtil.SCENE.SQUARE_FEED_IN_CHAT, "key_square_send_feed_ids_in_chat", TextUtils.join(",", f19229a));
            o(squareFeedForChatCard, "pageprichat_postcardsend");
        }
        return z2;
    }

    public static Set<String> q() {
        HashSet hashSet = new HashSet();
        String strN = SPUtil.f14322a.n(SPUtil.SCENE.SQUARE_FEED_IN_CHAT, "key_square_send_feed_ids_in_chat", "");
        if (!TextUtils.isEmpty(strN)) {
            String[] strArrSplit = strN.split(",");
            if (strArrSplit.length > 0) {
                hashSet.addAll(Arrays.asList(strArrSplit));
            }
        }
        return hashSet;
    }

    public static MessageVo r(MessageVo messageVo) {
        String str;
        int i;
        RichMsgVo richMsgVo;
        if (messageVo.mimeType != 33) {
            return messageVo;
        }
        String str2 = messageVo.extention;
        SquareFeedForChatCard squareFeedForChatCard = (TextUtils.isEmpty(str2) || (richMsgVo = (RichMsgVo) az2.a(str2, RichMsgVo.class)) == null) ? null : richMsgVo.squareFeed;
        if (squareFeedForChatCard == null) {
            return messageVo;
        }
        if (!messageVo.isSend) {
            squareFeedForChatCard.exid = AccountUtils.j(AppContext.getContext());
        }
        messageVo.mimeType = 20001;
        GuideInfoForChatCard guideInfoForChatCard = new GuideInfoForChatCard();
        str = "和Ta聊聊这个动态的故事吧~";
        String str3 = "Ta对你的这条动态很感兴趣~";
        try {
            JSONObject jSONObjectB = ts0.o().B();
            if (jSONObjectB != null) {
                String string = jSONObjectB.getString("postcardsender");
                String string2 = jSONObjectB.getString("postcardacceptor");
                str = TextUtils.isEmpty(string) ? "和Ta聊聊这个动态的故事吧~" : string;
                if (!TextUtils.isEmpty(string2)) {
                    str3 = string2;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (!messageVo.isSend) {
            str = str3;
        }
        guideInfoForChatCard.content = str;
        ArrayList<String> arrayList = new ArrayList<>();
        List<MediaForChatCard> list = squareFeedForChatCard.mediaList;
        if (list != null && list.size() > 0) {
            arrayList.add(squareFeedForChatCard.mediaList.get(0).thumbUrl);
        }
        guideInfoForChatCard.icon = arrayList;
        int i2 = squareFeedForChatCard.feedType;
        if (i2 == 1) {
            i = 3;
        } else {
            i = 2;
            if (i2 != 2) {
                i = 4;
            }
        }
        guideInfoForChatCard.styleType = i;
        if (i2 == 1) {
            guideInfoForChatCard.title = squareFeedForChatCard.content;
        }
        guideInfoForChatCard.turnUrl = squareFeedForChatCard.genDeepLinkUrl();
        RichMsgVo richMsgVo2 = new RichMsgVo();
        richMsgVo2.guideInfo = guideInfoForChatCard;
        messageVo.extention = az2.c(richMsgVo2);
        return messageVo;
    }

    @Override // defpackage.zi0
    public boolean a(MessageVo messageVo) {
        return false;
    }

    @Override // defpackage.mn2
    public boolean c(MessageVo messageVo) {
        return messageVo.mimeType == 33;
    }

    @Override // defpackage.zi0
    public kn2 d(MessageVo messageVo, kn2.a aVar) {
        return null;
    }

    @Override // defpackage.u0
    public MessageProto.Message i(MessageVo messageVo) {
        return super.i(messageVo);
    }
}
