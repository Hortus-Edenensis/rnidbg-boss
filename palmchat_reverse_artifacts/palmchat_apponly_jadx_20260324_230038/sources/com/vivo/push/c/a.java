package com.vivo.push.c;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.qq.gdt.action.ActionUtils;
import com.vivo.push.util.ag;
import com.vivo.push.util.t;
import com.vivo.push.util.z;
import com.vivo.push.x;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11218a;
    private HashMap<String, String> b = new HashMap<>();

    public a(Context context) {
        this.f11218a = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.content.ContentProviderClient, android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int g() throws Throwable {
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        if (this.f11218a == null) {
            return 8002;
        }
        if (this.b.size() > 0) {
            return 0;
        }
        Cursor cursorQuery = 0;
        cursorQuery = 0;
        try {
            try {
                int i = Build.VERSION.SDK_INT;
                if (i >= 24) {
                    ContentResolver contentResolver = this.f11218a.getContentResolver();
                    Uri uri = x.f11313a;
                    contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        try {
                            cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uri, null, null, null, null);
                        } catch (Exception e) {
                            e = e;
                            t.a("CoreConfigManager", "provider exception", e);
                            if (0 != 0) {
                                try {
                                    cursorQuery.close();
                                } catch (Exception e2) {
                                    t.a("CoreConfigManager", "close err ", e2);
                                    return AVMDLDataLoader.KeyIsLiveWatchDurationThreshold;
                                }
                            }
                            if (contentProviderClientAcquireUnstableContentProviderClient == null || Build.VERSION.SDK_INT < 24) {
                                return AVMDLDataLoader.KeyIsLiveWatchDurationThreshold;
                            }
                            contentProviderClientAcquireUnstableContentProviderClient.release();
                            return AVMDLDataLoader.KeyIsLiveWatchDurationThreshold;
                        }
                    }
                } else {
                    contentProviderClientAcquireUnstableContentProviderClient = null;
                }
                if (cursorQuery == 0) {
                    cursorQuery = this.f11218a.getContentResolver().query(x.f11313a, null, null, null, null);
                }
                if (cursorQuery == 0) {
                    t.a("CoreConfigManager", "cursor is null");
                    if (cursorQuery != 0) {
                        try {
                            cursorQuery.close();
                        } catch (Exception e3) {
                            t.a("CoreConfigManager", "close err ", e3);
                            return AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes;
                        }
                    }
                    if (contentProviderClientAcquireUnstableContentProviderClient == null || i < 24) {
                        return AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes;
                    }
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                    return AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes;
                }
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("name"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT));
                    if (!TextUtils.isEmpty(string)) {
                        this.b.put(string, string2);
                    }
                }
                try {
                    cursorQuery.close();
                    if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                    }
                } catch (Exception e4) {
                    t.a("CoreConfigManager", "close err ", e4);
                }
                return 0;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        cursorQuery.close();
                    } catch (Exception e5) {
                        t.a("CoreConfigManager", "close err ", e5);
                        throw th;
                    }
                }
                if (0 != 0 && Build.VERSION.SDK_INT >= 24) {
                    cursorQuery.release();
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            contentProviderClientAcquireUnstableContentProviderClient = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            if (0 != 0) {
                cursorQuery.release();
            }
            throw th;
        }
    }

    public final int a() throws Throwable {
        int iB = b(1);
        t.d("CoreConfigManager", "isSupportNewControlStrategies : ".concat(String.valueOf(iB)));
        return iB;
    }

    public final int b() throws Throwable {
        int iB = b(4);
        t.d("CoreConfigManager", "isSupportSyncProfileInfo : ".concat(String.valueOf(iB)));
        return iB;
    }

    public final boolean c() throws Throwable {
        int iB = b(8);
        t.d("CoreConfigManager", "isSupportdeleteRegid : ".concat(String.valueOf(iB)));
        return iB == 0;
    }

    public final boolean d() throws Throwable {
        int iB = b(16);
        t.d("CoreConfigManager", "isSupportQueryCurrentAppState : ".concat(String.valueOf(iB)));
        return iB == 0;
    }

    public final boolean e() throws Throwable {
        int iB = b(32);
        t.d("CoreConfigManager", "isSupportCreateNotifyChannel : ".concat(String.valueOf(iB)));
        return iB == 0;
    }

    public final boolean f() throws Throwable {
        int iB = b(128);
        t.d("CoreConfigManager", "isSupportAliasSubscribeCheck : ".concat(String.valueOf(iB)));
        return iB == 0;
    }

    private int b(int i) throws Throwable {
        int iG = g();
        if (iG != 0) {
            return iG;
        }
        HashMap<String, String> map = this.b;
        if (map == null || map.size() == 0) {
            return AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p;
        }
        String str = this.b.get("pushSupport");
        if (TextUtils.isEmpty(str)) {
            return 2;
        }
        try {
            return (i & Integer.parseInt(str)) > 0 ? 0 : 1;
        } catch (Exception unused) {
            return AVMDLDataLoader.KeyIsLiveCacheThresholdP2pToHttp;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
    
        if (r10 != 4096) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(int i) {
        if (b(i) == 0) {
            return true;
        }
        if ((i == 256 || i == 512 || i == 4096 || i == 1024 || i == 2048) && "com.vivo.pushservice".equals(z.a(this.f11218a))) {
            long jA = ag.a(this.f11218a);
            if (i != 256) {
                if (i != 512) {
                    if (i == 1024) {
                        return jA >= 4200;
                    }
                    if (i == 2048) {
                        return jA >= 4400;
                    }
                }
                return jA >= 4100;
            }
            if (jA >= 3700) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x00ab: MOVE (r3 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:57:0x00ab */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009d A[Catch: Exception -> 0x008b, TRY_ENTER, TryCatch #2 {Exception -> 0x008b, blocks: (B:37:0x0080, B:40:0x0087, B:50:0x009d, B:52:0x00a2, B:54:0x00a6), top: B:69:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str) throws Throwable {
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        Cursor cursorQuery;
        Cursor cursor;
        Cursor cursor2 = null;
        cursor2 = null;
        string = null;
        string = null;
        string = null;
        String string = null;
        try {
            try {
                try {
                } catch (Exception e) {
                    t.a("CoreConfigManager", "queryFromCoreSdk close error", e);
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
            }
        } catch (Exception e2) {
            e = e2;
            contentProviderClientAcquireUnstableContentProviderClient = null;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            contentProviderClientAcquireUnstableContentProviderClient = null;
        }
        if (context == null) {
            t.a("CoreConfigManager", "queryFromCoreSdk context is null");
            return null;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            ContentResolver contentResolver = context.getContentResolver();
            Uri uri = x.f;
            contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                try {
                    t.a("CoreConfigManager", "queryFromCoreSdk client is null");
                    cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uri, null, "queryParameter = ?  ", new String[]{str}, null);
                } catch (Exception e3) {
                    e = e3;
                    cursorQuery = null;
                    t.a("CoreConfigManager", "queryFromCoreSdk error ", e);
                    if (cursorQuery != null) {
                    }
                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                    }
                    return string;
                } catch (Throwable th3) {
                    th = th3;
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e4) {
                            t.a("CoreConfigManager", "queryFromCoreSdk close error", e4);
                            throw th;
                        }
                    }
                    if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                    }
                    throw th;
                }
            } else {
                cursorQuery = null;
            }
        } else {
            contentProviderClientAcquireUnstableContentProviderClient = null;
            cursorQuery = null;
        }
        if (cursorQuery == null) {
            try {
                cursorQuery = context.getContentResolver().query(x.f, null, "queryParameter = ?  ", new String[]{str}, null);
            } catch (Exception e5) {
                e = e5;
                t.a("CoreConfigManager", "queryFromCoreSdk error ", e);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                }
            }
        }
        if (cursorQuery == null) {
            t.a("CoreConfigManager", "queryFromCoreSdk cursor is null");
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception e6) {
                    t.a("CoreConfigManager", "queryFromCoreSdk close error", e6);
                }
            }
            if (contentProviderClientAcquireUnstableContentProviderClient != null && i >= 24) {
                contentProviderClientAcquireUnstableContentProviderClient.release();
            }
            return null;
        }
        string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("queryAppState")) : null;
        cursorQuery.close();
        if (contentProviderClientAcquireUnstableContentProviderClient != null && i >= 24) {
            contentProviderClientAcquireUnstableContentProviderClient.release();
        }
        return string;
    }
}
