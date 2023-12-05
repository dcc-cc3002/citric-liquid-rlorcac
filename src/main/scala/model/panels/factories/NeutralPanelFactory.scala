package cl.uchile.dcc.citric
package model.panels.factories

import model.factories.Factory
import model.panels.Panel
import model.panels.kinds.NeutralPanel

class NeutralPanelFactory extends Factory[Panel] {
  override def create(): Panel = new NeutralPanel()
}
