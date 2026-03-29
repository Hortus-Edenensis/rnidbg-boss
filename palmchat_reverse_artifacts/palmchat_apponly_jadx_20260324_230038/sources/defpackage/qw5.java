package defpackage;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.conversations.threadsnew.headerview.MsgBannerVo;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class qw5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f20339a;
    public Activity b;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends SimpleTarget<GifDrawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f20340a;

        public a(ImageView imageView) {
            this.f20340a = imageView;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(@NonNull GifDrawable gifDrawable, @Nullable Transition<? super GifDrawable> transition) {
            if (gifDrawable != null) {
                ViewGroup.LayoutParams layoutParams = this.f20340a.getLayoutParams();
                layoutParams.height = ((k86.z(qw5.this.b) - k86.e(qw5.this.b, 32.0f)) * gifDrawable.getIntrinsicHeight()) / gifDrawable.getIntrinsicWidth();
                this.f20340a.setLayoutParams(layoutParams);
                gifDrawable.start();
                this.f20340a.setImageDrawable(gifDrawable);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends SimpleTarget<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f20341a;

        public b(ImageView imageView) {
            this.f20341a = imageView;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
            if (bitmap != null) {
                ViewGroup.LayoutParams layoutParams = this.f20341a.getLayoutParams();
                layoutParams.height = ((k86.z(qw5.this.b) - k86.e(qw5.this.b, 32.0f)) * bitmap.getHeight()) / bitmap.getWidth();
                this.f20341a.setLayoutParams(layoutParams);
                this.f20341a.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MsgBannerVo f20342a;

        public c(MsgBannerVo msgBannerVo) {
            this.f20342a = msgBannerVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zn6.b("msg_topResource_click");
            ve.s(qw5.this.b, this.f20342a.url, false);
        }
    }

    public qw5(Activity activity, View view) {
        this.b = activity;
        this.f20339a = view.findViewById(R.id.ai_voice_thread_guide_layout);
    }

    public final boolean b() {
        MsgBannerVo msgBannerVoC = c();
        boolean z = false;
        if (msgBannerVoC.isEnable() && !TeenagersModeManager.a().d()) {
            zn6.b("msg_topResource_show");
            this.f20339a.setVisibility(0);
            d(msgBannerVoC);
            z = true;
        }
        if (!z) {
            this.f20339a.setVisibility(8);
        }
        return z;
    }

    public MsgBannerVo c() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.MSG_BANNER);
        MsgBannerVo msgBannerVo = (dynamicConfig == null || !dynamicConfig.isEnable()) ? null : (MsgBannerVo) dynamicConfig.parseExtra(MsgBannerVo.class);
        return msgBannerVo == null ? new MsgBannerVo() : msgBannerVo;
    }

    public final void d(MsgBannerVo msgBannerVo) {
        ImageView imageView = (ImageView) this.f20339a.findViewById(R.id.img_banner_ai);
        String str = v4.h() ? msgBannerVo.bg_female : msgBannerVo.bg_male;
        if (!TextUtils.isEmpty(str)) {
            if (str.endsWith(".gif")) {
                hc2.a(com.zenmen.palmchat.c.b()).asGif().load(str).into(new a(imageView));
            } else {
                hc2.a(com.zenmen.palmchat.c.b()).asBitmap().load(str).into(new b(imageView));
            }
        }
        imageView.setOnClickListener(new c(msgBannerVo));
    }

    public boolean e(boolean z) {
        if (!z) {
            return b();
        }
        this.f20339a.setVisibility(8);
        return false;
    }
}
