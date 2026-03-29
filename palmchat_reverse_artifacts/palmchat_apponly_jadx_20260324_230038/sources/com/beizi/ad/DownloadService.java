package com.beizi.ad;

import android.app.DownloadManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import com.beizi.ad.internal.e.b;
import com.beizi.ad.internal.e.k;
import com.beizi.ad.lance.ApkBean;
import com.beizi.ad.lance.a.h;
import com.beizi.ad.lance.a.i;
import com.beizi.ad.lance.a.m;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import java.io.File;
import java.util.HashMap;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class DownloadService extends Service {
    private static b.a f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f4323a;
    private String b;
    private DownloadManager c;
    private a d;
    private b e;
    private HashMap<String, ApkBean> g;
    private HashMap<String, Boolean> h;
    private HashMap<Long, String> i;
    private ApkBean j;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ContentObserver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            int[] iArr = {0, 0, 0};
            Cursor cursorQuery = null;
            try {
                try {
                    cursorQuery = DownloadService.this.c.query(new DownloadManager.Query().setFilterById(DownloadService.this.f4323a));
                    if (cursorQuery != null && cursorQuery.moveToFirst()) {
                        int i = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
                        m.a("DownloadService", "onChange status：" + i);
                        if (i == 1) {
                            DownloadService downloadService = DownloadService.this;
                            downloadService.c(downloadService.j);
                        }
                        iArr[0] = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("bytes_so_far"));
                        iArr[1] = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("total_size"));
                        iArr[2] = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
                        m.a("DownloadService", "progress：" + iArr[0] + "/" + iArr[1] + "");
                    }
                    if (cursorQuery == null) {
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (cursorQuery == null) {
                        return;
                    }
                }
                cursorQuery.close();
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                m.a("DownloadService", "onReceived...download finish...begin install！");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                if (DownloadService.this.i != null && DownloadService.this.g != null) {
                    String str = (String) DownloadService.this.i.get(Long.valueOf(longExtra));
                    if (DownloadService.this.h != null) {
                        DownloadService.this.h.put(str, Boolean.FALSE);
                    }
                    ApkBean apkBean = (ApkBean) DownloadService.this.g.get(str);
                    if (apkBean != null) {
                        if (apkBean.getmFollowTrackExt() != null) {
                            k.a(apkBean.getmFollowTrackExt().c());
                        }
                        if (Build.VERSION.SDK_INT < 26) {
                            DownloadService.this.a(context, Long.valueOf(longExtra), apkBean);
                        } else if (context.getPackageManager().canRequestPackageInstalls()) {
                            DownloadService.this.a(context, Long.valueOf(longExtra), apkBean);
                        } else {
                            DownloadService.this.a(context, Long.valueOf(longExtra), apkBean);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        m.a("DownloadService", "DownloadService onCreate()");
        this.c = (DownloadManager) getSystemService("download");
        this.d = new a(new Handler());
        this.e = new b();
        this.g = new HashMap<>();
        this.h = new HashMap<>();
        this.i = new HashMap<>();
        a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        m.a("DownloadService", "DownloadService onDestroy()");
        b();
        c();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Bundle bundleExtra;
        if (intent == null) {
            return 2;
        }
        m.a("DownloadService", "DownloadService onStartCommand()");
        if (intent != null) {
            try {
                if (intent.getExtras() != null && (bundleExtra = intent.getBundleExtra("data")) != null && bundleExtra.containsKey("apkBean")) {
                    this.j = (ApkBean) bundleExtra.getSerializable("apkBean");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        a(this.j);
        return 2;
    }

    private void b() {
        getContentResolver().unregisterContentObserver(this.d);
        unregisterReceiver(this.e);
        m.a("DownloadService", "unregister()");
    }

    private void c() {
        b.a aVar = f;
        if (aVar != null) {
            aVar.a();
        }
        if (this.h != null) {
            this.h = null;
        }
        if (this.g != null) {
            this.g = null;
        }
        if (this.i != null) {
            this.i = null;
        }
        m.a("DownloadService", "releaseResources()");
    }

    private void d(ApkBean apkBean) {
        m.a("DownloadService", "BEGIN_INSTALL!");
        if (apkBean.getmFollowTrackExt() != null) {
            k.a(apkBean.getmFollowTrackExt().d());
        }
    }

    private void a() {
        getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads"), true, this.d);
        registerReceiver(this.e, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
    }

    private synchronized void b(ApkBean apkBean) {
        Uri uriForFile;
        HashMap<String, Boolean> map = this.h;
        if (map != null && map.get(apkBean.getPkgName()) != null && this.h.get(apkBean.getPkgName()).booleanValue()) {
            m.a("DownloadService", "downloading..." + apkBean.getPkgName() + "...please not repeat click");
            Toast.makeText(this, "正在下载…请勿重复点击", 0).show();
            return;
        }
        File file = new File(apkBean.getDownloadPath(), apkBean.getPkgName() + ".zip");
        if (file.exists()) {
            file.delete();
            m.a("DownloadService", "apkCacheFile......remove:" + file.exists());
        }
        File file2 = new File(apkBean.getDownloadPath(), apkBean.getApkName());
        if (file2.exists()) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(268435456);
                intent.setAction("android.intent.action.VIEW");
                if (Build.VERSION.SDK_INT < 24) {
                    uriForFile = Uri.fromFile(file2);
                } else {
                    uriForFile = FileProvider.getUriForFile(this, apkBean.getAuthorities(), file2);
                    intent.addFlags(3);
                }
                if (uriForFile != null) {
                    intent.setDataAndType(uriForFile, AdBaseConstants.MIME_APK);
                    startActivity(intent);
                    d(apkBean);
                }
            } catch (Exception e) {
                Log.d("lance", "apkFile.exists():" + e);
            }
        }
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(apkBean.getApkUrl()));
            request.setTitle(apkBean.getApkTittleName());
            request.setDescription(apkBean.getApkDesc());
            request.setNotificationVisibility(1);
            request.setDestinationUri(Uri.fromFile(file));
            request.setMimeType(AdBaseConstants.MIME_APK);
            this.f4323a = this.c.enqueue(request);
            m.b("DownloadService", "mReqId:" + this.f4323a);
            HashMap<Long, String> map2 = this.i;
            if (map2 != null) {
                map2.put(Long.valueOf(this.f4323a), apkBean.getPkgName());
            }
            HashMap<String, Boolean> map3 = this.h;
            if (map3 != null) {
                map3.put(apkBean.getPkgName(), Boolean.TRUE);
            }
            Toast.makeText(this, "已开始下载…", 0).show();
            m.a("DownloadService", "BEGIN_DOWNLOAD!");
            if (apkBean.getmFollowTrackExt() != null) {
                k.a(apkBean.getmFollowTrackExt().b());
            }
        } catch (Exception e2) {
            Log.d("lance", "DownloadManager download fail:" + e2);
            try {
                if (!TextUtils.isEmpty(apkBean.getApkUrl()) && apkBean.getApkUrl().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    HashMap<String, Boolean> map4 = this.h;
                    if (map4 != null) {
                        map4.put(apkBean.getPkgName(), Boolean.TRUE);
                    }
                    Intent intent2 = new Intent();
                    intent2.setAction("android.intent.action.VIEW");
                    intent2.setData(Uri.parse(apkBean.getApkUrl()));
                    intent2.setFlags(268435456);
                    startActivity(intent2);
                }
            } catch (Exception e3) {
                Log.d("lance", "skip browser fail:" + e3);
            }
        }
    }

    private void a(ApkBean apkBean) {
        if (apkBean == null) {
            return;
        }
        HashMap<String, ApkBean> map = this.g;
        if (map != null) {
            map.put(apkBean.getPkgName(), apkBean);
        }
        HashMap<String, Boolean> map2 = this.h;
        if (map2 != null && map2.get(apkBean.getPkgName()) == null) {
            m.a("DownloadService", "not have package status...");
            this.h.put(apkBean.getPkgName(), Boolean.FALSE);
        }
        if (TextUtils.isEmpty(apkBean.getAuthorities())) {
            this.b = getPackageName() + ".fileprovider";
        } else {
            this.b = apkBean.getAuthorities();
        }
        h.a(apkBean.getDownloadPath());
        b(apkBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ApkBean apkBean) {
        if (apkBean == null) {
            return;
        }
        m.a("DownloadService", "--appUpdate downloadApk start--");
        b.a aVarA = com.beizi.ad.internal.e.b.a();
        f = aVarA;
        aVarA.a(new b.InterfaceC0117b() { // from class: com.beizi.ad.DownloadService.1
            @Override // com.beizi.ad.internal.e.b.InterfaceC0117b
            public void a(long j, long j2) {
            }

            @Override // com.beizi.ad.internal.e.b.InterfaceC0117b
            public void b(File file) {
                m.a("DownloadService", "--appUpdate downloadApk onSuccess--");
                if (DownloadService.this.h != null) {
                    DownloadService.this.h.put(apkBean.getPkgName(), Boolean.FALSE);
                }
                DownloadService.this.a(DownloadService.this.getApplicationContext(), -1L, apkBean);
            }

            @Override // com.beizi.ad.internal.e.b.InterfaceC0117b
            public boolean a(File file) {
                return true;
            }

            @Override // com.beizi.ad.internal.e.b.InterfaceC0117b
            public void a(int i) {
                m.a("DownloadService", "--appUpdate downloadApk onFail--");
                try {
                    String apkUrl = apkBean.getApkUrl();
                    if (TextUtils.isEmpty(apkUrl) || !apkUrl.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                        return;
                    }
                    if (DownloadService.this.h != null) {
                        DownloadService.this.h.put(apkBean.getPkgName(), Boolean.TRUE);
                    }
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(apkUrl));
                    intent.setFlags(268435456);
                    DownloadService.this.startActivity(intent);
                } catch (Exception e) {
                    m.a("DownloadService", "skip browser fail:" + e);
                }
            }
        });
        f.a(new b.d(apkBean.getApkUrl(), apkBean.getDownloadPath(), apkBean.getApkName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, Long l, ApkBean apkBean) {
        Uri uriForFile;
        try {
            File file = new File(apkBean.getDownloadPath(), apkBean.getPkgName() + ".zip");
            if (file.exists()) {
                String fileMD5 = apkBean.getFileMD5();
                String strA = i.a(file.getAbsolutePath());
                if (TextUtils.isEmpty(fileMD5) || fileMD5.equals(strA)) {
                    if (file.exists()) {
                        File file2 = new File(apkBean.getDownloadPath(), apkBean.getApkName());
                        file.renameTo(file2);
                        m.a("DownloadService", "apkFile......raName:" + file2.exists());
                    }
                    Intent intent = new Intent();
                    intent.addFlags(268435456);
                    intent.setAction("android.intent.action.VIEW");
                    int i = Build.VERSION.SDK_INT;
                    if (i < 23) {
                        uriForFile = this.c.getUriForDownloadedFile(l.longValue());
                        if (uriForFile != null) {
                            uriForFile = Uri.parse(uriForFile.toString().replace(".zip", com.huawei.hms.ads.dynamicloader.b.b));
                            m.a("DownloadService", "uri......" + uriForFile);
                        }
                    } else if (i < 24) {
                        File fileA = a(context, l.longValue());
                        if (fileA != null) {
                            uriForFile = Uri.fromFile(fileA);
                            if (uriForFile != null) {
                                uriForFile = Uri.parse(uriForFile.toString().replace(".zip", com.huawei.hms.ads.dynamicloader.b.b));
                                m.a("DownloadService", "uri......" + uriForFile);
                            }
                        } else {
                            uriForFile = null;
                        }
                    } else {
                        uriForFile = FileProvider.getUriForFile(context, this.b, new File(apkBean.getDownloadPath(), apkBean.getApkName()));
                        intent.addFlags(3);
                    }
                    if (uriForFile != null) {
                        intent.setDataAndType(uriForFile, AdBaseConstants.MIME_APK);
                        context.startActivity(intent);
                        d(apkBean);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static File a(Context context, long j) {
        Cursor cursorQuery;
        String path;
        DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
        File file = null;
        if (j != -1) {
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(j);
            query.setFilterByStatus(8);
            if (downloadManager != null && (cursorQuery = downloadManager.query(query)) != null) {
                if (cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("local_uri"));
                    if (!TextUtils.isEmpty(string) && (path = Uri.parse(string).getPath()) != null) {
                        file = new File(path);
                    }
                }
                cursorQuery.close();
            }
        }
        return file;
    }
}
