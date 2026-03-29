package com.opos.mobad.downloader.a;

import android.content.Context;
import android.widget.RemoteViews;
import com.heytap.msp.mobad.api.R;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8771a;
    private Map<Integer, RemoteViews> b = new ConcurrentHashMap();

    public f(Context context) {
        this.f8771a = context;
    }

    public RemoteViews a(String str, String str2, int i, int i2, int i3) {
        int iA;
        Map<Integer, RemoteViews> map = this.b;
        RemoteViews remoteViews = map != null ? map.get(Integer.valueOf(i3)) : null;
        if (remoteViews == null) {
            remoteViews = new RemoteViews(this.f8771a.getPackageName(), com.opos.mobad.downloader.b.c.a(this.f8771a, "opos_mob_layout_download_manager", "layout"));
            this.b.put(Integer.valueOf(i3), remoteViews);
        }
        remoteViews.setImageViewResource(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_icon_iv", "id"), com.opos.mobad.downloader.b.c.a(this.f8771a, "opos_mob_drawable_download_icon", "drawable"));
        remoteViews.setTextViewText(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_app_name_tv", "id"), str);
        remoteViews.setCharSequence(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_delete_bt", "id"), "setText", this.f8771a.getResources().getString(R.string.download_delete_bt_txt));
        if (i != 102) {
            if (i == 103) {
                remoteViews.setTextViewText(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_process_tv", "id"), str2);
                remoteViews.setViewVisibility(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_process_tv", "id"), 0);
                remoteViews.setTextViewText(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_status_tv", "id"), this.f8771a.getResources().getString(R.string.download_status_pause_txt));
                remoteViews.setViewVisibility(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_status_tv", "id"), 0);
                remoteViews.setViewVisibility(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_fail_tv", "id"), 8);
                remoteViews.setCharSequence(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_ctrl_bt", "id"), "setText", this.f8771a.getResources().getString(R.string.download_continue_bt_txt));
                remoteViews.setViewVisibility(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_ctrl_bt", "id"), 0);
                remoteViews.setViewVisibility(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_process_bar", "id"), 4);
            } else {
                if (i == 106) {
                    remoteViews.setViewVisibility(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_status_tv", "id"), 8);
                    remoteViews.setViewVisibility(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_process_tv", "id"), 8);
                    remoteViews.setTextViewText(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_fail_tv", "id"), this.f8771a.getResources().getString(R.string.download_status_fail_txt));
                    remoteViews.setViewVisibility(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_fail_tv", "id"), 0);
                    remoteViews.setViewVisibility(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_ctrl_bt", "id"), 0);
                    remoteViews.setTextViewText(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_ctrl_bt", "id"), this.f8771a.getResources().getString(R.string.download_retry_bt_txt));
                } else if (i == 105) {
                    remoteViews.setViewVisibility(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_status_tv", "id"), 8);
                    remoteViews.setViewVisibility(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_process_tv", "id"), 8);
                    remoteViews.setTextViewText(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_fail_tv", "id"), this.f8771a.getResources().getString(R.string.download_status_complete_txt));
                    remoteViews.setViewVisibility(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_fail_tv", "id"), 0);
                    remoteViews.setCharSequence(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_ctrl_bt", "id"), "setText", this.f8771a.getResources().getString(R.string.download_install_bt_txt));
                    remoteViews.setViewVisibility(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_ctrl_bt", "id"), 0);
                } else if (i == 107) {
                    remoteViews.setViewVisibility(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_status_tv", "id"), 8);
                    remoteViews.setViewVisibility(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_process_bar", "id"), 8);
                    remoteViews.setViewVisibility(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_process_tv", "id"), 8);
                    remoteViews.setViewVisibility(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_ctrl_bt", "id"), 4);
                    remoteViews.setTextViewText(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_fail_tv", "id"), this.f8771a.getResources().getString(R.string.download_status_waiting_txt));
                    iA = com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_fail_tv", "id");
                }
                remoteViews.setViewVisibility(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_process_bar", "id"), 8);
            }
            return remoteViews;
        }
        remoteViews.setTextViewText(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_process_tv", "id"), str2);
        remoteViews.setViewVisibility(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_process_tv", "id"), 0);
        remoteViews.setTextViewText(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_status_tv", "id"), this.f8771a.getResources().getString(R.string.download_status_downloading_txt));
        remoteViews.setViewVisibility(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_status_tv", "id"), 0);
        remoteViews.setViewVisibility(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_fail_tv", "id"), 8);
        remoteViews.setCharSequence(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_ctrl_bt", "id"), "setText", this.f8771a.getResources().getString(R.string.download_pause_bt_txt));
        remoteViews.setViewVisibility(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_ctrl_bt", "id"), 0);
        remoteViews.setProgressBar(com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_process_bar", "id"), 100, i2, false);
        iA = com.opos.mobad.downloader.b.c.a(this.f8771a, "dl_process_bar", "id");
        remoteViews.setViewVisibility(iA, 0);
        return remoteViews;
    }

    public void a() {
        Map<Integer, RemoteViews> map = this.b;
        if (map == null || map.size() <= 0) {
            return;
        }
        this.b.clear();
    }

    public void a(int i) {
        Map<Integer, RemoteViews> map = this.b;
        if (map == null || map.size() <= 0 || !this.b.containsKey(Integer.valueOf(i))) {
            return;
        }
        this.b.remove(Integer.valueOf(i));
    }
}
