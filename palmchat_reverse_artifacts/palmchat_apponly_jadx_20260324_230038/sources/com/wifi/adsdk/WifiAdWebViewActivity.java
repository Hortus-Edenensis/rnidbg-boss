package com.wifi.adsdk;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.wifi.ad.core.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class WifiAdWebViewActivity extends Activity {
    private WifiAdWebViewFragment mWkAdDetailFragment;

    @Override // android.app.Activity
    public void finish() {
        if (this.mWkAdDetailFragment.canGoBack()) {
            return;
        }
        super.finish();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_wk_ad);
        FragmentTransaction fragmentTransactionBeginTransaction = getFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.setTransition(4097);
        WifiAdWebViewFragment wifiAdWebViewFragment = (WifiAdWebViewFragment) Fragment.instantiate(this, WifiAdWebViewFragment.class.getName());
        this.mWkAdDetailFragment = wifiAdWebViewFragment;
        fragmentTransactionBeginTransaction.replace(R.id.fragment_container, wifiAdWebViewFragment);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }
}
