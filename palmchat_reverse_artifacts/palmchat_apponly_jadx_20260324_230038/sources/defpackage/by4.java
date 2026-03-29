package defpackage;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.Duration;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class by4 implements ge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Direction f1852a;
    public final int b;
    public final Interpolator c;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Direction f1853a = Direction.Bottom;
        public int b = Duration.Normal.duration;
        public Interpolator c = new DecelerateInterpolator();

        public by4 a() {
            return new by4(this.f1853a, this.b, this.c);
        }
    }

    @Override // defpackage.ge
    public Direction a() {
        return this.f1852a;
    }

    @Override // defpackage.ge
    public Interpolator b() {
        return this.c;
    }

    @Override // defpackage.ge
    public int getDuration() {
        return this.b;
    }

    public by4(Direction direction, int i, Interpolator interpolator) {
        this.f1852a = direction;
        this.b = i;
        this.c = interpolator;
    }
}
