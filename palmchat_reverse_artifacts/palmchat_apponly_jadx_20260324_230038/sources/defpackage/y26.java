package defpackage;

import android.content.Context;
import android.graphics.Typeface;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class y26 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleArrayMap<String, Typeface> f22109a = new SimpleArrayMap<>();

    public static Typeface a(Context context, String str) {
        SimpleArrayMap<String, Typeface> simpleArrayMap = f22109a;
        synchronized (simpleArrayMap) {
            if (simpleArrayMap.containsKey(str)) {
                return simpleArrayMap.get(str);
            }
            try {
                Typeface typefaceCreateFromAsset = Typeface.createFromAsset(context.getAssets(), String.format("fonts/%s", str));
                simpleArrayMap.put(str, typefaceCreateFromAsset);
                return typefaceCreateFromAsset;
            } catch (RuntimeException unused) {
                return null;
            }
        }
    }
}
