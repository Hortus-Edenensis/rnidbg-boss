package com.opos.mobad.mediaplayer.a;

import android.content.Context;
import android.text.TextUtils;
import com.oplus.tbl.exoplayer2.util.LibraryLoaderListener;
import com.oplus.tblplayer.TBLPlayerManager;
import com.oplus.tblplayer.config.GlobalsConfig;
import com.oplus.tblplayer.utils.LibraryLoaderDynamic;
import com.oplus.tblplayer.utils.UnZipUtil;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class e {
    public static void a(Context context, String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.d("VideoSoUtils", "empty soPath");
            return;
        }
        try {
            com.opos.cmn.an.f.a.b("VideoSoUtils", "initTblGlobalsWithSoPath " + str);
            LibraryLoaderDynamic.setLibraryLoaderListener(new LibraryLoaderListener() { // from class: com.opos.mobad.mediaplayer.a.e.1
                @Override // com.oplus.tbl.exoplayer2.util.LibraryLoaderListener
                public void loadFailed(String str2) {
                    com.opos.mobad.c.b.e().c().a(4, "dynamicLoad tblSo fail");
                    com.opos.cmn.an.f.a.d("VideoSoUtils", "loadFailed: " + str2);
                }

                @Override // com.oplus.tbl.exoplayer2.util.LibraryLoaderListener
                public void loadSuccess(String str2) {
                    com.opos.cmn.an.f.a.a("VideoSoUtils", "loadSuccess: " + str2);
                }
            });
            TBLPlayerManager.initGlobals(context, new GlobalsConfig.Builder(context).setDynamicSoLoadPath(str).setOkhttpEnable(c.a()).build());
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("VideoSoUtils", "initTblGlobalsWithSoPath error:", e);
        }
    }

    public static boolean a(String str, String str2) {
        try {
            if (!new File(str).exists()) {
                com.opos.cmn.an.f.a.c("VideoSoUtils", "Create dir failed: " + str);
            }
            File file = new File(str2);
            if (file.exists()) {
                f.a(file);
            }
            if (!file.mkdirs()) {
                com.opos.cmn.an.f.a.c("VideoSoUtils", "Create dir failed: " + file);
                return false;
            }
            boolean zUnzip = UnZipUtil.unzip(str, str2);
            com.opos.cmn.an.f.a.b("VideoSoUtils", "unzipResult: " + zUnzip);
            return zUnzip;
        } catch (Exception unused) {
            f.b(str);
            com.opos.mobad.c.b.e().c().a(2, "unzip so fail");
            return false;
        }
    }
}
