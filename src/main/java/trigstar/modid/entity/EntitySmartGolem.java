package trigstar.modid.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import trigstar.modid.entity.ai.EntityAIObserve;

public class EntitySmartGolem extends EntityMob {
    private static final DataParameter<Boolean> ACTIVE = EntityDataManager.createKey(EntitySmartGolem.class, DataSerializers.BOOLEAN);

    public EntitySmartGolem(World worldIn) {
        super(worldIn);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataManager().register(ACTIVE, false);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32D);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(2, new EntityAIObserve());
    }


}
