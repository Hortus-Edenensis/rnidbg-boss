package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.coupon.info.CircleCouponInfoItem;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class o70 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<CircleCouponInfoItem> f19706a = new ArrayList();
    public Context b;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EffectiveShapeView f19707a;
        public TextView b;
        public TextView c;
        public TextView d;
        public TextView e;
        public View f;

        public a() {
        }
    }

    public o70(Context context) {
        this.b = context;
    }

    public void a(ArrayList<CircleCouponInfoItem> arrayList) {
        this.f19706a.clear();
        if (arrayList != null) {
            this.f19706a.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f19706a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f19706a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.b).inflate(R.layout.item_circle_coupon_info, (ViewGroup) null);
            aVar = new a();
            aVar.f19707a = (EffectiveShapeView) view.findViewById(R.id.portrait);
            aVar.b = (TextView) view.findViewById(R.id.nick_name);
            aVar.c = (TextView) view.findViewById(R.id.time);
            aVar.d = (TextView) view.findViewById(R.id.money);
            aVar.e = (TextView) view.findViewById(R.id.best);
            aVar.f = view.findViewById(R.id.line);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.f19707a.changeShapeType(3);
        aVar.f19707a.setDegreeForRoundRectangle(10, 10);
        CircleCouponInfoItem circleCouponInfoItem = this.f19706a.get(i);
        String str = circleCouponInfoItem.headIconUrl;
        String str2 = circleCouponInfoItem.nickname;
        String str3 = circleCouponInfoItem.receiveTime;
        String str4 = circleCouponInfoItem.receiveAmountStr;
        boolean z = circleCouponInfoItem.bestLuck;
        if (i + 1 == this.f19706a.size()) {
            aVar.f.setVisibility(8);
        } else {
            aVar.f.setVisibility(0);
        }
        aVar.b.setText(str2);
        aVar.c.setText(str3);
        aVar.d.setText(str4);
        if (z) {
            aVar.e.setVisibility(0);
        } else {
            aVar.e.setVisibility(8);
        }
        gr2.j().h(str, aVar.f19707a, bq6.s());
        return view;
    }
}
