package maidgunfftrue.mixin;

import com.github.tartaricacid.touhoulittlemaid.compat.gun.swarfare.event.GunHurtMaidEvent;
import net.minecraft.world.damagesource.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = GunHurtMaidEvent.class,remap = false)
public class GunHurtMaidEventMixin {
    @Inject(method = "isBulletDamage", at = @At("HEAD"), remap = false, cancellable = true)
    private static void isBulletDamage(DamageSource source, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}