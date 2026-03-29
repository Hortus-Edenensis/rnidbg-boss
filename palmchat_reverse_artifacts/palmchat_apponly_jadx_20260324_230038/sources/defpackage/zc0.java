package defpackage;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zc0 extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22392a;
    public int b;
    public boolean c;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return zc0.a(view, motionEvent);
        }
    }

    public zc0() {
        this.f22392a = -16776961;
        this.b = 0;
        this.c = true;
    }

    public static boolean a(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int totalPaddingLeft = x - textView.getTotalPaddingLeft();
            int totalPaddingTop = y - textView.getTotalPaddingTop();
            int scrollX = totalPaddingLeft + textView.getScrollX();
            int scrollY = totalPaddingTop + textView.getScrollY();
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
            Spannable spannable = (Spannable) textView.getText();
            zc0[] zc0VarArr = (zc0[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, zc0.class);
            if (zc0VarArr.length != 0) {
                if (action == 0) {
                    Selection.setSelection(spannable, spannable.getSpanStart(zc0VarArr[0]), spannable.getSpanEnd(zc0VarArr[0]));
                    zc0VarArr[0].b(false);
                } else {
                    if (action == 1) {
                        zc0VarArr[0].onClick(textView);
                    }
                    zc0VarArr[0].b(true);
                    Selection.removeSelection(spannable);
                }
                return true;
            }
        } else {
            Log.e("ClickableSpanEx", "ClickableSpanEx supports TextView only .");
        }
        return false;
    }

    public void b(boolean z) {
        this.c = z;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.f22392a);
        textPaint.setUnderlineText(false);
        textPaint.bgColor = this.c ? 0 : this.b;
    }

    public zc0(int i, int i2) {
        this.c = true;
        this.f22392a = i;
        this.b = i2;
    }
}
