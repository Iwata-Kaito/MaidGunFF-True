package maidgunfftrue.mixin;

import com.github.tartaricacid.touhoulittlemaid.compat.gun.swarfare.event.GunHurtMaidEvent;
import net.minecraft.world.damagesource.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = GunHurtMaidEvent.class,remap = false)
public class GunHurtMaidEventMixin {
    @Overwrite
    private boolean isBulletDamage(DamageSource source) {
        System.out.println("§e[MIXIN] isBulletDamage");
        return false;   // 常に false を返す
    }
}