package com.zenmen.square.show;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.google.gson.reflect.TypeToken;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import com.zenmen.palmchat.widget.loopingvp.LoopingViewPager;
import com.zenmen.palmchat.widget.photoview.PhotoView;
import com.zenmen.square.NestTagFeedsActivity;
import com.zenmen.square.NestTopicFeedsActivity;
import com.zenmen.square.R$anim;
import com.zenmen.square.R$color;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import com.zenmen.square.adapter.LoopingFeedMediaPageAdapter;
import com.zenmen.square.comment.struct.UnitedException;
import com.zenmen.square.databinding.LayoutSquareShowMediaViewBinding;
import com.zenmen.square.lxpager.BasePagerBean;
import com.zenmen.square.lxpager.PagerFragment;
import com.zenmen.square.mvp.SquareDataBindingComponent;
import com.zenmen.square.mvp.model.bean.CheckResultBean;
import com.zenmen.square.mvp.model.bean.Media;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.model.bean.SquareFeedEvent;
import com.zenmen.square.mvp.model.bean.SquareFeedForChatCard;
import com.zenmen.square.mvvm.MediaViewModel;
import com.zenmen.square.support.SquareSingleton;
import com.zenmen.square.tag.bean.SquareTagBean;
import com.zenmen.square.ui.anim.VideoLikeBigStar;
import com.zenmen.square.ui.widget.DoubleClickView;
import com.zenmen.square.ui.widget.ExpandableTextView;
import com.zenmen.square.ui.widget.LoopingSquareHackyViewPager;
import com.zenmen.square.ui.widget.SquareDetailVideoView;
import com.zenmen.square.ui.widget.SquarePhotoView;
import defpackage.a46;
import defpackage.ai5;
import defpackage.an1;
import defpackage.az2;
import defpackage.bi5;
import defpackage.bj5;
import defpackage.cy5;
import defpackage.d33;
import defpackage.dn0;
import defpackage.ds0;
import defpackage.ei5;
import defpackage.fg6;
import defpackage.fi5;
import defpackage.gr2;
import defpackage.hg1;
import defpackage.is0;
import defpackage.k86;
import defpackage.l50;
import defpackage.m15;
import defpackage.ma3;
import defpackage.me1;
import defpackage.nq3;
import defpackage.py5;
import defpackage.qj5;
import defpackage.ro2;
import defpackage.sy5;
import defpackage.tg4;
import defpackage.ti0;
import defpackage.up0;
import defpackage.v4;
import defpackage.vi5;
import defpackage.wl1;
import defpackage.wq2;
import defpackage.xt1;
import defpackage.z66;
import defpackage.zn6;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FeedShowDetailFragment extends PagerFragment implements xt1.a {
    public boolean H;
    public boolean I;
    public LayoutSquareShowMediaViewBinding e;
    public View f;
    public MediaViewModel g;
    public View h;
    public View i;
    public DoubleClickView j;
    public SquareFeed k;
    public xt1 l;
    public String m;
    public String n;
    public long o;
    public int p;
    public LoopingSquareHackyViewPager r;
    public LoopingFeedMediaPageAdapter s;
    public int t;
    public boolean u;
    public String v;
    public boolean q = false;
    public String w = null;
    public up0 x = null;
    public Handler y = new Handler();
    public Runnable z = new k();
    public GestureDetector.OnDoubleTapListener A = new l();
    public boolean B = true;
    public boolean C = true;
    public ei5<BaseNetBean<SquareFeed>> E = new m();
    public ei5 F = new n();
    public ei5 G = new o();
    public int J = 0;
    public LXBottomSheetDialog.c K = new h();
    public m15 L = null;

    /* JADX INFO: compiled from: SearchBox */
    public class MediaViewBindingComponent extends SquareDataBindingComponent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FeedShowDetailFragment f16457a;

        public MediaViewBindingComponent(FeedShowDetailFragment feedShowDetailFragment) {
            this.f16457a = feedShowDetailFragment;
        }

        @Override // com.zenmen.square.mvp.SquareDataBindingComponent, androidx.databinding.DataBindingComponent
        public FeedShowDetailFragment getFeedShowDetailFragment() {
            return this.f16457a;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements d33.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareFeed f16458a;
        public final /* synthetic */ ExpandableTextView b;

        public a(SquareFeed squareFeed, ExpandableTextView expandableTextView) {
            this.f16458a = squareFeed;
            this.b = expandableTextView;
        }

        @Override // d33.a
        public void a(String str) {
            qj5.Z(this.f16458a);
            this.b.postInvalidate();
            bj5.b().a().c((FrameworkBaseActivity) FeedShowDetailFragment.this.getContext(), str, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ro2.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameworkBaseActivity f16459a;

        public b(FrameworkBaseActivity frameworkBaseActivity) {
            this.f16459a = frameworkBaseActivity;
        }

        @Override // ro2.b
        public void a(ContactInfoItem contactInfoItem) {
            this.f16459a.hideBaseProgressBar();
            if (FeedShowDetailFragment.this.isDetached()) {
                return;
            }
            FeedShowDetailFragment.this.g.e(contactInfoItem);
            FeedShowDetailFragment.this.u1(contactInfoItem);
        }

        @Override // ro2.b
        public void onError(String str) {
            this.f16459a.hideBaseProgressBar();
            if (FeedShowDetailFragment.this.isDetached()) {
                return;
            }
            sy5.f(FeedShowDetailFragment.this.getContext(), this.f16459a.getString(R$string.get_user_info_failed), 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ei5<BaseNetBean> {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends TypeToken<BaseNetBean> {
            public a() {
            }
        }

        public c() {
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            HashMap map = new HashMap();
            map.put("feedId", Long.valueOf(FeedShowDetailFragment.this.k.id));
            if (!TextUtils.isEmpty(FeedShowDetailFragment.this.k.exid)) {
                map.put("exFeedUid", FeedShowDetailFragment.this.k.exid);
            } else if (!TextUtils.isEmpty(FeedShowDetailFragment.this.m)) {
                map.put("exFeedUid", FeedShowDetailFragment.this.m);
            }
            if (!TextUtils.isEmpty(FeedShowDetailFragment.this.n)) {
                map.put("feedUid", FeedShowDetailFragment.this.n);
            }
            map.put("random", System.currentTimeMillis() + "");
            return new JSONObject(map);
        }

        @Override // defpackage.ei5
        public BaseNetBean handle(JSONObject jSONObject) {
            return BaseNetBean.createDefault(jSONObject, new a().getType());
        }

        @Override // defpackage.ei5
        public void onPostExecute(BaseNetBean baseNetBean) {
            try {
                FeedShowDetailFragment.this.getViewLifecycleOwner();
                if (baseNetBean != null) {
                    if (!baseNetBean.isSuccess()) {
                        FeedShowDetailFragment.this.w1(baseNetBean.getErrMsg());
                        return;
                    }
                    if (FeedShowDetailFragment.this.k.ifLike) {
                        SquareFeed squareFeed = FeedShowDetailFragment.this.k;
                        squareFeed.likeNums--;
                    } else {
                        FeedShowDetailFragment.this.k.likeNums++;
                    }
                    FeedShowDetailFragment.this.k.ifLike = !FeedShowDetailFragment.this.k.ifLike;
                    FeedShowDetailFragment.this.g.f(FeedShowDetailFragment.this.k);
                    SquareFeedEvent squareFeedEvent = new SquareFeedEvent();
                    squareFeedEvent.eventType = 2;
                    squareFeedEvent.feed = FeedShowDetailFragment.this.k;
                    an1.c().l(squareFeedEvent);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements ro2.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameworkBaseActivity f16462a;

        public d(FrameworkBaseActivity frameworkBaseActivity) {
            this.f16462a = frameworkBaseActivity;
        }

        @Override // ro2.b
        public void a(ContactInfoItem contactInfoItem) {
            this.f16462a.hideBaseProgressBar();
            if (FeedShowDetailFragment.this.isDetached()) {
                return;
            }
            FeedShowDetailFragment.this.g.e(contactInfoItem);
            FeedShowDetailFragment.this.W0(contactInfoItem);
        }

        @Override // ro2.b
        public void onError(String str) {
            this.f16462a.hideBaseProgressBar();
            if (FeedShowDetailFragment.this.isDetached()) {
                return;
            }
            sy5.f(FeedShowDetailFragment.this.getContext(), this.f16462a.getString(R$string.get_user_info_failed), 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements is0.f {
        public e() {
        }

        @Override // is0.f
        public void onItemClicked(int i) {
            if (i != 0) {
                return;
            }
            bi5.p("square.feed.delete.v1", FeedShowDetailFragment.this.F);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements is0.f {
        public f() {
        }

        @Override // is0.f
        public void onItemClicked(int i) {
            if (i != 0) {
                return;
            }
            zn6.c("pagediscover_feedpagedetail_morepopup_complaint", "click");
            bj5.b().a().z(FeedShowDetailFragment.this.getContext(), 901, FeedShowDetailFragment.this.k.exid, 8, 8);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements ro2.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareTagBean f16465a;

        public g(SquareTagBean squareTagBean) {
            this.f16465a = squareTagBean;
        }

        @Override // ro2.b
        public void a(ContactInfoItem contactInfoItem) {
            FeedShowDetailFragment.this.g.e(contactInfoItem);
            FeedShowDetailFragment.this.V0(this.f16465a, contactInfoItem);
        }

        @Override // ro2.b
        public void onError(String str) {
            FrameworkBaseActivity frameworkBaseActivityN0 = FeedShowDetailFragment.this.N0();
            if (frameworkBaseActivityN0 == null || FeedShowDetailFragment.this.isDetached()) {
                return;
            }
            frameworkBaseActivityN0.hideBaseProgressBar();
            sy5.f(FeedShowDetailFragment.this.getContext(), frameworkBaseActivityN0.getString(R$string.get_user_info_failed), 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements LXBottomSheetDialog.c {
        public h() {
        }

        @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog.c
        public void a(float f) {
            FeedShowDetailFragment.this.x.e(f, FeedShowDetailFragment.this.O0());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements DialogInterface.OnDismissListener {
        public i() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            FeedShowDetailFragment.this.x.a(FeedShowDetailFragment.this.O0());
            FeedShowDetailFragment.this.j1(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements nq3.b {
        public j() {
        }

        @Override // nq3.b
        public void a(int i, Object obj, int i2) {
            if (i == 1) {
                sy5.e(FeedShowDetailFragment.this.getContext(), R$string.square_comment_send_success, 1).g();
                return;
            }
            if (i == 2) {
                UnitedException unitedException = (UnitedException) obj;
                if (TextUtils.isEmpty(unitedException.getErrorMsg())) {
                    sy5.e(FeedShowDetailFragment.this.getContext(), R$string.square_http_error, 1).g();
                } else {
                    sy5.f(FeedShowDetailFragment.this.getContext(), unitedException.getErrorMsg(), 1).g();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FeedShowDetailFragment.this.getActivity() == null || FeedShowDetailFragment.this.getActivity().isFinishing()) {
                return;
            }
            FeedShowDetailFragment.this.getActivity().finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements GestureDetector.OnDoubleTapListener {
        public l() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (FeedShowDetailFragment.this.k == null) {
                return false;
            }
            new VideoLikeBigStar(FeedShowDetailFragment.this.getContext()).animBigStart((ViewGroup) FeedShowDetailFragment.this.f, motionEvent);
            FeedShowDetailFragment.this.K0();
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (FeedShowDetailFragment.this.k == null) {
                return false;
            }
            FeedShowDetailFragment.this.y1();
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements ei5<BaseNetBean<SquareFeed>> {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends TypeToken<BaseNetBean<SquareFeed>> {
            public a() {
            }
        }

        public m() {
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            HashMap map = new HashMap();
            map.put("feedId", Long.valueOf(FeedShowDetailFragment.this.o));
            if (!TextUtils.isEmpty(FeedShowDetailFragment.this.n)) {
                map.put("feedUid", FeedShowDetailFragment.this.n);
            }
            if (!TextUtils.isEmpty(FeedShowDetailFragment.this.m)) {
                map.put("feedExid", FeedShowDetailFragment.this.m);
            }
            LocationEx locationExI = com.zenmen.palmchat.location.d.g().i(86400000L);
            if (locationExI != null) {
                map.put("cityCode", locationExI.getCityCode());
                map.put("longitude", locationExI.getLongitude() + "");
                map.put("latitude", locationExI.getLatitude() + "");
            }
            return new JSONObject(map);
        }

        @Override // defpackage.ei5
        public BaseNetBean<SquareFeed> handle(JSONObject jSONObject) {
            BaseNetBean<SquareFeed> baseNetBeanCreateDefault = BaseNetBean.createDefault(jSONObject, new a().getType());
            if (baseNetBeanCreateDefault.isSuccess()) {
                ContactInfoItem contactInfoItemB = !TextUtils.isEmpty(FeedShowDetailFragment.this.m) ? dn0.b(FeedShowDetailFragment.this.m) : null;
                if (contactInfoItemB == null && !TextUtils.isEmpty(FeedShowDetailFragment.this.n)) {
                    contactInfoItemB = dn0.a(FeedShowDetailFragment.this.n);
                }
                String nameForShow = contactInfoItemB != null ? contactInfoItemB.getNameForShow() : null;
                if (!TextUtils.isEmpty(nameForShow)) {
                    baseNetBeanCreateDefault.data.nickname = nameForShow;
                }
            }
            return baseNetBeanCreateDefault;
        }

        @Override // defpackage.ei5
        public void onPostExecute(BaseNetBean<SquareFeed> baseNetBean) {
            SquareFeed squareFeed;
            boolean z = false;
            FeedShowDetailFragment.this.u = false;
            try {
                FeedShowDetailFragment.this.getViewLifecycleOwner();
                if (baseNetBean.isSuccess() && (squareFeed = baseNetBean.data) != null) {
                    squareFeed.isFirstRefresh = false;
                    FeedShowDetailFragment.this.G0(squareFeed);
                    SquareFeedEvent squareFeedEvent = new SquareFeedEvent();
                    squareFeedEvent.feed = baseNetBean.data;
                    squareFeedEvent.eventType = 2;
                    an1.c().l(squareFeedEvent);
                    return;
                }
                if (baseNetBean.isNetErr()) {
                    FeedShowDetailFragment.this.w1(baseNetBean.getErrMsg());
                    if (FeedShowDetailFragment.this.k == null || FeedShowDetailFragment.this.k.isEmptyFeed()) {
                        SquareFeed squareFeed2 = new SquareFeed();
                        squareFeed2.id = FeedShowDetailFragment.this.o;
                        squareFeed2.exid = FeedShowDetailFragment.this.m;
                        squareFeed2.uid = FeedShowDetailFragment.this.n;
                        qj5.t(FeedShowDetailFragment.this.p, squareFeed2, 0, FeedShowDetailFragment.this.v, FeedShowDetailFragment.this.w);
                        return;
                    }
                    return;
                }
                int i = baseNetBean.resultCode;
                if (i == 1016 || i == 1107) {
                    fi5 fi5Var = new fi5();
                    SquareFeed squareFeed3 = new SquareFeed();
                    fi5Var.f17534a = squareFeed3;
                    squareFeed3.id = FeedShowDetailFragment.this.o;
                    fi5Var.f17534a.deleted = 2;
                    ds0.a().b(fi5Var);
                    FeedShowDetailFragment feedShowDetailFragment = FeedShowDetailFragment.this;
                    if (feedShowDetailFragment.k.isTargetPosition && FeedShowDetailFragment.this.k.isFirstRefresh) {
                        z = true;
                    }
                    feedShowDetailFragment.L0(z);
                }
                if (baseNetBean.resultCode == -1003) {
                    FeedShowDetailFragment feedShowDetailFragment2 = FeedShowDetailFragment.this;
                    feedShowDetailFragment2.y.postDelayed(feedShowDetailFragment2.z, 2000L);
                }
                if (FeedShowDetailFragment.this.isResumed()) {
                    FeedShowDetailFragment.this.w1(baseNetBean.getErrMsg());
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements ei5<BaseNetBean> {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends TypeToken<BaseNetBean> {
            public a() {
            }
        }

        public n() {
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            HashMap map = new HashMap();
            map.put("feedId", Long.valueOf(FeedShowDetailFragment.this.k.id));
            return new JSONObject(map);
        }

        @Override // defpackage.ei5
        public BaseNetBean handle(JSONObject jSONObject) {
            return BaseNetBean.createDefault(jSONObject, new a().getType());
        }

        @Override // defpackage.ei5
        public void onPostExecute(BaseNetBean baseNetBean) {
            if (FeedShowDetailFragment.this.e == null) {
                return;
            }
            try {
                FeedShowDetailFragment.this.getViewLifecycleOwner();
                if (baseNetBean.isSuccess()) {
                    FeedShowDetailFragment.this.L0(false);
                    qj5.q(FeedShowDetailFragment.this.k, 1, FeedShowDetailFragment.this.p);
                } else {
                    FeedShowDetailFragment.this.w1(baseNetBean.getErrMsg());
                    qj5.q(FeedShowDetailFragment.this.k, 2, FeedShowDetailFragment.this.p);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements ei5<BaseNetBean<CheckResultBean>> {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends TypeToken<BaseNetBean<CheckResultBean>> {
            public a() {
            }
        }

        public o() {
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            HashMap map = new HashMap();
            if (!TextUtils.isEmpty(FeedShowDetailFragment.this.n)) {
                map.put("feedUid", FeedShowDetailFragment.this.n);
            }
            if (!TextUtils.isEmpty(FeedShowDetailFragment.this.m)) {
                map.put("feedExid", FeedShowDetailFragment.this.m);
            }
            map.put("feedId", Long.valueOf(FeedShowDetailFragment.this.o));
            return new JSONObject(map);
        }

        @Override // defpackage.ei5
        public BaseNetBean<CheckResultBean> handle(JSONObject jSONObject) {
            return BaseNetBean.createDefault(jSONObject, new a().getType());
        }

        @Override // defpackage.ei5
        public void onPostExecute(BaseNetBean<CheckResultBean> baseNetBean) {
            FeedShowDetailFragment.this.u = false;
            if (FeedShowDetailFragment.this.isResumed() && baseNetBean.isSuccess() && !baseNetBean.data.show) {
                if (FeedShowDetailFragment.this.isResumed()) {
                    FeedShowDetailFragment.this.w1("该动态已删除哦~");
                }
                FeedShowDetailFragment.this.L0(false);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FeedShowDetailFragment.this.d.o(FeedShowDetailFragment.this.k);
            FeedShowDetailFragment.this.d.n();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements Observer<ContactInfoItem> {
        public q() {
        }

        @Override // androidx.lifecycle.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable ContactInfoItem contactInfoItem) {
            if (FeedShowDetailFragment.this.k == null || TextUtils.isEmpty(FeedShowDetailFragment.this.k.uid)) {
                FeedShowDetailFragment.this.e.b.setVisibility(8);
            } else {
                FeedShowDetailFragment.this.e.b.setVisibility(0);
            }
            SquareFeed unused = FeedShowDetailFragment.this.k;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r implements Observer<SquareFeed> {
        public r() {
        }

        @Override // androidx.lifecycle.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(SquareFeed squareFeed) {
            if (squareFeed != null) {
                FeedShowDetailFragment.this.d.q(squareFeed);
            }
        }
    }

    public final void A1(int i2) {
        if (this.k.feedType == 3) {
            this.e.N.setVisibility(8);
            return;
        }
        this.e.N.setVisibility(0);
        this.e.f16235a.updateIndex(this.k.mediaList.size(), i2);
        this.e.N.setText((i2 + 1) + "/" + this.k.mediaList.size());
    }

    @Override // com.zenmen.square.lxpager.PagerFragment
    public View D() {
        return this.i;
    }

    @Override // com.zenmen.square.lxpager.PagerFragment
    public boolean E() {
        PhotoView photoViewQ0;
        SquareFeed squareFeed = this.k;
        if (squareFeed == null || squareFeed.feedType != 2 || (photoViewQ0 = Q0()) == null) {
            return false;
        }
        return photoViewQ0.isScaled();
    }

    @Override // com.zenmen.square.lxpager.PagerFragment
    public void F() {
        super.F();
        f1();
    }

    @Override // com.zenmen.square.lxpager.PagerFragment
    public void G(BasePagerBean basePagerBean, int i2) {
        if (basePagerBean instanceof SquareFeed) {
            this.k = (SquareFeed) basePagerBean;
        }
    }

    public final void G0(SquareFeed squareFeed) {
        Z0();
        if (this.B && isResumed()) {
            qj5.t(this.p, squareFeed, 1, this.v, this.w);
            this.B = false;
        }
        List<Media> list = squareFeed.mediaList;
        if (list == null || list.isEmpty()) {
            return;
        }
        SquareFeed squareFeed2 = this.k;
        squareFeed.imprId = squareFeed2.imprId;
        squareFeed.isTargetPosition = squareFeed2.isTargetPosition;
        this.k = squareFeed;
        LayoutSquareShowMediaViewBinding layoutSquareShowMediaViewBinding = (LayoutSquareShowMediaViewBinding) DataBindingUtil.bind(this.f, new MediaViewBindingComponent(this));
        this.e = layoutSquareShowMediaViewBinding;
        layoutSquareShowMediaViewBinding.h.setVisibility(0);
        this.g.f(squareFeed);
        this.e.p(squareFeed);
        this.e.q(this);
        this.e.setLifecycleOwner(this);
        this.g.d();
        int i2 = this.p;
        if (i2 == 8 || i2 == 15) {
            this.e.w.setVisibility(4);
            this.e.u.setVisibility(0);
        } else {
            this.e.u.setVisibility(8);
        }
        if (this.q) {
            this.q = false;
            ti0.c().d(getContext(), this.k, 4, this.p);
        }
        SquareSingleton.getInstance().addInScreenId(squareFeed.id);
    }

    public void I0(View view) {
        a46.C(view, R$anim.square_click_like_anim);
        z1();
    }

    @Override // com.zenmen.square.lxpager.PagerFragment
    public void J() {
        SquareFeed squareFeed = this.k;
        if (squareFeed == null || this.r == null || squareFeed.mediaList == null || E() || this.r.getCurrentItem() != this.k.mediaList.size() - 1) {
            return;
        }
        onAvatarClick(null);
    }

    @Override // com.zenmen.square.lxpager.PagerFragment
    public void K() {
        FrameworkBaseActivity frameworkBaseActivityN0;
        if (this.k == null || this.r == null || E() || this.r.getCurrentItem() != 0 || (frameworkBaseActivityN0 = N0()) == null) {
            return;
        }
        frameworkBaseActivityN0.onBackPressed();
    }

    public final void K0() {
        if (this.k.ifLike) {
            return;
        }
        z1();
    }

    @Override // com.zenmen.square.lxpager.PagerFragment
    public void L(hg1 hg1Var) {
        View view = this.f;
        if (view == null || hg1Var == null) {
            return;
        }
        hg1Var.t(view, view.findViewById(R$id.layout_mediaview));
    }

    public final void L0(boolean z) {
        if (isRemoving()) {
            return;
        }
        SquareFeedEvent squareFeedEvent = new SquareFeedEvent();
        squareFeedEvent.eventType = 3;
        squareFeedEvent.feed = this.k;
        an1.c().l(squareFeedEvent);
        fi5 fi5Var = new fi5();
        fi5Var.f17534a = this.k;
        ds0.a().b(fi5Var);
        if (!z) {
            this.d.m(this.k);
            this.d.n();
        } else {
            if (this.p == 47) {
                this.r.postDelayed(new p(), 100L);
                return;
            }
            this.d.m(this.k);
            this.d.n();
            N0().finish();
        }
    }

    @BindingAdapter({"feedDetailAvatarUrlShow"})
    public void M0(EffectiveShapeView effectiveShapeView, String str) {
        effectiveShapeView.setBorderColor(Color.parseColor("#ffffff"));
        gr2.j().h(k86.p(str), effectiveShapeView, a46.l());
    }

    public final FrameworkBaseActivity N0() {
        return (FrameworkBaseActivity) getActivity();
    }

    public final Media O0() {
        try {
            return this.k.mediaList.get(this.r.getCurrentItem());
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final PhotoView Q0() {
        LoopingFeedMediaPageAdapter loopingFeedMediaPageAdapter = this.s;
        if (loopingFeedMediaPageAdapter == null) {
            return null;
        }
        View viewL = loopingFeedMediaPageAdapter.l(this.t);
        if (viewL instanceof SquarePhotoView) {
            return ((SquarePhotoView) viewL).getPhotoView();
        }
        return null;
    }

    public final SquareDetailVideoView R0() {
        LoopingFeedMediaPageAdapter loopingFeedMediaPageAdapter = this.s;
        if (loopingFeedMediaPageAdapter == null) {
            return null;
        }
        View viewL = loopingFeedMediaPageAdapter.l(this.t);
        if (viewL instanceof SquareDetailVideoView) {
            return (SquareDetailVideoView) viewL;
        }
        return null;
    }

    public void S0(View view) {
        int i2 = this.p;
        if (i2 == 6 || i2 == 7) {
            getActivity().finish();
        } else {
            if (this.e == null) {
                return;
            }
            NestTopicFeedsActivity.G1(getActivity(), this.k.topicId, 4);
        }
    }

    public final void T0() {
        if (this.k == null) {
            return;
        }
        Bundle arguments = getArguments();
        this.w = arguments.getString("key_sid", "");
        this.v = arguments.getString("key_city_name", "");
        this.p = arguments.getInt("key_from", 0);
        this.q = arguments.getBoolean("key_show_comment", false);
        if (this.p == 11) {
            this.q = true;
        }
        if (this.k.isEmptyFeed()) {
            X0(this.o, this.m);
        } else {
            G0(this.k);
        }
        SquareFeed squareFeed = this.k;
        this.o = squareFeed.id;
        this.m = squareFeed.exid;
        this.n = squareFeed.uid;
    }

    public final void V0(SquareTagBean squareTagBean, ContactInfoItem contactInfoItem) {
        FrameworkBaseActivity frameworkBaseActivityN0 = N0();
        if (frameworkBaseActivityN0 == null) {
            return;
        }
        frameworkBaseActivityN0.hideBaseProgressBar();
        NestTagFeedsActivity.L1(frameworkBaseActivityN0, contactInfoItem, squareTagBean, 4);
    }

    public final void W0(ContactInfoItem contactInfoItem) {
        if (contactInfoItem == null) {
            qj5.g0(this.k, 0, this.p);
            return;
        }
        String strC = az2.c(SquareFeedForChatCard.parse(this.g.b()));
        if (contactInfoItem.getIsStranger()) {
            qj5.g0(this.k, 0, this.p);
            bj5.b().a().r(getActivity(), contactInfoItem, strC);
        } else {
            qj5.g0(this.k, 1, this.p);
            bj5.b().a().B(getActivity(), contactInfoItem, strC);
        }
    }

    public final void X0(long j2, String str) {
        if (this.u) {
            return;
        }
        this.u = true;
        if (TextUtils.isEmpty(this.m) && !TextUtils.isEmpty(this.n)) {
            bi5.p("square.feed.get.session.v8", this.E);
        } else if (this.p == 15) {
            bi5.p("square.feed.get.session.v8", this.E);
        } else {
            bi5.p("square.feed.get.v9", this.E);
        }
    }

    @Override // xt1.a
    public void Y0(SquareFeedEvent squareFeedEvent) {
        SquareFeed squareFeed = this.k;
        if (squareFeed != null && squareFeedEvent.eventType == 2 && squareFeed.mergeByNewUpdate(squareFeedEvent.feed)) {
            this.e.invalidateAll();
            this.e.executePendingBindings();
        }
    }

    public final void Z0() {
        this.g.a().observe(getViewLifecycleOwner(), new q());
        this.g.c().observe(getViewLifecycleOwner(), new r());
    }

    public void a1() {
        MediaViewModel mediaViewModel;
        qj5.E(this.k, 100, this.p);
        if (this.e == null || (mediaViewModel = this.g) == null || mediaViewModel.b() == null) {
            return;
        }
        SquareFeed squareFeedB = this.g.b();
        ContactInfoItem value = this.g.a().getValue();
        FrameworkBaseActivity frameworkBaseActivity = (FrameworkBaseActivity) getActivity();
        if (frameworkBaseActivity == null) {
            return;
        }
        if (value != null) {
            u1(value);
        } else {
            frameworkBaseActivity.showBaseProgressBar("", false);
            bj5.b().a().q(squareFeedB.exid, new b(frameworkBaseActivity));
        }
    }

    public void b1() {
        zn6.c("pagediscover_feedpagedetail_more", "click");
        if (this.e == null || getContext() == null) {
            return;
        }
        is0.f eVar = new e();
        FrameworkBaseActivity frameworkBaseActivity = (FrameworkBaseActivity) getActivity();
        if (TextUtils.equals(this.k.uid, v4.e(getContext()))) {
            frameworkBaseActivity.showPopupMenu(frameworkBaseActivity, this.h, new String[]{getResources().getString(R$string.delete)}, new int[]{R$drawable.ic_square_media_view_delete}, eVar, null);
        } else {
            frameworkBaseActivity.showPopupMenu(frameworkBaseActivity, this.h, new String[]{getResources().getString(R$string.complaint)}, new int[]{R$drawable.ic_square_media_view_complaint}, new f(), null);
        }
    }

    public final void c1() {
        qj5.m0(this.g.b().tagId, this.g.b().id);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (this.p == 5) {
            activity.finish();
            return;
        }
        SquareFeed squareFeedB = this.g.b();
        ContactInfoItem value = this.g.a().getValue();
        SquareTagBean squareTagBeanN = ai5.k().n(squareFeedB.tagId);
        N0().showBaseProgressBar("", false);
        if (value == null) {
            bj5.b().a().q(squareFeedB.exid, new g(squareTagBeanN));
        } else {
            V0(squareTagBeanN, value);
        }
    }

    public void e1(View view) {
        MediaViewModel mediaViewModel;
        if (this.e == null || l50.a() || (mediaViewModel = this.g) == null || mediaViewModel.b() == null || this.k == null) {
            return;
        }
        LayoutSquareShowMediaViewBinding layoutSquareShowMediaViewBinding = this.e;
        if (view == layoutSquareShowMediaViewBinding.F) {
            c1();
            return;
        }
        if (view == layoutSquareShowMediaViewBinding.r) {
            t1(view);
            return;
        }
        if (view == layoutSquareShowMediaViewBinding.l) {
            I0(view);
            return;
        }
        if (view == layoutSquareShowMediaViewBinding.g || view == layoutSquareShowMediaViewBinding.L) {
            onAvatarClick(view);
            return;
        }
        if (view == layoutSquareShowMediaViewBinding.v) {
            onChatBtnClick(view);
            return;
        }
        if (view == layoutSquareShowMediaViewBinding.b) {
            b1();
        } else if (view == layoutSquareShowMediaViewBinding.o) {
            a1();
        } else if (view == layoutSquareShowMediaViewBinding.G) {
            S0(view);
        }
    }

    public final void f1() {
        SquareFeed squareFeed = this.k;
        if (squareFeed == null || squareFeed.isEmptyFeed() || this.k.feedType != 3) {
            return;
        }
        LogUtil.e("logvideof", "onViewReAttachedToWindow");
        LogUtil.logStack("logvideof");
        LoopingFeedMediaPageAdapter loopingFeedMediaPageAdapter = new LoopingFeedMediaPageAdapter(getContext(), this.k, isResumed(), this.A);
        this.s = loopingFeedMediaPageAdapter;
        loopingFeedMediaPageAdapter.m(0);
        this.r.setAdapter(this.s);
        this.r.setOffscreenPageLimit(1);
        this.r.update(this.k.mediaList, 0);
    }

    @BindingAdapter({"setDetailWishesShow"})
    public void g1(LinearLayout linearLayout, SquareFeed squareFeed) {
        if (squareFeed == null) {
            return;
        }
        if (squareFeed.hasAe()) {
            TextView textView = (TextView) linearLayout.findViewById(R$id.tv_wishes_content);
            ImageView imageView = (ImageView) linearLayout.findViewById(R$id.iv_wishes_icon);
            textView.setText(squareFeed.aeName);
            if (TextUtils.isEmpty(squareFeed.aeIcon)) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                gr2.j().g(squareFeed.aeIcon, imageView);
                imageView.setColorFilter(Color.parseColor("#ffffff"));
            }
            linearLayout.setVisibility(0);
        } else {
            linearLayout.setVisibility(8);
        }
        if (squareFeed.canDelete()) {
            linearLayout.setVisibility(8);
        }
    }

    @Override // com.zenmen.square.lxpager.PagerFragment
    public String getSid() {
        return this.w;
    }

    @BindingAdapter({"setFeedDetailDescShow"})
    public void h1(ExpandableTextView expandableTextView, SquareFeed squareFeed) {
        if (squareFeed == null || this.H) {
            return;
        }
        String str = !TextUtils.isEmpty(squareFeed.content) ? squareFeed.content : "";
        if (!TextUtils.isEmpty(squareFeed.actionUrl)) {
            if (TextUtils.isEmpty(str)) {
                str = str + "  ";
            } else {
                str = str + "   ";
            }
        }
        SpannableString spannableString = new SpannableString(str);
        if (spannableString.length() <= 0) {
            expandableTextView.setVisibility(8);
            return;
        }
        expandableTextView.setVisibility(0);
        if (!TextUtils.isEmpty(squareFeed.actionUrl)) {
            int length = spannableString.length() - 2;
            int length2 = (spannableString.length() - 2) + 1;
            spannableString.setSpan(new wl1(expandableTextView.getContext(), R$drawable.icon_square_feed_detail_content_official_link, 2), length, length2, 18);
            spannableString.setSpan(new d33(squareFeed.actionUrl, expandableTextView.getContext().getResources().getColor(R$color.white), false, new a(squareFeed, expandableTextView)), length, length2, 18);
        }
        if (this.J == 0) {
            this.J = a46.m(getContext()).x - a46.b(getContext(), 99.0f);
        }
        expandableTextView.setOriginText(spannableString, this.J, squareFeed.id);
        this.H = true;
    }

    @BindingAdapter({"setFeedDetailDesc2Show"})
    public void i1(ExpandableTextView expandableTextView, SquareFeed squareFeed) {
        if (this.I) {
            return;
        }
        this.I = true;
        if (this.J == 0) {
            this.J = a46.m(getContext()).x - a46.b(getContext(), 99.0f);
        }
        expandableTextView.setOriginText(squareFeed.content, this.J, squareFeed.id);
    }

    public void j1(boolean z) {
        View viewC1 = getActivity() instanceof ShowMainActivity ? ((ShowMainActivity) getActivity()).C1() : null;
        if (z) {
            this.i.setVisibility(0);
            if (viewC1 != null) {
                viewC1.setVisibility(0);
                return;
            }
            return;
        }
        this.i.setVisibility(4);
        if (viewC1 != null) {
            viewC1.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k1(Media media) {
        long j2;
        boolean z = media.getPicSource() == 0;
        int i2 = z ? R$drawable.icon_square_remember : R$drawable.icon_feed_location;
        String str = z ? media.location : this.k.location;
        if (z) {
            j2 = media.shootingTime;
            if (j2 <= 0) {
                j2 = this.k.createTime;
            }
        }
        String strF = cy5.f(j2);
        this.e.m.setImageResource(i2);
        this.e.n.setImageResource(i2);
        if (TextUtils.isEmpty(str)) {
            this.e.H.setVisibility(8);
            this.e.I.setVisibility(8);
        } else {
            this.e.H.setVisibility(0);
            this.e.H.setText(str);
            this.e.I.setVisibility(0);
            this.e.I.setText(str);
        }
        this.e.J.setText(strF);
        this.e.K.setText(strF);
    }

    @BindingAdapter({"setMediaShow"})
    public void l1(ViewGroup viewGroup, SquareFeed squareFeed) {
        List<Media> list;
        if (this.k == null || (list = squareFeed.mediaList) == null || list.isEmpty() || this.s != null) {
            return;
        }
        LoopingFeedMediaPageAdapter loopingFeedMediaPageAdapter = new LoopingFeedMediaPageAdapter(getContext(), this.k, isResumed(), this.A);
        this.s = loopingFeedMediaPageAdapter;
        loopingFeedMediaPageAdapter.m(this.k.targetMediaPosition);
        A1(this.k.targetMediaPosition);
        this.r.setAdapter(this.s);
        this.r.setOffscreenPageLimit(1);
        LoopingSquareHackyViewPager loopingSquareHackyViewPager = this.r;
        SquareFeed squareFeed2 = this.k;
        loopingSquareHackyViewPager.update(squareFeed2.mediaList, squareFeed2.targetMediaPosition);
        this.r.setIndicatorChangeListener(new s());
        this.k.targetMediaPosition = 0;
        this.r.setPageMargin(me1.b(getContext(), 17));
        k1(this.k.mediaList.get(0));
        if (this.k.feedType == 2) {
            this.j.setVisibility(8);
        } else {
            this.j.setOnDoubleTabListener(this.A);
            this.j.setVisibility(0);
        }
    }

    @BindingAdapter({"setNickNameShow"})
    public void m1(TextView textView, SquareFeed squareFeed) {
        if (squareFeed == null || textView == null) {
            return;
        }
        textView.setVisibility(0);
        if (squareFeed.official) {
            textView.setTextColor(getContext().getResources().getColor(R$color.Gg));
        } else {
            int iH = fg6.h(squareFeed.userExt);
            if (fg6.q(iH)) {
                textView.setTextColor(fg6.n(getContext(), iH));
            } else {
                textView.setTextColor(getContext().getResources().getColor(R$color.white));
            }
        }
        textView.setText(squareFeed.nickname);
    }

    @BindingAdapter({"setPublishTimeShow"})
    public void n1(TextView textView, long j2) {
        textView.setText(cy5.h(j2));
    }

    public void onArrowPress(View view) {
        getActivity().finish();
    }

    public void onAvatarClick(View view) {
        FragmentActivity activity;
        if (this.e == null || (activity = getActivity()) == null) {
            return;
        }
        if (this.p == 16) {
            activity.finish();
            return;
        }
        String str = this.e.o().uid;
        if (TextUtils.isEmpty(str)) {
            str = this.n;
        }
        z66.c(4, this.e.o().id, str, this.e.o().exid, this.e.o(), activity);
    }

    public void onChatBtnClick(View view) {
        MediaViewModel mediaViewModel;
        if (this.e == null || (mediaViewModel = this.g) == null || mediaViewModel.b() == null) {
            return;
        }
        SquareFeed squareFeedB = this.g.b();
        ContactInfoItem value = this.g.a().getValue();
        FrameworkBaseActivity frameworkBaseActivity = (FrameworkBaseActivity) getActivity();
        if (frameworkBaseActivity == null) {
            return;
        }
        if (value != null) {
            W0(value);
        } else {
            frameworkBaseActivity.showBaseProgressBar("", false);
            bj5.b().a().q(squareFeedB.exid, new d(frameworkBaseActivity));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R$layout.layout_square_show_media_view, viewGroup, false);
        this.f = viewInflate;
        this.h = viewInflate.findViewById(R$id.feed_detail_title_bar);
        this.i = this.f.findViewById(R$id.infoLayout);
        this.j = (DoubleClickView) this.f.findViewById(R$id.v_feed_detail_cover);
        this.r = (LoopingSquareHackyViewPager) this.f.findViewById(R$id.feed_media_viewpager);
        this.g = (MediaViewModel) ViewModelProviders.of(this).get(MediaViewModel.class);
        this.l = new xt1(this);
        this.x = new up0(this.f.findViewById(R$id.layout_mediaview));
        an1.c().p(this.l);
        T0();
        this.h.setPadding(0, a46.n(getContext()), 0, 0);
        return this.f;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        SquareFeed squareFeed;
        super.onDestroy();
        ma3.a("FeedShowDetailFragment onDestroy", new Object[0]);
        if (this.k != null) {
            SquareSingleton.getInstance().removeInScreenId(this.k.id);
        }
        if (R0() != null && (squareFeed = this.k) != null && squareFeed.feedType == 3) {
            qj5.s(squareFeed, R0().getPlayTime(), this.p);
        }
        SquareFeed squareFeed2 = this.k;
        if (squareFeed2 != null && squareFeed2.feedType == 2) {
            qj5.s(squareFeed2, -1L, this.p);
        }
        DoubleClickView doubleClickView = this.j;
        if (doubleClickView != null) {
            doubleClickView.setOnDoubleTabListener(null);
        }
        LayoutSquareShowMediaViewBinding layoutSquareShowMediaViewBinding = this.e;
        if (layoutSquareShowMediaViewBinding != null) {
            layoutSquareShowMediaViewBinding.p(null);
            this.e.q(null);
            this.e.unbind();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        an1.c().r(this.l);
        Handler handler = this.y;
        if (handler != null) {
            handler.removeCallbacks(this.z);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        SquareFeed squareFeed = this.k;
        if (squareFeed != null && squareFeed.feedType == 3 && R0() != null) {
            R0().pausePlayer();
        }
        if (this.k.feedType == 2) {
            wq2.a().f();
        }
        this.r.setAutoLooping(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        SquareFeed squareFeed = this.k;
        if (squareFeed != null) {
            if (squareFeed.isTargetPosition || squareFeed.isEmptyFeed()) {
                X0(this.o, this.m);
            } else {
                x1();
                if (this.B) {
                    qj5.t(this.p, this.k, 1, this.v, this.w);
                }
            }
            if (this.k.feedType == 3 && R0() != null) {
                R0().startPlay();
            }
        }
        this.r.setAutoLooping(true);
        if (this.k.feedType == 2) {
            wq2.a().d(this.k.getFeedId());
        }
    }

    @BindingAdapter({"setTagShow"})
    public void p1(TextView textView, int i2) {
        ai5.k().n(i2);
        textView.setVisibility(8);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.e.c.getLayoutParams();
        layoutParams.bottomToTop = R$id.tv_feed_detail_topic_name;
        this.e.c.setLayoutParams(layoutParams);
    }

    @BindingAdapter({"setTopicNameShow"})
    public void r1(TextView textView, String str) {
        boolean zB = tg4.b(textView.getContext(), com.kuaishou.weapon.p0.g.g);
        boolean zG = vi5.b().g();
        if (zB && !zG && !TextUtils.isEmpty(str)) {
            textView.setText(str);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.e.c.getLayoutParams();
            layoutParams.bottomToTop = R$id.tv_feed_detail_tag;
            this.e.c.setLayoutParams(layoutParams);
        }
    }

    @BindingAdapter({"setVipIconShow"})
    public void s1(ImageView imageView, SquareFeed squareFeed) {
        if (squareFeed == null || imageView == null) {
            return;
        }
        int iH = fg6.h(squareFeed.userExt);
        if (!fg6.q(iH)) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageResource(fg6.e(iH));
            imageView.setVisibility(0);
        }
    }

    public void t1(View view) {
        if (this.g.b().discussionNum == 0) {
            v1();
            return;
        }
        qj5.l(this.k, 100, this.p);
        ti0.c().e(getContext(), this.k, 100, this.p, this.K, new i());
        this.x.b(O0());
        j1(false);
    }

    public final void u1(ContactInfoItem contactInfoItem) {
        if (getActivity() instanceof ShowMainActivity) {
            ((ShowMainActivity) getActivity()).F1(contactInfoItem);
        }
    }

    public final void v1() {
        ti0.c().f(getActivity(), this.k, null, 100, this.p, new j());
    }

    public final void w1(String str) {
        py5.b().d(getContext(), str, 0);
    }

    public final void x1() {
        if (this.u) {
            return;
        }
        this.u = true;
        bi5.p("square.feed.status.check.v1", this.G);
    }

    public final void z1() {
        qj5.d0(this.k, 100, this.p, 0);
        if (this.e == null) {
            return;
        }
        bi5.c(this.k.ifLike, new c());
    }

    public final void y1() {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s implements LoopingViewPager.c {
        public s() {
        }

        @Override // com.zenmen.palmchat.widget.loopingvp.LoopingViewPager.c
        public void b(int i) {
            FeedShowDetailFragment.this.t = i;
            FeedShowDetailFragment.this.A1(i);
            if (FeedShowDetailFragment.this.k.mediaList.size() > i) {
                FeedShowDetailFragment feedShowDetailFragment = FeedShowDetailFragment.this;
                feedShowDetailFragment.k1(feedShowDetailFragment.k.mediaList.get(i));
            }
        }

        @Override // com.zenmen.palmchat.widget.loopingvp.LoopingViewPager.c
        public void a(int i, float f) {
        }
    }
}
