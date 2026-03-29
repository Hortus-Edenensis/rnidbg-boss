package com.zenmen.palmchat.conversations;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cursoradapter.widget.CursorAdapter;
import com.bumptech.glide.Glide;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bean.CircleNoticeItem;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.bean.Amulet;
import com.zenmen.palmchat.database.ThreadBizExtHelper;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.redpacket.data.VoucherRedPacketVo;
import com.zenmen.palmchat.utils.SAppUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a65;
import defpackage.az2;
import defpackage.bo0;
import defpackage.by5;
import defpackage.fg6;
import defpackage.fu5;
import defpackage.il5;
import defpackage.ir5;
import defpackage.k86;
import defpackage.me1;
import defpackage.o90;
import defpackage.rw5;
import defpackage.tw5;
import defpackage.v8;
import defpackage.vl1;
import defpackage.zg5;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ThreadsAdapter extends CursorAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LayoutInflater f13746a;
    public List<String> b;
    public int c;

    public ThreadsAdapter(Context context) {
        super(context, (Cursor) null, 2);
        this.c = 0;
        this.f13746a = LayoutInflater.from(context);
        this.b = new ArrayList();
    }

    public final boolean a(ContactInfoItem contactInfoItem) {
        return v8.h() && v8.m && contactInfoItem != null && v8.C(contactInfoItem.getUid());
    }

    public final void b(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        String string = cursor.getString(cursor.getColumnIndex("thread_message_mid"));
        if (TextUtils.isEmpty(string) || this.b.contains(string)) {
            return;
        }
        String strS = DomainHelper.s(cursor.getString(cursor.getColumnIndex("contact_relate")));
        ThreadBizExtHelper.BizExt bizExtC = c(cursor.getInt(cursor.getColumnIndex("thread_biz_type")), cursor.getInt(cursor.getColumnIndex("latest_message_mime_type")), strS, cursor.getString(cursor.getColumnIndex("thread_biz_extension")));
        if (bizExtC == null || bizExtC.getRichMessage() == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mid", string);
            jSONObject.put("showType", bizExtC.getRichMessage().getShowType());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("M122", null, null, jSONObject.toString());
        this.b.add(string);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02fe A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0398 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03f7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0505 A[PHI: r5
      0x0505: PHI (r5v13 int) = (r5v12 int), (r5v51 int) binds: [B:159:0x0484, B:165:0x0504] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0507  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x057c A[PHI: r5
      0x057c: PHI (r5v14 int) = (r5v13 int), (r5v39 int) binds: [B:166:0x0505, B:169:0x057b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x05f2  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x05f8  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x066c  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0798  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x07fb  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x080a  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0813  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x082e  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0846  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0861  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0867  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0871  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x087e  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0893  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x08a4  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x08c5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02d5  */
    @Override // androidx.cursoradapter.widget.CursorAdapter
    @SuppressLint({"RestrictedApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bindView(View view, Context context, Cursor cursor) {
        String str;
        String str2;
        int i;
        int i2;
        int i3;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        ContactInfoItem contactInfoItem;
        Drawable drawable;
        Amulet amulet;
        int i4;
        ThreadBizExtHelper.BizExt bizExt;
        ThreadBizExtHelper.ThreadShowInfo threadShowInfo;
        int i5;
        int i6;
        String string;
        String strOptString;
        rw5 rw5Var = (rw5) view.getTag();
        String string2 = cursor.getString(cursor.getColumnIndex("icon_url"));
        String string3 = cursor.getString(cursor.getColumnIndex("title"));
        String string4 = cursor.getString(cursor.getColumnIndex("latest_message"));
        String string5 = cursor.getString(cursor.getColumnIndex("thread_draft"));
        String strS = DomainHelper.s(cursor.getString(cursor.getColumnIndex("contact_relate")));
        int i7 = cursor.getInt(cursor.getColumnIndex("latest_message_mime_type"));
        long j = cursor.getLong(cursor.getColumnIndex("latest_message_time_stamp"));
        long j2 = cursor.getLong(cursor.getColumnIndex("thread_draft_time"));
        if (j <= 0) {
            j = j2;
        }
        int i8 = cursor.getInt(cursor.getColumnIndex("unread_message_count"));
        boolean z = cursor.getInt(cursor.getColumnIndex("thread_nodisturb")) == 1;
        int i9 = cursor.getInt(cursor.getColumnIndex("thread_priority"));
        int i10 = cursor.getInt(cursor.getColumnIndex("chat_type"));
        long j3 = j;
        int i11 = cursor.getInt(cursor.getColumnIndex("thread_message_status"));
        boolean z2 = cursor.getInt(cursor.getColumnIndex("thread_has_remind")) != 0;
        int circleThreadHasNoticeStatus = CircleNoticeItem.getCircleThreadHasNoticeStatus(strS);
        int circleThreadHasVoucherStatus = VoucherRedPacketVo.getCircleThreadHasVoucherStatus(strS);
        boolean z3 = circleThreadHasNoticeStatus != 0;
        boolean z4 = circleThreadHasVoucherStatus != 0;
        boolean z5 = o90.a(strS) == 1;
        if (i7 == 10001) {
            z2 = false;
        }
        boolean z6 = z5;
        boolean z7 = cursor.getInt(cursor.getColumnIndex("latest_message_read")) == 1;
        int i12 = cursor.getInt(cursor.getColumnIndex("thread_biz_type"));
        String string6 = cursor.getString(cursor.getColumnIndex("thread_biz_extension"));
        if (i7 == 1) {
            string4 = il5.n(string4, 250);
        }
        if (i12 == 14) {
            str = strS;
            str2 = string6;
            i = i12;
            rw5Var.i.setVisibility(0);
            rw5Var.i.setTextColor(this.mContext.getResources().getColor(R.color.text_color_gray));
            rw5Var.i.setText(String.format("[%s]", this.mContext.getString(R.string.settings_item_fujinderen)));
        } else if (i12 == 17) {
            str = strS;
            str2 = string6;
            i = i12;
            rw5Var.i.setVisibility(0);
            rw5Var.i.setTextColor(this.mContext.getResources().getColor(R.color.text_color_gray));
            rw5Var.i.setText(String.format("[%s]", this.mContext.getString(R.string.source_type_people_match)));
        } else if (i12 != 10001) {
            rw5Var.i.setVisibility(8);
            str = strS;
            str2 = string6;
            i = i12;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(string6);
                int iOptInt = jSONObject.optInt("thread_biz_type");
                str2 = string6;
                try {
                    string = iOptInt != 14 ? iOptInt != 17 ? "" : this.mContext.getString(R.string.source_type_people_match) : this.mContext.getString(R.string.settings_item_fujinderen);
                    strOptString = jSONObject.optString("nick_name");
                    if (TextUtils.isEmpty(strOptString)) {
                        strOptString = this.mContext.getString(R.string.myself);
                    }
                    str = strS;
                } catch (JSONException unused) {
                    str = strS;
                }
            } catch (JSONException unused2) {
                str = strS;
                str2 = string6;
            }
            try {
                rw5Var.i.setVisibility(0);
                i = i12;
            } catch (JSONException unused3) {
                i = i12;
                rw5Var.i.setVisibility(8);
                if (i7 == 9) {
                }
                if (i9 != 100) {
                }
                if (i8 != 0) {
                }
                if (!z) {
                }
                rw5Var.h.setVisibility(8);
                if (fu5.t(i2)) {
                }
                rw5Var.l.setVisibility(i3);
                str3 = str;
                ContactInfoItem contactInfoItemL = bo0.r().l(str3);
                if (i10 != 0) {
                }
                if (i11 == 1) {
                }
                if (TextUtils.isEmpty(str2)) {
                }
                int color = Color.parseColor("#999999");
                if (!TextUtils.isEmpty(str5)) {
                }
                rw5Var.e.setTextColor(color);
                if (i10 != 1) {
                }
                rw5Var.d.setVisibility(8);
                if (i11 != 1) {
                }
                if (TextUtils.isEmpty(str7)) {
                }
                if (i2 == 10001) {
                }
                if (10001 != i2) {
                }
                if (a65.f(str6)) {
                }
                if (a(contactInfoItem)) {
                }
                b(cursor);
            }
            try {
                rw5Var.i.setTextColor(this.mContext.getResources().getColor(R.color.text_color_gray));
                if (TextUtils.isEmpty(string)) {
                    rw5Var.i.setText(String.format("%s: ", strOptString));
                } else if (i7 == 10001) {
                    rw5Var.i.setText(String.format("[%s]", string));
                } else {
                    rw5Var.i.setText(String.format("[%s] %s: ", string, strOptString));
                }
            } catch (JSONException unused4) {
                rw5Var.i.setVisibility(8);
            }
        }
        if (i7 == 9) {
            string4 = SAppUtil.b.b() ? tw5.c(context, string4, string3) : tw5.b(context, string4, string3);
        }
        if (i9 != 100) {
            view.setBackgroundResource(R.drawable.selector_thread_top_item_background);
        } else {
            view.setBackgroundResource(R.drawable.selector_settings_item_background);
        }
        if (i8 != 0) {
            rw5Var.g.setVisibility(8);
            rw5Var.b.setVisibility(8);
        } else if (z) {
            rw5Var.b.setVisibility(8);
            rw5Var.g.setVisibility(0);
        } else {
            rw5Var.g.setVisibility(8);
            rw5Var.b.setVisibility(0);
            if (i8 >= 100) {
                rw5Var.b.setText(R.string.notification_ellipsis);
            } else {
                rw5Var.b.setText(String.valueOf(i8));
            }
        }
        if (!z) {
            i2 = i;
            if (i2 < 10000) {
                rw5Var.h.setVisibility(0);
            }
            if (!fu5.t(i2) || fu5.k(i2).saveInTempTable) {
                i3 = 8;
                rw5Var.k.setVisibility(8);
            } else {
                rw5Var.k.setVisibility(0);
                i3 = 8;
            }
            rw5Var.l.setVisibility(i3);
            str3 = str;
            ContactInfoItem contactInfoItemL2 = bo0.r().l(str3);
            if (i10 != 0 || contactInfoItemL2 == null) {
                rw5Var.m.setVisibility(8);
                rw5Var.n.setVisibility(8);
                rw5Var.c.setTextColor(context.getResources().getColor(R.color.Gb));
                rw5Var.o.setVisibility(8);
            } else {
                int iG = fg6.g(contactInfoItemL2.getExt());
                if (fg6.q(iG)) {
                    rw5Var.n.setImageResource(fg6.c(iG));
                    i5 = 0;
                    rw5Var.n.setVisibility(0);
                    i6 = 8;
                } else {
                    i5 = 0;
                    i6 = 8;
                    rw5Var.n.setVisibility(8);
                }
                if (contactInfoItemL2.isOfficialAccount()) {
                    rw5Var.m.setVisibility(i5);
                } else {
                    rw5Var.m.setVisibility(i6);
                }
                if (contactInfoItemL2.isOfficialAccount()) {
                    rw5Var.c.setTextColor(context.getResources().getColor(R.color.Gg));
                } else {
                    rw5Var.c.setTextColor(fg6.n(context, iG));
                }
                if (zg5.i(contactInfoItemL2)) {
                    rw5Var.o.setVisibility(0);
                } else {
                    rw5Var.o.setVisibility(8);
                }
            }
            int i13 = (i11 == 1 || i11 == 4 || i11 == 3) ? 60 : 0;
            if (TextUtils.isEmpty(str2) || (bizExt = (ThreadBizExtHelper.BizExt) az2.a(str2, ThreadBizExtHelper.BizExt.class)) == null || (threadShowInfo = bizExt.threadShowInfo) == null || TextUtils.isEmpty(threadShowInfo.content)) {
                str4 = null;
                str5 = null;
            } else {
                ThreadBizExtHelper.ThreadShowInfo threadShowInfo2 = bizExt.threadShowInfo;
                str5 = threadShowInfo2.content;
                str4 = threadShowInfo2.color;
            }
            int color2 = Color.parseColor("#999999");
            if (!TextUtils.isEmpty(str5)) {
                if (!TextUtils.isEmpty(str4)) {
                    try {
                        color2 = Color.parseColor(str4);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                string4 = str5;
            }
            rw5Var.e.setTextColor(color2);
            if (i10 != 1 || !z3) {
                str6 = str3;
                int i14 = 1;
                if (i10 != 1) {
                    if (i10 != i14) {
                        if (i10 != i14 && z6) {
                            rw5Var.i.setVisibility(0);
                            rw5Var.i.setTextColor(this.mContext.getResources().getColor(R.color.draft_color));
                            rw5Var.i.setText(R.string.greetings_group_title_tip);
                            rw5Var.e.setText(il5.e(vl1.c(string4, this.mContext, vl1.d), AppContext.getContext().getResources().getDimension(R.dimen.conversation_text_size_main_text), ((k86.z(this.mContext) - k86.e(this.mContext, 124.0f)) - (((int) il5.k(this.mContext, rw5Var.i.getText().toString(), k86.e(this.mContext, 14.0f))) + k86.e(this.mContext, 4.0f))) - i13));
                        } else if (TextUtils.isEmpty(string5)) {
                            rw5Var.i.setVisibility(0);
                            rw5Var.i.setTextColor(this.mContext.getResources().getColor(R.color.draft_color));
                            rw5Var.i.setText(R.string.thread_draft);
                            rw5Var.e.setText(il5.e(vl1.c(string5, this.mContext, vl1.d), AppContext.getContext().getResources().getDimension(R.dimen.conversation_text_size_main_text), ((k86.z(this.mContext) - k86.e(this.mContext, 124.0f)) - (((int) il5.k(this.mContext, rw5Var.i.getText().toString(), k86.e(this.mContext, 14.0f))) + k86.e(this.mContext, 4.0f))) - i13));
                        } else {
                            str7 = string5;
                            if (i10 == 1 && z && i8 > 1) {
                                rw5Var.i.setVisibility(0);
                                rw5Var.i.setTextColor(this.mContext.getResources().getColor(R.color.text_color_gray));
                                rw5Var.i.setText(this.mContext.getString(R.string.thread_nodisturb_unread_count, Integer.valueOf(i8)));
                                contactInfoItem = contactInfoItemL2;
                                rw5Var.e.setText(il5.e(vl1.c(string4, this.mContext, vl1.d), AppContext.getContext().getResources().getDimension(R.dimen.conversation_text_size_main_text), ((k86.z(this.mContext) - k86.e(this.mContext, 124.0f)) - (((int) il5.k(this.mContext, rw5Var.i.getText().toString(), k86.e(this.mContext, 14.0f))) + k86.e(this.mContext, 4.0f))) - i13));
                            } else {
                                contactInfoItem = contactInfoItemL2;
                                if (i7 != 3 || z7) {
                                    rw5Var.e.setText(il5.e(vl1.c(string4, this.mContext, vl1.d), AppContext.getContext().getResources().getDimension(R.dimen.conversation_text_size_main_text), ((k86.z(this.mContext) - k86.e(this.mContext, 124.0f)) - (rw5Var.i.getVisibility() == 0 ? ((int) il5.k(this.mContext, rw5Var.i.getText().toString(), k86.e(this.mContext, 14.0f))) + k86.e(this.mContext, 4.0f) : 0)) - i13));
                                } else {
                                    SpannableString spannableString = new SpannableString(string4);
                                    int iLastIndexOf = string4.lastIndexOf(":");
                                    spannableString.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(R.color.draft_color)), iLastIndexOf < 0 ? 0 : iLastIndexOf + 1, string4.length(), 33);
                                    rw5Var.e.setText(spannableString);
                                }
                            }
                        }
                    } else if (z2) {
                        rw5Var.i.setVisibility(0);
                        rw5Var.i.setTextColor(this.mContext.getResources().getColor(R.color.draft_color));
                        rw5Var.i.setText(R.string.remind_notification);
                        rw5Var.e.setText(il5.e(vl1.c(string4, this.mContext, vl1.d), AppContext.getContext().getResources().getDimension(R.dimen.conversation_text_size_main_text), ((k86.z(this.mContext) - k86.e(this.mContext, 124.0f)) - (((int) il5.k(this.mContext, rw5Var.i.getText().toString(), k86.e(this.mContext, 14.0f))) + k86.e(this.mContext, 4.0f))) - i13));
                    } else {
                        i14 = 1;
                        if (i10 != i14) {
                            if (TextUtils.isEmpty(string5)) {
                            }
                        }
                    }
                } else if (z4) {
                    rw5Var.i.setVisibility(0);
                    rw5Var.i.setTextColor(this.mContext.getResources().getColor(R.color.draft_color));
                    rw5Var.i.setText("[券红包]");
                    if (circleThreadHasVoucherStatus == 2) {
                        rw5Var.e.setText("");
                    } else {
                        rw5Var.e.setText(il5.e(vl1.c(string4, this.mContext, vl1.d), AppContext.getContext().getResources().getDimension(R.dimen.conversation_text_size_main_text), ((k86.z(this.mContext) - k86.e(this.mContext, 124.0f)) - (((int) il5.k(this.mContext, rw5Var.i.getText().toString(), k86.e(this.mContext, 14.0f))) + k86.e(this.mContext, 4.0f))) - i13));
                    }
                } else {
                    i14 = 1;
                    if (i10 != i14) {
                    }
                }
                rw5Var.d.setVisibility(8);
                if (i11 != 1 || i11 == 4) {
                    rw5Var.f.setText(R.string.list_time_loading);
                    drawable = this.mContext.getResources().getDrawable(R.drawable.icon_thread_message_status_pending);
                } else if (i11 == 3) {
                    drawable = this.mContext.getResources().getDrawable(R.drawable.icon_thread_message_status_fail);
                    if (j3 > 0) {
                        rw5Var.f.setText(by5.e(j3, context));
                        rw5Var.f.setVisibility(0);
                    } else {
                        rw5Var.f.setVisibility(8);
                    }
                } else if (i7 != 37) {
                    i4 = 0;
                    if (j3 > 0) {
                        rw5Var.f.setText(by5.e(j3, context));
                        rw5Var.f.setVisibility(i4);
                    } else {
                        rw5Var.f.setVisibility(8);
                    }
                    drawable = null;
                } else {
                    if (ir5.c(true) - j3 > 21600000) {
                        rw5Var.d.setVisibility(8);
                        i4 = 0;
                        if (j3 > 0) {
                        }
                        drawable = null;
                    } else {
                        i4 = 0;
                        rw5Var.d.setVisibility(0);
                        if (j3 > 0) {
                        }
                        drawable = null;
                    }
                }
                if (TextUtils.isEmpty(str7)) {
                    amulet = null;
                    rw5Var.i.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                    rw5Var.i.setCompoundDrawablePadding(me1.b(this.mContext, 4));
                    rw5Var.e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    amulet = null;
                    rw5Var.e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                    rw5Var.e.setCompoundDrawablePadding(me1.b(this.mContext, 4));
                    rw5Var.i.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (i2 == 10001) {
                    rw5Var.c.setText(string3);
                } else {
                    rw5Var.c.setText(R.string.greetings_group_title);
                }
                if (10001 != i2) {
                    rw5Var.f20597a.getPortraitView().setImageResource(R.drawable.ic_greetings);
                } else {
                    rw5Var.f20597a.setAvatarView(string2, contactInfoItem != null ? contactInfoItem.getAmulet() : amulet);
                }
                if (a65.f(str6)) {
                    rw5Var.e.setText(a65.b(string4));
                }
                if (a(contactInfoItem)) {
                    rw5Var.p.setVisibility(8);
                } else {
                    rw5Var.p.setVisibility(0);
                    Glide.with(this.mContext).load2(v8.s).error(R.drawable.ai_chat_msg_aitag).into(rw5Var.p);
                }
                b(cursor);
            }
            rw5Var.i.setVisibility(0);
            rw5Var.i.setTextColor(this.mContext.getResources().getColor(R.color.draft_color));
            rw5Var.i.setText("[群公告]");
            if (circleThreadHasNoticeStatus == 2) {
                rw5Var.e.setText("");
                str6 = str3;
            } else {
                str6 = str3;
                rw5Var.e.setText(il5.e(vl1.c(string4, this.mContext, vl1.d), AppContext.getContext().getResources().getDimension(R.dimen.conversation_text_size_main_text), ((k86.z(this.mContext) - k86.e(this.mContext, 124.0f)) - (((int) il5.k(this.mContext, rw5Var.i.getText().toString(), k86.e(this.mContext, 14.0f))) + k86.e(this.mContext, 4.0f))) - i13));
            }
            contactInfoItem = contactInfoItemL2;
            str7 = string5;
            rw5Var.d.setVisibility(8);
            if (i11 != 1) {
                rw5Var.f.setText(R.string.list_time_loading);
                drawable = this.mContext.getResources().getDrawable(R.drawable.icon_thread_message_status_pending);
            }
            if (TextUtils.isEmpty(str7)) {
            }
            if (i2 == 10001) {
            }
            if (10001 != i2) {
            }
            if (a65.f(str6)) {
            }
            if (a(contactInfoItem)) {
            }
            b(cursor);
        }
        i2 = i;
        rw5Var.h.setVisibility(8);
        if (fu5.t(i2)) {
            i3 = 8;
            rw5Var.k.setVisibility(8);
        }
        rw5Var.l.setVisibility(i3);
        str3 = str;
        ContactInfoItem contactInfoItemL22 = bo0.r().l(str3);
        if (i10 != 0) {
            rw5Var.m.setVisibility(8);
            rw5Var.n.setVisibility(8);
            rw5Var.c.setTextColor(context.getResources().getColor(R.color.Gb));
            rw5Var.o.setVisibility(8);
        }
        if (i11 == 1) {
        }
        if (TextUtils.isEmpty(str2)) {
            str4 = null;
            str5 = null;
        }
        int color22 = Color.parseColor("#999999");
        if (!TextUtils.isEmpty(str5)) {
        }
        rw5Var.e.setTextColor(color22);
        if (i10 != 1) {
            str6 = str3;
            int i142 = 1;
            if (i10 != 1) {
            }
        }
        rw5Var.d.setVisibility(8);
        if (i11 != 1) {
        }
        if (TextUtils.isEmpty(str7)) {
        }
        if (i2 == 10001) {
        }
        if (10001 != i2) {
        }
        if (a65.f(str6)) {
        }
        if (a(contactInfoItem)) {
        }
        b(cursor);
    }

    public final ThreadBizExtHelper.BizExt c(int i, int i2, String str, String str2) {
        ThreadBizExtHelper.BizExt bizExt;
        if (i != 0 || i2 != 28 || "88888003".equals(str) || TextUtils.isEmpty(str2) || (bizExt = (ThreadBizExtHelper.BizExt) az2.a(str2, ThreadBizExtHelper.BizExt.class)) == null || bizExt.getRichMessage() == null) {
            return null;
        }
        if (bizExt.getRichMessage().getShowType() == 9 || bizExt.getRichMessage().getShowType() == 8) {
            return bizExt;
        }
        return null;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = this.f13746a.inflate(R.layout.list_item_threads_list, (ViewGroup) null, false);
        viewInflate.setTag(rw5.a(viewInflate));
        return viewInflate;
    }
}
