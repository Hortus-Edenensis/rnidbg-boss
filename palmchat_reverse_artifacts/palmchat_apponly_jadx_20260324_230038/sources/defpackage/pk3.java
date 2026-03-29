package defpackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.huawei.openalliance.ad.constant.az;
import com.zenmen.media.CameraActivity;
import com.zenmen.media.album.SquareMediaPickActivity;
import com.zenmen.media.crop.CropActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.activity.photoview.PhotoObject;
import com.zenmen.palmchat.chat.MediaPickActivity;
import com.zenmen.palmchat.chat.SendMessageActivity;
import com.zenmen.palmchat.chat.h;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import defpackage.bn2;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class pk3 implements bn2 {
    @Override // defpackage.bn2
    public void a(Activity activity, int i, int i2) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) SquareMediaPickActivity.class);
            intent.putExtra("from", "from_square_add");
            intent.putExtra("key_photo_num", i);
            activity.startActivityForResult(intent, i2);
        }
    }

    @Override // defpackage.bn2
    public Intent b(Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) MediaPickActivity.class);
        intent.putExtra("extra_key_max_num", 1);
        intent.putExtra("select_mode_key", 1);
        intent.putExtra("from", "from_js");
        return intent;
    }

    @Override // defpackage.bn2
    public void c(Fragment fragment, int i, int i2, int i3) {
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        Intent intent = new Intent(fragment.getActivity(), (Class<?>) CameraActivity.class);
        intent.putExtra("EXTRA_RECORD_MODE", i);
        intent.putExtra("EXTRA_REQUEST_CODE", i2);
        intent.putExtra(az.at, i3);
        fragment.startActivityForResult(intent, i2);
        fragment.getActivity().overridePendingTransition(R.anim.activity_translate_in, R.anim.scale_exit_out);
    }

    @Override // defpackage.bn2
    public void d(FrameworkBaseActivity frameworkBaseActivity, String str, int i, int i2) {
        if (frameworkBaseActivity != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("width", i);
                jSONObject.put("height", i2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Intent intent = new Intent();
            intent.setClass(frameworkBaseActivity, SendMessageActivity.class);
            PhotoObject photoObject = new PhotoObject();
            photoObject.thumbUrl = str;
            photoObject.url = str;
            photoObject.extension = jSONObject.toString();
            intent.putExtra("message_vo", MessageVo.buildImageMessage(xn3.a(), null, photoObject, false, 0, null));
            frameworkBaseActivity.startActivity(intent);
        }
    }

    @Override // defpackage.bn2
    public void e(String str, bn2.d dVar) {
        h.d().a(new h.e(str), dVar, false);
    }

    @Override // defpackage.bn2
    public void f(Activity activity, int i) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) SquareMediaPickActivity.class);
            intent.putExtra("from", "from_square_publish");
            activity.startActivityForResult(intent, i);
        }
    }

    @Override // defpackage.bn2
    public void g(Activity activity, int i, int i2, int i3, int i4) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) MediaPickActivity.class);
            intent.putExtra("extra_key_max_num", i);
            intent.putExtra("extra_key_mode", i2);
            intent.putExtra("select_mode_key", 0);
            intent.putExtra("from", "from_moment");
            intent.putExtra(az.at, i4);
            activity.startActivityForResult(intent, i3);
        }
    }

    @Override // defpackage.bn2
    @SuppressLint({"UnsafeOptInUsageError"})
    public void h(Activity activity, MediaItem mediaItem, int i) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) CropActivity.class);
            intent.putExtra("extra_media_item", mediaItem);
            activity.startActivityForResult(intent, i);
        }
    }

    @Override // defpackage.bn2
    public void i(Activity activity, int i, int i2) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) CameraActivity.class);
            intent.putExtra("EXTRA_RECORD_MODE", i);
            intent.putExtra("EXTRA_REQUEST_CODE", i2);
            activity.startActivityForResult(intent, i2);
            activity.overridePendingTransition(R.anim.activity_translate_in, R.anim.scale_exit_out);
        }
    }

    @Override // defpackage.bn2
    public void j(Activity activity, int i, int i2, int i3) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) CameraActivity.class);
            intent.putExtra("EXTRA_RECORD_MODE", i);
            intent.putExtra("EXTRA_REQUEST_CODE", i2);
            intent.putExtra(az.at, i3);
            activity.startActivityForResult(intent, i2);
            activity.overridePendingTransition(R.anim.activity_translate_in, R.anim.scale_exit_out);
        }
    }
}
