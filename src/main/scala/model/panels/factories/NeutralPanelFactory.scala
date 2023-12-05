package cl.uchile.dcc.citric
package model.panels.factories

import model.factories.Factory
import model.panels.kinds.NeutralPanel

class NeutralPanelFactory extends Factory[NeutralPanel] {
  override def create(): NeutralPanel = new NeutralPanel()
}
