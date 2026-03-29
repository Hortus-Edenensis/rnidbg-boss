package com.zenmen.palmchat.utils.urlspan;

import android.graphics.Color;
import android.net.Uri;
import android.os.Parcel;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class MyUrlSpan extends URLSpan {
    private boolean isRight;
    private WeakReference<a> listener;
    private static int colorRight = Color.parseColor("#FFFFFF");
    private static int colorLeft = Color.parseColor("#222222");

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void F(int i, String str, Uri uri, View view);
    }

    public MyUrlSpan(String str) {
        super(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        int i;
        Uri uri = Uri.parse(getURL());
        String url = getURL();
        if (TextUtils.isEmpty(url)) {
            i = 15;
        } else if (url.startsWith("tel:")) {
            i = 4;
        } else {
            String[] strArr = com.zenmen.palmchat.utils.urlspan.a.f15776a;
            if (url.startsWith(strArr[0]) || url.startsWith(strArr[1]) || url.startsWith(strArr[2])) {
                i = 1;
            }
        }
        WeakReference<a> weakReference = this.listener;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.listener.get().F(i, getURL(), uri, view);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (this.isRight) {
            textPaint.setColor(colorRight);
        } else {
            textPaint.setColor(colorLeft);
        }
        textPaint.setUnderlineText(false);
    }

    public MyUrlSpan(Parcel parcel) {
        super(parcel);
    }

    public MyUrlSpan(String str, a aVar, boolean z) {
        super(str);
        this.listener = new WeakReference<>(aVar);
        this.isRight = z;
    }
}
