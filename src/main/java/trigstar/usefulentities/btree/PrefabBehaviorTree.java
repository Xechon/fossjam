package trigstar.usefulentities.btree;

import net.minecraft.init.Blocks;
import net.minecraft.util.Tuple;
import trigstar.usefulentities.btree.deco.DecoratorDelay;
import trigstar.usefulentities.btree.leaf.*;
import trigstar.usefulentities.btree.select.SelectorPhase;
import trigstar.usefulentities.btree.seq.SequenceUntilFail;

import java.util.HashMap;

public class PrefabBehaviorTree {
    static HashMap<String, Node> prefabs;

    private PrefabBehaviorTree(){
        prefabs = new HashMap<>();
        prefabs.put("Harvest", new DecoratorDelay(10,
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
                                        new PickupItemEntity(),
                                        new PlaceBlock(Blocks.WHEAT),
                                        new SetPhase("FIND"))
                        ))
                )
        );

        prefabs.put("Sow", new DecoratorDelay(10,
                new SelectorPhase(new Tuple<>("FIND",
                        new SequenceUntilFail(
                                new FindBlock(Blocks.FARMLAND),
                                new MoveTo(),
                                new SetPhase("SOW")
                        )),new Tuple<>("SOW",
                        new SequenceUntilFail(
                                new PlaceBlock(Blocks.WHEAT),
                                new SetPhase("FIND")
                        ))
                )
        ));

        prefabs.put("Plow", new DecoratorDelay(10,
                new SelectorPhase(new Tuple<>("FIND",
                        new SequenceUntilFail(
                                new FindBlock(Blocks.DIRT),
                                new MoveTo(),
                                new SetPhase("PLOW")
                        )), new Tuple<>("PLOW",
                        new SequenceUntilFail(
                                new PlaceBlock(Blocks.FARMLAND),
                                new SetPhase("FIND")
                        ))
                )
        ));
    }

    public static Node get(String name, Blackboard blackboard){
        Node n = prefabs.get(name);
        n.setBlackboard(blackboard);
        return n;
    }
}
