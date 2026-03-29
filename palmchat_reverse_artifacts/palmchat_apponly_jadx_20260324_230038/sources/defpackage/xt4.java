package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.photoview.PhotoViewActivity;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import defpackage.je1;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class xt4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap<Integer, Boolean> f22048a = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f22049a;
        public final /* synthetic */ PopupWindow b;

        public a(Activity activity, PopupWindow popupWindow) {
            this.f22049a = activity;
            this.b = popupWindow;
        }

        @Override // java.lang.Runnable
        public void run() {
            PopupWindow popupWindow;
            if (this.f22049a == null || (popupWindow = this.b) == null || !popupWindow.isShowing()) {
                return;
            }
            this.b.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f22050a;
        public final /* synthetic */ MediaItem b;
        public final /* synthetic */ ChatItem c;
        public final /* synthetic */ PopupWindow d;

        public b(Activity activity, MediaItem mediaItem, ChatItem chatItem, PopupWindow popupWindow) {
            this.f22050a = activity;
            this.b = mediaItem;
            this.c = chatItem;
            this.d = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(this.f22050a, PhotoViewActivity.class);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            arrayList.add(this.b);
            intent.putExtra("info_item", this.c);
            intent.putParcelableArrayListExtra("mediaList", arrayList);
            intent.putExtra("selectIndex", 0);
            intent.putExtra("show_mode", 2);
            intent.putExtra("isNeedShowSendCount", false);
            this.f22050a.startActivity(intent);
            this.d.dismiss();
        }
    }

    public static MediaItem a() {
        Cursor cursorQuery;
        MediaItem mediaItem = null;
        try {
            cursorQuery = AppContext.getContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_data", "_display_name", "date_modified", "_size"}, "date_modified>? AND date_modified<?", new String[]{String.valueOf((System.currentTimeMillis() - 30000) / 1000), String.valueOf(System.currentTimeMillis() / 1000)}, "date_modified DESC");
        } catch (Exception e) {
            e.printStackTrace();
            cursorQuery = null;
        }
        if (cursorQuery != null) {
            if (cursorQuery.moveToNext()) {
                int i = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                if (f22048a.get(Integer.valueOf(i)) == null) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                    if (!TextUtils.isEmpty(string) && !string.startsWith(pu1.e)) {
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                        long j = cursorQuery.getLong(cursorQuery.getColumnIndex("date_modified"));
                        long j2 = cursorQuery.getLong(cursorQuery.getColumnIndex("_size"));
                        MediaItem mediaItem2 = new MediaItem();
                        mediaItem2.fileID = i;
                        mediaItem2.fileFullPath = string;
                        mediaItem2.fileName = string2;
                        mediaItem2.modifyTime = j;
                        mediaItem2.fileSize = j2;
                        f22048a.put(Integer.valueOf(i), Boolean.TRUE);
                        mediaItem = mediaItem2;
                    }
                }
            }
            cursorQuery.close();
        }
        return mediaItem;
    }

    public static PopupWindow b(Activity activity, View view, MediaItem mediaItem, ChatItem chatItem) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.layout_popup_recent_image, (ViewGroup) null);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.imageView);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.clickView);
        gr2.j().h(k86.p(mediaItem.fileFullPath), imageView, new je1.a().s(true).t(false).u(true).q(Bitmap.Config.RGB_565).B(R.drawable.media_pick_grid_item_background).A(R.drawable.media_pick_grid_item_background).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r());
        PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
        imageView2.setOnClickListener(new b(activity, mediaItem, chatItem, popupWindow));
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        viewInflate.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        popupWindow.setOutsideTouchable(false);
        popupWindow.setFocusable(true);
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
        popupWindow.showAsDropDown(view, 0, -me1.b(activity, 155));
        popupWindow.update();
        return popupWindow;
    }

    public static PopupWindow c(Activity activity, View view, ChatItem chatItem, Handler handler) {
        MediaItem mediaItemA = a();
        if (mediaItemA == null) {
            return null;
        }
        PopupWindow popupWindowB = b(activity, view, mediaItemA, chatItem);
        handler.postDelayed(new a(activity, popupWindowB), 10000L);
        return popupWindowB;
    }
}
