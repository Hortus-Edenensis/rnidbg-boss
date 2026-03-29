package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.zenmen.palmchat.smallvideo.EnterScene;
import com.zenmen.palmchat.smallvideo.SmallVideoEntranceController;
import com.zenmen.palmchat.smallvideo.VideoTabConfig;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.af6;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class kf5 implements qo2 {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18680a;
        public final /* synthetic */ String b;

        public a(String str, String str2) {
            this.f18680a = str;
            this.b = str2;
            put("feed_id", str);
            put("fid", str2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements af6.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f18681a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public b(Context context, String str, int i, String str2, String str3, String str4, String str5) {
            this.f18681a = context;
            this.b = str;
            this.c = i;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
        }

        @Override // af6.b
        public void onFinish(boolean z) {
            if (z) {
                kf5.this.g(this.f18681a, this.b, this.c, this.d, this.e, this.f, this.g);
            } else {
                b65.c();
            }
        }
    }

    @Override // defpackage.qo2
    public void a(Context context, String str, int i, String str2, String str3, String str4, String str5) {
        Log.d("SmallVideoImpl", "jumpToNativeFromShare contentType = " + i + ", contentId = " + str2);
        LogUtil.uploadInfoImmediate("M36_1", new a(str2, str));
        af6.e(context, str2, null, new b(context, str, i, str2, str3, str4, str5));
    }

    @Override // defpackage.qo2
    public boolean b() {
        return false;
    }

    @Override // defpackage.qo2
    public void d(String str, String str2) {
        EnterScene enterScene = EnterScene.SHARE_POP_COPYLINK;
        if (h05.c(str2)) {
            return;
        }
        h05.e(str2);
    }

    @Override // defpackage.qo2
    public String e() {
        VideoTabConfig videoTabConfigD = SmallVideoEntranceController.d();
        return (videoTabConfigD == null || TextUtils.isEmpty(videoTabConfigD.iconUrl)) ? "https://palmchat.cdn.lianxinapp.com/static/resource/logo/wine/w6.png" : videoTabConfigD.iconUrl;
    }

    public final void g(Context context, String str, int i, String str2, String str3, String str4, String str5) {
        EnterScene enterScene = EnterScene.LX_FRIEND;
        if (h05.c(str5)) {
            enterScene = EnterScene.LX_FRIEND_H;
        } else if (h05.e(str5)) {
            enterScene = EnterScene.LX_FRIEND_S;
        }
        SmallVideoEntranceController.k(context, i, str2, str3, str4, enterScene, null);
    }

    @Override // defpackage.qo2
    public void c(Context context, String str) {
    }
}
