package com.zenmen.palmchat.chat.aigreeting.vo;

import android.util.Pair;
import androidx.annotation.Keep;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.RichMsgExItemVo;
import com.zenmen.palmchat.Vo.RichMsgExVo;
import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.gift.GiftMessageHelper;
import com.zenmen.palmchat.giftkit.chat.ChatGiftMessageExtensionBean;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.az2;
import defpackage.b9;
import defpackage.rb3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class AiGreetingInfoRequestBody {
    private static int MAX_COUNT = 10;
    public int bizType;
    public long chatUid;
    public List<Records> chattingRecords;
    public String contentMd5;
    public String domain;
    public long lastChatTime;
    public int panel;
    public int scene;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class Records {
        public String content;
        public String mid;
        public boolean selfSendFlag;

        public Records(boolean z, String str, String str2) {
            this.selfSendFlag = z;
            this.mid = str;
            this.content = str2;
        }
    }

    public static AiGreetingInfoRequestBody build(ChatItem chatItem, int i, List<MessageVo> list) {
        AiGreetingInfoRequestBody aiGreetingInfoRequestBody = new AiGreetingInfoRequestBody();
        Pair<List<Records>, Long> pairBuildRecords = buildRecords(list);
        List<Records> list2 = (List) pairBuildRecords.first;
        long jLongValue = ((Long) pairBuildRecords.second).longValue();
        aiGreetingInfoRequestBody.scene = list2.size() == 0 ? 1 : 2;
        aiGreetingInfoRequestBody.panel = i;
        aiGreetingInfoRequestBody.lastChatTime = jLongValue;
        aiGreetingInfoRequestBody.domain = DomainHelper.m(chatItem).domain;
        aiGreetingInfoRequestBody.bizType = DomainHelper.i(chatItem);
        aiGreetingInfoRequestBody.contentMd5 = genMsgMd5(list2);
        aiGreetingInfoRequestBody.chatUid = Long.parseLong(chatItem.getChatId());
        aiGreetingInfoRequestBody.chattingRecords = list2;
        return aiGreetingInfoRequestBody;
    }

    public static Pair<List<Records>, Long> buildRecords(List<MessageVo> list) {
        RichMsgExVo richMsgExVo;
        ArrayList<RichMsgExItemVo> arrayList;
        ArrayList arrayList2 = new ArrayList();
        long j = 0;
        try {
            if (b9.d().i()) {
                if (list != null && list.size() > 0) {
                    long j2 = 0;
                    int i = 0;
                    for (int size = list.size() - 1; size >= 0; size--) {
                        try {
                            if (i >= MAX_COUNT) {
                                break;
                            }
                            MessageVo messageVo = list.get(size);
                            if (isRightType(messageVo)) {
                                int i2 = messageVo.mimeType;
                                Records records = null;
                                if (i2 == 35) {
                                    ChatGiftMessageExtensionBean chatGiftMessageExtensionBeanQ = GiftMessageHelper.Q(messageVo.extention);
                                    if (chatGiftMessageExtensionBeanQ != null) {
                                        records = new Records(messageVo.isSend, messageVo.mid, "送了一个礼物，礼物：【" + chatGiftMessageExtensionBeanQ.itemName + "】");
                                    }
                                } else if (i2 == 28) {
                                    RichMsgVo richMsgVo = (RichMsgVo) az2.a(messageVo.data1, RichMsgVo.class);
                                    if (richMsgVo != null && (richMsgExVo = richMsgVo.appMsg) != null && (arrayList = richMsgExVo.items) != null && arrayList.size() > 0) {
                                        RichMsgExItemVo richMsgExItemVo = richMsgExVo.items.get(0);
                                        records = new Records(messageVo.isSend, messageVo.mid, richMsgExItemVo.title + "[链接]");
                                    }
                                } else {
                                    records = new Records(messageVo.isSend, messageVo.mid, messageVo.text);
                                }
                                if (records != null) {
                                    arrayList2.add(records);
                                    i++;
                                    if (j2 == 0) {
                                        j2 = messageVo.time;
                                    }
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            j = j2;
                            e.printStackTrace();
                        }
                    }
                    j = j2;
                }
                if (arrayList2.size() > 0) {
                    Collections.reverse(arrayList2);
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
        return new Pair<>(arrayList2, Long.valueOf(j));
    }

    private static String genMsgMd5(List<Records> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<Records> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().mid);
        }
        return rb3.c(sb.toString());
    }

    public static long getLastRightMsgTime(List<MessageVo> list) {
        long j;
        if (list == null || list.size() <= 0) {
            j = 0;
        } else {
            for (int size = list.size() - 1; size >= 0 && MAX_COUNT > 0; size--) {
                MessageVo messageVo = list.get(size);
                if (isRightType(messageVo)) {
                    j = messageVo.time;
                    break;
                }
            }
            j = 0;
        }
        LogUtil.i("AiGreetingCardMsgHelper", "getLastMsgTime " + j);
        return j;
    }

    private static boolean isRightType(MessageVo messageVo) {
        int i;
        String str = messageVo.text;
        return str != null && str.length() <= 300 && ((i = messageVo.mimeType) == 1 || i == 35 || i == 28);
    }
}
