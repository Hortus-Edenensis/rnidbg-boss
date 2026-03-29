package defpackage;

import android.app.Activity;
import android.os.Bundle;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.temporary.SquareTempChatActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.settings.portrait.PortraitAlbumActivity;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class x20 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Set<String> f21859a = new HashSet();

    public static String a(Object obj, ChatItem chatItem, MessageVo messageVo, Map<String, y56> map) {
        y56 y56Var;
        y56 y56Var2;
        String strReplace = messageVo.text;
        if (map != null && map.size() > 0 && map.keySet() != null) {
            for (String str : map.keySet()) {
                if (str.contains("a0450") && (y56Var2 = map.get(str)) != null && y56Var2.g() != null) {
                    if (d()) {
                        strReplace = strReplace.replace(y56Var2.g(), "通知Ta已完善>");
                    }
                    i(obj, chatItem, messageVo);
                }
                if (str.contains("a0451") && (y56Var = map.get(str)) != null && y56Var.g() != null) {
                    if (c()) {
                        strReplace = strReplace.replace(y56Var.g(), "通知Ta已完善>");
                    }
                    i(obj, chatItem, messageVo);
                }
            }
        }
        return strReplace;
    }

    public static String b() {
        return "嗨！我已完成了你的邀请[微笑]！";
    }

    public static boolean c() {
        ContactInfoItem contactInfoItemA = dn0.a(AccountUtils.p(AppContext.getContext()));
        if (contactInfoItemA != null) {
            return contactInfoItemA.hasPortrait();
        }
        return false;
    }

    public static boolean d() {
        int i;
        ContactInfoItem contactInfoItemA = dn0.a(AccountUtils.p(AppContext.getContext()));
        if (contactInfoItemA == null) {
            return false;
        }
        try {
            i = Integer.parseInt(contactInfoItemA.getAge());
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        return (i > 0) && (contactInfoItemA.getGender() == 0 || contactInfoItemA.getGender() == 1) && !contactInfoItemA.needCompleteProfile();
    }

    public static void e(Activity activity, ChatItem chatItem) {
        if (!d()) {
            h("privatechat_invitetxtclck", chatItem);
            activity.startActivity(nn4.a(activity, 5));
            return;
        }
        h("privatechat_invitetxtnotice", chatItem);
        if (activity instanceof ChatterActivity) {
            ((ChatterActivity) activity).J4();
        } else if (activity instanceof SquareTempChatActivity) {
            ((SquareTempChatActivity) activity).S1();
        }
    }

    public static void f(Activity activity, ChatItem chatItem) {
        if (!c()) {
            h("privatechat_invitetxtclck", chatItem);
            Bundle bundle = new Bundle();
            bundle.putInt("from", 4);
            PortraitAlbumActivity.f2(activity, bundle);
            return;
        }
        h("privatechat_invitetxtnotice", chatItem);
        if (activity instanceof ChatterActivity) {
            ((ChatterActivity) activity).J4();
        } else if (activity instanceof SquareTempChatActivity) {
            ((SquareTempChatActivity) activity).S1();
        }
    }

    public static void g(Activity activity, ChatItem chatItem) {
        h("privatechat_invitetxtclck", chatItem);
        bj5.b().a().c0(activity, 8, null, null, null, true);
    }

    public static void h(String str, ChatItem chatItem) {
        HashMap map = new HashMap();
        if (chatItem != null && (chatItem instanceof ContactInfoItem)) {
            ContactInfoItem contactInfoItem = (ContactInfoItem) chatItem;
            map.put("targetUid", contactInfoItem.getUid());
            map.put("targetExid", contactInfoItem.getExid());
        }
        zn6.i(str, map);
    }

    public static void i(Object obj, ChatItem chatItem, MessageVo messageVo) {
        String str = obj.toString() + messageVo.mid;
        if (f21859a.contains(str)) {
            return;
        }
        f21859a.add(str);
        HashMap map = new HashMap();
        if (chatItem != null && (chatItem instanceof ContactInfoItem)) {
            ContactInfoItem contactInfoItem = (ContactInfoItem) chatItem;
            map.put("targetUid", contactInfoItem.getUid());
            map.put("targetExid", contactInfoItem.getExid());
        }
        zn6.i("privatechat_invitetxtshow", map);
    }
}
