package com.zenmen.palmchat.chat.aigreeting.vo;

import androidx.annotation.Keep;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class AiGreetingListItem {
    public static final int STATE_OK = 0;
    public static final int STATE_REQUESTING = 1;
    public static final int STATE_REQUEST_FAIL = 2;
    public int state;
    public String title;

    public AiGreetingListItem(String str, int i) {
        this.title = str;
        this.state = i;
    }

    public static List<AiGreetingListItem> getList(LXBaseNetBean<AiGreetingInfo> lXBaseNetBean) {
        AiGreetingInfo aiGreetingInfo;
        ArrayList arrayList = new ArrayList();
        if (lXBaseNetBean != null && lXBaseNetBean.isSuccess() && (aiGreetingInfo = lXBaseNetBean.data) != null && aiGreetingInfo.textList != null) {
            Iterator<String> it = aiGreetingInfo.textList.iterator();
            while (it.hasNext()) {
                arrayList.add(new AiGreetingListItem(it.next(), 0));
            }
        }
        return arrayList;
    }
}
