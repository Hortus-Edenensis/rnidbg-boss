package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class x56 extends ImageSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21885a;
    public TextView b;
    public boolean c;
    public int d;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends SimpleTarget<Bitmap> {
        public a() {
        }

        @Override // com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(x56.this.b.getContext().getResources(), x56.d(bitmap, x56.this.d));
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            try {
                Field declaredField = ImageSpan.class.getDeclaredField("mDrawable");
                declaredField.setAccessible(true);
                declaredField.set(x56.this, bitmapDrawable);
                Field declaredField2 = DynamicDrawableSpan.class.getDeclaredField("mDrawableRef");
                declaredField2.setAccessible(true);
                declaredField2.set(x56.this, null);
                x56.this.c = true;
                x56.this.b.setText(x56.this.b.getText());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
            }
        }
    }

    public x56(Context context, TextView textView, String str, int i) {
        super(context, i);
        this.d = context.getResources().getDrawable(i).getIntrinsicHeight();
        this.f21885a = str;
        this.b = textView;
    }

    public static Bitmap d(@NonNull Bitmap bitmap, int i) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = i / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Drawable drawable = getDrawable();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i6 = ((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2);
        canvas.save();
        canvas.translate(f, i6);
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        if (!this.c) {
            hc2.a(this.b.getContext()).asBitmap().load(this.f21885a).into(new a());
        }
        return super.getDrawable();
    }
}
