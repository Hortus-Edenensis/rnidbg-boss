package defpackage;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.Duration;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class tp5 implements ge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Direction f21037a;
    public final int b;
    public final Interpolator c;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Direction f21038a = Direction.Right;
        public int b = Duration.Normal.duration;
        public Interpolator c = new AccelerateInterpolator();

        public tp5 a() {
            return new tp5(this.f21038a, this.b, this.c);
        }

        public a b(Direction direction) {
            this.f21038a = direction;
            return this;
        }

        public a c(int i) {
            this.b = i;
            return this;
        }

        public a d(Interpolator interpolator) {
            this.c = interpolator;
            return this;
        }
    }

    @Override // defpackage.ge
    public Direction a() {
        return this.f21037a;
    }

    @Override // defpackage.ge
    public Interpolator b() {
        return this.c;
    }

    @Override // defpackage.ge
    public int getDuration() {
        return this.b;
    }

    public tp5(Direction direction, int i, Interpolator interpolator) {
        this.f21037a = direction;
        this.b = i;
        this.c = interpolator;
    }
}
