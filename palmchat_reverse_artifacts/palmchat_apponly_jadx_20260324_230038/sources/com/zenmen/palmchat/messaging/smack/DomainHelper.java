package com.zenmen.palmchat.messaging.smack;

import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ChatItem;
import defpackage.fu5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class DomainHelper {

    /* JADX INFO: compiled from: SearchBox */
    public enum Domains {
        DOMAIN_SINGLECHAT("@youni", false, 0, -1, false),
        DOMAIN_VIDEO("@svo.youni", true, 60, 38, true),
        DOMAIN_FQL("@couple.youni", true, 61, 43, true),
        DOMAIN_VOICE_ROOM("@voicehouse.youni", true, 62, -1, true),
        DOMAIN_KDY("@tinder.youni", true, 63, -1, true),
        DOMAIN_SQUARE("@square.youni", false, 64, 44, true),
        DOMAIN_RECOMMEND("@recommend.youni", false, 68, 46, true),
        DOMAIN_SQUARE_NEARBY("@nearby.youni", false, 65, 46, true),
        DOMAIN_MARRIAGE_MATCH("@match.youni", false, 66, 45, true),
        DOMAIN_DISCUSSION("@discussion.youni", false, 67, 44, true),
        DOMAIN_EDIT_PROFILE("@profile.youni", false, 69, 47, true),
        DOMAIN_PRIVATE("@private.youni", false, 5000, -1, true),
        DOMAIN_GROUPCHAT("@muc.youni", false, 0, -1, false);

        public int bizType;
        public String domain;
        public boolean isTemChat;
        public boolean saveInTempTable;
        public int sourceType;

        Domains(String str, boolean z, int i, int i2, boolean z2) {
            this.domain = str;
            this.saveInTempTable = z;
            this.bizType = i;
            this.sourceType = i2;
            this.isTemChat = z2;
        }

        public String getFilterName() {
            return this.domain.startsWith("@") ? this.domain.substring(1) : this.domain;
        }

        public boolean isEnable() {
            return (this.domain.equals("@svo.youni") || this.domain.equals("@tinder.youni") || this.domain.equals("@voicehouse.youni")) ? false : true;
        }

        public boolean isSingleChat() {
            return (this.domain.equals("@pot.youni") || this.domain.equals("@hoc.youni") || this.domain.equals("@muc.youni")) ? false : true;
        }

        public boolean isTempChat() {
            return this.isTemChat;
        }

        public boolean isTempChatShowInMsgTab() {
            return this.domain.equals("@square.youni") || this.domain.equals("@nearby.youni") || this.domain.equals("@match.youni") || this.domain.equals("@discussion.youni") || this.domain.equals("@recommend.youni") || this.domain.equals("@profile.youni") || this.domain.equals("@private.youni");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14705a;

        static {
            int[] iArr = new int[Domains.values().length];
            f14705a = iArr;
            try {
                iArr[Domains.DOMAIN_GROUPCHAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14705a[Domains.DOMAIN_SINGLECHAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static String a(ChatItem chatItem, boolean z) {
        if (chatItem == null) {
            return null;
        }
        if (chatItem.getChatType() != 0) {
            return chatItem.getChatId() + Domains.DOMAIN_GROUPCHAT.domain;
        }
        if (fu5.t(chatItem.getBizType())) {
            return fu5.h(chatItem.getChatId(), chatItem.getBizType(), z);
        }
        if (!z) {
            return chatItem.getChatId();
        }
        return chatItem.getChatId() + Domains.DOMAIN_SINGLECHAT.domain;
    }

    public static String b() {
        return AccountUtils.p(AppContext.getContext()) + Domains.DOMAIN_SINGLECHAT.domain;
    }

    public static String c(String str, int i) {
        return (TextUtils.isEmpty(str) || !fu5.t(i)) ? str : fu5.h(str, i, false);
    }

    public static String d(String str, Domains domains) {
        return (TextUtils.isEmpty(str) || !fu5.v(domains)) ? str : fu5.i(str, domains, false);
    }

    public static String e(ChatItem chatItem) {
        return a(chatItem, false);
    }

    public static String f(MessageVo messageVo) {
        return n(messageVo.contactRelate) == Domains.DOMAIN_SINGLECHAT ? fu5.h(j(messageVo.contactRelate), messageVo.bizType, true) : messageVo.contactRelate;
    }

    public static String g(Uri uri, String str) {
        return str + Domains.DOMAIN_GROUPCHAT.domain;
    }

    public static int h(String str, int i) {
        Domains[] domainsArrValues = Domains.values();
        int length = domainsArrValues.length;
        for (int i2 = 0; i2 < length; i2++) {
            Domains domains = domainsArrValues[i2];
            if (domains.domain.equals(str) || domains.domain.contains(str)) {
                return Domains.DOMAIN_PRIVATE == domains ? i + 5000 : domains.bizType;
            }
        }
        return 5000;
    }

    public static int i(ChatItem chatItem) {
        int bizType = chatItem.getBizType();
        return (Domains.DOMAIN_PRIVATE.domain.equalsIgnoreCase(m(chatItem).domain) && fu5.q(bizType)) ? bizType + AVMDLDataLoader.AVMDLErrorIsInvalidFileWrite : bizType;
    }

    public static String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Domains domainsN = n(str);
        int i = a.f14705a[domainsN.ordinal()];
        int iIndexOf = i != 1 ? i != 2 ? -1 : str.indexOf(Domains.DOMAIN_SINGLECHAT.domain) : str.indexOf(Domains.DOMAIN_GROUPCHAT.domain);
        if (fu5.v(domainsN)) {
            iIndexOf = str.indexOf(domainsN.domain);
        }
        return iIndexOf >= 0 ? str.substring(0, iIndexOf) : str;
    }

    public static String k(String str) {
        int iIndexOf;
        return (TextUtils.isEmpty(str) || (iIndexOf = str.indexOf("/")) < 0) ? str : str.substring(0, iIndexOf);
    }

    public static String l(ChatItem chatItem) {
        if (chatItem != null) {
            return chatItem.getChatType() == 0 ? fu5.t(chatItem.getBizType()) ? fu5.h(chatItem.getChatId(), chatItem.getBizType(), false) : chatItem.getChatId() : chatItem.getChatId();
        }
        return null;
    }

    public static Domains m(ChatItem chatItem) {
        return o(chatItem.getBizType(), chatItem.getChatType() == 0);
    }

    public static Domains n(String str) {
        Domains domains = Domains.DOMAIN_SINGLECHAT;
        if (TextUtils.isEmpty(str)) {
            return domains;
        }
        for (Domains domains2 : Domains.values()) {
            if (domains2.isEnable() && str.contains(domains2.domain)) {
                return domains2;
            }
        }
        return domains;
    }

    public static Domains o(int i, boolean z) {
        Domains domains = Domains.DOMAIN_SINGLECHAT;
        if (!z) {
            return Domains.DOMAIN_GROUPCHAT;
        }
        if (fu5.q(i)) {
            return Domains.DOMAIN_PRIVATE;
        }
        for (Domains domains2 : Domains.values()) {
            if (domains2.bizType == i && domains2.isSingleChat() == z) {
                return domains2;
            }
        }
        return domains;
    }

    public static String p(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Domains domainsN = n(str);
        if (fu5.v(domainsN) || a.f14705a[domainsN.ordinal()] != 1) {
            return str;
        }
        int iIndexOf = str.indexOf("/");
        if (iIndexOf >= 0) {
            return str.substring(iIndexOf + 1, str.length());
        }
        return null;
    }

    public static String q(String str) {
        if (str == null) {
            return str;
        }
        Domains domainsN = n(str);
        if (domainsN.isSingleChat()) {
            return u(str, domainsN);
        }
        if (!str.contains("/")) {
            return str.replace(Domains.DOMAIN_GROUPCHAT.domain, "");
        }
        int iIndexOf = str.indexOf("/") + 1;
        return iIndexOf > 0 ? str.substring(iIndexOf) : str;
    }

    public static boolean r(String str) {
        return !TextUtils.isEmpty(str) && str.contains("@cmd.youni");
    }

    public static String s(String str) {
        if (str == null) {
            return str;
        }
        for (Domains domains : Domains.values()) {
            if (domains.isEnable() && domains.isTempChat() && str.contains(domains.domain)) {
                return str.substring(0, str.indexOf(domains.domain));
            }
        }
        return str;
    }

    public static String t(String str) {
        if (str == null) {
            return str;
        }
        for (Domains domains : Domains.values()) {
            if (domains.isEnable() && domains.isSingleChat() && str.contains(domains.domain)) {
                return u(str, domains);
            }
        }
        return str;
    }

    public static String u(String str, Domains domains) {
        return str.contains(domains.domain) ? str.substring(0, str.indexOf(domains.domain)) : str;
    }
}
