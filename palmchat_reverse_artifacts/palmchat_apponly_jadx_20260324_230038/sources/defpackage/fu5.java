package defpackage;

import android.content.Intent;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.e.comm.constants.ErrorCode;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.conversations.threadgroup.ThreadFolderManager;
import com.zenmen.palmchat.database.b;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class fu5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f17604a = "TemporaryChatManager";
    public static int b = 9;
    public static int c;
    public static HashMap<Integer, Pair<Integer, Integer>> d = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<Integer, Pair<Integer, Integer>> {
        public a() {
            put(60, new Pair(38, Integer.valueOf(fu5.c)));
            put(61, new Pair(43, Integer.valueOf(fu5.c)));
            put(62, new Pair(-1, Integer.valueOf(fu5.c)));
            put(63, new Pair(-1, Integer.valueOf(fu5.c)));
            put(64, new Pair(44, 1));
            put(68, new Pair(46, 1));
            put(65, new Pair(46, 2));
            put(66, new Pair(45, Integer.valueOf(fu5.c)));
            put(67, new Pair(44, 3));
            put(69, new Pair(47, Integer.valueOf(fu5.c)));
            put(5000, new Pair(60, 0));
        }
    }

    public static int A(int i, boolean z) {
        LogUtil.i(f17604a + "_parseMessageProto", "value: " + i);
        int i2 = (i >> 8) & 1023;
        int i3 = i & 255;
        LogUtil.i(f17604a + "_parseMessageProto", "bizType:" + i2 + " subType:" + i3);
        return z ? i2 : i3;
    }

    public static void a(StringBuilder sb, ArrayList<String> arrayList, boolean z) {
        b(sb, arrayList, z, true);
    }

    public static void b(StringBuilder sb, ArrayList<String> arrayList, boolean z, boolean z2) {
        StringBuilder sb2 = new StringBuilder();
        HashSet<Integer> hashSet = new HashSet();
        HashSet<Integer> hashSet2 = new HashSet();
        Pair<Integer, Integer> pair = null;
        int i = 0;
        for (DomainHelper.Domains domains : DomainHelper.Domains.values()) {
            if (domains.isEnable() && domains.isTempChat() && (!z || domains.isTempChatShowInMsgTab())) {
                ThreadFolderManager.FolderType folderTypeA = com.zenmen.palmchat.conversations.threadgroup.a.a(domains.bizType);
                if (folderTypeA == null || !folderTypeA.enable()) {
                    hashSet.add(Integer.valueOf(domains.bizType));
                } else {
                    if (z2) {
                        hashSet.add(Integer.valueOf(folderTypeA.groupBizType));
                    }
                    if (10005 == folderTypeA.groupBizType) {
                        hashSet2.addAll(Arrays.asList(folderTypeA.bizTypes));
                        pair = folderTypeA.region;
                    }
                }
            }
        }
        if (hashSet.size() > 0) {
            for (Integer num : hashSet) {
                sb.append("thread_biz_type");
                sb.append("=? or ");
                arrayList.add(String.valueOf(num));
                sb2.append("thread_biz_type");
                sb2.append(ContainerUtils.KEY_VALUE_DELIMITER + num + " or ");
            }
        }
        if (hashSet2.size() > 0) {
            sb.append("(");
            sb.append("(");
            sb2.append("((");
            if (pair != null) {
                sb.append("(thread_biz_type>=" + pair.first + " and thread_biz_type<= " + pair.second + ") or ");
                sb2.append("(thread_biz_type>=" + pair.first + " and thread_biz_type<= " + pair.second + ") or ");
            }
            for (Integer num2 : hashSet2) {
                i++;
                if (i < hashSet2.size()) {
                    sb.append("thread_biz_type");
                    sb.append("=? or ");
                    sb2.append("thread_biz_type");
                    sb2.append(ContainerUtils.KEY_VALUE_DELIMITER + num2 + " or ");
                } else {
                    sb.append("thread_biz_type");
                    sb.append("=? ");
                    sb2.append("thread_biz_type");
                    sb2.append(ContainerUtils.KEY_VALUE_DELIMITER + num2 + " ");
                }
                arrayList.add(String.valueOf(num2));
            }
            sb.append(")");
            sb2.append(")");
            if (z2) {
                sb.append(" and ");
                sb2.append(" and ");
                sb.append("latest_message_time_stamp");
                sb.append(">=?");
                arrayList.add(String.valueOf(System.currentTimeMillis() - mo5.d()));
                sb2.append("latest_message_time_stamp");
                sb2.append(">=" + String.valueOf(System.currentTimeMillis() - mo5.d()));
            }
            sb.append(") or ");
            sb2.append(") or ");
        }
        LogUtil.i(f17604a, "appendForMessageThreadQuery " + sb2.toString());
    }

    public static void c(StringBuilder sb, ArrayList<String> arrayList, String str) {
        for (DomainHelper.Domains domains : DomainHelper.Domains.values()) {
            if (domains.isEnable() && domains.isTempChat()) {
                sb.append(" or contact_relate=?");
                arrayList.add(i(str, domains, false));
            }
        }
    }

    public static boolean d(int i) {
        return t(i) && ha3.a() && 61 == i;
    }

    public static int e(DomainHelper.Domains domains, MessageProto.Message message) {
        return (DomainHelper.Domains.DOMAIN_PRIVATE != domains || message == null) ? domains.bizType : A(message.getSubType(), true) + 5000;
    }

    public static int f(int i, int i2) {
        if (i == -1) {
            return i2;
        }
        for (DomainHelper.Domains domains : DomainHelper.Domains.values()) {
            if (domains.sourceType == i) {
                return domains.bizType;
            }
        }
        return i2;
    }

    public static int g(int i, String str) {
        if (v8.C(str)) {
            return 5068;
        }
        return f(i, ErrorCode.IMAGE_LOAD_ERROR);
    }

    public static String h(String str, int i, boolean z) {
        return i(str, k(i), z);
    }

    public static String i(String str, DomainHelper.Domains domains, boolean z) {
        if (!domains.saveInTempTable && !z) {
            return str;
        }
        return str + domains.domain;
    }

    public static Pair<String, Integer> j(int i) {
        String str = k(i).domain;
        if (DomainHelper.Domains.DOMAIN_PRIVATE.domain.equalsIgnoreCase(str) && q(i)) {
            i += AVMDLDataLoader.AVMDLErrorIsInvalidFileWrite;
        }
        return new Pair<>(str, Integer.valueOf(i));
    }

    public static DomainHelper.Domains k(int i) {
        return DomainHelper.o(i, true);
    }

    public static Pair<Integer, Integer> l(int i) {
        Pair<Integer, Integer> pair = d.get(Integer.valueOf(i));
        return (pair == null && q(i)) ? new Pair<>(60, Integer.valueOf(i + AVMDLDataLoader.AVMDLErrorIsInvalidFileWrite)) : pair;
    }

    public static String m(int i) {
        if (i == 61) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_fql));
        }
        if (i == 60) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_smallvideo));
        }
        if (i == 62) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_voice_room));
        }
        if (i == 63) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_people_match));
        }
        if (i == 64) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_square));
        }
        if (i == 65) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_nearby));
        }
        if (i == 66) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_marriage_match));
        }
        if (i == 67) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_discussion));
        }
        if (i == 68) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_find_friend_recommend));
        }
        if (i == 69) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_profile));
        }
        if (i == 5001) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_venus));
        }
        if (i == 5039) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_dynamic_super_expose));
        }
        if (i == 5002 || i == 5006) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_pytj));
        }
        if (i == 5004 || i == 5038) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_jryf));
        }
        if (i == 5003) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_xdpp));
        }
        if (i == 5005) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_nearby));
        }
        if (i == 5008) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_newfriend));
        }
        if (i == 5012) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_ylqx));
        }
        if (i == 5014) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_family_group));
        }
        if (i == 5015 || i == 5020) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_kdysh));
        }
        if (i == 5034) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_voicematch));
        }
        if (i == 5043) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_voicematch_video));
        }
        if (i == 5017) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_kdylike));
        }
        if (i == 5016) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_pzjy));
        }
        if (i == 5035) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_maptrip));
        }
        if (s(i)) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_super_expose));
        }
        if (i == 5045 || i == 5046 || i == 5047 || i == 5048 || i == 5049 || i == 5050) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_zj));
        }
        if (i == 5021 || i == 5062) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_find_map));
        }
        if (i == 5023 || i == 5033) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_map_separation));
        }
        if (i == 5030) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_ai_sleep));
        }
        if (i == 5052) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_square_gift));
        }
        if (i == 5042) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_ai_quick_match));
        }
        if (i == 5051) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_polish));
        }
        if (i == 5054) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_chatone));
        }
        if (i == 5053) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_chat_mate));
        }
        if (i == 5055 || i == 5058) {
            return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_online_text));
        }
        if (!q(i)) {
            return null;
        }
        return String.format(zk5.b(R.string.from) + " \"%s\"", zk5.b(R.string.source_type_private_chat));
    }

    public static int n(int i) {
        int i2;
        DomainHelper.Domains[] domainsArrValues = DomainHelper.Domains.values();
        int length = domainsArrValues.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                i2 = -1;
                break;
            }
            DomainHelper.Domains domains = domainsArrValues[i3];
            if (domains.bizType == i) {
                i2 = domains.sourceType;
                break;
            }
            i3++;
        }
        if (q(i)) {
            i2 = 60;
        }
        LogUtil.i("logaddfriend", "getSourceTypeForBizType sourceType=" + i2);
        return i2;
    }

    public static int o(MessageProto.Message message) {
        if (message == null) {
            return 0;
        }
        return DomainHelper.Domains.DOMAIN_PRIVATE == b.n(message) ? A(message.getSubType(), false) : message.getSubType();
    }

    public static boolean p(int i) {
        if (t(i)) {
            return 64 == i || 65 == i || 66 == i || 67 == i || 68 == i || 69 == i || q(i);
        }
        return false;
    }

    public static boolean q(int i) {
        return i >= 5000 && i <= 6023;
    }

    public static boolean r(String[] strArr) {
        return (strArr == null || strArr.length < 2 || TextUtils.isEmpty(strArr[0]) || TextUtils.isEmpty(strArr[1])) ? false : true;
    }

    public static boolean s(int i) {
        return i == 5018 || i == 5027 || i == 5024 || i == 5028 || i == 5026 || i == 5029 || i == 5056 || i == 5057 || i == 5039;
    }

    public static boolean t(int i) {
        return 61 == i || 60 == i || 62 == i || 63 == i || 64 == i || 65 == i || 66 == i || 67 == i || 68 == i || 69 == i || q(i);
    }

    public static boolean u(ChatItem chatItem) {
        if (chatItem != null) {
            return t(chatItem.getBizType());
        }
        return false;
    }

    public static boolean v(DomainHelper.Domains domains) {
        return domains.isTempChat();
    }

    public static boolean w(MessageProto.Message message) {
        int iM = b.m(message);
        return iM == 13 || iM == 14 || t(iM) || (message != null && o(message) == 16);
    }

    public static int x(int i, int i2) {
        if (q(i)) {
            i += AVMDLDataLoader.AVMDLErrorIsInvalidFileWrite;
        }
        LogUtil.i(f17604a + "_joinMessageSubtype", "bizType:" + i + " subType:" + i2);
        int i3 = (i << 8) | i2;
        StringBuilder sb = new StringBuilder();
        sb.append(f17604a);
        sb.append("_joinMessageSubtype");
        LogUtil.i(sb.toString(), "value: " + i3);
        return i3;
    }

    public static void y(String str, int i, int i2, boolean z) {
        if (bo0.r().l(str) == null) {
            Cursor cursorQuery = AppContext.getContext().getContentResolver().query(ho0.f18003a, null, "uid=?", new String[]{str}, null);
            if (cursorQuery != null) {
                z = cursorQuery.getCount() > 0;
                cursorQuery.close();
            } else {
                z = false;
            }
        }
        Intent intent = new Intent(AppContext.getContext(), (Class<?>) ChatterActivity.class);
        ContactInfoItem contactInfoItem = new ContactInfoItem();
        contactInfoItem.setUid(str);
        if (z) {
            contactInfoItem.setBizType(i2);
        } else {
            contactInfoItem.setSourceType(i);
            contactInfoItem.setBizType(i2);
            intent.putExtra("chat_from", "temporary_chat_notification");
        }
        intent.putExtra("chat_item", contactInfoItem);
        intent.putExtra("thread_biz_type", i2);
        intent.putExtra("chat_need_back_to_main", z);
        k86.X(intent);
        AppContext.getContext().startActivity(intent);
    }

    public static void z(String str, int i, boolean z, String... strArr) {
        boolean z2;
        Intent intent;
        ContactInfoItem contactInfoItem = new ContactInfoItem();
        contactInfoItem.setUid(str);
        if (bo0.r().l(str) != null) {
            z2 = true;
        } else {
            Cursor cursorQuery = AppContext.getContext().getContentResolver().query(ho0.f18003a, null, "uid=?", new String[]{str}, null);
            if (cursorQuery != null) {
                z2 = cursorQuery.getCount() > 0;
                cursorQuery.close();
            } else {
                z2 = false;
            }
        }
        if (!z2 && r(strArr)) {
            contactInfoItem.setIconURL(strArr[0]);
            contactInfoItem.setNickName(strArr[1]);
            contactInfoItem.setSourceType(n(i));
            AppContext.getContext().getContentResolver().insert(ho0.f18003a, nn0.c(contactInfoItem));
            z2 = true;
        }
        if (z2) {
            intent = new Intent(AppContext.getContext(), (Class<?>) ChatterActivity.class);
            contactInfoItem.setUid(str);
            contactInfoItem.setBizType(i);
            if (strArr != null && strArr.length >= 3) {
                String str2 = strArr[2];
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        if (jSONObject.optInt("showSendGift") == 1) {
                            intent.putExtra("chat_mate_need_send_gift", 1);
                        }
                        intent.putExtra("chat_mate_activity_from", jSONObject.optInt("from"));
                        if (jSONObject.optInt("joinChatmate") == 1) {
                            String strOptString = jSONObject.optString("roommateId");
                            if (!TextUtils.isEmpty(strOptString)) {
                                o30.C(str, strOptString, 2);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            intent.putExtra("chat_item", contactInfoItem);
            intent.putExtra("thread_biz_type", i);
            intent.putExtra("chat_need_back_to_main", z);
        } else {
            intent = new Intent(AppContext.getContext(), (Class<?>) MainTabsActivity.class);
            intent.putExtra("new_intent_position", "tab_msg");
        }
        k86.X(intent);
        AppContext.getContext().startActivity(intent);
    }
}
