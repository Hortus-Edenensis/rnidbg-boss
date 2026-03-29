package defpackage;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ExpressionObject;
import defpackage.je1;
import java.io.IOException;
import pl.droidsonroids.gif.GifImageView;
import pl.droidsonroids.gif.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class fs1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PopupWindow f17589a;

    public static void a() {
        PopupWindow popupWindow = f17589a;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        f17589a.dismiss();
    }

    public static PopupWindow b(Activity activity, View view, ExpressionObject expressionObject) {
        PopupWindow popupWindow = f17589a;
        if (popupWindow != null && popupWindow.isShowing()) {
            f17589a.dismiss();
        }
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.layout_popup_expression_preview, (ViewGroup) null);
        GifImageView gifImageView = (GifImageView) viewInflate.findViewById(R.id.imageView);
        try {
            gifImageView.setImageDrawable(new a(expressionObject.path));
        } catch (IOException e) {
            e.printStackTrace();
            gr2.j().h(k86.p(expressionObject.path), gifImageView, new je1.a().s(true).t(false).u(true).q(Bitmap.Config.RGB_565).B(R.drawable.media_pick_grid_item_background).A(R.drawable.media_pick_grid_item_background).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r());
        }
        PopupWindow popupWindow2 = new PopupWindow(viewInflate, -2, -2);
        f17589a = popupWindow2;
        popupWindow2.setBackgroundDrawable(new ColorDrawable(0));
        viewInflate.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        f17589a.setOutsideTouchable(true);
        f17589a.setFocusable(true);
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
        f17589a.showAsDropDown(view, -Math.abs((me1.b(activity, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION) - view.getWidth()) / 2), -Math.abs(me1.b(activity, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION) + view.getHeight()));
        f17589a.update();
        return f17589a;
    }
}
