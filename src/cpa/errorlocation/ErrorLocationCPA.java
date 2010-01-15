package cpa.errorlocation;

import cfa.objectmodel.CFAFunctionDefinitionNode;
import cpa.common.defaults.AbstractCPA;
import cpa.common.interfaces.AbstractElement;
import cpa.common.interfaces.TransferRelation;

public class ErrorLocationCPA extends AbstractCPA {

  private static enum ErrorLocationElement implements AbstractElement {
    
    NORMAL(false),
    ERROR(true),
    TOP(true),
    BOTTOM(false);
    
    private final boolean isError;
    
    private ErrorLocationElement(boolean isError) {
      this.isError = isError;
    }
    
    @Override
    public String toString() {
      return "<" + super.toString() + ">";
    }
    
    @Override
    public boolean isError() {
      return isError;
    }
  }

  private static final TransferRelation transferRelation = new ErrorLocationTransferRelation(ErrorLocationElement.ERROR);
  
  public ErrorLocationCPA(String mergeType, String stopType) {
    super("sep", "sep", transferRelation);
  }

  @Override
  public AbstractElement getInitialElement(CFAFunctionDefinitionNode node) {
    return ErrorLocationElement.NORMAL;
  }
}