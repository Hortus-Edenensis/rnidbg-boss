package defpackage;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.view.View;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.aigreeting.vo.AiGreetingProfileResult;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.kotlin.common.SPUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class c9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f1919a;
    public ChatItem b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f1920a;

        public a(View view) {
            this.f1920a = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f1920a.setVisibility(8);
            c9.this.d();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements io2<LXBaseNetBean<AiGreetingProfileResult>> {
        public b() {
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<AiGreetingProfileResult> lXBaseNetBean, Exception exc) {
            AiGreetingProfileResult aiGreetingProfileResult;
            if (lXBaseNetBean == null || !lXBaseNetBean.isSuccess() || (aiGreetingProfileResult = lXBaseNetBean.data) == null || aiGreetingProfileResult.completeStatus) {
                return;
            }
            c9.this.g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f1922a;

        public c(int i) {
            this.f1922a = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            c9.this.f1919a.setTranslationX(this.f1922a * ((Float) valueAnimator.getAnimatedValue()).floatValue());
            if (c9.this.f1919a.getVisibility() == 8) {
                c9.this.f1919a.setVisibility(0);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c9.this.f1919a.setVisibility(8);
        }
    }

    public c9(ChatItem chatItem, View view) {
        this.b = chatItem;
        this.f1919a = view;
        view.setOnClickListener(new a(view));
        view.setVisibility(8);
    }

    public final void d() {
        Intent intent = new Intent(this.f1919a.getContext(), (Class<?>) m66.c());
        ContactInfoItem contactInfoItem = new ContactInfoItem();
        contactInfoItem.setUid(v4.e(AppContext.getContext()));
        intent.putExtra("user_item_info", contactInfoItem);
        intent.putExtra("from", 35);
        this.f1919a.getContext().startActivity(intent);
    }

    public final boolean e() {
        return !SPUtil.f14322a.a(SPUtil.SCENE.APP_COMMON, k86.a("key_ai_greeting_profile_guide"), false);
    }

    public void f() {
        ChatItem chatItem;
        if (!e() || (chatItem = this.b) == null) {
            return;
        }
        a9.d(chatItem.getChatId(), new b());
    }

    public final void g() {
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, k86.a("key_ai_greeting_profile_guide"), Boolean.TRUE);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfFloat.addUpdateListener(new c(me1.g()));
        valueAnimatorOfFloat.start();
        this.f1919a.postDelayed(new d(), 5000L);
    }
}
