package com.zenmen.palmchat.conversations.threadsnew.newfriend;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.PhoneContactItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.ContactRequestsVO;
import com.zenmen.palmchat.contacts.NewContactRequestSendActivityV2;
import com.zenmen.palmchat.contacts.RecommendRequestSendActivity;
import com.zenmen.palmchat.contacts.UserDetailActivity;
import com.zenmen.palmchat.contacts.b;
import com.zenmen.palmchat.conversations.threadsnew.newfriend.NewFriendAdapter;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.LXPortraitView;
import defpackage.ap3;
import defpackage.bj5;
import defpackage.bo0;
import defpackage.fg6;
import defpackage.hs1;
import defpackage.i55;
import defpackage.jo6;
import defpackage.k86;
import defpackage.l50;
import defpackage.px3;
import defpackage.ro2;
import defpackage.ry5;
import defpackage.v8;
import defpackage.z53;
import defpackage.z66;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class NewFriendViewHolder2 extends BaseRecyclerViewHolder<NewFriendAdapter.a> {
    public Context f;
    public LXPortraitView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public ImageView m;
    public TextView n;
    public View o;
    public View p;
    public View q;
    public b.k r;
    public HashMap<String, PhoneContactItem> s;
    public NewFriendFragment t;
    public ImageListsView u;
    public ImageView v;
    public View w;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f13862a;
        public final /* synthetic */ ContactRequestsVO b;
        public final /* synthetic */ ContactInfoItem c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public a(boolean z, ContactRequestsVO contactRequestsVO, ContactInfoItem contactInfoItem, int i, String str, String str2, String str3) {
            this.f13862a = z;
            this.b = contactRequestsVO;
            this.c = contactInfoItem;
            this.d = i;
            this.e = str;
            this.f = str2;
            this.g = str3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PhoneContactItem phoneContactItem;
            if (this.f13862a) {
                return;
            }
            px3.d(this.b.fromUid, 1);
            if (((TextView) view).getText().equals("聊聊")) {
                NewFriendViewHolder2.this.t.E0(this.b);
                return;
            }
            int sourceType = this.c.getSourceType() == 4 ? 14 : this.d == 101 ? 3 : this.c.getSourceType();
            int i = this.d;
            if (i < 100) {
                NewFriendViewHolder2 newFriendViewHolder2 = NewFriendViewHolder2.this;
                String str = this.e;
                String str2 = this.f;
                String str3 = this.g;
                ContactInfoItem contactInfoItem = this.c;
                ContactRequestsVO contactRequestsVO = this.b;
                newFriendViewHolder2.x(i, str, str2, str3, contactInfoItem, sourceType, contactRequestsVO.realName, contactRequestsVO);
                return;
            }
            if (jo6.r()) {
                Intent intent = new Intent(NewFriendViewHolder2.this.f, (Class<?>) RecommendRequestSendActivity.class);
                intent.putExtra("uid_key", this.f);
                intent.putExtra("user_item_info_key", this.c);
                intent.putExtra("source_type_key", sourceType);
                intent.putExtra("real_name", this.b.realName);
                intent.putExtra("send_from_type", 4);
                intent.putExtra("subtype_key", NewFriendViewHolder2.this.r.f13564a);
                NewFriendViewHolder2.this.f.startActivity(intent);
                return;
            }
            if (!jo6.t()) {
                NewFriendViewHolder2.this.y(this.f, false, this.c, sourceType, this.b);
                return;
            }
            Intent intent2 = new Intent(NewFriendViewHolder2.this.f, (Class<?>) NewContactRequestSendActivityV2.class);
            intent2.putExtra("user_item_info", this.c);
            intent2.putExtra("uid_key", this.f);
            intent2.putExtra("new_contact_source_type", sourceType);
            intent2.putExtra("send_from_type", 4);
            if (TextUtils.isEmpty(this.c.getMobile())) {
                String str4 = this.b.identifyCode;
                if (!TextUtils.isEmpty(str4) && (phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(str4)) != null) {
                    intent2.putExtra("new_contact_local_phone_number", phoneContactItem.y());
                }
            } else {
                intent2.putExtra("new_contact_local_phone_number", this.c.getMobile());
            }
            intent2.putExtra("extra_request_type", this.c.getRequestType());
            intent2.putExtra("subtype_key", NewFriendViewHolder2.this.r.f13564a);
            intent2.putExtra("extra_request_from", 21);
            NewFriendViewHolder2.this.f.startActivity(intent2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f13863a;
        public final /* synthetic */ ContactRequestsVO b;

        public b(boolean z, ContactRequestsVO contactRequestsVO) {
            this.f13863a = z;
            this.b = contactRequestsVO;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ContactRequestsVO contactRequestsVO;
            if (this.f13863a || (contactRequestsVO = this.b) == null) {
                return;
            }
            UserDetailActivity.U2(NewFriendViewHolder2.this.t.getActivity(), contactRequestsVO.type, contactRequestsVO.identifyCode, contactRequestsVO.requestRid, this.b.convert2ContactInfoItem(), 21, contactRequestsVO.applyTime, contactRequestsVO.applyExpireSec, this.b.realName, 0);
            ContactRequestsVO contactRequestsVO2 = this.b;
            i55.c(contactRequestsVO2.fromUid, contactRequestsVO2.userInfo);
            px3.d(this.b.fromUid, 1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13864a;
        public final /* synthetic */ boolean b;

        public c(String str, boolean z) {
            this.f13864a = str;
            this.b = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            LogUtil.d("AiChatPeopleManagerTag", "aiBtnView click uid " + this.f13864a + " isFriend " + this.b);
            NewFriendViewHolder2.this.D(this.f13864a, this.b);
            v8.o(this.f13864a, 2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13865a;
        public final /* synthetic */ int b;

        public d(String str, int i) {
            this.f13865a = str;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            NewFriendViewHolder2.this.E(this.f13865a, this.b);
            v8.o(this.f13865a, 1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements ro2.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f13866a;
        public final /* synthetic */ String b;

        public e(boolean z, String str) {
            this.f13866a = z;
            this.b = str;
        }

        @Override // ro2.b
        public void a(ContactInfoItem contactInfoItem) {
            FragmentActivity activity = NewFriendViewHolder2.this.t.getActivity();
            if (activity != null) {
                if (this.f13866a) {
                    contactInfoItem.setBizType(0);
                    Intent intent = new Intent(AppContext.getContext(), (Class<?>) ChatterActivity.class);
                    intent.putExtra("chat_item", contactInfoItem);
                    intent.putExtra("thread_biz_type", contactInfoItem.getBizType());
                    intent.putExtra("chat_need_back_to_main", false);
                    intent.putExtra("chat_back_to_greet", false);
                    k86.X(intent);
                    activity.startActivity(intent);
                    return;
                }
                contactInfoItem.setUid(this.b);
                contactInfoItem.setSourceType(60);
                int i = (NewFriendViewHolder2.this.t == null || !"newFriend_notEmpty".equals(NewFriendViewHolder2.this.t.r0())) ? 5063 : 5064;
                LogUtil.d("", "AIP 新朋友启动聊天 aiBizType " + i);
                contactInfoItem.setBizType(i);
                ap3.j(activity, contactInfoItem, i);
            }
        }

        @Override // ro2.b
        public void onError(String str) {
            if (TextUtils.isEmpty(str)) {
                str = "获取用户信息失败";
            }
            ry5.a(str);
        }
    }

    public NewFriendViewHolder2(Context context, NewFriendFragment newFriendFragment, HashMap<String, PhoneContactItem> map, ViewGroup viewGroup, int i, b.k kVar) {
        super(context, viewGroup, i);
        this.f = context;
        this.t = newFriendFragment;
        this.r = kVar;
        this.s = map;
        this.g = (LXPortraitView) this.itemView.findViewById(R.id.portrait);
        this.h = (TextView) this.itemView.findViewById(R.id.friend_name);
        this.j = (TextView) this.itemView.findViewById(R.id.friend_profile);
        this.i = (TextView) this.itemView.findViewById(R.id.friend_info);
        this.k = (TextView) this.itemView.findViewById(R.id.confirm_button);
        this.l = (TextView) this.itemView.findViewById(R.id.profile_button);
        this.n = (TextView) this.itemView.findViewById(R.id.tv_official);
        this.m = (ImageView) this.itemView.findViewById(R.id.iv_vip);
        this.u = (ImageListsView) this.itemView.findViewById(R.id.image_list);
        this.v = (ImageView) this.itemView.findViewById(R.id.iv_feed_sex);
        this.w = this.itemView.findViewById(R.id.red_dot);
        this.o = this.itemView.findViewById(R.id.btn_say_hi_ai);
        this.p = this.itemView.findViewById(R.id.profile_uid_normal);
        this.q = this.itemView.findViewById(R.id.background);
    }

    public final String A(String str, String str2) {
        ContactInfoItem contactInfoItemL = bo0.r().l(str);
        return contactInfoItemL != null ? contactInfoItemL.getNickName() : str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02b5  */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [boolean, int] */
    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void o(NewFriendAdapter.a aVar, int i) {
        String str;
        boolean z;
        int i2;
        ?? r2;
        boolean z2;
        String string;
        int i3;
        List<String> listC;
        int i4;
        boolean z3;
        z53.a("ConversationViewHolder", "onBindViewHolder");
        ContactRequestsVO contactRequestsVO = aVar.f13833a;
        ContactInfoItem contactInfoItemBuildFromJson = ContactInfoItem.buildFromJson(contactRequestsVO.userInfo);
        String strA = A(contactRequestsVO.fromUid, contactRequestsVO.fromNickName);
        String str2 = contactRequestsVO.requestInfo;
        String strZ = z(contactRequestsVO.fromUid, contactRequestsVO.fromHeadIcon);
        long j = contactRequestsVO.acceptStatus;
        long j2 = contactRequestsVO.readStatus;
        String str3 = contactRequestsVO.requestRid;
        int i5 = contactRequestsVO.type;
        String str4 = contactRequestsVO.fromUid;
        String str5 = contactRequestsVO.identifyCode;
        ContactInfoItem contactInfoItemConvert2ContactInfoItem = contactRequestsVO.convert2ContactInfoItem();
        boolean z4 = v8.C(str4) && contactRequestsVO.aiShowUi == 1;
        if (TextUtils.isEmpty(strZ)) {
            this.g.getPortraitView().setImageResource(R.drawable.default_portrait);
            str = str5;
        } else {
            str = str5;
            this.g.setAvatarView(strZ, contactInfoItemConvert2ContactInfoItem.getAmulet());
        }
        boolean zW = bo0.r().w(str4);
        if (contactInfoItemBuildFromJson != null) {
            int gender = contactInfoItemBuildFromJson.getGender();
            z = zW;
            this.v.setVisibility(0);
            if (gender == 1) {
                this.v.setImageResource(R.drawable.icon_sex_female);
            } else if (gender == 0) {
                this.v.setImageResource(R.drawable.icon_sex_male);
            } else {
                this.v.setVisibility(8);
                i2 = gender;
            }
            i2 = gender;
        } else {
            z = zW;
            this.v.setVisibility(8);
            i2 = 0;
        }
        String localOrRealName = contactRequestsVO.getLocalOrRealName(this.s);
        if (!TextUtils.isEmpty(localOrRealName)) {
            strA = strA + " (" + localOrRealName + ")";
        }
        this.h.setText(strA);
        C(this.j, contactInfoItemBuildFromJson);
        int i6 = i2;
        boolean z5 = z4;
        boolean z6 = z;
        this.k.setOnClickListener(new a(z4, contactRequestsVO, contactInfoItemConvert2ContactInfoItem, i5, str3, str4, str));
        this.l.setOnClickListener(new b(z5, contactRequestsVO));
        if (!z6) {
            r2 = 0;
            z3 = false;
            z3 = false;
            z3 = false;
            r2 = 0;
            r2 = 0;
            if (i5 < 100) {
                if (ContactRequestsVO.isSenderParseFromRid(str3) || TextUtils.isEmpty(str3)) {
                    this.l.setVisibility(8);
                    this.k.setText("聊聊");
                    this.k.setVisibility(0);
                    string = "已发出好友申请";
                } else {
                    string = TextUtils.isEmpty(str2) ? "好想和你聊聊天" : str2;
                    this.l.setVisibility(0);
                    this.k.setText("接受");
                    this.k.setVisibility(0);
                }
            } else if (j == 2) {
                this.l.setVisibility(8);
                this.k.setText("聊聊");
                this.k.setVisibility(0);
                string = "已发出好友申请";
            } else {
                this.l.setVisibility(8);
                this.k.setText("添加");
                this.k.setVisibility(0);
                if (i5 >= 200 || i5 < 100) {
                    z2 = true;
                    string = i5 == 220 ? this.f.getString(R.string.contact_others_phone) : contactRequestsVO.recommendText;
                } else if (TextUtils.isEmpty(localOrRealName)) {
                    string = this.f.getString(R.string.add_contact_item_link);
                } else {
                    z2 = true;
                    string = this.f.getString(R.string.contact_phone_nick_name, localOrRealName);
                }
            }
            if (z5) {
                this.i.setText(string);
            } else {
                this.i.setText("可能想认识TA");
                v8.p(str4, r2);
            }
            if (z6 && j2 == 0 && i5 < 100) {
                this.w.setVisibility(r2);
                i3 = 8;
            } else {
                i3 = 8;
                this.w.setVisibility(8);
            }
            if (this.w.getVisibility() == 0) {
                if (z5) {
                    this.w.setVisibility(i3);
                } else {
                    this.w.setVisibility(r2);
                }
            }
            if (this.n != null) {
                if (contactInfoItemConvert2ContactInfoItem == null || !contactInfoItemConvert2ContactInfoItem.isOfficialAccount()) {
                    this.n.setVisibility(8);
                } else {
                    this.n.setVisibility(r2);
                }
            }
            int iG = fg6.g(contactInfoItemConvert2ContactInfoItem.getExt());
            if (this.m != null) {
                if (fg6.q(iG)) {
                    this.m.setVisibility(r2);
                    this.m.setImageResource(fg6.c(iG));
                } else {
                    this.m.setVisibility(8);
                }
            }
            if (contactInfoItemConvert2ContactInfoItem.isOfficialAccount()) {
                this.h.setTextColor(fg6.n(this.f, iG));
            } else {
                this.h.setTextColor(this.f.getResources().getColor(R.color.Gg));
            }
            if (z6 && (listC = px3.c(contactRequestsVO.userInfo)) != null && listC.size() > 0) {
                this.u.setVisibility(r2);
                this.u.setFeedThumbnail(listC);
                i4 = 8;
            } else {
                i4 = 8;
                this.u.setVisibility(8);
            }
            if (z5) {
                this.o.setVisibility(i4);
                this.p.setVisibility(r2);
            } else {
                this.o.setVisibility(r2);
                this.p.setVisibility(i4);
                this.o.setOnClickListener(new c(str4, z6));
            }
            if (z5) {
                this.q.setOnClickListener(null);
                this.q.setClickable(r2);
                return;
            } else {
                this.q.setClickable(z2);
                this.q.setOnClickListener(new d(str4, i6));
                return;
            }
        }
        this.l.setVisibility(8);
        this.k.setText("聊聊");
        z3 = false;
        this.k.setVisibility(0);
        string = "我们已经是好友啦";
        z2 = true;
        r2 = z3;
        if (z5) {
        }
        if (z6) {
            i3 = 8;
            this.w.setVisibility(8);
        }
        if (this.w.getVisibility() == 0) {
        }
        if (this.n != null) {
        }
        int iG2 = fg6.g(contactInfoItemConvert2ContactInfoItem.getExt());
        if (this.m != null) {
        }
        if (contactInfoItemConvert2ContactInfoItem.isOfficialAccount()) {
        }
        if (z6) {
            i4 = 8;
            this.u.setVisibility(8);
        } else {
            this.u.setVisibility(r2);
            this.u.setFeedThumbnail(listC);
            i4 = 8;
        }
        if (z5) {
        }
        if (z5) {
        }
    }

    public final void C(TextView textView, ContactInfoItem contactInfoItem) {
        StringBuilder sb = new StringBuilder();
        if (contactInfoItem != null) {
            if (!TextUtils.isEmpty(contactInfoItem.getAge()) && !"0".equals(contactInfoItem.getAge())) {
                sb.append(contactInfoItem.getAge());
                sb.append("岁");
            }
            if (!TextUtils.isEmpty(contactInfoItem.getCityName())) {
                if (sb.length() > 0) {
                    sb.append(" · ");
                }
                sb.append(contactInfoItem.getCityName());
            }
            if (contactInfoItem.getOccupation() > 0) {
                String strH = hs1.e().h(contactInfoItem.getOccupation());
                if (!TextUtils.isEmpty(strH) && !"请选择职业".equals(strH)) {
                    if (sb.length() > 0) {
                        sb.append(" · ");
                    }
                    sb.append(strH);
                }
            }
        }
        String string = sb.toString();
        if (TextUtils.isEmpty(string)) {
            string = "未知";
        }
        textView.setText(string);
    }

    public final void D(String str, boolean z) {
        bj5.b().a().J(str, new e(z, str));
    }

    public final void E(String str, int i) {
        NewFriendFragment newFriendFragment = this.t;
        int i2 = (newFriendFragment == null || !"newFriend_notEmpty".equals(newFriendFragment.r0())) ? 5063 : 5064;
        LogUtil.d("", "AIP 新朋友启动个人页 aiBizType " + i2);
        z66.f(str, null, i, 60, i2, 105, this.f);
    }

    public final void x(int i, String str, String str2, String str3, ContactInfoItem contactInfoItem, int i2, String str4, ContactRequestsVO contactRequestsVO) {
        this.t.m0(i, str, str2, str3, contactInfoItem, i2, str4, contactRequestsVO);
    }

    public final void y(String str, boolean z, ContactInfoItem contactInfoItem, int i, ContactRequestsVO contactRequestsVO) {
        this.t.n0(str, z, contactInfoItem, i, contactRequestsVO);
    }

    public final String z(String str, String str2) {
        ContactInfoItem contactInfoItemL = bo0.r().l(str);
        return contactInfoItemL != null ? contactInfoItemL.getIconURL() : str2;
    }
}
