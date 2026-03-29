package com.zenmen.palmchat.ui.widget.praisewidget;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import androidx.annotation.NonNull;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.greendao.model.Comment;
import defpackage.fk2;
import defpackage.k36;
import defpackage.n5;
import defpackage.zc0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class a extends zc0 {
    public Context d;
    public int e;
    public Comment f;

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15643a;
        public Context b;
        public int c = 16;
        public Comment d;
        public int e;

        public b(Context context, @NonNull Comment comment) {
            this.b = context;
            this.d = comment;
        }

        public a f() {
            return new a(this);
        }

        public b g(int i) {
            this.e = i;
            return this;
        }

        public b h(int i) {
            this.f15643a = i;
            return this;
        }

        public b i(int i) {
            this.c = k36.j(i);
            return this;
        }
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        fk2.a aVar = new fk2.a();
        Bundle bundle = new Bundle();
        bundle.putString(DeviceInfoUtil.UID_TAG, this.f.getCommentUid());
        aVar.b(bundle);
        this.d.startActivity(n5.a(this.d, aVar));
    }

    @Override // defpackage.zc0, android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setTextSize(this.e);
        textPaint.setTypeface(Typeface.DEFAULT);
    }

    public a(b bVar) {
        super(bVar.f15643a, bVar.e);
        this.d = bVar.b;
        this.f = bVar.d;
        this.e = bVar.c;
    }
}
