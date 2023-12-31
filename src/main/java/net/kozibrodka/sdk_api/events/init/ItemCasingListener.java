package net.kozibrodka.sdk_api.events.init;

import net.fabricmc.loader.api.FabricLoader;
import net.kozibrodka.sdk_api.events.parachute.SdkEntityParachute;
import net.kozibrodka.sdk_api.events.parachute.SdkRenderParachute;
import net.kozibrodka.sdk_api.events.utils.SdkMap;
import net.kozibrodka.sdk_api.events.utils.WW2Plane;
import net.kozibrodka.sdk_api.events.utils.WW2Tank;
import net.kozibrodka.sdk_api.events.utils.WW2Truck;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.render.entity.EntityRendererRegisterEvent;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import net.modificationstation.stationapi.api.event.entity.EntityRegister;
import net.modificationstation.stationapi.api.event.registry.EntityHandlerRegistryEvent;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.Registry;
import net.modificationstation.stationapi.api.util.Null;

import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;
import net.modificationstation.stationapi.api.template.item.TemplateItem;

public class ItemCasingListener {

    @Entrypoint.Namespace
    public static final Namespace MOD_ID = Null.get();

    public static TemplateItem itemBulletCasing;
    public static TemplateItem itemBulletCasingShell;
    public static TemplateItem itemWrenchGold;

    @EventListener
    public void registerItems(ItemRegistryEvent event) {
        if(FabricLoader.getInstance().isModLoaded("sdk")) {
            itemBulletCasing = (TemplateItem) new TemplateItem(Identifier.of(MOD_ID, "itemBulletCasing")).setTranslationKey(MOD_ID, "itemBulletCasing").setMaxStackSize(64);
            itemBulletCasingShell = (TemplateItem) new TemplateItem(Identifier.of(MOD_ID, "itemBulletCasingShell")).setTranslationKey(MOD_ID, "itemBulletCasingShell").setMaxStackSize(64);
        }
        itemWrenchGold = (TemplateItem) new TemplateItem(Identifier.of(MOD_ID, "itemWrenchGold")).setTranslationKey(MOD_ID, "itemWrenchGold").setMaxStackSize(1);
    }

    @EventListener
    public void registerTextures(TextureRegisterEvent event) {
        if(FabricLoader.getInstance().isModLoaded("sdk")) {
            itemBulletCasing.setTexture(Identifier.of(MOD_ID, "item/itemBulletCasing"));
            itemBulletCasingShell.setTexture(Identifier.of(MOD_ID, "item/itemBulletCasingShell"));
        }
        itemWrenchGold.setTexture(Identifier.of(MOD_ID, "item/itemWrenchGold"));
    }

    @EventListener
    private static void registerEntities(EntityRegister event) {
        event.register(SdkEntityParachute.class, String.valueOf(Identifier.of(MOD_ID, "SdkEntityParachute")));
    }

    @EventListener
    private static void registerMobHandlers(EntityHandlerRegistryEvent event) {
        Registry.register(event.registry, MOD_ID.id("SdkEntityParachute"), SdkEntityParachute::new);
    }

    @EventListener
    private static void registerEntityRenderers(EntityRendererRegisterEvent event) {
        event.renderers.put(SdkEntityParachute.class, new SdkRenderParachute());
    }
}
