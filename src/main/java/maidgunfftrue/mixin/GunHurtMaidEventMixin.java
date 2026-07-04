package maidgunfftrue.mixin;

import com.github.tartaricacid.touhoulittlemaid.api.event.MaidHurtEvent;
import com.github.tartaricacid.touhoulittlemaid.compat.gun.swarfare.event.GunHurtMaidEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = GunHurtMaidEvent.class,remap = false)
public class GunHurtMaidEventMixin {
    @Overwrite
    public void onMaidHurt(MaidHurtEvent event) {
        System.out.println("§b[MIXIN] onMaidHurt");
    }
}