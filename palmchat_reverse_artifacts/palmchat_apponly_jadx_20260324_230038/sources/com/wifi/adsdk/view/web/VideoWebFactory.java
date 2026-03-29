package com.wifi.adsdk.view.web;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class VideoWebFactory {
    protected static final FrameLayout.LayoutParams COVER_SCREEN_PARAMS = new FrameLayout.LayoutParams(-1, -1);
    private Context context;
    private View customView;
    private WebChromeClient.CustomViewCallback customViewCallback;
    private FrameLayout fullscreenContainer;
    private WebView webView;
    private Window window;

    /* JADX INFO: compiled from: SearchBox */
    public static class FullscreenHolder extends FrameLayout {
        public FullscreenHolder(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(R.color.black));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    public VideoWebFactory(Context context, WebView webView) {
        this.context = context;
        this.window = ((Activity) context).getWindow();
        this.webView = webView;
    }

    public static void fullScreen(Context context) {
        if (context.getResources().getConfiguration().orientation == 1) {
            ((Activity) context).setRequestedOrientation(0);
        } else {
            ((Activity) context).setRequestedOrientation(1);
        }
    }

    private void setStatusBarVisibility(boolean z) {
        this.window.setFlags(z ? 0 : 1024, 1024);
    }

    public View getCustomView() {
        return this.customView;
    }

    public View getVideoLoadingProgressView() {
        FrameLayout frameLayout = new FrameLayout(this.context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    public void hideCustomView() {
        if (this.customView == null) {
            return;
        }
        fullScreen(this.context);
        setStatusBarVisibility(true);
        ((FrameLayout) this.window.getDecorView()).removeView(this.fullscreenContainer);
        this.fullscreenContainer = null;
        this.customView = null;
        this.customViewCallback.onCustomViewHidden();
        this.webView.setVisibility(0);
    }

    public void showCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (this.customView != null) {
            customViewCallback.onCustomViewHidden();
            return;
        }
        fullScreen(this.context);
        this.window.getDecorView();
        FrameLayout frameLayout = (FrameLayout) this.window.getDecorView();
        FullscreenHolder fullscreenHolder = new FullscreenHolder(this.context);
        this.fullscreenContainer = fullscreenHolder;
        FrameLayout.LayoutParams layoutParams = COVER_SCREEN_PARAMS;
        fullscreenHolder.addView(view, layoutParams);
        frameLayout.addView(this.fullscreenContainer, layoutParams);
        this.customView = view;
        setStatusBarVisibility(false);
        this.customViewCallback = customViewCallback;
    }
}
