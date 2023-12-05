package cl.uchile.dcc.citric
package model.panels.factories

import model.factories.Factory
import model.panels.Panel
import model.panels.kinds.EncounterPanel

class EncounterPanelFactory extends Factory[EncounterPanel] {
  override def create(): EncounterPanel = new EncounterPanel()
}
