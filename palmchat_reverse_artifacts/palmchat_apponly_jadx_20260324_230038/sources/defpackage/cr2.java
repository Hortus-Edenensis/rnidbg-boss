package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import com.zenmen.imageeditengine.ImageEditActivity;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class cr2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16902a;
    public String b;
    public Activity c;
    public String d;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    public boolean h = true;
    public boolean i = false;
    public boolean j = false;
    public int k = 0;
    public Rect l;

    public cr2(Activity activity, String str, String str2) {
        this.c = activity;
        this.f16902a = str;
        this.b = str2;
    }

    public void a() {
        if (this.f16902a == null || !new File(this.f16902a).exists()) {
            sy5.f(this.c, "Invalid image path", 0).g();
            return;
        }
        Intent intent = new Intent(this.c, (Class<?>) ImageEditActivity.class);
        intent.putExtra("EXTRA_STICKER_FOLDER_NAME", this.d);
        intent.putExtra("EXTRA_IS_PAINT_MODE", this.f);
        intent.putExtra("EXTRA_IS_STICKER_MODE", this.g);
        intent.putExtra("EXTRA_IS_TEXT_MODE", this.e);
        intent.putExtra("EXTRA_IS_CROP_MODE", this.h);
        intent.putExtra("EXTRA_HAS_FILTERS", this.i);
        intent.putExtra("EXTRA_IMAGE_PATH", this.f16902a);
        intent.putExtra("EXTRA_CROP_ROTATION", this.k);
        Rect rect = this.l;
        if (rect != null) {
            intent.putExtra("EXTRA_CROP_RECT", rect);
        }
        String str = this.b;
        if (str != null) {
            intent.putExtra("EXTRA_EDITED_PATH", str);
        }
        intent.putExtra("EXTRA_SHOW_SEND_BUTTON", this.j);
        this.c.startActivityForResult(intent, 52);
    }

    public cr2 b(Rect rect) {
        this.l = rect;
        return this;
    }

    public cr2 c(int i) {
        this.k = i;
        return this;
    }

    public cr2 d(boolean z) {
        this.j = z;
        return this;
    }

    public cr2 e(String str) {
        this.d = str;
        this.g = true;
        return this;
    }
}
