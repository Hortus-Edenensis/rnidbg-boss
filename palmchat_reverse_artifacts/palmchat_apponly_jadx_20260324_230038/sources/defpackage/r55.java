package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.publish.PublishActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class r55 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements c5<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f20392a;
        public final /* synthetic */ int b;

        public a(Activity activity, int i) {
            this.f20392a = activity;
            this.b = i;
        }

        @Override // defpackage.c5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(String str) {
            if (TextUtils.isEmpty(str)) {
                Activity activity = this.f20392a;
                sy5.f(activity, activity.getResources().getString(R.string.message_image_notice_failed), 0).g();
                LogUtil.uploadInfoImmediate("M181", null, null, null);
                return;
            }
            if (!new File(str).exists()) {
                Activity activity2 = this.f20392a;
                sy5.f(activity2, activity2.getResources().getString(R.string.message_image_notice_failed), 0).g();
                LogUtil.uploadInfoImmediate("M181", null, null, null);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("key_from", this.b);
            intent.putExtra("key_publish_type", 2);
            ArrayList arrayList = new ArrayList();
            MediaItem mediaItem = new MediaItem();
            mediaItem.fileFullPath = str;
            arrayList.add(mediaItem);
            intent.putExtra("key_publish_pictures", arrayList);
            intent.setClass(this.f20392a, PublishActivity.class);
            this.f20392a.startActivity(intent);
            LogUtil.uploadInfoImmediate("M180", null, null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements c5<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f20393a;

        public b(Activity activity) {
            this.f20393a = activity;
        }

        @Override // defpackage.c5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Throwable th) {
            Activity activity = this.f20393a;
            sy5.f(activity, activity.getResources().getString(R.string.message_image_notice_failed), 0).g();
            LogUtil.uploadInfoImmediate("M181", null, null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements b5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f20394a;

        public c(Activity activity) {
            this.f20394a = activity;
        }

        @Override // defpackage.b5
        public void call() {
            Activity activity = this.f20394a;
            if (activity instanceof FrameworkBaseActivity) {
                ((FrameworkBaseActivity) activity).hideBaseProgressBar();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements b5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f20395a;

        public d(Activity activity) {
            this.f20395a = activity;
        }

        @Override // defpackage.b5
        public void call() {
            Activity activity = this.f20395a;
            if (activity instanceof FrameworkBaseActivity) {
                ((FrameworkBaseActivity) activity).showBaseProgressBar(activity.getString(R.string.loading), false);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements s42<MessageVo, String> {
        @Override // defpackage.s42
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call(MessageVo messageVo) {
            Bitmap bitmap;
            if (messageVo == null || messageVo.mimeType != 2 || messageVo.attachStatus == 5) {
                return "";
            }
            if (!TextUtils.isEmpty(messageVo.data1) && new File(messageVo.data1).exists()) {
                return messageVo.data1;
            }
            if (!TextUtils.isEmpty(messageVo.data3)) {
                File fileB = sd1.b(messageVo.data3);
                if (fileB != null && fileB.exists() && fileB.length() > 0) {
                    return fileB.getAbsolutePath();
                }
                try {
                    bitmap = hc2.a(AppContext.getContext()).asBitmap().load(k86.p(messageVo.data3)).submit().get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                    bitmap = null;
                }
                if (bitmap != null && !bitmap.isRecycled()) {
                    String strW = xt.w(bitmap, String.valueOf(System.currentTimeMillis()));
                    if (!TextUtils.isEmpty(strW)) {
                        File file = new File(strW);
                        if (file.isFile() && file.exists() && file.length() > 0) {
                            return file.getAbsolutePath();
                        }
                    }
                }
            }
            return "";
        }
    }

    public static n54<String> a(n54<MessageVo> n54Var) {
        return n54Var.h(new e());
    }

    public static void b(Activity activity, int i, n54<String> n54Var) {
        n54Var.u(b35.c()).i(wc.a()).c(new d(activity)).d(new c(activity)).q(new a(activity, i), new b(activity));
    }

    public static void c(Activity activity, MessageVo messageVo, int i) {
        if (activity == null || messageVo == null) {
            return;
        }
        b(activity, i, a(n54.f(messageVo)));
    }
}
