package com.zenmen.square.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
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
import androidx.viewpager.widget.ViewPager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.gson.reflect.TypeToken;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.palmchat.widget.photoview.PhotoView;
import com.zenmen.square.NestTagFeedsActivity;
import com.zenmen.square.NestTopicFeedsActivity;
import com.zenmen.square.R$anim;
import com.zenmen.square.R$color;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import com.zenmen.square.adapter.FeedMediaPageAdapter;
import com.zenmen.square.comment.struct.UnitedException;
import com.zenmen.square.databinding.LayoutSquareMediaViewBinding;
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
import com.zenmen.square.ui.widget.SquareDetailVideoView;
import com.zenmen.square.ui.widget.SquareHackyViewPager;
import com.zenmen.square.ui.widget.SquarePhotoView;
import defpackage.a46;
import defpackage.ai5;
import defpackage.an1;
import defpackage.az2;
import defpackage.b05;
import defpackage.bi5;
import defpackage.bj5;
import defpackage.c15;
import defpackage.cy5;
import defpackage.d33;
import defpackage.dn0;
import defpackage.ds0;
import defpackage.ei5;
import defpackage.fg6;
import defpackage.fi5;
import defpackage.gi5;
import defpackage.go2;
import defpackage.gr2;
import defpackage.hg1;
import defpackage.is0;
import defpackage.k86;
import defpackage.kj1;
import defpackage.l50;
import defpackage.m15;
import defpackage.ma3;
import defpackage.me1;
import defpackage.nq3;
import defpackage.py5;
import defpackage.q05;
import defpackage.qj5;
import defpackage.ro2;
import defpackage.si0;
import defpackage.sw4;
import defpackage.sy5;
import defpackage.tg4;
import defpackage.ti0;
import defpackage.uj5;
import defpackage.v05;
import defpackage.v4;
import defpackage.vi5;
import defpackage.wl1;
import defpackage.xt1;
import defpackage.z66;
import defpackage.zn6;
import defpackage.zw4;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FeedDetailFragment extends PagerFragment implements xt1.a {
    public boolean I;
    public boolean J;
    public AnimatorSet N;
    public LayoutSquareMediaViewBinding e;
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
    public SquareHackyViewPager r;
    public FeedMediaPageAdapter s;
    public int t;
    public boolean u;
    public String v;
    public boolean x;
    public boolean q = false;
    public String w = null;
    public boolean y = false;
    public Handler z = new Handler();
    public Runnable A = new k();
    public GestureDetector.OnDoubleTapListener B = new n();
    public boolean C = true;
    public boolean E = true;
    public ei5<BaseNetBean<SquareFeed>> F = new p();
    public ei5 G = new q();
    public ei5 H = new r();
    public int K = 0;
    public m15 L = null;
    public Runnable M = new i();
    public int O = 2;

    /* JADX INFO: compiled from: SearchBox */
    public class MediaViewBindingComponent extends SquareDataBindingComponent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FeedDetailFragment f16262a;

        public MediaViewBindingComponent(FeedDetailFragment feedDetailFragment) {
            this.f16262a = feedDetailFragment;
        }

        @Override // com.zenmen.square.mvp.SquareDataBindingComponent, androidx.databinding.DataBindingComponent
        public FeedDetailFragment getFeedDetailFragment() {
            return this.f16262a;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements d33.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareFeed f16264a;
        public final /* synthetic */ ExpandableTextView b;

        public b(SquareFeed squareFeed, ExpandableTextView expandableTextView) {
            this.f16264a = squareFeed;
            this.b = expandableTextView;
        }

        @Override // d33.a
        public void a(String str) {
            qj5.Z(this.f16264a);
            this.b.postInvalidate();
            bj5.b().a().c((FrameworkBaseActivity) FeedDetailFragment.this.getContext(), str, false);
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
            map.put("feedId", Long.valueOf(FeedDetailFragment.this.k.id));
            if (!TextUtils.isEmpty(FeedDetailFragment.this.k.exid)) {
                map.put("exFeedUid", FeedDetailFragment.this.k.exid);
            } else if (!TextUtils.isEmpty(FeedDetailFragment.this.m)) {
                map.put("exFeedUid", FeedDetailFragment.this.m);
            }
            if (!TextUtils.isEmpty(FeedDetailFragment.this.n)) {
                map.put("feedUid", FeedDetailFragment.this.n);
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
                FeedDetailFragment.this.getViewLifecycleOwner();
                if (baseNetBean != null) {
                    if (!baseNetBean.isSuccess()) {
                        FeedDetailFragment.this.y1(baseNetBean.getErrMsg());
                        return;
                    }
                    if (FeedDetailFragment.this.k.ifLike) {
                        SquareFeed squareFeed = FeedDetailFragment.this.k;
                        squareFeed.likeNums--;
                    } else {
                        FeedDetailFragment.this.k.likeNums++;
                    }
                    FeedDetailFragment.this.k.ifLike = !FeedDetailFragment.this.k.ifLike;
                    FeedDetailFragment.this.g.f(FeedDetailFragment.this.k);
                    SquareFeedEvent squareFeedEvent = new SquareFeedEvent();
                    squareFeedEvent.eventType = 2;
                    squareFeedEvent.feed = FeedDetailFragment.this.k;
                    an1.c().l(squareFeedEvent);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements ro2.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameworkBaseActivity f16267a;

        public d(FrameworkBaseActivity frameworkBaseActivity) {
            this.f16267a = frameworkBaseActivity;
        }

        @Override // ro2.b
        public void a(ContactInfoItem contactInfoItem) {
            this.f16267a.hideBaseProgressBar();
            if (FeedDetailFragment.this.isDetached()) {
                return;
            }
            FeedDetailFragment.this.g.e(contactInfoItem);
            FeedDetailFragment.this.X0(contactInfoItem);
        }

        @Override // ro2.b
        public void onError(String str) {
            this.f16267a.hideBaseProgressBar();
            if (FeedDetailFragment.this.isDetached()) {
                return;
            }
            sy5.f(FeedDetailFragment.this.getContext(), this.f16267a.getString(R$string.get_user_info_failed), 0).g();
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
            bi5.p("square.feed.delete.v1", FeedDetailFragment.this.G);
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
            bj5.b().a().z(FeedDetailFragment.this.getContext(), 901, FeedDetailFragment.this.k.exid, 8, 8);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements ro2.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareTagBean f16270a;

        public g(SquareTagBean squareTagBean) {
            this.f16270a = squareTagBean;
        }

        @Override // ro2.b
        public void a(ContactInfoItem contactInfoItem) {
            FeedDetailFragment.this.g.e(contactInfoItem);
            FeedDetailFragment.this.W0(this.f16270a, contactInfoItem);
        }

        @Override // ro2.b
        public void onError(String str) {
            FrameworkBaseActivity frameworkBaseActivityQ0 = FeedDetailFragment.this.Q0();
            if (frameworkBaseActivityQ0 == null || FeedDetailFragment.this.isDetached()) {
                return;
            }
            frameworkBaseActivityQ0.hideBaseProgressBar();
            sy5.f(FeedDetailFragment.this.getContext(), frameworkBaseActivityQ0.getString(R$string.get_user_info_failed), 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements nq3.b {
        public h() {
        }

        @Override // nq3.b
        public void a(int i, Object obj, int i2) {
            if (i == 1) {
                sy5.e(FeedDetailFragment.this.getContext(), R$string.square_comment_send_success, 1).g();
                return;
            }
            if (i == 2) {
                UnitedException unitedException = (UnitedException) obj;
                if (TextUtils.isEmpty(unitedException.getErrorMsg())) {
                    sy5.e(FeedDetailFragment.this.getContext(), R$string.square_http_error, 1).g();
                } else {
                    sy5.f(FeedDetailFragment.this.getContext(), unitedException.getErrorMsg(), 1).g();
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
            if (FeedDetailFragment.this.getActivity() == null || FeedDetailFragment.this.getActivity().isFinishing()) {
                return;
            }
            FeedDetailFragment.this.getActivity().finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements GestureDetector.OnDoubleTapListener {
        public n() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (FeedDetailFragment.this.k == null) {
                return false;
            }
            new VideoLikeBigStar(FeedDetailFragment.this.getContext()).animBigStart((ViewGroup) FeedDetailFragment.this.f, motionEvent);
            FeedDetailFragment.this.N0();
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (FeedDetailFragment.this.k == null) {
                return false;
            }
            FeedDetailFragment.this.B1();
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            q05.a("postboost_entrance_postdetail", 2, null);
            bj5.b().a().K(FeedDetailFragment.this.getContext(), MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_VIDEO_BUFLEN, FeedDetailFragment.this.k);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements ei5<BaseNetBean<SquareFeed>> {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends TypeToken<BaseNetBean<SquareFeed>> {
            public a() {
            }
        }

        public p() {
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            HashMap map = new HashMap();
            map.put("feedId", Long.valueOf(FeedDetailFragment.this.o));
            if (!TextUtils.isEmpty(FeedDetailFragment.this.n)) {
                map.put("feedUid", FeedDetailFragment.this.n);
            }
            if (!TextUtils.isEmpty(FeedDetailFragment.this.m)) {
                map.put("feedExid", FeedDetailFragment.this.m);
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
                ContactInfoItem contactInfoItemB = !TextUtils.isEmpty(FeedDetailFragment.this.m) ? dn0.b(FeedDetailFragment.this.m) : null;
                if (contactInfoItemB == null && !TextUtils.isEmpty(FeedDetailFragment.this.n)) {
                    contactInfoItemB = dn0.a(FeedDetailFragment.this.n);
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
            FeedDetailFragment.this.u = false;
            try {
                FeedDetailFragment.this.getViewLifecycleOwner();
                if (baseNetBean.isSuccess() && (squareFeed = baseNetBean.data) != null) {
                    squareFeed.isFirstRefresh = false;
                    FeedDetailFragment.this.L0(squareFeed);
                    SquareFeedEvent squareFeedEvent = new SquareFeedEvent();
                    squareFeedEvent.feed = baseNetBean.data;
                    squareFeedEvent.eventType = 2;
                    an1.c().l(squareFeedEvent);
                    return;
                }
                if (baseNetBean.isNetErr()) {
                    FeedDetailFragment.this.y1(baseNetBean.getErrMsg());
                    if (FeedDetailFragment.this.k == null || FeedDetailFragment.this.k.isEmptyFeed()) {
                        SquareFeed squareFeed2 = new SquareFeed();
                        squareFeed2.id = FeedDetailFragment.this.o;
                        squareFeed2.exid = FeedDetailFragment.this.m;
                        squareFeed2.uid = FeedDetailFragment.this.n;
                        qj5.t(FeedDetailFragment.this.p, squareFeed2, 0, FeedDetailFragment.this.v, FeedDetailFragment.this.w);
                        return;
                    }
                    return;
                }
                int i = baseNetBean.resultCode;
                if (i == 1016 || i == 1107) {
                    fi5 fi5Var = new fi5();
                    SquareFeed squareFeed3 = new SquareFeed();
                    fi5Var.f17534a = squareFeed3;
                    squareFeed3.id = FeedDetailFragment.this.o;
                    fi5Var.f17534a.deleted = 2;
                    ds0.a().b(fi5Var);
                    FeedDetailFragment feedDetailFragment = FeedDetailFragment.this;
                    if (feedDetailFragment.k.isTargetPosition && FeedDetailFragment.this.k.isFirstRefresh) {
                        z = true;
                    }
                    feedDetailFragment.O0(z);
                }
                if (baseNetBean.resultCode == -1003) {
                    FeedDetailFragment feedDetailFragment2 = FeedDetailFragment.this;
                    feedDetailFragment2.z.postDelayed(feedDetailFragment2.A, 2000L);
                }
                if (FeedDetailFragment.this.isResumed()) {
                    FeedDetailFragment.this.y1(baseNetBean.getErrMsg());
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements ei5<BaseNetBean> {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends TypeToken<BaseNetBean> {
            public a() {
            }
        }

        public q() {
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            HashMap map = new HashMap();
            map.put("feedId", Long.valueOf(FeedDetailFragment.this.k.id));
            return new JSONObject(map);
        }

        @Override // defpackage.ei5
        public BaseNetBean handle(JSONObject jSONObject) {
            return BaseNetBean.createDefault(jSONObject, new a().getType());
        }

        @Override // defpackage.ei5
        public void onPostExecute(BaseNetBean baseNetBean) {
            if (FeedDetailFragment.this.e == null) {
                return;
            }
            try {
                FeedDetailFragment.this.getViewLifecycleOwner();
                if (baseNetBean.isSuccess()) {
                    FeedDetailFragment.this.O0(false);
                    qj5.q(FeedDetailFragment.this.k, 1, FeedDetailFragment.this.p);
                } else {
                    FeedDetailFragment.this.y1(baseNetBean.getErrMsg());
                    qj5.q(FeedDetailFragment.this.k, 2, FeedDetailFragment.this.p);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r implements ei5<BaseNetBean<CheckResultBean>> {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends TypeToken<BaseNetBean<CheckResultBean>> {
            public a() {
            }
        }

        public r() {
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            HashMap map = new HashMap();
            if (!TextUtils.isEmpty(FeedDetailFragment.this.n)) {
                map.put("feedUid", FeedDetailFragment.this.n);
            }
            if (!TextUtils.isEmpty(FeedDetailFragment.this.m)) {
                map.put("feedExid", FeedDetailFragment.this.m);
            }
            map.put("feedId", Long.valueOf(FeedDetailFragment.this.o));
            return new JSONObject(map);
        }

        @Override // defpackage.ei5
        public BaseNetBean<CheckResultBean> handle(JSONObject jSONObject) {
            return BaseNetBean.createDefault(jSONObject, new a().getType());
        }

        @Override // defpackage.ei5
        public void onPostExecute(BaseNetBean<CheckResultBean> baseNetBean) {
            FeedDetailFragment.this.u = false;
            if (FeedDetailFragment.this.isResumed() && baseNetBean.isSuccess() && !baseNetBean.data.show) {
                if (FeedDetailFragment.this.isResumed()) {
                    FeedDetailFragment.this.y1("该动态已删除哦~");
                }
                FeedDetailFragment.this.O0(false);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s implements Runnable {
        public s() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FeedDetailFragment.this.d.o(FeedDetailFragment.this.k);
            FeedDetailFragment.this.d.n();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t implements Observer<ContactInfoItem> {
        public t() {
        }

        @Override // androidx.lifecycle.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable ContactInfoItem contactInfoItem) {
            boolean z = false;
            if (FeedDetailFragment.this.k == null || TextUtils.isEmpty(FeedDetailFragment.this.k.uid)) {
                FeedDetailFragment.this.e.f16232a.setVisibility(8);
            } else {
                FeedDetailFragment.this.e.f16232a.setVisibility(0);
            }
            if (contactInfoItem != null && !contactInfoItem.getIsStranger()) {
                z = true;
            }
            FeedDetailFragment.this.e.X.setText(z ? FeedDetailFragment.this.getString(R$string.square_btn_go_normal_chat) : ai5.k().g().getSquareChatText(FeedDetailFragment.this.getContext()));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u implements Observer<SquareFeed> {
        public u() {
        }

        @Override // androidx.lifecycle.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(SquareFeed squareFeed) {
            if (squareFeed != null) {
                FeedDetailFragment.this.d.q(squareFeed);
            }
        }
    }

    public static /* synthetic */ int x0(FeedDetailFragment feedDetailFragment) {
        int i2 = feedDetailFragment.O;
        feedDetailFragment.O = i2 - 1;
        return i2;
    }

    public final void A1(View view) {
        AnimatorSet animatorSet = this.N;
        if (animatorSet == null || !animatorSet.isRunning()) {
            this.O = 2;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.7f);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.7f);
            objectAnimatorOfFloat.setDuration(500L);
            objectAnimatorOfFloat2.setDuration(500L);
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "scaleX", 0.7f, 1.0f);
            ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view, "scaleY", 0.7f, 1.0f);
            objectAnimatorOfFloat3.setDuration(500L);
            objectAnimatorOfFloat4.setDuration(500L);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.playTogether(objectAnimatorOfFloat3, objectAnimatorOfFloat4);
            AnimatorSet animatorSet4 = new AnimatorSet();
            this.N = animatorSet4;
            animatorSet4.playSequentially(animatorSet2, animatorSet3);
            this.N.addListener(new l());
            b05.d("开始动画" + this.O);
            this.N.start();
        }
    }

    public final void B1() {
        if (this.i.getVisibility() != 0) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(4);
        }
    }

    public final void C1() {
        qj5.d0(this.k, 4, this.p, 0);
        if (this.e == null) {
            return;
        }
        bi5.c(this.k.ifLike, new c());
    }

    @Override // com.zenmen.square.lxpager.PagerFragment
    public View D() {
        return this.i;
    }

    public final void D1(int i2) {
        if (this.k.feedType == 3) {
            this.e.W.setVisibility(8);
            return;
        }
        this.e.W.setVisibility(0);
        this.e.W.setText((i2 + 1) + "/" + this.k.mediaList.size());
    }

    @Override // com.zenmen.square.lxpager.PagerFragment
    public boolean E() {
        PhotoView photoViewR0;
        SquareFeed squareFeed = this.k;
        if (squareFeed == null || squareFeed.feedType != 2 || (photoViewR0 = R0()) == null) {
            return false;
        }
        return photoViewR0.isScaled();
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
        FrameworkBaseActivity frameworkBaseActivityQ0;
        if (this.k == null || this.r == null || E() || this.r.getCurrentItem() != 0 || (frameworkBaseActivityQ0 = Q0()) == null) {
            return;
        }
        frameworkBaseActivityQ0.onBackPressed();
    }

    public void K0() {
        String str = q05.c() + "/square.feed.visit.v1";
        HashMap map = new HashMap();
        map.put("feedId", Long.valueOf(this.o));
        try {
            if (!TextUtils.isEmpty(this.n)) {
                map.put("feedUid", Long.valueOf(this.n));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.m)) {
            map.put("feedExid", this.m);
        }
        LocationEx locationExI = q05.i();
        if (locationExI != null) {
            map.put("cityCode", locationExI.getCityCode());
            map.put("latitude", Double.valueOf(locationExI.getLatitude()));
            map.put("longitude", Double.valueOf(locationExI.getLongitude()));
        }
        zw4.e(new m(str, map, false));
    }

    @Override // com.zenmen.square.lxpager.PagerFragment
    public void L(hg1 hg1Var) {
        View view = this.f;
        if (view == null || hg1Var == null) {
            return;
        }
        hg1Var.t(view, view.findViewById(R$id.layout_mediaview));
    }

    public final void L0(SquareFeed squareFeed) {
        a1();
        if (this.C && isResumed()) {
            qj5.t(this.p, squareFeed, 1, this.v, this.w);
            this.C = false;
        }
        List<Media> list = squareFeed.mediaList;
        if (list == null || list.isEmpty()) {
            return;
        }
        SquareFeed squareFeed2 = this.k;
        squareFeed.imprId = squareFeed2.imprId;
        squareFeed.isTargetPosition = squareFeed2.isTargetPosition;
        this.k = squareFeed;
        LayoutSquareMediaViewBinding layoutSquareMediaViewBinding = (LayoutSquareMediaViewBinding) DataBindingUtil.bind(this.f, new MediaViewBindingComponent(this));
        this.e = layoutSquareMediaViewBinding;
        layoutSquareMediaViewBinding.h.setVisibility(0);
        this.g.f(squareFeed);
        this.e.q(squareFeed);
        this.e.p(this);
        this.e.setLifecycleOwner(this);
        this.g.d();
        int i2 = this.p;
        if (i2 == 8 || i2 == 15) {
            this.e.B.setVisibility(4);
            this.e.z.setVisibility(0);
        } else {
            this.e.z.setVisibility(8);
        }
        if (this.q) {
            this.q = false;
            ti0.c().d(getContext(), this.k, 4, this.p);
        }
        SquareSingleton.getInstance().addInScreenId(squareFeed.id);
        if (kj1.b().c().booleanValue()) {
            ContactInfoItem contactInfoItemB = !TextUtils.isEmpty(this.m) ? dn0.b(this.m) : null;
            if (contactInfoItemB == null && !TextUtils.isEmpty(this.n)) {
                contactInfoItemB = dn0.a(this.n);
            }
            if (contactInfoItemB == null || contactInfoItemB.getUid() == null || q05.e() == null || q05.e().getUid() == null || !contactInfoItemB.getUid().equals(q05.e().getUid())) {
                this.e.x.setVisibility(8);
            } else {
                this.e.x.setVisibility(0);
                if (!this.y) {
                    this.y = true;
                    q05.a("postboost_entrance_postdetail", 1, null);
                }
                if (!this.x) {
                    this.x = true;
                    q05.n(this.e.G, "super_expose_v2_feed.svga");
                }
            }
        }
        this.e.x.setOnClickListener(new o());
    }

    public void M0(View view) {
        a46.C(view, R$anim.square_click_like_anim);
        C1();
    }

    public final void N0() {
        if (this.k.ifLike) {
            return;
        }
        C1();
    }

    public final void O0(boolean z) {
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
                this.r.postDelayed(new s(), 100L);
                return;
            }
            this.d.m(this.k);
            this.d.n();
            Q0().finish();
        }
    }

    public final FrameworkBaseActivity Q0() {
        return (FrameworkBaseActivity) getActivity();
    }

    public final PhotoView R0() {
        FeedMediaPageAdapter feedMediaPageAdapter = this.s;
        if (feedMediaPageAdapter == null) {
            return null;
        }
        View viewF = feedMediaPageAdapter.f(this.t);
        if (viewF instanceof SquarePhotoView) {
            return ((SquarePhotoView) viewF).getPhotoView();
        }
        return null;
    }

    public final SquareDetailVideoView S0() {
        FeedMediaPageAdapter feedMediaPageAdapter = this.s;
        if (feedMediaPageAdapter == null) {
            return null;
        }
        View viewF = feedMediaPageAdapter.f(this.t);
        if (viewF instanceof SquareDetailVideoView) {
            return (SquareDetailVideoView) viewF;
        }
        return null;
    }

    public void T0(View view) {
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

    public final void V0() {
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
            Z0(this.o, this.m);
        } else {
            L0(this.k);
        }
        SquareFeed squareFeed = this.k;
        this.o = squareFeed.id;
        this.m = squareFeed.exid;
        this.n = squareFeed.uid;
    }

    public final void W0(SquareTagBean squareTagBean, ContactInfoItem contactInfoItem) {
        FrameworkBaseActivity frameworkBaseActivityQ0 = Q0();
        if (frameworkBaseActivityQ0 == null) {
            return;
        }
        frameworkBaseActivityQ0.hideBaseProgressBar();
        NestTagFeedsActivity.L1(frameworkBaseActivityQ0, contactInfoItem, squareTagBean, 4);
    }

    public final void X0(ContactInfoItem contactInfoItem) {
        if (contactInfoItem == null) {
            qj5.g0(this.k, 0, this.p);
            return;
        }
        String strC = az2.c(SquareFeedForChatCard.parse(this.g.b()));
        if (!contactInfoItem.getIsStranger()) {
            qj5.g0(this.k, 1, this.p);
            bj5.b().a().B(getActivity(), contactInfoItem, strC);
            return;
        }
        int i2 = this.p;
        if (i2 == 109) {
            contactInfoItem.setSourceType(60);
            contactInfoItem.setBizType(bj5.b().a().C(109));
        } else if (i2 == 110) {
            contactInfoItem.setSourceType(60);
            contactInfoItem.setBizType(bj5.b().a().C(110));
        } else if (i2 == 111) {
            contactInfoItem.setSourceType(60);
            contactInfoItem.setBizType(bj5.b().a().C(111));
        }
        qj5.g0(this.k, 0, this.p);
        bj5.b().a().r(getActivity(), contactInfoItem, strC);
    }

    @Override // xt1.a
    public void Y0(SquareFeedEvent squareFeedEvent) {
        SquareFeed squareFeed = this.k;
        if (squareFeed != null && squareFeedEvent.eventType == 2 && squareFeed.mergeByNewUpdate(squareFeedEvent.feed)) {
            this.e.invalidateAll();
            this.e.executePendingBindings();
        }
    }

    public final void Z0(long j2, String str) {
        if (this.u) {
            return;
        }
        this.u = true;
        if (TextUtils.isEmpty(this.m) && !TextUtils.isEmpty(this.n)) {
            bi5.p("square.feed.get.session.v8", this.F);
        } else if (this.p == 15) {
            bi5.p("square.feed.get.session.v8", this.F);
        } else {
            bi5.p("square.feed.get.v9", this.F);
        }
    }

    public final void a1() {
        this.g.a().observe(getViewLifecycleOwner(), new t());
        this.g.c().observe(getViewLifecycleOwner(), new u());
    }

    public final void b1() {
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
        Q0().showBaseProgressBar("", false);
        if (value == null) {
            bj5.b().a().q(squareFeedB.exid, new g(squareTagBeanN));
        } else {
            W0(squareTagBeanN, value);
        }
    }

    public void c1(boolean z) {
        LinearLayout linearLayout;
        if (z) {
            LayoutSquareMediaViewBinding layoutSquareMediaViewBinding = this.e;
            if (layoutSquareMediaViewBinding != null && (linearLayout = layoutSquareMediaViewBinding.x) != null && linearLayout.getVisibility() == 0) {
                A1(this.e.G);
            }
            K0();
            return;
        }
        AnimatorSet animatorSet = this.N;
        if (animatorSet == null || !animatorSet.isRunning()) {
            return;
        }
        Iterator<Animator> it = this.N.getChildAnimations().iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
        this.N.cancel();
    }

    public void e1(View view) {
        MediaViewModel mediaViewModel;
        if (this.e == null || l50.a() || (mediaViewModel = this.g) == null || mediaViewModel.b() == null || this.k == null) {
            return;
        }
        LayoutSquareMediaViewBinding layoutSquareMediaViewBinding = this.e;
        if (view == layoutSquareMediaViewBinding.N) {
            b1();
            return;
        }
        if (view == layoutSquareMediaViewBinding.b || view == layoutSquareMediaViewBinding.t) {
            v1(view);
            return;
        }
        if (view == layoutSquareMediaViewBinding.l) {
            M0(view);
            return;
        }
        if (view == layoutSquareMediaViewBinding.g || view == layoutSquareMediaViewBinding.U) {
            onAvatarClick(view);
            return;
        }
        if (view == layoutSquareMediaViewBinding.A || view == layoutSquareMediaViewBinding.y) {
            onChatBtnClick(view);
        } else if (view == layoutSquareMediaViewBinding.f16232a) {
            onMoreBtnClick(view);
        } else if (view == layoutSquareMediaViewBinding.O) {
            T0(view);
        }
    }

    public final void f1() {
        SquareFeed squareFeed = this.k;
        if (squareFeed == null || squareFeed.isEmptyFeed() || this.k.feedType != 3) {
            return;
        }
        LogUtil.e("logvideof", "onViewReAttachedToWindow");
        LogUtil.logStack("logvideof");
        FeedMediaPageAdapter feedMediaPageAdapter = new FeedMediaPageAdapter(getContext(), this.k, isResumed());
        this.s = feedMediaPageAdapter;
        feedMediaPageAdapter.i(0);
        this.r.setAdapter(this.s);
        this.r.setCurrentItem(0, true);
        this.s.notifyDataSetChanged();
    }

    @BindingAdapter({"feedDetailAvatarUrl"})
    public void g1(EffectiveShapeView effectiveShapeView, String str) {
        effectiveShapeView.setBorderColor(Color.parseColor("#ffffff"));
        gr2.j().h(k86.p(str), effectiveShapeView, a46.l());
    }

    @Override // com.zenmen.square.lxpager.PagerFragment
    public String getSid() {
        return this.w;
    }

    @BindingAdapter({"setBottomString"})
    public void h1(TextView textView, String str) {
        textView.setText(si0.b(textView.getContext()));
    }

    @BindingAdapter({"setChatBtn"})
    public void i1(LinearLayout linearLayout, SquareFeed squareFeed) {
        if (squareFeed.canDelete()) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
        }
    }

    @BindingAdapter({"setDetailWishes"})
    public void j1(LinearLayout linearLayout, SquareFeed squareFeed) {
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

    @BindingAdapter({"setFeedDetailDesc"})
    public void k1(ExpandableTextView expandableTextView, SquareFeed squareFeed) {
        if (squareFeed == null || this.I) {
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
            spannableString.setSpan(new d33(squareFeed.actionUrl, expandableTextView.getContext().getResources().getColor(R$color.white), false, new b(squareFeed, expandableTextView)), length, length2, 18);
        }
        if (this.K == 0) {
            this.K = a46.m(getContext()).x - a46.b(getContext(), 99.0f);
        }
        expandableTextView.setOriginText(spannableString, this.K, squareFeed.id);
        this.I = true;
    }

    @BindingAdapter({"setFeedDetailDesc2"})
    public void l1(ExpandableTextView expandableTextView, SquareFeed squareFeed) {
        if (this.J) {
            return;
        }
        this.J = true;
        if (this.K == 0) {
            this.K = a46.m(getContext()).x - a46.b(getContext(), 99.0f);
        }
        expandableTextView.setOriginText(squareFeed.content, this.K, squareFeed.id);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m1(Media media) {
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
        this.e.n.setImageResource(i2);
        this.e.o.setImageResource(i2);
        if (TextUtils.isEmpty(str)) {
            this.e.P.setVisibility(8);
            this.e.Q.setVisibility(8);
        } else {
            this.e.P.setVisibility(0);
            this.e.P.setText(str);
            this.e.Q.setVisibility(0);
            this.e.Q.setText(str);
        }
        this.e.R.setText(strF);
        this.e.S.setText(strF);
    }

    @BindingAdapter({"setMedia"})
    public void n1(ViewGroup viewGroup, SquareFeed squareFeed) {
        List<Media> list;
        if (this.k == null || (list = squareFeed.mediaList) == null || list.isEmpty() || this.s != null) {
            return;
        }
        FeedMediaPageAdapter feedMediaPageAdapter = new FeedMediaPageAdapter(getContext(), this.k, isResumed());
        this.s = feedMediaPageAdapter;
        feedMediaPageAdapter.i(this.k.targetMediaPosition);
        D1(this.k.targetMediaPosition);
        this.r.setAdapter(this.s);
        this.r.setCurrentItem(this.k.targetMediaPosition, true);
        this.k.targetMediaPosition = 0;
        this.r.setPageMargin(me1.b(getContext(), 17));
        this.r.addOnPageChangeListener(new a());
        m1(this.k.mediaList.get(0));
        if (R0() == null) {
            this.j.setOnDoubleTabListener(this.B);
            this.j.setVisibility(0);
            return;
        }
        for (View view : this.s.g()) {
            if (view instanceof SquarePhotoView) {
                SquarePhotoView squarePhotoView = (SquarePhotoView) view;
                if (squarePhotoView.getPhotoView() != null) {
                    squarePhotoView.getPhotoView().setOnDoubleTapListener(this.B);
                }
            }
        }
        this.j.setVisibility(8);
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
        String str2 = str;
        int i2 = this.p;
        if (i2 == 109 || i2 == 110 || i2 == 111) {
            z66.g(i2, this.e.o().id, str2, this.e.o().exid, this.e.o(), activity, 60, bj5.b().a().C(this.p));
        } else {
            z66.c(4, this.e.o().id, str2, this.e.o().exid, this.e.o(), activity);
        }
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
            X0(value);
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
        View viewInflate = layoutInflater.inflate(R$layout.layout_square_media_view, viewGroup, false);
        this.f = viewInflate;
        this.h = viewInflate.findViewById(R$id.feed_detail_title_bar);
        this.i = this.f.findViewById(R$id.infoLayout);
        this.j = (DoubleClickView) this.f.findViewById(R$id.v_feed_detail_cover);
        this.r = (SquareHackyViewPager) this.f.findViewById(R$id.feed_media_viewpager);
        this.g = (MediaViewModel) ViewModelProviders.of(this).get(MediaViewModel.class);
        this.l = new xt1(this);
        an1.c().p(this.l);
        V0();
        this.h.setPadding(0, a46.n(getContext()), 0, 0);
        return this.f;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        List<View> listG;
        SquareFeed squareFeed;
        super.onDestroy();
        ma3.a("FeedDetailFragment onDestroy", new Object[0]);
        if (this.k != null) {
            SquareSingleton.getInstance().removeInScreenId(this.k.id);
        }
        if (S0() != null && (squareFeed = this.k) != null && squareFeed.feedType == 3) {
            qj5.s(squareFeed, S0().getPlayTime(), this.p);
        }
        SquareFeed squareFeed2 = this.k;
        if (squareFeed2 != null && squareFeed2.feedType == 2) {
            qj5.s(squareFeed2, -1L, this.p);
        }
        FeedMediaPageAdapter feedMediaPageAdapter = this.s;
        if (feedMediaPageAdapter != null && (listG = feedMediaPageAdapter.g()) != null) {
            for (View view : listG) {
                if (view instanceof SquarePhotoView) {
                    SquarePhotoView squarePhotoView = (SquarePhotoView) view;
                    if (squarePhotoView.getPhotoView() != null) {
                        squarePhotoView.getPhotoView().setOnDoubleTapListener(null);
                    }
                }
            }
        }
        DoubleClickView doubleClickView = this.j;
        if (doubleClickView != null) {
            doubleClickView.setOnDoubleTabListener(null);
        }
        LayoutSquareMediaViewBinding layoutSquareMediaViewBinding = this.e;
        if (layoutSquareMediaViewBinding != null) {
            layoutSquareMediaViewBinding.q(null);
            this.e.p(null);
            this.e.unbind();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        an1.c().r(this.l);
        AnimatorSet animatorSet = this.N;
        if (animatorSet != null && animatorSet.isRunning()) {
            Iterator<Animator> it = this.N.getChildAnimations().iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            this.N.cancel();
        }
        Handler handler = this.z;
        if (handler != null) {
            handler.removeCallbacks(this.A);
        }
    }

    public void onMoreBtnClick(View view) {
        zn6.c("pagediscover_feedpagedetail_more", "click");
        if (this.e == null) {
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

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        c1(false);
        SquareFeed squareFeed = this.k;
        if (squareFeed != null && squareFeed.feedType == 3 && S0() != null) {
            S0().pausePlayer();
        }
        getView().removeCallbacks(this.M);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        c1(true);
        SquareFeed squareFeed = this.k;
        if (squareFeed != null) {
            if (squareFeed.isTargetPosition || squareFeed.isEmptyFeed()) {
                Z0(this.o, this.m);
            } else {
                z1();
                if (this.C) {
                    qj5.t(this.p, this.k, 1, this.v, this.w);
                }
            }
            if (this.k.feedType == 3 && S0() != null) {
                S0().startPlay();
            }
        }
        if (uj5.b()) {
            getView().removeCallbacks(this.M);
            getView().postDelayed(this.M, gi5.m());
        }
    }

    @BindingAdapter({"setNickName"})
    public void p1(TextView textView, SquareFeed squareFeed) {
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

    @BindingAdapter({"setPublishTime"})
    public void r1(TextView textView, long j2) {
        textView.setText(cy5.h(j2));
    }

    @BindingAdapter({"setTag"})
    public void s1(TextView textView, int i2) {
        ai5.k().n(i2);
        textView.setVisibility(8);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.e.c.getLayoutParams();
        layoutParams.bottomToTop = R$id.tv_feed_detail_topic_name;
        this.e.c.setLayoutParams(layoutParams);
    }

    @BindingAdapter({"setTopicName"})
    public void t1(TextView textView, String str) {
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

    @BindingAdapter({"setVipIcon"})
    public void u1(ImageView imageView, SquareFeed squareFeed) {
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

    public void v1(View view) {
        if (view == this.e.b) {
            qj5.i(this.k);
            w1();
        } else if (this.g.b().discussionNum == 0) {
            w1();
        } else {
            qj5.l(this.k, 4, this.p);
            ti0.c().d(getContext(), this.k, 4, this.p);
        }
    }

    public final void w1() {
        ti0.c().f(getActivity(), this.k, null, 4, this.p, new h());
    }

    public final void x1() {
        if (this.L == null || this.g.b() == null || this.g.b().canDelete()) {
            this.e.H.stopAnimation();
            this.e.H.setVisibility(8);
            return;
        }
        this.e.H.setVideoItem(this.L);
        this.e.H.setVisibility(0);
        this.e.H.startAnimation();
        this.e.H.setLoops(0);
        this.e.H.setCallback(new j());
    }

    public final void y1(String str) {
        py5.b().d(getContext(), str, 0);
    }

    public final void z1() {
        if (this.u) {
            return;
        }
        this.u = true;
        bi5.p("square.feed.status.check.v1", this.H);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements v05 {
        public j() {
        }

        @Override // defpackage.v05
        public void a() {
            FeedDetailFragment.this.e.H.setVisibility(8);
        }

        @Override // defpackage.v05
        public void c() {
            FeedDetailFragment.this.e.H.stopAnimation();
        }

        @Override // defpackage.v05
        public void onPause() {
        }

        @Override // defpackage.v05
        public void b(int i, double d) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Runnable {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements c15.d {
            public a() {
            }

            @Override // c15.d
            public void onComplete(@NonNull m15 m15Var) {
                FeedDetailFragment.this.L = m15Var;
                FeedDetailFragment.this.x1();
            }

            @Override // c15.d
            public void onError() {
                FeedDetailFragment.this.e.H.setVisibility(8);
            }
        }

        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (uj5.b() && FeedDetailFragment.this.g.b() != null) {
                if (FeedDetailFragment.this.L != null) {
                    FeedDetailFragment.this.x1();
                } else {
                    ContactInfoItem value = FeedDetailFragment.this.g.a().getValue();
                    new c15(FeedDetailFragment.this.getContext()).n((value == null || value.getIsStranger()) ? "sayhi.svga" : "sendmsg.svga", new a(), new b());
                }
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements c15.e {
            public b() {
            }

            @Override // c15.e
            public void onPlay(@NonNull List<? extends File> list) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            FeedDetailFragment.this.t = i;
            FeedDetailFragment.this.D1(i);
            if (FeedDetailFragment.this.k.mediaList.size() > i) {
                FeedDetailFragment feedDetailFragment = FeedDetailFragment.this;
                feedDetailFragment.m1(feedDetailFragment.k.mediaList.get(i));
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements Animator.AnimatorListener {
        public l() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b05.d("onAnimationEnd" + FeedDetailFragment.this.O);
            if (FeedDetailFragment.this.O > 0) {
                FeedDetailFragment.x0(FeedDetailFragment.this);
                FeedDetailFragment.this.N.start();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m extends go2<LXBaseNetBean<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f16278a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ boolean c;

        public m(String str, HashMap map, boolean z) {
            this.f16278a = str;
            this.b = map;
            this.c = z;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, this.f16278a, this.b).f(this.c);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<String> lXBaseNetBean, Exception exc) {
        }
    }
}
