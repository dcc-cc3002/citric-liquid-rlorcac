package cl.uchile.dcc.citric
package model.panels.factories

import model.factories.Factory
import model.panels.Panel
import model.panels.kinds.BonusPanel

class BonusPanelFactory extends Factory[BonusPanel]{
  override def create(): BonusPanel = new BonusPanel()
}
