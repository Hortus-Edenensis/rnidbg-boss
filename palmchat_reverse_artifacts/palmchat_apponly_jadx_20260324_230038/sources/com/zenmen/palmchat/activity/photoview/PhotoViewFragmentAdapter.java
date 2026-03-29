package com.zenmen.palmchat.activity.photoview;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.ui.widget.SquareDetailVideoView;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class PhotoViewFragmentAdapter extends FragmentStatePagerAdapter {
    public static final String m = "PhotoViewFragmentAdapter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<MediaItem> f12346a;
    public boolean b;
    public boolean c;
    public boolean d;
    public int e;
    public ChatItem f;
    public boolean g;
    public String h;
    public MediaItem i;
    public int j;
    public boolean k;
    public int l;

    public PhotoViewFragmentAdapter(FragmentManager fragmentManager, ChatItem chatItem, ArrayList<MediaItem> arrayList, boolean z, boolean z2, boolean z3, boolean z4, String str, int i, boolean z5) {
        super(fragmentManager);
        this.l = 0;
        this.f12346a = arrayList;
        this.f = chatItem;
        this.b = z;
        this.c = z2;
        this.d = z3;
        this.g = z4;
        this.h = str;
        this.j = i;
        this.k = z5;
        if (arrayList != null) {
            LogUtil.i(m, "PhotoViewFragmentAdapter count = " + arrayList.size());
        }
    }

    public void f(MediaItem mediaItem) {
        this.i = mediaItem;
        notifyDataSetChanged();
    }

    public void g(int i) {
        this.e = i;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        ArrayList<MediaItem> arrayList = this.f12346a;
        return (arrayList == null || arrayList.size() == 0) ? this.i != null ? 1 : 0 : this.f12346a.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        MediaItem mediaItem;
        Log.e("rxx", "photo veiw getItem position:" + i);
        if (getCount() != 1 || (mediaItem = this.i) == null) {
            mediaItem = this.f12346a.get(i);
        }
        int i2 = mediaItem.mimeType;
        if (i2 != 4 && i2 != 1) {
            PhotoViewFragment photoViewFragment = new PhotoViewFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("long_click", this.g);
            bundle.putBoolean("from_portrait", this.b);
            bundle.putBoolean("from_user_portrait", this.c);
            bundle.putBoolean("extra_is_friend", this.d);
            bundle.putParcelable(SquareDetailVideoView.KEY_ITEM, mediaItem);
            bundle.putString("key_from", this.h);
            photoViewFragment.setArguments(bundle);
            return photoViewFragment;
        }
        LogUtil.i(m, "getItem path = " + mediaItem.localPath);
        VideoViewFragment videoViewFragment = new VideoViewFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("long_click", this.g);
        bundle2.putString(SquareDetailVideoView.KEY_ITEM, mediaItem.mid);
        bundle2.putParcelable("chat_item", this.f);
        bundle2.putInt(SquareDetailVideoView.KEY_POSITION, i);
        bundle2.putInt(SquareDetailVideoView.KEY_INIT_POSITION, this.e);
        bundle2.putParcelable("key_media_item", mediaItem);
        bundle2.putString("key_from", this.h);
        bundle2.putInt("key_show_mode", this.j);
        bundle2.putBoolean("key_init_item_auto_play", this.k);
        videoViewFragment.setArguments(bundle2);
        return videoViewFragment;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        int i = this.l;
        if (i <= 0) {
            return super.getItemPosition(obj);
        }
        this.l = i - 1;
        return -2;
    }

    public void h(ArrayList<MediaItem> arrayList) {
        this.f12346a = arrayList;
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        this.l = getCount();
        super.notifyDataSetChanged();
    }
}
