package edu.kit.sdq.dsis.metamodel.unified.design;
import unified.UnifiedSystemModel;
import org.eclipse.emf.ecore.EObject;

/**
 * The services class used by VSM.
 */
public class Services {
    
    /**
    * See http://help.eclipse.org/neon/index.jsp?topic=%2Forg.eclipse.sirius.doc%2Fdoc%2Findex.html&cp=24 for documentation on how to write service methods.
    */
    public EObject myService(EObject self, String arg) {
       // TODO Auto-generated code
      return self;
    }

    
    public void exportMetrics(UnifiedSystemModel model) {
        edu.kit.sdq.dsis.unified.design.actions.ExportDetailedMetricsAction action = 
            new edu.kit.sdq.dsis.unified.design.actions.ExportDetailedMetricsAction();
        action.exportMetrics(model);
    }
    
    public void exportFMEA(UnifiedSystemModel model) {
        edu.kit.sdq.dsis.unified.design.actions.ExportFMEAAction action = 
            new edu.kit.sdq.dsis.unified.design.actions.ExportFMEAAction();
        action.exportFMEA(model);
    }
    
    public void analyzeHazards(UnifiedSystemModel model) {
        edu.kit.sdq.dsis.unified.design.actions.HazardAnalysisAction action = 
            new edu.kit.sdq.dsis.unified.design.actions.HazardAnalysisAction();
        action.analyzeHazards(model);
    }
}