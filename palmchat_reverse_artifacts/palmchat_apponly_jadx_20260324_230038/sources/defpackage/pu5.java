package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.TypedValue;
import com.zenmen.square.R$color;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class pu5 extends Drawable {
    public static final int[] i = {R.attr.textAppearance};
    public static final int[] j = {R.attr.textSize, R.attr.typeface, R.attr.textStyle, R.attr.textColor};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Resources f20098a;
    public TextPaint b;
    public StaticLayout c;
    public Path e;
    public ColorStateList f;
    public Layout.Alignment d = Layout.Alignment.ALIGN_NORMAL;
    public CharSequence h = "";
    public Rect g = new Rect();

    public pu5(Context context) {
        this.f20098a = context.getResources();
        TextPaint textPaint = new TextPaint(1);
        this.b = textPaint;
        textPaint.density = this.f20098a.getDisplayMetrics().density;
        this.b.setDither(true);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(i);
        int i2 = -1;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        Typeface typeface = null;
        TypedArray typedArrayObtainStyledAttributes2 = resourceId != -1 ? context.obtainStyledAttributes(resourceId, j) : null;
        ColorStateList colorStateList = null;
        int i3 = -1;
        int dimensionPixelSize = 15;
        if (typedArrayObtainStyledAttributes2 != null) {
            for (int i4 = 0; i4 < typedArrayObtainStyledAttributes2.getIndexCount(); i4++) {
                int index = typedArrayObtainStyledAttributes2.getIndex(i4);
                if (index == 0) {
                    dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dimensionPixelSize);
                } else if (index == 1) {
                    i2 = typedArrayObtainStyledAttributes.getInt(index, i2);
                } else if (index == 2) {
                    i3 = typedArrayObtainStyledAttributes.getInt(index, i3);
                } else if (index == 3) {
                    colorStateList = typedArrayObtainStyledAttributes.getColorStateList(index);
                }
            }
            typedArrayObtainStyledAttributes2.recycle();
        }
        f(colorStateList == null ? ColorStateList.valueOf(-16777216) : colorStateList);
        b(dimensionPixelSize);
        if (i2 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i2 == 2) {
            typeface = Typeface.SERIF;
        } else if (i2 == 3) {
            typeface = Typeface.MONOSPACE;
        }
        j(typeface, i3);
    }

    public final void a() {
        if (this.e != null) {
            this.c = null;
            this.g.setEmpty();
        } else {
            StaticLayout staticLayout = new StaticLayout(this.h, this.b, (int) Math.ceil(Layout.getDesiredWidth(this.h, this.b)), this.d, 1.0f, 0.0f, false);
            this.c = staticLayout;
            this.g.set(0, 0, staticLayout.getWidth(), this.c.getHeight());
        }
        invalidateSelf();
    }

    public final void b(float f) {
        if (f != this.b.getTextSize()) {
            this.b.setTextSize(f);
            a();
        }
    }

    public void c(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.h = charSequence;
        a();
    }

    public void d(Layout.Alignment alignment) {
        if (this.d != alignment) {
            this.d = alignment;
            a();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int iSave = canvas.save();
        canvas.translate(bounds.left, bounds.top);
        if (this.e == null) {
            this.c.draw(canvas);
        } else {
            canvas.drawTextOnPath(this.h.toString(), this.e, 0.0f, 0.0f, this.b);
        }
        canvas.restoreToCount(iSave);
    }

    public void e(int i2) {
        f(ColorStateList.valueOf(i2));
    }

    public void f(ColorStateList colorStateList) {
        this.f = colorStateList;
        k(getState());
    }

    public void g(float f) {
        h(2, f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.g.isEmpty()) {
            return -1;
        }
        Rect rect = this.g;
        return rect.bottom - rect.top;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.g.isEmpty()) {
            return -1;
        }
        Rect rect = this.g;
        return rect.right - rect.left;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.b.getAlpha();
    }

    public void h(int i2, float f) {
        b(TypedValue.applyDimension(i2, f, this.f20098a.getDisplayMetrics()));
    }

    public void i(Typeface typeface) {
        if (this.b.getTypeface() != typeface) {
            this.b.setTypeface(typeface);
            a();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f.isStateful();
    }

    public void j(Typeface typeface, int i2) {
        if (i2 <= 0) {
            this.b.setFakeBoldText(false);
            this.b.setTextSkewX(0.0f);
            i(typeface);
        } else {
            Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i2) : Typeface.create(typeface, i2);
            i(typefaceDefaultFromStyle);
            int i3 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i2;
            this.b.setFakeBoldText((i3 & 1) != 0);
            this.b.setTextSkewX((i3 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    public final boolean k(int[] iArr) {
        int colorForState = this.f.getColorForState(iArr, this.f20098a.getColor(R$color.square_white));
        if (this.b.getColor() == colorForState) {
            return false;
        }
        this.b.setColor(colorForState);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.g.set(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        return k(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (this.b.getAlpha() != i2) {
            this.b.setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.b.getColorFilter() != colorFilter) {
            this.b.setColorFilter(colorFilter);
        }
    }
}
