package defpackage;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class s02 {
    public final AssetManager d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final et3<String> f20638a = new et3<>();
    public final Map<et3<String>, Typeface> b = new HashMap();
    public final Map<String, Typeface> c = new HashMap();
    public String e = ".ttf";

    public s02(Drawable.Callback callback, @Nullable r02 r02Var) {
        if (callback instanceof View) {
            this.d = ((View) callback).getContext().getAssets();
        } else {
            m63.c("LottieDrawable must be inside of a view for images to work.");
            this.d = null;
        }
    }

    public final Typeface a(String str) {
        Typeface typeface = this.c.get(str);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceCreateFromAsset = Typeface.createFromAsset(this.d, "fonts/" + str + this.e);
        this.c.put(str, typefaceCreateFromAsset);
        return typefaceCreateFromAsset;
    }

    public Typeface b(String str, String str2) {
        this.f20638a.b(str, str2);
        Typeface typeface = this.b.get(this.f20638a);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceD = d(a(str), str2);
        this.b.put(this.f20638a, typefaceD);
        return typefaceD;
    }

    public final Typeface d(Typeface typeface, String str) {
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        int i = (zContains && zContains2) ? 3 : zContains ? 2 : zContains2 ? 1 : 0;
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }

    public void c(@Nullable r02 r02Var) {
    }
}
