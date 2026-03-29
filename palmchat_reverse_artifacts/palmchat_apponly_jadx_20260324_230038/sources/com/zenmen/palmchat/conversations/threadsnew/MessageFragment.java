package com.zenmen.palmchat.conversations.threadsnew;

import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseFragment;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.ThreadChatItem;
import com.zenmen.palmchat.circle.bean.CircleNoticeItem;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.conversations.threadgroup.ThreadFolderManager;
import com.zenmen.palmchat.conversations.threadsnew.SeeMeManager;
import com.zenmen.palmchat.conversations.threadsnew.adapter.ConversationAdapter;
import com.zenmen.palmchat.conversations.threadsnew.filter.FilterType;
import com.zenmen.palmchat.conversations.threadsnew.filter.a;
import com.zenmen.palmchat.conversations.threadsnew.riskthread.RiskThreadsListActivity;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.login.AdSplaseActivity;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.peoplenearby.GreetingsThreadsActivity;
import com.zenmen.palmchat.redpacket.data.VoucherRedPacketVo;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.SAppUtil;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.UI;
import defpackage.a65;
import defpackage.b05;
import defpackage.b65;
import defpackage.bo0;
import defpackage.ch;
import defpackage.cx5;
import defpackage.dd6;
import defpackage.ds0;
import defpackage.dx5;
import defpackage.e9;
import defpackage.f46;
import defpackage.fu5;
import defpackage.g74;
import defpackage.h74;
import defpackage.i65;
import defpackage.io0;
import defpackage.iq5;
import defpackage.j00;
import defpackage.jw5;
import defpackage.k65;
import defpackage.k86;
import defpackage.ly4;
import defpackage.m30;
import defpackage.mb4;
import defpackage.mo5;
import defpackage.nw5;
import defpackage.o30;
import defpackage.pa6;
import defpackage.pm2;
import defpackage.pw5;
import defpackage.q05;
import defpackage.qm5;
import defpackage.s30;
import defpackage.sy5;
import defpackage.t45;
import defpackage.td3;
import defpackage.uk5;
import defpackage.ve;
import defpackage.y30;
import defpackage.zg5;
import defpackage.zh;
import defpackage.zn6;
import defpackage.zv3;
import defpackage.zy4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class MessageFragment extends BaseFragment implements pm2<Cursor>, a.InterfaceC1040a {
    public View f;
    public View g;
    public RecyclerView h;
    public LinearLayoutManager i;
    public ConversationAdapter j;
    public Response.ErrorListener m;
    public Response.Listener<JSONObject> n;
    public i65 o;
    public k65 p;
    public boolean r;
    public boolean s;
    public ConversationAdapter.e u;
    public int k = 0;
    public int l = -1;
    public long q = System.currentTimeMillis();
    public boolean t = false;
    public com.zenmen.palmchat.conversations.threadsnew.filter.a v = new com.zenmen.palmchat.conversations.threadsnew.filter.a();
    public ArrayList<ConversationAdapter.a> w = new ArrayList<>();
    public boolean x = false;
    public y30 y = new y30(new d());
    public long z = 0;
    public long A = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<JSONObject> {
        public a() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.d("MessageFragment", jSONObject.toString());
            int iOptInt = jSONObject.optInt("resultCode");
            MessageFragment.this.G();
            if (iOptInt == 0) {
                iq5.j(false, new String[0]);
            } else {
                MessageFragment.this.T0();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {
        public b() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            MessageFragment.this.G();
            MessageFragment.this.T0();
            LogUtil.d("MessageFragment", volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13763a;

        public c(int i) {
            this.f13763a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            MessageFragment.this.i.scrollToPositionWithOffset(this.f13763a, 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements y30.c {
        public d() {
        }

        @Override // y30.c
        public boolean a() {
            return MessageFragment.this.C0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements SeeMeManager.d {
        public e() {
        }

        @Override // com.zenmen.palmchat.conversations.threadsnew.SeeMeManager.d
        public void a(t45 t45Var, com.zenmen.palmchat.conversations.threadsnew.a aVar) {
            MessageFragment.this.t = false;
            if (MessageFragment.this.u == null) {
                MessageFragment.this.u = new ConversationAdapter.e(t45Var, aVar);
                if (MessageFragment.this.C0()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(MessageFragment.this.u);
                    MessageFragment.this.j.c(arrayList);
                    if (MessageFragment.this.isResumed()) {
                        MessageFragment.this.w0();
                    }
                }
            } else {
                MessageFragment.this.u.a(t45Var, aVar);
                if (MessageFragment.this.C0()) {
                    MessageFragment.this.j.notifyDataSetChanged();
                }
            }
            MessageFragment.this.t0();
        }

        @Override // com.zenmen.palmchat.conversations.threadsnew.SeeMeManager.d
        public void b() {
            MessageFragment.this.t = false;
            if (MessageFragment.this.u == null || MessageFragment.this.j.f() == null) {
                return;
            }
            MessageFragment.this.j.f().remove(MessageFragment.this.u);
            MessageFragment.this.u = null;
            MessageFragment.this.j.notifyDataSetChanged();
        }

        @Override // com.zenmen.palmchat.conversations.threadsnew.SeeMeManager.d
        public void onException(Exception exc) {
            MessageFragment.this.t = false;
            LogUtil.e("MessageFragment", "load seeme info failed.", exc);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uk5 f13766a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MessageFragment.this.O0(false);
            }
        }

        public f(uk5 uk5Var) {
            this.f13766a = uk5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            uk5 uk5Var = this.f13766a;
            if (uk5Var.f21235a != 50) {
                return;
            }
            int i = uk5Var.b;
            if (i == 1) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                z = Math.abs(jCurrentTimeMillis - MessageFragment.this.q) > 300000;
                MessageFragment.this.q = jCurrentTimeMillis;
            } else if (i != 2 && i != 3) {
                z = false;
            }
            if (z) {
                MessageFragment.this.Q0(false);
                RecyclerView recyclerView = MessageFragment.this.h;
                if (recyclerView != null) {
                    recyclerView.postDelayed(new a(), 1000L);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MessageFragment.this.y.d();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MessageFragment.this.getActivity() != null) {
                if (TeenagersModeManager.a().d()) {
                    sy5.h(AppContext.getContext(), "青少年模式开启中，暂时无法使用该功能哦", 1);
                    return;
                }
                ve.o(MessageFragment.this.getActivity(), pw5.a().blank_url, false);
                zn6.b("msgtab_subtitle_blank");
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements g74<ConversationAdapter.c> {
        public i() {
        }

        @Override // defpackage.g74
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(View view, int i, ConversationAdapter.c cVar) {
            if (q05.p()) {
                return;
            }
            int i2 = 0;
            if (!(cVar instanceof ConversationAdapter.a)) {
                if (cVar instanceof ConversationAdapter.d) {
                    if (o30.t()) {
                        sy5.h(MessageFragment.this.getContext(), "青少年模式不可用", 0);
                        return;
                    }
                    if (!o30.t) {
                        o30.y(MessageFragment.this.j);
                    }
                    o30.m(MessageFragment.this.getActivity(), 9);
                    return;
                }
                return;
            }
            ConversationAdapter.a aVar = (ConversationAdapter.a) cVar;
            ThreadChatItem threadChatItem = aVar.f13812a;
            if (threadChatItem != null) {
                if (threadChatItem.isRiskThreadGroup) {
                    MessageFragment.this.getActivity().startActivity(new Intent(MessageFragment.this.getActivity(), (Class<?>) RiskThreadsListActivity.class));
                    return;
                }
                if (threadChatItem.getBizType() >= 10000) {
                    if (ThreadFolderManager.e(threadChatItem.getBizType())) {
                        if (threadChatItem.getBizType() == 10001) {
                            LogUtil.onClickEvent("11", null, null);
                        }
                        Intent intent = new Intent(MessageFragment.this.getActivity(), (Class<?>) GreetingsThreadsActivity.class);
                        intent.putExtra("group_type", threadChatItem.getBizType());
                        MessageFragment.this.getActivity().startActivity(intent);
                        return;
                    }
                    return;
                }
                int i3 = 2;
                if (threadChatItem.isChatMateMsgListItem) {
                    o30.h("click", threadChatItem.relativeContact);
                    if (o30.t()) {
                        sy5.h(MessageFragment.this.getContext(), "青少年模式不可用", 0);
                        return;
                    } else {
                        o30.z(aVar, MessageFragment.this.j);
                        o30.x(MessageFragment.this.getActivity(), threadChatItem.chatMateRoomId, 2, threadChatItem.relativeContact);
                        return;
                    }
                }
                Intent intent2 = new Intent(MessageFragment.this.getActivity(), (Class<?>) ChatterActivity.class);
                intent2.setExtrasClassLoader(ChatItem.class.getClassLoader());
                ChatItem chatItemConvert2ContactOrGroupChatInfo = threadChatItem.convert2ContactOrGroupChatInfo();
                if (chatItemConvert2ContactOrGroupChatInfo == null) {
                    return;
                }
                String str = threadChatItem.lastMsgMid;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(DeviceInfoUtil.UID_TAG, chatItemConvert2ContactOrGroupChatInfo.getChatId());
                    jSONObject.put("mid", str);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (chatItemConvert2ContactOrGroupChatInfo instanceof ContactInfoItem) {
                    intent2.setExtrasClassLoader(ContactInfoItem.class.getClassLoader());
                } else if (chatItemConvert2ContactOrGroupChatInfo instanceof GroupInfoItem) {
                    intent2.setExtrasClassLoader(GroupInfoItem.class.getClassLoader());
                }
                intent2.putExtra("chat_item", chatItemConvert2ContactOrGroupChatInfo);
                intent2.putExtra("chat_need_back_to_main", MessageFragment.this.G0());
                intent2.putExtra("thread_biz_type", threadChatItem.getBizType());
                if (o30.q(chatItemConvert2ContactOrGroupChatInfo.getChatId())) {
                    intent2.putExtra("chat_mate_activity_from", 13);
                }
                if (threadChatItem.getChatType() == 0) {
                    LogUtil.onClickEvent(BaseWrapper.ENTER_ID_MARKET, null, jSONObject.toString());
                } else if (threadChatItem.getChatType() == 1) {
                    if (MessageFragment.this.y0() == 1) {
                        intent2.putExtra("fromType", 7);
                    } else {
                        intent2.putExtra("fromType", 2);
                    }
                    try {
                        if (!(MessageFragment.this instanceof GroupChatFragment)) {
                            i3 = 1;
                        }
                        jSONObject.put("page", i3);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    LogUtil.onClickEvent(BaseWrapper.ENTER_ID_GAME_CENTER, null, jSONObject.toString());
                    intent2.putExtra("draft_remind_uids", threadChatItem.remindIds);
                }
                intent2.putExtra("chat_draft", threadChatItem.draft);
                k86.X(intent2);
                if (!MessageFragment.this.N0(threadChatItem)) {
                    MessageFragment.this.getActivity().startActivity(intent2);
                }
                if (a65.f(chatItemConvert2ContactOrGroupChatInfo.getChatId())) {
                    String str2 = threadChatItem.lastMsg;
                    int i4 = threadChatItem.unReadCount;
                    boolean z = str2 != null && str2.startsWith("[连信红包]");
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put(DeviceInfoUtil.UID_TAG, chatItemConvert2ContactOrGroupChatInfo.getChatId());
                        if (i4 <= 0) {
                            i4 = 0;
                        }
                        jSONObject2.put("unread", i4);
                        if (z) {
                            jSONObject2.put("type", 1);
                        } else {
                            jSONObject2.put("type", 0);
                        }
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    LogUtil.onImmediateClickEvent("15", null, jSONObject2.toString());
                }
                if ("88888003".equals(chatItemConvert2ContactOrGroupChatInfo.getChatId())) {
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        int i5 = threadChatItem.unReadCount;
                        if (i5 > 0) {
                            i2 = i5;
                        }
                        jSONObject3.put("superscript", i2);
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                    LogUtil.uploadInfoImmediate("dt11", "1", null, jSONObject3.toString());
                    LogUtil.i("MessageFragment", "dt11" + jSONObject3.toString());
                }
                if (MessageFragment.this.v.e() != FilterType.ALL) {
                    HashMap map = new HashMap();
                    map.put("type", String.valueOf(MessageFragment.this.v.e().value));
                    map.put("fuid", chatItemConvert2ContactOrGroupChatInfo.getChatId());
                    zn6.i("msgtab_subtitle_click", map);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements h74<ConversationAdapter.c> {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements td3.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f13772a;
            public final /* synthetic */ ThreadChatItem b;
            public final /* synthetic */ boolean c;

            public a(String str, ThreadChatItem threadChatItem, boolean z) {
                this.f13772a = str;
                this.b = threadChatItem;
                this.c = z;
            }

            @Override // td3.f
            public void a(td3 td3Var, int i, CharSequence charSequence) {
                if (i == 0) {
                    if (TextUtils.isEmpty(this.f13772a)) {
                        return;
                    }
                    nw5.a(this.b, 1 ^ (this.c ? 1 : 0));
                } else {
                    if (i != 1 || TextUtils.isEmpty(this.f13772a)) {
                        return;
                    }
                    f46.l(ch.s().u(), this.b);
                    com.zenmen.palmchat.database.b.j(this.b);
                    nw5.d(DomainHelper.l(this.b));
                }
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements td3.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f13773a;
            public final /* synthetic */ ThreadChatItem b;
            public final /* synthetic */ boolean c;
            public final /* synthetic */ int d;
            public final /* synthetic */ boolean e;
            public final /* synthetic */ boolean f;
            public final /* synthetic */ boolean g;
            public final /* synthetic */ boolean h;

            public b(String str, ThreadChatItem threadChatItem, boolean z, int i, boolean z2, boolean z3, boolean z4, boolean z5) {
                this.f13773a = str;
                this.b = threadChatItem;
                this.c = z;
                this.d = i;
                this.e = z2;
                this.f = z3;
                this.g = z4;
                this.h = z5;
            }

            @Override // td3.f
            public void a(td3 td3Var, int i, CharSequence charSequence) {
                if (i == 0) {
                    if (TextUtils.isEmpty(this.f13773a)) {
                        return;
                    }
                    nw5.a(this.b, 1 ^ (this.c ? 1 : 0));
                    return;
                }
                if (i == 1) {
                    if (TextUtils.isEmpty(this.f13773a)) {
                        return;
                    }
                    MessageFragment.this.s0(this.d, this.f13773a, jw5.d(this.d, !this.e, this.f, this.g, this.h, zg5.j(this.b.getChatId())));
                    return;
                }
                if (i != 2 || TextUtils.isEmpty(this.f13773a)) {
                    return;
                }
                f46.l(ch.s().u(), this.b);
                com.zenmen.palmchat.database.b.j(this.b);
                nw5.d(DomainHelper.l(this.b));
                if (pa6.p() != null) {
                    pa6.p().X(0, this.f13773a, this.b.getBizType());
                }
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c implements td3.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ThreadChatItem f13774a;
            public final /* synthetic */ int b;

            public c(ThreadChatItem threadChatItem, int i) {
                this.f13774a = threadChatItem;
                this.b = i;
            }

            @Override // td3.f
            public void a(td3 td3Var, int i, CharSequence charSequence) {
                f46.l(ch.s().u(), this.f13774a);
                nw5.c(this.b);
            }
        }

        public j() {
        }

        @Override // defpackage.h74
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean a(View view, int i, ConversationAdapter.c cVar) {
            ThreadChatItem threadChatItem;
            if (!(cVar instanceof ConversationAdapter.a) || (threadChatItem = ((ConversationAdapter.a) cVar).f13812a) == null || threadChatItem.isRiskThreadGroup || threadChatItem.isChatMateMsgListItem) {
                return false;
            }
            String str = threadChatItem.relativeContact;
            boolean z = threadChatItem.priority == 100;
            boolean z2 = threadChatItem.isNoDisturb;
            boolean z3 = threadChatItem.showMembersNickName;
            boolean z4 = threadChatItem.unReadCount > 0;
            boolean z5 = threadChatItem.isBlackList;
            int i2 = threadChatItem.chatType;
            int i3 = threadChatItem.bizType;
            td3.c cVar2 = new td3.c(MessageFragment.this.getActivity());
            if (fu5.t(i3)) {
                String[] strArr = new String[2];
                Resources resources = MessageFragment.this.getResources();
                strArr[0] = z4 ? resources.getString(R.string.thread_set_read) : resources.getString(R.string.thread_set_unread);
                strArr[1] = MessageFragment.this.getResources().getString(R.string.menu_dialog_item_delete);
                cVar2.c(strArr).d(new a(str, threadChatItem, z4)).a().b();
                return true;
            }
            if (i3 >= 10000) {
                cVar2.c(new String[]{MessageFragment.this.getString(R.string.menu_dialog_item_delete)}).d(new c(threadChatItem, i3)).a().b();
                return true;
            }
            String[] strArr2 = new String[3];
            Resources resources2 = MessageFragment.this.getResources();
            strArr2[0] = z4 ? resources2.getString(R.string.thread_set_read) : resources2.getString(R.string.thread_set_unread);
            strArr2[1] = MessageFragment.this.getResources().getString(z ? R.string.thread_cancel_top : R.string.thread_set_top);
            strArr2[2] = MessageFragment.this.getResources().getString(R.string.menu_dialog_item_delete);
            cVar2.c(strArr2).d(new b(str, threadChatItem, z4, i2, z, z2, z3, z5)).a().b();
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Response.ErrorListener {
        public k() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            MessageFragment.this.G();
            MessageFragment.this.T0();
            LogUtil.d("MessageFragment", volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements Response.Listener<JSONObject> {
        public l() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.d("MessageFragment", jSONObject.toString());
            int iOptInt = jSONObject.optInt("resultCode");
            MessageFragment.this.G();
            if (iOptInt == 0) {
                iq5.j(false, new String[0]);
            } else {
                MessageFragment.this.T0();
            }
        }
    }

    public int A0() {
        return ch.s().A();
    }

    public final void B0() {
        this.g = this.f.findViewById(R.id.emptyLayout);
        TextView textView = (TextView) this.f.findViewById(R.id.emptyBtn);
        textView.setText(pw5.a().blank_button);
        ((TextView) this.f.findViewById(R.id.emptyTitle)).setText(pw5.a().blank_txt);
        textView.setOnClickListener(new h());
    }

    public final boolean C0() {
        com.zenmen.palmchat.conversations.threadsnew.filter.a aVar = this.v;
        return aVar != null && aVar.e() == FilterType.ALL;
    }

    public final void E0() {
        if (getClass() != MessageFragment.class || this.j == null || this.t) {
            return;
        }
        this.t = true;
        SeeMeManager.k(getContext(), new e());
    }

    public boolean G0() {
        return true;
    }

    @Override // com.zenmen.palmchat.BaseFragment
    public void I() {
        super.I();
        UI.c(getActivity(), y0(), null, this);
    }

    public boolean I0() {
        return false;
    }

    @Override // com.zenmen.palmchat.BaseFragment
    public void K(boolean z) {
        super.K(z);
        b05.d("MessageFragmentonUserVisibleChange" + z);
        this.x = z;
        if (z) {
            M0();
            if (!AdSplaseActivity.u && cx5.b().e() == 0 && SAppUtil.a.b()) {
                e9.d().r(getActivity());
            }
            o30.d(this.j);
            o30.c(this.j);
        }
    }

    public final void K0() {
        this.j.q(this.y.c(this.v.d(this.w), false));
        this.j.x(true);
        t0();
        b05.d("onDbDataChanged()");
        V0();
        o30.F(this.j);
        o30.G(this.j);
    }

    @Override // defpackage.pm2
    /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        LogUtil.i("MessageFragment", "onLoadFinished");
        if (loader.getId() != y0() || cursor == null) {
            return;
        }
        LogUtil.i("MessageFragment", "onLoadFinished" + cursor.getCount());
        this.l = -1;
        boolean z = false;
        this.k = 0;
        ArrayList<ConversationAdapter.a> arrayList = new ArrayList<>();
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            ThreadChatItem cursor2 = ThreadChatItem.parseCursor(cursor);
            ConversationAdapter.a aVar = new ConversationAdapter.a(cursor2);
            if (!I0() || !a65.f(cursor2.getChatId())) {
                arrayList.add(aVar);
                if (cursor2.chatType == 1) {
                    this.k++;
                }
                if (!z) {
                    int i2 = cursor.getInt(cursor.getColumnIndex("thread_biz_type"));
                    ThreadFolderManager.FolderType folderType = ThreadFolderManager.FolderType.TYPE_SQUARE_GREETINGS;
                    if (folderType.enable() && folderType.groupBizType == com.zenmen.palmchat.conversations.threadgroup.a.c(i2)) {
                        long j2 = cursor.getLong(cursor.getColumnIndex("latest_message_time_stamp"));
                        if (j2 > 0 && j2 < System.currentTimeMillis() - mo5.d()) {
                            z = true;
                        }
                    }
                }
                if (ThreadFolderManager.FolderType.TYPE_SQUARE_GREETINGS.groupBizType == cursor.getInt(cursor.getColumnIndex("thread_biz_type"))) {
                    this.l = cursor.getPosition();
                }
                String strS = DomainHelper.s(cursor.getString(cursor.getColumnIndex("contact_relate")));
                if (zv3.s() && !this.r && a65.f(strS)) {
                    this.r = true;
                    zv3.u(getActivity());
                }
            }
        }
        ly4.d().c(arrayList);
        this.w = arrayList;
        K0();
        if (y0() == 1) {
            X0(arrayList.size(), this.j.getItemCount(), z);
        }
        if (this.j.getItemCount() != 0 && !this.s) {
            this.s = true;
            R0(new Intent(ThreadsNewFragment.E));
        }
        if (z) {
            Q0(true);
        }
    }

    public final void M0() {
        this.y.e();
        ConversationAdapter conversationAdapter = this.j;
        if (conversationAdapter != null) {
            conversationAdapter.notifyDataSetChanged();
            O0(true);
        }
        w0();
        E0();
        t0();
    }

    public final boolean N0(ThreadChatItem threadChatItem) {
        boolean zG = false;
        if (threadChatItem == null) {
            return false;
        }
        String strD = io0.d(bo0.r().l(threadChatItem.relativeContact));
        LogUtil.d("logcontact", "processDirectStart url=" + strD);
        if (!TextUtils.isEmpty(strD)) {
            if (b65.a().b(threadChatItem.relativeContact)) {
                b65.c();
                return true;
            }
            Pair<Integer, ContentValues> pairG = mb4.g(strD);
            if (pairG != null) {
                int iIntValue = ((Integer) pairG.first).intValue();
                ContentValues contentValues = (ContentValues) pairG.second;
                contentValues.put("extra_key_from_uid", threadChatItem.relativeContact);
                zG = zy4.g(getActivity(), iIntValue, contentValues, null, strD, null, null);
                if (zG) {
                    u0(threadChatItem);
                }
            }
        }
        return zG;
    }

    public final void O0(boolean z) {
        if (getClass() != MessageFragment.class) {
            return;
        }
        mo5.e(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Q0(boolean z) {
        boolean z2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z) {
            long j2 = this.A;
            z2 = j2 <= 0 || jCurrentTimeMillis - j2 >= 60000;
        }
        if (z2) {
            this.A = jCurrentTimeMillis;
            UI.e(getActivity(), y0(), null, this);
            LogUtil.i("MessageFragment", "restartLoader: limitFrequency = " + z);
            LogUtil.uploadInfoImmediateWithRateCheck("key_restartloader_on_thread", null);
        }
    }

    public void R0(Intent intent) {
        LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(intent);
    }

    public void S0(com.zenmen.palmchat.conversations.threadsnew.filter.a aVar) {
        this.v = aVar;
        aVar.q(this);
    }

    public final void T0() {
        sy5.e(getActivity(), R.string.send_failed, 0).g();
    }

    public final void V0() {
        com.zenmen.palmchat.conversations.threadsnew.filter.a aVar = this.v;
        boolean z = (aVar == null || aVar.e() == FilterType.ALL || this.j.getItemCount() != 0) ? false : true;
        View view = this.g;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void W0() {
        LinearLayoutManager linearLayoutManager;
        if (this.h == null || (linearLayoutManager = this.i) == null || this.j == null) {
            return;
        }
        this.h.post(new c(this.j.r(linearLayoutManager.findFirstVisibleItemPosition(), A0() == 0)));
    }

    public final void X0(int i2, int i3, boolean z) {
        LogUtil.i("MessageFragment", "uploadThreadException total" + cx5.b().f16945a + " loadCount=" + i2 + isResumed());
        if ((cx5.b().f16945a <= 0 || !((i2 == 0 || i3 == 0) && isResumed())) && !z) {
            return;
        }
        HashMap map = new HashMap();
        map.put("threadTotalCount", String.valueOf(cx5.b().f16945a));
        map.put("unReadCount", String.valueOf(cx5.b().e()));
        map.put("loadCount", Integer.valueOf(i2));
        map.put("isResumed", Boolean.valueOf(isResumed()));
        map.put("listCount", Integer.valueOf(i3));
        LogUtil.uploadInfoImmediate("key_thread_load_exception", map);
    }

    @Override // com.zenmen.palmchat.conversations.threadsnew.filter.a.InterfaceC1040a
    public void b(FilterType filterType) {
        K0();
    }

    @qm5
    public void chatMateEvent(m30 m30Var) {
        if (m30Var != null) {
            int i2 = m30Var.b;
            LogUtil.d("ChatMateGiftManagerTAG", "MsgFragment removechatMateEvent type " + i2);
            if (i2 == 1) {
                o30.b(m30Var.f19133a, this.j);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @qm5
    public void onChatOneCountDownEvent(s30 s30Var) {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        activity.runOnUiThread(new g());
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ds0.a().c(this);
        ch.s().r().j(this);
    }

    public Loader<Cursor> onCreateLoader(int i2, Bundle bundle) {
        LogUtil.i("MessageFragment", "onCreateLoader " + i2);
        if (i2 != y0()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        sb.append("thread_active");
        sb.append("=? and ");
        arrayList.add(String.valueOf(1));
        sb.append("contact_relate");
        sb.append(" !=? and ");
        arrayList.add("88888003");
        if (dd6.b()) {
            sb.append("contact_relate");
            sb.append(" !=? and ");
            arrayList.add("88888027");
        }
        if (dd6.a()) {
            sb.append("contact_relate");
            sb.append(" !=? and ");
            arrayList.add("88888010");
        }
        sb.append("thread_blacklist");
        sb.append("=? and  (( ");
        arrayList.add(String.valueOf(0));
        sb.append("thread_contact_ready");
        sb.append("=? and (");
        arrayList.add(String.valueOf(1));
        sb.append("thread_biz_type");
        sb.append("=? or ");
        arrayList.add(String.valueOf(0));
        fu5.a(sb, arrayList, true);
        sb.append("thread_biz_type");
        sb.append("=?)) or (");
        arrayList.add(String.valueOf(13));
        sb.append("thread_contact_ready");
        sb.append(" =? and ");
        arrayList.add(String.valueOf(0));
        sb.append("thread_biz_type");
        sb.append(" =? ))");
        arrayList.add(String.valueOf(22));
        String string = sb.toString();
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        LogUtil.i("MessageFragment", "onCreateLoader selection" + string);
        return new CursorLoader(getActivity(), dx5.f17178a, null, string, strArr, "thread_priority DESC , pin_gift_message DESC , is_super_greetings DESC , thread_draft_time DESC , latest_message_time_stamp DESC");
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(x0(), viewGroup, false);
        this.f = viewInflate;
        this.h = (RecyclerView) viewInflate.findViewById(R.id.recycler_view);
        B0();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.i = linearLayoutManager;
        this.h.setLayoutManager(linearLayoutManager);
        this.h.setItemAnimator(null);
        ConversationAdapter conversationAdapter = new ConversationAdapter(getActivity(), null);
        this.j = conversationAdapter;
        this.h.setAdapter(conversationAdapter);
        this.j.n(new i());
        this.j.o(new j());
        this.m = new k();
        this.n = new l();
        E0();
        this.y.f(this.j);
        LogUtil.i("MessageFragment", "oncreateview finish");
        return this.f;
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ch.s().r().l(this);
        try {
            ds0.a().d(this);
        } catch (Exception unused) {
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        LogUtil.i("MessageFragment", "onLoaderReset");
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LogUtil.i("MessageFragment", "onResume");
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.j != null) {
            O0(true);
        }
        t0();
    }

    @qm5
    public void onStatusChanged(uk5 uk5Var) {
        FragmentActivity activity;
        LogUtil.i("MessageFragment", "onStatusChanged type =" + uk5Var.f21235a);
        if (uk5Var.f21235a != 50 || (activity = getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        activity.runOnUiThread(new f(uk5Var));
    }

    @Override // com.zenmen.palmchat.conversations.threadsnew.filter.a.InterfaceC1040a
    public void q() {
        if (this.v.e() == FilterType.HOT) {
            K0();
        }
    }

    public final void s0(int i2, String str, int i3) {
        if (i2 != 0) {
            k65 k65Var = new k65(this.n, this.m);
            this.p = k65Var;
            try {
                k65Var.n(str, i3);
                M(AppContext.getContext().getString(R.string.progress_sending), false);
                return;
            } catch (DaoException e2) {
                e2.printStackTrace();
                G();
                return;
            }
        }
        ContactInfoItem contactInfoItemL = bo0.r().l(str);
        if (contactInfoItemL != null) {
            boolean z = true;
            if (contactInfoItemL.getAccountType() == 1) {
                j00 j00Var = new j00(new a(), new b());
                try {
                    String chatId = contactInfoItemL.getChatId();
                    String strP = AccountUtils.p(getContext());
                    if (jw5.c(contactInfoItemL.getSessionConfig(), 1)) {
                        z = false;
                    }
                    j00Var.n(chatId, strP, null, Boolean.valueOf(z));
                    M(AppContext.getContext().getString(R.string.progress_sending), false);
                    return;
                } catch (DaoException e3) {
                    e3.printStackTrace();
                    return;
                }
            }
        }
        i65 i65Var = new i65(this.n, this.m);
        this.o = i65Var;
        try {
            i65Var.n(str, i3);
            M(AppContext.getContext().getString(R.string.progress_sending), false);
        } catch (DaoException e4) {
            e4.printStackTrace();
            G();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivityForResult(Intent intent, int i2, @Nullable Bundle bundle) {
        super.startActivityForResult(intent, i2, bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ed A[PHI: r2
      0x00ed: PHI (r2v15 int) = (r2v6 int), (r2v19 int) binds: [B:73:0x00ea, B:59:0x00c0] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void t0() {
        ConversationAdapter conversationAdapter;
        List<ConversationAdapter.c> listF;
        int size;
        int i2;
        if (getClass() != MessageFragment.class || (conversationAdapter = this.j) == null || this.u == null || (listF = conversationAdapter.f()) == null) {
            return;
        }
        int iIndexOf = listF.indexOf(this.u);
        if (iIndexOf >= 0) {
            listF.remove(iIndexOf);
        }
        if (!C0()) {
            if (iIndexOf >= 0) {
                this.j.notifyDataSetChanged();
                return;
            }
            return;
        }
        t45 t45Var = this.u.f13814a;
        if (t45Var.b == 2) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j2 = this.u.c;
            size = 0;
            if (j2 == -1 || ((double) Math.abs(jCurrentTimeMillis - j2)) >= ((this.u.f13814a.c * 60.0d) * 60.0d) * 1000.0d) {
                this.u.c = jCurrentTimeMillis;
            }
            for (ConversationAdapter.c cVar : listF) {
                if (cVar instanceof ConversationAdapter.a) {
                    ThreadChatItem threadChatItem = ((ConversationAdapter.a) cVar).f13812a;
                    if (threadChatItem != null && threadChatItem.priority == 0 && threadChatItem.pinGiftMessage == 0 && threadChatItem.isSuperGreetings == 0) {
                        long j3 = threadChatItem.draftDate;
                        if (j3 != 0) {
                            long j4 = this.u.c;
                            if (j4 == j3) {
                                if (this.u.c >= threadChatItem.lastMessageDate) {
                                    i2 = size;
                                    break;
                                }
                            } else if (j4 > j3) {
                                i2 = size;
                                break;
                            }
                        }
                    }
                    size++;
                }
            }
            i2 = -1;
            if (i2 != -1) {
                size = i2;
            }
        } else {
            int i3 = t45Var.i;
            Iterator<ConversationAdapter.c> it = listF.iterator();
            size = i3;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                }
                ConversationAdapter.c next = it.next();
                if (next instanceof ConversationAdapter.a) {
                    ThreadChatItem threadChatItem2 = ((ConversationAdapter.a) next).f13812a;
                    if (threadChatItem2 != null && threadChatItem2.priority == 0) {
                        i2 = size;
                        break;
                    }
                    size++;
                }
            }
            if (i2 != -1) {
            }
        }
        if (size > listF.size()) {
            size = listF.size();
        }
        listF.add(size, this.u);
        if (size != iIndexOf) {
            this.j.notifyDataSetChanged();
        }
    }

    public final void u0(ChatItem chatItem) {
        String[] strArr = {DomainHelper.l(chatItem)};
        ContentValues contentValues = new ContentValues();
        contentValues.put("unread_message_count", (Integer) 0);
        contentValues.put("thread_latest_unread_message_time", (Integer) 0);
        contentValues.put("thread_latest_unread_message_primary_key_id", (Integer) 0);
        contentValues.put("thread_has_remind", (Integer) 0);
        CircleNoticeItem.circleThreadHasNoticeStatus(chatItem.getChatId(), 0);
        VoucherRedPacketVo.circleThreadHasVoucherStatus(chatItem.getChatId(), 0);
        zh.k(AppContext.getContext().getContentResolver()).j(0, null, dx5.f17178a, contentValues, "contact_relate=?", strArr);
    }

    public final void w0() {
        if (getClass() == MessageFragment.class && this.u != null) {
            SeeMeViewHolder.u(true);
        }
    }

    public int x0() {
        return R.layout.layout_fragment_message;
    }

    public int y0() {
        return 1;
    }
}
