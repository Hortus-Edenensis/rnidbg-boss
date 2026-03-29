package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ExpressionObject;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class lt1 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<ExpressionObject> f19070a;
    public Context b;
    public LayoutInflater c;
    public int d;

    /* JADX INFO: compiled from: SearchBox */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f19071a;

        public a() {
        }
    }

    public lt1(Context context, ArrayList<ExpressionObject> arrayList, int i) {
        this.b = context;
        this.f19070a = arrayList;
        this.d = i;
        this.c = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ExpressionObject getItem(int i) {
        return this.f19070a.get(i + this.d);
    }

    public void b(ArrayList<ExpressionObject> arrayList) {
        this.f19070a = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f19070a.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.c.inflate(R.layout.layout_favorite_expression_item, (ViewGroup) null);
            aVar = new a();
            aVar.f19071a = (ImageView) view.findViewById(R.id.image);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        ExpressionObject item = getItem(i);
        if ("add".equals(item.tag)) {
            aVar.f19071a.setImageResource(R.drawable.icon_fav_exp);
            aVar.f19071a.setBackgroundResource(R.drawable.transparent_shape);
        } else if ("jsb".equals(item.tag)) {
            aVar.f19071a.setImageResource(R.drawable.jsb);
            aVar.f19071a.setBackgroundResource(R.drawable.selector_bg_face_item);
        } else if ("dice".equals(item.tag)) {
            aVar.f19071a.setImageResource(R.drawable.dice);
            aVar.f19071a.setBackgroundResource(R.drawable.selector_bg_face_item);
        } else {
            aVar.f19071a.setBackgroundResource(R.drawable.selector_bg_face_item);
            gr2.j().h(k86.p(item.coverPath), aVar.f19071a, bq6.n());
        }
        aVar.f19071a.setTag(Integer.valueOf(i));
        return view;
    }
}
