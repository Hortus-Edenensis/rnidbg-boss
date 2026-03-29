package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.zenmen.palmchat.utils.ImageUtils.NewCropImageActivity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class dr0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Intent f17127a;

    public dr0(Uri uri) {
        Intent intent = new Intent();
        this.f17127a = intent;
        intent.setData(uri);
    }

    public dr0 a(boolean z) {
        this.f17127a.putExtra("aspect_x", 1);
        this.f17127a.putExtra("aspect_y", 1);
        this.f17127a.putExtra("head_portrait", z);
        return this;
    }

    public Intent b(Context context) {
        this.f17127a.setClass(context, NewCropImageActivity.class);
        return this.f17127a;
    }

    public dr0 c(int i) {
        this.f17127a.putExtra("max_size", i);
        return this;
    }

    public dr0 d(Uri uri) {
        this.f17127a.putExtra("output", uri);
        return this;
    }

    public dr0 e(float f) {
        this.f17127a.putExtra("ratio", f);
        return this;
    }

    public void f(Activity activity) {
        g(activity, 6709);
    }

    public void g(Activity activity, int i) {
        activity.startActivityForResult(b(activity), i);
    }
}
