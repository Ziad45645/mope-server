package io.mopesbox.Ability;

public class PlayerAbility {
    public boolean isPossible() {
        return possible;
    }

    public void setPossible(boolean possible) {
        this.possible = possible;
    }

    private boolean possible;

    public boolean isUsable() {
        return usable;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    private boolean usable;

    public boolean isRecharging() {
        return recharging;
    }

    public void setRecharging(boolean recharging) {
        this.recharging = recharging;
    }

    private boolean recharging;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private boolean active;

    public int getType() {
        return type;
    }

    private boolean holding;

    public void setType(int type) {
        this.type = type;
    }
    public boolean isToHold(){
        return holding;
    }

    public void setHoldAbility(boolean a){
        this.holding = a;
    }
    private int type;

    public PlayerAbility(int type){
        this.type = type;
        this.possible = false;
        this.usable = false;
        this.recharging = false;
        this.active = false;
        this.holding = false;
    }
}
