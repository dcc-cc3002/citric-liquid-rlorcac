package cl.uchile.dcc.citric
package model.panels.factories

import model.factories.Factory
import model.panels.Panel
import model.panels.kinds.EncounterPanel

class EncounterPanelFactory extends Factory[Panel] {
  override def create(): Panel = new EncounterPanel()
}
