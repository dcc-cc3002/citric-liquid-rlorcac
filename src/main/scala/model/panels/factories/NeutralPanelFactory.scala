package cl.uchile.dcc.citric
package model.panels.factories

import model.panels.kinds.NeutralPanel
import utils.factories.AutoIncrementingFactory

class NeutralPanelFactory extends AutoIncrementingFactory[NeutralPanel](0){
  override def create(): NeutralPanel = new NeutralPanel(next)
}
