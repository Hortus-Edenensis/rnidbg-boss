package com.zenmen.palmchat.conversations.threadsnew.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ThreadChatItem;
import com.zenmen.palmchat.circle.bean.CircleNoticeItem;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.bean.Amulet;
import com.zenmen.palmchat.conversations.threadgroup.ThreadFolderManager;
import com.zenmen.palmchat.conversations.threadsnew.adapter.ConversationAdapter;
import com.zenmen.palmchat.database.ThreadBizExtHelper;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import com.zenmen.palmchat.redpacket.data.VoucherRedPacketVo;
import com.zenmen.palmchat.utils.SAppUtil;
import com.zenmen.palmchat.widget.LXPortraitView;
import com.zenmen.palmchat.widget.RhythmView;
import defpackage.a46;
import defpackage.a65;
import defpackage.az2;
import defpackage.bo0;
import defpackage.by5;
import defpackage.fg6;
import defpackage.fu5;
import defpackage.gu2;
import defpackage.il5;
import defpackage.ir5;
import defpackage.k86;
import defpackage.me1;
import defpackage.mo5;
import defpackage.o30;
import defpackage.o90;
import defpackage.tw5;
import defpackage.v8;
import defpackage.vl1;
import defpackage.z53;
import defpackage.zg5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ConversationViewHolder extends BaseRecyclerViewHolder<ConversationAdapter.a> {
    public LXPortraitView f;
    public TextView g;
    public TextView h;
    public RhythmView i;
    public TextView j;
    public TextView k;
    public View l;
    public ImageView m;
    public TextView n;
    public LinearLayout o;
    public ImageView p;
    public ImageView q;
    public ImageView r;
    public ImageView s;
    public TextView t;
    public ImageView u;
    public View v;
    public View w;
    public TextView x;
    public Context y;
    public FrameLayout z;

    public ConversationViewHolder(Context context, ViewGroup viewGroup, int i) {
        super(context, viewGroup, i);
        this.y = context;
        this.f = (LXPortraitView) this.itemView.findViewById(R.id.icon);
        this.h = (TextView) this.itemView.findViewById(R.id.title);
        this.j = (TextView) this.itemView.findViewById(R.id.message);
        RhythmView rhythmView = (RhythmView) this.itemView.findViewById(R.id.rhy_view);
        this.i = rhythmView;
        rhythmView.setCandidate(new int[]{8, 14, 6}).setRoundRadius(2.0f).setColor(Color.parseColor("#ff463c")).setStripe(1.5f, 14.0f, 3.0f).setFreq(30L).setMinHeight(6.0f).setMaxHeight(14.0f).init();
        this.k = (TextView) this.itemView.findViewById(R.id.date);
        this.g = (TextView) this.itemView.findViewById(R.id.notification_red_dot);
        this.l = this.itemView.findViewById(R.id.notification_red_dot_nodisturb);
        this.m = (ImageView) this.itemView.findViewById(R.id.disturbIv);
        this.n = (TextView) this.itemView.findViewById(R.id.additionMessage);
        this.o = (LinearLayout) this.itemView.findViewById(R.id.message_area);
        this.p = (ImageView) this.itemView.findViewById(R.id.iv_temp_chat);
        this.r = (ImageView) this.itemView.findViewById(R.id.iv_super_greetings);
        this.s = (ImageView) this.itemView.findViewById(R.id.iv_conversation_specialattention);
        this.t = (TextView) this.itemView.findViewById(R.id.tv_official);
        this.u = (ImageView) this.itemView.findViewById(R.id.iv_vip);
        this.w = this.itemView.findViewById(R.id.lyt_title);
        this.v = this.itemView.findViewById(R.id.extraLayout);
        this.x = (TextView) this.itemView.findViewById(R.id.tv_intimacy_score);
        this.q = (ImageView) this.itemView.findViewById(R.id.iv_ai_chat);
        this.z = (FrameLayout) this.itemView.findViewById(R.id.loop_message_layout);
    }

    public final boolean q(ContactInfoItem contactInfoItem) {
        return v8.h() && v8.m && contactInfoItem != null && v8.C(contactInfoItem.getUid());
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x04ff  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0506  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0579 A[PHI: r5
      0x0579: PHI (r5v22 int) = (r5v21 int), (r5v107 int) binds: [B:171:0x0504, B:174:0x0578] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x057b  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x05f0 A[PHI: r5
      0x05f0: PHI (r5v23 int) = (r5v22 int), (r5v95 int) binds: [B:175:0x0579, B:178:0x05ef] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x066c  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x06e2  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x08f9  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x095e  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x096f  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0978  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0993  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x09ab  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x09c6  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x09da  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x09e6  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0a02  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0a46  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0a54  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0a58  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0a5d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0a60  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0a64  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0a72  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0a8e  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0ab0  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0abf  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0465 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:294:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01db  */
    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void o(ConversationAdapter.a aVar, int i) {
        boolean z;
        String str;
        int i2;
        String str2;
        String str3;
        ContactInfoItem contactInfoItemL;
        boolean z2;
        int i3;
        String str4;
        String str5;
        boolean z3;
        String str6;
        ContactInfoItem contactInfoItem;
        String str7;
        Drawable drawable;
        String str8;
        Amulet amulet;
        int i4;
        boolean z4;
        int i5;
        ContactInfoItem contactInfoItem2;
        int i6;
        ThreadBizExtHelper.BizExt bizExt;
        ThreadBizExtHelper.ThreadShowInfo threadShowInfo;
        int i7;
        int i8;
        z53.a("ConversationViewHolder", "onBindViewHolder");
        ThreadChatItem threadChatItem = aVar.f13812a;
        String str9 = threadChatItem.iconUrl;
        String str10 = threadChatItem.title;
        String str11 = threadChatItem.lastMsg;
        if (threadChatItem.isRiskThreadGroup) {
            str10 = "异常账号消息过滤";
            str11 = "对方账号可能异常，请注意保护自身信息安全";
        }
        String str12 = str11;
        String str13 = str10;
        String strC = str12;
        String str14 = threadChatItem.draft;
        String str15 = threadChatItem.relativeContact;
        int i9 = threadChatItem.lastMsgType;
        long j = threadChatItem.lastMessageDate;
        long j2 = threadChatItem.draftDate;
        if (j <= 0) {
            j = j2;
        }
        int i10 = threadChatItem.unReadCount;
        boolean z5 = threadChatItem.isNoDisturb;
        int i11 = threadChatItem.priority;
        int i12 = threadChatItem.chatType;
        int i13 = threadChatItem.messageStatus;
        boolean z6 = threadChatItem.hasRemind;
        boolean z7 = threadChatItem.hasUnreadGiftMessage;
        boolean z8 = CircleNoticeItem.getCircleThreadHasNoticeStatus(str15) != 0;
        boolean z9 = VoucherRedPacketVo.getCircleThreadHasVoucherStatus(str15) != 0;
        long j3 = j;
        boolean z10 = o90.a(str15) == 1;
        if (i9 == 10001) {
            z6 = false;
        }
        boolean z11 = threadChatItem.read;
        int i14 = threadChatItem.bizType;
        String str16 = threadChatItem.bizExtension;
        if (i9 == 1) {
            strC = il5.n(strC, 250);
        }
        this.z.setVisibility(8);
        this.z.removeAllViews();
        this.j.setVisibility(0);
        if (ThreadFolderManager.e(i14)) {
            z = z10;
            this.n.setTextColor(this.y.getResources().getColor(R.color.Gd));
            String strC2 = ThreadFolderManager.c(this.y, i9, i14, str16);
            if (TextUtils.isEmpty(strC2)) {
                this.n.setVisibility(8);
            } else {
                this.n.setVisibility(0);
                this.n.setText(strC2);
            }
        } else {
            z = z10;
            if (i14 == 14) {
                str = str16;
                i2 = i13;
                this.n.setVisibility(0);
                this.n.setTextColor(this.y.getResources().getColor(R.color.Gd));
                str2 = str15;
                this.n.setText(String.format("[%s]", this.y.getString(R.string.settings_item_fujinderen)));
            } else if (i14 != 17) {
                this.n.setVisibility(8);
            } else {
                this.n.setVisibility(0);
                str = str16;
                this.n.setTextColor(this.y.getResources().getColor(R.color.Gd));
                i2 = i13;
                this.n.setText(String.format("[%s]", this.y.getString(R.string.source_type_people_match)));
                str2 = str15;
            }
            if (i9 == 9) {
                strC = SAppUtil.b.b() ? tw5.c(this.y, strC, str13) : tw5.b(this.y, strC, str13);
            }
            String str17 = strC;
            if (i11 != 100) {
                this.itemView.setBackgroundResource(R.drawable.selector_thread_top_item_background);
            } else {
                this.itemView.setBackgroundResource(R.drawable.selector_settings_item_background);
            }
            if (i10 != 0) {
                this.l.setVisibility(8);
                this.g.setVisibility(8);
            } else if (z5) {
                this.g.setVisibility(8);
                this.l.setVisibility(0);
            } else {
                if (ThreadFolderManager.e(i14)) {
                    this.l.setVisibility(0);
                    this.g.setVisibility(8);
                } else {
                    this.l.setVisibility(8);
                    this.g.setVisibility(0);
                }
                if (i10 >= 100) {
                    this.g.setText(R.string.notification_ellipsis);
                } else {
                    this.g.setText(String.valueOf(i10));
                }
            }
            if (z5 || i14 >= 10000) {
                this.m.setVisibility(8);
            } else {
                this.m.setVisibility(0);
            }
            if (fu5.t(i14) || fu5.k(i14).saveInTempTable) {
                this.p.setVisibility(8);
                this.r.setVisibility(8);
                this.f.getPortraitView().setBorderWidth(0);
                this.f.getPortraitView().setBorderColor(0);
            } else if (1 == threadChatItem.isSuperGreetings && 10005 == com.zenmen.palmchat.conversations.threadgroup.a.c(i14)) {
                this.p.setVisibility(8);
                this.r.setVisibility(0);
                this.f.getPortraitView().setBorderWidth(me1.b(this.y, 2));
                this.f.getPortraitView().setBorderColor(Color.parseColor("#FFD784"));
            } else {
                this.p.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.p.getLayoutParams();
                if (i14 == 5003) {
                    this.p.setImageResource(R.drawable.msg_list_item_biztype_match);
                    if (layoutParams != null) {
                        layoutParams.width = a46.b(this.y, 48.0f);
                        layoutParams.height = a46.b(this.y, 16.0f);
                        this.p.setLayoutParams(layoutParams);
                    }
                } else if (i14 == 5012) {
                    this.p.setImageResource(R.drawable.msg_list_item_biztype_ylqx);
                    if (layoutParams != null) {
                        layoutParams.width = a46.b(this.y, 52.0f);
                        layoutParams.height = a46.b(this.y, 14.0f);
                        this.p.setLayoutParams(layoutParams);
                    }
                } else if (fu5.s(i14)) {
                    this.p.setImageResource(R.drawable.msg_list_item_biztype_cjbg);
                    if (layoutParams != null) {
                        layoutParams.width = a46.b(this.y, 52.0f);
                        layoutParams.height = a46.b(this.y, 14.0f);
                        this.p.setLayoutParams(layoutParams);
                    }
                } else if (i14 == 5039) {
                    this.p.setImageResource(R.drawable.msg_list_item_biztype_cjbg);
                    if (layoutParams != null) {
                        layoutParams.width = a46.b(this.y, 52.0f);
                        layoutParams.height = a46.b(this.y, 14.0f);
                        this.p.setLayoutParams(layoutParams);
                    }
                } else {
                    this.p.setImageResource(R.drawable.icon_temp_chat);
                    if (layoutParams != null) {
                        layoutParams.width = a46.b(this.y, 32.0f);
                        layoutParams.height = a46.b(this.y, 14.0f);
                        this.p.setLayoutParams(layoutParams);
                    }
                }
                this.r.setVisibility(8);
                this.f.getPortraitView().setBorderWidth(0);
                this.f.getPortraitView().setBorderColor(0);
            }
            if (i12 != 0) {
                str3 = str2;
                contactInfoItemL = bo0.r().l(str3);
            } else {
                str3 = str2;
                contactInfoItemL = null;
            }
            if (i12 == 0 || contactInfoItemL == null) {
                this.t.setVisibility(8);
                this.u.setVisibility(8);
                this.h.setTextColor(this.y.getResources().getColor(R.color.Gb));
                this.s.setVisibility(8);
                z2 = false;
            } else {
                int iG = fg6.g(contactInfoItemL.getExt());
                if (fg6.q(iG)) {
                    this.u.setImageResource(fg6.c(iG));
                    i7 = 0;
                    this.u.setVisibility(0);
                    i8 = 8;
                } else {
                    i7 = 0;
                    i8 = 8;
                    this.u.setVisibility(8);
                }
                if (contactInfoItemL.isOfficialAccount()) {
                    this.t.setVisibility(i7);
                } else {
                    this.t.setVisibility(i8);
                }
                if (contactInfoItemL.isOfficialAccount()) {
                    this.h.setTextColor(this.y.getResources().getColor(R.color.Gg));
                } else {
                    this.h.setTextColor(fg6.n(this.y, iG));
                }
                boolean zIsNewUser = contactInfoItemL.isNewUser();
                if (zg5.i(contactInfoItemL)) {
                    this.s.setVisibility(0);
                } else {
                    this.s.setVisibility(8);
                }
                z2 = zIsNewUser;
            }
            if (contactInfoItemL != null || contactInfoItemL.getIsStranger() || a65.e(contactInfoItemL) || contactInfoItemL.isSelf() || !gu2.f() || contactInfoItemL.getIntimacyScore() < gu2.a().msglist_value) {
                this.x.setVisibility(8);
            } else {
                this.x.setVisibility(0);
                this.x.setText(gu2.b(contactInfoItemL.getIntimacyScore(), true));
            }
            i3 = i2;
            int i15 = (i3 != 1 || i3 == 4 || i3 == 3) ? 60 : 0;
            if (!TextUtils.isEmpty(str) || (bizExt = (ThreadBizExtHelper.BizExt) az2.a(str, ThreadBizExtHelper.BizExt.class)) == null || (threadShowInfo = bizExt.threadShowInfo) == null) {
                str4 = null;
                str5 = null;
            } else {
                str5 = threadShowInfo.content;
                str4 = threadShowInfo.color;
            }
            int color = Color.parseColor("#999999");
            if (!TextUtils.isEmpty(str4)) {
                try {
                    color = Color.parseColor(str4);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            int i16 = color;
            if (!TextUtils.isEmpty(str5)) {
                str17 = str5;
            }
            this.j.setTextColor(i16);
            if (i12 == 1 || !z8) {
                z3 = z2;
                str6 = str3;
                int i17 = 1;
                if (i12 != 1) {
                    if (i12 != i17) {
                        if (i12 != i17 && z) {
                            this.n.setVisibility(0);
                            this.n.setTextColor(this.y.getResources().getColor(R.color.draft_color));
                            this.n.setText(R.string.greetings_group_title_tip);
                            this.j.setText(il5.e(vl1.c(str17, this.y, vl1.d), AppContext.getContext().getResources().getDimension(R.dimen.conversation_text_size_main_text), ((k86.z(this.y) - k86.e(this.y, 124.0f)) - (((int) il5.k(this.y, this.n.getText().toString(), k86.e(this.y, 14.0f))) + k86.e(this.y, 4.0f))) - i15));
                        } else if (TextUtils.isEmpty(str14)) {
                            this.n.setVisibility(0);
                            this.n.setTextColor(this.y.getResources().getColor(R.color.draft_color));
                            this.n.setText(R.string.thread_draft);
                            str7 = str14;
                            contactInfoItem = contactInfoItemL;
                            this.j.setText(il5.e(vl1.c(str7, this.y, vl1.d), AppContext.getContext().getResources().getDimension(R.dimen.conversation_text_size_main_text), ((k86.z(this.y) - k86.e(this.y, 124.0f)) - (((int) il5.k(this.y, this.n.getText().toString(), k86.e(this.y, 14.0f))) + k86.e(this.y, 4.0f))) - i15));
                        } else {
                            contactInfoItem = contactInfoItemL;
                            str7 = str14;
                            if (i12 == 1 && z5 && i10 > 1) {
                                this.n.setVisibility(0);
                                this.n.setTextColor(this.y.getResources().getColor(R.color.Gd));
                                this.n.setText(this.y.getString(R.string.thread_nodisturb_unread_count, Integer.valueOf(i10)));
                                this.j.setText(il5.e(vl1.c(str17, this.y, vl1.d), AppContext.getContext().getResources().getDimension(R.dimen.conversation_text_size_main_text), ((k86.z(this.y) - k86.e(this.y, 124.0f)) - (((int) il5.k(this.y, this.n.getText().toString(), k86.e(this.y, 14.0f))) + k86.e(this.y, 4.0f))) - i15));
                            } else if (i9 == 3 && !z11) {
                                SpannableString spannableString = new SpannableString(str17);
                                int iLastIndexOf = str17.lastIndexOf(":");
                                spannableString.setSpan(new ForegroundColorSpan(this.y.getResources().getColor(R.color.draft_color)), iLastIndexOf < 0 ? 0 : iLastIndexOf + 1, str17.length(), 33);
                                this.j.setText(spannableString);
                            } else if (z7) {
                                if (str17 != null && str17.contains("挂件")) {
                                    this.n.setVisibility(8);
                                    this.j.setTextColor(this.y.getResources().getColor(R.color.draft_color));
                                    this.j.setText(il5.e(vl1.c(str17, this.y, vl1.d), AppContext.getContext().getResources().getDimension(R.dimen.conversation_text_size_main_text), ((k86.z(this.y) - k86.e(this.y, 124.0f)) - (((int) il5.k(this.y, this.n.getText().toString(), k86.e(this.y, 14.0f))) + k86.e(this.y, 4.0f))) - i15));
                                } else {
                                    this.n.setVisibility(0);
                                    this.n.setTextColor(this.y.getResources().getColor(R.color.draft_color));
                                    this.n.setText(R.string.thread_unread_gift);
                                    this.j.setText(il5.e(vl1.c(str17, this.y, vl1.d), AppContext.getContext().getResources().getDimension(R.dimen.conversation_text_size_main_text), ((k86.z(this.y) - k86.e(this.y, 124.0f)) - (((int) il5.k(this.y, this.n.getText().toString(), k86.e(this.y, 14.0f))) + k86.e(this.y, 4.0f))) - i15));
                                }
                            } else {
                                this.j.setText(il5.e(vl1.c(str17, this.y, vl1.d), AppContext.getContext().getResources().getDimension(R.dimen.conversation_text_size_main_text), ((k86.z(this.y) - k86.e(this.y, 124.0f)) - (this.n.getVisibility() == 0 ? ((int) il5.k(this.y, this.n.getText().toString(), k86.e(this.y, 14.0f))) + k86.e(this.y, 4.0f) : 0)) - i15));
                            }
                        }
                    } else if (z6) {
                        this.n.setVisibility(0);
                        this.n.setTextColor(this.y.getResources().getColor(R.color.draft_color));
                        this.n.setText(R.string.remind_notification);
                        this.j.setText(il5.e(vl1.c(str17, this.y, vl1.d), AppContext.getContext().getResources().getDimension(R.dimen.conversation_text_size_main_text), ((k86.z(this.y) - k86.e(this.y, 124.0f)) - (((int) il5.k(this.y, this.n.getText().toString(), k86.e(this.y, 14.0f))) + k86.e(this.y, 4.0f))) - i15));
                    } else {
                        i17 = 1;
                        if (i12 != i17) {
                        }
                        if (TextUtils.isEmpty(str14)) {
                        }
                    }
                } else if (z9) {
                    this.n.setVisibility(0);
                    this.n.setTextColor(this.y.getResources().getColor(R.color.draft_color));
                    this.n.setText("[券红包]");
                    this.j.setText(il5.e(vl1.c(str17, this.y, vl1.d), AppContext.getContext().getResources().getDimension(R.dimen.conversation_text_size_main_text), ((k86.z(this.y) - k86.e(this.y, 124.0f)) - (((int) il5.k(this.y, this.n.getText().toString(), k86.e(this.y, 14.0f))) + k86.e(this.y, 4.0f))) - i15));
                } else {
                    i17 = 1;
                    if (i12 != i17) {
                    }
                }
                this.i.setVisibility(8);
                if (i3 == 1 || i3 == 4) {
                    this.k.setText(R.string.list_time_loading);
                    drawable = this.y.getResources().getDrawable(R.drawable.icon_thread_message_status_pending);
                } else if (i3 == 3) {
                    drawable = this.y.getResources().getDrawable(R.drawable.icon_thread_message_status_fail);
                    if (j3 > 0) {
                        this.k.setText(by5.e(j3, this.y));
                        this.k.setVisibility(0);
                    } else {
                        this.k.setVisibility(8);
                    }
                } else if (i9 != 37) {
                    i6 = 0;
                    if (j3 > 0) {
                        this.k.setText(by5.e(j3, this.y));
                        this.k.setVisibility(i6);
                    } else {
                        this.k.setVisibility(8);
                    }
                    drawable = null;
                } else {
                    if (ir5.c(true) - j3 > 21600000) {
                        this.i.setVisibility(8);
                        i6 = 0;
                        if (j3 > 0) {
                        }
                        drawable = null;
                    } else {
                        i6 = 0;
                        this.i.setVisibility(0);
                        if (j3 > 0) {
                        }
                        drawable = null;
                    }
                }
                if (TextUtils.isEmpty(str7)) {
                    this.j.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.j.setCompoundDrawablePadding(me1.b(this.y, 4));
                    this.n.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.n.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.n.setCompoundDrawablePadding(me1.b(this.y, 4));
                    this.j.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (i14 == 10001) {
                    this.h.setText(R.string.greetings_group_title);
                } else if (i14 != 10005) {
                    this.h.setText(str13);
                } else {
                    this.h.setText(mo5.a());
                }
                if (threadChatItem.isRiskThreadGroup) {
                    a46.w("", R.drawable.ic_risk_thread_group, new DrawableImageViewTarget(this.f.getPortraitView()), Priority.NORMAL);
                    this.f.setDecor(null);
                } else if (10001 == i14) {
                    this.f.getPortraitView().setImageResource(R.drawable.ic_greetings);
                    this.f.setDecor(null);
                } else if (10005 == i14) {
                    this.f.getPortraitView().setImageResource(R.drawable.ic_square_nearby_group);
                    this.f.setDecor(null);
                } else {
                    LXPortraitView lXPortraitView = this.f;
                    if (contactInfoItem != null) {
                        amulet = contactInfoItem.getAmulet();
                        str8 = str9;
                    } else {
                        str8 = str9;
                        amulet = null;
                    }
                    lXPortraitView.setAvatarView(str8, amulet);
                }
                if (a65.f(str6)) {
                    this.j.setText(a65.b(str17));
                }
                if (threadChatItem.groupExtType == 2) {
                    i4 = 1;
                    z4 = true;
                } else {
                    i4 = 1;
                    z4 = false;
                }
                if (i12 != i4 || !z4) {
                    i4 = 0;
                }
                if (z3) {
                    this.f.setLabelText("新人", -1, R.drawable.bg_green_btn_8);
                } else {
                    if (i4 == 0) {
                        i5 = 0;
                        this.f.setLabelText(null, 0, 0);
                        contactInfoItem2 = contactInfoItem;
                        if (q(contactInfoItem2)) {
                            this.q.setVisibility(8);
                        } else {
                            this.q.setVisibility(i5);
                            Glide.with(m()).load2(v8.s).error(R.drawable.ai_chat_msg_aitag).into(this.q);
                        }
                        if (o30.q(threadChatItem.relativeContact)) {
                            return;
                        }
                        this.p.setVisibility(0);
                        this.p.setImageResource(R.drawable.chat_mate_logo_icon_bg);
                        ViewGroup.LayoutParams layoutParams2 = this.p.getLayoutParams();
                        if (layoutParams2 != null) {
                            layoutParams2.width = a46.b(this.y, 52.0f);
                            layoutParams2.height = a46.b(this.y, 14.0f);
                            this.p.setLayoutParams(layoutParams2);
                            return;
                        }
                        return;
                    }
                    this.f.setLabelText("家族", -1, R.drawable.shape_thread_family_group_tag);
                }
                contactInfoItem2 = contactInfoItem;
                i5 = 0;
                if (q(contactInfoItem2)) {
                }
                if (o30.q(threadChatItem.relativeContact)) {
                }
            } else {
                this.n.setVisibility(0);
                this.n.setTextColor(this.y.getResources().getColor(R.color.draft_color));
                this.n.setText("[群公告]");
                z3 = z2;
                str6 = str3;
                this.j.setText(il5.e(vl1.c(str17, this.y, vl1.d), AppContext.getContext().getResources().getDimension(R.dimen.conversation_text_size_main_text), ((k86.z(this.y) - k86.e(this.y, 124.0f)) - (((int) il5.k(this.y, this.n.getText().toString(), k86.e(this.y, 14.0f))) + k86.e(this.y, 4.0f))) - i15));
            }
            contactInfoItem = contactInfoItemL;
            str7 = str14;
            this.i.setVisibility(8);
            if (i3 == 1) {
                this.k.setText(R.string.list_time_loading);
                drawable = this.y.getResources().getDrawable(R.drawable.icon_thread_message_status_pending);
            }
            if (TextUtils.isEmpty(str7)) {
            }
            if (i14 == 10001) {
            }
            if (threadChatItem.isRiskThreadGroup) {
            }
            if (a65.f(str6)) {
            }
            if (threadChatItem.groupExtType == 2) {
            }
            if (i12 != i4) {
                i4 = 0;
            }
            if (z3) {
            }
            contactInfoItem2 = contactInfoItem;
            i5 = 0;
            if (q(contactInfoItem2)) {
            }
            if (o30.q(threadChatItem.relativeContact)) {
            }
        }
        str2 = str15;
        str = str16;
        i2 = i13;
        if (i9 == 9) {
        }
        String str172 = strC;
        if (i11 != 100) {
        }
        if (i10 != 0) {
        }
        if (z5) {
            this.m.setVisibility(8);
        }
        if (fu5.t(i14)) {
            this.p.setVisibility(8);
            this.r.setVisibility(8);
            this.f.getPortraitView().setBorderWidth(0);
            this.f.getPortraitView().setBorderColor(0);
        }
        if (i12 != 0) {
        }
        if (i12 == 0) {
            this.t.setVisibility(8);
            this.u.setVisibility(8);
            this.h.setTextColor(this.y.getResources().getColor(R.color.Gb));
            this.s.setVisibility(8);
            z2 = false;
        }
        if (contactInfoItemL != null) {
            this.x.setVisibility(8);
        } else {
            this.x.setVisibility(8);
        }
        i3 = i2;
        if (i3 != 1) {
        }
        if (TextUtils.isEmpty(str)) {
            str4 = null;
            str5 = null;
        }
        int color2 = Color.parseColor("#999999");
        if (!TextUtils.isEmpty(str4)) {
        }
        int i162 = color2;
        if (!TextUtils.isEmpty(str5)) {
        }
        this.j.setTextColor(i162);
        if (i12 == 1) {
            z3 = z2;
            str6 = str3;
            int i172 = 1;
            if (i12 != 1) {
            }
        }
        this.i.setVisibility(8);
        if (i3 == 1) {
        }
        if (TextUtils.isEmpty(str7)) {
        }
        if (i14 == 10001) {
        }
        if (threadChatItem.isRiskThreadGroup) {
        }
        if (a65.f(str6)) {
        }
        if (threadChatItem.groupExtType == 2) {
        }
        if (i12 != i4) {
        }
        if (z3) {
        }
        contactInfoItem2 = contactInfoItem;
        i5 = 0;
        if (q(contactInfoItem2)) {
        }
        if (o30.q(threadChatItem.relativeContact)) {
        }
    }
}
