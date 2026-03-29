package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.widget.SocialPortraitView;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ve2 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f21423a;
    public Collection<GroupInfoItem> b;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SocialPortraitView f21424a;
        public TextView b;
        public TextView c;

        public a() {
        }
    }

    public ve2(Context context) {
        this.f21423a = context;
    }

    public void a(Collection<GroupInfoItem> collection) {
        this.b = collection;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Collection<GroupInfoItem> collection = this.b;
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Iterator<GroupInfoItem> it = this.b.iterator();
        GroupInfoItem next = null;
        for (int i2 = 0; i2 <= i; i2++) {
            next = it.next();
        }
        return next;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.f21423a).inflate(R.layout.list_item_group_list, (ViewGroup) null);
            aVar = new a();
            SocialPortraitView socialPortraitView = (SocialPortraitView) view.findViewById(R.id.portrait);
            aVar.f21424a = socialPortraitView;
            socialPortraitView.changeShapeType(3);
            aVar.b = (TextView) view.findViewById(R.id.group_name);
            TextView textView = (TextView) view.findViewById(R.id.member_count);
            aVar.c = textView;
            textView.setVisibility(8);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        GroupInfoItem groupInfoItem = (GroupInfoItem) getItem(i);
        gr2.j().h(groupInfoItem.getIconURL(), aVar.f21424a, bq6.s());
        if (TextUtils.isEmpty(groupInfoItem.getGroupName())) {
            aVar.b.setText(groupInfoItem.getGroupLocalName());
        } else {
            aVar.b.setText(groupInfoItem.getGroupName());
        }
        return view;
    }
}
