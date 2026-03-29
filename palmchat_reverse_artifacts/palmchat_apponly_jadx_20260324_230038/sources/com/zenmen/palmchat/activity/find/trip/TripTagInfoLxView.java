package com.zenmen.palmchat.activity.find.trip;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class TripTagInfoLxView extends FrameLayout {
    public int tagKey;
    public String tagName;
    public TextView tagView;

    public TripTagInfoLxView(@NonNull Context context, String str, int i) {
        super(context);
        this.tagKey = 0;
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.map_trip_release_info_item, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.map_tag_info_title);
        this.tagView = textView;
        this.tagName = str;
        this.tagKey = i;
        textView.setText(str);
        this.tagView.setBackgroundResource(R.drawable.trip_map_release_tag_item_normal_bg);
        addView(viewInflate, new FrameLayout.LayoutParams(-2, -2));
    }

    public void clearBg() {
        this.tagView.setBackgroundResource(R.drawable.trip_map_release_tag_item_normal_bg);
        this.tagView.setTextColor(Color.parseColor("#222222"));
    }

    public void setClickBg() {
        this.tagView.setBackgroundResource(R.drawable.trip_map_release_tag_item_click_bg);
        this.tagView.setTextColor(Color.parseColor("#14CD64"));
    }
}
