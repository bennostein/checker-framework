package checkers.flow.cfg.node;

import java.util.Collection;
import java.util.Collections;

import javax.lang.model.type.TypeMirror;

import checkers.flow.util.HashCodeUtils;
import checkers.util.TypesUtils;

import com.sun.source.tree.Tree;
import com.sun.source.tree.Tree.Kind;

/**
 * A node for the widening primitive conversion operation. See JLS 5.1.2 for the
 * definition of widening primitive conversion.
 * 
 * A {@link WideningConversionNode} does not correspond to any tree node in the
 * parsed AST. It is introduced when a value of some primitive type appears in a
 * context that requires a different primitive with more bits of precision.
 * 
 * @author Stefan Heule
 * @author Charlie Garrett
 * 
 */
public class WideningConversionNode extends Node {

    protected Tree tree;
    protected Node operand;

    public WideningConversionNode(Tree tree, Node operand, TypeMirror type) {
        assert TypesUtils.isPrimitive(type) : "non-primitive type in widening conversion";
        this.tree = tree;
        this.operand = operand;
        this.type = type;
    }

    public Node getOperand() {
        return operand;
    }

    public TypeMirror getType() {
        return type;
    }

    @Override
    public Tree getTree() {
        return tree;
    }

    @Override
    public <R, P> R accept(NodeVisitor<R, P> visitor, P p) {
        return visitor.visitWideningConversion(this, p);
    }

    @Override
    public String toString() {
        return "WideningConversion(" + getOperand() + ", " + type + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof WideningConversionNode)) {
            return false;
        }
        WideningConversionNode other = (WideningConversionNode) obj;
        return getOperand().equals(other.getOperand())
                && TypesUtils.areSamePrimitiveTypes(getType(), other.getType());
    }

    @Override
    public int hashCode() {
        return HashCodeUtils.hash(getOperand());
    }

    @Override
    public Collection<Node> getOperands() {
        return Collections.singletonList(getOperand());
    }
}
