package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TableListener implements ActionListener {
  JButton table;
  Mediator mediator;
  int saleId;
  boolean hasASale = false;

  public TableListener(JButton table, Mediator mediator) {
    this.table = table;
    this.mediator = mediator;
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    mediator.setSelectedTable(table);
    System.out.println("selected table " + table.getLabel());
  }

  public void setSaleId(int saleId) {
    this.saleId = saleId;
    hasASale = true;
  }

  public int getSaleId() {
    return saleId;
  }

  public boolean hasASale() {
    return hasASale;
  }
}
