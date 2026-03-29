package defpackage;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.contacts.ContactInfoItem;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class q8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f20197a;
    public Context b;
    public ImageView f;
    public ImageView g;
    public MaterialDialog h;
    public long i;
    public long j;
    public int k;
    public int l;
    public TextView c = null;
    public TextView d = null;
    public View e = null;
    public boolean m = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            q8.this.g();
            v8.l(q8.this.i + "", "click", 2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            v8.N(q8.this.b, 190107, q8.this.i, q8.this.j, q8.this.k, q8.this.l);
            v8.l(q8.this.i + "", "click", 1);
            q8.this.g();
        }
    }

    public q8(@NonNull Context context) {
        this.f20197a = null;
        this.h = null;
        this.b = context;
        this.f20197a = View.inflate(context, R.layout.layout_ai_chat_buy_toast_dialog, null);
        this.h = new sd3(this.b).p(this.f20197a, false).v(true).d(R.color.transparent).h(false).e();
    }

    public final void g() {
        if (this.m) {
            this.h.dismiss();
        }
    }

    public final void h() {
        this.c = (TextView) this.f20197a.findViewById(R.id.ai_desc_title);
        this.d = (TextView) this.f20197a.findViewById(R.id.ai_button);
        View viewFindViewById = this.f20197a.findViewById(R.id.close_img);
        this.e = viewFindViewById;
        viewFindViewById.setOnClickListener(new a());
        this.d.setOnClickListener(new b());
        this.f = (ImageView) this.f20197a.findViewById(R.id.mine_avatar_img);
        this.g = (ImageView) this.f20197a.findViewById(R.id.other_avatar_img);
    }

    public void i(ChatItem chatItem) {
        if (chatItem == null || !this.m) {
            return;
        }
        try {
            this.l = chatItem.getBizType();
            if (!TextUtils.isEmpty(chatItem.getIconURL())) {
                Glide.with(this.b).load2(chatItem.getIconURL()).error(R.drawable.default_portrait).into(this.g);
            }
            String strP = AccountUtils.p(AppContext.getContext());
            ContactInfoItem contactInfoItemL = bo0.r().l(strP);
            if (!TextUtils.isEmpty(strP)) {
                this.j = Long.parseLong(strP);
            }
            if (!TextUtils.isEmpty(chatItem.getChatId())) {
                this.i = Long.parseLong(chatItem.getChatId());
            }
            if (contactInfoItemL != null) {
                if (!TextUtils.isEmpty(contactInfoItemL.getIconURL())) {
                    Glide.with(this.b).load2(contactInfoItemL.getIconURL()).error(R.drawable.default_portrait).into(this.f);
                }
                this.k = contactInfoItemL.getGender();
            }
            String str = "他？";
            if ((chatItem instanceof ContactInfoItem) && ((ContactInfoItem) chatItem).getGender() == 1) {
                str = "她？";
            }
            String chatName = TextUtils.isEmpty(chatItem.getChatName()) ? "AI虚拟人" : chatItem.getChatName();
            this.c.setText("你对" + chatName + "的守护已结束，是否继续守护" + str);
            StringBuilder sb = new StringBuilder();
            sb.append(this.i);
            sb.append("");
            v8.l(sb.toString(), "view", 0);
        } catch (Exception unused) {
        }
    }

    public void j() {
        Context context = this.b;
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        this.h.show();
        h();
        this.m = true;
    }
}
