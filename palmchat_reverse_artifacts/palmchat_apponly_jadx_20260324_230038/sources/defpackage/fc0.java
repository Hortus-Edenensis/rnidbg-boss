package defpackage;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.ImageView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class fc0 extends AsyncTask<String, Void, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f17501a;
    public ImageView b;

    public fc0(ImageView imageView, String str) {
        this.b = imageView;
        this.f17501a = str;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(String... strArr) {
        if (TextUtils.isEmpty(AccountUtils.p(AppContext.getContext()))) {
            return null;
        }
        try {
            return gt.e(this.f17501a, (int) AppContext.getContext().getResources().getDimension(R.dimen.settings_item_height));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap == null) {
            return;
        }
        this.b.setImageBitmap(bitmap);
    }
}
