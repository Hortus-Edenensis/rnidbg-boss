package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zenmen.palmchat.friendcircle.bean.SquareSimpleComment;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import com.zenmen.square.R$style;
import com.zenmen.square.comment.emoji.EmojiLayout;
import com.zenmen.square.comment.model.CommentPostBean;
import com.zenmen.square.comment.model.CommentViewModel;
import com.zenmen.square.comment.model.ResultBean;
import com.zenmen.square.comment.model.UserInfoItem;
import com.zenmen.square.comment.struct.CommentItem;
import com.zenmen.square.comment.struct.UnitedException;
import com.zenmen.square.comment.widget.RichEditText;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.model.bean.SquareFeedEvent;
import defpackage.e03;
import defpackage.nq3;
import defpackage.yn;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ro6 extends Dialog {
    public static final String x = "ro6";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public li0 f20521a;
    public nq3.b b;
    public boolean c;
    public CommentViewModel d;
    public int e;
    public View f;
    public RichEditText g;
    public EmojiLayout h;
    public TextView i;
    public View j;
    public View k;
    public int l;
    public ResultBean m;
    public Activity n;
    public UserInfoItem o;
    public CheckBox p;
    public boolean q;
    public boolean r;
    public long s;
    public long t;
    public SquareFeed u;
    public int v;
    public int w;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements DialogInterface.OnKeyListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) throws Throwable {
            if (i != 4 || !ro6.this.isShowing()) {
                return false;
            }
            ro6.this.dismiss();
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ro6.this.k.setVisibility(0);
            ro6.this.j.setVisibility(8);
            ro6.this.h.hideEmojiKeyBoard();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ro6.this.k.setVisibility(8);
            ro6.this.j.setVisibility(0);
            ro6.this.h.hiddenAll();
            ro6.this.A();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnTouchListener {
        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (ro6.this.h.getVisibility() == 0) {
                ro6.this.k.setVisibility(8);
                ro6.this.j.setVisibility(0);
                ro6.this.h.hiddenAll();
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnLayoutChangeListener {
        public e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws Throwable {
            int i9 = i8 - i4;
            if (i9 < 0 && ro6.this.l > 0) {
                ro6.this.o();
            }
            ro6.this.l = i9;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements InputFilter {
        public f() {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            if ("[null]".equals(charSequence.toString())) {
                return "";
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements e03.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f20529a = 0;

        public h() {
        }

        @Override // e03.b
        public void a(int i, boolean z) throws Throwable {
            Log.d(ro6.x, "onKeyboardChange:" + z);
            if (ro6.this.k.getVisibility() != 0) {
                if (z) {
                    return;
                }
                ro6.this.dismiss();
            } else {
                if (!z) {
                    ro6.this.h.showFullEmoji();
                    return;
                }
                ro6.this.h.hiddenAll();
                ro6.this.k.setVisibility(8);
                ro6.this.j.setVisibility(0);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            int id = view.getId();
            if (id == R$id.vs_comment_send) {
                ro6.this.s();
            } else if (id == R$id.contentView) {
                ro6.this.o();
            }
        }

        public /* synthetic */ i(ro6 ro6Var, a aVar) {
            this();
        }
    }

    public ro6(Activity activity, ResultBean resultBean, UserInfoItem userInfoItem, SquareFeed squareFeed, com.zenmen.square.comment.ui.b bVar, boolean z) {
        super(activity, R$style.square_dialog_theme_nodim_style);
        this.c = false;
        this.l = 0;
        this.q = false;
        this.r = false;
        this.s = 0L;
        this.t = 0L;
        this.v = 0;
        this.w = 0;
        xl1.e(activity);
        this.r = z;
        this.n = activity;
        this.m = resultBean;
        this.o = userInfoItem;
        this.u = squareFeed;
        li0 li0Var = new li0();
        this.f20521a = li0Var;
        li0Var.b(this);
        this.f20521a.e(userInfoItem);
        this.f20521a.c(bVar);
        this.q = xl1.f();
        q();
        v();
    }

    public final void A() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this.g, 1);
        }
    }

    public final void C() {
        this.c = true;
        this.f20521a.f(this.u, this.m, this.d, this.g.getText().toString().trim().replace("\n", ""), this.e, this.w, this.v);
        Activity activity = this.n;
        B(activity, activity.getString(R$string.square_comment_sending), true, true);
        new HashMap();
    }

    public void D(CommentViewModel commentViewModel, int i2, UnitedException unitedException) {
        nq3.b bVar = this.b;
        if (bVar != null) {
            bVar.a(2, unitedException, i2);
        }
        p();
    }

    public void E(CommentPostBean commentPostBean, CommentViewModel commentViewModel, int i2) {
        if (this.b != null) {
            commentViewModel.setCRId(commentPostBean.id);
            commentViewModel.setVersion(commentPostBean.version);
            commentViewModel.setDiscussionType(commentPostBean.discussionType);
            commentViewModel.setCRCity(commentPostBean.city);
            SquareFeedEvent squareFeedEvent = new SquareFeedEvent();
            squareFeedEvent.eventType = 2;
            SquareFeed squareFeed = this.u;
            squareFeedEvent.feed = squareFeed;
            squareFeed.discussionNum++;
            CommentItem commentItem = commentViewModel.commentItem;
            if (commentItem != null && commentItem.discussionType == 1 && commentItem.getUser() != null) {
                SquareFeed squareFeed2 = squareFeedEvent.feed;
                if (squareFeed2.discussions == null) {
                    squareFeed2.discussions = new ArrayList();
                }
                SquareSimpleComment squareSimpleComment = new SquareSimpleComment();
                squareSimpleComment.exFromUid = commentViewModel.commentItem.getUser().getExid();
                squareSimpleComment.nickname = commentViewModel.commentItem.getUser().getName();
                squareSimpleComment.id = commentViewModel.getCRId();
                squareSimpleComment.content = commentViewModel.getCRContent();
                squareFeedEvent.feed.discussions.add(0, squareSimpleComment);
            }
            int i3 = this.v;
            if (i3 != 19 && i3 != 17) {
                an1.c().l(squareFeedEvent);
            }
            this.b.a(1, commentViewModel, i2);
        }
        p();
        this.d = null;
        this.e = 0;
        this.g.setEmojiText(null);
        ResultBean resultBean = this.m;
        if (resultBean != null) {
            resultBean.commentContent = null;
        }
    }

    public void F(String str) {
        this.g.setEmojiText(str);
        this.m.commentContent = str;
        G();
    }

    public void G() {
        CommentViewModel commentViewModel = this.d;
        if (commentViewModel == null || commentViewModel.getCommentReplyOperater() == null || this.d.getCRUser() == null) {
            this.g.setHint(si0.b(getContext()));
            return;
        }
        this.g.setHint(getContext().getString(R$string.square_comment_reply) + this.d.getCRUser().getName() + "：");
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() throws Throwable {
        yn.b(this);
        super.dismiss();
        this.l = 0;
        xl1.i();
    }

    public final boolean l() {
        return true;
    }

    public void n() {
        F(this.g.getText().toString());
        nq3.b bVar = this.b;
        if (bVar != null) {
            bVar.a(4, this.g.getText().toString(), this.c ? 1 : -1);
        }
    }

    public final void o() throws Throwable {
        dismiss();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        r();
    }

    public final void q() {
        setContentView(R$layout.square_comment_input_dialog);
        Window window = getWindow();
        window.setWindowAnimations(R$style.square_dialog_WindowAnim2);
        window.setGravity(80);
        window.setSoftInputMode(18);
        Point pointH = tn.h(getContext());
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = pointH.x;
        attributes.height = -1;
        window.setAttributes(attributes);
        try {
            if ((this.n.getWindow().getAttributes().flags & 1024) == 1024) {
                window.addFlags(1024);
            }
        } catch (Throwable th) {
            Log.e("", th.getMessage());
        }
        RichEditText richEditText = (RichEditText) findViewById(R$id.edit_message_area);
        this.g = richEditText;
        richEditText.setHint(si0.b(getContext()));
        this.g.setEnableRang(false);
        EmojiLayout emojiLayout = (EmojiLayout) findViewById(R$id.emojiLayout);
        this.h = emojiLayout;
        emojiLayout.setEditTextSmile(this.g);
        this.i = (TextView) findViewById(R$id.vs_comment_send);
        View viewFindViewById = findViewById(R$id.vs_comment_emoji);
        this.j = viewFindViewById;
        viewFindViewById.setOnClickListener(new b());
        View viewFindViewById2 = findViewById(R$id.vs_comment_keyboard);
        this.k = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new c());
        if (this.q) {
            if (this.r) {
                this.k.setVisibility(0);
                this.j.setVisibility(8);
                this.h.showFullEmoji();
            } else {
                this.k.setVisibility(8);
                this.j.setVisibility(0);
                this.h.hiddenAll();
            }
            this.h.getEditTextEmoji().setOnTouchListener(new d());
        } else {
            this.k.setVisibility(8);
            this.j.setVisibility(8);
            this.h.hiddenAll();
        }
        View viewFindViewById3 = findViewById(R$id.contentView);
        this.f = viewFindViewById3;
        viewFindViewById3.addOnLayoutChangeListener(new e());
        this.i.setEnabled(false);
        i iVar = new i(this, null);
        this.i.setOnClickListener(iVar);
        this.f.setOnClickListener(iVar);
        this.g.setFilters(new InputFilter[]{new f()});
        this.g.setFocusable(true);
        this.g.addTextChangedListener(new g());
        this.p = (CheckBox) findViewById(R$id.checkbox);
        F(null);
    }

    public final void r() {
        e03.b(this.n, new h());
    }

    public void s() throws Throwable {
        if (!bo.a(this.n)) {
            Activity activity = this.n;
            sy5.f(activity, activity.getString(R$string.square_http_error), 1).g();
        } else if (l()) {
            C();
            o();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Activity activity = this.n;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        super.show();
        m();
    }

    public void t(yk2 yk2Var) {
        this.f20521a.d(yk2Var);
    }

    public void u(SquareFeed squareFeed) {
        this.u = squareFeed;
    }

    public final void v() {
        setOnKeyListener(new a());
    }

    public void w(nq3.b bVar) {
        this.b = bVar;
    }

    public void x() {
        nq3.b bVar = this.b;
        if (bVar != null) {
            bVar.a(3, null, -1);
        }
    }

    public void y(ResultBean resultBean, String str, CommentViewModel commentViewModel, int i2, int i3, int i4) {
        if (this.n.isFinishing()) {
            return;
        }
        this.v = i4;
        this.w = i3;
        this.s = resultBean.getCurrentPlayingTime();
        this.t = resultBean.getRealPlayingTime();
        if (commentViewModel != null || TextUtils.isEmpty(str)) {
            this.d = commentViewModel;
            this.e = i2;
        }
        this.c = false;
    }

    public void z(yn.b bVar) {
        if (this.j.getVisibility() == 0) {
            yn.f(this.n, this.g, bVar, this.r);
        }
    }

    public final void m() {
    }

    public void p() {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements TextWatcher {
        public g() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int iH = zk5.h(ro6.this.g, charSequence.toString().trim(), MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, null, false);
            if (iH == 0 || !si0.a(ro6.this.g.getText())) {
                ro6.this.i.setEnabled(false);
            } else {
                ro6.this.i.setEnabled(true);
            }
            if (iH > 140) {
                sy5.f(ro6.this.getContext(), ro6.this.n.getString(R$string.square_comment_input_max_toast), 0).g();
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public void B(Activity activity, String str, boolean z, boolean z2) {
    }
}
