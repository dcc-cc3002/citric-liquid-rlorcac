package cl.uchile.dcc.citric
package model.panels.factories

import model.factories.Factory
import model.panels.Panel
import model.panels.kinds.DropPanel

class DropPanelFactory extends Factory[DropPanel]{
  override def create(): DropPanel = new DropPanel()
}
