package com.zenmen.imageeditengine;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.zenmen.imageeditengine.CropFragment;
import com.zenmen.imageeditengine.PhotoEditorFragment;
import defpackage.s22;
import defpackage.sn2;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ImageEditActivity extends BaseImageEditActivity implements PhotoEditorFragment.b, CropFragment.a {
    public Rect q;
    public int r;
    public String s;
    public String t;
    public boolean u = false;

    @Override // com.zenmen.imageeditengine.CropFragment.a
    public void E0(Bitmap bitmap) {
        Intent intent = new Intent();
        intent.putExtra("EXTRA_SEND_IMAGE", true);
        if (bitmap != null) {
            if (this.t == null) {
                this.t = sn2.i(sn2.f(this.s), 0, true);
            } else {
                File file = new File(this.t);
                if (file.exists()) {
                    file.delete();
                }
                this.t = sn2.i(sn2.g(this.t), sn2.d(this.t), false);
            }
            y1(bitmap, this.t);
            intent.putExtra("EXTRA_CROP_RECT", this.q);
            intent.putExtra("EXTRA_CROP_ROTATION", this.r);
            intent.putExtra("EXTRA_EDITED_SRC_PATH", this.s);
            intent.putExtra("EXTRA_EDITED_PATH", this.t);
            intent.putExtra("EXTRA_CROP_RECT", this.q);
            intent.putExtra("EXTRA_CROP_ROTATION", this.r);
            intent.putExtra("EXTRA_EDITED_SRC_PATH", this.s);
            intent.putExtra("EXTRA_EDITED_PATH", this.t);
        } else {
            intent.putExtra("EXTRA_EDITED_SRC_PATH", this.s);
            intent.putExtra("EXTRA_EDITED_PATH", this.s);
        }
        setResult(-1, intent);
        finish();
    }

    @Override // com.zenmen.imageeditengine.PhotoEditorFragment.b
    public void f1(Bitmap bitmap) {
        E0(bitmap);
    }

    @Override // com.zenmen.imageeditengine.PhotoEditorFragment.b
    public void n1(Bitmap bitmap) {
        s22.a(this, R$id.fragment_container, CropFragment.F(bitmap, this.q, this.r));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.zenmen.imageeditengine.BaseImageEditActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_image_edit);
        String stringExtra = getIntent().getStringExtra("EXTRA_IMAGE_PATH");
        this.s = stringExtra;
        this.u = getIntent().getBooleanExtra("EXTRA_SHOW_SEND_BUTTON", false);
        this.r = getIntent().getIntExtra("EXTRA_CROP_ROTATION", 0);
        this.q = (Rect) getIntent().getParcelableExtra("EXTRA_CROP_RECT");
        String stringExtra2 = getIntent().getStringExtra("EXTRA_EDITED_PATH");
        this.t = stringExtra2;
        if (stringExtra != null) {
            s22.a(this, R$id.fragment_container, PhotoEditorFragment.L(stringExtra, stringExtra2));
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.zenmen.imageeditengine.PhotoEditorFragment.b
    public void s0(Bitmap bitmap) {
        Intent intent = new Intent();
        intent.putExtra("EXTRA_SEND_IMAGE", false);
        if (bitmap != null) {
            if (this.t == null) {
                this.t = sn2.i(sn2.f(this.s), 0, true);
            } else {
                File file = new File(this.t);
                if (file.exists()) {
                    file.delete();
                }
                this.t = sn2.i(sn2.g(this.t), sn2.d(this.t), false);
            }
            y1(bitmap, this.t);
            intent.putExtra("EXTRA_CROP_RECT", this.q);
            intent.putExtra("EXTRA_CROP_ROTATION", this.r);
            intent.putExtra("EXTRA_EDITED_SRC_PATH", this.s);
            intent.putExtra("EXTRA_EDITED_PATH", this.t);
        } else {
            intent.putExtra("EXTRA_EDITED_PATH", this.s);
            intent.putExtra("EXTRA_EDITED_SRC_PATH", this.s);
        }
        setResult(-1, intent);
        finish();
    }

    @Override // com.zenmen.imageeditengine.CropFragment.a
    public void w(Bitmap bitmap, Rect rect, int i) {
        this.q = rect;
        this.r = i;
        PhotoEditorFragment photoEditorFragment = (PhotoEditorFragment) s22.b(this, PhotoEditorFragment.class.getSimpleName());
        if (photoEditorFragment != null) {
            photoEditorFragment.O(bitmap);
            photoEditorFragment.M();
            s22.c(this, (BaseFragment) s22.b(this, CropFragment.class.getSimpleName()));
        }
    }

    public final String y1(Bitmap bitmap, String str) {
        try {
            File file = new File(str);
            file.getParentFile().mkdirs();
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            finish();
            return str;
        }
    }
}
