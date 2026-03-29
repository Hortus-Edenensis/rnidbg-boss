package com.zenmen.palmchat.activity.search;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cursoradapter.widget.CursorAdapter;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ChatItem;
import defpackage.a65;
import defpackage.by5;
import defpackage.do3;
import defpackage.gr2;
import defpackage.il5;
import defpackage.je1;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class MessageSearchResultAdapter extends CursorAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LayoutInflater f12366a;
    public je1 b;
    public ChatItem c;
    public String d;

    public MessageSearchResultAdapter(Context context, ChatItem chatItem, String str) {
        super(context, (Cursor) null, 2);
        this.f12366a = LayoutInflater.from(this.mContext);
        this.b = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).z(R.drawable.media_pick_grid_item_background).B(R.drawable.media_pick_grid_item_background).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r();
        this.c = chatItem;
        this.d = str;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        do3 do3Var = (do3) view.getTag();
        String iconURL = this.c.getIconURL();
        String chatName = this.c.getChatName();
        String string = cursor.getString(cursor.getColumnIndex("message"));
        int i = cursor.getInt(cursor.getColumnIndex("msg_type"));
        long j = cursor.getLong(cursor.getColumnIndex(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE));
        String string2 = cursor.getString(cursor.getColumnIndex("data2"));
        String string3 = cursor.getString(cursor.getColumnIndex("data5"));
        int iOptInt = 0;
        try {
            if (!TextUtils.isEmpty(string2)) {
                iOptInt = new JSONObject(string2).optInt("linkFlag");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String string4 = cursor.getString(cursor.getColumnIndex("src"));
        do3Var.f.setVisibility(8);
        do3Var.b.setVisibility(8);
        do3Var.g.setVisibility(8);
        if (i == 1 || i == 10000 || (i == 2 && !TextUtils.isEmpty(string3))) {
            if (1 == iOptInt || a65.f(string4)) {
                do3Var.d.setText(il5.h(a65.b(string), this.d));
            } else {
                do3Var.d.setText(il5.h(string, this.d));
            }
        } else if (i == 2) {
            do3Var.d.setText(R.string.message_type_pic);
        } else if (i == 3) {
            do3Var.d.setText(R.string.message_type_audio);
        } else if (i == 6) {
            do3Var.d.setText(R.string.message_type_file);
        } else if (i == 14) {
            do3Var.d.setText(R.string.string_message_type_expression);
        } else if (1 == iOptInt || a65.f(string4)) {
            do3Var.d.setText(il5.h(a65.b(string), this.d));
        } else {
            do3Var.d.setText(il5.h(string, this.d));
        }
        do3Var.c.setText(chatName);
        gr2.j().h(iconURL, do3Var.f17104a, this.b);
        do3Var.e.setText(by5.e(j, context));
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = this.f12366a.inflate(R.layout.list_item_message_search, (ViewGroup) null, false);
        viewInflate.setTag(do3.a(viewInflate));
        return viewInflate;
    }
}
