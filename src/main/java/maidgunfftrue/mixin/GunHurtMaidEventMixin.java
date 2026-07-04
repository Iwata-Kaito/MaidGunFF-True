package maidgunfftrue.mixin;

import com.github.tartaricacid.touhoulittlemaid.api.event.MaidHurtEvent;
import com.github.tartaricacid.touhoulittlemaid.compat.gun.swarfare.event.GunHurtMaidEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GunHurtMaidEvent.class,remap = false)
public class GunHurtMaidEventMixin {
    @Inject(method = "onMaidHurt", at = @At("HEAD"), cancellable = true)
    void CancelonMaidHurt(MaidHurtEvent event, CallbackInfo ci) {
        System.out.println("§b[MIXIN] onMaidHurt");
        ci.cancel();
    }
}