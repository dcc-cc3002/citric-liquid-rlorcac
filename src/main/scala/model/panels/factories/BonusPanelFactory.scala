package cl.uchile.dcc.citric
package model.panels.factories

import model.panels.kinds.BonusPanel
import utils.factories.AutoIncrementingFactory

class BonusPanelFactory extends AutoIncrementingFactory[BonusPanel](0) {
  override def create(): BonusPanel = new BonusPanel(next)
}
