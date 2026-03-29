package defpackage;

import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import com.afollestad.materialdialogs.GravityEnum;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ew5 {
    public static ew5 v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f17381a = false;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public int g = 0;
    public int h = 0;
    public Drawable i = null;
    public int j = 0;
    public int k = 0;

    @DrawableRes
    public int l = 0;

    @DrawableRes
    public int m = 0;

    @DrawableRes
    public int n = 0;

    @DrawableRes
    public int o = 0;

    @DrawableRes
    public int p = 0;
    public GravityEnum q;
    public GravityEnum r;
    public GravityEnum s;
    public GravityEnum t;
    public GravityEnum u;

    public ew5() {
        GravityEnum gravityEnum = GravityEnum.START;
        this.q = gravityEnum;
        this.r = gravityEnum;
        this.s = gravityEnum;
        this.t = gravityEnum;
        this.u = gravityEnum;
    }

    public static ew5 a() {
        return b(true);
    }

    public static ew5 b(boolean z) {
        if (v == null && z) {
            v = new ew5();
        }
        return v;
    }
}
