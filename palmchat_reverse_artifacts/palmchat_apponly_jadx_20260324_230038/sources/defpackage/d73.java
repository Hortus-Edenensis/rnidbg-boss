package defpackage;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.util.Pair;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.ThreadChatItem;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.NewContactActivity;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.groupchat.GroupInfoItem;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class d73 {
    public static boolean a(Activity activity, String str) {
        ThreadChatItem threadChatItemF = nw5.f(str);
        if (threadChatItemF == null || !threadChatItemF.isContactReady) {
            return false;
        }
        ChatItem chatItemConvert2ContactOrGroupChatInfo = threadChatItemF.convert2ContactOrGroupChatInfo();
        Intent intent = new Intent(AppContext.getContext(), (Class<?>) ChatterActivity.class);
        if (chatItemConvert2ContactOrGroupChatInfo instanceof ContactInfoItem) {
            intent.setExtrasClassLoader(ContactInfoItem.class.getClassLoader());
        } else if (chatItemConvert2ContactOrGroupChatInfo instanceof GroupInfoItem) {
            intent.setExtrasClassLoader(GroupInfoItem.class.getClassLoader());
        }
        intent.putExtra("chat_item", chatItemConvert2ContactOrGroupChatInfo);
        intent.putExtra("thread_biz_type", chatItemConvert2ContactOrGroupChatInfo.getBizType());
        intent.putExtra("chat_need_back_to_main", true);
        intent.putExtra("chat_back_to_greet", false);
        k86.X(intent);
        activity.startActivity(intent);
        return true;
    }

    public static void b(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        Intent intentB = NewContactActivity.h.b(AppContext.getContext());
        intentB.putExtra(BaseActionBarActivity.EXTRA_KEY_NEED_BACK2MAINTAB, true);
        activity.startActivity(intentB);
    }

    public static boolean c(Activity activity, String str) {
        return d(activity, str, false);
    }

    public static boolean d(Activity activity, String str, boolean z) {
        try {
            Intent intentF = bu3.g().f(activity, str, z);
            if (intentF == null) {
                return false;
            }
            activity.startActivity(intentF);
            return true;
        } catch (Exception e) {
            ma3.c(e);
            return false;
        }
    }

    public static boolean e(FrameworkBaseActivity frameworkBaseActivity, boolean z, int i, ContentValues contentValues, String str, ChatItem chatItem) {
        contentValues.put("fromThirdPush", Boolean.valueOf(z));
        contentValues.put("fromLoginRouter", Boolean.TRUE);
        if (chatItem != null) {
            contentValues.put("fromChatId", chatItem.getChatId());
        }
        FrameworkBaseActivity.g.c(true);
        return ve.r(frameworkBaseActivity, new Pair(Integer.valueOf(i), contentValues), str);
    }

    public static boolean f(String str) {
        return str != null && str.contains("a0461");
    }
}
