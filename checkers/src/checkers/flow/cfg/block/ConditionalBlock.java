package checkers.flow.cfg.block;

import checkers.flow.cfg.node.Node;

/**
 * Represents a conditional basic block that contains exactly one boolean
 * {@link Node}.
 * 
 * @author Stefan Heule
 * 
 */
public interface ConditionalBlock extends Block {

	/**
	 * Return the condition of this conditional basic block. The following
	 * invariant holds.
	 * 
	 * <pre>
	 * getCondition().getBlock() == this
	 * </pre>
	 * 
	 * @return The condition of this conditional basic block.
	 */
	Node getCondition();

	/**
	 * @return The entry block of the then branch.
	 */
	Block getThenSuccessor();

	/**
	 * @return The entry block of the else branch.
	 */
	Block getElseSuccessor();

}
