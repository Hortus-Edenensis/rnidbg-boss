package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.x.n;
import com.ss.android.socialbase.appdownloader.fx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class JumpKllkActivity extends TTDelegateActivity {
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        fx.u((Activity) this);
    }

    @Override // com.ss.android.downloadlib.activity.TTDelegateActivity
    public void u() {
        Intent intent = getIntent();
        if (getIntent() == null) {
            com.ss.android.downloadlib.pn.fx.u().u("handleIntent is null");
            fx.u((Activity) this);
            return;
        }
        String stringExtra = intent.getStringExtra("p");
        long longExtra = intent.getLongExtra("id", 0L);
        if (TextUtils.isEmpty(stringExtra) || longExtra == 0) {
            com.ss.android.downloadlib.pn.fx.u().u("getPackage or id is null");
            fx.u((Activity) this);
        }
        boolean booleanExtra = intent.getBooleanExtra(CmcdConfiguration.KEY_DEADLINE, false);
        String stringExtra2 = intent.getStringExtra("bk");
        if (booleanExtra && (!TextUtils.isEmpty(stringExtra2))) {
            n.u((Context) this, stringExtra, longExtra, stringExtra2, true);
            fx.u((Activity) this);
            return;
        }
        int iOptInt = l.a().optInt("ab", 0);
        n.u(this, stringExtra, longExtra, iOptInt == 1);
        if (iOptInt != 1) {
            fx.u((Activity) this);
        }
    }
}
