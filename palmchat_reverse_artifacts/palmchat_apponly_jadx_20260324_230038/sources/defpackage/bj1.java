package defpackage;

import android.text.TextUtils;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.dynamiclife.CommonViewHolder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class bj1 extends hd5<aj1> {
    @Override // defpackage.hd5
    public int i() {
        return R$layout.dynamic_life_day_city;
    }

    @Override // defpackage.zu2
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public void b(CommonViewHolder commonViewHolder, aj1 aj1Var, int i) {
        if (aj1Var.c) {
            commonViewHolder.l(R$id.ll_day).setVisibility(0);
        } else {
            commonViewHolder.l(R$id.ll_day).setVisibility(8);
        }
        commonViewHolder.n(R$id.tv_month, aj1Var.f1236a);
        if (TextUtils.isEmpty(aj1Var.b)) {
            commonViewHolder.n(R$id.tv_city, "未知");
        } else {
            commonViewHolder.n(R$id.tv_city, aj1Var.b);
        }
    }
}
