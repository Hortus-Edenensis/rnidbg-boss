package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.zenmen.media.roomchat.RTCParameters;
import com.zenmen.palmchat.R;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ir2 {
    public static void a(Context context, ImageView imageView, int i, String str) {
        if (i > 0) {
            imageView.setImageResource(i);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            imageView.setImageResource(R.drawable.manychats_icon_default_portrait);
            return;
        }
        try {
            hc2.a(context).load(str).thumbnail(0.1f).placeholder(R.drawable.manychats_icon_default_portrait).error(R.drawable.manychats_icon_default_portrait).transition(DrawableTransitionOptions.withCrossFade()).into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(ImageView imageView, int i, String str, int i2) {
        if (i > 0) {
            imageView.setImageResource(i);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            imageView.setImageResource(R.drawable.manychats_icon_default_portrait);
            return;
        }
        try {
            hc2.a(RTCParameters.c()).load(str).error(R.drawable.manychats_icon_default_portrait).transition(DrawableTransitionOptions.withCrossFade()).transform(new MultiTransformation(new CenterCrop(), new RoundedCornersTransformation(8, 0))).into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
