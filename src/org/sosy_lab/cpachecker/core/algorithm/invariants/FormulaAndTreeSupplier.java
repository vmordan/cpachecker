/*
 *  CPAchecker is a tool for configurable software verification.
 *  This file is part of CPAchecker.
 *
 *  Copyright (C) 2007-2016  Dirk Beyer
 *  All rights reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *
 *  CPAchecker web page:
 *    http://cpachecker.sosy-lab.org
 */
package org.sosy_lab.cpachecker.core.algorithm.invariants;

import org.sosy_lab.cpachecker.cfa.model.CFANode;
import org.sosy_lab.cpachecker.util.expressions.ExpressionTree;
import org.sosy_lab.cpachecker.util.predicates.pathformula.PathFormula;
import org.sosy_lab.cpachecker.util.predicates.pathformula.PathFormulaManager;
import org.sosy_lab.cpachecker.util.predicates.smt.FormulaManagerView;
import org.sosy_lab.solver.api.BooleanFormula;

class FormulaAndTreeSupplier implements InvariantSupplier, ExpressionTreeSupplier {

  private final InvariantSupplier invariantSupplier;

  private final ExpressionTreeSupplier expressionTreeSupplier;

  public FormulaAndTreeSupplier(InvariantSupplier pInvariantSupplier, ExpressionTreeSupplier pExpressionTreeSupplier) {
    this.invariantSupplier = pInvariantSupplier;
    this.expressionTreeSupplier = pExpressionTreeSupplier;
  }

  @Override
  public ExpressionTree<Object> getInvariantFor(CFANode pNode) {
    return expressionTreeSupplier.getInvariantFor(pNode);
  }

  @Override
  public BooleanFormula getInvariantFor(
      CFANode pNode, FormulaManagerView pFmgr, PathFormulaManager pPfmgr, PathFormula pContext) {
    return invariantSupplier.getInvariantFor(pNode, pFmgr, pPfmgr, pContext);
  }

}