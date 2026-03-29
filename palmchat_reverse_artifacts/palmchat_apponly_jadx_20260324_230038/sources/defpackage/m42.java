package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.square.R$string;
import com.zenmen.square.comment.struct.SquareCommentBean;
import com.zenmen.square.comment.struct.UnitedException;
import com.zenmen.square.fragment.FriendMessageFragment;
import com.zenmen.square.mvp.model.bean.PlaceFeed;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.fk2;
import defpackage.nq3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class m42 extends zi5<FriendMessageFragment, l42, PlaceFeed> {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements nq3.b {
        public a() {
        }

        @Override // nq3.b
        public void a(int i, Object obj, int i2) {
            if (i == 1) {
                sy5.e(((FriendMessageFragment) m42.this.f11844a).getActivity(), R$string.square_comment_send_success, 1).g();
                return;
            }
            if (i == 2) {
                UnitedException unitedException = (UnitedException) obj;
                if (TextUtils.isEmpty(unitedException.getErrorMsg())) {
                    sy5.e(((FriendMessageFragment) m42.this.f11844a).getActivity(), R$string.square_http_error, 1).g();
                } else {
                    sy5.f(((FriendMessageFragment) m42.this.f11844a).getActivity(), unitedException.getErrorMsg(), 1).g();
                }
            }
        }
    }

    public m42(FriendMessageFragment friendMessageFragment, l42 l42Var) {
        super(friendMessageFragment, l42Var);
    }

    public void A(int i, PlaceFeed placeFeed) {
        qj5.c(o(), placeFeed.feed.getFeedId().longValue(), placeFeed.comment.getFromUid(), null, null);
        fk2.a aVar = new fk2.a();
        Bundle bundle = new Bundle();
        bundle.putString(DeviceInfoUtil.UID_TAG, placeFeed.comment.getFromUid());
        aVar.b(bundle);
        ((FriendMessageFragment) this.f11844a).W().startActivity(n5.a(((FriendMessageFragment) this.f11844a).W(), aVar));
    }

    public void B(PlaceFeed placeFeed) {
        ContactInfoItem contactInfoItemA = dn0.a(placeFeed.comment.getFromUid());
        if (contactInfoItemA != null) {
            n40.b(contactInfoItemA, ((FriendMessageFragment) this.f11844a).getActivity());
        }
    }

    public void C(int i, PlaceFeed placeFeed, ImageView imageView) {
        Intent intent = new Intent();
        if (placeFeed.feed.getFeedType() == 3 || placeFeed.feed.getFeedType() == 2) {
            intent = nq3.a().b(((FriendMessageFragment) this.f11844a).W(), null, placeFeed.feed.getFeedId(), placeFeed.feed.getUid(), "", 19, null);
        } else if (placeFeed.feed.getFeedType() == 1 || placeFeed.feed.getFeedType() == 6 || placeFeed.feed.getFeedType() == 7 || placeFeed.feed.getFeedType() == 4) {
            intent.setAction("com.zenmen.square.MOMENTS_HALF");
            intent.putExtra("feed_type", placeFeed.feed.getFeedType());
            intent.putExtra("extra_feed_id", placeFeed.feed.getFeedId());
            intent.putExtra("extra_feed_uid", placeFeed.feed.getUid());
        } else if (placeFeed.feed.getFeedType() != 8) {
            return;
        }
        if (placeFeed.comment.getType() != tq3.d) {
            intent.putExtra("extra_operator_id", placeFeed.comment.getCommentUid());
            intent.putExtra("key_show_comment", true);
        }
        ((FriendMessageFragment) this.f11844a).W().startActivity(intent);
    }

    public void D(PlaceFeed placeFeed) {
        SquareFeed squareFeedConvertToSquareFeed = SquareFeed.convertToSquareFeed(placeFeed.feed);
        SquareCommentBean squareCommentBean = new SquareCommentBean();
        squareCommentBean.businessFrom = 1;
        squareCommentBean.exFeedUid = squareFeedConvertToSquareFeed.uid;
        squareCommentBean.feedId = squareFeedConvertToSquareFeed.id;
        squareCommentBean.exFromUid = placeFeed.comment.getFromUid();
        squareCommentBean.id = placeFeed.comment.getId().longValue();
        squareCommentBean.nickname = placeFeed.comment.getCommentCreatorName();
        squareCommentBean.exToUid = placeFeed.comment.getToUid();
        ti0.c().f(((FriendMessageFragment) this.f11844a).getActivity(), squareFeedConvertToSquareFeed, squareCommentBean, 19, 0, new a());
    }
}
