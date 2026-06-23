package cl.uchile.dcc.citric
package model.panels.factories

import model.panels.kinds.EncounterPanel
import utils.factories.AutoIncrementingFactory

class EncounterPanelFactory extends AutoIncrementingFactory[EncounterPanel](0)  {
  override def create(): EncounterPanel = new EncounterPanel(next)
}
