package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.bean.SquareDynamicLifeResponseBean;
import com.zenmen.square.dynamiclife.CommonViewHolder;
import com.zenmen.square.dynamiclife.DynamicLifeSpaceItem;
import com.zenmen.square.dynamiclife.PersonalDynamicLifeFragment;
import com.zenmen.square.dynamiclife.adapter.DynamicLifePictureAdapter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ij1 extends hd5<SquareDynamicLifeResponseBean> {
    public Context c;
    public DynamicLifeSpaceItem d;
    public int e;
    public PersonalDynamicLifeFragment.k f;

    public ij1(Context context, int i, PersonalDynamicLifeFragment.k kVar) {
        this.c = context;
        this.e = i;
        this.d = new DynamicLifeSpaceItem(me1.b(context, 2));
        this.f = kVar;
    }

    @Override // defpackage.hd5
    public int i() {
        return R$layout.dynamic_life_picture_rev;
    }

    @Override // defpackage.zu2
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public void b(CommonViewHolder commonViewHolder, SquareDynamicLifeResponseBean squareDynamicLifeResponseBean, int i) {
        Log.i("libb", "onBindViewHolder:  " + i);
        RecyclerView recyclerView = (RecyclerView) commonViewHolder.l(R$id.rv_picture);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(commonViewHolder.m(), 3);
        gridLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        DynamicLifePictureAdapter dynamicLifePictureAdapter = new DynamicLifePictureAdapter(this.c, this.e, squareDynamicLifeResponseBean.userDailyLifeList, this.f);
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(this.d);
        }
        recyclerView.setAdapter(dynamicLifePictureAdapter);
        if (TextUtils.isEmpty(squareDynamicLifeResponseBean.showMonth)) {
            commonViewHolder.l(R$id.ll_day).setVisibility(8);
            recyclerView.setPadding(0, 0, 0, 0);
        } else {
            commonViewHolder.l(R$id.ll_day).setVisibility(0);
            commonViewHolder.n(R$id.tv_month, squareDynamicLifeResponseBean.showMonth);
            recyclerView.setPadding(0, me1.b(this.c, 18), 0, 0);
        }
    }
}
