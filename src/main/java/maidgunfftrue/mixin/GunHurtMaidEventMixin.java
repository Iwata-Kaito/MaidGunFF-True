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

@Mixin(value = GunHurtMaidEvent.class,remap = false)
public class GunHurtMaidEventMixin {
    @Inject(method = "isBulletDamage", at = @At("HEAD"), remap = false, cancellable = true)
    private void CancelisBulletDamage(DamageSource source, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }

    @Inject(method = "onMaidHurt", at = @At("HEAD"), remap = false, cancellable = true)
    private void CancelMaidHurtEvent(MaidHurtEvent event, CallbackInfo ci) {
        ci.cancel();
    }

    @Inject(method = "onGunHurt", at = @At("HEAD"), remap = false, cancellable = true)
    private void CancelGunHurtEvent(EntityHurtByGunEvent.Pre event, CallbackInfo ci) {
        ci.cancel();
    }

    @Inject(method = "onExplosionDetonateEvent", at = @At("HEAD"), remap = false, cancellable = true)
    private void CancelExplosionDetonateEvent(ExplosionEvent.Detonate event, CallbackInfo ci) {
        ci.cancel();
    }
}