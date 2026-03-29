package defpackage;

import android.media.SoundPool;
import com.kuaishou.weapon.p0.t;
import java.io.FileDescriptor;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004J;\u0010\u000e\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0016\u0010\u0013J\b\u0010\u0017\u001a\u00020\u0002H\u0002R\u001c\u0010\u001b\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u001dR \u0010!\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00050\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010 R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010#¨\u0006'"}, d2 = {"Ll15;", "", "", t.l, "()Z", "Ll15$a;", "callBack", "Ljava/io/FileDescriptor;", "fd", "", "offset", "length", "", "priority", "c", "(Ll15$a;Ljava/io/FileDescriptor;JJI)I", "soundId", "", "f", "(I)V", "d", "(I)I", "e", "a", "", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "TAG", "Landroid/media/SoundPool;", "Landroid/media/SoundPool;", "soundPool", "", "Ljava/util/Map;", "soundCallBackMap", "", "F", "volume", "<init>", "()V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class l15 {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static SoundPool soundPool;
    public static final l15 e = new l15();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final String TAG = l15.class.getSimpleName();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final Map<Integer, a> soundCallBackMap = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public static float volume = 1.0f;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b`\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Ll15$a;", "", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
    public interface a {
    }

    public final boolean a() {
        boolean zB = b();
        if (!zB) {
            h63 h63Var = h63.f17877a;
            String TAG2 = TAG;
            Intrinsics.checkExpressionValueIsNotNull(TAG2, "TAG");
            h63Var.b(TAG2, "soundPool is null, you need call init() !!!");
        }
        return zB;
    }

    public final boolean b() {
        return soundPool != null;
    }

    public final int c(a callBack, FileDescriptor fd, long offset, long length, int priority) {
        if (!a()) {
            return -1;
        }
        SoundPool soundPool2 = soundPool;
        if (soundPool2 == null) {
            Intrinsics.throwNpe();
        }
        int iLoad = soundPool2.load(fd, offset, length, priority);
        h63 h63Var = h63.f17877a;
        String TAG2 = TAG;
        Intrinsics.checkExpressionValueIsNotNull(TAG2, "TAG");
        h63Var.a(TAG2, "load soundId=" + iLoad + " callBack=" + callBack);
        if (callBack != null) {
            Map<Integer, a> map = soundCallBackMap;
            if (!map.containsKey(Integer.valueOf(iLoad))) {
                map.put(Integer.valueOf(iLoad), callBack);
            }
        }
        return iLoad;
    }

    public final int d(int soundId) {
        if (!a()) {
            return -1;
        }
        h63 h63Var = h63.f17877a;
        String TAG2 = TAG;
        Intrinsics.checkExpressionValueIsNotNull(TAG2, "TAG");
        h63Var.a(TAG2, "play soundId=" + soundId);
        SoundPool soundPool2 = soundPool;
        if (soundPool2 == null) {
            Intrinsics.throwNpe();
        }
        float f = volume;
        return soundPool2.play(soundId, f, f, 1, 0, 1.0f);
    }

    public final void e(int soundId) {
        if (a()) {
            h63 h63Var = h63.f17877a;
            String TAG2 = TAG;
            Intrinsics.checkExpressionValueIsNotNull(TAG2, "TAG");
            h63Var.a(TAG2, "stop soundId=" + soundId);
            SoundPool soundPool2 = soundPool;
            if (soundPool2 == null) {
                Intrinsics.throwNpe();
            }
            soundPool2.stop(soundId);
        }
    }

    public final void f(int soundId) {
        if (a()) {
            h63 h63Var = h63.f17877a;
            String TAG2 = TAG;
            Intrinsics.checkExpressionValueIsNotNull(TAG2, "TAG");
            h63Var.a(TAG2, "unload soundId=" + soundId);
            SoundPool soundPool2 = soundPool;
            if (soundPool2 == null) {
                Intrinsics.throwNpe();
            }
            soundPool2.unload(soundId);
            soundCallBackMap.remove(Integer.valueOf(soundId));
        }
    }
}
