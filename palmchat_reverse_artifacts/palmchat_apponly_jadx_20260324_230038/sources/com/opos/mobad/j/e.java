package com.opos.mobad.j;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.ad.k;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f8947a;
    private com.opos.mobad.b b;
    private AdItemData h;
    private MaterialData i;
    private boolean c = false;
    private volatile boolean d = false;
    private long e = -1;
    private long f = -1;
    private boolean g = false;
    private boolean j = false;

    public e(com.opos.mobad.b bVar, k kVar) {
        this.b = bVar;
        this.f8947a = kVar;
    }

    private CharSequence a(Context context, SpannableStringBuilder spannableStringBuilder, SpannableString spannableString, long j) {
        int i;
        int i2;
        int i3;
        if (this.h.x() && this.h.C()) {
            spannableStringBuilder.append((CharSequence) a(context));
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append((CharSequence) context.getString(R.string.opos_mob_reward_close_last_tips_second));
            spannableStringBuilder.append((CharSequence) context.getString(R.string.opos_mob_reward_close_last_tips_or));
            i3 = R.string.opos_mob_reward_close_last_tips_open_detail;
        } else if (this.h.y() && this.h.z() && this.h.x()) {
            spannableStringBuilder.append((CharSequence) a(context));
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append((CharSequence) context.getString(R.string.opos_mob_reward_close_last_tips_second));
            spannableStringBuilder.append((CharSequence) context.getString(R.string.opos_mob_reward_close_last_tips_or));
            if (this.j) {
                spannableStringBuilder.append((CharSequence) context.getString(R.string.opos_mob_reward_close_last_tips_click));
                i3 = R.string.opos_mob_reward_close_last_tips_open_app;
            } else {
                i3 = R.string.opos_mob_reward_close_last_tips_install_app;
            }
        } else if (!this.h.y() || !this.h.z()) {
            if (!this.h.x() || !this.h.z()) {
                if (this.h.x() && this.h.y()) {
                    spannableStringBuilder.append((CharSequence) a(context));
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) context.getString(R.string.opos_mob_reward_close_last_tips_second));
                    if (!this.j) {
                        spannableStringBuilder.append((CharSequence) context.getString(R.string.opos_mob_reward_close_last_tips_or));
                        i3 = R.string.opos_mob_reward_close_last_tips_install_app;
                    }
                    i = R.string.opos_mob_reward_close_last_tips_get_reward_query;
                } else if (this.h.x()) {
                    spannableStringBuilder.append((CharSequence) a(context));
                    spannableStringBuilder.append((CharSequence) spannableString);
                    i3 = R.string.opos_mob_reward_close_last_tips_second;
                } else if (this.h.y()) {
                    i3 = R.string.opos_mob_reward_close_last_tips_install_app;
                } else if (this.h.z()) {
                    i2 = this.j ? R.string.opos_mob_reward_close_last_tips_click : R.string.opos_mob_reward_close_last_tips_download;
                } else if (this.h.A()) {
                    if (j > 0) {
                        spannableStringBuilder.append((CharSequence) a(context));
                        spannableStringBuilder.append((CharSequence) spannableString);
                        spannableStringBuilder.append((CharSequence) context.getString(R.string.opos_mob_reward_close_last_tips_second));
                        if (!this.g) {
                            spannableStringBuilder.append((CharSequence) context.getString(R.string.opos_mob_reward_close_last_tips_and));
                            i3 = R.string.opos_mob_reward_close_last_tips_interaction;
                        }
                        i = R.string.opos_mob_reward_close_last_tips_get_reward_query;
                    } else {
                        spannableStringBuilder.append((CharSequence) context.getString(R.string.opos_mob_reward_close_last_tips_click));
                        i3 = R.string.opos_mob_reward_close_last_tips_interaction;
                    }
                } else if (this.h.B()) {
                    i2 = R.string.opos_mob_reward_close_last_tips_download;
                } else {
                    i = R.string.opos_mob_reward_close_tips_text;
                }
                spannableStringBuilder.append((CharSequence) context.getString(i));
                return spannableStringBuilder;
            }
            spannableStringBuilder.append((CharSequence) a(context));
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append((CharSequence) context.getString(R.string.opos_mob_reward_close_last_tips_second));
            spannableStringBuilder.append((CharSequence) context.getString(R.string.opos_mob_reward_close_last_tips_or));
            i2 = this.j ? R.string.opos_mob_reward_close_last_tips_click : R.string.opos_mob_reward_close_last_tips_download;
            spannableStringBuilder.append((CharSequence) context.getString(i2));
            i3 = R.string.opos_mob_reward_close_last_tips_open_app;
        } else if (this.j) {
            spannableStringBuilder.append((CharSequence) context.getString(R.string.opos_mob_reward_close_last_tips_click));
            i3 = R.string.opos_mob_reward_close_last_tips_open_app;
        } else {
            i3 = R.string.opos_mob_reward_close_last_tips_install_app;
        }
        spannableStringBuilder.append((CharSequence) context.getString(i3));
        i = R.string.opos_mob_reward_close_last_tips_get_reward_query;
        spannableStringBuilder.append((CharSequence) context.getString(i));
        return spannableStringBuilder;
    }

    private long e(long j) {
        if (j <= 0) {
            j = this.i.s();
        }
        if (this.h.Q() > 0) {
            j = j > 0 ? Math.min(this.h.Q(), j) : this.h.Q();
        }
        long jMax = Math.max(j, 0L);
        long j2 = this.e;
        return j2 <= 0 ? jMax : Math.max(0L, jMax - j2);
    }

    private long f(long j) {
        long jQ = this.h.Q();
        if (j <= 0) {
            j = this.i.s();
        }
        if (jQ <= 0) {
            jQ = j;
        } else if (j > 0) {
            jQ = Math.min(jQ, j);
        }
        long jMax = Math.max(0L, jQ);
        long j2 = this.e;
        if (j2 >= jMax) {
            return 0L;
        }
        return Math.max(0L, jMax - j2);
    }

    public CharSequence b() {
        return com.opos.mobad.model.utils.e.a(this.h, this.i) ? "关闭广告" : "";
    }

    public CharSequence c() {
        return com.opos.mobad.model.utils.e.a(this.h, this.i) ? "继续试玩" : "";
    }

    public String d(long j) {
        long jE = e(j);
        return jE > 0 ? String.valueOf(Math.round(jE / 1000.0d)) : "0";
    }

    public boolean g() {
        if (this.d || this.c) {
            return false;
        }
        this.d = true;
        this.b.j().a(this.h.g(), 5, this.h.f(), this.h.b(), (this.h.i().isEmpty() || this.h.i().get(0) == null) ? "" : this.h.i().get(0).X(), this.h.a(), this.h.P());
        com.opos.cmn.an.f.a.b("RewardPresenter", "onVIPReward");
        a(0, new Object[0]);
        return true;
    }

    public boolean h() {
        if (this.d || this.c) {
            return false;
        }
        com.opos.cmn.an.f.a.b("RewardPresenter", "onFallbackReward");
        a(0, new Object[0]);
        return true;
    }

    public void i() {
        this.d = false;
        this.c = true;
    }

    private String a(Context context) {
        return context.getString(com.opos.mobad.model.utils.e.a(this.h, this.i) ? R.string.opos_mob_reward_close_last_tips_continue_trial_game : R.string.opos_mob_reward_close_last_tips_continue);
    }

    public CharSequence b(long j) {
        com.opos.cmn.an.f.a.b("RewardPresenter", "getRewardLastTips() duration=", Long.valueOf(j), "mHasReward=", Boolean.valueOf(this.d), "mHasDestroy=", Boolean.valueOf(this.c));
        if (this.d || this.h.D()) {
            return "";
        }
        if (this.h.x() && this.h.Q() <= 0 && this.i.s() <= 0) {
            return "";
        }
        long jF = f(j);
        String strValueOf = String.valueOf(Math.round(jF / 1000.0d));
        SpannableString spannableString = new SpannableString(strValueOf);
        spannableString.setSpan(new ForegroundColorSpan(this.b.b().getResources().getColor(android.R.color.holo_red_dark)), 0, strValueOf.length(), 33);
        return a(this.b.b(), new SpannableStringBuilder(), spannableString, jF);
    }

    public String c(long j) {
        long jE = e(j);
        String strValueOf = jE > 0 ? String.valueOf(Math.round(jE / 1000.0d)) : "";
        if (!this.d) {
            return a(strValueOf, jE);
        }
        TextUtils.isEmpty(strValueOf);
        return this.b.b().getString(R.string.opos_mob_reward_tips);
    }

    public boolean d() {
        return this.d;
    }

    public void e() {
        AdItemData adItemData;
        if (this.d || this.c || (adItemData = this.h) == null || adItemData.G()) {
            return;
        }
        this.h.d(true);
        com.opos.cmn.an.f.a.b("RewardPresenter", "rewardFromECommerceDialog isRewardLaunch()=", Boolean.valueOf(this.h.z()));
        a(1, new Object[0]);
    }

    public void f() {
        AdItemData adItemData;
        if (this.d || this.c || (adItemData = this.h) == null || !adItemData.z() || this.h.G()) {
            return;
        }
        this.h.d(true);
        com.opos.cmn.an.f.a.b("RewardPresenter", "rewardFromDP isRewardLaunch()=", Boolean.valueOf(this.h.z()));
        a(4, new Object[0]);
    }

    public String a(Context context, AdItemData adItemData, boolean z) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (!this.j) {
            if (adItemData.y()) {
                if (z && adItemData.x()) {
                    sb.append(context.getString(R.string.opos_mob_reward_spilt_key));
                }
                i = R.string.opos_mob_reward_install_key;
            } else if (adItemData.z()) {
                if (z && adItemData.x()) {
                    sb.append(context.getString(R.string.opos_mob_reward_spilt_key));
                }
                i = R.string.opos_mob_reward_open_without_install_key;
            }
            sb.append(context.getString(i));
        } else if (adItemData.z()) {
            if (z && adItemData.x()) {
                sb.append(context.getString(R.string.opos_mob_reward_spilt_key));
            }
            i = R.string.opos_mob_reward_open_key;
            sb.append(context.getString(i));
        }
        if (!adItemData.C()) {
            if (z || !TextUtils.isEmpty(sb)) {
                i2 = R.string.opos_mob_reward_key;
            }
            return sb.toString();
        }
        if (z && adItemData.x()) {
            sb.append(context.getString(R.string.opos_mob_reward_spilt_key));
        }
        i2 = R.string.opos_mob_reward_common_click_ad_key;
        sb.append(context.getString(i2));
        return sb.toString();
    }

    public void b(AdItemData adItemData, String str) {
        if (this.d || this.c) {
            return;
        }
        this.j = true;
        if (!this.h.y() || adItemData.G()) {
            return;
        }
        adItemData.d(true);
        AdItemData adItemData2 = this.h;
        if (adItemData2 != null && ((!TextUtils.isEmpty(adItemData2.f()) && !TextUtils.isEmpty(adItemData.f()) && this.h.f().equals(adItemData.f())) || (!TextUtils.isEmpty(this.h.c()) && !TextUtils.isEmpty(adItemData.c()) && this.h.c().equals(adItemData.c())))) {
            this.h.d(true);
        }
        com.opos.cmn.an.f.a.b("RewardPresenter", "onAppInstall");
        a(2, new Object[0]);
    }

    private final String a(Context context, String str, AdItemData adItemData) {
        if (!TextUtils.isEmpty(str)) {
            str = str + "s";
        }
        StringBuilder sb = new StringBuilder();
        sb.append((com.opos.mobad.model.utils.e.a(this.h, this.i) && adItemData.x()) ? context.getString(R.string.opos_mob_reward_trial_game_complete_key, str) : adItemData.x() ? context.getString(R.string.opos_mob_reward_video_complete_key, str) : context.getString(R.string.opos_mob_reward_without_video_complete_key, str));
        sb.append(a(context, adItemData, true));
        return sb.toString();
    }

    private String a(String str, long j) {
        if (this.h.y() || this.h.z() || this.h.x() || this.h.C()) {
            return a(this.b.b(), str, this.h);
        }
        if (!this.h.A()) {
            if (this.h.B()) {
                return "下载应用领取奖励";
            }
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            return str + "秒";
        }
        if (this.h.Q() <= 0) {
            if (j <= 0) {
                return "互动领取奖励";
            }
            return str + "互动领取奖励";
        }
        if (j <= 0) {
            return "互动领取奖励";
        }
        if (this.g) {
            return "观看" + str + "s领取奖励";
        }
        return "观看" + str + "s并互动领取奖励";
    }

    public void a() {
        if (this.d || this.c) {
            return;
        }
        if (this.h.B() || this.h.C()) {
            com.opos.cmn.an.f.a.b("RewardPresenter", "onAdClick");
            a(16, new Object[0]);
        }
    }

    private void a(int i, final Object... objArr) {
        this.d = true;
        com.opos.cmn.an.f.a.b("RewardPresenter", "notifyReward", objArr);
        com.opos.mobad.cmn.func.b.e.a(this.b, this.h.g(), this.h, this.i, this.f, this.e, i);
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.j.e.1
            @Override // java.lang.Runnable
            public void run() {
                k kVar;
                if (e.this.c || !e.this.d || (kVar = e.this.f8947a) == null) {
                    return;
                }
                kVar.onReward(objArr);
            }
        });
    }

    public void a(long j) {
        this.e = j;
        if (this.d || this.c || !this.h.x()) {
            return;
        }
        com.opos.cmn.an.f.a.b("RewardPresenter", "onComplete");
        a(1, new Object[0]);
    }

    public void a(long j, long j2) {
        this.e = j;
        this.f = j2;
        if (this.d || this.c) {
            return;
        }
        if (this.h.x() && this.h.Q() > 0 && j >= this.h.Q()) {
            com.opos.cmn.an.f.a.b("RewardPresenter", "onComplete");
            a(1, new Object[0]);
        }
        if (this.h.A() && this.g && this.e >= this.h.Q()) {
            com.opos.cmn.an.f.a.b("RewardPresenter", "onRewardPlayInteraction");
            a(8, new Object[0]);
        }
    }

    public void a(AdItemData adItemData, MaterialData materialData) {
        this.h = adItemData;
        this.i = materialData;
        this.d = false;
        this.g = false;
        this.e = -1L;
        this.f = -1L;
        this.j = com.opos.cmn.an.h.d.a.d(this.b.b(), this.i.i());
    }

    public void a(AdItemData adItemData, String str) {
        if (this.d || this.c || !this.h.z() || adItemData.G()) {
            return;
        }
        adItemData.d(true);
        AdItemData adItemData2 = this.h;
        if (adItemData2 != null && ((!TextUtils.isEmpty(adItemData2.f()) && !TextUtils.isEmpty(adItemData.f()) && this.h.f().equals(adItemData.f())) || (!TextUtils.isEmpty(this.h.c()) && !TextUtils.isEmpty(adItemData.c()) && this.h.c().equals(adItemData.c())))) {
            this.h.d(true);
        }
        com.opos.cmn.an.f.a.b("RewardPresenter", "onAppLunch");
        a(4, new Object[0]);
    }
}
