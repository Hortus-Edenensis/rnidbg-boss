package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.gift.GiftMessageHelper;
import com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.giftkit.chat.GiftMessageExtensionBean;
import defpackage.je1;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class dn4 extends SimpleChatViewAdapter {
    public je1 i = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).B(R.drawable.ic_chat_flowers_private_chat_gift_card).A(R.drawable.ic_chat_flowers_private_chat_gift_card).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).z(R.drawable.ic_chat_flowers_private_chat_gift_card).r();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f17087a;
        public final /* synthetic */ GiftMessageExtensionBean b;

        public a(MessageVo messageVo, GiftMessageExtensionBean giftMessageExtensionBean) {
            this.f17087a = messageVo;
            this.b = giftMessageExtensionBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            dn4.this.z(this.f17087a.isSend, this.b.giftId);
            dn4.this.C(this.f17087a, "1", this.b.openGiftName);
            GiftMessageExtensionBean giftMessageExtensionBean = this.b;
            String str = giftMessageExtensionBean.dynamicType;
            String str2 = giftMessageExtensionBean.dynamicUrl;
            if (!"svgah5".equals(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            GiftMessageHelper.y0(dn4.this.f, str2);
        }
    }

    public final void A(en4 en4Var, GiftMessageExtensionBean giftMessageExtensionBean) {
        en4Var.s.setText(giftMessageExtensionBean.openGiftName);
        en4Var.v.setText(giftMessageExtensionBean.openDesc);
        gr2.j().h(giftMessageExtensionBean.openIcon, en4Var.w, this.i);
        en4Var.u.setVisibility(8);
        en4Var.t.setVisibility(0);
        en4Var.t.setText(giftMessageExtensionBean.openSubTitle);
    }

    public final void B(MessageVo messageVo, en4 en4Var, GiftMessageExtensionBean giftMessageExtensionBean) {
        en4Var.s.setText(giftMessageExtensionBean.unOpenGiftName);
        en4Var.v.setText(giftMessageExtensionBean.unOpenDesc);
        gr2.j().h(giftMessageExtensionBean.unOpenIcon, en4Var.w, this.i);
        en4Var.u.setVisibility(0);
        en4Var.t.setVisibility(8);
        en4Var.u.setText(giftMessageExtensionBean.unOpenSubBtn);
        en4Var.u.setOnClickListener(new a(messageVo, giftMessageExtensionBean));
    }

    public final void C(MessageVo messageVo, String str, String str2) {
        String[] strArr = {messageVo.mid};
        ContentValues contentValues = new ContentValues();
        contentValues.put("data3", str);
        contentValues.put("message", str2);
        zh.k(AppContext.getContext().getContentResolver()).j(0, null, DBUriManager.c(ho3.class, messageVo.contactRelate), contentValues, "packet_id=?", strArr);
    }

    @Override // defpackage.o40
    public int a() {
        return 46;
    }

    @Override // defpackage.o40
    public View b(Context context, MessageVo messageVo) {
        if (messageVo != null && 35 == messageVo.mimeType && String.valueOf(0).equals(messageVo.data1) && String.valueOf(0).equals(messageVo.data2)) {
            return messageVo.isSend ? this.e.inflate(R.layout.list_item_private_chat_gift_card_right, (ViewGroup) null) : this.e.inflate(R.layout.list_item_private_chat_gift_card_left, (ViewGroup) null);
        }
        return null;
    }

    @Override // defpackage.o40
    public if6 c(View view) {
        return new en4(view);
    }

    @Override // defpackage.o40
    public int getViewTypeCount() {
        return 2;
    }

    @Override // defpackage.o40
    public <T extends if6> void l(T t, MessageVo messageVo) {
        y(messageVo, (en4) t);
    }

    @Override // defpackage.o40
    public int m(boolean z, int i, MessageVo messageVo) {
        if (messageVo != null && 35 == messageVo.mimeType && String.valueOf(0).equals(messageVo.data1) && String.valueOf(0).equals(messageVo.data2)) {
            return z ? 47 : 46;
        }
        return -1;
    }

    public void y(MessageVo messageVo, en4 en4Var) {
        View view = en4Var.g;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = en4Var.h;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = en4Var.j;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        ImageView imageView = en4Var.k;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = en4Var.c;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = en4Var.d;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        GiftMessageExtensionBean giftMessageExtensionBeanN = GiftMessageHelper.N(messageVo.extention, messageVo.isSend);
        if (giftMessageExtensionBeanN == null) {
            en4Var.r.setVisibility(8);
            return;
        }
        en4Var.r.setVisibility(0);
        if ("1".equals(messageVo.data3)) {
            A(en4Var, giftMessageExtensionBeanN);
        } else {
            B(messageVo, en4Var, giftMessageExtensionBeanN);
        }
    }

    public final void z(boolean z, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("report_type", "click");
            jSONObject.put("item_uid", AccountUtils.p(AppContext.getContext()));
            jSONObject.put("giftId", i);
            jSONObject.put("type", z ? 1 : 2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("pagechat_gift_open", null, jSONObject.toString());
    }
}
