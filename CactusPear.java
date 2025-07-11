package io.mopesbox.Objects.Eatable;

import io.mopesbox.Constants;
import io.mopesbox.Animals.Animal;
import io.mopesbox.Objects.GameObject;
import io.mopesbox.Utils.Timer;
import io.mopesbox.Utils.Utils;
import io.mopesbox.World.Room;

public class CactusPear extends GameObject{
    private int xp;
    private Room room;
    private boolean isDone = false;
    private Timer liveTimer = new Timer(80000);
    private Cactus origin;
    public CactusPear(int id, double x, double y, Room room, Cactus origin) {
        super(id, x, y, 14, 93);
        this.setMovable(true);
        this.xp = Utils.randomInt(15, 50);
        this.room = room;
        this.origin = origin;
        this.setBiome(4);
    }

    @Override
    public boolean getCollideable(GameObject o) {
        if(o instanceof Animal) {
            return false;
        }
        if(o instanceof CactusPear || o instanceof Water) {
            return false;
        }
        return true;
    }

    public boolean getCollideableIs(GameObject o) {
        if(o instanceof Animal) {
            if(((Animal)o).flag_flying) return false;
            if(((Animal)o).isInHole()) return false;
            if(((Animal)o).isDiveActive()) return false;
        }
        return true;
    }

    @Override
    public void onCollision(GameObject o) {
        super.onCollision(o);
        if(!this.isDone && getCollideableIs(o) && o instanceof Animal && (((Animal)o).getInfo().getTier() >= 3 && ((Animal)o).getInfo().getTier() <= 9)) {
            Animal biter = (Animal) o;
            biter.getClient().addXp(this.xp);
            this.isDone = true;
            this.room.removeObj(this, o);
            if(this.origin != null) this.origin.pears--;
        }
    }

    @Override
    public void update() {
        super.update();
        liveTimer.update(Constants.TICKS_PER_SECOND);
        if(liveTimer.isDone()) {
            this.room.removeObj(this, null);
            if(this.origin != null) this.origin.pears--;
            liveTimer.reset();
            return;
        }
    }
}
