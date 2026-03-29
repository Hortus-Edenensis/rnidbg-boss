package com.bytedance.sdk.component.widget.web;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.sdk.component.mv.fx;
import com.bytedance.sdk.component.mv.nr;
import com.bytedance.sdk.component.utils.jk;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class BizWebView extends MultiWebview implements fx {
    public BizWebView(Context context) {
        super(context);
    }

    private void nr(Runnable runnable) {
        jk.nr().post(runnable);
    }

    @Override // com.bytedance.sdk.component.widget.web.MultiWebview
    public void I_() {
        super.I_();
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void addJavascriptInterface(final Object obj, final String str) {
        if (this.nr != null) {
            this.nr.addJavascriptInterface(obj, str);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.addJavascriptInterface(obj, str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public boolean canGoBack() {
        if (this.nr != null) {
            if (this.nr.canGoBack()) {
                return true;
            }
            if (getWebViewCount() > 1 && u() != null) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void clearCache(boolean z) {
        if (this.nr != null) {
            this.nr.clearCache(z);
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void clearHistory() {
        if (this.nr != null) {
            this.nr.clearHistory();
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void clearView() {
        if (this.nr != null) {
            this.nr.clearView();
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.mv.fx
    public void computeScroll() {
        if (this.nr != null) {
            this.nr.computeScroll();
            return;
        }
        AtomicInteger atomicInteger = this.u;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.28
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.nr != null) {
                    BizWebView.this.nr.computeScroll();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.widget.web.MultiWebview, com.bytedance.sdk.component.mv.fx
    public void destroy() {
        super.destroy();
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        if (this.nr != null) {
            this.nr.evaluateJavascript(str, valueCallback);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.7
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.evaluateJavascript(str, valueCallback);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public int getContentHeight() {
        if (this.nr != null) {
            return this.nr.getContentHeight();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public int getProgress() {
        if (this.nr != null) {
            return this.nr.getProgress();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public String getUrl() {
        return this.nr != null ? this.nr.getUrl() : "";
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public String getUserAgentString() {
        return this.nr != null ? this.nr.getUserAgentString() : "";
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public WebView getWebView() {
        if (this.nr != null) {
            return this.nr.getWebView();
        }
        if (pn()) {
            return null;
        }
        long j = 500;
        while (this.u.get() < 3 && j > 0) {
            try {
                Thread.sleep(10L);
                j -= 10;
            } catch (Exception unused) {
            }
        }
        if (this.nr != null) {
            return this.nr.getWebView();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void goBack() {
        if (this.nr != null) {
            this.nr.goBack();
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void loadUrl(final String str) {
        if (this.nr != null) {
            this.nr.loadUrl(str);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.22
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.loadUrl(str);
                    }
                }
            });
        }
    }

    public void onPause() {
        if (this.nr != null) {
            this.nr.onPause();
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void onResume() {
        if (this.nr != null) {
            this.nr.onResume();
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void pauseTimers() {
        if (this.nr != null) {
            this.nr.pauseTimers();
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void removeJavascriptInterface(String str) {
        fx fxVar = this.nr;
        if (fxVar != null) {
            fxVar.removeJavascriptInterface(str);
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void resumeTimers() {
        if (this.nr != null) {
            this.nr.resumeTimers();
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void setAllowFileAccess(final boolean z) {
        if (this.nr != null) {
            this.nr.setAllowFileAccess(z);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.20
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.setAllowFileAccess(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void setAllowFileAccessFromFileURLs(final boolean z) {
        if (this.nr != null) {
            this.nr.setAllowFileAccessFromFileURLs(z);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.23
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.setAllowFileAccessFromFileURLs(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void setAllowUniversalAccessFromFileURLs(final boolean z) {
        if (this.nr != null) {
            this.nr.setAllowUniversalAccessFromFileURLs(z);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.24
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.setAllowFileAccessFromFileURLs(z);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.mv.fx
    public void setAlpha(final float f) {
        super.setAlpha(f);
        if (this.nr != null) {
            this.nr.setAlpha(f);
            return;
        }
        AtomicInteger atomicInteger = this.u;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.32
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.nr != null) {
                    BizWebView.this.nr.setAlpha(f);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void setAppCacheEnabled(final boolean z) {
        if (this.nr != null) {
            this.nr.setAppCacheEnabled(z);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.8
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.setAppCacheEnabled(z);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.mv.fx
    public void setBackgroundColor(final int i) {
        super.setBackgroundColor(i);
        if (this.nr != null) {
            this.nr.setBackgroundColor(i);
            return;
        }
        AtomicInteger atomicInteger = this.u;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.27
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.nr != null) {
                    BizWebView.this.nr.setBackgroundColor(i);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void setBlockNetworkImage(final boolean z) {
        if (this.nr != null) {
            this.nr.setBlockNetworkImage(z);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.21
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.setBlockNetworkImage(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void setBuiltInZoomControls(final boolean z) {
        if (this.nr != null) {
            this.nr.setBuiltInZoomControls(z);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.13
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.setBuiltInZoomControls(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void setCacheMode(final int i) {
        if (this.nr != null) {
            this.nr.setCacheMode(i);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.setCacheMode(i);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void setDatabaseEnabled(final boolean z) {
        if (this.nr != null) {
            this.nr.setDatabaseEnabled(z);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.19
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.setDatabaseEnabled(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void setDefaultFontSize(final int i) {
        if (this.nr != null) {
            this.nr.setDefaultFontSize(i);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.17
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.setDefaultFontSize(i);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void setDefaultTextEncodingName(final String str) {
        if (this.nr != null) {
            this.nr.setDefaultTextEncodingName(str);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.16
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.setDefaultTextEncodingName(str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void setDisplayZoomControls(final boolean z) {
        if (this.nr != null) {
            this.nr.setDisplayZoomControls(z);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.5
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.setDisplayZoomControls(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void setDomStorageEnabled(final boolean z) {
        if (this.nr != null) {
            this.nr.setDomStorageEnabled(z);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.12
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.setDomStorageEnabled(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void setDownloadListener(final DownloadListener downloadListener) {
        if (this.nr != null) {
            this.nr.setDownloadListener(downloadListener);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.37
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.setDownloadListener(downloadListener);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void setJavaScriptCanOpenWindowsAutomatically(final boolean z) {
        if (this.nr != null) {
            this.nr.setJavaScriptCanOpenWindowsAutomatically(z);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.11
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.setJavaScriptCanOpenWindowsAutomatically(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void setJavaScriptEnabled(final boolean z) {
        if (this.nr != null) {
            this.nr.setJavaScriptEnabled(z);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.setJavaScriptEnabled(z);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.mv.fx
    public void setLayerType(final int i, final Paint paint) {
        if (this.nr != null) {
            this.nr.setLayerType(i, paint);
            return;
        }
        AtomicInteger atomicInteger = this.u;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.29
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.nr != null) {
                    BizWebView.this.nr.setLayerType(i, paint);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void setLayoutAlgorithm(final WebSettings.LayoutAlgorithm layoutAlgorithm) {
        if (this.nr != null) {
            this.nr.setLayoutAlgorithm(layoutAlgorithm);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.14
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.setLayoutAlgorithm(layoutAlgorithm);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void setLoadWithOverviewMode(final boolean z) {
        if (this.nr != null) {
            this.nr.setLoadWithOverviewMode(z);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.15
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.setLoadWithOverviewMode(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void setMediaPlaybackRequiresUserGesture(final boolean z) {
        if (this.nr != null) {
            this.nr.setMediaPlaybackRequiresUserGesture(z);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.26
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.setMediaPlaybackRequiresUserGesture(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void setMixedContentMode(final int i) {
        if (this.nr != null) {
            this.nr.setMixedContentMode(i);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.18
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.setMixedContentMode(i);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void setNetworkAvailable(final boolean z) {
        if (this.nr != null) {
            this.nr.setNetworkAvailable(z);
            return;
        }
        AtomicInteger atomicInteger = this.u;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.nr != null) {
                    BizWebView.this.nr.setNetworkAvailable(z);
                }
            }
        });
    }

    @Override // android.view.View, com.bytedance.sdk.component.mv.fx
    public void setOnScrollChangeListener(final View.OnScrollChangeListener onScrollChangeListener) {
        if (this.nr != null) {
            this.nr.setOnScrollChangeListener(onScrollChangeListener);
            return;
        }
        AtomicInteger atomicInteger = this.u;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.33
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.nr != null) {
                    BizWebView.this.nr.setOnScrollChangeListener(onScrollChangeListener);
                }
            }
        });
    }

    @Override // android.view.View, com.bytedance.sdk.component.mv.fx
    public void setOverScrollMode(final int i) {
        super.setOverScrollMode(i);
        if (this.nr != null) {
            this.nr.setOverScrollMode(i);
            return;
        }
        AtomicInteger atomicInteger = this.u;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.30
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.nr != null) {
                    BizWebView.this.nr.setOverScrollMode(i);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void setSavePassword(final boolean z) {
        if (this.nr != null) {
            this.nr.setSavePassword(z);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.25
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.setSavePassword(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void setSupportZoom(final boolean z) {
        if (this.nr != null) {
            this.nr.setSupportZoom(z);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.9
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.setSupportZoom(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.mv.nr
    public void setTouchEventListener(final nr.u uVar) {
        if (this.nr != null) {
            this.nr.setTouchEventListener(uVar);
            return;
        }
        AtomicInteger atomicInteger = this.u;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.34
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.nr != null) {
                    BizWebView.this.nr.setTouchEventListener(uVar);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void setUseWideViewPort(final boolean z) {
        if (this.nr != null) {
            this.nr.setUseWideViewPort(z);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.10
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.setUseWideViewPort(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void setUserAgentString(final String str) {
        if (this.nr != null) {
            this.nr.setUserAgentString(str);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.35
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.setUserAgentString(str);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.mv.fx
    public void setVisibility(final int i) {
        super.setVisibility(i);
        if (this.nr != null) {
            this.nr.setVisibility(i);
            return;
        }
        AtomicInteger atomicInteger = this.u;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.31
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.nr != null) {
                    BizWebView.this.nr.setVisibility(i);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void setWebChromeClient(final WebChromeClient webChromeClient) {
        if (this.nr != null) {
            this.nr.setWebChromeClient(webChromeClient);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.setWebChromeClient(webChromeClient);
                    }
                }
            });
        }
    }

    public void setWebViewClient(final WebViewClient webViewClient) {
        if (this.nr != null) {
            this.nr.setWebViewClient(webViewClient);
        } else if (this.u.get() < 3) {
            nr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.36
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.nr != null) {
                        BizWebView.this.nr.setWebViewClient(webViewClient);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public void u(String str, String str2, Object obj) {
        if (this.nr != null) {
            this.nr.u(str, str2, obj);
        }
    }

    @Override // com.bytedance.sdk.component.mv.fx
    public View getView() {
        return this;
    }
}
