package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrintBillListener implements ActionListener {
  private Mediator mediator;
  public PrintBillListener(Mediator mediator) {
    this.mediator = mediator;
  }
  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    mediator.printBill();
  }
}