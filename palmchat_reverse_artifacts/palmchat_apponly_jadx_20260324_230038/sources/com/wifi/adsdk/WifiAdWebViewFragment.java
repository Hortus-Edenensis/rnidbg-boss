package com.wifi.adsdk;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.wifi.ad.core.R;
import com.wifi.adsdk.view.web.WebDelegate;
import com.wifi.adsdk.view.web.WifiWebView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class WifiAdWebViewFragment extends Fragment {
    private ProgressBar mProgressbar;
    private TextView mTitleTv;
    private WifiWebView mWebView;

    private void initView(View view) {
        view.findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.WifiAdWebViewFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                WifiAdWebViewFragment.this.getActivity().finish();
            }
        });
        this.mWebView = (WifiWebView) view.findViewById(R.id.web_view);
        this.mTitleTv = (TextView) view.findViewById(R.id.tv_title);
        this.mProgressbar = (ProgressBar) view.findViewById(R.id.progressbar);
        this.mWebView.setWebDelegate(new WebDelegate() { // from class: com.wifi.adsdk.WifiAdWebViewFragment.2
            @Override // com.wifi.adsdk.view.web.WebDelegate
            public void onPageFinished() {
                WifiAdWebViewFragment.this.mProgressbar.setVisibility(8);
            }

            @Override // com.wifi.adsdk.view.web.WebDelegate
            public void onProgressChanged(int i) {
                WifiAdWebViewFragment.this.mProgressbar.setProgress(i);
            }

            @Override // com.wifi.adsdk.view.web.WebDelegate
            public void onReceivedError() {
                WifiAdWebViewFragment.this.mProgressbar.setVisibility(8);
            }

            @Override // com.wifi.adsdk.view.web.WebDelegate
            public void onPageStarted() {
            }
        });
        setData();
    }

    private void setData() {
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("url");
            String stringExtra2 = intent.getStringExtra("title");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.mWebView.loadUrl(stringExtra);
            }
            this.mTitleTv.setText(stringExtra2);
        }
    }

    public boolean canGoBack() {
        WifiWebView wifiWebView = this.mWebView;
        if (wifiWebView == null) {
            return false;
        }
        boolean zCanGoBack = wifiWebView.canGoBack();
        if (!zCanGoBack) {
            return zCanGoBack;
        }
        this.mWebView.goBack();
        return zCanGoBack;
    }

    @Override // android.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_wk_ad, viewGroup, false);
        initView(viewInflate);
        return viewInflate;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mWebView.stopLoading();
        this.mWebView.destroy();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        this.mWebView.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.mWebView.onResume();
    }
}
