package com.zenmen.square.fragment;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.tag.bean.SquareTagBean;
import defpackage.bj5;
import defpackage.fw3;
import defpackage.qj5;
import defpackage.ro2;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class NestTagFeedsFragment extends FeedsFragment<fw3> {
    public ContactInfoItem u = null;
    public SquareTagBean v = null;
    public int w = 0;
    public String x;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ro2.b {
        public a() {
        }

        @Override // ro2.b
        public void a(ContactInfoItem contactInfoItem) {
            NestTagFeedsFragment.this.u = contactInfoItem;
        }

        @Override // ro2.b
        public void onError(String str) {
            Log.i("NewTagFeeds", "onError: " + str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void V(SquareTagBean squareTagBean);
    }

    @Override // com.zenmen.square.fragment.FeedsFragment
    public boolean G0() {
        return false;
    }

    @Override // com.zenmen.listui.list.BaseListFragment
    /* JADX INFO: renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public fw3 c0() {
        if (this.k == 0) {
            this.k = new fw3("square.queryFeedByTag.v8", this.v, this.u, o(), this.w);
        }
        return (fw3) this.k;
    }

    public final void R0() {
        bj5.b().a().q(this.x, new a());
    }

    @Override // com.zenmen.listui.list.BaseListFragment
    public void l0(List<SquareFeed> list) {
        if (list != null && (list.size() == 0 || list.get(0).contactInfoItem == null)) {
            SquareFeed squareFeed = new SquareFeed();
            squareFeed.contactInfoItem = this.u;
            squareFeed.squareTagBean = this.v;
            list.add(0, squareFeed);
        }
        super.l0(list);
    }

    @Override // com.zenmen.listui.list.BaseListFragment
    public void m0(int i) {
        super.m0(i);
        r0(0);
        if (getActivity() instanceof b) {
            ((b) getActivity()).V(this.v);
        }
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment
    public int o() {
        return 5;
    }

    @Override // com.zenmen.square.fragment.FeedsFragment, com.zenmen.square.fragment.SquareBaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        if (y() == null) {
            return;
        }
        y().setEnableRefresh(false);
    }

    @Override // com.zenmen.square.fragment.FeedsFragment, com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.u = (ContactInfoItem) arguments.getParcelable("key_contact_info");
        this.v = (SquareTagBean) arguments.getParcelable("key_square_tag");
        this.w = arguments.getInt("key_scene", 0);
        ContactInfoItem contactInfoItem = this.u;
        this.x = contactInfoItem != null ? contactInfoItem.getExid() : "";
        if (this.w == 43) {
            R0();
        }
        u(UUID.randomUUID().toString().replace("-", ""));
        qj5.U(getSid(), this.v.getPublishCnt(), this.v.getId(), this.x);
    }
}
