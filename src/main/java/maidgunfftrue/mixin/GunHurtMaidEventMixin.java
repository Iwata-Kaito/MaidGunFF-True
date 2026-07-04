package maidgunfftrue.mixin;

import com.github.tartaricacid.touhoulittlemaid.api.event.MaidHurtEvent;
import com.github.tartaricacid.touhoulittlemaid.compat.gun.swarfare.event.GunHurtMaidEvent;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.level.ExplosionEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(GunHurtMaidEvent.class)
public class GunHurtMaidEventMixin {
    @Overwrite
    public void onMaidHurt(MaidHurtEvent event) {
        System.out.println("§b[MIXIN] onMaidHurt");
    }

    @Overwrite
    public void onGunHurt(EntityHurtByGunEvent.Pre event) {
        System.out.println("§b[MIXIN] onGunHurt");
    }

    @Overwrite
    public void onPlayerHurt(LivingIncomingDamageEvent event) {
        System.out.println("§b[MIXIN] onPlayerHurt");
    }

    @Overwrite
    public void onExplosionDetonateEvent(ExplosionEvent.Detonate event) {
        System.out.println("§b[MIXIN] onExplosionDetonateEvent");
    }

    @Overwrite
    private boolean isBulletDamage(DamageSource source) {
        return false;
    }
}