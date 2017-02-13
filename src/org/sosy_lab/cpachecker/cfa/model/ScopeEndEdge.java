/*
 * CPAchecker is a tool for configurable software verification.
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
package org.sosy_lab.cpachecker.cfa.model;

import com.google.common.base.Optional;

import org.sosy_lab.cpachecker.cfa.ast.ADeclaration;
import org.sosy_lab.cpachecker.cfa.ast.ASimpleDeclaration;
import org.sosy_lab.cpachecker.cfa.ast.FileLocation;

import java.util.Map;


public class ScopeEndEdge extends AbstractCFAEdge {

  protected final Map<String, ? extends ASimpleDeclaration> leftForDeclarations;

  public ScopeEndEdge(final FileLocation pFileLocation,
                         final CFANode pPredecessor, final CFANode pSuccessor,
                         final Map<String, ? extends ASimpleDeclaration> pLeftForDeclarations) {

    super("", pFileLocation, pPredecessor, pSuccessor);
    leftForDeclarations = pLeftForDeclarations;
  }

  @Override
  public CFAEdgeType getEdgeType() {
    return CFAEdgeType.ScopeEndEdge;
  }

  public Map<String, ? extends ASimpleDeclaration> getLeftForDeclarations() {
    return leftForDeclarations;
  }

  @Override
  public String getDescription() {
    return String.format("Scope End for %d variable(s)", leftForDeclarations.size());
  }

  @Override
  public Optional<? extends ADeclaration> getRawAST() {
    return Optional.absent();
  }

  @Override
  public String getCode() {
    return "";
  }

  @Override
  public String toString() {
    return "Scope End";
  }
}