package com.zenmen.palmchat.chat;

import androidx.annotation.Keep;
import com.zenmen.palmchat.chat.ChatGiftConfig;
import defpackage.az2;
import defpackage.b05;
import defpackage.q05;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class ChatGiftConfig {
    public List<AmuletCard> amulet_cards_female;
    public List<AmuletCard> amulet_cards_male;
    public List<String> gift_bubbles;
    public List<GiftCard> gift_cards;
    public String gift_content;
    public int gift_num;
    public int gift_num_amuletshow;
    public String gift_title;
    public String gift_url;
    public int guide_num;
    public int guide_num_msgStatus;
    public String guide_text;
    public GiftClickcardText gift_clickcard_text = createDefaultGiftClickcardText();
    public String gift_nofrdbanner = "";
    public List<GiftApplyChat> gift_applychat = createDefaultGiftApplychat();
    public String gift_givetxt = "🎁回复率预计提升3倍！\n你的礼物消息已被置顶，对方会优先看到！";
    public boolean gift_newpanel = true;
    public List<String> gift_thxtext = Arrays.asList("礼物真好看，谢谢你", "啊谢谢你的礼物，聊聊吧~", "😊我真喜欢，谢谢你！");
    public List<GiftApplyChat> gift_agreechat = createDefaultGiftAgreechat();

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class AmuletCard {
        public int amuletid;
        public String content;
        public String title;
        public int type;
        public String url;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class GiftApplyChat {
        public int giftID;
        public String gifticon;
        public String giftname;
        public int giftprice;
        public String subtitle;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class GiftCard {
        public String buttonBgUrl;
        public String buttonText;
        public String buttonTextColor;
        public String cardBgUrl;
        public String content;
        public String title;
        public String titleColor;
        public String url;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class GiftClickcardItem {
        public int end;
        public int start;
        public List<GiftTextItem> text;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class GiftClickcardText {
        public List<GiftClickcardItem> friend;
        public List<GiftClickcardItem> notfriend;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class GiftTextItem {
        public int giftID;
        public String gifticon;
        public String giftname;
        public int giftprice;
        public String subtitle;
    }

    private static List<GiftApplyChat> createDefaultGiftAgreechat() {
        ArrayList arrayList = new ArrayList();
        GiftApplyChat giftApplyChat = new GiftApplyChat();
        giftApplyChat.giftID = 30197;
        giftApplyChat.gifticon = "https://palmchat.cdn.lianxinapp.com/static/resource/img/0604bbxn.png";
        giftApplyChat.giftprice = 39;
        giftApplyChat.giftname = "宝贝我想你";
        giftApplyChat.subtitle = "点击收获对方好感";
        arrayList.add(giftApplyChat);
        return arrayList;
    }

    private static List<GiftApplyChat> createDefaultGiftApplychat() {
        ArrayList arrayList = new ArrayList();
        GiftApplyChat giftApplyChat = new GiftApplyChat();
        giftApplyChat.giftID = 30197;
        giftApplyChat.gifticon = "https://palmchat.cdn.lianxinapp.com/static/resource/img/0604bbxn.png";
        giftApplyChat.giftprice = 39;
        giftApplyChat.giftname = "宝贝我想你";
        giftApplyChat.subtitle = "回复率预计提升3倍！";
        arrayList.add(giftApplyChat);
        return arrayList;
    }

    private static GiftClickcardText createDefaultGiftClickcardText() {
        GiftClickcardText giftClickcardText = new GiftClickcardText();
        GiftTextItem giftTextItem = new GiftTextItem();
        giftTextItem.giftID = 30197;
        giftTextItem.gifticon = "https://palmchat.cdn.lianxinapp.com/static/resource/img/0604bbxn.png";
        giftTextItem.giftprice = 39;
        giftTextItem.giftname = "宝贝我想你";
        giftTextItem.subtitle = "回复率预计提升3倍！";
        GiftClickcardItem giftClickcardItem = new GiftClickcardItem();
        giftClickcardItem.start = 0;
        giftClickcardItem.end = 23;
        ArrayList arrayList = new ArrayList();
        giftClickcardItem.text = arrayList;
        arrayList.add(giftTextItem);
        GiftClickcardItem giftClickcardItem2 = new GiftClickcardItem();
        giftClickcardItem2.start = 0;
        giftClickcardItem2.end = 23;
        ArrayList arrayList2 = new ArrayList();
        giftClickcardItem2.text = arrayList2;
        arrayList2.add(giftTextItem);
        ArrayList arrayList3 = new ArrayList();
        giftClickcardText.friend = arrayList3;
        arrayList3.add(giftClickcardItem);
        ArrayList arrayList4 = new ArrayList();
        giftClickcardText.notfriend = arrayList4;
        arrayList4.add(giftClickcardItem2);
        return giftClickcardText;
    }

    public static ChatGiftConfig getChatGiftConfig() {
        final ChatGiftConfig chatGiftConfig = null;
        try {
            final JSONObject jSONObjectF = q05.f("chatGiftConfig");
            b05.c(new b05.a() { // from class: j20
                @Override // b05.a
                public final Object getValue() {
                    return ChatGiftConfig.lambda$getChatGiftConfig$0(jSONObjectF);
                }
            });
            if (jSONObjectF != null) {
                chatGiftConfig = (ChatGiftConfig) az2.a(jSONObjectF.toString(), ChatGiftConfig.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (chatGiftConfig == null) {
            chatGiftConfig = new ChatGiftConfig();
        }
        b05.c(new b05.a() { // from class: k20
            @Override // b05.a
            public final Object getValue() {
                return ChatGiftConfig.lambda$getChatGiftConfig$1();
            }
        });
        b05.c(new b05.a() { // from class: l20
            @Override // b05.a
            public final Object getValue() {
                return ChatGiftConfig.lambda$getChatGiftConfig$2(this.f18892a);
            }
        });
        return chatGiftConfig;
    }

    public static GiftApplyChat getGiftAgreeChatItem() {
        List<GiftApplyChat> list = getChatGiftConfig().gift_agreechat;
        return (list == null || list.isEmpty()) ? createDefaultGiftAgreechat().get(0) : list.get(new Random().nextInt(list.size()));
    }

    public static GiftApplyChat getGiftApplyChatItem() {
        List<GiftApplyChat> list = getChatGiftConfig().gift_applychat;
        return (list == null || list.isEmpty()) ? createDefaultGiftApplychat().get(0) : list.get(new Random().nextInt(list.size()));
    }

    public static GiftTextItem getGiftTextItemByTime(boolean z) {
        List<GiftTextItem> list;
        GiftClickcardText giftClickcardText = getChatGiftConfig().gift_clickcard_text;
        List<GiftClickcardItem> list2 = z ? giftClickcardText.friend : giftClickcardText.notfriend;
        int i = Calendar.getInstance().get(11);
        for (GiftClickcardItem giftClickcardItem : list2) {
            if (i >= giftClickcardItem.start && i < giftClickcardItem.end && (list = giftClickcardItem.text) != null && !list.isEmpty()) {
                return giftClickcardItem.text.get(new Random().nextInt(giftClickcardItem.text.size()));
            }
        }
        return list2.get(0).text.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$getChatGiftConfig$0(JSONObject jSONObject) {
        return "获取的配置文件原始JSON是===》" + jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$getChatGiftConfig$1() {
        return "返回的JSON对象是===》";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$getChatGiftConfig$2(ChatGiftConfig chatGiftConfig) {
        return chatGiftConfig;
    }
}
