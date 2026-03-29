package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.activity.webview.TransparentCordovaWebActivity;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchEndCheckVo;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.paidservices.voicematch.vo.VoiceMatchResult;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class nd3 {
    public void a(VoiceMatchEndCheckVo voiceMatchEndCheckVo) {
        int iB = b();
        int i = voiceMatchEndCheckVo.level;
        if (i <= iB) {
            return;
        }
        SPUtil.f14322a.v(SPUtil.SCENE.APP_COMMON, "key_voicematch_level", Integer.valueOf(i));
        e(voiceMatchEndCheckVo.buildH5Params());
    }

    public final int b() {
        return SPUtil.f14322a.h(SPUtil.SCENE.APP_COMMON, "key_voicematch_level", 1);
    }

    public void c(View view) {
        String str = nl0.q + "/voice-level/";
        Context context = view.getContext();
        Intent intentA = tj6.a(context, str, true, false);
        intentA.putExtra(BaseActionBarActivity.EXTRA_KEY_NEED_BACK2MAINTAB, false);
        context.startActivity(intentA);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(VoiceMatchResult voiceMatchResult) {
        boolean z;
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        sPUtil.v(scene, "key_voicematch_level", Integer.valueOf(voiceMatchResult.level));
        if (Math.abs(sPUtil.k(scene, "KEY_VOICEMATCH_LEVEL_BUBBLE_TIME", 0L) - ir5.b()) >= 86400000) {
            sPUtil.v(scene, "KEY_VOICEMATCH_LEVEL_BUBBLE_TIME", Long.valueOf(ir5.b()));
            z = !TextUtils.isEmpty(voiceMatchResult.marquee);
        }
        ds0.a().b(new ld3(voiceMatchResult.marquee, z, voiceMatchResult.level));
    }

    public final void e(VoiceMatchEndCheckVo.H5Params h5Params) {
        Uri.Builder builderBuildUpon = Uri.parse(nl0.q + "/voice-level/#/levelup").buildUpon();
        builderBuildUpon.appendQueryParameter("level", String.valueOf(h5Params.level));
        String[] strArr = h5Params.privilegeUpgradeImages;
        if (strArr != null && strArr.length > 0) {
            builderBuildUpon.appendQueryParameter("privilegeUpgradeImages", md3.a(",", strArr));
        }
        String string = builderBuildUpon.build().toString();
        Intent intent = new Intent();
        intent.setClass(AppContext.getContext(), TransparentCordovaWebActivity.class);
        intent.addFlags(268435456);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", string);
        bundle.putBoolean("extra_key_full_window", true);
        bundle.putBoolean("hide_progressbar", true);
        intent.putExtras(bundle);
        AppContext.getContext().startActivity(intent);
    }
}
