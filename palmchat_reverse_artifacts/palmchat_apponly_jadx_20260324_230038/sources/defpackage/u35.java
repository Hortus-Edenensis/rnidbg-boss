package defpackage;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.photoview.PhotoObject;
import com.zenmen.palmchat.chat.SendMessageActivity;
import com.zenmen.palmchat.route.share.screenshots.ScreenShotItem;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class u35 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f21121a = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            u35.this.c();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            u35.this.c();
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScreenShotItem f21125a;
        public final /* synthetic */ Activity b;

        public d(ScreenShotItem screenShotItem, Activity activity) {
            this.f21125a = screenShotItem;
            this.b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v35.f().i("click", this.f21125a, "share");
            u35.this.g(this.b, this.f21125a);
            u35.this.c();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScreenShotItem f21126a;
        public final /* synthetic */ Activity b;

        public e(ScreenShotItem screenShotItem, Activity activity) {
            this.f21126a = screenShotItem;
            this.b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v35.f().i("click", this.f21126a, "contact");
            u35.this.c();
            ve.o(this.b, "zenxin://activity?page=a0520&uid=2849602035597312", false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements RequestListener<Drawable> {
        public f() {
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
            return false;
        }
    }

    public final void c() {
        View view = this.f21121a;
        if (view != null && view.getParent() != null && this.f21121a.getParent() != null) {
            ((ViewGroup) this.f21121a.getParent()).removeView(this.f21121a);
        }
        this.f21121a = null;
    }

    public final FrameLayout d(Activity activity) {
        try {
            return (FrameLayout) activity.getWindow().getDecorView().findViewById(R.id.content);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void e(Activity activity, ScreenShotItem screenShotItem) {
        LogUtil.i("ScreenShotManager", "onShowScreenShot" + activity);
        if (activity == null || screenShotItem == null) {
            return;
        }
        c();
        v35.f().i("view", screenShotItem, null);
        FrameLayout frameLayoutD = d(activity);
        if (frameLayoutD != null) {
            this.f21121a = f(activity, frameLayoutD, screenShotItem);
            u93.b(5000, new a());
        }
    }

    public final View f(Activity activity, FrameLayout frameLayout, ScreenShotItem screenShotItem) {
        LogUtil.i("ScreenShotManager", "setContentView" + az2.c(screenShotItem));
        View viewInflate = LayoutInflater.from(activity).inflate(com.zenmen.palmchat.R.layout.layout_screenshot_content, (ViewGroup) null);
        viewInflate.setOnTouchListener(new b());
        viewInflate.findViewById(com.zenmen.palmchat.R.id.contentCard).setOnClickListener(new c());
        ImageView imageView = (ImageView) viewInflate.findViewById(com.zenmen.palmchat.R.id.image);
        imageView.setVisibility(screenShotItem.type == 0 ? 0 : 8);
        TextView textView = (TextView) viewInflate.findViewById(com.zenmen.palmchat.R.id.share);
        textView.setText(screenShotItem.type == 0 ? "分享截图" : "分享录屏");
        textView.setOnClickListener(new d(screenShotItem, activity));
        viewInflate.findViewById(com.zenmen.palmchat.R.id.kefu).setOnClickListener(new e(screenShotItem, activity));
        frameLayout.addView(viewInflate, -1, -1);
        hc2.a(AppContext.getContext()).load(k86.p(screenShotItem.getCoverPath())).addListener(new f()).error(com.zenmen.palmchat.R.drawable.media_pick_grid_item_background).into(imageView);
        return viewInflate;
    }

    public final void g(Activity activity, ScreenShotItem screenShotItem) {
        MessageVo messageVoBuildVideoMessage;
        Intent intent = new Intent();
        intent.setClass(activity, SendMessageActivity.class);
        if (screenShotItem.type == 0) {
            PhotoObject photoObject = new PhotoObject();
            photoObject.path = screenShotItem.path;
            messageVoBuildVideoMessage = MessageVo.buildImageMessage(xn3.a(), AccountUtils.p(AppContext.getContext()), photoObject, true, 0, null);
        } else {
            messageVoBuildVideoMessage = MessageVo.buildVideoMessage(xn3.a(), AccountUtils.p(AppContext.getContext()), screenShotItem.path, screenShotItem.thumbPath, screenShotItem.during, 0);
        }
        intent.putExtra("message_vo", messageVoBuildVideoMessage);
        intent.putExtra("extra_from", 4);
        activity.startActivity(intent);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}
