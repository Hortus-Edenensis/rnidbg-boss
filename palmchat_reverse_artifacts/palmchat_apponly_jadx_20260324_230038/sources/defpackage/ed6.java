package defpackage;

import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ss.android.ttvecamera.TECameraSettings;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ed6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a[] f17282a = {new a("LENOVO Lenovo A830 4.2.2", TECameraSettings.FPS_480, 720)};
    public static String[] b = {"HUAWEI NXT-TL00", "HUAWEI EVA-AL00", "Vivo X9s", "HUAWEI FRD-AL00", "HUAWEI FRD-AL10", "HUAWEI MT7-TL10"};

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17283a;
        public b b;

        public a(String str, int i, int i2) {
            this.f17283a = str;
            this.b = new b(i, i2);
        }
    }

    public static int a() {
        return ("HONOR KOZ-AL40".equals(x86.b()) || "HONOR KOZ-AL00".equals(x86.b()) || g()) ? 21 : -1;
    }

    public static int b(int i, int i2, b bVar) {
        for (a aVar : f17282a) {
            if (aVar.f17283a.equals(x86.b() + " " + x86.c())) {
                b bVar2 = aVar.b;
                bVar.f17284a = bVar2.f17284a;
                bVar.b = bVar2.b;
                return 0;
            }
        }
        if (i2 >= i * 2) {
            bVar.f17284a = TECameraSettings.FPS_480;
            bVar.b = 960;
        } else {
            bVar.f17284a = MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING;
            bVar.b = 960;
        }
        return 0;
    }

    public static int c(int i, b bVar) {
        if (i > 120000) {
            bVar.f17284a = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION;
            bVar.b = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
        } else {
            bVar.f17284a = MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING;
            bVar.b = 960;
            for (a aVar : f17282a) {
                if (aVar.f17283a.equals(x86.b())) {
                    b bVar2 = aVar.b;
                    bVar.f17284a = bVar2.f17284a;
                    bVar.b = bVar2.b;
                }
            }
        }
        return 0;
    }

    public static boolean d() {
        for (String str : b) {
            if (str.equals(x86.b())) {
                return true;
            }
        }
        return false;
    }

    public static boolean e() {
        return "HONOR KOZ-AL00".equals(x86.b()) || f();
    }

    public static boolean f() {
        String[] strArrSplit;
        boolean z = false;
        try {
            String strOptString = vs0.a().getConfig("video_compress").optString("sWEncoder");
            String str = Build.MODEL;
            if (!TextUtils.isEmpty(strOptString) && (strArrSplit = strOptString.split(",")) != null && strArrSplit.length > 0) {
                int length = strArrSplit.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    if (str.equals(strArrSplit[i])) {
                        z = true;
                        break;
                    }
                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LogUtil.i("VideoProperty", "useSWEncoder = " + z);
        return z;
    }

    public static boolean g() {
        String[] strArrSplit;
        boolean z = false;
        try {
            String strOptString = vs0.a().getConfig("video_compress").optString("yuv420");
            String str = Build.MODEL;
            if (!TextUtils.isEmpty(strOptString) && (strArrSplit = strOptString.split(",")) != null && strArrSplit.length > 0) {
                int length = strArrSplit.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    if (str.equals(strArrSplit[i])) {
                        z = true;
                        break;
                    }
                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LogUtil.i("VideoProperty", "useYUV420 = " + z);
        return z;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17284a;
        public int b;

        public b() {
            this.f17284a = 0;
            this.b = 0;
        }

        public b(int i, int i2) {
            this.f17284a = i;
            this.b = i2;
        }
    }
}
