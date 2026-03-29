package defpackage;

import android.text.Html;
import android.text.TextUtils;
import com.baidu.location.LocationConst;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class a65 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashSet<String> f1161a = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashSet<String> {
        public a() {
            add("2849602035597312");
            add("6784941294553088");
            add("6202177136563200");
            add("7146103898604544");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageProto.Message f1162a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public b(MessageProto.Message message, String str, String str2) {
            this.f1162a = message;
            this.b = str;
            this.c = str2;
            put("mid", message.getMid());
            put("from", str);
            put("type", Integer.valueOf(message.getType()));
            put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, str2);
        }
    }

    public static String a() {
        return nl0.k() ? "6202177136563200" : "7146103898604544";
    }

    public static String b(String str) {
        return TextUtils.isEmpty(str) ? "" : Html.fromHtml(qf2.a(str)).toString();
    }

    public static boolean c(ChatItem chatItem) {
        if (chatItem != null && chatItem.getChatType() == 0 && (chatItem instanceof ContactInfoItem)) {
            return f1161a.contains(((ContactInfoItem) chatItem).getChatId());
        }
        return false;
    }

    public static boolean d(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("88888") && str.length() == 8;
    }

    public static boolean e(ChatItem chatItem) {
        if (chatItem != null && chatItem.getChatType() == 0 && (chatItem instanceof ContactInfoItem)) {
            return (((ContactInfoItem) chatItem).getAccountType() == 1) || d(chatItem.getChatId());
        }
        return false;
    }

    public static boolean f(String str) {
        ContactInfoItem contactInfoItemL = bo0.r().l(str);
        return (contactInfoItemL != null && contactInfoItemL.getAccountType() == 1) || d(str);
    }

    public static void g(MessageProto.Message message, String str) {
        if (message != null) {
            String strA = m40.a(message.getFrom());
            if (f(strA)) {
                LogUtil.uploadInfoImmediate("msg_ser_receive", new b(message, strA, str));
            }
        }
    }

    public static boolean h(ChatItem chatItem) {
        if (chatItem != null && chatItem.getChatType() == 0 && (chatItem instanceof ContactInfoItem)) {
            return jw5.c(((ContactInfoItem) chatItem).getSessionConfig(), 64);
        }
        return true;
    }

    public static boolean i(ContactInfoItem contactInfoItem) {
        if (contactInfoItem == null || contactInfoItem.getAccountType() != 1) {
            return true;
        }
        return jw5.c(contactInfoItem.getSessionConfig(), 32);
    }
}
