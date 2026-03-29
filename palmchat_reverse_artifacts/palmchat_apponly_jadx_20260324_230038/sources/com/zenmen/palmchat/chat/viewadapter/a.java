package com.zenmen.palmchat.chat.viewadapter;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter;
import com.zenmen.palmchat.chat.viewadapter.a;
import com.zenmen.palmchat.contacts.ContactRequestsVO;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.utils.SAppUtil;
import com.zenmen.palmchat.widget.LXPortraitView;
import defpackage.ho3;
import defpackage.i7;
import defpackage.if6;
import defpackage.l50;
import defpackage.p40;
import defpackage.zh;
import defpackage.zn6;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a extends SimpleChatViewAdapter {
    public boolean i = false;
    public boolean j = false;

    /* JADX INFO: renamed from: com.zenmen.palmchat.chat.viewadapter.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1000a implements SimpleChatViewAdapter.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i7 f12924a;

        public C1000a(i7 i7Var) {
            this.f12924a = i7Var;
        }

        @Override // com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter.b
        public void a(int i) {
            this.f12924a.w.setTextColor(i);
        }

        @Override // com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter.b
        public void onReset() {
            this.f12924a.w.setTextColor(a.this.f.getResources().getColor(R.color.Gb));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p40 f12925a;
        public final /* synthetic */ MessageVo b;

        public b(p40 p40Var, MessageVo messageVo) {
            this.f12925a = p40Var;
            this.b = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p40 p40Var;
            com.zenmen.palmchat.chat.fragment.a aVarE;
            if (l50.a() || (p40Var = this.f12925a) == null || (aVarE = p40Var.e()) == null) {
                return;
            }
            aVarE.o(true, true, false, null);
            a.A("pagechatwindow_quickapply_click", "click");
            a.this.C(this.b, AppContext.getContext().getString(R.string.add_friend_in_chat_already_apply));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p40 f12926a;

        /* JADX INFO: renamed from: com.zenmen.palmchat.chat.viewadapter.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC1001a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Runnable f12927a;

            public RunnableC1001a(Runnable runnable) {
                this.f12927a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f12927a.run();
            }
        }

        public c(p40 p40Var) {
            this.f12926a = p40Var;
        }

        public static /* synthetic */ void b(com.zenmen.palmchat.chat.fragment.a aVar) {
            ContactRequestsVO contactRequestsVOU = aVar.u();
            if (contactRequestsVOU == null) {
                aVar.o(true, true, false, null);
            } else {
                aVar.m(true, contactRequestsVOU);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p40 p40Var;
            final com.zenmen.palmchat.chat.fragment.a aVarE;
            if (l50.a() || (p40Var = this.f12926a) == null || (aVarE = p40Var.e()) == null) {
                return;
            }
            Runnable runnable = new Runnable() { // from class: h7
                @Override // java.lang.Runnable
                public final void run() {
                    a.c.b(aVarE);
                }
            };
            ContactRequestsVO contactRequestsVOU = aVarE.u();
            if (contactRequestsVOU == null) {
                aVarE.D();
                view.postDelayed(new RunnableC1001a(runnable), 500L);
            } else {
                aVarE.m(true, contactRequestsVOU);
            }
            a.A("pagechatwindow_quickagree_click", "click");
        }
    }

    public static void A(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("report_type", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d(str, null, jSONObject.toString());
    }

    public final void B(i7 i7Var, int i) {
        i7Var.i.setVisibility(8);
        i7Var.t.setVisibility(8);
        i7Var.r.setVisibility(8);
        i7Var.u.setVisibility(8);
        i7Var.v.setVisibility(8);
        if (i == 0) {
            if (SAppUtil.b.b()) {
                i7Var.v.setVisibility(8);
                return;
            } else {
                i7Var.v.setVisibility(0);
                return;
            }
        }
        if (i == 1) {
            i7Var.t.setVisibility(0);
            if (this.i) {
                return;
            }
            A("pagechatwindow_quickapply", "view");
            this.i = true;
            return;
        }
        if (i != 2) {
            if (i == 3) {
                i7Var.u.setVisibility(0);
            }
        } else {
            i7Var.i.setVisibility(0);
            i7Var.r.setVisibility(0);
            if (this.j) {
                return;
            }
            A("pagechatwindow_quickagree", "view");
            this.j = true;
        }
    }

    public final void C(MessageVo messageVo, String str) {
        String[] strArr = {messageVo.mid};
        ContentValues contentValues = new ContentValues();
        contentValues.put("message", str);
        zh.k(AppContext.getContext().getContentResolver()).j(0, null, DBUriManager.c(ho3.class, messageVo.contactRelate), contentValues, "packet_id=?", strArr);
    }

    @Override // defpackage.o40
    public int a() {
        return 44;
    }

    @Override // defpackage.o40
    public View b(Context context, MessageVo messageVo) {
        if (133 != messageVo.mimeType) {
            return null;
        }
        return this.e.inflate(R.layout.list_item_chat_add_friend, (ViewGroup) null);
    }

    @Override // defpackage.o40
    public if6 c(View view) {
        return new i7(view);
    }

    @Override // defpackage.o40
    public int getViewTypeCount() {
        return 1;
    }

    @Override // defpackage.o40
    public <T extends if6> void l(T t, MessageVo messageVo) {
        z(messageVo, (i7) t);
    }

    @Override // defpackage.o40
    public int m(boolean z, int i, MessageVo messageVo) {
        return i == 133 ? 44 : -1;
    }

    public final int x(MessageVo messageVo) {
        String str = messageVo.extention;
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        try {
            String string = new JSONObject(str).getString("friendActionType");
            if (!TextUtils.isEmpty(string) && !"apply".equalsIgnoreCase(string)) {
                return "agree".equalsIgnoreCase(string) ? 2 : 1;
            }
            return 1;
        } catch (JSONException e) {
            e.printStackTrace();
            return 1;
        }
    }

    public final Pair<Integer, Boolean> y(MessageVo messageVo, com.zenmen.palmchat.chat.fragment.a aVar) {
        boolean zOptBoolean;
        int iY = aVar.y();
        boolean z = false;
        try {
            JSONObject jSONObject = new JSONObject(messageVo.extention);
            zOptBoolean = jSONObject.optBoolean("alreadyApply", false);
            try {
                String string = jSONObject.getString("friendActionType");
                if (!TextUtils.isEmpty(string)) {
                    if (!"apply".equalsIgnoreCase(string)) {
                        "agree".equalsIgnoreCase(string);
                    } else if (zOptBoolean) {
                        z = true;
                    }
                }
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e = e2;
            zOptBoolean = false;
        }
        if (z && iY != 0) {
            iY = 3;
        }
        return new Pair<>(Integer.valueOf(iY), Boolean.valueOf(zOptBoolean));
    }

    public void z(MessageVo messageVo, i7 i7Var) {
        com.zenmen.palmchat.chat.fragment.a aVarE;
        LXPortraitView lXPortraitView = i7Var.i;
        if (lXPortraitView != null) {
            ((RelativeLayout.LayoutParams) lXPortraitView.getLayoutParams()).addRule(9, 1);
        }
        View view = i7Var.j;
        if (view != null) {
            view.setVisibility(8);
        }
        ImageView imageView = i7Var.k;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = i7Var.c;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = i7Var.d;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        if (i7Var.w != null) {
            if (TextUtils.isEmpty(messageVo.text)) {
                i7Var.w.setText(R.string.add_friend_in_chat_apply_tips);
            } else {
                i7Var.w.setText(messageVo.text);
            }
        }
        u(messageVo, i7Var.w, i7Var.i, new C1000a(i7Var));
        p40 p40VarR = r();
        if (p40VarR != null && (aVarE = p40VarR.e()) != null) {
            Pair<Integer, Boolean> pairY = y(messageVo, aVarE);
            int iIntValue = ((Integer) pairY.first).intValue();
            if (iIntValue == 1 && (iIntValue = x(messageVo)) == 2 && aVarE.z() != null && !((Boolean) pairY.second).booleanValue()) {
                aVarE.z().e();
            }
            B(i7Var, iIntValue);
        }
        i7Var.t.setOnClickListener(new b(p40VarR, messageVo));
        i7Var.s.setOnClickListener(new c(p40VarR));
    }
}
