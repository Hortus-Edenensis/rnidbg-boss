package defpackage;

import android.text.InputFilter;
import android.text.Spanned;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class rl1 implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Set<String> f20502a = new HashSet();
    public static Set<Object> b = new HashSet();

    static {
        b(f20502a, 128513, 128591);
        b(f20502a, 9986, 10160);
        b(f20502a, 128640, 128704);
        a(f20502a, 9410);
        b(f20502a, 127344, 127569);
        b(f20502a, 128512, 128566);
        b(f20502a, 128641, 128709);
        b(f20502a, 127757, 128359);
        a(f20502a, 126980);
        a(f20502a, 127183);
        b(f20502a, 127744, 127757);
        b(f20502a, 128507, 128511);
        a(f20502a, 169);
        a(f20502a, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE);
        a(f20502a, 35);
        c(f20502a, 48, 57);
        a(f20502a, 8252);
        a(f20502a, 8265);
        a(f20502a, 8419);
        a(f20502a, 8482);
        a(f20502a, 8505);
        b(f20502a, 8596, 8601);
        b(f20502a, 8617, 8618);
        b(f20502a, 8986, 8987);
        b(f20502a, 9193, 9196);
        a(f20502a, 9200);
        a(f20502a, 9203);
        b(f20502a, 9642, 9643);
        b(f20502a, 9723, 9726);
        b(f20502a, 9728, 9982);
        b(f20502a, 10548, 10549);
        b(f20502a, 11013, 11015);
        b(f20502a, 11035, 11036);
        a(f20502a, 11088);
        a(f20502a, 11093);
        a(f20502a, 12336);
        a(f20502a, 12349);
        a(f20502a, 12951);
        a(f20502a, 12953);
    }

    public static void a(Set<String> set, int i) {
        if (set == null) {
            return;
        }
        f20502a.add(new String(new int[]{i}, 0, 1));
    }

    public static void b(Set<String> set, int i, int i2) {
        if (set != null && i <= i2) {
            while (i <= i2) {
                f20502a.add(new String(new int[]{i}, 0, 1));
                i++;
            }
        }
    }

    public static void c(Set<String> set, int i, int i2) {
        if (set != null && i <= i2) {
            while (i <= i2) {
                f20502a.add(new String(new int[]{i, 8419}, 0, 2));
                i++;
            }
        }
    }

    public boolean d(CharSequence charSequence) {
        return !charSequence.equals("#") && f20502a.contains(charSequence.toString());
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        return (charSequence.equals("#") || !f20502a.contains(charSequence.toString())) ? charSequence : "";
    }
}
