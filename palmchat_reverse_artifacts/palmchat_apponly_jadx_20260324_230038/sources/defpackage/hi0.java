package defpackage;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.View;
import com.zenmen.palmchat.friendcircle.bean.SquareSimpleComment;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class hi0 extends zc0 {
    public int d;
    public SquareSimpleComment e;
    public r64 f;
    public String g;

    public void c(r64 r64Var) {
        this.f = r64Var;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        r64 r64Var;
        SquareSimpleComment squareSimpleComment = this.e;
        if (squareSimpleComment == null || (r64Var = this.f) == null) {
            return;
        }
        r64Var.a(squareSimpleComment, this.g);
    }

    @Override // defpackage.zc0, android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setTextSize(this.d);
        textPaint.setTypeface(Typeface.DEFAULT);
    }
}
