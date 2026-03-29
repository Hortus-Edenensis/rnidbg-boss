package defpackage;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.widget.EffectiveShapeView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class l40 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ChatterActivity f18900a;
    public View b;
    public EffectiveShapeView c;
    public EffectiveShapeView d;
    public TextView e;
    public TextView f;
    public ImageView g;
    public boolean h;
    public ContactInfoItem i;
    public ContactInfoItem j;
    public boolean k;

    public l40(ChatterActivity chatterActivity, ChatItem chatItem, View view, boolean z) {
        ContactInfoItem contactInfoItem;
        this.f18900a = chatterActivity;
        this.b = view;
        this.k = z;
        this.h = (chatItem == null || chatItem.getChatType() != 0 || !gu2.f() || a65.e(chatItem) || a65.c(chatItem) || a65.c(v4.f())) ? false : true;
        b();
        if (!this.h || (contactInfoItem = (ContactInfoItem) chatItem) == null) {
            return;
        }
        d(contactInfoItem);
        e(contactInfoItem);
        iu2.b(false, this.i);
    }

    public final float a(ContactInfoItem contactInfoItem) {
        if (contactInfoItem.getIsStranger()) {
            return -1.0f;
        }
        return contactInfoItem.getIntimacyScore();
    }

    public final void b() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
        View viewFindViewById = this.f18900a.findViewById(R.id.title_layout_normal);
        View viewFindViewById2 = this.f18900a.findViewById(R.id.title_layout_intimacy);
        View viewFindViewById3 = this.f18900a.findViewById(R.id.title_layout_aichat);
        EffectiveShapeView effectiveShapeView = (EffectiveShapeView) this.f18900a.findViewById(R.id.avatar1);
        this.c = effectiveShapeView;
        effectiveShapeView.setOnClickListener(this);
        EffectiveShapeView effectiveShapeView2 = (EffectiveShapeView) this.f18900a.findViewById(R.id.avatar2);
        this.d = effectiveShapeView2;
        effectiveShapeView2.setOnClickListener(this);
        this.e = (TextView) this.f18900a.findViewById(R.id.tv_private_chat_type);
        this.f = (TextView) this.f18900a.findViewById(R.id.tv_intimacy_score);
        ImageView imageView = (ImageView) this.f18900a.findViewById(R.id.iv_intimacy);
        this.g = imageView;
        imageView.setOnClickListener(this);
        if (this.k) {
            viewFindViewById.setVisibility(8);
            viewFindViewById2.setVisibility(8);
            viewFindViewById3.setVisibility(0);
            layoutParams.leftMargin = ((me1.g() - me1.b(this.f18900a, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME)) / 2) - me1.b(this.f18900a, 36);
            this.b.setLayoutParams(layoutParams);
            return;
        }
        viewFindViewById3.setVisibility(8);
        if (!this.h) {
            viewFindViewById.setVisibility(0);
            viewFindViewById2.setVisibility(8);
        } else {
            layoutParams.leftMargin = ((me1.g() - me1.b(this.f18900a, 144)) / 2) - me1.b(this.f18900a, 36);
            this.b.setLayoutParams(layoutParams);
            viewFindViewById.setVisibility(8);
            viewFindViewById2.setVisibility(0);
        }
    }

    public boolean c() {
        return this.h;
    }

    public void d(ContactInfoItem contactInfoItem) {
        if (this.h) {
            ContactInfoItem contactInfoItemF = v4.f();
            if (contactInfoItem != null) {
                this.i = contactInfoItem;
            }
            if (contactInfoItemF != null) {
                this.j = contactInfoItemF;
            }
            if (contactInfoItem == null || TextUtils.isEmpty(contactInfoItem.getIconURL()) || contactInfoItemF == null || TextUtils.isEmpty(contactInfoItemF.getIconURL())) {
                return;
            }
            gr2.j().h(k86.p(contactInfoItem.getIconURL()), this.c, a46.l());
            gr2.j().h(k86.p(contactInfoItemF.getIconURL()), this.d, a46.l());
        }
    }

    public void e(ContactInfoItem contactInfoItem) {
        if (contactInfoItem != null) {
            this.i = contactInfoItem;
        }
        float fA = a(contactInfoItem);
        if (fA < 0.0f) {
            this.g.setImageResource(R.drawable.ic_intimacy_state_none);
        } else if (fA == 0.0f) {
            this.g.setImageResource(R.drawable.ic_intimacy_state_0);
        } else if (fA < 100.0f) {
            this.g.setImageResource(R.drawable.ic_intimacy_state_100);
        } else {
            this.g.setImageResource(R.drawable.ic_intimacy_state_max);
        }
        if (fA < 0.0f) {
            this.f.setVisibility(8);
            return;
        }
        String strB = gu2.b(fA, false);
        int length = strB != null ? strB.length() : 0;
        this.f.setText(strB);
        if (length <= 3) {
            this.f.setTextSize(1, 16.0f);
        } else if (length <= 4) {
            this.f.setTextSize(1, 14.0f);
        } else if (fA <= 5.0f) {
            this.f.setTextSize(1, 11.0f);
        } else if (fA <= 6.0f) {
            this.f.setTextSize(1, 9.0f);
        } else if (fA <= 7.0f) {
            this.f.setTextSize(1, 7.0f);
        } else {
            this.f.setTextSize(1, 6.0f);
        }
        this.f.setVisibility(0);
    }

    public void f(String str) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
        if (TextUtils.isEmpty(str)) {
            this.e.setVisibility(8);
            layoutParams.bottomMargin = 0;
        } else {
            this.e.setVisibility(0);
            this.e.setText(str);
            layoutParams.bottomMargin = me1.b(this.f18900a, 8);
        }
        this.g.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.avatar1) {
            ContactInfoItem contactInfoItem = this.i;
            if (contactInfoItem != null) {
                this.f18900a.G3(contactInfoItem);
                return;
            }
            return;
        }
        if (view.getId() == R.id.avatar2) {
            ContactInfoItem contactInfoItem2 = this.j;
            if (contactInfoItem2 != null) {
                this.f18900a.G3(contactInfoItem2);
                return;
            }
            return;
        }
        if (view.getId() == R.id.iv_intimacy) {
            Pair<Integer, Integer> pairA = this.f18900a.m3().A();
            ChatItem chatItemO3 = this.f18900a.o3();
            if (chatItemO3 == null || chatItemO3.getChatType() != 0) {
                return;
            }
            iu2.b(true, this.i);
            gu2.g(this.f18900a, this.i, !((ContactInfoItem) chatItemO3).getIsStranger(), ((Integer) pairA.first).intValue(), ((Integer) pairA.second).intValue(), DomainHelper.m(chatItemO3).domain, chatItemO3.getBizType());
        }
    }
}
