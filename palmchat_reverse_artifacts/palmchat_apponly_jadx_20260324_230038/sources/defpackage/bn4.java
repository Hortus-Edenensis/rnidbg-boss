package defpackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.pay.PayChatInfo;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.bean.SquareChatCheckBean;
import com.zenmen.square.tag.bean.CommonResponse;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class bn4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f1777a;
    public h b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public int g;
    public boolean h;
    public String i;
    public int j;
    public PopupWindow k;
    public PopupWindow l;
    public boolean m;
    public a94 n;
    public String o;
    public PayChatInfo p;
    public boolean q = false;
    public ChatItem r;
    public boolean s;
    public boolean t;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends tw4<CommonResponse<SquareChatCheckBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatItem f1778a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        public a(ChatItem chatItem, TextView textView, int i, int i2) {
            this.f1778a = chatItem;
            this.b = textView;
            this.c = i;
            this.d = i2;
        }

        @Override // defpackage.tw4
        public void a(CommonResponse<SquareChatCheckBean> commonResponse) {
            if (commonResponse != null && commonResponse.getData() != null) {
                SquareChatCheckBean data = commonResponse.getData();
                bn4 bn4Var = bn4.this;
                bn4Var.d = data.allowSend;
                bn4Var.e = data.isVip;
                bn4Var.f = data.needVipCounts;
                bn4Var.g = data.vipCounts;
                bn4Var.h = data.needAlert;
                bn4Var.i = data.alertMsg;
                bn4Var.j = data.statusCode;
                bn4Var.c = true;
                if (bn4Var.u(this.f1778a.getBizType()) || bn4.this.x(this.f1778a.getBizType())) {
                    this.b.setVisibility(0);
                    bn4.this.g(this.f1778a.getBizType(), this.b, true, this.c, this.d, this.f1778a);
                }
            }
            bn4.this.b.b(bn4.this.d);
        }

        @Override // defpackage.tw4
        public void b(int i, String str) {
            super.b(i, str);
            bn4.this.b.b(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f1779a;
        public final /* synthetic */ ChatItem b;
        public final /* synthetic */ TextView c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;

        public b(boolean z, ChatItem chatItem, TextView textView, int i, int i2) {
            this.f1779a = z;
            this.b = chatItem;
            this.c = textView;
            this.d = i;
            this.e = i2;
        }

        @Override // bn4.i
        public void a(boolean z) {
            bn4.this.q = true;
            bn4.this.b.a(this.f1779a);
            if (z) {
                return;
            }
            bn4.this.z(this.b, this.c, this.d, this.e);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f1780a;
        public final /* synthetic */ ChatItem b;

        public c(i iVar, ChatItem chatItem) {
            this.f1780a = iVar;
            this.b = chatItem;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            this.f1780a.a(false);
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            JSONObject jSONObject2;
            LogUtil.i("PrivateChatCheckHelper", "getPayChatInfoFromService" + jSONObject);
            if (yy2Var.f22300a && (jSONObject2 = yy2Var.d) != null) {
                bn4.this.p = (PayChatInfo) az2.a(jSONObject2.toString(), PayChatInfo.class);
            }
            PayChatInfo payChatInfo = bn4.this.p;
            if (payChatInfo == null) {
                this.f1780a.a(false);
                return;
            }
            this.f1780a.a(payChatInfo.needChatPay());
            if (TextUtils.isEmpty(bn4.this.p.sysContent) || !bn4.this.p.isNeedShowPayInfo()) {
                return;
            }
            com.zenmen.palmchat.chat.pay.a.d(this.b, bn4.this.p.sysContent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends MaterialDialog.e {
        public d() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            materialDialog.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f1782a;
        public final /* synthetic */ ChatItem b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        public e(int i, ChatItem chatItem, int i2, int i3) {
            this.f1782a = i;
            this.b = chatItem;
            this.c = i2;
            this.d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bn4.m(bn4.this.f1777a, this.f1782a, -1);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("report_type", "click");
                if (!TextUtils.isEmpty(bn4.this.o)) {
                    jSONObject.put("impr_id", bn4.this.o);
                }
                ChatItem chatItem = this.b;
                if (chatItem != null && !TextUtils.isEmpty(chatItem.getChatId())) {
                    jSONObject.put("target_uid", this.b.getChatId());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            zn6.d("pagechat_half_viphint", null, jSONObject.toString());
            bn4.this.h(this.f1782a, this.c, this.d);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f1783a;
        public final /* synthetic */ View b;
        public final /* synthetic */ PopupWindow c;

        public f(View view, View view2, PopupWindow popupWindow) {
            this.f1783a = view;
            this.b = view2;
            this.c = popupWindow;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                int iB = me1.b(AppContext.getContext(), 27);
                int measuredWidth = this.f1783a.getMeasuredWidth() - this.b.getMeasuredWidth();
                int i = -(this.f1783a.getMeasuredHeight() + this.b.getMeasuredHeight() + iB);
                if (bn4.this.f1777a == null || bn4.this.f1777a.isFinishing() || bn4.this.f1777a.isDestroyed()) {
                    return;
                }
                this.c.showAsDropDown(this.f1783a, measuredWidth, i, GravityCompat.START);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f1784a;
        public final /* synthetic */ View b;
        public final /* synthetic */ PopupWindow c;

        public g(View view, View view2, PopupWindow popupWindow) {
            this.f1784a = view;
            this.b = view2;
            this.c = popupWindow;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                int iB = me1.b(AppContext.getContext(), 27);
                int measuredWidth = this.f1784a.getMeasuredWidth() - this.b.getMeasuredWidth();
                int i = -(this.f1784a.getMeasuredHeight() + this.b.getMeasuredHeight() + iB);
                if (bn4.this.f1777a == null || bn4.this.f1777a.isFinishing() || bn4.this.f1777a.isDestroyed()) {
                    return;
                }
                this.c.showAsDropDown(this.f1784a, measuredWidth, i, GravityCompat.START);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface h {
        void a(boolean z);

        void b(boolean z);

        void c(boolean z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface i {
        void a(boolean z);
    }

    public bn4(Activity activity, ChatItem chatItem, String str, h hVar) {
        this.f1777a = activity;
        this.r = chatItem;
        this.o = str;
        this.b = hVar;
    }

    public static void C(int i2, int i3, int i4) {
        if (5002 == i2 || 5006 == i2) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (5002 == i2) {
                    jSONObject.put("page", "tab_mine");
                } else {
                    jSONObject.put("page", "tab_square");
                }
                jSONObject.put("index", i3);
                jSONObject.put("clickType", i4);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            zn6.g("friend_recommend_chat_limit", jSONObject);
        }
    }

    public static void m(Activity activity, int i2, int i3) {
        if (activity == null) {
            return;
        }
        String strValueOf = 64 == i2 ? "1" : 65 == i2 ? "2" : 67 == i2 ? "9" : 66 == i2 ? "10" : 68 == i2 ? "25" : 69 == i2 ? "26" : fu5.q(i2) ? String.valueOf(i2 + AVMDLDataLoader.AVMDLErrorIsInvalidFileWrite + 500) : "";
        if (i3 > 0) {
            strValueOf = String.valueOf(i3);
        }
        ap3.x(activity, strValueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        this.m = false;
    }

    public void A(Context context, int i2, ChatItem chatItem) {
        View viewInflate = LayoutInflater.from(AppContext.getContext()).inflate(R.layout.private_chat_limit_dialog_custom_view, (ViewGroup) null, false);
        if (!TextUtils.isEmpty(this.i)) {
            ((TextView) viewInflate.findViewById(R.id.tv_limit_tips)).setText(this.i);
        }
        new sd3(context).p(viewInflate, false).O(R.string.alert_dialog_all_right).f(new d()).e().show();
        p(i2, chatItem);
    }

    public void B(Activity activity) {
        if (activity != null) {
            try {
                a94 a94Var = this.n;
                if (a94Var != null) {
                    a94Var.dismiss();
                }
                a94 a94VarA = a94.a();
                this.n = a94VarA;
                a94VarA.show(activity.getFragmentManager(), a94.class.getSimpleName());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final PopupWindow D(View view, int i2, int i3, int i4, ChatItem chatItem) {
        View viewInflate = LayoutInflater.from(AppContext.getContext()).inflate(R.layout.super_greetings_chat_need_pop_layout, (ViewGroup) null);
        s(viewInflate);
        PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setContentView(viewInflate);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setFocusable(false);
        popupWindow.setAnimationStyle(R.style.AnimationPopMenuDialog);
        viewInflate.setOnClickListener(new e(i2, chatItem, i3, i4));
        if (!popupWindow.isShowing() && view != null) {
            view.postDelayed(new f(view, viewInflate, popupWindow), 50L);
        }
        popupWindow.update();
        return popupWindow;
    }

    public PopupWindow E(View view, int i2) {
        View viewInflate = LayoutInflater.from(AppContext.getContext()).inflate(R.layout.super_greetings_count_pop_layout, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.tv_super_greetings_count)).setText(String.format(AppContext.getContext().getString(R.string.super_greetings_count), Integer.valueOf(i2)));
        s(viewInflate);
        PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setContentView(viewInflate);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setFocusable(false);
        popupWindow.setAnimationStyle(R.style.AnimationPopMenuDialog);
        if (!popupWindow.isShowing() && view != null) {
            view.postDelayed(new g(view, viewInflate, popupWindow), 50L);
        }
        popupWindow.update();
        return popupWindow;
    }

    public boolean F(int i2) {
        return fu5.p(i2);
    }

    public void g(int i2, View view, boolean z, int i3, int i4, ChatItem chatItem) {
        PopupWindow popupWindow;
        if (view == null) {
            return;
        }
        if (z) {
            try {
                if (view.getVisibility() == 0) {
                    if (this.m) {
                        return;
                    }
                    this.m = true;
                    if (u(i2)) {
                        PopupWindow popupWindow2 = this.k;
                        if (popupWindow2 == null || !popupWindow2.isShowing()) {
                            this.k = D(view, i2, i3, i4, chatItem);
                            view.setBackground(AppContext.getContext().getDrawable(R.drawable.selector_btn_send_super_chat));
                            q(i2, i3, i4, chatItem);
                            this.b.c(true);
                        }
                    } else if (x(i2) && ((popupWindow = this.l) == null || !popupWindow.isShowing())) {
                        this.l = E(view, this.g);
                        view.setBackground(AppContext.getContext().getDrawable(R.drawable.selector_btn_send_super_chat));
                        r();
                        this.b.c(true);
                    }
                    view.postDelayed(new Runnable() { // from class: an4
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f1261a.n();
                        }
                    }, 100L);
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        PopupWindow popupWindow3 = this.k;
        if (popupWindow3 != null) {
            popupWindow3.dismiss();
        }
        PopupWindow popupWindow4 = this.l;
        if (popupWindow4 != null) {
            popupWindow4.dismiss();
        }
        view.setBackground(AppContext.getContext().getDrawable(R.drawable.selector_btn_send));
        this.b.c(false);
    }

    public void h(int i2, int i3, int i4) {
        if (5002 == i2 || 5006 == i2) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (5002 == i2) {
                    jSONObject.put("page", "tab_mine");
                } else {
                    jSONObject.put("page", "tab_square");
                }
                jSONObject.put("index", i3);
                jSONObject.put("clickType", i4);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            zn6.g("friend_recommend_chat_limit_click", jSONObject);
        }
    }

    public void i() {
        try {
            a94 a94Var = this.n;
            if (a94Var != null) {
                a94Var.dismiss();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public PayChatInfo j() {
        return this.p;
    }

    public final void k(ChatItem chatItem, i iVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("chatUid", chatItem.getChatId());
            jSONObject.put("domain", fu5.k(this.r.getBizType()).domain);
            if (fu5.q(this.r.getBizType())) {
                jSONObject.put("bizType", this.r.getBizType() + AVMDLDataLoader.AVMDLErrorIsInvalidFileWrite);
            } else {
                jSONObject.put("bizType", 0);
            }
            LogUtil.i("PrivateChatCheckHelper", "getPayChatInfoFromService param=" + jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zw4.f(nl0.z + "/chat.pay.tips.v1", 1, jSONObject, new c(iVar, chatItem));
    }

    public boolean l() {
        return this.q;
    }

    public void o(int i2) {
        if (F(i2)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("report_type", "click");
                jSONObject.put("type", this.e ? 1 : 0);
                if (!TextUtils.isEmpty(this.o)) {
                    jSONObject.put("impr_id", this.o);
                }
                ChatItem chatItem = this.r;
                if (chatItem != null) {
                    jSONObject.put("fuid", chatItem.getChatId());
                }
                if (5016 == i2) {
                    jSONObject.put("bstype", 2);
                } else if (5012 == i2) {
                    jSONObject.put("bstype", 1);
                }
                jSONObject.put("chat_charge_status", w() ? 1 : 0);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            zn6.d("pagechat_half_sendbutton", null, jSONObject.toString());
        }
    }

    public final void p(int i2, ChatItem chatItem) {
        JSONObject jSONObject = new JSONObject();
        String str = "";
        if (64 == i2) {
            str = "1";
        } else if (65 == i2) {
            str = "2";
        } else if (67 == i2) {
            str = "3";
        } else if (66 == i2) {
            str = "4";
        } else if (68 == i2) {
            str = "5";
        } else if (69 == i2) {
            str = "6";
        }
        try {
            jSONObject.put("report_type", "view");
            jSONObject.put("from", str);
            jSONObject.put("forbidtype", this.j);
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("impr_id", this.o);
            }
            if (chatItem != null && !TextUtils.isEmpty(chatItem.getChatId())) {
                jSONObject.put("target_uid", chatItem.getChatId());
            }
            if (fu5.q(i2)) {
                jSONObject.put("bizType", i2 + AVMDLDataLoader.AVMDLErrorIsInvalidFileWrite);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("pagechatlimit", null, jSONObject.toString());
    }

    public final void q(int i2, int i3, int i4, ChatItem chatItem) {
        if (this.s) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("report_type", "view");
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("impr_id", this.o);
            }
            if (chatItem != null && !TextUtils.isEmpty(chatItem.getChatId())) {
                jSONObject.put("target_uid", chatItem.getChatId());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("pagechat_half_viphint", null, jSONObject.toString());
        C(i2, i3, i4);
        this.s = true;
    }

    public final void r() {
        if (this.t) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("report_type", "view");
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("impr_id", this.o);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("pagechat_half_vipres", null, jSONObject.toString());
        this.t = true;
    }

    public final void s(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    public boolean t(int i2) {
        return F(i2) && this.c && !this.d && this.e && this.h && !v() && !TextUtils.isEmpty(this.i);
    }

    public boolean u(int i2) {
        return (!F(i2) || !this.c || this.d || v() || this.e) ? false : true;
    }

    public boolean v() {
        PayChatInfo payChatInfo = this.p;
        return payChatInfo != null && payChatInfo.needChatPay();
    }

    public boolean w() {
        PayChatInfo payChatInfo = this.p;
        return payChatInfo != null && payChatInfo.needPayOnSendMsg();
    }

    public boolean x(int i2) {
        return F(i2) && this.c && this.d && this.e && !v() && this.f && this.g > 0;
    }

    public void y(ChatItem chatItem, TextView textView, int i2, int i3, boolean z) {
        if (chatItem == null || !F(chatItem.getBizType())) {
            this.q = true;
            this.b.a(z);
            this.b.b(true);
        } else if (chatItem instanceof ContactInfoItem) {
            k(chatItem, new b(z, chatItem, textView, i2, i3));
        }
    }

    public final void z(ChatItem chatItem, TextView textView, int i2, int i3) {
        ContactInfoItem contactInfoItem = (ContactInfoItem) chatItem;
        int gender = contactInfoItem.getGender();
        String uid = contactInfoItem.getUid();
        ContactInfoItem contactInfoItemL = bo0.r().l(AccountUtils.p(AppContext.getContext()));
        if (contactInfoItemL == null) {
            return;
        }
        int gender2 = contactInfoItemL.getGender();
        uo2 uo2VarC = bj5.b().c();
        if (uo2VarC != null) {
            uo2VarC.c(gender2, uid, gender, contactInfoItem, new a(chatItem, textView, i2, i3));
        }
    }
}
