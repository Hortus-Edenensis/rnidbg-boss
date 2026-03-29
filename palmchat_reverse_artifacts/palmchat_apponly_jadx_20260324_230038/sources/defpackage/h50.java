package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.media.file.FileProgressView;
import com.zenmen.palmchat.widget.AutoResizeImageView;
import com.zenmen.palmchat.widget.DownloadProgressBar;
import com.zenmen.palmchat.widget.FileTransferProgressBarRoundCorner;
import com.zenmen.palmchat.widget.SocialPortraitView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class h50 extends u10 {
    public ImageView A;
    public TextView A0;
    public View B;
    public ImageView B0;
    public View C;
    public ImageView C0;
    public View D;
    public TextView D0;
    public TextView E;
    public ImageView E0;
    public LinearLayout F;
    public View F0;
    public TextView G;
    public TextView G0;
    public TextView H;
    public View H0;
    public ViewGroup I;
    public TextView I0;
    public ImageView J;
    public View J0;
    public SeekBar K;
    public View K0;
    public TextView L;
    public View L0;
    public TextView M;
    public AutoResizeImageView M0;
    public View N;
    public View N0;
    public bs0 O;
    public View O0;
    public TextView P;
    public ViewGroup P0;
    public FileProgressView Q;
    public TextView R;
    public TextView S;
    public FileTransferProgressBarRoundCorner T;
    public View U;
    public TextView V;
    public View W;
    public TextView X;
    public TextView Y;
    public SocialPortraitView Z;
    public TextView a0;
    public ImageView b0;
    public ImageView c0;
    public String d0;
    public ViewGroup e0;
    public AutoResizeImageView f0;
    public ImageView g0;
    public TextView h0;
    public TextView i0;
    public TextView j0;
    public DownloadProgressBar k0;
    public ViewGroup l0;
    public LinearLayout m0;
    public ViewGroup n0;
    public TextView o0;
    public ImageView p0;
    public ViewGroup q0;
    public String r;
    public TextView r0;
    public String s;
    public ViewGroup s0;
    public TextView t;
    public TextView t0;
    public ImageView u;
    public ImageView u0;
    public ImageView v;
    public String v0;
    public ImageView w;
    public TextView w0;
    public RelativeLayout x;
    public TextView x0;
    public TextView y;
    public TextView y0;
    public TextView z;
    public ImageView z0;

    public h50(View view) {
        super(view);
    }

    public static h50 g(View view) {
        h50 h50Var = new h50(view);
        h50Var.t = (TextView) view.findViewById(R.id.message);
        h50Var.u = (ImageView) view.findViewById(R.id.image);
        h50Var.v = (ImageView) view.findViewById(R.id.audio);
        h50Var.w = (ImageView) view.findViewById(R.id.location);
        h50Var.y = (TextView) view.findViewById(R.id.sys_notify_textview);
        h50Var.P0 = (ViewGroup) view.findViewById(R.id.sys_notification_container);
        h50Var.z = (TextView) view.findViewById(R.id.sys_notify_action);
        h50Var.A = (ImageView) view.findViewById(R.id.file_download_status);
        h50Var.C = view.findViewById(R.id.file_download_status_area);
        h50Var.D = view.findViewById(R.id.image_click_area);
        h50Var.f = view.findViewById(R.id.audio_read);
        h50Var.B = view.findViewById(R.id.audio_attach_download_fail);
        h50Var.E = (TextView) view.findViewById(R.id.sending_progress);
        h50Var.F = (LinearLayout) view.findViewById(R.id.sending_progress_container);
        h50Var.G = (TextView) view.findViewById(R.id.audio_during);
        h50Var.H = (TextView) view.findViewById(R.id.audio_during_label);
        h50Var.I = (ViewGroup) view.findViewById(R.id.audioControlLayout);
        h50Var.J = (ImageView) view.findViewById(R.id.play_icon);
        h50Var.K = (SeekBar) view.findViewById(R.id.play_seek_bar);
        h50Var.L = (TextView) view.findViewById(R.id.play_length);
        h50Var.x = (RelativeLayout) view.findViewById(R.id.audioContainer);
        h50Var.P = (TextView) view.findViewById(R.id.thumb_text);
        h50Var.Q = (FileProgressView) view.findViewById(R.id.mask_progressbar);
        h50Var.R = (TextView) view.findViewById(R.id.title_text);
        h50Var.S = (TextView) view.findViewById(R.id.sub_title_text);
        h50Var.T = (FileTransferProgressBarRoundCorner) view.findViewById(R.id.file_transfer_progress);
        h50Var.U = view.findViewById(R.id.file_container);
        h50Var.V = (TextView) view.findViewById(R.id.address);
        h50Var.W = view.findViewById(R.id.location_text_area);
        h50Var.b0 = (ImageView) view.findViewById(R.id.image_loading_fail);
        h50Var.c0 = (ImageView) view.findViewById(R.id.specialExpressionIv);
        h50Var.X = (TextView) view.findViewById(R.id.name_card_nickName);
        h50Var.Y = (TextView) view.findViewById(R.id.name_card_id);
        h50Var.a0 = (TextView) view.findViewById(R.id.name_card_title);
        h50Var.Z = (SocialPortraitView) view.findViewById(R.id.name_card_portrait);
        h50Var.f0 = (AutoResizeImageView) view.findViewById(R.id.video_thumbnail);
        h50Var.g0 = (ImageView) view.findViewById(R.id.video_play);
        h50Var.h0 = (TextView) view.findViewById(R.id.video_size);
        h50Var.i0 = (TextView) view.findViewById(R.id.video_length);
        h50Var.j0 = (TextView) view.findViewById(R.id.retry_text);
        h50Var.k0 = (DownloadProgressBar) view.findViewById(R.id.downloadProgress);
        h50Var.l0 = (ViewGroup) view.findViewById(R.id.richMsgSubView);
        h50Var.m0 = (LinearLayout) view.findViewById(R.id.realcontentLayout);
        h50Var.n0 = (ViewGroup) view.findViewById(R.id.headerLayout);
        h50Var.o0 = (TextView) view.findViewById(R.id.header_text);
        h50Var.p0 = (ImageView) view.findViewById(R.id.header_icon);
        h50Var.q0 = (ViewGroup) view.findViewById(R.id.footerLayout);
        h50Var.r0 = (TextView) view.findViewById(R.id.footer_text);
        h50Var.s0 = (ViewGroup) view.findViewById(R.id.sourceLayout);
        h50Var.t0 = (TextView) view.findViewById(R.id.source_text);
        h50Var.u0 = (ImageView) view.findViewById(R.id.source_icon);
        h50Var.B0 = (ImageView) view.findViewById(R.id.thumb);
        h50Var.C0 = (ImageView) view.findViewById(R.id.gif_down);
        h50Var.D0 = (TextView) view.findViewById(R.id.gif_size);
        h50Var.E0 = (ImageView) view.findViewById(R.id.gif_shadow);
        h50Var.w0 = (TextView) view.findViewById(R.id.guide_title);
        h50Var.x0 = (TextView) view.findViewById(R.id.guide_action);
        h50Var.e0 = (ViewGroup) view.findViewById(R.id.greet_container);
        h50Var.y0 = (TextView) view.findViewById(R.id.notice_content);
        h50Var.z0 = (ImageView) view.findViewById(R.id.notice_image);
        h50Var.A0 = (TextView) view.findViewById(R.id.notice_action);
        h50Var.F0 = view.findViewById(R.id.image_extra);
        h50Var.G0 = (TextView) view.findViewById(R.id.noChatFrom);
        h50Var.H0 = view.findViewById(R.id.noChatTag);
        h50Var.K0 = view.findViewById(R.id.ai_lock_layout);
        h50Var.L0 = view.findViewById(R.id.image_container);
        h50Var.M0 = (AutoResizeImageView) view.findViewById(R.id.thumbnail_ai_blur);
        h50Var.N0 = view.findViewById(R.id.ai_audio_lock_layout);
        h50Var.O0 = view.findViewById(R.id.video_normal_layout);
        h50Var.I0 = (TextView) view.findViewById(R.id.realContentTv);
        h50Var.J0 = view.findViewById(R.id.textContentLayout);
        h50Var.M = (TextView) view.findViewById(R.id.map_location_find_people_text_num);
        h50Var.N = view.findViewById(R.id.map_loaction_find_people_layout);
        return h50Var;
    }

    @Override // defpackage.u10
    public ImageView d() {
        return this.J;
    }

    @Override // defpackage.u10
    public SeekBar e() {
        return this.K;
    }
}
