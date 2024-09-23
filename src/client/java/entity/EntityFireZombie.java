package entity;

import net.minecraft.src.game.entity.Entity;
import net.minecraft.src.game.entity.EntityMob;
import net.minecraft.src.game.item.Item;
import net.minecraft.src.game.level.World;

public class EntityFireZombie extends EntityMob {

    public EntityFireZombie(World world) {
        super(world);
        this.texture = "/textures/mobs/fire_zombie.png";
    }

    @Override
    public Item getSpawnEgg() {
        return Item.zombieSpawnEgg;
    }

    @Override
    public void onLivingUpdate() {
//        if (this.worldObj.isDaytime()) {
//            float var1 = this.getEntityBrightness(1.0F);
//            if (var1 > 0.5F
//                    && this.worldObj
//                    .canBlockSeeTheSky(
//                            MathHelper.floor_double(this.posX),
//                            MathHelper.floor_double(this.posY),
//                            MathHelper.floor_double(this.posZ)
//                    )
//                    && this.rand.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F) {
//                this.fire = 300;
//            }
//        }

        super.onLivingUpdate();
    }

    @Override
    protected String getLivingSound() {
        return "mob.zombie";
    }

    @Override
    protected String getHurtSound() {
        return "mob.zombiehurt";
    }

    @Override
    protected String getDeathSound() {
        return "mob.zombiedeath";
    }

    @Override
    protected int getDropItemId() {
        return Item.feather.itemID;
    }


    public void attackEntity(Entity target, float distance) {
        if (this.attackTime <= 0
                && distance < 2.0F
                && target.boundingBox.maxY > this.boundingBox.minY
                && target.boundingBox.minY < this.boundingBox.maxY) {
            this.attackTime = 20;
            this.swingItem();
            target.attackEntityFrom(this, this.attackStrength);
            target.fire = 300;
        }
    }
}
