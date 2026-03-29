package defpackage;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeableMethod;
import defpackage.by4;
import defpackage.tp5;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class qz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public StackFrom f20356a = StackFrom.None;
    public int b = 3;
    public int c = 1;
    public float d = 8.0f;
    public float e = 0.95f;
    public float f = 0.3f;
    public float g = 20.0f;
    public List<Direction> h = Direction.HORIZONTAL;
    public List<Direction> i = new ArrayList();
    public boolean j = true;
    public boolean k = true;
    public SwipeableMethod l = SwipeableMethod.AutomaticAndManual;
    public tp5 m = new tp5.a().a();
    public by4 n = new by4.a().a();
    public Interpolator o = new LinearInterpolator();
}
