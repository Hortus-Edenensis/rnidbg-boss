package com.zenmen.palmchat.chat.aigreeting;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import defpackage.me1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AiLoadingTextView extends TextView {
    private static String DOT = ".";
    private static int MAX_LENGTH = 4;
    private int interval;
    private int interval_change;
    private Runnable loop;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12731a;
        public final /* synthetic */ String b;

        public a(String str, String str2) {
            this.f12731a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            String string = AiLoadingTextView.this.getText().toString();
            if (string == null || !string.equals(this.f12731a)) {
                return;
            }
            AiLoadingTextView.this.setText(this.b);
            AiLoadingTextView.this.setMinWidth((int) (AiLoadingTextView.this.getPaint().measureText(this.b + "...") + me1.b(AiLoadingTextView.this.getContext(), 4)));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AiLoadingTextView.this.updateDote();
            AiLoadingTextView aiLoadingTextView = AiLoadingTextView.this;
            aiLoadingTextView.postDelayed(aiLoadingTextView.loop, AiLoadingTextView.this.interval);
        }
    }

    public AiLoadingTextView(Context context) {
        super(context);
        this.interval = 200;
        this.interval_change = 1000;
        this.loop = new b();
    }

    private static int count(String str, char c) {
        if (str == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == c) {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDote() {
        String string = getText().toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        String strReplace = string.replace(DOT, "");
        int iCount = (count(string, DOT.charAt(0)) + 1) % MAX_LENGTH;
        if (iCount > 0) {
            for (int i = 0; i < iCount; i++) {
                strReplace = strReplace + DOT;
            }
        }
        setText(strReplace);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopLoading();
    }

    public void startLoading(String str, String str2) {
        setText(str);
        setMinWidth((int) (getPaint().measureText(str + "...") + me1.b(getContext(), 4)));
        removeCallbacks(this.loop);
        postDelayed(this.loop, (long) this.interval);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        postDelayed(new a(str, str2), this.interval_change);
    }

    public void stopLoading() {
        removeCallbacks(this.loop);
    }

    public AiLoadingTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.interval = 200;
        this.interval_change = 1000;
        this.loop = new b();
    }

    public AiLoadingTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.interval = 200;
        this.interval_change = 1000;
        this.loop = new b();
    }

    public AiLoadingTextView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.interval = 200;
        this.interval_change = 1000;
        this.loop = new b();
    }
}
