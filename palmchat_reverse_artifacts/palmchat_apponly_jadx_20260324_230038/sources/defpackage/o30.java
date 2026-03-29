package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.utils.Async;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.ThreadChatItem;
import com.zenmen.palmchat.chat.mate.ChatMateActivityStatusData;
import com.zenmen.palmchat.chat.mate.ChatMateGuideMsgData;
import com.zenmen.palmchat.chat.mate.ChatMateJumpData;
import com.zenmen.palmchat.chat.mate.ChatMateRoomTypeData;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.conversations.threadsnew.adapter.ConversationAdapter;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.mine.view.LoopTextView;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class o30 {
    public static ConversationAdapter.d G;
    public static String q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ArrayList<ConversationAdapter.a> f19670a = new ArrayList<>();
    public static boolean b = true;
    public static int c = 5;
    public static ArrayList<String> d = new ArrayList<>();
    public static boolean e = true;
    public static int f = 5;
    public static ArrayList<String> g = new ArrayList<>();
    public static int h = 600;
    public static int i = 1;
    public static int j = 3;
    public static int k = 2;
    public static boolean l = true;
    public static int m = 1440;
    public static int n = 5;
    public static int o = 2;
    public static int p = 600;
    public static ArrayList<String> r = new ArrayList<>();
    public static String s = "试试一键召唤5人畅聊";
    public static boolean t = true;
    public static boolean u = true;
    public static int v = 5;
    public static ArrayList<String> w = new ArrayList<>();
    public static int x = 1;
    public static int y = 3;
    public static int z = 3;
    public static int A = 600;
    public static LoopTextView B = null;
    public static Handler C = new Handler(Looper.getMainLooper());
    public static String D = "点击获得更多礼物";
    public static String E = "点击获得更多礼物";
    public static String F = "确定将礼物送给TA？送出后，本次召唤任务将结束。其他参与的异性还可以和你继续聊天~";

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f19671a;
        public final /* synthetic */ int b;
        public final /* synthetic */ ConversationAdapter.a c;
        public final /* synthetic */ ConversationAdapter d;

        public a(List list, int i, ConversationAdapter.a aVar, ConversationAdapter conversationAdapter) {
            this.f19671a = list;
            this.b = i;
            this.c = aVar;
            this.d = conversationAdapter;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f19671a.add(this.b, this.c);
                this.d.notifyDataSetChanged();
                o30.f19670a.add(this.c);
                int iA = cx5.b().a() + 1;
                cx5.b().h(iA);
                LogUtil.d("ChatMateGiftManagerTAG", "ChatMateGiftManager addChatMateListMsg 塞入成功的targetPosition " + this.b + " 未读总数为 " + iA);
            } catch (Exception e) {
                LogUtil.d("ChatMateGiftManagerTAG", "ChatMateGiftManager addChatMateListMsg Exception " + e.toString());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19672a;

        public b(String str) {
            this.f19672a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            o30.B(this.f19672a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends go2<LXBaseNetBean<ChatMateJumpData>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19673a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Activity d;

        public c(String str, int i, String str2, Activity activity) {
            this.f19673a = str;
            this.b = i;
            this.c = str2;
            this.d = activity;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put(DeviceInfoUtil.UID_TAG, v4.e(AppContext.getContext()));
            map.put("roomId", this.f19673a);
            map.put("from", Integer.valueOf(this.b));
            return sw4.b(1, nl0.z + "/chat.mate.jump.v1", map).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<ChatMateJumpData> lXBaseNetBean, Exception exc) {
            LogUtil.i("ChatMateGiftManagerTAG", "postItemClick roomId " + this.f19673a + " info onResult=" + az2.c(lXBaseNetBean));
            if (lXBaseNetBean != null) {
                try {
                    ChatMateJumpData chatMateJumpData = lXBaseNetBean.data;
                    if (chatMateJumpData != null) {
                        if (!TextUtils.isEmpty(chatMateJumpData.msg)) {
                            sy5.h(AppContext.getContext(), lXBaseNetBean.data.msg, 0);
                        }
                        if (TextUtils.isEmpty(lXBaseNetBean.data.url)) {
                            return;
                        }
                        if (!TextUtils.isEmpty(this.f19673a)) {
                            o30.C(this.c, this.f19673a, 1);
                            o30.C(v4.e(AppContext.getContext()), this.f19673a, 2);
                        }
                        ve.o(this.d, lXBaseNetBean.data.url, false);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends go2<LXBaseNetBean<ChatMateActivityStatusData>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19674a;
        public final /* synthetic */ sk2 b;

        public d(String str, sk2 sk2Var) {
            this.f19674a = str;
            this.b = sk2Var;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put(DeviceInfoUtil.UID_TAG, this.f19674a);
            return sw4.b(1, nl0.z + "/chat.mate.my.room.v1", map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<ChatMateActivityStatusData> lXBaseNetBean, Exception exc) {
            ChatMateRoomTypeData chatMateRoomTypeDataL;
            String str;
            sk2 sk2Var;
            LogUtil.i("ChatMateGiftManagerTAG", "roomDataCheck postChatActivityMateStatus info onResult=" + az2.c(lXBaseNetBean));
            if (lXBaseNetBean == null) {
                return;
            }
            try {
                int i = lXBaseNetBean.resultCode;
                if (i == 0) {
                    ChatMateActivityStatusData chatMateActivityStatusData = lXBaseNetBean.data;
                    if (chatMateActivityStatusData == null || (sk2Var = this.b) == null) {
                        return;
                    }
                    sk2Var.onSuccess(chatMateActivityStatusData);
                    return;
                }
                if (i == 3005) {
                    ChatMateActivityStatusData chatMateActivityStatusData2 = lXBaseNetBean.data;
                    String str2 = chatMateActivityStatusData2 != null ? chatMateActivityStatusData2.roomId : "";
                    if (TextUtils.isEmpty(str2) && (chatMateRoomTypeDataL = o30.l(this.f19674a)) != null && (str = chatMateRoomTypeDataL.roomId) != null) {
                        str2 = str;
                    }
                    o30.B(str2);
                }
            } catch (Exception e) {
                LogUtil.d("ChatMateGiftManagerTAG", "postChatActivityMateStatus e " + e.toString());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatItem f19675a;
        public final /* synthetic */ Activity b;

        public e(ChatItem chatItem, Activity activity) {
            this.f19675a = chatItem;
            this.b = activity;
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x0070  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            ThreadChatItem threadChatItem;
            ThreadChatItem threadChatItemF;
            String chatId = this.f19675a.getChatId();
            if (chatId != null) {
                ArrayList arrayList = new ArrayList();
                List<String> listE = nw5.e();
                if (listE != null && listE.size() > 0) {
                    for (int i = 0; i < listE.size(); i++) {
                        String str = listE.get(i);
                        if (o30.q(str) && (threadChatItemF = nw5.f(str)) != null) {
                            arrayList.add(threadChatItemF);
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    int i2 = 0;
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (chatId.equals(((ThreadChatItem) arrayList.get(i3)).relativeContact)) {
                            i2 = i3 + 1;
                        }
                    }
                    if (i2 == arrayList.size()) {
                        i2 = 0;
                    }
                    threadChatItem = (i2 < 0 || i2 >= arrayList.size()) ? null : (ThreadChatItem) arrayList.get(i2);
                }
            }
            if (threadChatItem == null || this.b == null) {
                return;
            }
            if (chatId.equals(threadChatItem.relativeContact)) {
                sy5.h(this.b, "暂时没有更多会话", 0);
                return;
            }
            Intent intent = new Intent(this.b, (Class<?>) ChatterActivity.class);
            intent.setExtrasClassLoader(ChatItem.class.getClassLoader());
            ChatItem chatItemConvert2ContactOrGroupChatInfo = threadChatItem.convert2ContactOrGroupChatInfo();
            if (chatItemConvert2ContactOrGroupChatInfo == null) {
                return;
            }
            if (chatItemConvert2ContactOrGroupChatInfo instanceof ContactInfoItem) {
                intent.setExtrasClassLoader(ContactInfoItem.class.getClassLoader());
            }
            intent.putExtra("chat_item", chatItemConvert2ContactOrGroupChatInfo);
            intent.putExtra("thread_biz_type", threadChatItem.getBizType());
            intent.putExtra("chat_mate_activity_from", 16);
            this.b.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends go2<LXBaseNetBean<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19676a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public f(String str, String str2, String str3) {
            this.f19676a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put(DeviceInfoUtil.UID_TAG, this.f19676a);
            map.put("toUid", this.b);
            map.put("roomId", this.c);
            return sw4.b(1, nl0.z + "/chat.mate.give.gift.v1", map).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<String> lXBaseNetBean, Exception exc) {
            LogUtil.i("ChatMateGiftManagerTAG", "confirmPostSendGift roomId " + this.c + " info onResult=" + az2.c(lXBaseNetBean));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f19677a;

        public g(JSONObject jSONObject) {
            this.f19677a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            int length;
            String strOptString = this.f19677a.optString("roomId");
            int iOptInt = this.f19677a.optInt("maxChatSize");
            JSONArray jSONArrayOptJSONArray = this.f19677a.optJSONArray("joinUids");
            String str = this.f19677a.optLong("oid", 0L) + "";
            if (!"0".equals(str)) {
                o30.C(str, strOptString, 1);
            }
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                length = -1;
            } else {
                length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    o30.C(jSONArrayOptJSONArray.optLong(i) + "", strOptString, 2);
                }
            }
            m30 m30Var = new m30(6);
            m30Var.c = strOptString;
            m30Var.d = str;
            m30Var.e = iOptInt;
            m30Var.f = length;
            ds0.a().b(m30Var);
        }
    }

    static {
        d.clear();
        d.add("<p ><span style=\"color: #999999; font-size: 14px\">还在苦苦等待回复？试试最佳聊友，一键召唤异性热聊</span><span style=\"color: #14CD64\">点击试试> </span></p>");
        g.clear();
        g.add("<p ><span style=\"color: #999999; font-size: 14px\">还在苦苦等待回复？试试最佳聊友，一键召唤异性热聊</span><span style=\"color: #14CD64\">点击试试> </span></p>");
        r.clear();
        r.add("找不到人聊？");
        w.clear();
        w.add("<p ><span style=\"color: #999999; font-size: 14px\">礼物不够多？试试最佳聊友，高价值礼物聊天就可抢！</span><span style=\"color: #14CD64\">点击试试> </span></p>");
    }

    public static void A(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("chatmate")) == null) {
            return;
        }
        String strOptString = jSONObjectOptJSONObject.optString("roomId");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        C.post(new b(strOptString));
    }

    public static void B(String str) {
        String[] strArrB;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        m30 m30Var = new m30(3);
        m30Var.c = str;
        ds0.a().b(m30Var);
        ArrayList arrayList = new ArrayList();
        SharedPreferences sharedPreferencesM = SPUtil.f14322a.m(SPUtil.SCENE.CHATROOMMATE);
        if ((sharedPreferencesM instanceof xp3) && (strArrB = ((xp3) sharedPreferencesM).b()) != null && strArrB.length > 0) {
            for (String str2 : strArrB) {
                ChatMateRoomTypeData chatMateRoomTypeDataL = l(str2);
                if (chatMateRoomTypeDataL != null && str.equals(chatMateRoomTypeDataL.roomId)) {
                    LogUtil.d("ChatMateGiftManagerTAG", "removeChatMateMsgData find valueRoomId " + str + " uidKey " + str2);
                    arrayList.add(str2);
                }
            }
        }
        if (arrayList.size() > 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                SPUtil.f14322a.r(SPUtil.SCENE.CHATROOMMATE, (String) arrayList.get(i2));
            }
        }
    }

    public static void C(String str, String str2, int i2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SPUtil.f14322a.t(SPUtil.SCENE.CHATROOMMATE, str, str2 + "_" + i2);
    }

    public static void D(MessageProto.Message message) {
        String string = "";
        if (message == null || !s()) {
            return;
        }
        String strT = DomainHelper.t(message.getFrom());
        LogUtil.d("ChatMateGiftManagerTAG", "saveSendGiftUid 开始保存该uid " + strT);
        if (TextUtils.isEmpty(strT)) {
            return;
        }
        try {
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.CHATMATE;
            String strP = sPUtil.p(scene, "KEY_CHATMATE_SEND_GIFT_UIDS", "");
            if (TextUtils.isEmpty(strP)) {
                LogUtil.d("ChatMateGiftManagerTAG", "saveSendGiftUid 没有数据则创建新的数据 创建新的sp " + strT);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(strT);
                string = jSONArray.toString();
            } else {
                JSONArray jSONArray2 = new JSONArray(strP);
                if (jSONArray2.length() > 0) {
                    boolean zR = r(strT, jSONArray2);
                    LogUtil.d("ChatMateGiftManagerTAG", "saveSendGiftUid 有数据 更新sp " + strT + " addUid " + zR);
                    if (!zR) {
                        jSONArray2.put(strT);
                    }
                    string = jSONArray2.toString();
                }
            }
            LogUtil.d("ChatMateGiftManagerTAG", "saveSendGiftUid 保存最终数据 result " + string);
            sPUtil.v(scene, "KEY_CHATMATE_SEND_GIFT_UIDS", string);
        } catch (Exception unused) {
        }
    }

    public static void E(Activity activity, ChatItem chatItem) {
        if (chatItem == null || chatItem.getChatId() == null) {
            return;
        }
        Async.INSTANCE.getCache().execute(new e(chatItem, activity));
    }

    public static void F(ConversationAdapter conversationAdapter) {
        int size = f19670a.size();
        LogUtil.d("ChatMateGiftManagerTAG", "ChatMateGiftManager updateMateSort size " + size);
        if (conversationAdapter == null || size <= 0) {
            return;
        }
        for (int i2 = 0; i2 < size; i2++) {
            List<ConversationAdapter.c> listF = conversationAdapter.f();
            ConversationAdapter.a aVar = f19670a.get(i2);
            int iK = k(listF, aVar.f13812a);
            LogUtil.d("ChatMateGiftManagerTAG", "ChatMateGiftManager updateMateSort targetPosition " + iK + " i " + i2 + " chatItem.threadChatItem " + aVar.f13812a.relativeContact);
            listF.add(iK, aVar);
        }
        conversationAdapter.notifyDataSetChanged();
    }

    public static void G(ConversationAdapter conversationAdapter) {
        if (conversationAdapter == null || G == null) {
            return;
        }
        if (conversationAdapter.f() != null) {
            if (conversationAdapter.f().size() > 0) {
                conversationAdapter.f().add(1, G);
            } else {
                conversationAdapter.f().add(G);
            }
        }
        conversationAdapter.notifyDataSetChanged();
    }

    public static void b(ThreadChatItem threadChatItem, ConversationAdapter conversationAdapter) {
        ThreadChatItem threadChatItem2;
        if (threadChatItem == null || conversationAdapter == null) {
            return;
        }
        String str = threadChatItem.relativeContact;
        List<ConversationAdapter.c> listF = conversationAdapter.f();
        if (listF != null) {
            boolean z2 = false;
            if (str != null && listF.size() > 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= listF.size()) {
                        break;
                    }
                    ConversationAdapter.c cVar = listF.get(i2);
                    if ((cVar instanceof ConversationAdapter.a) && (threadChatItem2 = ((ConversationAdapter.a) cVar).f13812a) != null && threadChatItem2.isChatMateMsgListItem) {
                        z2 = true;
                        break;
                    }
                    i2++;
                }
            }
            LogUtil.d("ChatMateGiftManagerTAG", "ChatMateGiftManager ChatMateMsg addChatMateListMsg 是否已经拥有消息会话入口 " + z2);
            if (z2) {
                return;
            }
            C.post(new a(listF, k(listF, threadChatItem), new ConversationAdapter.a(threadChatItem), conversationAdapter));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x015d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(ConversationAdapter conversationAdapter) {
        boolean z2;
        int i2;
        if (conversationAdapter != null) {
            try {
                if (s() && !t() && l) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    SPUtil sPUtil = SPUtil.f14322a;
                    SPUtil.SCENE scene = SPUtil.SCENE.CHATMATE;
                    long jK = sPUtil.k(scene, "KEY_CHATMATE_CARD_SHOW_START_TIME", 0L);
                    String strP = sPUtil.p(scene, "KEY_CHATMATE_CARD_SHOW_ITEM_DATA", "");
                    String str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(jCurrentTimeMillis));
                    LogUtil.d("ChatMateGiftManagerTAG", "checkGiveTypeMsg curResult " + str);
                    int i3 = 1;
                    if (!TextUtils.isEmpty(strP)) {
                        ChatMateGuideMsgData chatMateGuideMsgData = (ChatMateGuideMsgData) az2.a(strP, ChatMateGuideMsgData.class);
                        if (chatMateGuideMsgData != null) {
                            String str2 = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(jK));
                            LogUtil.d("ChatMateGiftManagerTAG", "checkGiveTypeMsg lastResult " + str2);
                            if (jCurrentTimeMillis - jK <= p * 1000 && str.equals(str2)) {
                                if (G != null) {
                                    LogUtil.d("ChatMateGiftManagerTAG", "checkGiveTypeMsg 有数据 时间未到期，但是已经展示了数据");
                                    return;
                                }
                                LogUtil.d("ChatMateGiftManagerTAG", "checkGiveTypeMsg 有数据 时间未到期，展示对应sp数据");
                                G = new ConversationAdapter.d(chatMateGuideMsgData);
                                if (conversationAdapter.f() != null) {
                                    if (conversationAdapter.f().size() > 0) {
                                        conversationAdapter.f().add(1, G);
                                    } else {
                                        conversationAdapter.f().add(G);
                                    }
                                }
                                conversationAdapter.notifyDataSetChanged();
                                return;
                            }
                            LogUtil.d("ChatMateGiftManagerTAG", "checkGiveTypeMsg 有数据 时间已经到期，不展示且清除所有对应sp数据 ");
                            y(conversationAdapter);
                            return;
                        }
                        return;
                    }
                    LogUtil.d("ChatMateGiftManagerTAG", "checkGiveTypeMsg 无sp数据 需要判断频控是否满足，N天内可出现1次");
                    if (jK > 0) {
                        String str3 = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(jK));
                        if (str.equals(str3)) {
                            LogUtil.d("ChatMateGiftManagerTAG", "checkGiveTypeMsg 无sp数据 当天之内不允许重复展示");
                        } else {
                            long j2 = o * 24 * 60 * 60 * 1000;
                            long time = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(str3).getTime();
                            long time2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(str).getTime();
                            long j3 = time2 - time;
                            LogUtil.d("ChatMateGiftManagerTAG", "checkGiveTypeMsg 无sp数据 非当天之内判断 lastDateTime " + time + " curDateTime " + time2 + " durationTime " + j3 + " allDurationTime " + j2);
                            z2 = j3 >= j2;
                        }
                    }
                    LogUtil.d("ChatMateGiftManagerTAG", "checkGiveTypeMsg allowShow " + z2);
                    if (z2) {
                        long j4 = m * 60 * 1000;
                        if (conversationAdapter.f() != null) {
                            int i4 = 0;
                            for (int i5 = 0; i5 < conversationAdapter.f().size(); i5++) {
                                ConversationAdapter.c cVar = conversationAdapter.f().get(i5);
                                if ((cVar instanceof ConversationAdapter.a) && ((ConversationAdapter.a) cVar).f13812a != null && !((ConversationAdapter.a) cVar).f13812a.isChatMateMsgListItem) {
                                    ChatItem chatItemConvert2ContactOrGroupChatInfo = ((ConversationAdapter.a) cVar).f13812a.convert2ContactOrGroupChatInfo();
                                    if (!a65.f(chatItemConvert2ContactOrGroupChatInfo.getChatId()) && !a65.c(chatItemConvert2ContactOrGroupChatInfo) && jCurrentTimeMillis - ((ConversationAdapter.a) cVar).f13812a.lastMessageDate < j4) {
                                        i4++;
                                    }
                                }
                            }
                            i2 = i4;
                            if (conversationAdapter.f().size() > 0) {
                            }
                            LogUtil.d("ChatMateGiftManagerTAG", "checkGiveTypeMsg allNum " + i2 + " targetPosition " + i3 + " chatcard_msgnumber " + n + " msgGuideItem " + G);
                            if (i2 <= n || G != null) {
                            }
                            ChatMateGuideMsgData chatMateGuideMsgData2 = new ChatMateGuideMsgData();
                            chatMateGuideMsgData2.subTitle = s;
                            chatMateGuideMsgData2.iconUrl = q;
                            chatMateGuideMsgData2.titleList = r;
                            G = new ConversationAdapter.d(chatMateGuideMsgData2);
                            String strC = az2.c(chatMateGuideMsgData2);
                            SPUtil sPUtil2 = SPUtil.f14322a;
                            SPUtil.SCENE scene2 = SPUtil.SCENE.CHATMATE;
                            sPUtil2.v(scene2, "KEY_CHATMATE_CARD_SHOW_ITEM_DATA", strC);
                            sPUtil2.v(scene2, "KEY_CHATMATE_CARD_SHOW_START_TIME", Long.valueOf(jCurrentTimeMillis));
                            LogUtil.d("ChatMateGiftManagerTAG", "checkGiveTypeMsg 添加msgGuideItem 保存sp数据");
                            if (i3 >= conversationAdapter.f().size()) {
                                conversationAdapter.f().add(G);
                            } else {
                                conversationAdapter.f().add(i3, G);
                            }
                            conversationAdapter.notifyDataSetChanged();
                            return;
                        }
                        i2 = 0;
                        i3 = 0;
                        LogUtil.d("ChatMateGiftManagerTAG", "checkGiveTypeMsg allNum " + i2 + " targetPosition " + i3 + " chatcard_msgnumber " + n + " msgGuideItem " + G);
                        if (i2 <= n) {
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void d(ConversationAdapter conversationAdapter) {
        if (!s() || conversationAdapter == null || conversationAdapter.f() == null || f19670a.size() <= 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (int i3 = 0; i3 < f19670a.size(); i3++) {
            ConversationAdapter.a aVar = f19670a.get(i3);
            ThreadChatItem threadChatItem = aVar.f13812a;
            if (threadChatItem != null && jCurrentTimeMillis >= threadChatItem.roomDeadline) {
                arrayList.add(aVar);
            }
        }
        try {
            int size = arrayList.size();
            if (size > 0) {
                conversationAdapter.f().removeAll(arrayList);
                f19670a.removeAll(arrayList);
                conversationAdapter.notifyDataSetChanged();
                int iA = cx5.b().a() - size;
                if (iA >= 0) {
                    i2 = iA;
                }
                cx5.b().h(i2);
                LogUtil.d("ChatMateGiftManagerTAG", "removeChatMateListAllAdapter messageAdapter success size " + size);
            }
        } catch (Exception unused) {
        }
    }

    public static void e(String str) {
        if (!s() || t() || TextUtils.isEmpty(str)) {
            return;
        }
        String strP = SPUtil.f14322a.p(SPUtil.SCENE.CHATMATE, "KEY_CHATMATE_SEND_GIFT_UIDS", "");
        LogUtil.d("ChatMateGiftManagerTAG", "saveSendGiftUid 判断start uid " + str + " giftResult " + strP);
        if (TextUtils.isEmpty(strP)) {
            return;
        }
        try {
            boolean zR = r(str, new JSONArray(strP));
            LogUtil.d("ChatMateGiftManagerTAG", "saveSendGiftUid 判断start uid " + str + " addUid " + zR);
            if (zR) {
                ds0.a().b(new m30(4));
            }
        } catch (Exception unused) {
        }
    }

    public static void f(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("chatmate")) == null) {
            return;
        }
        C.post(new g(jSONObjectOptJSONObject));
    }

    public static void g() {
        LoopTextView loopTextView = B;
        if (loopTextView != null) {
            loopTextView.stopAutoScroll();
            B = null;
        }
    }

    public static void h(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("report_type", str);
            jSONObject.put("fuid", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("chatmate_add", null, jSONObject.toString());
    }

    public static void i(String str, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("report_type", str);
            jSONObject.put("from", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("chatmate_invite", null, jSONObject.toString());
    }

    public static void j(int i2, int i3, String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i2);
            jSONObject.put("from", i3);
            jSONObject.put(DeviceInfoUtil.UID_TAG, str);
            jSONObject.put("fuid", str2);
            jSONObject.put("taskid", str3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("chatmate_chatwindow", null, jSONObject.toString());
    }

    public static int k(List<ConversationAdapter.c> list, ThreadChatItem threadChatItem) {
        ConversationAdapter.c next;
        ThreadChatItem threadChatItem2;
        Iterator<ConversationAdapter.c> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if ((next instanceof ConversationAdapter.a) && (threadChatItem2 = ((ConversationAdapter.a) next).f13812a) != null && threadChatItem2.priority == 0 && threadChatItem2.pinGiftMessage == 0 && threadChatItem2.isSuperGreetings == 0) {
                long j2 = threadChatItem2.draftDate;
                if (j2 != 0) {
                    long j3 = threadChatItem.lastMessageDate;
                    if (j3 != j2) {
                        if (j3 > j2) {
                            break;
                        }
                    }
                }
                if (threadChatItem.lastMessageDate >= threadChatItem2.lastMessageDate) {
                    break;
                }
            }
        }
        int iIndexOf = next != null ? list.indexOf(next) : -1;
        return iIndexOf == -1 ? list.size() : iIndexOf;
    }

    public static ChatMateRoomTypeData l(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strN = SPUtil.f14322a.n(SPUtil.SCENE.CHATROOMMATE, str, "");
        if (TextUtils.isEmpty(strN)) {
            return null;
        }
        try {
            String[] strArrSplit = strN.split("_");
            if (strArrSplit == null || strArrSplit.length != 2) {
                return null;
            }
            ChatMateRoomTypeData chatMateRoomTypeData = new ChatMateRoomTypeData();
            chatMateRoomTypeData.roomId = strArrSplit[0];
            chatMateRoomTypeData.type = Integer.parseInt(strArrSplit[1]);
            return chatMateRoomTypeData;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void m(Activity activity, int i2) {
        ve.o(activity, "zenxin://activity?page=a0052&pkgId=chat-mate&urlExtra=%23%2F%3Ffrom%3D" + i2, false);
        i("click", i2);
    }

    public static void n() {
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2;
        JSONArray jSONArrayOptJSONArray3;
        JSONObject config = vs0.a().getConfig("chatmate");
        if (config != null) {
            JSONObject jSONObjectOptJSONObject = config.optJSONObject("chatmate_givetips");
            if (jSONObjectOptJSONObject != null) {
                b = jSONObjectOptJSONObject.optBoolean("enableA", true);
                c = jSONObjectOptJSONObject.optInt("Alasttime", 5);
                JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray("Atextlist");
                if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() > 0) {
                    d.clear();
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray4.length(); i2++) {
                        d.add(jSONArrayOptJSONArray4.optString(i2));
                    }
                }
                e = jSONObjectOptJSONObject.optBoolean("enableB", true);
                f = jSONObjectOptJSONObject.optInt("Blasttime", 5);
                JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray("Btextlist");
                if (jSONArrayOptJSONArray5 != null && jSONArrayOptJSONArray5.length() > 0) {
                    g.clear();
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray5.length(); i3++) {
                        g.add(jSONArrayOptJSONArray5.optString(i3));
                    }
                }
                i = jSONObjectOptJSONObject.optInt("maxoneday", 1);
                j = jSONObjectOptJSONObject.optInt("number_day", 3);
                h = jSONObjectOptJSONObject.optInt("cooldown", 600);
                k = jSONObjectOptJSONObject.optInt("number_time", 2);
            }
            JSONObject jSONObjectOptJSONObject2 = config.optJSONObject("chatmate_chatcard");
            if (jSONObjectOptJSONObject2 != null) {
                l = jSONObjectOptJSONObject2.optBoolean("enableC", true);
                m = jSONObjectOptJSONObject2.optInt("msgtime", 1440);
                n = jSONObjectOptJSONObject2.optInt("msgnumber", 5);
                o = jSONObjectOptJSONObject2.optInt("number_day", 2);
                p = jSONObjectOptJSONObject2.optInt("lasttime", 600);
                t = jSONObjectOptJSONObject2.optBoolean("fixed", true);
                ContactInfoItem contactInfoItemF = v4.f();
                String str = (contactInfoItemF == null || contactInfoItemF.getGender() != 1) ? MediationConfigUserInfoForSegment.GENDER_MALE : MediationConfigUserInfoForSegment.GENDER_FEMALE;
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("material_subtitle");
                if (jSONObjectOptJSONObject3 != null && jSONObjectOptJSONObject3.has(str) && (jSONArrayOptJSONArray3 = jSONObjectOptJSONObject3.optJSONArray(str)) != null && jSONArrayOptJSONArray3.length() > 0) {
                    s = jSONArrayOptJSONArray3.optString(new Random().nextInt(jSONArrayOptJSONArray3.length()));
                }
                JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject2.optJSONObject("material_head");
                if (jSONObjectOptJSONObject4 != null && jSONObjectOptJSONObject4.has(str) && (jSONArrayOptJSONArray2 = jSONObjectOptJSONObject4.optJSONArray(str)) != null && jSONArrayOptJSONArray2.length() > 0) {
                    q = jSONArrayOptJSONArray2.optString(new Random().nextInt(jSONArrayOptJSONArray2.length()));
                }
                JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject2.optJSONObject("material_title");
                if (jSONObjectOptJSONObject5 != null && jSONObjectOptJSONObject5.has(str) && (jSONArrayOptJSONArray = jSONObjectOptJSONObject5.optJSONArray(str)) != null && jSONArrayOptJSONArray.length() > 0) {
                    r.clear();
                    if (jSONArrayOptJSONArray.length() <= 5) {
                        for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                            r.add(jSONArrayOptJSONArray.optString(i4));
                        }
                    } else {
                        for (int i5 = 0; i5 < 5; i5++) {
                            r.add(jSONArrayOptJSONArray.optString(new Random().nextInt(jSONArrayOptJSONArray.length())));
                        }
                    }
                }
            }
            JSONObject jSONObjectOptJSONObject6 = config.optJSONObject("chatmate_recievetips");
            if (jSONObjectOptJSONObject6 != null) {
                u = jSONObjectOptJSONObject6.optBoolean("enableA", true);
                v = jSONObjectOptJSONObject6.optInt("Alasttime", 5);
                JSONArray jSONArrayOptJSONArray6 = jSONObjectOptJSONObject6.optJSONArray("Atextlist");
                if (jSONArrayOptJSONArray6 != null && jSONArrayOptJSONArray6.length() > 0) {
                    w.clear();
                    for (int i6 = 0; i6 < jSONArrayOptJSONArray6.length(); i6++) {
                        w.add(jSONArrayOptJSONArray6.optString(i6));
                    }
                }
                x = jSONObjectOptJSONObject6.optInt("maxoneday", 1);
                y = jSONObjectOptJSONObject6.optInt("number_day", 3);
                z = jSONObjectOptJSONObject6.optInt("number_time", 3);
                A = jSONObjectOptJSONObject6.optInt("cooldown", 600);
            }
            JSONObject jSONObjectOptJSONObject7 = config.optJSONObject("chatmate_gift");
            if (jSONObjectOptJSONObject7 != null) {
                D = jSONObjectOptJSONObject7.optString("moregift", "点击获得更多礼物");
                E = jSONObjectOptJSONObject7.optString("nogift", "点击获得更多礼物");
            }
            JSONObject jSONObjectOptJSONObject8 = config.optJSONObject("pickpage");
            if (jSONObjectOptJSONObject8 != null) {
                F = jSONObjectOptJSONObject8.optString("giftpop_txt", "确定将礼物送给TA？送出后，本次召唤任务将结束。其他参与的异性还可以和你继续聊天~");
            }
        }
    }

    public static void o(JSONObject jSONObject) {
        if (!s() || t()) {
            return;
        }
        try {
            LogUtil.d("ChatMateGiftManagerTAG", "ChatMateGiftManager insertChatMateMsg msg " + jSONObject);
            if (jSONObject != null) {
                ThreadChatItem threadChatItem = new ThreadChatItem();
                threadChatItem.relativeContact = jSONObject.optLong(DeviceInfoUtil.UID_TAG) + "";
                threadChatItem.iconUrl = jSONObject.optString("headIconUrl");
                threadChatItem.title = jSONObject.optString("nickname");
                threadChatItem.bizType = 5053;
                threadChatItem.lastMessageDate = System.currentTimeMillis();
                threadChatItem.isChatMateMsgListItem = true;
                threadChatItem.unReadCount = 1;
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("chatmate");
                if (jSONObjectOptJSONObject != null) {
                    threadChatItem.lastMsg = jSONObjectOptJSONObject.optString("text");
                    threadChatItem.chatMateRoomId = jSONObjectOptJSONObject.optString("roomId");
                    threadChatItem.roomDeadline = jSONObjectOptJSONObject.optLong("roomDeadline");
                }
                m30 m30Var = new m30(1);
                m30Var.f19133a = threadChatItem;
                ds0.a().b(m30Var);
            }
        } catch (Exception unused) {
        }
    }

    public static boolean p(int i2, String str) {
        String str2;
        int i3;
        String str3;
        int i4;
        if (q(str)) {
            return false;
        }
        boolean z2 = b;
        int i5 = j;
        int i6 = i;
        int i7 = h;
        int i8 = k;
        String str4 = "KEY_CHATMATE_LAST_TIME";
        String str5 = "KEY_CHATMATE_LAST_START_TIME";
        String str6 = "KEY_CHATMATE_DAILY_COUNT";
        String str7 = "KEY_CHATMATE_TOTAL_COUNT";
        if (i2 == 8) {
            z2 = e;
        } else if (i2 == 10) {
            z2 = u;
            i5 = y;
            i6 = x;
            i7 = A;
            i8 = z;
            str4 = "KEY_CHATMATE_RECEIVER_LAST_TIME";
            str5 = "KEY_CHATMATE_RECEIVER_LAST_START_TIME";
            str6 = "KEY_CHATMATE_RECEIVER_DAILY_COUNT";
            str7 = "KEY_CHATMATE_RECEIVER_TOTAL_COUNT";
        }
        if (!s() || t() || !z2) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strA = iv0.a(jCurrentTimeMillis, "yyyy-MM-dd");
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.CHATMATE;
        int i9 = i7;
        int i10 = i8;
        Long lValueOf = Long.valueOf(sPUtil.k(scene, str4, 0L));
        Long lValueOf2 = Long.valueOf(sPUtil.k(scene, str5, 0L));
        String str8 = str4;
        int i11 = i6;
        if (lValueOf2.longValue() == 0 || lValueOf.longValue() == 0) {
            str2 = "ChatMateGiftManagerTAG";
            i3 = 0;
            sPUtil.v(scene, str6, 0);
            sPUtil.v(scene, str7, 0);
            sPUtil.v(scene, str5, Long.valueOf(jCurrentTimeMillis));
            str3 = str8;
            sPUtil.v(scene, str3, Long.valueOf(jCurrentTimeMillis));
        } else {
            long jLongValue = (jCurrentTimeMillis - lValueOf2.longValue()) / 86400000;
            LogUtil.d("ChatMateGiftManagerTAG", "isAllowShowGiftGuide type " + i2 + " daysDiff " + jLongValue + " number_day " + i5);
            str2 = "ChatMateGiftManagerTAG";
            if (jLongValue >= i5) {
                sPUtil.v(scene, str6, 0);
                sPUtil.v(scene, str7, 0);
                sPUtil.v(scene, str5, Long.valueOf(jCurrentTimeMillis));
            }
            int iH = sPUtil.h(scene, str7, 0);
            int iH2 = sPUtil.h(scene, str6, 0);
            LogUtil.d(str2, "isAllowShowGiftGuide type " + i2 + " totalCount " + iH + " todayCount " + iH2);
            if (strA.equals(iv0.a(lValueOf.longValue(), "yyyy-MM-dd"))) {
                i4 = i11;
            } else {
                sPUtil.v(scene, str6, 0);
                i4 = i11;
                iH2 = 0;
            }
            if (iH2 >= i4) {
                LogUtil.d(str2, "isAllowShowGiftGuide type " + i2 + " todayCount >= maxoneday return false");
                return false;
            }
            if (System.currentTimeMillis() - lValueOf.longValue() < i9 * 1000) {
                LogUtil.d(str2, "isAllowShowGiftGuide type " + i2 + " cooldown return false");
                return false;
            }
            i3 = 0;
            if (iH >= i10) {
                LogUtil.d(str2, "isAllowShowGiftGuide type " + i2 + " totalCount >= number_time return false");
                return false;
            }
            str3 = str8;
        }
        int iH3 = sPUtil.h(scene, str7, i3);
        sPUtil.v(scene, str6, Integer.valueOf(sPUtil.h(scene, str6, i3) + 1));
        sPUtil.v(scene, str7, Integer.valueOf(iH3 + 1));
        sPUtil.v(scene, str3, Long.valueOf(jCurrentTimeMillis));
        LogUtil.d(str2, "isAllowShowGiftGuide type " + i2 + " allow return true totalCount " + iH3);
        return true;
    }

    public static boolean q(String str) {
        ChatMateRoomTypeData chatMateRoomTypeDataL;
        ChatMateRoomTypeData chatMateRoomTypeDataL2;
        return (!s() || str == null || (chatMateRoomTypeDataL = l(str)) == null || (chatMateRoomTypeDataL2 = l(v4.e(AppContext.getContext()))) == null || chatMateRoomTypeDataL.type == chatMateRoomTypeDataL2.type || TextUtils.isEmpty(chatMateRoomTypeDataL.roomId) || TextUtils.isEmpty(chatMateRoomTypeDataL2.roomId) || !chatMateRoomTypeDataL.roomId.equals(chatMateRoomTypeDataL2.roomId)) ? false : true;
    }

    public static boolean r(String str, JSONArray jSONArray) {
        if (!TextUtils.isEmpty(str) && jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    if (str.equals(jSONArray.optString(i2))) {
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
        }
        return false;
    }

    public static boolean s() {
        return !"A".equals(t66.h().e("LX-69483", "A"));
    }

    public static boolean t() {
        return TeenagersModeManager.a().d();
    }

    public static void u() {
        f19670a.clear();
        G = null;
        g();
        if (cx5.b().a() > 0) {
            cx5.b().h(0);
        }
    }

    public static void v(String str, sk2 sk2Var) {
        LogUtil.d("ChatMateGiftManagerTAG", "roomDataCheck postChatActivityMateStatus 开始请求数据");
        zw4.e(new d(str, sk2Var));
    }

    public static void w(ChatItem chatItem, String str) {
        if (chatItem != null) {
            String strE = v4.e(AppContext.getContext());
            String chatId = chatItem.getChatId();
            if (TextUtils.isEmpty(strE) || TextUtils.isEmpty(chatId) || TextUtils.isEmpty(str)) {
                return;
            }
            zw4.e(new f(strE, chatId, str));
        }
    }

    public static void x(Activity activity, String str, int i2, String str2) {
        LogUtil.i("ChatMateGiftManagerTAG", "postItemClick roomId =" + str);
        zw4.e(new c(str, i2, str2, activity));
    }

    public static void y(ConversationAdapter conversationAdapter) {
        if (conversationAdapter != null) {
            try {
                if (G != null) {
                    conversationAdapter.f().remove(G);
                    conversationAdapter.notifyDataSetChanged();
                    G = null;
                }
            } catch (Exception unused) {
                return;
            }
        }
        g();
        SPUtil.f14322a.s(SPUtil.SCENE.CHATMATE, "KEY_CHATMATE_CARD_SHOW_ITEM_DATA");
        LogUtil.d("ChatMateGiftManagerTAG", "checkGiveTypeMsg removeChatMateCardItem 删除msgGuideItem 清除sp数据");
    }

    public static void z(ConversationAdapter.a aVar, ConversationAdapter conversationAdapter) {
        if (conversationAdapter == null || aVar == null) {
            return;
        }
        try {
            conversationAdapter.f().remove(aVar);
            conversationAdapter.notifyDataSetChanged();
            if (f19670a.contains(aVar)) {
                f19670a.remove(aVar);
            }
            int iA = cx5.b().a() - 1;
            if (iA < 0) {
                iA = 0;
            }
            cx5.b().h(iA);
        } catch (Exception unused) {
        }
    }
}
