package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.widget.SocialPortraitView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ee2 extends CursorAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LayoutInflater f17286a;
    public boolean b;

    public ee2(Context context, Cursor cursor, int i, boolean z) {
        super(context, cursor, i);
        this.f17286a = LayoutInflater.from(context);
        this.b = z;
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        SocialPortraitView socialPortraitView = (SocialPortraitView) view.findViewById(R.id.portrait);
        socialPortraitView.changeShapeType(3);
        TextView textView = (TextView) view.findViewById(R.id.group_name);
        TextView textView2 = (TextView) view.findViewById(R.id.member_count);
        GroupInfoItem itemFromCursor = GroupInfoItem.getItemFromCursor(cursor, (ChatItem) null);
        String groupName = itemFromCursor.getGroupName();
        String iconURL = itemFromCursor.getIconURL();
        String groupLocalName = itemFromCursor.getGroupLocalName();
        int memberCount = itemFromCursor.getMemberCount();
        if (!this.b || memberCount <= 0) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(AppContext.getContext().getString(R.string.string_number, Integer.valueOf(memberCount)));
            textView2.setVisibility(0);
        }
        if (!TextUtils.isEmpty(groupName)) {
            textView.setText(groupName);
        } else if (TextUtils.isEmpty(groupLocalName)) {
            textView.setText(R.string.group_no_name);
        } else {
            textView.setText(groupLocalName);
        }
        if (TextUtils.isEmpty(iconURL)) {
            socialPortraitView.setImageResource(R.drawable.default_portrait);
        } else {
            gr2.j().h(iconURL, socialPortraitView, bq6.s());
        }
    }

    @Override // android.widget.CursorAdapter, android.widget.Adapter
    public Object getItem(int i) {
        Cursor cursor = getCursor();
        cursor.moveToPosition(i);
        return GroupInfoItem.getItemFromCursor(cursor, (ChatItem) null);
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f17286a.inflate(R.layout.list_item_group_list, (ViewGroup) null, false);
    }
}
