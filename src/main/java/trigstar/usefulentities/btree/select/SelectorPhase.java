package trigstar.usefulentities.btree.select;

import net.minecraft.util.Tuple;
import trigstar.usefulentities.btree.Blackboard;
import trigstar.usefulentities.btree.BranchNode;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

import java.util.HashMap;

public class SelectorPhase extends Node {
    HashMap<String, Node> nodeMap;

    public SelectorPhase(Tuple<String, Node>... nodes) {
        nodeMap = new HashMap<>();
        for (Tuple<String, Node> t : nodes) {
            this.nodeMap.put(t.getFirst(), t.getSecond());
        }
    }

    @Override
    public void setBlackboard(Blackboard blackboard) {
        super.setBlackboard(blackboard);
        for (Node n: nodeMap.values()) {
            n.setBlackboard(blackboard);
        }
    }

    @Override
    public Result update() {
        return nodeMap.get(blackboard.phase).update();
    }
}
