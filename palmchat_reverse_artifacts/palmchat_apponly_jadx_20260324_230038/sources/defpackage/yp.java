package defpackage;

import androidx.core.view.InputDeviceCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class yp implements hm1 {
    public static char c(char c, int i) {
        int i2 = c + ((i * 149) % 255) + 1;
        return i2 <= 255 ? (char) i2 : (char) (i2 + InputDeviceCompat.SOURCE_ANY);
    }

    @Override // defpackage.hm1
    public void a(km1 km1Var) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        while (true) {
            if (!km1Var.i()) {
                break;
            }
            sb.append(km1Var.c());
            km1Var.f++;
            int iN = uh2.n(km1Var.d(), km1Var.f, b());
            if (iN != b()) {
                km1Var.o(iN);
                break;
            }
        }
        int length = sb.length() - 1;
        int iA = km1Var.a() + length + 1;
        km1Var.q(iA);
        boolean z = km1Var.g().a() - iA > 0;
        if (km1Var.i() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else {
                if (length <= 249 || length > 1555) {
                    throw new IllegalStateException("Message length not in valid ranges: " + length);
                }
                sb.setCharAt(0, (char) ((length / 250) + MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM_TOKEN));
                sb.insert(1, (char) (length % 250));
            }
        }
        int length2 = sb.length();
        for (int i = 0; i < length2; i++) {
            km1Var.r(c(sb.charAt(i), km1Var.a() + 1));
        }
    }

    public int b() {
        return 5;
    }
}
