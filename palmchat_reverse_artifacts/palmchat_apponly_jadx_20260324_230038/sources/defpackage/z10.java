package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatBreakHelper;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterAdapter;
import com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter;
import com.zenmen.palmchat.widget.LXPortraitView;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class z10 extends SimpleChatViewAdapter {
    public static Set<String> i = new HashSet();
    public static Map<String, List<ChatBreakHelper.ChatQue>> j = new HashMap();
    public static Map<String, List<ChatBreakHelper.ChatAns>> k = new HashMap();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f22315a;
        public final /* synthetic */ MessageVo b;
        public final /* synthetic */ List c;

        public a(List list, MessageVo messageVo, List list2) {
            this.f22315a = list;
            this.b = messageVo;
            this.c = list2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            List list = this.f22315a;
            if (list != null && list.size() > 0) {
                z10.this.E(this.b, (ChatBreakHelper.ChatQue) this.f22315a.get(0));
            }
            List list2 = this.c;
            if (list2 == null || list2.size() <= 0) {
                return;
            }
            z10.this.D(this.b, (ChatBreakHelper.ChatAns) this.c.get(0));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f22316a;
        public final /* synthetic */ MessageVo b;
        public final /* synthetic */ List c;

        public b(List list, MessageVo messageVo, List list2) {
            this.f22316a = list;
            this.b = messageVo;
            this.c = list2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            List list = this.f22316a;
            if (list != null && list.size() > 1) {
                z10.this.E(this.b, (ChatBreakHelper.ChatQue) this.f22316a.get(1));
            }
            List list2 = this.c;
            if (list2 == null || list2.size() <= 1) {
                return;
            }
            z10.this.D(this.b, (ChatBreakHelper.ChatAns) this.c.get(1));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f22317a;
        public final /* synthetic */ MessageVo b;
        public final /* synthetic */ List c;

        public c(List list, MessageVo messageVo, List list2) {
            this.f22317a = list;
            this.b = messageVo;
            this.c = list2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            List list = this.f22317a;
            if (list != null && list.size() > 2) {
                z10.this.E(this.b, (ChatBreakHelper.ChatQue) this.f22317a.get(2));
            }
            List list2 = this.c;
            if (list2 == null || list2.size() <= 2) {
                return;
            }
            z10.this.D(this.b, (ChatBreakHelper.ChatAns) this.c.get(2));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f22318a;
        public final /* synthetic */ a20 b;

        public d(MessageVo messageVo, a20 a20Var) {
            this.f22318a = messageVo;
            this.b = a20Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f22318a != null) {
                z10.i.remove(this.f22318a.mid);
                z10.j.remove(this.f22318a.mid);
                z10.k.remove(this.f22318a.mid);
            }
            z10.this.C(this.f22318a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f22319a;

        public e(MessageVo messageVo) {
            this.f22319a = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageVo messageVo = this.f22319a;
            if (messageVo != null) {
                ChatBreakHelper.n(messageVo.mid, z10.this.o());
            }
        }
    }

    public ChatterAdapter.h B() {
        return r().o();
    }

    public void C(MessageVo messageVo, a20 a20Var) {
        List<ChatBreakHelper.ChatAns> list;
        int iOptInt;
        long jOptLong;
        ChatBreakHelper.ConfigNoChat configNoChat;
        ChatBreakHelper.ConfigAnswer configAnswer;
        ChatBreakHelper.ChatQue chatQueS;
        ChatBreakHelper.ConfigNoChat configNoChat2;
        ChatBreakHelper.ConfigQuestion configQuestion;
        View view = a20Var.g;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = a20Var.h;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        LXPortraitView lXPortraitView = a20Var.i;
        if (lXPortraitView != null) {
            lXPortraitView.setVisibility(8);
        }
        View view3 = a20Var.j;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        ImageView imageView = a20Var.k;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = a20Var.c;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = a20Var.d;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        a20Var.s.setVisibility(4);
        a20Var.v.setVisibility(4);
        a20Var.y.setVisibility(4);
        a20Var.B.setVisibility(8);
        a20Var.C.setVisibility(8);
        List<ChatBreakHelper.ChatQue> list2 = null;
        if (messageVo != null && !il5.l(messageVo.extention)) {
            try {
                JSONObject jSONObject = new JSONObject(messageVo.extention);
                iOptInt = jSONObject.optInt("noChat");
                try {
                    jOptLong = jSONObject.optLong("noChatQueId");
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    jOptLong = 0;
                }
            } catch (JSONException e3) {
                e = e3;
                iOptInt = 0;
            }
            if (iOptInt == 1) {
                List<ChatBreakHelper.ChatQue> listT = j.get(messageVo.mid);
                if (listT == null) {
                    listT = ChatBreakHelper.t();
                    j.put(messageVo.mid, listT);
                }
                if (listT.isEmpty()) {
                    a20Var.r.setVisibility(8);
                } else {
                    a20Var.r.setVisibility(0);
                    String str = listT.get(0).pro;
                    if (il5.l(str)) {
                        a20Var.s.setVisibility(4);
                    } else {
                        a20Var.t.setText(str);
                        a20Var.s.setVisibility(0);
                    }
                    if (listT.size() < 2 || il5.l(listT.get(1).pro)) {
                        a20Var.v.setVisibility(4);
                    } else {
                        a20Var.w.setText(listT.get(1).pro);
                        a20Var.v.setVisibility(0);
                    }
                    if (listT.size() < 3 || il5.l(listT.get(2).pro)) {
                        a20Var.y.setVisibility(4);
                    } else {
                        a20Var.z.setText(listT.get(2).pro);
                        a20Var.y.setVisibility(0);
                    }
                    ChatBreakHelper.MsgCardOption msgCardOptionP = ChatBreakHelper.p();
                    if (msgCardOptionP == null || (configNoChat2 = msgCardOptionP.nochat) == null || (configQuestion = configNoChat2.question) == null) {
                        a20Var.D.setText("聊聊这些，Ta可能会感兴趣哦");
                        a20Var.u.setText("发送");
                        a20Var.x.setText("发送");
                        a20Var.A.setText("发送");
                        a20Var.B.setVisibility(0);
                    } else {
                        a20Var.D.setText(configQuestion.question_title);
                        a20Var.u.setText(msgCardOptionP.nochat.question.question_but);
                        a20Var.x.setText(msgCardOptionP.nochat.question.question_but);
                        a20Var.A.setText(msgCardOptionP.nochat.question.question_but);
                        if ("change".equals(msgCardOptionP.nochat.question.question_type)) {
                            a20Var.B.setVisibility(0);
                        } else {
                            a20Var.C.setVisibility(0);
                        }
                    }
                }
                List<ChatBreakHelper.ChatQue> list3 = listT;
                list = null;
                list2 = list3;
            } else if (iOptInt == 2) {
                list = k.get(messageVo.mid);
                if (list == null && (chatQueS = ChatBreakHelper.q().s(jOptLong)) != null && (list = chatQueS.ans) != null && !list.isEmpty()) {
                    Collections.shuffle(list);
                    k.put(messageVo.mid, list);
                }
                if (list == null || list.isEmpty()) {
                    a20Var.r.setVisibility(8);
                } else {
                    a20Var.r.setVisibility(0);
                    String str2 = list.get(0).ans;
                    if (il5.l(str2)) {
                        a20Var.s.setVisibility(4);
                    } else {
                        a20Var.t.setText(str2);
                        a20Var.s.setVisibility(0);
                    }
                    if (list.size() < 2 || il5.l(list.get(1).ans)) {
                        a20Var.v.setVisibility(4);
                    } else {
                        a20Var.w.setText(list.get(1).ans);
                        a20Var.v.setVisibility(0);
                    }
                    if (list.size() < 3 || il5.l(list.get(2).ans)) {
                        a20Var.y.setVisibility(4);
                    } else {
                        a20Var.z.setText(list.get(2).ans);
                        a20Var.y.setVisibility(0);
                    }
                    ChatBreakHelper.MsgCardOption msgCardOptionP2 = ChatBreakHelper.p();
                    if (msgCardOptionP2 == null || (configNoChat = msgCardOptionP2.nochat) == null || (configAnswer = configNoChat.answer) == null) {
                        a20Var.D.setText("Ta很想知道你的答案，立即回答Ta吧");
                        a20Var.u.setText("发送");
                        a20Var.x.setText("发送");
                        a20Var.A.setText("发送");
                        a20Var.C.setVisibility(0);
                    } else {
                        a20Var.D.setText(configAnswer.answer_title);
                        a20Var.u.setText(msgCardOptionP2.nochat.answer.answer_but);
                        a20Var.x.setText(msgCardOptionP2.nochat.answer.answer_but);
                        a20Var.A.setText(msgCardOptionP2.nochat.answer.answer_but);
                        if ("change".equals(msgCardOptionP2.nochat.answer.answer_type)) {
                            a20Var.B.setVisibility(0);
                        } else {
                            a20Var.C.setVisibility(0);
                        }
                    }
                }
            } else {
                a20Var.r.setVisibility(8);
            }
            a20Var.u.setOnClickListener(new a(list2, messageVo, list));
            a20Var.x.setOnClickListener(new b(list2, messageVo, list));
            a20Var.A.setOnClickListener(new c(list2, messageVo, list));
            a20Var.B.setOnClickListener(new d(messageVo, a20Var));
            a20Var.C.setOnClickListener(new e(messageVo));
            F(messageVo, list2, list);
        }
        a20Var.r.setVisibility(8);
        list = null;
        a20Var.u.setOnClickListener(new a(list2, messageVo, list));
        a20Var.x.setOnClickListener(new b(list2, messageVo, list));
        a20Var.A.setOnClickListener(new c(list2, messageVo, list));
        a20Var.B.setOnClickListener(new d(messageVo, a20Var));
        a20Var.C.setOnClickListener(new e(messageVo));
        F(messageVo, list2, list);
    }

    public final void D(MessageVo messageVo, ChatBreakHelper.ChatAns chatAns) {
        G("chatpage_optioncard_click", null, chatAns);
        if (l50.a()) {
            return;
        }
        if (!hx3.m(this.f)) {
            sy5.e(this.f, R.string.net_status_unavailable, 1).g();
            return;
        }
        ChatterAdapter.h hVarB = B();
        if (hVarB == null || o() == null) {
            return;
        }
        hVarB.v0(ChatBreakHelper.j(chatAns, o()), messageVo.mid);
    }

    public final void E(MessageVo messageVo, ChatBreakHelper.ChatQue chatQue) {
        G("chatpage_optioncard_click", chatQue, null);
        if (l50.a()) {
            return;
        }
        if (!hx3.m(this.f)) {
            sy5.e(this.f, R.string.net_status_unavailable, 1).g();
            return;
        }
        ChatterAdapter.h hVarB = B();
        if (hVarB == null || o() == null) {
            return;
        }
        hVarB.v0(ChatBreakHelper.m(chatQue, o()), messageVo.mid);
    }

    public final void F(MessageVo messageVo, List<ChatBreakHelper.ChatQue> list, List<ChatBreakHelper.ChatAns> list2) {
        if (messageVo == null || i.contains(messageVo.mid)) {
            return;
        }
        HashMap map = new HashMap();
        ChatItem chatItemO = o();
        if (chatItemO != null) {
            map.put("targetUid", chatItemO.getChatId());
            map.put("topic", "nochat");
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    jSONArray.put(list.get(i2).id);
                }
                map.put("qTxt", jSONArray.toString());
            }
            if (list2 != null && list2.size() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    jSONArray2.put(list2.get(i3).aid);
                }
                map.put("aTxt", jSONArray2.toString());
            }
        }
        zn6.h("chatpage_optioncard_show", "view", map);
        i.add(messageVo.mid);
    }

    public final void G(String str, ChatBreakHelper.ChatQue chatQue, ChatBreakHelper.ChatAns chatAns) {
        HashMap map = new HashMap();
        ChatItem chatItemO = o();
        if (chatItemO != null) {
            map.put("targetUid", chatItemO.getChatId());
            map.put("topic", "nochat");
            if (chatQue != null) {
                map.put("qTxt", String.valueOf(chatQue.id));
            }
            if (chatAns != null) {
                map.put("aTxt", String.valueOf(chatAns.aid));
            }
        }
        zn6.h(str, "click", map);
    }

    @Override // defpackage.o40
    public int a() {
        return 45;
    }

    @Override // defpackage.o40
    public View b(Context context, MessageVo messageVo) {
        if (20003 != messageVo.mimeType) {
            return null;
        }
        return this.e.inflate(R.layout.list_item_chat_break, (ViewGroup) null);
    }

    @Override // defpackage.o40
    public if6 c(View view) {
        return new a20(view);
    }

    @Override // com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter, defpackage.o40
    public void f(Context context, ChatItem chatItem) {
        super.f(context, chatItem);
        i.clear();
        j.clear();
        k.clear();
    }

    @Override // defpackage.o40
    public int getViewTypeCount() {
        return 1;
    }

    @Override // defpackage.o40
    public <T extends if6> void l(T t, MessageVo messageVo) {
        C(messageVo, (a20) t);
    }

    @Override // defpackage.o40
    public int m(boolean z, int i2, MessageVo messageVo) {
        return i2 == 20003 ? 45 : -1;
    }

    @Override // com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter
    public ChatItem o() {
        return super.o();
    }
}
