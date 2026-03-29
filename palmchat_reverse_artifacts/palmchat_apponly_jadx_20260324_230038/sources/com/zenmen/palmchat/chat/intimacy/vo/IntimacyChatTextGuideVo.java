package com.zenmen.palmchat.chat.intimacy.vo;

import androidx.annotation.Keep;
import com.zenmen.palmchat.chat.gift.quicksend.QuickSendVo;
import defpackage.gu2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class IntimacyChatTextGuideVo {
    public static int TYPE_GIFT = 1;
    public static int TYPE_NONE = 0;
    public static int TYPE_TEXT = 2;
    public String actionBody;
    public String actionTypes;
    public List<QuickSendVo> giftList;
    public List<String> list;
    public String text;
    public int type = 0;

    public static IntimacyChatTextGuideVo genTest(int i) {
        IntimacyChatTextGuideVo intimacyChatTextGuideVo = new IntimacyChatTextGuideVo();
        intimacyChatTextGuideVo.type = i;
        intimacyChatTextGuideVo.text = "哈哈哈哈哈哈哈哈";
        ArrayList arrayList = new ArrayList();
        intimacyChatTextGuideVo.list = arrayList;
        arrayList.add("test1");
        intimacyChatTextGuideVo.list.add("test2");
        intimacyChatTextGuideVo.list.add("test3");
        ArrayList arrayList2 = new ArrayList();
        intimacyChatTextGuideVo.giftList = arrayList2;
        arrayList2.add(QuickSendVo.getTestItem(false));
        intimacyChatTextGuideVo.giftList.add(QuickSendVo.getTestItem(false));
        intimacyChatTextGuideVo.giftList.add(QuickSendVo.getTestItem(false));
        return intimacyChatTextGuideVo;
    }

    public static IntimacyChatTextGuideVo getGuideVo(int i, String str) {
        List<QuickSendVo> list;
        if (i == TYPE_TEXT) {
            List<String> list2 = gu2.a().chatwindow_sayhi_txt;
            if (list2 != null && list2.size() >= 3) {
                IntimacyChatTextGuideVo intimacyChatTextGuideVo = new IntimacyChatTextGuideVo();
                intimacyChatTextGuideVo.text = str;
                intimacyChatTextGuideVo.type = i;
                ArrayList arrayList = new ArrayList();
                intimacyChatTextGuideVo.list = arrayList;
                arrayList.addAll(list2);
                return intimacyChatTextGuideVo;
            }
        } else if (i == TYPE_GIFT && (list = gu2.a().chatwindow_sayhi_gift) != null && list.size() >= 3) {
            IntimacyChatTextGuideVo intimacyChatTextGuideVo2 = new IntimacyChatTextGuideVo();
            intimacyChatTextGuideVo2.text = str;
            intimacyChatTextGuideVo2.type = i;
            ArrayList arrayList2 = new ArrayList();
            intimacyChatTextGuideVo2.giftList = arrayList2;
            arrayList2.addAll(list);
            return intimacyChatTextGuideVo2;
        }
        return new IntimacyChatTextGuideVo();
    }
}
