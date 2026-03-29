package defpackage;

import android.content.Context;
import android.util.Base64;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zenmen.media.msgevent.MediaClientEvent;
import com.zenmen.media.roomchat.RTCParameters;
import com.zenmen.media.roomchatdemo.videocallgroup.d;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bh;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class qn1 implements MediaClientEvent.OnNotifyEventListener, bh.b {
    public static qn1 c;
    public static d d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f20280a = "EventMessageListener";
    public Context b = null;

    public static qn1 a() {
        if (c == null) {
            c = new qn1();
        }
        return c;
    }

    public static void c(d dVar) {
        d = dVar;
    }

    public void b(Context context) {
        this.b = context;
    }

    @Override // com.zenmen.media.msgevent.MediaClientEvent.OnNotifyEventListener
    public void onEventNotify(int i, int i2, int i3, Object obj) {
        try {
            if (i == 2) {
                d.r((String) obj);
                return;
            }
            if (i == 3) {
                d.f0(i2);
                return;
            }
            if (i != 10) {
                if (i == 13) {
                    d.h0(false);
                    return;
                }
                if (i == 313) {
                    d.j0();
                    return;
                }
                if (i == 20180617) {
                    if (i2 != 1042 || obj == null) {
                        return;
                    }
                    try {
                        String str = new String(Base64.decode(obj.toString().getBytes(), 0));
                        if (str.contains("cmd") && str.contains("\"moduleid\":2")) {
                            LogUtil.i(this.f20280a, "Read Data from Socket:" + str);
                            d.y(str);
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                switch (i) {
                    case 23:
                        LogUtil.i(this.f20280a, "用户在说话... ID：" + Long.valueOf(String.valueOf(obj)));
                        return;
                    case 24:
                        break;
                    case 25:
                        d.m0();
                        return;
                    case 26:
                        d.b0((String) obj);
                        return;
                    case 27:
                        d.q((String) obj);
                        return;
                    case 28:
                        d.p0(i2, (String) obj);
                        return;
                    case 29:
                        break;
                    default:
                        switch (i) {
                            case 304:
                                LogUtil.i(this.f20280a, "SKY_SKY logined to Notify server: " + i);
                                break;
                            case 305:
                                LogUtil.i(this.f20280a, "SKY_SKY logined to VOIP cmd server: " + i + ((String) obj));
                                d.h0(true);
                                break;
                            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_PREDELAY /* 306 */:
                                d.u0((String) obj);
                                break;
                            case 307:
                                d.v0((String) obj, i2);
                                break;
                            case MediaPlayer.MEDIA_PLAYER_OPTION_START_PLAY_BUFFER_THRES /* 309 */:
                                d.w0((String) obj);
                                break;
                            case 310:
                                String str2 = (String) obj;
                                int length = str2.length();
                                byte[] bArr = new byte[length / 2];
                                for (int i4 = 0; i4 < length; i4 += 2) {
                                    bArr[i4 / 2] = (byte) ((Character.digit(str2.charAt(i4), 16) << 4) + Character.digit(str2.charAt(i4 + 1), 16));
                                }
                                RTCParameters.n(bArr);
                                break;
                        }
                        return;
                }
                d.l0((String) obj);
                return;
            }
            d.i0(i2);
        } catch (Exception unused) {
        }
    }
}
