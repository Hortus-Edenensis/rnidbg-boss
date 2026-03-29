package defpackage;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Pair;
import com.ss.android.ttvecamera.TECameraSettings;
import com.zenmen.palmchat.fileupload.dao.UploadResultVo;
import java.io.File;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class xe6 implements zy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a56 f21941a = new a();
    public a56 b = new b();
    public nu1 c;
    public nu1 d;
    public long e;
    public long f;
    public String g;
    public String h;
    public Context i;
    public ye6 j;
    public UploadResultVo k;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements a56 {
        public a() {
        }

        @Override // defpackage.a56
        public void a(Exception exc) {
            if (xe6.this.j != null) {
                xe6.this.j.a(exc);
            }
        }

        @Override // defpackage.a56
        public void b(UploadResultVo uploadResultVo) {
            xe6.this.k = uploadResultVo;
            xe6.this.c.a(false);
        }

        @Override // defpackage.a56
        public void onProgress(int i, int i2) {
            if (xe6.this.j != null) {
                xe6.this.j.onProgress((int) ((i2 / (xe6.this.e + xe6.this.f)) * 100.0f));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements a56 {
        public b() {
        }

        @Override // defpackage.a56
        public void a(Exception exc) {
            if (xe6.this.j != null) {
                xe6.this.j.a(exc);
            }
        }

        @Override // defpackage.a56
        public void b(UploadResultVo uploadResultVo) {
            xe6.this.i.getContentResolver().delete(ue6.f21200a, "video_thumbnail=? and video_type=2", new String[]{xe6.this.g});
            if (xe6.this.j != null) {
                xe6.this.j.b(new Pair<>(xe6.this.k, uploadResultVo));
            }
        }

        @Override // defpackage.a56
        public void onProgress(int i, int i2) {
            if (xe6.this.j != null) {
                xe6.this.j.onProgress((int) (((((long) i2) + xe6.this.f) / (xe6.this.e + xe6.this.f)) * 100.0f));
            }
        }
    }

    public xe6(String str, File file, File file2, ye6 ye6Var, ExecutorService executorService, String str2, Context context, String str3, boolean z) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = ue6.f21200a;
        Cursor cursorQuery = contentResolver.query(uri, null, "video_thumbnail=? and video_type=2", new String[]{str2}, null);
        if (cursorQuery != null) {
            if (cursorQuery.getCount() == 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(TECameraSettings.Parameters.VIDEO_PATH, file.getAbsolutePath());
                contentValues.put("video_thumbnail", str2);
                contentValues.put("video_type", (Integer) 2);
                context.getContentResolver().insert(uri, contentValues);
            }
            cursorQuery.close();
        }
        this.g = str2;
        this.h = str3;
        this.i = context;
        nu1 nu1Var = new nu1(file, 2, file.getName(), this.b, executorService, str2, context, str3);
        this.c = nu1Var;
        nu1Var.t(str);
        this.c.s(!z);
        this.d = new nu1(file2, 0, true, file2.getName(), this.f21941a, executorService, str2, context, str3);
        this.e = file.length();
        this.f = file2.length();
        this.j = ye6Var;
    }

    @Override // defpackage.zy
    public void cancel() {
        this.d.cancel();
        this.c.cancel();
    }

    public void j() {
        this.d.a(true);
    }
}
