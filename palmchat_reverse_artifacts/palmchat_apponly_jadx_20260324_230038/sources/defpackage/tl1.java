package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.zenmen.palmchat.R;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class tl1 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<String> f21017a;
    public Context b;
    public LayoutInflater c;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f21018a;

        public a() {
        }
    }

    public tl1(Context context, ArrayList<String> arrayList) {
        this.b = context;
        this.f21017a = arrayList;
        this.c = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String getItem(int i) {
        return this.f21017a.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f21017a.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate;
        a aVar;
        if (view == null) {
            aVar = new a();
            viewInflate = this.c.inflate(R.layout.layout_emoji_item, (ViewGroup) null);
            aVar.f21018a = (ImageView) viewInflate.findViewById(R.id.image);
            viewInflate.setTag(aVar);
        } else {
            viewInflate = view;
            aVar = (a) view.getTag();
        }
        try {
            aVar.f21018a.setImageResource(vl1.h(vl1.f().get(this.f21017a.get(i))));
        } catch (OutOfMemoryError unused) {
        }
        return viewInflate;
    }
}
