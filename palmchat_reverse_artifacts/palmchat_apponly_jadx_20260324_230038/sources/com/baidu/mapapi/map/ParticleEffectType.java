package com.baidu.mapapi.map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public enum ParticleEffectType {
    UnKnow(-1),
    Snow(0),
    RainStorm(4),
    Smog(5),
    SandStorm(7),
    Fireworks(8),
    Flower(14);

    private int b;

    ParticleEffectType(int i) {
        this.b = i;
    }

    public int getType() {
        return this.b;
    }
}
