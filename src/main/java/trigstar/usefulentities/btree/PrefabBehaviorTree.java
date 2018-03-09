package trigstar.usefulentities.btree;

import net.minecraft.init.Blocks;
import net.minecraft.util.Tuple;
import trigstar.usefulentities.btree.deco.DecoratorDelay;
import trigstar.usefulentities.btree.deco.DecoratorTimer;
import trigstar.usefulentities.btree.leaf.*;
import trigstar.usefulentities.btree.select.SelectorPhase;
import trigstar.usefulentities.btree.seq.SequenceAll;
import trigstar.usefulentities.btree.seq.SequenceUntilFail;

import java.util.HashMap;

public class PrefabBehaviorTree {
    static HashMap<String, Node> prefabs;

    static {
        prefabs = new HashMap<>();
        prefabs.put("Harvest", new SequenceAll(new DecoratorDelay(10,
                        new SelectorPhase(new Tuple<>("FIND",
                                new SequenceUntilFail(
                                        new FindBlockGrownCrop(),
                                        new MoveTo(),
                                        new SetPhase("BREAK")
                                )), new Tuple<>("BREAK",
                                new SequenceUntilFail(
                                        new IsOverBlock(),
                                        new BreakBlock(),
                                        new SetPhase("COLLECT")
                                )), new Tuple<>("COLLECT",
                                new SequenceUntilFail(
                                        new PlaceBlock(Blocks.WHEAT),
                                        new SetPhase("FIND"))
                        ))
                ),
                new PickupItemEntity(),
                new DecoratorTimer(1200, new SequenceAll(new DepositIntoInventory(),new SetNewTask()))
        ));

        prefabs.put("Sow", new SequenceAll(new DecoratorDelay(10,
                new SelectorPhase(new Tuple<>("FIND",
                        new SequenceUntilFail(
                                new FindBlock(Blocks.FARMLAND),
                                new MoveTo(),
                                new BlockOffset(0,1,0),
                                new SetPhase("SOW")
                        )),new Tuple<>("SOW",
                        new SequenceUntilFail(
                                new PlaceBlock(Blocks.WHEAT),
                                new SetPhase("FIND")
                        ))
                )),
                new DecoratorTimer(1200, new SequenceAll(new DepositIntoInventory(),new SetNewTask()))
        ));

        prefabs.put("Plow", new SequenceAll(new DecoratorDelay(10,
                new SelectorPhase(new Tuple<>("FIND",
                        new SequenceUntilFail(
                                new FindBlock(Blocks.DIRT, Blocks.GRASS),
                                new MoveTo(),
                                new SetPhase("PLOW")
                        )), new Tuple<>("PLOW",
                        new SequenceUntilFail(
                                new PlaceBlock(Blocks.FARMLAND),
                                new SetPhase("FIND")
                        ))
                )),
                new DecoratorTimer(1200, new SequenceAll(new DepositIntoInventory(),new SetNewTask()))
        ));
    }

    public static Node get(String name, Blackboard blackboard){
        Node n = prefabs.get(name);
        n.setBlackboard(blackboard);
        return n;
    }
}
