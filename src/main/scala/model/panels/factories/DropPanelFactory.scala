package cl.uchile.dcc.citric
package model.panels.factories

import model.panels.kinds.DropPanel
import utils.factories.AutoIncrementingFactory

class DropPanelFactory extends AutoIncrementingFactory[DropPanel](0) {
  override def create(): DropPanel = new DropPanel(next)
}
