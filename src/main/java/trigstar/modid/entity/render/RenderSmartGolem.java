package trigstar.modid.entity.render;

import net.minecraft.client.model.ModelIronGolem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import trigstar.modid.ExampleMod;
import trigstar.modid.entity.EntitySmartGolem;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderSmartGolem extends RenderLiving<EntitySmartGolem> {
    private ResourceLocation texture = new ResourceLocation(ExampleMod.MODID, "textures/entity/smart_golem.png");

    public static final Factory FACTORY = new Factory();

    public RenderSmartGolem(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelIronGolem(), 0.5f);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(@Nonnull EntitySmartGolem entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntitySmartGolem> {

        @Override
        public Render<? super EntitySmartGolem> createRenderFor(RenderManager manager) {
            return new RenderSmartGolem(manager);
        }
    }
}
