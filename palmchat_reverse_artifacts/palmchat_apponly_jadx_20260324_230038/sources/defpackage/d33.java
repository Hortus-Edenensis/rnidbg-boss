package defpackage;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class d33 extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16967a;
    public final int b;
    public final boolean c;
    public final a d;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(String str);
    }

    public d33(String str, int i, boolean z, a aVar) {
        this.f16967a = str;
        this.b = i;
        this.c = z;
        this.d = aVar;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@NonNull View view) {
        a aVar = this.d;
        if (aVar != null) {
            aVar.a(this.f16967a);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.b);
        textPaint.setUnderlineText(this.c);
    }
}
