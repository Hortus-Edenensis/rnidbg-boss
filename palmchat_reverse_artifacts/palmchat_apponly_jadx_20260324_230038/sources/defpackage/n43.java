package defpackage;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.je1;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class n43 extends AsyncTask<String, Void, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19433a;
    public ImageView b;
    public ImageView c;
    public String d;
    public String e;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f19434a;
        public final /* synthetic */ long b;

        public a(Bitmap bitmap, long j) {
            this.f19434a = bitmap;
            this.b = j;
            put("action", "get_QRCode");
            put("status", "get_success");
            put("detail", "result=" + bitmap + "  time:" + (System.currentTimeMillis() - j) + "ms");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f19435a;

        public b(long j) {
            this.f19435a = j;
            put("action", "get_QRCode");
            put("status", "get_fail");
            put("detail", "Exception time:" + (System.currentTimeMillis() - j) + "ms");
        }
    }

    public n43(ImageView imageView, EffectiveShapeView effectiveShapeView, String str, String str2) {
        this.b = imageView;
        this.c = effectiveShapeView;
        this.f19433a = str;
        this.e = str2;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(String... strArr) {
        String strP = AccountUtils.p(AppContext.getContext());
        Bitmap bitmap = null;
        if (TextUtils.isEmpty(strP)) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            ContactInfoItem contactInfoItemL = bo0.r().l(strP);
            if (contactInfoItemL != null && !TextUtils.isEmpty(contactInfoItemL.getIconURL())) {
                this.d = contactInfoItemL.getIconURL();
            }
            Bitmap bitmapD = gt.d(this.e, (int) AppContext.getContext().getResources().getDimension(R.dimen.settings_fragment_qrcode));
            try {
                LogUtil.i(this.f19433a, 3, new a(bitmapD, jCurrentTimeMillis), (Throwable) null);
                return bitmapD;
            } catch (Exception e) {
                bitmap = bitmapD;
                e = e;
                LogUtil.i(this.f19433a, 3, new b(jCurrentTimeMillis), e);
                e.printStackTrace();
                return bitmap;
            }
        } catch (Exception e2) {
            e = e2;
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
        gr2.j().h(this.d, this.c, new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).B(R.drawable.default_portrait).A(R.drawable.default_portrait).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r());
    }
}
