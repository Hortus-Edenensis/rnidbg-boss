package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ExpressionObject;
import defpackage.je1;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class nt1 extends BaseAdapter {
    public Context b;
    public LayoutInflater c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<ExpressionObject> f19593a = new ArrayList<>();
    public boolean d = false;
    public je1 e = new je1.a().s(true).t(false).u(true).q(Bitmap.Config.RGB_565).w(ImageScaleType.EXACTLY).r();

    /* JADX INFO: compiled from: SearchBox */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f19594a;
        public ImageView b;
        public View c;
        public String d;

        public a() {
        }
    }

    public nt1(Context context) {
        this.b = context;
        this.c = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ExpressionObject getItem(int i) {
        return this.f19593a.get(i);
    }

    public int b() {
        int i = 0;
        if (e()) {
            Iterator<ExpressionObject> it = this.f19593a.iterator();
            while (it.hasNext()) {
                if (it.next().isSelect) {
                    i++;
                }
            }
        }
        return i;
    }

    public ArrayList<ExpressionObject> c() {
        ArrayList<ExpressionObject> arrayList = new ArrayList<>();
        for (ExpressionObject expressionObject : this.f19593a) {
            if (expressionObject.isSelect) {
                arrayList.add(expressionObject);
            }
        }
        return arrayList;
    }

    public boolean e() {
        return this.d;
    }

    public void f(ArrayList<ExpressionObject> arrayList) {
        this.f19593a = arrayList;
        g(this.d);
    }

    public void g(boolean z) {
        boolean z2 = true;
        boolean z3 = this.d != z;
        this.d = z;
        if (z) {
            int i = -1;
            for (int i2 = 0; i2 < this.f19593a.size(); i2++) {
                ExpressionObject expressionObject = this.f19593a.get(i2);
                if (z3) {
                    expressionObject.isSelect = false;
                }
                if ("add".equals(expressionObject.tag)) {
                    i = i2;
                }
            }
            if (this.f19593a.size() > i && i >= 0) {
                this.f19593a.remove(i);
            }
        } else {
            Iterator<ExpressionObject> it = this.f19593a.iterator();
            while (true) {
                if (it.hasNext()) {
                    if ("add".equals(it.next().tag)) {
                        break;
                    }
                } else {
                    z2 = false;
                    break;
                }
            }
            if (!z2) {
                ExpressionObject expressionObject2 = new ExpressionObject();
                expressionObject2.tag = "add";
                this.f19593a.add(expressionObject2);
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f19593a.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.c.inflate(R.layout.layout_manage_favorite_expression_item, (ViewGroup) null);
            int iG = me1.g() / 5;
            view.setLayoutParams(new AbsListView.LayoutParams(iG, iG));
            aVar = new a();
            aVar.f19594a = (ImageView) view.findViewById(R.id.image);
            aVar.b = (ImageView) view.findViewById(R.id.selector);
            aVar.c = view.findViewById(R.id.sepView);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.c != null) {
            if ((i + 1) % 5 != 0 || i == getCount() - 1) {
                aVar.c.setVisibility(0);
            } else {
                aVar.c.setVisibility(8);
            }
        }
        ExpressionObject item = getItem(i);
        if (this.d) {
            aVar.b.setVisibility(0);
            aVar.b.setSelected(item.isSelect);
        } else {
            aVar.b.setVisibility(8);
        }
        if (TextUtils.isEmpty(item.tag)) {
            String str = aVar.d;
            if (str == null || !str.equals(k86.p(item.coverPath))) {
                aVar.d = k86.p(item.coverPath);
                gr2.j().h(k86.p(item.coverPath), aVar.f19594a, this.e);
            }
        } else {
            aVar.d = "add";
            gr2.j().e(R.drawable.icon_expression_manage_add, aVar.f19594a, this.e);
        }
        return view;
    }
}
