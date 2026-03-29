package com.opos.mobad.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.opos.mobad.c.f;
import com.opos.mobad.g;
import com.opos.mobad.l.a;
import com.opos.mobad.l.b;
import com.opos.mobad.model.utils.AdHelper;
import com.opos.mobad.p.a;
import com.opos.mobad.video.player.BaseShowActivity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class VideoActivity extends BaseShowActivity {
    public static final String EXTRA_KEY_ACTION_TYPE = "actionType";
    public static final String EXTRA_KEY_AD_HELP_DATA = "adHelpData";
    public static final String EXTRA_KEY_BID_PRICE = "bidPrice";
    public static final String EXTRA_KEY_SCREEN_MODE = "screenMode";
    public static final String EXTRA_KEY_SHOW_CALLBACK = "adShowCallback";
    public static final String EXTRA_KEY_WEB_CALLBACK = "webShowCallback";
    private static final String TAG = "VideoActivity";

    private void doFinishWithCode(com.opos.mobad.l.a aVar, int i) {
        com.opos.cmn.an.f.a.b(TAG, "handleAction code=", Integer.valueOf(i), ", msg=", com.opos.mobad.ad.a.a(i));
        if (aVar != null) {
            try {
                aVar.a(i, com.opos.mobad.ad.a.a(i));
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
        doFinish();
    }

    private com.opos.mobad.l.a getAdShowCallback(Intent intent) {
        IBinder binder;
        if (intent == null) {
            return null;
        }
        try {
            if (intent.getExtras() == null || (binder = intent.getExtras().getBinder(EXTRA_KEY_SHOW_CALLBACK)) == null) {
                return null;
            }
            return a.AbstractBinderC0751a.a(binder);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c(TAG, "getAdShowCallback", e);
            return null;
        }
    }

    @SuppressLint({"Do not delete"})
    public static Intent getIntent(AdHelper.AdHelperData adHelperData, boolean z, int i, com.opos.mobad.l.a aVar, com.opos.mobad.p.a aVar2, int i2) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_KEY_AD_HELP_DATA, adHelperData);
        intent.putExtra(EXTRA_KEY_ACTION_TYPE, i2);
        intent.putExtra(EXTRA_KEY_BID_PRICE, i);
        Bundle bundle = new Bundle();
        if (aVar != null) {
            bundle.putBinder(EXTRA_KEY_SHOW_CALLBACK, aVar.asBinder());
        }
        if (aVar2 != null) {
            bundle.putBinder(EXTRA_KEY_WEB_CALLBACK, aVar2.asBinder());
        }
        if (!bundle.isEmpty()) {
            intent.putExtras(bundle);
        }
        return intent;
    }

    @SuppressLint({"Do not delete"})
    public static Intent getInterstitialIntent(Activity activity, AdHelper.AdHelperData adHelperData, int i, int i2, com.opos.mobad.l.a aVar) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_KEY_AD_HELP_DATA, adHelperData);
        intent.putExtra(EXTRA_KEY_ACTION_TYPE, i2);
        intent.putExtra(EXTRA_KEY_BID_PRICE, i);
        intent.putExtra(EXTRA_KEY_SCREEN_MODE, com.opos.cmn.an.h.f.a.a(activity) || (activity.getWindow().getDecorView().getSystemUiVisibility() & 4) == 4);
        Bundle bundle = new Bundle();
        if (aVar != null) {
            bundle.putBinder(EXTRA_KEY_SHOW_CALLBACK, aVar.asBinder());
        }
        if (!bundle.isEmpty()) {
            intent.putExtras(bundle);
        }
        return intent;
    }

    private com.opos.mobad.p.a getWebShowCallback(Intent intent) {
        IBinder binder;
        if (intent == null) {
            return null;
        }
        try {
            if (intent.getExtras() == null || (binder = intent.getExtras().getBinder(EXTRA_KEY_WEB_CALLBACK)) == null) {
                return null;
            }
            return a.AbstractBinderC0760a.a(binder);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c(TAG, "getWebShowCallback", e);
            return null;
        }
    }

    @Override // com.opos.mobad.video.player.BaseShowActivity
    public com.opos.mobad.cmn.func.a createInteractor() {
        return new g();
    }

    @Override // com.opos.mobad.video.player.BaseShowActivity
    public void handleAction(Intent intent) {
        if (intent != null) {
            try {
                com.opos.mobad.l.a adShowCallback = getAdShowCallback(intent);
                com.opos.mobad.p.a webShowCallback = getWebShowCallback(intent);
                f fVarJ = com.opos.mobad.c.b.j();
                if (fVarJ != null && fVarJ.a()) {
                    boolean booleanExtra = intent.getBooleanExtra(EXTRA_KEY_SCREEN_MODE, false);
                    int intExtra = intent.getIntExtra(EXTRA_KEY_ACTION_TYPE, -1);
                    int intExtra2 = intent.getIntExtra(EXTRA_KEY_BID_PRICE, 0);
                    AdHelper.AdHelperData adHelperData = (AdHelper.AdHelperData) intent.getParcelableExtra(EXTRA_KEY_AD_HELP_DATA);
                    if (adHelperData == null) {
                        doFinishWithCode(adShowCallback, 10601);
                        return;
                    } else {
                        getAndShow(new com.opos.mobad.c(this, fVarJ.b(), fVarJ.c(), fVarJ.d(), fVarJ.e(), fVarJ.g(), new com.opos.mobad.e.b(getApplicationContext())), adHelperData, intExtra, intExtra2, booleanExtra, new com.opos.mobad.video.player.a.a(adShowCallback, new b.a() { // from class: com.opos.mobad.activity.VideoActivity.1
                            @Override // com.opos.mobad.l.b
                            public void a() throws RemoteException {
                                VideoActivity.this.doFinish();
                            }
                        }), webShowCallback);
                        return;
                    }
                }
                doFinishWithCode(adShowCallback, 10414);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c(TAG, "handleAction", e);
                doFinish();
            }
        }
    }
}
