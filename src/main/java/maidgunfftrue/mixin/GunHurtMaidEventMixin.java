package maidgunfftrue.mixin;

import com.github.tartaricacid.touhoulittlemaid.api.event.MaidHurtEvent;
import com.github.tartaricacid.touhoulittlemaid.compat.gun.tacz.event.GunHurtMaidEvent;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.neoforged.neoforge.event.level.ExplosionEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static maidgunfftrue.MaidGunFFTrue.LOGGER;

@Mixin(value = GunHurtMaidEvent.class,remap = false)
public class GunHurtMaidEventMixin {
    @Inject(method = "isBulletDamage(Lnet/minecraft/world/damagesource/DamageSource;)Z", at = @At("HEAD"), remap = false, cancellable = true)
    private void isBulletDamage(DamageSource source, CallbackInfoReturnable<Boolean> cir) {
        LOGGER.debug("damage source filter method intercepted!");
        cir.setReturnValue(false);
    }

    @Inject(method = "onMaidHurt(Lcom/github/tartaricacid/touhoulittlemaid/api/event/MaidHurtEvent;)V", at = @At("HEAD"), remap = false, cancellable = true)
    private void interceptMaidHurtEvent(MaidHurtEvent event, CallbackInfo ci) {
        LOGGER.debug("Maid hurt event intercepted!");
        ci.cancel();
    }

    @Inject(method = "onGunHurt(Lcom/tacz/guns/api/event/common/EntityHurtByGunEvent$Pre;)V", at = @At("HEAD"), remap = false, cancellable = true)
    private void interceptGunHurtEvent(EntityHurtByGunEvent.Pre event, CallbackInfo ci) {
        LOGGER.debug("Gun hurt event intercepted!");
        ci.cancel();
    }

    @Inject(method = "onExplosionDetonateEvent(Lnet/neoforged/neoforge/event/level/ExplosionEvent$Detonate;)V", at = @At("HEAD"), remap = false, cancellable = true)
    private void interceptExplosionDetonateEvent(ExplosionEvent.Detonate event, CallbackInfo ci) {
        LOGGER.debug("Explosion detonate event intercepted!");
        ci.cancel();
    }
}