package defpackage;

import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.config.QuickMessageConf;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class vp4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static vp4 f21502a = new vp4();

    public static vp4 a() {
        return f21502a;
    }

    public List<String> b(ChatItem chatItem) {
        return c(chatItem);
    }

    public List<String> c(ChatItem chatItem) {
        int gender;
        QuickMessageConf quickMessageConf;
        if (chatItem instanceof ContactInfoItem) {
            gender = ((ContactInfoItem) chatItem).getGender();
        } else {
            ContactInfoItem contactInfoItemA = dn0.a(chatItem.getChatId());
            gender = contactInfoItemA != null ? contactInfoItemA.getGender() : -1;
        }
        if (gender == -1) {
            ContactInfoItem contactInfoItemS = bo0.r().s();
            if (contactInfoItemS.getGender() == 1) {
                gender = 0;
            } else if (contactInfoItemS.getGender() == 0) {
                gender = 1;
            }
        }
        JSONObject config = vs0.a().getConfig("quickgreeting_update");
        List<String> list = null;
        if (config != null) {
            try {
                quickMessageConf = (QuickMessageConf) az2.a(config.toString(), QuickMessageConf.class);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            quickMessageConf = null;
        }
        if (quickMessageConf == null) {
            return null;
        }
        List<QuickMessageConf.QuickMessage> list2 = gender == 1 ? quickMessageConf.female : gender == 0 ? quickMessageConf.male : null;
        if (list2 == null || list2.size() == 0) {
            return null;
        }
        int i = Calendar.getInstance().get(11);
        Iterator<QuickMessageConf.QuickMessage> it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            QuickMessageConf.QuickMessage next = it.next();
            if (i >= next.start && i <= next.end) {
                list = next.txt;
                break;
            }
        }
        return (list == null || list.size() == 0) ? list : d(list, 5);
    }

    public final List<String> d(List<String> list, int i) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list);
        if (arrayList2.size() > 0) {
            Random random = new Random();
            int iMin = Math.min(i, arrayList2.size());
            for (int i2 = 0; i2 < iMin; i2++) {
                int iNextInt = random.nextInt(arrayList2.size());
                String str = (String) arrayList2.get(iNextInt);
                arrayList2.remove(iNextInt);
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public final boolean e(ChatItem chatItem) {
        return SPUtil.f14322a.a(SPUtil.SCENE.CHAT_QUICKSEND, "key_chat_quick_send_hasChat" + chatItem.getChatId(), false);
    }

    public boolean f() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.QUICKGREETING);
        if (dynamicConfig != null) {
            return dynamicConfig.isEnable();
        }
        return false;
    }

    public boolean g(ChatItem chatItem) {
        boolean zF = f();
        boolean zE = a65.e(chatItem);
        boolean zE2 = e(chatItem);
        LogUtil.d("QuickChatHelper", "isEnable:" + zF + " isServiceAccount:" + zE + " hasSendMessage:" + zE2);
        return (zE || zE2) ? false : true;
    }

    public void h(ChatItem chatItem) {
        SPUtil.f14322a.t(SPUtil.SCENE.CHAT_QUICKSEND, "key_chat_quick_send_hasChat" + chatItem.getChatId(), Boolean.TRUE);
    }
}
