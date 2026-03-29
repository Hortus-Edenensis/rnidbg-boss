package com.baidu.b;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.util.Log;
import com.baidu.mapapi.http.HttpClient;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f3342a;
    private c b;

    public g(Context context, c cVar) {
        this.f3342a = context;
        this.b = cVar;
    }

    private f a() {
        File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
        if (file.exists()) {
            return f.b(com.baidu.b.f.c.a(file));
        }
        return null;
    }

    private f b() {
        return f.a(c("com.baidu.deviceid"), c("bd_setting_i"));
    }

    private String c(String str) {
        try {
            return Settings.System.getString(this.f3342a.getContentResolver(), str);
        } catch (Exception e) {
            com.baidu.b.f.c.a(e);
            return null;
        }
    }

    private String d(String str) {
        return "0";
    }

    private f e(String str) {
        String str2;
        BufferedReader bufferedReader;
        StringBuilder sb;
        String str3 = "";
        File file = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
        if (!file.exists()) {
            file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            sb = new StringBuilder();
        } catch (FileNotFoundException | IOException | Exception unused) {
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            sb.append(line);
            sb.append(HttpClient.NEWLINE);
            str2 = "";
            return f.a(str3, str2);
        }
        bufferedReader.close();
        byte[] bArrA = com.baidu.b.c.a.g.a();
        String[] strArrSplit = new String(com.baidu.b.c.a.c.a(bArrA, bArrA, com.baidu.b.d.a.a(sb.toString().getBytes()))).split(ContainerUtils.KEY_VALUE_DELIMITER);
        if (strArrSplit == null || strArrSplit.length != 2) {
            str2 = "";
        } else {
            str2 = strArrSplit[0];
            try {
                str3 = strArrSplit[1];
            } catch (FileNotFoundException | IOException | Exception unused2) {
            }
        }
        return f.a(str3, str2);
    }

    private f a(Context context) {
        List<b> listB = this.b.b(context);
        f fVarB = null;
        if (listB != null) {
            File filesDir = context.getFilesDir();
            String name = "files";
            if (!"files".equals(filesDir.getName())) {
                Log.e("CuidV266Manager", "fetal error:: app files dir name is unexpectedly :: " + filesDir.getAbsolutePath());
                name = filesDir.getName();
            }
            for (b bVar : listB) {
                if (!bVar.d) {
                    File file = new File(new File(bVar.f3302a.dataDir, name), "libcuid.so");
                    if (file.exists() && (fVarB = f.b(com.baidu.b.f.c.a(file))) != null) {
                        break;
                    }
                }
            }
        }
        return fVarB;
    }

    private boolean b(String str) {
        return this.f3342a.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    public f a(String str) {
        boolean z;
        f fVarA = a(this.f3342a);
        if (fVarA == null) {
            fVarA = f.b(c("com.baidu.deviceid.v2"));
        }
        boolean zB = b(com.kuaishou.weapon.p0.g.i);
        if (fVarA == null && zB) {
            fVarA = a();
        }
        if (fVarA == null) {
            fVarA = b();
        }
        if (fVarA == null && zB) {
            fVarA = e(d(""));
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            d("");
        }
        if (fVarA != null) {
            fVarA.c();
        }
        return fVarA;
    }
}
