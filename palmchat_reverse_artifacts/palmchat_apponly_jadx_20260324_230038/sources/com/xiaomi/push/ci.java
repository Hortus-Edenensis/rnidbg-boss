package com.xiaomi.push;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.lantern.auth.app.FunDC;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public abstract class ci {

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends ch {
        public a() {
            super(1);
        }

        @Override // com.xiaomi.push.ch
        public String a(Context context, String str, List<at> list) {
            if (list == null) {
                return au.a(context, new URL(str));
            }
            Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
            for (at atVar : list) {
                builderBuildUpon.appendQueryParameter(atVar.a(), atVar.b());
            }
            return au.a(context, new URL(builderBuildUpon.toString()));
        }
    }

    public static String a(Context context, String str, List<at> list) {
        return a(context, str, list, new a(), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00aa A[Catch: MalformedURLException -> 0x00c3, TRY_ENTER, TryCatch #4 {MalformedURLException -> 0x00c3, blocks: (B:4:0x000f, B:6:0x0016, B:8:0x0020, B:11:0x0027, B:13:0x002d, B:14:0x0030, B:15:0x0035, B:17:0x003b, B:19:0x0044, B:21:0x004c, B:49:0x00aa, B:50:0x00bc), top: B:64:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str, List<at> list, ch chVar, boolean z) {
        cc ccVar;
        IOException iOException;
        String str2;
        String str3;
        if (au.m175a(context)) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                if (z) {
                    cc ccVarM253a = cg.a().m253a(str);
                    if (ccVarM253a != null) {
                        arrayList = ccVarM253a.a(str);
                    }
                    ccVar = ccVarM253a;
                } else {
                    ccVar = null;
                }
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
                String str4 = null;
                for (String str5 : arrayList) {
                    ArrayList arrayList2 = list != null ? new ArrayList(list) : null;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                    } catch (IOException e) {
                        iOException = e;
                        str2 = str4;
                    }
                    if (!chVar.m263a(context, str5, (List<at>) arrayList2)) {
                        return str4;
                    }
                    String strA = chVar.a(context, str5, (List<at>) arrayList2);
                    try {
                    } catch (IOException e2) {
                        e = e2;
                        str3 = strA;
                    }
                    if (!TextUtils.isEmpty(strA)) {
                        if (ccVar != null) {
                            try {
                                ccVar.a(str5, System.currentTimeMillis() - jCurrentTimeMillis, a(chVar, str5, arrayList2, strA));
                            } catch (IOException e3) {
                                iOException = e3;
                                str2 = strA;
                                if (ccVar != null) {
                                    ccVar.a(str5, System.currentTimeMillis() - jCurrentTimeMillis, a(chVar, str5, arrayList2, str2), iOException);
                                }
                                iOException.printStackTrace();
                                str4 = str2;
                            }
                        }
                        return strA;
                    }
                    if (ccVar != null) {
                        str3 = strA;
                        try {
                            ccVar.a(str5, System.currentTimeMillis() - jCurrentTimeMillis, a(chVar, str5, arrayList2, strA), null);
                        } catch (IOException e4) {
                            e = e4;
                            String str6 = str3;
                            iOException = e;
                            str2 = str6;
                            if (ccVar != null) {
                            }
                            iOException.printStackTrace();
                            str4 = str2;
                        }
                    } else {
                        str3 = strA;
                    }
                    str4 = str3;
                }
                return str4;
            } catch (MalformedURLException e5) {
                e5.printStackTrace();
            }
        }
        return null;
    }

    private static int a(ch chVar, String str, List<at> list, String str2) {
        if (chVar.a() == 1) {
            return a(str.length(), a(str2));
        }
        if (chVar.a() != 2) {
            return -1;
        }
        return a(str.length(), a(list), a(str2));
    }

    public static int a(List<at> list) {
        int length = 0;
        for (at atVar : list) {
            if (!TextUtils.isEmpty(atVar.a())) {
                length += atVar.a().length();
            }
            if (!TextUtils.isEmpty(atVar.b())) {
                length += atVar.b().length();
            }
        }
        return length * 2;
    }

    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return 0;
        }
    }

    public static int a(int i, int i2) {
        return (((i2 + MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE) / 1448) * MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA) + FunDC.ID_AUTH_1080 + i + i2;
    }

    public static int a(int i, int i2, int i3) {
        return (((i2 + 200) / 1448) * MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA) + 1011 + i2 + i + i3;
    }
}
