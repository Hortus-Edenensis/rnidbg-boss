package defpackage;

import com.zenmen.palmchat.framework.mediapick.MediaItem;
import defpackage.ds0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class br2 implements ds0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1806a;
    public MediaItem b;

    public br2(int i, MediaItem mediaItem) {
        this.f1806a = i;
        this.b = mediaItem;
    }

    public static br2 a(int i, MediaItem mediaItem) {
        return new br2(i, mediaItem);
    }
}
