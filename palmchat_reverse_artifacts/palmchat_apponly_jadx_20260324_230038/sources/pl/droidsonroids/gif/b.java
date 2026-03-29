package pl.droidsonroids.gif;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RawRes;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f20043a = Arrays.asList("raw", "drawable", "mipmap");

    public static void a(int i, Drawable drawable) {
        if (drawable instanceof pl.droidsonroids.gif.a) {
            ((pl.droidsonroids.gif.a) drawable).h(i);
        }
    }

    public static float b(@NonNull Resources resources, @DrawableRes @RawRes int i) {
        TypedValue typedValue = new TypedValue();
        resources.getValue(i, typedValue, true);
        int i2 = typedValue.density;
        if (i2 == 0) {
            i2 = 160;
        } else if (i2 == 65535) {
            i2 = 0;
        }
        int i3 = resources.getDisplayMetrics().densityDpi;
        if (i2 <= 0 || i3 <= 0) {
            return 1.0f;
        }
        return i3 / i2;
    }

    public static a c(ImageView imageView, AttributeSet attributeSet, int i, int i2) {
        if (attributeSet == null || imageView.isInEditMode()) {
            return new a();
        }
        a aVar = new a(imageView, attributeSet, i, i2);
        int i3 = aVar.b;
        if (i3 >= 0) {
            a(i3, imageView.getDrawable());
            a(i3, imageView.getBackground());
        }
        return aVar;
    }

    public static boolean d(ImageView imageView, Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            imageView.setImageDrawable(new pl.droidsonroids.gif.a(imageView.getContext().getContentResolver(), uri));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean e(ImageView imageView, boolean z, int i) {
        Resources resources = imageView.getResources();
        if (resources != null) {
            try {
                if (!f20043a.contains(resources.getResourceTypeName(i))) {
                    return false;
                }
                pl.droidsonroids.gif.a aVar = new pl.droidsonroids.gif.a(resources, i);
                if (z) {
                    imageView.setImageDrawable(aVar);
                    return true;
                }
                imageView.setBackground(aVar);
                return true;
            } catch (Resources.NotFoundException | IOException unused) {
            }
        }
        return false;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends C1265b {
        public final int c;
        public final int d;

        public a(ImageView imageView, AttributeSet attributeSet, int i, int i2) {
            super(imageView, attributeSet, i, i2);
            this.c = a(imageView, attributeSet, true);
            this.d = a(imageView, attributeSet, false);
        }

        public static int a(ImageView imageView, AttributeSet attributeSet, boolean z) {
            int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", z ? "src" : "background", 0);
            if (attributeResourceValue > 0) {
                if (b.f20043a.contains(imageView.getResources().getResourceTypeName(attributeResourceValue)) && !b.e(imageView, z, attributeResourceValue)) {
                    return attributeResourceValue;
                }
            }
            return 0;
        }

        public a() {
            this.c = 0;
            this.d = 0;
        }
    }

    /* JADX INFO: renamed from: pl.droidsonroids.gif.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C1265b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f20044a;
        public final int b;

        public C1265b(View view, AttributeSet attributeSet, int i, int i2) {
            TypedArray typedArrayObtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R$styleable.GifView, i, i2);
            this.f20044a = typedArrayObtainStyledAttributes.getBoolean(R$styleable.GifView_freezesAnimation, false);
            this.b = typedArrayObtainStyledAttributes.getInt(R$styleable.GifView_loopCount, -1);
            typedArrayObtainStyledAttributes.recycle();
        }

        public C1265b() {
            this.f20044a = false;
            this.b = -1;
        }
    }
}
