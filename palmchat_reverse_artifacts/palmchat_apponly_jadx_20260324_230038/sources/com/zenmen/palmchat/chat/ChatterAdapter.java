package com.zenmen.palmchat.chat;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.huawei.openalliance.ad.constant.bq;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.CircleNotice;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.aigreeting.vo.AiGreetingChatCardInfo;
import com.zenmen.palmchat.chat.gift.quicksend.QuickSendVo;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.conversations.threadsnew.chatone.vo.ChatOneItemVo;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.bridge.risk.RiskConfig;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.media.AudioController;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.utils.urlspan.MyUrlSpan;
import com.zenmen.palmchat.widget.LXPortraitView;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.a65;
import defpackage.az2;
import defpackage.b05;
import defpackage.bo0;
import defpackage.by5;
import defpackage.ds0;
import defpackage.e20;
import defpackage.ef2;
import defpackage.fg6;
import defpackage.fi5;
import defpackage.hb3;
import defpackage.he;
import defpackage.i50;
import defpackage.ir5;
import defpackage.je1;
import defpackage.l10;
import defpackage.lt4;
import defpackage.m40;
import defpackage.mb4;
import defpackage.mi5;
import defpackage.o40;
import defpackage.oc0;
import defpackage.p40;
import defpackage.qm5;
import defpackage.qq2;
import defpackage.sd3;
import defpackage.t20;
import defpackage.u10;
import defpackage.v10;
import defpackage.w8;
import defpackage.x30;
import defpackage.x8;
import defpackage.xa3;
import defpackage.y56;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ChatterAdapter extends BaseAdapter implements p40, w8 {
    public static final String P = "ChatterAdapter";
    public int F;
    public MessageVo G;
    public Activity H;
    public j I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f12588a;
    public List<o40> b;
    public com.zenmen.palmchat.chat.fragment.a c;
    public ChatItem d;
    public ContactInfoItem e;
    public GroupInfoItem f;
    public HashMap<String, ContactInfoItem> h;
    public je1 i;
    public SimpleDateFormat j;
    public h k;
    public he l;
    public ChatterMoreActionFragment q;
    public g s;
    public i t;
    public double v;
    public boolean w;
    public List<String> z;
    public boolean g = false;
    public ArrayList<MessageVo> m = new ArrayList<>();
    public long n = 0;
    public boolean o = false;
    public LinkedHashMap<String, MessageVo> p = new LinkedHashMap<>();
    public boolean r = false;
    public boolean u = true;
    public boolean x = false;
    public List<String> y = new ArrayList();
    public List<SquareFeed> A = new ArrayList();
    public boolean B = false;
    public boolean C = true;
    public boolean E = false;
    public x8 J = new x8(this);
    public x30 K = new x30(this);
    public boolean L = false;
    public HashMap<String, Boolean> M = new HashMap<>();
    public long N = -1;
    public boolean O = false;

    /* JADX INFO: compiled from: SearchBox */
    public enum OtherViewType {
        ReSendRedPacket,
        SendImageToMoments
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ fi5 f12589a;

        public a(fi5 fi5Var) {
            this.f12589a = fi5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f12589a.f17534a == null) {
                return;
            }
            ChatterAdapter.this.A.add(this.f12589a.f17534a);
            ChatterAdapter.this.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12590a;

        public b(MessageVo messageVo) {
            this.f12590a = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ChatterAdapter.this.k != null) {
                ChatterAdapter.this.k.b0(this.f12590a, true);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12591a;

        public c(MessageVo messageVo) {
            this.f12591a = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ChatterAdapter.this.k != null) {
                ChatterAdapter.this.k.b0(this.f12591a, false);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12592a;
        public final /* synthetic */ ContactInfoItem b;

        public d(MessageVo messageVo, ContactInfoItem contactInfoItem) {
            this.f12592a = messageVo;
            this.b = contactInfoItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ChatterAdapter.this.k != null) {
                ChatterAdapter.this.k.q0(this.f12592a.isSend ? ChatterAdapter.this.e : this.b);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12593a;
        public final /* synthetic */ ContactInfoItem b;

        public e(MessageVo messageVo, ContactInfoItem contactInfoItem) {
            this.f12593a = messageVo;
            this.b = contactInfoItem;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (ChatterAdapter.this.k == null) {
                return true;
            }
            ChatterAdapter.this.k.X(this.f12593a.isSend ? ChatterAdapter.this.e : this.b);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12594a;
        public final /* synthetic */ u10 b;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
            }
        }

        public f(MessageVo messageVo, u10 u10Var) {
            this.f12594a = messageVo;
            this.b = u10Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ChatterAdapter.this.w && ChatterAdapter.this.p.size() > 100) {
                new sd3(ChatterAdapter.this.f12588a).j(R.string.report_dialog_content).O(R.string.dialog_confirm).f(new a()).e().show();
                return;
            }
            if (ChatterAdapter.this.p.containsKey(this.f12594a.mid)) {
                ChatterAdapter.this.p.remove(this.f12594a.mid);
                this.b.k.setImageResource(R.drawable.ic_checkbox_uncheck);
                if (ChatterAdapter.this.q == null || !ChatterAdapter.this.p.isEmpty()) {
                    return;
                }
                ChatterAdapter.this.q.V(false);
                return;
            }
            LinkedHashMap linkedHashMap = ChatterAdapter.this.p;
            MessageVo messageVo = this.f12594a;
            linkedHashMap.put(messageVo.mid, messageVo);
            this.b.k.setImageResource(R.drawable.ic_checkbox_green_check);
            if (ChatterAdapter.this.q == null || ChatterAdapter.this.q.T()) {
                return;
            }
            ChatterAdapter.this.q.V(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface g {
        void W0(String str);

        void b1(String str, int i, ContentValues contentValues, y56 y56Var);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface h extends MyUrlSpan.a, w8 {
        void D0(String str);

        void H(MessageVo messageVo, Object obj);

        void J0(OtherViewType otherViewType, MessageVo messageVo);

        void N(MessageVo messageVo);

        void Q(MessageVo messageVo);

        void S(MessageVo messageVo);

        void X(ContactInfoItem contactInfoItem);

        void b0(MessageVo messageVo, boolean z);

        void f0();

        void g0(MessageVo messageVo, String str, QuickSendVo quickSendVo);

        boolean i0();

        void m(MessageVo messageVo, Object obj);

        void o0(MessageVo messageVo);

        void o1(MessageVo messageVo);

        void q0(ContactInfoItem contactInfoItem);

        void q1(String str);

        void t(MessageVo messageVo, String str);

        void v0(MessageVo messageVo, String str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface i {
        void a();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface j {
        String e();

        ChatOneItemVo f();
    }

    public ChatterAdapter(Activity activity, ChatItem chatItem, h hVar, boolean z, boolean z2, com.zenmen.palmchat.chat.fragment.a aVar) {
        this.w = false;
        this.k = hVar;
        this.f12588a = activity;
        this.d = chatItem;
        this.w = z;
        this.c = aVar;
        if (chatItem instanceof GroupInfoItem) {
            this.f = (GroupInfoItem) chatItem;
        }
        this.e = bo0.r().l(AccountUtils.p(AppContext.getContext()));
        this.b = i50.d().c(activity, chatItem, this);
        this.i = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).y(false).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).z(R.drawable.default_portrait).B(R.drawable.default_portrait).r();
        this.j = new SimpleDateFormat("HH:mm");
        this.l = new he();
        this.z = new ArrayList();
        ds0.a().c(this);
    }

    public static int M(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str).getInt("height");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return 0;
    }

    public static float O(String str) {
        return P(str, false);
    }

    public static float P(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return z ? 1.3333334f : 1.0f;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("width");
            int iOptInt2 = jSONObject.optInt("height");
            if (iOptInt == 0 || iOptInt2 == 0) {
                return 1.0f;
            }
            return iOptInt / iOptInt2;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return 1.0f;
        }
    }

    public static int R(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str).getInt("width");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return 0;
    }

    public void A(int i2) {
        MessageVo messageVoBuildAdMessage;
        if (i2 == -1 || this.B || (messageVoBuildAdMessage = MessageVo.buildAdMessage(i2)) == null) {
            return;
        }
        if (this.m.isEmpty()) {
            this.m.add(messageVoBuildAdMessage);
        } else {
            ArrayList<MessageVo> arrayList = this.m;
            arrayList.add(arrayList.size() - 1, messageVoBuildAdMessage);
        }
        this.B = true;
    }

    public void A0(j jVar) {
        this.I = jVar;
    }

    public void B(MessageVo messageVo) {
        this.m.add(messageVo);
        notifyDataSetChanged();
    }

    public void B0(long j2) {
        this.n = j2;
        notifyDataSetChanged();
    }

    public void C(MessageVo messageVo) {
        if (this.E || messageVo == null) {
            return;
        }
        this.G = messageVo;
        this.m.add(messageVo);
        notifyDataSetChanged();
        this.E = true;
    }

    public void C0(GroupInfoItem groupInfoItem, HashMap<String, ContactInfoItem> map) {
        this.g = true;
        this.f = groupInfoItem;
        this.h = map;
    }

    public final void D() {
        if (this.C) {
            ArrayList<MessageVo> arrayList = this.m;
            if (arrayList == null || arrayList.size() <= 0) {
                this.N = 0L;
                return;
            } else {
                ArrayList<MessageVo> arrayList2 = this.m;
                this.N = arrayList2.get(arrayList2.size() - 1)._id;
                return;
            }
        }
        ArrayList<MessageVo> arrayList3 = this.m;
        if (arrayList3 == null || arrayList3.size() <= 0) {
            return;
        }
        ArrayList<MessageVo> arrayList4 = this.m;
        if (arrayList4.get(arrayList4.size() - 1)._id <= this.N || this.O) {
            return;
        }
        qq2.j(this.d);
        this.O = true;
    }

    public x8 E() {
        return this.J;
    }

    public void E0(ChatterMoreActionFragment chatterMoreActionFragment) {
        this.q = chatterMoreActionFragment;
    }

    public ChatItem F() {
        return this.d;
    }

    public void F0(boolean z, MessageVo messageVo) {
        this.o = z;
        this.p.clear();
        if (messageVo != null) {
            this.p.put(messageVo.mid, messageVo);
        }
        notifyDataSetChanged();
    }

    public ArrayList<MessageVo> G() {
        ArrayList<MessageVo> arrayList = new ArrayList<>();
        Iterator<Map.Entry<String, MessageVo>> it = this.p.entrySet().iterator();
        while (it.hasNext()) {
            MessageVo value = it.next().getValue();
            if (value.mimeType != 10001) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    public void G0(double d2) {
        this.v = d2;
    }

    public void H0(boolean z) {
        if (this.r != z) {
            this.r = z;
            notifyDataSetChanged();
        }
    }

    public ArrayList<MessageVo> I() {
        return this.m;
    }

    public void I0(boolean z) {
        this.L = z;
    }

    public j J() {
        return this.I;
    }

    public int K() {
        if (this.n > 0) {
            for (int i2 = 0; i2 < this.m.size(); i2++) {
                if (this.m.get(i2)._id >= this.n) {
                    return i2;
                }
            }
        }
        return -1;
    }

    public final ContactInfoItem L(String str, MessageVo messageVo) {
        if (this.d.getChatType() == 0) {
            return (ContactInfoItem) this.d;
        }
        String strE = m40.e(str);
        if (TextUtils.isEmpty(strE)) {
            return new ContactInfoItem();
        }
        HashMap<String, ContactInfoItem> map = this.h;
        ContactInfoItem contactInfoItem = map != null ? map.get(strE) : null;
        ContactInfoItem contactInfoItemL = bo0.r().l(strE);
        if (contactInfoItem != null) {
            if (contactInfoItemL != null && contactInfoItemL.getIconURL() != null) {
                contactInfoItem.setIconURL(contactInfoItemL.getIconURL());
            }
        } else {
            if (contactInfoItemL != null) {
                return contactInfoItemL;
            }
            contactInfoItem = new ContactInfoItem();
            contactInfoItem.setUid(strE);
        }
        return contactInfoItem;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public MessageVo getItem(int i2) {
        return this.m.get(i2);
    }

    public boolean U() {
        return this.o;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void V(ContactInfoItem contactInfoItem, MessageVo messageVo, u10 u10Var) {
        View view;
        String str;
        Boolean bool = this.M.get(messageVo.mid);
        if (bool == null || !bool.booleanValue()) {
            u10Var.e.setVisibility(8);
        } else {
            long j2 = messageVo.time;
            if (j2 > 0) {
                u10Var.e.setText(by5.d(j2, this.f12588a));
                u10Var.e.setVisibility(0);
            } else {
                u10Var.e.setVisibility(4);
            }
        }
        if (v10.a()) {
            u10Var.e.setBackgroundResource(R.drawable.gray_round_rect_2);
        }
        int i2 = messageVo.mimeType;
        if ((i2 == 10002 || i2 == 30 || i2 == 1) && !messageVo.isSend) {
            u10Var.f.setVisibility(8);
        }
        int i3 = messageVo.mimeType;
        if (i3 == 10000 || i3 == 10001 || i3 == 200005) {
            return;
        }
        if (messageVo.isSend) {
            TextView textView = u10Var.c;
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = u10Var.d;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            ImageView imageView = u10Var.l;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        } else if (this.g && (this.r || oc0.f())) {
            u10Var.c.setVisibility(0);
            if (u10Var.d != null) {
                if (oc0.f() && contactInfoItem.getRoleType() == 2) {
                    u10Var.d.setVisibility(0);
                    u10Var.d.setText("管理员");
                } else if (oc0.f() && contactInfoItem.getRoleType() == 1) {
                    u10Var.d.setVisibility(0);
                    if (getGroupItem() == null) {
                        str = "群主";
                        u10Var.d.setText(str);
                    } else {
                        if (getGroupItem().getGroupExtTypeFromExtension() == 2) {
                            str = "族长";
                        }
                        u10Var.d.setText(str);
                    }
                } else {
                    u10Var.d.setVisibility(8);
                }
            }
            ContactInfoItem contactInfoItemL = bo0.r().l(contactInfoItem.getUid());
            if (contactInfoItemL != null) {
                contactInfoItem.setRemarkName(contactInfoItemL.getRemarkName());
                contactInfoItem.setRemarkAllPinyin(contactInfoItemL.getRemarkAllPinyin());
                contactInfoItem.setRemarkFirstPinyin(contactInfoItemL.getRemarkFirstPinyin());
                contactInfoItem.setExt(contactInfoItemL.getExt());
            }
            u10Var.c.setText(contactInfoItem.getNameForShow());
            int iG = fg6.g(contactInfoItem.getExt());
            if (fg6.q(iG)) {
                ImageView imageView2 = u10Var.l;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                    u10Var.l.setImageResource(fg6.c(iG));
                }
                u10Var.c.setTextColor(fg6.n(this.f12588a, iG));
            } else {
                ImageView imageView3 = u10Var.l;
                if (imageView3 != null) {
                    imageView3.setVisibility(8);
                }
                u10Var.c.setTextColor(this.f12588a.getResources().getColor(R.color.text_color_gray));
            }
        } else {
            TextView textView3 = u10Var.c;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            TextView textView4 = u10Var.d;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            ImageView imageView4 = u10Var.l;
            if (imageView4 != null) {
                imageView4.setVisibility(8);
            }
        }
        if (messageVo.isSend && (view = u10Var.g) != null) {
            int i4 = messageVo.status;
            if (i4 == 4) {
                if (messageVo.time - ir5.b() > 2000) {
                    u10Var.g.setVisibility(8);
                    u10Var.h.setVisibility(0);
                } else {
                    u10Var.g.setVisibility(8);
                    u10Var.h.setVisibility(8);
                }
            } else if (i4 == 1 && messageVo.mimeType != 6) {
                view.setVisibility(8);
                u10Var.h.setVisibility(0);
            } else if (i4 == 3) {
                view.setVisibility(0);
                u10Var.h.setVisibility(8);
            } else {
                view.setVisibility(8);
                u10Var.h.setVisibility(8);
            }
            u10Var.g.setOnClickListener(new b(messageVo));
            TextView textView5 = u10Var.q;
            if (textView5 != null) {
                textView5.setOnClickListener(new c(messageVo));
            }
        }
        LXPortraitView lXPortraitView = u10Var.i;
        if (lXPortraitView == null) {
            return;
        }
        if (messageVo.isSend) {
            ContactInfoItem contactInfoItem2 = this.e;
            if (contactInfoItem2 != null) {
                lXPortraitView.setAvatarView(contactInfoItem2.getIconURL(), this.e.getAmulet());
            }
        } else if (contactInfoItem != null) {
            lXPortraitView.setAvatarView(contactInfoItem.getIconURL(), contactInfoItem.getAmulet());
        }
        u10Var.i.setOnClickListener(new d(messageVo, contactInfoItem));
        if (!a65.e(this.d)) {
            u10Var.i.setOnLongClickListener(new e(messageVo, contactInfoItem));
        }
        if (!this.o) {
            b05.a("未显示多选模式");
            u10Var.j.setVisibility(8);
            u10Var.j.setOnTouchListener(null);
            u10Var.j.setOnClickListener(null);
            u10Var.k.setVisibility(8);
            if (messageVo.isSend) {
                ((RelativeLayout.LayoutParams) u10Var.i.getLayoutParams()).addRule(11, 1);
                return;
            }
            return;
        }
        b05.a("显示多选模式");
        u10Var.j.setVisibility(0);
        u10Var.j.setOnClickListener(new f(messageVo, u10Var));
        u10Var.k.setVisibility(0);
        if (messageVo.isSend) {
            ((RelativeLayout.LayoutParams) u10Var.i.getLayoutParams()).addRule(11, 0);
        }
        if (this.p.containsKey(messageVo.mid)) {
            u10Var.k.setImageResource(R.drawable.ic_checkbox_green_check);
        } else {
            u10Var.k.setImageResource(R.drawable.ic_checkbox_uncheck);
        }
    }

    public final MessageVo W(long j2) {
        RiskConfig riskConfigH = hb3.g().h();
        if (riskConfigH == null || TextUtils.isEmpty(riskConfigH.sys_nofchat_normal)) {
            return null;
        }
        MessageVo messageVo = new MessageVo();
        messageVo.time = j2;
        messageVo.mimeType = 10000;
        messageVo.text = riskConfigH.sys_nofchat_normal;
        return messageVo;
    }

    public final void Y(boolean z) {
        ChatItem chatItem;
        MessageVo messageVoW;
        if (this.m.size() <= 0 || z || !hb3.g().i() || (chatItem = this.d) == null || !(chatItem instanceof ContactInfoItem) || a65.e(chatItem) || a65.c(this.d) || !((ContactInfoItem) this.d).getIsStranger() || (messageVoW = W(this.m.get(0).time)) == null) {
            return;
        }
        this.m.add(1, messageVoW);
    }

    public final boolean Z(Cursor cursor) {
        return cursor.getInt(cursor.getColumnIndex("msg_type")) == 8;
    }

    @Override // defpackage.w8
    public void a(String str) {
        this.J.a(str);
    }

    public final int a0(int i2) {
        if (this.n <= 0) {
            return 1;
        }
        MessageVo messageVo = i2 == 0 ? null : this.m.get(i2 - 1);
        if (messageVo == null || messageVo._id >= this.n || this.m.get(i2)._id < this.n) {
            return (int) (this.m.get(i2)._id - this.n);
        }
        return 0;
    }

    @Override // defpackage.p40
    public HashMap<String, ContactInfoItem> b() {
        return this.h;
    }

    @Override // defpackage.p40
    public AiGreetingChatCardInfo c() {
        return this.J.h();
    }

    public final boolean c0(Cursor cursor) {
        CircleNotice circleNotice;
        if (cursor.getInt(cursor.getColumnIndex("msg_type")) != 53) {
            return false;
        }
        String string = cursor.getString(cursor.getColumnIndex("msg_extend"));
        return (TextUtils.isEmpty(string) || (circleNotice = (CircleNotice) az2.a(string, CircleNotice.class)) == null || circleNotice.getNotice() == null || circleNotice.getNotice().getStatus() == 2) ? false : true;
    }

    public final boolean d0(long j2, long j3) {
        return ((j3 / 1000) / 60) - ((j2 / 1000) / 60) > 4;
    }

    @Override // defpackage.p40
    public com.zenmen.palmchat.chat.fragment.a e() {
        return this.c;
    }

    public final boolean e0(Cursor cursor) {
        return mb4.h(cursor.getInt(cursor.getColumnIndex("msg_type")));
    }

    @Override // defpackage.p40
    public boolean f() {
        return this.x;
    }

    @Override // defpackage.p40
    public ContactInfoItem g(MessageVo messageVo) {
        return messageVo.isSend ? bo0.r().l(AccountUtils.p(this.H)) : this.d.getChatType() == 0 ? (ContactInfoItem) this.d : L(messageVo.from, messageVo);
    }

    @Override // defpackage.p40
    public Activity getActivity() {
        return this.f12588a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.m.size();
    }

    @Override // defpackage.p40
    public GroupInfoItem getGroupItem() {
        return this.f;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        MessageVo messageVo = this.m.get(i2);
        if (messageVo == null) {
            return 0;
        }
        int i3 = messageVo.mimeType;
        for (o40 o40Var : this.b) {
            if (o40Var instanceof l10) {
                ((l10) o40Var).H(this.H);
            }
            int iJ = o40Var.j(messageVo.isSend, i3, messageVo);
            if (iJ != -1) {
                return iJ;
            }
        }
        throw new IllegalStateException("can't support mimeType: " + i3);
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        MessageVo messageVo = this.m.get(i2);
        if (view == null) {
            view = j0(this.f12588a, messageVo);
        }
        u10 u10Var = (u10) view.getTag();
        k0(u10Var.a(), u10Var, messageVo, i2);
        h hVar = this.k;
        if (hVar != null) {
            hVar.Q(messageVo);
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        int viewTypeCount = 0;
        for (o40 o40Var : this.b) {
            if (o40Var instanceof l10) {
                ((l10) o40Var).H(this.H);
            }
            viewTypeCount += o40Var.getViewTypeCount();
        }
        return viewTypeCount;
    }

    @Override // defpackage.p40
    public g h() {
        return this.s;
    }

    public final boolean h0(Cursor cursor) {
        return (Z(cursor) || c0(cursor) || e0(cursor)) ? false : true;
    }

    @Override // defpackage.p40
    public List<String> i() {
        return this.z;
    }

    @Override // defpackage.p40
    public List<SquareFeed> j() {
        return this.A;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [o40] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object, od5, u10] */
    /* JADX WARN: Type inference failed for: r7v4, types: [he] */
    public View j0(Context context, MessageVo messageVo) {
        Iterator<o40> it = this.b.iterator();
        ?? r1 = 0;
        ?? r2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            o40 next = it.next();
            if (next instanceof l10) {
                ((l10) next).H(this.H);
            }
            View viewB = next.b(context, messageVo);
            if (viewB != null) {
                r1 = next;
                r2 = viewB;
                break;
            }
            r2 = viewB;
        }
        ?? r6 = (u10) r1.c(r2);
        r6.b(r1);
        r2.setTag(r6);
        View view = r6.h;
        if (view != null) {
            this.l.d(view);
        }
        if (f() && r6.e() != null) {
            this.l.c(r6);
        }
        return r2;
    }

    public final void k0(o40 o40Var, u10 u10Var, MessageVo messageVo, int i2) {
        h hVar;
        ContactInfoItem contactInfoItemL = L(messageVo.from, messageVo);
        o40Var.i(contactInfoItemL);
        o40Var.e(this.k);
        messageVo.nickName = contactInfoItemL.getNameForShow();
        u10Var.c(o40Var.m(messageVo.isSend, messageVo.mimeType, messageVo));
        if (u10Var.f()) {
            V(contactInfoItemL, messageVo, u10Var);
        }
        o40Var.l(u10Var, messageVo);
        int iA0 = a0(i2);
        if (iA0 != 0) {
            View view = u10Var.m;
            if (view != null) {
                view.setVisibility(8);
            }
        } else if (this.L) {
            View view2 = u10Var.m;
            if (view2 != null) {
                view2.setVisibility(0);
            }
        } else {
            View view3 = u10Var.m;
            if (view3 != null) {
                view3.setVisibility(8);
            }
        }
        if (iA0 <= 0 && (hVar = this.k) != null) {
            hVar.f0();
        }
        xa3.d(bq.b.V, messageVo, new Object[0]);
    }

    @Override // defpackage.w8
    public void l() {
        this.J.l();
    }

    public void l0(boolean z) {
        this.J.j(z);
    }

    public void m0() {
        this.C = true;
        this.G = null;
        ds0.a().d(this);
    }

    public void n0() {
        this.l.e();
    }

    @Override // defpackage.p40
    public h o() {
        return this.k;
    }

    @qm5
    public void onSquareDeleteEvent(fi5 fi5Var) {
        Activity activity = this.H;
        if (activity != null) {
            activity.runOnUiThread(new a(fi5Var));
        }
    }

    public void p0() {
        this.l.g();
        notifyDataSetChanged();
    }

    @Override // defpackage.p40
    public List<String> q() {
        return this.y;
    }

    public boolean r0() {
        return AudioController.b0().p0();
    }

    public void s0() {
        if (this.m.size() > 0) {
            MessageVo messageVo = this.m.get(r0.size() - 1);
            if (messageVo == null || messageVo.mimeType != 200010) {
                return;
            }
            this.m.remove(r0.size() - 1);
            notifyDataSetChanged();
        }
    }

    public void t0(g gVar) {
        this.s = gVar;
    }

    public void u0(int i2) {
        this.F = i2;
        Iterator<o40> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().d(i2);
        }
    }

    @Override // defpackage.w8
    public void w() {
        this.J.w();
    }

    public void w0(ChatItem chatItem) {
        this.d = chatItem;
        Iterator<o40> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().k(chatItem);
        }
    }

    public void x0(i iVar) {
        this.t = iVar;
    }

    public void y0(Cursor cursor, int i2, boolean z) {
        long jB = ir5.b();
        this.m.clear();
        this.B = false;
        this.E = false;
        if (cursor != null && cursor.moveToLast()) {
            do {
                try {
                    if (h0(cursor)) {
                        this.m.add(MessageVo.buildFromCursor(cursor));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } while (cursor.moveToPrevious());
        }
        Y(z);
        this.K.e(this.m);
        this.J.k(this.m);
        lt4.d().j(this.d, this.m, this.C, getActivity() instanceof FrameworkBaseActivity ? ((FrameworkBaseActivity) getActivity()).isPaused() : false);
        long j2 = 0;
        for (int i3 = 0; i3 < this.m.size(); i3++) {
            MessageVo messageVo = this.m.get(i3);
            mi5.r(messageVo);
            String str = messageVo.mid;
            long j3 = messageVo.time;
            if (i3 == 0) {
                this.M.put(str, Boolean.TRUE);
            } else {
                Boolean bool = this.M.get(str);
                if (bool == null) {
                    boolean zD0 = d0(j2, j3);
                    if (zD0) {
                        j2 = j3;
                    }
                    this.M.put(str, Boolean.valueOf(zD0));
                } else if (!bool.booleanValue()) {
                    boolean zD02 = d0(j2, j3);
                    if (zD02) {
                        j2 = j3;
                    }
                    this.M.put(str, Boolean.valueOf(zD02));
                }
            }
            j2 = j3;
        }
        LogUtil.i(P, "set Date time " + ir5.e(jB) + " size= " + this.m.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<String, MessageVo>> it = this.p.entrySet().iterator();
        while (it.hasNext()) {
            MessageVo value = it.next().getValue();
            if (this.m != null) {
                int i4 = 0;
                while (true) {
                    if (i4 >= this.m.size()) {
                        break;
                    }
                    if (value.get_id() == this.m.get(i4).get_id()) {
                        value = this.m.get(i4);
                        break;
                    }
                    i4++;
                }
            }
            if (value.mimeType != 10001) {
                linkedHashMap.put(value.mid, value);
            }
        }
        this.p.clear();
        this.p.putAll(linkedHashMap);
        D();
        if (!ef2.g() || e20.a()) {
            this.C = false;
        } else if (this.C) {
            ArrayList<MessageVo> arrayList = this.m;
            if (arrayList != null) {
                if (arrayList.size() > 0) {
                    MessageVo messageVo2 = this.m.get(r9.size() - 1);
                    if (messageVo2 != null && messageVo2.mimeType != 33 && System.currentTimeMillis() - messageVo2.time > ef2.e()) {
                        ds0.a().b(new t20());
                    }
                } else {
                    ds0.a().b(new t20());
                }
            }
            this.C = false;
        } else {
            ArrayList<MessageVo> arrayList2 = this.m;
            if (arrayList2 != null) {
                if (arrayList2.size() > 0) {
                    MessageVo messageVo3 = this.m.get(r9.size() - 1);
                    if (messageVo3 != null && messageVo3.mimeType != 33 && System.currentTimeMillis() - messageVo3.time > ef2.e()) {
                        C(this.G);
                    }
                } else {
                    C(this.G);
                }
            }
        }
        A(i2);
        notifyDataSetChanged();
        i iVar = this.t;
        if (iVar != null) {
            iVar.a();
        }
    }

    public void z0(Cursor cursor, boolean z) {
        y0(cursor, -1, z);
    }
}
