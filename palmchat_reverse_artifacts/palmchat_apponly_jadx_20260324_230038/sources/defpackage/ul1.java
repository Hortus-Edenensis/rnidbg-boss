package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.friendcircle.R$layout;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ul1 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<String> f21238a;
    public Context b;
    public LayoutInflater c;

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f21239a;

        public b() {
        }
    }

    public ul1(Context context, ArrayList<String> arrayList) {
        this.b = context;
        this.f21238a = arrayList;
        this.c = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String getItem(int i) {
        return this.f21238a.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f21238a.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate;
        b bVar;
        if (view == null) {
            bVar = new b();
            viewInflate = this.c.inflate(R$layout.layout_emoji_item, (ViewGroup) null);
            bVar.f21239a = (ImageView) viewInflate.findViewById(R$id.image);
            viewInflate.setTag(bVar);
        } else {
            viewInflate = view;
            bVar = (b) view.getTag();
        }
        try {
            bVar.f21239a.setImageResource(vl1.h(vl1.f().get(this.f21238a.get(i))));
        } catch (OutOfMemoryError unused) {
        }
        return viewInflate;
    }
}
