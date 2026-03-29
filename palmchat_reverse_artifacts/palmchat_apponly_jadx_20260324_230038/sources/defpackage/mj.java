package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.net.Uri;
import android.provider.Settings;
import android.util.Pair;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.MimeTypes;
import com.google.android.exoplayer2.m;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class mj {
    public static final mj c = new mj(new int[]{2}, 10);
    public static final ImmutableList<Integer> d = ImmutableList.of(2, 5, 6);
    public static final ImmutableMap<Integer, Integer> e = new ImmutableMap.b().h(5, 6).h(17, 6).h(7, 6).h(30, 10).h(18, 6).h(6, 8).h(8, 8).h(14, 8).d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f19231a;
    public final int b;

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(23)
    public static final class a {
        @DoNotInline
        private static final ImmutableSet<Integer> a() {
            ImmutableSet.a aVarK = new ImmutableSet.a().k(8, 7);
            int i = g86.f17680a;
            if (i >= 31) {
                aVarK.k(26, 27);
            }
            if (i >= 33) {
                aVarK.a(30);
            }
            return aVarK.e();
        }

        @DoNotInline
        public static final boolean b(Context context) {
            AudioDeviceInfo[] devices = ((AudioManager) vh.e((AudioManager) context.getSystemService("audio"))).getDevices(2);
            ImmutableSet<Integer> immutableSetA = a();
            for (AudioDeviceInfo audioDeviceInfo : devices) {
                if (immutableSetA.contains(Integer.valueOf(audioDeviceInfo.getType()))) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(29)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AudioAttributes f19232a = new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build();

        /* JADX WARN: Multi-variable type inference failed */
        @DoNotInline
        public static ImmutableList<Integer> a() {
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            o46 it = mj.e.keySet().iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (g86.f17680a >= 34 || iIntValue != 30) {
                    if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(iIntValue).setSampleRate(48000).build(), f19232a)) {
                        aVarBuilder.a(Integer.valueOf(iIntValue));
                    }
                }
            }
            aVarBuilder.a(2);
            return aVarBuilder.e();
        }

        @DoNotInline
        public static int b(int i, int i2) {
            for (int i3 = 10; i3 > 0; i3--) {
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i).setSampleRate(i2).setChannelMask(g86.G(i3)).build(), f19232a)) {
                    return i3;
                }
            }
            return 0;
        }
    }

    public mj(@Nullable int[] iArr, int i) {
        if (iArr != null) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            this.f19231a = iArrCopyOf;
            Arrays.sort(iArrCopyOf);
        } else {
            this.f19231a = new int[0];
        }
        this.b = i;
    }

    public static boolean b() {
        if (g86.f17680a >= 17) {
            String str = g86.c;
            if ("Amazon".equals(str) || "Xiaomi".equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static mj c(Context context) {
        return d(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    @SuppressLint({"InlinedApi"})
    public static mj d(Context context, @Nullable Intent intent) {
        int i = g86.f17680a;
        if (i >= 23 && a.b(context)) {
            return c;
        }
        ImmutableSet.a aVar = new ImmutableSet.a();
        if (b() && Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) == 1) {
            aVar.l(d);
        }
        if (i >= 29 && (g86.C0(context) || g86.x0(context))) {
            aVar.l(b.a());
            return new mj(ku2.p(aVar.e()), 10);
        }
        if (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 1) {
            ImmutableSet immutableSetE = aVar.e();
            return !immutableSetE.isEmpty() ? new mj(ku2.p(immutableSetE), 10) : c;
        }
        int[] intArrayExtra = intent.getIntArrayExtra("android.media.extra.ENCODINGS");
        if (intArrayExtra != null) {
            aVar.l(ku2.c(intArrayExtra));
        }
        return new mj(ku2.p(aVar.e()), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 10));
    }

    public static int e(int i) {
        int i2 = g86.f17680a;
        if (i2 <= 28) {
            if (i == 7) {
                i = 8;
            } else if (i == 3 || i == 4 || i == 5) {
                i = 6;
            }
        }
        if (i2 <= 26 && "fugu".equals(g86.b) && i == 1) {
            i = 2;
        }
        return g86.G(i);
    }

    @Nullable
    public static Uri g() {
        if (b()) {
            return Settings.Global.getUriFor("external_surround_sound_enabled");
        }
        return null;
    }

    public static int h(int i, int i2) {
        return g86.f17680a >= 29 ? b.b(i, i2) : ((Integer) vh.e(e.getOrDefault(Integer.valueOf(i), 0))).intValue();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof mj)) {
            return false;
        }
        mj mjVar = (mj) obj;
        return Arrays.equals(this.f19231a, mjVar.f19231a) && this.b == mjVar.b;
    }

    @Nullable
    public Pair<Integer, Integer> f(m mVar) {
        int iF = fp3.f((String) vh.e(mVar.l), mVar.i);
        if (!e.containsKey(Integer.valueOf(iF))) {
            return null;
        }
        if (iF == 18 && !j(18)) {
            iF = 6;
        } else if ((iF == 8 && !j(8)) || (iF == 30 && !j(30))) {
            iF = 7;
        }
        if (!j(iF)) {
            return null;
        }
        int iH = mVar.y;
        if (iH == -1 || iF == 18) {
            int i = mVar.z;
            if (i == -1) {
                i = 48000;
            }
            iH = h(iF, i);
        } else if (mVar.l.equals(MimeTypes.AUDIO_DTS_X)) {
            if (iH > 10) {
                return null;
            }
        } else if (iH > this.b) {
            return null;
        }
        int iE = e(iH);
        if (iE == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(iF), Integer.valueOf(iE));
    }

    public int hashCode() {
        return this.b + (Arrays.hashCode(this.f19231a) * 31);
    }

    public boolean i(m mVar) {
        return f(mVar) != null;
    }

    public boolean j(int i) {
        return Arrays.binarySearch(this.f19231a, i) >= 0;
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.b + ", supportedEncodings=" + Arrays.toString(this.f19231a) + "]";
    }
}
