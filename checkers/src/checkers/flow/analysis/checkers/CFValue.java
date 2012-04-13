package checkers.flow.analysis.checkers;

import java.util.Set;

import javax.lang.model.element.AnnotationMirror;

/**
 * The default abstract value used in the Checker Framework.
 * 
 * @author Stefan Heule
 * 
 */
public class CFValue extends CFAbstractValue<CFValue> {

    public CFValue(CFAbstractAnalysis<CFValue, ?, ?> analysis,
            Set<AnnotationMirror> annotations) {
        super(analysis, annotations);
    }

}
