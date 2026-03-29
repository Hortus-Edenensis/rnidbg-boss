package defpackage;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.ThreadChatItem;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.conversations.threadsnew.chatone.vo.ChatOneItemVo;
import com.zenmen.palmchat.conversations.threadsnew.chatone.vo.ChatOneState;
import com.zenmen.palmchat.conversations.threadsnew.chatone.vo.ChatOneVo;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.d;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.y30;
import defpackage.zh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class w30 {
    public static volatile w30 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ChatOneVo f21594a;
    public ChatOneState b = new ChatOneState();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements io2<LXBaseNetBean<ChatOneVo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y30.b f21595a;

        public a(y30.b bVar) {
            this.f21595a = bVar;
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<ChatOneVo> lXBaseNetBean, Exception exc) {
            List<ChatOneItemVo> list;
            ArrayList arrayList = new ArrayList();
            ChatOneVo chatOneVo = (z && lXBaseNetBean != null && lXBaseNetBean.isSuccess()) ? lXBaseNetBean.data : null;
            if (chatOneVo != null && (list = chatOneVo.list) != null && list.size() > 0) {
                chatOneVo.time = ir5.b();
                String strA = xn3.a();
                for (ChatOneItemVo chatOneItemVo : chatOneVo.list) {
                    chatOneItemVo.requestId = strA;
                    arrayList.add(chatOneItemVo.uid);
                }
                w30.this.f21594a = chatOneVo;
                w30.this.n(chatOneVo);
                this.f21595a.a(chatOneVo);
            }
            HashMap map = new HashMap();
            map.put("fuids", arrayList);
            map.put("resultcode", (z && lXBaseNetBean != null && lXBaseNetBean.isSuccess()) ? "1" : "2");
            zn6.j("msg_chatlots_result", null, map);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends go2<LXBaseNetBean<ChatOneVo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ io2 f21596a;

        public b(io2 io2Var) {
            this.f21596a = io2Var;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            LocationEx locationExI = d.g().i(86400000L);
            if (locationExI != null) {
                map.put("longitude", Double.valueOf(locationExI.getLongitude()));
                map.put("latitude", Double.valueOf(locationExI.getLatitude()));
                map.put("cityCode", locationExI.getCityCode());
            }
            return sw4.b(1, nl0.z + "/chat.lots.rec.list", map);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<ChatOneVo> lXBaseNetBean, Exception exc) {
            this.f21596a.onResult(z, lXBaseNetBean, exc);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements zh.a<ThreadChatItem> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21597a;
        public final /* synthetic */ ChatOneItemVo b;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements zh.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ContactInfoItem f21598a;

            public a(ContactInfoItem contactInfoItem) {
                this.f21598a = contactInfoItem;
            }

            @Override // zh.a
            public void a(Object obj) {
                LogUtil.i("ChatOneManager", "onItemClicked insert contact end");
                c cVar = c.this;
                w30.this.o(cVar.f21597a, this.f21598a, cVar.b);
            }
        }

        public c(Context context, ChatOneItemVo chatOneItemVo) {
            this.f21597a = context;
            this.b = chatOneItemVo;
        }

        @Override // zh.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ThreadChatItem threadChatItem) {
            LogUtil.i("ChatOneManager", "onItemClicked ThreadChatItem" + threadChatItem);
            if (threadChatItem != null && threadChatItem.isContactReady) {
                w30.this.o(this.f21597a, (ContactInfoItem) threadChatItem.convert2ContactOrGroupChatInfo(), this.b);
                return;
            }
            ContactInfoItem contactInfoItemL = bo0.r().l(this.b.uid);
            LogUtil.i("ChatOneManager", "onItemClicked contactInfoItem" + contactInfoItemL);
            if (contactInfoItemL != null) {
                if (contactInfoItemL.getIsStranger()) {
                    contactInfoItemL.setBizType(5054);
                }
                w30.this.o(this.f21597a, contactInfoItemL, this.b);
                return;
            }
            LogUtil.i("ChatOneManager", "onItemClicked insert contact start");
            ContactInfoItem contactInfoItem = new ContactInfoItem();
            contactInfoItem.setUid(this.b.uid);
            if (!TextUtils.isEmpty(this.b.gender)) {
                contactInfoItem.setGender(Integer.parseInt(this.b.gender));
            }
            contactInfoItem.setIconURL(this.b.avatar);
            contactInfoItem.setNickName(this.b.nickname);
            contactInfoItem.setBizType(5054);
            contactInfoItem.setSourceType(fu5.n(5054));
            ln0.b(nn0.c(contactInfoItem), new a(contactInfoItem));
        }
    }

    public static w30 f() {
        if (c == null) {
            synchronized (w30.class) {
                if (c == null) {
                    c = new w30();
                }
            }
        }
        return c;
    }

    public static boolean h() {
        return t66.h().f("LX-70430", false);
    }

    public final ChatOneVo d() {
        String strP = SPUtil.f14322a.p(SPUtil.SCENE.APP_COMMON, "key_chat_one_save_state1" + ir5.a(), "");
        if (TextUtils.isEmpty(strP)) {
            return null;
        }
        return (ChatOneVo) az2.a(strP, ChatOneVo.class);
    }

    public ChatOneItemVo e() {
        List<ChatOneItemVo> list;
        ChatOneVo chatOneVo = this.f21594a;
        if (chatOneVo == null || (list = chatOneVo.list) == null || list.size() <= 0) {
            return null;
        }
        ChatOneVo chatOneVo2 = this.f21594a;
        int i = chatOneVo2.currentIndex;
        return this.f21594a.list.get((i < 0 || i >= chatOneVo2.list.size()) ? 0 : this.f21594a.currentIndex);
    }

    public final int g() {
        JSONObject config = vs0.a().getConfig("msg_chatlots");
        if (config != null) {
            return config.optInt("request_time", 600);
        }
        return 600;
    }

    public void i() {
        ChatOneVo chatOneVo = this.f21594a;
        if (chatOneVo != null) {
            chatOneVo.isChtEnd = true;
            n(chatOneVo);
        }
    }

    public void j() {
        ChatOneItemVo chatOneItemVoE = e();
        if (chatOneItemVoE != null) {
            chatOneItemVoE.hasClicked = true;
            n(this.f21594a);
        }
    }

    public void k(Context context) {
        ChatOneItemVo chatOneItemVoE = f().e();
        LogUtil.i("ChatOneManager", "onItemClicked" + chatOneItemVoE);
        if (chatOneItemVoE != null) {
            HashMap map = new HashMap();
            map.put("fuid", chatOneItemVoE.uid);
            map.put("click_type", "1");
            zn6.h("msg_chatlots_msg", "click", map);
            f().j();
            nw5.g(chatOneItemVoE.uid, new c(context, chatOneItemVoE));
        }
    }

    public void l(ChatOneItemVo chatOneItemVo) {
        List<ChatOneItemVo> list;
        LogUtil.i("ChatOneManager", "onItemHasSendMsg" + chatOneItemVo);
        ChatOneVo chatOneVo = this.f21594a;
        if (chatOneVo == null || (list = chatOneVo.list) == null || !list.remove(chatOneItemVo)) {
            return;
        }
        this.f21594a.time = ir5.b() + 500;
        n(this.f21594a);
        if (this.f21594a.list.size() == 0) {
            zn6.b("msg_chatlots_empty");
        }
    }

    public boolean m() {
        List<ChatOneItemVo> list;
        ChatOneVo chatOneVo = this.f21594a;
        if (chatOneVo != null && (list = chatOneVo.list) != null && list.size() > 0) {
            HashMap map = new HashMap();
            map.put("fuid", e().uid);
            map.put("click_type", "2");
            zn6.h("msg_chatlots_msg", "click", map);
            if (this.f21594a.list.size() != 1) {
                ChatOneVo chatOneVo2 = this.f21594a;
                int size = (chatOneVo2.currentIndex + 1) % chatOneVo2.list.size();
                ChatOneVo chatOneVo3 = this.f21594a;
                chatOneVo3.currentIndex = size;
                n(chatOneVo3);
                return true;
            }
            ry5.a("今天没有更多推荐啦，期待明天新缘分");
        }
        return false;
    }

    public final void n(ChatOneVo chatOneVo) {
        SPUtil.f14322a.v(SPUtil.SCENE.APP_COMMON, "key_chat_one_save_state1" + ir5.a(), az2.c(chatOneVo));
    }

    public final void o(Context context, ContactInfoItem contactInfoItem, ChatOneItemVo chatOneItemVo) {
        if (contactInfoItem == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) ChatterActivity.class);
        intent.setExtrasClassLoader(ContactInfoItem.class.getClassLoader());
        intent.putExtra("chat_item", contactInfoItem);
        intent.putExtra("chat_need_back_to_main", true);
        intent.putExtra("thread_biz_type", contactInfoItem.getBizType());
        intent.putExtra("extra_key_chatone_info", az2.c(chatOneItemVo));
        k86.X(intent);
        context.startActivity(intent);
    }

    public final void p(io2<LXBaseNetBean<ChatOneVo>> io2Var) {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        if (Math.abs(ir5.e(sPUtil.k(scene, "key_chat_one_lastRequestTime", 0L))) < ((long) g()) * 1000) {
            LogUtil.i("ChatOneManager", "updateChatOneVo request fail on interval");
            return;
        }
        sPUtil.v(scene, "key_chat_one_lastRequestTime", Long.valueOf(ir5.b()));
        zn6.b("msg_chatlots_request");
        zw4.e(new b(io2Var));
    }

    public void q(y30.b bVar) {
        ChatOneVo chatOneVoD = d();
        LogUtil.i("ChatOneManager", "updateListOnEnterMsgList cache data =" + az2.c(chatOneVoD));
        if (chatOneVoD == null) {
            p(new a(bVar));
            return;
        }
        if (!chatOneVoD.isChtEnd && chatOneVoD.list.size() == 0 && this.f21594a == null) {
            bVar.a(null);
        } else {
            this.f21594a = chatOneVoD;
            bVar.a(chatOneVoD);
        }
    }
}
