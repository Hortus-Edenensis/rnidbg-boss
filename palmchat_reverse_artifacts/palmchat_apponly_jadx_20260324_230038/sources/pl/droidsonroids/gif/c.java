package pl.droidsonroids.gif;

import android.content.res.AssetManager;
import android.content.res.Resources;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RawRes;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c {

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AssetManager f20045a;
        public final String b;

        public b(@NonNull AssetManager assetManager, @NonNull String str) {
            super();
            this.f20045a = assetManager;
            this.b = str;
        }

        @Override // pl.droidsonroids.gif.c
        public GifInfoHandle a() throws IOException {
            return new GifInfoHandle(this.f20045a.openFd(this.b));
        }
    }

    /* JADX INFO: renamed from: pl.droidsonroids.gif.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C1266c extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f20046a;
        public final int b;

        public C1266c(@NonNull Resources resources, @DrawableRes @RawRes int i) {
            super();
            this.f20046a = resources;
            this.b = i;
        }

        @Override // pl.droidsonroids.gif.c
        public GifInfoHandle a() throws IOException {
            return new GifInfoHandle(this.f20046a.openRawResourceFd(this.b));
        }
    }

    public abstract GifInfoHandle a() throws IOException;

    public c() {
    }
}
