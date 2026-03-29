package com.opos.mobad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.opos.mobad.activity.VideoActivity;
import com.opos.mobad.model.utils.AdHelper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class q implements com.opos.mobad.video.player.d {
    @Override // com.opos.mobad.video.player.d
    public void a(Context context, AdHelper.AdHelperData adHelperData, boolean z, int i, com.opos.mobad.l.a aVar, com.opos.mobad.p.a aVar2, int i2) {
        Intent intent = new Intent();
        intent.setClass(context, VideoActivity.class);
        intent.putExtra(VideoActivity.EXTRA_KEY_AD_HELP_DATA, adHelperData);
        intent.putExtra(VideoActivity.EXTRA_KEY_ACTION_TYPE, i2);
        intent.putExtra(VideoActivity.EXTRA_KEY_BID_PRICE, i);
        Bundle bundle = new Bundle();
        if (aVar != null) {
            bundle.putBinder(VideoActivity.EXTRA_KEY_SHOW_CALLBACK, aVar.asBinder());
        }
        if (aVar2 != null) {
            bundle.putBinder(VideoActivity.EXTRA_KEY_WEB_CALLBACK, aVar2.asBinder());
        }
        if (!bundle.isEmpty()) {
            intent.putExtras(bundle);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    @Override // com.opos.mobad.video.player.d
    public boolean a(Activity activity) {
        return activity != null && com.opos.mobad.cmn.func.b.g.b(activity, VideoActivity.class);
    }

    @Override // com.opos.mobad.video.player.d
    public boolean a(Activity activity, AdHelper.AdHelperData adHelperData, int i, int i2, com.opos.mobad.l.a aVar) {
        if (!a(activity)) {
            return false;
        }
        Intent intent = new Intent(activity, (Class<?>) VideoActivity.class);
        intent.putExtra(VideoActivity.EXTRA_KEY_AD_HELP_DATA, adHelperData);
        intent.putExtra(VideoActivity.EXTRA_KEY_ACTION_TYPE, i2);
        intent.putExtra(VideoActivity.EXTRA_KEY_BID_PRICE, i);
        intent.putExtra(VideoActivity.EXTRA_KEY_SCREEN_MODE, com.opos.cmn.an.h.f.a.a(activity) || (activity.getWindow().getDecorView().getSystemUiVisibility() & 4) == 4);
        Bundle bundle = new Bundle();
        if (aVar != null) {
            bundle.putBinder(VideoActivity.EXTRA_KEY_SHOW_CALLBACK, aVar.asBinder());
        }
        if (!bundle.isEmpty()) {
            intent.putExtras(bundle);
        }
        activity.startActivity(intent);
        com.opos.cmn.an.f.a.b("RewardedVideoAdPlayer", "start inter activity");
        return true;
    }
}
